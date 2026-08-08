// ================================================================
// tempctrl.c — 飞智 WaspWing 散热器智能温控守护程序
// ================================================================
//
// 运行环境：Magisk / KernelSU 模块，由 service.sh 启动并守护
// App 进程检测：直读 /proc/<pid>/cmdline 精确比对包名（不经 shell，避免 pgrep 自匹配误判）
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
// ⚠️ 不推荐使用智能温控模式（mode=0）：实测其风扇转速配置疑似并非强制生效，经常突破设定的上限，尤其在刚切换过去的瞬间。这会导致噪音突然变大，体验较差。全部固定功率模式的档位表已避免此问题。
//
//setRunMode(mode, targetTemperature,windLevelOverclock, coldLevelOverclock,windLevel, modeCustom, extra)
//
// 参数映射：mode=0(智能温控)：targetTemperature, windLevel(风扇转速上限)
//          mode=1（固定功率）：windLevelOverclock(风扇固定转速), coldLevelOverclock(制冷片强度)

// --- 档位范围 ---
#define LEVEL_INIT          5     // 无存档时的默认初始档位
#define GEAR_TABLE_MAX      32    // 最大支持档位数（支持自动扩展）

// --- 档位表（动态，可通过 profile.conf 的 GEAR_B6X_N / GEAR_B7X_N 配置覆盖）---
// 每条包含：模式(0=智能温控, 1=固定功率), 目标温度(°C), 风扇转速(RPM), 制冷片强度(0-194)
typedef struct {
    int mode;       // 0=智能温控, 1=固定功率
    int target;     // 智能温控目标温度 (°C)，固定功率时为 0
    int fan_rpm;    // 风扇转速 (RPM)
    int cold;       // 制冷片强度 (0-194)
    int config_n;   // 配置中的原始档位编号（日志显示用，无空洞时同 runtime level）
} GearEntry;

// 双设备独立档位表（B6X / B7X），活动表指针随 active_device 切换
static GearEntry gear_table_b6[GEAR_TABLE_MAX];
static GearEntry gear_table_b7[GEAR_TABLE_MAX];
static GearEntry *gear_table = gear_table_b6;  // 活动表指针
static int gear_count_b6 = 0;    // B6X 实际档位数
static int gear_count_b7 = 0;    // B7X 实际档位数
static int gear_min = 1;
static int gear_max_b6 = 12;     // B6X 默认 12 档
static int gear_max_b7 = 12;     // B7X 默认 12 档
static int gear_count = 12;      // 活动表档位数（select_gear_table 同步）
static int gear_max = 12;        // 活动表最大档（select_gear_table 同步）

// 默认档位表（依实测散热曲线标定，全部固定功率模式）
// 格式：GEAR_B6X_<档位N>=<模式>,<目标温度°C>,<风扇RPM>,<制冷强度>（B7X 用 GEAR_B7X_ 前缀）
// 范围：N=1~32, 模式=0(智能)或1(固定), 目标=5~35°C, 风扇=2000~6000, 制冷=1~194
// 注意：模式 0 时制冷强度失效（散热器自行管理），模式 1 时目标温度无效
// 例：GEAR_B6X_12=1,0,6000,190 表示 12 档固定功率，6000RPM，制冷 190
//     GEAR_B6X_5=0,16,2650,0   表示  5 档智能温控，16°C，风扇上限 2650RPM
static const GearEntry DEFAULT_GEAR_TABLE[12] = {
    {1, 0, 2000,  5,  1},    // Level 1   α待机
    {1, 0, 2000, 10,  2},    // Level 2
    {1, 0, 2000, 20,  3},    // Level 3
    {1, 0, 2300, 35,  4},    // Level 4
    {1, 0, 2650, 55,  5},    // Level 5   LEVEL_INIT
    {1, 0, 3050, 75,  6},    // Level 6
    {1, 0, 3500, 100, 7},    // Level 7
    {1, 0, 4000, 125, 8},    // Level 8
    {1, 0, 4500, 145, 9},    // Level 9
    {1, 0, 5000, 165, 10},   // Level 10
    {1, 0, 5500, 180, 11},   // Level 11
    {1, 0, 6000, 190, 12},   // Level 12 制冷峰值
};

/**
 * 初始化默认档位表（B6X / B7X 各一套，内容相同）
 * 程序启动时调用。若 profile.conf 包含 GEAR_B6X_N / GEAR_B7X_N 配置，load_config 将覆盖之。
 */
static void init_gear_table(void) {
    gear_count_b6 = 12; gear_max_b6 = 12;
    gear_count_b7 = 12; gear_max_b7 = 12;
    gear_min = 1;
    for (int i = 0; i < 12; i++) {
        gear_table_b6[i] = DEFAULT_GEAR_TABLE[i];
        gear_table_b7[i] = DEFAULT_GEAR_TABLE[i];
    }
    gear_table = gear_table_b6;   // 默认活动表：B6X
    gear_count = gear_count_b6;
    gear_max   = gear_max_b6;
}

/** GEAR_B6X_N / GEAR_B7X_N 配置解析临时结构体（用于排序后填入连续档位表） */
typedef struct {
    int config_n;   // 配置中的原始档位编号
    int mode;
    int target;
    int fan_rpm;
    int cold;
} GearConfigTemp;

/** 防呆排序：按制冷强度升序，同级按风扇转速升序（供 qsort 使用） */
static int cmp_gear_config_cold(const void *a, const void *b) {
    const GearConfigTemp *x = (const GearConfigTemp *)a;
    const GearConfigTemp *y = (const GearConfigTemp *)b;
    if (x->cold != y->cold) return x->cold - y->cold;
    if (x->fan_rpm != y->fan_rpm) return x->fan_rpm - y->fan_rpm;
    return x->config_n - y->config_n;
}

/** 获取运行时档位的配置编号（日志显示用，空洞时显示原始编号） */
static inline int gear_label(int level) {
    if (level < 1 || level > gear_count) return level;
    int label = gear_table[level - 1].config_n;
    return (label > 0) ? label : level;
}

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
static int cpu_zone_rescan_sec = 60;   // CPU thermal_zone 全量重扫间隔（秒，CPU_ZONE_RESCAN 配置，默认 60）

// ======================== 通用参数（PID 和 Gear 共用）========================
// --- 基准温度 ---
static int BATT_BASELINE = 350;     // 基准温度 35.0°C

// --- 控制模式 ---
static int ctrl_mode = 1;           // CTRL_MODE: 0=gear, 1=PID

// --- 冷端→风扇映射 ---
static int cold_map_start = 40;     // 映射起始强度，低于此值时线性外推下限
static int cold_map_exp = 150;      // n^exp（÷100，150=1.50），>1 低冷慢转
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
static int RATE_LIMIT_TEMP = 2;   // 目标温度每周期最大变化量（0.1°C）

// --- 动态值（根据电池温差自动调整）---
static int RATE_LIMIT_COLD_MULT = 10;  // 制冷强度倍率：升速/降速 = base ± dev(0.1°C) × mult / 10
static int COLD_UP_DEADZONE = 5;       // 制冷上升死区：上升变化量 ≤ 该值时不升（制冷强度变化时会在限制以下波动一段时间，上升太少不如不升）
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
static int actual_target_temp = -1;    // 当前实际目标温度（°C）

// ======================== Gear 模式 — 电池控制（CTRL_MODE=0）========================
// --- 三区间阈值 ---
static int BATT_BOUNDARY_1 = 5;      // ±0.5°C → 不变（死区）
static int BATT_BOUNDARY_2 = 13;     // ±1.3°C → ±1 档
static int BATT_BOUNDARY_3 = 25;     // ±2.5°C → ±2 档（超过→±3档）
static int BATT_COOLDOWN_CYCLES = 3; // 档位变动后冷却周期数

// --- 电流-挡位映射 ---
static int CURRENT_GEAR_MODE_CHARGE    = 1;    // 充电开关
static int CURRENT_GEAR_MODE_DISCHARGE = 1;    // 放电开关
static int CURRENT_GEAR_MULT_CHARGE    = 2;    // 充电倍率
static int CURRENT_GEAR_MULT_DISCHARGE = 6;    // 放电倍率
static int CURRENT_GEAR_SMOOTH_ALPHA   = 25;   // 电流平滑系数（%）
static int CURRENT_GEAR_MIN            = 6;    // 低于此值回退基准模式
// 电流-挡位运行状态
static int curr_gear_smooth_val   = 0;         // 电流平滑值（µA）
static int curr_gear_smooth_valid = 0;         // 平滑值是否已初始化
static int curr_gear_recommended  = 0;         // 上一次的电流推荐挡位
static int curr_gear_temp_offset   = 0;        // 温度累积偏移量
static int curr_gear_temp_cooldown = 0;        // 温度偏移冷却剩余周期

// --- 反补查表 ---
static int REV_COMP_THRESH_1 = 2;
static int REV_COMP_THRESH_2 = 3;
static int REV_COMP_THRESH_3 = 4;
static int REV_COMP_COOLDOWN = 1;
static int REV_COMP_ENABLED  = 1;              // 反补独立开关
// 反补运行状态
static int rev_comp_pending_delta = 0;
static int rev_comp_pending_idle  = 0;
static int rev_comp_cooldown = 0;

// --- 趋势豁免 ---
static int TREND_EXEMPT_ENABLED = 1;          // 趋势豁免独立开关
static int TREND_RESET_THRESHOLD = 6;
static int trend_anchor_temp = -1;            // 趋势豁免锚点温度
static int trend_exempt_count = 0;

// --- 电池控制运行状态 ---
static int batt_gear_base = 0;                // 电池控制决定的基础档位
static int last_batt_reading = -1;            // 上次读取的电池温度
static int temp_idle_cycles = 0;              // 温度值连续未变的控制周期数
static int pid_ctrl_cycles = 0;               // PID 控制周期单调计数器（pid_cycle 每次 +1，方差插值用）
static int BATT_SKIP_MAX = 6;                 // 值连续未变达到此上限时强制处理一次（防卡死，可配置）
static int batt_gear_cooldown = 0;            // 电池调档冷却剩余周期

// ======================== Gear 模式 — 紧急干预（CTRL_MODE=0）========================
// --- 独立开关 ---
static int EMERG_CPU_ENABLED     = 1;         // CPU 温度紧急开关

// --- CPU 温度紧急 ---
static int CPU_EMERG_3   = 850;     // >85.0°C → 等级 3
static int CPU_EMERG_2   = 750;     // >75.0°C → 等级 2
static int CPU_EMERG_1   = 650;     // >65.0°C → 等级 1
static int CPU_RECOVER_0 = 550;     // <55.0°C → 清除紧急
static int CPU_RECOVER_1 = 650;     // <65.0°C 且 ≥2 级时降为 1
static int CPU_RECOVER_2 = 750;     // <75.0°C 且 ≥3 级时降为 2
static int CPU_FILTER_ALPHA = 25;   // CPU 滤波系数（%）
// CPU 紧急运行状态
static int cpu_filtered_temp = 250; // 加权 CPU 温度，初始 25.0°C
static int first_run = 1;           // 首次运行，滤波直接赋初值

// --- 紧急干预模式 ---
static int EMERG_MODE_ENTRY = 0;   // 0=查表强制最低档, 1=升档
static int EMERG_MODE_EXIT  = 1;   // 0=钳制最高档, 1=降档
static int EMERG_STEP = 2;
static int EMERG_EXIT_BATT_THRESHOLD = 20;  // 电池温度阈值（0.1°C）

// --- 紧急强制最低档位 ---
static int EMERG_FORCED_1 = 6;   // 等级 1 强制最低档位
static int EMERG_FORCED_2 = 8;   // 等级 2
static int EMERG_FORCED_3 = 10;  // 等级 3
static int EMERG_FORCED_4 = 12;  // 等级 4
static int EMERG_EXIT_CAP_OFFSET = 1;  // 退出钳制偏移

// --- 紧急退出恢复期 ---
static int EMERG_RECOVERY_MULT_1 = 6;             // P1 阈值倍率
static int EMERG_RECOVERY_MULT_2 = 4;             // P2 阈值倍率
static int EMERG_RECOVERY_MULT_3 = 2;             // P3 阈值倍率
static int EMERG_RECOVERY_PHASE_CYCLES = 6;       // 每阶段周期数
static int emerg_recovery_mult = 1;               // 当前恢复倍率
static int emerg_recovery_cycles = 0;             // 当前阶段剩余周期
static int emerg_recovery_phase = 0;              // 当前阶段（0=关闭）

// --- 紧急干预运行状态 ---
static int emergency_level = 0;     // 紧急等级 0~3
static int emerg_forced_gear = 0;   // 紧急强制最低档位

// ======================== 日志与调试 ========================
// --- 日志路径（默认根据二进制名自动生成，可由 profile.conf 覆盖）---
static char log_file_path[256] = "";
static int LOG_MAX = 7936;          // 日志文件大小上限（字节），0=关闭日志
static FILE *log_fp = NULL;          // 持久的日志文件指针，避免每行都 fopen/fclose
static char log_path_opened[256] = ""; // 已打开的文件路径（检测路径变化）
static int debug_mode = 0;           // 调试日志总开关，=1 时启用各分区调试输出
static int debug_sensor = 0;    // [传感器] 电池/CPU 读数
static int debug_emerg   = 0;   // [紧急干预] CPU 温度紧急等级计算
static int debug_batt    = 0;   // [电池控制] 电池温度调档/恢复期/反补
static int debug_exec    = 0;   // [执行下发] 速率限制/am broadcast 送参数
static int debug_conn    = 0;   // [连接状态] App 存活/BLE/重连对齐
static int debug_config  = 0;   // [配置加载] 配置文件解析过程
static int debug_main    = 0;   // [主循环] main_loop 流程跟踪
static int debug_pid     = 0;   // [PID] PID 控制调试
static int debug_launch  = 0;   // [自动拉起] 目标选择/回退/跳过（结果成功/失败为普通日志，不归此分区）
static int debug_fan     = 0;   // [风扇] 转速计算/限速/下发

// ======================== 配置文件系统 ========================
// 配置文件路径（自动检测或 --config 指定）
static char config_path[256] = "";
// 卸载脚本路径（由 config_path 推导：$MODDIR/uninstall.sh，用于记录自定义日志路径）
static char uninstall_script_path[256] = "";
// 配置文件的最后修改时间（用于热重载检测）
static time_t config_mtime = 0;

// ======================== PID 模式控制（CTRL_MODE=1）========================
// --- 核心参数 ---
static int pid_kp = 300;                  // PID_KP（÷1000，1°C→P=40%）
static int pid_ki = 45;                   // PID_KI 第一值=积分增益（÷1000；dt 为周期数后标定单位=每 5s 周期，原秒标定 ×5 得等效值）
static int pid_kd = 300;                  // PID_KD
static int pid_integral_limit = 667;      // PID_KI 第二值=积分上限（÷1000，I 项最大输出贡献）

// --- KI 方差门控 ---
static int pid_ki_var_threshold = 50;     // PID_KI_VAR 第一值=方差门控阈值（0.1°C²，0=关闭）
static int pid_ki_var_samples = 6;        // PID_KI_VAR 第二值=采样数（2~20）
static int pid_ki_deadband = 20;          // PID_KI_DEADBAND（0.1°C，0=禁止I项）

// --- 输入滤波 ---
static int pid_input_filter_enabled = 1;  // PID_INPUT_FILTER 第一值：默认开（EMA 滤波；自适应逻辑可按间隔自动关闭/恢复）
static int pid_batt_alpha = 33;           // PID_BATT_ALPHA（%，新值权重）
static int pid_filter_auto_threshold_on = 30;   // 自动关闭阈值（×0.1周期）
static int pid_filter_auto_threshold_off = 20;  // 自动恢复阈值（×0.1周期）
static int pid_filter_auto_alpha = 20;          // 间隔EMA平滑系数（%）
static int pid_filter_auto_off = 0;             // 运行时标志：1=自适应关闭了滤波
static int pid_filter_interval_smooth = -1;     // 平滑后的更新周期数（0.1周期）
#define PID_FILTER_GAP_MULT 2   // 滤波间隔 EMA 输入钳位倍数

