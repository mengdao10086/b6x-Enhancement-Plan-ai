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
//   NDK 编译命令：aarch64-linux-android21-clang -static -O2
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

// ======================== 档位定义 ========================
//
// ⚠️ 不推荐使用智能温控模式（mode=0）：实测其风扇转速配置疑似并非强制生效，经常突破设定的上限，尤其在刚切换过去的瞬间。这会导致噪音突然变大，体验较差。全部固定功率模式的档位表已避免此问题。
//
//setRunMode(mode, targetTemperature,windLevelOverclock, coldLevelOverclock,windLevel, modeCustom, extra)
//
// 参数映射：mode=0（智能温控）：targetTemperature, windLevel(风扇转速上限)
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
} GearEntry;

static GearEntry gear_table[GEAR_TABLE_MAX];
static int gear_count = 0;     // 实际档位数，0=尚未初始化
static int level_min = 1;
static int level_max = 10;     // 默认 10 档（由 init_gear_table 设定）

// 默认档位表（依实测散热曲线标定，全部固定功率模式）
// 格式：GEAR_<档位N>=<模式>,<目标温度°C>,<风扇RPM>,<制冷强度>
// 范围：N=1~32, 模式=0(智能)或1(固定), 目标=5~35°C, 风扇=2000~6000, 制冷=1~194
// 注意：模式 0 时制冷强度失效（散热器自行管理），模式 1 时目标温度无效
// 例：GEAR_12=1,0,6000,185 表示 12 档固定功率，6000RPM，制冷 185
//     GEAR_5=0,16,2650,0   表示  5 档智能温控，16°C，风扇上限 2650RPM
static const GearEntry DEFAULT_GEAR_TABLE[12] = {
    {1, 0, 2000,  5},    // Level 1   α待机
    {1, 0, 2000, 10},    // Level 2
    {1, 0, 2000, 20},    // Level 3
    {1, 0, 2300, 35},    // Level 4
    {1, 0, 2650, 55},    // Level 5   LEVEL_INIT
    {1, 0, 3050, 75},    // Level 6
    {1, 0, 3500, 100},   // Level 7
    {1, 0, 4000, 125},   // Level 8
    {1, 0, 4500, 145},   // Level 9
    {1, 0, 5000, 160},   // Level 10
    {1, 0, 5500, 175},   // Level 11
    {1, 0, 6000, 185},   // Level 12 制冷峰值
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

// --- 制冷片强度范围 ---
#define COLD_MIN             1
#define COLD_MAX           194     // 最大有效值（以上需超频模式，本场景不用）

// --- 电池温度控制（0.1°C）—— 可由 profile.conf 覆盖 ---
static int BATT_BASELINE = 350;     // 基准温度 35.0°C
static int BATT_ZONE_1   = 7;       // ±0.7°C → 不变（死区）
static int BATT_ZONE_2   = 20;      // ±2.0°C → 1 档（超过→2档）

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
static int EMERG_FORCED_3 = 10;  // 等级 3 强制最低档位（固定功率 5000RPM/160）
static int EMERG_FORCED_4 = 12;  // 等级 4 强制最低档位（固定功率 6000RPM/185 峰值）

// --- 紧急退出钳制偏移（退出时高一级强制档位 + 此偏移作为档位上限）---
static int EMERG_EXIT_CAP_OFFSET = 1;

// --- CPU 滤波系数（百分比，0~100，默认 20=α=0.20）---
static int CPU_FILTER_ALPHA = 20;

// --- 趋势豁免上限（可配置）---
// 温度趋势反向时最多连续豁免次数，超过后强制执行
static int OVERRIDE_MAX = 6;

// --- 反补阈值（由 battery_control 根据方向+区域查表使用）---
// 原 PEAK_DAMP_INNER_BOUNDARY/THRESHOLD/OUTER_THRESHOLD 已移除，
// 改为 Sheet3 三区×双向×三级阈值查表法，详见 battery_control。

// --- 电池调档冷却周期数（可配置）---
// 每次电池温度导致的档位变动后冻结多少周期（×5s），期内跳过常规升降档
static int BATT_COOLDOWN_CYCLES = 3;

// --- 温度不变最大跳过次数（可配置）---
// 电池温度连续不变时最多跳过多少次 battery_control，之后强制进入
static int BATT_SKIP_MAX = 6;

// --- 状态文件超时（秒，可配置）---
static int STATUS_TIMEOUT = 16;

// --- 电池电流紧急干预阈值（µA，可配置）---
// 通过 /sys/class/power_supply/battery/current_now 读取，取绝对值
static int CURRENT_EMERG_3 = 7000000;   // >7A → 等级 3
static int CURRENT_EMERG_2 = 6000000;   // >6A → 等级 2
static int CURRENT_EMERG_1 = 5000000;   // >5A → 等级 1
static int CURRENT_RECOVER_2 = 6000000; // <6A → 从 3 降为 2
static int CURRENT_RECOVER_1 = 5000000; // <5A → 从 2 降为 1
static int CURRENT_RECOVER_0 = 4000000; // <4A → 清除

// --- 电流紧急退出平滑系数（百分比，可配置）---
// 进入紧急时电流用原始值不平滑；退出时使用 EMA 平滑值
// 升档（紧急等级提高）时重置平滑，从当前值重新累积
static int CURRENT_SMOOTH_ALPHA = 25;   // 默认 α=0.25

// --- 逐档提升启动档位（可配置）---
// ≤此档位时：可直接跳到目标档位（不逐级变动）
// >此档位时：每轮最多 ±1 档，压制噪音突变
static int GRADUAL_STEP_THRESHOLD = 5;


// --- 日志路径（默认根据二进制名自动生成，可由 profile.conf 覆盖）---
static char log_file_path[256] = "";
static int LOG_MAX_KB = 10;          // 日志文件大小上限（KB），0=关闭日志
static FILE *log_fp = NULL;          // 持久的日志文件指针，避免每行都 fopen/fclose
static char log_path_opened[256] = ""; // 已打开的文件路径（检测路径变化）

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
static int last_batt_reading = -1;     // 上次读取的电池温度（变化检测 + 趋势判断）
static int batt_unchanged_count = 0;   // 温度连续不变跳过次数（≥BATT_SKIP_MAX 时强制进入）
static int trend_override = 0;         // 趋势豁免计数器（最多 OVERRIDE_MAX 次）
static int first_run = 1;              // 首次运行，滤波直接赋初值
static volatile int running = 1;       // 信号控制标记

// --- 逐步执行状态 ---
static int actual_level = LEVEL_INIT;   // 散热器实际运行的档位（逐级变动）
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

// 前向声明（配置系统函数位于 write_log/clamp 之前，C 要求先声明后使用）
static void write_log(const char *fmt, ...);
static inline int clamp(int val, int lo, int hi);
static void alarm_handler(int sig);

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

    // ---- 第一遍扫描：收集开关状态 ----
    // CONFIG_ENABLED / GEAR_CONFIG_ENABLED / GEAR_N 存在性一次性检测
    char line[256];
    int enabled = 1;
    int gear_config_enabled = 0;
    int gear_any_seen = 0;
    while (fgets(line, sizeof(line), f)) {
        char *key;
        char *val_str = config_parse_line(line, &key);
        if (!val_str) continue;

        if (strcmp(key, "CONFIG_ENABLED") == 0)
            enabled = atoi(val_str) != 0;
        else if (strcmp(key, "GEAR_CONFIG_ENABLED") == 0)
            gear_config_enabled = atoi(val_str) != 0;
        else if (strncmp(key, "GEAR_", 5) == 0)
            gear_any_seen = 1;
    }

    if (!enabled) {
        fclose(f);
        write_log("配置 已禁用，使用默认参数");
        return;
    }

    // GEAR_CONFIG_ENABLED 关闭时忽略 GEAR_N，即使文件中有
    int gear_config_seen = gear_config_enabled && gear_any_seen;

    // 有 GEAR_N → 清空档位表，后续只从配置读取
    if (gear_config_seen) {
        gear_count = 0;
        level_max = 0;
        memset(gear_table, 0, sizeof(gear_table));
        write_log("配置 档位表将由 GEAR_N 定义");
    }

    // ---- 第二遍扫描：解析全部参数 ----
    rewind(f);
    int loaded = 0;
    while (fgets(line, sizeof(line), f)) {
        char *key;
        char *val_str = config_parse_line(line, &key);
        if (!val_str) continue;

        int val = atoi(val_str);

        // ---- 匹配 key ----
        if      (strcmp(key, "BATT_BASELINE") == 0)        BATT_BASELINE      = clamp(val, 300, 500);
        else if (strcmp(key, "BATT_ZONE_1") == 0)          BATT_ZONE_1        = clamp(val, 1, 100);
        else if (strcmp(key, "BATT_ZONE_2") == 0)          BATT_ZONE_2        = clamp(val, 1, 100);
        else if (strcmp(key, "CPU_EMERG_3") == 0)          CPU_EMERG_3        = clamp(val, 600, 1000);
        else if (strcmp(key, "CPU_EMERG_2") == 0)          CPU_EMERG_2        = clamp(val, 500, 900);
        else if (strcmp(key, "CPU_EMERG_1") == 0)          CPU_EMERG_1        = clamp(val, 400, 800);
        else if (strcmp(key, "CPU_RECOVER_0") == 0)        CPU_RECOVER_0      = clamp(val, 300, 700);
        else if (strcmp(key, "CPU_RECOVER_1") == 0)        CPU_RECOVER_1      = clamp(val, 400, 800);
        else if (strcmp(key, "CPU_RECOVER_2") == 0)        CPU_RECOVER_2      = clamp(val, 500, 900);
        else if (strcmp(key, "EMERG_FORCED_1") == 0)       EMERG_FORCED_1     = clamp(val, 0, 12);
        else if (strcmp(key, "EMERG_FORCED_2") == 0)       EMERG_FORCED_2     = clamp(val, 0, 12);
        else if (strcmp(key, "EMERG_FORCED_3") == 0)       EMERG_FORCED_3     = clamp(val, 0, 12);
        else if (strcmp(key, "EMERG_FORCED_4") == 0)       EMERG_FORCED_4     = clamp(val, 0, 12);
        else if (strcmp(key, "CPU_FILTER_ALPHA") == 0)     CPU_FILTER_ALPHA   = clamp(val, 1, 100);
        else if (strcmp(key, "OVERRIDE_MAX") == 0)         OVERRIDE_MAX       = clamp(val, 0, 20);
        // PEAK_DAMP_* 已移除（v2.1 改为 Sheet3 查表法）
        else if (strcmp(key, "BATT_COOLDOWN_CYCLES") == 0) BATT_COOLDOWN_CYCLES = clamp(val, 0, 20);
        else if (strcmp(key, "BATT_SKIP_MAX") == 0)        BATT_SKIP_MAX        = clamp(val, 0, 30);
        else if (strcmp(key, "STATUS_TIMEOUT") == 0)       STATUS_TIMEOUT     = clamp(val, 5, 60);
        else if (strcmp(key, "CPU_ZONE_MIN") == 0)          CPU_ZONE_MIN       = clamp(val, 0, 99);
        else if (strcmp(key, "CPU_ZONE_MAX") == 0)          CPU_ZONE_MAX       = clamp(val, 0, 99);
        else if (strcmp(key, "CURRENT_EMERG_3") == 0)       CURRENT_EMERG_3    = clamp(val, 1000000, 15000000);
        else if (strcmp(key, "CURRENT_EMERG_2") == 0)       CURRENT_EMERG_2    = clamp(val, 1000000, 15000000);
        else if (strcmp(key, "CURRENT_EMERG_1") == 0)       CURRENT_EMERG_1    = clamp(val, 1000000, 15000000);
        else if (strcmp(key, "CURRENT_RECOVER_2") == 0)     CURRENT_RECOVER_2  = clamp(val, 1000000, 15000000);
        else if (strcmp(key, "CURRENT_RECOVER_1") == 0)     CURRENT_RECOVER_1  = clamp(val, 1000000, 15000000);
        else if (strcmp(key, "CURRENT_RECOVER_0") == 0)     CURRENT_RECOVER_0  = clamp(val, 1000000, 15000000);
        else if (strcmp(key, "CURRENT_SMOOTH_ALPHA") == 0)  CURRENT_SMOOTH_ALPHA = clamp(val, 1, 100);
        else if (strcmp(key, "GRADUAL_STEP_THRESHOLD") == 0) GRADUAL_STEP_THRESHOLD = clamp(val, 0, 10);
        else if (strcmp(key, "EMERG_EXIT_CAP_OFFSET") == 0) EMERG_EXIT_CAP_OFFSET = clamp(val, 0, 5);
        else if (strcmp(key, "GEAR_CONFIG_ENABLED") == 0) { /* 预检已处理 */ }
        else if (strcmp(key, "LOG_MAX_KB") == 0)           LOG_MAX_KB         = clamp(val, 0, 1000);
        else if (strcmp(key, "LOG_FILE") == 0) {
            char *v = val_str;
            while (*v == ' ' || *v == '\t') v++;
            char *nl = v + strlen(v) - 1;
            while (nl > v && (*nl == '\n' || *nl == '\r' || *nl == ' ' || *nl == '\t')) *nl-- = '\0';
            if (*v) {
                strncpy(log_file_path, v, sizeof(log_file_path) - 1);
                log_file_path[sizeof(log_file_path) - 1] = '\0';
            }
        }
        else if (strncmp(key, "GEAR_", 5) == 0) {
            // GEAR_N=模式,目标温度(°C),风扇转速(RPM),制冷片强度
            int n = atoi(key + 5);
            if (n < 1 || n > GEAR_TABLE_MAX || !gear_config_seen) continue;

            int m, t, f, c;
            char *next;
            m = (int)strtol(val_str, &next, 10);
            if (*next != ',') continue;
            t = (int)strtol(next + 1, &next, 10);
            if (*next != ',') continue;
            f = (int)strtol(next + 1, &next, 10);
            if (*next != ',') continue;
            c = (int)strtol(next + 1, NULL, 10);

            gear_table[n - 1].mode   = (m == 0) ? 0 : 1;
            gear_table[n - 1].target = clamp(t, 0, 35);
            gear_table[n - 1].fan_rpm = clamp(f, 0, 99999);
            gear_table[n - 1].cold   = clamp(c, 0, 194);
            if (n > gear_count) gear_count = n;
        }
        else { continue; }

        loaded++;
    }
    fclose(f);

    // ---- GEAR_N 后处理：同步档位范围，钳制当前档位 ----
    if (gear_config_seen) {
        if (gear_count > 0) {
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
 * 写入日志（自动滚动：超上限后删除最早 1~2 行）
 * 日期格式：日+时间，无年月（例 "14 22:30:16"）
 * LOG_MAX_KB=0 时关闭日志
 *
 * 持有一个持久 FILE*，避免每行日志都 syscall open/close
 * 路径变化（热重载 LOG_FILE）时自动重开
 */
static void write_log(const char *fmt, ...) {
    if (LOG_MAX_KB == 0) return;     // 日志关闭

    int max_bytes = LOG_MAX_KB * 1024;

    // 超标 → 滚动：先关 log_fp，再读-删-写，下次自动重开
    struct stat st;
    if (stat(log_file_path, &st) == 0 && st.st_size > max_bytes) {
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

static inline int clamp(int val, int lo, int hi) {
    if (val < lo) return lo;
    if (val > hi) return hi;
    return val;
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
            app_ble_connected = val ? 1 : 0;
        }
    }
    fclose(f);
}

// ======================== 档位存档（持久化上次档位） ========================

/**
 * 设定齿轮存档路径（根据 /proc/self/exe 推导）
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
 * 保存档位到存档文件
 */
static void save_gear(int level) {
    FILE *f = fopen(gear_file_path, "w");
    if (f) {
        fprintf(f, "%d\n", level);
        fclose(f);
    }
}

/**
 * 读取存档档位，失败返回 LEVEL_INIT
 */
static int load_gear(void) {
    FILE *f = fopen(gear_file_path, "r");
    if (!f) return LEVEL_INIT;
    int val = LEVEL_INIT;
    fscanf(f, "%d", &val);
    fclose(f);
    if (val < level_min || val > level_max) return LEVEL_INIT;
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
    char path[64];
    snprintf(path, sizeof(path), "/sys/class/thermal/thermal_zone%d/temp", zone_id);
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
    return read_sysfs_int("/sys/class/power_supply/battery/temp");
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
    }

    // 后续调用 → 只扫描已保留的 zone
    int max_temp = -1;
    for (int j = 0; j < cpu_zone_count; j++) {
        int raw = read_thermal_zone_raw(cpu_zone_cache[j]);
        if (raw < 0) continue;

        int decic = raw / 100;
        if (decic > max_temp) max_temp = decic;
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
    FILE *f = fopen("/sys/class/power_supply/battery/current_now", "r");
    if (!f) return -1;
    int val;
    if (fscanf(f, "%d", &val) != 1) {
        fclose(f);
        return -1;
    }
    fclose(f);
    return (val >= 0) ? val : -val;
}

// ======================== 控制参数计算与下发 ========================

/**
 * 根据档位计算 setRunMode 的各参数
 *
 * 使用查表法，因为档位与风扇转速、目标温度之间不是线性关系。
 *
 * 智能温控模式（mode=0）：
 *   targetTemperature = 查表目标温度
 *   windLevel = 查表风扇转速上限 (RPM)
 *   windLevelOverclock / coldLevelOverclock = 0（此模式下不用）
 *
 * 固定功率模式（mode=1）：
 *   windLevelOverclock = 查表风扇固定转速 (RPM)
 *   coldLevelOverclock = 查表制冷片强度
 *   targetTemperature = 5°C（表值为 0，clamp(5,35) 后为 5，固件模式忽略此值）
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

    // ---- 去重检测 ----
    if (last_sent_valid &&
        mode      == last_mode &&
        target    == last_target_temp &&
        windOC    == last_windOC &&
        coldOC    == last_coldOC &&
        windLevel == last_windLevel)
    {
        return 0;   // 无变化，跳过
    }

    // ---- 直接执行 am（fork+execvp 避开 shell 进程） ----
    char m_s[12], t_s[12], woc_s[12], coc_s[12], wl_s[12];
    snprintf(m_s, sizeof(m_s), "%d", mode);
    snprintf(t_s, sizeof(t_s), "%d", target);
    snprintf(woc_s, sizeof(woc_s), "%d", windOC);
    snprintf(coc_s, sizeof(coc_s), "%d", coldOC);
    snprintf(wl_s, sizeof(wl_s), "%d", windLevel);

    pid_t pid = fork();
    if (pid < 0) {
        // fork 失败（系统资源不足），跳过本周期
        write_log("fork 失败，跳过下发");
        return 0;
    }
    if (pid == 0) {
        // 子进程：静默执行，stdout/stderr 重定向到 /dev/null
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
        _exit(127);  // 到达这里说明 exec 失败
    }
    if (pid > 0) {
        // 父进程：限时等待子进程（3 秒超时，防止 am 卡死阻塞 daemon）
        signal(SIGALRM, alarm_handler);
        alarm(3);
        int status;
        if (waitpid(pid, &status, 0) == -1) {
            write_log("am broadcast 超时，已强杀");
            kill(pid, SIGKILL);
            waitpid(pid, NULL, 0);  // 回收僵尸
        }
        alarm(0);
        signal(SIGALRM, SIG_DFL);
    }

    // ---- 更新缓存 ----
    last_sent_valid    = 1;
    last_mode          = mode;
    last_target_temp   = target;
    last_windOC        = windOC;
    last_coldOC        = coldOC;
    last_windLevel     = windLevel;

    // 每次下发成功后保存档位（用于下次启动时继承）
    save_gear(level);

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
    return (now - st.st_mtime <= STATUS_TIMEOUT) ? 1 : 0;
}

// ======================== 电池温度控制 ========================

/**
 * 根据电池温度调整基础档位
 * 每 5 秒调用一次
 *
 * 调整策略（基准温度 35.0°C）：
 *   偏差 ≤0.7°C  → 不变（死区）
 *   偏差 0.7~2°C → ±1 档
 *   偏差 >2°C    → ±2 档
 *
 * 温度读数未变化时跳过升降档。
 * 每次档位变动后启动 BATT_COOLDOWN_CYCLES 周期冷却，期间跳过常规升降档。
 *
 * 反补查表（Sheet3 三区×双向×三级阈值）：
 *   三区：冷外区(≤基准-ZONE2) / 内区(±ZONE2内) / 热外区(≥基准+ZONE2)
 *   升温时：冷外 0.8→1 / 内区 0.5→1, 0.8→2 / 热外 0.3→1, 0.5→2, 0.8→3
 *   降温时：冷外 0.3→1, 0.5→2, 0.8→3 / 内区 0.5→1, 0.8→2 / 热外 0.8→1
 */
static void battery_control(void) {
    int batt = read_battery_temp();
    if (batt < 0) return;

    // 计算本周期温度变化量和常规升降档量（先算，给跳过逻辑参考）
    int batt_change = 0, abs_change = 0;
    if (last_batt_reading >= 0) {
        batt_change = batt - last_batt_reading;
        abs_change = abs(batt_change);
    }
    int diff = batt - BATT_BASELINE;
    int ad = abs(diff);
    int sign;
    if      (diff > 0) sign =  1;
    else if (diff < 0) sign = -1;
    else               sign =  0;
    int delta = 0;
    if      (ad > BATT_ZONE_2) delta = 2;
    else if (ad > BATT_ZONE_1) delta = 1;
    delta *= sign;

    // 温度值与上次调整时相同 → 计数跳过，超过 BATT_SKIP_MAX 次后强制进入
    if (batt == last_batt_reading) {
        if (++batt_unchanged_count < BATT_SKIP_MAX) return;
        batt_unchanged_count = 0;
        // 温度没变时 delta 已在上次执行过，清零防齿轮漂移
        delta = 0;
        abs_change = 0;
        batt_change = 0;
    } else {
        batt_unchanged_count = 0;
    }

    int skip_delta = 0;  // =1 时本次不执行常规升降档

    // 冷却递减（放在 abs_change 判断之前，温度不变强制进入时也能递减）
    int in_cooldown = (batt_cooldown > 0);
    if (in_cooldown) {
        batt_cooldown--;
        skip_delta = 1;
    }

    // ═══════════════ 反补查表（Sheet3 三区×双向×三级阈值） ═══════════════
    if (last_batt_reading >= 0 && abs_change > 0) {
        int trend_rev = (delta > 0 && batt < last_batt_reading) ||
                        (delta < 0 && batt > last_batt_reading);
        int dir = (batt_change > 0) ? 1 : -1;  // +1=升温, -1=降温

        // 三区判断：冷外区 / 内区 / 热外区
        int is_cold_outer = (batt <= BATT_BASELINE - BATT_ZONE_2);
        int is_hot_outer  = (batt >= BATT_BASELINE + BATT_ZONE_2);
        int in_inner_zone = !is_cold_outer && !is_hot_outer;

        // 根据方向+区域查三级阈值（0.1°C 单位，999=无穷大）
        int t1 = 999, t2 = 999, t3 = 999;  // 分别对应 +1/+2/+3 档的 ∆T 门槛
        if (dir > 0) {    // ═══ 升温 ═══
            if      (is_cold_outer) { t1 = 8; }                         // 0.8→1
            else if (in_inner_zone) { t1 = 5; t2 = 8; }                 // 0.5→1, 0.8→2
            else                   { t1 = 3; t2 = 5; t3 = 8; }          // 0.3→1, 0.5→2, 0.8→3
        } else {          // ═══ 降温 ═══
            if      (is_cold_outer) { t1 = 3; t2 = 5; t3 = 8; }         // 0.3→1, 0.5→2, 0.8→3
            else if (in_inner_zone) { t1 = 5; t2 = 8; }                 // 0.5→1, 0.8→2
            else                   { t1 = 8; }                          // 0.8→1
        }

        // ═══ 小变动（≤t1）→ 趋势豁免 ═══
        if (!in_cooldown && abs_change <= t1) {
            if (trend_rev && battery_fan_level > level_min &&
                battery_fan_level < level_max &&
                trend_override < OVERRIDE_MAX) {
                if (trend_override == 0)
                    write_log("趋势豁免 %d", battery_fan_level);
                trend_override++;
                skip_delta = 1;
            } else {
                trend_override = 0;
            }
        }

        // ═══ 大变动（>t1）→ 反补（冷却期也执行） ═══
        if (abs_change > t1) {
            trend_override = 0;

            // 跨越几个门槛就补几档
            int steps = (abs_change > t1) + (abs_change > t2) + (abs_change > t3);
            int adjust = dir * steps;

            if (adjust != 0) {
                int old = battery_fan_level;
                battery_fan_level += adjust;
                battery_fan_level = clamp(battery_fan_level, level_min, level_max);
                skip_delta = 1;
                if (old != battery_fan_level) {
                    batt_cooldown = BATT_COOLDOWN_CYCLES;
                    write_log("过冲%d.%d 挡位%d（%+d）",
                              abs_change / 10, abs_change % 10,
                              battery_fan_level, adjust);
                }
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
            write_log("挡位%d（%+d）", battery_fan_level, delta);
        }
    }

    // 更新温度记录
    last_batt_reading = batt;
}

// ======================== 紧急干预（CPU+电流双源） ========================

/**
 * 紧急干预（CPU 温度 + 电池电流双源）
 * 每 5 秒调用一次
 *
 * CPU 温度使用一阶低通滤波（α=CPU_FILTER_ALPHA）平滑
 * 电池电流：进入时用原始值（不平滑），退出时用 EMA 平滑值
 * 电流 EMA 平滑（α=CURRENT_SMOOTH_ALPHA）仅在紧急状态下累积，
 * 升档（紧急等级提高）时重置，降档时继续累积。
 *
 * 紧急等级 = cpu_level + current_level（各自 0~3，综合 0~6，上限 4）
 *   等级 1 → 强制最低档位 EMERG_FORCED_1（默认 6，固定 3050RPM/75）
 *   等级 2 → 强制最低档位 EMERG_FORCED_2（默认 8，固定 4000RPM/125）
 *   等级 3 → 强制最低档位 EMERG_FORCED_3（默认 10，固定 5000RPM/160）
 *   等级 4 → 强制最低档位 EMERG_FORCED_4（默认 12，固定 6000RPM/185）
 *   单源最高触发 3 级，4 级需双源叠加（≥3+1 或 2+2 等）
 *
 * 退出逻辑（AND）：降档时逐级检查双源恢复阈值后才允许下降，包括退出到 0
 */
static void emergency_intervention(void) {
    // --- 1. CPU 温度读入与滤波 ---
    int cpu_now = read_cpu_temp_max();
    if (cpu_now >= 0) {
        if (first_run) {
            cpu_weighted = cpu_now;
            first_run = 0;
        } else {
            cpu_weighted = (cpu_now * CPU_FILTER_ALPHA +
                            cpu_weighted * (100 - CPU_FILTER_ALPHA)) / 100;
        }
    }
    int t = cpu_weighted;
    int cpu_valid = (cpu_now >= 0);

    // --- 2. 电池电流绝对值 ---
    int cur_ua = read_battery_current_abs();
    int cur_valid = (cur_ua >= 0);

    int prev_level = emergency_level;
    int new_level = emergency_level;

    // === 3. 计算单源级别（各自 0~3，用进入阈值） ===
    int cpu_lvl = 0;
    if (cpu_valid) {
        if      (t > CPU_EMERG_3) cpu_lvl = 3;
        else if (t > CPU_EMERG_2) cpu_lvl = 2;
        else if (t > CPU_EMERG_1) cpu_lvl = 1;
    }
    int cur_lvl = 0;
    if (cur_valid) {
        // 进入时用原始电流值
        if      (cur_ua > CURRENT_EMERG_3) cur_lvl = 3;
        else if (cur_ua > CURRENT_EMERG_2) cur_lvl = 2;
        else if (cur_ua > CURRENT_EMERG_1) cur_lvl = 1;
    }

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
        int cpu_ok = 1;
        if (cpu_valid) {
            if      (emergency_level >= 3) cpu_ok = (t < CPU_RECOVER_2);
            else if (emergency_level >= 2) cpu_ok = (t < CPU_RECOVER_1);
            else                           cpu_ok = (t < CPU_RECOVER_0);
        }
        int cur_ok = 1;
        if (cur_valid) {
            int cur_exit = curr_smooth_valid ? curr_smooth_val : cur_ua;
            if      (emergency_level >= 3) cur_ok = (cur_exit < CURRENT_RECOVER_2);
            else if (emergency_level >= 2) cur_ok = (cur_exit < CURRENT_RECOVER_1);
            else                           cur_ok = (cur_exit < CURRENT_RECOVER_0);
        }
        if (cpu_ok && cur_ok) {
            new_level = emergency_level - 1;  // 逐级下降
        }
        // 至少一个未恢复 → 保持当前等级
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
            curr_smooth_val = (cur_ua * CURRENT_SMOOTH_ALPHA +
                               curr_smooth_val * (100 - CURRENT_SMOOTH_ALPHA)) / 100;
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

    // --- 7. 设定强制最低档位 ---
    switch (emergency_level) {
        case 4: forced_min_level = EMERG_FORCED_4; break;
        case 3: forced_min_level = EMERG_FORCED_3; break;
        case 2: forced_min_level = EMERG_FORCED_2; break;
        case 1: forced_min_level = EMERG_FORCED_1; break;
        default: forced_min_level = 0;             break;
    }
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
 * 单次控制循环（纯计算，不下发）
 * 配置重载 → 紧急干预（CPU+电流综合等级）→ 电池控制 → 保存目标档位
 * 调用者在外部立即执行逐步变档，本函数只做决策
 */
static int prev_emerg_level = 0;   // 记录上一轮紧急等级，退出紧急时用作档位上限

static void main_loop(void) {
    // 0. 检查配置文件是否更新（热重载）
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

    // 1. 紧急干预（CPU 温度 + 电池电流，更新 emergency_level）
    prev_emerg_level = emergency_level;
    emergency_intervention();

    // 2. 电池温度控制（内部处理冷却期）
    battery_control();

    // 3. 计算最终档位 = max(电池基础档位, 紧急强制最低档位)
    int final_level = battery_fan_level;
    if (forced_min_level > final_level) final_level = forced_min_level;
    final_level = clamp(final_level, level_min, level_max);

    // 4. 同步逻辑跟踪值（供下轮控制计算基础），不下发
    battery_fan_level = final_level;

    // 5. 保存为目标档位（供下轮逐步执行使用）
    target_level = final_level;

    // 6. 退出紧急时限制电池档位上限（过渡期保护，仅生效一周期）
    //    用上一级紧急的强制最低档位 + 偏移量作为上限
    //    压制 battery_control 立即拉升，又给用户一点过渡余量
    if (emergency_level < prev_emerg_level) {
        int cap;
        if      (prev_emerg_level >= 4) cap = EMERG_FORCED_4;
        else if (prev_emerg_level >= 3) cap = EMERG_FORCED_3;
        else if (prev_emerg_level >= 2) cap = EMERG_FORCED_2;
        else                             cap = EMERG_FORCED_1;
        cap += EMERG_EXIT_CAP_OFFSET;
        if (cap > level_max) cap = level_max;
        if (battery_fan_level > cap)
            battery_fan_level = cap;
        // 同步 target_level，避免逐步执行向已被压低的档位上方移动
        if (target_level > battery_fan_level)
            target_level = battery_fan_level;
    }
}

// ======================== 程序入口 ========================

int main(int argc, char *argv[]) {
    signal(SIGTERM, handle_signal);
    signal(SIGINT,  handle_signal);

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

    // --- 初始化档位（继承上次档位，无存档用 LEVEL_INIT=5） ---
    battery_fan_level = load_gear();
    batt_cooldown = 0;
    target_level = battery_fan_level;
    actual_level = battery_fan_level;
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

        if (!fully_connected) {
            if (app_was_alive) {
                app_was_alive = 0;
                if (!app_proc_ok) {
                    write_log("App 不存在，等待连接...\n");
                } else {
                    write_log("BLE 已断开，等待连接...\n");
                }

                // 散热器已断联，清零待执行步伐
                actual_level = target_level;
            }

            // 等待完全恢复的循环（进程+BLE 都就绪）
            while (running) {
                sleep(5);
                read_status_ble();
                if (is_app_alive() && app_ble_connected) {
                    app_was_alive = 1;
                    last_sent_valid = 0;
                    actual_level = target_level;
                    apply_level(actual_level);
                    break;
                }
            }
            continue;   // 跳过本轮 main_loop，下一轮再开始控制
        } else if (!app_was_alive) {
            app_was_alive = 1;
            last_sent_valid = 0;
            actual_level = target_level;
            apply_level(actual_level);
        }

        main_loop();

        // ★ 计算完成后立即执行（向 target_level 靠拢）
        // 升档时：target ≤ GRADUAL_STEP_THRESHOLD 可直接跳转，否则逐级 ±1
        // 降档时：始终逐级 -1（压制噪音突降）
        if (actual_level < target_level) {
            if (target_level <= GRADUAL_STEP_THRESHOLD) {
                actual_level = target_level;     // 低频区直接跳转
            } else {
                actual_level++;                  // 高频区逐级提升
            }
            apply_level(actual_level);
        } else if (actual_level > target_level) {
            actual_level--;
            apply_level(actual_level);
        }
        // actual_level == target_level → 跳过（已到达目标）

        // 逐秒睡眠（可被信号中断）
        for (int i = 0; i < 5 && running; i++) {
            sleep(1);
        }
    }

exit:
    if (log_fp) fclose(log_fp);
    return 0;
}
