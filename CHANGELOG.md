# 更新日志

> 格式：[Keep a Changelog](https://keepachangelog.com/zh-CN/1.1.0/)


## v2.4（2026-07-29）

### Added
- **温度趋势预测算法**（`PID_PREDICT_MODE/WIN/RISE/MIN_DELTA`）：基于历史每周期温差变化趋势预测温度稳定点，peak/valley 检测 + per-cycle delta 归一化 + 线性减速模型 + 权重混合（加热/冷却独立权重），消除 PID 冷静期等待。含 ramp-up 渐进限制和过渡平滑
- **`read_batt_current_ua10()`**：封装电池电流读取，内部用 `BATT_CURRENT_DIVISOR` 做 µA→0.01A 转换，调用方直接使用 0.01A 单位值
- **`BATT_CURRENT_DIVISOR`**：电池电流缩放系数（默认 10000，可配置），替换硬编码 `÷10000`

### Changed
- **PID 输入增加温度预测层**：预测值经 ramp-up 钳位 + 权重混合后参与 PID 计算，`PID_ALPHA` 扩展为三值（新增预测平滑系数 50%）
- **反补/趋势豁免合并配置**：`REV_COMP_ENABLED` + `TREND_EXEMPT_ENABLED` → `REV_COMP=1 1`（双值开关）
- **紧急单源化**：`emergency_intervention()` 从 CPU+电流双源简化为 CPU 单源，紧急等级从 4 级降为 3 级；ramp-up 钳位精简（7 行 → 1 行 clamp），整体代码量 -25 行

### Removed
- **PID 电流补偿**：删除 `PID_CURR_COMP_ENABLED/THRESHOLD/DIVISOR` 全部逻辑
- **Gear 电流紧急**：删除 `CURRENT_EMERG/SMOOTH_ALPHA/EMERG_CURRENT_ENABLED` 全部逻辑
- **`read_battery_current_abs()`**：无调用方死代码
- **`BATT_CURRENT_DIVISOR` 旧实现**：后以新设计恢复

---

## v2.3（2026-07-09）

### Added
- **PID I 项方差门控 + 采样/死区**（`PID_KI_VAR_THRESHOLD/SAMPLES/DEADBAND`）：将积分分离条件从固定 ±1°C 改为温度方差门控。温度稳定（方差<阈值）时 I 项全温度段启用，消除稳态静差；温度波动时冻结 I 防 windup。回退死区（默认 ±1.5°C）在方差门控未激活或采样不足时生效
- **GEAR_AUTO_FAN**：挡位模式自动风扇转速（`profile.conf` [8] 挡位表段）。默认 =1，使用冷端强度+热端温度双映射计算风扇转速，挡位表风扇转速配置变为截断上限；=0 恢复旧行为
- **LOG_TRIM_LINES**：日志超限时删除最早 N 行改为可配置（默认 3，0=不清理，`profile.conf` [1] 日志段）
- **PID 连续无级调节模式**（`CTRL_MODE=1`）：P+I(积分分离±1°C)+D 控制器，归一化输出 0~1，输入 EMA 滤波
- **mtime 温度检测**（替代 `BATT_SKIP_MAX`）：通过 `stat()` 检查电池温度 sysfs 文件修改时间，仅 mtime 变化时读取，`batt_temp_updated` 标记通知各函数。Gear 和 PID 模式跳过逻辑改为「温度文件未更新 → 跳过」
- **制冷→RPM 映射引擎**：冷端指数映射（`PID_COLD_EXP`）+ 热端线性映射 + 自加权合并，PID/常规模式共享
- **限速统一下沉**：RPM/制冷/目标温度限速从 `rate_limited_execute` 内建到 `apply_level`/`apply_level_direct` 内部，计算层只管传目标值

### Changed
- **`pid_compute` 改为方差门控 + 死区回退**：从固定 `±1.0°C` 硬编码改为双层逻辑（新增 `PID_KI_VAR_THRESHOLD/SAMPLES/DEADBAND`）
- **删除所有参数下发日志**：不再记录 `[PID] ...°C 冷... RPM...` 和 `apply_level 下发 档位...` 等包含实际下发参数的日志行，保留错误/跳过日志
- **风扇 RPM 取整至 50 倍数**：`am broadcast` 发送的 RPM 值自动取整
- **日志管理优化**：`LOG_TRIM_LINES` 控制清理行数（默认 3），滚动只删最早行
- **编译优化**：段裁剪 + strip，二进制体积减少约 80%
- **`read_status_ble()` 扩展至 10 字段**：解析 RUN_MODE/HOT_TEMP/COLD_TEMP/RPM_REAL/COLD_REAL 等散热器全参数回传
- **持久化改为制冷强度**：`save_gear`→`save_cold`，`load_gear`→`load_cold`；PID 模式也参与存档，重启不再丢失状态
- **热端 RPM 双向滞回**（`rpm_from_hot_end`）：降温时有效温度 +1°C 使 RPM 滞后下降，升温时 RPM 不低于上次值（防止微升反降 RPM）
- **EMA 方向取整**（`EMA_DIR`）：所有整数 EMA 平滑改用方向取整宏，基于原始值方向决定舍入（上升→向上取整，下降→自然截断），消除渐进无法到达的问题。影响：CPU 温度滤波、电流紧急/挡位平滑、PID 电池输入滤波
- **速率限制温差动态化 + 0.1°C 精度**（`RATE_LIMIT_FAN_BASE`/`COLD_MULT`）：风扇升速和制冷强度速率不再固定，改为根据电池温度与基准温差（d=0.1°C）自动调整，使用 `d × mult / 10` 保留原始精度。风扇降速继续保持固定值。新增 `RATE_LIMIT_FAN_BASE`（双值：升基础值 升倍率）、`RATE_LIMIT_COLD_MULT` 配置参数
- **配置系统重构**：PERF_ENABLED/DEBUG_ENABLED 双层守卫替代分组子守卫；13 组多键参数改为连续值格式；`STATUS_TIMEOUT` 移除；配置参数顺序不再影响解析结果
- **PID 输入补偿**：引入 CPU 温差和电池电流作为额外模拟热源

### Fixed
- **文档参数名与实际代码不一致**：BATT_ZONE→BATT_BOUNDARY、BATT_RECOVERY→EMERG_RECOVERY_MULT、PID_* 前缀等
- **`compute_direct_cold_rpm` 除零 bug**：`level_max==level_min` 时分母为 0
- **配置热重载 CTRL_MODE 切换未触发 PID 对齐**
- **电流-挡位映射冷却期阻止偏移下降**：`curr_gear_temp_offset` 从 +91 归零需约 10 分钟，修复后冷却期仅阻止同方向累积，反方向随时可调
- **配置解析 [组 1] `else if` 过度贪婪**：`CURRENT_GEAR_MODE` 默认开启时吞掉所有未匹配 Group 0 的 key，导致 PID 参数（含 `PID_KP`/`PID_KI`/`PID_KD`/`DEBUG_PID` 等）从未从 profile.conf 加载成功，全部使用硬编码默认值。修复：Group 1 额外检查 `strncmp(key, "CURRENT_GEAR_", 13) == 0`，非 `CURRENT_GEAR_*` key 正常透传到后续分组
- **LSPosed `experimentalRunModeValue` 设错导致 App 自修复与 PID 竞争 BLE 命令队列**：原逻辑将 `experimentalRunModeValue` 设为 `lastSetColdOC`（如 189），App 自修复条件要求 `experimentalRunModeValue == realColdLevel + 1`，189 不等于 realCold+1（125→188），导致自修复每周期都发 `setExperimentalRunMode` 命令覆盖 PID 的 `setRunMode`。前台越久 BLE 队列越膨胀，PID 命令严重延迟，冷强度卡在自修复设定的值上。修复：改为 `realColdLevel + 1` 满足条件，自修复静默跳过

### lsp模块
- **`writeStatusFile()` 扩展**：完整的 10 行 status 协议（含散热器全参数回传）
- **`xposedscope` 元数据**：管理器显示推荐作用域
- **`onDeviceInfoUpdate` 参数捕获**：供散热器数据回传使用
- **修复参数回传钩子指向**：追加 `WaspWingViewModel.onDeviceInfoUpdate`（app 层），散热器数据实际经过此类而非 SDK 的 `WaspwingViewModel`
- **后台自动重连**：捕获 BLE 设备引用，断连后立即通过 `WaspWingManager.connectGattWith()` 经由 SDK 自身重连通道恢复连接，无需 Activity。支持远程断联（散热器出范围）和主动断联两种场景

### 注意
- **DIRECT_COLD_MODE 未进入发布版本**：在 v2.3 开发过程中删除

---

## v2.2（2026-07-03）

### Added
- **电流-挡位映射 + 温度融合模式**：以电池电流为推荐挡位依据，温度在此基础累积偏移（带冷却期）。分充电/放电两套倍率，`CURRENT_GEAR_MODE` 两数字开关控制。推荐挡位变化时偏移自动继承，无偏移上限
- **独立开关**：`EMERG_CURRENT_ENABLED`（默认关闭）、`EMERG_CPU_ENABLED`、`REV_COMP_ENABLED`、`TREND_EXEMPT_ENABLED`，各功能模块独立控制，配置文件热重载即生效
- **调试日志系统**：`DEBUG_MODE` 总开关 + 7 个分区开关（传感器/紧急/电池/执行/连接/配置/主循环），开启时自动关闭日志体积限制
- **配置预扫描**：`load_config` 先解析所有开关/模式参数，关闭时跳过对应详细参数，提升热重载效率

### Changed
- **电流单位优化**：原始 µA ÷10000 转 0.01A 内部单位，放电负值不再被当作传感器错误
- **`CURRENT_GEAR_MODE` 默认改为 `1 1`**：充电放电全开
- **`CURRENT_GEAR_OFFSET` 参数删除**：温度偏移不再设上限，由 `level_min`/`level_max` 钳位
- **电流映射冷却行为统一**：遵守 `BATT_COOLDOWN_CYCLES` 配置

### lsp模块
无更新

---

## v2.1（2026-06-18）

### Added
- **档位表可配置化**：`profile.conf` 支持 `GEAR_N=模式,目标°C,风扇RPM,制冷强度` 自定义覆盖，自动扩展档位数量
- **紧急 4 级**（需 CPU + 电流双源叠加）
- **紧急进入退出可选策略**：升档模式 / 降档模式，由 `EMERG_MODE` 控制
- **电池第三区间阈值**（`BATT_ZONE_3`）
- **紧急退出恢复期**：BATT_ZONE 阈值 ×6→×4→×2→1 逐步恢复全灵敏度，`BATT_RECOVERY_PHASE_CYCLES` 可配置
- **反补独立冷却**（`REV_COMP_COOLDOWN`）
- **速率限制参数可调**：`RATE_LIMIT_RPM`、`RATE_LIMIT_COLD`、`RATE_LIMIT_TEMP`

### Changed
- **默认档位表改为全部固定功率模式**：智能温控模式的风扇转速上限非强制生效，易突破上限导致噪音突增
- **决策与执行分离**：`main_loop` 纯计算不下发，`rate_limited_execute` 负责带速率限制执行
- **逐档变动→每周期限速**：改为限制每个参数单次循环的变化量
- **CPU 温度扫描优化**：仅保留温度最高的 20 个 zone
- **电流紧急降级使用 EMA 平滑**
- **反补改为平均每周期温差计算**：温差÷空闲周期数，支持冷却期累积

### Fixed
- **风扇每周期转速限制失效**：RPM 平滑跟踪修复
- **高温时退出紧急的降档幅度限制**
- **断开重连温度突变屏蔽**

### lsp模块
- **基础 bug 修复**

---

## v2.0（2026-06-15）

### Added
- **C 智能温控守护程序（tempctrl）**：电池/CPU 双温控决策，通过 `am broadcast` 发送指令到 LSPosed 模块
- **LSPosed 广播接收器**：`com.flydigi.SET_TEMPERATURE` 支持 7 参数完整控制
- **双重检查存活检测**：status 文件 mtime 心跳 + BLE=1
- **阈值运行时可配置**：`profile.conf` 支持 mtime 热重载
- **查表法档位系统**：1~12 级，趋势豁免 + 峰值反补合并逻辑

### Changed
- **FIFO 通信→status 文件**：改用 status 文件心跳
- **pgrep 进程检测→mtime 检测**：改用 mtime 心跳 + BLE=1 双重检查
- **日志 File\* 持久化**：替代每行 open/close，超限自动滚动

### Fixed
- **DefaultDispatcher 线程 100% CPU 占用**：`runFetchLoop` 空队列忙等修复
- **脚本数组越界导致最高档风扇转速异常**

---

## v1.0（2026-06-08）

### Added
- **LSPosed 模块修复 BLE 连接**：`MainHook.java` 修复 Android 16 BLE 无法连接问题

### Fixed
- **第 1 层**：设备连接后扫描不停止，钩 `onDeviceConnected` → `stopScan()`
- **第 2 层**：UI 不更新，钩 `onDeviceConnected` → 手动更新 LiveData
- **第 3 层**：GATT 服务发现不触发，强制 `checkBluetoothPermission()` 返回 true（Android 16 暗坑）
- **第 4 层**：智能温控 UI 闪烁，去掉 `convertFromDevice` 早期创建 WaspWingInfo
