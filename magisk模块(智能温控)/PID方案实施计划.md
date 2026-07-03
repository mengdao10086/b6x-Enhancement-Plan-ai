# PID 温控方案 — 实施计划

> 基于 `tempctrl.c` v2.2，新增 CTRL_MODE=1 分支接 PID 控制。
> 现有 CTRL_MODE=0 全部保留不变。

---

## 1. 改动清单

| 文件 | 改动 | 行数 |
|------|------|------|
| `tempctrl.c` | 新加 PID 计算函数 | ~40 行 |
| `tempctrl.c` | 新加制冷→RPM 映射（4个函数） | ~40 行 |
| `tempctrl.c` | 新加全局变量 + 默认值 | ~30 行 |
| `tempctrl.c` | `load_config` 增加 PID 参数 | ~40 行 |
| `tempctrl.c` | `main_loop` 增加 PID 分支 | ~25 行 |
| `tempctrl.c` | `rate_limited_execute` 增加 PID 分支 | ~15 行 |
| `tempctrl.c` | `read_status_ble` 扩展解析 | ~20 行 |
| `profile.conf` | 增加 PID 配置段 | ~25 行 |
| `MainHook.java` | `writeStatusFile` 增加回传 | ~20 行 |

**净增 ~255 行，改 0 行现有逻辑。**

---

## 2. 可复用现有参数（不新增）

| 计划曾拟新增 | 实际处理 | 理由 |
|-------------|---------|------|
| `PID_TARGET` | **复用 `BATT_BASELINE`** | 数值和含义完全相同 |
| `PID_RATE_LIMIT_RPM` | **复用 `RATE_LIMIT_RPM=250`** | 两 mode 共用同一限速 |
| `PID_RATE_LIMIT_COLD` | **复用 `RATE_LIMIT_COLD=20`** | 同上 |

PID 模式直接引用现有变量，不新增配置行。

---

## 3. 配置参数 (profile.conf)

```
# ── [8] PID 控制模式 ──
CTRL_MODE=0
# 0 = 现有离散档位 + 全套补偿
# 1 = PID 连续无级调节

# ── PID 核心参数（CTRL_MODE=1 生效）──
PID_KP=80              # 比例系数（÷1000，保守初值，建议实测上调至 300~500）
PID_KI=20              # 积分系数（÷1000，实际 0.020）
PID_KD=150             # 微分系数
PID_INTEGRAL_LIMIT=500 # 积分上限（÷1000，防饱和）

# ── 输入/输出滤波 ──
PID_BATT_ALPHA=30      # 电池温度 EMA 滤波（%，新值权重，30=新值占30%）
PID_OUTPUT_ALPHA=50    # PID 输出 EMA 平滑（%，新值权重，与电池滤波同一语义）

# ── 制冷强度范围 ──
PID_COLD_MIN=1         # 制冷片强度下限
PID_COLD_MAX=190       # 制冷片强度上限

# ── 制冷→风扇映射（指数曲线）──
PID_COLD_EXP=150       # n^exp（÷100，150=1.50），>1 低冷慢转
PID_RPM_MIN=2000       # 最低风扇转速
PID_RPM_MAX=6000       # 最高风扇转速

# ── 热端线性映射范围 ──
PID_HOT_MAP_MIN=350    # 热端映射最低温度（0.1°C），低于此值→PID_RPM_MIN
PID_HOT_MAP_MAX=450    # 热端映射最高温度（0.1°C），高于此值→PID_RPM_MAX
```

**复用现有参数：** `BATT_BASELINE`、`RATE_LIMIT_RPM`、`RATE_LIMIT_COLD`

---

## 4. 新增全局变量

