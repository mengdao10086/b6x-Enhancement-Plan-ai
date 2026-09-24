# Magisk 模块 → LSPosed 模块：路线合并记录

> 由原 `.claude/路线A-*.md` 8 份提炼，只保留**思想与实现方式**：具体进展流水、逐条验收结果、各线自述与验收报告之间的冲突记录与整改流水均已删除。
> **协议规范的唯一来源是 [lsp模块/README.md](../lsp模块/README.md)**（广播协议、status 文件协议），本文不复制协议表；温控策略设计见 [lsp模块/daemon/逻辑说明.md](../lsp模块/daemon/逻辑说明.md)。

---

## 1. 为什么改路线

原路线 = 「刷 Magisk 模块（`magisk模块框架/` 的 `module.prop` / `customize.sh` / `service.sh` / `uninstall.sh` + `webroot/` 静态界面）+ 直接改 APK（smali 反编译重打包）」。改为 **LSPosed 模块**路线的理由：

- **交付物收敛为单个 APK**：LSPosed 模块本就随 APK 安装，把「落盘 C 二进制 + `service.d` 拉起脚本」改成 APK 内的**一键部署**后，不再需要单独发 Magisk 模块包；CI 也随之从多产物收敛为单一 `build` job、唯一交付物 APK。
- **不再依赖模块目录规范，同时保持多 root 兼容**：部署改由 APK 侧用 root 落盘到 `/data/local/tmp/` 与 `service.d`，Magisk 与 KernelSU（现代目录 + legacy 目录，用 `ksud -V` 嗅探）都能拉起；仍是 root 拉起，但不要求用户刷模块。
- **直接改 APK 路线已废弃**：smali 反编译重打包的尝试收在 `参考资料/smali_patching_attempts/`（失败尝试），现由 LSPosed 钩散热器 SDK 的 `setRunMode()` 下发 BLE 指令取代。
- **消除参数漂移**：WebUI 时代配置键在 4 处手工同步（`webroot/schema.js`、`profile.conf`、`逻辑说明.md` 参数表、`tempctrl.c`）——四份键集合虽无缺无多，但**键序 / 默认值语义 / 分组元字段 / 类型覆盖**四类不一致，需逐条裁定才收敛。改为「单一手写来源 + 生成器 + 校验脚本」（见 §5）。
- **界面从 WebUI 换成原生界面**：`webroot/` 的 `app.js` / `index.html` / `style.css` 整体删除，界面改为 APK 内原生实现（见 §2）；用户可见文案不再引用内部文件名。
- **清理与隐私**：daemon 的数据落点从 `/data/local/tmp`（root 共享、文件 `0666`）与 `/cache` 迁到 app 私有目录，卸载 APK 时由 `Deployer.uninstall()` 统一清；不再靠 `uninstall.sh` 自清理脚本。

---

## 2. 模块骨架与职责划分

`lsp模块/app/src/main/java/com/example/waspwingtempctrl/`：

| 组件 | 职责 |
|---|---|
| `RootShell`（I2 冻结） | su 通道的唯一封装：SU 类型嗅探（MAGISK / KERNELSU / APATCH / UNKNOWN）与命令选型、判活（带指数退避，1s 起、上限 60s）、阻塞执行（默认超时 30s；**禁止主线程**）、常驻会话（`cd` / `export` 跨命令保留）。执行脚本不得为空、不得含 `exit` |
| `ConfigStore`（I3 冻结） | `profile.conf` 的唯一读写层，**界面只准用它读写配置**（见 §3）。纯文本层做成嵌套类 `ConfigStore.ConfText`，不含 Android API，可在桌面 JVM 单测 |
| `Deployer`（I4 冻结） | 部署 / 卸载 / 拉起 + **部署完成判定**。判据只用 APK 侧可得信息：su 可用 ∧ `/data/local/tmp/tempctrl` 存在且可执行且 md5 == `assets/tempctrl-arm64` ∧ `service.d` 脚本存在且 md5 == `assets/deploy/b6x-tempctrl.sh`。配置存在与进程在跑**只作状态，不参与判定**（不要求 C 端加 `--version`） |
| `MainHook` | LSPosed 钩子：钩散热器 SDK 的 `setRunMode()` 下发 BLE 指令；双 `status` 文件心跳；双广播接口；`tempctrl_last_dev` 持久化 + 冷启动自动连接 |
| 原生界面 `ui/` + `SetupActivity` | 三页签「状态 / 配置 · 曲线 / 日志」（底部页签，左右跟手滑动切页），另有界面参数设置页。只作薄外壳 + 各页 Fragment |

