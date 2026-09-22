# 路线 A — 线 C：Deployer + service.d + ConfigStore（进展）

> 在 `.claude/`，不进版本库。**未 git add**。

## 产物
- 新增 `app/src/main/java/com/example/waspwingtempctrl/ConfigStore.java`（I3；纯文本层为嵌套类 `ConfigStore.ConfText`，不含 Android API，可在桌面 JVM 单测）
- 新增 `.../Deployer.java`（I4；I5 的调用边界）
- 新增 `app/src/main/assets/deploy/b6x-tempctrl.sh`（service.d 模板：**逐字节**部署、无占位符，故内容哈希可直接与 APK 内比对）
- 改 `.../SetupActivity.java`（只接线：状态/一键部署/卸载部署/拉起/su 诊断对话框；界面与 res 仍属线 D）
- 改 `lsp模块(apk修复+温控接口)/gradle.properties`：**只加一行** `android.overridePathCheck=true`（原地编译，见文末）
- 未碰：RootShell / MainHook / params.json / Manifest / build.gradle.kts / res / tempctrl.c / magisk模块框架 / build.yml / 任何 md

## I3 冻结：`ConfigStore`（界面只准用它读写 profile.conf）
`static ConfigStore get(Context)`；`File getConfigFile()/getPrivateDir()` · `String daemonConfigPath()/configFileName()` · `boolean exists()/isPathAlignedWithDaemon()/definitionsLoaded()` · `int keyCount()` · `List<GroupMeta> groups()` · `List<KeyMeta> keys()` · `KeyMeta key(String)`（未知→null）
读：`Snapshot read()`（`values`/`unknownKeys`/`exists`/`mtimeMs`/`notes`）· `Value get(String)`
写：`WriteResult set(String,Value)` · `WriteResult setAll(Map<String,Value>)` · `WriteResult writeFactoryIfAbsent()`
校验：`Assessment assess(String,Value)`（`uiValue`/`changedByClamp`/`guardrail`/`notes`）· `Accept daemonAccepts(String,Value)`（`accepted`/`reasons`/`degraded`）· `boolean isGuardrailValidated(String)` · `String guardrailConsistency()` · `String describeState()`
语义（冻结）：① 普通 Java File IO，同 uid，**不需要 root**；② **原子替换**（同目录 `.tmp` + fsync + `renameTo`），因 C 端 5s `stat()+st_mtime` 轮询；③ 改单键**逐字节保留**注释/空行/行序/行内注释与对齐空白，同键多行全改，键不存在则追加；④ 未知键（params.json 未定义）**拒绝写入**；⑤ 值未变则不写、不触 mtime；⑥ 元数据（类型/min/max/默认值/分组/label）全部读 `assets/params.json`，不手抄；⑦ `st_mtime` 只有**秒级**精度 → 界面防抖需 ≥1s，否则 C 端不重载；⑧ 多值键在文件里 token 少于字段数时 C 端**保留旧值**（不是补 0）；⑨ 护栏键 `PID_KI_DYN_T/GATE/WIN`：**界面钳制 ≠ C 端语义**（C 端越界整组拒绝、保留旧值），界面问"会不会生效"必须用 `daemonAccepts()`。
`writeFactoryIfAbsent()`：仅文件不存在时写；值取 `factory`；已存在（含空文件）**一个字不覆盖**。

