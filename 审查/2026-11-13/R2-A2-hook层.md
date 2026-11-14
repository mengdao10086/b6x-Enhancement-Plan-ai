# R2-A2 · Xposed 模块 hook 层只读审查

> 审查人：R2-A2　日期：2026-11-13　方式：静态通读 + 仓库内反编译产物交叉核对。
> 未编译、未运行、未提交、未投放；本文件是本次唯一写盘产物。

## 头

### 范围

- 白名单三文件：`MainHook.java`、`StartupTiming.java`、`AppFiles.java`（均在 `lsp模块/core/src/main/java/com/example/waspwingtempctrl/`）。
- 越界只读：与三文件有直接数据传递的 daemon 广播/status/临时停止协议、宿主反编译产物、构建配置；越界发现统一放 C 节并标注归属包。

### 实际读取文件清单

| 类别 | 文件 | 读取方式 |
|---|---|---|
| 白名单 | `lsp模块/core/src/main/java/com/example/waspwingtempctrl/MainHook.java` | 全文 3252 行 |
| 白名单 | `lsp模块/core/src/main/java/com/example/waspwingtempctrl/StartupTiming.java` | 全文 293 行 |
| 白名单 | `lsp模块/core/src/main/java/com/example/waspwingtempctrl/AppFiles.java` | 全文 209 行 |
| 必读上下文 | 项目 `CLAUDE.md` | 全文 |
| 必读上下文 | `参数定义/对齐报告.md` | 全文 |
| 必读上下文 | `TECH_DEBT.md`、`待办.md` | 全文 |
| 必读上下文 | `lsp模块/app/逻辑说明.md` | §1（含 1.1–1.7）、§3.6、§5.3、§10 |
| 必读上下文 | `lsp模块/README.md` | 全文（广播、status、uiprefs、文件落点） |
| 越界 | `lsp模块/daemon/tempctrl.c` | 广播发送、status 解析、仲裁、温度/临时停止相关段 |
| 越界 | `lsp模块/daemon/逻辑说明.md` | 主循环节奏、临时停止、死链/智能模式相关段 |
| 越界 | `lsp模块/core/build.gradle.kts`、`app/build.gradle.kts` | minSdk/compileSdk |
| 越界 | `参考资料/decompile/b6_devtool/devtool/smali/.../AbstractDataInteractionController.smali` | `processData`/`runFetchLoop`/队列字段 |
| 越界 | `参考资料/decompile/b7_overclock_v3/resources/AndroidManifest.xml` | `android:process` |
| 越界 | `参考资料/decompile/b7_overclock_v3/sources/{DeviceHomeFragment,DetailActivity,v5/a,DataConstant}.java` | 自动进入控制页与设备码兜底核对 |
| 参考 | `lsp模块/.claude/scratch/review-hook.md` | 既往 hook 侧发版前审查（仅用于避免重复结论） |

### 总行数

- 白名单三文件：**3754 行**（3252 + 293 + 209）。
- 上下文/越界：按相关段落读取约 **2200 行**（未逐行通读 daemon 全文件与全部反编译产物）。

### 结论摘要

- S1：**2 条**（均为多写者/多进程导致 status 协议数据损坏、温控停摆）。
- S2：**8 条**（getter 连坐、停滞判据与 daemon 语义错配、B7X/B6X 组合换算、型号兜底被清零、裸写状态、输入边界、API 兼容）。
- S3：**16 条**（资源/竞态/文档/测试缺口）。

---

## A 十条横切判据逐条结论

**1. 契约一致性：不一致（S1-1、S1-2、S2-4）。**
广播 Action 与 7 个 extra 名在 `MainHook:294-306` 与 `tempctrl.c:2470-2474/2538-2541` 逐项一致；status/uiprefs/temp_stop 的路径与字段也与 README 一致（见 D）。但 status 协议隐含“每个 status 路径只有一个写者”的前提，代码在 B7X `:remote` 进程与两个 B6X 包并存时都会违反；`connectedModel` 同时承担“设备型号”和“宿主 SDK 协议”两种语义，导致 B7X app 连 B6X 设备时 mode 换算错位。