```c
// --- PID 模式开关 ---
static int ctrl_mode = 0;                 // CTRL_MODE

// PID 参数
static int pid_kp = 80;                   // PID_KP
static int pid_ki = 20;                   // PID_KI（÷1000）
static int pid_kd = 150;                  // PID_KD
static int pid_integral_limit = 500;      // PID_INTEGRAL_LIMIT
static int pid_batt_alpha = 30;           // PID_BATT_ALPHA
static int pid_output_alpha = 50;         // PID_OUTPUT_ALPHA
static int pid_cold_min = 1;              // PID_COLD_MIN
static int pid_cold_max = 190;            // PID_COLD_MAX
static int pid_cold_exp = 150;            // PID_COLD_EXP（÷100）
static int pid_rpm_min = 2000;            // PID_RPM_MIN
static int pid_rpm_max = 6000;            // PID_RPM_MAX

static int pid_hot_map_min = 350;         // PID_HOT_MAP_MIN
static int pid_hot_map_max = 450;         // PID_HOT_MAP_MAX

// PID 运行状态
static int pid_integral = 0;              // 积分累积值
static int pid_prev_error = 0;            // 上周期误差（0.1°C）
static int pid_batt_filtered = -1;        // EMA 滤波后电池温度
static int pid_last_batt = -1;            // 上次参与 PID 计算的原始温度
static time_t pid_last_change_time = 0;   // 上次温度变化时间戳
static float pid_output_smoothed = 0.0f;  // 输出平滑值

// PID 初始化值（供 rate_limited_execute 读取）
static int pid_target_rpm = 2000;
static int pid_target_cold = 60;

// 散热器回传状态
static int cooler_hot_temp = -1;          // 热端温度（0.1°C，解析时 ×10）
```

---

## 5. PID 计算函数

```c
/**
 * PID 计算（温度变化时调用一次）
 * @param batt_10  电池温度（0.1°C），已 EMA 滤波
 * @param dt       自上次变化以来的实际秒数（钳位 3~30）
 * @return 归一化输出 0.0~1.0
 */
static float pid_compute(int batt_10, float dt) {
    // 1. 目标温度（复用 BATT_BASELINE）
    int target_10 = BATT_BASELINE;

    // 2. 误差 = 实际 - 目标（正 = 过热 = 需加强散热）
    int error_10 = batt_10 - target_10;
    float error = error_10 / 10.0f;

    // 3. P 项
    float p = (pid_kp / 1000.0f) * error;

    // 4. I 项（积分分离：±1.0°C 内才累积）
    if (error > -1.0f && error < 1.0f) {
        pid_integral += (pid_ki / 1000.0f) * error * dt;
    }
    float i_limit = pid_integral_limit / 1000.0f;
    if (pid_integral >  i_limit) pid_integral =  i_limit;
    if (pid_integral < -i_limit) pid_integral = -i_limit;

    // 5. D 项（首次跳过）
    float d = 0.0f;
    if (pid_prev_error != 0 || pid_last_batt >= 0) {
        d = (pid_kd / 1000.0f) * (error - pid_prev_error) / dt;
    }
    pid_prev_error = error;

    // 6. 钳位 0~1
    float raw = p + pid_integral + d;
    if (raw < 0.0f) raw = 0.0f;
    if (raw > 1.0f) raw = 1.0f;
    return raw;
}
```

---

## 5b. PID 参数调参指引

> 以下默认值为理论保守初值，**强烈建议真机实测标定**。

### 默认值特性分析

| 参数 | 值（÷1000） | 效果 | 说明 |
|------|------------|------|------|
| `PID_KP=80` | 0.080 | 2.5°C 误差 → P=0.20（20% 输出） | **保守偏低**，满输出需 12.5°C 误差 |
| `PID_KI=20` | 0.020 | dt=10s 时 0.5°C 误差 → 每周期 +0.10 | 积分限幅 ±0.50，防止 windup |
| `PID_KD=150` | 0.150 | 误差变化 1°C/10s → D=0.015 | 有效但易受传感器噪声干扰 |

### 建议调参步骤

1. **粗调 P**：将 `PID_KP` 上调至 300~500（÷1000=0.3~0.5），使中等误差（2~3°C）产生 50~70% 输出。观察稳态时是否有小幅振荡：
   - 振荡幅度过大 → 减小 KP
   - 响应太慢 → 增大 KP
2. **加 I 消静差**：保持 `PID_KI=20` 或略升至 30~50。观察长时间后温度是否收敛到目标值
3. **加 D 抑制过冲**：`PID_KD` 默认 150，若升温/降温过冲明显可加大至 200~300。注意温度传感器抖动可能导致微分项噪声放大
4. **最终微调**：三参数一起调整，每改一次观察至少 2~3 个完整升降温周期

### 调试打点建议

在真机测试阶段，建议用以下格式输出完整数据（详见 调试日志 节）：

