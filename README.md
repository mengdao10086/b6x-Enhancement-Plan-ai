# 飞智 B6X 增强计划

[![Build](https://github.com/mengdao10086/b6x-Enhancement-Plan-ai/actions/workflows/build-apk.yml/badge.svg)](https://github.com/mengdao10086/b6x-Enhancement-Plan-ai/actions/workflows/build-apk.yml)

飞智 B6X 散热器开发者工具的增强方案。修复了 Android 16 上的 BLE 兼容性问题，并扩展了智能温控功能。

---

## 组件

| 组件 | 路径 | 说明 | 状态 |
|------|------|------|------|
| **LSPosed 模块** | [lsp模块（apk修复+温控接口）/](lsp模块（apk修复+温控接口）/README.md) | 修复 Android 16 BLE Bug + 提供智能温控广播接口 | ✅ v1.0 已发布 |
| **C 守护程序** | [magisk模块（智能温控）/](magisk模块（智能温控）/tempctrl.c) | 双重进程检测(pgrep+心跳文件) + am broadcast 控制 | ⚙️ v2.0 开发中 |

### LSPosed 模块功能

- 修复 Android 16 (API 36) 上 `checkBluetoothPermission()` 返回 false 导致 BLE 无法连接的问题
- 修复连接后扫描不停、ViewModel LiveData 不更新等 4 层 Bug
- 提供 `com.flydigi.SET_TEMPERATURE` 广播接收器，支持 7 参数完整控制
- 模块每 5 秒写入 `tempctrl.status` 上报 BLE 连接状态 + 心跳，daemon 通过 pgrep + 文件 mtime 双重检测进程存活

### C 智能温控守护程序

- 读取电池温度（sysfs）和 CPU 温度，综合决策散热档位
- 12 级档位（1~12），使用查表法（实测数据）
- CPU 紧急干预（65/75/85°C 三级，带低通滤波 + 10°C 滞回）
- 电池温度调档（基准 35°C，三级区间：死区/±1档/±2档）
- 趋势豁免（融合峰值反补）：小变动趋势反向→豁免，大变动→直接反补
  - 2°C 内：≤PEAK_DAMP_INNER_BOUNDARY(0.3°C) 且趋势反向：豁免
  - 2°C 内：>PEAK_DAMP_INNER_BOUNDARY(0.3°C) 且 ≤PEAK_DAMP_INNER_THRESHOLD(0.5°C)：反补 1 档
  - 2°C 内：>PEAK_DAMP_INNER_THRESHOLD(0.5°C)：反补 2 档（固定）
  - 2°C 外：≤PEAK_DAMP_OUTER_THRESHOLD(0.5°C)：豁免，>：反补 1 档（固定）
- 温度未变化时跳过升降档，防止重复调整
- 电池档位继承实际下发档位，紧急退出后挡位不暴跌
- 退出紧急降档验证：仅电池温度低于升档阈值时允许降档
- 三合一存活检测：pgrep + 状态文件 mtime 心跳 + BLE=1，任一判死即断联
- 所有阈值可通过 profile.conf 运行时配置并热重载（共 16 个可调参数）
- CONFIG_ENABLED=0 时跳过配置加载，全部使用代码默认值
- 指令去重，避免散热器频繁切换

---

## 快速开始

### 安装 LSPosed 模块

1. 从 [Actions 页面](https://github.com/mengdao10086/b6x-Enhancement-Plan-ai/actions) 下载最新 APK（`LSPosed-Module-APK` 构件）和 Magisk 模块（`b6x-Magisk-Module` 构件）
2. 安装到手机
3. 在 LSPosed 中启用模块，作用域勾选 `com.flydigi.waspwing.experimental`
4. 强制停止飞智散热器 App，重新打开

### 手动测试广播

```bash
# 设置智能温控 16°C，风扇上限 4000RPM
am broadcast -a com.flydigi.SET_TEMPERATURE \
    --ei mode 0 --ei temperature 16 --ei windLevel 4000
```

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

APK 和 C 守护程序均由 GitHub Actions 自动构建：
- 推送 `v*` 标签自动触发
- 也可在 Actions 页面手动 `workflow_dispatch` 触发
- 构建产物在对应运行记录的 Artifacts 中下载

> **分支**：所有开发直接提交到 **`main`** 分支（默认分支），不经过 master。
> **CI 注意事项**：NDK (~700MB) 已配置 `actions/cache` 缓存，首次运行后不再重复下载。
> 使用 `workflow_dispatch` 测试，不要推送 release tag 直到测试通过。

### ⚠️ 重要：C 守护程序必须使用 GitHub Actions 编译

**不要在手机上用 Termux 编译！** Termux 的 `clang -static` 链接的是 Termux 的 libc，
不是 Android 的 libc，编译出的二进制在实际的 Android 系统上 PT_TLS 段对齐错误，
即使执行 `patch_tls.py` 修复也无法保证在所有内核版本上正常运行。

**务必使用 GitHub Actions 编译**（或本地 NDK arm64 交叉编译）：

- CI 使用 NDK r27c，固定路径 `/opt/ndk`
- 编译命令：`aarch64-linux-android21-clang -static -O2`
- NDK 已配置 `actions/cache` 缓存（~700MB），首次后不再重复下载
- CI 产物在 Actions 运行记录的 Artifacts 中下载

---

## 待办 / 开发中

### C 守护程序待测试

| 任务 | 优先级 | 说明 |
|------|--------|------|
| 进程检测与恢复（双重检测） | 🟡 中 | pgrep + status 文件 mtime 16 秒超时，模块断写心跳后 daemon 能否正确判死并恢复 |
| 断联恢复测试 | 🟡 中 | BLE 断开后重连，daemon 是否正确恢复（不重置状态） |
| Status 文件 BLE 状态上报 | 🟡 中 | 模块每 5 秒写 BLE=0/1 到 status 文件，daemon 读取并响应 |
| config 热重载验证 | 🟡 中 | 修改 `profile.conf` 后是否自动生效 |
| 峰值过冲抑制测试 | 🟡 中 | 温度快速变化时反向补偿是否合理，日志确认 |
| 退出紧急降档验证 | 🟡 中 | 电池温度高于升档阈值时是否正确跳过 cap |

### CI 可改进

- NDK 缓存：每次 CI 下载 NDK ~700MB，可改为缓存加速（✅ 已实现）
- 自动发布：等 v2.0 稳定后可开启 tag 自动发布 APK + C 二进制

### 待分析/待实现

| 项目 | 类型 | 说明 |
|------|------|------|
| DefaultDispatch 线程死循环 | ✅ 已修复 | `hookAllConstructors` 替换队列 + sleep(50ms) |
| 档位表可配置化(v2.1) | 🟡 中 | 将 4 张查表数组改为 profile.conf GEAR_N=模式,目标,风扇,制冷 格式，支持自动扩展档位数量 |
| UI 模式选择器闪烁（固定功率时圆点空白） | 🟢 低 | `experimentalRunModeValue` 覆写已修复智能温控模式闪烁，但固定功率模式仍显示异常 |

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