**2. 资源生命周期：有问题（S3-4、S3-5、S3-6、S3-7）。**
`mainHandler` 为非 volatile 惰性单例；`connectedControllers` 只在 `markDisconnected(gatt)` 能匹配 gatt 时清理，否则线性增长；四处 `BufferedReader` 在异常路径不关闭；守护消费线程无退出条件。主线程 Handler 本身不持有 Activity 的长期引用，延迟任务只持有 0.5–3 s（见 D）。

**3. 静默失败：有问题（S2-1、S3-2、S3-16）。**
`writeStatusFile` 的 7 个字段共用一个 try，任一 getter 抛异常即整段后续字段缺失（历史 `RPM_RUN` 问题只把这一列单独拆出）；写盘失败会跳过本 tick 的 `checkCommandStall`；`checkCommandStall` 的 `catch(Throwable)` 无日志。其余反射兜底均有“保守放行/保持原行为”的显式语义（见 D）。

**4. 并发与竞态：有问题（S1-1、S1-2、S3-3、S3-4）。**
同一 status 路径在 B7X `:remote` 进程与两个 B6X 包之间被多个 1 Hz 写线程并发覆写；`.tmp` 路径在多写者间共用；`sMainHandler` 的发布不是安全发布。BLE 回调线程与 tick 线程共享的字段大多已 `volatile`，未发现字段级可见性缺陷。

**5. 状态机完整性：有问题（S2-6、S2-5、S3-10）。**
`invokeSetRunMode` 在 state∈{1,2} 且 gatt≠null 时裸写 `mDataConnectState=2`，包括“正在建连”的 state=1；`updateModelFromInfo` 会把未知型号写成 0，覆盖 `markConnected` 的包名兜底。B6X/B7X 的会话状态机（`enteredSetup`/`appBackgrounded`/`b7AutoLaunchSession`）分支独立，未发现交叉污染。

**6. 输入边界：有问题（S2-7、S2-8、S3-14）。**
广播接收器导出且 7 个 extra 无范围/来源校验；API 25 上三参 `registerReceiver` 不存在；`COLD_TEMP` 在 (-1,0) ℃ 区间会丢符号。Daemon 侧发送值受 clamp 约束，正常链路不会越界。

**7. 旧键兼容层：部分命中（S2-1 为主，D 有已核实项）。**
`getSpeed` 缺失已用独立 try 隔离，符合 README 的“缺 RPM_RUN 不影响其余字段”；但 `getTemperatureDecimal`、`getColdRunLevel`、`getTargetTemperature` 任一缺失仍会连坐后续字段。`GATE_LE` 已按文档不再读取，仅 daemon 为旧模块继续写（无副作用）。`setRunMode`/`W` 双名回退正常。

**8. 重复与死代码：有问题（S3-9、S3-10）。**
`resolveWaspWingManager` 的 B7X `t9.j.f50990a` 兜底在主类名 `loadClass` 抛异常时不可达（farsef 无 `com.flydigi.sdk.waspwing.WaspWingManager`）；`hookControllerStopScan` 在 B7X 必然因 `onDeviceConnected` 不存在而失败并打错误日志。其余同名钩子（`Activity.onResume` 的 B6/B7/autoLaunch 三处）按进程只注册其一，属有意设计。

**9. 文档偏差：有问题（S2-2 相关文档、S3-11、S3-12）。**
`app/逻辑说明.md` §1.3 称既有锁死判据“以已下发为前提”，代码没有 `lastBcast≥0` 门禁；`StartupTiming` javadoc 写“连续 6 个累计槽”，实际 `SUB_COUNT=8`；`AppFiles.diagnose` 引用仓库中不存在的“进展文件未决项”。README 的 status 协议未声明单写者假设（见 C）。

**10. 测试缺口：无（S3-17）。**
`lsp模块` 下没有任何 `src/test`/`androidTest` 源与测试依赖。`StartupTiming` 的“首写胜出/accFlush 只写一次”、`AppFiles.readTail` 的半截行丢弃、`MainHook` 的停滞判据均无回归保护。

