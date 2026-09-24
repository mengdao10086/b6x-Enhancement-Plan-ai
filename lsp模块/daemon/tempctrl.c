// ================================================================
// tempctrl.c — 飞智 WaspWing 散热器智能温控守护程序
// ================================================================
//
// 运行环境：root 常驻守护进程，由 APK 部署的 service.d 脚本拉起并守护
// App 进程检测：直读 /proc/<pid>/cmdline 精确比对包名
// 控制指令：am broadcast → LSPosed 模块 → WaspWingManager.setRunMode
//
// 温度单位：整型 0.1°C（电池原生单位，CPU m°C ÷ 100）
//   例：350 = 35.0°C, 753 = 75.3°C
//
// 编译：参数与工具链约束见同目录 build_tempctrl.sh（唯一来源，勿在此复制命令行）
//
// ================================================================

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <signal.h>
#include <time.h>
#include <stdarg.h>
#include <sys/stat.h>
#include <sys/file.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <dirent.h>
#include <limits.h>
#include <math.h>

// C 端键表与 clamp 边界的唯一手写处是 参数定义/params.def.json，本头由 gen_params.py 生成。
// 本文件只取宏：CFG_PERF_INT_KEYS / CFG_SYSFS_KEYS 的展开点必须在下方 struct 与所有被取地址的
// static 变量声明之后（见 params_generated.h 头部说明）。
#include "params_generated.h"

// --- 通用宏 ---
#define EMA(new_val, old_val, alpha_pct) \
    (((new_val) * (alpha_pct) + (old_val) * (100 - (alpha_pct))) / 100)

/** 带方向取整的 EMA：平滑值向原始值方向取整，解决渐进无法到达的问题
 *  上升（_nv>_ov）：向上取整 → 向新值方向
 *  下降（_nv<_ov）：_num/100 截断已是向下取整（向新值方向），无需再调整
 */
#define EMA_DIR(new_val, old_val, alpha_pct) \
    ({ \
        int _nv = (new_val); \
        int _ov = (old_val); \
        int _num = (_nv) * (alpha_pct) + (_ov) * (100 - (alpha_pct)); \
        int _r = _num / 100; \
        if (_nv > _ov && _num % 100 > 0) _r++; \
        _r; \
    })

// ======================== 运行模式与参数映射 ========================
//
// ⚠️ 不推荐智能温控模式（mode=0）：实测其风扇转速配置疑似非强制生效，常突破上限（尤在刚切换的瞬间），噪音突然变大体验差。本实现固定下发 mode=1（固定功率），规避此问题。
//
//setRunMode(mode, targetTemperature,windLevelOverclock, coldLevelOverclock,windLevel, modeCustom, extra)
//
// 参数映射：mode=0(智能温控)：targetTemperature, windLevel(风扇转速上限)
//          mode=1（固定功率）：windLevelOverclock(风扇固定转速), coldLevelOverclock(制冷片强度)

// ----（Gear 档位表 / init_gear_table / sort_vals / gear_label 已随 Gear 删除）----

// ======================== 常量与边界 ========================
#define COLD_MIN             1
#define COLD_MAX           194     // 制冷强度最大有效值（B6X 硬件上限），PID_COLD_RANGE/RATE_LIMIT_COLD/COLD_RPM_MAP 的 clamp 上界
// B7X 独立上限（运行时根据 active_device 选择）
#define B7X_COLD_MAX       255
#define B7X_FAN_RPM_MAX    8000

// B7X 上限（FAN_RPM_RANGE / PID_COLD_RANGE 第三值，可配置，暂时与 B6X 一致）
// B7X_COLD_MAX / B7X_FAN_RPM_MAX 宏保留为 clamp 安全上界
static int b7_pid_cold_max = 190;   // PID_COLD_RANGE 第三值（B7X），默认同 B6X
static int b7_fan_rpm_max  = 6000;  // FAN_RPM_RANGE 第三值（B7X），默认同 B6X

// ======================== 私有目录（配置/日志/曲线数据落点） ========================
// status 双文件仍留 /data/local/tmp/（与 MainHook.java 共享，原样不动）
// tempctrl_last_dev 归宿主 app 私有目录，由 MainHook 独用，daemon 不参与
// 此路径必须与 lsp模块/app/build.gradle.kts 的 applicationId 一致：
// 安装后的包名由 applicationId 决定，数据目录名即等于它，改任一处都要同步另一处
#define PRIVATE_DIR "/data/data/com.example.waspwingtempctrl/files"

/** 确保私有目录存在（守护进程以 root 运行，但目录可能尚未创建）。返回 1=可用，0=不可用
 *  只 mkdir 这一层：父目录 /data/data/<包名> 不存在时 ENOENT 直接失败，绝不逐级创建
 *  （父目录须由系统 installd 创建并打 SELinux 标签，root 抢建会坏事）
 *  新建时把属主改为父目录（=app 数据目录）的属主，与系统建 files/ 一致：
 *  否则 root 先建会使 app 自身（写配置走 Framework File API）无写权限 */
static int ensure_private_dir(void) {
    if (mkdir(PRIVATE_DIR, 0771) == 0) {
        char parent[256];
        snprintf(parent, sizeof(parent), "%s", PRIVATE_DIR);
        char *slash = strrchr(parent, '/');
        if (slash) {
            *slash = '\0';
            struct stat pst;
            if (stat(parent, &pst) == 0)
                chown(PRIVATE_DIR, pst.st_uid, pst.st_gid);   // best-effort，失败不影响 root 自身读写
        }
        return 1;
    }
    struct stat st;
    return stat(PRIVATE_DIR, &st) == 0 && S_ISDIR(st.st_mode);
}

// ======================== 系统命令路径 ========================
// 一律用绝对路径：daemon 由 service.d 拉起，环境 PATH 未必含 /system/bin；
// 裸命令名会静默失败（system() 只返回非零，execlp 子进程 _exit(127)）。
// 路径不含空格/元字符，与后续参数用空格分隔拼进同一 shell 词即可，无需引号。
#define AM_BIN      "/system/bin/am"
#define PM_BIN      "/system/bin/pm"
#define DUMPSYS_BIN "/system/bin/dumpsys"

// ======================== 系统路径与缩放 ========================
// --- sysfs 路径配置（可由 profile.conf 覆盖）---
static char BATT_TEMP_PATH[128] = "/sys/class/power_supply/battery/temp";
static char CPU_TEMP_PATH_FMT[128] = "/sys/class/thermal/thermal_zone%d/temp";
static char BATT_CURRENT_PATH[128] = "/sys/class/power_supply/battery/current_now";

// --- sysfs 缩放系数（原始值 ÷ 缩放系数 = 内部单位 0.1°C）---
static int BATT_TEMP_DIVISOR = 1;     // 电池温度原始值 0.1°C，无需缩放
static int CPU_TEMP_DIVISOR = 100;    // CPU 温度原始值 m°C，÷100 转 0.1°C
static int BATT_CURRENT_DIVISOR = 10000;  // 电池电流原始值 µA ÷ 此值 → 0.01A

// --- CPU 温度扫描范围（可配置）---
// 首次运行在此范围内扫描有效的 thermal_zone，后续只扫命中的 zone
static int CPU_ZONE_MIN = 0;
static int CPU_ZONE_MAX = 99;
static int cpu_zone_rescan_sec = 60;   // CPU thermal_zone 全量重扫间隔（秒，CPU_ZONE_RESCAN 第一值，默认 60）
static int cpu_zone_keep = 10;         // 保留温度值个数（CPU_ZONE_RESCAN 第二值，默认 10）

// ======================== 通用参数 ========================
// --- 基准温度 ---
static int BATT_BASELINE = 350;     // 基准温度 35.0°C

// --- 控制模式：本实现仅保留 PID（Gear 已删除）---

// --- 冷端→风扇映射 ---
static int cold_map_start = 40;     // COLD_RPM_MAP 第一值=映射起始强度，低于此值时线性外推下限
static int cold_map_exp = 150;      // COLD_RPM_MAP 第二值=n^exp（÷100，150=1.50），>1 低冷慢转
// MAP_INPUT_SMOOTH_ALPHA：冷/热端映射输入（制冷强度/热端温度）共用的 EMA 平滑系数（%，1~99）
static int rpm_smooth_alpha = 33;

// --- 热端映射范围 ---
static int hot_map_min = 350;       // HOT_RPM_MAP 第一值（0.1°C）
static int hot_map_max = 450;       // HOT_RPM_MAP 第二值（0.1°C）

// --- 风扇转速范围 ---
static int fan_rpm_min = 2000;      // FAN_RPM_RANGE 第一值
static int fan_rpm_max = 6000;      // FAN_RPM_RANGE 第二值
static int fan_rpm_round_unit = 10; // FAN_RPM_ROUND_UNIT：下发转速前按该单位就近取整（RPM，1~500）

// ======================== 速率限制 ========================
// --- 固定值 ---
static int RATE_LIMIT_FAN = 250;   // RATE_LIMIT_FAN 第一值：风扇每周期最大变化量（RPM，升/降共用，双值键）
static int RATE_LIMIT_COLD = 25;   // 制冷强度升降速基础值：升速=base+dev×mult/10，降速=base-dev×mult/10，负值→0=禁止该方向

// --- 动态值（根据电池温差自动调整）---
static int RATE_LIMIT_COLD_MULT = 10;  // 制冷强度倍率：升速/降速 = base ± dev(0.1°C) × mult / 10
static int COLD_DEADZONE = 3;          // 制冷最小变化幅度（RATE_LIMIT_COLD 第三值）：与散热器实际 |差值| < 该值时不升不降
static int RATE_LIMIT_FAN_DEBOUNCE = 50;   // RATE_LIMIT_FAN 第二值：防抖阈值（RPM/周期，0=关闭防抖）；变化量 ≤ 阈值且距方向端点（升=最高/降=最低）≥ 阈值×1.5 时保持不动
static int cycle_batt_temp = -1;       // 本周期电池温度（-1=未就绪）
// --- 1s 采集缓存：5s 控制块直接读缓存，不再重复读 sysfs/状态文件 ---
static int cached_batt_raw = -1;   // 电池温度（0.1°C），保留上次成功值抗抖
static int cached_cpu_now  = -1;   // CPU 最高温度（0.1°C），保留上次成功值抗抖

// ======================== 实际值 ========================
// 始终向目标档位的表格值靠拢，每周期最多变动速率限制的量
static int actual_rpm = -1;            // 当前实际风扇转速（RPM）
static int actual_cold = -1;           // 当前实际制冷片强度

// ======================== 控制周期计数器 ========================
static int pid_ctrl_cycles = 0;               // PID 控制周期单调计数器（pid_cycle 每次 +1）
static int reconnect_keep_cycles = 3;         // RECONNECT_KEEP_CYCLES：断联< N 控制周期(×5s) 不重置 PID 状态

// ======================== CPU 温度滤波 ========================
static int CPU_FILTER_ALPHA = 25;   // CPU 滤波系数（%）
static int cpu_filtered_temp = 250; // 加权 CPU 温度，初始 25.0°C
static int first_run = 1;           // 首次运行，滤波直接赋初值

// ======================== 日志与调试 ========================
// --- 日志路径（默认根据二进制名自动生成，可由 profile.conf 覆盖）---
static char log_file_path[256] = "";
static int LOG_MAX = 16256;          // 日志文件大小上限（字节），0=关闭日志
static FILE *log_fp = NULL;          // 持久的日志文件指针
static char log_path_opened[256] = ""; // 已打开的文件路径（检测路径变化）
static int debug_mode = 0;           // 调试日志总开关，=1 时启用各分区调试输出
static int debug_sensor = 0;    // [传感器] 电池/CPU 读数
static int debug_exec   = 0;    // [执行下发] 速率限制/am broadcast + 风扇转速
static int debug_conn   = 0;    // [连接状态] App 存活/BLE/重连对齐
static int debug_config = 0;    // [配置加载] 配置文件解析过程
static int debug_main   = 0;    // [主循环] main_loop 流程跟踪
static int debug_pid    = 0;    // [PID] PID 控制调试
static int debug_launch = 0;    // [自动拉起] 目标选择/回退/跳过（结果成功/失败为普通日志，不归此分区）

// ======================== 配置文件系统 ========================
// 配置文件路径（自动检测或 --config 指定）
static char config_path[256] = "";
// 配置文件的最后修改时间（用于热重载检测）
static time_t config_mtime = 0;

// ======================== PID 控制（单累积器） ========================
// --- 配置变量（按 profile.conf 键顺序排列）---

// PID_KDP：KDP 融合 P+D 项系数（÷1000，kdp = kdp_coef×ch_kdp）
static int pid_kdp_coef = 300;
// PID_KI_RATE 第一值：积分升速率（÷1000，被积项 ch−target_f > 0 时用；acc 不乘 dt）
static int pid_ki_up_coef = 20;
// PID_KI_RATE 第二值：积分降速率（÷1000，被积项 < 0 时用；默认 30，可独立调）
static int pid_ki_down_coef = 30;
// PID_SPEED：速度项倍率系数（÷10，100=速度×10，0=关闭；ch = error + v×speed_coef/10 + cpu_comp）
static int pid_speed_coef = 100;
// PID_SPEED_NL_THR：速度非线性阈值 L（÷100，单位 °C/周期；|v| ≥ L 严格恒等，|v| < L 按幂曲线降权）
static int pid_spd_nl_thr_p100 = 20;
// PID_SPEED_NL_EXP：速度非线性强度 q（÷100；0 = 完全线性）
static int pid_spd_nl_exp_p100 = 100;
// PID_TARGET 第一值：动态目标系数（÷1000，raw_target = clamp(error×target_coef, ±上限)）
static int pid_target_coef = 20;
// PID_TARGET 第二值：目标 EMA 平滑系数（%，滤波系数）
static int pid_target_alpha = 10;
// PID_TARGET 第三值：动态目标上限（0.1°C，默认 15=1.5°C）
static int pid_target_max = 15;
// PID_TARGET_DIR：动态目标方向性 EMA（远离基线加快->away alpha，回归基线减慢->toward alpha）
static int pid_target_dir_on = 1;                 // 第一值：方向性滤波开关（0=退回 PID_TARGET 第2值单 alpha）
static int pid_target_away_alpha = 20;            // 第二值：远离基线 alpha（%，20=0.2）
static int pid_target_toward_alpha = 10;          // 第三值：回归基线 alpha（%，10=0.1）
// PID_CH_THRESHOLD：跳过重算的 ch 阈值（0.1°C，|last_ch|≤此值 → 整轮冻结）
static int pid_ch_threshold = 2;

// PID_CPU_COMP：CPU 补偿（始终生效，无开关）
static int pid_cpu_comp_filter_alpha = 25;      // PID_CPU_COMP 第一值：补偿 EMA 平滑系数（%）
static int pid_cpu_comp_divisor = 30;           // PID_CPU_COMP 第二值：除数
static int pid_cpu_comp_offset = 100;           // PID_CPU_COMP 第三值：偏移量（0.1°C，100=10.0°C）

// PID_COLD_RANGE：输出范围
static int pid_cold_min = 1;              // PID_COLD_RANGE 第一值：制冷强度下限
static int pid_cold_max = 190;            // PID_COLD_RANGE 第二值：制冷强度上限（B6X）

// --- 逻辑2「冷值动态倍率」参数（配置值为整数；冷值三点零换算，其余 ×100 换算进内部）---
// PID_COLD_DYN_IN  = 输入轴 下界 拐点 上界（冷值，零换算；默认 40 100 190）
// PID_COLD_DYN_OUT = 输出轴拐点值（正数 ×100；默认 50 → 抽象值 −0.50，两端固定 0 与 −1）
// PID_COLD_DYN_W   = KDP / KI升 / KI降 三作用点权重（各自 ×100；默认 100 100 100 = 1.00）
// PID_COLD_DYN_MAP = 倍率上界 U / 形状指数 γ（各自 ×100；默认 200 100 = 2.00 / 1.00）
static int cold_dyn_in_lo = 40;           // 输入轴下界（冷值；≤ 此处不干预）
static int cold_dyn_in_mid = 100;         // 输入轴拐点（冷值；过此点转第二段）
static int cold_dyn_in_hi = 190;          // 输入轴上界（冷值；≥ 此处最大降幅）
static int cold_dyn_out_mid_p100 = 50;    // 输出轴拐点值（正数 ×100；C 内取负成抽象值）
static int cold_dyn_w_kdp_p100 = 100;     // KDP 作用点权重（×100；0 = 该处不受影响）
static int cold_dyn_w_up_p100  = 100;     // KI 升速率作用点权重（×100）
static int cold_dyn_w_dn_p100  = 100;     // KI 降速率作用点权重（×100）
static int cold_dyn_u_p100     = 200;     // 倍率上界 U（×100）；下界自动 = 1/U
static int cold_dyn_gamma_p100 = 100;     // 形状指数 γ（×100）

// --- PID 运行时状态（单累积器）---
static float pid_ki = 0.0f;               // 积分累积值（acc；float：限幅赋小数需保留）
static float pid_kdp = 0.0f;              // 融合 P+D 项（kdp = kdp_coef×ch_kdp；无记忆，跳过①用 last 值）
static float pid_target_f = 0.0f;         // EMA 动态目标
static float pid_last_error = 0.0f;       // 上周期纯电池误差（°C，v 计算用）
static float pid_last_ch = 0.0f;          // 上周期 ch（|ch|≤阈值 → 整轮冻结判据）
static time_t pid_last_change_time = 0;   // 上次重算时间戳（dt 锚点）
// --- 无变化回溯（PID_SPEED_RECALL）：锚点温度 + 累计周期数 → 重算速度 ---
static int recall_anchor = 0;             // 最近一次温度变化前的温度（0.1°C）
static int recall_prev_batt = 0;          // 上个控制周期的电池温度（0.1°C）
static int recall_cycles = 0;             // 距该次变化的控制周期数（>0 才有效）
static int pid_spd_recall_on = 1;         // PID_SPEED_RECALL 第一值：开关
static int pid_spd_recall_weight = 1000;  // PID_SPEED_RECALL 第二值：回溯速度权重（÷1000，1000=全量）

// --- CPU 补偿运行状态 ---
static int pid_cpu_comp_ready = 0;          // 补偿平滑是否已初始化（首次上次值用 0，从 0 爬升）
static float pid_cpu_comp_smooth = 0.0f;    // CPU 补偿 EMA 平滑值（°C）
static int pid_last_comp_10 = 0;            // 上次 PID 重算时的补偿值（0.1°C）
static int pid_cpu_comp_active = 0;         // 补偿门控：1=激活（进入后即使条件消失也保持到滤波归零才退出）

// --- 电池温度输入滤波（改动2：加回；仅温度更新时滤波，动态 α，停机后恢复原始值）---
static int pid_batt_filtered = -1;        // 滤波后电池温度（0.1°C），-1=未初始化
static int pid_batt_last_update_cycle = -1; // 上次温度更新的控制周期（动态α间隔计算用）
static int pid_batt_snap_done = 0;        // 停机后是否已做一次"恢复原始值"snap（1=已做）

// ----（Gear 温度预测 / gear_predict_* / gear_input_batt 已随 Gear 删除）----
// --- 输出映射与对齐 ---
static int pid_align_rpm = 2000;          // PID 目标 RPM（仅初始化对齐与日志使用；风扇下发已由 compute_fan_target 独立计算）
static int pid_align_cold = 1;            // PID 目标制冷强度

// --- 逻辑2「冷值动态倍率」运行状态（复位值 = 不干预：抽象值 0、三倍率 1.0）---
static float cold_dyn_s         = 0.0f;   // 抽象值 s ∈ [−1,0]（未加权；0 = 不干预）
static float cold_dyn_mult_kdp  = 1.0f;   // KDP 作用点最终倍率（∈ [1/U, 1]）
static float cold_dyn_mult_up   = 1.0f;   // KI 升速率作用点最终倍率
static float cold_dyn_mult_dn   = 1.0f;   // KI 降速率作用点最终倍率

// ======================== 散热器回传参数 ========================
static int cooler_hot_temp = -1;          // 热端温度（0.1°C）
static int cooler_cold_temp = -1;         // 冷端温度（0.1°C）
static int cooler_rpm_real = -1;          // 实际风扇转速
static int cooler_cold_real = -1;         // 实际制冷强度

// --- 回传可信就绪 + 启动/重连对齐（不拿 -1/占位1 兜底，等真实回传再定基线）---
// LSP 端 COLD_REAL/RPM_REAL 只在 lastWaspWingInfo 就绪时随 RUN_MODE 一起写入；重启/重连瞬间
// lastWaspWingInfo 为空 → 这些行缺失（读到 -1）或设备未下发前回占位 1。若此时拿它初始化
// actual_cold 会被兜底成 1（WebUI 显示 1），且后续快速限速一步拉到 PID 目标（125/4500）。
// 因此启动/长断连重置后不直接采用瞬时回传，改为等待 REPORT_OK_N 帧连续真实回传（RUN_MODE
// 存在 + 冷/rpm 值合法）再对齐，超时用保守值起步防停摆。
#define REPORT_OK_N 2                      // 连续 N 帧读到真实回传才判可信（1 帧=1s）
#define ALIGN_WAIT_TIMEOUT 15              // 等待真实回传上限（秒），超时用保守值起步防永久停摆
static int report_ok = 0;                  // 1=已连续 REPORT_OK_N 帧读到真实回传（RUN_MODE 存在 + 冷/rpm 值合法）
static int report_ok_streak = 0;           // 连续"真实回传"读数
static int pending_align = 0;              // 1=等待真实回传后对齐 actual_cold/actual_rpm
static time_t pending_align_since = 0;     // pending_align 起点（超时兜底用）

// ======================== 全局运行状态 ========================
// --- 信号 ---
static volatile int running = 1;

// --- 电池温度数值追踪（Scene 式：定时轮询 + 值比较，mtime 变化作为补充刷新信号）---
static int batt_cached_temp = -1;        // 最后一次读取的温度缓存
static int batt_temp_updated = 0;        // 最近一次 1s 采集：值或 mtime 任一变化即置位（供采样 push 判定）
static time_t batt_temp_mtime = 0;       // 温度文件上次 mtime（mtime 更新视为温度数据刷新；不可靠内核恒不变则退化为纯值比较）
static int batt_changed_since_ctrl = 0;  // 自上次 5s 控制以来，1s 层是否检测到过温度变化（累积）
static int batt_window_changed = 0;      // 当前控制周期快照（main_loop 入口设置，供跳过判定）

