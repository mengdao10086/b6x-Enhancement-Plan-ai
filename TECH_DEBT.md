# 技术债与未解决问题记录

> **归口（2026-09-22 固化）**：本文件是**已知缺陷及其状态与根因**的唯一归口处；**待做事项（动作）**归 [`待办.md`](待办.md)。同一事项两边都有时，本文件留状态与根因，`待办.md` 只留待做动作并链接过来。
> 规则：
> - **未解决的问题**：只记录**可观察的现象与事实**（时间、版本、日志、复现条件、已验证排除项），**不记录分析推测与根因结论**——未确认的推测可能误导后续排查。
> - **已解决的问题**：说明清楚**问题原因与解决思路**，供后续参考（根因确认后补记结论）。

## 未解决区

### 1. 散热器偶发锁制冷 125 / 风扇 4500，tempctrl 下发无效（2026-08-11 发现，未解决）

> **口径（本项状态的唯一有效源，2026-09-22 重申）**：`ensureUsableController()`（下发前校验）与 `checkCommandStall()`（锁死自愈）**均未根治，状态：未解决**——锁 125/4500 仍偶发。下方「已尝试的解决」是**已下发的措施**，不等于已修复；凡本仓库其他文档（含反编译分析类文档）出现与之矛盾的「已实施修复 / 已修复」表述，一律以本节为准。

**现象**：散热器偶发停在制冷 125、风扇 4500，tempctrl（magisk 守护进程）持续下发新参数但散热器不响应；常在 BLE 重连后出现（多次快速重连更易触发），偶发无重连也出现。LSP 日志（`D:\下载\LocalSend`）显示下发与回传长期偏离。**当前所有自愈措施触发后仍偶发**（未根治）。

**已确认机制**（三层证据链，非未确认推测；供后续排查不重复推导）：
1. **4500/125 不是任何一方下发的值**：日志中 tempctrl 下发的 windOC/coldOC 组合（3100/168、4800/144、4900/183、5250/190、5550/190 等）从未包含 4500/125——这是设备固件在"未收到有效控制命令"时的默认固定功率档（0x13 回传 `coldLevelOverclock=byte[0xd]=125`、`windLevelOverclock=byte[0xc]×100+byte[0x13]=45×100`）
2. **多 controller 实例竞态**：B6X 重连时 SDK 可能创建多个 controller 实例并各自触发 `onGattConnected`，static `dataInteractionController` 指向"最后连接成功"的实例，可能并非正在接收 0x13 状态包的实例
3. **两处命令静默丢弃点**：`AbstractDataInteractionController.processData` 的 `mDataConnectState != 2` 出队即丢；`LeDataInteractionController.writeToBluetoothDevice` 只检查 `mBluetoothGatt != null` 不检查已连接，失效 gatt 的 `writeCharacteristic` 静默返回 false（state==2 也拦不住）

**已尝试的解决**（均未根治，仅降低频率）：
- [2026-08-11] **下发前校验** `ensureUsableController()`：每次 `invokeSetRunMode` 前校验 static controller 的 gatt 是否等于当前有效连接（`currentValidGatt`，连接成功记录、断连清空）；失效时从已连接实例注册表（`connectedControllers`）找回 gatt 有效实例重新同步，找不到则强制重连
- [2026-08-11] **锁死自愈** `checkCommandStall()`：累计 3 次参数下发后回传仍停滞且 ≠ 下发目标判定锁死 → 强制重连（10s 防抖）；回传到位或回传在变均清零，避免误判限速追赶
- [2026-08-11] 覆盖 B6X 新旧 app（`com.flydigi.waspwing.experimental` 与 `com.flydigi.waspwing.experimentanliuliu`）与 B7X（混淆 `t9.j`/`a`）同一套逻辑
- [2026-08-11] **守护消费线程**（相关后续，见已解决区条目 5「命令消费协程崩溃」）：重连级自愈对"命令消费协程 `runFetchLoop` 崩溃"场景无效（锁 82/2000，最后成功命令残留态），新增双信号判断（命令队列堆积 >6 条 + 回传停滞 ≥3 次下发）+ 守护消费线程反射接管 `processData`——重连无法恢复进程级协程，须以队列堆积为判据独立兜底

**状态**：**未解决**——`ensureUsableController()` 与 `checkCommandStall()` **均未根治**；锁 125/4500 仍偶发。


### 2. GitNexus 对本仓库的 `detect_changes` 曾恒返回 0 条（2026-09-21 记录；2026-09-22 定位根因；2026-09-24 漏报问题已解决）

**现象**：在本仓库（`D:\下载\Claude Code\飞智b6x增强计划`）对工作区改动跑 GitNexus `detect_changes()`，无论改动多少源码，恒返回 0 条受影响符号／流程。

