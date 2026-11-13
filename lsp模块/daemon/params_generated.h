/* 本文件由 python 参数定义/gen_params.py 生成，勿手改。
 * 唯一手写处：参数定义/params.def.json；改动后重跑生成脚本。
 * 只定义宏。X 宏的展开点必须在 struct SysfsCfgKey / enum SK_* 与所有被取地址的
 * static 变量（BATT_TEMP_PATH、log_file_path、LOG_MAX 等）声明之后。 */
#ifndef PARAMS_GENERATED_H
#define PARAMS_GENERATED_H

/* 性能层单值键表（PERF_ENABLED=1）→ INT_CFG_KEYS[]：X(键名, C 变量, min, max) */
#define CFG_PERF_INT_KEYS(X) \
    X("BATT_BASELINE", BATT_BASELINE, 300, 500) \
    X("PID_KDP", pid_kdp_coef, 1, 1000) \
    X("RECONNECT_KEEP_CYCLES", reconnect_keep_cycles, 0, 30) \
    X("CPU_FILTER_ALPHA", CPU_FILTER_ALPHA, 1, 100) \
    X("MAP_INPUT_SMOOTH_ALPHA", rpm_smooth_alpha, 1, 99) \
    X("PID_CH_THRESHOLD", pid_ch_threshold, 1, 100)

/* sysfs 层键表（SYSFS_ENABLED=1）→ SYSFS_CFG_KEYS[]：
 *   X(键名, kind, ivar, imin, imax, svar, ssize)
 * kind/SK_INT 槽位钳制范围由本表给出；SK_ZONE/SK_RESCAN 的逐字段校验在 tempctrl.c 解析代码内。 */
#define CFG_SYSFS_KEYS(X) \
    X("BATT_TEMP_PATH", SK_PATH, NULL, 0, 0, BATT_TEMP_PATH, sizeof(BATT_TEMP_PATH)) \
    X("BATT_TEMP_DIVISOR", SK_INT, &BATT_TEMP_DIVISOR, 1, 10000, NULL, 0) \
    X("BATT_CURRENT_PATH", SK_PATH, NULL, 0, 0, BATT_CURRENT_PATH, sizeof(BATT_CURRENT_PATH)) \
    X("BATT_CURRENT_DIVISOR", SK_INT, &BATT_CURRENT_DIVISOR, 1, 100000, NULL, 0) \
    X("CPU_TEMP_PATH_FMT", SK_PATH, NULL, 0, 0, CPU_TEMP_PATH_FMT, sizeof(CPU_TEMP_PATH_FMT)) \
    X("CPU_TEMP_DIVISOR", SK_INT, &CPU_TEMP_DIVISOR, 1, 10000, NULL, 0) \
    X("CPU_ZONE", SK_ZONE, NULL, 0, 0, NULL, 0) \
    X("CPU_ZONE_RESCAN", SK_RESCAN, NULL, 0, 0, NULL, 0) \
    X("CPU_AFFINITY", SK_AFFINITY, NULL, 0, 0, NULL, 0) \
    X("LOG_FILE", SK_PATH, NULL, 0, 0, log_file_path, sizeof(log_file_path)) \
    X("LOG_MAX", SK_INT, &LOG_MAX, 0, 1048576, NULL, 0)

/* 路径键默认值（C 端同名变量初值；LOG_FILE 不在此列，运行期由 PRIVATE_DIR + 二进制名派生）*/
#define CFG_DEFAULT_BATT_TEMP_PATH "/sys/class/power_supply/battery/temp"
#define CFG_DEFAULT_BATT_CURRENT_PATH "/sys/class/power_supply/battery/current_now"
#define CFG_DEFAULT_CPU_TEMP_PATH_FMT "/sys/class/thermal/thermal_zone%d/temp"
#define CFG_DEFAULT_CPU_AFFINITY "c0"

/* 表键（type=table）：行前缀、逐字段 clamp 边界与默认行。解析代码在 tempctrl.c
 * 手写，用这些宏取前缀/边界/默认行，避免与定义各写一份（行数可变，故不并入上方 X 表）。 */
