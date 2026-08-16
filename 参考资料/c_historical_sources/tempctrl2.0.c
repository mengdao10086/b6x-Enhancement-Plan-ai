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
// 编译（Termux）：
//   clang -static -o tempctrl tempctrl.c
//   python3 patch_tls.py tempctrl   （修复 PT_TLS 对齐）
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

// ======================== 档位定义 ========================
//
// 档位    模式             目标温度   风扇转速/RPM   制冷片强度  说明
// ─────────────────────────────────────────────────────────────────
//  12    固定功率(mode=1)    —        6000          190        制冷峰值
//  11    智能温控(mode=0)   12°C      5800          auto       紧急3-min
//  10    智能温控(mode=0)   13°C      5500          auto       官方默认风扇满速值
//   9    智能温控(mode=0)   14°C      5100          auto       紧急2-min
//   8    智能温控(mode=0)   15°C      4600          auto
//   7    智能温控(mode=0)   16°C      4000          auto       紧急1-min
//   6    智能温控(mode=0)   18°C      3400          auto
//   5    固定功率(mode=1)    —        2900           80        低功耗1
//   4    固定功率(mode=1)    —        2500           60        低功耗2
//   3    固定功率(mode=1)    —        2200           40        低功耗3
//   2    固定功率(mode=1)    —        2000           20        伪待机4
//   1    固定功率(mode=1)    —        2000           10        伪待机
//
// setRunMode 签名：
//   setRunMode(mode, targetTemperature,
//              windLevelOverclock, coldLevelOverclock,
//              windLevel, modeCustom, extra)
//
// 参数映射：
//   mode=0(智能温控)：targetTemperature, windLevel(风扇转速上限)
//   mode=1（固定功率）：windLevelOverclock(风扇固定转速), coldLevelOverclock(制冷片强度)
//
// 档位映射使用查表法（见 build_params），因为风扇转速、目标温度不再是线性关系。
//
// ================================================================

// --- 档位范围 ---
#define LEVEL_MAX          12
#define LEVEL_MIN           1     // 档位范围 1~12（1=最低待机，12=满功率）
#define LEVEL_INIT          5     // 无存档时的默认初始档位

// --- 档位查表 ---
// 注意：风扇转速、目标温度、制冷片强度在档位间不是线性关系，
//       必须使用查表法而非公式计算。

// 档位 → 风扇转速 (RPM)，索引 = level - 1
static const int FAN_RPM_TABLE[12] = {
    2000, 2000, 2200, 2500, 2900, 3400, 4000, 4600, 5100, 5500, 5800, 6000
};

// 档位 → 运行模式 (0=智能温控, 1=固定功率)，索引 = level - 1
static const int GEAR_MODE_TABLE[12] = {
    1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1
};

// 档位 → 智能温控目标温度 (°C)，固定功率模式该项无效（传 20 占位），索引 = level - 1
static const int TARGET_TEMP_TABLE[12] = {
    20, 20, 20, 20, 20, 18, 16, 15, 14, 13, 12, 20
};

// 档位 → 固定功率制冷片强度，智能模式该项传 0（让散热器自行管理），索引 = level - 1
static const int COLD_INTENSITY_TABLE[12] = {
    10, 20, 40, 60, 80, 0, 0, 0, 0, 0, 0, 190
};

// --- 制冷片强度范围 ---
#define COLD_MIN             1
#define COLD_MAX           194     // 最大有效值（以上需超频模式，本场景不用）

// --- 电池温度控制（0.1°C）—— 可由 profile.conf 覆盖 ---
static int BATT_BASELINE = 350;     // 基准温度 35.0°C
static int BATT_ZONE_1   = 7;       // ±0.7°C → 不变（死区）
static int BATT_ZONE_2   = 20;      // ±2.0°C → 1 档（超过→2档）

