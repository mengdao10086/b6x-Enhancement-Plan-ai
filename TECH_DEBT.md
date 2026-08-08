# 技术债与未解决问题记录

> 规则：
> - **未解决的问题**：只记录**可观察的现象与事实**（时间、版本、日志、复现条件、已验证排除项），**不记录分析推测与根因结论**——未确认的推测可能误导后续排查。
> - **已解决的问题**：说明清楚**问题原因与解决思路**，供后续参考（根因确认后补记结论）。

## 未解决区

（当前无未解决条目）

## 已解决区

### 1. PID 模式下风扇转速远滞后于制冷强度/热面温度（2026-08-05 发现，已解决）

**现象**：PID 模式（CTRL_MODE=1）下，风扇转速目标有概率长期显著低于制冷强度与热面温度所对应的需求，甚至完全卡死在低位，呈"制冷已拉满、热面已超温、风扇仍在中低转速"的状态，并非滤波/EMA 带来的轻微滞后。

**日志样例**：

```
[04 15:21:48] 35+3.0° b6x 冷190 热49° RPM3500
```

（`冷190`=制冷强度已到上限 190；`热49°`=热端 49°C，已超 HOT_MAP 上限 45°C；`RPM3500`=风扇目标仅 58% 满速）

**可复现环境**：
- 机型/散热器：b6x
- 配置：profile.conf 默认值（CTRL_MODE=1，PID 模式）
- 代码版本：当前工作区（v2.5+ 世代，含 WebUI 1s 数据文件架构、5s 控制节拍）
- 对照版本：`参考资料/c_historical_sources/tempctrl2.4.c`（v2.4，profile.conf 配置值一致）逻辑与本版基本一致，**无此现象**

**已验证排除项**（仅客观记录检查结果，不代表结论）：
- C 端限速公式、rate_limit 函数、5s 控制节拍与 v2.4 一致
- pid_compute（KP/KI/KD/方差门控/死区）与 v2.4 逐字一致
- CPU 补偿公式与 v2.4 一致
- 散热器回传参数读取（状态文件 HOT_TEMP/COLD_TEMP/RPM_REAL/COLD_REAL）与 v2.4 一致
- profile.conf 配置值与 v2.4 一致
- C→LSP 广播（send_am_broadcast）与 v2.4 逐字一致
- LSP 对 windOC/windLevel 为直传（setRunMode 7 参数），app 侧 mode=1 固定功率时 windOC 直接指定风扇转速

**待验证方向**（未执行，仅列出可验证的检查项）：
- 日志中是否存在频繁「连接丢失 / 重连 / 切换 / App 不存在」记录（STATUS_TIMEOUT 已由 5s 改为 3s）
- LSP 侧 XposedBridge 日志是否存在「实例未就绪 / setRunMode 失败」记录
- 对比 C 日志目标 RPM（send_rpm）与 WebUI 曲线显示的实际 RPM（cooler_rpm_real）是否长期偏离

**状态**：**已解决**。

2026-08-05 实施修正（事实记录）：风扇目标从 PID/Gear 输出链中解耦——新增 `compute_fan_target()`，每周期下发前独立使用限速后实际制冷（actual_cold）+ 热面温度（cooler_hot_temp）计算风扇目标；`pid_map_output` 不再输出 rpm；`apply_gear_direct` 简化为纯下发。

定性：**疑似"工程问题"**——控制逻辑与 v2.4 基本一致但 v2.4 无此现象，根因疑在工程实施层面的输出链耦合（风扇目标依附于 PID/Gear 输出），而非算法逻辑本身。

### 2. 温度变化检测大量异常跳过（2026-08-06 发现，已解决）

**现象**：电池温度实际在变化时，控制周期大量出现"温度未更新，跳过本周期"日志，控制长期不执行（疑似漏掉真实温度变化）。

**可复现环境**：
- 代码版本：v2.5+ 世代（温度变化检测基于 sysfs 文件 mtime 判断）
- 配置：与温度采样相关的任意配置

**已执行修正（2026-08-06，事实记录）**：
- 温度变化检测由"sysfs 文件 mtime 判断"退回**纯数值比较**（每秒读温度值，值与上次缓存不同才标记更新）。mtime 判断不可靠（疑似部分内核的 sysfs 温度文件 mtime 不随值变化更新），是大量跳过源头
- 5s 控制周期跳过判定改用"自上次控制以来 1s 层值变化累积"窗口判断，温度在窗口内变过又回到原位也不会漏判
- 恢复 `BATT_SKIP_MAX`（默认 6，可配置）卡死保护：值连续未变达上限时强制进入一次计算

