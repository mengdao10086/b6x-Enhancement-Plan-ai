# Claude 指令 — 飞智 B6X 增强计划

> 本文件仅包含 AI 操作规则。项目介绍见 [README.md](README.md)，版本变更见 [CHANGELOG.md](CHANGELOG.md)。

**重要**：本文件同时包含远程仓库和本地配置的内容，合并后使用以下整合规则。

---

## 1. Git 子模块

- **本目录是 git 子模块**。所有 `git add/commit/push/pull` 必须在本目录内执行。
- 外层工作区（本子模块的父目录）只追踪子模块指针，不要在外层 add/commit。
- `origin` 使用 PAT 认证，push 需网络可达 GitHub。

## 2. 工作目录

- 根目录：本目录
- LSPosed 模块：`./lsp模块/`（Android Studio 项目）
- 智能温控 C：`./lsp模块/daemon/tempctrl.c`
- **Bash 环境执行，分支 = main**

## 3. 分析 App 内部行为时

先在 `参考资料/` 搜索关键词，再考虑加诊断钩子。这里已有完整 smali 反编译输出。

## 4. 修改代码前

- 改函数/类方法的**行为、签名或公共接口**前 → 先跑 `impact`，并向用户报告直接调用者、受影响流程、风险级别
- 重命名符号用 `rename`，不得文本替换
- 改完后跑 `detect_changes()` 检查影响范围
- 风险 HIGH/CRITICAL → 先告知用户再继续
- 普通日志降级为 debug 时，用**对应功能分区的子开关**（如配置加载→`debug_config`、传感器→`debug_sensor`、PID→`debug_pid`），不得用通用 `write_log` 或乱选分区。注意 C 宏按文本顺序生效，调用点位于宏定义之前时需把 `debug_log`/`pid_log` 宏上移
- **加/改配置参数**：`参数定义/params.def.json` 是 52 个键的**唯一手写处**。改定义 → `python 参数定义/gen_params.py` 重新生成 `lsp模块/app/src/main/assets/params.json` → `python 参数定义/check_params.py` 必须 EXIT=0（该项已接入 CI，在 checkout 之后、Gradle 编译之前）。该脚本对账 `profile.conf` / `逻辑说明.md` / `tempctrl.c` 等派生副本，漂移则退出 2
- **手工同步的派生副本**（改了上面任一处都要跟着改，界面表单**不**用改——它读 `params.json` 动态生成）：`lsp模块/daemon/profile.conf`（键序 + 注释）、`逻辑说明.md` 参数表

## 5. 编译须知

- C 守护程序用 GitHub Actions（NDK r27c）编译，**不得建议 Termux 编译**
- 编译命令见 `lsp模块/daemon/build_tempctrl.sh`（编译参数的唯一来源，勿在此处复制副本）
- CI 只有一条构建链（`.github/workflows/build.yml` 的单一 `build` job）：编译 C → 注入 `app/src/main/assets/tempctrl-arm64` → `assembleRelease` 出**唯一交付物 APK**；不再有 Magisk 模块产物
- 每轮新对话和压缩上下文后的**首次 push** → 跟踪 CI 检查是否报错

## 6. 安全边界

- 不得自动执行 git push、部署、发布、破坏性迁移
- 修改 `.env` 前需说明用途，用户确认后再执行
- **版本号不自动更新**：`build.gradle.kts` versionName、`CHANGELOG.md` 等版本号一律保持现状，不因审查/清理/重构主动修改；需要改版本号由用户明确要求

---

## 关键文件索引

快速定位用；项目结构概览见 [README.md](README.md)。**关键文件以本表为准**，其他文档只做链接（`lsp模块/app/src/**` 的 Java 与 res 逐文件明细不列，见其实际目录）。

| 文件 | 作用 |
|------|------|
| `lsp模块/daemon/tempctrl.c` | 智能温控 C 守护程序（唯一核心源码） |
| `lsp模块/daemon/build_tempctrl.sh` | NDK 编译命令（编译参数的唯一来源） |
| `lsp模块/daemon/patch_tls.py` | 编译后修补 PT_TLS 对齐 |
| `lsp模块/daemon/profile.conf` | 配置模板（键序与注释的参考；出厂值由 `params.json` 的 `factory` 提供） |
| `lsp模块/app/build.gradle.kts` | 版本号 `versionName` / `versionCode` 的唯一来源（CI 由此解析） |
| `lsp模块/app/src/main/java/.../MainHook.java` | LSPosed 模块核心 |
| `lsp模块/README.md` | LSPosed 模块说明；广播与 status 文件协议的唯一规范处 |
| `逻辑说明.md` | 温控技术设计文档 |
| `动态KI机制流程图.md` | 动态 KI 抑制机制的分支级流程图 |
| `参数定义/params.def.json` | 52 个配置键的单一来源（唯一手写处） |
| `参数定义/gen_params.py` | 生成 `lsp模块/app/src/main/assets/params.json` |
| `参数定义/check_params.py` | 派生副本漂移校验（CI 已接入，EXIT=0 为通过） |
| `参数定义/对齐报告.md` | 参数定义的对账与裁定记录 |
| `CHANGELOG.md` | 版本变更记录 |
| `TECH_DEBT.md` | 技术债与未解决问题记录 |
| `待办.md` | 项目待办清单 |
| `diagnose_status.sh` | 散热器无反应诊断脚本（设备端一键排查） |
| `反编译分析/总览.md` | 反编译技术文档总览（所有 app 分析索引） |
| `反编译分析/飞智散热器开发者工具运行逻辑.md` | App 内部运行逻辑分析 |
| `参考资料/完整修复历程.md` | BLE 4 层 Bug 修复全记录 + B8X 分析 |
| `参考资料/decompile/` | 各工具反编译产物（`b6_devtool/`、`b6_overclock_v2/`、`b7_overclock_v3/`、`b8x/`；不进 git，分析文档在 `反编译分析/`） |
| `参考资料/c_historical_sources/` | tempctrl 历史版本源码（单独追踪） |
| `参考资料/smali_patching_attempts/` | smali 工具链产物（失败尝试，工具 jar 已并入集中 `工具/`；不进 git） |
| `.github/workflows/build.yml` | CI 单一构建链：编译 C → 注入 APK assets → 出唯一交付物 APK |


### 工具路径

| 工具 | 位置 |
|------|------|
| `baksmali.jar` | `../工具/baksmali.jar`（集中目录） |
| `smali.jar` | `../工具/smali.jar` |
| `debug.keystore` | `../工具/debug.keystore` |
| `jadx.jar` | `../工具/jadx.jar` |

---

## 文件组织规则
- 每个项目必须有独立文件夹，不要在根目录直接操作。
- 项目根目录只保留：入口文件（main.*）、配置文件（package.json、Cargo.toml等）、README。
- 旧版产出物移入子文件夹，子文件夹按功能或目标命名，最好使用中文。
- 工具链文件夹（`.git/`、`.claude/`、`.gitnexus/`、`node_modules/` 等）不受上述规则限制。
- 二级子文件夹按时间或版本号命名。
- 同一项目下的命名风格保持一致。
- 技术债记录文件 `TECH_DEBT.md` 放在项目根目录。

### 文档内容规范
- 同类信息只在**一个** md 中写全，其他 md 引用链接，不得复制内容
- 版本变更统一放到 `CHANGELOG.md`。其他 md 提到版本变化时最多一句话，加 `详见 CHANGELOG.md`
- 发现重复内容 → 删掉多余的那份，换成 `详见 [目标文件](path)`
- 跨文件链接必须用相对路径，从引用文件所在位置出发计算