// --- CPU 紧急干预阈值（0.1°C）—— 可由 profile.conf 覆盖 ---
static int CPU_EMERG_3   = 850;     // >85.0°C → 等级 3
static int CPU_EMERG_2   = 750;     // >75.0°C → 等级 2
static int CPU_EMERG_1   = 650;     // >65.0°C → 等级 1
static int CPU_RECOVER_0 = 550;     // <55.0°C → 清除紧急
static int CPU_RECOVER_1 = 650;     // <65.0°C 且 ≥2 级时降为 1
static int CPU_RECOVER_2 = 750;     // <75.0°C 且 ≥3 级时降为 2

// --- 紧急强制最低档位 —— 可由 profile.conf 覆盖 ---
static int EMERG_FORCED_1 = 6;   // 新档位 6 = 旧档位 5（智能 16°C/4000RPM）
static int EMERG_FORCED_2 = 8;   // 新档位 8 = 旧档位 7（智能 14°C/5100RPM）
static int EMERG_FORCED_3 = 10;  // 新档位 10 = 旧档位 9（智能 12°C/5800RPM）

// --- CPU 滤波系数（百分比，0~100，默认 20=α=0.20）---
static int CPU_FILTER_ALPHA = 20;

// --- 趋势豁免上限（可配置）---
// 温度趋势反向时最多连续豁免次数，超过后强制执行
static int OVERRIDE_MAX = 8;

// --- 峰值过冲抑制（可配置）---
// PEAK_DAMP_OUTER_THRESHOLD：2°C 外豁免/反补分界阈值。
//   变动 ≤ 此值 → 趋势豁免；变动 > 此值 → 反补 1 档
// PEAK_DAMP_INNER_BOUNDARY：2°C 内豁免/反补分界阈值。
//   变动 ≤ 此值 → 趋势豁免；变动 > 此值 → 反补（仍受 INNER_THRESHOLD 控制分级）
// PEAK_DAMP_INNER_THRESHOLD：2°C 内反补二级阈值。
//   boundary < 变动 ≤ 此值(0.5°C) → 反补 1 档；> 此值 → 反补 2 档（固定）
static int PEAK_DAMP_INNER_BOUNDARY  = 3;
static int PEAK_DAMP_INNER_THRESHOLD = 5;
static int PEAK_DAMP_OUTER_THRESHOLD = 5;

// --- 电池调档冷却周期数（可配置）---
// 每次电池温度导致的档位变动后冻结多少周期（×5s），期内跳过常规升降档
static int BATT_COOLDOWN_CYCLES = 3;

// --- 状态文件超时（秒，可配置）---
static int STATUS_TIMEOUT = 16;

// --- CPU 温度扫描范围（可配置）---
// 首次运行在此范围内扫描有效的 thermal_zone，后续只扫命中的 zone
static int CPU_ZONE_MIN = 0;
static int CPU_ZONE_MAX = 99;


// --- 日志路径（默认根据二进制名自动生成，可由 profile.conf 覆盖）---
static char log_file_path[256] = "";
static int LOG_MAX_KB = 10;          // 日志文件大小上限（KB），0=关闭日志

// ======================== 配置文件系统 ========================

// 配置文件路径（自动检测或 --config 指定）
static char config_path[256] = "";
// 配置文件的最后修改时间（用于热重载检测）
static time_t config_mtime = 0;

// 前向声明（配置系统函数位于 write_log/clamp 之前，C 要求先声明后使用）
static void write_log(const char *fmt, ...);
static inline int clamp(int val, int lo, int hi);

/**
 * 从 KEY=VALUE 格式的配置文件加载参数
 * 遇到不认识的 key 或格式错误的行，跳过并记日志
 * 找不到文件则不修改任何变量（保持默认值）
 */