---

## B 缺陷清单

> 每条格式：`文件:行 | 触发条件 | 后果 | 建议`。行号基于当前工作树。

### S1（崩溃 / 功能失效 / 数据损坏）

| 文件:行 | 触发条件 | 后果 | 建议（≤30字） |
|---|---|---|---|
| `MainHook.java:900-922, 2108-2119`；宿主 `AndroidManifest.xml:260-269` | B7X 悬浮窗服务拉起 `:remote` 进程，LSPosed 按包注入该进程 | 该进程无 BLE，却每秒把同一 status 写成 `BLE=0/CONNECTED_AT=0`，覆盖主进程的 `BLE=7`；daemon 判断联/仲裁跳变，温控停摆 | 用 `lpparam.isFirstApplication` 拦非主进程 |
| `MainHook.java:46-47, 905, 911` | 两个 B6X 包（老/新）同时存活（用户可能分别安装） | 两者都写 `/data/local/tmp/tempctrl_b6x.status`；未连接方每秒写 `BLE=0`，覆盖连接方的 `BLE=1/2` 与 `CONNECTED_AT`，daemon 心跳与“先连者优先”仲裁失真 | 按 owner 只允许一个包写，或分文件 |

### S2（边界条件下行为与预期不符）

| 文件:行 | 触发条件 | 后果 | 建议（≤30字） |
|---|---|---|---|
| `MainHook.java:424-464` | 任一 getter 在当前宿主版本缺失或抛异常（`getTemperatureDecimal`/`getColdRunLevel`/`getTargetTemperature` 等） | 同一 try 内其后的所有字段整段不写；只有 `RPM_RUN`（468-478）独立，历史缺口只补了一列 | 每个 getter 独立 try/catch |
| `MainHook.java:93, 2835-2870` | daemon 未部署/从未广播，`lastBcastColdLv/RpmLv` 仍为 -1，回传值稳定 | `cold != -1` 进入停滞计时，15 s 后 `forceReconnect()`；形成约每 15 s 断开重连一次的循环 | 加 `lastBcast≥0` 门禁再判 |
| `MainHook.java:2838, 2862-2870`；`tempctrl.c:2685-2750` | daemon 因 `COLD_DEADZONE`/`RATE_LIMIT_FAN_DEBOUNCE` 在死区内刻意不下发，而设备回显与最近下发目标存在稳定偏差 | 模块要求“精确相等”，偏差不变即 15 s 判停滞并强断重连 | 按 daemon 死区口径比较 |
| `MainHook.java:2566, 3202`；`README.md:108` | B7X（farsef）连接 B6X/B6X 型号散热器且下发固定功率 | `connectedModel=6` 触发 B6X 的 mode 1→2 与参数槽重排，但接收方是 B7X 的 `t9.j.W`；固定功率可能被忽略或错档 | 条件改为 `appKind==6`，B7X 透传 |
| `MainHook.java:3199-3202, 3159-3160` | 连接早期 `onDeviceInfoUpdate` 的 `getDeviceCode()` 为空/未知 | `connectedModel` 被写成 0，覆盖 `markConnected` 的包名兜底；固定功率暂不换算，B7X owner 兜底失效 | 未知型号时保留旧值 |
| `MainHook.java:2544-2557` | `state∈{1,2}` 且 controller.gatt≠null 时收到广播 | 裸写 `mDataConnectState=2`（含正在建连的 1）；模块与 SDK 状态机可能去同步，命令写进未就绪 gatt | 仅 state==0 时校正 |
| `MainHook.java:300-306, 328` | 任意第三方 app 向导出 action 发广播，或 extra 缺失/越界 | 无范围与来源校验，`mode/coldOC/windOC` 原样进 SDK，可越界驱动硬件或误切模式 | 按机型 clamp 并校验来源 |
| `MainHook.java:328`；`core/build.gradle.kts:10` | API 25 设备（minSdk 声明支持） | 三参 `registerReceiver(receiver, filter, flags)` 为 API 26+，`NoSuchMethodError` 被吞，接收器不注册，温控广播全失效 | 低版本改两参重载或升 minSdk |