// --- 连接状态 ---
static int STATUS_TIMEOUT = 3;   // LSP 每 1 秒写一次 status，mtime 超 3s 判死
static int app_was_alive = 0;
// 双 status 文件路径（B6X 文件 BLE=0/1/2=owner，B7X 文件 BLE=0/6/7=型号）
static char status_file_path_b6[512] = "/data/local/tmp/tempctrl_b6x.status";
static char status_file_path_b7[512] = "/data/local/tmp/tempctrl_b7x.status";

// status 文件协议：行格式「字段名=值」，由 LSP 侧写入、本进程只读。
// 协议的唯一规范处是 lsp模块/README.md（改了这里必须同步改 LSP 侧与那份说明）。
// 字段名集中在此声明：字段名、比较长度、取值偏移三者由一处推导，
// 避免改名字却漏改长度/偏移（原先三处各自硬编码，是同一缺陷的三个面）。
#define STF_BLE            "BLE="
#define STF_CONNECTED_AT   "CONNECTED_AT="
#define STF_BLE_OWNER_LAST "BLE_OWNER_LAST="
#define STF_HOT_TEMP       "HOT_TEMP="
#define STF_COLD_TEMP      "COLD_TEMP="
#define STF_RUN_MODE       "RUN_MODE="
#define STF_RPM_REAL       "RPM_REAL="
#define STF_COLD_REAL      "COLD_REAL="

/** 行首若为该字段名，返回值的起点指针；否则返回 NULL。长度直接取自字段名本身。 */
static const char *status_field_value(const char *line, const char *field) {
    size_t n = strlen(field);
    return strncmp(line, field, n) == 0 ? line + n : NULL;
}

// WebUI 曲线数据文件（每 1 秒一行，滚动保留最大曲线窗口秒数）
#define WEBUI_DATA_PATH       PRIVATE_DIR "/tempctrl_webui.data"
#define WEBUI_DATA_MAX_LINES  720   // = 曲线最大时间挡位（秒）

// 曲线行格式：列数唯一声明（CI 断言可 grep 本行数 % 个数，须等于 WEBUI_DATA_COLS）
// 列序：epoch, 电池, CPU, 热端, 冷端, 实际转速, 实际制冷, 目标制冷（0.1°C，未就绪为 -1）
#define WEBUI_DATA_COLS       8
#define WEBUI_ROW_FMT         "%ld,%d,%d,%d,%d,%d,%d,%d\n"

// 三方 app 包名（farsef 在最近连 B6X 散热器时也参与仲裁）
#define APP_PKG_B6X_OLD "com.flydigi.waspwing.experimental"
#define APP_PKG_B6X_NEW "com.flydigi.waspwing.experimentanliuliu"
#define APP_PKG_B7X "com.fdg.flashplay.farsef"

#define ARBITRATE_INTERVAL 15   // app 存活仲裁间隔（秒）：合并扫描后仍较低频，兼顾拉起/清理响应

// 自动拉起散热器 app（优先上次使用的 app）
static int APP_LAUNCH_ENABLED = 0;      // 总开关：1=允许自动拉起，0=关闭（默认关，刷入时可选开）
// 锁死自动重启（watchdog）：每次实际下发制冷变化时判定——实际停滞（=上周期实际）且≠上周期下发持续 N 次 → kill app 并重新拉起
static int app_watchdog_cycles = 6;     // APP_WATCHDOG：连续停滞次数（0=关闭，默认 6）
static int watchdog_stall_count = 0;    // 当前连续停滞次数（按实际下发周期计数）
static int watchdog_last_cold = -1;     // 上周期实际制冷值（停滞判定基准）
static int watchdog_last_cmd  = -1;     // 上周期下发制冷值（未达目标判定基准）
static long watchdog_last_kill_at = 0;  // 上次 kill 时间戳（冷却防风暴）
static time_t last_launch_attempt = 0;  // 上次拉起尝试时间（冷却用）
static time_t last_arbitrate = 0;       // 上次 app 存活仲裁时间（ARBITRATE_INTERVAL 节流）
static int app_launch_cooldown = 60;    // APP_LAUNCH_COOLDOWN：两次拉起最小间隔（秒，默认 60）
static int app_launch_screen_gate_enabled = 1;  // APP_LAUNCH_SCREEN_GATE 第一值：屏幕门禁开关
static int app_launch_screen_dozing_on  = 0;    // 第二值：Dozing 是否算亮屏（默认 0）
static time_t last_probe_off_at = 0;     // 上次确认息屏（并完成屏检）的时刻：息屏退避锚点，见 APP_LAUNCH_PROBE_OFF_INTERVAL
static int last_screen_off = 0;          // 上次观察到的屏幕状态：1=息屏（含按配置算灭的 Dozing），0=亮屏/未知。初值=亮屏

// 息屏时整条探测链的最小间隔（秒，硬编码常量，不是配置键）。
// 用户拍板值 10s：屏灭时探测链注定下发不了（屏幕门禁会拦），却每轮仍要付 pm 冷启动 + 全量 /proc 扫描，
// 外加一次 is_screen_awake()（popen 一次起 sh+dumpsys+awk 三个进程，dumpsys power 的活还在 system_server
// 里干）—— 屏检本身就在整条链最贵之列，故退避必须连屏检一起节流，否则最贵的一环一次没省。
// 亮屏节奏不变（仍由调用方 5s 一轮驱动）。
// 不做成配置键：新增键要连带动 params.def.json → 生成头文件 → profile.conf → 界面，超出本次修改范围。
#define APP_LAUNCH_PROBE_OFF_INTERVAL 10

// --- 界面开关转写（UI_BACK_HIDE）---
// 界面与 Xposed 钩子分属两个进程、不共享内存：本机不消费该值，只把它写进一个双方都能访问的文件，
// 由钩子读取。这是界面 → 钩子的唯一通道（钩子 → 守护进程走 status 文件，方向相反）。
#define UIPREFS_PATH "/data/local/tmp/tempctrl_uiprefs"
static int back_hide_enabled     = 1;    // UI_BACK_HIDE：1=返回键收后台（默认），0=恢复系统默认退出
static int uiprefs_last_back_hide = -1;  // 上次已写出的值（-1 = 尚未写过，首轮必写一次）
static int uiprefs_fail_logged    = 0;   // 写失败只记一条日志，避免每轮重复刷屏

// 双设备 BLE 连接状态
static int b6_connected = 0;        // B6X: BLE 是否已连接
static int b7_connected = 0;        // B7X: BLE 是否已连接
static time_t b6_connected_at = 0;  // B6X 连接时间戳（用于仲裁"先连"）
static time_t b7_connected_at = 0;  // B7X 连接时间戳
static int app_ble_connected = 0;   // 兼容旧代码，指向当前 active_device
static int b6_owner = 0;            // B6X: BLE 连接 owner（0=无, 1=老 app, 2=新 app）

// 实际连接的设备型号（B7X 文件 BLE=6/7 编码；B6X 文件 BLE=1/2 型号未知，由路径兜底为 6）
static int b6_model = 0;            // B6X app 连接的设备型号：0=未知, 6=B6X, 7=B7X
static int b7_model = 0;            // B7X app 连接的设备型号

// BLE_OWNER_LAST 上次连接者（B6X 文件 1/2；B7X 文件 6/7；跨文件合并取时间最新者）
static int b6_last_owner = 0;
static time_t b6_last_at = 0;
static int b7_last_owner = 0;
static time_t b7_last_at = 0;
static int last_owner = 0;       // 全局最近连接者（合并后：1/2/6/7，0=无）
static time_t last_owner_at = 0; // 对应连接时间

// ----（档位模式自动风扇 gear_auto_fan / gear_config_enabled 已随 Gear 删除）----

// ======================== 双设备仲裁 ========================
typedef enum { DEVICE_NONE = 0, DEVICE_B6X, DEVICE_B7X } DeviceType;
static DeviceType active_device = DEVICE_NONE;      // 当前控制的设备

// 运行时动态限制（根据 active_device 设置）
static int active_fan_max  = 6000;          // 当前设备风扇上限
static int active_pid_cold_max = 190;       // 当前设备 PID 制冷上限

// ======================== 热端过温制冷削减 ========================
// 热端温度 > 阈值 → 削低制冷上限 (热端-阈值)×倍率：首次削减把生效上限压到「当前实际制冷值 − 削减量」，
//   之后每次触发在当前生效上限上继续累减（不回看历史触发值），削减后 5 周期内不再削减；
// 热端温度 ≤ 阈值 → 生效上限每次 +5（复用倍率值）逐级上爬，封顶配置上限，恢复后 5 周期内不再恢复；
// 削减与恢复的冷却独立（不共用）。hot_derate = 相对配置上限的削减量（0=无削减）
static int HOT_DERATE_THRESHOLD = 450;   // 热端阈值（0.1°C，450=45.0°C）
static int HOT_DERATE_MULT = 5;          // 削减倍率 = 单次恢复值（削减量=(热端-阈值)×mult/10）
static int HOT_DERATE_COOLDOWN = 5;      // 削减/恢复后冷却周期数（5 个 5s 周期）
static int hot_derate = 0;               // 当前削减量（相对配置上限；累减，恢复归零=封顶）
static int hot_derate_cooldown = 0;      // 削减冷却剩余周期（独立）
static int hot_recover_cooldown = 0;     // 恢复冷却剩余周期（独立）

// 活动档位表切换（select_gear_table）已随 Gear 删除

// --- 发送去重缓存 ---
static int last_bcast_valid = 0;
static int last_mode = -1;
static int last_target_temp = -1;
static int last_rpm = -1;
static int last_cold = -1;
static int last_wind_level = -1;

// 前向声明（配置函数位于 write_log/clamp 之前）
static void write_log(const char *fmt, ...);
static inline int clamp(int val, int lo, int hi);
static void alarm_handler(int sig);
static int compute_fan_target(void);
static void set_default_log_path(void);   // 层开关复位用（定义在 write_log 之后）

/* 调试日志宏：总开关 debug_mode=1 且对应分区开关=1 时才输出。
 * 必须单行（NDK clang + CRLF 多行续行失效） */
