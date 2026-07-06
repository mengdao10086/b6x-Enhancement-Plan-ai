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
#include <math.h>

// --- 通用宏 ---
#define EMA(new_val, old_val, alpha_pct) \
    (((new_val) * (alpha_pct) + (old_val) * (100 - (alpha_pct))) / 100)

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
static int level_min = 1;
static int level_max = 12;     // 默认 12 档（由 init_gear_table 设定）

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
    level_min = 1;
    level_max = 12;
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

static int cmp_gear_config_n(const void *a, const void *b) {
    return ((const GearConfigTemp*)a)->config_n - ((const GearConfigTemp*)b)->config_n;
}

/** 获取运行时档位的配置编号（日志显示用，空洞时显示原始编号） */
static inline int gear_label(int level) {
    if (level < 1 || level > gear_count) return level;
    int label = gear_table[level - 1].config_n;
    return (label > 0) ? label : level;
}

// --- 制冷片强度范围 ---
#define COLD_MIN             1
#define COLD_MAX           194     // 最大有效值（更高需超频模式，本场景不用）

// --- 电池温度控制（0.1°C）—— 可由 profile.conf 覆盖 ---
static int BATT_BASELINE = 350;     // 基准温度 35.0°C
static int BATT_ZONE_1   = 5;       // ±0.5°C → 不变（死区）
static int BATT_ZONE_2   = 13;      // ±1.3°C → ±1 档
static int BATT_ZONE_3   = 25;      // ±2.5°C → ±2 档（超过→±3档）

// --- CPU 温度扫描范围（可配置）---
// 首次运行在此范围内扫描有效的 thermal_zone，后续只扫命中的 zone
static int CPU_ZONE_MIN = 0;
static int CPU_ZONE_MAX = 99;

// --- CPU 紧急干预阈值（0.1°C）—— 可由 profile.conf 覆盖 ---
static int CPU_EMERG_3   = 850;     // >85.0°C → 等级 3
static int CPU_EMERG_2   = 750;     // >75.0°C → 等级 2
static int CPU_EMERG_1   = 650;     // >65.0°C → 等级 1
static int CPU_RECOVER_0 = 550;     // <55.0°C → 清除紧急
static int CPU_RECOVER_1 = 650;     // <65.0°C 且 ≥2 级时降为 1
static int CPU_RECOVER_2 = 750;     // <75.0°C 且 ≥3 级时降为 2

// --- 紧急强制最低档位 —— 可由 profile.conf 覆盖 ---
static int EMERG_FORCED_1 = 6;   // 等级 1 强制最低档位（固定功率 3050RPM/75）
static int EMERG_FORCED_2 = 8;   // 等级 2 强制最低档位（固定功率 4000RPM/125）
static int EMERG_FORCED_3 = 10;  // 等级 3 强制最低档位（固定功率 5000RPM/165）
static int EMERG_FORCED_4 = 12;  // 等级 4 强制最低档位（固定功率 6000RPM/190 峰值）

// --- 紧急退出钳制偏移（退出时高一级强制档位 + 此偏移作为档位上限）---
static int EMERG_EXIT_CAP_OFFSET = 1;

// --- 紧急干预模式（可由 profile.conf 覆盖）---
// EMERG_MODE_ENTRY: 0=提高最低档(EMERG_FORCED_N), 1=升档(EMERG_STEP*level)
// EMERG_MODE_EXIT:  0=钳制最高档(EMERG_EXIT_CAP_OFFSET), 1=降档(EMERG_STEP*drop)
static int EMERG_MODE_ENTRY = 0;
static int EMERG_MODE_EXIT  = 1;
static int EMERG_STEP = 2;

// --- 紧急退出电池温度阈值（0.1°C）---
// 电池温度低于基准+此值时允许正常退出紧急干预
// 低于基准+此值*2时允许以一半效果退出（档位数/钳制量减半）
static int EMERG_EXIT_BATT_THRESHOLD = 20;  // 默认2.0°C

// --- CPU 滤波系数（百分比，0~100，默认 25=α=0.25）---
static int CPU_FILTER_ALPHA = 25;

// --- 趋势豁免（温度锚点复位机制）---
// 首次豁免记录当前电池温度，以此 - 当前豁免区间中值为复位阈值，
// 温度低于该值后复位豁免计数器，下轮重新开始
static int OVERRIDE_MAX = 6;            // 保留配置项（当前未作主动限制，仅作安全兜底）
static int override_anchor_temp = -1;   // 趋势豁免锚点温度（首次豁免时记录）

// --- 反补查表三级阈值（0.1°C，可由 profile.conf 覆盖）---
// 对应 battery_control 中 t1/t2/t3 三个台阶，不同方向+区域组合下有不同的生效方式：
//   升温：冷外 t1 / 内 t1/t2 / 热 t1/t2/t3
//   降温：冷 t1/t2/t3 / 内 t1/t2 / 热 t1
// 默认值 2/3/4 = 0.2°C / 0.3°C / 0.4°C 每周期
static int REV_COMP_T1 = 2;
static int REV_COMP_T2 = 3;
static int REV_COMP_T3 = 4;

// --- 反补冷却周期数（可配置）---
// 每次反补生效后冻结 N 个周期，期内不执行反补调整
static int REV_COMP_COOLDOWN = 1;

// --- 电池调档冷却周期数（可配置）---
// 每次电池温度导致的档位变动后冻结多少周期（×5s），期内跳过常规升降档
static int BATT_COOLDOWN_CYCLES = 3;

// --- 温度不变最大跳过次数（可配置）---
// 电池温度连续不变时最多跳过多少次 battery_control，之后强制进入
static int BATT_SKIP_MAX = 6;

// --- 状态文件超时（秒，可配置）---
static int STATUS_TIMEOUT = 11;

// --- sysfs 路径配置（可由 profile.conf 覆盖）---
static char BATT_TEMP_PATH[128] = "/sys/class/power_supply/battery/temp";
static char CPU_TEMP_PATH_FMT[128] = "/sys/class/thermal/thermal_zone%d/temp";
static char BATT_CURRENT_PATH[128] = "/sys/class/power_supply/battery/current_now";

// --- sysfs 缩放系数（原始值 ÷ 缩放系数 = 内部单位 0.1°C / µA）---
static int BATT_TEMP_DIVISOR = 1;     // 电池温度原始值 0.1°C，无需缩放
static int CPU_TEMP_DIVISOR = 100;    // CPU 温度原始值 m°C，÷100 转 0.1°C
static int BATT_CURRENT_DIVISOR = 1;  // 电池电流原始值 µA，无需缩放

// --- 电池电流紧急干预阈值（µA，可配置）---
// 通过 /sys/class/power_supply/battery/current_now 读取，取绝对值
static int CURRENT_EMERG_3 = 700;   // >7A → 等级 3
static int CURRENT_EMERG_2 = 600;   // >6A → 等级 2
static int CURRENT_EMERG_1 = 500;   // >5A → 等级 1
static int CURRENT_RECOVER_2 = 600; // <6A → 从 3 降为 2
static int CURRENT_RECOVER_1 = 500; // <5A → 从 2 降为 1
static int CURRENT_RECOVER_0 = 400; // <4A → 退出紧急

// --- 电流紧急退出平滑系数（百分比，可配置）---
// 进入紧急时电流用原始值不平滑；退出时使用 EMA 平滑值
// 升档（紧急等级提高）时重置平滑，从当前值重新累积
static int CURRENT_SMOOTH_ALPHA = 25;   // 默认 α=0.25

// --- 速率限制（每 5 秒周期最大变化量，可配置）---
// 风扇转速限制（两种模式通用）
static int RATE_LIMIT_RPM_UP = 250;
static int RATE_LIMIT_RPM_DOWN = 250;
// 制冷片强度限制（固定功率模式时生效）
static int RATE_LIMIT_COLD = 20;
// 目标温度限制（智能温控模式时生效）
static int RATE_LIMIT_TEMP = 2;

// --- 当前实际值（-1=未初始化）---
// 始终向目标档位的表格值靠拢，每周期最多变动速率限制的量
// 溢出部分自然累积到下周期；目标档位变化时自动从当前值计算新差值
static int actual_rpm = -1;            // 当前实际风扇转速（RPM）
static int actual_cold = -1;           // 当前实际制冷片强度
static int actual_target_temp = -1;    // 当前实际目标温度（°C）


// --- 日志路径（默认根据二进制名自动生成，可由 profile.conf 覆盖）---
static char log_file_path[256] = "";
static int LOG_MAX_KB = 7;          // 日志文件大小上限（KB），0=关闭日志
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

// ======================== 独立开关（可由 profile.conf 覆盖）===================
static int EMERG_CURRENT_ENABLED = 0;   // 电流紧急独立开关，默认关闭（让位于电流-挡位映射）
static int EMERG_CPU_ENABLED     = 1;   // CPU 温度紧急独立开关
static int REV_COMP_ENABLED      = 1;   // 反补独立开关
static int TREND_EXEMPT_ENABLED  = 1;   // 趋势豁免独立开关

