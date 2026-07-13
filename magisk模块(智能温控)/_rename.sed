# ── 组1：风扇映射变量（去掉 PID_ 前缀）──
s/\bpid_rpm_min\b/fan_rpm_min/g
s/\bpid_rpm_max\b/fan_rpm_max/g
s/\bpid_hot_map_min\b/hot_map_min/g
s/\bpid_hot_map_max\b/hot_map_max/g
s/\bpid_cold_map_start\b/cold_map_start/g
s/\bpid_cold_exp\b/cold_map_exp/g

# ── 组2：紧急退出恢复期（BATT_RECOVERY_* → EMERG_RECOVERY_*）──
s/\bBATT_RECOVERY_M1\b/EMERG_RECOVERY_MULT_1/g
s/\bBATT_RECOVERY_M2\b/EMERG_RECOVERY_MULT_2/g
s/\bBATT_RECOVERY_M3\b/EMERG_RECOVERY_MULT_3/g
s/\bBATT_RECOVERY_PHASE_CYCLES\b/EMERG_RECOVERY_PHASE_CYCLES/g
s/\bbatt_recovery_multiplier\b/emerg_recovery_mult/g
s/\bbatt_recovery_cycles\b/emerg_recovery_cycles/g
s/\brecovery_step\b/emerg_recovery_phase/g

# ── 组3：趋势豁免命名统一（OVERRIDE/override → TREND/trend）──
s/\bOVERRIDE_MAX\b/TREND_RESET_THRESHOLD/g
s/\btrend_override\b/trend_exempt_count/g
s/\boverride_anchor_temp\b/trend_anchor_temp/g

# ── 组4：PID 状态变量 ──
s/\bpid_integral\b/pid_integral_accum/g
s/\bpid_filter_auto_disabled\b/pid_filter_auto_off/g
s/\bpid_target_rpm\b/pid_align_rpm/g
s/\bpid_target_cold\b/pid_align_cold/g

# ── 组5：档位相关（level → gear）──
s/\blevel_min\b/gear_min/g
s/\blevel_max\b/gear_max/g
s/\btarget_level\b/final_gear/g
s/\bbattery_fan_level\b/batt_gear_base/g
s/\bforced_min_level\b/emerg_forced_gear/g

# ── 组6：函数名 ──
s/\bapply_level_direct\b/apply_gear_direct/g
s/\bapply_level\b/apply_gear/g
s/\bcurrent_gear_override\b/gear_from_current/g

# ── 组7：发送去重缓存 ──
s/\blast_sent_valid\b/last_bcast_valid/g
s/\blast_windOC\b/last_rpm/g
s/\blast_coldOC\b/last_cold/g
s/\blast_windLevel\b/last_wind_level/g

# ── 组8：电流相关 ──
s/\bcurr_gear_rec\b/curr_gear_recommended/g
s/\bcurr_smooth_val\b/curr_emerg_smooth_val/g
s/\bcurr_smooth_valid\b/curr_emerg_smooth_valid/g

# ── 组9：反补（REV_COMP_T* → REV_COMP_THRESH_*）──
s/\bREV_COMP_T1\b/REV_COMP_THRESH_1/g
s/\bREV_COMP_T2\b/REV_COMP_THRESH_2/g
s/\bREV_COMP_T3\b/REV_COMP_THRESH_3/g
s/\brev_comp_pending_abs\b/rev_comp_pending_delta/g

# ── 组10：电池区间阈值（BATT_ZONE → BATT_BOUNDARY）──
s/\bBATT_ZONE_1\b/BATT_BOUNDARY_1/g
s/\bBATT_ZONE_2\b/BATT_BOUNDARY_2/g
s/\bBATT_ZONE_3\b/BATT_BOUNDARY_3/g

# ── 组11：CPU 温度状态 ──
s/\bcpu_weighted\b/cpu_filtered_temp/g

# ── 组12：电池调档冷却 ──
s/\bbatt_cooldown\b/batt_gear_cooldown/g