```
[PID] epoch=123 Tbatt=358 Ttgt=360 Thot=420 dt=12s e=-0.20 P=-16 I=+12 D=-8 raw=0.18 sm=0.22 cold=35 rpm=2650
```

用 `grep '\[PID\]' /cache/tempctrl.log | awk '{print $3,$4,$5,$6,$7,$8,$9,$10,$11,$12,$13,$14}' > pid.csv` 可导出为 CSV，在 PC 上绘制控制曲线图辅助调参。

---

## 6. 制冷→RPM 映射（双路加权合并）

PID 输出 → 制冷强度（线性）→ RPM 由两路独立计算后加权合并：

```
一路：冷强度指数映射（供给侧）
  冷强度越大 → 热端需散热越多 → 风扇应越快
  公式：rpm_cold = min + n^exp × (max-min)

二路：热端温度线性映射（需求侧）
  热端温度越高 → 散热需求越迫切 → 风扇应越快
  公式：35°C→2000RPM, 45°C→6000RPM, 线性插值

合并：自加权平均
  权重 = 各自的 RPM 值（大者自动主导）
  final = (rpm_hot² + rpm_cold²) / (rpm_hot + rpm_cold)
```

特性：冷却需求（热端）和供给能力（冷强度）矛盾时，自动偏向数值更紧急的那一方。

```c
/**
 * 热端温度线性映射：PID_HOT_MAP_MIN → PID_RPM_MIN, PID_HOT_MAP_MAX → PID_RPM_MAX
 */
static int rpm_from_hot_end(int hot_10) {
    int range = pid_hot_map_max - pid_hot_map_min;
    if (range <= 0) return pid_rpm_min;  // 防除零
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
    if (rpm_hot + rpm_cold <= 0) return pid_rpm_min;  // 防除零
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
```

---

## 7. main_loop PID 分支

```c
void main_loop(void) {
    // (0) 热重载（共用）
    // ... 原代码 ...

    if (ctrl_mode == 0) {
        // ═══ 现有逻辑，原封不动 ═══
        return;
    }

    // ═══ PID 逻辑 ═══

    // 1. 紧急干预（共用）
    emergency_intervention();

    // 2. 读电池温度
    int batt_raw = read_battery_temp();
    if (batt_raw < 0) return;

    // 3. 输入 EMA 滤波
    if (pid_batt_filtered < 0) {
        pid_batt_filtered = batt_raw;
    } else {
        pid_batt_filtered = (batt_raw * pid_batt_alpha +
                             pid_batt_filtered * (100 - pid_batt_alpha)) / 100;
    }

    // 4. 温度变化时才执行 PID
    if (batt_raw != pid_last_batt) {
        time_t now = time(NULL);
        float dt = (float)(now - pid_last_change_time);
        if (dt > 30.0f) dt = 30.0f;
        if (dt < 3.0f)  dt = 3.0f;

        float pid_out = pid_compute(pid_batt_filtered, dt);

        // 输出 EMA 平滑（与电池滤波同一语义：alpha=新值权重）
        // PID_OUTPUT_ALPHA=50 → 新值 50%，历史 50%
        pid_output_smoothed = (pid_output_alpha * pid_out +
                               (100 - pid_output_alpha) * pid_output_smoothed) / 100.0f;

        // 紧急覆盖
        if (forced_min_level > 0 && emergency_level > 0) {
            float min_out = (float)(forced_min_level - level_min) /
                            (level_max - level_min);
            if (pid_output_smoothed < min_out)
                pid_output_smoothed = min_out;
        }

        // 映射到物理值
        pid_map_output(pid_output_smoothed,
                       &pid_target_cold, &pid_target_rpm);

        pid_last_batt = batt_raw;
        pid_last_change_time = now;
    }
}
```

---

## 8. rate_limited_execute PID 分支

