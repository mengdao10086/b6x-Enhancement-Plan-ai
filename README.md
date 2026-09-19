# 飞智 B6X 增强计划

[![自动构建](https://github.com/mengdao10086/b6x-Enhancement-Plan-ai/actions/workflows/build.yml/badge.svg)](https://github.com/mengdao10086/b6x-Enhancement-Plan-ai/actions/workflows/build.yml)

飞智 B6X/B7X 散热器的增强方案。修复了 Android 16 上的 BLE 兼容性问题，扩展了智能温控功能。

---

## 组件

| 组件 | 路径 | 说明 | 状态 |
|------|------|------|------|
| **APK（唯一交付物）** | [lsp模块(apk修复+温控接口)/](lsp模块(apk修复+温控接口)/) | LSPosed 模块 + 原生配置界面；内置 C 守护程序（CI 编译后注入 `assets/tempctrl-arm64`） | ✅ v3.0 |
| C 守护程序源码 | [magisk模块(智能温控)/](magisk模块(智能温控)/) | 智能温控，由 CI 编译后打进上面的 APK | 已并入 APK |
| 参数定义 | [参数定义/](参数定义/) | 52 个配置键的单一来源，生成 APK 内的 `assets/params.json` | — |

---

## 架构概览

手机内三进程协作：**B6X App / B7X App** 内由 LSPosed 模块钩住散热器 SDK（`setRunMode()` → BLE 下发指令）；Root 进程 **tempctrl** 通过双 status 文件心跳仲裁 active 设备，每 5s 周期决策并经 `am broadcast` 下发控制指令。

C 守护程序（`tempctrl`）与 `service.d` 拉起脚本由 APK 内的部署功能落盘到 `/data/local/tmp/` 与 `/data/adb/service.d/`，不再单独发 Magisk 模块包。

> 详细架构图、进程协作与各文件落点见 [逻辑说明.md](magisk模块(智能温控)/逻辑说明.md)。

---

## 功能

### LSPosed 模块

- 修复蓝牙连接bug，死循环吃满一个核心bug → [完整修复历程](参考资料/完整修复历程.md)
- 广播控制接口（完整 7 参数散热器控制），协议详见 [lsp模块 README](lsp模块(apk修复+温控接口)/README.md)
- 状态文件（tempctrl_b6x.status / tempctrl_b7x.status）向 C 守护程序回传散热器参数
- **原生配置界面（Material）**：部署状态 / 一键部署 / su 诊断 / 参数表单 / 实时曲线 / 日志，共四页签

### C 智能温控守护程序

- **PID控制**：PID 连续无级调节（比例/微分融合 + 动态目标 + 电池温度输入滤波），尽可能稳定手机温度
- **制冷→风扇自动映射**：冷端指数 + 热端线性自加权合并，冷/热端映射输入 EMA 平滑系数可配置（输入先平滑、映射后不滤波），保证散热相对够用的同时尽可能压低风扇转速降低噪音
- **可自动拉起散热器 app**：无散热器 app 存活时自动拉起上次使用的 app（**默认关闭**，需在界面中开启）
- **高可玩性**：大量可自定义参数
- **界面内直接查看实时曲线与日志**：参数改即存，daemon 每 5s 热重载
- **配置热重载**：界面或 profile.conf 修改参数后无需重启即生效

> 详细策略设计 → [逻辑说明.md](magisk模块(智能温控)/逻辑说明.md) · 版本变更 → [CHANGELOG.md](CHANGELOG.md)

---

## 项目结构

<pre>
├── <a href="lsp模块(apk修复+温控接口)/">lsp模块(apk修复+温控接口)/</a>     ← LSPosed 模块 + 原生界面（Android 项目，唯一交付物）
├── <a href="magisk模块(智能温控)/">magisk模块(智能温控)/</a>          ← C 守护程序源码
│   ├── <a href="magisk模块(智能温控)/tempctrl.c">tempctrl.c</a>                 ← 核心 C 代码
│   ├── <a href="magisk模块(智能温控)/逻辑说明.md">逻辑说明.md</a>                ← 技术设计文档
│   ├── <a href="magisk模块(智能温控)/patch_tls.py">patch_tls.py</a>               ← CI 构建工具（修复 PT_TLS 对齐）
│   └── <a href="magisk模块(智能温控)/magisk模块框架/">magisk模块框架/</a>            ← profile.conf（配置模板）+ webroot/schema.js（参数定义四源之一）
├── <a href="参数定义/">参数定义/</a>                       ← 52 个配置键的单一来源 + 生成/校验脚本
├── <a href="CHANGELOG.md">CHANGELOG.md</a>                   ← 版本更新日志
├── <a href="参考资料/">参考资料/</a>
│   ├── <a href="参考资料/完整修复历程.md">完整修复历程.md</a>             ← BLE 4 层 Bug 修复全记录 + B8X 分析
│   ├── <a href="参考资料/decompile/">decompile/</a>                  ← APK 反编译产物（不进 git）
│   └── <a href="参考资料/smali_patching_attempts/">smali_patching_attempts/</a>     ← smali 工具链 + DEX 修改产物（失败尝试，工具 jar 已并入集中 [../工具/](../工具/)）
├── <a href="反编译分析/">反编译分析/</a>                   ← 各 app 反编译分析文档（总览见 <a href="反编译分析/总览.md">总览.md</a>）
├── <a href=".github/workflows/">.github/workflows/</a>              ← CI 自动构建
└── <a href="README.md">README.md</a>                       ← 本文件
</pre>