**I5 边界（界面调用边界）**：界面只调 `Deployer` 的 `probe / deploy / uninstall / startDaemon / buildDiagnostics` 与 `ConfigStore` 的读写，**不拼 shell 命令、不碰文件、不直接调 `RootShell`**；唯一例外是 `ui/AppFiles.java` 直读层（只读 `tempctrl.log` 与曲线数据文件的尾部，不读 `profile.conf`）。`RootShell` / `Deployer` 的阻塞方法一律放后台线程。

---

## 3. 关键设计决定

- **私有目录成为唯一数据落点**：`PRIVATE_DIR = /data/data/com.example.waspwingtempctrl/files`。
  - 包名与 `applicationId` 一致；**不改 applicationId**，避免破坏已发布 APK 的身份。
  - daemon 的 `PRIVATE_DIR` 与 `ConfigStore.DAEMON_PRIVATE_DIR` 逐字一致，并保留 `isPathAlignedWithDaemon()` 作跨语言护栏——**先比规范路径、再退回字面比较**（设备上 `getFilesDir()` 通常是 `/data/user/0/<包名>/files`，`/data/data` 是它的符号链接，只比字面会误报）。
- **`tempctrl_last_dev` 落点迁移**（原 `/data/local/tmp/` 四包共用 → 宿主 app 私有目录 `/data/data/<宿主包名>/files/tempctrl_last_dev`，各包各记）：
  - 键用**包名常量**而非 `appKind`——包名常量 3 个（B6X 老 / B6X 新 / B7X），而 `appKind` 只有 6/7 两值，**不是一一对应**，按 `appKind` 拼会把两个 B6X 包并成同一个文件。
  - 路径**拼死**不用 `getFilesDir()`（冷启动可能早于 Application 挂载、拿不到 context）；写前 `getParentFile().mkdirs()`。
  - daemon 侧不再预创建该文件（预创建块已删），文件完全由 app 自建自用；对旧路径**不做兼容读取**（一次性切换）。
- **单实例锁**：`flock(LOCK_EX|LOCK_NB)` 落在私有目录；取不到锁退出码 **2**（语义「已有实例在运行」，部署脚本判活/幂等可直接用），其余启动失败路径均返回 0，可区分。
  - 锁文件曾一度放 `/data/local/tmp/`，经用户复核裁定迁回私有目录。**已知后果**：app「清除数据」会连锁文件一起删，运行中的实例仍持旧 inode 上的锁 → **那一次锁失效**，兜底靠部署脚本的开机自检。
  - `pkill` 后必须等旧进程真正退出再启动，否则新实例立刻以 2 退出；`service.d` 脚本负责轮询 `pgrep` 等真退出，不能只 `sleep 1`。
- **日志 / 曲线数据落点**：`PRIVATE_DIR/<二进制名>.log` 与 `PRIVATE_DIR/tempctrl_webui.data`；私有目录不可用时日志兜底回 `/cache/<二进制名>.log` 并写 stderr（**不静默**）。
  - 部署时由 app 以自身 uid **预创建**空 `tempctrl.log` 与 `tempctrl_webui.data`（仅不存在时建、失败不阻断部署），因为 root 创建的文件 SELinux 标签未必是 `app_data_file`——按防御性处理、不作依赖项，界面读失败仍按原样报错。C 端日志轮转是原地截断（不 rename 不重建），故预创建不会被轮转打回 root 创建。
- **`status` 双文件原样不动**：路径、字段、预创建、`chmod 0666` 一字未改，仍在 `/data/local/tmp/`；daemon 不写 status，只 `fopen(...,"a")` 预创建，写入端只有 `MainHook`。
- **卸载先杀看门狗 shell、再杀守护进程**：`service.d` 脚本自身的 `while true` 看门狗，其 cmdline 不含二进制路径，只 `pkill -f "$BIN"` 抓不到它——脚本文件删了 shell 还在，下一轮 tick 会把刚删的日志重建、把守护进程拉回来。做法：`pkill -f b6x-tempctrl.sh` + 轮询等真退出，**先于**守护进程杀；脚本侧另加纵深防御——每轮 tick 先查脚本文件（`$0` 含 `/` 时）与二进制是否还在，任一不在就**静默** `exit 0`（一旦写盘就又把它删掉的日志建了回来），且该检查排在任何 `log()` / `start()` 之前。
- **护栏键语义（已失效，2026-09-23）**：下列三个键与 `ConfigStore.daemonAccepts()` 已随「冷值动态倍率」落地一并删除，现存参数一律走 C 端钳位、界面钳制即 C 端语义。以下为当时的约定，保留作记录：`PID_KI_DYN_T` / `PID_KI_DYN_GATE` / `PID_KI_DYN_WIN` 在 C 端是**越界整组拒绝（不是钳位）**、保留旧值；界面按 min/max 钳制会让用户触发不到该分支。界面问「会不会生效」必须用 `ConfigStore.daemonAccepts()`，不得声称界面钳制等同 C 端。