#define debug_log(flag, fmt, ...) do { if (debug_mode && (flag)) write_log("[DEBUG] " fmt, ##__VA_ARGS__); } while(0)
#define pid_log(fmt, ...) \
    do { if (debug_mode && debug_pid) \
        write_log("[PID] " fmt, ##__VA_ARGS__); \
    } while(0)

// Gear 档位表配置解析（parse_gear_config_line / collect_gear_config / rebuild_gear_table）已随 Gear 删除

/** 去除首尾空白，返回修剪后的起始指针 */
static inline char *trim_line(char *line) {
    char *p = line;
    while (*p == ' ' || *p == '\t') p++;
    char *end = p + strlen(p) - 1;
    while (end > p && (*end == ' ' || *end == '\t')) *end-- = '\0';
    return p;
}

/** 去除字符串尾部空白，原地修改 */
static inline void trim_right(char *s) {
    char *end = s + strlen(s) - 1;
    while (end > s && (*end == ' ' || *end == '\t')) *end-- = '\0';
}

/** 原地去除首尾空白及换行符，返回修剪后的起始指针 */
static inline char *trim_value(char *s) {
    char *p = s;
    while (*p == ' ' || *p == '\t') p++;
    char *end = p + strlen(p) - 1;
    while (end > p && (*end == '\n' || *end == '\r' || *end == ' ' || *end == '\t'))
        *end-- = '\0';
    return p;
}

/** 从配置值字符串读取路径（trim + strncpy，空值跳过） */
static void config_read_path(char *dest, size_t dest_size, char *src) {
    char *v = trim_value(src);
    if (*v) {
        strncpy(dest, v, dest_size - 1);
        dest[dest_size - 1] = '\0';
    }
}

/**
 * 解析配置文件中的一行 KEY=VALUE。
 * 跳过注释（#开头）和空行，在 '=' 处分割，修剪 key 尾部空白。
 * 原地修改 line：key 尾部被 '\0' 截断。
 * 成功时 *out_key 指向修剪后的 key，返回 value 起始指针（跳过 '='）。
 * 失败（注释/空行/无'='）返回 NULL。
 */
static char *config_parse_line(char *line, char **out_key) {
    char *p = trim_line(line);
    if (*p == '#' || *p == '\n' || *p == '\0') return NULL;
    char *eq = strchr(p, '=');
    if (!eq) return NULL;
    *eq = '\0';
    *out_key = p;
    trim_right(p);
    return eq + 1;
}

// ======================== 配置解析（表驱动 + 分段函数） ========================

// --- sysfs 层键表：键名与解析方式的唯一权威名单 ---
// is_sysfs_key 与 parse_sysfs_cfg 同源查表，新增键只在此加一行；
// 不存在"名单里有、分发里没有"而被静默忽略的可能。
enum { SK_INT = 0, SK_PATH, SK_ZONE, SK_RESCAN };

struct SysfsCfgKey {
    const char *key;
    int kind;               // SK_INT / SK_PATH / SK_ZONE / SK_RESCAN
    int *ivar;              // SK_INT：目标变量
    int imin, imax;         // SK_INT：clamp 范围
    char *svar;             // SK_PATH：目标路径缓冲
    size_t ssize;           // SK_PATH：缓冲大小
};

static const struct SysfsCfgKey SYSFS_CFG_KEYS[] = {
    // 表行由 params_generated.h 的 CFG_SYSFS_KEYS 展开，键序与 clamp 边界随定义，勿在此手抄
#define CFG_ROW(k, kind, ivar, imin, imax, svar, ssize) \
    { k, kind, ivar, imin, imax, svar, ssize },
    CFG_SYSFS_KEYS(CFG_ROW)
#undef CFG_ROW
};

/** sysfs 层键查找：命中返回表项，未命中返回 NULL */
static const struct SysfsCfgKey *sysfs_key_lookup(const char *key) {
    int n = (int)(sizeof(SYSFS_CFG_KEYS) / sizeof(SYSFS_CFG_KEYS[0]));
    for (int i = 0; i < n; i++)
        if (strcmp(key, SYSFS_CFG_KEYS[i].key) == 0) return &SYSFS_CFG_KEYS[i];
    return NULL;
}

/** sysfs 路径与缩放层键集合（SYSFS_ENABLED=1 时解析，独立于性能/调试总开关） */
static int is_sysfs_key(const char *key) {
    return sysfs_key_lookup(key) != NULL;
}

// --- 配置表驱动：纯 int clamp 单值键（性能层，PERF_ENABLED=1）---
struct IntCfgKey { const char *key; int *var; int min; int max; };

static const struct IntCfgKey INT_CFG_KEYS[] = {
    // 表行由 params_generated.h 的 CFG_PERF_INT_KEYS 展开，键序与 clamp 边界随定义，勿在此手抄。
    // 多值键（PID_KI_RATE / PID_TARGET / PID_TARGET_DIR / PID_COLD_RANGE / PID_CPU_COMP / PID_SPEED_RECALL）
    // 与冷值动态倍率四键（PID_COLD_DYN_IN/_OUT/_W/_MAP，含单值键 _OUT）均在 parse_pid_cfg 分段解析，不进本表
#define CFG_ROW(k, var, lo, hi) { k, &var, lo, hi },
    CFG_PERF_INT_KEYS(CFG_ROW)
#undef CFG_ROW
};

/** 配置表查找：命中（键名一致）则 clamp 赋值，返回 1 */
static int parse_int_cfg(const char *key, int val) {
    int n = (int)(sizeof(INT_CFG_KEYS) / sizeof(INT_CFG_KEYS[0]));
    for (int i = 0; i < n; i++) {
        if (strcmp(key, INT_CFG_KEYS[i].key) == 0) {
            *INT_CFG_KEYS[i].var = clamp(val, INT_CFG_KEYS[i].min, INT_CFG_KEYS[i].max);
            return 1;
        }
    }
    return 0;
}

/** DEBUG 子开关（DEBUG_ENABLED=1 时） */
static void parse_debug_cfg(const char *key, int val) {
    if      (strcmp(key, "DEBUG_SENSOR") == 0)  debug_sensor = (val != 0);
    else if (strcmp(key, "DEBUG_EXEC") == 0)    debug_exec   = (val != 0);
    else if (strcmp(key, "DEBUG_CONN") == 0)    debug_conn   = (val != 0);
    else if (strcmp(key, "DEBUG_CONFIG") == 0)  debug_config = (val != 0);
    else if (strcmp(key, "DEBUG_MAIN") == 0)    debug_main   = (val != 0);
    else if (strcmp(key, "DEBUG_PID") == 0)     debug_pid    = (val != 0);
    else if (strcmp(key, "DEBUG_LAUNCH") == 0)  debug_launch = (val != 0);
}

/** sysfs 路径与缩放层（SYSFS_ENABLED=1 时）；解析方式由 SYSFS_CFG_KEYS 表驱动 */
static void parse_sysfs_cfg(const char *key, int val, const char *val_str) {
    const struct SysfsCfgKey *e = sysfs_key_lookup(key);
    if (!e) return;
    switch (e->kind) {
    case SK_INT:
        *e->ivar = clamp(val, e->imin, e->imax);
        break;
    case SK_PATH:
        config_read_path(e->svar, e->ssize, (char *)val_str);
        break;
    case SK_ZONE: {
        int a = CPU_ZONE_MIN, b = CPU_ZONE_MAX;
        if (sscanf(val_str, "%d %d", &a, &b) >= 2) { CPU_ZONE_MIN = clamp(a,0,99); CPU_ZONE_MAX = clamp(b,0,99); }
        break;
    }
    case SK_RESCAN: {
        // 双值：重扫间隔（秒） 保留温度值个数
        int a = cpu_zone_rescan_sec, b = cpu_zone_keep;
        int n = sscanf(val_str, "%d %d", &a, &b);
        if (n >= 1) cpu_zone_rescan_sec = clamp(a, 5, 3600);
        if (n >= 2) cpu_zone_keep = clamp(b, 1, 64);
        break;
    }
    }
}

/** PID 专属多值配置（PERF 层；单值键已并入 INT_CFG_KEYS 表驱动） */
static int parse_pid_cfg(const char *key, int val, const char *val_str) {
    // PID_KI_RATE = KI升速率(÷1000) KI降速率(÷1000)
    // 被积项 ch−target_f > 0 用升速率、< 0 用降速率；默认 20 30
    if (strcmp(key, "PID_KI_RATE") == 0) {
        int a = pid_ki_up_coef, b = pid_ki_down_coef;
        int n = sscanf(val_str, "%d %d", &a, &b);
        if (n >= 1) pid_ki_up_coef   = clamp(a, 1, 1000);
        if (n >= 2) pid_ki_down_coef = clamp(b, 1, 1000);
        return 1;
    }
    // PID_TARGET = 目标系数(÷1000) 目标EMA平滑(%) 动态目标上限(0.1°C)
    if (strcmp(key, "PID_TARGET") == 0) {
        int a = pid_target_coef, b = pid_target_alpha, c = pid_target_max;
        int n = sscanf(val_str, "%d %d %d", &a, &b, &c);
        if (n >= 1) pid_target_coef  = clamp(a, 1, 1000);
        if (n >= 2) pid_target_alpha = clamp(b, 1, 100);
        if (n >= 3) pid_target_max   = clamp(c, 1, 100);
        return 1;
    }
    // PID_TARGET_DIR = 方向性滤波开关 远离基线alpha(%) 回归基线alpha(%)
    // 默认 "1 20 10" = 远离基线 0.2、回归基线 0.1；开关=0 时退回 PID_TARGET 第2值单一 alpha
    if (strcmp(key, "PID_TARGET_DIR") == 0) {
        int on = pid_target_dir_on, a = pid_target_away_alpha, t = pid_target_toward_alpha;
        int n = sscanf(val_str, "%d %d %d", &on, &a, &t);
        if (n >= 1) pid_target_dir_on   = (on != 0);
        if (n >= 2) pid_target_away_alpha   = clamp(a, 1, 100);
        if (n >= 3) pid_target_toward_alpha = clamp(t, 1, 100);
        return 1;
    }
    if (strcmp(key, "PID_COLD_RANGE") == 0) {
        int a = pid_cold_min, b = pid_cold_max, c = b7_pid_cold_max;
        int n = sscanf(val_str, "%d %d %d", &a, &b, &c);
        if (n >= 2) { pid_cold_min=clamp(a,0,COLD_MAX); pid_cold_max=clamp(b,0,COLD_MAX); }
        if (n >= 3) { b7_pid_cold_max = clamp(c, 1, B7X_COLD_MAX); }
        return 1;
    }
    if (strcmp(key, "PID_CPU_COMP") == 0) {
        int a = pid_cpu_comp_filter_alpha, b = pid_cpu_comp_divisor, c = pid_cpu_comp_offset;
        int n = sscanf(val_str, "%d %d %d", &a, &b, &c);
        if (n >= 1) pid_cpu_comp_filter_alpha = clamp(a, 1, 100);
        if (n >= 2) pid_cpu_comp_divisor = clamp(b, 5, 200);
        if (n >= 3) pid_cpu_comp_offset = clamp(c, 0, 500);
        return 1;
    }
    // PID_SPEED_RECALL = 开关 回溯速度权重(÷1000)
    // 默认 "1 1000" = 开启、注入全量速度；无上限（锚点+累计周期数）
    if (strcmp(key, "PID_SPEED_RECALL") == 0) {
        int on = pid_spd_recall_on, w = pid_spd_recall_weight;
        int n = sscanf(val_str, "%d %d", &on, &w);
        if (n >= 1) pid_spd_recall_on = (on != 0);
        if (n >= 2) pid_spd_recall_weight = clamp(w, 100, 1000);
        return 1;
    }
    // PID_COLD_DYN_IN = 输入轴 下界 拐点 上界（冷值，零换算；默认 40 100 190）
    // 纯钳位：乱序配置不拦，除零保护放在 cold_dyn_t()（保证输出恒落 [−1,0]）
    if (strcmp(key, "PID_COLD_DYN_IN") == 0) {
        int a = cold_dyn_in_lo, b = cold_dyn_in_mid, c = cold_dyn_in_hi;
        int n = sscanf(val_str, "%d %d %d", &a, &b, &c);
        if (n >= 1) cold_dyn_in_lo  = clamp(a, 0, 255);
        if (n >= 2) cold_dyn_in_mid = clamp(b, 0, 255);
        if (n >= 3) cold_dyn_in_hi  = clamp(c, 0, 255);
        return 1;
    }
    // PID_COLD_DYN_OUT = 输出轴拐点值（正数 ×100；默认 50 = 拐点处降幅 0.50）
    if (strcmp(key, "PID_COLD_DYN_OUT") == 0) {
        int a = cold_dyn_out_mid_p100;
        if (sscanf(val_str, "%d", &a) >= 1) cold_dyn_out_mid_p100 = clamp(a, 0, 100);
        return 1;
    }
    // PID_COLD_DYN_W = KDP / KI升 / KI降 三作用点权重（各自 ×100；默认 100 100 100 = 1.00）
    if (strcmp(key, "PID_COLD_DYN_W") == 0) {
        int a = cold_dyn_w_kdp_p100, b = cold_dyn_w_up_p100, c = cold_dyn_w_dn_p100;
        int n = sscanf(val_str, "%d %d %d", &a, &b, &c);
        if (n >= 1) cold_dyn_w_kdp_p100 = clamp(a, 0, 200);
        if (n >= 2) cold_dyn_w_up_p100  = clamp(b, 0, 200);
        if (n >= 3) cold_dyn_w_dn_p100  = clamp(c, 0, 200);
        return 1;
    }
    // PID_COLD_DYN_MAP = 倍率上界 U / 形状指数 γ（各自 ×100；默认 200 100 = 2.00 / 1.00）
    if (strcmp(key, "PID_COLD_DYN_MAP") == 0) {
        int a = cold_dyn_u_p100, b = cold_dyn_gamma_p100;
        int n = sscanf(val_str, "%d %d", &a, &b);
        if (n >= 1) cold_dyn_u_p100     = clamp(a, 100, 400);
        if (n >= 2) cold_dyn_gamma_p100 = clamp(b, 10, 400);
        return 1;
    }
    return 0;
}

// Gear 专属配置解析（parse_gear_cfg）已随 Gear 删除

/** 通用多值配置（PERF 层） */
static int parse_common_cfg(const char *key, int val, const char *val_str) {
    if (strcmp(key, "HOT_RPM_MAP") == 0) {
        int a = hot_map_min, b = hot_map_max;
        if (sscanf(val_str, "%d %d", &a, &b) >= 2) { hot_map_min = clamp(a,200,500); hot_map_max = clamp(b,200,500); }
        return 1;
    }
    if (strcmp(key, "FAN_RPM_RANGE") == 0) {
        int a = fan_rpm_min, b = fan_rpm_max, c = b7_fan_rpm_max;
        int n = sscanf(val_str, "%d %d %d", &a, &b, &c);
        if (n >= 2) { fan_rpm_min = clamp(a,1000,6000); fan_rpm_max = clamp(b,1000,6000); }
        if (n >= 3) { b7_fan_rpm_max = clamp(c, 2000, B7X_FAN_RPM_MAX); }
        return 1;
    }
    if (strcmp(key, "HOT_DERATE") == 0) {
        int t = HOT_DERATE_THRESHOLD, m = HOT_DERATE_MULT, c = HOT_DERATE_COOLDOWN;
        int n = sscanf(val_str, "%d %d %d", &t, &m, &c);
        if (n >= 1) HOT_DERATE_THRESHOLD = clamp(t, 350, 700);   // 35.0~70.0°C
        if (n >= 2) HOT_DERATE_MULT = clamp(m, 1, 20);
        if (n >= 3) HOT_DERATE_COOLDOWN = clamp(c, 0, 20);
        return 1;
    }
    // RATE_LIMIT_FAN = 每周期最大变化量 防抖阈值（双值，升降共用步长；阈值 0=关闭防抖）
    if (strcmp(key, "RATE_LIMIT_FAN") == 0) {
        int step = RATE_LIMIT_FAN, thr = RATE_LIMIT_FAN_DEBOUNCE;
        int n = sscanf(val_str, "%d %d", &step, &thr);
        if (n >= 1) RATE_LIMIT_FAN          = clamp(step, 50, 2000);
        if (n >= 2) RATE_LIMIT_FAN_DEBOUNCE = clamp(thr, 0, 2000);
        return 1;
    }
    if (strcmp(key, "RATE_LIMIT_COLD") == 0) {
        // RATE_LIMIT_COLD = 基础值 倍率 最小变化幅度（三值）
        int base = RATE_LIMIT_COLD, mult = RATE_LIMIT_COLD_MULT, dz = COLD_DEADZONE;
        int n = sscanf(val_str, "%d %d %d", &base, &mult, &dz);
        if (n >= 1) RATE_LIMIT_COLD      = clamp(base, 1, COLD_MAX);
        if (n >= 2) RATE_LIMIT_COLD_MULT = clamp(mult, 1, 100);
        if (n >= 3) COLD_DEADZONE        = clamp(dz, 1, 50);
        return 1;
    }
    // COLD_RPM_MAP = 映射起始强度 指数（双值）
    if (strcmp(key, "COLD_RPM_MAP") == 0) {
        int s = cold_map_start, e = cold_map_exp;
        int n = sscanf(val_str, "%d %d", &s, &e);
        if (n >= 1) cold_map_start = clamp(s, 0, COLD_MAX);
        if (n >= 2) cold_map_exp   = clamp(e, 50, 500);
        return 1;
    }
    return 0;
}

/**
 * 把界面侧开关转写成 /data/local/tmp 标志文件（BACK_HIDE=0/1），供宿主进程里的钩子读取。
 *
 * <p>只在值变化时写；写失败不更新「已写出」记录，下一轮配置重载会重试，且只记一条日志。
 * 先写 .tmp 再 rename，避免钩子读到半行。
 */
static void publish_uiprefs(void) {
    if (back_hide_enabled == uiprefs_last_back_hide) {
        return;
    }
    char tmp[64];
    snprintf(tmp, sizeof(tmp), "%s.tmp", UIPREFS_PATH);
    FILE *f = fopen(tmp, "w");
    if (!f) {
        if (!uiprefs_fail_logged) {
            write_log("界面开关 标志文件不可写 %s（返回键后台化将按默认值生效）", UIPREFS_PATH);
            uiprefs_fail_logged = 1;
        }
        return;
    }
    fprintf(f, "BACK_HIDE=%d\n", back_hide_enabled ? 1 : 0);
    fclose(f);
    if (rename(tmp, UIPREFS_PATH) != 0) {
        if (!uiprefs_fail_logged) {
            write_log("界面开关 标志文件替换失败 %s", UIPREFS_PATH);
            uiprefs_fail_logged = 1;
        }
        remove(tmp);
        return;
    }
    uiprefs_last_back_hide = back_hide_enabled;
    uiprefs_fail_logged = 0;
}

// ======================== 层开关关闭 → 该层参数回落默认值 ========================
// 语义：PERF_ENABLED / SYSFS_ENABLED 由 1→0 时，把该层的**运行时参数**批量赋回代码默认值
// （等同该层配置不存在）；配置文件内容不动，开关再打开时文件里的值在下一次重载立刻恢复。
// 总开关自身不复位——PERF_ENABLED 代码默认值是 1，复位它会让该层立刻自我重开，等于没复位。
// 「首次加载不触发」：-1 表示"尚无上一轮状态"。首轮加载时这些配置变量本就是 static 初值
// （= 代码默认值），复位是恒等操作，故直接跳过；哨兵只在下方的 load_config 内更新。
static int last_perf_enabled  = -1;   // -1=未加载过；否则=上一轮 PERF_ENABLED（0/1）
static int last_sysfs_enabled = -1;   // -1=未加载过；否则=上一轮 SYSFS_ENABLED（0/1）

/* 默认值表行适配：把生成头的 X(C 变量, 默认值) 展开成赋值语句（用法同上两张键表） */
#define CFG_RESET_ROW(var, def) var = (def);

/** PERF 层 int 取值位 → 代码默认值（表见 params_generated.h 的 CFG_PERF_DEFAULTS） */
static void reset_perf_layer_defaults(void) {
    CFG_PERF_DEFAULTS(CFG_RESET_ROW)
    // 削减量是"相对生效上限"的累减量：上限复位后基线失效，连同两个冷却计数一并清零。
    // PID 运行态（积分/动态目标等）不动——那是运行状态，不是配置。
    hot_derate = 0;
    hot_derate_cooldown = 0;
    hot_recover_cooldown = 0;
}

/** SYSFS 层取值位 → 代码默认值（int 位见 CFG_SYSFS_DEFAULTS；4 个路径键另行处理） */
static void reset_sysfs_layer_defaults(void) {
    CFG_SYSFS_DEFAULTS(CFG_RESET_ROW)
    // 路径键：3 个用生成头的默认值宏（char[] 不能整型赋值），strncpy 后必须补 NUL
    strncpy(BATT_TEMP_PATH, CFG_DEFAULT_BATT_TEMP_PATH, sizeof(BATT_TEMP_PATH) - 1);
    BATT_TEMP_PATH[sizeof(BATT_TEMP_PATH) - 1] = '\0';
    strncpy(BATT_CURRENT_PATH, CFG_DEFAULT_BATT_CURRENT_PATH, sizeof(BATT_CURRENT_PATH) - 1);
    BATT_CURRENT_PATH[sizeof(BATT_CURRENT_PATH) - 1] = '\0';
    strncpy(CPU_TEMP_PATH_FMT, CFG_DEFAULT_CPU_TEMP_PATH_FMT, sizeof(CPU_TEMP_PATH_FMT) - 1);
    CPU_TEMP_PATH_FMT[sizeof(CPU_TEMP_PATH_FMT) - 1] = '\0';
    // LOG_FILE 必须走派生函数（二进制名 + 私有目录，不可用时兜底 /cache），照抄宏会绕过兜底
    set_default_log_path();
}

#undef CFG_RESET_ROW

static void load_config(const char *path) {
    FILE *f = fopen(path, "r");
    if (!f) {
        write_log("配置 无法打开 %s", path);
        return;
    }
    // --- 第一遍：预读 PERF_ENABLED 和 DEBUG_ENABLED（全扫描，不受配置顺序影响）---
    char line[256];
    int perf_enabled = 1;
    int found_debug = 0;
    int found_sysfs = 0;
    while (fgets(line, sizeof(line), f)) {
        char *key;
        char *val_str = config_parse_line(line, &key);
        if (!val_str) continue;
        if (strcmp(key, "PERF_ENABLED") == 0) {
            perf_enabled = atoi(val_str) != 0;
        } else if (strcmp(key, "DEBUG_ENABLED") == 0) {
            found_debug = atoi(val_str) != 0;
        } else if (strcmp(key, "SYSFS_ENABLED") == 0) {
            found_sysfs = atoi(val_str) != 0;   // sysfs 路径与缩放独立大类
        } else if (strcmp(key, "APP_LAUNCH_ENABLED") == 0) {
            APP_LAUNCH_ENABLED = (atoi(val_str) != 0);   // 任何模式下都生效（含 PERF=0/DEBUG=0）
        } else if (strcmp(key, "APP_WATCHDOG") == 0) {
            app_watchdog_cycles = clamp(atoi(val_str), 0, 120);   // 锁死自动重启停滞周期数（0=关闭）
        } else if (strcmp(key, "APP_LAUNCH_COOLDOWN") == 0) {
            app_launch_cooldown = clamp(atoi(val_str), 0, 3600);  // 两次拉起最小间隔（秒，0=不冷却）
        } else if (strcmp(key, "APP_LAUNCH_SCREEN_GATE") == 0) {
            // 屏幕门禁（二值：开关 Dozing是否算亮屏）；仅 mWakefulness=Awake 才拉起
            // 注：旧三值行（开关 读取失败默认值 Dozing）按二值口径取前两个 token，中间的旧值即被当成 Dozing
            int on = app_launch_screen_gate_enabled, dz = app_launch_screen_dozing_on;
            int n = sscanf(val_str, "%d %d", &on, &dz);
            if (n >= 1) app_launch_screen_gate_enabled = (on != 0);
            if (n >= 2) app_launch_screen_dozing_on  = (dz != 0);
        } else if (strcmp(key, "UI_BACK_HIDE") == 0) {
            // 界面键里唯一被守护进程读取的一个：本机不消费，只转写标志文件供钩子读取。
            // 与 APP_LAUNCH_ENABLED 同理，必须在第一遍读掉——否则 PERF/DEBUG/SYSFS 全关时本函数会提前 return。
            back_hide_enabled = (atoi(val_str) != 0);
        }
    }

    // 转写要在下面的前置处理与提前 return 之前完成（总开关全关时也要发布）
    publish_uiprefs();

    // 前置条件：自动拉起关闭 → 锁死自动重启（watchdog）强制关闭（不改配置，仅运行时生效）。
    if (!APP_LAUNCH_ENABLED && app_watchdog_cycles > 0) {
        write_log("配置 自动拉起关闭 → 锁死自动重启 强制关闭（APP_WATCHDOG=%d 运行时置 0）", app_watchdog_cycles);
        app_watchdog_cycles = 0;
    }

    // 层开关 1→0 边沿：该层运行时参数回落代码默认值（首次加载 last_* = -1，不触发）。
    // 复位点必须在下面「三层全关提前 return」之前：三层全关时第二遍不跑，只有这里能复位。
    if (last_perf_enabled == 1 && !perf_enabled) {
        reset_perf_layer_defaults();
        write_log("配置 性能参数层关闭 → 运行时参数回落代码默认值");
    }
    if (last_sysfs_enabled == 1 && !found_sysfs) {
        reset_sysfs_layer_defaults();
        write_log("配置 sysfs 层关闭 → 运行时参数回落代码默认值");
    }
    last_perf_enabled  = perf_enabled;
    last_sysfs_enabled = found_sysfs;

    // debug_mode 需在提前 return 前更新（PERF=0 且 DEBUG=0 时也清零）
    if (found_debug) {
        debug_mode = 1;
        write_log("配置 调试日志 开启");
    } else {
        debug_mode = 0;
    }

    if (!perf_enabled && !found_debug && !found_sysfs) {
        fclose(f);   // PERF/DEBUG/SYSFS 全关：跳过解析
        return;
    }

    if (perf_enabled) {
        write_log("配置 自定义性能参数 启用");
    }

    // --- 第二遍：全量单次扫描，仅按层分发（DEBUG/sysfs/PERF），无子守卫 ---
    rewind(f);
    while (fgets(line, sizeof(line), f)) {
        char *key;
        char *val_str = config_parse_line(line, &key);
        if (!val_str) continue;
        int val = atoi(val_str);

        // --- DEBUG 子开关：仅 DEBUG_ENABLED=1 时解析 ---
        if (debug_mode && strncmp(key, "DEBUG_", 6) == 0 && strcmp(key, "DEBUG_ENABLED") != 0) {
            parse_debug_cfg(key, val);
            continue;
        }

        // --- sysfs 路径与缩放层（SYSFS_ENABLED=1 时加载，独立于性能/调试总开关） ---
        if (found_sysfs && is_sysfs_key(key)) {
            parse_sysfs_cfg(key, val, val_str);
            continue;
        }

        // --- 性能参数：仅 PERF_ENABLED=1 时解析（不含 DEBUG_*/sysfs 路径键） ---
        if (!perf_enabled) continue;

        // 表驱动单值 → 分段函数（PID/通用），键互不重叠、唯一命中
        if (parse_int_cfg(key, val)) continue;
        if (parse_pid_cfg(key, val, val_str)) continue;
        if (parse_common_cfg(key, val, val_str)) continue;
        debug_log(debug_config, "配置 未识别键 %s（已忽略）", key);
    }
    fclose(f);

    // （CTRL_MODE 模式切换过渡 / GEAR 档位表后处理 已随 Gear 删除）
}

// ======================== 可执行文件名提取 ========================

/** 读取自身可执行文件路径（/proc/self/exe）到 out，返回 1=成功，0=失败 */
static int read_self_exe(char *out, size_t size) {
    ssize_t len = readlink("/proc/self/exe", out, size - 1);
    if (len <= 0) return 0;
    out[len] = '\0';
    return 1;
}

/**
 * 从 /proc/self/exe 获取可执行文件名（不含路径）
 * 返回 1=成功，0=失败
 */
static int get_exe_basename(char *buf, size_t size) {
    char exe_path[512];
    if (!read_self_exe(exe_path, sizeof(exe_path))) return 0;
    char *slash = strrchr(exe_path, '/');
    if (!slash) return 0;
    strncpy(buf, slash + 1, size - 1);
    buf[size - 1] = '\0';
    return 1;
}

/**
 * 根据二进制名设定默认日志路径
 * 例：tempctrl → <PRIVATE_DIR>/tempctrl.log
 * 此值为默认值，profile.conf 中 LOG_FILE 可覆盖
 * 私有目录不可用时兜底回原 /cache 落点，并写 stderr（不静默失败）
 */
static void set_default_log_path(void) {
    char basename[64];
    if (!get_exe_basename(basename, sizeof(basename))) {
        strncpy(basename, "tempctrl", sizeof(basename) - 1);
        basename[sizeof(basename) - 1] = '\0';
    }
    if (ensure_private_dir()) {
        snprintf(log_file_path, sizeof(log_file_path), PRIVATE_DIR "/%s.log", basename);
        return;
    }
    fprintf(stderr, "tempctrl: 私有目录 %s 不可用，日志回退 /cache\n", PRIVATE_DIR);
    snprintf(log_file_path, sizeof(log_file_path), "/cache/%s.log", basename);
}

/**
 * 自动检测配置文件路径
 *
 * 默认在私有目录下找 profile.conf（--config 指定的绝对路径优先，见 main）
 *
 * 返回 1=找到，0=未找到
 */
static int detect_config_path(void) {
    if (!ensure_private_dir()) return 0;

    snprintf(config_path, sizeof(config_path), PRIVATE_DIR "/profile.conf");
    if (access(config_path, F_OK) == 0) return 1;

    config_path[0] = '\0';
    return 0;
}

// ======================== 辅助函数 ========================

/**
 * 写入日志（自动滚动：超上限后保留最新日志，截断对齐到完整行首）。
 * 日期格式：日+时间，无年月（例 "14 22:30:16"）。
 * LOG_MAX=0 时关闭日志。持持久 FILE*
 */
static void write_log(const char *fmt, ...) {
    if (LOG_MAX == 0) return;     // 日志关闭

    int max_bytes = LOG_MAX;

    // 超标 → 截断保留尾部（调试模式下跳过限制，保留完整日志）。
    // ftruncate 只能从尾部截断，删头部必须先把尾部内容前移到文件头再截断。
    struct stat st;
    if (!debug_mode && stat(log_file_path, &st) == 0 && st.st_size > max_bytes) {
        int fd = open(log_file_path, O_RDWR);
        if (fd >= 0) {
            off_t keep = (off_t)max_bytes;            // 保留的尾部字节数（最新日志）
            off_t del  = (off_t)st.st_size - keep;    // 头部要删除的字节数
            char *buf = malloc((size_t)keep);
            if (buf) {
                ssize_t got = pread(fd, buf, (size_t)keep, del);
                // 对齐完整行首：del 落在行中间时，丢弃 buf 开头的半行
                size_t start = 0;
                char prev = '\0';
                if (del > 0 && pread(fd, &prev, 1, del - 1) == 1 && prev != '\n') {
                    for (size_t i = 0; i < (size_t)got; i++) {
                        if (buf[i] == '\n') { start = i + 1; break; }
                    }
                }
                if (got - (off_t)start > 0) {
                    pwrite(fd, buf + start, (size_t)(got - (off_t)start), 0);
                    ftruncate(fd, (off_t)(got - (off_t)start));
                }
                free(buf);
            }
            close(fd);
        }
    }

    // 打开或重开（首次调用、路径变化、或因滚动刚关闭）
    if (!log_fp || strcmp(log_file_path, log_path_opened) != 0) {
        if (log_fp) fclose(log_fp);
        log_fp = fopen(log_file_path, "a");
        if (!log_fp) return;
        strncpy(log_path_opened, log_file_path, sizeof(log_path_opened) - 1);
    }

    // 时间戳（仅日+时间）
    time_t now = time(NULL);
    struct tm *tm = localtime(&now);
    char ts[24];
    snprintf(ts, sizeof(ts), "%02d %02d:%02d:%02d", tm->tm_mday, tm->tm_hour, tm->tm_min, tm->tm_sec);
    fprintf(log_fp, "[%s] ", ts);

    va_list args;
    va_start(args, fmt);
    vfprintf(log_fp, fmt, args);
    va_end(args);

    fprintf(log_fp, "\n");
    fflush(log_fp);    // 立即落盘，防止崩溃丢日志
}

static inline int clamp(int val, int lo, int hi) {
    if (val < lo) return lo;
    if (val > hi) return hi;
    return val;
}

/** 浮点钳制；lo > hi 时把 hi 提到 lo，防调用方给错区间时返回越界值 */
static inline float clampf(float val, float lo, float hi) {
    if (hi < lo) hi = lo;
    if (val < lo) return lo;
    if (val > hi) return hi;
    return val;
}

/** 设备代号（日志显示用）：B7X→"b7x"，其余（B6X / 无设备）→"b6x" */
static const char *device_tag_of(DeviceType dev) {
    return (dev == DEVICE_B7X) ? "b7x" : "b6x";
}

/** 限速步进：actual 向 desired 靠拢，每周期最多变 up_limit（升）或 down_limit（降）。
 * 任何情况都走正常步进（不做首步直通）；调用方须保证 actual 已初始化为合法值，
 * 重连/启动路径用散热器实际回传值初始化，回传异常时保持原值/最小合法值。 */
static inline void rate_limit(int *actual, int desired, int up_limit, int down_limit) {
    int diff = desired - *actual;
    int step = (diff > 0) ? up_limit : down_limit;
    if (abs(diff) > step)
        *actual += (diff > 0) ? step : -step;
    else
        *actual = desired;
}

/** CPU 温度 EMA 滤波：首次直取，此后按 CPU_FILTER_ALPHA 平滑 */
static void update_cpu_filtered(int cpu_now) {
    if (cpu_now < 0) return;
    if (first_run) {
        cpu_filtered_temp = cpu_now;
        first_run = 0;
    } else {
        cpu_filtered_temp = EMA_DIR(cpu_now, cpu_filtered_temp, CPU_FILTER_ALPHA);
    }
}

// ======================== 状态文件（模块心跳 + BLE 状态） ========================

/**
 * 创建（或触摸）状态文件，设 0666 权限
 *
 * 模块（App 进程）通过此文件向 daemon 发送 BLE 连接状态和心跳。
 * daemon 创建后模块每 5 秒覆写一次 BLE 状态（B6X=0/1/2, B7X=0/6/7）。
 * open("a") 不会截断已有内容，仅创建/更新时间戳。
 */
static void create_status_files(void) {
    const char *paths[] = {status_file_path_b6, status_file_path_b7};
    for (int i = 0; i < 2; i++) {
        FILE *f = fopen(paths[i], "a");
        if (f) {
            fclose(f);
            chmod(paths[i], 0666);
            write_log("状态文件 就绪 %s", paths[i]);
        } else {
            write_log("状态文件 创建失败 %s", paths[i]);
        }
    }
}

// ======================== 双文件状态读取 ========================

/**
 * 读取单个 status 文件的 BLE 连接状态和连接时间戳
 * is_b6_file=1：B6X 文件，BLE=0/1/2（0=未连接, 1=老 app 连接, 2=新 app 连接），ble 即 b6_owner
 * is_b6_file=0：B7X 文件，BLE=0/6/7（0=未连接, 6=B6X 型号, 7=B7X 型号）
 * 两文件均解析 BLE_OWNER_LAST=<owner> <at>（B6X 文件 1/2，B7X 文件 6/7），存入全局 b6/b7_last_*
 */
static void read_single_status(const char *path, int is_b6_file,
                               int *out_connected, time_t *out_connected_at,
                               int *out_model) {
    *out_connected = 0;
    *out_connected_at = 0;
    if (out_model) *out_model = 0;
    FILE *f = fopen(path, "r");
    if (!f) return;
    char line[64];
    while (fgets(line, sizeof(line), f)) {
        const char *v;
        if ((v = status_field_value(line, STF_BLE)) != NULL) {
            int ble = atoi(v);
            *out_connected = (ble != 0);
            if (is_b6_file) {
                if (ble == 1 || ble == 2) b6_owner = ble;
                // BLE=1/2 不设 model，由 read_status_ble_both 按文件路径兜底型号 6
            } else if (out_model && (ble == 6 || ble == 7)) {
                *out_model = ble;   // B7X 文件型号编码
            }
        } else if ((v = status_field_value(line, STF_CONNECTED_AT)) != NULL) {
            *out_connected_at = (time_t)atol(v);
        } else if ((v = status_field_value(line, STF_BLE_OWNER_LAST)) != NULL) {
            int owner = 0;
            long at = 0;
            if (sscanf(v, "%d %ld", &owner, &at) == 2 && owner > 0) {
                if (is_b6_file) { b6_last_owner = owner; b6_last_at = (time_t)at; }
                else { b7_last_owner = owner; b7_last_at = (time_t)at; }
            }
        }
    }
    fclose(f);
}

/**
 * 读取双状态文件中的 BLE 连接状态
 */
static void read_status_ble_both(void) {
    read_single_status(status_file_path_b6, 1, &b6_connected, &b6_connected_at, &b6_model);
    read_single_status(status_file_path_b7, 0, &b7_connected, &b7_connected_at, &b7_model);
    // B6X BLE=1/2 型号未知 → 按文件路径兜底（B6X app 默认连 B6X 散热器，型号按 6）
    if (b6_connected && b6_model == 0) b6_model = 6;
    // B7X BLE≠6/7（旧编码 1/2）→ 按文件路径兜底型号 7
    if (b7_connected && b7_model == 0) b7_model = 7;
    // BLE_OWNER_LAST 跨文件合并——取最近一次连接者（时间最新者）。
    // 时间戳相等（同秒连接，1 秒分辨率）时固定选 B6X 侧；两文件均无记录时 last_owner=0
    if (b7_last_at > b6_last_at) { last_owner = b7_last_owner; last_owner_at = b7_last_at; }
    else { last_owner = b6_last_owner; last_owner_at = b6_last_at; }
}

/**
 * 仲裁：根据 BLE 状态决定当前控制哪台设备
 *
 * 规则：
 *   仅一台连 → 控制那台
 *   两台都连 → 选先连者（CONNECTED_AT 小者优先）
 *   都断连   → DEVICE_NONE
 */
static DeviceType select_active_device(void) {
    if (b6_connected && !b7_connected) return DEVICE_B6X;
    if (!b6_connected && b7_connected) return DEVICE_B7X;
    if (!b6_connected && !b7_connected) return DEVICE_NONE;

    // 两者都连：比较时间戳
    if (b6_connected_at > 0 && b7_connected_at > 0)
        return (b6_connected_at <= b7_connected_at) ? DEVICE_B6X : DEVICE_B7X;
    if (b6_connected_at > 0) return DEVICE_B6X;  // 仅 B6X 有精确时间戳
    if (b7_connected_at > 0) return DEVICE_B7X;  // 仅 B7X 有精确时间戳
    return DEVICE_B6X;  // 都无时间戳，B6X 优先
}

/**
 * 设置运行时动态限制（根据 active_device）
 * 切换设备时调用
 */
static void update_active_limits(void) {
    // 按 status 回传的实际设备型号选择限制，而非按包名猜测。
    // （B7X 文件 BLE=6/7 回传实际型号；B6X 文件 BLE=1/2 型号未知，b6_model 已兜底为 6）
    int model = (active_device == DEVICE_B7X) ? b7_model : b6_model;
    if (model != 6 && model != 7)
        model = (active_device == DEVICE_B7X) ? 7 : 6;  // 型号未知按包名兜底
    if (model == 7) {
        active_fan_max  = b7_fan_rpm_max;    // FAN_RPM_RANGE 第三值（B7X），默认同 B6X
        active_pid_cold_max = b7_pid_cold_max; // PID_COLD_RANGE 第三值（B7X），默认同 B6X
    } else {
        active_fan_max  = fan_rpm_max;        // 使用 profile.conf 中的配置值
        active_pid_cold_max = pid_cold_max;   // 使用 profile.conf 中的配置值
    }
}

/**
 * 读取 active_device 对应的状态文件中的散热器回传参数
 * 在仲裁确定 active_device 后调用
 */
static void read_cooler_params(void) {
    const char *path = (active_device == DEVICE_B7X) ? status_file_path_b7 : status_file_path_b6;

    // 先重置所有参数
    cooler_hot_temp = -1; cooler_cold_temp = -1;
    cooler_rpm_real = -1; cooler_cold_real = -1;

    FILE *f = fopen(path, "r");
    if (!f) return;
    char line[64];
    int run_mode_seen = 0;   // 本帧是否读到 RUN_MODE（与 COLD_REAL 同块写入，lastWaspWingInfo 就绪才有）
    while (fgets(line, sizeof(line), f)) {
        const char *v;
        if ((v = status_field_value(line, STF_BLE)) != NULL) {
            app_ble_connected = (atoi(v) != 0);
        } else if ((v = status_field_value(line, STF_HOT_TEMP)) != NULL) {
            cooler_hot_temp = atoi(v);
        } else if ((v = status_field_value(line, STF_COLD_TEMP)) != NULL) {
            cooler_cold_temp = atoi(v);
        } else if (status_field_value(line, STF_RUN_MODE) != NULL) {
            run_mode_seen = 1;
        } else if ((v = status_field_value(line, STF_RPM_REAL)) != NULL) {
            cooler_rpm_real = atoi(v);
        } else if ((v = status_field_value(line, STF_COLD_REAL)) != NULL) {
            cooler_cold_real = atoi(v);
        }
    }
    fclose(f);

    // 回传可信判定：本帧 RUN_MODE 存在（真实回传已就绪）+ 冷/rpm 值合法 → 累计连续帧；
    // 任一帧缺失/异常即清零。连续 REPORT_OK_N 帧（≈N 秒）才置 report_ok=1，用于启动/重连对齐。
    int frame_ok = (run_mode_seen && cooler_cold_real >= COLD_MIN && cooler_rpm_real >= fan_rpm_min);
    if (frame_ok) {
        if (report_ok_streak < REPORT_OK_N) report_ok_streak++;
        if (report_ok_streak >= REPORT_OK_N) report_ok = 1;
    } else {
        report_ok_streak = 0;
    }
}

// ======================== sysfs 读取工具 ========================

/**
 * 从 sysfs 文件读取一个整数值
 * 失败（文件不可读或解析失败）返回 -1
 */
static int read_sysfs_int(const char *path) {
    FILE *f = fopen(path, "r");
    if (!f) return -1;
    int val;
    if (fscanf(f, "%d", &val) != 1) {
        fclose(f);
        return -1;
    }
    fclose(f);
    return val;
}

/**
 * 读取指定 thermal_zone 的原始温度值（m°C），含异常值过滤
 * 失败或值不合法返回 -1
 */
static int read_thermal_zone_raw(int zone_id) {
    char path[128];
    snprintf(path, sizeof(path), CPU_TEMP_PATH_FMT, zone_id);
    int raw = read_sysfs_int(path);
    if (raw <= 0 || raw > 150000) return -1;
    return raw;
}

// ======================== 温度读取 ========================

/**
 * 读取电池温度，返回 0.1°C（如 350 = 35.0°C）
 * 文件路径：默认 /sys/class/power_supply/battery/temp（可配置 BATT_TEMP_PATH）
 * 失败返回 -1
 */
static int read_battery_temp(void) {
    // Scene 式：值比较为主判据，mtime 更新也视为数据刷新（补充信号，部分内核 mtime 不可靠）。
    int raw = read_sysfs_int(BATT_TEMP_PATH);
    if (raw < 0) {
        batt_temp_updated = 0;
        return -1;
    }
    int val = raw / BATT_TEMP_DIVISOR;
    debug_log(debug_sensor, "batt_temp 原始 %d 除数 %d = %d (%.1f°C)",
              raw, BATT_TEMP_DIVISOR, val, val / 10.0);
    struct stat st;
    int mtime_changed = 0;
    if (stat(BATT_TEMP_PATH, &st) == 0 && st.st_mtime != batt_temp_mtime) {
        mtime_changed = 1;
        batt_temp_mtime = st.st_mtime;
    }
    batt_temp_updated = (val != batt_cached_temp) || mtime_changed;   // 值或 mtime 任一变化
    batt_cached_temp = val;
    return val;
}

/**
 * 缓存已发现的 CPU 温度 zone（首次全量扫描后记录）
 */
#define CPU_ZONE_MAX_CACHE 64
static int cpu_zone_cache[CPU_ZONE_MAX_CACHE];
static int cpu_zone_valid[CPU_ZONE_MAX_CACHE];   // 首次全量扫描发现的有效 zone 候选名单（固定，不随重扫增减）
static int cpu_zone_valid_count = 0;
static int cpu_zone_count = 0;
static int cpu_zone_scanned = 0;
static time_t cpu_zone_last_scan = 0;        // 上次全量扫描时间（每 cpu_zone_rescan_sec 秒重扫一次）

// 初始扫描时暂存 zone 编号 + 温度（用于排序筛选）
typedef struct { int id; int raw; } ZoneReading;

static int cmp_zone_desc(const void *a, const void *b) {
    int da = ((const ZoneReading*)a)->raw;
    int db = ((const ZoneReading*)b)->raw;
    return (da < db) - (da > db);   // 降序
}

/**
 * 扫描 thermal_zone 并保留最高温的 cpu_zone_keep 个。
 * 首次（!cpu_zone_scanned）真全量扫描 CPU_ZONE_MIN~MAX，把有效 zone 记为固定候选名单；
 * 后续只在候选名单内读值重排。首次由 read_cpu_temp_max 同步触发（保证首个读数可用）；
 * 周期重扫由 5s 控制块 maybe_rescan_cpu_zones 触发——全量扫描 ~100 个 zone 阻塞近 1s，
 * 不能放在 1s 采集热路径内。
 */
static void rescan_cpu_zones(void) {
    time_t now = time(NULL);
    ZoneReading readings[CPU_ZONE_MAX_CACHE];
    int count = 0;

    if (!cpu_zone_scanned) {
        // 首次：真全量扫描 CPU_ZONE_MIN~MAX，记录所有能读到有效值（正数）的 zone 为固定候选名单
        for (int i = CPU_ZONE_MIN; i <= CPU_ZONE_MAX; i++) {
            int raw = read_thermal_zone_raw(i);
            if (raw < 0) continue;
            if (count < CPU_ZONE_MAX_CACHE) {
                readings[count].id  = i;
                readings[count].raw = raw;
                count++;
            }
        }
        cpu_zone_valid_count = count;
        for (int i = 0; i < count; i++) cpu_zone_valid[i] = readings[i].id;
    } else {
        // 后续重扫：只在首次有效候选名单内读值重排，不扫描区间外、不发现新 zone；
        // 名单中本轮无效（≤0/读失败）的 zone 不入列。无回退全量兜底。
        for (int i = 0; i < cpu_zone_valid_count; i++) {
            int raw = read_thermal_zone_raw(cpu_zone_valid[i]);
            if (raw < 0) continue;
            if (count < CPU_ZONE_MAX_CACHE) {
                readings[count].id  = cpu_zone_valid[i];
                readings[count].raw = raw;
                count++;
            }
        }
    }

    // 按温度降序排列，保留温度最高的 cpu_zone_keep 个
    qsort(readings, count, sizeof(ZoneReading), cmp_zone_desc);
    int keep = count < cpu_zone_keep ? count : cpu_zone_keep;
    for (int i = 0; i < keep; i++)
        cpu_zone_cache[i] = readings[i].id;
    cpu_zone_count = keep;
    cpu_zone_scanned = 1;
    cpu_zone_last_scan = now;

    if (keep == 0) {
        debug_log(debug_sensor, "thermal_zone 扫描 无可读 zone（路径 %s），CPU 紧急无法触发",
                  CPU_TEMP_PATH_FMT);
    } else {
        debug_log(debug_sensor, "thermal_zone 扫描 有效 %d 个，保留 %d 个最高温（%ds 后重扫）",
                  count, keep, cpu_zone_rescan_sec);
    }
}

/** 周期重扫（5s 控制块调用）：距上次全量扫描达到 cpu_zone_rescan_sec 时重建保留列表 */
static void maybe_rescan_cpu_zones(void) {
    if (!cpu_zone_scanned) return;   // 首次扫描由 read_cpu_temp_max 同步完成
    time_t now = time(NULL);
    if (now - cpu_zone_last_scan < cpu_zone_rescan_sec) return;
    rescan_cpu_zones();
}

/**
 * 读取 CPU 最高温度，返回 0.1°C（如 753 = 75.3°C）
 *
 * 首次调用：同步全量扫描 thermal_zone0~99 一次，记录所有能读到有效值的 zone
 * 后续调用：只扫描已记录的 zone 列表，取最高值（周期重扫在 5s 控制块 maybe_rescan_cpu_zones）
 *
 * 原始值 m°C，除以 100 转 0.1°C
 * 全部失败返回 -1
 */
static int read_cpu_temp_max(void) {
    // 首次调用：同步全量扫描一次（保证首个读数可用）。
    // 周期重扫已迁至 5s 控制块：全量扫描 ~100 个 zone 阻塞近 1s，不能放 1s 采集热路径。
    if (!cpu_zone_scanned) rescan_cpu_zones();

    // 后续调用 → 只扫描已保留的 zone
    int max_temp = -1;
    for (int j = 0; j < cpu_zone_count; j++) {
        int raw = read_thermal_zone_raw(cpu_zone_cache[j]);
        if (raw < 0) continue;

        int decic = raw / CPU_TEMP_DIVISOR;
        if (decic > max_temp) max_temp = decic;
    }
    if (max_temp >= 0) {
        debug_log(debug_sensor, "cpu_temp zone=%d max=%d (%.1f°C)",
                  cpu_zone_count, max_temp, max_temp / 10.0);
    }
    return max_temp;
}

// ======================== 热端过温制冷削减 ========================

/** 当前生效的制冷强度上限 = 基准上限（配置上限）- 热端过温削减，下限不低于冷端最小强度 */
static inline int eff_cold_max(int base_max, int cold_min) {
    int m = base_max - hot_derate;
    if (m < cold_min) m = cold_min;
    return m;
}

// 当前模式有效制冷范围（每 5s 周期由 update_active_cold_range 统一计算，下发/去重/映射共用）
static int active_cold_eff_min = 1;    // 有效制冷下限（PID=pid_cold_min）
static int active_cold_eff_max = 190;  // 有效制冷上限（含热端过温削减）

/**
 * 每 5s 周期调用：根据散热器热端温度更新制冷上限削减量。
 * 热端 > 阈值 → 单次削减 (热端-阈值)×倍率：首次削减把生效上限压到「当前实际制冷值 − 削减量」，
 *   之后每次触发在当前生效上限上继续累减（不回看历史触发值），削减后 HOT_DERATE_COOLDOWN 周期内不再削减；
 * 热端 ≤ 阈值 → 生效上限每次 +5（=倍率值）逐级上爬，归零即封顶配置上限，恢复后冷却周期内不再恢复；
 * 削减/恢复冷却独立。热端数据无效（<0）时保持当前削减量。原始直算不加滤波。
 */
static void update_hot_derate(void) {
    if (hot_derate_cooldown > 0) hot_derate_cooldown--;
    if (hot_recover_cooldown > 0) hot_recover_cooldown--;
    if (cooler_hot_temp < 0) return;   // 热端无效：保持当前削减

    if (cooler_hot_temp > HOT_DERATE_THRESHOLD) {
        if (hot_derate_cooldown == 0) {
            int reduction = (cooler_hot_temp - HOT_DERATE_THRESHOLD) * HOT_DERATE_MULT / 10;
            if (reduction > 0) {   // 刚过阈值整数截断为 0 时跳过，不触发冷却
                int before = eff_cold_max(active_pid_cold_max, pid_cold_min);
                if (hot_derate == 0) {
                    // 首次削减：就地把上限压到「当前实际制冷值 − 削减量」（未就绪时按配置上限算）
                    int cold_now = (actual_cold >= COLD_MIN) ? actual_cold : active_pid_cold_max;
                    hot_derate = active_pid_cold_max - cold_now + reduction;
                } else {
                    hot_derate += reduction;   // 再次触发：在当前生效上限上累减
                }
                hot_derate_cooldown = HOT_DERATE_COOLDOWN;
                write_log("热端过温 %d.%d°C 削减制冷上限 %d→%d（削减量 %d）",
                          cooler_hot_temp / 10, cooler_hot_temp % 10,
                          before, eff_cold_max(active_pid_cold_max, pid_cold_min), reduction);
            }
        }
    } else {
        if (hot_derate > 0 && hot_recover_cooldown == 0) {
            int before = eff_cold_max(active_pid_cold_max, pid_cold_min);
            hot_derate -= HOT_DERATE_MULT;
            if (hot_derate < 0) hot_derate = 0;   // 归零=封顶配置上限
            hot_recover_cooldown = HOT_DERATE_COOLDOWN;
            write_log("热端回落 %d.%d°C 恢复制冷上限 %d→%d（恢复量 %d）",
                      cooler_hot_temp / 10, cooler_hot_temp % 10,
                      before, eff_cold_max(active_pid_cold_max, pid_cold_min), HOT_DERATE_MULT);
        }
    }
}

/**
 * 计算 PID 模式有效制冷范围（默认上限 = PID_COLD_RANGE 上限，含热端过温削减）。
 * 每 5s 周期在 update_hot_derate 之后调用，供下发/去重/映射统一使用。
 */
static void update_active_cold_range(void) {
    active_cold_eff_min = pid_cold_min;
    active_cold_eff_max = eff_cold_max(active_pid_cold_max, pid_cold_min);
}

// ======================== 控制参数计算与下发 ========================

// 档位查表参数构造（build_params）已随 Gear 删除

// ======================== 广播协议（须与 MainHook.java 侧一致） ========================
// Action / extra 名的唯一权威名单，改此处须同步 lsp模块/app/ 内 MainHook.java
#define BROADCAST_ACTION_B6X  "com.flydigi.SET_TEMPERATURE"
#define BROADCAST_ACTION_B7X  "com.flydigi.SET_TEMPERATURE_B7"
// extra 名按下发顺序排列，与 send_am_broadcast 的取值数组逐项对应
static const char *const BROADCAST_EXTRAS[] = {
    "mode", "temperature", "windOC", "coldOC", "windLevel", "modeCustom", "extra",
};
#define BROADCAST_EXTRAS_N  ((int)(sizeof(BROADCAST_EXTRAS) / sizeof(BROADCAST_EXTRAS[0])))
#define BROADCAST_VAL_MAX   12   // 整型 extra 字符串缓冲（int 最长 11 字符 + NUL）

/**
 * 通过 am broadcast 下发控制参数到 LSPosed 模块（fork+exec，3s 超时）
 */
static void send_am_broadcast(int mode, int target, int windOC, int coldOC, int windLevel) {
    // 取值顺序必须与 BROADCAST_EXTRAS 一致（前 5 项来自形参，后 2 项固定 0）
    const int vals[BROADCAST_EXTRAS_N] = { mode, target, windOC, coldOC, windLevel, 0, 0 };
    char v_s[BROADCAST_EXTRAS_N][BROADCAST_VAL_MAX];
    for (int i = 0; i < BROADCAST_EXTRAS_N; i++)
        snprintf(v_s[i], sizeof(v_s[i]), "%d", vals[i]);

    pid_t pid = fork();
    if (pid < 0) {
        write_log("fork 失败，跳过下发");
        return;
    }
    if (pid == 0) {
        int fd = open("/dev/null", O_WRONLY);
        if (fd >= 0) {
            dup2(fd, STDOUT_FILENO);
            dup2(fd, STDERR_FILENO);
            close(fd);
        }
        // 根据当前控制的设备选择广播 Action
        const char *action = (active_device == DEVICE_B7X)
            ? BROADCAST_ACTION_B7X
            : BROADCAST_ACTION_B6X;
        // 用绝对路径执行 am：daemon 环境 PATH 若缺 /system/bin，execlp 会静默失败
        // （子进程 _exit(127)，父进程 waitpid 正常返回，故障不可见）。
        // execv 不依赖 PATH；argv 由 extra 名单驱动，避免形参序与 --ei 序错位。
        char *argv[6 + 3 * BROADCAST_EXTRAS_N + 1];
        int ai = 0;
        argv[ai++] = (char *)"am";
        argv[ai++] = (char *)"broadcast";
        argv[ai++] = (char *)"--user";
        argv[ai++] = (char *)"0";
        argv[ai++] = (char *)"-a";
        argv[ai++] = (char *)action;
        for (int i = 0; i < BROADCAST_EXTRAS_N; i++) {
            argv[ai++] = (char *)"--ei";
            argv[ai++] = (char *)BROADCAST_EXTRAS[i];
            argv[ai++] = v_s[i];
        }
        argv[ai] = NULL;
        execv(AM_BIN, argv);
        _exit(127);
    }
    // 父进程：限时等待子进程（3 秒超时）
    signal(SIGALRM, alarm_handler);
    alarm(3);
    int status;
    if (waitpid(pid, &status, 0) == -1) {
        write_log("am broadcast 超时");
        kill(pid, SIGKILL);
        waitpid(pid, NULL, 0);
    } else if (WIFEXITED(status) && WEXITSTATUS(status) != 0) {
        // am 退出码非零 → 广播未送达，需让故障可见
        write_log("am broadcast 失败：退出码 %d（广播未送达）", WEXITSTATUS(status));
    } else if (WIFSIGNALED(status)) {
        write_log("am broadcast 异常终止：信号 %d", WTERMSIG(status));
    } else {
        debug_log(debug_exec, "am broadcast 已发送 mode=%d target=%d windOC=%d coldOC=%d windLevel=%d",
                  mode, target, windOC, coldOC, windLevel);
    }
    alarm(0);
    signal(SIGALRM, SIG_DFL);
}

/**
 * 计算速率上限：风扇升降共用固定步长（防抖在 rate_limit_fan 内单独判定）；制冷强度按电池温差动态算
 * @param out_fan_step  风扇每周期最大变化量（RPM，= RATE_LIMIT_FAN 固定值，升/降共用）
 * @param out_cold_up   制冷强度升速上限（有符号温差，负值→0=禁止升）
 * @param out_cold_down 制冷强度降速上限（有符号温差，负值→0=禁止降）
 */
static void calc_dynamic_rates(int *out_fan_step, int *out_cold_up, int *out_cold_down) {
    *out_fan_step = RATE_LIMIT_FAN;
    // 制冷强度：有符号温差 dev，升速/降速独立；负值 → clamp 到 0（禁止该方向）
    int dev = 0;
    if (cycle_batt_temp >= 0) dev = cycle_batt_temp - BATT_BASELINE;
    int up   = RATE_LIMIT_COLD + dev * RATE_LIMIT_COLD_MULT / 10;
    int down = RATE_LIMIT_COLD - dev * RATE_LIMIT_COLD_MULT / 10;
    *out_cold_up   = (up   > 0) ? up   : 0;
    *out_cold_down = (down > 0) ? down : 0;
}

/**
 * 制冷强度限速（升降独立，负值方向已 clamp 到 0）。
 * 更新 actual_cold；调用方随后用限速后的实际制冷重算风扇目标。
 */
static void rate_limit_cold(int desired_cold) {
    int fan_step, cold_up, cold_down;
    calc_dynamic_rates(&fan_step, &cold_up, &cold_down);
    int old_cold = actual_cold;
    rate_limit(&actual_cold, desired_cold, cold_up, cold_down);
    debug_log(debug_exec, "cold 限速 %d→%d desired=%d（升%d 降%d）",
              old_cold, actual_cold, desired_cold, cold_up, cold_down);
}

/**
 * 风扇转速限速（升/降共用同一步长，两个方向各带一段防抖）。
 * 返回限速后的实际风扇转速，就近取整到 FAN_RPM_ROUND_UNIT 的倍数并钳制到设备范围。
 *
 * 防抖是「幅度阈值」：本周期变化量不超过阈值就整步不做（不看时间、不计数）；
 * 距最低转速（降）/最高转速（升）< 阈值×1.5 时防抖失效（贴近端点无需再抑制）。
 */
static int rate_limit_fan(int desired_rpm) {
    int fan_step, cold_up, cold_down;
    calc_dynamic_rates(&fan_step, &cold_up, &cold_down);

    // 防抖判定：升/降两条同构守卫已收敛为一次求值，方向由 rising 定死；
    // 原实现靠「降速分支先改写 desired」隐式保证两条互斥，勿拆回两条。
    int rising = (desired_rpm > actual_rpm);
    int ref_room = rising ? (active_fan_max - actual_rpm)    // 升速：距最高转速（现场读，active_fan_max 为运行时量）
                          : (actual_rpm - fan_rpm_min);      // 降速：距最低转速
    int delta = abs(desired_rpm - actual_rpm);
    // 阈值 ×1.5 必须先乘后除（* 3 / 2）：写成 /2*3 时阈值 51 得 75 而非 76，差 1 RPM 即移动 >= 边界
    int hold = delta > 0 &&
               ref_room >= RATE_LIMIT_FAN_DEBOUNCE * 3 / 2 &&
               delta <= RATE_LIMIT_FAN_DEBOUNCE;
    if (hold) desired_rpm = actual_rpm;   // 防抖：变化量不超阈值 → 本周期保持不动
    int drop_hold = hold && !rising;      // 降速防抖命中
    int rise_hold = hold && rising;       // 升速防抖命中

    // 单键语义：两个实参必须同值
    rate_limit(&actual_rpm, desired_rpm, fan_step, fan_step);
    // 下限钳制：内部 actual_rpm 与 send_rpm 对齐，恒不低于 fan_rpm_min。
    // 否则风扇目标偏低时 actual_rpm 跌破 fan_rpm_min，rate_limited_execute 的就绪守卫会误判"未就绪"而永久跳过下发（死锁）。
    actual_rpm = clamp(actual_rpm, fan_rpm_min, active_fan_max);

    // ---- 就近取整到 FAN_RPM_ROUND_UNIT 的倍数（默认 10：2044→2040、2045→2050）----
    int round_unit = (fan_rpm_round_unit > 0) ? fan_rpm_round_unit : 1;
    int send_rpm = ((actual_rpm + round_unit / 2) / round_unit) * round_unit;
    send_rpm = clamp(send_rpm, fan_rpm_min, active_fan_max);
    debug_log(debug_exec, "rpm 限速 desired=%d → %d（降防抖=%d 升防抖=%d）",
              desired_rpm, send_rpm, drop_hold, rise_hold);
    return send_rpm;
}

/**
 * 下发去重 + 制冷变化死区判定：返回 1 表示跳过本次下发。
 *
 * 去重以散热器实际回传为准：要播发值与实际值一致视为已到位，跳过下发；
 * 回传异常（实际值 < 0）时退化用 last_* 缓存对比。
 *
 * 制冷变化死区：目标与制冷实际 |差值| 少于设定则上升下降都不下发；
 * 距最高/最低制冷强度 < 阈值×2 时死区失效（接近极值必须允许精确到位）。
 */
static int should_skip_dispatch(int mode, int target, int windOC, int cold, int windLevel) {
    int send_rpm = (mode == 0) ? windLevel : windOC;

    if (cooler_cold_real >= 0 && cooler_rpm_real >= 0) {
        if (mode == 0) {
            // mode=0 智能温控：散热器自管理制冷，故只需比较风扇上限（windLevel/RPM），制冷不参与去重。
            if (send_rpm == cooler_rpm_real) {
                debug_log(debug_exec, "skip 已到位（mode=0 仅比较风扇）：目标RPM%d == 回传RPM%d，跳过下发",
                          send_rpm, cooler_rpm_real);
                return 1;   // 风扇已到位（制冷由散热器自管理，不判）
            }
            return 0;
        }

        if (cold == cooler_cold_real && send_rpm == cooler_rpm_real) {
            debug_log(debug_exec, "skip 已到位：目标冷%d RPM%d == 回传冷%d RPM%d，跳过下发",
                      cold, send_rpm, cooler_cold_real, cooler_rpm_real);
            return 1;   // 散热器实际已到位
        }

        int diff = cold - cooler_cold_real;
        if (diff != 0) {
            // 最小变化幅度：目标与制冷实际 |差值| < 死区 → 上升下降都不变；接近极值处死区失效允许到位。
            int cmin = active_cold_eff_min;   // 当前模式有效范围（main_loop 统一计算）
            int cmax = active_cold_eff_max;
            int adiff = abs(diff);
            int near_extreme = (cmax - cooler_cold_real) < COLD_DEADZONE * 2
                            || (cooler_cold_real - cmin) < COLD_DEADZONE * 2;
            if (adiff < COLD_DEADZONE && !near_extreme) {
                debug_log(debug_exec, "skip 制冷变化死区：目标冷%d 回传冷%d |diff|=%d <%d死区，升降都不变",
                          cold, cooler_cold_real, adiff, COLD_DEADZONE);
                return 1;   // |差值| < 最小变化幅度 → 上升下降都不下发
            }
        }
        return 0;
    }

    // 回传异常：退化用 last_* 缓存对比（异常路径必须常驻可见，不走 debug 分区）
    int skip = last_bcast_valid &&
               mode == last_mode && target == last_target_temp &&
               windOC == last_rpm && cold == last_cold &&
               windLevel == last_wind_level;
    if (skip)
        write_log("下发去重 回传异常（冷%d RPM%d 不可用），按上次参数缓存判定跳过 mode=%d 冷%d RPM%d",
                  cooler_cold_real, cooler_rpm_real, last_mode, last_cold, last_rpm);
    return skip;
}

// Gear 档位下发（apply_gear）已随 Gear 删除

// ======================== App 进程 + 心跳检测 ========================

/**
 * 检测 App 是否存活：状态文件 mtime 不超过 STATUS_TIMEOUT 秒
 * LSP 每 1 秒写一次 status 文件，mtime 超时即判进程死
 */
static int is_app_alive(void) {
    const char *path = (active_device == DEVICE_B7X) ? status_file_path_b7 : status_file_path_b6;
    struct stat st;
    if (stat(path, &st) != 0) return 0;
    time_t now = time(NULL);
    int alive = (now - st.st_mtime <= STATUS_TIMEOUT);
    return alive;
}

// ======================== 双 app 存活仲裁 ========================
// 需求：B6X 两个 app 最多一个后台存活，保留 BLE 连接者（b6_owner），无法区分时保留老 app。
// farsef（B7X app）仅在最近连接的是 B6X 散热器（BLE_OWNER_LAST==6）时参与；B7X 设备由 select_active_device 单独处理。

/**
 * 单次遍历 /proc，同时检测多个包名存活状态（合并扫描，替代逐包名全量遍历，省 2/3 开销）。
 * 直读 /proc/<pid>/cmdline 做精确比对，不经 shell：整参等于包名，或 --nice-name=<包名>；
 * 避免 system("pgrep -f <pkg>") 时临时 shell 自身命令行含包名造成的自匹配误判。
 */
static void app_process_scan(const char *pkgs[], int alive[], int count) {
    for (int i = 0; i < count; i++) alive[i] = 0;
    DIR *d = opendir("/proc");
    if (!d) return;
    struct dirent *de;
    char buf[4096];
    int found_all = 0;
    while (!found_all && (de = readdir(d)) != NULL) {
        if (de->d_name[0] < '0' || de->d_name[0] > '9') continue;   // 只扫数字 PID
        char path[64];
        snprintf(path, sizeof(path), "/proc/%s/cmdline", de->d_name);
        int fd = open(path, O_RDONLY);
        if (fd < 0) continue;
        ssize_t n = read(fd, buf, sizeof(buf) - 1);
        close(fd);
        if (n <= 0) continue;
        buf[n] = '\0';
        for (char *tok = buf; tok < buf + n; ) {
            size_t len = strnlen(tok, (size_t)(buf + n - tok));
            if (len > 0) {
                for (int i = 0; i < count; i++) {
                    if (!alive[i] &&
                        (strcmp(tok, pkgs[i]) == 0 ||
                         (strncmp(tok, "--nice-name=", 12) == 0 && strcmp(tok + 12, pkgs[i]) == 0)))
                        alive[i] = 1;
                }
            }
            tok += len + 1;
        }
        found_all = 1;
        for (int i = 0; i < count; i++) if (!alive[i]) { found_all = 0; break; }
    }
    closedir(d);
}

/**
 * 屏幕状态（dumpsys power 读 mWakefulness）：仅 Awake 算亮屏。
 * 返回：1=Awake(亮屏)、2=Dozing(息屏常显)、0=Asleep/其余(灭屏)、-1=读取失败。
 * 精确匹配 "mWakefulness=" 并排除 "mWakefulnessOverride="（跨版本行序不定，勿用 grep -m1 直接截断）。
 */
static int is_screen_awake(void) {
    char cmd[256];
    snprintf(cmd, sizeof(cmd),
             DUMPSYS_BIN " power 2>/dev/null | awk -F'=' '/mWakefulness=/{ if ($0 !~ /Override/) { print $2; exit } }'");
    FILE *fp = popen(cmd, "r");
    if (!fp) return -1;
    char val[32] = {0};
    if (fgets(val, sizeof(val), fp)) {
        size_t n = strlen(val);
        while (n > 0 && (val[n-1] == '\n' || val[n-1] == '\r')) val[--n] = 0;
    }
    pclose(fp);
    if (strcmp(val, "Awake") == 0) return 1;
    if (strcmp(val, "Dozing") == 0) return 2;
    if (strlen(val) == 0) return -1;   // 解析到空 → 失败，调用方按兜底处理
    return 0;                          // Asleep / 其余 → 灭屏
}

/** 判断指定包名是否为当前前台/top Activity（dumpsys 开销约 100~300ms，仅在要 kill 时调用） */
static int is_foreground_pkg(const char *pkg) {
    // 优先窗口焦点 mCurrentFocus（最准确），退化为 topResumedActivity/mResumedActivity
    // grep -m1 截断管道，dumpsys 收到 SIGPIPE 提前退出，实际开销远低于完整 dumpsys
    char cmd[1024];
    snprintf(cmd, sizeof(cmd),
             DUMPSYS_BIN " window 2>/dev/null | grep -m1 'mCurrentFocus='; "
             DUMPSYS_BIN " activity activities 2>/dev/null | grep -m1 -E 'topResumedActivity|mResumedActivity'");
    FILE *fp = popen(cmd, "r");
    if (!fp) return 0;
    char line[1024];
    int fg = 0;
    while (fgets(line, sizeof(line), fp)) {
        if (strstr(line, pkg)) { fg = 1; break; }
    }
    pclose(fp);
    return fg;
}

/** 构建命令并静默执行（输出重定向到 /dev/null），返回 system() 退出码 */
static int run_cmd_silent(const char *fmt, const char *arg) {
    char cmd[256];
    snprintf(cmd, sizeof(cmd), fmt, arg);
    return system(cmd);
}

/**
 * 包安装状态实时探测（走 pm path）。
 * 返回：1=已安装、0=未安装（pm 明确报包不存在）、-1=无法判定（命令没跑起来）。
 * 每次调用都要 fork+exec 一次 pm（ART 冷启动，约 100~300ms，同 is_foreground_pkg 处 dumpsys 量级），
 * 故探测链上不要直接调用本函数，一律走带缓存的 app_installed()；只有需要实时结论的宿主卸载探测才直接用它。
 */
static int app_installed_probe(const char *pkg) {
    int st = run_cmd_silent(PM_BIN " path %s > /dev/null 2>&1", pkg);
    if (st == 0) return 1;
    // system() 返回的是 wait 状态而不是退出码：-1=fork/exec 失败；WIFEXITED 假=进程被信号杀死（pm 没跑完）；
    // 退出码 126=无执行权限、127=shell 找不到 pm。这三类都是「命令跑不起来」的环境故障，不是「未安装」。
    if (st == -1 || !WIFEXITED(st) || WEXITSTATUS(st) == 126 || WEXITSTATUS(st) == 127) return -1;
    return 0;   // pm 正常退出且非 0 → 包确实不存在
}

// —— 包安装状态缓存 ——
// 生命周期：进程启动时为空，随本进程（≈一次开机周期）一直有效，不设过期、不做失效机制。
//   理由：包安装状态在一次开机周期内极少变化 —— 用户重装 APK 时包名不变、结论依旧成立；
//   卸载（罕见）最多让缓存多留一条过期结论，也不会导致误拉起（拉起前还有「已安装」与「未运行」两道门）。
//   可清理性：无落盘、无配置项，不需要清理；重启 daemon 或重启设备即回到实时探测。
// 不缓存的情形：无法判定（probe 返回 -1）—— 那是环境故障，缓存住会把故障固化到下次开机。
#define INSTALL_CACHE_SLOTS 3   // 探测链只会问这三个包（老/新 B6X app、farsef），容量取 3
static const char *install_cache_pkg[INSTALL_CACHE_SLOTS];   // 缓存键：包名指针（调用方传入的都是 #define 字面量，静态存储期；若将来传栈上缓冲须改为拷贝）
static int install_cache_val[INSTALL_CACHE_SLOTS];           // 缓存值：1=已确认安装，0=已确认未安装
static time_t install_cache_at[INSTALL_CACHE_SLOTS];         // 结论写入时间（唯一用途：表满时挑最旧一条淘汰）
static int install_cache_used = 0;                           // 已用槽数（0..INSTALL_CACHE_SLOTS）

/** 判断指定包名是否已安装（带缓存：同一包名在一次开机周期内只 fork 一次 pm） */
static int app_installed(const char *pkg) {
    for (int i = 0; i < install_cache_used; i++)
        if (strcmp(install_cache_pkg[i], pkg) == 0) return install_cache_val[i];

    int r = app_installed_probe(pkg);
    if (r < 0) return 0;   // 无法判定：沿用加缓存前的语义按「未安装」返回（由调用方日志暴露），但不写缓存

    int slot = install_cache_used;
    if (slot >= INSTALL_CACHE_SLOTS) {   // 表满：淘汰最旧一条，保证表长有界
        slot = 0;
        for (int i = 1; i < INSTALL_CACHE_SLOTS; i++)
            if (install_cache_at[i] < install_cache_at[slot]) slot = i;
    } else {
        install_cache_used++;
    }
    install_cache_pkg[slot] = pkg;
    install_cache_val[slot] = r;
    install_cache_at[slot]  = time(NULL);
    return r;
}

/**
 * 解析自动拉起的包名：优先 BLE_OWNER_LAST 记录的上次连接者；
 * 目标 B6X app 未安装时回退另一个 B6X app（老 app 未安装→新 app，反之亦然）。
 */
static const char *resolve_launch_pkg(void) {
    const char *pkg;
    if      (last_owner == 2)                     pkg = APP_PKG_B6X_NEW;
    else if (last_owner == 6 || last_owner == 7)  pkg = APP_PKG_B7X;
    else                                          pkg = APP_PKG_B6X_OLD;  // 无记录/老 app
    if (strcmp(pkg, APP_PKG_B6X_OLD) == 0 && !app_installed(pkg) && app_installed(APP_PKG_B6X_NEW)) {
        debug_log(debug_launch, "自动拉起 老 B6X app 未安装，改用新 app");
        pkg = APP_PKG_B6X_NEW;
    } else if (strcmp(pkg, APP_PKG_B6X_NEW) == 0 && !app_installed(pkg) && app_installed(APP_PKG_B6X_OLD)) {
        debug_log(debug_launch, "自动拉起 新 B6X app 未安装，改用老 app");
        pkg = APP_PKG_B6X_OLD;
    }
    return pkg;
}

/** 构建并执行 am start 拉起指定包名（显式组件优先，未知 launcher 回退 -p），返回 system() 退出码 */
static int am_start_app(const char *pkg) {
    // 优先显式组件：这些 app 的 launcher 未导出/非标准 filter，隐式启动解析不到
    // （报 "unable to resolve Intent"），须用显式组件 -n <包名>/<类名>；未知 launcher 回退 -p
    const char *act = NULL;
    if (strcmp(pkg, APP_PKG_B6X_OLD) == 0 || strcmp(pkg, APP_PKG_B6X_NEW) == 0)
        act = "com.example.extool.MainActivity";
    else if (strcmp(pkg, APP_PKG_B7X) == 0)
        act = "com.game.motionelf.activity.ActivityStart";
    char cmd[320];
    if (act)
        snprintf(cmd, sizeof(cmd),
                 AM_BIN " start -n %s/%s --es b6x_auto_launch 1 > /dev/null 2>&1", pkg, act);
    else
        snprintf(cmd, sizeof(cmd),
                 AM_BIN " start -a android.intent.action.MAIN -c android.intent.category.LAUNCHER "
                 "-p %s --es b6x_auto_launch 1 > /dev/null 2>&1", pkg);
    return system(cmd);
}

/**
 * 自动拉起上次使用的散热器 app（带冷却）
 * 包名按 last_owner 选择：2→新 B6X app，6/7→farsef，其余/无记录→老 B6X app；
 * 目标 B6X app 未安装时回退另一个 B6X app。
 * 拉起用 am start（显式 launcher 组件 -n）+ b6x_auto_launch 标志（LSP 读到后连接完成自动后台化，几乎无感）。
 * 仅在 APP_LAUNCH_ENABLED=1 且目标 app 已安装、未运行时执行。
 *
 * @param pkg_known_dead 调用方是否已确认「本轮候选目标进程必定不存在」：
 *   1 = 已确认 —— arbitrate_apps 刚在同一轮用三包合并扫描确认三方 app 全灭，而候选目标必是这三者之一
 *       （resolve_launch_pkg 只会返回 APP_PKG_B6X_OLD/NEW/B7X）。此时内部不再重复一次全量 /proc 扫描。
 *   0 = 无此已知信息（断连分支）→ 内部自行单包扫描。
 */
static void launch_last_app(int pkg_known_dead) {
    time_t now = time(NULL);
    if (now - last_launch_attempt < app_launch_cooldown) return;   // 冷却节流（仅在真正 am start 前记录尝试）
    if (!APP_LAUNCH_ENABLED) {
        debug_log(debug_launch, "自动拉起 开关关闭，跳过");
        return;
    }

    // —— 屏幕门禁 + 息屏退避（APP_LAUNCH_SCREEN_GATE）——
    // 位置前移到最贵的一环（pm 冷启动、全量 /proc 扫描）之前：屏灭时本链注定下发不了（门禁会拦），
    // 却每轮仍要付 1~3 次 pm + 一次全量扫描 + 日志，是断联期探测风暴的主因。
    // 屏幕状态只取一次，退避与门禁共用 —— 屏检一次起 3 个进程，是本链最贵的一环之一，不可为退避再取一次。
    // 门禁关闭时不进本块：那时屏灭也允许下发，退避只会把真实下发推迟最多 10s，且要多付一次屏检。
    if (app_launch_screen_gate_enabled) {
        // 息屏退避闸门（用户拍板 10s）：上次已判定息屏且未到间隔 → 本次连屏检都不做，
        // 不打日志、什么都不做。否则 10s 只能砍掉一行 debug，最贵的屏检照旧每 5s 一次。
        if (last_screen_off && now - last_probe_off_at < APP_LAUNCH_PROBE_OFF_INTERVAL) return;

        int sc = is_screen_awake();
        if (sc == 2) sc = app_launch_screen_dozing_on ? 1 : 0;   // Dozing 按配置是否算亮屏（默认 0=算灭）
        if (sc < 0) sc = 1;                                      // 读取失败一律按可拉起兜底（防探测坏掉后永久不拉起）
        if (sc != 1) {
            // 息屏：记下锚点与「上次已知息屏」，此后每 APP_LAUNCH_PROBE_OFF_INTERVAL 秒只留一次屏检复核
            //（不屏检就永远发现不了屏幕已变亮），中间各轮全部在上一道闸门被挡掉 —— 省掉的是整条链，含屏检。
            // 代价（必须知道，不绕开）：息屏→亮屏最长滞后 APP_LAUNCH_PROBE_OFF_INTERVAL 秒（从前 ≤5s），
            // 故息屏期间若散热器 app 被系统回收，自动拉起最晚 10s 后才开始 —— 这是「息屏 10s」的必然代价。
            last_screen_off = 1;
            last_probe_off_at = now;
            debug_log(debug_launch, "自动拉起 屏幕未亮（mWakefulness 非 Awake），本周期跳过");
            return;
        }
        last_screen_off = 0;   // 屏检确认亮屏（含 -1 兜底）→ 恢复每轮一次屏检，节奏与改动前完全一致
    }

    const char *pkg = resolve_launch_pkg();
    debug_log(debug_launch, "自动拉起 目标 %s（last_owner=%d）", pkg, last_owner);
    if (!app_installed(pkg)) {
        write_log("自动拉起 目标 app 未安装 %s", pkg);
        return;
    }
    if (!pkg_known_dead) {   // 有已知「已全灭」结论时跳过本次单包扫描
        int pkg_alive = 0;
        app_process_scan(&pkg, &pkg_alive, 1);   // 单包扫描（复用合并遍历逻辑）
        if (pkg_alive) {
            debug_log(debug_launch, "自动拉起 目标已在运行 %s，跳过", pkg);
            return;
        }
    }

    last_launch_attempt = now;   // 真正下发 am start 才记冷却，避免屏灭轮询消耗冷却
    int rc = am_start_app(pkg);
    write_log("自动拉起散热器 app %s（后台化）rc=%d", pkg, rc);
}

/** kill 目标散热器 app 并重新拉起（绕过 APP_LAUNCH_ENABLED 开关：本处主动 kill 必须拉起） */
static void force_kill_and_relaunch(void) {
    const char *pkg = resolve_launch_pkg();
    write_log("锁死自动重启 强制停止 %s 并重新拉起", pkg);
    run_cmd_silent(AM_BIN " force-stop %s > /dev/null 2>&1", pkg);
    // 等进程退出（最多 2s）
    for (int i = 0; i < 20; i++) {
        int alive = 0;
        app_process_scan(&pkg, &alive, 1);
        if (!alive) break;
        usleep(100000);
    }
    // 复用自动拉起的显式组件逻辑（b6x_auto_launch 后台化）
    int rc = am_start_app(pkg);
    write_log("锁死自动重启 重新拉起 %s rc=%d", pkg, rc);
}

/**
 * 锁死自动重启检测（watchdog）：每次实际下发制冷变化时判定一次（调用点在 rate_limited_execute 之后、且仅在其返回已下发时）。
 * 双条件都满足才计数：①本周期实际 = 上周期实际（停滞）②本周期实际 ≠ 上周期下发（未达目标），
 * 连续计数 ≥ APP_WATCHDOG 次 → 判定设备锁死/无响应（App 进程内坏状态，重启散热器无效）
 * → 强制重启散热器 app（重建连接栈）。
 * 实际值用 COLD_REAL（status 文件 cooler_cold_real）；上周期下发 = watchdog_last_cmd
 * （上次实际下发后保存的 last_cold，供本周期"未达目标"判定）。
 * 仅 BLE 已连接、实际回传可用、watchdog 开启时启用；kill 后冷却 300s 防风暴。
 */
static void watchdog_check(void) {
    if (app_watchdog_cycles <= 0)      { watchdog_stall_count = 0; return; }  // 关闭
    if (cooler_cold_real < 0)          { watchdog_stall_count = 0; return; }  // 无实际回传不判
    if (last_cold < 0)                 { watchdog_stall_count = 0; return; }  // 从未下发不判
    if (active_device == DEVICE_NONE)  { watchdog_stall_count = 0; return; }  // 无连接设备不判
    // mode=0 不计数：散热器自管理制冷，实际制冷不跟随下发是正常现象；
    // 同时刷新锚点，切回 mode=1 时以最新实际/下发为基准。
    if (last_mode == 0) {
        watchdog_stall_count = 0;
        watchdog_last_cold = cooler_cold_real;
        watchdog_last_cmd  = last_cold;
        return;
    }
    time_t now = time(NULL);

    // 首次锚定：记录上周期实际 + 上周期下发基准，不计数
    if (watchdog_last_cold < 0 || watchdog_last_cmd < 0) {
        watchdog_last_cold = cooler_cold_real;
        watchdog_last_cmd  = last_cold;
        return;
    }
    // kill 冷却期内每周期刷新锚点（防冷却期锚点不更新误判）。
    if (now - watchdog_last_kill_at < 300) {   // kill 冷却：5 分钟内不重复 kill
        watchdog_last_cold = cooler_cold_real;
        watchdog_last_cmd  = last_cold;
        return;
    }
    // 双条件都满足才计数：实际 = 上周期实际（停滞）且 实际 ≠ 上周期下发（未达目标）；
    // 任一不满足 → 清零（实际在变=设备在响应；已达目标=设备正常）
    if (cooler_cold_real == watchdog_last_cold && cooler_cold_real != watchdog_last_cmd) {
        watchdog_stall_count++;
    } else {
        watchdog_stall_count = 0;
    }
    // 更新基准：本次实际/本次下发成为下次判定的"上周期"
    watchdog_last_cold = cooler_cold_real;
    watchdog_last_cmd  = last_cold;

    // 触发：计数 ≥ N 次
    if (watchdog_stall_count >= app_watchdog_cycles) {
        write_log("锁死自动重启 实际制冷 %d 停滞且≠上周期下发 %d 连续 %d 次，kill app 并重新拉起",
                  cooler_cold_real, watchdog_last_cmd, app_watchdog_cycles);
        watchdog_stall_count = 0;
        watchdog_last_kill_at = now;
        force_kill_and_relaunch();
    }
}

/** 淘汰存活参与者：非保留者且非前台时 force-stop（在前台则等下周期再试） */
static void evict_app_if_eligible(int alive, const char *keep, const char *pkg) {
    if (alive && keep != pkg && !is_foreground_pkg(pkg)) {
        write_log("app 仲裁 强制停止 %s（保留 %s）", pkg, keep);
        // 输出重定向到 /dev/null
        run_cmd_silent(AM_BIN " force-stop %s > /dev/null 2>&1", pkg);
    }
}

/**
 * 三方 app 存活仲裁：主循环每 5s 判断、ARBITRATE_INTERVAL 秒节流执行，read_status_ble_both 之后。
 * 老/新 B6X app 始终参与；farsef 只在最近连接的是 B6X 散热器（BLE_OWNER_LAST==6）时参与，
 * 连 B7X 设备（==7）时不参与（控制另一台设备，不应被杀）。
 * 优先保留 BLE_OWNER_LAST 值代表的 app（1→老, 2→新, 6→farsef）；保留者涉及 farsef 时，
 * 与另一方（B6X app）的连接时间比较，保留更晚者。无 last_owner 时回退当前连接者 b6_owner。
 * 被淘汰者非 top-app/foreground 时 am force-stop（在前台则等下一周期）。
 */
static void arbitrate_apps(void) {
    // 单次遍历 /proc 同时检测 3 个包名（合并扫描，不再逐包名全量遍历）
    const char *pkgs[3] = { APP_PKG_B6X_OLD, APP_PKG_B6X_NEW, APP_PKG_B7X };
    int alive[3];
    app_process_scan(pkgs, alive, 3);
    int old_alive = alive[0];
    int new_alive = alive[1];
    int far_alive = alive[2];
    int far_in = far_alive && (last_owner == 6);  // farsef 上次连的是 B6X 散热器才参与

    // 无任何散热器 app 存活 → 自动拉起上次使用的 app（复用下方 keep 的选择逻辑，冷却节流）
    if (old_alive + new_alive + far_alive == 0) {
        // 传 1：上面那次三包合并扫描刚确认三方 app 全灭，候选目标必是这三者之一 → 内部免去重复的全量 /proc 扫描
        launch_last_app(1);
        return;
    }

    if (old_alive + new_alive + far_in < 2) return;  // 只有一个（或没有）存活，无需仲裁

    // 优先保留 BLE_OWNER_LAST 值代表的 app；无记录时回退当前连接者 b6_owner；兜底老 app
    const char *keep = APP_PKG_B6X_OLD;
    if (last_owner == 2) keep = APP_PKG_B6X_NEW;
    else if (last_owner == 1) keep = APP_PKG_B6X_OLD;
    else if (last_owner == 6 && far_alive) keep = APP_PKG_B7X;  // farsef 已死时不得保留它，回退 b6_owner 兜底
    else if (b6_owner == 2) keep = APP_PKG_B6X_NEW;
    else if (b6_owner == 1) keep = APP_PKG_B6X_OLD;

    // 保留者涉及 farsef：与另一方（B6X app）的连接时间比较，保留更晚者。
    // 注意：B6X app 连接事件会同时更新本文件 CONNECTED_AT 与 BLE_OWNER_LAST，
    // 故常规流程下 b6_connected_at 与 b6_last_at 同值、此分支实际不可达；
    // 保留作为对写入方时序不一致 / 旧版 LSP 的防御性兜底。
    if (strcmp(keep, APP_PKG_B7X) == 0 && b6_connected_at > last_owner_at)
        keep = (b6_owner == 2) ? APP_PKG_B6X_NEW : APP_PKG_B6X_OLD;

    // 淘汰其他存活参与者（非前台才 force-stop）
    evict_app_if_eligible(old_alive, keep, APP_PKG_B6X_OLD);
    evict_app_if_eligible(new_alive, keep, APP_PKG_B6X_NEW);
    evict_app_if_eligible(far_in, keep, APP_PKG_B7X);
}

// ======================== 电池温度控制 ========================

/**
 * 紧急退出恢复期阶段推进：冷却周期递减，到期推进 P1→P2→P3→正常。
 * 不受电池温度读取失败影响（battery_control 入口先调用，冷却期也能走完各阶段）。
 */
// Gear 模式（紧急恢复期推进）已随 Gear 删除

// 过冲反补 + 趋势豁免（rev_comp_and_trend）已随 Gear 删除

// 电池温度调档（battery_control）已随 Gear 删除

// ======================== 紧急干预（CPU 温度） ========================

// CPU 温度紧急干预（emergency_intervention）已随 Gear 删除

// ======================== 电流-挡位映射 + 温度调整融合 ========================

// 电流-挡位映射 + 温度融合（gear_from_current）已随 Gear 删除

// ======================== PID 方差门控 ========================

/**
 * 推入方差采样（对齐 PID 计算时机）。
 * @param value 原始电池温度（0.1°C）——固定推原始值，不做滤波/预测
 * @param cycle 当前控制周期计数（pid_ctrl_cycles）
 * 两次推入间若有周期被跳过（无滤波跳过周期不推入），在缺档处线性插值补样本，
 * 保证方差窗口覆盖连续控制周期，反映真实温度变化率。
 */
// PID 方差门控（pid_var_push / pid_var_compute）已随补丁删除

// Gear 温度预测（gear_predict_push / gear_predict_compute）已随 Gear 删除

// ======================== 输入补偿 ========================

/**
 * CPU 补偿值（0.1°C）：comp=(cpu滤波温度 − 电池 − 偏移)/divisor，clamp≥0，
 * 再按补偿专属滤波系数 EMA 平滑（首次上次值用 0，从 0 平滑爬升而非直取）。
 * 门控滞回：条件满足（raw>0）进入补偿；条件消失（raw=0）后不立即退出，
 * 平滑值归零后才关闭补偿
 * 始终生效，无开关（门控由条件自触发）。
 * @param batt 当前电池温度（0.1°C，用原始电池温度口径）
 */
static int cpu_comp_now(int batt) {
    if (cpu_filtered_temp < 0) return 0;
    float raw = (float)(cpu_filtered_temp - batt - pid_cpu_comp_offset) / (pid_cpu_comp_divisor * 10);
    if (raw < 0.0f) raw = 0.0f;
    // 进入门控：条件满足（CPU 高于电池+偏移，raw>0）→ 激活补偿
    if (raw > 0.0f) pid_cpu_comp_active = 1;
    // 未激活（从未满足条件，或已归零退出）→ 无补偿输出
    if (!pid_cpu_comp_active) return 0;
    // 首次滤波：上次值使用 0（从 0 开始 EMA 爬升，而非直接取 raw 首值跳变）
    float prev = pid_cpu_comp_ready ? pid_cpu_comp_smooth : 0.0f;
    pid_cpu_comp_smooth = (pid_cpu_comp_filter_alpha * raw +
                          (100 - pid_cpu_comp_filter_alpha) * prev) / 100.0f;
    pid_cpu_comp_ready = 1;
    // 退出门控：滤波值归零才退出（raw=0 时 EMA 使平滑值渐进收敛，不瞬间切断）
    if (pid_cpu_comp_smooth <= 0.0001f) {
        pid_cpu_comp_active = 0;
        pid_cpu_comp_smooth = 0.0f;
    }
    return (int)(pid_cpu_comp_smooth * 10 + 0.5f);
}

// ======================== 逻辑2：冷值动态倍率 ========================
// 冷值（上次 PID 重算算出的目标制冷强度 pid_align_cold）→ 抽象值 s ∈ [−1,0]（两段线性 + 两端平台）
// → 统一指数映射得倍率（只降不升）→ 三个作用点各乘权重：KDP / KI 升速率 / KI 降速率。
// 更新门控与 pid_kdp 一致（温度窗口变化才重算）；两次重算之间沿用同一取样值。
// 单位：冷值三点为码；输出轴拐点值 / 权重 / U / γ 为配置整数（×100），内部按浮点算。

/**
 * 归一化辅助：v ≤ base → 0；den ≤ 0（配置乱序，纯钳位不拦）→ 1。
 * den ≤ 0 分支即除零保护，保证任何配置下 s 都落在 [−1,0]、不产生 NaN/Inf。
 */
static inline float cold_dyn_t(int v, int base, int den) {
    if (v <= base) return 0.0f;
    if (den <= 0)  return 1.0f;
    return clampf((float)(v - base) / (float)den, 0.0f, 1.0f);
}

/** 冷值（码）→ 抽象值 s ∈ [−1,0]：两段线性 + 两端平台（下界以下 0、上界以上 −1） */
static float cold_dyn_abs(int cold) {
    float om = cold_dyn_out_mid_p100 * 0.01f;   // 输出轴拐点值（正数）→ 拐点处降幅
    float s;
    if (cold <= cold_dyn_in_mid)
        s = -om * cold_dyn_t(cold, cold_dyn_in_lo, cold_dyn_in_mid - cold_dyn_in_lo);
    else
        s = -om - (1.0f - om) * cold_dyn_t(cold, cold_dyn_in_mid, cold_dyn_in_hi - cold_dyn_in_mid);
    return clampf(s, -1.0f, 0.0f);
}

/** 抽象值 → 倍率 U^(−(−s)^γ)，取整三位小数（s = 0 → 1.0；s = −1 → 1/U） */
static float cold_dyn_map(float s) {
    if (s >= 0.0f) return 1.0f;                 // 不干预
    float u = cold_dyn_u_p100 * 0.01f;
    float g = cold_dyn_gamma_p100 * 0.01f;
    return roundf(powf(u, -powf(-s, g)) * 1000.0f) / 1000.0f;
}

/** 重算：取样冷值 → 抽象值 → 三作用点（各乘权重、钳 [−1,0]、映射），并打诊断日志 */
static void cold_dyn_update(int cold) {
    cold_dyn_s = cold_dyn_abs(cold);
    float sk = clampf(cold_dyn_s * (cold_dyn_w_kdp_p100 * 0.01f), -1.0f, 0.0f);
    float su = clampf(cold_dyn_s * (cold_dyn_w_up_p100  * 0.01f), -1.0f, 0.0f);
    float sd = clampf(cold_dyn_s * (cold_dyn_w_dn_p100  * 0.01f), -1.0f, 0.0f);
    cold_dyn_mult_kdp = cold_dyn_map(sk);
    cold_dyn_mult_up  = cold_dyn_map(su);
    cold_dyn_mult_dn  = cold_dyn_map(sd);
    pid_log("冷值动态 in=%d om=%.2f s=%.3f | 加权 sk=%.3f su=%.3f sd=%.3f | 倍率 rkdp=%.3f rup=%.3f rdn=%.3f",
            cold, cold_dyn_out_mid_p100 * 0.01f, cold_dyn_s, sk, su, sd,
            cold_dyn_mult_kdp, cold_dyn_mult_up, cold_dyn_mult_dn);
}

/** 复位为「不干预」：抽象值 0、三倍率 1.0（启动 / 长断连复位） */
static void cold_dyn_reset(void) {
    cold_dyn_s = 0.0f;
    cold_dyn_mult_kdp = 1.0f;
    cold_dyn_mult_up  = 1.0f;
    cold_dyn_mult_dn  = 1.0f;
}

// ======================== PID 控制函数 ========================

/**
 * 速度非线性映射（v → v'）：小幅速度按幂曲线降权，幅度到位后严格恒等。
 * - 阈值 L = PID_SPEED_NL_THR/100（°C/周期）、强度 q = PID_SPEED_NL_EXP/100。
 * - |v| ≥ L → 输出 = v（恒等，1:1，无恒定偏置）。
 * - |v| < L → t = |v|/L；s = t²(3−2t)（平滑阶跃）；输出 = sign(v)·|v|·s^q。
 * 性质：保号（奇函数）、处处 |输出| ≤ |v|、随 |v| 单调不减、v = ±L 处连续（s=1、s^q=1）。
 * 护栏：v = 0 → 0（避开 0^0）；q = 0 → 位精确恒等（完全线性）；L ≤ 0（手改配置）→ 恒等，不除零。
 */
static float pid_spd_nl_map(float v) {
    if (v == 0.0f) return 0.0f;                  // 护栏①：0 无符号，直接 0
    if (pid_spd_nl_exp_p100 == 0) return v;      // 护栏②：q=0 → 完全线性，位精确恒等
    float l = pid_spd_nl_thr_p100 / 100.0f;
    if (l <= 0.0f) return v;                     // 护栏③：阈值非法 → 恒等，不除零
    float a = (v < 0.0f) ? -v : v;               // |v|
    if (a >= l) return v;                        // |v| ≥ L：严格恒等
    float t = a / l;
    float s = t * t * (3.0f - 2.0f * t);         // 平滑阶跃 ∈ (0,1)
    return (v < 0.0f ? -a : a) * powf(s, pid_spd_nl_exp_p100 / 100.0f);   // sign(v)·|v|·s^q
}

/**
 * PID 计算（单累积器）：OUTPUT = clamp(acc + kdp, 0, 1)。
 * - error 为纯电池误差（不含 CPU 补偿）；cpu_comp 与速度同地位，算 ch 时加入。
 * - 速度 v = (error − 上次error)/dt（倍率系数缩放，不乘 dt）。
 * - 速度非线性映射（pid_spd_nl_map）：|v| ≥ L 严格恒等（1:1）、|v| < L 按「平滑阶跃的幂」降权，
 *   保号且 |输出| ≤ |v|；L/q 见 PID_SPEED_NL_THR / PID_SPEED_NL_EXP。
 *   回溯注入的 v（recall_on）与常规 v 汇聚到同一处映射，各恰好施加一次，映射后的 v 共用给 ch 与 ch_kdp。
 * - ch 用于积分（acc += ki_rate×(ch − target_f)，ki_rate 按被积项符号取升/降速率），ch_kdp 用于 KDP（速度按 0.33 衰减，无记忆）。
 * - 动态目标 target_f（EMA 平滑），使积分逼近"误差×目标系数"包络，防静态过冲。
 * - 逻辑2 冷值动态倍率（cold_dyn_*）：重算门控与 kdp 同处（温度窗口变化），三倍率分别作用于 kdp / KI 升 / KI 降。
 * - 温度未变（batt_window_changed=0）时 kdp 沿用上次值（跳过①），避免补偿突变带动 KDP 跳变。
 * @param batt_10  原始电池温度（0.1°C，纯电池，不含补偿）
 * @param dt       距上次重算以来的 5 秒周期数（钳位 0.6~6，1 = 5s）
 * @param cpu_comp CPU 补偿（°C，已 EMA 平滑）
 * @param batt_window_changed 本周期温度窗口是否变化（0=温度未变，kdp 沿用）
 * @return 归一化输出 0.0~1.0
 */
static float pid_compute(int batt_10, float dt, float cpu_comp, int batt_window_changed, int recall_on, float recall_v) {
    // 输入误差（纯电池）
    float error = (batt_10 - BATT_BASELINE) / 10.0f;

    // 速度项（°C/周期）：首次重算（无常值历史）时 v=0；温度未变时用回溯速度（recall_on，item4）
    float v = 0.0f;
    if (recall_on)
        v = recall_v;
    else if (pid_last_change_time != 0)
        v = (error - pid_last_error) / dt;
    pid_last_error = error;

    // 速度非线性映射：差分 v 与回溯注入 v 的唯一映射点（各恰好施加一次）
    v = pid_spd_nl_map(v);

    // ch（受控量，用于积分）与 ch_kdp（用于 KDP，速度按 0.33 衰减）
    float sc = pid_speed_coef / 10.0f;
    float ch    = error + v * sc + cpu_comp;
    float chkdp = error + v * sc * 0.33f + cpu_comp;

    // 动态目标（EMA）：raw_target = clamp(error×目标系数, ±目标上限)
    float raw_target = error * (pid_target_coef / 1000.0f);
    float tmax = pid_target_max / 10.0f;   // 0.1°C → °C
    if (raw_target >  tmax) raw_target =  tmax;
    if (raw_target < -tmax) raw_target = -tmax;
    // 动态目标 EMA（item2 方向性滤波）：远离基线加快(away)，回归基线减慢(toward)
    {
        float ta = pid_target_alpha / 100.0f;
        if (pid_target_dir_on) {
            float ra = (raw_target < 0.0f) ? -raw_target : raw_target;
            float tf = (pid_target_f  < 0.0f) ? -pid_target_f  : pid_target_f;
            ta = (ra > tf) ? (pid_target_away_alpha / 100.0f) : (pid_target_toward_alpha / 100.0f);
        }
        pid_target_f += ta * (raw_target - pid_target_f);
    }

    // 逻辑2 冷值动态倍率重算：门控与下面的 KDP 一致（温度窗口变化），
    // 取样 = 上次重算算出的目标冷值 pid_align_cold；本轮三倍率同时供 KI 与 KDP 使用。
    if (batt_window_changed)
        cold_dyn_update(pid_align_cold);

    // 积分累积（acc；不乘 dt）：被积项为正走升速率、为负走降速率，各自乘逻辑2 对应倍率
    {
        float integrand = ch - pid_target_f;
        float ki_rate = (integrand >= 0.0f) ? pid_ki_up_coef * cold_dyn_mult_up
                                            : pid_ki_down_coef * cold_dyn_mult_dn;
        pid_ki += (ki_rate / 1000.0f) * integrand;
    }

    // KDP（融合 P+D）：温度变了才更新；温度未变沿用上次值（跳过①）
    if (batt_window_changed)
        pid_kdp = (pid_kdp_coef / 1000.0f) * chkdp * cold_dyn_mult_kdp;

    // 预算钳制：acc ≥0 且 ≤ max(0, 1−kdp)（防 acc+kdp 超 1 被末端硬截断，即抗 windup）
    float budget = 1.0f - pid_kdp;
    if (budget < 0.0f) budget = 0.0f;
    if (pid_ki > budget) pid_ki = budget;
    if (pid_ki < 0.0f)   pid_ki = 0.0f;

    pid_last_ch = ch;

    // 钳位 0~1
    float out = pid_ki + pid_kdp;
    if (out < 0.0f) out = 0.0f;
    if (out > 1.0f) out = 1.0f;

    pid_log("e=%.2f v=%.2f ch=%.2f tgt=%.2f ki=%.2f kdp=%.2f out=%.2f win=%d",
            error, v, ch, pid_target_f, pid_ki, pid_kdp, out, batt_window_changed);
    return out;
}

/**
 * 热端温度线性映射 + EMA 平滑 + 双向滞回：无上下限，低于 HOT_RPM_MAP 最低温度或高于最高温度时线性外推
 * 最终钳制在下发阶段（apply_gear_direct 内部）
 *
 * 平滑：输入先经 MAP_INPUT_SMOOTH_ALPHA EMA 平滑（与冷端共用系数）
 * 滞回（基于平滑后的值）：
 *   降温（hot_s < prev_hot）→ 有效温度 = 实际 + 1°C，钳位 ≤ 上次 RPM
 *   升温（hot_s > prev_hot）→ 正常映射，但 RPM 不低于上次值
 *   平滑值不变             → 保持上次输出
 */
static int rpm_from_hot_end(int hot_10) {
    static int prev_hot = -1;   // 上一轮平滑后的温度
    static int prev_rpm = 0;
    if (hot_10 <= 0) {
        debug_log(debug_exec, "rpm 热端 ≤0（%d），保持上次 %d", hot_10, prev_rpm);
        return prev_rpm;   // 热端 ≤0（异常/未就绪）时保持上次输出
    }
    int range = hot_map_max - hot_map_min;
    if (range <= 0) return 0;

    // EMA 平滑输入温度（首次直取）
    int hot_s;
    if (prev_hot < 0) {
        hot_s = hot_10;
    } else {
        hot_s = EMA_DIR(hot_10, prev_hot, rpm_smooth_alpha);
    }

    // 平滑后温度不变 → 保持上次输出
    if (hot_s == prev_hot)
        return prev_rpm;

    int eff_hot;
    if (hot_s < prev_hot) {
        // 降温滞回：有效温度 = 平滑值 + 1°C（0.1°C*10），使 RPM 滞后下降
        eff_hot = hot_s + 10;
        if (eff_hot > hot_map_max) eff_hot = hot_map_max;
    } else {
        // 升温或首次 → 直通
        eff_hot = hot_s;
    }

    float t = (float)(eff_hot - hot_map_min) / range;
    int rpm = fan_rpm_min + (int)(t * (active_fan_max - fan_rpm_min));

    // 双向钳位（基于平滑值）
    if (prev_hot >= 0) {
        if (hot_s < prev_hot && rpm > prev_rpm) rpm = prev_rpm;  // 降温 ≥ 上次（滞回 +10 不超限）
        if (hot_s > prev_hot && rpm < prev_rpm) rpm = prev_rpm;  // 升温 ≥ 上次时保持或不降
    }

    prev_hot = hot_s;
    prev_rpm = rpm;
    debug_log(debug_exec, "rpm 热端 hot=%d(平滑%d) → %d", hot_10, hot_s, rpm);
    return rpm;
}

/**
 * 冷强度指数映射：n^exp，无上下限
 * cold < cold_map_start 时线性外推下限（powf 负数底数→NaN）
 * 输入（制冷强度）先经 MAP_INPUT_SMOOTH_ALPHA EMA 平滑（与热端映射共用系数，首次直取）
 * 最终钳制在下发阶段（apply_gear_direct 内部）
 */
static int rpm_from_cold_exp(int cold) {
    static int cold_in_smoothed = -1;   // 输入侧 EMA 平滑后的制冷强度
    int range = active_pid_cold_max - cold_map_start;
    if (range <= 0) return 0;

    // 输入侧 EMA 平滑：平滑制冷强度本身，映射后再无输出滤波
    if (cold_in_smoothed < 0) {
        cold_in_smoothed = cold;
    } else {
        cold_in_smoothed = EMA_DIR(cold, cold_in_smoothed, rpm_smooth_alpha);
    }
    int cold_s = cold_in_smoothed;

    float n = (float)(cold_s - cold_map_start) / range;
    int rpm;
    if (n < 0.0f)
        rpm = fan_rpm_min + (int)(n * (active_fan_max - fan_rpm_min));
    else {
        float n_exp = powf(n, cold_map_exp / 100.0f);
        rpm = fan_rpm_min + (int)(n_exp * (active_fan_max - fan_rpm_min));
    }
    debug_log(debug_exec, "rpm 冷端 exp cold=%d(平滑%d) → %d", cold, cold_s, rpm);
    return rpm;
}

/**
 * 独立风扇目标计算：冷端指数映射（基于限速后实际制冷）+ 热端线性映射加权合并。
 * 与 PID 输出解耦：每周期下发前由 rate_limited_execute 单独调用。
 */
static int compute_fan_target(void) {
    int rpm_cold = rpm_from_cold_exp(actual_cold);
    int rpm = rpm_cold;
    if (cooler_hot_temp >= 0) {   // 热端 ≤0（0=异常 0°）也进入，由 rpm_from_hot_end 保持上次值
        // 自加权合并：各以自身 RPM 为权重，权重钳制到设备范围
        int rpm_hot = rpm_from_hot_end(cooler_hot_temp);
        if (rpm_hot > 0) {
            int w_hot  = clamp(rpm_hot,  fan_rpm_min, active_fan_max);
            int w_cold = clamp(rpm_cold, fan_rpm_min, active_fan_max);
            rpm = (w_hot * rpm_hot + w_cold * rpm_cold) / (w_hot + w_cold);
        }
    }
    debug_log(debug_exec, "rpm 目标 冷端=%d 热端=%d → %d", rpm_cold, cooler_hot_temp, rpm);
    return rpm;
}

/**
 * 直接下发 AT 广播（PID 模式使用）
 * 通过 should_skip_dispatch 用 last_* 缓存去重
 * 返回 1=已发送，0=跳过（无变化）
 */
static int apply_gear_direct(int mode, int target,
                               int send_rpm, int cold, int wl) {
    // 纯下发：制冷限速与风扇目标已由 rate_limited_execute 完成，此处只去重/日志/广播

    // ---- 热端过温边界钳制（去重前生效；不同步 actual_cold，风扇由 actual_cold 推算保持高转速散热）----
    int cold_pre_clamp = cold;
    if (hot_derate > 0) {
        int cold_cap = active_cold_eff_max;
        if (cold > cold_cap) cold = cold_cap;
    }

    // ---- 去重检测 + 制冷变化死区（以散热器实际回传为准）----
    if (should_skip_dispatch(mode, target, send_rpm, cold, wl)) {
        debug_log(debug_exec, "apply_gear_direct 跳过下发（目标冷%d RPM%d == 回传冷%d RPM%d）",
                  cold, send_rpm, cooler_cold_real, cooler_rpm_real);
        return 0;
    }

    // 过热钳制冷动作日志（仅在实际下发时输出，与去重判定一致）
    if (cold < cold_pre_clamp)
        write_log("过热钳制冷 %d→%d（削减量 %d）", cold_pre_clamp, cold, hot_derate);

    // 偏差 = (原始电池温度 + 补偿) - 目标温度
    int batt_10 = (cached_batt_raw >= 0) ? cached_batt_raw : BATT_BASELINE;
    int dev_10 = batt_10 + pid_last_comp_10 - BATT_BASELINE;
    int hot_deg = (cooler_hot_temp > 0) ? cooler_hot_temp / 10 : 0;
    write_log("%d%+.1f° %s 冷%d 热%d° RPM%d",
              BATT_BASELINE / 10, dev_10 / 10.0f,
              device_tag_of(active_device),
              cold, hot_deg, send_rpm);
    send_am_broadcast(mode, target, send_rpm, cold, wl);

    last_bcast_valid   = 1;
    last_mode          = mode;
    last_target_temp   = target;
    last_rpm           = send_rpm;
    last_cold          = cold;
    last_wind_level    = wl;
    return 1;
}

/**
 * 重置 PID 核心状态（积分、误差、滤波、补偿）
 * 不同场景的调用者在此基础上附加各自的额外重置逻辑
 */
static void pid_reset_core(void) {
    pid_ki = 0.0f;
    pid_kdp = 0.0f;
    pid_target_f = 0.0f;
    pid_last_error = 0.0f;
    pid_last_ch = 0.0f;
    pid_last_change_time = 0;
    pid_cpu_comp_smooth = 0.0f;
    pid_last_comp_10 = 0;
    pid_cpu_comp_ready = 0;
    pid_cpu_comp_active = 0;
    pid_batt_filtered = -1;          // 电池输入滤波重置（改动2；重连/启动后直取初值）
    pid_batt_last_update_cycle = -1;
    pid_batt_snap_done = 0;
    recall_anchor = 0;
    recall_prev_batt = 0;
    recall_cycles = 0;
    cold_dyn_reset();
}

// Gear 模式切换对齐（pid_align_from_gear）已随 Gear 删除

/**
 * 按制冷强度参考值对齐 PID 初始输出。
 * @param cold_ref 制冷强度参考值（LSP 回传实际值，低于 pid_cold_min 时已由调用方兜底）
 * @param cold_max 参考值对应的制冷上限（active_pid_cold_max）
 * @return 对齐比例（0~1），用于映射制冷强度
 */
static float pid_ratio_from_cold(int cold_ref, int cold_max) {
    // 除数保护：cold_max == pid_cold_min 时按 1 处理
    int span = cold_max - pid_cold_min;
    if (span < 1) span = 1;
    float ratio = (float)(cold_ref - pid_cold_min) / span;
    if (ratio < 0.0f) ratio = 0.0f;
    if (ratio > 1.0f) ratio = 1.0f;
    pid_align_cold = cold_ref;
    pid_align_rpm  = fan_rpm_min + (int)(ratio * (active_fan_max - fan_rpm_min));
    return ratio;
}

// ======================== 宿主 APK 卸载自清理 ========================
// 需求：本 APK 被卸载后，daemon 必须自己停止并把落盘产物删干净（连二进制与 service.d 脚本一起删）。
// 代价（用户已拍板）：重装 APK 后必须重新「一键部署」——这是设计意图，不是缺陷。
// 落点分工：C 端为主（5s 节拍、root、能删 /data/local/tmp · /data/adb · /cache），
// service.d 脚本看门狗兜底（能删自己，覆盖「daemon 已死但脚本还在」「启动后 30s 延迟窗口」
// 「C 端被 SELinux 拒删 /data/adb」三类）。判据与清理清单两侧必须保持一致，改一处同步另一处。

#define HOST_PKG             "com.example.waspwingtempctrl"
#define HOST_DATA_DIR        "/data/data/" HOST_PKG
// 需与 PRIVATE_DIR 的包名一致（applicationId 决定数据目录名，改包名时两处连同 build.gradle.kts 一起改）
#define HOST_PROBE_INTERVAL  60   // 二级 pm 探测最小间隔（秒）：fork+pm 约 100~300ms，不许每轮跑
#define HOST_CONFIRM_HITS    2    // 连续一级命中次数阈值，避免瞬态误判误杀

static int    host_miss_hits = 0;    // 一级（父目录不存在）连续命中次数
static time_t host_probe_at  = 0;    // 上次二级（pm path）探测时间戳
static int    host_probe_gone = 0;   // 上次二级探测结论：1=包已不注册（节流窗口内复用）

/**
 * 判断宿主 APK 是否已卸载。返回 1=确认已卸载（可清理），0=仍在 / 无法确认。
 *
 * 两级判据，必须都过：
 *   一级 stat(HOST_DATA_DIR) —— 用【父目录】而非 files/：app「清除数据」只清 contents
 *     （files/ 内容），父目录 /data/data/<包名> 由系统保留 → 可抗"清除数据"误判。
 *     该代价已记录在 逻辑说明.md 的「参数落点」注记处（清除数据会清掉私有目录产物）。
 *     每轮可跑、零成本。
 *   二级 app_installed_probe(HOST_PKG)（走 pm path，实时不缓存）—— 一级命中后才跑，且按 HOST_PROBE_INTERVAL
 *     节流（fork+exec pm 的开销不能进每轮热路径）。
 * 再叠「连续 HOST_CONFIRM_HITS 次命中才判真」：单次 stat 失败可能来自瞬时挂载抖动、
 * app 正在被 installd 重装（目录短暂消失）等瞬态，连续两次（间隔 ≥5s 一轮）可滤掉。
 */
static int host_app_uninstalled(void) {
    struct stat st;
    if (stat(HOST_DATA_DIR, &st) == 0) {
        host_miss_hits = 0;   // 父目录在 → 未卸载，计数清零（下次命中重新从 1 数起）
        return 0;
    }

    // 一级命中：父目录不存在。二级 pm 确认（节流窗口内复用上次结论）
    time_t now = time(NULL);
    if (now - host_probe_at >= HOST_PROBE_INTERVAL) {
        host_probe_at = now;
        // 走实时探测而非缓存版：卸载自清理需要在同一次开机内看到安装状态变化，缓存对它只有风险没有收益
        // （本处自带 HOST_PROBE_INTERVAL 节流，不在热路径上）。「== 1」与加缓存前的 app_installed() 真值等价：
        // 无法判定（命令跑不起来）时同样按「已不注册」处理，由连续 HOST_CONFIRM_HITS 次命中叠加过滤瞬态。
        host_probe_gone = (app_installed_probe(HOST_PKG) == 1) ? 0 : 1;
    }
    if (!host_probe_gone) {
        // 目录不在但包仍注册（重装过程中、多用户数据目录尚未创建等）→ 不判真
        host_miss_hits = 0;
        return 0;
    }

    if (++host_miss_hits < HOST_CONFIRM_HITS) return 0;
    return 1;
}

/**
 * 检测到宿主 APK 已卸载 → 清理全部落盘产物并置 running=0（走既有 exit: 收尾）。
 * 用 read_self_exe() 取自身实测路径再 unlink，防二进制被改名/换路径后按约定路径漏删。
 *
 * 清理范围与**已知局限**（如实记录，不假装清干净了）：
 *   1) /data/local/tmp/tempctrl_b6x.status 与 tempctrl_b7x.status —— 只要飞智 app 进程还活着，
 *      其 LSPosed 钩子会每秒重写这两个文件，本处 unlink 之后可能被立刻重建。
 *      只有重启飞智 app 或重启设备，这两个文件才会彻底消失。**此处删不干净是已知局限。**
 *   2) 私有目录（profile.conf / tempctrl.log / tempctrl_webui.data / tempctrl.lock）不显式删：
 *      系统卸载会连带删掉整个 /data/data/<包名>，显式删只是多一条可能被 SELinux 拒的路径。
 *      与工程既有「卸载部署 ≠ 删配置」口径一致（不显式删 profile.conf）。
 *   3) /data/adb 下脚本能否 unlink 取决于 daemon 所在 SELinux 域：由 service.d 拉起时继承
 *      magisk 域一般可写，app 内 nohup 拉起则可能被拒。被拒时由脚本看门狗自尽兜底，
 *      故此处按"尽力而为"处理：失败不重试、不报错（用户已卸载，无人看 stderr）。
 */
static void cleanup_artifacts_on_uninstall(void) {
    // 先留痕再删（日志文件本身随后可能被一起删掉，但这正是"清理"的预期结果）
    write_log("检测到宿主 APK 已卸载，已清理产物并退出");

    // 自身二进制：实测路径优先（read_self_exe 走 /proc/self/exe），约定路径兜底
    char self[512];
    if (read_self_exe(self, sizeof(self))) unlink(self);
    unlink("/data/local/tmp/tempctrl");

    static const char *artifacts[] = {
        // /data/local/tmp 下的全部产物
        "/data/local/tmp/tempctrl_b6x.status",
        "/data/local/tmp/tempctrl_b7x.status",
        "/data/local/tmp/tempctrl_uiprefs",
        "/data/local/tmp/tempctrl_service.log",
        "/data/local/tmp/tempctrl.lock",       // 旧版残留（现锁文件已移至私有目录）
        "/data/local/tmp/tempctrl_last_dev",   // 旧版残留
        // service.d 脚本两个候选路径（KSU 版本分界，见 Deployer）
        "/data/adb/service.d/b6x-tempctrl.sh",
        "/data/adb/ksu/service.d/b6x-tempctrl.sh",
        // 私有目录不可用时的兜底日志
        "/cache/tempctrl.log",
    };
    for (size_t i = 0; i < sizeof(artifacts) / sizeof(artifacts[0]); i++) unlink(artifacts[i]);

    running = 0;   // 交给 main 的 exit: 收尾（关闭日志句柄后返回 0）
}

// ======================== 主循环 ========================

/** 信号处理器：设置 running=0 退出主循环 */
static void handle_signal(int sig) {
    (void)sig;
    running = 0;
}

/** 闹钟处理器：仅用于中断 waitpid，不做实际处理 */
static void alarm_handler(int sig) {
    (void)sig;  // 仅用于中断 waitpid，不做事
}

/** 记录最近一次断联时间戳（重连汇总行用；0=未处于断联） */
static time_t last_disconnect_time = 0;

/**
 * 对齐实际制冷/转速到散热器真实回传（启动/长断连重置后"待对齐"时调用）。
 * 仅当 report_ok（连续 REPORT_OK_N 帧真实回传）才对齐；超时（ALIGN_WAIT_TIMEOUT 秒）
 * 用保守值起步，防止回传长期缺失（旧机型）导致永久停摆。
 * @return 1=本次对齐完成（可强制下发），0=仍待对齐
 */
static int try_align_actual(void) {
    if (!pending_align) return 0;
    if (report_ok) {
        actual_cold = (cooler_cold_real >= COLD_MIN) ? cooler_cold_real : pid_cold_min;
        actual_rpm = (cooler_rpm_real >= fan_rpm_min) ? cooler_rpm_real : fan_rpm_min;
        write_log("回传就绪对齐 冷=%d rpm=%d", actual_cold, actual_rpm);
        pending_align = 0;
        return 1;
    }
    if (pending_align_since > 0 && time(NULL) - pending_align_since >= ALIGN_WAIT_TIMEOUT) {
        actual_cold = pid_cold_min;
        actual_rpm = fan_rpm_min;
        write_log("回传超时（>%ds）未就绪，用保守值起步 冷=%d rpm=%d",
                  ALIGN_WAIT_TIMEOUT, actual_cold, actual_rpm);
        pending_align = 0;
        return 1;
    }
    return 0;
}

/**
 * 重连安全对齐：以散热器实际回传值为准初始化实际制冷/转速，
 * 由 rate_limited_execute 按正常限速逐步调节，抑制重连突变。
 * 此处不立即下发（分段执行）。
 *
 * 改动：不直接用瞬时 cooler_cold_real 覆盖 actual_cold——重连瞬间 lastWaspWingInfo
 * 未就绪，COLD_REAL 可能缺失(-1)或设备未下发前回占位 1，拿它初始化会被兜底成 1，
 * 且后续快速限速一步拉到 PID 目标（125/4500）。改为：长断连由 try_align_actual 等
 * 真实回传就绪后对齐；短断连保留 PID 状态、沿用内存实际值（断联期间未被改仍准确）。
 */
static void reconnect_align(void) {
    // 清空温度窗口累积标志
    batt_changed_since_ctrl = 0;
    batt_window_changed = 0;

    // 断联→重连汇总行（常驻）：断联时长 + 重连后散热器回传实际值
    int discon_sec = 0;
    if (last_disconnect_time > 0) {
        discon_sec = (int)(time(NULL) - last_disconnect_time);
        write_log("重连 断联%d秒 回传冷%d RPM%d",
                  discon_sec, cooler_cold_real, cooler_rpm_real);
        last_disconnect_time = 0;
    }

    // 断联 < reconnect_keep_cycles 个控制周期(×5s)：短断联保留 PID 状态（积分/误差），
    // 沿用内存实际值（断联期间 actual_cold 未被改，仍是最下发值）；长断联则完整重置并进入待对齐。
    if (discon_sec > 0) {
        if (reconnect_keep_cycles > 0 && discon_sec < reconnect_keep_cycles * 5) {
            write_log("重连 断联%d秒<%d周期，保留 PID 状态", discon_sec, reconnect_keep_cycles);
        } else {
            // 重置 PID 状态；不立即用回传覆盖 actual_cold，等真实回传就绪后由 try_align_actual 对齐。
            pid_reset_core();
            actual_cold = -1;      // 未就绪：不设兜底基线，避免被 COLD_MIN=1 吞掉真实起步值
            actual_rpm = -1;
            pending_align = 1;
            pending_align_since = time(NULL);
            write_log("重连 PID 状态已重置，进入待对齐（等待真实回传）");
            first_run = 1;
        }
    }
}

/**
 * 速率限制执行：返回 1=实际下发了制冷变化，0=跳过（无变化/去重）。
 * 输出端滤波 → 制冷限速 → 独立风扇计算（不跟 PID 输出）→ 风扇限速 → 纯下发
 */
static int rate_limited_execute(void) {
    // 实际值未就绪（启动/长断连后待对齐期间 actual_cold=-1）：不强制下发，避免用无效/兜底值起步。
    if (actual_cold < COLD_MIN || actual_rpm < fan_rpm_min) {
        debug_log(debug_exec, "实际值未就绪（冷%d rpm%d），跳过下发", actual_cold, actual_rpm);
        return 0;
    }
    rate_limit_cold(pid_align_cold);
    int send_rpm = rate_limit_fan(compute_fan_target());
    return apply_gear_direct(1, 5, send_rpm, actual_cold, 0);
}

/**
 * PID 模式控制周期（每 5s）：CPU 补偿 → 两条跳过判定 → PID 计算 → 映射制冷。
 * 输入用原始电池温度（无滤波），重算由温度窗口变化或补偿变化门控。
 */
static void pid_cycle(void) {
    time_t now = time(NULL);
    pid_ctrl_cycles++;               // 单调周期计数
    int batt_raw = cached_batt_raw;   // 1s 采集缓存
    if (batt_raw < 0) return;

    // --- 无变化回溯锚点（item4）：温度窗口变化→锚点=变化前值+重置周期；未变→周期计数++ ---
    if (batt_window_changed) {
        recall_anchor  = recall_prev_batt;
        recall_cycles  = 1;
    } else {
        recall_cycles++;
    }
    recall_prev_batt = batt_raw;

    // --- CPU 温度读入与滤波（用于补偿） ---
    int cpu_now = cached_cpu_now;   // 1s 采集缓存
    update_cpu_filtered(cpu_now);

    // --- CPU 补偿值计算（始终生效，原始电池温度口径；cpu_comp_now 内部 EMA 平滑） ---
    int total_comp_10 = cpu_comp_now(batt_raw);
    float cpu_comp = total_comp_10 / 10.0f;   // 日志用（0.1°C → °C）

    // --- 电池温度输入滤波（改动2：加回；仅温度更新时滤波并输出，动态 α） ---
    // 首启直取；此后仅温度窗口变化（值/mtime 变）时滤波；动态 α=0.2+0.05×间隔周期数（5s控制周期）。
    if (pid_batt_filtered < 0) {
        pid_batt_filtered = batt_raw;
        pid_batt_last_update_cycle = pid_ctrl_cycles;
    } else if (batt_window_changed) {
        int interval = clamp(pid_ctrl_cycles - pid_batt_last_update_cycle, 0, 16);   // 钳 0~16 → α 0.2~1.0（1.0=不滤波）
        float alpha = 0.2f + 0.05f * interval;
        pid_batt_filtered = (int)(alpha * batt_raw + (1.0f - alpha) * pid_batt_filtered + 0.5f);
        pid_batt_last_update_cycle = pid_ctrl_cycles;
        pid_batt_snap_done = 0;             // 新样本，恢复 snap 资格
    }

    // 滤波态判据：原始电池温度 != 滤波值 → 正在滤波（可触发恢复原始值逻辑）
    int filter_lag = (pid_batt_filtered != batt_raw);
    // 停机首周期（温度未变）且滤波未收敛且未 snap 过：优先恢复原始值强制重算（改动2优先，绕过冻结）
    int filter_forced = 0;
    if (!batt_window_changed && filter_lag && !pid_batt_snap_done) {
        pid_batt_filtered = batt_raw;   // 恢复原始值 = 未更新的电池温度
        pid_batt_snap_done = 1;         // 只 snap 一次，次周期回正常冻结
        filter_forced = 1;
    }

    // --- PID 重算判定：温度窗口变化 或 补偿变化 或 改动2 snap 强制 ---
    int should_recompute = batt_window_changed ||
                           total_comp_10 != pid_last_comp_10 ||
                           filter_forced;

    if (!should_recompute) {
        debug_log(debug_pid, "PID 跳过重算（温度/补偿/滤波 未变）");
        return;
    }

    // --- 跳过②：温度未变（仅补偿变化触发）且上次 |ch| ≤ ch阈值 → 整轮冻结 ---
    // （改动2优先：本周期已 snap 强制重算则跳过冻结，"改动2跑完再冻结"；snap 后 pid_batt_filtered==batt_raw 回正常冻结）
    if (!batt_window_changed && !filter_forced) {
        float last_ch_abs = (pid_last_ch >= 0.0f) ? pid_last_ch : -pid_last_ch;
        if (last_ch_abs <= (pid_ch_threshold / 10.0f)) {
            debug_log(debug_pid, "PID 整轮冻结（|last_ch|=%.2f ≤阈值%.1f）",
                      pid_last_ch, pid_ch_threshold / 10.0f);
            pid_last_comp_10 = total_comp_10;   // 补偿书签推进，防死锁
            return;
        }
    }

    // dt：距上次重算以来的 5 秒周期数（1 = 5s），钳位 0.6~6（3s~30s）。标定单位为每 5s 周期
    float dt = (float)(now - pid_last_change_time) / 5.0f;
    if (dt > 6.0f) dt = 6.0f;
    if (dt < 0.6f) dt = 0.6f;

    // 无变化回溯速度（item4）：仅温度未变、开关开启、锚点有效时注入，否则走常规 v
    int recall_on = 0;
    float recall_v = 0.0f;
    if (pid_spd_recall_on && !batt_window_changed &&
        recall_cycles >= 1 && recall_anchor > 0 && batt_raw > 0 && pid_last_change_time != 0) {
        recall_on = 1;
        recall_v = ((float)(batt_raw - recall_anchor) / (float)recall_cycles / 10.0f)
                   * (pid_spd_recall_weight / 1000.0f);
    }

    // --- PID 计算（电池 error 用滤波值 pid_batt_filtered + cpu_comp；snap 后==batt_raw 故恢复原始值；温度未变时 kdp 沿用）---
    float pid_out = pid_compute(pid_batt_filtered, dt, cpu_comp, batt_window_changed, recall_on, recall_v);

    // 直接映射到物理值（无输出平滑）：PID 输出 → 制冷强度（风扇目标由 compute_fan_target 独立计算）
    int cmax = active_cold_eff_max;
    int range = cmax - pid_cold_min;
    if (range <= 0) range = 1;
    pid_align_cold = clamp(pid_cold_min + (int)(pid_out * range), pid_cold_min, cmax);

    pid_log("epoch=%ld Tbatt=%d+comp%+.1f(cpu)=Tinp%d Ttgt=%d Thot=%d dt=%.1f周期",
            now, batt_raw, cpu_comp, batt_raw + total_comp_10, BATT_BASELINE, cooler_hot_temp, dt);

    pid_last_comp_10 = total_comp_10;
    pid_last_change_time = now;
}

/**
 * 单次控制循环（纯计算，不下发）
 * 配置重载 → 热端过温/有效范围 → PID 周期
 * 调用者在外部立即执行速率限制下发，本函数只做决策
 */
static void main_loop(void) {
    // 温度窗口变化：自上次 5s 控制以来，1s 采集层是否检测到值变化（防漏判：变过又回原位仍算变化）。
    batt_window_changed = batt_changed_since_ctrl;
    batt_changed_since_ctrl = 0;                 // 开启新窗口

    // 0. 检查配置文件是否更新（热重载）
    debug_log(debug_main, "main_loop 开始 温度窗口=%s",
              batt_window_changed ? "变化" : "未变");
    struct stat st;
    if (config_path[0] != '\0' && stat(config_path, &st) == 0 && st.st_mtime != config_mtime) {
        load_config(config_path);
        config_mtime = st.st_mtime;
        write_log("配置 热重载");
        // 配置重载可能重置了 fan_rpm_max/pid_cold_max，立即用设备限制覆盖
        update_active_limits();
    }

    // 0.5. 热端过温 → 制冷削减（先于 PID 决策，本周期即生效）
    update_hot_derate();
    // 0.6. 当前模式有效制冷范围（统一计算，供下发/去重/映射使用，消除模式分支散落）
    update_active_cold_range();

    // --- 控制周期分发（本实现仅 PID） ---
    pid_cycle();
}

// ======================== 程序入口 ========================

// ======================== WebUI 曲线数据 ========================
// 每 1s 追加 1 行，行格式见 WEBUI_ROW_FMT / WEBUI_DATA_COLS（上方声明处）。
// 每 WEBUI_COMPACT_EVERY 行压缩一次（删最旧行，文件 720~780 行）
#define WEBUI_COMPACT_EVERY 60   // 每追加 60 行（≈60s）压缩一次，文件最多膨胀到 720+60=780 行
static int webui_lines_since_compact = 0;   // 自上次压缩以来追加的行数

/**
 * 每 1 秒采集一次并写入 WebUI 曲线数据文件（滚动保留 720 行）。
 * 断联（BLE 未连 或 app 进程失活）时停止写入：数据文件留下真实时间空洞，
 * WebUI 端按相邻采样时间戳差 > 5s 断开曲线并留出 5s 宽空白。
 */
static void write_webui_data(void) {
    int batt = read_battery_temp();
    int cpu  = read_cpu_temp_max();
    read_cooler_params();   // 更新 cooler_* 全局（热/冷端、实际转速、实际制冷）+ app_ble_connected
    // 更新 1s 采集缓存（保留上次成功值抗抖）
    if (batt >= 0) cached_batt_raw = batt;
    if (batt_temp_updated) batt_changed_since_ctrl = 1;  // 1s 层累积：自上次控制以来值变过
    if (cpu  >= 0) cached_cpu_now  = cpu;
    // 断联即停止写曲线（判定与主循环一致：BLE 未连 或 app 失活），留下真实时间空洞供 WebUI 断开。
    // 温度采集/缓存不受影响，5s 控制块仍用新鲜缓存。
    if (!app_ble_connected || !is_app_alive()) return;

    // 快速路径：追加 1 行到文件（mtime 每 1s 更新）
    FILE *wf = fopen(WEBUI_DATA_PATH, "a");
    if (wf) {
        fprintf(wf, WEBUI_ROW_FMT,
                (long)time(NULL), batt, cpu,
                cooler_hot_temp, cooler_cold_temp,
                cooler_rpm_real, cooler_cold_real, actual_cold);
        fclose(wf);
    }
    webui_lines_since_compact++;

    // 每 WEBUI_COMPACT_EVERY 行压缩：读文件 → 删最旧行 → 写回，文件收敛回 ~720 行
    if (webui_lines_since_compact >= WEBUI_COMPACT_EVERY) {
        webui_lines_since_compact = 0;
        char buf[WEBUI_DATA_MAX_LINES][96];
        int total = 0;
        FILE *rf = fopen(WEBUI_DATA_PATH, "r");
        if (rf) {
            // 环形覆盖读：缓冲只留最近 WEBUI_DATA_MAX_LINES 行（文件可能已膨胀到 780 行）
            while (fgets(buf[total % WEBUI_DATA_MAX_LINES], sizeof(buf[0]), rf)) total++;
            fclose(rf);
        }
        if (total > 0) {
            int keep = (total < WEBUI_DATA_MAX_LINES) ? total : WEBUI_DATA_MAX_LINES;
            int start = (total < WEBUI_DATA_MAX_LINES) ? 0 : (total % WEBUI_DATA_MAX_LINES);
            FILE *cf = fopen(WEBUI_DATA_PATH, "w");
            if (cf) {
                for (int i = 0; i < keep; i++)
                    fputs(buf[(start + i) % WEBUI_DATA_MAX_LINES], cf);
                fclose(cf);
            }
        }
    }
}

// ======================== 单实例锁 ========================
// service.d 开机拉起 + app 内手动拉起两条路径都直接执行启动命令，由本锁保证幂等。
// 锁文件与配置/日志/曲线数据同处私有目录。
// 残留后果（不美化）：app「清除数据」会把锁文件一起删掉，运行中的实例与新实例随即锁到
// 不同 inode，那一次锁失效；兜底靠部署脚本的开机自检。
#define LOCK_FILE_PATH        PRIVATE_DIR "/tempctrl.lock"
#define EXIT_ALREADY_RUNNING  2     // 退出码 2：已有实例在跑（其它启动失败路径均返回 0）
static int lock_fd = -1;

/** 取单实例锁（flock 非阻塞）。返回 1=取到可继续启动，0=已有实例在运行
 *  私有目录不可用（mkdir 被拒 / 父目录不存在）时不阻塞启动，仅 stderr 记录 */
static int acquire_single_instance_lock(void) {
    if (!ensure_private_dir()) {
        fprintf(stderr, "tempctrl: 私有目录 %s 不可用，跳过单实例检查\n", PRIVATE_DIR);
        return 1;
    }
    lock_fd = open(LOCK_FILE_PATH, O_RDWR | O_CREAT | O_CLOEXEC, 0666);
    if (lock_fd < 0) {
        // 锁文件建不了 → 不阻塞启动，仅 stderr 记录
        fprintf(stderr, "tempctrl: 锁文件 %s 不可用（跳过单实例检查）\n", LOCK_FILE_PATH);
        return 1;
    }
    if (flock(lock_fd, LOCK_EX | LOCK_NB) != 0) {
        close(lock_fd);
        lock_fd = -1;
        return 0;
    }
    return 1;   // 锁随进程存活持有，退出即自动释放
}

int main(int argc, char *argv[]) {
    signal(SIGTERM, handle_signal);
    signal(SIGINT,  handle_signal);

    // --- 单实例锁：已有实例在跑则退出（退出码 EXIT_ALREADY_RUNNING，与普通启动失败区分）---
    if (!acquire_single_instance_lock()) {
        fprintf(stderr, "tempctrl: 已有实例在运行（锁 %s），本次退出\n", LOCK_FILE_PATH);
        return EXIT_ALREADY_RUNNING;
    }

    // --- 日志路径、配置加载 ---
    set_default_log_path();
    if (argc >= 3 && strcmp(argv[1], "--config") == 0) {
        strncpy(config_path, argv[2], sizeof(config_path) - 1);
        config_path[sizeof(config_path) - 1] = '\0';
        load_config(config_path);
    } else if (detect_config_path()) {
        load_config(config_path);
    } else {
        config_path[0] = '\0';   // 未找到配置（私有目录不可用或文件不存在）→ 全部用代码默认值
        write_log("配置 未找到 %s/profile.conf，使用代码默认值", PRIVATE_DIR);
    }
    if (config_path[0] != '\0') {
        struct stat st;
        if (stat(config_path, &st) == 0) config_mtime = st.st_mtime;
    }
    debug_log(debug_main, "main 启动 ALPHA=%d ZONE=%d~%d", CPU_FILTER_ALPHA, CPU_ZONE_MIN, CPU_ZONE_MAX);

    // --- 双状态文件初始化 ---
    // 状态文件路径已由全局初始化设好（status_file_path_b6/_b7 硬编码）
    create_status_files();

    write_log("脚本启动成功");
    write_log("单实例锁 已获取 %s", LOCK_FILE_PATH);

    // --- 等待任一设备模块就绪 + BLE 连接（BLE 字段语义见 read_single_status） ---
    active_device = DEVICE_NONE;
    while (running) {
        // 宿主 APK 卸载自清理：必须放在本循环内，否则无 BLE、停在等待设备循环时永远不检测
        if (host_app_uninstalled()) {
            cleanup_artifacts_on_uninstall();
            break;   // running 已置 0，由下方 if (!running) goto exit 收尾
        }
        read_status_ble_both();
        DeviceType dev = select_active_device();
        if (dev != DEVICE_NONE) {
            active_device = dev;
            update_active_limits();
            write_log("初始设备 %s", device_tag_of(active_device));
            read_cooler_params();
            break;
        }
        arbitrate_apps();   // 等待设备期间无 app 存活则自动拉起上次使用的 app（冷却节流）
        sleep(5);
    }
    if (!running) goto exit;

    // --- PID 初始化（放在 BLE 就绪后）---
    pid_reset_core();

    // --- 进入工作模式 ---
    app_was_alive = 1;
    first_run = 1;

    // 以散热器实际回传值为准初始化实际制冷/转速。仅当真实回传已就绪才对齐并强制首次下发；
    // 未就绪（app 刚重启、lastWaspWingInfo 为空 → COLD_REAL 缺失/占位 1）则进入"待对齐"，
    // 由主循环等真实回传到达后起步，避免被 COLD_MIN 兜底成 1 或用低基线强制下发导致跳变。
    if (report_ok) {
        float pid_ratio = 0.0f;
        int cold_ref = (cooler_cold_real >= pid_cold_min) ? cooler_cold_real : pid_cold_min;
        pid_ratio = pid_ratio_from_cold(cold_ref, active_pid_cold_max);
        if (cooler_cold_real >= COLD_MIN) actual_cold = cooler_cold_real;
        else actual_cold = pid_cold_min;
        if (cooler_rpm_real >= fan_rpm_min) actual_rpm = cooler_rpm_real;
        else actual_rpm = fan_rpm_min;
        write_log("LSP 回传承载就绪 制冷=%d ratio=%.2f rpm=%d", actual_cold, pid_ratio, pid_align_rpm);

        // 强制首次下发
        last_bcast_valid = 0;
        rate_limit_cold(pid_align_cold);
        int send_rpm = rate_limit_fan(compute_fan_target());
        apply_gear_direct(1, 5, send_rpm, actual_cold, 0);
    } else {
        actual_cold = -1;      // 未就绪：不设兜底基线，待 try_align_actual 对齐后起步
        actual_rpm = -1;
        pid_align_cold = 1;    // 待对齐期间保持最小，等 PID 重算/对齐后推进
        pending_align = 1;
        pending_align_since = time(NULL);
        write_log("LSP 回传未就绪，进入待对齐（等待真实回传）");
    }

    // ---- 主循环：1 秒节拍（采集 + 控制分离） ----
    // 每 1s：采集电池/CPU/散热器回传 → 写 WebUI 曲线数据文件（滚动 720 行，断联不写）
    // 每 5s（时间判定）：执行控制（仲裁/存活/主循环/限速下发）
    time_t last_ctrl = 0;
    while (running) {
        write_webui_data();   // 每 1s 采集写数据文件（刚需热数据，WebUI 直接读）

        if (last_ctrl == 0 || time(NULL) - last_ctrl >= 5) {
            last_ctrl = time(NULL);

            // -1. 宿主 APK 卸载自清理（走 5s 节拍：一级 stat 每轮可跑，二级 pm 自带 60s 节流）
            if (host_app_uninstalled()) {
                cleanup_artifacts_on_uninstall();
                break;   // running 已置 0，跳出主循环走 exit: 收尾
            }

            // 0. CPU thermal_zone 周期重扫（移入 5s 控制块：全量扫描 ~100 个 zone 阻塞近 1s，
            //    不在 1s 采集热路径 write_webui_data 内触发）
            maybe_rescan_cpu_zones();

            // 1. 读取双状态文件 + 仲裁
            read_status_ble_both();
            if (time(NULL) - last_arbitrate >= ARBITRATE_INTERVAL) {
                arbitrate_apps();  // 双 app 存活仲裁（ARBITRATE_INTERVAL 节流 + 合并扫描，降低 /proc 遍历开销）
                last_arbitrate = time(NULL);
            }
            DeviceType new_device = select_active_device();

            // 2. 设备切换检测：当前设备断联时尝试切换到另一台
            if (new_device != active_device) {
                if (new_device == DEVICE_NONE) {
                    // 所有设备都断联
                    if (active_device != DEVICE_NONE) {
                        write_log("%s 已断开，无其他设备可切换\n",
                                  device_tag_of(active_device));
                        if (last_disconnect_time == 0)
                            last_disconnect_time = time(NULL);   // 断联起点（重连汇总行用）
                    }
                    active_device = DEVICE_NONE;
                    app_was_alive = 0;
                    continue;   // 每 5s 重试，期间持续写数据
                } else {
                    // 切换到另一台在线设备
                    write_log("切换 %s → %s",
                              device_tag_of(active_device),
                              device_tag_of(new_device));
                    active_device = new_device;
                    update_active_limits();
                    read_cooler_params();
                    reconnect_align();
                }
            } else if (active_device == DEVICE_NONE) {
                continue;   // 无可用设备，5s 后重试
            }

            // 3. 散热器回传参数（cooler_*）由 1s 采集路径维护，此处直接用缓存
            debug_log(debug_conn, "main 当前设备=%s ble=%d",
                      device_tag_of(active_device), app_ble_connected);

            // 4. 存活检测（debug_conn 日志只在 5s 控制层输出，is_app_alive 另被 1s 采集层调用）
            int app_proc_ok = is_app_alive();
            struct stat st_conn;
            long mtime_gap = -1;
            if (stat((active_device == DEVICE_B7X) ? status_file_path_b7 : status_file_path_b6,
                     &st_conn) == 0)
                mtime_gap = (long)(time(NULL) - st_conn.st_mtime);
            debug_log(debug_conn, "app_alive device=%s %d mtime_gap=%lds timeout=%ds",
                      device_tag_of(active_device), app_proc_ok, mtime_gap, STATUS_TIMEOUT);
            if (!app_proc_ok || !app_ble_connected) {
                // 每断联只打一次：last_disconnect_time==0 表示本次断联尚未记录，恢复由 reconnect_align 清零
                if (last_disconnect_time == 0) {
                    last_disconnect_time = time(NULL);   // 断联起点（重连汇总行用）
                    write_log("%s 连接丢失", device_tag_of(active_device));
                }
                launch_last_app(0);   // 断联时也尝试拉起散热器 app（无 app 存活时真正拉起；存活时 debug 提示）
                                      // 传 0：本处无「已确认全灭」的已知结论，由内部自行单包扫描
                app_was_alive = 0;  // 复活后走 reconnect_align 重新对齐实际值
                continue;
            }

            if (!app_was_alive) {
                app_was_alive = 1;
                reconnect_align();
            }

            main_loop();

            // ★ 待对齐：启动/长断连重置后先等真实回传就绪再对齐实际值（对齐后允许强制首下）
            if (pending_align && try_align_actual())
                last_bcast_valid = 0;

            // ★ 速率限制执行
            cycle_batt_temp = cached_batt_raw;   // 1s 采集缓存
            int dispatched = rate_limited_execute();   // 1=实际下发了制冷变化，0=跳过

            // ★ 锁死自动重启检测（watchdog）：仅在本次实际下发制冷变化后判定——
            // 实际停滞（=上周期实际）且未达目标（≠上周期下发）连续 N 次 → kill app 重新拉起
            if (dispatched) watchdog_check();
        }

        sleep(1);
    }

exit:
    if (log_fp) fclose(log_fp);
    return 0;
}
