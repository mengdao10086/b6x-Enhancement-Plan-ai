// ================================================================
// tempctrl.c — 飞智 WaspWing 散热器智能温控守护程序
// ================================================================
//
// 运行环境：Magisk / KernelSU 模块，由 service.sh 启动并守护
// App 进程检测：pgrep -f com.flydigi.waspwing.experimental
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
#include <limits.h>
#include <math.h>

// --- 通用宏 ---
#define EMA(new_val, old_val, alpha_pct) \
    (((new_val) * (alpha_pct) + (old_val) * (100 - (alpha_pct))) / 100)

/** 带方向取整的 EMA：平滑值向原始值方向取整，解决渐进无法到达的问题 */
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
//
// ==========================================================

// --- 档位范围 ---
#define LEVEL_INIT          5     // 无存档时的默认初始档位
#define GEAR_TABLE_MAX      32    // 最大支持档位数（支持自动扩展）

// --- 档位表（动态，可通过 profile.conf 的 GEAR_N 配置覆盖）---
// 每条包含：模式(0=智能温控, 1=固定功率), 目标温度(°C), 风扇转速(RPM), 制冷片强度(0-194)
typedef struct {
    int mode;       // 0=智能温控, 1=固定功率
    int target;     // 智能温控目标温度 (°C)，固定功率时为 0
    int fan_rpm;    // 风扇转速 (RPM)
    int cold;       // 制冷片强度 (0-194)
    int config_n;   // 配置中的原始档位编号（日志显示用，无空洞时同 runtime level）
} GearEntry;

static GearEntry gear_table[GEAR_TABLE_MAX];
static int gear_count = 0;     // 实际档位数，0=尚未初始化
static int gear_min = 1;
static int gear_max = 12;     // 默认 12 档（由 init_gear_table 设定）

// 默认档位表（依实测散热曲线标定，全部固定功率模式）
// 格式：GEAR_<档位N>=<模式>,<目标温度°C>,<风扇RPM>,<制冷强度>
// 范围：N=1~32, 模式=0(智能)或1(固定), 目标=5~35°C, 风扇=2000~6000, 制冷=1~194
// 注意：模式 0 时制冷强度失效（散热器自行管理），模式 1 时目标温度无效
// 例：GEAR_12=1,0,6000,190 表示 12 档固定功率，6000RPM，制冷 190
//     GEAR_5=0,16,2650,0   表示  5 档智能温控，16°C，风扇上限 2650RPM
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
 * 初始化默认档位表
 * 程序启动时调用。若 profile.conf 包含 GEAR_N 配置，load_config 将覆盖之。
 */
static void init_gear_table(void) {
    gear_count = 12;
    gear_min = 1;
    gear_max = 12;
    for (int i = 0; i < gear_count; i++) {
        gear_table[i] = DEFAULT_GEAR_TABLE[i];
    }
}

/** GEAR_N 配置解析临时结构体（用于排序后填入连续档位表） */
typedef struct {
    int config_n;   // 配置中的原始档位编号
    int mode;
    int target;
    int fan_rpm;
    int cold;
} GearConfigTemp;

/** 按配置编号升序排序（供 qsort 使用） */
static int cmp_gear_config_n(const void *a, const void *b) {
    return ((const GearConfigTemp*)a)->config_n - ((const GearConfigTemp*)b)->config_n;
}

/** 获取运行时档位的配置编号（日志显示用，空洞时显示原始编号） */
static inline int gear_label(int level) {
    if (level < 1 || level > gear_count) return level;
    int label = gear_table[level - 1].config_n;
    return (label > 0) ? label : level;
}

// ======================== 常量与边界 ========================
#define COLD_MIN             1
#define COLD_MAX           194     // 最大有效值（更高需超频模式，本场景不用）

// ======================== 系统路径与缩放 ========================
// --- sysfs 路径配置（可由 profile.conf 覆盖）---
static char BATT_TEMP_PATH[128] = "/sys/class/power_supply/battery/temp";
static char CPU_TEMP_PATH_FMT[128] = "/sys/class/thermal/thermal_zone%d/temp";
static char BATT_CURRENT_PATH[128] = "/sys/class/power_supply/battery/current_now";

// --- sysfs 缩放系数（原始值 ÷ 缩放系数 = 内部单位 0.1°C / µA）---
static int BATT_TEMP_DIVISOR = 1;     // 电池温度原始值 0.1°C，无需缩放
static int CPU_TEMP_DIVISOR = 100;    // CPU 温度原始值 m°C，÷100 转 0.1°C
static int BATT_CURRENT_DIVISOR = 1;  // 电池电流原始值 µA，无需缩放

// --- CPU 温度扫描范围（可配置）---
// 首次运行在此范围内扫描有效的 thermal_zone，后续只扫命中的 zone
static int CPU_ZONE_MIN = 0;
static int CPU_ZONE_MAX = 99;

// ======================== 通用参数（PID 和 Gear 共用）================
// --- 基准温度 ---
static int BATT_BASELINE = 350;     // 基准温度 35.0°C

// --- 控制模式 ---
static int ctrl_mode = 1;           // CTRL_MODE: 0=gear, 1=PID

// --- 冷端→风扇映射 ---
static int cold_map_start = 40;     // 映射起始强度，低于此值时线性外推下限
static int cold_map_exp = 150;      // n^exp（÷100，150=1.50），>1 低冷慢转

// --- 热端映射范围 ---
static int hot_map_min = 350;       // HOT_MAP_MIN（0.1°C）
static int hot_map_max = 450;       // HOT_MAP_MAX（0.1°C）

// --- 风扇转速范围 ---
static int fan_rpm_min = 2000;      // FAN_RPM_MIN
static int fan_rpm_max = 6000;      // FAN_RPM_MAX
static int fan_rpm_change_threshold = 100; // 变化阈值（0=不限制）

// ======================== 速率限制 ========================
// --- 固定值 ---
static int RATE_LIMIT_RPM_DOWN = 250;
static int RATE_LIMIT_COLD = 10;
static int RATE_LIMIT_TEMP = 2;

// --- 动态值（根据电池温差自动调整）---
static int RATE_LIMIT_COLD_MULT = 10;  // 制冷强度倍率：d(0.1°C) × mult / 10
static int RATE_LIMIT_FAN_BASE = 200;  // 风扇升速基础值：RPM_UP = base + d × mult / 10
static int RATE_LIMIT_FAN_MULT = 50;   // 风扇升速倍率（RATE_LIMIT_FAN_BASE 双值第二位）
static int cycle_batt_temp = -1;       // 本周期电池温度（-1=未就绪）

// ======================== 实际值 ========================
// 始终向目标档位的表格值靠拢，每周期最多变动速率限制的量
static int actual_rpm = -1;            // 当前实际风扇转速（RPM）
static int actual_cold = -1;           // 当前实际制冷片强度
static int actual_target_temp = -1;    // 当前实际目标温度（°C）

// ======================== Gear 模式 — 电池控制（CTRL_MODE=0）================
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
static int temp_idle_cycles = 0;              // 温度未变的周期数
static int batt_gear_cooldown = 0;            // 电池调档冷却剩余周期

// ======================== Gear 模式 — 紧急干预（CTRL_MODE=0）================
// --- 独立开关 ---
static int EMERG_CPU_ENABLED     = 1;         // CPU 温度紧急开关
static int EMERG_CURRENT_ENABLED = 0;         // 电流紧急开关

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

// --- 电池电流紧急 ---
static int CURRENT_EMERG_3 = 700;   // >7A → 等级 3
static int CURRENT_EMERG_2 = 600;   // >6A → 等级 2
static int CURRENT_EMERG_1 = 500;   // >5A → 等级 1
static int CURRENT_RECOVER_2 = 600; // <6A → 从 3 降为 2
static int CURRENT_RECOVER_1 = 500; // <5A → 从 2 降为 1
static int CURRENT_RECOVER_0 = 400; // <4A → 退出紧急
static int CURRENT_SMOOTH_ALPHA = 25;   // 电流退出 EMA 平滑系数（%）
// 电流紧急运行状态
static int curr_emerg_smooth_val   = 0;   // 平滑后的电流值（µA）
static int curr_emerg_smooth_valid = 0;   // 平滑数据是否有效

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
static int LOG_MAX_KB = 7;          // 日志文件大小上限（KB），0=关闭日志
static int log_trim_lines = 3;      // 日志超限时删除最早 N 行，0=不清理
static FILE *log_fp = NULL;          // 持久的日志文件指针，避免每行都 fopen/fclose
static char log_path_opened[256] = ""; // 已打开的文件路径（检测路径变化）
static int debug_mode = 0;           // 调试日志总开关，=1 时启用各分区调试输出
static int debug_sensor = 0;    // [传感器] 电池/CPU/电流读数
static int debug_emerg   = 0;   // [紧急干预] CPU 温度/电流紧急等级计算
static int debug_batt    = 0;   // [电池控制] 电池温度调档/恢复期/反补
static int debug_exec    = 0;   // [执行下发] 速率限制/am broadcast 送参数
static int debug_conn    = 0;   // [连接状态] App 存活/BLE/重连对齐
static int debug_config  = 0;   // [配置加载] 配置文件解析过程
static int debug_main    = 0;   // [主循环] main_loop 流程跟踪
static int debug_pid     = 0;   // [PID] PID 控制调试

// ======================== 配置文件系统 ========================
// 配置文件路径（自动检测或 --config 指定）
static char config_path[256] = "";
// 配置文件的最后修改时间（用于热重载检测）
static time_t config_mtime = 0;

// ======================== PID 模式控制（CTRL_MODE=1）================
// --- 核心参数 ---
static int pid_kp = 300;                  // PID_KP（÷1000，1°C→P=40%）
static int pid_ki = 50;                   // PID_KI（÷1000）
static int pid_kd = 240;                  // PID_KD
static int pid_integral_limit = 800;      // PID_INTEGRAL_LIMIT（÷1000）

// --- KI 方差门控 ---
static int pid_ki_var_threshold = 25;     // PID_KI_VAR_THRESHOLD（0.1°C²，0=关闭）
static int pid_ki_var_samples = 6;        // PID_KI_VAR_SAMPLES（采样数，2~20）
static int pid_ki_deadband = 15;          // PID_KI_DEADBAND（0.1°C，0=禁止I项）

// --- 输入滤波 ---
static int pid_input_filter_enabled = 1;  // PID_INPUT_FILTER_ENABLED: 1=每周期滤波+PID重算
static int pid_batt_alpha = 33;           // PID_BATT_ALPHA（%，新值权重）
static int pid_filter_auto_threshold_on = 30;   // 自动关闭阈值（×0.1周期）
static int pid_filter_auto_threshold_off = 20;  // 自动恢复阈值（×0.1周期）
static int pid_filter_auto_alpha = 20;          // 间隔EMA平滑系数（%）
static int pid_filter_auto_off = 0;             // 运行时标志：1=自适应关闭了滤波
static int pid_filter_interval_smooth = -1;     // 平滑后的更新周期数（0.1周期）
#define PID_FILTER_GAP_MULT 2   // 滤波间隔 EMA 输入钳位倍数