static void load_config(const char *path) {
    // ---- 先预检 CONFIG_ENABLED ----
    FILE *f = fopen(path, "r");
    if (!f) {
        write_log("配置 无法打开 %s", path);
        return;
    }
    int enabled = 1;
    char line[256];
    while (fgets(line, sizeof(line), f)) {
        char *p = line;
        while (*p == ' ' || *p == '\t') p++;
        if (*p == '#' || *p == '\n' || *p == '\0') continue;
        char *eq = strchr(p, '=');
        if (!eq) continue;
        *eq = '\0';
        char *k = p;
        char *end = k + strlen(k) - 1;
        while (end > k && (*end == ' ' || *end == '\t')) *end-- = '\0';
        if (strcmp(k, "CONFIG_ENABLED") == 0) {
            enabled = atoi(eq + 1) ? 1 : 0;
            break;
        }
    }
    fclose(f);

    if (!enabled) {
        write_log("配置 已禁用，使用默认参数");
        return;
    }

    // ---- 正常解析全部参数 ----
    f = fopen(path, "r");
    if (!f) return;

    int loaded = 0;
    while (fgets(line, sizeof(line), f)) {
        char *p = line;
        while (*p == ' ' || *p == '\t') p++;
        if (*p == '#' || *p == '\n' || *p == '\0') continue;

        char *eq = strchr(p, '=');
        if (!eq) continue;
        *eq = '\0';
        char *key = p;
        char *val_str = eq + 1;

        char *end = key + strlen(key) - 1;
        while (end > key && (*end == ' ' || *end == '\t')) *end-- = '\0';

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
        else if (strcmp(key, "EMERG_FORCED_1") == 0)       EMERG_FORCED_1     = clamp(val, 0, 10);
        else if (strcmp(key, "EMERG_FORCED_2") == 0)       EMERG_FORCED_2     = clamp(val, 0, 10);
        else if (strcmp(key, "EMERG_FORCED_3") == 0)       EMERG_FORCED_3     = clamp(val, 0, 10);
        else if (strcmp(key, "CPU_FILTER_ALPHA") == 0)     CPU_FILTER_ALPHA   = clamp(val, 1, 100);
        else if (strcmp(key, "OVERRIDE_MAX") == 0)         OVERRIDE_MAX       = clamp(val, 0, 20);
        else if (strcmp(key, "PEAK_DAMP_INNER_BOUNDARY") == 0) PEAK_DAMP_INNER_BOUNDARY  = clamp(val, 1, 10);
        else if (strcmp(key, "PEAK_DAMP_INNER_THRESHOLD") == 0)  PEAK_DAMP_INNER_THRESHOLD = clamp(val, 1, 10);
        else if (strcmp(key, "PEAK_DAMP_OUTER_THRESHOLD") == 0)  PEAK_DAMP_OUTER_THRESHOLD = clamp(val, 1, 10);
        else if (strcmp(key, "BATT_COOLDOWN_CYCLES") == 0) BATT_COOLDOWN_CYCLES = clamp(val, 0, 20);
        else if (strcmp(key, "STATUS_TIMEOUT") == 0)       STATUS_TIMEOUT     = clamp(val, 5, 60);
        else if (strcmp(key, "CPU_ZONE_MIN") == 0)          CPU_ZONE_MIN       = clamp(val, 0, 99);
        else if (strcmp(key, "CPU_ZONE_MAX") == 0)          CPU_ZONE_MAX       = clamp(val, 0, 99);
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
        else { continue; }

        loaded++;
    }
    fclose(f);

    write_log("配置 已加载 %d 项 %s", loaded, path);
}

/**
 * 根据二进制名设定默认日志路径
 * 例：tempctrl → /cache/tempctrl.log
 * 此值为默认值，profile.conf 中 LOG_FILE 可覆盖
 */
