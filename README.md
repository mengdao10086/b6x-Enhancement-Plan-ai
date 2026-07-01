# 飞智 B6X 增强计划

[![Build](https://github.com/mengdao10086/b6x-Enhancement-Plan-ai/actions/workflows/build.yml/badge.svg)](https://github.com/mengdao10086/b6x-Enhancement-Plan-ai/actions/workflows/build.yml)

飞智 B6X 散热器开发者工具的增强方案。修复了 Android 16 上的 BLE 兼容性问题，并扩展了智能温控功能。

---

## 组件

| 组件 | 路径 | 说明 | 状态 |
|------|------|------|------|
| **LSPosed 模块** | [lsp模块(apk修复+温控接口)/](lsp模块(apk修复+温控接口)/) | 提供散热器控制接口 | ✅ v2.0 已发布 |
| **C 守护程序** | [magisk模块(智能温控)/](magisk模块(智能温控)/) | 使用lsp模块接口控制散热器 | ✅ v2.1 已发布 |

### LSPosed 模块功能

- 修复 Android 16 BLE 无法连接的 4 层连环 Bug（权限/扫描/ViewModel/UI 闪烁）
- 提供 `com.flydigi.SET_TEMPERATURE` 广播接收器，支持 7 参数完整控制
- 修复 DefaultDispatcher 线程 100% CPU 占用（`runFetchLoop` 空队列忙等）

### C 智能温控守护程序

- 读取电池温度（sysfs）和 CPU 温度，综合决策散热档位
- CPU 温度 + 电池电流双源紧急干预（OR 入 AND 出）：
  - CPU > 65/75/85°C 或电流 > 5/6/7A 触发 1/2/3 级紧急
  - CPU 带低通滤波，电流用原始绝对值不平滑
  - 退出时 CPU 和电流都低于恢复阈值才降级
- 电池温度调档（基准 35°C，三级调整区间：死区/±1档/±2档）
- 趋势豁免/反补查表（Sheet3 三区×双向×三级阈值）：
  - **三区**：冷外区(≤基准-ZONE₂) / 内区(±ZONE₂内) / 热外区(≥基准+ZONE₂)
  - 升温时：冷外 0.8→1 / 内区 0.5→1, 0.8→2 / 热外 0.3→1, 0.5→2, 0.8→3
  - 降温时：冷外 0.3→1, 0.5→2, 0.8→3 / 内区 0.5→1, 0.8→2 / 热外 0.8→1
  - 趋势豁免仅温度向基准方向变动时生效，最多豁免 OVERRIDE_MAX 次（默认 6）
  - **冷却期内反补也执行**（安全机制不冻结）
- 温度未变化时跳过升降档，防止重复调整
- 电池档位继承逻辑目标档位，紧急退出后挡位不暴跌
- 退出紧急降档：直接按 AND 逻辑结果钳制（不再判断电池温度/充电电流）
- **决策与执行分离**：main_loop 纯计算不下发，**速率限制执行**替代旧版逐档变动：
  - 风扇转速每周期最多变化 RATE_LIMIT_RPM（默认 250 RPM）
  - 制冷片强度每周期最多变化 RATE_LIMIT_COLD（默认 20，固定功率模式）
  - 目标温度每周期最多变化 RATE_LIMIT_TEMP（默认 2°C，智能温控模式）
  - 溢出自然累积下周期，目标变化时从当前值重新计算
- 断联时丢弃未执行的变化量，实际值保持断联前最后数值
- 重连时将三个实际值（RPM/制冷/温度）都调到匹配挡位，不下发，由 `rate_limited_execute` 按正常速率逐步过渡，防止基准值错误
- **紧急退出恢复期**：紧急等级降低后 BATT_ZONE 阈值 ×6→×4→×2→1 逐步恢复全灵敏度，每阶段 BATT_RECOVERY_PHASE_CYCLES 周期（默认 6），连续退出重启，反补照常执行
- 双重检查存活检测：status 文件 mtime 心跳 + BLE=1，任一判死即断联（pgrep 已移除）
- 大部分参数可通过 profile.conf 运行时配置并热重载
- CONFIG_ENABLED=0 时跳过配置加载，全部使用代码默认值
- 指令去重，避免散热器频繁切换

---

## 项目结构

```
├── lsp模块(apk修复+温控接口)/     ← LSPosed 模块（Android 项目）
├── magisk模块(智能温控)/          ← C 守护程序源码 + Magisk 模块框架
├── 参考资料/                        ← APK 反编译分析 + 修复历程 + 历史源码
│   ├── 完整修复历程.md              ← 4 层 Bug 修复全记录
│   ├── 飞智散热器开发者工具原版.apk  ← 原始 APK
│   ├── apk逆向分析/                ← APK 逆向工程
│   │   ├── smali/                 ← 合并反编译输出（8865 文件）
│   │   ├── apk_extracted/         ← 原始 APK 解压
│   │   └── app运行逻辑.md          ← App 运行逻辑分析
│   ├── smali修改重编译apk尝试/      ← smali 工具链 + DEX 修改产物
│   └── 历史c脚本源码/              ← 历史 C 源码备份
├── .github/workflows/              ← CI 自动构建（APK + C 二进制）
├── log.md                           ← 修改日志（git 已忽略，仅本地）
└── README.md                       ← 本文件
```

## 构建
### ⚠️ 重要：C 守护程序推荐使用 GitHub Actions 编译

**不要在手机上用 Termux 编译！** Termux 的 `clang -static` 链接的是 Termux 的 libc，
不是 Android 的 libc，编译出的二进制在实际的 Android 系统上 PT_TLS 段对齐错误，
即使执行 `patch_tls.py` 修复也无法保证在所有内核版本上正常运行。

**推荐使用 GitHub Actions 编译**（或本地 NDK arm64 交叉编译）：

- CI 使用 NDK r27c，固定路径 `/opt/ndk`
- 编译命令：`aarch64-linux-android21-clang -static -O2`
- NDK 已配置 `actions/cache` 缓存（~700MB），首次后不再重复下载
- CI 产物在 Actions 运行记录的 Artifacts 中下载

单一 Workflow（[build.yml](.github/workflows/build.yml)）自动按变更内容编译：
| 触发方式 | 编译内容 |
|----------|----------|
| 推送 `lsp模块/**` 变更 | 仅 LSPosed 模块 APK |
| 推送 `magisk模块/**` 变更 | 仅 Magisk 模块（C 守护程序 + 模块框架） |
| 推送 `v*` 标签 / 手动触发 | 全量编译（LSPosed + Magisk） |
| 手动 `workflow_dispatch` | 全量编译 |

构建产物在对应运行记录的 Artifacts 中下载。

### 产物命名规范

| 组件 | 格式 | 示例 | 版本号来源 |
|------|------|------|-----------|
| **LSPosed APK** | `b6x-EP-LSPosed-v{version}.apk` | `b6x-EP-LSPosed-v2.0.apk` | `app/build.gradle.kts` → `versionName` |
| **Magisk ZIP** | `b6x-EP-Magisk-v{version}.zip` | `b6x-EP-Magisk-v2.0.zip` | `module.prop` → `version` 字段（去 v 前缀） |

- `b6x-EP` = b6x Enhancement Plan（项目缩写）
- 版本号编号与 Magisk 模块的 version 字段保持一致

> **NDK 缓存**：NDK (~700MB) 已配置 `actions/cache`，首次运行后不再重复下载。
> **分支**：所有开发直接提交到 **`main`** 分支。

---

### 待分析/待实现

| 项目 | 优先度 | 说明 |
|------|------|------|
| UI 模式选择器智能温控时闪烁；固定功率时圆点空白 | 🟢 低 | **智能模式闪烁**：经尝试修复后变为无法稳定复现，暂无法确定根因。<br>**固定功率圆点空白**：脚本下发的档位并非 App 自带的"固定模式"——它是通过 `setRunMode` 参数独立设定的一档固定功率值，与 App 内置的那几个固定功率档位（UI 上可选的）是两套独立的配置。因此模式选择器空白反而是**正确显示**：当前运行的既非智能温控、也非 App 的任何一档内置固定模式。此时点击"固定模式"切回的是 App 自身的固定模式（使用 App 此前设定的数值），而不是脚本下发的挡位。<br><br>**推测（未实测验证）**：LSPosed 模块钩住 `WaspWingManager.setRunMode()` 后，通过广播接收参数并调用此方法，成功发送了 BLE 指令，散热器确实按脚本参数运行。但 App 的 UI 状态（模式选中项）监听的是 `WaspWingInfo.runMode` 等 LiveData——此字段仅反映 App 自身通过 UI 设定的模式，不感知外部广播设置的参数。因此圆点空白是正常现象：它准确报告了"当前模式不在 App 内置选项列表中"。 |

---

## 本地开发环境

| 项目 | 说明 |
|------|------|
| 代码路径 | `D:\下载\Claude Code\飞智b6x增强计划\` |
| Git 远程 | `https://github.com/mengdao10086/b6x-Enhancement-Plan-ai.git` |
| 默认分支 | `main` |
| 模块编译 | Android Studio 打开 `lsp模块(apk修复+温控接口)/` → Build APK |
| C 编译 | **仅限 GitHub Actions**（NDK r27c），参见上方构建说明 |
| 模块安装 | LSPosed 勾选模块 + 作用域 `com.flydigi.waspwing.experimental` → 强制停止 App |

## 已知风险

| 风险 | 说明 |
|------|------|
| `RECEIVER_EXPORTED` 权限 | `am broadcast` 从系统进程发广播，模块需 `RECEIVER_EXPORTED` 才能收到（Android 14+） |
| 温度传感器路径 | `thermal_zone` 范围可通过 `CPU_ZONE_MIN/MAX` 配置，K60 推荐 30~40 |
| NDK 编译 | CI 中不要依赖 `$ANDROID_NDK_HOME`，改用固定路径下载 NDK r27c |
| Xposed `catch(Exception)` 陷阱 | `NoSuchMethodError` / `NoSuchFieldError` 继承自 `Error` 而非 `Exception`，必须用 `catch(Throwable)` 捕获。模块中所有外层 try 块均已使用 `Throwable` |
