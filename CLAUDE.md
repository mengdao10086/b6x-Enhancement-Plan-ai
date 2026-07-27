# Claude 指令 — 飞智 B6X 增强计划

> 本文件仅包含 AI 操作规则。项目介绍见 [README.md](README.md)，版本变更见 [CHANGELOG.md](CHANGELOG.md)。

**重要**：本文件同时包含远程仓库和本地配置的内容，合并后使用以下整合规则。

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
| `baksmali.jar` | `../../工具/baksmali.jar`（集中目录） |
| `smali.jar` | `../../工具/smali.jar` |
| `debug.keystore` | `../../工具/debug.keystore` |
| `jadx.jar` | `../../工具/jadx.jar` |

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

<!-- gitnexus:start -->
# GitNexus — Code Intelligence

This project is indexed by GitNexus as **b6x-Enhancement-Plan-ai** (11323 symbols, 11723 relationships, 47 execution flows). Use the GitNexus MCP tools to understand code, assess impact, and navigate safely.

> Index stale? Run `node .gitnexus/run.cjs analyze` from the project root — it auto-selects an available runner. No `.gitnexus/run.cjs` yet? `npx gitnexus analyze` (npm 11 crash → `npm i -g gitnexus`; #1939).

## Always Do

- **MUST run impact analysis before editing any symbol.** Before modifying a function, class, or method, run `impact({target: "symbolName", direction: "upstream"})` and report the blast radius (direct callers, affected processes, risk level) to the user.
- **MUST run `detect_changes()` before committing** to verify your changes only affect expected symbols and execution flows. For regression review, compare against the default branch: `detect_changes({scope: "compare", base_ref: "main"})`.
- **MUST warn the user** if impact analysis returns HIGH or CRITICAL risk before proceeding with edits.
- When exploring unfamiliar code, use `query({search_query: "concept"})` to find execution flows instead of grepping. It returns process-grouped results ranked by relevance.
- When you need full context on a specific symbol — callers, callees, which execution flows it participates in — use `context({name: "symbolName"})`.
- For security review, `explain({target: "fileOrSymbol"})` lists taint findings (source→sink flows; needs `analyze --pdg`).

## Never Do

- NEVER edit a function, class, or method without first running `impact` on it.
- NEVER ignore HIGH or CRITICAL risk warnings from impact analysis.
- NEVER rename symbols with find-and-replace — use `rename` which understands the call graph.
- NEVER commit changes without running `detect_changes()` to check affected scope.

## Resources

| Resource | Use for |
|----------|---------|
| `gitnexus://repo/b6x-Enhancement-Plan-ai/context` | Codebase overview, check index freshness |
| `gitnexus://repo/b6x-Enhancement-Plan-ai/clusters` | All functional areas |
| `gitnexus://repo/b6x-Enhancement-Plan-ai/processes` | All execution flows |
| `gitnexus://repo/b6x-Enhancement-Plan-ai/process/{name}` | Step-by-step execution trace |

## CLI

| Task | Read this skill file |
|------|---------------------|
| Understand architecture / "How does X work?" | `.claude/skills/gitnexus/gitnexus-exploring/SKILL.md` |
| Blast radius / "What breaks if I change X?" | `.claude/skills/gitnexus/gitnexus-impact-analysis/SKILL.md` |
| Trace bugs / "Why is X failing?" | `.claude/skills/gitnexus/gitnexus-debugging/SKILL.md` |
| Rename / extract / split / refactor | `.claude/skills/gitnexus/gitnexus-refactoring/SKILL.md` |
| Tools, resources, schema reference | `.claude/skills/gitnexus/gitnexus-guide/SKILL.md` |
| Index, status, clean, wiki CLI commands | `.claude/skills/gitnexus/gitnexus-cli/SKILL.md` |

<!-- gitnexus:end -->
