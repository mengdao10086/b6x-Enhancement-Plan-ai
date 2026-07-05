# Claude 指令 — 飞智 B6X 增强计划

> 本文件仅包含 AI 操作规则。项目介绍见 [README.md](README.md)，版本变更见 [参考资料/CHANGELOG.md](参考资料/CHANGELOG.md)。

---

## 1. 操作规则

### 1.1 Git 子模块

- **本目录是 git 子模块**。所有 `git add/commit/push/pull` 必须在本目录内执行。
- 外层 `D:\下载\Claude Code\` 只追踪子模块指针，不要在外层 add/commit。
- `origin` 使用 PAT 认证，push 需网络可达 GitHub。

### 1.2 工作目录

- 根目录：`D:\下载\Claude Code\飞智b6x增强计划`
- LSPosed 模块：`./lsp模块(apk修复+温控接口)/`（Android Studio 项目）
- 智能温控 C：`./magisk模块(智能温控)/tempctrl.c`
- **Bash 环境执行，分支 = main**

### 1.3 分析 App 内部行为时

MUST 先在 `参考资料/` 搜索关键词，再考虑加诊断钩子。这里已有完整 smali 反编译输出。

### 1.4 修改代码前

- 修改函数/类方法的**行为、签名或公共接口**前 → MUST 运行 `impact` 分析
- MUST 向用户报告：直接调用者、受影响流程、风险级别
- 重命名符号 MUST 用 `rename`（不得文本替换）
- 改完后 MUST 运行 `detect_changes()` 检查影响范围
- 风险 HIGH/CRITICAL → MUST 先告知用户再继续

### 1.5 编译须知

- C 守护程序 MUST 使用 GitHub Actions（NDK r27c）编译，**不得建议 Termux 编译**
- 编译命令：`aarch64-linux-android21-clang -static -O2 -ffunction-sections -fdata-sections -Wl,--gc-sections -Wl,--strip-all`
- 每轮新对话和压缩上下文后的**首次 push** → MUST 跟踪 CI 检查是否报错

### 1.6 安全边界

- 不得自动执行 git push、部署、发布、破坏性迁移
- `git commit` 由用户手动执行，AI 不得自动提交
- 修改 `.env` 前需说明用途，用户确认后再执行

---

## 2. 关键文件索引

快速定位用，详细结构见 [README.md](README.md)。

| 文件 | 作用 |
|------|------|
| `magisk模块(智能温控)/tempctrl.c` | 智能温控 C 守护程序 |
| `magisk模块(智能温控)/逻辑说明.md` | 技术设计文档 |
| `magisk模块(智能温控)/magisk模块框架/profile.conf` | 运行时配置参数 |
| `lsp模块(apk修复+温控接口)/app/src/main/java/.../MainHook.java` | LSPosed 模块核心 |
| `参考资料/完整修复历程.md` | BLE 4 层 Bug 修复全记录 |
| `参考资料/apk逆向分析/app运行逻辑.md` | App 内部运行逻辑分析 |
| `参考资料/apk逆向分析/smali/` | APK 反编译 smali 代码 |
| `参考资料/smali修改重编译apk尝试/` | smali 工具链产物 |

### 工具路径

| 工具 | 位置 |
|------|------|
| `baksmali.jar` | `参考资料/smali修改重编译apk尝试/baksmali.jar` |
| `smali.jar` | `参考资料/smali修改重编译apk尝试/smali.jar` |
| `debug.keystore` | `参考资料/smali修改重编译apk尝试/debug.keystore` |