## I4 冻结：`Deployer`（部署完成判定）
`static Deployer get(Context)` · `Status probe()` · `Result deploy()/uninstall()/startDaemon()` · `boolean isRunning()` · `String buildDiagnostics()`
判据（只用 APK 侧可得信息，**未要求 C 端加 --version**）：su 可用 ∧ `/data/local/tmp/tempctrl` 存在 ∧ 可执行 ∧ md5 == assets/`tempctrl-arm64`，∧ service.d 脚本存在 ∧ md5 == assets/`deploy/b6x-tempctrl.sh`。配置存在与进程在跑**只作状态**，不参与判定。常量：`BIN_ASSET`/`BIN_DEST`/`SCRIPT_ASSET`/`SCRIPT_NAME`/`SERVICE_D_MODERN=/data/adb/service.d`/`SERVICE_D_KSU_LEGACY=/data/adb/ksu/service.d`/`KSU_MODERN_VER_CODE=10683`/`EXIT_ALREADY_RUNNING=2`。
部署：私有目录中转（File API 落盘 + `setExecutable(true,false)` 沿父链）→ root `cp`+`chmod 0755` 到 `/data/local/tmp/tempctrl` 与 service.d（`/data/local/tmp` 与 `/data/adb` 不是 app 可写目录，chmod 只作用于 root 拥有的路径）→ md5 核对 → 配置保留写入 → 省电白名单（`dumpsys deviceidle whitelist +`、`appops set RUN_IN_BACKGROUND allow`、`am set-standby-bucket active`、`am unfreeze --sticky`（失败退裸 `am unfreeze`））→ 自检。KSU 目录用 `ksud -V` 嗅探 verCode <10683 才走 legacy。
拉起：`startDaemon()` 先判活、再 10s 冷却，直接执行启动命令由 C 端单实例锁兜底；service.d 脚本负责 `pkill` → **轮询 pgrep 等真退出** → 启动（只 `sleep 1` 会让新实例立刻以 2 退出）。
I5 边界：界面只调上述 5 个方法 + 读 `Status` 文本，不拼 shell、不碰文件。

## 卸载残留清单（`uninstall()` 实际行为，逐条）
| 残留物 | 谁清 | 清了影响在跑的进程吗 |
|---|---|---|
| **看门狗 shell**（脚本自身的常驻循环，cmdline 不含二进制路径） | 本方法（root）：`pkill -f b6x-tempctrl.sh` + **轮询等真退出**，**先于守护进程杀** | 必须杀：否则它下一轮 tick 会把刚删的日志重建、并把守护进程再拉起来 |
| service.d 脚本（两个候选目录都 rm） | 本方法（root） | 不影响：脚本只在开机跑一次 |
| `/data/local/tmp/tempctrl` | 本方法（root） | 先 kill 再 rm；unlink 不影响已运行进程 |
| `tempctrl.lock`（私有目录） | Java 删，**仅确认两个进程都已退出后** | 进程活着时删会绕过单实例锁，故未确认退出就不删 |
| `tempctrl.lock` **旧落点** `/data/local/tmp/…` | 本方法（root） | 无（旧版迁移残留，非重复代码） |
| `/cache/tempctrl.log`（私有目录不可用时的兜底日志） | 本方法（root） | 无 |
| `/data/local/tmp/tempctrl_b6x.status`、`_b7x.status` | 本方法（root） | 守护进程下次启动重建；仍激活的 MainHook 读到缺失即视为断联 |
| `/data/local/tmp/tempctrl_service.log`（脚本自身日志） | 本方法（root） | 无 |
| 私有目录 `tempctrl.log`、`tempctrl_webui.data`、`deploy/`（中转副本） | Java（无需 root） | 无 |
| `profile.conf` | **不清**：用户配置，卸载部署≠删配置 | — |
| `tempctrl_last_dev` **旧落点** `/data/local/tmp/…` | 本方法（root）：**旧版迁移残留**，daemon 侧预创建已删、现无人读写，不会自己消失，卸载时一并清 | 无 |
| `tempctrl_last_dev` **新落点**（飞智 app 私有目录，各包各记） | **不碰**：不属本次产物，也不在我们有权的目录里 | — |
| 省电白名单 | **不清**：对仍装着的 LSPosed 模块同样有益，用户可自行撤销 | — |