---

## 4. C 端 8 处最小改动（做法）

对象：`lsp模块/daemon/tempctrl.c`。均为最小改动，**不碰** PID/KI 算法、clamp、广播协议、status 路径。

1. **私有目录落点**：新增 `#define PRIVATE_DIR "..."` + 新函数 `ensure_private_dir()`（`mkdir` 0771；**新建时 chown 为父目录属主 = app uid**，否则 root 先建会让 app 自己写不进 `profile.conf`）。只 `mkdir` 一层：父目录 `/data/data/<包名>` 不存在时 ENOENT 失败、**绝不逐级创建**（父目录须由系统 installd 建并打 SELinux 标签）。
2. **日志默认路径**：`set_default_log_path()` 的 `/cache/<名>.log` → `PRIVATE_DIR/<名>.log`；私有目录不可用时兜底回原 `/cache/<名>.log` 并写 stderr（不静默）。取不到自身名时用 `tempctrl` 兜底。
3. **配置默认路径**：`detect_config_path()` 由「exe 同目录找 `profile.conf`」改为 `PRIVATE_DIR/profile.conf`；`--config <绝对路径>` 分支未动、仍优先。
4. **曲线时序数据**：`WEBUI_DATA_PATH` 宏改指 `PRIVATE_DIR "/tempctrl_webui.data"`（`write_webui_data()` 代码未改，只换宏）。
5. **未找到配置不再静默**：`main()` 的 else 分支加一行日志「配置未找到 … 使用代码默认值」。
6. **单实例锁**：新增 `LOCK_FILE_PATH`、`EXIT_ALREADY_RUNNING 2`、`static int lock_fd` 与新函数 `acquire_single_instance_lock()`（`flock(LOCK_EX|LOCK_NB)`）；私有目录/锁文件不可用 → stderr + 返回 1 **不阻塞启动**；`main()` 首步调用，未取到锁 → stderr + `return 2`；取到后记一行「单实例锁 已获取 <path>」。
7. **删 `uninstall.sh` 自清理**：删函数 `record_log_path_for_uninstall()`、`parse_sysfs_cfg()` 中 `LOG_FILE` 分支的调用行、全局变量 `uninstall_script_path`（仅该处使用，成死变量）。**只删这一处**，未动其它清理/收尾逻辑。
8. **删 `tempctrl_last_dev` 死代码**：`create_status_files()` 末尾「预创建 MAC 记录文件（`fopen("a")` / `fclose` / `chmod(0666)`）」整块删除——该文件迁到宿主 app 私有目录后，daemon 既不读也不该再造一个 `/data/local/tmp/` 残留物。

不变量：status 双文件全套（路径 / 字段 / 预创建 / 0666 / 读取）、全部 PID/KI/限速/仲裁、广播协议均未改。
验证口径：本机无 C 工具链（无 NDK/clang/gcc/MSVC 前端），**CI 是唯一门禁**；本机只做括号配平与人工复核。`flock` 已确认 bionic `sys/file.h` 无 `__INTRODUCED_IN` 门槛，android21-clang 可编译。

---

## 5. 参数定义机制：单一手写来源 + 生成器 + 校验脚本

- **唯一手写处**：`参数定义/params.def.json`（键 + 分组 + `chart` 段 + `audit` 段）。键数由 `参数定义/check_params.py` 的 `EXPECTED_KEY_COUNT` 断言，**不在文档里写死数字**。
- **生成器** `参数定义/gen_params.py`：由定义生成 4 个产物并纳入版本控制——`lsp模块/daemon/profile.conf`、`逻辑说明.md` 参数表段、`lsp模块/daemon/params_generated.h`、`lsp模块/app/src/main/assets/params.json`。生成**幂等**（重复执行无变化）；`--audit` 做四源漂移审计。
- **校验脚本** `参数定义/check_params.py`：A 产物可复现 / B 产物自洽 / C 四源无漂移，退出码 **0/1/2**；已接入 CI（在 checkout 之后、Gradle 编译之前）。C 侧审计默认**致命**（退出 2），线 A 改 `tempctrl.c` 的窗口期内可临时 `--no-audit`。
- **C 端键表由生成头承接**：`tempctrl.c` 的 `INT_CFG_KEYS[]` / `SYSFS_CFG_KEYS[]` 以 X 宏展开生成头（`CFG_PERF_INT_KEYS(CFG_ROW)` / `CFG_SYSFS_KEYS(CFG_ROW)`），clamp 边界不再在 C 里手抄 → **新增配置键只需改定义，C 端零改动**。
- **不得手工同步派生副本**：`profile.conf` / `逻辑说明.md` 参数表段 / `params_generated.h` / `assets/params.json` 均由生成器写出，手改会被校验判为漂移（断言 A）。
- **界面元数据**：界面表单读 `assets/params.json` 动态生成（类型 / min / max / 默认值 / 分组 / label 不手抄）；`ConfigStore` 的元数据同样取自它。

