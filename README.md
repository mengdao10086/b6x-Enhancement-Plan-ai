# 飞智 B6X 增强计划

[![自动构建](https://github.com/mengdao10086/b6x-Enhancement-Plan-ai/actions/workflows/build.yml/badge.svg)](https://github.com/mengdao10086/b6x-Enhancement-Plan-ai/actions/workflows/build.yml)

飞智 B6X 散热器开发者工具的增强方案。修复了 Android 16 上的 BLE 兼容性问题，并扩展了智能温控功能。

---

## 组件

| 组件 | 路径 | 说明 | 状态 |
|------|------|------|------|
| **LSPosed 模块** | [lsp模块(apk修复+温控接口)/](lsp模块(apk修复+温控接口)/) | 提供散热器控制接口 | ✅ v2.3 |
| **C 守护程序** | [magisk模块(智能温控)/](magisk模块(智能温控)/) | 使用 LSPosed 模块接口控制散热器 | ✅ v2.3 |

---

## 架构概览

```
 ┌─ 手机 ────────────────────────────────────────┐
 │                                               │
 │  飞智 App 进程              Root 进程          │
 │  ┌──────────────────┐     ┌────────────────┐ │
 │  │ LSPosed 模块     │ stat │ tempctrl       │ │
 │  │ (MainHook.java)  │◄────│ C 守护程序      │  │
 │  │                  │ 心跳 │ main_loop 5s   │ │
 │  │ ←─ am broadcast ─│─────│ 读传感器→决策   │  │
 │  │   SET_TEMPERATURE│ 指令 │ →am broadcast  │ │
 │  │       ↓          │     └────────────────┘ │
 │  │ WaspWingManager  │                         │
 │  │ .setRunMode()    │                         │
 │  │     ↓            │                         │
 │  │    BLE → 散热器  │                         │
 │  └──────────────────┘                         │
 └───────────────────────────────────────────────┘
```

---

## 功能

### LSPosed 模块

- 修复 Android 16 BLE 无法连接的 4 层连环 Bug → [完整修复历程](参考资料/完整修复历程.md)
- 提供 `com.flydigi.SET_TEMPERATURE` 广播接收器，支持 7 参数完整控制
- 修复 DefaultDispatcher 线程 100% CPU 占用（空队列忙等）

### C 智能温控守护程序

- **PID 连续无级调节**（v2.3）：CTRL_MODE=1 启用，P+I(方差门控/死区回退)+D 控制 + 输入 EMA 滤波
- **制冷→RPM 自动映射**：冷端指数映射 + 热端线性映射 + 自加权合并，PID/常规双模式共享映射引擎
- **双源紧急干预**：CPU 温度 + 电池电流，OR 入 AND 出，4 级紧急 + 退出恢复期
- **电池温度调档**：基准 35°C，四区策略（死区/±1/±2/±3 档），趋势豁免 + 反补查表
- **电流-挡位映射 + 温度融合**：电池电流推荐基础档位，温度累积偏移，推荐挡位变化时偏移自动继承
- **限速统一下沉**：RPM/制冷/目标温度限速内建到下发函数内部，计算层只管传目标值
- **决策执行分离**：`main_loop` 纯计算，`rate_limited_execute` 分发
- **独立开关**：电流紧急/CPU 紧急/反补/趋势豁免各自独立控制
- **调试日志系统**：`DEBUG_MODE` + 8 个分区（含 PID），开启时自动关闭日志体积限制

> 详细策略设计 → [逻辑说明.md](magisk模块(智能温控)/逻辑说明.md) · 版本变更 → [CHANGELOG.md](参考资料/CHANGELOG.md)

---

## 项目结构

<pre>
├── <a href="lsp模块(apk修复+温控接口)/">lsp模块(apk修复+温控接口)/</a>     ← LSPosed 模块（Android 项目）
├── <a href="magisk模块(智能温控)/">magisk模块(智能温控)/</a>          ← C 守护程序源码 + Magisk 模块框架
│   ├── <a href="magisk模块(智能温控)/tempctrl.c">tempctrl.c</a>                 ← 核心 C 代码
│   ├── <a href="magisk模块(智能温控)/逻辑说明.md">逻辑说明.md</a>                ← 技术设计文档
│   └── <a href="magisk模块(智能温控)/magisk模块框架/">magisk模块框架/</a>            ← module.prop / service.sh / customize.sh / profile.conf
├── <a href="参考资料/">参考资料/</a>
│   ├── <a href="参考资料/完整修复历程.md">完整修复历程.md</a>             ← BLE 4 层 Bug 修复全记录
│   ├── <a href="参考资料/CHANGELOG.md">CHANGELOG.md</a>               ← 版本更新日志
│   ├── <a href="参考资料/apk逆向分析/">apk逆向分析/</a>               ← APK 反编译 + 运行逻辑分析
│   │   ├── <a href="参考资料/apk逆向分析/smali/">smali/</a>                 ← 合并反编译输出
│   │   └── <a href="参考资料/apk逆向分析/app运行逻辑.md">app运行逻辑.md</a>         ← App 内部运行逻辑分析
│   └── <a href="参考资料/smali修改重编译apk尝试/">smali修改重编译apk尝试/</a>     ← smali 工具链 + DEX 修改产物
├── <a href=".github/workflows/">.github/workflows/</a>              ← CI 自动构建
└── <a href="README.md">README.md</a>                       ← 本文件
</pre>

---

## 构建

### ⚠️ 重要：C 守护程序使用 GitHub Actions 编译

**不要在手机上用 Termux 编译！** Termux 的 `clang -static` 链接的是 Termux 的 libc，非 Android libc。编译出的二进制在真机上 PT_TLS 段对齐错误。

**推荐使用 GitHub Actions 编译**（或本地 NDK arm64 交叉编译）：

- CI 使用 NDK r27c，固定路径 `/opt/ndk`
- 编译命令：`aarch64-linux-android21-clang -static -O2 -ffunction-sections -fdata-sections -Wl,--gc-sections -Wl,--strip-all`
- NDK 已配置 `actions/cache` 缓存（~700MB），首次后不再重复下载

单一 Workflow（[build.yml](.github/workflows/build.yml)）自动检测变更模块编译：

| 触发方式 | 编译内容 |
|----------|----------|
| git push（内部 diff 判断） | 按变更选 LSPosed / Magisk / 全量 |
| 推送 `v*` 标签 | 全量编译 |
| 手动 `workflow_dispatch` | 全量编译 |

产物在 Actions 运行记录的 Artifacts 中下载。

### 产物命名规范

| 组件 | 格式 | 示例 | 版本号来源 |
|------|------|------|-----------|
| **LSPosed APK** | `b6x-EP-LSPosed-v{version}.apk` | `b6x-EP-LSPosed-v2.0.apk` | `build.gradle.kts` → `versionName` |
| **Magisk ZIP** | `b6x-EP-Magisk-v{version}.zip` | `b6x-EP-Magisk-v2.0.zip` | `module.prop` → `version`（去 v 前缀） |

---

## 本地开发环境

| 项目 | 说明 |
|------|------|
| 代码路径 | `D:\下载\Claude Code\飞智b6x增强计划\`（git 子模块） |
| Git 远程 | `https://github.com/mengdao10086/b6x-Enhancement-Plan-ai.git` |
| 默认分支 | `main` |
| 模块编译 | Android Studio 打开 `lsp模块(apk修复+温控接口)/` → Build APK |
| C 编译 | **仅限 GitHub Actions**（NDK r27c） |
| 模块安装 | LSPosed 勾选模块 → 作用域 `com.flydigi.waspwing.experimental` → 强制停止 App |

---

## 已知风险

| 风险 | 说明 |
|------|------|
| `RECEIVER_EXPORTED` 权限 | `am broadcast` 从系统进程发广播，模块需 `RECEIVER_EXPORTED` 才能收到（Android 14+） |
| 温度传感器路径 | `thermal_zone` 范围可通过 `CPU_ZONE_MIN/MAX` 配置，K60 推荐 30~40 |
| NDK 编译 | CI 中不要依赖 `$ANDROID_NDK_HOME`，改用固定路径下载 NDK r27c |
| Xposed `catch(Exception)` 陷阱 | `NoSuchMethodError` / `NoSuchFieldError` 继承自 `Error` 而非 `Exception`，必须用 `catch(Throwable)` 捕获 |
| Git 子模块 | 本仓库是 git 子模块，所有 git 操作在目录内执行，外层只追踪指针 |