## 验证
- **原地编译通过（本机，非副本）**：`assembleDebug` 与 `assembleRelease`（含 `lintVitalRelease`）均 BUILD SUCCESSFUL；versionCode 4 / versionName 2.6 / targetSdk 34 / xposed 四条 meta-data / launcher activity 不变；未新增用户可见权限（仅 androidx 自签名权限）；APK 内含 `assets/deploy/b6x-tempctrl.sh`，不含 `tempctrl-arm64`（CI 注入）。
- **改单键逐字节可复现**：宿主 JVM 上编译**仓库里的 ConfigStore.java 本体**跑 41 条断言全通过（样例为真实 `magisk模块框架/profile.conf`，12641 B / 205 行）：只改一行、其余行逐字节一致；行内注释与对齐空白保留；CRLF 保留；同键多行全改；键不存在则追加且原文是前缀。测试期发现并修掉两个真 bug（同键多行只改第一行；值为空时 `A=  # c` 被拼成 `A=  2# c`）。
- **未验证**：真机上的 root 往返、`md5sum`/`ksud`/`service.d` 实际拉起、C 端热重载（本机无 Android 运行环境）；`writeFactoryIfAbsent()` 生成的全文未在设备上跑过（仅用 params.json 交叉核对 52/52 键覆盖：4 个 master + 48 个组内键，另有未分组兜底）。
- 交错任务结论：AGP 8.2.0 的 `android.overridePathCheck` 是**有效开关**（`BooleanOption` 第 35 项；实测不加会**抛异常拒绝配置**，不是警告），已加；**后续（含线 D）改用原地编译**，不必再同步 ASCII 副本。

## 未决（需主窗口拍板）
1. ~~私有目录包名不一致（阻断级）~~ **已解决**：协调方已把 `tempctrl.c` 的 `PRIVATE_DIR` 与 `ConfigStore.DAEMON_PRIVATE_DIR` 同改为 `/data/data/com.example.waspwingtempctrl/files`（不改 applicationId，避免破坏已发布 APK 身份）。两处字面量已核对一致；`isPathAlignedWithDaemon()` 保留为跨语言护栏。**附带修正**：该护栏改为**先比规范路径**再退回字面比较——设备上 `getFilesDir()` 通常是 `/data/user/0/<包名>/files`（`/data/data` 是它的符号链接），只比字面会误报。
2. ~~`LOG_FILE` 的 factory 指向 `/cache`~~ **已不成立**：P0 已把 `params.def.json` 的 default/factory 改为 `/data/data/com.example.waspwingtempctrl/files/tempctrl.log` 并重生成产物（本线已复核 `params.json`）。**遗留**：`ConfigStore.writeFactoryIfAbsent()` 的 javadoc 里仍写着旧的「factory 是 /cache，属 I1 待修」一句话，属陈旧注释；`ConfigStore.java` 在本轮禁止改动清单内，故未动，待下次一并清理。
3. KernelSU <10683 的目录分界靠 `ksud -V` 解析，解析不到就落 `/data/adb/service.d`；真机才能确认。
4. 未新建独立 Java 文件：纯文本层做成 `ConfigStore` 的嵌套类 `ConfText`（便于宿主 JVM 单测）。新增物 = 2 个 java 文件 + `assets/deploy/`，均在原文件清单内。
5. `probe()` 在两个 service.d 目录都有脚本时报**现代路径**（KV 协议后写覆盖先写），实际生效目录仍以 `deploy()` 返回的 `SVCD` 为准。