```c
void rate_limited_execute(void) {
    if (ctrl_mode == 0) {
        // ═══ 现有逻辑 ═══
        return;
    }

    // ═══ PID 模式 ═══
    if (actual_rpm < 0)  actual_rpm  = pid_rpm_min;
    if (actual_cold < 0) actual_cold = pid_cold_min;

    // RPM 限速（复用 RATE_LIMIT_RPM）
    int diff_rpm = pid_target_rpm - actual_rpm;
    if (abs(diff_rpm) > RATE_LIMIT_RPM)
        actual_rpm += (diff_rpm > 0) ? RATE_LIMIT_RPM : -RATE_LIMIT_RPM;
    else
        actual_rpm = pid_target_rpm;

    // COLD 限速（复用 RATE_LIMIT_COLD）
    int diff_cold = pid_target_cold - actual_cold;
    if (abs(diff_cold) > RATE_LIMIT_COLD)
        actual_cold += (diff_cold > 0) ? RATE_LIMIT_COLD : -RATE_LIMIT_COLD;
    else
        actual_cold = pid_target_cold;

    // 统一下发：固定功率模式 mode=1
    apply_level_direct(1, 5, actual_rpm, actual_cold, 0);
}
```

> **执行周期**：PID 模式下 `rate_limited_execute` 调用周期保持 5s，与 gear 模式相同。因此 `RATE_LIMIT_RPM=250`（≈50 RPM/s）和 `RATE_LIMIT_COLD=20`（≈4/s）在两模式下的实际变化速率一致。

---

## 9. 直接下发函数（复用现有 am broadcast 逻辑）

```c
static void apply_level_direct(int mode, int target,
                               int rpm, int cold, int wl) {
    if (last_sent_valid &&
        mode == last_mode && rpm == last_windOC &&
        cold == last_coldOC && wl == last_windLevel)
        return;

    // fork + exec am broadcast（同现有 apply_level）
    // 直接复用它内部的 fork/exec 代码段
    // ...
}
```

可直接提取现有 `apply_level` 的 fork+exec 部分为内部函数，两个 mode 共用。

---

## 10. status 文件解析 & 散热器全参数回传

PID 控制器的双路 RPM 合并需要热端温度等实时参数；调试阶段需要用实际值对比下发值、判断散热器固件是否如实执行。LSPosed 模块通过已有的 `onDeviceInfoUpdate` 钩子捕获 `WaspWingInfo` 中的全部运行参数，写入 status 文件供 daemon 读取。

以下字段名和方法名均来自 smali 反编译确认（详见 `参考资料/apk逆向分析/smali/com/flydigi/sdk/waspwing/WaspWingInfo.smali`）。

### tempctrl 端（read_status_ble 扩展）

```c
// ── 新增全局变量（v2.3）
static int cooler_runmode = -1;          // 散热器实际运行模式
static int cooler_hot_temp = -1;         // 热端温度（℃）
static int cooler_cold_temp = -1;        // 冷端温度（℃，拼合为 0.1°C 单位）
static int cooler_cold_level = -1;       // 制冷强度（PWM 原始值）
static int cooler_rpm_level = -1;        // 风扇 PWM 档位（原始值）
static int cooler_rpm_real = -1;         // 实际风扇转速（经超频逻辑折算）
static int cooler_cold_real = -1;        // 实际制冷强度（经超频逻辑折算）
static int cooler_target_temp = -1;      // 目标温度（0.1°C）

// read_status_ble 扩展
while (fgets(line, sizeof(line), f)) {
    if      (strncmp(line, "BLE=", 4) == 0)
        app_ble_connected = atoi(line + 4) ? 1 : 0;
    else if (strncmp(line, "RUN_MODE=", 9) == 0)
        cooler_runmode = atoi(line + 9);
    else if (strncmp(line, "HOT_TEMP=", 9) == 0)
        cooler_hot_temp = atoi(line + 9);
    else if (strncmp(line, "COLD_TEMP=", 10) == 0)
        cooler_cold_temp = atoi(line + 10);
    else if (strncmp(line, "RPM_REAL=", 9) == 0)
        cooler_rpm_real = atoi(line + 9);
    else if (strncmp(line, "RPM_LEVEL=", 10) == 0)
        cooler_rpm_level = atoi(line + 10);
    else if (strncmp(line, "COLD_REAL=", 10) == 0)
        cooler_cold_real = atoi(line + 10);
    else if (strncmp(line, "COLD_LEVEL=", 11) == 0)
        cooler_cold_level = atoi(line + 11);
    else if (strncmp(line, "TARGET_TEMP=", 12) == 0)
        cooler_target_temp = atoi(line + 12);
}
```

### LSPosed 端（MainHook.java）

利用已有的 `onDeviceInfoUpdate` 钩子，全部通过反射调用对应 getter 来提取散热器实时参数：

