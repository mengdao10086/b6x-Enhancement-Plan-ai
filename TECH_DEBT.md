# 技术债与未解决问题记录

> 规则：
> - **未解决的问题**：只记录**可观察的现象与事实**（时间、版本、日志、复现条件、已验证排除项），**不记录分析推测与根因结论**——未确认的推测可能误导后续排查。
> - **已解决的问题**：说明清楚**问题原因与解决思路**，供后续参考（根因确认后补记结论）。

## 未解决区

### 1. 散热器偶发锁制冷 125 / 风扇 4500，tempctrl 下发无效（2026-08-11 发现，未解决）

**现象**：散热器偶发停在制冷 125、风扇 4500，tempctrl（magisk 守护进程）持续下发新参数但散热器不响应；常在 BLE 重连后出现（多次快速重连更易触发），偶发无重连也出现。LSP 日志（`D:\下载\LocalSend`）显示下发与回传长期偏离。**当前所有自愈措施触发后仍偶发**（未根治）。

**已确认机制**（三层证据链，非未确认推测；供后续排查不重复推导）：
1. **4500/125 不是任何一方下发的值**：日志中 tempctrl 下发的 windOC/coldOC 组合（3100/168、4800/144、4900/183、5250/190、5550/190 等）从未包含 4500/125——这是设备固件在"未收到有效控制命令"时的默认固定功率档（0x13 回传 `coldLevelOverclock=byte[0xd]=125`、`windLevelOverclock=byte[0xc]×100+byte[0x13]=45×100`）
2. **多 controller 实例竞态**：B6X 重连时 SDK 可能创建多个 controller 实例并各自触发 `onGattConnected`，static `dataInteractionController` 指向"最后连接成功"的实例，可能并非正在接收 0x13 状态包的实例
3. **两处命令静默丢弃点**：`AbstractDataInteractionController.processData` 的 `mDataConnectState != 2` 出队即丢；`LeDataInteractionController.writeToBluetoothDevice` 只检查 `mBluetoothGatt != null` 不检查已连接，失效 gatt 的 `writeCharacteristic` 静默返回 false（state==2 也拦不住）

**已尝试的解决**（均未根治，仅降低频率/待真机验证）：
- [2026-08-11] **下发前校验** `ensureUsableController()`：每次 `invokeSetRunMode` 前校验 static controller 的 gatt 是否等于当前有效连接（`currentValidGatt`，连接成功记录、断连清空）；失效时从已连接实例注册表（`connectedControllers`）找回 gatt 有效实例重新同步，找不到则强制重连
- [2026-08-11] **锁死自愈** `checkCommandStall()`：累计 3 次参数下发后回传仍停滞且 ≠ 下发目标判定锁死 → 强制重连（10s 防抖）；回传到位或回传在变均清零，避免误判限速追赶
- [2026-08-11] 覆盖 B6X 新旧 app（`com.flydigi.waspwing.experimental` 与 `com.flydigi.waspwing.experimentanliuliu`）与 B7X（混淆 `t9.j`/`a`）同一套逻辑
- [2026-08-11] **守护消费线程**（相关后续，见已解决区条目 5「命令消费协程崩溃」）：重连级自愈对"命令消费协程 `runFetchLoop` 崩溃"场景无效（锁 82/2000，最后成功命令残留态），新增双信号判断（命令队列堆积 >6 条 + 回传停滞 ≥3 次下发）+ 守护消费线程反射接管 `processData`——重连无法恢复进程级协程，须以队列堆积为判据独立兜底

**状态**：**未解决**——锁 125/4500 仍偶发；待真机长期验证上述自愈是否足以覆盖，或进一步定位固件级根因。

### 3. 合并后真机未验证项（2026-09-20 记录，待真机验证）

**背景**：Magisk 模块合并进 APK（v3.0）后，下列各项只有**源码级证据**，从未在设备上跑过——合并不算"已跑通过一次闭环"。