---

## 6. 卸载残留清单（`Deployer.uninstall()` 实际行为）

| 残留物 | 谁清 | 说明 |
|---|---|---|
| 看门狗 shell（`service.d` 脚本自身循环） | `Deployer`（root）：`pkill -f b6x-tempctrl.sh` + 轮询等真退出，**先于守护进程杀** | 必须杀：否则下一轮 tick 会把刚删的日志重建、并把守护进程拉回来 |
| `service.d` 脚本（两个候选目录都 rm） | `Deployer`（root） | 不影响：脚本只在开机跑一次 |
| `/data/local/tmp/tempctrl` | `Deployer`（root），先 kill 再 rm | unlink 不影响已运行进程 |
| 私有目录 `tempctrl.lock` | Java，**仅确认两个进程都已退出后** | 进程活着时删会绕过单实例锁 |
| `tempctrl.lock` **旧落点** `/data/local/tmp/…` | `Deployer`（root） | 旧版迁移残留 |
| `/cache/tempctrl.log`（私有目录不可用时的兜底日志） | `Deployer`（root） | — |
| `/data/local/tmp/tempctrl_b6x.status`、`_b7x.status` | `Deployer`（root） | 守护进程下次启动重建；仍激活的 `MainHook` 读到缺失即视为断联 |
| `/data/local/tmp/tempctrl_service.log`（脚本自身日志） | `Deployer`（root） | — |
| 私有目录 `tempctrl.log`、`tempctrl_webui.data`、`deploy/`（中转副本） | Java（无需 root） | — |
| `profile.conf` | **不清** | 用户配置，卸载部署 ≠ 删配置 |
| `tempctrl_last_dev` **旧落点** `/data/local/tmp/…` | `Deployer`（root） | 旧版迁移残留，daemon 侧预创建已删、现无人读写，不会自己消失 |
| `tempctrl_last_dev` **新落点**（飞智 app 私有目录，各包各记） | **不碰** | 不属本次产物，也不在有权的目录里 |
| 省电白名单（deviceidle / appops / standby） | **不清** | 下发对象是已安装的散热器控制 app（不是界面自身）；对它们仍有益，用户可自行撤销 |

---

## 7. 未决事项

1. **su 选型口径有两种记载，本实现以源码为准**：Scene 源码（`scene相关/decompiled/sources/a/a70.java` 的 `f()`）里 MAGISK 是单独一支 → `su`，只有 APATCH 才落到 `magisk su -mm`；另有一种旧口径记为「SDK≥30 其他 → `magisk su -mm`」。本实现照源码；若要改按旧口径，只需改 `getRecommendedSuCommand()` 一处。
2. **`magisk` 不在 app 的 PATH**：`magisk su -mm` 由 app 进程 `Runtime.exec` 启动，用的是 app 的 PATH 而非 su 的；APATCH 设备上可能起不来。已用 `checkAlive()` 的「退回裸 `su`」+ 手动切换兜底。
3. 权限（`POST_NOTIFICATIONS` 等）留到后续批次；线 D 换 AppCompatActivity 时需在 `res/values/themes.xml` 加 AppCompat/Material 主题（`res/**` 属线 D）。

---

## 相关文档

- [lsp模块/README.md](../lsp模块/README.md) —— 广播协议与 status 文件协议的**唯一规范处**
- [lsp模块/daemon/逻辑说明.md](../lsp模块/daemon/逻辑说明.md) —— 温控策略设计、参数表、落点说明
- [完整修复历程.md](完整修复历程.md) —— BLE 4 层 Bug 修复全记录
- [../参数定义/对齐报告.md](../参数定义/对齐报告.md) —— 参数定义的对账与裁定记录
