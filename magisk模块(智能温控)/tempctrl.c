// ================================================================
// tempctrl.c — 飞智 WaspWing 散热器智能温控守护程序
// ================================================================
//
// 运行环境：Magisk / KernelSU 模块，由 service.sh 启动并守护
// App 进程检测：直读 /proc/<pid>/cmdline 精确比对包名
// 控制指令：am broadcast → LSPosed 模块 → WaspWingManager.setRunMode
//
// 温度单位：整型 0.1°C（电池原生单位，CPU m°C ÷ 100）
//   例：350 = 35.0°C, 753 = 75.3°C
//
// 编译（请使用 GitHub Actions CI，NDK r27c）：
//   Termux 的 clang -static 链接 Termux 的 libc，非 Android libc，
//   编译出的二进制在真机上 PT_TLS 对齐错误，不可用。
//   NDK 编译命令：aarch64-linux-android21-clang -static -O2 -ffunction-sections -fdata-sections -Wl,--gc-sections -Wl,--strip-all
//   （NDK 静态编译后需要 python3 patch_tls.py 修复 PT_TLS 对齐）
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
#include <sys/wait.h>
#include <fcntl.h>
#include <dirent.h>
#include <limits.h>
#include <math.h>

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

// ======================== 档位定义 ========================
//
// ⚠️ 不推荐智能温控模式（mode=0）：实测其风扇转速配置疑似非强制生效，常突破上限（尤在刚切换的瞬间），噪音突然变大体验差。固定功率档位表已避免此问题。
//
//setRunMode(mode, targetTemperature,windLevelOverclock, coldLevelOverclock,windLevel, modeCustom, extra)
//
// 参数映射：mode=0(智能温控)：targetTemperature, windLevel(风扇转速上限)
//          mode=1（固定功率）：windLevelOverclock(风扇固定转速), coldLevelOverclock(制冷片强度)

// ----（Gear 档位表 / init_gear_table / sort_vals / gear_label 已随 Gear 删除）----

// ======================== 常量与边界 ========================
#define COLD_MIN             1
#define COLD_MAX           194     // 最大有效值（B6X 硬件上限）
// B7X 独立上限（运行时根据 active_device 选择）
#define B7X_COLD_MAX       255
#define B7X_FAN_RPM_MAX    8000

// B7X 上限（FAN_RPM / PID_COLD 第三值，可配置，暂时与 B6X 一致）
// B7X_COLD_MAX / B7X_FAN_RPM_MAX 宏保留为 clamp 安全上界
static int b7_pid_cold_max = 190;   // FAN_RPM/PID_COLD 第三值（B7X），默认同 B6X
static int b7_fan_rpm_max  = 6000;  // FAN_RPM 第三值（B7X），默认同 B6X

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

// ======================== 通用参数（PID 和 Gear 共用）========================
// --- 基准温度 ---
static int BATT_BASELINE = 350;     // 基准温度 35.0°C

// --- 控制模式：本实现仅保留 PID（Gear 已删除）---

// --- 冷端→风扇映射 ---
static int cold_map_start = 40;     // COLD_MAP 第一值=映射起始强度，低于此值时线性外推下限
static int cold_map_exp = 150;      // COLD_MAP 第二值=n^exp（÷100，150=1.50），>1 低冷慢转
static int rpm_smooth_alpha = 50;   // RPM_SMOOTH_ALPHA：冷/热端→风扇转速映射的 EMA 平滑系数（百分比，1~99）

// --- 热端映射范围 ---
static int hot_map_min = 350;       // HOT_MAP_MIN（0.1°C）
static int hot_map_max = 450;       // HOT_MAP_MAX（0.1°C）

// --- 风扇转速范围 ---
static int fan_rpm_min = 2000;      // FAN_RPM_MIN
static int fan_rpm_max = 6000;      // FAN_RPM_MAX
static int fan_rpm_change_threshold = 200; // 变化阈值（0=不限制；仅风扇降低时防抖，距最低转速<阈值×1.5 时失效）

// ======================== 速率限制 ========================
// --- 固定值 ---
static int RATE_LIMIT_FAN_DOWN = 400;   // 风扇降速每周期最大变化量（RPM）
static int RATE_LIMIT_COLD = 25;   // 制冷强度升降速基础值：升速=base+dev×mult/10，降速=base-dev×mult/10，负值→0=禁止该方向

// --- 动态值（根据电池温差自动调整）---
static int RATE_LIMIT_COLD_MULT = 10;  // 制冷强度倍率：升速/降速 = base ± dev(0.1°C) × mult / 10
static int COLD_DEADZONE = 3;          // 制冷最小变化幅度（RATE_LIMIT_COLD 第三值）：与散热器实际 |差值| ≤ 该值时不升不降
static int RATE_LIMIT_FAN_UP = 200;   // 风扇升速基础值：RPM_UP = base + d × mult / 10
static int RATE_LIMIT_FAN_MULT = 50;  // 风扇升速倍率（RATE_LIMIT_FAN_UP 双值第二位）
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

// ======================== CPU 温度滤波（PID / Gear 共用）========================
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
// 卸载脚本路径（由 config_path 推导：$MODDIR/uninstall.sh，用于记录自定义日志路径）
static char uninstall_script_path[256] = "";
// 配置文件的最后修改时间（用于热重载检测）
static time_t config_mtime = 0;

// ======================== PID 控制（单累积器） ========================
// --- 配置变量（按 profile.conf 键顺序排列）---

// PID_GAIN 第一值：KDP 融合 P+D 项系数（÷1000，kdp = kdp_coef×ch_kdp）
static int pid_kdp_coef = 300;
// PID_GAIN 第二值：积分增益（÷1000，acc += ki_coef×(ch−target_f)，不乘 dt）
static int pid_ki_coef = 20;
// PID_GAIN 第三值：速度项倍率系数（÷1000，ch = error + v×speed_coef + cpu_comp）
static int pid_speed_coef = 240;
// PID_TARGET 第一值：动态目标系数（÷1000，raw_target = clamp(error×target_coef, ±上限)）
static int pid_target_coef = 20;
// PID_TARGET 第二值：目标 EMA 平滑系数（%，滤波系数）
static int pid_target_alpha = 10;
// PID_TARGET 第三值：动态目标上限（0.1°C，默认 10=1.0°C）
static int pid_target_max = 10;
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