```java
// ========== 散热器全参数回传（v2.3） ==========
private static Object lastWaspWingInfo = null;

// 在已有 SDK onDeviceInfoUpdate 钩子的 afterHookedMethod 中追加这一行：
// lastWaspWingInfo = param.args[0];

private static void writeStatusFile() {
    try {
        FileOutputStream fos = new FileOutputStream(STATUS_FILE);
        StringBuilder sb = new StringBuilder();
        sb.append("BLE=").append(bleConnected ? "1" : "0").append("\n");

        try {
            if (lastWaspWingInfo != null) {
                // 运行模式：getRunMode() → 0=固定功率(手动), 1=智能
                Object runMode = XposedHelpers.callMethod(lastWaspWingInfo, "getRunMode");
                if (runMode != null)
                    sb.append("RUN_MODE=").append(runMode).append("\n");

                // 热端温度：getHotSurfaceTemperature() → byte(°C) → 0.1°C
                Object hot = XposedHelpers.callMethod(lastWaspWingInfo, "getHotSurfaceTemperature");
                if (hot != null)
                    sb.append("HOT_TEMP=").append(((Integer)hot) * 10).append("\n");

                // 冷端温度：getTemperature()(整数) + getTemperatureDecimal()(小数位) → 0.1°C
                Object cold = XposedHelpers.callMethod(lastWaspWingInfo, "getTemperature");
                Object coldDec = XposedHelpers.callMethod(lastWaspWingInfo, "getTemperatureDecimal");
                if (cold != null && coldDec != null) {
                    int c = (Integer)cold;
                    int d = (Integer)coldDec;
                    if (d >= 10) d = (d + 5) / 10;  // 多位小数 → 四舍五入到 0.1°C
                    sb.append("COLD_TEMP=").append(c * 10 + d).append("\n");
                }

                // 实际风扇转速（经超频逻辑折算）：getRealWindLevel()，后接 PWM 原始值
                Object rpmReal = XposedHelpers.callMethod(lastWaspWingInfo, "getRealWindLevel");
                if (rpmReal != null)
                    sb.append("RPM_REAL=").append(rpmReal).append("\n");
                Object windLv = XposedHelpers.callMethod(lastWaspWingInfo, "getWindLevel");
                if (windLv != null)
                    sb.append("RPM_LEVEL=").append(windLv).append("\n");

                // 实际制冷强度（经超频逻辑折算）：getRealColdLevel()，后接 PWM 原始值
                Object coldReal = XposedHelpers.callMethod(lastWaspWingInfo, "getRealColdLevel");
                if (coldReal != null)
                    sb.append("COLD_REAL=").append(coldReal).append("\n");
                Object coldLv = XposedHelpers.callMethod(lastWaspWingInfo, "getColdLevel");
                if (coldLv != null)
                    sb.append("COLD_LEVEL=").append(coldLv).append("\n");

                // 目标温度：getTargetTemperature() → °C → 0.1°C
                Object tgtTemp = XposedHelpers.callMethod(lastWaspWingInfo, "getTargetTemperature");
                if (tgtTemp != null)
                    sb.append("TARGET_TEMP=").append(((Integer)tgtTemp) * 10).append("\n");
            }
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 参数回传异常: " + t.getMessage());
        }

        fos.write(sb.toString().getBytes());
        fos.close();
    } catch (Exception e) {
        XposedBridge.log(TAG + " 写入状态文件失败: " + e.getMessage());
    }
}
```

> 注意：`getRealWindLevel()` / `getRealColdLevel()` 内部逻辑是当 `runMode==0`(固定功率) 且 `overClockUsable==true` 时返回 overclock 值，否则返回普通 windLevel/coldLevel。daemon 侧可以对比 `RPM_LEVEL`(原始) 和 `RPM_REAL`(实际) 判断散热器是否处于超频状态。

### 数据流

```
散热器硬件 → GATT 特征值 → WaspWingDataInteractionController
    → onDeviceInfoUpdate(WaspWingInfo) → [Xposed 钩子] lastWaspWingInfo = info
    → writeStatusFile() 每 5s 写入全部参数
    → /data/local/tmp/tempctrl.status
    → tempctrl read_status_ble() 逐行解析
    → pid_map_output() rpm_from_hot_end() / 调试日志对比下发 vs 实际
```

