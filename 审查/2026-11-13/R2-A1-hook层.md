# R2-A1 — Xposed hook 层只读全量审查

> 审查对象：`lsp模块/core/.../MainHook.java`、`StartupTiming.java`、`AppFiles.java`。
> 约束：只读；未修改、未编译、未提交、未投放产物。除本文件外未写盘。
> 日期：2026-11-13

## 头

**范围**：hook 层三个白名单文件的契约一致性、异常边界、线程/资源、多进程、停滞与临时停止判定、启动记账与产物直读。相邻包（daemon / README 协议 / 反编译产物）只做为核对契约所必需的定点读取。

**实际读取文件清单**

| 类别 | 文件 | 说明 |
|---|---|---|
| 白名单 | `lsp模块/core/src/main/java/com/example/waspwingtempctrl/MainHook.java` | 3252 行，全文 |
| 白名单 | `lsp模块/core/src/main/java/com/example/waspwingtempctrl/StartupTiming.java` | 293 行，全文 |
| 白名单 | `lsp模块/core/src/main/java/com/example/waspwingtempctrl/AppFiles.java` | 209 行，全文 |
| 必读 | `CLAUDE.md`、`参数定义/对齐报告.md`、`TECH_DEBT.md`、`待办.md`、`lsp模块/app/逻辑说明.md` | 逻辑说明全文（1036 行） |
| 越界 | `lsp模块/README.md`（广播/status/uiprefs/临时停止协议） | 全文 |
| 越界 | `lsp模块/daemon/tempctrl.c` | 定点：广播/status 解析/uiprefs/临时停止/下发去重/主循环 |
| 越界 | `参考资料/decompile/b6_devtool`、`b6_overclock_v2`、`b7_overclock_v3` | 反射目标类/方法/字段签名核对 |
| 越界 | `lsp模块/app/src/main/java/.../ui/StartupTimingReport.java` | `slot()` 消费口径 |

**总行数**：白名单 3754 行（MainHook 3252 + StartupTiming 293 + AppFiles 209）；上下文与越界定点读取约 2700 行。

---

## A. 十条横切判据

1. **契约一致性**：广播 action 与 7 个 extra 的名称/顺序在 `MainHook:73-74,300-306` 与 `tempctrl.c:2470-2476,2538-2543` 逐项一致；拉起 extra `b6x_auto_launch`（String）两侧一致。status 写入 11 个字段中，`TARGET_TEMP` 只有写端（`MainHook:447`），daemon 的 `STF_*` 表（`tempctrl.c:355-364`）与全仓都没有消费方——README 却把它列为「供守护进程解析」。另有「停滞判据精确相等 vs daemon 死区/折算」与「隐式广播无定向、无回执」。结论：主体对称，3 处偏差（S3-10、S3-11、S2-6）。
2. **资源生命周期**：Handler 懒加载正确（`MainHook:140-143`），线程均为进程级 daemon；Activity 引用大多及时清；`b7AutoEnterFrom` 可长期持有 Activity（S3-4）；5 处 `FileOutputStream` 无 `finally`（S3-2）；`connectedControllers` 无淘汰（S3-3）。结论：有缺陷。
3. **静默失败**：`blockSelfRepair` 的 `setIntField` 对 `Integer` 字段必抛且被空 catch 吞、原子写失败退化为截断直写且不留痕；`updateModelFromInfo` / `captureInfoFromController` / `setExperimentalRunMode` 为空 catch（后者属有意屏蔽）。结论：有静默面（S3-1、S3-16）。
4. **并发与竞态**：同进程 `writeStatusFile` 有 `synchronized`；跨进程完全无互斥（S1-1、S2-1）；`markConnected`/`markDisconnected` 可交错；`checkCommandStall` 无同步、可被 tick 与 BLE 回调线程同时进入；`capturedWaspWingMgr` 非 volatile（S3-13）。`StartupTiming` 的 CAS/首写胜出实现正确。结论：有竞态。
5. **状态机完整性**：重连/唤醒/锁死状态机自洽（`reconnectPending`/`wakeupAttempts`/`stallReconnectCount`/`deviceLockedAlerted`）；B6X/B7X 会话状态机彼此独立；`appBackgrounded` 在钩子注册失败时有降级路径。缺口是**没有进程维度**——同一包的非主进程也走完整状态机（S1-1）。结论：基本完整，缺进程维度。
6. **输入边界**：导出广播接收器无发送方校验、7 个 int 无范围钳制（S2-7）；status/uiprefs 的解析对缺行/坏值容错良好。结论：有缺陷。
7. **旧键兼容层**：`GATE_LE` 只写不读（有意留给旧版模块，README 与 §1.7 均已载明）；本包无其它遗留键。结论：无（有意兼容）。
8. **重复与死代码**：B7X `resolveWaspWingManager` 的 t9.j 兜底不可达（S2-2）；B7X 队列字段名不匹配使 CPU 修复失效（S2-11）；`blockSelfRepair` 永不生效（S3-16）；`TARGET_TEMP` 是死字段（S3-10）；`DIAG_LOG_MAX_PER_CONN` 注释与值不符（S3-14）。结论：有死代码。
9. **文档偏差**：README「连续 3 次参数下发后」、`MainHook:3149`「每连最多 3 条」、`StartupTiming`「6 个之一」与悬空 `{@link #counter(int)}`、`AppFiles` 诊断文案「app 无权直读」、README 把 `TARGET_TEMP` 列为解析字段。结论：有 6 处。
10. **测试缺口**：`lsp模块` 无任何 `test`/`androidTest` 目录；`AppFiles.readTail`、`StartupTiming` 的槽位语义、`modelFromDeviceCode`/`isB7*Code` 等纯逻辑可 JVM 测试却零覆盖；广播/status 协议也没有类似 `check_params.py` 的自动对称性核对。结论：有缺口。