// PID_COLD：输出范围
static int pid_cold_min = 1;              // PID_COLD 第一值：制冷强度下限
static int pid_cold_max = 190;            // PID_COLD 第二值：制冷强度上限（B6X）

// --- PID 运行时状态（单累积器）---
static float pid_ki = 0.0f;               // 积分累积值（acc；float：限幅赋小数需保留）
static float pid_kdp = 0.0f;              // 融合 P+D 项（kdp = kdp_coef×ch_kdp；无记忆，跳过①用 last 值）
static float pid_target_f = 0.0f;         // EMA 动态目标
static float pid_last_error = 0.0f;       // 上周期纯电池误差（°C，v 计算用）
static float pid_last_ch = 0.0f;          // 上周期 ch（|ch|≤阈值 → 整轮冻结判据）
static time_t pid_last_change_time = 0;   // 上次重算时间戳（dt 锚点）
// --- 无变化回溯（PID_SPD_RECALL）：锚点温度 + 累计周期数 → 重算速度 ---
static int recall_anchor = 0;             // 最近一次温度变化前的温度（0.1°C）
static int recall_prev_batt = 0;          // 上个控制周期的电池温度（0.1°C）
static int recall_cycles = 0;             // 距该次变化的控制周期数（>0 才有效）
static int pid_spd_recall_on = 1;         // PID_SPD_RECALL 第一值：开关
static int pid_spd_recall_weight = 1000;  // PID_SPD_RECALL 第二值：回溯速度权重（÷1000，1000=全量）

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
static float pid_ratio_saved = -1.0f;     // PID 无级对齐量（0~1，-1=未初始化）

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

// WebUI 曲线数据文件（每 1 秒一行，滚动保留最大曲线窗口秒数）
#define WEBUI_DATA_PATH       "/data/local/tmp/tempctrl_webui.data"
#define WEBUI_DATA_MAX_LINES  720   // = 曲线最大时间挡位（秒）

// 三方 app 包名（farsef 在最近连 B6X 散热器时也参与仲裁）
#define APP_PKG_B6X_OLD "com.flydigi.waspwing.experimental"
#define APP_PKG_B6X_NEW "com.flydigi.waspwing.experimentanliuliu"
#define APP_PKG_B7X "com.fdg.flashplay.farsef"

#define ARBITRATE_INTERVAL 15   // app 存活仲裁间隔（秒）：合并扫描后仍较低频，兼顾拉起/清理响应

// 自动拉起散热器 app（优先上次使用的 app）
static int APP_LAUNCH_ENABLED = 0;      // 总开关：1=允许自动拉起，0=关闭（默认关，刷入时可选开）
// 锁死自动重启（watchdog）：每次实际下发制冷变化时判定——实际停滞（=上周期实际）且≠上周期下发持续 N 次 → kill app 并重新拉起
static int app_watchdog_cycles = 0;     // APP_WATCHDOG：连续停滞次数（0=关闭，默认 6）
static int watchdog_stall_count = 0;    // 当前连续停滞次数（按实际下发周期计数）
static int watchdog_last_cold = -1;     // 上周期实际制冷值（停滞判定基准）
static int watchdog_last_cmd  = -1;     // 上周期下发制冷值（未达目标判定基准）
static long watchdog_last_kill_at = 0;  // 上次 kill 时间戳（冷却防风暴）
static time_t last_launch_attempt = 0;  // 上次拉起尝试时间（冷却用）
static time_t last_arbitrate = 0;       // 上次 app 存活仲裁时间（ARBITRATE_INTERVAL 节流）
static int app_launch_cooldown = 60;    // APP_LAUNCH_COOLDOWN：两次拉起最小间隔（秒，默认 60）
static int app_launch_screen_gate_enabled = 1;  // APP_LAUNCH_SCREEN_GATE 第一值：屏幕门禁开关
static int app_launch_screen_fail_ok    = 1;    // 第二值：读取失败默认值（1=可拉起，0=跳过）
static int app_launch_screen_dozing_on  = 0;    // 第三值：Dozing 是否算亮屏（默认 0）

#define BOOT_START_DELAY_SEC 30         // 脚本启动成功后延迟开始运行（等待系统/蓝牙就绪，避开开机初期拉起 app 闪烁）

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

// ======================== 热端过温制冷上限削减 ========================
// 热端温度 > 阈值 → 每次削减制冷上限 (热端-阈值)×倍率，削减后 5 周期内不再削减；
// 热端温度 ≤ 阈值 → 每次恢复 5（复用倍率值），恢复后 5 周期内不再恢复；
// 削减与恢复的冷却独立（不共用）。削减基准上限：gear = 档位表最高档制冷
static int HOT_DERATE_THRESHOLD = 450;   // 热端阈值（0.1°C，450=45.0°C）
static int HOT_DERATE_MULT = 5;          // 削减倍率 = 单次恢复值（削减量=(热端-阈值)×mult/10）
static int HOT_DERATE_COOLDOWN = 5;      // 削减/恢复后冷却周期数（5 个 5s 周期）
static int hot_derate = 0;               // 当前制冷上限削减量
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

/**
 * 将日志路径追加到卸载脚本 uninstall.sh（幂等），供卸载时清理用户自定义日志文件。
 * 用户修改 LOG_FILE 后热重载，新路径会被记录；脚本中已存在的路径不重复追加。
 * uninstall_script_path 由 config_path（$MODDIR/profile.conf）推导。
 */