### S3（一致性 / 可读性 / 运维负担）

| 文件:行 | 触发条件 | 后果 | 建议（≤30字） |
|---|---|---|---|
| `MainHook.java:2838-2851` | 某 tick 因“回传==目标”早退，期间队列非空计时未清零 | 之后新命令入队时沿用旧起点，立即判 30 s 队列停滞并启动守护线程 | 早退分支同步清零队列计时 |
| `MainHook.java:497-515` | `.tmp` 与直写均失败（目录无权限/磁盘满） | 异常跳出 try，末尾 `checkCommandStall()` 本 tick 被跳过 | 把停滞检测移出写盘 try |
| `MainHook.java:484-501` | app 无法在 `/data/local/tmp` 创建 `.tmp`，或多写者共用同名 `.tmp` | 原子 rename 退化为直写；并发下读者可能看到交错内容 | daemon 预建 `.tmp` 或单写者 |
| `MainHook.java:139-143` | 非主线程首次调用 `mainHandler()` 与主线程并发 | 非 volatile 惰性发布，存在重复构造/可见性竞态 | 改 Holder 或加同步 |
| `MainHook.java:92, 1945, 2060, 3187-3191` | 多次重连且旧 gatt 未触发断连回调 | `connectedControllers` 条目累积，防锁死恢复的线性遍历变慢 | 只保留最近 1–2 条 |
| `MainHook.java:1828-1838, 2155-2169, 2284-2300, 2306-2326` | 读文件过程中 `readLine`/解析抛异常 | `BufferedReader` 未关闭，fd 泄漏（低频） | 改 try-with-resources |
| `MainHook.java:2919-2976` | 守护消费线程启动后 | 无退出条件，余下进程生命周期 250 ms 轮询；队列堆积>30 s 时可能与仍存活的 `runFetchLoop` 并发处理不同命令 | 加空闲退出，接管前复核 |
| `MainHook.java:2894-2901` | 队列持续堆积（该判据的目标场景） | `ConcurrentLinkedQueue.size()` 为 O(n)，每秒遍历一次增长队列 | 只探测是否≥阈值 |
| `MainHook.java:3087, 3114-3126` | B7X 且 `capturedWaspWingMgr==null`（广播早于构造） | 主类名 `loadClass` 先抛 `ClassNotFoundException`，`t9.j.f50990a` 兜底不可达，下发必失败 | B7X 兜底前置或单独 try |
| `MainHook.java:977-991` | 每个 B7X 进程启动 | B7X 无 `AbstractBluetoothController.onDeviceConnected`，钩子必失败并打一条错误日志 | 按 appKind 跳过该钩子 |
| `StartupTiming.java:228`（对比 `:58`） | 静态文档 | javadoc 写“连续 6 个累计槽”，实际 `SUB_COUNT=8`（含自检、诊断提交） | 改为 8 或引用 SUB_COUNT |
| `AppFiles.java:135` | 界面展示读取失败诊断 | 文案引用不存在的“进展文件未决项”，误导排障 | 改为指向 README/逻辑说明 |
| `AppFiles.java:141-146` | 调用方传入负数或超大 `maxBytes` | 负数会放大分配尺寸，超大值可 OOM（当前调用点均为小常量） | 入口 clamp 到合理区间 |
| `MainHook.java:436-438` | 冷端温度为 (-1,0) ℃ 且整数部分截断为 0、小数位为正 | `c=0` 走 `c*10+d`，输出 +0.x 而非 -0.x | 用原始符号位判定 |
| `MainHook.java:55, 2799`；`tempctrl.c:3649-3711` | daemon 主循环被 `pm`/`am` 卡住 >10 s 且处于临时停止 | 模块 15 s 判标记过期，恢复停滞判定并可能强断重连 | 新鲜度放宽或内容+时间双判 |
| `MainHook.java:2881` | `checkCommandStall` 内任意反射异常 | 整段 `catch(Throwable)` 无日志，停滞检测连续静默失效 | 限频留痕 |
| 三文件 | 任何改动 | 无 `src/test`/`androidTest`，关键判据无回归测试 | 为前两者补 JVM 单测 |