// --- PID 运行状态 ---
static float pid_integral_accum = 0.0f;   // 积分累积值（必须 float：int 在限幅赋小数时会截断为 0，I 项恒失效）
static int pid_prev_error = 0;            // 上周期误差
static int pid_batt_filtered = -1;        // EMA 滤波后电池温度
static int pid_last_batt = -1;            // 上次参与 PID 计算的原始温度
static time_t pid_last_change_time = 0;   // 上次温度变化时间戳
// 方差门控环形缓冲区
#define PID_VAR_BUF_MAX 20    // 最大支持采样数（≥ PID_KI_VAR 第二值上限）
static int pid_var_buffer[PID_VAR_BUF_MAX];
static int pid_var_head = 0;
static int pid_var_count = 0;
static int pid_var_last_value = -1;  // 上次推入的值（插值用）
static int pid_var_last_cycle = -1;  // 上次推入时的周期计数（插值用）

// ======================== Gear 温度预测 ========================
// 通过历史温度变化趋势预测电池温度的平衡点，提前给 Gear 调档提供前馈信号（PID 不使用预测）
#define PREDICT_BUF_MAX 32  // 缓冲区容量上限（≥ 可配置的 GEAR_PREDICT_WIN 第一值）

typedef struct {
    int temp;     // 真实电池温度（0.1°C）
    int gap;      // 距离上个真实读数的周期数（≥1）
} PredictPoint;

// --- 预测配置参数 ---
static int gear_predict_buf_n = 10;         // GEAR_PREDICT_WIN 第一值：温度记录缓冲区大小（3~32）
static int gear_predict_win_n = 5;          // GEAR_PREDICT_WIN 第二值：计算窗口（有效数据点数，3~10）
static int gear_predict_min_points = 2;     // GEAR_PREDICT_WIN 第三值：最小可用数据点数（2~5）
static int gear_predict_max_rise = 30;      // GEAR_PREDICT_RISE 第一值：最大预测变化量（0.1°C，10~100）
static int gear_predict_ramp_cycles = 3;    // GEAR_PREDICT_RISE 第二值：Ramp-up 周期数（1~10，0=不渐进）
static int gear_predict_min_delta = 2;      // GEAR_PREDICT_RISE 第三值=最小起始 delta（0.1°C/周期，1~10）
static int gear_predict_heat_weight = 10;   // GEAR_PREDICT_WEIGHT 第一值：升温预测权重（0~10，默认10=全效）
static int gear_predict_cool_weight = 5;    // GEAR_PREDICT_WEIGHT 第二值：降温预测权重（0~10，默认5=半效）
static int gear_predict_suppress = 50;      // GEAR_PREDICT_WEIGHT 第三值：低于稳定性闸门的预测增量抑制系数（%，50=×0.5，0=完全抑制=停止）
static int gear_predict_alpha = 33;         // GEAR_PREDICT_ALPHA：预测平滑系数（%，独立键）

// --- 预测运行状态 ---
static PredictPoint gear_predict_buf[PREDICT_BUF_MAX];
static int gear_predict_buf_cnt = 0;        // 缓冲区有效条目数
static int gear_predict_buf_head = 0;       // 环形缓冲区写指针
static int gear_predict_smoothed = -1;      // 平滑后的预测温度（0.1°C），-1=未初始化
static int gear_predict_was_active = 0;     // 上周期是否使用了预测模式
static int gear_predict_consecutive = 0;    // 连续预测周期数（用于 ramp-up）

// --- 输入补偿（加到电池温度，反映 CPU 额外发热；PID 与 Gear 共用，始终生效，无开关）---
static int pid_cpu_comp_filter_alpha = 25;  // PID_CPU_COMP 第一值：补偿 EMA 平滑系数（%，独立于 CPU_FILTER_ALPHA）
static int pid_cpu_comp_divisor = 30;       // PID_CPU_COMP 第二值：除数
static int pid_cpu_comp_offset = 100;       // PID_CPU_COMP 第三值：偏移量（0.1°C，100=10.0°C）
static int pid_cpu_comp_ready = 0;          // 补偿平滑是否已初始化（首值直取）
static float pid_cpu_comp_smooth = 0.0f;    // CPU 补偿 EMA 平滑值（°C）
static int pid_last_comp_10 = 0;            // 上次 PID 重算时的补偿值（0.1°C）

// --- Gear 调档输入温度（每 5s 周期由 gear_compute_input 计算，battery_control / gear_from_current 读取）---
static int gear_input_batt = -1;

// --- 输出映射与对齐 ---
static int pid_cold_min = 1;              // PID_COLD_MIN
static int pid_cold_max = 190;            // PID_COLD_MAX
static int pid_align_rpm = 2000;          // PID 目标 RPM（仅初始化对齐与日志使用；风扇下发已由 compute_fan_target 独立计算）
static int pid_align_cold = 1;            // PID 目标制冷强度
static float pid_ratio_saved = -1.0f;     // PID 无级对齐量（0~1，-1=未初始化；切回 Gear 时映射回档位）

// ======================== 散热器回传参数 ========================
static int cooler_hot_temp = -1;          // 热端温度（0.1°C）
static int cooler_cold_temp = -1;         // 冷端温度（0.1°C）
static int cooler_rpm_real = -1;          // 实际风扇转速
static int cooler_cold_real = -1;         // 实际制冷强度

// ======================== 全局运行状态 ========================
// --- 信号 ---
static volatile int running = 1;

// --- 电池温度数值追踪（Scene 式：定时轮询 + 值比较，不依赖 sysfs mtime）---
static int batt_cached_temp = -1;        // 最后一次读取的温度缓存
static int batt_temp_updated = 0;        // 最近一次 1s 采集值是否变化（供采样 push 判定）
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
static time_t last_launch_attempt = 0;  // 上次拉起尝试时间（冷却用）
static time_t last_arbitrate = 0;       // 上次 app 存活仲裁时间（ARBITRATE_INTERVAL 节流）
#define APP_LAUNCH_COOLDOWN 60          // 两次拉起最小间隔（秒）

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

// --- 档位模式自动风扇 ---
static int gear_auto_fan = 1;   // GEAR_AUTO_FAN: 0=直通, 1=自动映射+截断
static int gear_config_enabled = 0;   // GEAR_CONFIG_ENABLED: 0=代码默认表, 1=使用配置档位表

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

/** 根据 active_device 切换活动档位表指针与计数（B6X/B7X 独立表） */
static void select_gear_table(void) {
    if (active_device == DEVICE_B7X) {
        gear_table = gear_table_b7;
        gear_count = gear_count_b7;
        gear_max   = gear_max_b7;
    } else {
        gear_table = gear_table_b6;
        gear_count = gear_count_b6;
        gear_max   = gear_max_b6;
    }
}

// --- 发送去重缓存 ---
static int last_bcast_valid = 0;
static int last_mode = -1;
static int last_target_temp = -1;
static int last_rpm = -1;
static int last_cold = -1;
static int last_wind_level = -1;

// --- 执行状态 ---
static int final_gear = LEVEL_INIT;   // 逻辑计算的目标档位（执行向此靠拢）

// 前向声明（配置系统函数位于 write_log/clamp 之前，C 要求先声明后使用）
static void write_log(const char *fmt, ...);
static inline int clamp(int val, int lo, int hi);
static void alarm_handler(int sig);
static void pid_align_from_gear(void);
static int compute_fan_target(void);

/* 调试日志宏：总开关 debug_mode=1 且对应分区开关=1 时才输出。
 * 注意：必须写成单行，多行续行在 NDK clang + CRLF 下会失效。 */
#define debug_log(flag, fmt, ...) do { if (debug_mode && (flag)) write_log("[DEBUG] " fmt, ##__VA_ARGS__); } while(0)
#define pid_log(fmt, ...) \
    do { if (debug_mode && debug_pid) \
        write_log("[PID] " fmt, ##__VA_ARGS__); \
    } while(0)

/** 解析 GEAR_B6X_N / GEAR_B7X_N 配置值 "模式,目标温度°C,风扇RPM,制冷强度" */
static int parse_gear_config_line(const char *val_str, GearConfigTemp *out) {
    int m, t, f, c;
    char *next;
    m = (int)strtol(val_str, &next, 10);
    if (*next != ',') return 0;
    t = (int)strtol(next + 1, &next, 10);
    if (*next != ',') return 0;
    f = (int)strtol(next + 1, &next, 10);
    if (*next != ',') return 0;
    c = (int)strtol(next + 1, NULL, 10);
    out->mode    = (m == 0) ? 0 : 1;
    out->target  = clamp(t, 5, 35);
    out->fan_rpm = clamp(f, 2000, 6000);
    out->cold    = clamp(c, 1, 194);
    return 1;
}

/** 收集 GEAR_B6X_N / GEAR_B7X_N 配置到临时表（编号越界或表满时跳过） */
static void collect_gear_config(const char *key, const char *val_str,
                                GearConfigTemp *configs, int *count) {
    int n = atoi(key + 9);
    if (n < 1 || n > GEAR_TABLE_MAX) return;
    if (*count < GEAR_TABLE_MAX &&
        parse_gear_config_line(val_str, &configs[*count])) {
        configs[*count].config_n = n;
        (*count)++;
    }
}

/**
 * 用配置档位表重建 B6X/B7X 独立档位表（按制冷/风扇强度升序排为连续档位表，防呆排序）。
 * 无有效配置时回退到默认档位表。
 */
static void rebuild_gear_table(GearEntry *table, GearConfigTemp *configs, int count,
                               int *out_count, int *out_max, const char *tag) {
    if (count > 0) {
        *out_count = 0;
        *out_max = 0;
        memset(table, 0, sizeof(*table) * GEAR_TABLE_MAX);
        qsort(configs, count, sizeof(GearConfigTemp), cmp_gear_config_cold);  // 防呆：按制冷/风扇升序
        for (int i = 0; i < count; i++) {
            configs[i].config_n = i + 1;   // 排序后重编号 1..count
            table[i].config_n = configs[i].config_n;
            table[i].mode     = configs[i].mode;
            table[i].target   = configs[i].target;
            table[i].fan_rpm  = configs[i].fan_rpm;
            table[i].cold     = configs[i].cold;
            (*out_count)++;
        }
        *out_max = *out_count;
        write_log("配置 %s 档位表 %d 级 (1~%d)", tag, *out_count, *out_max);
    } else {
        for (int i = 0; i < 12; i++) table[i] = DEFAULT_GEAR_TABLE[i];
        *out_count = 12;
        *out_max = 12;
        write_log("配置 %s 档位表无效，使用默认档位表 (%d 级)", tag, *out_count);
    }
}

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
    { "BATT_COOLDOWN_CYCLES",      &BATT_COOLDOWN_CYCLES,        0, 20 },
    { "EMERG_RECOVERY_PHASE_CYCLES", &EMERG_RECOVERY_PHASE_CYCLES, 1, 50 },
    { "CPU_FILTER_ALPHA",          &CPU_FILTER_ALPHA,            1, 100 },
    { "EMERG_EXIT_CAP_OFFSET",     &EMERG_EXIT_CAP_OFFSET,       0, 5 },
    { "EMERG_STEP",                &EMERG_STEP,                  1, 12 },
    { "EMERG_EXIT_BATT_THRESHOLD", &EMERG_EXIT_BATT_THRESHOLD,   5, 50 },
    { "TREND_RESET_THRESHOLD",     &TREND_RESET_THRESHOLD,       0, 20 },
    { "REV_COMP_COOLDOWN",         &REV_COMP_COOLDOWN,           0, 10 },
    { "RATE_LIMIT_TEMP",           &RATE_LIMIT_TEMP,             1, 30 },
    { "COLD_UP_DEADZONE",          &COLD_UP_DEADZONE,            1, 50 },
    { "BATT_SKIP_MAX",             &BATT_SKIP_MAX,               1, 60 },
    { "PID_KP",                    &pid_kp,                      1, 1000 },
    { "PID_KD",                    &pid_kd,                      0, 1000 },
    { "PID_KI_DEADBAND",           &pid_ki_deadband,             0, 100 },
    { "GEAR_PREDICT_ALPHA",        &gear_predict_alpha,          1, 100 },
    { "COLD_MAP_START",            &cold_map_start,              0, 194 },
    { "COLD_MAP_EXP",              &cold_map_exp,                50, 500 },
    { "RPM_SMOOTH_ALPHA",          &rpm_smooth_alpha,            1, 99 },
    { "CURRENT_GEAR_SMOOTH_ALPHA", &CURRENT_GEAR_SMOOTH_ALPHA,   1, 100 },
    { "CURRENT_GEAR_MIN",          &CURRENT_GEAR_MIN,            1, 12 },
    // sysfs 层（SYSFS_ENABLED=1）
    { "BATT_TEMP_DIVISOR",         &BATT_TEMP_DIVISOR,           1, 10000 },
    { "CPU_TEMP_DIVISOR",          &CPU_TEMP_DIVISOR,            1, 10000 },
    { "BATT_CURRENT_DIVISOR",      &BATT_CURRENT_DIVISOR,        1, 100000 },
    { "CPU_ZONE_RESCAN",           &cpu_zone_rescan_sec,         5, 3600 },
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
    else if (strcmp(key, "DEBUG_EMERG") == 0)   debug_emerg  = (val != 0);
    else if (strcmp(key, "DEBUG_BATT") == 0)    debug_batt   = (val != 0);
    else if (strcmp(key, "DEBUG_EXEC") == 0)    debug_exec   = (val != 0);
    else if (strcmp(key, "DEBUG_CONN") == 0)    debug_conn   = (val != 0);
    else if (strcmp(key, "DEBUG_CONFIG") == 0)  debug_config = (val != 0);
    else if (strcmp(key, "DEBUG_MAIN") == 0)    debug_main   = (val != 0);
    else if (strcmp(key, "DEBUG_PID") == 0)     debug_pid    = (val != 0);
    else if (strcmp(key, "DEBUG_LAUNCH") == 0)  debug_launch = (val != 0);
    else if (strcmp(key, "DEBUG_FAN") == 0)     debug_fan    = (val != 0);
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
    else if (strcmp(key, "LOG_FILE") == 0) {
        config_read_path(log_file_path, sizeof(log_file_path), val_str);
        record_log_path_for_uninstall(log_file_path);  // 记录自定义日志路径供卸载清理
    }
}