static void set_default_log_path(void) {
    char exe_path[512];
    ssize_t len = readlink("/proc/self/exe", exe_path, sizeof(exe_path) - 1);
    if (len > 0) {
        exe_path[len] = '\0';
        char *slash = strrchr(exe_path, '/');
        if (slash) {
            slash++;
            snprintf(log_file_path, sizeof(log_file_path), "/cache/%s.log", slash);
            return;
        }
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

// ======================== 全局状态 ========================

static int battery_fan_level = 0;      // 电池控制决定的基础档位
static int emergency_level = 0;        // CPU 紧急等级 0~3
static int forced_min_level = 0;       // 紧急强制最低档位
static int cpu_weighted = 250;         // 加权 CPU 温度，初始 25.0°C
static int batt_cooldown = 0;          // 电池调档冷却剩余周期
static int prev_batt_temp = -1;       // 上次调整时的电池温度（变化检测）
static int last_batt_reading = -1;    // 上次读取的电池温度（趋势判断）
static int trend_override = 0;        // 趋势豁免计数器（最多 6 次）
static int first_run = 1;             // 首次运行（滤波初始化）
static volatile int running = 1;       // 信号控制标记

// --- 逐步执行状态 ---
static int actual_level = LEVEL_INIT;   // 散热器实际运行的档位（逐级变动）
static int target_level = LEVEL_INIT;   // 逻辑计算的目标档位（执行向此靠拢）

// --- 发送去重缓存 ---
// 记录上次发送的完整参数，避免重复下发
static int last_sent_valid = 0;        // 0=尚未发送过
static int last_mode = -1;
static int last_target_temp = -1;
static int last_windOC = -1;
static int last_coldOC = -1;
static int last_windLevel = -1;

// --- App 进程检测 ---
static int app_was_alive = 0;          // 上次检测时 App 是否存活

// --- 状态文件检测（模块心跳 + BLE 状态）---
// 模块每 5 秒写入一次 status 文件，daemon 通过 mtime 判断进程是否活着
// 同时读取 BLE=0/1 获知 BLE 连接状态
static char status_file_path[512] = "";
static char gear_file_path[512] = "";
static int app_ble_connected = 0;

// ======================== 辅助函数 ========================

/**
 * 写入日志（自动滚动：超上限后删除最早 1~2 行）
 * 日期格式：日+时间，无年月（例 "14 22:30:16"）
 * LOG_MAX_KB=0 时关闭日志
 */
static void write_log(const char *fmt, ...) {
    if (LOG_MAX_KB == 0) return;     // 日志关闭

    int max_bytes = LOG_MAX_KB * 1024;

    // 超标 → 滚动：读文件，跳过最早 2 行，重写剩余内容
    struct stat st;
    if (stat(log_file_path, &st) == 0 && st.st_size > max_bytes) {
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

                // 重写
                FILE *wf = fopen(log_file_path, "w");
                if (wf) {
                    fwrite(tail, 1, rd - (tail - buf), wf);
                    fclose(wf);
                }
            }
            free(buf);
        }
    }

    FILE *f = fopen(log_file_path, "a");
    if (!f) return;

    // 时间戳（仅日+时间）
    time_t now = time(NULL);
    struct tm *tm = localtime(&now);
    char ts[24];
    strftime(ts, sizeof(ts), "%d %H:%M:%S", tm);
    fprintf(f, "[%s] ", ts);

    va_list args;
    va_start(args, fmt);
    vfprintf(f, fmt, args);
    va_end(args);

    fprintf(f, "\n");
    fclose(f);
}