---

## C 越界发现

| 归属包 | 一句话 |
|---|---|
| daemon（`tempctrl.c:2685-2750`） | `should_skip_dispatch` 用死区（非精确相等）决定“已到位”，与模块 `checkCommandStall` 的精确比较口径相反，是 S2-3 的另一半；建议两侧统一为同一判据。 |
| daemon（`tempctrl.c:2020-2080, 3280-3320`） | `read_single_status`/`select_active_device`/`b6_owner` 的模型是“一个 status 文件一个写者”，无法承载两个 B6X 包或 `:remote` 进程并发写；S1-2 的协议根因。 |
| `lsp模块/README.md:95-158` | status 协议只描述字段，未声明“每个路径只允许一个写者/主进程写”的前提，读者无法从文档发现 S1-1/S1-2。 |
| `lsp模块/app/逻辑说明.md:77, 92` | 称“既有两条锁死判据都以已下发为前提”“与 daemon 下发频率无关”，但 `checkCommandStall` 没有 `lastBcast` 有效性门禁（S2-2）。 |
| daemon（`tempctrl.c:3649-3711`） | 临时停止每 5 s 刷新，模块只容忍 15 s（3 个周期）；daemon 主循环卡顿 >10 s 即误判过期（S3-15 的另一半）。 |
| 宿主 app / 安装前提 | farsef 的 `AndroidManifest.xml:260-269` 声明 `:remote` 进程；这是 S1-1 成立的外部条件，需真机确认 LSPosed 注入与 `Application.onCreate` 调用链。 |

---

## D 已核实无害（可疑但查证不成立）

1. **守护消费线程会不会重复下发同一条命令**：否。`AbstractDataInteractionController.processData(RequestPack)` 的第一条指令就是 `mConcurrentLinkedQueue.poll()`（smali 361-366），每次 invoke 消耗一条；`peek` 只用于观察队首。与既往审查结论一致。
2. **广播 extra 是否与 daemon 对称**：是。`tempctrl.c:2470-2474` 的 `BROADCAST_EXTRAS[]` 与 `send_am_broadcast` 的 `vals[]` 顺序一致，`MainHook:300-306` 按同名读取；两个 Action 与 `appKind` 对应正确。
3. **临时停止文件协议**：路径、`1\n/0\n` 内容、daemon 启动预创建 + 5 s 重写（`tempctrl.c:1962-1965, 3649-3711`）与模块 `MainHook:53-55, 2795-2813` 的“内容=1 且 mtime≤15 s”一致；缺失/过期按 0 处理，符合 README:143-144。
4. **B7X 自动进入控制页的类名/extra**：与宿主反编译一致。`DeviceHomeFragment` 的进入点确实用 `key_device_type=3` + `key_device_code`（`DeviceHomeFragment.java:622,675`），`DetailActivity` 通过 `@Autowired`/`getIntent()` 读取（`DetailActivity.java:39,43,114`），`v5.a.j().k().getDeviceCode()` 存在（`v5/a.java:31,109`）。
5. **`hookDeviceTypeGate` 的放行范围**：`gateLeActive` 限定 connect() 执行期，地址必须等于 `lastDevice`，且原方法抛异常时不改结果（`MainHook:1390-1419`），不会误放行其它设备或模块自身探针。
6. **`RPM_RUN` 独立 try 是否真的生效**：是。主参数块（424-464）异常后仍会执行 468-478 的 `getSpeed` 独立块；README:134 的承诺成立。
7. **`hookRunFetchLoopCpuFix` 的队列替换**：`mConcurrentLinkedQueue` 在 smali 中为 `private volatile`（`AbstractDataInteractionController.smali:83`），替换对运行中协程可见；`peek()` 在全 smali 中只有 `runFetchLoop` 一个调用点，包装体的 sleep 不会卡到入队路径。
8. **静态初始化依赖主线程 Looper**：TECH_DEBT §3 的 NPE 已修复，`mainHandler()` 改为惰性（`MainHook:139-143`）；现有调用点均在 Looper 就绪后。
9. **跨线程字段可见性**：`bleConnected`、`lastWaspWingInfo`、`currentValidGatt`、`appContext`、`currentGuideActivity` 等已声明 `volatile`（`MainHook:84-91,136,214`），未发现字段级可见性缺陷。
10. **`isAllZeroInfo` 误判正常空闲**：判据要求冷/热/RPM 同时为 0（`MainHook:1171-1175`），常温下热端不可能为 0；且 `checkZeroInfoTimeout` 只在 `bleConnected && lastWaspWingInfo != null` 时运行。
11. **钩子注册失败是否会重试风暴**：不会。`hookClassMethod`/各 `hookAllConstructors` 失败只记一条日志（`MainHook:956-968` 等），无重试循环。
12. **`markDisconnected` 的 `connectedControllers` 清理**：能按 gatt 精确移除（`MainHook:3180-3196`）；仅在 gatt 从未回调断连时残留（S3-5）。

