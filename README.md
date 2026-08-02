# 飞智 B6X 增强计划

[![自动构建](https://github.com/mengdao10086/b6x-Enhancement-Plan-ai/actions/workflows/build.yml/badge.svg)](https://github.com/mengdao10086/b6x-Enhancement-Plan-ai/actions/workflows/build.yml)

飞智 B6X/B7X 散热器的增强方案。修复了 Android 16 上的 BLE 兼容性问题，扩展了智能温控功能，支持双设备共存仲裁。

---

## 组件

| 组件 | 路径 | 说明 | 状态 |
|------|------|------|------|
| **LSPosed 模块** | [lsp模块(apk修复+温控接口)/](lsp模块(apk修复+温控接口)/) | 修复蓝牙连接 + 提供散热器控制接口 | ✅ v2.5 |
| **C 守护程序** | [magisk模块(智能温控)/](magisk模块(智能温控)/) | 智能温控，通过 LSPosed 接口控制散热器 | ✅ v2.5 |

---

## 架构概览

```
 ┌─ 手机 ─────────────────────────────────────────────────┐
 │                                                        │
 │  B6X App 进程         B7X App 进程     Root 进程        │
 │ ┌──────────────────┐ ┌──────────────┐ ┌───────────────┐│
 │ │ LSPosed 模块     │ │  LSPosed 模块 │ │ tempctrl      ││
 │ │ B6X 钩子集       │ │  B7X 钩子集   │ │ 单实例仲裁     ││
 │ │                  │ │              │ │               ││
 │ │ ←─ am broadcast  │ │← am broadcast│ │ 双 status     ││
 │ │   SET_TEMPERATURE│ │ SET_TEMP_B7  │ │ 文件心跳       ││
 │ │       ↓          │ │    ↓         │ │ →选active     ││
 │ │ WaspWingManager  │ │ t9.j(混淆)   │ │ →am broadcast ││
 │ │ .setRunMode()    │ │ .setRunMode()│ │ 5s 周期       ││
 │ │     ↓            │ │    ↓         │ └───────────────┘│
 │ │  BLE → B6X 散热器 │ │ BLE → B7X    │                  │
 │ └──────────────────┘ └──────────────┘                  │
 └────────────────────────────────────────────────────────┘
```

---

## 功能

### LSPosed 模块

- 修复 Android 16 BLE 无法连接的 4 层连环 Bug → [完整修复历程](参考资料/完整修复历程.md)
- 广播控制接口（B6X：`com.flydigi.SET_TEMPERATURE` / B7X：`com.flydigi.SET_TEMPERATURE_B7`），7 参数完整控制
- 双状态文件心跳（`tempctrl_b6x.status` / `tempctrl_b7x.status`），写入连接状态、连接时间、上次连接者，供 C 端仲裁
- 双设备全功能支持（B6X 原生 + B7X 混淆适配）

### C 智能温控守护程序

- **双设备 + 三方 app 存活仲裁**：按状态文件选择当前设备；在 B6X 两个 app 与 farsef 之间做存活仲裁，保留上次连接者
- **PID 连续无级调节**：P+I+D 控制 + 温度趋势预测 + 输入滤波
- **制冷→风扇自动映射**：冷端指数 + 热端线性映射，双端 EMA 平滑系数可配置（`RPM_SMOOTH_ALPHA`），速率限制统一内建
- **降速防抖**：风扇下降方向阈值防抖（可配置 `FAN_RPM_CHANGE_THRESHOLD`），上升自由爬升
- **CPU 紧急干预**：3 级紧急 + 退出恢复期
- **配置热重载**：profile.conf 修改后无需重启即生效

> 详细策略设计 → [逻辑说明.md](magisk模块(智能温控)/逻辑说明.md) · 版本变更 → [CHANGELOG.md](CHANGELOG.md)

---

## 项目结构

<pre>
├── <a href="lsp模块(apk修复+温控接口)/">lsp模块(apk修复+温控接口)/</a>     ← LSPosed 模块（Android 项目）
├── <a href="magisk模块(智能温控)/">magisk模块(智能温控)/</a>          ← C 守护程序源码 + Magisk 模块框架
│   ├── <a href="magisk模块(智能温控)/tempctrl.c">tempctrl.c</a>                 ← 核心 C 代码
│   ├── <a href="magisk模块(智能温控)/逻辑说明.md">逻辑说明.md</a>                ← 技术设计文档
│   └── <a href="magisk模块(智能温控)/magisk模块框架/">magisk模块框架/</a>            ← module.prop / service.sh / customize.sh / profile.conf
├── <a href="CHANGELOG.md">CHANGELOG.md</a>                   ← 版本更新日志
├── <a href="参考资料/">参考资料/</a>
│   ├── <a href="参考资料/完整修复历程.md">完整修复历程.md</a>             ← BLE 4 层 Bug 修复全记录 + B8X 分析
│   ├── <a href="参考资料/decompile/">decompile/</a>                  ← APK 反编译输出
│   │   └── <a href="参考资料/decompile/app运行逻辑.md">app运行逻辑.md</a>            ← App 内部运行逻辑分析
│   └── <a href="参考资料/smali修改重编译apk尝试/">smali修改重编译apk尝试/</a>     ← smali 工具链 + DEX 修改产物
├── <a href=".github/workflows/">.github/workflows/</a>              ← CI 自动构建
└── <a href="README.md">README.md</a>                       ← 本文件
</pre>
