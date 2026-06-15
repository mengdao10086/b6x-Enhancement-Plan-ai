# 项目记忆索引

- [完整修复历程](修复历程/完整修复历程.md) — 全部 4 层 Bug 修复全记录
- [LSPosed 模块源码](lsp模块（apk修复+温控接口）/app/src/main/java/com/example/waspwingtempctrl/MainHook.java) — MainHook.java（SET_TEMPERATURE 广播接收 + BLE 修复）
- [智能温控 C 守护程序](magisk模块（智能温控）/tempctrl.c) — 智能温控算法源码（pgrep 进程检测，查表法档位，电池/CPU 双温控，profile.conf 配置热重载，温度趋势豁免）
- [智能温控逻辑说明](magisk模块（智能温控）/逻辑说明.md) — 智能温控设计文档（运行逻辑、策略细节、注意事项）
- [Magisk 模块框架](magisk模块（智能温控）/magisk模块框架/) — module.prop / service.sh / customize.sh / profile.conf
- [反编译分析](参考资料/反编译及分析结果/bug_analysis_report.md) — 原始 Bug 分析报告
- [第一阶段修复](修复历程/完整修复历程.md#2-第一阶段apk-直接修改尝试失败) — smali 修改尝试记录（合入完整版第 2 章）

## 进程检测与控制流

| 方向 | 方式 | 数据 |
|------|------|------|
| tempctrl → App 存活检测 | `pgrep -f com.flydigi.waspwing.experimental` | 每 5 秒检查 |
| tempctrl → LSPosed 模块 | `am broadcast` | `com.flydigi.SET_TEMPERATURE` 带 7 参数 |
| LSPosed 模块 → 散热器 | `WaspWingManager.setRunMode()` → BLE | 散热器控制指令 |

## 核心逻辑

- ~~FIFO 通信已废弃~~（KernelSU 下 App 进程写 `/data/local/tmp/` 权限不通）
- tempctrl 通过 `pgrep` 每 5 秒检测 App 进程存活
- App 进程不存在 → 等待复活；复活后 `actual_level = target_level` 对齐，清缓存强制下发
- 断联时 `actual_level = target_level`（清零待执行步伐），无超时重置
- 档位决策与执行分离：`main_loop` 纯计算，每轮连接检测后逐步执行 ±1 档
- 电池档位继承：`battery_fan_level = final_level`，紧急退出后不会暴跌
- 温度趋势豁免：降温不升档、升温不降档（最多豁免 `OVERRIDE_MAX` 次，默认 8）
- 所有阈值通过 `profile.conf` 配置，修改后 mtime 热重载无需重启
- App 前后台切换不影响控制（模块仍在接收广播）