---

## E 未覆盖 / 待真机

1. **`:remote` 进程是否真被注入**：需 `ps -T` + LSPosed 日志确认 `handleLoadPackage` 在 `:remote` 被调用、且宿主 Application 的 `onCreate` 调用了 `super`（否则 1 Hz 写线程不会启动）。本报告按“LSPosed 包级作用域注入所有进程”推定 S1-1。
2. **两个 B6X 包是否真的会同时存活**：daemon 的 `arbitrate_and_keep_one` 在 `APP_LAUNCH_ENABLED/APP_WATCHDOG` 开启且扫描到两个包时会 force-stop 多余者；需真机确认默认出厂配置下是否仍有并存窗口。
3. **“回显与最近下发目标存在稳定偏差”是否实际发生**：S2-3 依赖设备把目标落在死区内且回显不精确等于最后下发值；需真机抓 `checkCommandStall` 的 `cold/rpm` 与 `lastBcast` 日志（当前无该字段日志，建议临时加）。
4. **daemon 未部署时 `lastBcast` 是否为 -1 且持续 15 s**：静态路径成立；需真机在“只装模块、不部署 daemon”配置下观察是否出现周期性断连。
5. **farsef 连 B6X 设备时的固定功率 mode 语义**：S2-4 需反编译/真机确认 `t9.j.W` 对 B6X 设备是否仍按 `mode=1`，还是也接受 `mode=2`。
6. **SELinux 下 app 能否在 `/data/local/tmp` 创建 `.tmp`**：决定 S3-3 是“常态”还是“理论路径”；需 `strace`/`ls -lZ` 真机确认。
7. **API 25 设备**：S2-8 的三参 `registerReceiver` 可用性按 Android 文档推定；目标用户多在 Android 13+，未实测。
8. **旧宿主版本缺哪些 getter**：`getTemperatureDecimal`/`getColdRunLevel`/`getSpeed` 在 B6X 老/新包与 farsef 各版本的可用性未逐一取证，决定 S2-1 的实际影响面。
9. **守护线程与仍存活的 `runFetchLoop` 并发消费**：S3-7 的“双消费者”只在队列持续堆积 >30 s 时可能出现；需设备侧制造慢写/卡顿复现。
10. **`StartupTiming` 真机数字与旋转重建**：`accFlush` 的首写胜出在二次建表/旋转下的展示口径未实测。

---

## 待批问题

1. S1-1/S1-2 涉及 status 协议写者模型，修复需改 `MainHook` 的进程/包写入门禁，建议单独立项并先定“谁是唯一写者”。
2. S2-3 的修复方向取决于 daemon 是否愿意把“死区容差”写入 status（或模块自算死区），属跨包协议变更，需拍板。
3. S2-4 需先确认 farsef 对 B6X 设备的 mode 语义；在确认前不建议直接改换算条件。