/**
 * 限幅
 */
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
    char exe_path[512];
    ssize_t len = readlink("/proc/self/exe", exe_path, sizeof(exe_path) - 1);
    if (len > 0) {
        exe_path[len] = '\0';
        char *slash = strrchr(exe_path, '/');
        if (slash) {
            slash++;
            snprintf(status_file_path, sizeof(status_file_path),
                     "/data/local/tmp/%s.status", slash);
            return;
        }
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
    char exe[512];
    ssize_t len = readlink("/proc/self/exe", exe, sizeof(exe) - 1);
    if (len > 0) {
        exe[len] = '\0';
        char *s = strrchr(exe, '/');
        if (s) {
            s++;
            snprintf(gear_file_path, sizeof(gear_file_path),
                     "/data/local/tmp/%s.gear", s);
            return;
        }
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
    if (val < LEVEL_MIN || val > LEVEL_MAX) return LEVEL_INIT;
    return val;
}

// ======================== 温度读取 ========================

/**
 * 读取电池温度，返回 0.1°C（如 350 = 35.0°C）
 * 文件路径：/sys/class/power_supply/battery/temp
 * 失败返回 -1
 */
static int read_battery_temp(void) {
    FILE *f = fopen("/sys/class/power_supply/battery/temp", "r");
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
 * 缓存已发现的 CPU 温度 zone（首次全量扫描后记录）
 */
#define CPU_ZONE_MAX_CACHE 64
static int cpu_zone_cache[CPU_ZONE_MAX_CACHE];
static int cpu_zone_count = 0;
static int cpu_zone_scanned = 0;

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
        char path[64];
        for (int i = CPU_ZONE_MIN; i <= CPU_ZONE_MAX; i++) {
            snprintf(path, sizeof(path),
                     "/sys/class/thermal/thermal_zone%d/temp", i);
            FILE *f = fopen(path, "r");
            if (!f) continue;

            int raw;
            if (fscanf(f, "%d", &raw) != 1) {
                fclose(f);
                continue;
            }
            fclose(f);

            if (raw <= 0 || raw > 150000) continue;

            if (cpu_zone_count < CPU_ZONE_MAX_CACHE) {
                cpu_zone_cache[cpu_zone_count++] = i;
            }
        }
        cpu_zone_scanned = 1;
        write_log("CPU扫描 %d 个有效 zone (%d~%d)", cpu_zone_count, CPU_ZONE_MIN, CPU_ZONE_MAX);
    }

    // 后续调用 → 只扫描已记录的 zone
    int max_temp = -1;
    char path[64];
    for (int j = 0; j < cpu_zone_count; j++) {
        snprintf(path, sizeof(path),
                 "/sys/class/thermal/thermal_zone%d/temp", cpu_zone_cache[j]);
        FILE *f = fopen(path, "r");
        if (!f) continue;

        int raw;
        if (fscanf(f, "%d", &raw) != 1) {
            fclose(f);
            continue;
        }
        fclose(f);

        // 滤除异常值
        if (raw <= 0 || raw > 150000) continue;

        int decic = raw / 100;
        if (decic > max_temp) max_temp = decic;
    }
    return max_temp;
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
 *   targetTemperature = 占位 20
 */
static void build_params(int level,
                         int *out_mode,
                         int *out_target,
                         int *out_windOC,
                         int *out_coldOC,
                         int *out_windLevel)
{
    int mode, target, windOC, coldOC, windLevel;

    mode   = GEAR_MODE_TABLE[level - 1];
    target = TARGET_TEMP_TABLE[level - 1];
    target = clamp(target, 5, 35);

    if (mode == 0) {
        // --- 智能温控 ---
        windLevel = FAN_RPM_TABLE[level];
        windOC = 0;
        coldOC = 0;   // 智能模式让散热器自行管理制冷
    } else {
        // --- 固定功率 ---
        windOC = FAN_RPM_TABLE[level];
        coldOC = COLD_INTENSITY_TABLE[level - 1];
        coldOC = clamp(coldOC, COLD_MIN, COLD_MAX);
        windLevel = 0;
    }

    *out_mode      = mode;
    *out_target    = target;
    *out_windOC    = windOC;
    *out_coldOC    = coldOC;
    *out_windLevel = windLevel;
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

    level = clamp(level, LEVEL_MIN, LEVEL_MAX);
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

    // ---- 构建命令 ----
    char cmd[512];
    snprintf(cmd, sizeof(cmd),
        "am broadcast --user 0 "
        "-a com.flydigi.SET_TEMPERATURE "
        "--ei mode %d "
        "--ei temperature %d "
        "--ei windOC %d "
        "--ei coldOC %d "
        "--ei windLevel %d "
        "--ei modeCustom 0 "
        "--ei extra 0 "
        ">/dev/null 2>&1",
        mode, target, windOC, coldOC, windLevel);

    int ret = system(cmd);

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
 * 双重检测 App 是否存活：
 *   1. pgrep 进程存在
 *   2. 状态文件 mtime 不超过 STATUS_TIMEOUT 秒（模块心跳）
 * 两者都确认才算存活，任一有问题即判死。
 */
static int is_app_alive(void) {
    // 1. pgrep 进程检测
    int pgrep_ok = system("pgrep -f 'com.flydigi.waspwing.experimental' >/dev/null 2>&1") == 0;

    // 2. 状态文件 mtime 心跳检测（模块每 5 秒写入一次）
    int status_ok = 0;
    struct stat st;
    if (stat(status_file_path, &st) == 0) {
        time_t now = time(NULL);
        if (now - st.st_mtime <= STATUS_TIMEOUT) {
            status_ok = 1;
        }
    }

    return pgrep_ok && status_ok;
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
 * 已去除冷却期（冷却期原用于延迟升降档，现改为随到随调）。
 *
 * 合并逻辑：
 *   2°C 内：≤0.3°C 趋势豁免，0.3~0.5°C 反补 1 档，>0.5°C 反补 2 档
 *   2°C 外：≤PEAK_DAMP_OUTER_THRESHOLD 趋势豁免，> 则反补 1 档
 */
static void battery_control(void) {
    int batt = read_battery_temp();
    if (batt < 0) return;

    // 温度值与上次调整时相同 → 跳过所有逻辑
    if (batt == prev_batt_temp) return;

    // 计算本周期温度变化量
    int batt_change = 0, abs_change = 0;
    if (last_batt_reading >= 0) {
        batt_change = batt - last_batt_reading;
        abs_change = (batt_change > 0) ? batt_change : -batt_change;
    }

    // 计算常规档位调整量（无副作用，纯计算）
    int diff = batt - BATT_BASELINE;
    int delta = 0;
    if (diff > 0) {
        if      (diff <= BATT_ZONE_1) delta = 0;
        else if (diff <= BATT_ZONE_2) delta = 1;
        else                          delta = 2;
    } else if (diff < 0) {
        int ad = -diff;
        if      (ad <= BATT_ZONE_1) delta = 0;
        else if (ad <= BATT_ZONE_2) delta = -1;
        else                        delta = -2;
    }

    int abs_diff = (diff > 0) ? diff : -diff;
    int skip_delta = 0;  // =1 时本次不执行常规升降档

    // ═══════════════ 合并逻辑：趋势豁免 + 峰值过冲抑制 ═══════════════
    if (last_batt_reading >= 0) {
        int trend_rev = (delta > 0 && batt < last_batt_reading) ||
                        (delta < 0 && batt > last_batt_reading);

        // 冷却期内跳过常规升降档和豁免，峰值反补仍运行（安全机制）
        int in_cooldown = (batt_cooldown > 0);
        if (in_cooldown) {
            batt_cooldown--;
            skip_delta = 1;   // 冷却期内 delta 不执行
        }

        // 方向感知的区间判断：同向变动时容忍度更宽，反向时收紧
        // 降温时 batt ≤ BASELINE+ZONE_2 → 内区（温和反补）
        // 升温时 batt ≥ BASELINE-ZONE_2 → 内区（温和反补）
        // 否则 → 外区（强力反补）
        int in_inner_zone = 0;
        if (batt_change < 0) {
            in_inner_zone = (batt <= BATT_BASELINE + BATT_ZONE_2);
        } else if (batt_change > 0) {
            in_inner_zone = (batt >= BATT_BASELINE - BATT_ZONE_2);
        } else {
            in_inner_zone = (abs_diff <= BATT_ZONE_2);
        }
        int peak_bound = in_inner_zone ? PEAK_DAMP_INNER_BOUNDARY : PEAK_DAMP_OUTER_THRESHOLD;

        // ═══ 小变动（≤阈值）→ 趋势豁免 ═══
        // 最高/最低档位时不触发豁免
        if (!in_cooldown && abs_change <= peak_bound) {
            if (trend_rev && battery_fan_level > LEVEL_MIN &&
                battery_fan_level < LEVEL_MAX) {
                if (trend_override < OVERRIDE_MAX) {
                    int first = (trend_override == 0);
                    trend_override++;
                    skip_delta = 1;
                    if (first) {
                        write_log("趋势豁免 %d", battery_fan_level);
                    }
                } else {
                    trend_override = 0;
                }
            } else {
                trend_override = 0;
            }
        }

        // ═══ 大变动（>阈值）→ 峰值反补（冷却期也执行） ═══
        if (abs_change > peak_bound) {
            trend_override = 0;

            int adjust = 0;
            if (in_inner_zone) {
                // 内区：≤PEAK_DAMP_INNER_THRESHOLD→1档，>→2档（固定）
                if (abs_change <= PEAK_DAMP_INNER_THRESHOLD)
                    adjust = (batt_change > 0) ? 1 : -1;
                else
                    adjust = (batt_change > 0) ? 2 : -2;
            } else {
                // 外区：固定反补1档
                adjust = (batt_change > 0) ? 1 : -1;
            }

            if (adjust != 0) {
                int old = battery_fan_level;
                battery_fan_level += adjust;
                battery_fan_level = clamp(battery_fan_level, LEVEL_MIN, LEVEL_MAX);
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
        battery_fan_level = clamp(battery_fan_level, LEVEL_MIN, LEVEL_MAX);
        if (old != battery_fan_level) {
            batt_cooldown = BATT_COOLDOWN_CYCLES;
            write_log("挡位%d（%d）", battery_fan_level, delta);
        }
    }

    // 更新温度记录
    prev_batt_temp = batt;
    last_batt_reading = batt;
}

// ======================== CPU 紧急干预 ========================

/**
 * CPU 温度紧急干预
 * 每 5 秒调用一次
 *
 * 使用一阶低通滤波（α=0.25）平滑温度
 *
 * 紧急等级分布（档位值根据 Sheet2 标注）：
 *   等级 1（>65°C）→ 最低档位 5（智能 16°C/4000RPM，紧急1-min）
 *   等级 2（>75°C）→ 最低档位 7（智能 14°C/5100RPM，紧急2-min）
 *   等级 3（>85°C）→ 最低档位 9（智能 12°C/5800RPM，紧急3-min）
 *
 * 降温使用 10°C 滞回避免频繁跳变
 */
static void emergency_intervention(void) {
    int cpu_now = read_cpu_temp_max();
    if (cpu_now < 0) return;   // 读取失败，保持当前等级

    // 一阶低通滤波：weighted = raw×ALPHA% + weighted×(100-ALPHA)%
    if (first_run) {
        cpu_weighted = cpu_now;
        first_run = 0;
    } else {
        cpu_weighted = (cpu_now * CPU_FILTER_ALPHA + cpu_weighted * (100 - CPU_FILTER_ALPHA)) / 100;
    }

    int t = cpu_weighted;
    int new_level = emergency_level;

    // 升温：直接跳到对应等级
    if      (t > CPU_EMERG_3) new_level = 3;
    else if (t > CPU_EMERG_2) new_level = 2;
    else if (t > CPU_EMERG_1) new_level = 1;
    // 降温：10°C 滞回，逐级下降
    else if (t < CPU_RECOVER_0)                          new_level = 0;
    else if (t < CPU_RECOVER_1 && emergency_level >= 2)  new_level = 1;
    else if (t < CPU_RECOVER_2 && emergency_level >= 3)  new_level = 2;

    // 等级变化处理
    if (new_level != emergency_level) {
        int old = emergency_level;
        int delta_e = new_level - old;
        write_log("紧急%d（%s%d）cpu%d.%d",
                  new_level,
                  (delta_e >= 0 ? "+" : ""), delta_e,
                  cpu_now / 10, cpu_now % 10);

        emergency_level = new_level;
        batt_cooldown = BATT_COOLDOWN_CYCLES;   // 任何档位变动后启动冷却
    }

    // 设定强制最低档位
    switch (emergency_level) {
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
    // 如果阻塞在 read(fifo_fd) 中，信号会中断它
}

/**
 * 单次控制循环（纯计算，不下发）
 * 配置重载 → CPU 紧急 → 电池控制 → 保存目标档位
 */
// 记录上一轮紧急等级（用于退出限制判断）
static int prev_emerg_level = 0;

static void main_loop(void) {
    // 0. 检查配置文件是否更新（热重载）
    if (config_path[0] != '\0') {
        struct stat st;
        if (stat(config_path, &st) == 0) {
            if (st.st_mtime != config_mtime) {
                load_config(config_path);
                config_mtime = st.st_mtime;
                write_log("配置 热重载");
            }
        }
    }

    // 1. CPU 紧急干预（更新 cpu_weighted 和 emergency_level）
    prev_emerg_level = emergency_level;
    emergency_intervention();

    // 2. 电池温度控制（内部处理冷却期）
    battery_control();

    // 3. 计算最终档位 = max(电池基础档位, 紧急强制最低档位)
    int final_level = battery_fan_level;
    if (forced_min_level > final_level) final_level = forced_min_level;
    final_level = clamp(final_level, LEVEL_MIN, LEVEL_MAX);

    // 4. 同步逻辑跟踪值（供下轮控制计算基础），不下发
    battery_fan_level = final_level;

    // 5. 保存为目标档位（供下轮逐步执行使用）
    target_level = final_level;

    // 6. 退出紧急时限制电池档位上限（在同步之后执行）
    // 仅在电池温度低于升档阈值（基准温度+死区）时允许降档，
    // 防止 CPU 温度刚降下来又反弹回去
    // 大电流充电（current < -2000mA）时跳过限制——此时电池升温来自充电而非 CPU
    {
        int batt = read_battery_temp();
        int upshift_threshold = BATT_BASELINE + BATT_ZONE_1;
        int charging_hard = 0;
        FILE *cf = fopen("/sys/class/power_supply/battery/current_now", "r");
        if (cf) {
            int cur;
            if (fscanf(cf, "%d", &cur) == 1 && cur < -2000000)
                charging_hard = 1;
            fclose(cf);
        }
        if (batt >= 0 && charging_hard) {
            ;  // 大电流充电中→不降档
        } else if (batt < 0 || batt <= upshift_threshold) {
            if (prev_emerg_level >= 3 && emergency_level < 3 && battery_fan_level > EMERG_FORCED_3)
                battery_fan_level = EMERG_FORCED_3;
            if (prev_emerg_level >= 2 && emergency_level < 2 && battery_fan_level > EMERG_FORCED_2)
                battery_fan_level = EMERG_FORCED_2;
            if (prev_emerg_level >= 1 && emergency_level < 1 && battery_fan_level > EMERG_FORCED_1)
                battery_fan_level = EMERG_FORCED_1;
        }
    }
}

// ======================== 程序入口 ========================

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

    // --- 状态文件 + 档位存档初始化 ---
    set_default_status_path();
    create_status_file();
    set_gear_file_path();

    // --- 初始化档位（继承上次档位，无存档用 LEVEL_INIT=5） ---
    battery_fan_level = load_gear();
    batt_cooldown = 0;
    target_level = battery_fan_level;
    actual_level = battery_fan_level;
    {
        int batt = read_battery_temp();
        if (batt >= 0) {
            prev_batt_temp = batt;
            last_batt_reading = batt;
        }
    }
    write_log("脚本启动成功");

    // --- 等待模块就绪（进程存活 + status 文件有内容） ---
    // status 文件由模块在 Application.onCreate 中写入 "BLE=0/1\n"，
    // 文件有内容即代表模块初始化完成。
    while (running) {
        if (system("pgrep -f 'com.flydigi.waspwing.experimental' >/dev/null 2>&1") == 0) {
            // 检查 status 文件是否有模块写入的实际内容
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
                if (!app_proc_ok)
                    write_log("App 不存在，等待连接...");
                else
                    write_log("BLE 已断开，等待连接...");

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

        // ★ 逐步执行（每轮最多变动 1 档，向 target_level 方向靠拢）
        // 散热器实际运行的档位逐级变化，压制档位突变带来的噪音突变
        if (actual_level < target_level) {
            actual_level++;
            apply_level(actual_level);
        } else if (actual_level > target_level) {
            actual_level--;
            apply_level(actual_level);
        }
        // actual_level == target_level → 跳过（已到达目标）

        main_loop();

        // 逐秒睡眠（可被信号中断）
        for (int i = 0; i < 5 && running; i++) {
            sleep(1);
        }
    }

exit:
    return 0;
}
