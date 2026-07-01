# 飞智 B6X 增强计划 — Claude 指令

## 项目定位
飞智 B6X 散热器开发者工具增强项目。**Android 16 BLE 修复已完成**，**智能温控 v2.1 已发布**。

### v2.2 概况（独立开关 + 电流-挡位映射 + 调试日志）
- **独立开关**：`EMERG_CURRENT_ENABLED`（默认关闭）、`EMERG_CPU_ENABLED`、`REV_COMP_ENABLED`、`TREND_EXEMPT_ENABLED`，各功能模块独立控制
- **电流-挡位映射模式**：以电池电流为挡位调整依据，覆盖常规电池温度调档。分充电/放电两套倍率，`CURRENT_GEAR_MODE` 两数字开关。支持 EMA 平滑 + 温度偏移修正。推荐档位低于 `CURRENT_GEAR_MIN` 时回退基准模式。无冷却期
- **调试日志系统**：`DEBUG_MODE` 总开关 + 7 个分区（SENSOR/EMERG/BATT/EXEC/CONN/CONFIG/MAIN），开启时自动关闭日志体积限制
- **电流单位优化**：原始 µA ÷10000 转 0.01A 内部单位，减小所有后续计算的开销。放电负值（`current_now < 0`）不再被当作传感器错误
- **配置预扫描**：`load_config` 先解析所有开关/模式参数，关则跳过对应详细参数，提升热重载效率

### v2.1 概况（速率限制取代逐档变动）
- **速率限制执行**（替代逐档变动）：三参数独立限速——风扇 RPM（`RATE_LIMIT_RPM`，默认 250）、制冷强度（`RATE_LIMIT_COLD`，默认 20）、目标温度（`RATE_LIMIT_TEMP`，默认 2°C）
- 溢出自然累积下周期，目标变化时从当前实际值重新计算
- 所有速率限制值加入 `profile.conf` 可自定义；`RPM_SMOOTH_STEP` 作为 `RATE_LIMIT_RPM` 的别名保留兼容
- 断联时丢弃未执行的变化量，实际值保持断联前最后数值
- 重连时三个实际值（RPM/制冷/温度）都调到匹配挡位的值，不下发，等下轮 `rate_limited_execute` 按正常速率向目标挡位过渡，防止基准值错误导致的操作偏差
- **紧急退出恢复期**：紧急等级降低后 BATT_ZONE 阈值 ×6→×4→×2→1 逐步恢复全灵敏度（每阶段 BATT_RECOVERY_PHASE_CYCLES 周期，默认 6），连续退出重启，反补照常执行；重新进入紧急时立即取消
- 紧急干预双源化：CPU 温度 + 电池电流 OR 入 AND 出，电流使用绝对值不平滑
- 退出紧急直接按 AND 结果钳制，不再判断电池温度/充电电流
- 删除 pgrep 进程检测：改为 status 文件 mtime 心跳 + BLE=1 双重检查
- 日志持 FILE* 避免每行 open/close，日志格式支持末尾 \\n 实现空行
- **档位表可配置化**：GearEntry 结构体替代 4 张静态数组，profile.conf 支持 `GEAR_N=模式,目标°C,风扇RPM,制冷强度` 自定义覆盖，支持自动扩展档位数量
- **默认档位表改为全部固定功率**：根据实测，智能温控模式（mode=0）的风扇转速上限非强制生效，常突破上限导致噪音突增。新默认表 1~10 级全部固定功率模式（mode=1）

### v2.0 概况（基础）
- 通信：~~FIFO~~ → 已废弃，改用 status 文件 mtime 心跳 + BLE=1 双重检查
- 配置：所有阈值通过 `profile.conf` 运行时配置，支持 mtime 热重载（`CONFIG_ENABLED=0` 可跳过）
- 档位：1~12 级，使用查表法，趋势豁免+峰值反补合并逻辑
- 进程检测：双重检查（status 文件 mtime 心跳 + BLE=1），无 pgrep
- 日志：持 FILE* 避免重复 open/close，超限自动滚动
- 部署：Magisk/KSU 模块（`service.sh` 复制到 `/data/local/tmp/` 绕过 noexec）
- *(v2.1 改为速率限制执行)*

## ⚠️ Git 子模块
- **本目录（`飞智b6x增强计划/`）是一个 git 子模块**，所有代码和 git 操作都在此目录内进行。
- 外层 `D:\下载\Claude Code\` 只追踪子模块指针（gitlink），在外层 add/commit 只改了指针。
- **所有 git 操作（add/commit/push/pull）必须在本目录内执行**。
- 子模块内有 `origin/main` 的本地缓存，`git rebase origin/main` 无需网络。
- `origin` remote 使用 PAT 认证，push 前需要网络可达 GitHub。

## 工作目录
- 根目录：`D:\下载\Claude Code\飞智b6x增强计划`
- LSPosed 模块项目：`./lsp模块(apk修复+温控接口)/`（Android Studio 项目）
- 智能温控：`./magisk模块(智能温控)/`（C 守护程序 + Magisk 模块框架）
- 所有操作在 **Bash 环境** 下执行
- **分支**：所有开发直接提交到 **`main`** 分支（默认分支），不使用 master

## 最终方案
**LSPosed 1.9.2-it 运行时 Hook**（不修改 APK）

模块类：`com.example.waspwingtempctrl.MainHook`
模块源码：`lsp模块(apk修复+温控接口)/app/src/main/java/com/example/waspwingtempctrl/MainHook.java`


1. 分析 app 内部行为时 **不要猜** 先在 `参考资料/` 目录里搜索关键词——这里已经有完整的 smali 反编译输出，可以用 `Grep` 扫整个项目（包括 `参考资料/`），确认有没有现成的分析结果
2. 如果 `参考资料/` 没有，再考虑加诊断钩子或实时分析

## 关键文件索引
| 文件 | 说明 |
|------|------|
| `lsp模块(apk修复+温控接口)/` | LSPosed 模块 Android Studio 项目 |
| `参考资料/apk逆向分析/smali/` | APK 反编译 smali 代码 |
| `参考资料/完整修复历程.md` | 4 层 Bug 的完整修复记录（含早期反编译分析） |
| `参考资料/smali修改重编译apk尝试/` | smali 工具链 + DEX 修改尝试产物 |
| `magisk模块(智能温控)/tempctrl.c` | 智能温控 C 守护程序 |
| `magisk模块(智能温控)/逻辑说明.md` | 智能温控设计文档 |
| `magisk模块(智能温控)/magisk模块框架/` | Magisk 模块框架（module.prop/service.sh/customize.sh/profile.conf） |

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
- 每轮新对话和压缩上下文之后的首次推送，必须跟随检查是否报错

## 工具位置
- `baksmali.jar` → `参考资料/smali修改重编译apk尝试/baksmali.jar`
- `smali.jar` → `参考资料/smali修改重编译apk尝试/smali.jar`
- `debug.keystore` → `参考资料/smali修改重编译apk尝试/debug.keystore`