**根因（2026-09-22 定位）**：**查询时传了错误的仓库名**。本机共索引 4 个仓库，本仓库的名字是 `b6x-Enhancement-Plan-ai`（覆盖 `lsp模块/**`、`逻辑说明.md` 等）；此前一直用外层工作区的 `Claude Code`（2949 文件，主要是其他项目，**不含本项目代码**）去查，于是恒空。同索引下 `analyze` / `query` / `context` 看似正常，反而掩盖了"问错仓库"这件事。

**证据**：改用 `repo=b6x-Enhancement-Plan-ai`（索引 2026-09-22 重建，3977 节点）后 —— `impact(pid_compute)` 立即返回 5 个候选，含真正那处 `lsp模块/daemon/tempctrl.c:2235`（3 受影响 / 1 直接调用者 / LOW）；`detect_changes(scope=compare, base_ref=d962bf0)` 返回 36 个变更符号 / 6 个文件。

**真相（2026-09-24 实测定位）**：不是"只映射部分节点类型"，而是**路径含非 ASCII 的文件被整份丢弃**。git 默认 `core.quotePath=true`，把这类路径的 diff 头写成 `+++ "b/lsp\346\250\241\345\235\227/..."`（引号 + 八进制转义），而 gitnexus 1.6.9 的 `parseDiffHunks`（`dist/storage/git.js`）判据是字面 `line.startsWith('+++ b/')` → **整行被跳过**。本仓库 123 个受控文件里 **114 个（93%）路径含中文**，索引 116 个文件里 112 个（97%）→ 对该工具几乎全瞎；上一段"17 个 java + `tempctrl.c` 全部漏报"由此解释。

**叠加的第二处缺陷（同版本）**：跳过文件头时**不重置"当前文件"**，被跳过文件的 hunk 会挂到上一份文件名下（实测 `README.md` 的 hunk 列表里出现 `(1634,1681)`、`(1041,1065)`、`(1382,1426)` 等它不可能有的行号）；再撞上符号查询用**裸 `ENDS WITH`**（`README.md` 会同时命中 `lsp模块/README.md`），就产出"报出根本没改过的文件"这种怪结果。

**复现**：`git diff <ref> -U0 | grep '^+++'` 看被引号包裹的行；或对比解析结果 —— `git diff <ref> -U0` 与 `git -c core.quotePath=false diff <ref> -U0` 各自按上述判据解析，文件数 **2 → 15**。

**修复（2026-09-24）**：升级 `gitnexus` 1.6.9 → **1.6.12**（`npm i -g gitnexus@1.6.12`）。其解析器已重写：新增 `unquoteCStyleGitToken` 解引号路径、遇 `diff --git` 头先 `current = null`、支持 `+++ /dev/null`（删除的文件改用旧侧行号，旧版整份丢弃）、hunk 行号换算到索引的 0-based 空间、路径匹配改为按 `/` 锚定、未解析的 `diff --git` 头会把结果标 `partial`（不再静默假装干净）。**实证**：同一条 diff 由 `2 files / 24 symbols / 0 processes / low` 变为 **`15 files / 65 symbols / 61 processes / critical`**，CLI 与 MCP 两侧一致。

**回退到旧版时的兜底**：`git config core.quotePath false`（仓库或全局）—— 实测能让 1.6.9 的解析器看到全部文件，但它只治主因，不治第二处缺陷与"纯删除文件"盲点。

**附带发现**：`参考资料/c_historical_sources/*.c` 也在索引内，与 `tempctrl.c` 存在同名符号（`pid_compute` 有 5 个候选）→ 用 `impact` / `context` 时须以 `file_path` 或 `uid` 消歧。

**影响**：CLAUDE.md 的「commit 前 MUST 先跑 `detect_changes()`」在本仓库曾长期是**假绿灯**（返回 `risk_level: low` 而实际漏报全部代码改动）。升级后（≥1.6.12）该门禁已可信，但仍须：①**带对仓库名 `b6x-Enhancement-Plan-ai`**；②索引按 commit 快照建、不感知未提交改动，故复核前先 `analyze --force`（见根 `CLAUDE.md` 的 GitNexus 索引维护规则）。纯文档改动返回 0 条属正常。

**状态**：**已解决**（2026-09-24：升级 gitnexus 1.6.12 并以本次真实改动实证，见上）。

### 3. 四项已知缺陷与有意取舍（2026-09-20 记录；原 `待办.md` §已知未修，按归口迁入）