// --- PID 运行状态 ---
static int pid_integral_accum = 0;        // 积分累积值
static int pid_prev_error = 0;            // 上周期误差
static int pid_batt_filtered = -1;        // EMA 滤波后电池温度
static int pid_last_batt = -1;            // 上次参与 PID 计算的原始温度
static time_t pid_last_change_time = 0;   // 上次温度变化时间戳
// 方差门控环形缓冲区
#define PID_VAR_BUF_MAX 20    // 最大支持采样数（≥ PID_KI_VAR_SAMPLES 上限）
static int pid_var_buffer[PID_VAR_BUF_MAX];
static int pid_var_head = 0;
static int pid_var_count = 0;

// --- 输入补偿（加到电池温度，反映 CPU/电流额外发热）---
static int pid_cpu_comp_enabled = 1;       // PID_CPU_COMP_ENABLED: CPU 补偿开关
static int pid_cpu_comp_divisor = 30;      // PID_CPU_COMP_DIVISOR: (cpu-batt 0.1°C)÷divisor→0.1°C
static int pid_curr_comp_enabled = 0;      // PID_CURR_COMP_ENABLED: 电流补偿开关（默认关）
static int pid_curr_comp_threshold = 200;  // PID_CURR_COMP_THRESHOLD: 0.01A 阈值(200=2A)
static int pid_curr_comp_divisor = 2;      // PID_CURR_COMP_DIVISOR: |A|÷divisor→°C
static float pid_cpu_comp_smooth = 0.0f;   // CPU 补偿 EMA 平滑值（°C）
static float pid_curr_comp_smooth = 0.0f;  // 电流补偿 EMA 平滑值（°C）
static int pid_last_comp_10 = 0;           // 上次 PID 重算时的补偿值（0.1°C）

// --- 输出映射与对齐 ---
static int pid_cold_min = 1;              // PID_COLD_MIN
static int pid_cold_max = 190;            // PID_COLD_MAX
static int pid_align_rpm = 2000;          // PID 目标 RPM（供 rate_limited_execute 读取）
static int pid_align_cold = 1;            // PID 目标制冷强度

// ======================== 散热器回传参数 ========================
static int cooler_runmode = -1;           // 散热器实际运行模式
static int cooler_hot_temp = -1;          // 热端温度（0.1°C）
static int cooler_cold_temp = -1;         // 冷端温度（0.1°C）
static int cooler_rpm_real = -1;          // 实际风扇转速
static int cooler_rpm_level = -1;         // 风扇 PWM 原始值
static int cooler_cold_real = -1;         // 实际制冷强度
static int cooler_cold_level = -1;        // 制冷 PWM 原始值
static int cooler_target_temp = -1;       // 目标温度（0.1°C）

// ======================== 全局运行状态 ========================
// --- 信号 ---
static volatile int running = 1;

// --- 电池温度 mtime 追踪（替代值比较跳过）---
static time_t batt_temp_mtime = 0;    // 电池温度文件最后修改时间
static int batt_cached_temp = -1;      // 最后一次读取的温度缓存
static int batt_temp_updated = 0;      // 本周期温度是否更新

// --- 连接状态 ---
static int STATUS_TIMEOUT = 12;
static int app_was_alive = 0;
static char status_file_path[512] = "";
static char gear_file_path[512] = "";
static int app_ble_connected = 0;

// --- 档位模式自动风扇 ---
static int gear_auto_fan = 1;   // GEAR_AUTO_FAN: 0=直通, 1=自动映射+截断

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
static int match_nearest_gear_for_reconnect(void);
static void pid_align_from_gear(void);
static int rpm_from_hot_end(int hot_10);
static int rpm_from_cold_exp(int cold);
static int rpm_combine_weighted(int rpm_hot, int rpm_cold);

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
 * 从 KEY=VALUE 格式的配置文件加载参数
 * 遇到不认识的 key 或格式错误的行，跳过并记日志
 * 找不到文件则不修改任何变量（保持默认值）
 *
 * 第一遍预读 PERF_ENABLED 和 DEBUG_ENABLED：
 *   - PERF_ENABLED=1：解析除 DEBUG_* 子项外的全部参数（性能/系统/路径/模式等）
 *   - DEBUG_ENABLED=1：解析 DEBUG_SENSOR/EMERG/BATT 等调试子项
 *   - 两者都关闭时跳过全部解析，使用代码默认值
 * 去掉了更低层的条件守卫（CURRENT_GEAR_MODE/ctrl_mode/gear_config_enabled 等子守卫）
 */