static void record_log_path_for_uninstall(const char *path) {
    if (path == NULL || path[0] == '\0') return;
    // 懒初始化：从 config_path 推导 $MODDIR/uninstall.sh
    if (uninstall_script_path[0] == '\0' && config_path[0] != '\0') {
        char *slash = strrchr(config_path, '/');
        if (slash) {
            int len = (int)(slash - config_path);
            snprintf(uninstall_script_path, sizeof(uninstall_script_path),
                     "%.*s/uninstall.sh", len, config_path);
        }
    }
    if (uninstall_script_path[0] == '\0') return;

    // 幂等检查：脚本中已存在该路径的 rm 行则跳过
    char needle[512];
    snprintf(needle, sizeof(needle), "rm -f %s", path);
    FILE *f = fopen(uninstall_script_path, "r");
    char line[512];
    int found = 0;
    if (f) {
        while (fgets(line, sizeof(line), f)) {
            if (strstr(line, needle)) { found = 1; break; }
        }
        fclose(f);
    }
    if (found) return;

    f = fopen(uninstall_script_path, "a");
    if (f) {
        fprintf(f, "rm -f %s\n", path);
        fclose(f);
    }
}

/** sysfs 路径与缩放层键集合（SYSFS_ENABLED=1 时解析，独立于性能/调试总开关） */
static int is_sysfs_key(const char *key) {
    return strcmp(key, "BATT_TEMP_PATH") == 0
        || strcmp(key, "BATT_TEMP_DIVISOR") == 0
        || strcmp(key, "BATT_CURRENT_PATH") == 0
        || strcmp(key, "BATT_CURRENT_DIVISOR") == 0
        || strcmp(key, "CPU_TEMP_PATH_FMT") == 0
        || strcmp(key, "CPU_TEMP_DIVISOR") == 0
        || strcmp(key, "CPU_ZONE") == 0
        || strcmp(key, "CPU_ZONE_RESCAN") == 0
        || strcmp(key, "LOG_FILE") == 0
        || strcmp(key, "LOG_MAX") == 0;
}

// ======================== 配置解析（表驱动 + 分段函数） ========================

// --- 配置表驱动：纯 int clamp 单值键（layer 0=性能层 / 1=sysfs层；键互不重叠）---
struct IntCfgKey { const char *key; int *var; int min; int max; int layer; };

static const struct IntCfgKey INT_CFG_KEYS[] = {
    // 性能层（PERF_ENABLED=1）
    { "BATT_BASELINE",             &BATT_BASELINE,               300, 500 },
    { "CPU_FILTER_ALPHA",          &CPU_FILTER_ALPHA,            1, 100 },
    { "RECONNECT_KEEP_CYCLES",     &reconnect_keep_cycles,       0, 30 },
    // PID 单值键走表驱动；多值键（PID_GAIN / PID_TARGET / PID_TARGET_DIR / PID_COLD / PID_CPU_COMP / PID_SPD_RECALL）在 parse_pid_cfg 分段解析
    { "PID_CH_THRESHOLD",          &pid_ch_threshold,            1, 100 },
    { "RPM_SMOOTH_ALPHA",          &rpm_smooth_alpha,            1, 99 },
    // sysfs 层（SYSFS_ENABLED=1）
    { "BATT_TEMP_DIVISOR",         &BATT_TEMP_DIVISOR,           1, 10000 },
    { "CPU_TEMP_DIVISOR",          &CPU_TEMP_DIVISOR,            1, 10000 },
    { "BATT_CURRENT_DIVISOR",      &BATT_CURRENT_DIVISOR,        1, 100000 },
    { "LOG_MAX",                   &LOG_MAX,                     0, 1048576 },
};