---

## B. 缺陷清单

### S1（崩溃 / 功能失效 / 数据损坏）

| 文件:行 | 触发条件 | 后果 | 建议(≤30字) |
|---|---|---|---|
| S1-1 MainHook.java:899-947, 2106-2119, 414-516 | B7X 包的 `:remote` 进程被拉起（`参考资料/decompile/b7_overclock_v3/resources/AndroidManifest.xml:264` 声明 `android:process=":remote"` 的 `FloatingWindow` 服务），LSPosed 按包注入全部进程；代码只判包名、不判进程名 | 第二个进程同样注册 `SET_TEMPERATURE_B7` 接收器、起 1Hz status 写线程（以自身静态态写 `BLE=0`）并执行 `restoreLastDevice`→`t9.j.E` 重连：与主进程抢写同一 status 文件、可能建立第二条 GATT 连接，daemon 看到间歇断联/双命令流 | handleLoadPackage 先按进程名过滤，仅主进程装钩子 |

### S2（边界条件下行为与预期不符）

| 文件:行 | 触发条件 | 后果 | 建议(≤30字) |
|---|---|---|---|
| S2-1 MainHook.java:51, 902-908, 414-421 | 老/新 B6X 两个包都安装且进程同时存活（README 作用域同时含两者） | 两进程共写 `/data/local/tmp/tempctrl_b6x.status`，后写者覆盖；未连接方持续写 `BLE=0`，daemon 约半数帧误判 B6 断联，控制/仲裁抖动，旧包还可能按自己的 `tempctrl_last_dev` 另发连接 | 仅已连接方写 status，或按包拆文件 |
| S2-2 MainHook.java:3080-3130（3087 抛、3114-3126 不可达） | B7X（管理器为 `t9.j`）且构造函数捕获尚未发生（daemon 拉起后立即广播时最可能） | `loadClass("...WaspWingManager")` 抛异常直接冒泡，其后的静态方法/INSTANCE/`t9.j.f50990a` 兜底全部不可执行——注释声明的兜底链在 B7X 上是死代码，命令被丢弃 | appKind==7 先走 t9.j 分支或包内 try |
| S2-3 MainHook.java:95-96, 2838, 2873 | daemon 未部署/未运行（本连接从未成功广播），BLE 已连且回传稳定 | `lastBcastColdLv/RpmLv` 恒为 -1，永不与回传相等 → 15s 判停滞 → `forceReconnect`，之后约每 25s 循环断连重连 | 要求 `lastBcastColdLv>=0` 或下发计数≥N |
| S2-4 MainHook.java:424-464 | 宿主 SDK 任一 getter 缺失/抛异常（历史 `getSpeed` 即此例；`getColdRunLevel` 是较新的 getter） | 同一 try 内其后的 `COLD_REAL`/`COLD_RUN`/`TARGET_TEMP` 整段缺失，`paramMissingLogged` 的「已恢复」日志也被跳过——与「RPM_RUN 整列缺失」同源 | 每个 getter 独立 try（照 RPM_RUN） |
| S2-5 MainHook.java:2028-2035（对比 1222-1233） | B7X 新装、`BLUETOOTH_CONNECT` 未授予，用户直接点连接 | `c0.s1()` 被无条件改为 true，SDK 继续走到 `getType()/connectGatt()` 抛 `SecurityException`；宿主该链路无 try/catch（代码注释自述），可致宿主崩溃。B6X 侧有实测权限门控，B7X 没有 | 与 B6X 一样用实测权限门控 |
| S2-6 MainHook.java:292-332（328） | 任意第三方应用发送 `com.flydigi.SET_TEMPERATURE[_B7]` | `RECEIVER_EXPORTED` 且无权限/无发送方校验、7 个 int 不钳制，任意值直达 `setRunMode`；可造成设备非预期档位或 SDK 异常 | 私有权限/发送方校验 + 参数钳制 |
| S2-7 MainHook.java:1355-1375, 3180-3196 | 宿主进程内任何非散热器 GATT 被 `disconnect()`（如 `DfuService` 的 DFU 连接、其它 BLE 设备） | 全局 `BluetoothGatt.disconnect` 钩子不校验 gatt 身份，直接 `markDisconnected`：清 `currentValidGatt`/`bleConnected`、写 `BLE=0`，daemon 误判断联并停止控制，tick 又发起重连 | 仅当 gatt == 当前控制 gatt 时处理 |
| S2-8 MainHook.java:1992-1997, 2002-2004 | B7X 连接超时（`c0$b.R1`） | 钩子目标写成 `c0`，而 `R1` 声明在内部类 `c0$b`（`b7_overclock_v3/sources/com/flydigi/sdk/bluetooth/c0.java:86,392`）；`findAndHookMethod` 只查声明方法 → 注册失败，且回调对象无 `E`/`I` 字段。超时 gatt 不 close，句柄泄漏回归 | 改钩 `c0$b.R1`，经 `this$0` 取 controller |
| S2-9 MainHook.java:1476-1477, 1507-1508 | B7X（任何连接/构造） | B7X 的队列字段是 `H`（`b7_overclock_v3/sources/.../AbstractDataInteractionController.java:30`），代码固定读 `mConcurrentLinkedQueue` → `NoSuchFieldError` 被吞，队列替换失败；「双设备」的 runFetchLoop 100% CPU 修复在 B7X 上从未生效（`getCommandQueueSize`/`clearCommandQueue` 同因失效） | 字段名按 appKind 分流（B7X=H） |

