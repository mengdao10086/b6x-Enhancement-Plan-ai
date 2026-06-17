# 飞智 B6X 增强计划

[![Build](https://github.com/mengdao10086/b6x-Enhancement-Plan-ai/actions/workflows/build-apk.yml/badge.svg)](https://github.com/mengdao10086/b6x-Enhancement-Plan-ai/actions/workflows/build-apk.yml)

飞智 B6X 散热器开发者工具的增强方案。修复了 Android 16 上的 BLE 兼容性问题，并扩展了智能温控功能。

---

## 组件

| 组件 | 路径 | 说明 | 状态 |
|------|------|------|------|
| **LSPosed 模块** | [lsp模块（apk修复+温控接口）/](lsp模块（apk修复+温控接口）/README.md) | 提供散热器控制接口 | ✅ v2.0 已发布 |
| **C 守护程序** | [magisk模块（智能温控）/](magisk模块（智能温控）/tempctrl.c) | 使用lsp模块接口控制散热器 | ✅ v2.0 已发布 |

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
- 趋势豁免/峰值反补（方向感知区间）：
  - **内区**（降温且≤37°C / 升温且≥33°C时）：
    - ≤PEAK_DAMP_INNER_BOUNDARY(0.3°C) 且趋势反向：豁免
    - >分界且 ≤PEAK_DAMP_INNER_THRESHOLD(0.5°C)：反补 1 档
    - >PEAK_DAMP_INNER_THRESHOLD(0.5°C)：反补 2 档（固定）
  - **外区**（其余情况）：≤PEAK_DAMP_OUTER_THRESHOLD(0.5°C)：豁免，>：反补 1 档（固定）
- 温度未变化时跳过升降档，防止重复调整
- 电池档位继承逻辑目标档位，紧急退出后挡位不暴跌
- 退出紧急降档：直接按 AND 逻辑结果钳制（不再判断电池温度/充电电流）
- **决策与执行分离**：main_loop 纯计算不下发，每轮最多变动 1 档，压制档位突变噪音
- 断联时清零待执行步伐，重连时对齐目标后强制下发
- 三重检查存活检测：pgrep + 状态文件 mtime 心跳 + BLE=1，任一判死即断联
- 大部分参数可通过 profile.conf 运行时配置并热重载
- CONFIG_ENABLED=0 时跳过配置加载，全部使用代码默认值
- 指令去重，避免散热器频繁切换

---

## 项目结构

```
├── lsp模块（apk修复+温控接口）/     ← LSPosed 模块（Android 项目）
├── magisk模块（智能温控）/          ← C 守护程序源码 + Magisk 模块框架
├── 参考资料/                        ← 原始 APK + 反编译分析
├── 修复历程/                        ← Bug 修复全记录
├── .github/workflows/              ← CI 自动构建（APK + C 二进制）
└── log.md                           ← 修改日志（git 已忽略，仅本地）
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

GitHub Actions 自动构建，**只推送有变化部分的编译即可**：
| 触发方式 | 编译内容 |
|----------|----------|
| 推送 `lsp模块/**` 变更 | 仅 LSPosed 模块（`build-lsposed.yml`） |
| 推送 `magisk模块/**` 变更 | 仅 C 守护程序 + Magisk 模块包（`build-magisk.yml`） |
| 推送 `v*` 标签 | 全量编译（`build-apk.yml`） |
| 手动 `workflow_dispatch` | 全量编译 |

构建产物在对应运行记录的 Artifacts 中下载。

> **NDK 缓存**：NDK (~700MB) 已配置 `actions/cache`，首次运行后不再重复下载。
> **分支**：所有开发直接提交到 **`main`** 分支。

---

### 待分析/待实现

| 项目 | 优先度 | 说明 |
|------|------|------|
| 档位表可配置化(v2.1) | 🟡 中 | 暂定将 4 张查表数组改为 profile.conf GEAR_N=模式,目标,风扇,制冷 格式，支持自动扩展档位数量 |
| UI 模式选择器智能温控时闪烁，固定功率时圆点空白 | 🟢 低 | 不影响运行，无法手动操控时切换一次模式即可 |

---

## 本地开发环境

| 项目 | 说明 |
|------|------|
| 代码路径 | `D:\下载\Claude Code\飞智b6x增强计划\` |
| Git 远程 | `https://github.com/mengdao10086/b6x-Enhancement-Plan-ai.git` |
| 默认分支 | `main` |
| 模块编译 | Android Studio 打开 `lsp模块（apk修复+温控接口）/` → Build APK |
| C 编译 | **仅限 GitHub Actions**（NDK r27c），参见上方构建说明 |
| 模块安装 | LSPosed 勾选模块 + 作用域 `com.flydigi.waspwing.experimental` → 强制停止 App |

## 已知风险

| 风险 | 说明 |
|------|------|
| `RECEIVER_EXPORTED` 权限 | `am broadcast` 从系统进程发广播，模块需 `RECEIVER_EXPORTED` 才能收到（Android 14+） |
| 温度传感器路径 | `thermal_zone` 范围可通过 `CPU_ZONE_MIN/MAX` 配置，K60 推荐 30~40 |
| BLE 重连时序 | `BluetoothGatt.disconnect()` 钩子可能被多次触发（已移除 FIFO，不影响） |
| NDK 编译 | CI 中不要依赖 `$ANDROID_NDK_HOME`，改用固定路径下载 NDK r27c |
| Xposed `catch(Exception)` 陷阱 | `NoSuchMethodError` / `NoSuchFieldError` 继承自 `Error` 而非 `Exception`，必须用 `catch(Throwable)` 捕获。模块中所有外层 try 块均已使用 `Throwable` |