1. **`service.d` 冷启动拉起与幂等** — 脚本负责 `pkill → 轮询 pgrep 等真退出 → 启动 → renice`；看门狗每轮自检「脚本文件与二进制是否还在」，任一不在则**静默退出**（写盘会把已删的日志文件建回来，故不能记日志）。KernelSU 版本分界（`KSU_VER_CODE < 10683` 走 `/data/adb/ksu/service.d`，靠 `ksud -V` 解析，解析不到落 `/data/adb/service.d`）、目录需 `mkdir -p`、FBE 解锁时机（靠等亮屏规避）均未验。
2. **root 往返** — `su` 嗅探与命令行选型在真机上是否可用；`magisk` 不在 app 进程的 PATH 里，`magisk su -mm` 那一支可能起不来（已用「退回裸 su」+ 手动切换兜底）。
3. **SELinux 标签假设** — `tempctrl.log` 与 `tempctrl_webui.data` 由 root 的 daemon 在 app 私有目录创建，其标签是否让 app 直读**未知**。已做防御性处置：部署时由 **app 自身 uid**（非 root）预创建这两个空文件，仅不存在时建。轮转机制已由源码核实（非真机）是 `O_RDWR` + `ftruncate` **原地截断、不 rename 不重建**，故预创建不会被打回 root 创建。**未覆盖面**：二进制被改名、或 `LOG_FILE` 被改成别的文件名。界面读失败时按原样报错并给出含 errno 的诊断串，不静默。
4. **私有目录创建** — daemon 的 `mkdir` 只建一层、父目录不存在即 ENOENT 失败（刻意不逐级创建，避免 root 抢建 app 数据目录）；`files/` 若由 root 先建，其 SELinux 标签与属主是否与系统建的一致，未验。
5. **参数校验审计的盲区** — `params.json` 与 C 端 clamp 的一致性由 `python 参数定义/check_params.py --audit` 自动核对（当前漂移 0 条），但脚本自己列出 7 处 C 端 clamp 与若干路径/布尔键**无法自动核对**，靠人工；另有一条已知盲区：核对规则里 `.log` 后缀写死，二进制改名会让核对仍通过。

**状态**：**未验证**。上述任一条失败都会让"合并已可用"这个结论不成立，须逐条在真机上过。

### 4. 第四轮（v3.0 内）改动包的未验证项（2026-09-21 记录，待真机验证）

**背景**：v3.0 合并后的第四轮改动（状态页刷新与按钮重排、拉起改先停再起、二进制哈希弹窗、参数输入框宽度、日志页搜索框移位、设置页参数重置栏、返回退出开关修复、卸载自清理）全部只有**源码级证据**，本机无 Android SDK / 无设备，**从未在设备上跑过**。

1. **daemon 的 SELinux 域与 `/data/adb/**` 写权限未验证** — 卸载自清要删 `service.d` 脚本，能否 `unlink` 取决于 daemon 所在 SELinux 域（由 `service.d` 脚本拉起 与 由 app 内 `nohup` 拉起，两条路径的域是否不同也未验）。当前按"尽力而为"处理：失败不重试、不报错（用户已卸载，无人看 stderr），靠脚本看门狗自尽兜底——**那条兜底本身也在本项内，同样未验**。
2. **`tempctrl_b6x/b7x.status` 卸载后删不干净** — 只要飞智 app 进程还活着，其 LSPosed 钩子会每秒重写这两个文件，daemon `unlink` 后可能被立刻重建；须重启飞智 app 或重启设备才彻底消失。**已知局限，非可修项**（app 已卸载，钩子却仍挂在还活着的宿主进程里）。
3. **卸载与重装间隔 >10s 会触发自毁** — daemon 确认宿主已卸载即清掉自己与全部落盘产物，属**设计意图**（代价：重装后必须重新「一键部署」）。真机上须确认不会因 `/data/data` 挂载抖动或 `pm` 未就绪而**误判自毁**——已做「连续 2 次一级命中 + 二级 `pm path` 复核 + 脚本侧隔 5s 复核」的防抖，未验。
4. **键盘弹起时底栏 inset 冲突（本轮未修）** — material 给底栏自带的 inset 监听与 `ui/EdgeToEdge` 的让位逻辑冲突，键盘弹起时底栏可能被压空／塌陷。

**状态**：**未验证**。上述任一条都要在真机上过；其中第 3 条的误判代价最高（会把已部署好的进程连产物一起清掉）。

### 5. `Deployer.isRunning()` 本轮起已无调用者（2026-09-21 记录）

**背景**：「拉起daemon」改为**先停再起**，"已在运行"不再是跳过拉起的理由，`isRunning()` 作为前置拦截的唯一调用点随之删除（全仓库 `grep -rn isRunning` 现只剩方法定义本身）。方法保留为公开 API（状态展示将来可能复用）。

**状态**：**未解决**（保留待定；若确认不再需要应删除，删前须确认无外部调用）。

### 6. GitNexus 对本仓库的 `detect_changes` 恒返回 0 条（2026-09-21 记录）