### S3（一致性 / 可读性 / 运维负担）

| 文件:行 | 触发条件 | 后果 | 建议(≤30字) |
|---|---|---|---|
| S3-1 MainHook.java:483-501 | app 进程在 `/data/local/tmp` 无目录写权限（daemon 只预建最终文件，`tempctrl.c:1978-1989` 未预建 `.tmp`）或 rename 失败 | `.tmp`+rename 的原子路径恒失败且无日志，静默退化为截断直写；daemon 可能读到空/半截文件（低概率） | daemon 预建 `.tmp` 0666；失败留痕 |
| S3-2 MainHook.java:485-500, 1805-1807, 2146-2148, 2338-2340, 2368-2370 | `write` 抛异常（ENOSPC 等） | `FileOutputStream` 无 try-with-resources，fd 泄漏；status 每秒重试会累积 | 全部改 try-with-resources |
| S3-3 MainHook.java:92, 1945, 2060, 3187-3191 | SDK 换实例但未对旧 gatt 触发 disconnect 回调 | `connectedControllers` 无上限/无淘汰，长期驻留 controller+gatt 对象 | 重连成功时清旧条目或加上限 |
| S3-4 MainHook.java:193, 1651-1655, 1781 | 自动跳转后源 Activity 未及时 `onStop`（半透明/任务复用） | 静态持有 Activity；后续真实退后台会被 `act == b7AutoEnterFrom` 误判为跳转而漏记，可能再次自动弹入 | WeakReference + 超时清理 |
| S3-5 MainHook.java:507-515 | status 写盘抛异常 | `checkCommandStall()` 与写盘同处一个 try，被整段跳过一拍，自愈延迟 1s | 把自愈检测移出写盘 try |
| S3-6 StartupTiming.java:270-277, 210, 36, 227-228 | 外部按 `slotCount()` 语义调用 `slot()`；javadoc 引用不存在的方法 | `slot(int)` 实为原始数组下标（调用方须 ×2），命名/契约易误用；`{@link #counter(int)}` 悬空；注释「6 个之一」与 `SUB_COUNT=8` 漂移 | 更名 rawSlot/提供取值封装，修注释 |
| S3-7 AppFiles.java:141-146, 175-177 | `maxBytes<0`（当前调用方均为正常量） | `length-start` 为负 → `NegativeArraySizeException` 被 `catch(Throwable)` 包成 IOException，诊断误导；`Error` 也被降级为 IOException | 参数校验；只捕 IOException |
| S3-8 AppFiles.java:133-136 | 展示诊断串 | 文案「app 无权直读」与本类注释、§3.6「同 uid 可直读」矛盾，排障误导 | 改文案为「daemon 落点参考」 |
| S3-9 MainHook.java:1209-1351 | 该 try 内任一 `loadClass`/`findAndHookMethod` 失败（宿主更新改名等） | 其后全部钩子（含 `checkBluetoothPermission`、`onDeviceInfoUpdate`）静默不注册；只有首条日志，部分注册态不可辨 | 拆成逐钩子 try（照 hookB6Activity） |
| S3-10 MainHook.java:447（tempctrl.c:355-364, README.md:118,131） | 每秒写 status | `TARGET_TEMP` 全仓无消费方，白写一次 getter 与一行文本；README 把它列为 daemon 解析字段，契约声明与实现不符 | 删除该字段或补消费端 |
| S3-11 MainHook.java:2838（tempctrl.c:2704-2732） | 设备回显与最后下发值存在折算/取整偏差（README 明示 `RPM_REAL`「经超频逻辑折算」），而 daemon 侧到位判据含死区（冷 3 / RPM 50） | 停滞判据用精确相等、到位判据用容差，两侧口径不一；一旦回显不逐值等于最后下发值就会周期性误判停滞 | 与 daemon 同口径或用容差（待真机） |
| S3-12 MainHook.java:2412-2414 | 透明转发页恰为任务根 | 判据 `taskRoot \|\| isBackHideTargetActivity()` 短路，排除表对该情形失效，返回键被接管 | 先判排除表再判 taskRoot（待真机） |
| S3-13 MainHook.java:79, 1878/1909, 3081 | 构造函数钩子在非主线程捕获管理器 | `capturedWaspWingMgr` 非 volatile，接收器线程可能读到旧 null，偶发「实例未就绪」 | 加 volatile |
| S3-14 MainHook.java:3149 | 阅读代码/运维对照日志 | 注释「每连最多 3 条」与 `DIAG_LOG_MAX_PER_CONN=1` 不符 | 改注释 |
| S3-15 lsp模块（无 test 目录） | 任何回归 | 纯文件/纯函数逻辑（readTail、槽位 CAS、型号映射）与协议对称性无自动保护 | 加 JVM 测试与协议核对脚本 |
| S3-16 MainHook.java:3211-3216（`WaspWingInfo.smali:262`、b7 `WaspWingInfo.java:64`） | 每次参数回传（B6X） | `experimentalRunModeValue` 字段类型是 `Ljava/lang/Integer;`，`setIntField` 必抛 `IllegalArgumentException` 且被空 catch 吞掉，该屏蔽手段从不生效；当前自修复入口已被 `setExperimentalRunMode` 钩子另行屏蔽，故属冗余死代码 | 改 `setObjectField` 并留痕，或删段 |