- **`profile.conf.tmp` 卸载残留** — **已裁定不做**：`ConfigStore.writeAtomic()` 的同目录临时文件，仅在写配置途中被强杀或掉电时残留（约 2KB），卸载不清。修法是在 `Deployer.cleanPrivateRuntime()` 的清单里加一项，但该函数 `impact` 为 **HIGH**（从 `StatusFragment` 的卸载按钮可达），收益近零。
- **`tempctrl_last_dev` 在卸载时无法清理** — **设计约束，非遗漏**：它写在**宿主 app 自己的私有目录**里，而 `MainHook` 运行在飞智 app 的 uid 下，我们的 APK 无权限去删别的 app 的私有文件。
- **「构建成功」不等于「编译过且无告警」** — **未解决（CI 盲区）**：CI 的编译步骤仅在源码哈希变化时才执行，命中二进制缓存的构建从不产出 stderr，既有告警可以在多次绿色构建里一直不可见。
- **配置键改名的兼容性** — **有意取舍，不修**：五个界面专用键由 `WEBUI_*` 改为 `UI_*`，设备上已存在的 `profile.conf` 里旧键名不再被识别，这五项回退默认值（仅界面偏好，不影响守护进程）。无迁移代码。

### 4. 界面改配置无效、日志不再更新，重启守护进程即恢复（2026-09-24 记录，疑似）

**现象**：界面改配置**完全无效**，日志也不再更新；但守护进程活着、仍在用代码默认值正常控温。**手动重新拉起守护进程后立即恢复正常**——界面改动即时生效、日志恢复更新。用户未做任何代码修改，只重启进程。

**疑似根因（未验证）**：守护进程启动时那次**一次性的**「私有目录 / profile.conf 落点探测」失败后**没有任何重试**，该实例于是整个生命周期都不读配置、写的日志也不在界面读的那份里：

- 落点探测只跑一次：`lsp模块/daemon/tempctrl.c:929-937`（`access(PRIVATE_DIR/profile.conf)` 失败即返回 0），调用点只在 `main()` 的 `:2831-2836`，失败即置 `config_path[0]='\0'` 并写一行「配置 未找到 … 使用代码默认值」；全文件再无第二处给 `config_path` 赋值。
- 热重载硬要求该路径非空：`tempctrl.c:2708`（`config_path[0] != '\0' && stat(...) && st_mtime != config_mtime`）→ **文件后来写出来了也不会被读到**，只有重启进程才重新探测。
- 日志同一次判定里被改道：`tempctrl.c:908-920`（私有目录不可用 → `/cache/<二进制名>.log` + stderr，`tempctrl.c:89-104` 是那条判据），而界面固定读私有目录那份（`lsp模块/app/src/main/java/com/example/waspwingtempctrl/ui/AppFiles.java:40`）→ 两条日志从此分家。
- 该判定发生在进程很早期：`tempctrl.c:2826-2849`（日志路径 → 配置加载 → 才 `sleep(30)` 与等待设备），所以「被拉起那一刻目录没就位」就足以永久定性，与之后 BLE/app 是否就绪无关。

**为什么用户看不到任何提示**：那条失败信息写在**改道后的日志**（`/cache/tempctrl.log`）里，而界面读的是私有目录那份 → 静默失败，界面侧没有任何位点能反映「配置根本没被加载」。**可复现的规避手段**：手动重新拉起守护进程（界面状态页入口，或设备侧重启该进程），即重新做一次落点探测。

**触发条件（疑似，均未在设备侧核对）**：① 开机时 CE 存储尚未解锁、或私有目录 / `profile.conf` 尚未就位时先被拉起（`lsp模块/app/src/main/assets/deploy/b6x-tempctrl.sh:115-118` 只等 `mWakefulness=Awake`，锁屏界面也算 Awake）；② 卸载重装 APK 或「清除数据」后，由开机脚本或看门狗先把进程起起来——`lsp模块/daemon/逻辑说明.md` 的「参数落点」注记已记过同一代价（"守护进程还在跑、配置已空"）。

**已排除项**：最近三笔界面提交（`08f6a703`、`5e60633c`、`09fa53d5`）与写配置路径无关——`5e60633c` 只改 `WrapRowLayout` 的换行数学，`08f6a703` 把 IO/队列/冲刷原样搬进 `ConfigFormController`（各冲刷点仍在），`09fa53d5` 只新增 enum 渲染与起始页判定；`PERF_ENABLED` 出厂值 0 只能解释「配置无效」、解释不了日志，且**本次被实测反证**（总开关若为 0，重启不会自愈）。

**待确认判据（未做）**：① 曲线数据文件是否仍在随时间变化（`tempctrl_webui.data` 与日志同落私有目录、由守护进程每秒写，在动即排除这条路）；② 设备侧核对这个实例的实际启动时刻与落点（`ls -l /proc/<pid>/fd` 指向哪份日志、进程启动时刻与 `profile.conf` 的 mtime 对比）。

