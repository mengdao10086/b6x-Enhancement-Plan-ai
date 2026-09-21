/* 本文件由 python 参数定义/gen_params.py 生成，勿手改。
 * 唯一手写处：参数定义/params.def.json；改动后重跑生成脚本。
 * 只定义宏。X 宏的展开点必须在 struct SysfsCfgKey / enum SK_* 与所有被取地址的
 * static 变量（BATT_TEMP_PATH、log_file_path、LOG_MAX 等）声明之后。 */
#ifndef PARAMS_GENERATED_H
#define PARAMS_GENERATED_H

/* 键数：守护进程消费 / 仅界面读取 */
#define CFG_DAEMON_KEY_COUNT 48
#define CFG_WEBUI_KEY_COUNT 4

/* 性能层单值键表（PERF_ENABLED=1）→ INT_CFG_KEYS[]：X(键名, C 变量, min, max) */
#define CFG_PERF_INT_KEYS(X) \
    X("RECONNECT_KEEP_CYCLES", reconnect_keep_cycles, 0, 30) \
    X("BATT_BASELINE", BATT_BASELINE, 300, 500) \
    X("CPU_FILTER_ALPHA", CPU_FILTER_ALPHA, 1, 100) \
    X("MAP_INPUT_SMOOTH_ALPHA", rpm_smooth_alpha, 1, 99) \
    X("FAN_RPM_ROUND_UNIT", fan_rpm_round_unit, 1, 500) \
    X("PID_KDP", pid_kdp_coef, 1, 1000) \
    X("PID_SPEED", pid_speed_coef, 0, 1000) \
    X("PID_CH_THRESHOLD", pid_ch_threshold, 1, 100)

/* sysfs 层键表（SYSFS_ENABLED=1）→ SYSFS_CFG_KEYS[]：
 *   X(键名, kind, ivar, imin, imax, svar, ssize)
 * kind/SK_INT 槽位钳制范围由本表给出；SK_ZONE/SK_RESCAN 的逐字段范围见 CFG_MIN/MAX_*。 */
#define CFG_SYSFS_KEYS(X) \
    X("BATT_TEMP_PATH", SK_PATH, NULL, 0, 0, BATT_TEMP_PATH, sizeof(BATT_TEMP_PATH)) \
    X("BATT_TEMP_DIVISOR", SK_INT, &BATT_TEMP_DIVISOR, 1, 10000, NULL, 0) \
    X("BATT_CURRENT_PATH", SK_PATH, NULL, 0, 0, BATT_CURRENT_PATH, sizeof(BATT_CURRENT_PATH)) \
    X("BATT_CURRENT_DIVISOR", SK_INT, &BATT_CURRENT_DIVISOR, 1, 100000, NULL, 0) \
    X("CPU_TEMP_PATH_FMT", SK_PATH, NULL, 0, 0, CPU_TEMP_PATH_FMT, sizeof(CPU_TEMP_PATH_FMT)) \
    X("CPU_TEMP_DIVISOR", SK_INT, &CPU_TEMP_DIVISOR, 1, 10000, NULL, 0) \
    X("CPU_ZONE", SK_ZONE, NULL, 0, 0, NULL, 0) \
    X("CPU_ZONE_RESCAN", SK_RESCAN, NULL, 0, 0, NULL, 0) \
    X("LOG_FILE", SK_PATH, NULL, 0, 0, log_file_path, sizeof(log_file_path)) \
    X("LOG_MAX", SK_INT, &LOG_MAX, 0, 1048576, NULL, 0)

/* 逐键/逐字段 clamp 边界（单值键 = 键名；多值键 = 键名_字段序号）。
 * 多值键与 SK_ZONE/SK_RESCAN 的解析代码仍在 tempctrl.c 手写，此处只提供边界值。 */
