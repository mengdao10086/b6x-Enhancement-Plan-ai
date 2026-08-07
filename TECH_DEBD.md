# 技术债记录

> 下发链路改造（2026-08-08 经 grilling 收敛）**已实现，待 CI 编译 + 真机验证**。验证通过后从本文件移除，并在 `CHANGELOG.md` 记录。

## 已实现（待验证）

### 改动 1｜去重改用散热器实际值对比 + 删除强制清零
- **实现**：`should_skip_dispatch()` 以散热器实际回传为准去重（回传异常退化 `last_*` 对比）；删除设备切换/重连路径的 `last_bcast_valid = 0`。
- **验证**：真机确认"日志已变化但实际未到位"消失；设备切换/重连后新参数正常下发。

### 改动 2｜制冷上升死区（COLD_UP_DEADZONE，可配置）
- **实现**：`should_skip_dispatch()` 内死区逻辑 + `profile.conf` `COLD_UP_DEADZONE=5` + `load_config` 解析。
- **验证**：profile.conf 热重载生效；距最高/最低制冷 < 阈值×2 时死区失效、可精确到位。

### 改动 3｜删除限速首步直通 + 重连/启动用散热器实际回传起步
- **实现**：`rate_limit()` 删 `actual<0` 直通；`reconnect_align` 制冷/转速改用 `COLD_REAL`/`RPM_REAL` 起步（PID 同时重置 PID 状态）；启动/档位表重排初始化 actual 用回传值（异常保底最小合法值）；目标温度 `<0` 显式初始化。
- **验证**：断联重连曲线无跳变；PID 重连从回传值正常步进；冷启动/档位表重排无负值。

### 改动 4｜删除 gear 存档，改用 status 回传值
- **实现**：删除 `save_cold`/`load_cold`/`gear_file_path`/`set_gear_file_path` + 2 处 save 调用；Gear/PID 启动改读 status 文件 `COLD_REAL`。
- **验证**：`/data/local/tmp/tempctrl.gear` 不再写入；Gear/PID 启动读 status 回传正常。

## 验证清单
- [ ] GitHub Actions CI 编译通过（NDK r27c）
- [ ] 真机：断联重连曲线无跳变
- [ ] 真机：档位切换后回传逐步跟上、无负值日志
- [ ] 真机：`tempctrl.gear` 不再写入

## Out of scope
档位表内容、PID 参数、WebUI、风扇死区（未提及）、`module.prop`/版本号（不自动更新）。