static void load_config(const char *path) {
    FILE *f = fopen(path, "r");
    if (!f) {
        write_log("配置 无法打开 %s", path);
        return;
    }
    int old_ctrl_mode = ctrl_mode;  // 保存旧值，用于 PID 过渡检测

    // --- 第一遍：预读 PERF_ENABLED 和 DEBUG_ENABLED（全扫描，不受配置顺序影响）---
    char line[256];
    int perf_enabled = 1;
    int found_debug = 0;
    while (fgets(line, sizeof(line), f)) {
        char *key;
        char *val_str = config_parse_line(line, &key);
        if (!val_str) continue;
        if (strcmp(key, "PERF_ENABLED") == 0) {
            perf_enabled = atoi(val_str) != 0;
        } else if (strcmp(key, "DEBUG_ENABLED") == 0) {
            found_debug = atoi(val_str) != 0;
        }
    }

    if (!perf_enabled && !found_debug) {
        write_log("配置 PERF=0 且 DEBUG=0，跳过解析");
        fclose(f);
        return;
    }

    if (perf_enabled) {
        write_log("配置 自定义性能参数 启用");
    }

    if (found_debug) {
        debug_mode = 1;
        write_log("配置 调试日志 开启");
    } else {
        debug_mode = 0;
    }

    // --- 第二遍：全量单次扫描，仅分两层（PERF/DEBUG），无子守卫 ---
    rewind(f);
    int loaded = 0;
    int gear_config_enabled = 0;
    GearConfigTemp config_gears[GEAR_TABLE_MAX];
    int config_gear_count = 0;
    while (fgets(line, sizeof(line), f)) {
        char *key;
        char *val_str = config_parse_line(line, &key);
        if (!val_str) continue;
        int val = atoi(val_str);

        // --- DEBUG 子开关：仅 DEBUG_ENABLED=1 时解析 ---
        if (debug_mode && strncmp(key, "DEBUG_", 6) == 0 && strcmp(key, "DEBUG_ENABLED") != 0) {
            if      (strcmp(key, "DEBUG_SENSOR") == 0)  debug_sensor = (val != 0);
            else if (strcmp(key, "DEBUG_EMERG") == 0)   debug_emerg  = (val != 0);
            else if (strcmp(key, "DEBUG_BATT") == 0)    debug_batt   = (val != 0);
            else if (strcmp(key, "DEBUG_EXEC") == 0)    debug_exec   = (val != 0);
            else if (strcmp(key, "DEBUG_CONN") == 0)    debug_conn   = (val != 0);
            else if (strcmp(key, "DEBUG_CONFIG") == 0)  debug_config = (val != 0);
            else if (strcmp(key, "DEBUG_MAIN") == 0)    debug_main   = (val != 0);
            else if (strcmp(key, "DEBUG_PID") == 0)     debug_pid    = (val != 0);
            loaded++;
            continue;
        }

        // --- 性能参数：仅 PERF_ENABLED=1 时解析（含除 DEBUG_* 外的全部参数） ---
        //     无子守卫：路径/CURRENT_GEAR_*/PID_*/GEAR_N/模式开关等全部在此层
        if (!perf_enabled) continue;

        // --- 系统路径与缩放 ---
        if      (strcmp(key, "BATT_TEMP_PATH") == 0)
            config_read_path(BATT_TEMP_PATH, sizeof(BATT_TEMP_PATH), val_str);
        else if (strcmp(key, "CPU_TEMP_PATH_FMT") == 0)
            config_read_path(CPU_TEMP_PATH_FMT, sizeof(CPU_TEMP_PATH_FMT), val_str);
        else if (strcmp(key, "BATT_CURRENT_PATH") == 0)
            config_read_path(BATT_CURRENT_PATH, sizeof(BATT_CURRENT_PATH), val_str);
        else if (strcmp(key, "BATT_TEMP_DIVISOR") == 0)   BATT_TEMP_DIVISOR  = clamp(val, 1, 10000);
        else if (strcmp(key, "CPU_TEMP_DIVISOR") == 0)    CPU_TEMP_DIVISOR   = clamp(val, 1, 10000);
        else if (strcmp(key, "BATT_CURRENT_DIVISOR") == 0) BATT_CURRENT_DIVISOR = clamp(val, 1, 10000);

        // --- 多值连续格式（空格分隔的 2~4 值）---
        else if (strcmp(key, "CPU_ZONE") == 0) {
            int a = CPU_ZONE_MIN, b = CPU_ZONE_MAX;
            if (sscanf(val_str, "%d %d", &a, &b) >= 2) { CPU_ZONE_MIN = clamp(a,0,99); CPU_ZONE_MAX = clamp(b,0,99); }
        }
        else if (strcmp(key, "HOT_MAP") == 0) {
            int a = hot_map_min, b = hot_map_max;
            if (sscanf(val_str, "%d %d", &a, &b) >= 2) { hot_map_min = clamp(a,200,500); hot_map_max = clamp(b,200,500); }
        }
        else if (strcmp(key, "FAN_RPM") == 0) {
            int a = fan_rpm_min, b = fan_rpm_max;
            if (sscanf(val_str, "%d %d", &a, &b) >= 2) { fan_rpm_min = clamp(a,1000,6000); fan_rpm_max = clamp(b,1000,6000); }
        }
        else if (strcmp(key, "PID_FILTER_AUTO_THRESHOLD") == 0) {
            int a = pid_filter_auto_threshold_on, b = pid_filter_auto_threshold_off;
            if (sscanf(val_str, "%d %d", &a, &b) >= 2) { pid_filter_auto_threshold_on=clamp(a,5,100); pid_filter_auto_threshold_off=clamp(b,5,100); }
        }
        else if (strcmp(key, "PID_ALPHA") == 0) {
            int a = pid_filter_auto_alpha, b = pid_batt_alpha;
            if (sscanf(val_str, "%d %d", &a, &b) >= 2) { pid_filter_auto_alpha=clamp(a,1,100); pid_batt_alpha=clamp(b,1,100); }
        }
        else if (strcmp(key, "PID_COLD") == 0) {
            int a = pid_cold_min, b = pid_cold_max;
            if (sscanf(val_str, "%d %d", &a, &b) >= 2) { pid_cold_min=clamp(a,0,194); pid_cold_max=clamp(b,0,194); }
        }
        else if (strcmp(key, "BATT_BOUNDARY") == 0) {
            int v[3] = {BATT_BOUNDARY_1,BATT_BOUNDARY_2,BATT_BOUNDARY_3};
            if (sscanf(val_str, "%d %d %d", &v[0],&v[1],&v[2]) >= 3)
                { BATT_BOUNDARY_1=clamp(v[0],1,100); BATT_BOUNDARY_2=clamp(v[1],1,100); BATT_BOUNDARY_3=clamp(v[2],1,100); }
        }
        else if (strcmp(key, "CURRENT_GEAR_MULT") == 0) {
            int a = CURRENT_GEAR_MULT_CHARGE, b = CURRENT_GEAR_MULT_DISCHARGE;
            if (sscanf(val_str, "%d %d", &a, &b) >= 2)
                { CURRENT_GEAR_MULT_CHARGE=clamp(a,1,50); CURRENT_GEAR_MULT_DISCHARGE=clamp(b,1,50); }
        }
        else if (strcmp(key, "REV_COMP_T") == 0) {
            int v[3] = {REV_COMP_THRESH_1,REV_COMP_THRESH_2,REV_COMP_THRESH_3};
            if (sscanf(val_str, "%d %d %d", &v[0],&v[1],&v[2]) >= 3)
                { REV_COMP_THRESH_1=clamp(v[0],1,50); REV_COMP_THRESH_2=clamp(v[1],1,50); REV_COMP_THRESH_3=clamp(v[2],1,50); }
        }
        else if (strcmp(key, "EMERG_FORCED") == 0) {
            int v[4] = {EMERG_FORCED_1,EMERG_FORCED_2,EMERG_FORCED_3,EMERG_FORCED_4};
            if (sscanf(val_str, "%d %d %d %d", &v[0],&v[1],&v[2],&v[3]) >= 4)
                { EMERG_FORCED_1=clamp(v[0],0,12); EMERG_FORCED_2=clamp(v[1],0,12); EMERG_FORCED_3=clamp(v[2],0,12); EMERG_FORCED_4=clamp(v[3],0,12); }
        }
        else if (strcmp(key, "EMERG_RECOVERY_MULT") == 0) {
            int v[3] = {EMERG_RECOVERY_MULT_1,EMERG_RECOVERY_MULT_2,EMERG_RECOVERY_MULT_3};
            if (sscanf(val_str, "%d %d %d", &v[0],&v[1],&v[2]) >= 3)
                { EMERG_RECOVERY_MULT_1=clamp(v[0],1,20); EMERG_RECOVERY_MULT_2=clamp(v[1],1,20); EMERG_RECOVERY_MULT_3=clamp(v[2],1,20); }
        }
        else if (strcmp(key, "CPU_EMERG") == 0) {
            int v[4] = {CPU_RECOVER_0,CPU_EMERG_1,CPU_EMERG_2,CPU_EMERG_3};
            if (sscanf(val_str, "%d %d %d %d", &v[0],&v[1],&v[2],&v[3]) >= 4) {
                CPU_RECOVER_0=clamp(v[0],300,700); CPU_EMERG_1=clamp(v[1],400,800);
                CPU_EMERG_2=clamp(v[2],500,900);   CPU_EMERG_3=clamp(v[3],600,1000);
                CPU_RECOVER_1=CPU_EMERG_1; CPU_RECOVER_2=CPU_EMERG_2; // 自动同步恢复阈值
            }
        }
        else if (strcmp(key, "CURRENT_EMERG") == 0) {
            int v[4] = {CURRENT_RECOVER_0,CURRENT_EMERG_1,CURRENT_EMERG_2,CURRENT_EMERG_3};
            if (sscanf(val_str, "%d %d %d %d", &v[0],&v[1],&v[2],&v[3]) >= 4) {
                CURRENT_RECOVER_0=clamp(v[0],100,1500); CURRENT_EMERG_1=clamp(v[1],100,1500);
                CURRENT_EMERG_2=clamp(v[2],100,1500);   CURRENT_EMERG_3=clamp(v[3],100,1500);
                CURRENT_RECOVER_1=CURRENT_EMERG_1; CURRENT_RECOVER_2=CURRENT_EMERG_2;
            }
        }

        // --- 电池控制 ---
        else if (strcmp(key, "BATT_BASELINE") == 0)        BATT_BASELINE      = clamp(val, 300, 500);
        else if (strcmp(key, "BATT_COOLDOWN_CYCLES") == 0) BATT_COOLDOWN_CYCLES = clamp(val, 0, 20);

        // --- 紧急恢复期 ---
        else if (strcmp(key, "EMERG_RECOVERY_PHASE_CYCLES") == 0) EMERG_RECOVERY_PHASE_CYCLES = clamp(val, 1, 50);

        // --- CPU 紧急 ---
        else if (strcmp(key, "CPU_FILTER_ALPHA") == 0)     CPU_FILTER_ALPHA   = clamp(val, 1, 100);

        // --- 电流紧急 ---
        else if (strcmp(key, "CURRENT_SMOOTH_ALPHA") == 0)  CURRENT_SMOOTH_ALPHA = clamp(val, 1, 100);

        // --- 紧急强制与退出 ---
        else if (strcmp(key, "EMERG_EXIT_CAP_OFFSET") == 0) EMERG_EXIT_CAP_OFFSET = clamp(val, 0, 5);
        else if (strcmp(key, "EMERG_STEP") == 0)              EMERG_STEP = clamp(val, 1, 12);
        else if (strcmp(key, "EMERG_EXIT_BATT_THRESHOLD") == 0) EMERG_EXIT_BATT_THRESHOLD = clamp(val, 5, 50);

        // --- 反补与趋势豁免 ---
        else if (strcmp(key, "TREND_RESET_THRESHOLD") == 0)         TREND_RESET_THRESHOLD       = clamp(val, 0, 20);
        else if (strcmp(key, "REV_COMP_COOLDOWN") == 0)   REV_COMP_COOLDOWN  = clamp(val, 0, 10);

        // --- 速率限制 ---
        else if (strcmp(key, "RATE_LIMIT_RPM_DOWN") == 0) RATE_LIMIT_RPM_DOWN = clamp(val, 50, 2000);
        else if (strcmp(key, "RATE_LIMIT_COLD") == 0) {
            int base = RATE_LIMIT_COLD, mult = RATE_LIMIT_COLD_MULT;
            if (sscanf(val_str, "%d %d", &base, &mult) >= 1) {
                RATE_LIMIT_COLD      = clamp(base, 1, 194);
                RATE_LIMIT_COLD_MULT = clamp(mult, 1, 100);
            }
        }
        else if (strcmp(key, "RATE_LIMIT_TEMP") == 0) RATE_LIMIT_TEMP = clamp(val, 1, 30);
        else if (strcmp(key, "RATE_LIMIT_FAN_BASE") == 0) {
            int rise = RATE_LIMIT_FAN_BASE, mult = RATE_LIMIT_FAN_MULT;
            if (sscanf(val_str, "%d %d", &rise, &mult) >= 1) {
                RATE_LIMIT_FAN_BASE   = clamp(rise, 50, 2000);
                RATE_LIMIT_FAN_MULT = clamp(mult, 1, 200);
            }
        }

        // --- PID 核心 + 补偿 ---
        else if (strcmp(key, "PID_KP") == 0)              pid_kp              = clamp(val, 1, 1000);
        else if (strcmp(key, "PID_KI") == 0)              pid_ki              = clamp(val, 0, 1000);
        else if (strcmp(key, "PID_KD") == 0)              pid_kd              = clamp(val, 0, 1000);
        else if (strcmp(key, "PID_INTEGRAL_LIMIT") == 0)  pid_integral_limit  = clamp(val, 0, 1000);
        else if (strcmp(key, "PID_KI_VAR_THRESHOLD") == 0) pid_ki_var_threshold = clamp(val, 0, 200);
        else if (strcmp(key, "PID_KI_VAR_SAMPLES") == 0)   pid_ki_var_samples   = clamp(val, 2, 20);
        else if (strcmp(key, "PID_KI_DEADBAND") == 0)       pid_ki_deadband      = clamp(val, 0, 100);
        else if (strcmp(key, "PID_INPUT_FILTER_ENABLED") == 0) pid_input_filter_enabled = (val != 0);
        else if (strcmp(key, "PID_CPU_COMP_ENABLED") == 0)   pid_cpu_comp_enabled   = (val != 0);
        else if (strcmp(key, "PID_CPU_COMP_DIVISOR") == 0)   pid_cpu_comp_divisor   = clamp(val, 5, 200);
        else if (strcmp(key, "PID_CURR_COMP_ENABLED") == 0)  pid_curr_comp_enabled  = (val != 0);
        else if (strcmp(key, "PID_CURR_COMP_THRESHOLD") == 0) pid_curr_comp_threshold = clamp(val, 50, 1000);
        else if (strcmp(key, "PID_CURR_COMP_DIVISOR") == 0)  pid_curr_comp_divisor  = clamp(val, 1, 50);

        // --- PID 映射 ---
        else if (strcmp(key, "COLD_MAP_START") == 0)   cold_map_start  = clamp(val, 0, 194);
        else if (strcmp(key, "COLD_MAP_EXP") == 0)         cold_map_exp        = clamp(val, 50, 500);
        else if (strcmp(key, "FAN_RPM_CHANGE_THRESHOLD") == 0) fan_rpm_change_threshold = clamp(val, 0, 2000);

        // --- 日志与系统 ---
        else if (strcmp(key, "LOG_MAX_KB") == 0)           LOG_MAX_KB         = clamp(val, 0, 1000);
        else if (strcmp(key, "LOG_TRIM_LINES") == 0)       log_trim_lines     = clamp(val, 0, 50);
        else if (strcmp(key, "LOG_FILE") == 0)
            config_read_path(log_file_path, sizeof(log_file_path), val_str);

        // --- 模式开关等 ---
        else if (strcmp(key, "CTRL_MODE") == 0)                ctrl_mode            = (val != 0);
        else if (strcmp(key, "GEAR_AUTO_FAN") == 0)        gear_auto_fan       = (val != 0);
        else if (strcmp(key, "EMERG_CURRENT_ENABLED") == 0)   EMERG_CURRENT_ENABLED = (val != 0);
        else if (strcmp(key, "EMERG_CPU_ENABLED") == 0)       EMERG_CPU_ENABLED     = (val != 0);
        else if (strcmp(key, "REV_COMP_ENABLED") == 0)        REV_COMP_ENABLED      = (val != 0);
        else if (strcmp(key, "TREND_EXEMPT_ENABLED") == 0)    TREND_EXEMPT_ENABLED  = (val != 0);
        else if (strcmp(key, "GEAR_CONFIG_ENABLED") == 0)     gear_config_enabled   = (val != 0);
        else if (strcmp(key, "CURRENT_GEAR_MODE") == 0) {
            int charge = CURRENT_GEAR_MODE_CHARGE, discharge = CURRENT_GEAR_MODE_DISCHARGE;
            if (sscanf(val_str, "%d %d", &charge, &discharge) >= 1) {
                CURRENT_GEAR_MODE_CHARGE    = clamp(charge, 0, 1);
                CURRENT_GEAR_MODE_DISCHARGE = clamp(discharge, 0, 1);
            }
        }
        else if (strcmp(key, "EMERG_MODE") == 0) {
            int entry = EMERG_MODE_ENTRY, exit = EMERG_MODE_EXIT;
            if (sscanf(val_str, "%d %d", &entry, &exit) >= 1) {
                EMERG_MODE_ENTRY = clamp(entry, 0, 1);
                EMERG_MODE_EXIT  = clamp(exit, 0, 1);
            }
        }

        // --- 电流-挡位子项（无 CURRENT_GEAR_MODE 子守卫）---
        else if (strncmp(key, "CURRENT_GEAR_", 13) == 0) {
            if      (strcmp(key, "CURRENT_GEAR_SMOOTH_ALPHA") == 0)
                CURRENT_GEAR_SMOOTH_ALPHA = clamp(val, 1, 100);
            else if (strcmp(key, "CURRENT_GEAR_MIN") == 0)
                CURRENT_GEAR_MIN = clamp(val, 1, 12);
        }

        // --- 档位表（无 gear_config_enabled 子守卫，收集后由后处理判断）---
        else if (strncmp(key, "GEAR_", 5) == 0) {
            int n = atoi(key + 5);
            if (n < 1 || n > GEAR_TABLE_MAX) continue;
            int m, t, f, c;
            char *next;
            m = (int)strtol(val_str, &next, 10);
            if (*next != ',') continue;
            t = (int)strtol(next + 1, &next, 10);
            if (*next != ',') continue;
            f = (int)strtol(next + 1, &next, 10);
            if (*next != ',') continue;
            c = (int)strtol(next + 1, NULL, 10);
            if (config_gear_count < GEAR_TABLE_MAX) {
                config_gears[config_gear_count].config_n = n;
                config_gears[config_gear_count].mode     = (m == 0) ? 0 : 1;
                config_gears[config_gear_count].target   = clamp(t, 5, 35);
                config_gears[config_gear_count].fan_rpm  = clamp(f, 2000, 6000);
                config_gears[config_gear_count].cold     = clamp(c, 1, 194);
                config_gear_count++;
            }
        }

        else { continue; }
        loaded++;
    }
    fclose(f);

    // CTRL_MODE 变化过渡处理
    if (ctrl_mode != old_ctrl_mode) {
        last_bcast_valid = 0;
        if (ctrl_mode == 1 && config_mtime != 0) {
            pid_align_from_gear();
        }
        write_log("配置 CTRL_MODE=%d", ctrl_mode);
    }

    // --- GEAR_N 后处理：排序重排为连续档位表，同步范围 ---
    if (gear_config_enabled) {
        if (config_gear_count > 0) {
            // 重置档位表，填入配置档位
            gear_count = 0;
            gear_max = 0;
            memset(gear_table, 0, sizeof(gear_table));
            actual_rpm = -1;
            actual_cold = -1;
            actual_target_temp = -1;

            qsort(config_gears, config_gear_count, sizeof(GearConfigTemp), cmp_gear_config_n);
            for (int i = 0; i < config_gear_count; i++) {
                gear_table[i].config_n = config_gears[i].config_n;
                gear_table[i].mode     = config_gears[i].mode;
                gear_table[i].target   = config_gears[i].target;
                gear_table[i].fan_rpm  = config_gears[i].fan_rpm;
                gear_table[i].cold     = config_gears[i].cold;
                gear_count++;
            }
            gear_max = gear_count;
            batt_gear_base = clamp(batt_gear_base, gear_min, gear_max);
            write_log("配置 档位表 %d 级 (1~%d)", gear_count, gear_max);
        } else {
            // 所有 GEAR_N 行格式无效，回退到默认档位表
            init_gear_table();
            write_log("配置 GEAR_N 全部无效，使用默认档位表 (%d 级)", gear_count);
        }
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
 * 写入日志（自动滚动：超上限后删除最早 3 行）。
 * 日期格式：日+时间，无年月（例 "14 22:30:16"）。
 * LOG_MAX_KB=0 时关闭日志。持持久 FILE* 避免每行 open/close。
 */
static void write_log(const char *fmt, ...) {
    if (LOG_MAX_KB == 0) return;     // 日志关闭

    int max_bytes = LOG_MAX_KB * 1024;

    // 超标 → 滚动：先关 log_fp，再读-删-写，下次自动重开（调试模式下跳过限制，保留完整日志）
    struct stat st;
    if (!debug_mode && log_trim_lines > 0 && stat(log_file_path, &st) == 0 && st.st_size > max_bytes) {
        if (log_fp) { fclose(log_fp); log_fp = NULL; }
        size_t sz = st.st_size;
        char *buf = malloc(sz + 1);
        if (buf) {
            FILE *rf = fopen(log_file_path, "r");
            if (rf) {
                size_t rd = fread(buf, 1, sz, rf);
                buf[rd] = '\0';
                fclose(rf);

                // 跳过前 N 个换行（删除最早 N 行，行数由 log_trim_lines 配置）
                int nl = 0;
                char *tail = buf;
                while (*tail && nl < log_trim_lines) {
                    if (*tail == '\n') nl++;
                    tail++;
                }

                FILE *wf = fopen(log_file_path, "w");
                if (wf) {
                    fwrite(tail, 1, rd - (tail - buf), wf);
                    fclose(wf);
                }
            }
            free(buf);
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

/** 调试日志宏：需要总开关 DEBUG_MODE=1 且对应分区开关=1 时才输出 */
/* 注意：必须写成单行，多行续行在 NDK clang + CRLF 下会失效 */
#define debug_log(flag, fmt, ...) do { if (debug_mode && (flag)) write_log("[DEBUG] " fmt, ##__VA_ARGS__); } while(0)
#define pid_log(fmt, ...) \
    do { if (debug_mode && debug_pid) \
        write_log("[PID] " fmt, ##__VA_ARGS__); \
    } while(0)
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

/** 限速步进：actual 向 desired 靠拢，每周期最多变 up_limit（升）或 down_limit（降） */
static inline void rate_limit(int *actual, int desired, int up_limit, int down_limit) {
    if (*actual < 0) { *actual = desired; return; }
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

// ======================== 状态文件（模块心跳 + BLE 状态） ========================

/**
 * 根据二进制名设定状态文件路径
 * 例：tempctrl → /data/local/tmp/tempctrl.status
 */
static void set_default_status_path(void) {
    char basename[64];
    if (get_exe_basename(basename, sizeof(basename))) {
        snprintf(status_file_path, sizeof(status_file_path),
                 "/data/local/tmp/%s.status", basename);
        return;
    }
    // fallback
    strncpy(status_file_path, "/data/local/tmp/tempctrl.status",
            sizeof(status_file_path) - 1);
}

/**
 * 创建（或触摸）状态文件，设 0666 权限
 *
 * 模块（App 进程）通过此文件向 daemon 发送 BLE 连接状态和心跳。
 * daemon 创建后模块每 5 秒覆写一次 "BLE=0/1\n"。
 * open("a") 不会截断已有内容，仅创建/更新时间戳。
 */
static void create_status_file(void) {
    FILE *f = fopen(status_file_path, "a");
    if (f) {
        fclose(f);
        chmod(status_file_path, 0666);
        write_log("状态文件 就绪 %s", status_file_path);
    } else {
        write_log("状态文件 创建失败 %s", status_file_path);
    }
}

/**
 * 读取状态文件中的 BLE 连接状态
 * 纯内容读取，不过问 mtime（mtime 由 is_app_alive 检测）
 * 读失败时不修改 app_ble_connected（保持旧值）
 */
static void read_status_ble(void) {
    FILE *f = fopen(status_file_path, "r");
    if (!f) return;

    char line[64];
    while (fgets(line, sizeof(line), f)) {
        if (strncmp(line, "BLE=", 4) == 0) {
            int val = atoi(line + 4);
            app_ble_connected = (val != 0);
        } else if (strncmp(line, "RUN_MODE=", 9) == 0) {
            cooler_runmode = atoi(line + 9);
        } else if (strncmp(line, "HOT_TEMP=", 9) == 0) {
            cooler_hot_temp = atoi(line + 9);
        } else if (strncmp(line, "COLD_TEMP=", 10) == 0) {
            cooler_cold_temp = atoi(line + 10);
        } else if (strncmp(line, "RPM_REAL=", 9) == 0) {
            cooler_rpm_real = atoi(line + 9);
        } else if (strncmp(line, "RPM_LEVEL=", 10) == 0) {
            cooler_rpm_level = atoi(line + 10);
        } else if (strncmp(line, "COLD_REAL=", 10) == 0) {
            cooler_cold_real = atoi(line + 10);
        } else if (strncmp(line, "COLD_LEVEL=", 11) == 0) {
            cooler_cold_level = atoi(line + 11);
        } else if (strncmp(line, "TARGET_TEMP=", 12) == 0) {
            cooler_target_temp = atoi(line + 12);
        }
    }
    fclose(f);
}

// ======================== 存档（持久化上次制冷强度） ========================

/**
 * 设定存档路径（根据 /proc/self/exe 推导）
 */
static void set_gear_file_path(void) {
    char basename[64];
    if (get_exe_basename(basename, sizeof(basename))) {
        snprintf(gear_file_path, sizeof(gear_file_path),
                 "/data/local/tmp/%s.gear", basename);
        return;
    }
    strncpy(gear_file_path, "/data/local/tmp/tempctrl.gear",
            sizeof(gear_file_path) - 1);
}

/**
 * 保存制冷强度到存档文件
 */
static void save_cold(int cold) {
    if (cold < 1) return;
    FILE *f = fopen(gear_file_path, "w");
    if (f) {
        fprintf(f, "%d\n", cold);
        fclose(f);
    }
}

/**
 * 读取存档制冷强度，失败返回 -1
 */
static int load_cold(void) {
    FILE *f = fopen(gear_file_path, "r");
    if (!f) return -1;
    int val = -1;
    fscanf(f, "%d", &val);
    fclose(f);
    return val;
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
 * 文件路径：/sys/class/power_supply/battery/temp
 * 失败返回 -1
 */
static int read_battery_temp(void) {
    // 先 stat 检测文件修改时间戳
    struct stat st;
    int st_ok = (stat(BATT_TEMP_PATH, &st) == 0);

    // 文件存在且 mtime 未变（非首次）→ 返回缓存，标记未更新
    if (st_ok && batt_temp_mtime != 0 && st.st_mtime == batt_temp_mtime) {
        batt_temp_updated = 0;
        return batt_cached_temp;
    }

    // mtime 变化或首次 / stat 失败 → 正常读取
    int raw = read_sysfs_int(BATT_TEMP_PATH);
    if (raw < 0) {
        batt_temp_updated = 0;
        return -1;
    }
    int val = raw / BATT_TEMP_DIVISOR;
    debug_log(debug_sensor, "batt_temp 原始 %d 除数 %d = %d (%.1f°C) mtime=%ld",
              raw, BATT_TEMP_DIVISOR, val, val / 10.0, st_ok ? (long)st.st_mtime : 0L);
    batt_cached_temp = val;
    batt_temp_updated = 1;
    if (st_ok) batt_temp_mtime = st.st_mtime;
    return val;
}

/**
 * 缓存已发现的 CPU 温度 zone（首次全量扫描后记录）
 */
#define CPU_ZONE_MAX_CACHE 64
#define CPU_ZONE_TOP_KEEP   20   // 首次扫描后只保留温度最高的 N 个 zone
static int cpu_zone_cache[CPU_ZONE_MAX_CACHE];
static int cpu_zone_count = 0;
static int cpu_zone_scanned = 0;

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
    // 首次调用 → 在 CPU_ZONE_MIN~MAX 范围内扫描可用 zone
    if (!cpu_zone_scanned) {
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

        if (keep == 0) {
            debug_log(debug_sensor, "thermal_zone 扫描 无可读 zone（路径 %s），CPU 紧急无法触发",
                      CPU_TEMP_PATH_FMT);
        } else {
            debug_log(debug_sensor, "thermal_zone 扫描 发现 %d 个有效 zone，保留 %d 个最高温",
                      count, keep);
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

/**
 * 读取电池电流绝对值（µA）
 * /sys/class/power_supply/battery/current_now
 * 正值=放电，负值=充电，本函数取绝对值
 * 返回值：µA 绝对值，读取失败返回 -1
 */
static int read_battery_current_abs(void) {
    int val = read_sysfs_int(BATT_CURRENT_PATH);
    // 注意：不检查 val<0，因为放电时 current_now 为负值，这是正常现象
    // 传感器读取出错时 val=-1，abs(-1)=1 远低于所有阈值，不影响判断
    int abs_val = abs(val) / BATT_CURRENT_DIVISOR;
    int cA = abs_val / 10000;  // µA → 0.01A（截断后4位，减小后续计算量）
    debug_log(debug_sensor, "batt_current 原始 %d µA → %d (0.01A)", val, cA);
    return cA;
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
        *out_coldOC    = clamp(cold, COLD_MIN, COLD_MAX);
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
        execlp("am", "am", "broadcast", "--user", "0",
               "-a", "com.flydigi.SET_TEMPERATURE",
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
    }
    alarm(0);
    signal(SIGALRM, SIG_DFL);
}

/**
 * 根据电池温差计算动态速率上限
 * @param out_fan_up   风扇升速上限（RPM）
 * @param out_cold_rate 制冷强度变化上限
 */
static void calc_dynamic_rates(int *out_fan_up, int *out_cold_rate) {
    int d = 0;
    if (cycle_batt_temp >= 0) {
        d = abs(cycle_batt_temp - BATT_BASELINE);
    }
    *out_fan_up = RATE_LIMIT_FAN_BASE + d * RATE_LIMIT_FAN_MULT / 10;
    if (*out_fan_up > 2000) *out_fan_up = 2000;
    *out_cold_rate = RATE_LIMIT_COLD;
    if (d > 0) {
        int cold_dyn = d * RATE_LIMIT_COLD_MULT / 10;
        if (cold_dyn > *out_cold_rate) *out_cold_rate = cold_dyn;
    }
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

    // GEAR_AUTO_FAN：用冷端+热端双映射计算风扇转速，挡位表风扇转速变为截断上限
    if (gear_auto_fan && mode == 1) {
        int cap_rpm = windOC;
        int calc_rpm = rpm_from_cold_exp(coldOC);
        if (cooler_hot_temp > 0) {
            calc_rpm = rpm_combine_weighted(rpm_from_hot_end(cooler_hot_temp), calc_rpm);
        }
        windOC = (calc_rpm < cap_rpm) ? calc_rpm : cap_rpm;
    }

    // 风扇转速限速（升降独立速率）
    int desired_rpm = (mode == 0) ? windLevel : windOC;
    if (fan_rpm_change_threshold > 0 && abs(desired_rpm - actual_rpm) <= fan_rpm_change_threshold)
        desired_rpm = actual_rpm;
    int this_fan_up, this_cold_rate;
    calc_dynamic_rates(&this_fan_up, &this_cold_rate);
    rate_limit(&actual_rpm, desired_rpm,
               this_fan_up, RATE_LIMIT_RPM_DOWN);

    // 制冷强度限速
    rate_limit(&actual_cold, coldOC, this_cold_rate, this_cold_rate);

    // 目标温度限速（仅智能温控模式；<0 时 rate_limit 直接初始化）
    if (mode == 0 || actual_target_temp < 0)
        rate_limit(&actual_target_temp, target, RATE_LIMIT_TEMP, RATE_LIMIT_TEMP);

    // ---- 用限速后的 actual_* 值替换查表值 ----
    if (mode == 0)
        windLevel = actual_rpm;
    else
        windOC = actual_rpm;
    coldOC = actual_cold;
    target = actual_target_temp;

    // ---- 向上取整到 50 的倍数 ----
    int send_rpm = ((actual_rpm + 49) / 50) * 50;
    send_rpm = clamp(send_rpm, fan_rpm_min, fan_rpm_max);
    if (mode == 0)
        windLevel = send_rpm;
    else
        windOC = send_rpm;

    // ---- 去重检测 ----
    if (last_bcast_valid &&
        mode      == last_mode &&
        target    == last_target_temp &&
        windOC    == last_rpm &&
        coldOC    == last_cold &&
        windLevel == last_wind_level)
    {
        debug_log(debug_exec, "apply_gear 档位%d 参数无变化，跳过下发", gear_label(level));
        return 0;
    }

    send_am_broadcast(mode, target, windOC, coldOC, windLevel);

    // ---- 更新缓存 ----
    last_bcast_valid   = 1;
    last_mode          = mode;
    last_target_temp   = target;
    last_rpm           = windOC;
    last_cold          = coldOC;
    last_wind_level    = windLevel;

    save_cold(coldOC);

    return 1;
}

// ======================== App 进程 + 心跳检测 ========================

/**
 * 检测 App 是否存活：状态文件 mtime 不超过 STATUS_TIMEOUT 秒
 * 模块每 5 秒写入一次 status 文件，mtime 超时即判进程死
 */
static int is_app_alive(void) {
    struct stat st;
    if (stat(status_file_path, &st) != 0) return 0;
    time_t now = time(NULL);
    int alive = (now - st.st_mtime <= STATUS_TIMEOUT);
    debug_log(debug_conn, "app_alive %d mtime_gap=%lds timeout=%ds", alive, (long)(now - st.st_mtime), STATUS_TIMEOUT);
    return alive;
}

// ======================== 电池温度控制 ========================

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
    int batt = read_battery_temp();
    if (batt < 0) {
        temp_idle_cycles++;  // 传感器偶发失败时递增空闲计数，保证温差归一化正确
        return;
    }

    // --- 紧急退出恢复期：阶段推进（用 emerg_recovery_phase 索引，不依赖具体倍率值）---
    // 阶段推进不受电池温度读取失败影响（已在上方处理），
    // 但推进逻辑需放在首次读取判断之前，确保冷却期中也能正常走完各阶段
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
    int delta = 0;
    if      (ad > eff_z3) delta = 3;
    else if (ad > eff_z2) delta = 2;
    else if (ad > eff_z1) delta = 1;
    delta *= sign;

    debug_log(debug_batt, "batt_ctrl temp=%d (%.1f°C) diff=%d ad=%d sign=%d eff_z=[%d/%d/%d] delta=%d rec_mul=%d",
              batt, batt / 10.0, diff, ad, sign, eff_z1, eff_z2, eff_z3, delta, emerg_recovery_mult);

    int cur_idle = temp_idle_cycles;  // 快照：自上次有效变化以来已过的空闲周期数

    // mtime 检测：sysfs 文件未更新时跳过本周期，仅递增空闲计数
    if (!batt_temp_updated) {
        temp_idle_cycles++;
        debug_log(debug_batt, "batt_ctrl 温度未更新，跳过本周期 (idle=%d)", temp_idle_cycles);
        return;
    }
    temp_idle_cycles = 0;

    int skip_delta = 0;  // =1 时本次不执行常规升降档

    // 冷却递减（放在 abs_change 判断之前，温度不变强制进入时也能递减）
    int in_cooldown = (batt_gear_cooldown > 0);
    if (in_cooldown) {
        batt_gear_cooldown--;
        skip_delta = 1;
        debug_log(debug_batt, "batt_ctrl 冷却中，剩余%d周期", batt_gear_cooldown);
    }
    if (rev_comp_cooldown > 0) rev_comp_cooldown--;

    // --------------- 反补查表（Sheet3 三区×双向×三级阈值） ---------------
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
                    skip_delta = 1;
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
                        skip_delta = 1;
                    }
                }
            } else {
                trend_exempt_count = 0;
            }
        }

        // --- 反补（不为全效豁免时执行） ---
        if (REV_COMP_ENABLED && !skip_delta && (steps > 0 || rev_comp_pending_delta > 0)) {
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
                    skip_delta = 1;
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

// ======================== 紧急干预（CPU+电流双源） ========================

/**
 * 紧急干预—CPU 温度 + 电池电流双源，每 5 秒一次。
 *
 * CPU 温度经 EMA 滤波（α=CPU_FILTER_ALPHA）；电流进入用原始值，退出用 EMA 平滑。
 * 等级 = cpu_level(0~3) + current_level(0~3)，综合上限 4 级。
 * 升档即时响应（进入阈值）；降档逐级滞回（双源均低于恢复阈值才允许）。
 * 等级 → 强制最低档位：EMERG_FORCED_1~4。
 */
static void emergency_intervention(void) {
    // --- 1. CPU 温度读入与滤波 ---
    int cpu_now = read_cpu_temp_max();
    if (cpu_now >= 0) {
        if (first_run) {
            cpu_filtered_temp = cpu_now;
            first_run = 0;
        } else {
            cpu_filtered_temp = EMA_DIR(cpu_now, cpu_filtered_temp, CPU_FILTER_ALPHA);
        }
    }
    int t = cpu_filtered_temp;
    int cpu_valid = (cpu_now >= 0);
    debug_log(debug_emerg, "emerg CPU 原始%d 滤波%d 有效%d", cpu_now, t, cpu_valid);

    // --- 2. 电池电流绝对值 ---
    int cur_ua = read_battery_current_abs();
    int cur_valid = (cur_ua >= 0);

    int prev_level = emergency_level;
    int new_level = emergency_level;

    // --- 3. 计算单源级别（各自 0~3，用进入阈值） ---
    int cpu_lvl = 0;
    if (cpu_valid && EMERG_CPU_ENABLED) {
        if      (t > CPU_EMERG_3) cpu_lvl = 3;
        else if (t > CPU_EMERG_2) cpu_lvl = 2;
        else if (t > CPU_EMERG_1) cpu_lvl = 1;
    }
    int cur_lvl = 0;
    if (cur_valid && EMERG_CURRENT_ENABLED) {
        // 进入时用原始电流值
        if      (cur_ua > CURRENT_EMERG_3) cur_lvl = 3;
        else if (cur_ua > CURRENT_EMERG_2) cur_lvl = 2;
        else if (cur_ua > CURRENT_EMERG_1) cur_lvl = 1;
    }
    debug_log(debug_emerg, "emerg cpu_lvl=%d cur_lvl=%d cur=%d(0.01A) combined=%d prev_level=%d",
              cpu_lvl, cur_lvl, cur_ua, cpu_lvl + cur_lvl > 4 ? 4 : cpu_lvl + cur_lvl, prev_level);

    // --- 4. 综合等级 = cpu_level + current_level（统一升降滞回） ---
    // 升档：combined > 当前等级 → 立即跳升（进入阈值，快速响应）
    // 降档：combined < 当前等级 → 逐级下降（恢复阈值滞回，防振荡）
    // 单源最高 3 级，综合最高 4 级
    int combined = cpu_lvl + cur_lvl;
    if (combined > 4) combined = 4;

    if (combined > emergency_level) {
        // 升档：立即响应
        new_level = combined;
    } else if (combined < emergency_level) {
        // 降档：双源都低于恢复阈值才允许降一级
        // 注意：传感器读取失败时（!cpu_valid 或 !cur_valid）
        //       cpu_ok/cur_ok 默认 0（保守），防止偶发读取失败导致误降级
        int cpu_ok = 0;
        if (cpu_valid) {
            if      (emergency_level >= 3) cpu_ok = (t < CPU_RECOVER_2);
            else if (emergency_level >= 2) cpu_ok = (t < CPU_RECOVER_1);
            else                           cpu_ok = (t < CPU_RECOVER_0);
        }
        int cur_ok = 0;
        if (cur_valid) {
            int cur_exit = curr_emerg_smooth_valid ? curr_emerg_smooth_val : cur_ua;
            if      (emergency_level >= 3) cur_ok = (cur_exit < CURRENT_RECOVER_2);
            else if (emergency_level >= 2) cur_ok = (cur_exit < CURRENT_RECOVER_1);
            else                           cur_ok = (cur_exit < CURRENT_RECOVER_0);
        }
        if (cpu_ok && cur_ok) {
            new_level = emergency_level - 1;  // 逐级下降
            debug_log(debug_emerg, "emerg 降级 %d→%d（cpu_ok=%d cur_ok=%d）",
                      emergency_level, new_level, cpu_ok, cur_ok);
        } else {
            debug_log(debug_emerg, "emerg 保持 %d（cpu_ok=%d cur_ok=%d）",
                      emergency_level, cpu_ok, cur_ok);
        }
    }
    // combined == emergency_level → 保持当前等级

    // --- 5. 电流平滑维护（紧急退出用 EMA） ---
    // 升档时重置平滑（从新值重新累积）；降档不重置，直到完全退出
    if (new_level > prev_level) {
        curr_emerg_smooth_valid = 0;
    }
    if (cur_valid && emergency_level > 0) {
        if (!curr_emerg_smooth_valid) {
            curr_emerg_smooth_val = cur_ua;
            curr_emerg_smooth_valid = 1;
        } else {
            curr_emerg_smooth_val = EMA_DIR(cur_ua, curr_emerg_smooth_val, CURRENT_SMOOTH_ALPHA);
        }
    }

    // --- 6. 等级变化处理与日志 ---
    if (new_level != emergency_level) {
        int delta_e = new_level - emergency_level;
        int cpu_disp = cpu_valid ? cpu_now : t;
        int cur_disp = cur_valid ? cur_ua : 0;
        write_log("紧急%d（%s%d）cpu%d.%d cur%d.%d",
                  new_level,
                  (delta_e >= 0 ? "+" : ""), delta_e,
                  cpu_disp / 10, cpu_disp % 10,
                  cur_disp / 1000000, (cur_disp / 100000) % 10);

        emergency_level = new_level;
        batt_gear_cooldown = BATT_COOLDOWN_CYCLES;
    }

    // --- 7. 根据模式设定强制最低档位 ---
    if (EMERG_MODE_ENTRY == 0) {
        // 模式 0：查表强制最低档
        static const int EMERG_FORCED_TABLE[] = {0, EMERG_FORCED_1, EMERG_FORCED_2, EMERG_FORCED_3, EMERG_FORCED_4};
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
    // 1. 读取带符号电池电流（÷10000 转 0.01A 单位）
    int val = read_sysfs_int(BATT_CURRENT_PATH);
    int ua10 = val / 10000;  // µA → 0.01A（截断后4位）
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

    // 5. 温度偏移管理
    int batt = read_battery_temp();
    if (curr_gear_recommended > 0) {
        // 已激活：每周期根据当前温度差计算偏移（不受冷却期阻挡）
        // 冷却期仅阻止同方向继续累积，但反方向（温度回归方向）始终允许
        if (batt >= 0) {
            int diff = batt - BATT_BASELINE;
            int ad = abs(diff);
            int sign = sign_of(diff);
            int delta = 0;
            if      (ad > BATT_BOUNDARY_3) delta = 3 * sign;
            else if (ad > BATT_BOUNDARY_2) delta = 2 * sign;
            else if (ad > BATT_BOUNDARY_1) delta = 1 * sign;
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
 * 推入温度采样（仅 batt_temp_updated 时调用，使用原始值）
 */
static void pid_var_push(int value) {
    pid_var_buffer[pid_var_head] = value;
    pid_var_head = (pid_var_head + 1) % PID_VAR_BUF_MAX;
    if (pid_var_count < PID_VAR_BUF_MAX)
        pid_var_count++;
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

/**
 * 重置方差门控状态（重连/启动时调用）
 */
static void pid_var_reset(void) {
    pid_var_count = 0;
    pid_var_head = 0;
}

// ======================== PID 控制函数 ========================

/**
 * PID 计算（温度变化时调用一次）
 * @param batt_10  电池温度（0.1°C），已 EMA 滤波
 * @param dt       自上次变化以来的实际秒数（钳位 3~30）
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
    if (pid_ki_var_threshold > 0 && pid_var_count >= 2) {
        int v = pid_var_compute();
        if (v < pid_ki_var_threshold) ki_active = 1;
    }
    if (!ki_active && pid_ki_deadband > 0) {
        float db = pid_ki_deadband / 10.0f;
        if (error > -db && error < db) ki_active = 1;
    }
    if (ki_active) {
        pid_integral_accum += (pid_ki / 1000.0f) * error * dt;
    }
    float i_limit = pid_integral_limit / 1000.0f;
    if (pid_integral_accum >  i_limit) pid_integral_accum =  i_limit;
    if (pid_integral_accum < -i_limit) pid_integral_accum = -i_limit;

    // D 项（首次跳过）
    float d = 0.0f;
    if (pid_prev_error != 0 || pid_last_batt >= 0) {
        d = (pid_kd / 1000.0f) * (error - pid_prev_error) / dt;
    }
    pid_prev_error = error;

    // 钳位 0~1
    float raw = p + pid_integral_accum + d;
    if (raw < 0.0f) raw = 0.0f;
    if (raw > 1.0f) raw = 1.0f;
    return raw;
}

/**
 * 热端温度线性映射 + 双向滞回：无上下限，低于 HOT_MAP_MIN 或高于 HOT_MAP_MAX 时线性外推
 * 最终钳制在下发阶段（apply_gear / apply_gear_direct 内部）
 *
 * 滞回逻辑：
 *   降温（hot_10 < prev_hot）→ 有效温度 = 实际 + 1°C，钳位 ≤ 上次 RPM
 *   升温（hot_10 > prev_hot）→ 正常映射，但 RPM 不低于上次值
 *   温度不变              → 保持上次输出
 */
static int rpm_from_hot_end(int hot_10) {
    static int prev_hot = -1;
    static int prev_rpm = 0;
    int range = hot_map_max - hot_map_min;
    if (range <= 0) return 0;

    // 温度不变 → 保持上次输出
    if (prev_hot >= 0 && hot_10 == prev_hot)
        return prev_rpm;

    int eff_hot;
    if (prev_hot >= 0 && hot_10 < prev_hot) {
        // 降温滞回：有效温度 = 实际 + 1°C（0.1°C*10），使 RPM 滞后下降
        eff_hot = hot_10 + 10;
        if (eff_hot > hot_map_max) eff_hot = hot_map_max;
    } else {
        // 升温或首次 → 直通
        eff_hot = hot_10;
    }

    float t = (float)(eff_hot - hot_map_min) / range;
    int rpm = fan_rpm_min + (int)(t * (fan_rpm_max - fan_rpm_min));

    // 双向钳位
    if (prev_hot >= 0) {
        if (hot_10 < prev_hot && rpm > prev_rpm) rpm = prev_rpm;  // 降温 ≥ 上次（滞回 +10 不超限）
        if (hot_10 > prev_hot && rpm < prev_rpm) rpm = prev_rpm;  // 升温 ≥ 上次（防止微降反降 RPM）
    }

    prev_hot = hot_10;
    prev_rpm = rpm;
    return rpm;
}

/**
 * 冷强度指数映射：n^exp，无上下限
 * cold < cold_map_start 时线性外推下限（powf 负数底数→NaN）
 * 最终钳制在下发阶段（apply_gear / apply_gear_direct 内部）
 */
static int rpm_from_cold_exp(int cold) {
    int range = pid_cold_max - cold_map_start;
    if (range <= 0) return 0;
    float n = (float)(cold - cold_map_start) / range;
    if (n < 0.0f)
        return fan_rpm_min + (int)(n * (fan_rpm_max - fan_rpm_min));
    float n_exp = powf(n, cold_map_exp / 100.0f);
    return fan_rpm_min + (int)(n_exp * (fan_rpm_max - fan_rpm_min));
}

/**
 * 自加权合并：各以自身 RPM 为权重
 * 热端无数据（cooler_hot_temp<=0）时退化为纯 exp
 * 权重值钳制到 [fan_rpm_min, fan_rpm_max]，避免某方值极小时权重接近无效；
 * 输入值（实际转速）保持不变，仅影响权重占比
 */
static int rpm_combine_weighted(int rpm_hot, int rpm_cold) {
    if (rpm_hot <= 0) return rpm_cold;
    int w_hot = clamp(rpm_hot, fan_rpm_min, fan_rpm_max);
    int w_cold = clamp(rpm_cold, fan_rpm_min, fan_rpm_max);
    int sum = w_hot + w_cold;
    if (sum <= 0) return fan_rpm_min;
    return (w_hot * rpm_hot + w_cold * rpm_cold) / sum;
}

/**
 * PID 输出 → 制冷强度 + 风扇转速（双路合并）
 */
static void pid_map_output(float output, int *out_cold, int *out_rpm) {
    int range = pid_cold_max - pid_cold_min;
    if (range <= 0) range = 1;
    int cold = clamp(pid_cold_min + (int)(output * range), pid_cold_min, pid_cold_max);

    int rpm = rpm_from_cold_exp(cold);
    if (cooler_hot_temp > 0) {
        int rpm_hot = rpm_from_hot_end(cooler_hot_temp);
        rpm = rpm_combine_weighted(rpm_hot, rpm);
    }

    *out_cold = cold;
    *out_rpm  = rpm;
}

/**
 * 直接下发 AT 广播（PID / 直接冷端模式使用）
 * 与 apply_gear 共享 last_* 去重缓存
 */
static void apply_gear_direct(int mode, int target,
                               int rpm, int cold, int wl) {
    int this_fan_up, this_cold_rate;
    calc_dynamic_rates(&this_fan_up, &this_cold_rate);

    // 制冷强度限速
    rate_limit(&actual_cold, cold, this_cold_rate, this_cold_rate);

    // 风扇转速限速（升降独立速率）
    if (fan_rpm_change_threshold > 0 && abs(rpm - actual_rpm) <= fan_rpm_change_threshold)
        rpm = actual_rpm;
    rate_limit(&actual_rpm, rpm, this_fan_up, RATE_LIMIT_RPM_DOWN);

    // ---- 向上取整到 50 的倍数 ----
    int send_rpm = ((actual_rpm + 49) / 50) * 50;
    send_rpm = clamp(send_rpm, fan_rpm_min, fan_rpm_max);

    // ---- 去重检测（用限速后的 actual_* 值）----
    if (last_bcast_valid &&
        mode == last_mode && send_rpm == last_rpm &&
        actual_cold == last_cold && wl == last_wind_level)
        return;

    // 偏差 = (滤波后电池温度 + 补偿) - 目标温度，取自上一周期 PID 计算的结果
    int batt_10 = (pid_batt_filtered >= 0) ? pid_batt_filtered : BATT_BASELINE;
    int dev_10 = batt_10 + pid_last_comp_10 - BATT_BASELINE;
    int hot_deg = (cooler_hot_temp > 0) ? cooler_hot_temp / 10 : 0;
    write_log("%d%+.1f° 冷%d 热%d° RPM%d",
              BATT_BASELINE / 10, dev_10 / 10.0f,
              actual_cold, hot_deg, send_rpm);
    send_am_broadcast(mode, target, send_rpm, actual_cold, wl);

    last_bcast_valid   = 1;
    last_mode          = mode;
    last_target_temp   = target;
    last_rpm           = send_rpm;
    last_cold          = actual_cold;
    last_wind_level    = wl;

    save_cold(actual_cold);
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
    pid_curr_comp_smooth = 0.0f;
    pid_last_comp_10 = 0;
    pid_var_reset();
}

/**
 * CTRL_MODE 0→1 热切换时对齐 PID 初始值
 * 从当前 gear 状态映射到 PID 输出空间
 */
static void pid_align_from_gear(void) {
    float ratio = (float)(batt_gear_base - gear_min) /
                  (gear_max - gear_min);
    pid_align_rpm  = fan_rpm_min + (int)(ratio * (fan_rpm_max - fan_rpm_min));
    pid_align_cold = pid_cold_min + (int)(ratio * (pid_cold_max - pid_cold_min));
    pid_reset_core();
    last_bcast_valid     = 0;
    write_log("PID 从 gear 对齐 ratio=%.2f cold=%d", ratio, pid_align_cold);
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

/**
 * 重连安全对齐：将三个实际值都调到匹配挡位的值，
 * 后续由 rate_limited_execute 按正常速率向目标挡位变化，
 * 不在此处立即下发，防止部分执行后参数组合不协调
 */
static void reconnect_align(void) {
    // PID 模式：重置 PID 状态，actual 值由 rate_limited_execute 重新初始化
    if (ctrl_mode == 1) {
        pid_reset_core();
        pid_filter_interval_smooth = -1;
        pid_filter_auto_off = 0;
        temp_idle_cycles = 0;
        actual_rpm = -1;
        actual_cold = -1;
        actual_target_temp = -1;
        write_log("重连 PID 状态已重置");
        last_batt_reading = -1;
        first_run = 1;
        return;
    }

    // --- gear 模式：保留现有逻辑 ---
    debug_log(debug_conn, "reconnect_align actual_rpm=%d actual_cold=%d", actual_rpm, actual_cold);
    if (actual_rpm >= 0 && actual_cold >= 0) {
        int idx = match_nearest_gear_for_reconnect();
        debug_log(debug_conn, "reconnect_align match idx=%d final_gear=%d", idx, final_gear);
        if (idx >= 0) {
            actual_rpm = gear_table[idx].fan_rpm;
            actual_cold = gear_table[idx].cold;
            actual_target_temp = gear_table[idx].target;
            write_log("重连 匹配档位%d 风扇%dRPM 制冷%d",
                      gear_label(idx + 1), actual_rpm, actual_cold);
        }
    } else {
        actual_rpm = -1;
        actual_cold = -1;
        actual_target_temp = -1;
    }

    last_batt_reading = -1;
    first_run = 1;
    // 不下发，等下轮 rate_limited_execute 从匹配挡位自然过渡
}

/** 记录上一轮紧急等级，退出紧急时用作档位上限 */
static int prev_emerg_level = 0;

/**
 * 按当前模式分发执行（限速统一下沉到 apply_gear / apply_gear_direct 内部）
 * PID 模式：传 pid_align_* → apply_gear_direct 内部限速
 * Gear 模式：apply_gear 内部限速
 */
static void rate_limited_execute(void) {
    // --- PID 模式 ---
    if (ctrl_mode == 1) {
        // 限速已内建到 apply_gear_direct，此处只管传目标值
        apply_gear_direct(1, 5, pid_align_rpm, pid_align_cold, 0);
        return;
    }

    // --- Gear 模式：限速已内建到 apply_gear ---
    apply_gear(final_gear);
}

/**
 * 单次控制循环（纯计算，不下发）
 * 配置重载 → 紧急干预（CPU+电流综合等级）→ 电池控制 → 保存目标档位
 * 调用者在外部立即执行速率限制下发，本函数只做决策
 */
static void main_loop(void) {
    // 0. 检查配置文件是否更新（热重载）
    debug_log(debug_main, "main_loop 开始 emergency=%d forced_min=%d battery_fan=%d target=%d",
              emergency_level, emerg_forced_gear, batt_gear_base, final_gear);
    if (config_path[0] != '\0') {
        struct stat st;
        if (stat(config_path, &st) == 0) {
            if (st.st_mtime != config_mtime) {
                load_config(config_path);
                config_mtime = st.st_mtime;
                write_log("配置 热重载\n");
            }
        }
    }

    // --- PID 模式：跳过档位/紧急逻辑，直接 PID 计算 ---
    if (ctrl_mode == 1) {
        time_t now = time(NULL);
        int batt_raw = read_battery_temp();
        if (batt_raw < 0) return;

        // --- 温度更新周期跟踪（基于周期数，非时间） ---
        if (batt_temp_updated) {
            // 推入方差采样（使用原始电池温度，非滤波值）
            pid_var_push(batt_raw);
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
            temp_idle_cycles = 0;
        } else {
            temp_idle_cycles++;
        }

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
        int filter_eff = filter_cfg_on && !pid_filter_auto_off;

        // --- 根据有效滤波状态分支 ---
        if (filter_eff) {
            // 滤波模式：EMA 滤波 + 方向取整（增大→向上取整，减小→向下取整）
            if (pid_batt_filtered < 0) {
                pid_batt_filtered = batt_raw;
            } else {
                int old_f = pid_batt_filtered;
                int numer = batt_raw * pid_batt_alpha + pid_batt_filtered * (100 - pid_batt_alpha);
                int new_val = numer / 100;
                if (batt_raw > old_f && numer % 100 > 0) {
                    new_val++;  // 向原始值方向取整（反向自然截断，无需处理）
                }
                pid_batt_filtered = new_val;
            }
        } else {
            // 无滤波模式：原始值直通，温度未更新则跳过本周期
            pid_batt_filtered = batt_raw;
            if (!batt_temp_updated && pid_last_batt >= 0) {
                debug_log(debug_pid, "PID 跳过（温度未更新）");
                return;
            }
        }

        // --- CPU 温度读入与滤波（用于补偿，两模式共享） ---
        int cpu_now = read_cpu_temp_max();
        if (cpu_now >= 0) {
            if (first_run) {
                cpu_filtered_temp = cpu_now;
                first_run = 0;
            } else {
                cpu_filtered_temp = EMA_DIR(cpu_now, cpu_filtered_temp, CPU_FILTER_ALPHA);
            }
        }

        // --- 补偿值计算（两模式共享） ---
        float cpu_comp = 0.0f, curr_comp = 0.0f;

        if (pid_cpu_comp_enabled && cpu_filtered_temp >= 0) {
            float raw = (float)(cpu_filtered_temp - batt_raw) / (pid_cpu_comp_divisor * 10);
            if (raw < 0.0f) raw = 0.0f;
            if (pid_last_batt < 0)
                pid_cpu_comp_smooth = raw;
            else
                pid_cpu_comp_smooth = (CPU_FILTER_ALPHA * raw +
                                      (100 - CPU_FILTER_ALPHA) * pid_cpu_comp_smooth) / 100.0f;
            cpu_comp = pid_cpu_comp_smooth;
        }

        if (pid_curr_comp_enabled) {
            int curr_cA = read_battery_current_abs();
            if (curr_cA >= pid_curr_comp_threshold) {
                float raw = (float)curr_cA / (pid_curr_comp_divisor * 100);
                if (pid_last_batt < 0)
                    pid_curr_comp_smooth = raw;
                else
                    pid_curr_comp_smooth = (CURRENT_GEAR_SMOOTH_ALPHA * raw +
                                           (100 - CURRENT_GEAR_SMOOTH_ALPHA) * pid_curr_comp_smooth) / 100.0f;
                curr_comp = pid_curr_comp_smooth;
            }
        }

        float total_comp = cpu_comp + curr_comp;
        int total_comp_10 = (int)(total_comp * 10 + 0.5f);

        // --- PID 重算判定 ---
        // 滤波模式：每周期都重算 | 无滤波模式：温度或补偿变化时才重算
        int should_recompute = filter_eff ||
                               (batt_raw != pid_last_batt || total_comp_10 != pid_last_comp_10);

        if (should_recompute) {
            float dt = (float)(now - pid_last_change_time);
            if (dt > 30.0f) dt = 30.0f;
            if (dt < 3.0f)  dt = 3.0f;

            int pid_input = (filter_eff ? pid_batt_filtered : batt_raw);
            int compensated_10 = pid_input + total_comp_10;
            float pid_out = pid_compute(compensated_10, dt);

            // 直接映射到物理值（无输出平滑）
            pid_map_output(pid_out, &pid_align_cold, &pid_align_rpm);

            pid_log("epoch=%ld Tbatt=%d+comp%+.1f(cpu%+.1f+curr%+.1f)=Tinp%d Ttgt=%d Thot=%d dt=%.0fs e=%.2f out=%.2f var=%d",
                     now, pid_input, total_comp, cpu_comp, curr_comp,
                     compensated_10, BATT_BASELINE, cooler_hot_temp,
                     dt, (compensated_10 - BATT_BASELINE) / 10.0f,
                     pid_out, pid_var_count >= 2 ? pid_var_compute() : -1);

            pid_last_batt = batt_raw;
            pid_last_comp_10 = total_comp_10;
            pid_last_change_time = now;
        }

        return;  // PID 模式不执行后续档位逻辑
    }

    // --- Gear 模式逻辑 ---
    // 1. 紧急干预（CPU 温度 + 电池电流，更新 emergency_level）
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
        int batt_temp = read_battery_temp();
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
        }
        // exit_mode == 0 → 电池温度过高，不退出紧急，保持当前档位
        // 恢复期已在步骤 1 提前启动，此处不再重复
    }
}

// ======================== 重连安全对齐 ========================

/**
 * 断联重连时：用实际值（制冷强度/目标温度）匹配最接近的档位，
 * 将风扇转速对齐到该档位，防止断联前部分执行导致参数组合不协调。
 *
 * 例如：风扇转速很低但制冷强度很高（危险），或风扇很高但制冷很弱（噪音）。
 * 匹配后风扇从安全值开始，再经 rate_limited_execute 向目标档位变化。
 *
 * 返回档位索引（0-based），失败返回 -1。
 */
static int match_nearest_gear_for_reconnect(void) {
    if (gear_count == 0) return -1;

    // 防御：final_gear 越界时回退到 gear_min
    int safe_level = final_gear;
    if (safe_level < gear_min || safe_level > gear_max)
        safe_level = gear_min;

    // 用目标档位的模式决定匹配依据
    int mode = gear_table[safe_level - 1].mode;
    int ref_val = (mode == 0) ? actual_target_temp : actual_cold;

    int best_idx = 0;
    int best_dist = INT_MAX;
    for (int i = 0; i < gear_count; i++) {
        int tbl = (gear_table[i].mode == 0) ? gear_table[i].target : gear_table[i].cold;
        int dist = abs(tbl - ref_val);
        if (dist < best_dist) {
            best_dist = dist;
            best_idx = i;
        }
    }
    return best_idx;
}

// ======================== 程序入口 ========================

int main(int argc, char *argv[]) {
    signal(SIGTERM, handle_signal);
    signal(SIGINT,  handle_signal);
    debug_log(debug_main, "main 启动 ALPHA=%d ZONE=%d~%d", CPU_FILTER_ALPHA, CPU_ZONE_MIN, CPU_ZONE_MAX);

    // --- 初始化默认档位表（load_config 中 GEAR_N 可覆盖） ---
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

    // --- 状态文件 + 档位存档初始化 ---
    set_default_status_path();
    create_status_file();
    set_gear_file_path();

    // --- Gear 模式初始化（与 cooler 状态无关，在 BLE 就绪前完成） ---
    if (ctrl_mode != 1) {
        int stored_cold = load_cold();
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
            write_log("存档 制冷强度%d→挡位%d", stored_cold, nearest);
        } else {
            batt_gear_base = LEVEL_INIT;
        }
        batt_gear_cooldown = 0;
        final_gear = batt_gear_base;
    }

    write_log("脚本启动成功");

    // --- 等待模块就绪 + BLE 连接 ---
    // status 文件由模块在 Application.onCreate 中写入 "BLE=0/1\n"，
    // 有内容即代表模块已启动，读到 BLE=1 表示蓝牙已连
    while (running) {
        int ready = 0;
        FILE *f = fopen(status_file_path, "r");
        if (f) {
            char line[16];
            if (fgets(line, sizeof(line), f) && strncmp(line, "BLE=1", 5) == 0)
                ready = 1;
            fclose(f);
        }
        if (ready) {
            read_status_ble();
            break;
        }
        sleep(5);
    }
    if (!running) goto exit;

    // --- PID 模式初始化（需要 cooler 状态回传，放在 BLE 就绪后） ---
    // 优先读取历史存档，其次读取 LSP 模块回传的实际制冷强度，最后回退到 gear 对齐
    if (ctrl_mode == 1) {
        float pid_ratio = 0.0f;

        int stored_cold = load_cold();
        if (stored_cold >= 1) {
            pid_ratio = (float)(stored_cold - pid_cold_min) /
                        (pid_cold_max - pid_cold_min);
            if (pid_ratio < 0.0f) pid_ratio = 0.0f;
            if (pid_ratio > 1.0f) pid_ratio = 1.0f;
            pid_align_cold = stored_cold;
            pid_align_rpm  = fan_rpm_min + (int)(pid_ratio * (fan_rpm_max - fan_rpm_min));
            write_log("存档 恢复制冷=%d ratio=%.2f rpm=%d",
                      stored_cold, pid_ratio,
                      fan_rpm_min + (int)(pid_ratio * (fan_rpm_max - fan_rpm_min)));
        } else if (cooler_cold_real >= pid_cold_min) {
            pid_ratio = (float)(cooler_cold_real - pid_cold_min) /
                        (pid_cold_max - pid_cold_min);
            if (pid_ratio < 0.0f) pid_ratio = 0.0f;
            if (pid_ratio > 1.0f) pid_ratio = 1.0f;
            pid_align_cold = cooler_cold_real;
            pid_align_rpm  = fan_rpm_min + (int)(pid_ratio * (fan_rpm_max - fan_rpm_min));
            write_log("LSP 回传承载 制冷=%d ratio=%.2f rpm=%d",
                      cooler_cold_real, pid_ratio,
                      fan_rpm_min + (int)(pid_ratio * (fan_rpm_max - fan_rpm_min)));
        } else {
            pid_align_from_gear();
            goto pid_init_done;
        }

        pid_reset_core();
        batt_gear_base   = (int)(pid_ratio * (gear_max - gear_min) + gear_min + 0.5f);
        if (batt_gear_base < gear_min) batt_gear_base = gear_min;
        if (batt_gear_base > gear_max) batt_gear_base = gear_max;

pid_init_done:
        batt_gear_cooldown = 0;
        final_gear = batt_gear_base;
    }

    // --- 进入工作模式 ---
    app_was_alive = 1;
    batt_gear_cooldown = 0;
    emergency_level = 0;
    emerg_forced_gear = 0;
    first_run = 1;
    last_batt_reading = -1;     // 重置电池温度跟踪，使首次 battery_control 视作新读数

    // 强制首次下发（PID 模式使用 apply_gear_direct 避免走 Gear 表）
    last_bcast_valid = 0;
    if (ctrl_mode == 1) {
        apply_gear_direct(1, 5, pid_align_rpm, pid_align_cold, 0);
    } else {
        apply_gear(batt_gear_base);
    }

    // ---- 主控制循环：每 5 秒一次 ----
    // 循环开头先检测连接状态，断联时不执行 main_loop
    while (running) {
        read_status_ble();
        int app_proc_ok = is_app_alive();
        int fully_connected = app_proc_ok && app_ble_connected;
        debug_log(debug_conn, "main 连接状态 app_alive=%d ble=%d fully=%d", app_proc_ok, app_ble_connected, fully_connected);

        if (!fully_connected) {
            if (app_was_alive) {
                app_was_alive = 0;
                if (!app_proc_ok) {
                    write_log("App 不存在，等待连接...\n");
                } else {
                    write_log("BLE 已断开，等待连接...\n");
                }

                // 散热器已断联，丢弃未执行的变化量
                // 实际值保持断联前最后记录的数值，不再继续变化
            }

            // 等待完全恢复的循环（进程+BLE 都就绪）
            while (running) {
                sleep(5);
                read_status_ble();
                if (is_app_alive() && app_ble_connected) {
                    app_was_alive = 1;
                    last_bcast_valid = 0;
                    reconnect_align();
                    break;
                }
            }
            continue;   // 跳过本轮 main_loop，下一轮再开始控制
        } else if (!app_was_alive) {
            app_was_alive = 1;
            last_bcast_valid = 0;
            reconnect_align();
        }

        main_loop();

        // ★ 速率限制执行（替代逐档变动 + RPM 平滑跟踪）
        // 每周期电池温差 → 动态计算风扇/制冷速率上限（0.1°C 精度）
        // 风扇升速 = FAN_BASE + d × FAN_MULT / 10，降速 = RATE_LIMIT_RPM_DOWN
        // 制冷强度 = max(RATE_LIMIT_COLD, d × COLD_MULT / 10)
        cycle_batt_temp = read_battery_temp();
        rate_limited_execute();

        // 逐秒睡眠（可被信号中断）
        for (int i = 0; i < 5 && running; i++) {
            sleep(1);
        }
    }

exit:
    if (log_fp) fclose(log_fp);
    return 0;
}