---

## C. 越界发现

| 归属包 | 一句话 |
|---|---|
| daemon | `maintain_temp_stop()` 只在等待设备循环（`tempctrl.c:5215`）与 `main_loop()`（4678）里调用；主循环断联分支在 `5326/5338/5363` 提前 `continue`，此时 temp_stop 文件 mtime 会老化。当前 hook 侧只在 `bleConnected` 为真时读它，故无实际影响；若将来有别的消费者按「新鲜」判定，会误读。 |
| daemon | BT 请求的首次读只记基准不执行（`tempctrl.c:4821-4825`），而 hook 在写请求前就落盘了冷却时间戳（`MainHook:2364-2373`）；daemon 重启后首个请求可能被吞，自动开蓝牙最坏再等一个 `BT_AUTO_ENABLE_SEC`（默认 300s）。 |
| daemon / 文档 | status 协议表把 `TARGET_TEMP` 列为「供 daemon 解析」（`README.md:118,131`），daemon 的 `STF_*` 表（`tempctrl.c:355-364`）并无该字段。 |
| 文档 | `README.md:19` 仍写「连续 3 次参数下发后回传仍停滞」，实现早已是按 15s 时间窗判定（`app/逻辑说明.md:91` 已更新），两份文档口径不一。 |
| 部署 | `create_status_files()` 只预建最终 status 文件（`tempctrl.c:1978-1989`），未预建 `.tmp`，hook 的原子写路径依赖目录写权限（见 S3-1）。 |

---

## D. 已核实无害（可疑但不成立）