#define CFG_ROW_PREFIX_PID_CUT "PID_CUT_"
#define CFG_MIN_PID_CUT_F1 0
#define CFG_MAX_PID_CUT_F1 255
#define CFG_MIN_PID_CUT_F2 0
#define CFG_MAX_PID_CUT_F2 200
#define CFG_MIN_PID_CUT_F3 0
#define CFG_MAX_PID_CUT_F3 200
#define CFG_MIN_PID_CUT_F4 0
#define CFG_MAX_PID_CUT_F4 200
#define CFG_DEFAULT_PID_CUT_1 "1,100,100,50,60,100,100,100,120,100,70,80,190,100,50,65"

/* 各层 int 取值位的**代码默认值**表：层开关由 1→0 时，tempctrl.c 展开本表把该层
 * 运行时参数批量赋回代码默认值（= 等同该层配置不存在）。行格式 X(C 变量, 默认值)。
 * 路径键不入表：非 LOG_FILE 的走上方 CFG_DEFAULT_* 宏；LOG_FILE 走 set_default_log_path()
 * （该函数按二进制名派生路径，私有目录不可用时兜底 /cache，照抄宏会绕过兜底）。
 * 各层总开关自身同样不入表（PERF_ENABLED 默认 1，复位它会立刻自我重开）。 */
#define CFG_PERF_DEFAULTS(X) \
    X(BATT_BASELINE, 350) \
    X(fan_rpm_min, 2000) \
    X(fan_rpm_max, 6000) \
    X(b7_fan_rpm_max, 6000) \
    X(pid_kdp_coef, 300) \
    X(pid_ki_up_coef, 20) \
    X(pid_ki_down_coef, 30) \
    X(RATE_LIMIT_FAN, 200) \
    X(RATE_LIMIT_FAN_DEBOUNCE, 50) \
    X(fan_rpm_round_unit, 10) \
    X(RATE_LIMIT_COLD, 15) \
    X(RATE_LIMIT_COLD_MULT, 10) \
    X(COLD_DEADZONE, 3) \
    X(ramp_dispatch, 1) \
    X(reconnect_keep_cycles, 3) \
    X(CPU_FILTER_ALPHA, 25) \
    X(cold_map_start, 40) \
    X(cold_map_exp, 150) \
    X(hot_map_min, 350) \
    X(hot_map_max, 450) \
    X(rpm_smooth_alpha, 33) \
    X(HOT_DERATE_THRESHOLD, 450) \
    X(HOT_DERATE_MULT, 5) \
    X(HOT_DERATE_COOLDOWN, 5) \
    X(pid_speed_coef, 100) \
    X(pid_spd_nl_thr_p100, 20) \
    X(pid_spd_nl_exp_p100, 100) \
    X(pid_target_coef, 20) \
    X(pid_target_alpha, 10) \
    X(pid_target_max, 15) \
    X(pid_ch_threshold, 2) \
    X(pid_cpu_comp_filter_alpha, 25) \
    X(pid_cpu_comp_divisor, 30) \
    X(pid_cpu_comp_offset, 100) \
    X(pid_target_dir_on, 1) \
    X(pid_target_away_alpha, 20) \
    X(pid_target_toward_alpha, 10) \
    X(pid_spd_recall_on, 1) \
    X(pid_spd_recall_weight, 1000) \
    X(pid_cold_min, 1) \
    X(pid_cold_max, 190) \
    X(b7_pid_cold_max, 190)

#define CFG_SYSFS_DEFAULTS(X) \
    X(BATT_TEMP_DIVISOR, 1) \
    X(BATT_CURRENT_DIVISOR, 10000) \
    X(CPU_TEMP_DIVISOR, 100) \
    X(CPU_ZONE_MIN, 0) \
    X(CPU_ZONE_MAX, 99) \
    X(cpu_zone_rescan_cycles, 12) \
    X(cpu_zone_keep, 10) \
    X(LOG_MAX, 16256)

#endif  /* PARAMS_GENERATED_H */
