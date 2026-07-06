# Task Plan: 日志逻辑修正与配置调整

## Goal
修复 PID 模式下日志的多个问题，并调整默认配置参数。

## Phases
- [ ] Phase 1: 探索项目结构，理解代码组织方式
- [ ] Phase 2: 分析日志相关代码逻辑（紧急模式、debug模式、PID日志）
- [ ] Phase 3: 修复问题1 — 紧急模式只应在普通模式专属，PID模式不应出现紧急日志
- [ ] Phase 4: 修复问题2 — PID 正常状态应有日志（不依赖 debug 开关）
- [ ] Phase 5: 修复存档日志 "冷强度" → "制冷强度"，PID模式去掉"→挡位x"，普通模式保留
- [ ] Phase 6: PID gear 对齐日志删除风扇转速
- [ ] Phase 7: PID 模式电流补偿默认关，输入/输出滤波默认 33
- [ ] Phase 8: 验证修改完整性，总结变更

## Status
**Currently in Phase 1** - 探索项目结构

## Log