/** PID 专属多值配置（PERF 层） */
static int parse_pid_cfg(const char *key, int val, const char *val_str) {
    if (strcmp(key, "PID_INPUT_FILTER") == 0) {
        int on = pid_input_filter_enabled, a = pid_filter_auto_threshold_on, b = pid_filter_auto_threshold_off;
        int n = sscanf(val_str, "%d %d %d", &on, &a, &b);
        if (n >= 1) pid_input_filter_enabled = (on != 0);
        if (n >= 2) pid_filter_auto_threshold_on = clamp(a, 5, 100);
        if (n >= 3) pid_filter_auto_threshold_off = clamp(b, 5, 100);
        return 1;
    }
    if (strcmp(key, "PID_ALPHA") == 0) {
        int a = pid_filter_auto_alpha, b = pid_batt_alpha;
        if (sscanf(val_str, "%d %d", &a, &b) >= 2) { pid_filter_auto_alpha=clamp(a,1,100); pid_batt_alpha=clamp(b,1,100); }
        return 1;
    }
    if (strcmp(key, "PID_COLD") == 0) {
        int a = pid_cold_min, b = pid_cold_max, c = b7_pid_cold_max;
        int n = sscanf(val_str, "%d %d %d", &a, &b, &c);
        if (n >= 2) { pid_cold_min=clamp(a,0,194); pid_cold_max=clamp(b,0,194); }
        if (n >= 3) { b7_pid_cold_max = clamp(c, 1, B7X_COLD_MAX); }
        return 1;
    }
    if (strcmp(key, "PID_KI") == 0) {
        int k = pid_ki, l = pid_integral_limit;
        if (sscanf(val_str, "%d %d", &k, &l) >= 1) {
            pid_ki              = clamp(k, 0, 1000);
            pid_integral_limit  = clamp(l, 0, 1000);
        }
        return 1;
    }
    if (strcmp(key, "PID_KI_VAR") == 0) {
        int t = pid_ki_var_threshold, n = pid_ki_var_samples;
        if (sscanf(val_str, "%d %d", &t, &n) >= 1) {
            pid_ki_var_threshold = clamp(t, 0, 200);
            pid_ki_var_samples   = clamp(n, 2, 20);
        }
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
    return 0;
}

/** Gear 专属多值/开关/档位表配置（PERF 层） */
static int parse_gear_cfg(const char *key, int val, const char *val_str,
                          GearConfigTemp *gears_b6, int *cnt_b6,
                          GearConfigTemp *gears_b7, int *cnt_b7) {
    if (strcmp(key, "BATT_BOUNDARY") == 0) {
        int v[3] = {BATT_BOUNDARY_1,BATT_BOUNDARY_2,BATT_BOUNDARY_3};
        if (sscanf(val_str, "%d %d %d", &v[0],&v[1],&v[2]) >= 3)
            { BATT_BOUNDARY_1=clamp(v[0],1,100); BATT_BOUNDARY_2=clamp(v[1],1,100); BATT_BOUNDARY_3=clamp(v[2],1,100); }
        return 1;
    }
    if (strcmp(key, "CURRENT_GEAR_MULT") == 0) {
        int a = CURRENT_GEAR_MULT_CHARGE, b = CURRENT_GEAR_MULT_DISCHARGE;
        if (sscanf(val_str, "%d %d", &a, &b) >= 2)
            { CURRENT_GEAR_MULT_CHARGE=clamp(a,1,50); CURRENT_GEAR_MULT_DISCHARGE=clamp(b,1,50); }
        return 1;
    }
    if (strcmp(key, "REV_COMP_T") == 0) {
        int v[3] = {REV_COMP_THRESH_1,REV_COMP_THRESH_2,REV_COMP_THRESH_3};
        if (sscanf(val_str, "%d %d %d", &v[0],&v[1],&v[2]) >= 3)
            { REV_COMP_THRESH_1=clamp(v[0],1,50); REV_COMP_THRESH_2=clamp(v[1],1,50); REV_COMP_THRESH_3=clamp(v[2],1,50); }
        return 1;
    }
    if (strcmp(key, "EMERG_FORCED") == 0) {
        int v[4] = {EMERG_FORCED_1,EMERG_FORCED_2,EMERG_FORCED_3,EMERG_FORCED_4};
        if (sscanf(val_str, "%d %d %d %d", &v[0],&v[1],&v[2],&v[3]) >= 4)
            { EMERG_FORCED_1=clamp(v[0],0,12); EMERG_FORCED_2=clamp(v[1],0,12); EMERG_FORCED_3=clamp(v[2],0,12); EMERG_FORCED_4=clamp(v[3],0,12); }
        return 1;
    }
    if (strcmp(key, "EMERG_RECOVERY_MULT") == 0) {
        int v[3] = {EMERG_RECOVERY_MULT_1,EMERG_RECOVERY_MULT_2,EMERG_RECOVERY_MULT_3};
        if (sscanf(val_str, "%d %d %d", &v[0],&v[1],&v[2]) >= 3)
            { EMERG_RECOVERY_MULT_1=clamp(v[0],1,20); EMERG_RECOVERY_MULT_2=clamp(v[1],1,20); EMERG_RECOVERY_MULT_3=clamp(v[2],1,20); }
        return 1;
    }
    if (strcmp(key, "CPU_EMERG") == 0) {
        int v[4] = {CPU_RECOVER_0,CPU_EMERG_1,CPU_EMERG_2,CPU_EMERG_3};
        if (sscanf(val_str, "%d %d %d %d", &v[0],&v[1],&v[2],&v[3]) >= 4) {
            CPU_RECOVER_0=clamp(v[0],300,700); CPU_EMERG_1=clamp(v[1],400,800);
            CPU_EMERG_2=clamp(v[2],500,900);   CPU_EMERG_3=clamp(v[3],600,1000);
            CPU_RECOVER_1=CPU_EMERG_1; CPU_RECOVER_2=CPU_EMERG_2; // 自动同步恢复阈值
        }
        return 1;
    }
    if (strcmp(key, "CTRL_MODE") == 0)            { ctrl_mode = (val != 0); return 1; }
    if (strcmp(key, "GEAR_AUTO_FAN") == 0)        { gear_auto_fan = (val != 0); return 1; }
    if (strcmp(key, "EMERG_CPU_ENABLED") == 0)    { EMERG_CPU_ENABLED = (val != 0); return 1; }
    if (strcmp(key, "GEAR_CONFIG_ENABLED") == 0)  { gear_config_enabled = (val != 0); return 1; }
    if (strcmp(key, "REV_COMP") == 0) {
        int a = REV_COMP_ENABLED, b = TREND_EXEMPT_ENABLED;
        if (sscanf(val_str, "%d %d", &a, &b) >= 1) {
            REV_COMP_ENABLED     = (a != 0);
            TREND_EXEMPT_ENABLED = (b != 0);
        }
        return 1;
    }
    if (strcmp(key, "CURRENT_GEAR_MODE") == 0) {
        int charge = CURRENT_GEAR_MODE_CHARGE, discharge = CURRENT_GEAR_MODE_DISCHARGE;
        if (sscanf(val_str, "%d %d", &charge, &discharge) >= 1) {
            CURRENT_GEAR_MODE_CHARGE    = clamp(charge, 0, 1);
            CURRENT_GEAR_MODE_DISCHARGE = clamp(discharge, 0, 1);
        }
        return 1;
    }
    if (strcmp(key, "EMERG_MODE") == 0) {
        int entry = EMERG_MODE_ENTRY, exit = EMERG_MODE_EXIT;
        if (sscanf(val_str, "%d %d", &entry, &exit) >= 1) {
            EMERG_MODE_ENTRY = clamp(entry, 0, 1);
            EMERG_MODE_EXIT  = clamp(exit, 0, 1);
        }
        return 1;
    }
    // --- 电流-挡位子项（无 CURRENT_GEAR_MODE 子守卫）---
    if (strncmp(key, "CURRENT_GEAR_", 13) == 0) {
        if      (strcmp(key, "CURRENT_GEAR_SMOOTH_ALPHA") == 0)
            CURRENT_GEAR_SMOOTH_ALPHA = clamp(val, 1, 100);
        else if (strcmp(key, "CURRENT_GEAR_MIN") == 0)
            CURRENT_GEAR_MIN = clamp(val, 1, 12);
        return 1;
    }
    if (strcmp(key, "GEAR_PREDICT_WIN") == 0) {
        int a = gear_predict_buf_n, b = gear_predict_win_n, c = gear_predict_min_points;
        if (sscanf(val_str, "%d %d %d", &a, &b, &c) >= 3) {
            gear_predict_buf_n      = clamp(a, 3, 32);
            gear_predict_win_n      = clamp(b, 3, 10);
            gear_predict_min_points = clamp(c, 2, 5);
        }
        return 1;
    }
    if (strcmp(key, "GEAR_PREDICT_RISE") == 0) {
        int a = gear_predict_max_rise, b = gear_predict_ramp_cycles, d = gear_predict_min_delta;
        if (sscanf(val_str, "%d %d %d", &a, &b, &d) >= 1) {
            gear_predict_max_rise    = clamp(a, 10, 100);
            gear_predict_ramp_cycles = clamp(b, 0, 10);
            gear_predict_min_delta   = clamp(d, 1, 10);
        }
        return 1;
    }
    if (strcmp(key, "GEAR_PREDICT_WEIGHT") == 0) {
        int h = gear_predict_heat_weight, c = gear_predict_cool_weight, s = gear_predict_suppress;
        if (sscanf(val_str, "%d %d %d", &h, &c, &s) >= 1) {
            gear_predict_heat_weight = clamp(h, 0, 10);
            gear_predict_cool_weight = clamp(c, 0, 10);
            gear_predict_suppress     = clamp(s, 0, 100);
        }
        return 1;
    }
    // --- 档位表（无 gear_config_enabled 子守卫，收集后由后处理判断）---
    if (strncmp(key, "GEAR_B7X_", 9) == 0) { collect_gear_config(key, val_str, gears_b7, cnt_b7); return 1; }
    if (strncmp(key, "GEAR_B6X_", 9) == 0) { collect_gear_config(key, val_str, gears_b6, cnt_b6); return 1; }
    return 0;
}

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
        int base = RATE_LIMIT_COLD, mult = RATE_LIMIT_COLD_MULT;
        if (sscanf(val_str, "%d %d", &base, &mult) >= 1) {
            RATE_LIMIT_COLD      = clamp(base, 1, 194);
            RATE_LIMIT_COLD_MULT = clamp(mult, 1, 100);
        }
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
    int old_ctrl_mode = ctrl_mode;  // 保存旧值，用于模式切换过渡检测

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
        }
    }

    // debug_mode 必须在提前 return 之前更新：PERF=0 且 DEBUG=0 时也要清零，
    // 否则 debug_mode 保持旧值 → 分区开关不重解析、debug 日志继续输出
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
    gear_config_enabled = 0;   // 每轮重置（原为 load_config 局部变量语义；配置未写该键时回默认）
    GearConfigTemp config_gears_b6[GEAR_TABLE_MAX];
    GearConfigTemp config_gears_b7[GEAR_TABLE_MAX];
    int config_gear_count_b6 = 0;
    int config_gear_count_b7 = 0;
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
        if (parse_gear_cfg(key, val, val_str, config_gears_b6, &config_gear_count_b6,
                           config_gears_b7, &config_gear_count_b7)) continue;
        if (parse_common_cfg(key, val, val_str)) continue;
        debug_log(debug_config, "配置 未识别键 %s（已忽略）", key);
    }
    fclose(f);

    // CTRL_MODE 变化过渡处理（模式切换：PID/Gear 相互对齐，状态各自清理）
    if (ctrl_mode != old_ctrl_mode) {
        last_bcast_valid = 0;
        if (ctrl_mode == 1) {
            // 0→1 切 PID：清 Gear 预测状态，从当前档位对齐 PID 初始输出
            gear_predict_smoothed = -1;
            gear_predict_was_active = 0;
            gear_predict_consecutive = 0;
            gear_predict_buf_cnt = 0;
            gear_predict_buf_head = 0;
            if (config_mtime != 0)
                pid_align_from_gear();
        } else {
            // 1→0 切 Gear：用 PID 无级对齐量映射回档位（无缝接管，无跳变）
            if (pid_ratio_saved >= 0.0f) {
                batt_gear_base = clamp((int)(pid_ratio_saved * (gear_max - gear_min) + gear_min + 0.5f),
                                       gear_min, gear_max);
                final_gear = batt_gear_base;
            }
        }
        write_log("配置 CTRL_MODE=%d", ctrl_mode);
    }

    // --- GEAR_B6X_N / GEAR_B7X_N 后处理：B6X/B7X 各排序重排为连续档位表 ---
    if (gear_config_enabled) {
        rebuild_gear_table(gear_table_b6, config_gears_b6, config_gear_count_b6,
                           &gear_count_b6, &gear_max_b6, "b6x");
        rebuild_gear_table(gear_table_b7, config_gears_b7, config_gear_count_b7,
                           &gear_count_b7, &gear_max_b7, "b7x");

        // 切换活动表指针与计数，同步范围
        select_gear_table();
        // 档位表重排后 actual 值复位：以散热器实际回传为准初始化（回传异常用最小合法值保底），
        // 避免删直通后 -1 初值步进出负值
        if (cooler_cold_real >= COLD_MIN) actual_cold = cooler_cold_real;
        else actual_cold = COLD_MIN;
        if (cooler_rpm_real >= fan_rpm_min) actual_rpm = cooler_rpm_real;
        else actual_rpm = fan_rpm_min;
        actual_target_temp = -1;
        batt_gear_base = clamp(batt_gear_base, gear_min, gear_max);
    }

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
 * LOG_MAX=0 时关闭日志。持持久 FILE* 避免每行 open/close。
 */