**现象**：在本仓库（`D:\下载\Claude Code\飞智b6x增强计划`，路径含非 ASCII）对工作区改动跑 GitNexus `detect_changes()`，无论改动多少源码，恒返回 0 条受影响符号／流程；本轮再次复现。

**已确认的事实**：同一索引下 `analyze` / `query` / `context` 均正常（能查符号、能查调用关系），只有 git-diff → 符号的映射落空；工作区确实有大量改动（`git status` 可见）。

**未确认**：根因未定位。候选因素（索引快照与未提交改动的比对基线、仓库路径含非 ASCII 字符）均**未验证**，不作结论。

**影响**：CLAUDE.md 规定的「commit 前 MUST 先跑 `detect_changes()`」在本仓库**恒为绿灯**——**空结果 ≠ 改动安全**。复查改动影响改用 `impact()` 指定符号，或逐文件人工核对。

**状态**：**未解决**（工具侧问题，非本仓库代码问题）。

## 已解决区

### 1. PID 模式下风扇转速远滞后于制冷强度/热面温度（2026-08-05 发现，已解决）

**现象**：PID 模式（CTRL_MODE=1）下，风扇转速目标有概率长期显著低于制冷强度与热面温度所对应的需求，甚至完全卡死在低位，呈"制冷已拉满、热面已超温、风扇仍在中低转速"的状态，并非滤波/EMA 带来的轻微滞后。

**日志样例**：

```
[04 15:21:48] 35+3.0° b6x 冷190 热49° RPM3500
```

（`冷190`=制冷强度已到上限 190；`热49°`=热端 49°C，已超 HOT_RPM_MAP 上限 45°C；`RPM3500`=风扇目标仅 58% 满速）

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
- 温度变化检测由"sysfs 文件 mtime 判断"改为**以值比较为主、mtime 降级为次级刷新信号**（每秒读温度值，值与上次缓存不同才标记更新；mtime 更新即使值相同也视为数据刷新）。mtime 单独用不可靠（疑似部分内核的 sysfs 温度文件 mtime 不随值变化更新），是大量跳过源头；不可靠机型自动退化为纯值比较
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

### 5. 散热器停摆制冷82/风扇2000，命令消费协程崩溃（2026-08-11 发现，已解决待真机验证）

**现象**：散热器偶发停在制冷 82、风扇 2000（**最后一次成功命令的残留状态**，非固件默认档），tempctrl 持续下发新参数但散热器不响应；未解决区条目 1 的锁死自愈（重连）触发后**仍无效**，必须强制停止 app 冷启动才恢复。LSP 日志显示回传热端温度持续变化（310→390，0x13 通知链路活着），制冷/风扇字段恒 82/2000。

**机制（已确认，日志+反编译证据）**：
1. SDK 的 `AbstractDataInteractionController.runFetchLoop`（命令消费协程）**只在构造函数里 `GlobalScope.launch` 启动一次**，是死循环且无重启机制；
2. 断联后某次 `writeToBluetoothDevice` 对已 close 的 gatt 调用 `writeCharacteristic` 抛异常，runFetchLoop 无 try-catch **直接崩溃退出**；
3. 之后 `setRunMode` 照常入队（`addCommandToQueue` 只检查 state≠0），但**队列无人消费** → 散热器停在最后成功状态；
4. 0x13 回传是**独立链路**（`BluetoothGattCallback.onCharacteristicChanged`，不走 runFetchLoop），故热端温度仍更新——"回传活着但命令不生效"的表象；
5. 重连**无法恢复进程级协程**（不随连接重建）；杀 app 冷启动 = 重建 controller + 重建 runFetchLoop。

**修正（2026-08-11，待真机验证）**：
- **双信号并行判断、独立处置**：锁死检测同时判"命令队列堆积（>6 条）"与"回传停滞（≥3 次下发）"两个正交信号——队列堆积即启动守护消费线程接管 `processData`；回传停滞即 forceReconnect；**两者可同时触发**（消费协程与连接可能同时坏）
- **守护消费线程**：轮询命令队列，state==2 时反射调用 `processData` 消费；单条异常 try-catch 不冒泡（天然防崩溃）
- **重连前清空队列**：forceReconnect 前 `clear()` 堆积命令，避免断连期无效命令残留

**教训**：LSP 侧"命令下发无反应"的排查，除连接状态（state==2，条目 4）与 gatt 有效性（未解决区条目 1）外，还要检查**命令消费协程是否存活**——SDK 在构造时启动的进程级死循环协程一旦崩溃，重连无法恢复，必须以"队列堆积"为判据做独立兜底（守护消费线程），而不能只依赖连接级自愈。
