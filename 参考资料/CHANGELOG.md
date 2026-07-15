# 更新日志

> 格式：[Keep a Changelog](https://keepachangelog.com/zh-CN/1.1.0/)

## v2.4（2026-07-17）

### Changed
- **配置解析重组**：去掉分组子守卫（CURRENT_GEAR_MODE/ctrl_mode/gear_config_enabled 等），PERF_ENABLED=1 时所有参数全量解析。只有两层：PERF_ENABLED 控制除 DEBUG_* 外的全部参数，DEBUG_ENABLED 控制 8 个调试子开关。LOG_FILE/LOG_MAX_KB 归 PERF_ENABLED 管理（不再固定解析）。配置文件参数顺序不再影响解析结果。

### Fixed
- 文档参数名与实际代码不一致问题（BATT_ZONE→BATT_BOUNDARY、BATT_RECOVERY→EMERG_RECOVERY_MULT、PID_* 前缀等）

## v2.3（2026-07-09）

### Added
- **GEAR_AUTO_FAN**：挡位模式自动风扇转速（`profile.conf` [7] 挡位表段）。默认 =1，使用冷端强度+热端温度双映射计算风扇转速，挡位表风扇转速配置变为截断上限；=0 恢复旧行为
- **LOG_TRIM_LINES**：日志超限时删除最早 N 行改为可配置（默认 3，0=不清理，`profile.conf` [1] 日志段）
- **PID 连续无级调节模式**（`CTRL_MODE=1`）：P+I(积分分离±1°C)+D 控制器，归一化输出 0~1，输入 EMA 滤波
- **mtime 温度检测**（替代 `BATT_SKIP_MAX`）：通过 `stat()` 检查电池温度 sysfs 文件修改时间，仅 mtime 变化时读取，`batt_temp_updated` 标记通知各函数。Gear 和 PID 模式跳过逻辑改为「温度文件未更新 → 跳过」
- **制冷→RPM 映射引擎**：冷端指数映射（`PID_COLD_EXP`）+ 热端线性映射 + 自加权合并，PID/常规模式共享
- **限速统一下沉**：RPM/制冷/目标温度限速从 `rate_limited_execute` 内建到 `apply_level`/`apply_level_direct` 内部，计算层只管传目标值
- **`CTRL_MODE` 加入配置预扫描**，PID 关闭时 PID 控制参数（KP/KI/KD 等）跳过加载
- **`send_am_broadcast()`**：提取公共 fork+exec 代码，`apply_level`/`apply_level_direct` 共享

### Changed
- **删除所有参数下发日志**：不再记录 `[PID] ...°C 冷... RPM...` 和 `apply_level 下发 档位...` 等包含实际下发参数的日志行，保留错误/跳过日志
- **风扇转速向上取整到 50 的倍数**：所有通过 `am broadcast` 发送的 RPM 值自动 `((rpm + 49) / 50) * 50`
- `write_log` 日志清理行数改为由 `LOG_TRIM_LINES` 控制（默认 3），硬编码 2 行删除已移除
- 编译命令添加 `-ffunction-sections -fdata-sections -Wl,--gc-sections -Wl,--strip-all`，二进制体积减少约 30%
- `read_status_ble()` 扩展为 10 字段解析（含 RUN_MODE/HOT_TEMP/COLD_TEMP/RPM_REAL/COLD_REAL 等散热器全参数回传）
- 持久化从档位号改为制冷强度：`save_gear`→`save_cold`，`load_gear`→`load_cold`；PID 模式也参与存档，重启不再丢失状态
- `write_log` 日志滚动优化：超标后仅删除最早行而非全部重写
- 冷却期逻辑：退出紧急时立即复位趋势豁免/反补累积，防止脏数据
- 配置解析重构为分组结构：CTRL_MODE / CURRENT_GEAR_MODE / DEBUG_MODE 以 `else if` 外层分支组织子项，代码反映"大类→子项"层级
- PID 输入补偿（方案 A）：CPU 温差和电池电流作为额外热源加到 PID 输入温度，每周期更新、独立触发 PID 重算，PID 日志增加补偿值分解输出
- **配置文件重构**：性能与调试开关分离层级
  - `CONFIG_ENABLED` → `PERF_ENABLED`（只管理性能参数：挡位表、PID、紧急、速率限制等）
  - `DEBUG_MODE` → `DEBUG_ENABLED`（提升为与 `PERF_ENABLED` 平级的独立总开关）
  - 日志路径（`LOG_FILE`）和大小（`LOG_MAX_KB`）归 `PERF_ENABLED` 管理
  - 配置文件中「日志 & 调试」和「sysfs 路径与缩放」部分互换前后位置
  - `load_config` 中 `perf_enabled` 守卫包裹所有性能参数；debug 子项分组独立于 `perf_enabled`
  - `DEBUG_PID` 从 PID 分组移至调试子项分组，归 `DEBUG_ENABLED` 统一管理
  - 所有 debug 分区开关默认值改为 0
  - `PERF_ENABLED` 默认值改为 0（需用户主动开启）
  - 移除 `STATUS_TIMEOUT` 配置项：默认值改为 12，不可从配置覆盖

### Fixed
- `compute_direct_cold_rpm` 除零 bug（`level_max==level_min` 时分母为 0）
- 配置热重载 CTRL_MODE 切换未正确触发 PID 对齐
- 电流-挡位映射模式下 `curr_gear_temp_offset` 被冷却期阻挡无法下降：冷却期内只减计数器不计算偏移，从 +91 归零需要约 10 分钟。修复后每周期都计算偏移，冷却期仅阻止同方向累积，反方向随时可调
- **配置解析 [组 1] `else if` 过度贪婪**：`CURRENT_GEAR_MODE` 默认开启时吞掉所有未匹配 Group 0 的 key，导致 PID 参数（含 `PID_KP`/`PID_KI`/`PID_KD`/`DEBUG_PID` 等）从未从 profile.conf 加载成功，全部使用硬编码默认值。修复：Group 1 额外检查 `strncmp(key, "CURRENT_GEAR_", 13) == 0`，非 `CURRENT_GEAR_*` key 正常透传到后续分组
- **LSPosed `experimentalRunModeValue` 设错导致 App 自修复与 PID 竞争 BLE 命令队列**：原逻辑将 `experimentalRunModeValue` 设为 `lastSetColdOC`（如 189），App 自修复条件要求 `experimentalRunModeValue == realColdLevel + 1`，189 不等于 realCold+1（125→188），导致自修复每周期都发 `setExperimentalRunMode` 命令覆盖 PID 的 `setRunMode`。前台越久 BLE 队列越膨胀，PID 命令严重延迟，冷强度卡在自修复设定的值上。修复：改为 `realColdLevel + 1` 满足条件，自修复静默跳过

### lsp模块
- `writeStatusFile()` 扩展为完整的 10 行 status 协议（含散热器全参数回传）
- 新增 `xposedscope` 元数据，管理器显示推荐作用域
- 捕获 `onDeviceInfoUpdate` 参数对象供回传使用
- 修复参数回传钩子指向：追加 `WaspWingViewModel.onDeviceInfoUpdate`（app 层），散热器数据实际经过此类而非 SDK 的 `WaspwingViewModel`
- **后台自动重连**：捕获 BLE 设备引用，断连后立即通过 `WaspWingManager.connectGattWith()` 经由 SDK 自身重连通道恢复连接，无需 Activity。支持远程断联（散热器出范围）和主动断联两种场景

### 注意
- DIRECT_COLD_MODE 已在 v2.3 开发过程中删除，未进入发布版本

---

## v2.2（2026-07-03）

### Added
- **电流-挡位映射 + 温度融合模式**：以电池电流为推荐挡位依据，温度在此基础累积偏移（带冷却期）。分充电/放电两套倍率，`CURRENT_GEAR_MODE` 两数字开关控制。推荐挡位变化时偏移自动继承，无偏移上限
- **独立开关**：`EMERG_CURRENT_ENABLED`（默认关闭）、`EMERG_CPU_ENABLED`、`REV_COMP_ENABLED`、`TREND_EXEMPT_ENABLED`，各功能模块独立控制，配置文件热重载即生效
- **调试日志系统**：`DEBUG_MODE` 总开关 + 7 个分区开关（传感器/紧急/电池/执行/连接/配置/主循环），开启时自动关闭日志体积限制
- **配置预扫描**：`load_config` 先解析所有开关/模式参数，关闭时跳过对应详细参数，提升热重载效率

### Changed
- **电流单位优化**：原始 µA ÷10000 转 0.01A 内部单位，放电负值不再被当作传感器错误
- `CURRENT_GEAR_MODE` 默认改为 `1 1`（充电放电全开）
- `CURRENT_GEAR_OFFSET` 参数删除（温度偏移不再设上限，由 `level_min`/`level_max` 钳位）
- 电流映射模式不再享有冷却豁免，遵守 `BATT_COOLDOWN_CYCLES` 配置

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
- **默认档位表改为全部固定功率模式**（mode=1）：智能温控模式的风扇转速上限非强制生效，易突破上限导致噪音突增
- **决策与执行分离**：`main_loop` 纯计算不下发，`rate_limited_execute` 负责带速率限制执行
- **逐档变动机制已移除**：改为限制每个参数单次循环的变化量
- CPU 温度扫描优化：不再每次扫描所有 zone，只使用最高的 20 个值
- 电流紧急降级判断改为使用 EMA 平滑值
- 反补改为平均每周期温度变化值（温差÷空闲周期数），支持冷却期累积

### Fixed
- 风扇每周期转速限制失效（RPM 平滑跟踪修复）
- 高温时退出紧急的降档幅度限制
- 断开重连温度突变屏蔽

### lsp模块
- 修了一些bug

---

## v2.0（2026-06-15）

### Added
- **C 智能温控守护程序（tempctrl）**：电池/CPU 双温控决策，通过 `am broadcast` 发送指令到 LSPosed 模块
- **LSPosed 模块的 `com.flydigi.SET_TEMPERATURE` 广播接收器**：支持 7 参数完整控制
- **双重检查存活检测**：status 文件 mtime 心跳 + BLE=1
- **阈值运行时可配置**：`profile.conf` 支持 mtime 热重载
- **查表法档位系统**：1~12 级，趋势豁免 + 峰值反补合并逻辑

### Changed
- ~~FIFO 通信~~ → 已废弃，改用 status 文件心跳
- ~~pgrep 进程检测~~ → 已移除，改用 mtime 心跳 + BLE=1 双重检查
- 日志：持 FILE\* 替代每行 open/close，超限自动滚动

### Fixed
- LSPosed 模块 DefaultDispatcher 线程 100% CPU 占用（`runFetchLoop` 空队列忙等修复）
- 脚本数组越界导致最高档风扇转速异常

---

## v1.0（2026-06-08）

### Added
- LSPosed 模块（`MainHook.java`）修复 Android 16 BLE 无法连接问题

### Fixed
- 第 1 层：设备连接后扫描不停止 → 钩 `onDeviceConnected` → `stopScan()`
- 第 2 层：UI 不更新 → 钩 `onDeviceConnected` → 手动更新 LiveData
- 第 3 层：GATT 服务发现不触发 → 强制 `checkBluetoothPermission()` 返回 true（Android 16 暗坑）
- 第 4 层：智能温控 UI 闪烁 → 去掉 `convertFromDevice` 早期创建 WaspWingInfo