## 追加（协调方指令后，已重编复验）
1. **路径护栏修正**：`isPathAlignedWithDaemon()` 先比规范路径再退回字面比较（理由见未决 1）。两端常量字面量已核对一致。
2. **预创建运行时文件＝防御性优化，未经真机验证**：部署时由 app 以自身 uid 用普通 File IO（**不用 root**）在私有目录预创建空的 `tempctrl.log` 与 `tempctrl_webui.data`，仅在不存在时建、失败不阻断部署。假设前提是「root 创建的文件 SELinux 标签未必是 `app_data_file`」——**此假设未验证**，故按防御性处理、不作为依赖项；界面读这两个文件失败时仍要按原样报错。
3. **已核对 C 端轮转语义（读源码，非真机）**：`write_log()` 轮转是 `open(O_RDWR)`+`pread/pwrite`+`ftruncate` **原地截断，不 rename 不重建**，写路径是持久 `FILE*` + `fopen(path,"a")`；`write_webui_data()` 同样是 `"a"` 追加与原地 `"w"` 重写，全库无 `rename/unlink` → 上述预创建**不会被轮转打回 root 创建**，不只对首次有效。唯一不覆盖的情形：二进制被改名或 `LOG_FILE` 被改成别的名字。
4. 重编复验：`assembleDebug` + `assembleRelease`（含 lintVitalRelease）均 BUILD SUCCESSFUL；`ConfText` 41 条断言重跑全通过。

## 追加 2（P3 验收缺陷修复，已重编复验）
1. **卸载先杀看门狗 shell 再杀守护进程**：`pkill -f b6x-tempctrl.sh` + 轮询等真退出（新增 `WATCHDOG_STOPPED` KV）；两个都确认退出才清私有目录（原来只 gate 守护进程）。缺陷成立原因：脚本 cmdline 不含 `$BIN`，只 `pkill $BIN` 抓不到它 → 脚本文件删了 shell 还在，下一轮 `log()` 会把 `/data/local/tmp/tempctrl_service.log` 重建、`start()` 会把守护进程拉回来。
2. **脚本看门狗自尽自检（纵深防御）**：每轮 tick 先查「脚本文件（`$0` 含 '/' 时）与二进制是否还在」，任一不在 → **静默 `exit 0`**（静默是必须的：一旦写盘就又把删掉的日志建回来），且检查排在任何 `log()/start()` 之前。**已沙箱实测**：删脚本+二进制+日志后，4 秒内 shell 自行消失且日志未被重建。
3. 补 `/cache/tempctrl.log` 清理（私有目录不可用时的兜底落点）。
4. `/data/local/tmp/tempctrl.lock` 补旧版迁移残留注释，与私有目录那份显式区分（防后人当重复代码删一行）。
5. `diagnose_status.sh`（实际在**仓库根**，不在 `magisk模块框架/`）：§1 的 `/data/adb/modules/*/module.prop` 扫描改为看部署产物（二进制 / service.d / 看门狗 / 配置 / `dumpsys package` 取 APK 版本），旧版 Magisk 残留单独一段且无输出时明说「符合合并后形态」（原实现是**静默空输出**）。**额外一并修了 §3**（协调方裁定改法）：MAC 记录改为**通配符扫目录** `for p in /data/data/*/files/tempctrl_last_dev /data/local/tmp/tempctrl_last_dev`，**不列包名** —— 包名手抄已是已知漂移点（R4），诊断脚本不能再新增一份；旧 `/data/local/tmp` 仅作兼容。**已沙箱实测**：建两份假 `…/files/tempctrl_last_dev` 能全部列出并打印内容；扫不到时输出可读的「(无 tempctrl_last_dev：…)」而不是空。
6. **未做**（按指令）：`MainHook.java:272` 的 `<status>.tmp` 未加进清理清单。
7. 复验：`assembleDebug`+`assembleRelease` 均 BUILD SUCCESSFUL；`ConfText` 41 断言全通过；APK 内 `assets/deploy/b6x-tempctrl.sh` 与源文件**逐字节一致**（md5 `a854d923c49186e62cc7d65d421d1da5`，4256 B）→ I4 的哈希比对成立；新 uninstall 片段语法与 `WATCHDOG_STOPPED/STOPPED` KV 协议沙箱通过。

## 上下文用量
本轮线 C 单 agent 执行，未派 subagent；自查约 245k/1000k tokens。