### 3. LSP 模块加载失败导致所有钩子失效（2026-08-06 发现，已解决）

**现象**：重编 LSP 模块后，散热器 app 无论哪种方式打开都不自动跳转设置界面，且 Android 16 蓝牙"一直扫描中"修复失效——两者分属不同钩子路径（`autoStartSetup` 与 `hookControllerStopScan`），同时失效指向模块整体未加载，而非某个钩子逻辑。

**日志样例**（LSPosed 模块日志 `modules_2026-08-06T*.log`）：

```
Failed to load class com.example.waspwingtempctrl.MainHook
java.lang.ExceptionInInitializerError
Caused by: java.lang.NullPointerException: Attempt to read from field 'android.os.MessageQueue android.os.Looper.mQueue' on a null object reference in method 'void android.os.Handler.<init>'
	at com.example.waspwingtempctrl.MainHook.<clinit>(MainHook.java:66)
```

（同一错误在每次进程 fork 时重复出现）

**根因（已确认）**：`MainHook` 静态初始化里写了 `new Handler(Looper.getMainLooper())`。模块类在 **Zygote fork 阶段**即被加载（栈帧 `Zygote.forkUsap`），此刻主线程 Looper 尚未创建，`getMainLooper()` 返回 null，`new Handler(null)` 抛 NPE → `ExceptionInInitializerError` → 模块类初始化失败、所有钩子不注册。

**修正（2026-08-06，已真机验证）**：Handler 改为**懒加载**——静态字段仅声明，`mainHandler()` 方法首次调用（Activity.onCreate 主线程，Looper 必已就绪）时才创建；`postDelayed`/`removeCallbacks` 两个调用点改走 `mainHandler()`。

**教训**：LSP 模块类的静态初始化不能依赖主线程 Looper/UI 等运行时资源——模块类加载时机早于 app 主线程就绪，凡需 Handler 一律懒加载。

### 4. setRunMode 下发但散热器无反应（2026-08-08 发现，已解决）

**现象**：magisk 模块日志显示已下发 setRunMode 广播（`am broadcast ... mode=1 windOC=6000`），LSPosed 日志显示 `setRunMode 已下发` 无异常，但散热器不响应；app UI 显示已连接（蓝灯、可调节页面、参数回传正常）。

**机制（已确认，含故障注入验证）**：SDK 连接状态机（`LeDataInteractionController`，B6X 用其子类 `WaspWingDataInteractionController`）：
- `connectGatt()` → `mDataConnectState=1`（连接中）
- `onGattConnected`（GATT 成功回调）→ `mDataConnectState=2`（已连接）
- `onGattDisconnected` → `mDataConnectState=0`

`AbstractDataInteractionController.processData()` 严格检查 `mDataConnectState==2` 才 `writeToBluetoothDevice`，否则 logw `"Gatt hasn't connected"` 后丢弃命令（入队闸门 `addCommandToQueue` 只要求 `!=0`，发送闸门要求 `==2`，两者不同）。

**根因（已确认）**：`WaspWingManager.dataInteractionController` 是 **static 字段**，只在 `init()` 时赋值一次（WaspWingManager.smali:529 `new WaspWingDataInteractionController → sput-object`），app 重连/重建 controller 后 static **不自动指向新实例**。MainHook 调 `setRunMode` 走 static 旧实例，其 `mDataConnectState≠2` → 命令在 `processData` 被丢弃；而 app UI 用的是新连接实例（state=2），故 UI 显示已连接但命令不生效。

**验证（2026-08-08，故障注入）**：验证版 LSP 模块在 `invokeSetRunMode` 前强制 static controller `mDataConnectState=1`，散热器即无反应——症状与真实 bug 完全一致，坐实"非 2 状态丢弃命令"机制。

**修正（2026-08-08）**：
- 新增 `hookSyncConnectedController`：hook `LeDataInteractionController.onGattConnected`，GATT 连接成功时把 static `dataInteractionController` 同步指向当前已连接实例（此时 state=2、gatt 就绪、runFetchLoop 在跑），从根上消除实例不一致
- `invokeSetRunMode` 增加状态自愈兜底：static controller 若 gatt 已就绪但 state≠2，强制置 2

**教训**：SDK static 单例字段可能在重连后被 app 替换为新实例而不更新 static 引用，外部 hook 调用方必须保证引用的实例与 app 实际连接实例一致；排查"命令下发无反应"要同时检查入队闸门与发送闸门的连接状态判断。