- **广播契约**：`BROADCAST_EXTRAS` 的 7 个名称与顺序、两个 action、`b6x_auto_launch` 的 String 类型，均与接收端逐项一致（含 `am start --es`）。
- **反射签名**：`onDeviceConnected`、`onGattConnected`、`onDeviceInfoUpdate(WaspWingInfo)`、`onCharacteristicChanged` 两参版、`connect()`、`startLeScan()/stopScan()`、`c0.s1()`、`a.S1/T1/Z0`、`t9.j.W(7×int)`、`connectGattWith(BluetoothDevice)`/`t9.j.E`、`WaspWingDataInteractionController.deviceInfo`、`t9.j.f50990a/f50991b` 均在对应类中声明（三份反编译逐条核对），不存在其它「钩错类」。
- **九项 getter**：`getRunMode/getHotSurfaceTemperature/getTemperature/getTemperatureDecimal/getRealWindLevel/getRealColdLevel/getColdRunLevel/getTargetTemperature/getSpeed` 在 B6X 老/新与 B7X 三份反编译中全部存在，当前不会触发 S2-4 的缺失路径。
- **CPU 修复（B6X）**：`mConcurrentLinkedQueue` 只由 `AbstractDataInteractionController` 构造器赋值（`b6_devtool/...:83,123-127`），after-hook 替换后不会被覆盖；队列原内容为空，drain 无数据丢失。
- **Handler/清单**：`mainHandler()` 懒加载、`sPendingHooked` 有锁；`VM_FIX_FLUSH` 为静态 Runnable，无 Activity 泄漏。
- **`forceReconnect` 重入**：`disconnect()` 钩子会重入 `writeStatusFile`，但内层 `checkCommandStall` 因 `bleConnected=false` 立即返回，且 10s 防抖，不构成递归/死锁。
- **StartupTiming**：`span/mark/count/accFlush` 的 CAS 与「首写胜出」自洽；后台调用方只用原子 API；`accBegin/accEnd/accReset/accFlush` 的调用点全在主线程建表链上；`markCount` 读计数格的下标正确。
- **AppFiles 尾读**：`readTail` 的换行裁剪与「整块无换行则整块给出」逻辑正确；`decode` 的非法字节替换与文档一致。
- **B7X 自动进入控制页**：`key_device_type=3`、`key_device_code`、`ip_type`、`DetailActivity` 类名与 `DataConstant` 常量逐值一致。
- **`GATE_LE` 只写不读**：有意保留给旧版模块，README 与 app 逻辑说明均已声明，不是漏读。
- **`hookControllerScanEntry`**：`A0()` 先置 `f16228r` 再起扫、只认 `F0()` 清标志，与 hook 的 before 处置一致（B7X 反编译核对）。

---

## E. 未覆盖 / 待真机

1. `/data/local/tmp` 是否允许 app 进程（untrusted_app）创建 `.tmp` —— 决定 S3-1 的原子写是否真的只走直写兜底；需要 `ls -ld /data/local/tmp` + SELinux 策略/实测 open。
2. B7X `:remote`（`FloatingWindow` 服务）在正常使用中是否被拉起 —— 决定 S1-1 的触发频率；需要服务端 `dumpsys activity services com.fdg.flashplay.farsef` 与实际使用路径确认。
3. 宿主是否会用非散热器 GATT（DFU、其它 BLE 设备）调用 `disconnect()` —— 决定 S2-8 的实际触发面；需要抓 `BluetoothGatt.disconnect` 钩子日志的 device 地址对照。
4. 设备回显 `getRealWindLevel/getRealColdLevel` 是否逐值等于最后下发值（超频折算/取整是否引入固定偏差）—— 决定 S3-11 的严重度；需要真机对照 status 的 `RPM_REAL/COLD_REAL` 与广播值。
5. B7X 超时补 close 修正到 `c0$b` 后，回调是否确有 `this$0` 且能取到 `E/I` —— 需真机 dump 字段。
6. `DISPATCH_STALL_TIMEOUT_MS=15000` 与实际下发节奏（daemon 控制周期 5s、平滑下发 5 份/s）在弱链路下的表现 —— 需真机日志统计误触发率。
7. B7X 队列字段改为 `H` 后，是否有子类在构造后重写该字段 —— 需再核对 SDK 版本。
8. 预测性返回：宿主升到 targetSdk≥35 或启用 `enableOnBackInvokedCallback` 后，两处 `onBackPressed` 钩子失效（文档已记，未做兼容）。
9. `hookDeviceTypeGate` 不覆盖新 B6X 包与 B7X 包（文档已记）；新包上后台重连是否仍被 SDK 类型门卡住未验证。
