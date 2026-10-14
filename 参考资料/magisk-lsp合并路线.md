# Magisk 模块 → LSPosed 模块：路线合并记录

> **本文是归档（路线决策记录）**：只保留「为什么改路线」的决策与理由；**现行实现与当前值一律以权威文档为准**，本文不复述、也不作权威 —— 协议见 [lsp模块/README.md](../lsp模块/README.md)（广播协议、status 文件协议唯一规范处），app 侧 Java 见 [lsp模块/app/逻辑说明.md](../lsp模块/app/逻辑说明.md)，C 守护进程见 [lsp模块/daemon/逻辑说明.md](../lsp模块/daemon/逻辑说明.md)，参数机制见 [项目 CLAUDE.md](../CLAUDE.md) 与 `参数定义/`。
> 由原 `.claude/路线A-*.md` 8 份提炼，只保留**思想与实现方式**：具体进展流水、逐条验收结果、各线自述与验收报告之间的冲突记录与整改流水均已删除。

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

## 3. 关键设计决定（机制见现行权威）

本节只记录**决定与理由**；各项的现行机制与当前值以权威文档为准，本文不复述（app 侧 [lsp模块/app/逻辑说明.md](../lsp模块/app/逻辑说明.md)，C 守护进程 [lsp模块/daemon/逻辑说明.md](../lsp模块/daemon/逻辑说明.md)，文件落点 [lsp模块/README.md](../lsp模块/README.md)）。

- **私有目录成为唯一数据落点**：数据不再落 root 共享的 `/data/local/tmp`（`0666`、卸载可能残留）与 `/cache`，改由 APK 侧统一管理；**不改 applicationId**（避免破坏已发布 APK 身份），app 与 daemon 两侧私有目录逐字一致并有跨语言护栏。
- **`tempctrl_last_dev` 落点迁移**：原 `/data/local/tmp/` 四包共用 → 宿主 app 私有目录各包各记；键用**包名常量**而非 `appKind`（`appKind` 只有 6/7 两值，与飞智三包名不是一一对应）；对旧路径**不做兼容读取**（一次性切换）。
- **单实例锁**：`flock(LOCK_EX|LOCK_NB)` 落私有目录，取不到锁退出码 **2**（语义「已有实例在运行」），其余启动失败路径返回 0。**已知后果**：app「清除数据」会连锁文件一起删、运行中实例仍持旧 inode 的锁 → **那一次锁失效**，兜底靠部署脚本开机自检。
- **日志 / 曲线数据落私有目录**：不可用时兜底 `/cache` 并写 stderr（**不静默**）；部署时由 app 以自身 uid 预创建（仅不存在时建、失败不阻断）。
- **`status` 双文件原样不动**：路径、字段、预创建、`chmod 0666` 一字未改，仍在 `/data/local/tmp/`；写入端只有 `MainHook`。
- **卸载先杀看门狗 shell、再杀守护进程**：脚本自身的 `while true` 看门狗 cmdline 不含二进制路径，只 `pkill -f "$BIN"` 抓不到（脚本删了 shell 还在，下一轮 tick 会把刚删的日志重建、把守护进程拉回来）；做法是按「`comm` 为 shell 且 `cmdline` 某参数**恰好等于**脚本路径」精确列出 pid 再 kill + 轮询等真退出，**先于**守护进程杀；脚本侧另有纵深防御。
- **护栏键语义（已失效，2026-09-23）**：`PID_KI_DYN_T` / `PID_KI_DYN_GATE` / `PID_KI_DYN_WIN` 三键与 `ConfigStore.daemonAccepts()` 已随「冷值动态倍率」落地一并删除，现存参数一律走 C 端钳位。

---

## 4. C 端改动做法（历史）

对象：`lsp模块/daemon/tempctrl.c`。改动**最小化**——**不碰** PID/KI 算法、clamp、广播协议、status 路径。

8 处改动（私有目录落点 / 日志与配置默认路径 / 曲线数据路径 / 未找到配置不再静默 / 单实例锁 / 删 `uninstall.sh` 自清理 / 删 `tempctrl_last_dev` 死代码）都是把落点从 root 共享目录迁到 app 私有目录所需；其**当前实现**见 [lsp模块/daemon/逻辑说明.md](../lsp模块/daemon/逻辑说明.md)，本文不复述逐条 diff。

不变量：status 双文件全套（路径 / 字段 / 预创建 / 0666 / 读取）、全部 PID/KI/限速/仲裁、广播协议均未改。
验证口径：本机无 C 工具链（无 NDK/clang/gcc/MSVC 前端），**CI 是唯一门禁**；本机只做括号配平与人工复核。`flock` 已确认 bionic `sys/file.h` 无 `__INTRODUCED_IN` 门槛，android21-clang 可编译。

---

## 5. 参数定义机制

WebUI 时代配置键在 4 处手工同步（`webroot/schema.js`、`profile.conf`、`逻辑说明.md` 参数表、`tempctrl.c`），键序 / 默认值语义 / 分组元字段 / 类型覆盖四类不一致，需逐条裁定才收敛。合并路线据此改为**单一手写来源 + 生成器 + 校验脚本**。

该机制已是**现行规范**，权威见 [项目 CLAUDE.md](../CLAUDE.md)（「修改代码前」节）与 `参数定义/`（`params.def.json` = 唯一手写处、`gen_params.py` = 生成器、`check_params.py` = 校验脚本），本文不复述。

---

## 6. 卸载残留清单

卸载 APK 时由 `Deployer.uninstall()` 统一清（不再靠 `uninstall.sh` 自清理脚本），这是合并路线的一项决定。

逐项残留清单（残留物 / 谁清 / 说明）为**现行实现细节**，见 [lsp模块/app/逻辑说明.md](../lsp模块/app/逻辑说明.md)（§2.4 卸载清理的本类边界与唯一例外、§2.5 文件落点与三份清理清单的同步义务）与 [lsp模块/README.md](../lsp模块/README.md)（文件落点），本文不复述。

---

## 7. 未决事项

- **su 选型**：Scene 源码里 MAGISK 是单独一支 → `su`，只有 APATCH 才落到 `magisk su -mm`；另有一种旧口径记为「SDK≥30 其他 → `magisk su -mm`」。本实现照源码；若要改按旧口径，只需改 `getRecommendedSuCommand()` 一处。现行口径见 [lsp模块/app/逻辑说明.md](../lsp模块/app/逻辑说明.md)（Root 调用）。
- **`magisk` 不在 app 的 PATH**：`magisk su -mm` 由 app 进程 `Runtime.exec` 启动，用的是 app 的 PATH 而非 su 的；APATCH 设备上可能起不来。已用 `checkAlive()` 的「退回裸 `su`」+ 手动切换兜底。
- **权限与主题**（`POST_NOTIFICATIONS` 等；线 D 换 AppCompatActivity 需补 AppCompat/Material 主题）留到后续批次。

---

## 相关文档

- [lsp模块/README.md](../lsp模块/README.md) —— 广播协议与 status 文件协议的**唯一规范处**
- [lsp模块/app/逻辑说明.md](../lsp模块/app/逻辑说明.md) —— app 侧 Java 代码的设计与逻辑唯一权威文档
- [lsp模块/daemon/逻辑说明.md](../lsp模块/daemon/逻辑说明.md) —— 温控策略设计、参数表、落点说明
- [完整修复历程.md](完整修复历程.md) —— BLE 4 层 Bug 修复全记录
- [../参数定义/对齐报告.md](../参数定义/对齐报告.md) —— 参数定义的对账与裁定记录