// ======================== 电流-挡位映射 + 温度融合模式 =======================
// 电流为推荐挡位基础，温度累积偏移调整，带冷却期和偏移继承
static int CURRENT_GEAR_MODE_CHARGE    = 1;    // 充电(负电流)：0=普通模式, 1=电流-挡位模式
static int CURRENT_GEAR_MODE_DISCHARGE = 1;    // 放电(正电流)：0=普通模式, 1=电流-挡位模式
static int CURRENT_GEAR_MULT_CHARGE    = 2;    // 充电倍率：abs(电流µA) × 倍率 ÷ 1000000 → 推荐档位
static int CURRENT_GEAR_MULT_DISCHARGE = 6;    // 放电倍率：电流µA × 倍率 ÷ 1000000 → 推荐档位
static int CURRENT_GEAR_SMOOTH_ALPHA   = 25;   // 电流平滑系数（百分比，1~100），默认 α=0.25
static int CURRENT_GEAR_MIN            = 6;    // 推荐档位低于此值回退基准模式
// 电流-挡位平滑状态
static int curr_gear_smooth_val   = 0;         // 电流平滑值（µA）
static int curr_gear_smooth_valid = 0;         // 平滑值是否已初始化
// 电流-挡位融合模式状态（推荐挡位跟踪 + 温度偏移继承）
static int curr_gear_rec           = 0;         // 上一次的电流推荐挡位
static int curr_gear_temp_offset   = 0;         // 温度累积偏移量（无上限，由 level_min/max 钳位）
static int curr_gear_temp_cooldown = 0;         // 温度偏移冷却剩余周期

// ======================== 配置文件系统 ========================

// 配置文件路径（自动检测或 --config 指定）
static char config_path[256] = "";
// 配置文件的最后修改时间（用于热重载检测）
static time_t config_mtime = 0;

// ======================== 全局状态 ========================

static int battery_fan_level = 0;      // 电池控制决定的基础档位（逻辑基准值，非实际档位）
static int emergency_level = 0;        // 紧急等级 0~3
static int forced_min_level = 0;       // 紧急强制最低档位
static int cpu_weighted = 250;         // 加权 CPU 温度，初始 25.0°C
static int batt_cooldown = 0;          // 电池调档冷却剩余周期
static int rev_comp_cooldown = 0;      // 反补冷却剩余周期
static int batt_idle_cycles = 0;       // 自上次有效变化以来温度未变的周期数
static int rev_comp_pending_abs = 0;   // 反补冷却期累积温差
static int rev_comp_pending_idle = 0;  // 反补冷却期累积空闲周期
static int last_batt_reading = -1;     // 上次读取的电池温度（变化检测 + 趋势判断）
static int batt_unchanged_count = 0;   // 温度连续不变跳过次数（≥BATT_SKIP_MAX 时强制进入）
static int trend_override = 0;         // 趋势豁免计数器（锚点温度复位机制使用）
static int first_run = 1;              // 首次运行，滤波直接赋初值

// --- 紧急退出恢复期状态 ---
static int batt_recovery_multiplier = 1;  // 电池阈值恢复倍率（1=正常）
static int batt_recovery_cycles = 0;      // 当前恢复阶段剩余周期数
static int recovery_step = 0;             // 恢复期阶段（0=关闭, 1=P1, 2=P2, 3=P3）

// 恢复期配置（可由 profile.conf 覆盖）
static int BATT_RECOVERY_M1 = 6;             // P1 阈值倍率
static int BATT_RECOVERY_M2 = 4;             // P2 阈值倍率
static int BATT_RECOVERY_M3 = 2;             // P3 阈值倍率
static int BATT_RECOVERY_PHASE_CYCLES = 6;   // 每阶段周期数

static volatile int running = 1;       // 信号控制标记

// --- 执行状态 ---
static int target_level = LEVEL_INIT;   // 逻辑计算的目标档位（执行向此靠拢）

// --- 发送去重缓存 ---
// 记录上次发送的完整参数，避免重复下发
static int last_sent_valid = 0;
static int last_mode = -1;
static int last_target_temp = -1;
static int last_windOC = -1;
static int last_coldOC = -1;
static int last_windLevel = -1;

// --- App 进程检测 ---
static int app_was_alive = 0;

// --- 状态文件检测（模块心跳 + BLE 状态）---
// 模块每 5 秒写入一次 status 文件，daemon 通过 mtime 判断进程是否活着
// 同时读取 BLE=0/1 获知 BLE 连接状态
static char status_file_path[512] = "";
static char gear_file_path[512] = "";
static int app_ble_connected = 0;

// --- 电流平滑状态（紧急退出用 EMA）---
static int curr_smooth_val = 0;       // 平滑后的电流值（µA）
static int curr_smooth_valid = 0;     // 平滑数据是否有效

// --- PID 控制模式全局变量 ---
static int ctrl_mode = 0;                 // CTRL_MODE: 0=gear, 1=PID

// PID 参数
static int pid_kp = 300;                  // PID_KP（÷1000，1°C→P=40%）
static int pid_ki = 50;                   // PID_KI（÷1000，±1°C内累积）
static int pid_kd = 150;                  // PID_KD
static int pid_integral_limit = 500;      // PID_INTEGRAL_LIMIT（÷1000）
static int pid_batt_alpha = 33;           // PID_BATT_ALPHA（%，新值权重）
static int pid_output_alpha = 33;         // PID_OUTPUT_ALPHA（%，新值权重）
static int pid_cold_min = 1;              // PID_COLD_MIN
static int pid_cold_max = 190;            // PID_COLD_MAX
static int pid_cold_exp = 150;            // PID_COLD_EXP（÷100）
static int pid_rpm_min = 2000;            // PID_RPM_MIN
static int pid_rpm_max = 6000;            // PID_RPM_MAX
static int pid_hot_map_min = 350;         // PID_HOT_MAP_MIN（0.1°C）
static int pid_hot_map_max = 450;         // PID_HOT_MAP_MAX（0.1°C）

// PID 运行状态
static int pid_integral = 0;              // 积分累积值
static int pid_prev_error = 0;            // 上周期误差（0.1°C）
static int pid_batt_filtered = -1;        // EMA 滤波后电池温度
static int pid_last_batt = -1;            // 上次参与 PID 计算的原始温度
static time_t pid_last_change_time = 0;   // 上次温度变化时间戳
static float pid_output_smoothed = 0.0f;  // 输出平滑值

// PID 输入补偿（加到电池温度，反映 CPU/电流额外发热）
static int pid_cpu_comp_enabled = 1;       // PID_CPU_COMP_ENABLED: CPU 补偿开关
static int pid_cpu_comp_divisor = 30;      // PID_CPU_COMP_DIVISOR: (cpu-batt 0.1°C)÷divisor→0.1°C
static int pid_curr_comp_enabled = 0;      // PID_CURR_COMP_ENABLED: 电流补偿开关（默认关）
static int pid_curr_comp_threshold = 200;  // PID_CURR_COMP_THRESHOLD: 0.01A 阈值(200=2A)
static int pid_curr_comp_divisor = 2;      // PID_CURR_COMP_DIVISOR: |A|÷divisor→°C
static float pid_cpu_comp_smooth = 0.0f;   // CPU 补偿 EMA 平滑值（°C）
static float pid_curr_comp_smooth = 0.0f;  // 电流补偿 EMA 平滑值（°C）
static int pid_last_comp_10 = 0;           // 上次 PID 重算时的补偿值（0.1°C）

// PID 目标值（供 rate_limited_execute 读取）
static int pid_target_rpm = 2000;
static int pid_target_cold = 60;

// 散热器回传参数（由 read_status_ble 解析，供 PID 分支使用）
static int cooler_runmode = -1;           // 散热器实际运行模式
static int cooler_hot_temp = -1;          // 热端温度（0.1°C）
static int cooler_cold_temp = -1;         // 冷端温度（0.1°C）
static int cooler_rpm_real = -1;          // 实际风扇转速
static int cooler_rpm_level = -1;         // 风扇 PWM 原始值
static int cooler_cold_real = -1;         // 实际制冷强度
static int cooler_cold_level = -1;        // 制冷 PWM 原始值
static int cooler_target_temp = -1;       // 目标温度（0.1°C）

// 前向声明（配置系统函数位于 write_log/clamp 之前，C 要求先声明后使用）
static void write_log(const char *fmt, ...);
static inline int clamp(int val, int lo, int hi);
static void alarm_handler(int sig);
static int match_nearest_gear_for_reconnect(void);
static void pid_align_from_gear(void);

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
 */
