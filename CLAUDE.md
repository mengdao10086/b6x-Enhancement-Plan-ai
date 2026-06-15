# 飞智 B6X 增强计划 — Claude 指令

## 项目定位
飞智 B6X 散热器开发者工具增强项目。**Android 16 BLE 修复已完成**，**智能温控 v2.0 已完成**。

### v2.0 概况
- 通信：~~FIFO~~ → 已废弃，改用 status 文件 mtime + pgrep + BLE 三重检查
- 控制：C 守护程序每 5 秒决策 → `am broadcast` → LSPosed 模块 → `WaspWingManager.setRunMode()` → BLE 指令
- 配置：所有阈值通过 `profile.conf` 运行时配置，支持 mtime 热重载（`CONFIG_ENABLED=0` 可跳过）
- 档位：1~12 级，使用查表法，趋势豁免+峰值反补合并逻辑
- 部署：Magisk/KSU 模块（`service.sh` 复制到 `/data/local/tmp/` 绕过 noexec）

## 工作目录
- 根目录：`D:\下载\Claude Code\飞智b6x增强计划`
- LSPosed 模块项目：`./lsp模块（apk修复+温控接口）/`（Android Studio 项目）
- 智能温控：`./magisk模块（智能温控）/`（C 守护程序 + Magisk 模块框架）
- 所有操作在 **Bash 环境** 下执行
- **分支**：所有开发直接提交到 **`main`** 分支（默认分支），不使用 master

## 最终方案
**LSPosed 1.9.2-it 运行时 Hook**（不修改 APK）

模块类：`com.example.waspwingtempctrl.MainHook`
模块源码：`lsp模块（apk修复+温控接口）/app/src/main/java/com/example/waspwingtempctrl/MainHook.java`


1. 分析 app 内部行为时 **不要猜** 先在 `参考资料/` 目录里搜索关键词——这里已经有完整的 smali 反编译输出，可以用 `Grep` 扫整个项目（包括 `参考资料/`），确认有没有现成的分析结果
2. 如果 `参考资料/` 没有，再考虑加诊断钩子或实时分析

## 关键文件索引
| 文件 | 说明 |
|------|------|
| `lsp模块（apk修复+温控接口）/` | LSPosed 模块 Android Studio 项目 |
| `参考资料/反编译及分析结果/smali_output/` | APK 反编译 smali 代码 |
| `参考资料/反编译及分析结果/bug_analysis_report.md` | 原始 Bug 分析报告 |
| `修复历程/完整修复历程.md` | 4 层 Bug 的完整修复记录 |
| `修复历程/修复过程1.1/` | smali 工具链 |
| `magisk模块（智能温控）/tempctrl.c` | 智能温控 C 守护程序 |
| `magisk模块（智能温控）/逻辑说明.md` | 智能温控设计文档 |
| `magisk模块（智能温控）/magisk模块框架/` | Magisk 模块框架（module.prop/service.sh/customize.sh/profile.conf） |

## 修复成果
| 问题 | 修复 | 状态 |
|------|------|------|
| 扫描永不停止 | 钩 `onDeviceConnected` → `stopScan()` | ✅ |
| UI 持续显示"扫描中" | 更新 `_connectLiveData` 和 `_waspWingInfo` | ✅ |
| GATT 服务发现不触发 | 强制 `checkBluetoothPermission()` 返回 true | ✅ |
| 智能温控模式闪烁 | 去掉 `convertFromDevice` 提前创建 WaspWingInfo | ✅ |

## 编译注意事项
- **C 守护程序必须使用 GitHub Actions（NDK）编译**，不要在手机上用 Termux 编译
  - Termux 的 `clang -static` 链接 Termux 的 libc，非 Android libc，PT_TLS 段无法正确运行
  - 仅 NDK 的 `aarch64-linux-android21-clang -static -O2` 能产生正确的二进制
- CI 按变更自动选择编译内容：
  - 改 `lsp模块/` → 仅编译 LSPosed APK
  - 改 `magisk模块/` → 仅编译 C 二进制
  - 推送 `v*` 标签或手动触发 → 全量编译
- `patch_tls.py` 仅对 NDK 静态编译有效，Termux 编译修复后仍不可靠

## 工具位置
- `baksmali.jar` → `修复历程/修复过程1.1/baksmali.jar`
- `smali.jar` → `修复历程/修复过程1.1/smali.jar`
- `debug.keystore` → `修复历程/修复过程1.1/debug.keystore`
