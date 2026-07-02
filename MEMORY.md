# 项目记忆索引

> 快速定位文件。核心内容见各文件本身，此处只存链接。

| 主题 | 位置 | 一句话 |
|------|------|--------|
| BLE 修复全记录 | [完整修复历程](参考资料/完整修复历程.md) | 4 层 Bug 链（扫描→UI→GATT→闪烁）的完整修复过程 |
| LSPosed 模块源码 | [MainHook.java](lsp模块(apk修复+温控接口)/app/src/main/java/com/example/waspwingtempctrl/MainHook.java) | Xposed 钩子 + SET_TEMPERATURE 广播接收 |
| 智能温控 C 源码 | [tempctrl.c](magisk模块(智能温控)/tempctrl.c) | 电池/CPU 双温控决策，profile.conf 热重载 |
| 智能温控设计文档 | [逻辑说明.md](magisk模块(智能温控)/逻辑说明.md) | 运行逻辑、策略细节、配置参数映射 |
| Magisk 模块框架 | [magisk模块框架/](magisk模块(智能温控)/magisk模块框架/) | module.prop / service.sh / customize.sh / profile.conf |
| App 逆向分析 | [app运行逻辑.md](参考资料/apk逆向分析/app运行逻辑.md) | App 内部结构、BLE 通信流程、LiveData 数据链 |
| 更新日志 | [CHANGELOG.md](参考资料/CHANGELOG.md) | v1.0 → v2.2 逐版本变更 |
| 版本状态 | 当前版本 v2.2（电流-挡位融合模式），2026-07-03 | Android 16 BLE 修复已完成 |