static void write_log(const char *fmt, ...) {
    if (LOG_MAX == 0) return;     // 日志关闭

    int max_bytes = LOG_MAX;

    // 超标 → 截断保留尾部（调试模式下跳过限制，保留完整日志）。
    // ftruncate 只能从尾部截断，删头部必须先把尾部内容前移到文件头再截断。
    // 旧实现直接 ftruncate(st_size - max_bytes) 是反向的：保留头部、删掉最新日志，且超限越多删得越过头，已废弃。
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

/** 返回 x 的符号：正→1，负→-1，零→0 */
static inline int sign_of(int x) {
    if (x > 0) return 1;
    if (x < 0) return -1;
    return 0;
}

/** 设备代号（日志显示用）：B7X→"b7x"，其余→"b6x" */
static const char *device_tag_of(DeviceType dev) {
    return (dev == DEVICE_B7X) ? "b7x" : "b6x";
}

/** 温差绝对值 → 档位偏移量（三区间阈值：1/2/3 档） */
static inline int temp_delta_by_boundary(int ad, int z1, int z2, int z3) {
    if (ad > z3) return 3;
    if (ad > z2) return 2;
    if (ad > z1) return 1;
    return 0;
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

/** 清除趋势豁免 / 反补累积状态 */
static inline void reset_exempt_state(void) {
    trend_exempt_count = 0;
    trend_anchor_temp = -1;
    rev_comp_pending_delta = 0;
    rev_comp_pending_idle = 0;
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

    // 切换活动档位表（B6X/B7X 独立表）
    select_gear_table();
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
    while (fgets(line, sizeof(line), f)) {
        if (strncmp(line, "BLE=", 4) == 0) {
            app_ble_connected = (atoi(line + 4) != 0);
        } else if (strncmp(line, "HOT_TEMP=", 9) == 0) {
            cooler_hot_temp = atoi(line + 9);
        } else if (strncmp(line, "COLD_TEMP=", 10) == 0) {
            cooler_cold_temp = atoi(line + 10);
        } else if (strncmp(line, "RPM_REAL=", 9) == 0) {
            cooler_rpm_real = atoi(line + 9);
        } else if (strncmp(line, "COLD_REAL=", 10) == 0) {
            cooler_cold_real = atoi(line + 10);
        }
    }
    fclose(f);
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
    // Scene 式：定时轮询 + 纯数值比较，不依赖 sysfs mtime。
    // 部分内核的 sysfs 温度文件 mtime 更新不可靠（不随值变化更新），原 mtime 判断
    // 会导致温度实际在变却被判"未更新"而大量跳过。改为值比较：值变化才标记更新。
    int raw = read_sysfs_int(BATT_TEMP_PATH);
    if (raw < 0) {
        batt_temp_updated = 0;
        return -1;
    }
    int val = raw / BATT_TEMP_DIVISOR;
    debug_log(debug_sensor, "batt_temp 原始 %d 除数 %d = %d (%.1f°C)",
              raw, BATT_TEMP_DIVISOR, val, val / 10.0);
    batt_temp_updated = (val != batt_cached_temp);   // 值变化才标记更新
    batt_cached_temp = val;
    return val;
}

/**
 * 读取电池电流，返回 0.01A 单位（正=放电，负=充电），失败返回 0。
 */
static int read_batt_current_ua10(void) {
    int val = read_sysfs_int(BATT_CURRENT_PATH);
    if (val == 0) return 0;
    int ua10 = val / BATT_CURRENT_DIVISOR;
    debug_log(debug_sensor, "batt_curr 原始 %d 除数 %d = %d (%.2fA)",
              val, BATT_CURRENT_DIVISOR, ua10, ua10 / 100.0);
    return ua10;
}

/**
 * 缓存已发现的 CPU 温度 zone（首次全量扫描后记录）
 */
#define CPU_ZONE_MAX_CACHE 64
#define CPU_ZONE_TOP_KEEP   10   // 只保留温度最高的 N 个 zone（CPU 紧急取 max，前 10 已具代表性）
static int cpu_zone_cache[CPU_ZONE_MAX_CACHE];
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
 * 读取 CPU 最高温度，返回 0.1°C（如 753 = 75.3°C）
 *
 * 首次调用：扫描 thermal_zone0~99，记录所有能读到有效值的 zone
 * 后续调用：只扫描已记录的 zone 列表，取最高值
 *
 * 原始值 m°C，除以 100 转 0.1°C
 * 全部失败返回 -1
 */
static int read_cpu_temp_max(void) {
    time_t now = time(NULL);
    // 首次调用 或 距上次全量扫描超过 cpu_zone_rescan_sec → 在 CPU_ZONE_MIN~MAX 范围内重扫。
    // 周期重扫让保留列表跟随温度分布变化（负载迁移到其它 zone 时更新），避免固定 zone 失真。
    if (!cpu_zone_scanned || now - cpu_zone_last_scan >= cpu_zone_rescan_sec) {
        ZoneReading readings[CPU_ZONE_MAX_CACHE];
        int count = 0;
        for (int i = CPU_ZONE_MIN; i <= CPU_ZONE_MAX; i++) {
            int raw = read_thermal_zone_raw(i);
            if (raw < 0) continue;
            if (count < CPU_ZONE_MAX_CACHE) {
                readings[count].id  = i;
                readings[count].raw = raw;
                count++;
            }
        }

        // 按温度降序排列，保留温度最高的 CPU_ZONE_TOP_KEEP 个
        qsort(readings, count, sizeof(ZoneReading), cmp_zone_desc);
        int keep = count < CPU_ZONE_TOP_KEEP ? count : CPU_ZONE_TOP_KEEP;
        for (int i = 0; i < keep; i++)
            cpu_zone_cache[i] = readings[i].id;
        cpu_zone_count = keep;
        cpu_zone_scanned = 1;
        cpu_zone_last_scan = now;

        if (keep == 0) {
            debug_log(debug_sensor, "thermal_zone 扫描 无可读 zone（路径 %s），CPU 紧急无法触发",
                      CPU_TEMP_PATH_FMT);
        } else {
            debug_log(debug_sensor, "thermal_zone 扫描 发现 %d 个有效 zone，保留 %d 个最高温（%ds 后重扫）",
                      count, keep, cpu_zone_rescan_sec);
        }
    }

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
static int active_cold_eff_min = 1;    // 有效制冷下限（Gear=COLD_MIN，PID=pid_cold_min）
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
 * 计算当前模式有效制冷范围（Gear=档位表最高档，PID=PID_COLD 上限；均含热端过温削减）。
 * 每 5s 周期在 update_hot_derate 之后调用，供下发/去重/映射统一使用，消除模式分支散落。
 */
static void update_active_cold_range(void) {
    if (ctrl_mode == 1) {
        active_cold_eff_min = pid_cold_min;
        active_cold_eff_max = eff_cold_max(active_pid_cold_max, pid_cold_min);
    } else {
        active_cold_eff_min = COLD_MIN;
        // 基准上限 = 档位表最高档制冷（档位表已按制冷升序）
        int base = (gear_max >= 1 && gear_max <= gear_count)
                 ? gear_table[gear_max - 1].cold : COLD_MIN;
        active_cold_eff_max = eff_cold_max(base, COLD_MIN);
    }
}

// ======================== 控制参数计算与下发 ========================

/**
 * 根据档位查表计算 setRunMode 参数（档位与风扇/制冷非线性）。
 *
 * mode=0 智能温控：targetTemperature + windLevel（风扇上限）。
 * mode=1 固定功率：windLevelOverclock（风扇）+ coldLevelOverclock（制冷）。
 */
static void build_params(int level,
                         int *out_mode,
                         int *out_target,
                         int *out_windOC,
                         int *out_coldOC,
                         int *out_windLevel)
{
    // 防御性钳制：确保档位索引不越界（调用栈已保证，但作为内部接口增加保护）
    if (level < gear_min || level > gear_max) level = gear_min;
    int idx = level - 1;
    int mode   = gear_table[idx].mode;
    int target = gear_table[idx].target;
    int fan    = gear_table[idx].fan_rpm;
    int cold   = gear_table[idx].cold;

    target = clamp(target, 5, 35);

    if (mode == 0) {
        // --- 智能温控 ---
        *out_windLevel = fan;
        *out_windOC    = 0;
        *out_coldOC    = 0;   // 智能模式让散热器自行管理制冷
    } else {
        // --- 固定功率 ---
        *out_windOC    = fan;
        *out_coldOC    = clamp(cold, COLD_MIN, active_cold_eff_max);
        *out_windLevel = 0;
    }

    *out_mode   = mode;
    *out_target = target;
}

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
    // 父进程：限时等待子进程（3 秒超时，防止 am 卡死阻塞 daemon）
    signal(SIGALRM, alarm_handler);
    alarm(3);
    int status;
    if (waitpid(pid, &status, 0) == -1) {
        write_log("am broadcast 超时");
        kill(pid, SIGKILL);
        waitpid(pid, NULL, 0);
    } else if (WIFEXITED(status) && WEXITSTATUS(status) != 0) {
        // am 退出码非零（127=命令未找到等）→ 广播未送达，必须让故障可见，否则
        // daemon 会持续重发而散热器永远不动（正是之前"日志正常但实际不变"的静默根因）。
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
    debug_log(debug_fan, "cold 限速 %d→%d desired=%d（升%d 降%d）",
              old_cold, actual_cold, desired_cold, cold_up, cold_down);
}

/**
 * 风扇转速限速（升降独立速率，含降速防抖）。
 * 返回限速后的实际风扇转速，向上取整到 50 的倍数并钳制到设备范围。
 *
 * 防抖仅在下降低于阈值内时生效（上升自由爬升，避免数周期锁死）；
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
    debug_log(debug_fan, "rpm 限速 desired=%d → %d（防抖保持=%d）", desired_rpm, send_rpm,
              (fan_rpm_change_threshold > 0 && !near_min_rpm &&
               desired_rpm < actual_rpm && (actual_rpm - desired_rpm) <= fan_rpm_change_threshold));
    return send_rpm;
}

/**
 * 下发去重 + 制冷上升死区判定：返回 1 表示跳过本次下发。
 *
 * 去重以散热器实际回传为准：要播发值与散热器实际值一致视为已到位，跳过下发，
 * 解决"日志报告已变化，但实际因广播丢失/BLE 失败未成功"导致的无法达到最高/最低制冷强度。
 * 回传异常（status 文件读失败，实际值 < 0）时退化用 last_* 缓存对比。
 *
 * 制冷上升死区：制冷强度变化时会在限制以下波动一段时间，所以如果上升值较少不如不升。
 * 制冷上升且"要下发值 − 散热器实际值 ≤ COLD_UP_DEADZONE"时跳过；
 * 距最高/最低制冷强度 < 阈值×2 时死区失效（接近极值必须允许精确到位）。
 * 下降方向不受限（快速响应撤冷）。
 */
static int should_skip_dispatch(int mode, int target, int windOC, int cold, int windLevel) {
    int send_rpm = (mode == 0) ? windLevel : windOC;

    if (cooler_cold_real >= 0 && cooler_rpm_real >= 0) {
        if (cold == cooler_cold_real && send_rpm == cooler_rpm_real) {
            debug_log(debug_exec, "skip 已到位：目标冷%d RPM%d == 回传冷%d RPM%d，跳过下发",
                      cold, send_rpm, cooler_cold_real, cooler_rpm_real);
            return 1;   // 散热器实际已到位
        }

        int diff = cold - cooler_cold_real;
        if (diff > 0) {
            int cmin = active_cold_eff_min;   // 当前模式有效范围（main_loop 统一计算）
            int cmax = active_cold_eff_max;
            int near_extreme = (cmax - cooler_cold_real) < COLD_UP_DEADZONE * 2
                            || (cooler_cold_real - cmin) < COLD_UP_DEADZONE * 2;
            if (!near_extreme && diff <= COLD_UP_DEADZONE) {
                debug_log(debug_exec, "skip 制冷上升死区：目标冷%d 回传冷%d diff=%d ≤死区%d，跳过下发",
                          cold, cooler_cold_real, diff, COLD_UP_DEADZONE);
                return 1;   // 上升太少，不如不升
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

/**
 * 下发控制参数（如有变化）
 * 通过 am broadcast 发送到 LSPosed 模块
 *
 * 注意：散热器每次调整都会暂时性能下降，所以参数无变化时必须跳过
 * 返回 1=已发送，0=跳过（无变化）
 */
static int apply_gear(int level) {
    int mode, target, windOC, coldOC, windLevel;

    level = clamp(level, gear_min, gear_max);
    build_params(level, &mode, &target, &windOC, &coldOC, &windLevel);

    // 制冷强度限速（升降独立，负值方向已 clamp 到 0）
    rate_limit_cold(coldOC);

    // GEAR_AUTO_FAN：独立风扇目标（基于限速后实际制冷 + 热端），挡位表风扇转速变为截断上限
    if (gear_auto_fan && mode == 1) {
        int cap_rpm = windOC;
        int calc_rpm = compute_fan_target();
        windOC = (calc_rpm < cap_rpm) ? calc_rpm : cap_rpm;
    }

    // 风扇转速限速（升降独立，含降速防抖）
    int desired_rpm = (mode == 0) ? windLevel : windOC;
    int send_rpm = rate_limit_fan(desired_rpm);

    // 目标温度限速（仅智能温控模式；回传无目标温度字段，<0 时显式初始化为目标档位 target）
    if (actual_target_temp < 0)
        actual_target_temp = target;
    else if (mode == 0)
        rate_limit(&actual_target_temp, target, RATE_LIMIT_TEMP, RATE_LIMIT_TEMP);

    // ---- 用限速后的实际值替换查表值 ----
    coldOC = actual_cold;
    target = actual_target_temp;

    // ---- 热端过温边界钳制（去重前生效；不同步 actual_cold，风扇由 actual_cold 推算保持高转速散热）----
    int cold_pre_clamp = coldOC;
    if (hot_derate > 0) {
        int cold_cap = active_cold_eff_max;
        if (coldOC > cold_cap) coldOC = cold_cap;
    }

    // ---- 风扇转速向上取整到 50 的倍数（rate_limit_fan 已钳制到设备范围）----
    if (mode == 0)
        windLevel = send_rpm;
    else
        windOC = send_rpm;

    // ---- 去重检测 + 制冷上升死区（以散热器实际回传为准）----
    if (should_skip_dispatch(mode, target, windOC, coldOC, windLevel)) {
        return 0;   // 跳过原因日志已由 should_skip_dispatch 内部输出
    }

    // 过热钳制冷动作日志（仅在实际下发时输出，与去重判定一致）
    if (coldOC < cold_pre_clamp)
        write_log("过热钳制冷 %d→%d（上限削减 %d）", cold_pre_clamp, coldOC, hot_derate);

    send_am_broadcast(mode, target, windOC, coldOC, windLevel);
    // Gear 模式下发成功常驻快照（与 PID 模式 apply_gear_direct 对齐，消除下发可见性不对称）
    write_log("%s 档位%d mode=%d 冷%d 热%d° RPM%d 目标%d°C",
              device_tag_of(active_device), gear_label(level), mode,
              coldOC, (cooler_hot_temp > 0) ? cooler_hot_temp / 10 : 0,
              send_rpm, target);

    // ---- 更新缓存 ----
    last_bcast_valid   = 1;
    last_mode          = mode;
    last_target_temp   = target;
    last_rpm           = windOC;
    last_cold          = coldOC;
    last_wind_level    = windLevel;

    return 1;
}

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
 * 自动拉起上次使用的散热器 app，带冷却防止反复拉起被杀。
 * 包名按 last_owner 选择：2→新 B6X app，6/7→farsef，其余/无记录→老 B6X app；
 * 目标 B6X app 未安装时回退另一个 B6X app。
 * 拉起用 am start（显式 launcher 组件 -n）+ b6x_auto_launch 标志（LSP 读到后连接完成自动后台化，几乎无感）。
 * 仅在 APP_LAUNCH_ENABLED=1 且目标 app 已安装、未运行时执行。
 */
static void launch_last_app(void) {
    time_t now = time(NULL);
    if (now - last_launch_attempt < APP_LAUNCH_COOLDOWN) return;   // 冷却节流（含开关关闭，避免断联刷屏）
    last_launch_attempt = now;
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
    int rc = system(cmd);
    write_log("自动拉起散热器 app %s（后台化）rc=%d", pkg, rc);
}

/** 淘汰存活参与者：非保留者且非前台时 force-stop（在前台则等下周期再试） */
static void evict_app_if_eligible(int alive, const char *keep, const char *pkg) {
    if (alive && keep != pkg && !is_foreground_pkg(pkg)) {
        write_log("app 仲裁 强制停止 %s（保留 %s）", pkg, keep);
        // 输出重定向到 /dev/null，避免泄漏进日志（service.sh 把 stdout/stderr 指向日志）
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
static void emerg_recovery_advance(void) {
    if (emerg_recovery_cycles > 0) {
        emerg_recovery_cycles--;
        if (emerg_recovery_cycles == 0) {
            if (emerg_recovery_phase == 1) {
                // P1 → P2
                emerg_recovery_mult = EMERG_RECOVERY_MULT_2;
                emerg_recovery_phase = 2;
                emerg_recovery_cycles = EMERG_RECOVERY_PHASE_CYCLES;
                debug_log(debug_batt, "recovery P1→P2 倍率%d→%d", EMERG_RECOVERY_MULT_1, EMERG_RECOVERY_MULT_2);
            } else if (emerg_recovery_phase == 2) {
                // P2 → P3
                emerg_recovery_mult = EMERG_RECOVERY_MULT_3;
                emerg_recovery_phase = 3;
                emerg_recovery_cycles = EMERG_RECOVERY_PHASE_CYCLES;
                debug_log(debug_batt, "recovery P2→P3 倍率%d→%d", EMERG_RECOVERY_MULT_2, EMERG_RECOVERY_MULT_3);
            } else if (emerg_recovery_phase >= 3) {
                // P3 结束 → 恢复正常
                emerg_recovery_mult = 1;
                emerg_recovery_phase = 0;
                debug_log(debug_batt, "recovery P3 结束，恢复正常");
            }
        }
    }
}

/**
 * 过冲反补 + 趋势豁免（三区×双向×三级阈值）。
 * 输入为 battery_control 本轮的调档上下文；通过 *skip_delta 传递"本次跳过常规升降档"。
 */
static void rev_comp_and_trend(int batt, int delta, int batt_change, int abs_change,
                               int eff_z2, int cur_idle, int in_cooldown,
                               int *skip_delta) {
    if (abs_change > 0) {
        int trend_rev = (delta > 0 && batt < last_batt_reading) ||
                        (delta < 0 && batt > last_batt_reading);
        int dir = (batt_change > 0) ? 1 : -1;  // +1=升温, -1=降温

        // 三区判断：冷外区 / 内区 / 热外区
        int is_cold_outer = (batt <= BATT_BASELINE - eff_z2);
        int is_hot_outer  = (batt >= BATT_BASELINE + eff_z2);
        int in_inner_zone = !is_cold_outer && !is_hot_outer;

        // 根据方向+区域查三级阈值（0.1°C 单位，999=无穷大）
        // REV_COMP_THRESH_1/2/3 默认 2/3/4 = 0.2°C / 0.3°C / 0.4°C 每周期，可通过 profile.conf 配置
        int t1 = 999, t2 = 999, t3 = 999;
        if (dir > 0) {
            if      (is_cold_outer) { t1 = REV_COMP_THRESH_3; }
            else if (in_inner_zone) { t1 = REV_COMP_THRESH_2; t2 = REV_COMP_THRESH_3; }
            else                   { t1 = REV_COMP_THRESH_1; t2 = REV_COMP_THRESH_2; t3 = REV_COMP_THRESH_3; }
        } else {
            if      (is_cold_outer) { t1 = REV_COMP_THRESH_1; t2 = REV_COMP_THRESH_2; t3 = REV_COMP_THRESH_3; }
            else if (in_inner_zone) { t1 = REV_COMP_THRESH_2; t2 = REV_COMP_THRESH_3; }
            else                   { t1 = REV_COMP_THRESH_3; }
        }

        // 统一计算每周期速率（用于下方趋势豁免和反补）
        int total_abs = abs_change + rev_comp_pending_delta;
        int total_interval = (cur_idle + 1) + rev_comp_pending_idle;
        int rate = total_abs / total_interval;
        if (rate < 1) rate = 1;

        // 计算跨过几个阈值（用于反补档位数和豁免范围判断）
        int steps = (rate > t1) + (rate > t2) + (rate > t3);

        // --- 趋势豁免（抬高生效阈值） ---
        // 豁免阈值随速率提高而抬高：
        //   steps=0(T1未触发) → 豁免区间 [0, T1)（原行为）
        //   steps=1(T1已触发, T2未触发) → 豁免区间 [T1, T2)（抬至T1以上）
        //   steps=2(T2已触发, T3未触发) → 豁免区间 [T2, T3)（抬至T2以上）
        //   steps=3(T3已触发) → 始终不豁免
        //
        // 温度锚点复位：首次豁免记录当前温度为锚点。区间中间值（steps=0→T1/2,
        // steps=1→(T1+T2)/2, steps=2→(T2+T3)/2）作为偏移量：降温豁免用减号
        // （锚点-偏移量=复位阈值），升温豁免用加号（锚点+偏移量=复位阈值）。
        // 电池温度越过复位阈值后豁免计数器复位，下轮以新锚点重新开始
        if (TREND_EXEMPT_ENABLED && !in_cooldown && rev_comp_pending_delta == 0 && steps < 3) {
            if (trend_rev && batt_gear_base > gear_min &&
                batt_gear_base < gear_max)
            {
                if (trend_exempt_count == 0) {
                    // 首次豁免：记录锚点温度
                    trend_anchor_temp = batt;
                    write_log("趋势豁免 %d", gear_label(batt_gear_base));
                    trend_exempt_count++;
                    *skip_delta = 1;
                } else {
                    // 持续豁免中：计算当前区间中间值（0.1°C）
                    int band_mid;
                    if      (steps == 0) band_mid = REV_COMP_THRESH_1 / 2;
                    else if (steps == 1) band_mid = (REV_COMP_THRESH_1 + REV_COMP_THRESH_2) / 2;
                    else                 band_mid = (REV_COMP_THRESH_2 + REV_COMP_THRESH_3) / 2;
                    if (band_mid < 1) band_mid = 1;

                    // 降温（delta<0，温度向基准降温）→ 锚点 - 中值 = 复位下限
                    // 升温（delta>0，温度向基准升温）→ 锚点 + 中值 = 复位上限
                    int reset_threshold;
                    int reset_triggered = 0;
                    if (delta < 0) {
                        reset_threshold = trend_anchor_temp - band_mid;
                        if (batt <= reset_threshold) reset_triggered = 1;
                    } else {
                        reset_threshold = trend_anchor_temp + band_mid;
                        if (batt >= reset_threshold) reset_triggered = 1;
                    }

                    if (reset_triggered) {
                        // 温度越过复位阈值 → 复位豁免
                        trend_exempt_count = 0;
                    } else {
                        trend_exempt_count++;
                        *skip_delta = 1;
                    }
                }
            } else {
                trend_exempt_count = 0;
            }
        }

        // --- 反补（不为全效豁免时执行） ---
        if (REV_COMP_ENABLED && !*skip_delta && (steps > 0 || rev_comp_pending_delta > 0)) {
            trend_exempt_count = 0;

            if (rev_comp_cooldown == 0) {
                // 冷却已到 → 用速率查表执行反补
                int adjust = dir * steps;

                rev_comp_pending_delta = 0;
                rev_comp_pending_idle = 0;

                if (adjust != 0) {
                    int old = batt_gear_base;
                    batt_gear_base += adjust;
                    batt_gear_base = clamp(batt_gear_base, gear_min, gear_max);
                    *skip_delta = 1;
                    if (old != batt_gear_base) {
                        batt_gear_cooldown = BATT_COOLDOWN_CYCLES;
                        rev_comp_cooldown = REV_COMP_COOLDOWN;
                        write_log("过冲%d/%d 挡位%d（%+d）",
                                  rate / 10, rate % 10,
                                  gear_label(batt_gear_base), adjust);
                    }
                }
            } else {
                // 冷却期内累积温差和周期数，不做调整
                rev_comp_pending_delta = total_abs;
                rev_comp_pending_idle = total_interval;
                debug_log(debug_batt, "batt_ctrl 反补冷却中 累积 abs=%d 周期=%d", total_abs, total_interval);
            }
        }
    }
}

/**
 * 根据电池温度调整基础档位，每 5 秒一次。
 *
 * 死区 ±ZONE_1 / ±1 档至 ZONE_2 / ±2 档至 ZONE_3 / ±3 档以上。
 * 温度不变时跳过升降档；档位变动后冷却 BATT_COOLDOWN_CYCLES 周期。
 * 紧急退出恢复期：将 BOUNDARY 阈值乘以恢复倍率，降低灵敏度。
 *
 * 反补查表：三区（冷外/内/热外）× 方向（升/降温）× 三级阈值（REV_COMP_THRESH_1/2/3）。
 * 趋势豁免：反补被抑制时抬高生效阈值，锚点温度复位。
 */
static void battery_control(void) {
    int batt = gear_input_batt;   // Gear 调档输入温度（预测温度+CPU 补偿，gear 分支开头已计算）
    if (batt < 0) {
        return;   // 无有效温度，跳过本周期（idle 已由 main_loop 入口统一维护）
    }

    // --- 紧急退出恢复期：阶段推进（放在首次读取判断之前，确保冷却期中也能正常走完各阶段）---
    emerg_recovery_advance();

    // 首次读取（启动后/重连后第一次）：不参与任何判断，数据正常更新，直接进入冷却
    if (last_batt_reading < 0) {
        last_batt_reading = batt;
        batt_gear_cooldown = BATT_COOLDOWN_CYCLES;
        return;
    }

    // 计算本周期温度变化量和常规升降档量（先算，给跳过逻辑参考）
    // last_batt_reading 必定 >= 0（上方已早退处理 <0 的情况）
    int batt_change = batt - last_batt_reading;
    int abs_change = abs(batt_change);
    int diff = batt - BATT_BASELINE;
    int ad = abs(diff);
    int sign = sign_of(diff);
    // 紧急退出恢复期：将 BATT_BOUNDARY 阈值乘以恢复倍率，降低调档灵敏度
    int eff_z1 = BATT_BOUNDARY_1 * emerg_recovery_mult;
    int eff_z2 = BATT_BOUNDARY_2 * emerg_recovery_mult;
    int eff_z3 = BATT_BOUNDARY_3 * emerg_recovery_mult;
    int delta = temp_delta_by_boundary(ad, eff_z1, eff_z2, eff_z3) * sign;

    debug_log(debug_batt, "batt_ctrl temp=%d (%.1f°C) diff=%d ad=%d sign=%d eff_z=[%d/%d/%d] delta=%d rec_mul=%d",
              batt, batt / 10.0, diff, ad, sign, eff_z1, eff_z2, eff_z3, delta, emerg_recovery_mult);

    int cur_idle = temp_idle_cycles;  // 快照：自上次有效变化以来已过的空闲周期数

    // 温度跳过判定：1s 层检测到值变化（batt_window_changed）→ 进计算；
    // 未变但 idle 未达 BATT_SKIP_MAX → 跳过；达上限 → 强制处理一次（防卡死）。
    // idle 递增已由 main_loop 入口统一维护，此处不再自增。
    if (!batt_window_changed && temp_idle_cycles < BATT_SKIP_MAX) {
        debug_log(debug_batt, "batt_ctrl 温度未更新，跳过本周期 (idle=%d)", temp_idle_cycles);
        return;
    }

    int skip_delta = 0;  // =1 时本次不执行常规升降档

    // 冷却递减（放在 abs_change 判断之前，温度不变强制进入时也能递减）
    int in_cooldown = (batt_gear_cooldown > 0);
    if (in_cooldown) {
        batt_gear_cooldown--;
        skip_delta = 1;
        debug_log(debug_batt, "batt_ctrl 冷却中，剩余%d周期", batt_gear_cooldown);
    }
    if (rev_comp_cooldown > 0) rev_comp_cooldown--;

    // --------------- 反补查表 + 趋势豁免（已抽为 rev_comp_and_trend） ---------------
    rev_comp_and_trend(batt, delta, batt_change, abs_change, eff_z2, cur_idle, in_cooldown, &skip_delta);
    // ---- 应用常规升降档（仅当未被豁免/反补跳过时） ----
    if (delta != 0 && !skip_delta) {
        int old = batt_gear_base;
        batt_gear_base += delta;
        batt_gear_base = clamp(batt_gear_base, gear_min, gear_max);
        if (old != batt_gear_base) {
            batt_gear_cooldown = BATT_COOLDOWN_CYCLES;
            write_log("挡位%d（%+d）", gear_label(batt_gear_base), delta);
        }
    }

    debug_log(debug_batt, "batt_ctrl 最终 batt_gear_base=%d skip_delta=%d cooldown=%d",
              batt_gear_base, skip_delta, batt_gear_cooldown);

    // 更新温度记录
    last_batt_reading = batt;
}

// ======================== 紧急干预（CPU 温度） ========================

/**
 * 紧急干预 — CPU 温度，每 5 秒一次。
 *
 * CPU 温度经 EMA 滤波（α=CPU_FILTER_ALPHA）。
 * 等级 = cpu_level(0~3)。
 * 升档即时响应（进入阈值）；降档逐级滞回（低于恢复阈值才允许）。
 * 等级 → 强制最低档位：EMERG_FORCED_1~4。
 */
static void emergency_intervention(void) {
    // --- 1. CPU 温度读入与滤波（1s 采集缓存） ---
    int cpu_now = cached_cpu_now;
    update_cpu_filtered(cpu_now);
    int t = cpu_filtered_temp;
    int cpu_valid = (cpu_now >= 0);
    debug_log(debug_emerg, "emerg CPU 原始%d 滤波%d 有效%d", cpu_now, t, cpu_valid);

    int prev_level = emergency_level;
    int new_level = emergency_level;

    // --- 2. 计算 CPU 紧急级别（0~3） ---
    int cpu_lvl = 0;
    if (cpu_valid && EMERG_CPU_ENABLED) {
        if      (t > CPU_EMERG_3) cpu_lvl = 3;
        else if (t > CPU_EMERG_2) cpu_lvl = 2;
        else if (t > CPU_EMERG_1) cpu_lvl = 1;
    }
    debug_log(debug_emerg, "emerg cpu_lvl=%d prev_level=%d", cpu_lvl, prev_level);

    // --- 3. 升降滞回 ---
    // 升档：立即响应；降档：低于恢复阈值才逐级下降
    if (cpu_lvl > emergency_level) {
        new_level = cpu_lvl;
    } else if (cpu_lvl < emergency_level) {
        int cpu_ok = 0;
        if (cpu_valid) {
            if      (emergency_level >= 3) cpu_ok = (t < CPU_RECOVER_2);
            else if (emergency_level >= 2) cpu_ok = (t < CPU_RECOVER_1);
            else                           cpu_ok = (t < CPU_RECOVER_0);
        }
        if (cpu_ok) {
            new_level = emergency_level - 1;
            debug_log(debug_emerg, "emerg 降级 %d→%d（cpu_ok=1）",
                      emergency_level, new_level);
        } else {
            debug_log(debug_emerg, "emerg 保持 %d（cpu_ok=0）",
                      emergency_level);
        }
    }

    // --- 4. 等级变化处理与日志 ---
    if (new_level != emergency_level) {
        int delta_e = new_level - emergency_level;
        int cpu_disp = cpu_valid ? cpu_now : t;
        write_log("紧急%d（%s%d）cpu%d.%d",
                  new_level,
                  (delta_e >= 0 ? "+" : ""), delta_e,
                  cpu_disp / 10, cpu_disp % 10);

        emergency_level = new_level;
        batt_gear_cooldown = BATT_COOLDOWN_CYCLES;
    }

    // --- 5. 根据模式设定强制最低档位 ---
    if (EMERG_MODE_ENTRY == 0) {
        // 模式 0：查表强制最低档
        const int EMERG_FORCED_TABLE[] = {0, EMERG_FORCED_1, EMERG_FORCED_2, EMERG_FORCED_3, EMERG_FORCED_4};
        if (emergency_level >= 1 && emergency_level <= 4)
            emerg_forced_gear = EMERG_FORCED_TABLE[emergency_level];
        else
            emerg_forced_gear = 0;
    } else {
        // 模式 1：升档模式 — 按等级计算最低档 = gear_min + EMERG_STEP * level
        if (emergency_level > 0) {
            emerg_forced_gear = gear_min + EMERG_STEP * emergency_level;
            if (emerg_forced_gear > gear_max) emerg_forced_gear = gear_max;
        } else {
            emerg_forced_gear = 0;
        }
    }
    debug_log(debug_emerg, "emerg 最终等级=%d forced_min=%d", emergency_level, emerg_forced_gear);
}

// ======================== 电流-挡位映射 + 温度调整融合 ========================

/**
 * 电流-挡位映射 + 温度融合模式。
 *
 * 电流经 EMA 平滑 + 倍率 → 推荐挡位（基础）。
 * 温度在推荐挡位上累积偏移（带冷却期），推荐挡位变化时偏移继承。
 * 最终挡位 = clamp(推荐 + 偏移, gear_min, gear_max)。
 *
 * 返回 1=已覆盖，0=回退常规模式。
 */
static int gear_from_current(void) {
    // 1. 读取电池电流（0.01A 单位，正=放电，负=充电）
    int ua10 = read_batt_current_ua10();
    if (ua10 == 0) {
        return 0;
    }

    // 用户约定：负值 = 充电（充电电流），正值 = 放电（放电电流）
    int is_charging = (ua10 < 0);
    int abs_ua10 = (ua10 < 0) ? -ua10 : ua10;

    // 2. 检查方向开关
    int mode_enabled = is_charging ? CURRENT_GEAR_MODE_CHARGE : CURRENT_GEAR_MODE_DISCHARGE;
    if (!mode_enabled) return 0;

    // 3. EMA 平滑
    if (!curr_gear_smooth_valid) {
        curr_gear_smooth_val = abs_ua10;
        curr_gear_smooth_valid = 1;
    } else {
        curr_gear_smooth_val = EMA_DIR(abs_ua10, curr_gear_smooth_val, CURRENT_GEAR_SMOOTH_ALPHA);
    }

    // 4. 推荐挡位 = 平滑值(0.01A) × 倍率 ÷ 100
    int multiplier = is_charging ? CURRENT_GEAR_MULT_CHARGE : CURRENT_GEAR_MULT_DISCHARGE;
    int recommended = (curr_gear_smooth_val * multiplier) / 100;
    recommended = clamp(recommended, gear_min, gear_max);

    debug_log(debug_batt, "curr_gear sign=%s raw=%d smooth=%d rec=%d/%d",
              is_charging ? "充电" : "放电", abs_ua10, curr_gear_smooth_val,
              recommended, gear_label(recommended));

    // 5. 温度偏移管理（温度用 Gear 调档输入 = 预测温度 + CPU 补偿）
    int batt = gear_input_batt;
    if (curr_gear_recommended > 0) {
        // 已激活：每周期根据当前温度差计算偏移（不受冷却期阻挡）
        // 冷却期仅阻止同方向继续累积，但反方向（温度回归方向）始终允许
        if (batt >= 0) {
            int diff = batt - BATT_BASELINE;
            int ad = abs(diff);
            int sign = sign_of(diff);
            int delta = temp_delta_by_boundary(ad, BATT_BOUNDARY_1, BATT_BOUNDARY_2, BATT_BOUNDARY_3) * sign;
            if (delta != 0) {
                if (curr_gear_temp_cooldown > 0) {
                    // 冷却期：仅允许向零靠近，阻止同方向继续累积
                    if ((delta > 0 && curr_gear_temp_offset < 0) ||
                        (delta < 0 && curr_gear_temp_offset > 0)) {
                        curr_gear_temp_offset += delta;
                    }
                } else {
                    curr_gear_temp_offset += delta;
                    curr_gear_temp_cooldown = BATT_COOLDOWN_CYCLES;
                }
            }
        }
    } else {
        // 初次进入/重新进入：以当前实际挡位为基准计算初始偏移
        curr_gear_temp_offset = batt_gear_base - recommended;
    }

    // 6. 计算实际挡位 = 推荐 + 偏移
    int final_level = recommended + curr_gear_temp_offset;
    final_level = clamp(final_level, gear_min, gear_max);

    // 7. 统一以实际挡位走阈值检查：低于阈值则退出/不进入电流映射
    if (final_level < CURRENT_GEAR_MIN) {
        curr_gear_recommended = 0;
        curr_gear_temp_offset = 0;
        curr_gear_temp_cooldown = 0;
        return 0;
    }

    // 偏移继承日志（推荐挡位变化时温度偏移自然保留）
    if (curr_gear_recommended > 0 && recommended != curr_gear_recommended) {
        debug_log(debug_batt, "curr_gear rec变化 %d→%d, temp_offset=%+d 继承",
                  curr_gear_recommended, recommended, curr_gear_temp_offset);
    }
    curr_gear_recommended = recommended;
    batt_gear_base = final_level;

    // 清除反补/豁免状态（切换模式时不应保留旧状态）
    reset_exempt_state();
    rev_comp_cooldown = 0;
    last_batt_reading = -1;
    temp_idle_cycles = 0;

    debug_log(debug_batt, "curr_gear 融合 rec=%d temp_offset=%+d gear=%d",
              recommended, curr_gear_temp_offset, gear_label(final_level));
    return 1;
}

// ======================== PID 方差门控 ========================

/**
 * 推入方差采样（对齐 PID 计算时机）。
 * @param value 原始电池温度（0.1°C）——固定推原始值，不做滤波/预测
 * @param cycle 当前控制周期计数（pid_ctrl_cycles）
 * 两次推入间若有周期被跳过（无滤波跳过周期不推入），在缺档处线性插值补样本，
 * 保证方差窗口覆盖连续控制周期，反映真实温度变化率。
 */
static void pid_var_push(int value, int cycle) {
    if (pid_var_last_cycle >= 0 && cycle > pid_var_last_cycle + 1) {
        // 距上次推入 gap = cycle - pid_var_last_cycle 个周期，缺中间 gap-1 个样本
        int gap = cycle - pid_var_last_cycle;
        for (int k = 1; k < gap; k++) {
            int v = pid_var_last_value
                    + (value - pid_var_last_value) * k / gap;
            pid_var_buffer[pid_var_head] = v;
            pid_var_head = (pid_var_head + 1) % PID_VAR_BUF_MAX;
            if (pid_var_count < PID_VAR_BUF_MAX)
                pid_var_count++;
        }
    }
    pid_var_buffer[pid_var_head] = value;
    pid_var_head = (pid_var_head + 1) % PID_VAR_BUF_MAX;
    if (pid_var_count < PID_VAR_BUF_MAX)
        pid_var_count++;
    pid_var_last_value = value;
    pid_var_last_cycle = cycle;
}

/**
 * 计算当前缓冲区方差 Σ(xi-mean)²/n（0.1°C² 单位）
 * 采样不足时返回大值使方差门控不触发
 */
static int pid_var_compute(void) {
    int n = pid_ki_var_samples;
    if (n > pid_var_count) n = pid_var_count;
    if (n < 2) return 999999;  // 采样不足

    int sum = 0;
    for (int i = 0; i < n; i++) {
        int idx = (pid_var_head - n + i + PID_VAR_BUF_MAX) % PID_VAR_BUF_MAX;
        sum += pid_var_buffer[idx];
    }
    int mean = sum / n;
    int var_sum = 0;
    for (int i = 0; i < n; i++) {
        int idx = (pid_var_head - n + i + PID_VAR_BUF_MAX) % PID_VAR_BUF_MAX;
        int dev = pid_var_buffer[idx] - mean;
        var_sum += dev * dev;
    }
    return var_sum / n;
}

// ======================== Gear 温度预测 ========================

/**
 * 推入真实温度读数到预测缓冲区（仅 batt_temp_updated 时调用，Gear 模式）
 * @param batt_raw  原始电池温度（0.1°C）
 * @param gap       距上次真实读数的周期数（temp_idle_cycles + 1）
 */
static void gear_predict_push(int batt_raw, int gap) {
    PredictPoint *e = &gear_predict_buf[gear_predict_buf_head];
    e->temp = batt_raw;
    e->gap = gap;
    gear_predict_buf_head = (gear_predict_buf_head + 1) % gear_predict_buf_n;
    if (gear_predict_buf_cnt < gear_predict_buf_n) gear_predict_buf_cnt++;
}

/**
 * 温度平衡点预测。
 *
 * 算法：
 *   1. 在缓冲区中扫描最近峰/谷作为趋势起点
 *   2. 从峰/谷开始计算 per_cycle_delta（归一化温差，0.01°C/周期）
 *   3. 在绝对值空间计算加速度（delta 变化量）均值
 *   4. 迭代外推 delta 归零的点作为预测平衡温度
 *
 * @param batt_raw  本周期原始电池温度（0.1°C）
 * @return 预测平衡温度（0.1°C），0 表示数据不足/无法预测
 */
static int gear_predict_compute(int batt_raw) {
    // ---- 1. 最小数据检查 ----
    if (gear_predict_buf_cnt < 2) return 0;

    // ---- 2. 取窗口 ----
    int win_n = gear_predict_win_n;
    if (gear_predict_buf_cnt < win_n) win_n = gear_predict_buf_cnt;
    int win_start = (gear_predict_buf_head - win_n + gear_predict_buf_n) % gear_predict_buf_n;

    // 窗口内访问宏
#define BUF_AT(off) gear_predict_buf[(win_start + (off)) % gear_predict_buf_n]

    // ---- 3. 峰/谷检测（窗口内扫描温度拐点） ----
    int pivot = 0;
    for (int i = win_n - 2; i >= 1; i--) {
        int t_prev = BUF_AT(i - 1).temp;
        int t_cur  = BUF_AT(i).temp;
        int t_next = BUF_AT(i + 1).temp;
        // 峰: 前升后降；谷: 前降后升（等号归入"不严格单调"侧，避免平顶误判）
        if ((t_prev <= t_cur && t_cur > t_next) ||
            (t_prev >= t_cur && t_cur < t_next)) {
            pivot = i;
            break;
        }
    }

    // ---- 4. 可用数据点数检查 ----
    int usable_points = win_n - pivot;
    if (usable_points < gear_predict_min_points) return 0;

    // ---- 5. 计算 per_cycle_delta（带符号 + 绝对值，0.01°C/周期）----
    int pcd_signed[9], pcd_abs[9];
    int pcd_cnt = 0;
    for (int i = pivot; i < win_n - 1; i++) {
        int diff = BUF_AT(i + 1).temp - BUF_AT(i).temp;
        int g = BUF_AT(i + 1).gap;
        pcd_signed[pcd_cnt] = (diff * 10) / g;
        pcd_abs[pcd_cnt] = abs(pcd_signed[pcd_cnt]);
        pcd_cnt++;
    }
    // ---- 6. 稳定性闸门（×1）：最大 |delta| < min_delta → 压缩预测增量而非停止 ----
    //    （原 ×2 直接放弃；现低于闸门时预测增量 × 抑制系数，0=完全抑制=停止）
    int max_pcd_abs = 0;
    for (int i = 0; i < pcd_cnt; i++)
        if (pcd_abs[i] > max_pcd_abs) max_pcd_abs = pcd_abs[i];
    int below_gate = (max_pcd_abs < gear_predict_min_delta);
    if (below_gate && gear_predict_suppress <= 0) return 0;

    // ---- 7. 2 点线性模式：仅 1 个 delta（2 有效点）→ 无法算加速度，线性外推 ----
    //    预测 = 当前温度 + 两窗口间变化速度（1 周期外推），低于闸门时增量压缩
    if (pcd_cnt < 2) {
        int sign = (pcd_signed[0] >= 0) ? 1 : -1;
        int weight = (sign >= 0) ? gear_predict_heat_weight : gear_predict_cool_weight;
        if (weight <= 0) return 0;
        int inc_10 = pcd_signed[0] / 10;   // 单周期变化速度（0.1°C，有符号）
        if (below_gate) inc_10 = inc_10 * gear_predict_suppress / 100;
        int predicted_10 = batt_raw + inc_10;
        predicted_10 = (predicted_10 * weight + batt_raw * (10 - weight)) / 10;
        return predicted_10;
    }

    // ---- 8. 加速度均值（绝对值空间，统一处理升/降温） ----
    int accel_sum = 0, accel_cnt = 0;
    for (int i = 0; i < pcd_cnt - 1; i++) {
        accel_sum += pcd_abs[i + 1] - pcd_abs[i];
        accel_cnt++;
    }
    int avg_accel = accel_sum / accel_cnt;
    if (avg_accel >= 0) return 0;  // 仍在加速，无法预测平衡点

    // ---- 9. 方向权重（0=禁用，10=全效预测） ----
    int sign = (pcd_signed[pcd_cnt - 1] >= 0) ? 1 : -1;
    int weight = (sign >= 0) ? gear_predict_heat_weight : gear_predict_cool_weight;
    if (weight <= 0) return 0;

    // ---- 10. 迭代预测 ----
    int cur_delta = pcd_abs[pcd_cnt - 1];
    if (cur_delta < gear_predict_min_delta)
        cur_delta = gear_predict_min_delta;

    int sum_01c = 0;       // 累积预测变化量（0.01°C）
    int last_valid = 0;    // 最后一个 cur_delta > 0 时的 sum
    while (cur_delta > 0) {
        sum_01c += cur_delta;
        cur_delta += avg_accel;      // avg_accel < 0，delta 递减
        if (cur_delta > 0) last_valid = sum_01c;
    }
    if (below_gate) last_valid = last_valid * gear_predict_suppress / 100;  // 低于闸门：压缩增量
    int predicted_10 = batt_raw + sign * (last_valid / 10);

    // 按权重混合预测值与实际温度：weight=10 全效预测，weight=0 等同于实际温度
    predicted_10 = (predicted_10 * weight + batt_raw * (10 - weight)) / 10;

#undef BUF_AT
    return predicted_10;
}

// ======================== 输入补偿（PID / Gear 共用） ========================

/**
 * CPU 补偿值（0.1°C）：comp=(cpu滤波温度 − 电池 − 偏移)/divisor，clamp≥0，
 * 再按补偿专属滤波系数 EMA 平滑（首值直取）。始终生效，无开关。
 * @param batt 当前电池温度（0.1°C，两模式均用原始电池温度口径）
 */
static int cpu_comp_now(int batt) {
    if (cpu_filtered_temp < 0) return 0;
    float raw = (float)(cpu_filtered_temp - batt - pid_cpu_comp_offset) / (pid_cpu_comp_divisor * 10);
    if (raw < 0.0f) raw = 0.0f;
    if (!pid_cpu_comp_ready) {
        pid_cpu_comp_smooth = raw;
        pid_cpu_comp_ready = 1;
    } else {
        pid_cpu_comp_smooth = (pid_cpu_comp_filter_alpha * raw +
                              (100 - pid_cpu_comp_filter_alpha) * pid_cpu_comp_smooth) / 100.0f;
    }
    return (int)(pid_cpu_comp_smooth * 10 + 0.5f);
}

// ======================== Gear 调档输入温度 ========================

/**
 * 计算 Gear 调档输入温度：原始电池温度 → 预测温度替代 → + CPU 补偿。
 * 每 5s 周期在 gear 分支开头计算一次，结果存 gear_input_batt，
 * battery_control / gear_from_current 直接读取，保证调档判断口径统一。
 * @return 调档输入温度（0.1°C），-1 表示无有效电池温度
 */
static int gear_compute_input(void) {
    int batt = cached_batt_raw;
    if (batt < 0) return -1;

    // 预测温度替代实际温度（参与偏差/边界/反补/趋势豁免全部调档判断）
    if (gear_predict_heat_weight > 0 || gear_predict_cool_weight > 0) {
        int pred = gear_predict_compute(batt);
        if (pred != 0) {
            // 预测成功：ramp-up 渐进钳位（在平滑之前）
            int max_rise = gear_predict_max_rise;
            if (gear_predict_ramp_cycles > 0
                && gear_predict_consecutive < gear_predict_ramp_cycles) {
                max_rise = gear_predict_max_rise
                           * (gear_predict_consecutive + 1)
                           / gear_predict_ramp_cycles;
            }
            int clamped = clamp(pred, batt - max_rise, batt + max_rise);

            if (!gear_predict_was_active) {
                // 转换 IN：防跳变平滑（以上周期平滑值或实际温度为基准）
                int base = (gear_predict_smoothed >= 0) ? gear_predict_smoothed : batt;
                gear_predict_smoothed = EMA_DIR(clamped, base, gear_predict_alpha);
            } else {
                // 连续预测：轻量自平滑
                gear_predict_smoothed = EMA_DIR(clamped, gear_predict_smoothed, gear_predict_alpha);
            }
            batt = gear_predict_smoothed;
            gear_predict_was_active = 1;
            gear_predict_consecutive++;
            debug_log(debug_batt, "predict raw=%d(%.1f°C) clamp=%d smoothed=%d ramp=%d/%d",
                      pred, pred / 10.0, clamped, gear_predict_smoothed,
                      gear_predict_consecutive, gear_predict_ramp_cycles);
        } else if (gear_predict_was_active) {
            // 转换 OUT：防跳变平滑（向实际温度靠拢）
            gear_predict_smoothed = EMA_DIR(batt, gear_predict_smoothed, gear_predict_alpha);
            batt = gear_predict_smoothed;
            gear_predict_was_active = 0;
            gear_predict_consecutive = 0;
            debug_log(debug_batt, "predict out batt=%d smoothed=%d", batt, gear_predict_smoothed);
        } else {
            // 连续不预测：使用实际温度
            gear_predict_smoothed = batt;
        }
    }

    // CPU 补偿（基于原始电池温度计算，加到预测/实际温度上）
    batt += cpu_comp_now(cached_batt_raw);
    return batt;
}

// ======================== PID 控制函数 ========================

/**
 * PID 计算（滤波模式下每周期调用；无滤波模式仅温度/补偿变化时调用）
 * @param batt_10  电池温度（0.1°C），已 EMA 滤波
 * @param dt       距上次重算以来的 5 秒周期数（钳位 0.6~6，1 = 5s）
 * @return 归一化输出 0.0~1.0
 */
static float pid_compute(int batt_10, float dt) {
    int target_10 = BATT_BASELINE;
    int error_10 = batt_10 - target_10;
    float error = error_10 / 10.0f;

    // P 项
    float p = (pid_kp / 1000.0f) * error;

    // I 项（方差门控 + 死区回退）
    // 方差门控：温度稳定（方差<阈值）时全温度段启用 I 累积
    // 死区回退：方差门控未激活时，仅在 |error|<deadband 内累积
    // 两者均不满足时冻结 I（防 windup）
    int ki_active = 0;
    int ki_gate = 0;      // 门控来源：0=冻结 1=方差门控 2=死区门控（仅日志用）
    int v = -1;           // 当前方差（仅日志用，-1=采样不足未计算）
    if (pid_ki_var_threshold > 0 && pid_var_count >= 2) {
        v = pid_var_compute();
        if (v < pid_ki_var_threshold) { ki_active = 1; ki_gate = 1; }
    }
    if (!ki_active && pid_ki_deadband > 0) {
        float db = pid_ki_deadband / 10.0f;
        if (error > -db && error < db) { ki_active = 1; ki_gate = 2; }
    }
    if (ki_active) {
        pid_integral_accum += (pid_ki / 1000.0f) * error * dt;
    }
    float i_limit = pid_integral_limit / 1000.0f;
    if (pid_integral_accum >  i_limit) pid_integral_accum =  i_limit;
    // 积分单向限制 0~+LIMIT：低温（error<0）时不累积负积分，
    // 避免之后升温时需先抵消负积分才能响应（升温延迟）
    if (pid_integral_accum < 0.0f)    pid_integral_accum = 0.0f;

    // D 项（首次跳过）
    float d = 0.0f;
    if (pid_prev_error != 0 || pid_last_batt >= 0) {
        d = (pid_kd / 1000.0f) * (error - pid_prev_error) / dt;
    }
    pid_prev_error = error;

    // 钳位 0~1
    float raw = p + pid_integral_accum + d;
    float raw_pre = raw;   // 钳位前值（仅日志用）
    if (raw < 0.0f) raw = 0.0f;
    if (raw > 1.0f) raw = 1.0f;
    // 分项诊断（仅 debug_pid 开启时输出）：P/I/D 贡献 + 钳位前后 + 门控来源 + 方差
    const char *gate = ki_active ? (ki_gate == 1 ? "var" : "dead") : "frozen";
    pid_log("p=%.2f i=%.2f d=%.2f raw=%.2f out=%.2f ki=%s var=%d", p, pid_integral_accum, d, raw_pre, raw, gate, v);
    return raw;
}

/**
 * 热端温度线性映射 + EMA 平滑 + 双向滞回：无上下限，低于 HOT_MAP_MIN 或高于 HOT_MAP_MAX 时线性外推
 * 最终钳制在下发阶段（apply_gear / apply_gear_direct 内部）
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
        debug_log(debug_fan, "rpm 热端 ≤0（%d），保持上次 %d", hot_10, prev_rpm);
        return prev_rpm;   // 热端 ≤0（异常/未就绪）时保持上次输出，避免映射漂移
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
        if (hot_s > prev_hot && rpm < prev_rpm) rpm = prev_rpm;  // 升温 ≥ 上次（防止微降反降 RPM）
    }

    prev_hot = hot_s;
    prev_rpm = rpm;
    debug_log(debug_fan, "rpm 热端 hot=%d(平滑%d) → %d", hot_10, hot_s, rpm);
    return rpm;
}

/**
 * 冷强度指数映射：n^exp，无上下限
 * cold < cold_map_start 时线性外推下限（powf 负数底数→NaN）
 * 最终钳制在下发阶段（apply_gear / apply_gear_direct 内部）
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
    // EMA 平滑，防止风扇转速跳变（系数可配置 RPM_SMOOTH_ALPHA）
    if (cold_rpm_smoothed < 0) {
        cold_rpm_smoothed = raw_rpm;
    } else {
        cold_rpm_smoothed = EMA_DIR(raw_rpm, cold_rpm_smoothed, rpm_smooth_alpha);
    }
    debug_log(debug_fan, "rpm 冷端 exp cold=%d → %d", cold, cold_rpm_smoothed);
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
        // 自加权合并：各以自身 RPM 为权重，权重钳制到设备范围避免某方极小时权重失效（输入值不变，仅影响占比）
        int rpm_hot = rpm_from_hot_end(cooler_hot_temp);
        if (rpm_hot > 0) {
            int w_hot  = clamp(rpm_hot,  fan_rpm_min, active_fan_max);
            int w_cold = clamp(rpm_cold, fan_rpm_min, active_fan_max);
            rpm = (w_hot * rpm_hot + w_cold * rpm_cold) / (w_hot + w_cold);
        }
    }
    debug_log(debug_fan, "rpm 目标 冷端=%d 热端=%d → %d", rpm_cold, cooler_hot_temp, rpm);
    return rpm;
}

/**
 * 直接下发 AT 广播（PID / 直接冷端模式使用）
 * 与 apply_gear 共享 last_* 去重缓存
 */
static void apply_gear_direct(int mode, int target,
                               int send_rpm, int cold, int wl) {
    // 纯下发：制冷限速与风扇目标已由 rate_limited_execute 完成，此处只去重/日志/广播

    // ---- 热端过温边界钳制（去重前生效；不同步 actual_cold，风扇由 actual_cold 推算保持高转速散热）----
    int cold_pre_clamp = cold;
    if (hot_derate > 0) {
        int cold_cap = active_cold_eff_max;
        if (cold > cold_cap) cold = cold_cap;
    }

    // ---- 去重检测 + 制冷上升死区（以散热器实际回传为准）----
    if (should_skip_dispatch(mode, target, send_rpm, cold, wl)) {
        debug_log(debug_exec, "apply_gear_direct 跳过下发（目标冷%d RPM%d == 回传冷%d RPM%d）",
                  cold, send_rpm, cooler_cold_real, cooler_rpm_real);
        return;
    }

    // 过热钳制冷动作日志（仅在实际下发时输出，与去重判定一致）
    if (cold < cold_pre_clamp)
        write_log("过热钳制冷 %d→%d（上限削减 %d）", cold_pre_clamp, cold, hot_derate);

    // 偏差 = (滤波后电池温度 + 补偿) - 目标温度，取自上一周期 PID 计算的结果
    int batt_10 = (pid_batt_filtered >= 0) ? pid_batt_filtered : BATT_BASELINE;
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
}

/**
 * 重置 PID 核心状态（积分、误差、滤波、补偿、方差缓冲区）
 * 不同场景的调用者在此基础上附加各自的额外重置逻辑
 */
static void pid_reset_core(void) {
    pid_integral_accum = 0;
    pid_prev_error = 0;
    pid_batt_filtered = -1;
    pid_last_batt = -1;
    pid_last_change_time = 0;
    pid_cpu_comp_smooth = 0.0f;
    pid_last_comp_10 = 0;
    // 方差门控状态重置（环形缓冲区 + 插值锚点）
    pid_var_count = 0;
    pid_var_head = 0;
    pid_var_last_value = -1;
    pid_var_last_cycle = -1;
    pid_cpu_comp_ready = 0;
}

/**
 * CTRL_MODE 0→1 热切换时对齐 PID 初始值
 * 从当前 gear 状态映射到 PID 输出空间
 */
static void pid_align_from_gear(void) {
    float ratio = (float)(batt_gear_base - gear_min) /
                  (gear_max - gear_min);
    pid_ratio_saved = ratio;   // 记录无级对齐量（切回 Gear 时映射回档位）
    pid_align_rpm  = fan_rpm_min + (int)(ratio * (active_fan_max - fan_rpm_min));
    pid_align_cold = pid_cold_min + (int)(ratio * (eff_cold_max(active_pid_cold_max, pid_cold_min) - pid_cold_min));
    pid_reset_core();
    last_bcast_valid     = 0;
    write_log("PID 从 gear 对齐 ratio=%.2f cold=%d", ratio, pid_align_cold);
}

/**
 * 按制冷强度参考值对齐 PID 初始输出。
 * @param cold_ref 制冷强度参考值（存档值或 LSP 回传实际值）
 * @param cold_max 参考值所在档位的制冷上限（存档用 pid_cold_max，LSP 用 active_pid_cold_max）
 * @return 对齐比例（0~1），用于映射基础档位
 */
static float pid_ratio_from_cold(int cold_ref, int cold_max) {
    float ratio = (float)(cold_ref - pid_cold_min) / (cold_max - pid_cold_min);
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
 * 重连安全对齐：以散热器实际回传值为准初始化实际制冷/转速（PID/gear 共用），
 * 由 rate_limited_execute 按正常限速逐步调节，抑制重连突变。
 * 不在此处立即下发，防止部分执行后参数组合不协调
 */
static void reconnect_align(void) {
    // 清空温度窗口累积标志，避免重连后误判"窗口内变过"
    batt_changed_since_ctrl = 0;
    batt_window_changed = 0;

    // 断联→重连汇总行（常驻）：断联时长 + 重连后散热器回传实际值
    if (last_disconnect_time > 0) {
        write_log("重连 断联%d秒 回传冷%d RPM%d",
                  (int)(time(NULL) - last_disconnect_time),
                  cooler_cold_real, cooler_rpm_real);
        last_disconnect_time = 0;
    }

    // 以散热器实际回传为准：重连后从真实当前状态起步，由正常限速逐步调节，抑制突变。
    // 回传异常（status 文件读失败）时保持原值不变，避免无效初值。
    if (cooler_cold_real >= COLD_MIN) actual_cold = cooler_cold_real;
    if (cooler_rpm_real >= fan_rpm_min) actual_rpm = cooler_rpm_real;

    if (ctrl_mode == 1) {
        // PID 模式：重置 PID 状态（积分/误差/滤波），制冷/转速初值取回传实际值，
        // 由 rate_limited_execute 从回传值向 PID 目标正常步进
        pid_reset_core();
        pid_filter_interval_smooth = -1;
        pid_filter_auto_off = 0;
        temp_idle_cycles = 0;
        // 回传异常时保持原值（函数开头已处理有效回传覆盖），避免强制拉到最小值
        actual_target_temp = -1;
        write_log("重连 PID 状态已重置，制冷从回传实际值起步 cold=%d", actual_cold);
        last_batt_reading = -1;
        first_run = 1;
        return;
    }

    // --- gear 模式：删除档位表匹配，直接以散热器实际回传值起步 ---
    debug_log(debug_conn, "reconnect_align actual_rpm=%d actual_cold=%d", actual_rpm, actual_cold);
    int safe_level = clamp(final_gear, gear_min, gear_max);
    actual_target_temp = gear_table[safe_level - 1].target;
    last_batt_reading = -1;
    first_run = 1;
    // 不下发，等下轮 rate_limited_execute 从实际值自然过渡
}

/** 记录上一轮紧急等级，退出紧急时用作档位上限 */
static int prev_emerg_level = 0;

/**
 * 按当前模式分发执行（限速统一下沉到 apply_gear / apply_gear_direct 内部）
 * PID 模式：传 pid_align_* → apply_gear_direct 内部限速
 * Gear 模式：apply_gear 内部限速
 */
static void rate_limited_execute(void) {
    // --- PID 模式：制冷限速 → 独立风扇计算（不跟 PID 输出）→ 风扇限速 → 纯下发 ---
    if (ctrl_mode == 1) {
        rate_limit_cold(pid_align_cold);
        int send_rpm = rate_limit_fan(compute_fan_target());
        apply_gear_direct(1, 5, send_rpm, actual_cold, 0);
        return;
    }

    // --- Gear 模式：限速已内建到 apply_gear（GEAR_AUTO_FAN 分支同样独立计算风扇） ---
    apply_gear(final_gear);
}

/**
 * PID 模式控制周期（每 5s）：输入滤波 → CPU 补偿 → PID 计算 → 映射制冷。
 * 预测已迁到 Gear，PID 直接使用滤波值，无档位/紧急逻辑。
 */
static void pid_cycle(void) {
    time_t now = time(NULL);
    pid_ctrl_cycles++;               // 单调周期计数（方差插值用；跳过周期也计数，保证插值对齐真实时间）
    int batt_raw = cached_batt_raw;   // 1s 采集缓存
    if (batt_raw < 0) return;

    // --- 温度更新周期跟踪（基于周期数，非时间） ---
    // idle 递增已由 main_loop 入口按窗口变化统一维护，此处只做采样 push
    // 方差采样 push 已下移到 pid_input 计算之后：与 PID 计算输入标准保持一致
    if (batt_temp_updated) {
        int gap = temp_idle_cycles + 1;  // 距离上次更新经过的周期数
        if (pid_filter_interval_smooth < 0) {
            pid_filter_interval_smooth = gap * 10;  // ×10 转 0.1周期
        } else {
            int old_s = pid_filter_interval_smooth;
            // 钳位输入值：钳位值 = 自动关闭阈值 × 倍数，防偶发长间隙平滑值异常跳变
            int raw_gap = gap * 10;
            int gap_max = pid_filter_auto_threshold_on * PID_FILTER_GAP_MULT;
            if (raw_gap > gap_max) raw_gap = gap_max;
            pid_filter_interval_smooth = EMA(raw_gap, old_s, pid_filter_auto_alpha);
            // 方向取整：平滑值增大→向上取整，减小→向下取整
            if (pid_filter_interval_smooth > old_s) pid_filter_interval_smooth++;
        }
    }
    // else：值未变，不推入新样本（idle 已由入口维护，避免重复递增）

    // --- 自适应滤波开关（仅在配置开启时生效，不修改配置文件值） ---
    int filter_cfg_on = pid_input_filter_enabled;
    if (filter_cfg_on && pid_filter_interval_smooth >= 0) {
        if (pid_filter_auto_off) {
            if (pid_filter_interval_smooth < pid_filter_auto_threshold_off) {
                pid_filter_auto_off = 0;
                pid_log("滤波 自适应恢复（间隔%.1f <%d.%d周期）",
                         pid_filter_interval_smooth / 10.0,
                         pid_filter_auto_threshold_off / 10, pid_filter_auto_threshold_off % 10);
            }
        } else {
            if (pid_filter_interval_smooth > pid_filter_auto_threshold_on) {
                pid_filter_auto_off = 1;
                pid_log("滤波 自适应关闭（间隔%.1f >%d.%d周期）",
                         pid_filter_interval_smooth / 10.0,
                         pid_filter_auto_threshold_on / 10, pid_filter_auto_threshold_on % 10);
            }
        }
    }
    int filter_eff = (filter_cfg_on && !pid_filter_auto_off);

    // --- 根据有效滤波状态分支 ---
    if (filter_eff) {
        // 滤波模式：EMA 滤波 + 方向取整（增大→向上取整，减小→向下取整）
        if (pid_batt_filtered < 0) {
            pid_batt_filtered = batt_raw;
        } else {
            pid_batt_filtered = EMA_DIR(batt_raw, pid_batt_filtered, pid_batt_alpha);
        }
    } else {
        // 无滤波模式：原始值直通；1s 层未变过且 idle 未达上限则跳过本周期
        pid_batt_filtered = batt_raw;
        if (!batt_window_changed && temp_idle_cycles < BATT_SKIP_MAX && pid_last_batt >= 0) {
            debug_log(debug_pid, "PID 跳过（温度未更新 idle=%d）", temp_idle_cycles);
            return;
        }
    }

    // --- CPU 温度读入与滤波（用于补偿，两模式共享） ---
    int cpu_now = cached_cpu_now;   // 1s 采集缓存
    update_cpu_filtered(cpu_now);

    // --- CPU 补偿值计算（始终生效，原始电池温度口径；cpu_comp_now 内部 EMA 平滑） ---
    int total_comp_10 = cpu_comp_now(batt_raw);
    float cpu_comp = total_comp_10 / 10.0f;   // 日志用（0.1°C → °C）

    // --- PID 输入（使用滤波值；温度预测仅 Gear 使用） ---
    int pid_input = (filter_eff ? pid_batt_filtered : batt_raw);

    // --- 方差采样 push（对齐 PID 计算时机） ---
    // 固定推入原始温度 batt_raw（不做滤波/预测）；跳过周期（无滤波模式温度未更新）不推入，
    // pid_var_push 内部对缺档做线性插值，保证窗口覆盖连续控制周期。
    pid_var_push(batt_raw, pid_ctrl_cycles);

    // --- PID 重算判定 ---
    // 滤波模式：每周期都重算 | 无滤波模式：温度或补偿变化时才重算
    int should_recompute = filter_eff ||
                           (batt_raw != pid_last_batt || total_comp_10 != pid_last_comp_10);

    if (should_recompute) {
        // dt：距上次 PID 重算以来的 5 秒周期数（1 = 5s），钳位 0.6~6（3s~30s）。
        // 改为周期数后 PID_KI/PID_KD 标定单位随之为"每 5s 周期"：原秒标定值 KI×5 / KD÷5 保持原行为
        float dt = (float)(now - pid_last_change_time) / 5.0f;
        if (dt > 6.0f) dt = 6.0f;
        if (dt < 0.6f) dt = 0.6f;

        int compensated_10 = pid_input + total_comp_10;
        float pid_out = pid_compute(compensated_10, dt);

        // 直接映射到物理值（无输出平滑）：PID 输出 → 制冷强度（风扇目标由 compute_fan_target 独立计算）
        int cmax = active_cold_eff_max;
        int range = cmax - pid_cold_min;
        if (range <= 0) range = 1;
        pid_align_cold = clamp(pid_cold_min + (int)(pid_out * range), pid_cold_min, cmax);

        pid_log("epoch=%ld Tbatt=%d+comp%+.1f(cpu)=Tinp%d Ttgt=%d Thot=%d dt=%.1f周期 e=%.2f out=%.2f var=%d",
                 now, pid_input, cpu_comp,
                 compensated_10, BATT_BASELINE, cooler_hot_temp,
                 dt, (compensated_10 - BATT_BASELINE) / 10.0f,
                 pid_out, pid_var_count >= 2 ? pid_var_compute() : -1);

        pid_last_batt = batt_raw;
        pid_last_comp_10 = total_comp_10;
        pid_last_change_time = now;
    }
}

/**
 * Gear 模式控制周期（每 5s）：预测输入 → 紧急干预 → 电池/电流调档 → 最终档位。
 */
static void gear_cycle(void) {
    // 0. 预测采样推入（温度更新时）+ 计算调档输入温度（预测温度 + CPU 补偿）
    if (batt_temp_updated) {
        int gap = temp_idle_cycles + 1;
        if (gear_predict_heat_weight > 0 || gear_predict_cool_weight > 0)
            gear_predict_push(cached_batt_raw, gap);
    }
    gear_input_batt = gear_compute_input();

    // 1. 紧急干预（CPU 温度，更新 emergency_level）
    prev_emerg_level = emergency_level;
    emergency_intervention();

    // 重新进入紧急 → 取消恢复期（立即恢复全灵敏度以快速响应）
    if (emergency_level > prev_emerg_level) {
        emerg_recovery_mult = 1;
        emerg_recovery_cycles = 0;
        emerg_recovery_phase = 0;
        // 清除趋势豁免/反补累积，防止紧急期间脏状态影响后续逻辑
        reset_exempt_state();
    }

    // 退出紧急 → 启动恢复期，清除趋势豁免/反补累积
    if (emergency_level < prev_emerg_level) {
        emerg_recovery_phase = 1;
        emerg_recovery_mult = EMERG_RECOVERY_MULT_1;
        emerg_recovery_cycles = EMERG_RECOVERY_PHASE_CYCLES;
        reset_exempt_state();
        write_log("紧急退出 进入恢复期 P1 倍率%d 周期%d",
                  EMERG_RECOVERY_MULT_1, EMERG_RECOVERY_PHASE_CYCLES);
    }

    // 2. 电池温度控制 / 电流-挡位映射模式
    // 先尝试电流-挡位模式（返回 1 表示已覆盖挡位），未覆盖则回退到常规温度控制
    if (!gear_from_current()) {
        battery_control();
    }

    // 3. 计算最终档位 = max(电池基础档位, 紧急强制最低档位)
    int final_level = batt_gear_base;
    if (emerg_forced_gear > final_level) final_level = emerg_forced_gear;
    final_level = clamp(final_level, gear_min, gear_max);

    // 4. 同步逻辑跟踪值（供下轮控制计算基础），不下发
    batt_gear_base = final_level;

    // 5. 保存为目标档位（供下轮逐步执行使用）
    final_gear = final_level;

    // 6. 退出紧急时限制档位（过渡期保护，仅生效一周期，受电池温度约束）
    //    电池温度低于基准+EMERG_EXIT_BATT_THRESHOLD → 全效退出
    //    低于基准+EMERG_EXIT_BATT_THRESHOLD×2 → 半效退出
    //    否则 → 不退出（保持当前档位）
    //    注意：恢复期启动已在步骤 1 中完成，此处只做 cap/drop
    if (emergency_level < prev_emerg_level) {
        int batt_temp = cached_batt_raw;   // 1s 采集缓存
        enum { EXIT_NONE = 0, EXIT_HALF = 1, EXIT_FULL = 2 };
        int exit_mode = EXIT_FULL;
        if (batt_temp >= 0) {
            int t1 = BATT_BASELINE + EMERG_EXIT_BATT_THRESHOLD;
            int t2 = BATT_BASELINE + EMERG_EXIT_BATT_THRESHOLD * 2;
            if (batt_temp < t1) {
                exit_mode = EXIT_FULL;
            } else if (batt_temp < t2) {
                exit_mode = EXIT_HALF;
            } else {
                exit_mode = EXIT_NONE;
            }
        } // batt_temp<0 → 传感器异常，默认全效退出(安全)

        if (exit_mode >= EXIT_HALF) {
            if (EMERG_MODE_EXIT == 0) {
                // 模式 0：钳制最高档
                int cap;
                if      (prev_emerg_level >= 4) cap = EMERG_FORCED_4;
                else if (prev_emerg_level >= 3) cap = EMERG_FORCED_3;
                else if (prev_emerg_level >= 2) cap = EMERG_FORCED_2;
                else                             cap = EMERG_FORCED_1;
                cap += EMERG_EXIT_CAP_OFFSET;
                if (cap > gear_max) cap = gear_max;
                if (batt_gear_base > cap) {
                    if (exit_mode >= EXIT_FULL) {
                        batt_gear_base = cap;
                    } else {
                        // 半效：只降低实际档位与 cap 差值的一半
                        int reduction = batt_gear_base - cap;
                        batt_gear_base -= reduction / 2;
                    }
                }
            } else {
                // 模式 1：降档模式 — 直接减去 EMERG_STEP（全效）或一半（半效）
                int step = (exit_mode >= EXIT_FULL) ? EMERG_STEP : (EMERG_STEP / 2);
                if (step < 1) step = 1;
                if (batt_gear_base > step)
                    batt_gear_base -= step;
                else
                    batt_gear_base = gear_min;
            }
            // 同步 final_gear，避免逐步执行向已被压低的档位上方移动
            if (final_gear > batt_gear_base)
                final_gear = batt_gear_base;
            debug_log(debug_emerg, "emerg 退出 cap/drop 档位=%d final=%d exit=%s 模式%d",
                      batt_gear_base, final_gear,
                      exit_mode == EXIT_FULL ? "全效" : "半效", EMERG_MODE_EXIT);
        } else {
            debug_log(debug_emerg, "emerg 退出被电池温度阻挡（电池%d.%d 过高），保持档位",
                      batt_temp / 10, batt_temp % 10);
        }
        // exit_mode == EXIT_NONE → 电池温度过高，不退出紧急，保持当前档位
        // 恢复期已在步骤 1 提前启动，此处不再重复
    }
}

/**
 * 单次控制循环（纯计算，不下发）
 * 配置重载 → 热端过温/有效范围 → 按模式分发（PID / Gear）
 * 调用者在外部立即执行速率限制下发，本函数只做决策
 */
static void main_loop(void) {
    // 温度窗口变化判定：自上次 5s 控制以来，1s 采集层是否检测到值变化。
    // 防漏判：温度在窗口内变过又回到原位时，当前采样值虽与上次相同，但 1s 层累积标志已置位。
    batt_window_changed = batt_changed_since_ctrl;
    batt_changed_since_ctrl = 0;                 // 开启新窗口
    if (batt_window_changed) temp_idle_cycles = 0;
    else temp_idle_cycles++;

    // 0. 检查配置文件是否更新（热重载）
    if (ctrl_mode == 1)
        debug_log(debug_main, "main_loop 开始(PID) 温度窗口=%s idle=%d",
                  batt_window_changed ? "变化" : "未变", temp_idle_cycles);
    else
        debug_log(debug_main, "main_loop 开始(Gear) emergency=%d forced_min=%d 档位=%d target=%d",
                  emergency_level, emerg_forced_gear, batt_gear_base, final_gear);
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

    // --- 按模式分发 ---
    if (ctrl_mode == 1)
        pid_cycle();
    else
        gear_cycle();
}

// ======================== 程序入口 ========================

// ======================== WebUI 曲线数据 ========================
// 每 1s 追加 1 行，行格式：epoch,电池,CPU,热端,冷端,实际转速,实际制冷,目标制冷（0.1°C，未就绪为 -1）。
// 每追加 WEBUI_COMPACT_EVERY 行压缩一次（删最旧行，文件在 720~780 行间波动）；相比旧实现每秒全量读改写，I/O 降约 55 倍。
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
    // 断联即停止写入曲线：重连后 read_cooler_params 检测到 BLE 恢复即自动继续写。
    // 断联判定与主循环一致（BLE 未连 或 app 进程失活），覆盖"BLE 干净断开"与"app 被强杀"两种场景。
    // 断联期间不写行 → 数据文件留下真实时间空洞，WebUI 按相邻时间戳差 >5s 断开曲线。
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

    // --- 初始化默认档位表（load_config 中 GEAR_B6X_N / GEAR_B7X_N 可覆盖） ---
    init_gear_table();

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

    // --- Gear 模式初始化（与 cooler 状态无关，在 BLE 就绪前完成） ---
    // 原档位存档已删除：改为读 status 文件历史回传制冷强度（回传文件重启不删，保留上次实际状态），
    // 匹配最近档位作为初始档位，读到无效值用 LEVEL_INIT 保底
    if (ctrl_mode != 1) {
        int stored_cold = -1;
        const char *paths[] = {status_file_path_b6, status_file_path_b7};
        for (int i = 0; i < 2 && stored_cold < 1; i++) {
            FILE *f = fopen(paths[i], "r");
            if (f) {
                char line[64];
                while (fgets(line, sizeof(line), f)) {
                    if (strncmp(line, "COLD_REAL=", 10) == 0) {
                        int v = atoi(line + 10);
                        if (v >= 1) stored_cold = v;
                        break;
                    }
                }
                fclose(f);
            }
        }
        if (stored_cold >= 1) {
            int nearest = LEVEL_INIT;
            int min_diff = 9999;
            for (int i = 0; i < gear_count; i++) {
                int diff = abs(gear_table[i].cold - stored_cold);
                if (diff < min_diff) {
                    min_diff = diff;
                    nearest = i + 1;
                }
            }
            batt_gear_base = nearest;
            write_log("status 回传 制冷强度%d→挡位%d", stored_cold, nearest);
        } else {
            batt_gear_base = LEVEL_INIT;
        }
        batt_gear_cooldown = 0;
        final_gear = batt_gear_base;
    }

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

    // --- PID 模式初始化（需要 cooler 状态回传，放在 BLE 就绪后） ---
    // 读取 LSP 模块回传的实际制冷强度，不可用则回退到 gear 对齐
    if (ctrl_mode == 1) {
        float pid_ratio = 0.0f;

        if (cooler_cold_real >= pid_cold_min) {
            // 内部记录 pid_ratio_saved（切回 Gear 时映射回档位）
            pid_ratio = pid_ratio_from_cold(cooler_cold_real, active_pid_cold_max);
            write_log("LSP 回传承载 制冷=%d ratio=%.2f rpm=%d",
                      cooler_cold_real, pid_ratio, pid_align_rpm);
        } else {
            pid_align_from_gear();   // 回退到 gear 对齐
            goto pid_init_done;
        }

        pid_reset_core();

pid_init_done:
        batt_gear_cooldown = 0;
    }

    // --- 进入工作模式 ---
    app_was_alive = 1;
    batt_gear_cooldown = 0;
    emergency_level = 0;
    emerg_forced_gear = 0;
    first_run = 1;
    last_batt_reading = -1;     // 重置电池温度跟踪，使首次 battery_control 视作新读数

    // 以散热器实际回传值为准初始化实际制冷/转速（进入工作模式前 read_cooler_params 已读回传）。
    // 回传异常（文件读失败）时用最小合法值保底，避免删直通后无效初值步进出负值。
    if (cooler_cold_real >= COLD_MIN) actual_cold = cooler_cold_real;
    else if (actual_cold < COLD_MIN) actual_cold = COLD_MIN;
    if (cooler_rpm_real >= fan_rpm_min) actual_rpm = cooler_rpm_real;
    else if (actual_rpm < fan_rpm_min) actual_rpm = fan_rpm_min;

    // 强制首次下发（PID 模式使用 apply_gear_direct 避免走 Gear 表）
    last_bcast_valid = 0;
    if (ctrl_mode == 1) {
        rate_limit_cold(pid_align_cold);
        int send_rpm = rate_limit_fan(compute_fan_target());
        apply_gear_direct(1, 5, send_rpm, actual_cold, 0);
    } else {
        apply_gear(batt_gear_base);
    }

    // ---- 主循环：1 秒节拍（采集 + 控制分离） ----
    // 每 1s：采集电池/CPU/散热器回传 → 写 WebUI 曲线数据文件（滚动 720 行，断联不写）
    // 每 5s（时间判定）：执行控制（仲裁/存活/主循环/限速下发）；原"5 秒间隔对齐"已删除
    time_t last_ctrl = 0;
    while (running) {
        write_webui_data();   // 每 1s 采集写数据文件（刚需热数据，WebUI 直接读）

        if (last_ctrl == 0 || time(NULL) - last_ctrl >= 5) {
            last_ctrl = time(NULL);

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

            // ★ 速率限制执行（替代逐档变动 + RPM 平滑跟踪）
            cycle_batt_temp = cached_batt_raw;   // 1s 采集缓存
            rate_limited_execute();
        }

        sleep(1);
    }

exit:
    if (log_fp) fclose(log_fp);
    return 0;
}