#define CFG_MIN_RATE_LIMIT_FAN_1 50  /* C 变量 RATE_LIMIT_FAN */
#define CFG_MAX_RATE_LIMIT_FAN_1 2000
#define CFG_MIN_RATE_LIMIT_FAN_2 0  /* C 变量 RATE_LIMIT_FAN_DEBOUNCE */
#define CFG_MAX_RATE_LIMIT_FAN_2 2000
#define CFG_MIN_RATE_LIMIT_COLD_1 1  /* C 变量 RATE_LIMIT_COLD */
#define CFG_MAX_RATE_LIMIT_COLD_1 194
#define CFG_MIN_RATE_LIMIT_COLD_2 1  /* C 变量 RATE_LIMIT_COLD_MULT */
#define CFG_MAX_RATE_LIMIT_COLD_2 100
#define CFG_MIN_RATE_LIMIT_COLD_3 1  /* C 变量 COLD_DEADZONE */
#define CFG_MAX_RATE_LIMIT_COLD_3 50
#define CFG_MIN_RECONNECT_KEEP_CYCLES 0  /* C 变量 reconnect_keep_cycles */
#define CFG_MAX_RECONNECT_KEEP_CYCLES 30
#define CFG_MIN_BATT_BASELINE 300  /* C 变量 BATT_BASELINE */
#define CFG_MAX_BATT_BASELINE 500
#define CFG_MIN_CPU_FILTER_ALPHA 1  /* C 变量 CPU_FILTER_ALPHA */
#define CFG_MAX_CPU_FILTER_ALPHA 100
#define CFG_MIN_COLD_RPM_MAP_1 0  /* C 变量 cold_map_start */
#define CFG_MAX_COLD_RPM_MAP_1 194
#define CFG_MIN_COLD_RPM_MAP_2 50  /* C 变量 cold_map_exp */
#define CFG_MAX_COLD_RPM_MAP_2 500
#define CFG_MIN_HOT_RPM_MAP_1 200  /* C 变量 hot_map_min */
#define CFG_MAX_HOT_RPM_MAP_1 500
#define CFG_MIN_HOT_RPM_MAP_2 200  /* C 变量 hot_map_max */
#define CFG_MAX_HOT_RPM_MAP_2 500
#define CFG_MIN_MAP_INPUT_SMOOTH_ALPHA 1  /* C 变量 rpm_smooth_alpha */
#define CFG_MAX_MAP_INPUT_SMOOTH_ALPHA 99
#define CFG_MIN_FAN_RPM_RANGE_1 1000  /* C 变量 fan_rpm_min */
#define CFG_MAX_FAN_RPM_RANGE_1 6000
#define CFG_MIN_FAN_RPM_RANGE_2 1000  /* C 变量 fan_rpm_max */
#define CFG_MAX_FAN_RPM_RANGE_2 6000
#define CFG_MIN_FAN_RPM_RANGE_3 2000  /* C 变量 b7_fan_rpm_max */
#define CFG_MAX_FAN_RPM_RANGE_3 8000
#define CFG_MIN_FAN_RPM_ROUND_UNIT 1  /* C 变量 fan_rpm_round_unit */
#define CFG_MAX_FAN_RPM_ROUND_UNIT 500
#define CFG_MIN_HOT_DERATE_1 350  /* C 变量 HOT_DERATE_THRESHOLD */
#define CFG_MAX_HOT_DERATE_1 700
#define CFG_MIN_HOT_DERATE_2 1  /* C 变量 HOT_DERATE_MULT */
#define CFG_MAX_HOT_DERATE_2 20
#define CFG_MIN_HOT_DERATE_3 0  /* C 变量 HOT_DERATE_COOLDOWN */
#define CFG_MAX_HOT_DERATE_3 20
#define CFG_MIN_PID_KDP 1  /* C 变量 pid_kdp_coef */
#define CFG_MAX_PID_KDP 1000
#define CFG_MIN_PID_KI_RATE_1 1  /* C 变量 pid_ki_up_coef */
#define CFG_MAX_PID_KI_RATE_1 1000
#define CFG_MIN_PID_KI_RATE_2 1  /* C 变量 pid_ki_down_coef */
#define CFG_MAX_PID_KI_RATE_2 1000
#define CFG_MIN_PID_KI_DYN_T_1 1
#define CFG_MAX_PID_KI_DYN_T_1 10000
#define CFG_MIN_PID_KI_DYN_T_2 1
#define CFG_MAX_PID_KI_DYN_T_2 10000
#define CFG_MIN_PID_KI_DYN_T_3 1
#define CFG_MAX_PID_KI_DYN_T_3 10000
#define CFG_MIN_PID_KI_DYN_GATE_1 3
#define CFG_MAX_PID_KI_DYN_GATE_1 10
#define CFG_MIN_PID_KI_DYN_GATE_2 10
#define CFG_MAX_PID_KI_DYN_GATE_2 100
#define CFG_MIN_PID_KI_DYN_WIN_1 6
#define CFG_MAX_PID_KI_DYN_WIN_1 128
#define CFG_MIN_PID_KI_DYN_WIN_2 1
#define CFG_MAX_PID_KI_DYN_WIN_2 100
#define CFG_MIN_PID_SPEED 0  /* C 变量 pid_speed_coef */
#define CFG_MAX_PID_SPEED 1000
#define CFG_MIN_PID_TARGET_1 1  /* C 变量 pid_target_coef */
#define CFG_MAX_PID_TARGET_1 1000
#define CFG_MIN_PID_TARGET_2 1  /* C 变量 pid_target_alpha */
#define CFG_MAX_PID_TARGET_2 100
#define CFG_MIN_PID_TARGET_3 1  /* C 变量 pid_target_max */
#define CFG_MAX_PID_TARGET_3 100
#define CFG_MIN_PID_CH_THRESHOLD 1  /* C 变量 pid_ch_threshold */
#define CFG_MAX_PID_CH_THRESHOLD 100
#define CFG_MIN_PID_CPU_COMP_1 1  /* C 变量 pid_cpu_comp_filter_alpha */
#define CFG_MAX_PID_CPU_COMP_1 100
#define CFG_MIN_PID_CPU_COMP_2 5  /* C 变量 pid_cpu_comp_divisor */
#define CFG_MAX_PID_CPU_COMP_2 200
#define CFG_MIN_PID_CPU_COMP_3 0  /* C 变量 pid_cpu_comp_offset */
#define CFG_MAX_PID_CPU_COMP_3 500
#define CFG_MIN_PID_TARGET_DIR_2 1  /* C 变量 pid_target_away_alpha */
#define CFG_MAX_PID_TARGET_DIR_2 100
#define CFG_MIN_PID_TARGET_DIR_3 1  /* C 变量 pid_target_toward_alpha */
#define CFG_MAX_PID_TARGET_DIR_3 100
#define CFG_MIN_PID_SPEED_RECALL_2 100  /* C 变量 pid_spd_recall_weight */
#define CFG_MAX_PID_SPEED_RECALL_2 1000
#define CFG_MIN_PID_COLD_RANGE_1 0  /* C 变量 pid_cold_min */
#define CFG_MAX_PID_COLD_RANGE_1 194
#define CFG_MIN_PID_COLD_RANGE_2 0  /* C 变量 pid_cold_max */
#define CFG_MAX_PID_COLD_RANGE_2 194
#define CFG_MIN_PID_COLD_RANGE_3 1  /* C 变量 b7_pid_cold_max */
#define CFG_MAX_PID_COLD_RANGE_3 255
#define CFG_MIN_BATT_TEMP_DIVISOR 1  /* C 变量 BATT_TEMP_DIVISOR */
#define CFG_MAX_BATT_TEMP_DIVISOR 10000
#define CFG_MIN_BATT_CURRENT_DIVISOR 1  /* C 变量 BATT_CURRENT_DIVISOR */
#define CFG_MAX_BATT_CURRENT_DIVISOR 100000
#define CFG_MIN_CPU_TEMP_DIVISOR 1  /* C 变量 CPU_TEMP_DIVISOR */
#define CFG_MAX_CPU_TEMP_DIVISOR 10000
#define CFG_MIN_CPU_ZONE_1 0  /* C 变量 CPU_ZONE_MIN */
#define CFG_MAX_CPU_ZONE_1 99
#define CFG_MIN_CPU_ZONE_2 0  /* C 变量 CPU_ZONE_MAX */
#define CFG_MAX_CPU_ZONE_2 99
#define CFG_MIN_CPU_ZONE_RESCAN_1 5  /* C 变量 cpu_zone_rescan_sec */
#define CFG_MAX_CPU_ZONE_RESCAN_1 3600
#define CFG_MIN_CPU_ZONE_RESCAN_2 1  /* C 变量 cpu_zone_keep */
#define CFG_MAX_CPU_ZONE_RESCAN_2 64
#define CFG_MIN_LOG_MAX 0  /* C 变量 LOG_MAX */
#define CFG_MAX_LOG_MAX 1048576
#define CFG_MIN_APP_LAUNCH_COOLDOWN 0  /* C 变量 app_launch_cooldown */
#define CFG_MAX_APP_LAUNCH_COOLDOWN 3600
#define CFG_MIN_APP_WATCHDOG 0  /* C 变量 app_watchdog_cycles */
#define CFG_MAX_APP_WATCHDOG 120

/* 路径键默认值（C 端同名变量初值；LOG_FILE 运行期由 PRIVATE_DIR + 二进制名派生）*/
#define CFG_DEFAULT_BATT_TEMP_PATH "/sys/class/power_supply/battery/temp"
#define CFG_DEFAULT_BATT_CURRENT_PATH "/sys/class/power_supply/battery/current_now"
#define CFG_DEFAULT_CPU_TEMP_PATH_FMT "/sys/class/thermal/thermal_zone%d/temp"
#define CFG_DEFAULT_LOG_FILE "/data/data/com.example.waspwingtempctrl/files/tempctrl.log"

#endif  /* PARAMS_GENERATED_H */
