# 飞智 B6X 增强计划

[![自动构建](https://github.com/mengdao10086/b6x-Enhancement-Plan-ai/actions/workflows/build.yml/badge.svg)](https://github.com/mengdao10086/b6x-Enhancement-Plan-ai/actions/workflows/build.yml)

飞智 B6X/B7X 散热器的增强方案。修复了 Android 16 上的 BLE 兼容性问题，扩展了智能温控功能。

---

## 组件

| 组件 | 路径 | 说明 | 状态 |
|------|------|------|------|
| **APK（唯一交付物）** | [lsp模块/](lsp模块/) | LSPosed 模块 + 原生配置界面；内置 C 守护程序（CI 编译后注入 `assets/tempctrl-arm64`） | ✅ 版本见 [lsp模块/app/build.gradle.kts](lsp模块/app/build.gradle.kts) |
| C 守护程序源码 | [lsp模块/daemon/](lsp模块/daemon/) | 智能温控，由 CI 编译后打进上面的 APK | 已并入 APK |
| 参数定义 | [参数定义/](参数定义/) | 配置键的单一来源（键数见 `参数定义/check_params.py` 的 `EXPECTED_KEY_COUNT`），生成 APK 内的 `assets/params.json` | — |

---

## 架构概览

手机内三进程协作：**B6X App / B7X App** 内由 LSPosed 模块钩住散热器 SDK（`setRunMode()` → BLE 下发指令）；Root 进程 **tempctrl** 通过双 status 文件心跳仲裁 active 设备，每 5s 周期决策并经 `am broadcast` 下发控制指令。

C 守护程序（`tempctrl`）与 `service.d` 拉起脚本由 APK 内的部署功能落盘到 `/data/local/tmp/` 与 `/data/adb/service.d/`，不再单独发 Magisk 模块包。**卸载 APK 后守护进程会自行清理这些落盘产物并停止运行**（含开机自启脚本），设备上不留残留；重装后需重新一键部署。

> 详细架构图、进程协作与各文件落点见 [逻辑说明.md](逻辑说明.md)。

---

## 功能

### LSPosed 模块

- 修复蓝牙连接bug，死循环吃满一个核心bug → [完整修复历程](参考资料/完整修复历程.md)
- 广播控制接口（完整 7 参数散热器控制），协议详见 [lsp模块 README](lsp模块/README.md)
- 状态文件（tempctrl_b6x.status / tempctrl_b7x.status）向 C 守护程序回传散热器参数
- **原生配置界面（Material）**：部署状态 / 一键部署 / su 诊断 / 参数表单 / 实时曲线 / 日志，共三页签

### C 智能温控守护程序

- **PID控制**：PID 连续无级调节（比例/微分融合 + 动态目标 + 电池温度输入滤波），尽可能稳定手机温度
- **制冷→风扇自动映射**：冷端指数 + 热端线性自加权合并，冷/热端映射输入 EMA 平滑系数可配置（输入先平滑、映射后不滤波），保证散热相对够用的同时尽可能压低风扇转速降低噪音
- **可自动拉起散热器 app**：无散热器 app 存活时自动拉起上次使用的 app（**默认关闭**，需在界面中开启）
- **高可玩性**：大量可自定义参数
- **界面内直接查看实时曲线与日志**：参数改即存，daemon 每 5s 热重载
- **配置热重载**：界面或 profile.conf 修改参数后无需重启即生效

> 详细策略设计 → [逻辑说明.md](逻辑说明.md) · 版本变更 → [CHANGELOG.md](CHANGELOG.md)

---

## 项目结构

```
├── lsp模块/             ← LSPosed 模块 + 原生界面（Android 项目，唯一交付物）
│   ├── app/             ← Android 源码与资源
│   └── daemon/          ← C 守护程序源码、编译工具与 profile.conf
├── 参数定义/             ← 配置键的单一来源 + 生成/校验脚本
├── 参考资料/             ← BLE 修复历程、反编译分析与路线记录
│   ├── decompile/       ← 各 app 反编译产物 + 逐 app 反编译分析（索引 `总览.md`；**不进 git**）
│   ├── 路线记录/         ← 原 `.claude/路线A-*` 8 份原件
│   └── magisk-lsp合并路线.md ← 由 Magisk 模块改为 LSPosed 模块路线的来龙去脉
├── .github/workflows/   ← CI 自动构建
├── 逻辑说明.md           ← 温控技术设计文档
├── CHANGELOG.md         ← 版本更新日志
├── TECH_DEBT.md         ← 技术债记录
└── 待办.md              ← 项目待办清单
```

> 逐文件索引见 [CLAUDE.md](CLAUDE.md#关键文件索引)。
