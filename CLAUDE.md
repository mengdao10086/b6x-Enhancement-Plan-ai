# Claude 指令 — 飞智 B6X 增强计划

> 本文件仅包含 AI 操作规则。项目介绍见 [README.md](README.md)，版本变更见 [参考资料/CHANGELOG.md](参考资料/CHANGELOG.md)。

**重要**：本文件同时包含远程仓库和本地配置的内容，合并后使用以下整合规则。

---

## 沟通偏好
- 优先使用中文回复，除非有直接要求使用其他语言。专业术语和引用内容可以例外，但是要附加简短中文解释。

## 安全边界
- **在没有用户明确命令时：**
  不要删除或修改：系统关键环境变量（如 `SystemRoot`、`WINDIR`）、敏感目录（`~/.ssh/`、`~/.gnupg/`）、**生产环境相关**的 `.env` 文件（如 `.env.production`）。
  对于开发用途的 `.env`、`.env.local`，或是用户级环境变量，修改前必须先说明用途，用户确认后再执行。
  项目内的配置文件（如 .eslintrc、tsconfig.json）如果有必要可以修改，但删除前需确认。
  不要自动执行 git push、部署、发布和破坏性迁移。

## 工具选择指引

### 决策表

| 场景 | 工具 | 命令 |
|------|------|------|
| 查函数签名 / 参数 / 接口定义 | **Token Savior** | `find_*` |
| 查设计决策 / 上下文压缩 | **Token Savior** | `get_*` |
| — | — | — |
| 按概念搜代码在哪 | **codebase-memory-mcp** | `search_graph` |
| 语义搜索（搜"发送"→publish） | **codebase-memory-mcp** | `search_graph` + semantic_query |
| 架构全景 / 模块划分 | **codebase-memory-mcp** | `get_architecture` |
| 函数调用链（谁调它 / 它调谁） | **codebase-memory-mcp** | `trace_path` |
| 死代码检测（未使用函数） | **codebase-memory-mcp** | `search_graph(max_degree=0)` |
| 跨服务 HTTP/gRPC 调用链 | **codebase-memory-mcp** | `query_graph(HTTP_CALLS)` |
| 记录 / 查看架构决策 | **codebase-memory-mcp** | `manage_adr` |
| 低 token 预算时的结构查询 | **codebase-memory-mcp** | 任何场景优先使用 |
| — | — | — |
| 评估改函数的风险 | **GitNexus** | `impact` |
| 安全审计 / 污点追踪 | **GitNexus** | `explain` |
| 按业务流程理解执行路径 | **GitNexus** | `processes` |
| 重命名符号 | **GitNexus** | `rename` |
| — | — | — |
| 跨会话回忆 / 继续之前的工作 | **claude-mem** | `/mem-search` |

### 独有能力速查（常规路径不满足时查这里）
- **Token Savior**: 上下文压缩 / 设计决策检索
- **codebase-memory-mcp**: 死代码检测 / ADR 管理 / 158 语言 / 语义搜索 / HTTP_CALLS 跨服务追踪 / <1ms 查询
- **GitNexus**: 风险评级 / taint 安全审计 / 调用图感知重命名 / 业务流程分组 / PDG
- **claude-mem**: 跨会话记忆

### 兜底
决策表未覆盖的场景 → 按 codebase-memory-mcp > GitNexus > Token Savior 次序尝试

---

## 1. Git 子模块

- **本目录是 git 子模块**。所有 `git add/commit/push/pull` 必须在本目录内执行。
- 外层 `D:\下载\Claude Code\` 只追踪子模块指针，不要在外层 add/commit。
- `origin` 使用 PAT 认证，push 需网络可达 GitHub。

## 2. 工作目录

- 根目录：`D:\下载\Claude Code\飞智b6x增强计划`
- LSPosed 模块：`./lsp模块(apk修复+温控接口)/`（Android Studio 项目）
- 智能温控 C：`./magisk模块(智能温控)/tempctrl.c`
- **Bash 环境执行，分支 = main**

## 3. 分析 App 内部行为时

MUST 先在 `参考资料/` 搜索关键词，再考虑加诊断钩子。这里已有完整 smali 反编译输出。

## 4. 修改代码前

- 修改函数/类方法的**行为、签名或公共接口**前 → MUST 运行 `impact` 分析
- MUST 向用户报告：直接调用者、受影响流程、风险级别
- 重命名符号 MUST 用 `rename`（不得文本替换）
- 改完后 MUST 运行 `detect_changes()` 检查影响范围
- 风险 HIGH/CRITICAL → MUST 先告知用户再继续

## 5. 编译须知

- C 守护程序 MUST 使用 GitHub Actions（NDK r27c）编译，**不得建议 Termux 编译**
- 编译命令：`aarch64-linux-android21-clang -static -O2 -ffunction-sections -fdata-sections -Wl,--gc-sections -Wl,--strip-all`
- 每轮新对话和压缩上下文后的**首次 push** → MUST 跟踪 CI 检查是否报错

## 6. 安全边界

- 不得自动执行 git push、部署、发布、破坏性迁移
- `git commit` 由用户手动执行，AI 不得自动提交
- 修改 `.env` 前需说明用途，用户确认后再执行

---

## 关键文件索引

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