### 调试验证

```bash
adb shell cat /data/local/tmp/tempctrl.status
# 期望输出示例：
# BLE=1
# RUN_MODE=1
# HOT_TEMP=420        ← 42.0°C 的内部单位（0.1°C）
# COLD_TEMP=58         ← 5.8°C 的内部单位（0.1°C）
# RPM_REAL=77
# RPM_LEVEL=77
# COLD_REAL=115
# COLD_LEVEL=115
# TARGET_TEMP=180     ← 18°C 的内部单位（0.1°C）

adb logcat -s WaspWingTempCtrl | grep "参数回传\|onDeviceInfoUpdate"
```

---

## 11. 模式切换对齐

CTRL_MODE 0→1 热切换时，从当前 gear 状态对齐 PID 初始值：

```c
static void pid_align_from_gear(void) {
    float ratio = (float)(battery_fan_level - level_min) /
                  (level_max - level_min);
    pid_output_smoothed = ratio;
    pid_target_rpm  = pid_rpm_min + (int)(ratio * (pid_rpm_max - pid_rpm_min));
    pid_target_cold = pid_cold_min + (int)(ratio * (pid_cold_max - pid_cold_min));
    pid_integral       = 0;
    pid_prev_error     = 0;
    pid_batt_filtered  = -1;
    pid_last_batt      = -1;
    last_sent_valid    = 0;
}
```

在 `load_config` 中检测到 `CTRL_MODE` 变化时调用。

---

## 12. 编译

```bash
# CI build.yml 编译命令增加 -lm
aarch64-linux-android21-clang -static -O2 tempctrl.c -lm -o tempctrl
```

`-lm` 增加 ~48KB 二进制体积（`powf` 用于 `PID_COLD_EXP` 指数映射）。

**头文件：** 在 tempctrl.c 已有 `#include` 列表中加入 `#include <math.h>`（提供 `powf`）。

---

## 13. 调试日志

```c
static int debug_pid = 0;           // [PID] 分区，profile.conf 新增

#define pid_log(fmt, ...) \
    do { if (debug_mode && debug_pid) \
        write_log("[PID] " fmt, ##__VA_ARGS__); \
    } while(0)

// 输出示例：
// [PID] epoch=123 Tbatt=358 Ttgt=360 Thot=420 dt=12s e=-0.20 P=-16 I=+12 D=-8 raw=0.18 sm=0.22 cold=35 rpm=2650
// [PID] cold=72 rpm=2987 (cold_exp=2714 hot_map=3200)
// [PID] apply mode=1 windOC=2987 coldOC=72

// CSV 提取（PC 端绘图调参用）：
// grep '\[PID\]' /cache/tempctrl.log | awk '{print $3,$4,$5,$6,$7,$8,$9,$10,$11,$12}' > pid_data.csv
```

---

## 14. 实施步骤

| 步 | 内容 | 验证 |
|----|------|------|
| 1 | 新增全局变量 + 默认值 | 编译通过 |
| 2 | 实现 `pid_compute()` | 代码审查 |
| 3 | 实现 `pid_map_output()` | 含 `powf`，确认 `-lm` |
| 4 | 实现 `apply_level_direct()` | 代码审查 |
| 5 | 实现 `pid_align_from_gear()` | 代码审查 |
| 6 | `load_config` 增加 PID 参数解析 + 切换检测 | 编译通过 |
| 7 | `main_loop` 增加 PID 分支 | 编译通过 |
| 8 | `rate_limited_execute` 增加 PID 分支 | 编译通过 |
| 9 | `read_status_ble` 扩展 | 编译通过 |
| 10 | `profile.conf` 增加配置段 | 格式检查 |
| 11 | CI build.yml 加 `-lm` | Actions 通过 |
| 12 | `MainHook.java` 扩展（可选） | 编译通过 |
| 13 | 真机回归（CTRL_MODE=0） | 行为不变 |
| 14 | 真机测试（CTRL_MODE=1） | 调参 |

---

## 15. 参数速查