/** 配置表查找：命中（layer 匹配 + 键名一致）则 clamp 赋值，返回 1 */
static int parse_int_cfg(const char *key, int val, int layer) {
    int n = (int)(sizeof(INT_CFG_KEYS) / sizeof(INT_CFG_KEYS[0]));
    for (int i = 0; i < n; i++) {
        if (INT_CFG_KEYS[i].layer == layer && strcmp(key, INT_CFG_KEYS[i].key) == 0) {
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

/** sysfs 路径与缩放层（SYSFS_ENABLED=1 时） */
static void parse_sysfs_cfg(const char *key, int val, const char *val_str) {
    if (parse_int_cfg(key, val, 1)) return;
    if      (strcmp(key, "BATT_TEMP_PATH") == 0)
        config_read_path(BATT_TEMP_PATH, sizeof(BATT_TEMP_PATH), val_str);
    else if (strcmp(key, "CPU_TEMP_PATH_FMT") == 0)
        config_read_path(CPU_TEMP_PATH_FMT, sizeof(CPU_TEMP_PATH_FMT), val_str);
    else if (strcmp(key, "BATT_CURRENT_PATH") == 0)
        config_read_path(BATT_CURRENT_PATH, sizeof(BATT_CURRENT_PATH), val_str);
    else if (strcmp(key, "CPU_ZONE") == 0) {
        int a = CPU_ZONE_MIN, b = CPU_ZONE_MAX;
        if (sscanf(val_str, "%d %d", &a, &b) >= 2) { CPU_ZONE_MIN = clamp(a,0,99); CPU_ZONE_MAX = clamp(b,0,99); }
    }
    else if (strcmp(key, "CPU_ZONE_RESCAN") == 0) {
        // 双值：重扫间隔（秒） 保留温度值个数
        int a = cpu_zone_rescan_sec, b = cpu_zone_keep;
        int n = sscanf(val_str, "%d %d", &a, &b);
        if (n >= 1) cpu_zone_rescan_sec = clamp(a, 5, 3600);
        if (n >= 2) cpu_zone_keep = clamp(b, 1, 64);
    }
    else if (strcmp(key, "LOG_FILE") == 0) {
        config_read_path(log_file_path, sizeof(log_file_path), val_str);
        record_log_path_for_uninstall(log_file_path);  // 记录自定义日志路径供卸载清理
    }
}

/** PID 专属多值配置（PERF 层；单值键已并入 INT_CFG_KEYS 表驱动） */
static int parse_pid_cfg(const char *key, int val, const char *val_str) {
    // PID_GAIN = KDP融合系数(÷1000) KI积分增益(÷1000) 速度倍率(÷1000)
    if (strcmp(key, "PID_GAIN") == 0) {
        int a = pid_kdp_coef, b = pid_ki_coef, c = pid_speed_coef;
        int n = sscanf(val_str, "%d %d %d", &a, &b, &c);
        if (n >= 1) pid_kdp_coef   = clamp(a, 1, 1000);
        if (n >= 2) pid_ki_coef    = clamp(b, 1, 1000);
        if (n >= 3) pid_speed_coef = clamp(c, 0, 1000);
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
    if (strcmp(key, "PID_COLD") == 0) {
        int a = pid_cold_min, b = pid_cold_max, c = b7_pid_cold_max;
        int n = sscanf(val_str, "%d %d %d", &a, &b, &c);
        if (n >= 2) { pid_cold_min=clamp(a,0,194); pid_cold_max=clamp(b,0,194); }
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
    // PID_SPD_RECALL = 开关 回溯速度权重(÷1000)
    // 默认 "1 1000" = 开启、注入全量速度；无上限（锚点+累计周期数）
    if (strcmp(key, "PID_SPD_RECALL") == 0) {
        int on = pid_spd_recall_on, w = pid_spd_recall_weight;
        int n = sscanf(val_str, "%d %d", &on, &w);
        if (n >= 1) pid_spd_recall_on = (on != 0);
        if (n >= 2) pid_spd_recall_weight = clamp(w, 100, 1000);
        return 1;
    }
    return 0;
}

// Gear 专属配置解析（parse_gear_cfg）已随 Gear 删除

/** 通用多值配置（PERF 层，PID/Gear 共用） */
static int parse_common_cfg(const char *key, int val, const char *val_str) {
    if (strcmp(key, "HOT_MAP") == 0) {
        int a = hot_map_min, b = hot_map_max;
        if (sscanf(val_str, "%d %d", &a, &b) >= 2) { hot_map_min = clamp(a,200,500); hot_map_max = clamp(b,200,500); }
        return 1;
    }
    if (strcmp(key, "FAN_RPM") == 0) {
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
    if (strcmp(key, "RATE_LIMIT_FAN_DOWN") == 0) {
        int base = RATE_LIMIT_FAN_DOWN, thr = fan_rpm_change_threshold;
        int n = sscanf(val_str, "%d %d", &base, &thr);
        if (n >= 1) RATE_LIMIT_FAN_DOWN = clamp(base, 50, 2000);
        if (n >= 2) fan_rpm_change_threshold = clamp(thr, 0, 2000);
        return 1;
    }
    if (strcmp(key, "RATE_LIMIT_COLD") == 0) {
        // RATE_LIMIT_COLD = 基础值 倍率 最小变化幅度（三值）
        int base = RATE_LIMIT_COLD, mult = RATE_LIMIT_COLD_MULT, dz = COLD_DEADZONE;
        int n = sscanf(val_str, "%d %d %d", &base, &mult, &dz);
        if (n >= 1) RATE_LIMIT_COLD      = clamp(base, 1, 194);
        if (n >= 2) RATE_LIMIT_COLD_MULT = clamp(mult, 1, 100);
        if (n >= 3) COLD_DEADZONE        = clamp(dz, 1, 50);
        return 1;
    }
    // COLD_MAP = 映射起始强度 指数（双值）
    if (strcmp(key, "COLD_MAP") == 0) {
        int s = cold_map_start, e = cold_map_exp;
        int n = sscanf(val_str, "%d %d", &s, &e);
        if (n >= 1) cold_map_start = clamp(s, 0, 194);
        if (n >= 2) cold_map_exp   = clamp(e, 50, 500);
        return 1;
    }
    if (strcmp(key, "RATE_LIMIT_FAN_UP") == 0) {
        int rise = RATE_LIMIT_FAN_UP, mult = RATE_LIMIT_FAN_MULT;
        if (sscanf(val_str, "%d %d", &rise, &mult) >= 1) {
            RATE_LIMIT_FAN_UP   = clamp(rise, 50, 2000);
            RATE_LIMIT_FAN_MULT = clamp(mult, 1, 200);
        }
        return 1;
    }
    return 0;
}

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
            // 屏幕门禁（多值：开关 读取失败默认值 Dozing是否算亮屏）；仅 mWakefulness=Awake 才拉起
            int on = app_launch_screen_gate_enabled, f = app_launch_screen_fail_ok, dz = app_launch_screen_dozing_on;
            int n = sscanf(val_str, "%d %d %d", &on, &f, &dz);
            if (n >= 1) app_launch_screen_gate_enabled = (on != 0);
            if (n >= 2) app_launch_screen_fail_ok    = (f != 0);
            if (n >= 3) app_launch_screen_dozing_on  = (dz != 0);
        }
    }

    // 前置条件：自动拉起关闭 → 锁死自动重启（watchdog）强制关闭（不改配置，仅运行时生效）。
    if (!APP_LAUNCH_ENABLED && app_watchdog_cycles > 0) {
        write_log("配置 自动拉起关闭 → 锁死自动重启 强制关闭（APP_WATCHDOG=%d 运行时置 0）", app_watchdog_cycles);
        app_watchdog_cycles = 0;
    }

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

        // 表驱动单值 → 分段函数（PID/Gear/通用），键互不重叠、唯一命中
        if (parse_int_cfg(key, val, 0)) continue;
        if (parse_pid_cfg(key, val, val_str)) continue;
        if (parse_common_cfg(key, val, val_str)) continue;
        debug_log(debug_config, "配置 未识别键 %s（已忽略）", key);
    }
    fclose(f);

    // （CTRL_MODE 模式切换过渡 / GEAR 档位表后处理 已随 Gear 删除）
}

// ======================== 可执行文件名提取 ========================

/**
 * 从 /proc/self/exe 获取可执行文件名（不含路径）
 * 返回 1=成功，0=失败
 */
static int get_exe_basename(char *buf, size_t size) {
    char exe_path[512];
    ssize_t len = readlink("/proc/self/exe", exe_path, sizeof(exe_path) - 1);
    if (len <= 0) return 0;
    exe_path[len] = '\0';
    char *slash = strrchr(exe_path, '/');
    if (!slash) return 0;
    strncpy(buf, slash + 1, size - 1);
    buf[size - 1] = '\0';
    return 1;
}

/**
 * 根据二进制名设定默认日志路径
 * 例：tempctrl → /cache/tempctrl.log
 * 此值为默认值，profile.conf 中 LOG_FILE 可覆盖
 */
static void set_default_log_path(void) {
    char basename[64];
    if (get_exe_basename(basename, sizeof(basename))) {
        snprintf(log_file_path, sizeof(log_file_path), "/cache/%s.log", basename);
        return;
    }
    // fallback
    strncpy(log_file_path, "/cache/tempctrl.log", sizeof(log_file_path) - 1);
}

/**
 * 自动检测配置文件路径
 *
 * 通过 /proc/self/exe 获取 tempctrl 自身路径，
 * 在同目录下找 profile.conf
 *
 * 返回 1=找到，0=未找到
 */
static int detect_config_path(void) {
    char exe_path[512];
    ssize_t len = readlink("/proc/self/exe", exe_path, sizeof(exe_path) - 1);
    if (len <= 0) return 0;
    exe_path[len] = '\0';

    // 获取 exe 所在目录
    char *last_slash = strrchr(exe_path, '/');
    if (!last_slash) return 0;
    *last_slash = '\0';

    // 在同目录下找 profile.conf
    snprintf(config_path, sizeof(config_path), "%s/profile.conf", exe_path);
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
    // 日志超限：保留尾部完整行
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
    strftime(ts, sizeof(ts), "%d %H:%M:%S", tm);
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

/** 设备代号（日志显示用）：B7X→"b7x"，B6X/B8X→"b6x"，无设备→"none" */
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
    // 预创建 MAC 记录文件（0666 权限；路径与 MainHook LAST_DEV_FILE 一致）
    FILE *mf = fopen("/data/local/tmp/tempctrl_last_dev", "a");
    if (mf) {
        fclose(mf);
        chmod("/data/local/tmp/tempctrl_last_dev", 0666);
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
        if (strncmp(line, "BLE=", 4) == 0) {
            int ble = atoi(line + 4);
            *out_connected = (ble != 0);
            if (is_b6_file) {
                if (ble == 1 || ble == 2) b6_owner = ble;
                // BLE=1/2 不设 model，由 read_status_ble_both 按文件路径兜底型号 6
            } else if (out_model && (ble == 6 || ble == 7)) {
                *out_model = ble;   // B7X 文件型号编码
            }
        } else if (strncmp(line, "CONNECTED_AT=", 13) == 0) {
            *out_connected_at = (time_t)atol(line + 13);
        } else if (strncmp(line, "BLE_OWNER_LAST=", 15) == 0) {
            int owner = 0;
            long at = 0;
            if (sscanf(line + 15, "%d %ld", &owner, &at) == 2 && owner > 0) {
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
        active_fan_max  = b7_fan_rpm_max;    // FAN_RPM 第三值（B7X），默认同 B6X
        active_pid_cold_max = b7_pid_cold_max; // PID_COLD 第三值（B7X），默认同 B6X
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
        if (strncmp(line, "BLE=", 4) == 0) {
            app_ble_connected = (atoi(line + 4) != 0);
        } else if (strncmp(line, "HOT_TEMP=", 9) == 0) {
            cooler_hot_temp = atoi(line + 9);
        } else if (strncmp(line, "COLD_TEMP=", 10) == 0) {
            cooler_cold_temp = atoi(line + 10);
        } else if (strncmp(line, "RUN_MODE=", 9) == 0) {
            run_mode_seen = 1;
        } else if (strncmp(line, "RPM_REAL=", 9) == 0) {
            cooler_rpm_real = atoi(line + 9);
        } else if (strncmp(line, "COLD_REAL=", 10) == 0) {
            cooler_cold_real = atoi(line + 10);
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

// ======================== 热端过温制冷上限削减 ========================

/** 当前生效的制冷强度上限 = 基准上限 - 热端过温削减，下限不低于冷端最小强度 */
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
 * 热端 > 阈值 → 削减 (热端-阈值)×倍率，削减后 HOT_DERATE_COOLDOWN 周期内不再削减；
 * 热端 ≤ 阈值 → 恢复 5（=倍率值），恢复后 HOT_DERATE_COOLDOWN 周期内不再恢复；
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
                hot_derate += reduction;
                hot_derate_cooldown = HOT_DERATE_COOLDOWN;
                write_log("热端过温 %d.%d°C 削减制冷上限 %d（总削减 %d）",
                          cooler_hot_temp / 10, cooler_hot_temp % 10, reduction, hot_derate);
            }
        }
    } else {
        if (hot_derate > 0 && hot_recover_cooldown == 0) {
            hot_derate -= HOT_DERATE_MULT;
            if (hot_derate < 0) hot_derate = 0;
            hot_recover_cooldown = HOT_DERATE_COOLDOWN;
            write_log("热端回落 %d.%d°C 恢复制冷上限 %d（剩余削减 %d）",
                      cooler_hot_temp / 10, cooler_hot_temp % 10, HOT_DERATE_MULT, hot_derate);
        }
    }
}

/**
 * 计算 PID 模式有效制冷范围（上限 = PID_COLD 上限，含热端过温削减）。
 * 每 5s 周期在 update_hot_derate 之后调用，供下发/去重/映射统一使用。
 */
static void update_active_cold_range(void) {
    active_cold_eff_min = pid_cold_min;
    active_cold_eff_max = eff_cold_max(active_pid_cold_max, pid_cold_min);
}

// ======================== 控制参数计算与下发 ========================

// 档位查表参数构造（build_params）已随 Gear 删除

/**
 * 通过 am broadcast 下发控制参数到 LSPosed 模块（fork+exec，3s 超时）
 */
static void send_am_broadcast(int mode, int target, int windOC, int coldOC, int windLevel) {
    char m_s[12], t_s[12], woc_s[12], coc_s[12], wl_s[12];
    snprintf(m_s, sizeof(m_s), "%d", mode);
    snprintf(t_s, sizeof(t_s), "%d", target);
    snprintf(woc_s, sizeof(woc_s), "%d", windOC);
    snprintf(coc_s, sizeof(coc_s), "%d", coldOC);
    snprintf(wl_s, sizeof(wl_s), "%d", windLevel);

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
            ? "com.flydigi.SET_TEMPERATURE_B7"
            : "com.flydigi.SET_TEMPERATURE";
        // 用绝对路径执行 am：daemon 环境 PATH 若缺 /system/bin，execlp 会静默失败
        // （子进程 _exit(127)，父进程 waitpid 正常返回，故障不可见）。
        // execl 不依赖 PATH，标准 Android/MIUI 的 am 均在 /system/bin/am。
        execl("/system/bin/am", "am", "broadcast", "--user", "0",
              "-a", action,
              "--ei", "mode", m_s,
              "--ei", "temperature", t_s,
              "--ei", "windOC", woc_s,
              "--ei", "coldOC", coc_s,
              "--ei", "windLevel", wl_s,
              "--ei", "modeCustom", "0",
              "--ei", "extra", "0",
              (char *)NULL);
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
 * 根据电池温差计算动态速率上限
 * @param out_fan_up    风扇升速上限（RPM）
 * @param out_cold_up   制冷强度升速上限（有符号温差，负值→0=禁止升）
 * @param out_cold_down 制冷强度降速上限（有符号温差，负值→0=禁止降）
 */
static void calc_dynamic_rates(int *out_fan_up, int *out_cold_up, int *out_cold_down) {
    int d = 0;
    if (cycle_batt_temp >= 0) {
        d = abs(cycle_batt_temp - BATT_BASELINE);
    }
    *out_fan_up = RATE_LIMIT_FAN_UP + d * RATE_LIMIT_FAN_MULT / 10;
    if (*out_fan_up > 2000) *out_fan_up = 2000;
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
    int fan_up, cold_up, cold_down;
    calc_dynamic_rates(&fan_up, &cold_up, &cold_down);
    int old_cold = actual_cold;
    rate_limit(&actual_cold, desired_cold, cold_up, cold_down);
    debug_log(debug_exec, "cold 限速 %d→%d desired=%d（升%d 降%d）",
              old_cold, actual_cold, desired_cold, cold_up, cold_down);
}

/**
 * 风扇转速限速（升降独立速率，含降速防抖）。
 * 返回限速后的实际风扇转速，向上取整到 50 的倍数并钳制到设备范围。
 *
 * 防抖仅在下降低于阈值内时生效（上升自由爬升）
 * 距最低转速 < 阈值×1.5 时防抖失效（接近最低转速无需防突降噪音）。
 */
static int rate_limit_fan(int desired_rpm) {
    int fan_up, cold_up, cold_down;
    calc_dynamic_rates(&fan_up, &cold_up, &cold_down);

    int near_min_rpm = (actual_rpm - fan_rpm_min) < fan_rpm_change_threshold * 3 / 2;
    if (fan_rpm_change_threshold > 0 && !near_min_rpm &&
        desired_rpm < actual_rpm && (actual_rpm - desired_rpm) <= fan_rpm_change_threshold)
        desired_rpm = actual_rpm;
    rate_limit(&actual_rpm, desired_rpm, fan_up, RATE_LIMIT_FAN_DOWN);

    // ---- 向上取整到 50 的倍数 ----
    int send_rpm = ((actual_rpm + 49) / 50) * 50;
    send_rpm = clamp(send_rpm, fan_rpm_min, active_fan_max);
    debug_log(debug_exec, "rpm 限速 desired=%d → %d（防抖保持=%d）", desired_rpm, send_rpm,
              (fan_rpm_change_threshold > 0 && !near_min_rpm &&
               desired_rpm < actual_rpm && (actual_rpm - desired_rpm) <= fan_rpm_change_threshold));
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
            int adiff = (diff >= 0) ? diff : -diff;
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
             "dumpsys power 2>/dev/null | awk -F'=' '/mWakefulness=/{ if ($0 !~ /Override/) { print $2; exit } }'");
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
             "dumpsys window 2>/dev/null | grep -m1 'mCurrentFocus='; "
             "dumpsys activity activities 2>/dev/null | grep -m1 -E 'topResumedActivity|mResumedActivity'");
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

/** 判断指定包名是否已安装（pm path 有输出即已安装） */
static int app_installed(const char *pkg) {
    return (run_cmd_silent("pm path %s > /dev/null 2>&1", pkg) == 0);
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
    if (pkg == APP_PKG_B6X_OLD && !app_installed(pkg) && app_installed(APP_PKG_B6X_NEW)) {
        debug_log(debug_launch, "自动拉起 老 B6X app 未安装，改用新 app");
        pkg = APP_PKG_B6X_NEW;
    } else if (pkg == APP_PKG_B6X_NEW && !app_installed(pkg) && app_installed(APP_PKG_B6X_OLD)) {
        debug_log(debug_launch, "自动拉起 新 B6X app 未安装，改用老 app");
        pkg = APP_PKG_B6X_OLD;
    }
    return pkg;
}

/**
 * 自动拉起上次使用的散热器 app（带冷却）
 * 包名按 last_owner 选择：2→新 B6X app，6/7→farsef，其余/无记录→老 B6X app；
 * 目标 B6X app 未安装时回退另一个 B6X app。
 * 拉起用 am start（显式 launcher 组件 -n）+ b6x_auto_launch 标志（LSP 读到后连接完成自动后台化，几乎无感）。
 * 仅在 APP_LAUNCH_ENABLED=1 且目标 app 已安装、未运行时执行。
 */
static void launch_last_app(void) {
    time_t now = time(NULL);
    if (now - last_launch_attempt < app_launch_cooldown) return;   // 冷却节流（仅在真正 am start 前记录尝试）
    if (!APP_LAUNCH_ENABLED) {
        debug_log(debug_launch, "自动拉起 开关关闭，跳过");
        return;
    }

    const char *pkg = resolve_launch_pkg();
    debug_log(debug_launch, "自动拉起 目标 %s（last_owner=%d）", pkg, last_owner);
    if (!app_installed(pkg)) {
        write_log("自动拉起 目标 app 未安装 %s", pkg);
        return;
    }
    int pkg_alive = 0;
    app_process_scan(&pkg, &pkg_alive, 1);   // 单包扫描（复用合并遍历逻辑）
    if (pkg_alive) {
        debug_log(debug_launch, "自动拉起 目标已在运行 %s，跳过", pkg);
        return;
    }

    // 屏幕状态门禁（APP_LAUNCH_SCREEN_GATE）：仅 mWakefulness=Awake 才拉起；屏灭/失败跳过本周期（下一 5s 重试）
    if (app_launch_screen_gate_enabled) {
        int sc = is_screen_awake();
        if (sc == 2) sc = app_launch_screen_dozing_on ? 1 : 0;   // Dozing 按配置是否算亮屏（默认 0=算灭）
        if (sc < 0) sc = app_launch_screen_fail_ok;              // 读取失败兜底（默认 1=可拉起，防永久不拉起）
        if (sc != 1) {
            debug_log(debug_launch, "自动拉起 屏幕未亮（mWakefulness 非 Awake），本周期跳过");
            return;
        }
    }

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
                 "am start -n %s/%s --es b6x_auto_launch 1 > /dev/null 2>&1", pkg, act);
    else
        snprintf(cmd, sizeof(cmd),
                 "am start -a android.intent.action.MAIN -c android.intent.category.LAUNCHER "
                 "-p %s --es b6x_auto_launch 1 > /dev/null 2>&1", pkg);
    last_launch_attempt = now;   // 真正下发 am start 才记冷却，避免屏灭轮询消耗冷却
    int rc = system(cmd);
    write_log("自动拉起散热器 app %s（后台化）rc=%d", pkg, rc);
}

/** kill 目标散热器 app 并重新拉起（绕过 APP_LAUNCH_ENABLED 开关：本处主动 kill 必须拉起） */
static void force_kill_and_relaunch(void) {
    const char *pkg = resolve_launch_pkg();
    write_log("锁死自动重启 强制停止 %s 并重新拉起", pkg);
    run_cmd_silent("am force-stop %s > /dev/null 2>&1", pkg);
    // 等进程退出（最多 2s）
    for (int i = 0; i < 20; i++) {
        int alive = 0;
        app_process_scan(&pkg, &alive, 1);
        if (!alive) break;
        usleep(100000);
    }
    // 复用自动拉起的显式组件逻辑（b6x_auto_launch 后台化）
    const char *act = NULL;
    if (strcmp(pkg, APP_PKG_B6X_OLD) == 0 || strcmp(pkg, APP_PKG_B6X_NEW) == 0)
        act = "com.example.extool.MainActivity";
    else if (strcmp(pkg, APP_PKG_B7X) == 0)
        act = "com.game.motionelf.activity.ActivityStart";
    char cmd[320];
    if (act)
        snprintf(cmd, sizeof(cmd),
                 "am start -n %s/%s --es b6x_auto_launch 1 > /dev/null 2>&1", pkg, act);
    else
        snprintf(cmd, sizeof(cmd),
                 "am start -a android.intent.action.MAIN -c android.intent.category.LAUNCHER "
                 "-p %s --es b6x_auto_launch 1 > /dev/null 2>&1", pkg);
    int rc = system(cmd);
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
        run_cmd_silent("am force-stop %s > /dev/null 2>&1", pkg);
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
        launch_last_app();
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
    if (keep == APP_PKG_B7X && b6_connected_at > last_owner_at)
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

// ======================== 输入补偿（PID / Gear 共用） ========================

/**
 * CPU 补偿值（0.1°C）：comp=(cpu滤波温度 − 电池 − 偏移)/divisor，clamp≥0，
 * 再按补偿专属滤波系数 EMA 平滑（首次上次值用 0，从 0 平滑爬升而非直取）。
 * 门控滞回：条件满足（raw>0）进入补偿；条件消失（raw=0）后不立即退出，
 * 平滑值归零后才关闭补偿
 * 始终生效，无开关（门控由条件自触发）。
 * @param batt 当前电池温度（0.1°C，两模式均用原始电池温度口径）
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

// ======================== PID 控制函数 ========================

/**
 * PID 计算（单累积器）：OUTPUT = clamp(acc + kdp, 0, 1)。
 * - error 为纯电池误差（不含 CPU 补偿）；cpu_comp 与速度同地位，算 ch 时加入。
 * - 速度 v = (error − 上次error)/dt（倍率系数缩放，不乘 dt）。
 * - ch 用于积分（acc += ki×(ch − target_f)），ch_kdp 用于 KDP（速度按 0.33 衰减，无记忆）。
 * - 动态目标 target_f（EMA 平滑），使积分逼近"误差×目标系数"包络，防静态过冲。
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

    // ch（受控量，用于积分）与 ch_kdp（用于 KDP，速度按 0.33 衰减）
    float sc = pid_speed_coef / 1000.0f;
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

    // 积分累积（acc；不乘 dt）
    pid_ki += (pid_ki_coef / 1000.0f) * (ch - pid_target_f);

    // KDP（融合 P+D）：温度变了才更新；温度未变沿用上次值（跳过①）
    if (batt_window_changed)
        pid_kdp = (pid_kdp_coef / 1000.0f) * chkdp;

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
 * 热端温度线性映射 + EMA 平滑 + 双向滞回：无上下限，低于 HOT_MAP_MIN 或高于 HOT_MAP_MAX 时线性外推
 * 最终钳制在下发阶段（apply_gear_direct 内部）
 *
 * 平滑：输入先经 RPM_SMOOTH_ALPHA EMA 平滑（与冷端共用系数）
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
 * 最终钳制在下发阶段（apply_gear_direct 内部）
 */
static int rpm_from_cold_exp(int cold) {
    static int cold_rpm_smoothed = -1;  // RPM_SMOOTH_ALPHA EMA 平滑
    int range = active_pid_cold_max - cold_map_start;
    if (range <= 0) return 0;
    float n = (float)(cold - cold_map_start) / range;
    int raw_rpm;
    if (n < 0.0f)
        raw_rpm = fan_rpm_min + (int)(n * (active_fan_max - fan_rpm_min));
    else {
        float n_exp = powf(n, cold_map_exp / 100.0f);
        raw_rpm = fan_rpm_min + (int)(n_exp * (active_fan_max - fan_rpm_min));
    }
    // EMA 平滑（系数可配置 RPM_SMOOTH_ALPHA）
    if (cold_rpm_smoothed < 0) {
        cold_rpm_smoothed = raw_rpm;
    } else {
        cold_rpm_smoothed = EMA_DIR(raw_rpm, cold_rpm_smoothed, rpm_smooth_alpha);
    }
    debug_log(debug_exec, "rpm 冷端 exp cold=%d → %d", cold, cold_rpm_smoothed);
    return cold_rpm_smoothed;
}

/**
 * 独立风扇目标计算：冷端指数映射（基于限速后实际制冷）+ 热端线性映射加权合并。
 * 与 PID/Gear 输出解耦：每周期下发前由 rate_limited_execute / apply_gear 单独调用。
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
 * 直接下发 AT 广播（PID / 直接冷端模式使用）
 * 与 apply_gear 共享 last_* 去重缓存
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
        write_log("过热钳制冷 %d→%d（上限削减 %d）", cold_pre_clamp, cold, hot_derate);

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
 * 重置 PID 核心状态（积分、误差、滤波、补偿、方差缓冲区）
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
    pid_batt_filtered = -1;          // 电池输入滤波重置（改动2；切模式/重连后直取初值）
    pid_batt_last_update_cycle = -1;
    pid_batt_snap_done = 0;
    recall_anchor = 0;
    recall_prev_batt = 0;
    recall_cycles = 0;
}

// Gear 模式切换对齐（pid_align_from_gear）已随 Gear 删除

/**
 * 按制冷强度参考值对齐 PID 初始输出。
 * @param cold_ref 制冷强度参考值（存档值或 LSP 回传实际值）
 * @param cold_max 参考值对应的制冷上限（存档用 pid_cold_max，LSP 用 active_pid_cold_max）
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
    pid_ratio_saved = ratio;
    return ratio;
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
 * 重连安全对齐：以散热器实际回传值为准初始化实际制冷/转速（PID/gear 共用），
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
        int interval = pid_ctrl_cycles - pid_batt_last_update_cycle;
        if (interval < 0) interval = 0;
        if (interval > 16) interval = 16;   // 钳 0~16 → α 0.2~1.0（1.0=不滤波）
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
    if (config_path[0] != '\0') {
        struct stat st;
        if (stat(config_path, &st) == 0) {
            if (st.st_mtime != config_mtime) {
                load_config(config_path);
                config_mtime = st.st_mtime;
                write_log("配置 热重载");
                // 配置重载可能重置了 fan_rpm_max/pid_cold_max，立即用设备限制覆盖
                update_active_limits();
            }
        }
    }

    // 0.5. 热端过温 → 制冷上限削减（两模式共用，先于 PID/档位决策，本周期即生效）
    update_hot_derate();
    // 0.6. 当前模式有效制冷范围（统一计算，供下发/去重/映射使用，消除模式分支散落）
    update_active_cold_range();

    // --- 控制周期分发（本实现仅 PID） ---
    pid_cycle();
}

// ======================== 程序入口 ========================

// ======================== WebUI 曲线数据 ========================
// 每 1s 追加 1 行，行格式：epoch,电池,CPU,热端,冷端,实际转速,实际制冷,目标制冷（0.1°C，未就绪为 -1）。
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
        fprintf(wf, "%ld,%d,%d,%d,%d,%d,%d,%d\n",
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

int main(int argc, char *argv[]) {
    signal(SIGTERM, handle_signal);
    signal(SIGINT,  handle_signal);

    // --- 日志路径、配置加载 ---
    set_default_log_path();
    if (argc >= 3 && strcmp(argv[1], "--config") == 0) {
        strncpy(config_path, argv[2], sizeof(config_path) - 1);
        config_path[sizeof(config_path) - 1] = '\0';
        load_config(config_path);
    } else if (detect_config_path()) {
        load_config(config_path);
    } else {
        config_path[0] = '\0';
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
    sleep(BOOT_START_DELAY_SEC);   // 延迟开始运行：等待系统/蓝牙就绪（守护进程保持存活，watchdog 不会误重启）

    // --- 等待任一设备模块就绪 + BLE 连接（BLE 字段语义见 read_single_status） ---
    active_device = DEVICE_NONE;
    while (running) {
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
                launch_last_app();   // 断联时也尝试拉起散热器 app（无 app 存活时真正拉起；存活时 debug 提示）
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