static void load_config(const char *path) {
    FILE *f = fopen(path, "r");
    if (!f) {
        write_log("配置 无法打开 %s", path);
        return;
    }
    int old_ctrl_mode = ctrl_mode;  // 保存旧值，用于 PID 过渡检测

    // ── 第一遍：总开关检测（找到后立即退出，避免全文件扫描）──
    char line[256];
    int enabled = 1;
    while (fgets(line, sizeof(line), f)) {
        char *key;
        char *val_str = config_parse_line(line, &key);
        if (!val_str) continue;
        if (strcmp(key, "CONFIG_ENABLED") == 0) {
            enabled = atoi(val_str) != 0;
            break;
        }
    }

    if (!enabled) {
        fclose(f);
        write_log("配置 已禁用，使用默认参数");
        return;
    }

    // ── 第二遍：全量单次扫描 ──
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

        // ═══════════════════════════════════════════════════════════
        // [组 0] 无条件参数（放在最前，否则会被有 guard 的分组吞掉）
        // ═══════════════════════════════════════════════════════════
        if (0) {}
        // ── 系统路径与缩放 ──
        else if (strcmp(key, "BATT_TEMP_PATH") == 0)
            config_read_path(BATT_TEMP_PATH, sizeof(BATT_TEMP_PATH), val_str);
        else if (strcmp(key, "CPU_TEMP_PATH_FMT") == 0)
            config_read_path(CPU_TEMP_PATH_FMT, sizeof(CPU_TEMP_PATH_FMT), val_str);
        else if (strcmp(key, "BATT_CURRENT_PATH") == 0)
            config_read_path(BATT_CURRENT_PATH, sizeof(BATT_CURRENT_PATH), val_str);
        else if (strcmp(key, "BATT_TEMP_DIVISOR") == 0)   BATT_TEMP_DIVISOR  = clamp(val, 1, 10000);
        else if (strcmp(key, "CPU_TEMP_DIVISOR") == 0)    CPU_TEMP_DIVISOR   = clamp(val, 1, 10000);
        else if (strcmp(key, "BATT_CURRENT_DIVISOR") == 0) BATT_CURRENT_DIVISOR = clamp(val, 1, 10000);
        // ── 基础控制参数 ──
        else if (strcmp(key, "BATT_BASELINE") == 0)        BATT_BASELINE      = clamp(val, 300, 500);
        else if (strcmp(key, "BATT_ZONE_1") == 0)          BATT_ZONE_1        = clamp(val, 1, 100);
        else if (strcmp(key, "BATT_ZONE_2") == 0)          BATT_ZONE_2        = clamp(val, 1, 100);
        else if (strcmp(key, "BATT_ZONE_3") == 0)          BATT_ZONE_3        = clamp(val, 1, 100);
        else if (strcmp(key, "BATT_COOLDOWN_CYCLES") == 0) BATT_COOLDOWN_CYCLES = clamp(val, 0, 20);
        else if (strcmp(key, "BATT_SKIP_MAX") == 0)        BATT_SKIP_MAX        = clamp(val, 0, 30);
        else if (strcmp(key, "BATT_RECOVERY_M1") == 0)    BATT_RECOVERY_M1     = clamp(val, 1, 20);
        else if (strcmp(key, "BATT_RECOVERY_M2") == 0)    BATT_RECOVERY_M2     = clamp(val, 1, 20);
        else if (strcmp(key, "BATT_RECOVERY_M3") == 0)    BATT_RECOVERY_M3     = clamp(val, 1, 20);
        else if (strcmp(key, "BATT_RECOVERY_PHASE_CYCLES") == 0) BATT_RECOVERY_PHASE_CYCLES = clamp(val, 1, 50);
        // ── CPU 紧急阈值（无条件解析，EMERG_CPU_ENABLED 运行时决定是否检查）──
        else if (strcmp(key, "CPU_EMERG_3") == 0)          CPU_EMERG_3        = clamp(val, 600, 1000);
        else if (strcmp(key, "CPU_EMERG_2") == 0)          CPU_EMERG_2        = clamp(val, 500, 900);
        else if (strcmp(key, "CPU_EMERG_1") == 0)          CPU_EMERG_1        = clamp(val, 400, 800);
        else if (strcmp(key, "CPU_RECOVER_2") == 0)        CPU_RECOVER_2      = clamp(val, 500, 900);
        else if (strcmp(key, "CPU_RECOVER_1") == 0)        CPU_RECOVER_1      = clamp(val, 400, 800);
        else if (strcmp(key, "CPU_RECOVER_0") == 0)        CPU_RECOVER_0      = clamp(val, 300, 700);
        else if (strcmp(key, "CPU_FILTER_ALPHA") == 0)     CPU_FILTER_ALPHA   = clamp(val, 1, 100);
        else if (strcmp(key, "CPU_ZONE_MIN") == 0)          CPU_ZONE_MIN       = clamp(val, 0, 99);
        else if (strcmp(key, "CPU_ZONE_MAX") == 0)          CPU_ZONE_MAX       = clamp(val, 0, 99);
        // ── 电流紧急阈值 ──
        else if (strcmp(key, "CURRENT_EMERG_3") == 0)       CURRENT_EMERG_3    = clamp(val, 100, 1500);
        else if (strcmp(key, "CURRENT_EMERG_2") == 0)       CURRENT_EMERG_2    = clamp(val, 100, 1500);
        else if (strcmp(key, "CURRENT_EMERG_1") == 0)       CURRENT_EMERG_1    = clamp(val, 100, 1500);
        else if (strcmp(key, "CURRENT_RECOVER_2") == 0)     CURRENT_RECOVER_2  = clamp(val, 100, 1500);
        else if (strcmp(key, "CURRENT_RECOVER_1") == 0)     CURRENT_RECOVER_1  = clamp(val, 100, 1500);
        else if (strcmp(key, "CURRENT_RECOVER_0") == 0)     CURRENT_RECOVER_0  = clamp(val, 100, 1500);
        else if (strcmp(key, "CURRENT_SMOOTH_ALPHA") == 0)  CURRENT_SMOOTH_ALPHA = clamp(val, 1, 100);
        // ── 紧急覆盖参数 ──
        else if (strcmp(key, "EMERG_FORCED_1") == 0)       EMERG_FORCED_1     = clamp(val, 0, 12);
        else if (strcmp(key, "EMERG_FORCED_2") == 0)       EMERG_FORCED_2     = clamp(val, 0, 12);
        else if (strcmp(key, "EMERG_FORCED_3") == 0)       EMERG_FORCED_3     = clamp(val, 0, 12);
        else if (strcmp(key, "EMERG_FORCED_4") == 0)       EMERG_FORCED_4     = clamp(val, 0, 12);
        else if (strcmp(key, "EMERG_EXIT_CAP_OFFSET") == 0) EMERG_EXIT_CAP_OFFSET = clamp(val, 0, 5);
        else if (strcmp(key, "EMERG_STEP") == 0)              EMERG_STEP = clamp(val, 1, 12);
        else if (strcmp(key, "EMERG_EXIT_BATT_THRESHOLD") == 0) EMERG_EXIT_BATT_THRESHOLD = clamp(val, 5, 50);
        // ── 反补 / 豁免参数 ──
        else if (strcmp(key, "OVERRIDE_MAX") == 0)         OVERRIDE_MAX       = clamp(val, 0, 20);
        else if (strcmp(key, "REV_COMP_T1") == 0)          REV_COMP_T1        = clamp(val, 1, 50);
        else if (strcmp(key, "REV_COMP_T2") == 0)          REV_COMP_T2        = clamp(val, 1, 50);
        else if (strcmp(key, "REV_COMP_T3") == 0)          REV_COMP_T3        = clamp(val, 1, 50);
        else if (strcmp(key, "REV_COMP_COOLDOWN") == 0)   REV_COMP_COOLDOWN  = clamp(val, 0, 10);
        // ── 速率限制（无条件，作用于所有模式）──
        else if (strcmp(key, "RATE_LIMIT_RPM_UP") == 0)  RATE_LIMIT_RPM_UP  = clamp(val, 50, 2000);
        else if (strcmp(key, "RATE_LIMIT_RPM_DOWN") == 0) RATE_LIMIT_RPM_DOWN = clamp(val, 50, 2000);
        else if (strcmp(key, "RATE_LIMIT_COLD") == 0) RATE_LIMIT_COLD = clamp(val, 1, 194);
        else if (strcmp(key, "RATE_LIMIT_TEMP") == 0) RATE_LIMIT_TEMP = clamp(val, 1, 30);
        // ── PID 映射范围（gear 模式也用到 pid_align_from_gear，故无条件）──
        else if (strcmp(key, "PID_COLD_MIN") == 0)         pid_cold_min        = clamp(val, 0, 194);
        else if (strcmp(key, "PID_COLD_MAX") == 0)         pid_cold_max        = clamp(val, 0, 194);
        else if (strcmp(key, "PID_COLD_EXP") == 0)         pid_cold_exp        = clamp(val, 50, 500);
        else if (strcmp(key, "PID_RPM_MIN") == 0)          pid_rpm_min         = clamp(val, 1000, 6000);
        else if (strcmp(key, "PID_RPM_MAX") == 0)          pid_rpm_max         = clamp(val, 1000, 6000);
        else if (strcmp(key, "PID_HOT_MAP_MIN") == 0)      pid_hot_map_min     = clamp(val, 200, 500);
        else if (strcmp(key, "PID_HOT_MAP_MAX") == 0)      pid_hot_map_max     = clamp(val, 200, 500);
        // ── 系统参数 ──
        else if (strcmp(key, "STATUS_TIMEOUT") == 0)       STATUS_TIMEOUT     = clamp(val, 5, 60);
        else if (strcmp(key, "LOG_MAX_KB") == 0)           LOG_MAX_KB         = clamp(val, 0, 1000);
        else if (strcmp(key, "LOG_FILE") == 0)
            config_read_path(log_file_path, sizeof(log_file_path), val_str);
        // ── 开关/模式类（写在组 0 末尾，解析后供后续分组守卫使用）──
        else if (strcmp(key, "CTRL_MODE") == 0)                ctrl_mode            = (val != 0);
        else if (strcmp(key, "EMERG_CURRENT_ENABLED") == 0)   EMERG_CURRENT_ENABLED = (val != 0);
        else if (strcmp(key, "EMERG_CPU_ENABLED") == 0)       EMERG_CPU_ENABLED     = (val != 0);
        else if (strcmp(key, "REV_COMP_ENABLED") == 0)        REV_COMP_ENABLED      = (val != 0);
        else if (strcmp(key, "TREND_EXEMPT_ENABLED") == 0)    TREND_EXEMPT_ENABLED  = (val != 0);
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
        else if (strcmp(key, "DEBUG_MODE") == 0) {
            debug_mode = (val != 0);
            write_log("配置 调试模式 %s", debug_mode ? "开启" : "关闭");
        }
        else if (strcmp(key, "GEAR_CONFIG_ENABLED") == 0)     gear_config_enabled  = (val != 0);
        // ── 兼容旧名称 ──
        else if (strcmp(key, "RPM_SMOOTH_STEP") == 0) RATE_LIMIT_RPM_UP  = clamp(val, 50, 2000);
        else if (strcmp(key, "RATE_LIMIT_RPM_up") == 0) RATE_LIMIT_RPM_UP = clamp(val, 50, 2000);

        // ═══════════════════════════════════════════════════════════
        // [组 1] 电流-挡位子项：仅 CURRENT_GEAR_MODE 启用时生效
        // ═══════════════════════════════════════════════════════════
        else if (CURRENT_GEAR_MODE_CHARGE || CURRENT_GEAR_MODE_DISCHARGE) {
            if      (strcmp(key, "CURRENT_GEAR_MULT_CHARGE") == 0)
                CURRENT_GEAR_MULT_CHARGE = clamp(val, 1, 50);
            else if (strcmp(key, "CURRENT_GEAR_MULT_DISCHARGE") == 0)
                CURRENT_GEAR_MULT_DISCHARGE = clamp(val, 1, 50);
            else if (strcmp(key, "CURRENT_GEAR_SMOOTH_ALPHA") == 0)
                CURRENT_GEAR_SMOOTH_ALPHA = clamp(val, 1, 100);
            else if (strcmp(key, "CURRENT_GEAR_MIN") == 0)
                CURRENT_GEAR_MIN = clamp(val, 1, 12);
        }

        // ═══════════════════════════════════════════════════════════
        // [组 2] PID 控制参数：仅 CTRL_MODE=1 时生效
        // ═══════════════════════════════════════════════════════════
        else if (ctrl_mode == 1) {
            // PID 核心
            if      (strcmp(key, "PID_KP") == 0)              pid_kp              = clamp(val, 1, 1000);
            else if (strcmp(key, "PID_KI") == 0)              pid_ki              = clamp(val, 0, 1000);
            else if (strcmp(key, "PID_KD") == 0)              pid_kd              = clamp(val, 0, 1000);
            else if (strcmp(key, "PID_INTEGRAL_LIMIT") == 0)  pid_integral_limit  = clamp(val, 0, 1000);
            else if (strcmp(key, "PID_BATT_ALPHA") == 0)      pid_batt_alpha      = clamp(val, 1, 100);
            else if (strcmp(key, "PID_OUTPUT_ALPHA") == 0)    pid_output_alpha    = clamp(val, 1, 100);
            // PID 输入补偿
            else if (strcmp(key, "PID_CPU_COMP_ENABLED") == 0)   pid_cpu_comp_enabled   = (val != 0);
            else if (strcmp(key, "PID_CPU_COMP_DIVISOR") == 0)   pid_cpu_comp_divisor   = clamp(val, 5, 200);
            else if (strcmp(key, "PID_CURR_COMP_ENABLED") == 0)  pid_curr_comp_enabled  = (val != 0);
            else if (strcmp(key, "PID_CURR_COMP_THRESHOLD") == 0) pid_curr_comp_threshold = clamp(val, 50, 1000);
            else if (strcmp(key, "PID_CURR_COMP_DIVISOR") == 0)  pid_curr_comp_divisor  = clamp(val, 1, 50);
            // PID 调试
            else if (strcmp(key, "DEBUG_PID") == 0)            debug_pid           = (val != 0);
        }

        // ═══════════════════════════════════════════════════════════
        // [组 3] 调试子项：仅 DEBUG_MODE=1 时生效
        // ═══════════════════════════════════════════════════════════
        else if (debug_mode) {
            if      (strcmp(key, "DEBUG_SENSOR") == 0)  { debug_sensor = (val != 0); }
            else if (strcmp(key, "DEBUG_EMERG") == 0)   { debug_emerg   = (val != 0); }
            else if (strcmp(key, "DEBUG_BATT") == 0)    { debug_batt    = (val != 0); }
            else if (strcmp(key, "DEBUG_EXEC") == 0)    { debug_exec    = (val != 0); }
            else if (strcmp(key, "DEBUG_CONN") == 0)    { debug_conn    = (val != 0); }
            else if (strcmp(key, "DEBUG_CONFIG") == 0)  { debug_config  = (val != 0); }
            else if (strcmp(key, "DEBUG_MAIN") == 0)    { debug_main    = (val != 0); }
        }

        // ═══════════════════════════════════════════════════════════
        // [组 4] 挡位表：仅 GEAR_CONFIG_ENABLED=1 时生效
        // ═══════════════════════════════════════════════════════════
        else if (strncmp(key, "GEAR_", 5) == 0) {
            if (!gear_config_enabled) continue;
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
        last_sent_valid = 0;
        if (ctrl_mode == 1 && config_mtime != 0) {
            pid_align_from_gear();
        }
        write_log("配置 CTRL_MODE=%d", ctrl_mode);
    }

    // ── GEAR_N 后处理：排序重排为连续档位表，同步范围 ──
    if (gear_config_enabled) {
        if (config_gear_count > 0) {
            // 重置档位表，填入配置档位
            gear_count = 0;
            level_max = 0;
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
            level_max = gear_count;
            battery_fan_level = clamp(battery_fan_level, level_min, level_max);
            write_log("配置 档位表 %d 级 (1~%d)", gear_count, level_max);
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
 * 写入日志（自动滚动：超上限后删除最早 2 行）。
 * 日期格式：日+时间，无年月（例 "14 22:30:16"）。
 * LOG_MAX_KB=0 时关闭日志。持持久 FILE* 避免每行 open/close。
 */
static void write_log(const char *fmt, ...) {
    if (LOG_MAX_KB == 0) return;     // 日志关闭

    int max_bytes = LOG_MAX_KB * 1024;

    // 超标 → 滚动：先关 log_fp，再读-删-写，下次自动重开（调试模式下跳过限制，保留完整日志）
    struct stat st;
    if (!debug_mode && stat(log_file_path, &st) == 0 && st.st_size > max_bytes) {
        if (log_fp) { fclose(log_fp); log_fp = NULL; }
        size_t sz = st.st_size;
        char *buf = malloc(sz + 1);
        if (buf) {
            FILE *rf = fopen(log_file_path, "r");
            if (rf) {
                size_t rd = fread(buf, 1, sz, rf);
                buf[rd] = '\0';
                fclose(rf);

                // 跳过前 2 个换行（删除最早 2 行）
                int nl = 0;
                char *tail = buf;
                while (*tail && nl < 2) {
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
    trend_override = 0;
    override_anchor_temp = -1;
    rev_comp_pending_abs = 0;
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
    int raw = read_sysfs_int(BATT_TEMP_PATH);
    if (raw < 0) return -1;
    int val = raw / BATT_TEMP_DIVISOR;
    debug_log(debug_sensor, "batt_temp 原始 %d 除数 %d = %d (%.1f°C)", raw, BATT_TEMP_DIVISOR, val, val / 10.0);
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
        debug_log(debug_sensor, "cpu_temp zone=%.0f max=%d (%.1f°C)",
                  (double)cpu_zone_count, max_temp, max_temp / 10.0);
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
    if (level < level_min || level > level_max) level = level_min;
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
 * 下发控制参数（如有变化）
 * 通过 am broadcast 发送到 LSPosed 模块
 *
 * 注意：散热器每次调整都会暂时性能下降，所以参数无变化时必须跳过
 * 返回 1=已发送，0=跳过（无变化）
 */
static int apply_level(int level) {
    int mode, target, windOC, coldOC, windLevel;

    level = clamp(level, level_min, level_max);
    build_params(level, &mode, &target, &windOC, &coldOC, &windLevel);

    // 风扇转速限速（升降独立速率）
    rate_limit(&actual_rpm, (mode == 0) ? windLevel : windOC,
               RATE_LIMIT_RPM_UP, RATE_LIMIT_RPM_DOWN);

    // 制冷强度限速
    rate_limit(&actual_cold, coldOC, RATE_LIMIT_COLD, RATE_LIMIT_COLD);

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

    // ---- 去重检测 ----
    if (last_sent_valid &&
        mode      == last_mode &&
        target    == last_target_temp &&
        windOC    == last_windOC &&
        coldOC    == last_coldOC &&
        windLevel == last_windLevel)
    {
        debug_log(debug_exec, "apply_level 档位%d 参数无变化，跳过下发", gear_label(level));
        return 0;
    }

    debug_log(debug_exec, "apply_level 下发 档位%d mode=%d target=%d windOC=%d coldOC=%d windLevel=%d",
              gear_label(level), mode, target, windOC, coldOC, windLevel);

    send_am_broadcast(mode, target, windOC, coldOC, windLevel);

    // ---- 更新缓存 ----
    last_sent_valid    = 1;
    last_mode          = mode;
    last_target_temp   = target;
    last_windOC        = windOC;
    last_coldOC        = coldOC;
    last_windLevel     = windLevel;

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
 * 紧急退出恢复期：将 ZONE 阈值乘以恢复倍率，降低灵敏度。
 *
 * 反补查表：三区（冷外/内/热外）× 方向（升/降温）× 三级阈值（REV_COMP_T1/T2/T3）。
 * 趋势豁免：反补被抑制时抬高生效阈值，锚点温度复位。
 */
static void battery_control(void) {
    int batt = read_battery_temp();
    if (batt < 0) {
        batt_idle_cycles++;  // 传感器偶发失败时递增空闲计数，保证温差归一化正确
        return;
    }

    // --- 紧急退出恢复期：阶段推进（用 recovery_step 索引，不依赖具体倍率值）---
    // 阶段推进不受电池温度读取失败影响（已在上方处理），
    // 但推进逻辑需放在首次读取判断之前，确保冷却期中也能正常走完各阶段
    if (batt_recovery_cycles > 0) {
        batt_recovery_cycles--;
        if (batt_recovery_cycles == 0) {
            if (recovery_step == 1) {
                // P1 → P2
                batt_recovery_multiplier = BATT_RECOVERY_M2;
                recovery_step = 2;
                batt_recovery_cycles = BATT_RECOVERY_PHASE_CYCLES;
                debug_log(debug_batt, "recovery P1→P2 倍率%d→%d", BATT_RECOVERY_M1, BATT_RECOVERY_M2);
            } else if (recovery_step == 2) {
                // P2 → P3
                batt_recovery_multiplier = BATT_RECOVERY_M3;
                recovery_step = 3;
                batt_recovery_cycles = BATT_RECOVERY_PHASE_CYCLES;
                debug_log(debug_batt, "recovery P2→P3 倍率%d→%d", BATT_RECOVERY_M2, BATT_RECOVERY_M3);
            } else if (recovery_step >= 3) {
                // P3 结束 → 恢复正常
                batt_recovery_multiplier = 1;
                recovery_step = 0;
                debug_log(debug_batt, "recovery P3 结束，恢复正常");
            }
        }
    }

    // 首次读取（启动后/重连后第一次）：不参与任何判断，数据正常更新，直接进入冷却
    if (last_batt_reading < 0) {
        last_batt_reading = batt;
        batt_cooldown = BATT_COOLDOWN_CYCLES;
        return;
    }

    // 计算本周期温度变化量和常规升降档量（先算，给跳过逻辑参考）
    int batt_change = 0, abs_change = 0;
    if (last_batt_reading >= 0) {
        batt_change = batt - last_batt_reading;
        abs_change = abs(batt_change);
    }
    int diff = batt - BATT_BASELINE;
    int ad = abs(diff);
    int sign = sign_of(diff);
    // 紧急退出恢复期：将 BATT_ZONE 阈值乘以恢复倍率，降低调档灵敏度
    int eff_z1 = BATT_ZONE_1 * batt_recovery_multiplier;
    int eff_z2 = BATT_ZONE_2 * batt_recovery_multiplier;
    int eff_z3 = BATT_ZONE_3 * batt_recovery_multiplier;
    int delta = 0;
    if      (ad > eff_z3) delta = 3;
    else if (ad > eff_z2) delta = 2;
    else if (ad > eff_z1) delta = 1;
    delta *= sign;

    debug_log(debug_batt, "batt_ctrl temp=%d (%.1f°C) diff=%d ad=%d sign=%d eff_z=[%d/%d/%d] delta=%d rec_mul=%d",
              batt, batt / 10.0, diff, ad, sign, eff_z1, eff_z2, eff_z3, delta, batt_recovery_multiplier);

    int cur_idle = batt_idle_cycles;  // 快照：自上次有效变化以来已过的空闲周期数

    // 温度值与上次调整时相同 → 计数跳过，超过 BATT_SKIP_MAX 次后强制进入
    if (batt == last_batt_reading) {
        batt_idle_cycles++;
        if (++batt_unchanged_count < BATT_SKIP_MAX) return;
        batt_unchanged_count = 0;
        // 温度没变时 delta 已在上次执行过，清零防齿轮漂移
        delta = 0;
        abs_change = 0;
        batt_change = 0;
    } else {
        batt_unchanged_count = 0;
        batt_idle_cycles = 0;
    }

    int skip_delta = 0;  // =1 时本次不执行常规升降档

    // 冷却递减（放在 abs_change 判断之前，温度不变强制进入时也能递减）
    int in_cooldown = (batt_cooldown > 0);
    if (in_cooldown) {
        batt_cooldown--;
        skip_delta = 1;
        debug_log(debug_batt, "batt_ctrl 冷却中，剩余%d周期", batt_cooldown);
    }
    if (rev_comp_cooldown > 0) rev_comp_cooldown--;

    // ═══════════════ 反补查表（Sheet3 三区×双向×三级阈值） ═══════════════
    if (last_batt_reading >= 0 && abs_change > 0) {
        int trend_rev = (delta > 0 && batt < last_batt_reading) ||
                        (delta < 0 && batt > last_batt_reading);
        int dir = (batt_change > 0) ? 1 : -1;  // +1=升温, -1=降温

        // 三区判断：冷外区 / 内区 / 热外区
        int is_cold_outer = (batt <= BATT_BASELINE - eff_z2);
        int is_hot_outer  = (batt >= BATT_BASELINE + eff_z2);
        int in_inner_zone = !is_cold_outer && !is_hot_outer;

        // 根据方向+区域查三级阈值（0.1°C 单位，999=无穷大）
        // REV_COMP_T1/T2/T3 默认 2/3/4 = 0.2°C / 0.3°C / 0.4°C 每周期，可通过 profile.conf 配置
	        int t1 = 999, t2 = 999, t3 = 999;
	        if (dir > 0) {
	            if      (is_cold_outer) { t1 = REV_COMP_T3; }
	            else if (in_inner_zone) { t1 = REV_COMP_T2; t2 = REV_COMP_T3; }
	            else                   { t1 = REV_COMP_T1; t2 = REV_COMP_T2; t3 = REV_COMP_T3; }
	        } else {
	            if      (is_cold_outer) { t1 = REV_COMP_T1; t2 = REV_COMP_T2; t3 = REV_COMP_T3; }
	            else if (in_inner_zone) { t1 = REV_COMP_T2; t2 = REV_COMP_T3; }
	            else                   { t1 = REV_COMP_T3; }
	        }

	        // 统一计算每周期速率（用于下方趋势豁免和反补）
	        int total_abs = abs_change + rev_comp_pending_abs;
	        int total_interval = (cur_idle + 1) + rev_comp_pending_idle;
	        int rate = total_abs / total_interval;
	        if (rate < 1) rate = 1;

	        // 计算跨过几个阈值（用于反补档位数和豁免范围判断）
	        int steps = (rate > t1) + (rate > t2) + (rate > t3);

	        // ═══ 趋势豁免（抬高生效阈值） ═══
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
	        if (TREND_EXEMPT_ENABLED && !in_cooldown && rev_comp_pending_abs == 0 && steps < 3) {
	            if (trend_rev && battery_fan_level > level_min &&
	                battery_fan_level < level_max)
	            {
	                if (trend_override == 0) {
	                    // 首次豁免：记录锚点温度
	                    override_anchor_temp = batt;
	                    write_log("趋势豁免 %d", gear_label(battery_fan_level));
	                    trend_override++;
	                    skip_delta = 1;
	                } else {
	                    // 持续豁免中：计算当前区间中间值（0.1°C）
	                    int band_mid;
	                    if      (steps == 0) band_mid = REV_COMP_T1 / 2;
	                    else if (steps == 1) band_mid = (REV_COMP_T1 + REV_COMP_T2) / 2;
	                    else                 band_mid = (REV_COMP_T2 + REV_COMP_T3) / 2;
	                    if (band_mid < 1) band_mid = 1;

	                    // 降温（delta<0，温度向基准降温）→ 锚点 - 中值 = 复位下限
	                    // 升温（delta>0，温度向基准升温）→ 锚点 + 中值 = 复位上限
	                    int reset_threshold;
	                    int reset_triggered = 0;
	                    if (delta < 0) {
	                        reset_threshold = override_anchor_temp - band_mid;
	                        if (batt <= reset_threshold) reset_triggered = 1;
	                    } else {
	                        reset_threshold = override_anchor_temp + band_mid;
	                        if (batt >= reset_threshold) reset_triggered = 1;
	                    }

	                    if (reset_triggered) {
	                        // 温度越过复位阈值 → 复位豁免
	                        trend_override = 0;
	                    } else {
	                        trend_override++;
	                        skip_delta = 1;
	                    }
	                }
	            } else {
	                trend_override = 0;
	            }
	        }

	        // ═══ 反补（不为全效豁免时执行） ═══
	        if (REV_COMP_ENABLED && !skip_delta && (steps > 0 || rev_comp_pending_abs > 0)) {
	            trend_override = 0;

	            if (rev_comp_cooldown == 0) {
	                // 冷却已到 → 用速率查表执行反补
	                int adjust = dir * steps;

	                rev_comp_pending_abs = 0;
	                rev_comp_pending_idle = 0;

	                if (adjust != 0) {
	                    int old = battery_fan_level;
	                    battery_fan_level += adjust;
	                    battery_fan_level = clamp(battery_fan_level, level_min, level_max);
	                    skip_delta = 1;
	                    if (old != battery_fan_level) {
	                        batt_cooldown = BATT_COOLDOWN_CYCLES;
	                        rev_comp_cooldown = REV_COMP_COOLDOWN;
	                        write_log("过冲%d/%d 挡位%d（%+d）",
	                                  rate / 10, rate % 10,
	                                  gear_label(battery_fan_level), adjust);
	                    }
	                }
	            } else {
	                // 冷却期内累积温差和周期数，不做调整
	                rev_comp_pending_abs = total_abs;
	                rev_comp_pending_idle = total_interval;
	                debug_log(debug_batt, "batt_ctrl 反补冷却中 累积 abs=%d 周期=%d", total_abs, total_interval);
	            }
	        }
	    }
    // ---- 应用常规升降档（仅当未被豁免/反补跳过时） ----
    if (delta != 0 && !skip_delta) {
        int old = battery_fan_level;
        battery_fan_level += delta;
        battery_fan_level = clamp(battery_fan_level, level_min, level_max);
        if (old != battery_fan_level) {
            batt_cooldown = BATT_COOLDOWN_CYCLES;
            write_log("挡位%d（%+d）", gear_label(battery_fan_level), delta);
        }
    }

    debug_log(debug_batt, "batt_ctrl 最终 battery_fan_level=%d skip_delta=%d cooldown=%d",
              battery_fan_level, skip_delta, batt_cooldown);

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
            cpu_weighted = cpu_now;
            first_run = 0;
        } else {
            cpu_weighted = EMA(cpu_now, cpu_weighted, CPU_FILTER_ALPHA);
        }
    }
    int t = cpu_weighted;
    int cpu_valid = (cpu_now >= 0);
    debug_log(debug_emerg, "emerg CPU 原始%d 滤波%d 有效%d", cpu_now, t, cpu_valid);

    // --- 2. 电池电流绝对值 ---
    int cur_ua = read_battery_current_abs();
    int cur_valid = (cur_ua >= 0);

    int prev_level = emergency_level;
    int new_level = emergency_level;

    // === 3. 计算单源级别（各自 0~3，用进入阈值） ===
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

    // === 4. 综合等级 = cpu_level + current_level（统一升降滞回） ===
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
            int cur_exit = curr_smooth_valid ? curr_smooth_val : cur_ua;
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

    // === 5. 电流平滑维护（紧急退出用 EMA） ===
    // 升档时重置平滑（从新值重新累积）；降档不重置，直到完全退出
    if (new_level > prev_level) {
        curr_smooth_valid = 0;
    }
    if (cur_valid && emergency_level > 0) {
        if (!curr_smooth_valid) {
            curr_smooth_val = cur_ua;
            curr_smooth_valid = 1;
        } else {
            curr_smooth_val = EMA(cur_ua, curr_smooth_val, CURRENT_SMOOTH_ALPHA);
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
        batt_cooldown = BATT_COOLDOWN_CYCLES;
    }

    // --- 7. 根据模式设定强制最低档位 ---
    if (EMERG_MODE_ENTRY == 0) {
        // 模式 0：表查强制最低档（EMERG_FORCED_N，当前逻辑）
        switch (emergency_level) {
            case 4: forced_min_level = EMERG_FORCED_4; break;
            case 3: forced_min_level = EMERG_FORCED_3; break;
            case 2: forced_min_level = EMERG_FORCED_2; break;
            case 1: forced_min_level = EMERG_FORCED_1; break;
            default: forced_min_level = 0;             break;
        }
    } else {
        // 模式 1：升档模式 — 按等级计算最低档 = level_min + EMERG_STEP * level
        if (emergency_level > 0) {
            forced_min_level = level_min + EMERG_STEP * emergency_level;
            if (forced_min_level > level_max) forced_min_level = level_max;
        } else {
            forced_min_level = 0;
        }
    }
    debug_log(debug_emerg, "emerg 最终等级=%d forced_min=%d", emergency_level, forced_min_level);
}

// ======================== 电流-挡位映射 + 温度调整融合 ========================

/**
 * 电流-挡位映射 + 温度融合模式。
 *
 * 电流经 EMA 平滑 + 倍率 → 推荐挡位（基础）。
 * 温度在推荐挡位上累积偏移（带冷却期），推荐挡位变化时偏移继承。
 * 最终挡位 = clamp(推荐 + 偏移, level_min, level_max)。
 *
 * 返回 1=已覆盖，0=回退常规模式。
 */
static int current_gear_override(void) {
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
        curr_gear_smooth_val = EMA(abs_ua10, curr_gear_smooth_val, CURRENT_GEAR_SMOOTH_ALPHA);
    }

    // 4. 推荐挡位 = 平滑值(0.01A) × 倍率 ÷ 100
    int multiplier = is_charging ? CURRENT_GEAR_MULT_CHARGE : CURRENT_GEAR_MULT_DISCHARGE;
    int recommended = (curr_gear_smooth_val * multiplier) / 100;
    recommended = clamp(recommended, level_min, level_max);

    debug_log(debug_batt, "curr_gear sign=%s raw=%d smooth=%d rec=%d/%d",
              is_charging ? "充电" : "放电", abs_ua10, curr_gear_smooth_val,
              recommended, gear_label(recommended));

    // 5. 温度偏移管理
    int batt = read_battery_temp();
    if (curr_gear_rec > 0) {
        // 已激活：每周期根据当前温度差计算偏移（不受冷却期阻挡）
        // 冷却期仅阻止同方向继续累积，但反方向（温度回归方向）始终允许
        if (batt >= 0) {
            int diff = batt - BATT_BASELINE;
            int ad = abs(diff);
            int sign = sign_of(diff);
            int delta = 0;
            if      (ad > BATT_ZONE_3) delta = 3 * sign;
            else if (ad > BATT_ZONE_2) delta = 2 * sign;
            else if (ad > BATT_ZONE_1) delta = 1 * sign;
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
        curr_gear_temp_offset = battery_fan_level - recommended;
    }

    // 6. 计算实际挡位 = 推荐 + 偏移
    int final_level = recommended + curr_gear_temp_offset;
    final_level = clamp(final_level, level_min, level_max);

    // 7. 统一以实际挡位走阈值检查：低于阈值则退出/不进入电流映射
    if (final_level < CURRENT_GEAR_MIN) {
        curr_gear_rec = 0;
        curr_gear_temp_offset = 0;
        curr_gear_temp_cooldown = 0;
        return 0;
    }

    // 偏移继承日志（推荐挡位变化时温度偏移自然保留）
    if (curr_gear_rec > 0 && recommended != curr_gear_rec) {
        debug_log(debug_batt, "curr_gear rec变化 %d→%d, temp_offset=%+d 继承",
                  curr_gear_rec, recommended, curr_gear_temp_offset);
    }
    curr_gear_rec = recommended;
    battery_fan_level = final_level;

    // 清除反补/豁免状态（切换模式时不应保留旧状态）
    reset_exempt_state();
    rev_comp_cooldown = 0;
    last_batt_reading = -1;
    batt_idle_cycles = 0;
    batt_unchanged_count = 0;

    debug_log(debug_batt, "curr_gear 融合 rec=%d temp_offset=%+d gear=%d",
              recommended, curr_gear_temp_offset, gear_label(final_level));
    return 1;
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

    // I 项（积分分离：±1.0°C 内才累积）
    if (error > -1.0f && error < 1.0f) {
        pid_integral += (pid_ki / 1000.0f) * error * dt;
    }
    float i_limit = pid_integral_limit / 1000.0f;
    if (pid_integral >  i_limit) pid_integral =  i_limit;
    if (pid_integral < -i_limit) pid_integral = -i_limit;

    // D 项（首次跳过）
    float d = 0.0f;
    if (pid_prev_error != 0 || pid_last_batt >= 0) {
        d = (pid_kd / 1000.0f) * (error - pid_prev_error) / dt;
    }
    pid_prev_error = error;

    // 钳位 0~1
    float raw = p + pid_integral + d;
    if (raw < 0.0f) raw = 0.0f;
    if (raw > 1.0f) raw = 1.0f;
    return raw;
}

/**
 * 热端温度线性映射：PID_HOT_MAP_MIN → PID_RPM_MIN, PID_HOT_MAP_MAX → PID_RPM_MAX
 */
static int rpm_from_hot_end(int hot_10) {
    int range = pid_hot_map_max - pid_hot_map_min;
    if (range <= 0) return pid_rpm_min;
    float t = (float)(hot_10 - pid_hot_map_min) / range;
    if (t < 0.0f) t = 0.0f;
    if (t > 1.0f) t = 1.0f;
    return pid_rpm_min + (int)(t * (pid_rpm_max - pid_rpm_min));
}

/**
 * 冷强度指数映射：n^exp
 */
static int rpm_from_cold_exp(int cold) {
    int range = pid_cold_max - pid_cold_min;
    if (range <= 0) return pid_rpm_min;
    float n = (float)(cold - pid_cold_min) / range;
    float n_exp = powf(n, pid_cold_exp / 100.0f);
    return pid_rpm_min + (int)(n_exp * (pid_rpm_max - pid_rpm_min));
}

/**
 * 自加权合并：各以自身 RPM 为权重
 * 冷端无数据（cooler_hot_temp<=0）时退化为纯 exp
 */
static int rpm_combine_weighted(int rpm_hot, int rpm_cold) {
    if (rpm_hot <= 0) return rpm_cold;
    if (rpm_hot + rpm_cold <= 0) return pid_rpm_min;
    return (rpm_hot * rpm_hot + rpm_cold * rpm_cold) / (rpm_hot + rpm_cold);
}

/**
 * PID 输出 → 制冷强度 + 风扇转速（双路合并）
 */
static void pid_map_output(float output, int *out_cold, int *out_rpm) {
    int range = pid_cold_max - pid_cold_min;
    if (range <= 0) range = 1;
    int cold = pid_cold_min + (int)(output * range);
    if (cold < pid_cold_min) cold = pid_cold_min;
    if (cold > pid_cold_max) cold = pid_cold_max;

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
 * 与 apply_level 共享 last_* 去重缓存
 */
static void apply_level_direct(int mode, int target,
                               int rpm, int cold, int wl) {
    // 制冷强度限速
    rate_limit(&actual_cold, cold, RATE_LIMIT_COLD, RATE_LIMIT_COLD);

    // 风扇转速限速（升降独立速率）
    rate_limit(&actual_rpm, rpm, RATE_LIMIT_RPM_UP, RATE_LIMIT_RPM_DOWN);

    // ---- 去重检测（用限速后的 actual_* 值）----
    if (last_sent_valid &&
        mode == last_mode && actual_rpm == last_windOC &&
        actual_cold == last_coldOC && wl == last_windLevel)
        return;

    send_am_broadcast(mode, target, actual_rpm, actual_cold, wl);

    pid_log("apply mode=%d windOC=%d coldOC=%d", mode, actual_rpm, actual_cold);

    last_sent_valid  = 1;
    last_mode        = mode;
    last_target_temp = target;
    last_windOC      = actual_rpm;
    last_coldOC      = actual_cold;
    last_windLevel   = wl;

    save_cold(actual_cold);
}

/**
 * CTRL_MODE 0→1 热切换时对齐 PID 初始值
 * 从当前 gear 状态映射到 PID 输出空间
 */
static void pid_align_from_gear(void) {
    float ratio = (float)(battery_fan_level - level_min) /
                  (level_max - level_min);
    pid_output_smoothed = ratio;
    pid_target_rpm  = pid_rpm_min + (int)(ratio * (pid_rpm_max - pid_rpm_min));
    pid_target_cold = pid_cold_min + (int)(ratio * (pid_cold_max - pid_cold_min));
    pid_integral        = 0;
    pid_prev_error      = 0;
    pid_batt_filtered   = -1;
    pid_last_batt       = -1;
    pid_last_change_time = 0;
    pid_cpu_comp_smooth  = 0.0f;
    pid_curr_comp_smooth = 0.0f;
    pid_last_comp_10     = 0;
    last_sent_valid     = 0;
    write_log("PID 从 gear 对齐 ratio=%.2f cold=%d", ratio, pid_target_cold);
}

// ======================== 主循环 ========================

static void handle_signal(int sig) {
    (void)sig;
    running = 0;
}

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
        pid_batt_filtered   = -1;
        pid_last_batt       = -1;
        pid_integral        = 0;
        pid_prev_error      = 0;
        pid_last_change_time = 0;
        pid_cpu_comp_smooth  = 0.0f;
        pid_curr_comp_smooth = 0.0f;
        pid_last_comp_10     = 0;
        pid_output_smoothed = 0.0f;
        actual_rpm = -1;
        actual_cold = -1;
        actual_target_temp = -1;
        write_log("重连 PID 状态已重置");
        last_batt_reading = -1;
        first_run = 1;
        return;
    }

    // ═══ gear 模式：保留现有逻辑 ═══
    debug_log(debug_conn, "reconnect_align actual_rpm=%d actual_cold=%d", actual_rpm, actual_cold);
    if (actual_rpm >= 0 && actual_cold >= 0) {
        int idx = match_nearest_gear_for_reconnect();
        debug_log(debug_conn, "reconnect_align match idx=%d target_level=%d", idx, target_level);
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

/**
 * 单次控制循环（纯计算，不下发）
 * 配置重载 → 紧急干预（CPU+电流综合等级）→ 电池控制 → 保存目标档位
 * 调用者在外部立即执行速率限制下发，本函数只做决策
 */
static int prev_emerg_level = 0;   // 记录上一轮紧急等级，退出紧急时用作档位上限

/**
 * 按当前模式分发执行（限速统一下沉到 apply_level / apply_level_direct 内部）
 * PID 模式：传 pid_target_* → apply_level_direct 内部限速
 * Gear 模式：apply_level 内部限速
 */
static void rate_limited_execute(void) {
    // ═══ PID 模式 ═══
    if (ctrl_mode == 1) {
        // 限速已内建到 apply_level_direct，此处只管传目标值
        apply_level_direct(1, 5, pid_target_rpm, pid_target_cold, 0);
        return;
    }

    // ═══ Gear 模式：限速已内建到 apply_level ═══
    apply_level(target_level);
}

static void main_loop(void) {
    // 0. 检查配置文件是否更新（热重载）
    debug_log(debug_main, "main_loop 开始 emergency=%d forced_min=%d battery_fan=%d target=%d",
              emergency_level, forced_min_level, battery_fan_level, target_level);
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

    // ═══ PID 模式：跳过档位/紧急逻辑，直接 PID 计算 ═══
    if (ctrl_mode == 1) {
        // 读电池温度
        int batt_raw = read_battery_temp();
        if (batt_raw < 0) return;

        // 输入 EMA 滤波（新值权重语义：alpha=新值占比）
        if (pid_batt_filtered < 0) {
            pid_batt_filtered = batt_raw;
        } else {
            pid_batt_filtered = EMA(batt_raw, pid_batt_filtered, pid_batt_alpha);
        }

        // ═══ CPU 温度读入与滤波（用于补偿，无紧急逻辑） ═══
        int cpu_now = read_cpu_temp_max();
        if (cpu_now >= 0) {
            if (first_run) {
                cpu_weighted = cpu_now;
                first_run = 0;
            } else {
                cpu_weighted = EMA(cpu_now, cpu_weighted, CPU_FILTER_ALPHA);
            }
        }

        // ═══ 补偿值计算（每周期更新，不受电池温度变化限制） ═══
        float cpu_comp = 0.0f, curr_comp = 0.0f;

        if (pid_cpu_comp_enabled && cpu_weighted >= 0) {
            float raw = (float)(cpu_weighted - batt_raw) / (pid_cpu_comp_divisor * 10);
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

        // 温度或补偿变化时才执行 PID（首次 pid_last_batt<0 也会进入）
        if (batt_raw != pid_last_batt || total_comp_10 != pid_last_comp_10) {
            time_t now = time(NULL);
            float dt = (float)(now - pid_last_change_time);
            if (dt > 30.0f) dt = 30.0f;
            if (dt < 3.0f)  dt = 3.0f;

            // 方案 A：补偿加到 PID 输入温度
            int compensated_10 = pid_batt_filtered + total_comp_10;
            float pid_out = pid_compute(compensated_10, dt);

            // 输出 EMA 平滑（首次直接赋初值）
            if (pid_output_smoothed < 0.001f && pid_last_batt < 0) {
                pid_output_smoothed = pid_out;
            } else {
                pid_output_smoothed = (pid_output_alpha * pid_out +
                                       (100 - pid_output_alpha) * pid_output_smoothed) / 100.0f;
            }

            // 映射到物理值
            pid_map_output(pid_output_smoothed,
                           &pid_target_cold, &pid_target_rpm);

            write_log("[PID] epoch=%ld Tbatt=%d+comp%+.1f(cpu%+.1f+curr%+.1f)=Tinp%d Ttgt=%d Thot=%d dt=%.0fs e=%.2f raw=%.2f sm=%.2f cold=%d rpm=%d",
                     now, pid_batt_filtered, total_comp, cpu_comp, curr_comp,
                     compensated_10, BATT_BASELINE, cooler_hot_temp,
                     dt, (compensated_10 - BATT_BASELINE) / 10.0f,
                     pid_out, pid_output_smoothed, pid_target_cold, pid_target_rpm);

            pid_last_batt = batt_raw;
            pid_last_comp_10 = total_comp_10;
            pid_last_change_time = now;
        }

        return;  // PID 模式不执行后续档位逻辑
    }

    // ═══ 以下为现有 gear 模式逻辑（原封不动） ═══
    // 1. 紧急干预（CPU 温度 + 电池电流，更新 emergency_level）
    prev_emerg_level = emergency_level;
    emergency_intervention();

    // 重新进入紧急 → 取消恢复期（立即恢复全灵敏度以快速响应）
    if (emergency_level > prev_emerg_level) {
        batt_recovery_multiplier = 1;
        batt_recovery_cycles = 0;
        recovery_step = 0;
        // 清除趋势豁免/反补累积，防止紧急期间脏状态影响后续逻辑
        reset_exempt_state();
    }

    // 退出紧急 → 启动恢复期，清除趋势豁免/反补累积
    if (emergency_level < prev_emerg_level) {
        recovery_step = 1;
        batt_recovery_multiplier = BATT_RECOVERY_M1;
        batt_recovery_cycles = BATT_RECOVERY_PHASE_CYCLES;
        reset_exempt_state();
    }

    // 2. 电池温度控制 / 电流-挡位映射模式
    // 先尝试电流-挡位模式（返回 1 表示已覆盖挡位），未覆盖则回退到常规温度控制
    if (!current_gear_override()) {
        battery_control();
    }

    // 3. 计算最终档位 = max(电池基础档位, 紧急强制最低档位)
    int final_level = battery_fan_level;
    if (forced_min_level > final_level) final_level = forced_min_level;
    final_level = clamp(final_level, level_min, level_max);

    // 4. 同步逻辑跟踪值（供下轮控制计算基础），不下发
    battery_fan_level = final_level;

    // 5. 保存为目标档位（供下轮逐步执行使用）
    target_level = final_level;

    // 6. 退出紧急时限制档位（过渡期保护，仅生效一周期，受电池温度约束）
    //    电池温度低于基准+EMERG_EXIT_BATT_THRESHOLD → 全效退出
    //    低于基准+EMERG_EXIT_BATT_THRESHOLD×2 → 半效退出
    //    否则 → 不退出（保持当前档位）
    //    注意：恢复期启动已在步骤 1 中完成，此处只做 cap/drop
    if (emergency_level < prev_emerg_level) {
        int batt_temp = read_battery_temp();
        int exit_mode = 2;  // 0=不退出, 1=半效, 2=全效
        if (batt_temp >= 0) {
            int t1 = BATT_BASELINE + EMERG_EXIT_BATT_THRESHOLD;
            int t2 = BATT_BASELINE + EMERG_EXIT_BATT_THRESHOLD * 2;
            if (batt_temp < t1) {
                exit_mode = 2;  // 全效
            } else if (batt_temp < t2) {
                exit_mode = 1;  // 半效
            } else {
                exit_mode = 0;  // 不退出
            }
        } // batt_temp<0 → 传感器异常，默认全效退出(安全)

        if (exit_mode >= 1) {
            if (EMERG_MODE_EXIT == 0) {
                // 模式 0：钳制最高档
                int cap;
                if      (prev_emerg_level >= 4) cap = EMERG_FORCED_4;
                else if (prev_emerg_level >= 3) cap = EMERG_FORCED_3;
                else if (prev_emerg_level >= 2) cap = EMERG_FORCED_2;
                else                             cap = EMERG_FORCED_1;
                cap += EMERG_EXIT_CAP_OFFSET;
                if (cap > level_max) cap = level_max;
                if (battery_fan_level > cap) {
                    if (exit_mode >= 2) {
                        battery_fan_level = cap;
                    } else {
                        // 半效：只降低实际档位与 cap 差值的一半
                        int reduction = battery_fan_level - cap;
                        battery_fan_level -= reduction / 2;
                    }
                }
            } else {
                // 模式 1：降档模式 — 直接减去 EMERG_STEP（全效）或一半（半效）
                int step = (exit_mode >= 2) ? EMERG_STEP : (EMERG_STEP / 2);
                if (step < 1) step = 1;
                if (battery_fan_level > step)
                    battery_fan_level -= step;
                else
                    battery_fan_level = level_min;
            }
            // 同步 target_level，避免逐步执行向已被压低的档位上方移动
            if (target_level > battery_fan_level)
                target_level = battery_fan_level;
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

    // 防御：target_level 越界时回退到 level_min
    int safe_level = target_level;
    if (safe_level < level_min || safe_level > level_max)
        safe_level = level_min;

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

    // --- 初始化制冷强度（继承上次制冷强度，无存档直接找默认挡位） ---
    int stored_cold = load_cold();
    if (stored_cold >= 1) {
        if (ctrl_mode == 1) {
            // PID 模式：从制冷强度直接对齐初始值
            float ratio = (float)(stored_cold - pid_cold_min) /
                          (pid_cold_max - pid_cold_min);
            if (ratio < 0.0f) ratio = 0.0f;
            if (ratio > 1.0f) ratio = 1.0f;
            pid_output_smoothed = ratio;
            pid_target_cold     = stored_cold;
            pid_target_rpm      = pid_rpm_min + (int)(ratio * (pid_rpm_max - pid_rpm_min));
            pid_integral        = 0;
            pid_prev_error      = 0;
            pid_batt_filtered   = -1;
            pid_last_batt       = -1;
            pid_cpu_comp_smooth  = 0.0f;
            pid_curr_comp_smooth = 0.0f;
            pid_last_comp_10     = 0;
            battery_fan_level   = (int)(ratio * (level_max - level_min) + level_min + 0.5f);
            if (battery_fan_level < level_min) battery_fan_level = level_min;
            if (battery_fan_level > level_max) battery_fan_level = level_max;
            write_log("存档 恢复制冷=%d ratio=%.2f rpm=%d",
                      stored_cold, ratio, pid_target_rpm);
        } else {
            // Gear 模式：找冷强度最接近的挡位
            int nearest = LEVEL_INIT;
            int min_diff = 9999;
            for (int i = 0; i < gear_count; i++) {
                int diff = abs(gear_table[i].cold - stored_cold);
                if (diff < min_diff) {
                    min_diff = diff;
                    nearest = i + 1;
                }
            }
            battery_fan_level = nearest;
            write_log("存档 制冷强度%d→挡位%d", stored_cold, nearest);
        }
    } else {
        // 无存档：使用默认初始挡位
        battery_fan_level = LEVEL_INIT;
        if (ctrl_mode == 1) {
            pid_align_from_gear();
        }
    }
    batt_cooldown = 0;
    target_level = battery_fan_level;

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

    // --- 进入工作模式 ---
    app_was_alive = 1;
    batt_cooldown = 0;
    emergency_level = 0;
    forced_min_level = 0;
    first_run = 1;
    last_batt_reading = -1;     // 重置电池温度跟踪，使首次 battery_control 视作新读数

    // 强制首次下发
    last_sent_valid = 0;
    apply_level(battery_fan_level);

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
                    last_sent_valid = 0;
                    reconnect_align();
                    break;
                }
            }
            continue;   // 跳过本轮 main_loop，下一轮再开始控制
        } else if (!app_was_alive) {
            app_was_alive = 1;
            last_sent_valid = 0;
            reconnect_align();
        }

        main_loop();

        // ★ 速率限制执行（替代逐档变动 + RPM 平滑跟踪）
        // 每周期最多变动 RATE_LIMIT_RPM_UP(RPM升)/RATE_LIMIT_RPM_DOWN(RPM降)/RATE_LIMIT_COLD/
        // RATE_LIMIT_TEMP °C 目标温度，未完成部分自然累积到下周期
        // 目标档位变化时自动从当前实际值重新计算差值
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