| 参数 | 复用/新增 | 默认值 | 说明 |
|------|----------|--------|------|
| `CTRL_MODE` | 新增 | 0 | 0=gear，1=PID |
| `PID_KP` | 新增 | 80 | 比例系数（÷1000，保守初值，建议实测上调至300~500） |
| `PID_KI` | 新增 | 20 | 积分系数（÷1000） |
| `PID_KD` | 新增 | 150 | 微分系数 |
| `PID_INTEGRAL_LIMIT` | 新增 | 500 | 积分防饱和（÷1000） |
| `PID_BATT_ALPHA` | 新增 | 30 | 电池 EMA 滤波（%，新值权重） |
| `PID_OUTPUT_ALPHA` | 新增 | 50 | 输出 EMA 平滑（%，新值权重，与电池滤波同一语义） |
| `PID_COLD_MIN` | 新增 | 1 | 制冷片强度下限 |
| `PID_COLD_MAX` | 新增 | 190 | 制冷片强度上限 |
| `PID_COLD_EXP` | 新增 | 150 | n^exp 指数（÷100） |
| `PID_RPM_MIN` | 新增 | 2000 | 最低风扇 RPM |
| `PID_RPM_MAX` | 新增 | 6000 | 最高风扇 RPM |
| `PID_HOT_MAP_MIN` | 新增 | 350 | 热端映射最低温 (0.1°C) |
| `PID_HOT_MAP_MAX` | 新增 | 450 | 热端映射最高温 (0.1°C) |
| `BATT_BASELINE` | **复用** | 350 | 目标温度 (0.1°C) |
| `RATE_LIMIT_RPM` | **复用** | 250 | 每周期最大 RPM 变化 |
| `RATE_LIMIT_COLD` | **复用** | 20 | 每周期最大冷强度变化 |

---

## 16. LSPosed 模块 v2.3 待办

以下为 LSPosed 模块（`lsp模块(apk修复+温控接口)/`）在本次 PID 方案中需要完成的增量修改。

### 16.1 散热器全参数回传

所有字段名和方法名已通过 smali 反编译确认（`参考资料/apk逆向分析/smali/.../WaspWingInfo.smali`）：

| 项 | status 行 | getter | 输出单位 | 优先级 |
|----|-----------|--------|---------|--------|
| 1 | `onDeviceInfoUpdate` 钩子中捕获 `WaspWingInfo` 对象 | — | — | 🔴 高 |
| 2 | `RUN_MODE=` | `getRunMode()` | int | 🔴 高 |
| 3 | `HOT_TEMP=` | `getHotSurfaceTemperature()` | 0.1°C（byte°C×10） | 🔴 高 |
| 4 | `COLD_TEMP=` | `getTemperature()` + `getTemperatureDecimal()` | 0.1°C（int×10+小数位，四舍五入到0.1） | 🔴 高 |
| 5 | `RPM_REAL=` | `getRealWindLevel()` | int | 🔴 高 |
| 6 | `RPM_LEVEL=` | `getWindLevel()` | int (PWM，跟在 RPM_REAL 后) | 🔴 高 |
| 7 | `COLD_REAL=` | `getRealColdLevel()` | int | 🔴 高 |
| 8 | `COLD_LEVEL=` | `getColdLevel()` | int (PWM，跟在 COLD_REAL 后) | 🔴 高 |
| 9 | `TARGET_TEMP=` | `getTargetTemperature()` | 0.1°C（int°C×10） | 🔴 高 |

详见 [§10](#10-status-文件解析--散热器全参数回传)。

### 16.2 推荐作用域（xposedscope）

在 LSPosed 管理器中显示推荐勾选的应用 `com.flydigi.waspwing.experimental`。

**① 新建 `app/src/main/res/values/arrays.xml`：**
```xml
<resources>
    <string-array name="xposed_scope">
        <item>com.flydigi.waspwing.experimental</item>
    </string-array>
</resources>
```

**② `AndroidManifest.xml` 的 `<application>` 内追加：**
```xml
<meta-data
    android:name="xposedscope"
    android:resource="@array/xposed_scope" />
```

### 16.3 编译 & CI

| 项 | 内容 | 验证 |
|----|------|------|
| 1 | 编译 `MainHook.java` 增量修改 | `./gradlew assembleRelease` 通过 |
| 2 | 回归测试：CTRL_MODE=0 模式不受影响 | 行为不变 |
| 3 | 真机验证 status 文件回传参数 | `adb shell cat /data/local/tmp/tempctrl.status`