**可能的修法（未实施，仅备选记录）**：① 落点探测失败后按周期重试，让配置/日志能自愈；② 启动诊断落到界面可见处（界面页或 status 文件），而不是只写进可能已改道的日志；③ 界面在「配置未加载」时给出明确提示。

**状态**：**疑似**——仅靠重启恢复，未做代码修复，未做设备侧核对。

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

### 5. 散热器停摆制冷82/风扇2000，命令消费协程崩溃（2026-08-11 发现，机制已确认）

**现象**：散热器偶发停在制冷 82、风扇 2000（**最后一次成功命令的残留状态**，非固件默认档），tempctrl 持续下发新参数但散热器不响应；未解决区条目 1 的锁死自愈（重连）触发后**仍无效**，必须强制停止 app 冷启动才恢复。LSP 日志显示回传热端温度持续变化（310→390，0x13 通知链路活着），制冷/风扇字段恒 82/2000。

**机制（已确认，日志+反编译证据）**：
1. SDK 的 `AbstractDataInteractionController.runFetchLoop`（命令消费协程）**只在构造函数里 `GlobalScope.launch` 启动一次**，是死循环且无重启机制；
2. 断联后某次 `writeToBluetoothDevice` 对已 close 的 gatt 调用 `writeCharacteristic` 抛异常，runFetchLoop 无 try-catch **直接崩溃退出**；
3. 之后 `setRunMode` 照常入队（`addCommandToQueue` 只检查 state≠0），但**队列无人消费** → 散热器停在最后成功状态；
4. 0x13 回传是**独立链路**（`BluetoothGattCallback.onCharacteristicChanged`，不走 runFetchLoop），故热端温度仍更新——"回传活着但命令不生效"的表象；
5. 重连**无法恢复进程级协程**（不随连接重建）；杀 app 冷启动 = 重建 controller + 重建 runFetchLoop。

**修正（2026-08-11）**：
- **双信号并行判断、独立处置**：锁死检测同时判"命令队列堆积（>6 条）"与"回传停滞（≥3 次下发）"两个正交信号——队列堆积即启动守护消费线程接管 `processData`；回传停滞即 forceReconnect；**两者可同时触发**（消费协程与连接可能同时坏）
- **守护消费线程**：轮询命令队列，state==2 时反射调用 `processData` 消费；单条异常 try-catch 不冒泡（天然防崩溃）
- **重连前清空队列**：forceReconnect 前 `clear()` 堆积命令，避免断连期无效命令残留

**教训**：LSP 侧"命令下发无反应"的排查，除连接状态（state==2，条目 4）与 gatt 有效性（未解决区条目 1）外，还要检查**命令消费协程是否存活**——SDK 在构造时启动的进程级死循环协程一旦崩溃，重连无法恢复，必须以"队列堆积"为判据做独立兜底（守护消费线程），而不能只依赖连接级自愈。

### 6. `Deployer.isRunning()` 长期无调用者（2026-09-21 记录，2026-09-24 删除）

**原因**：「拉起daemon」改为**先停再起**后，"已在运行"不再是跳过拉起的理由，`isRunning()` 作为前置拦截的唯一调用点随之删除；此后它一直是零调用者的公开 API，「状态展示将来可能复用」的保留理由未成立。

**解决思路**：删前做三重确证——全仓 grep（含无点前缀的调用形式）0 命中、两版索引交叉、GitNexus `impact` 报 0 受影响符号。同批还删掉同类的 `Deployer.readAll(File)`（`ui/ChartConfig.java:185` 的 `readAll(InputStream)` 是**同名活方法**，未碰）。

**状态**：**已解决（2026-09-24）**。

### 7. `FlowWrapLayout` 的换行标记持强引用，容器清空后不清理（2026-09-21 记录，2026-09-24 随容器重写消除）

**原因**：`setFullLine` / `setBreakBefore` 把子视图存进两个 `List<View>`（独占行、另起一行），只在显式传 `false` 时才移除；调用方若先 `removeAllViews()` 再重建（曲线页图例正是这种写法），被移除的旧视图仍被列表持有。

**解决思路**：不修旧类而是**整体替换**——配置页与曲线图例改用新容器 `ui/WrapRowLayout`，换行标记改存在**子视图自己的 `LayoutParams`** 上（`trailing` / `fullLine` / `breakBefore` / 垂直对齐偏移），实例字段只剩两个间距值，不再持有任何子视图引用，标记随视图一起被回收。旧容器与配套的 `attrs_flow_wrap.xml` 已删除；配置行不再靠负外边距与 layout 回调修正几何，换行判据全项目只剩容器里一份。

**状态**：**已解决（2026-09-24）**。
