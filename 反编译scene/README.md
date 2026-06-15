# Scene v9.3.1 — 反编译项目文档

> 一款 Android 系统性能调校工具的反编译分析文档  
> 包名：`com.omarea` / 入口：`com.omarea.Scene`  
> 版本：9.3.1（Android 12+，minSdkVersion = 31，targetSdkVersion = 31+）

---

## 目录

- [项目概述](#项目概述)
- [反编译概况](#反编译概况)
- [目录结构](#目录结构)
- [模块速查表](#模块速查表)
- [关键文件索引](#关键文件索引)
- [快速导航](#快速导航)

---

## 项目概述

**Scene** 是一款需要 ROOT 权限的系统级性能调校工具，功能覆盖：

- **性能监控**：CPU/GPU 频率、FPS 帧率、温度、功耗、充电状态
- **系统调校**：CPU 调度、Swap/ZRam、Dex2oat 编译、文件系统 Trim
- **场景模式**：根据应用切换性能模式（如游戏加速、省电）
- **应用管理**：应用冻结/解冻、组件管理、权限配置
- **Xposed 模块**：集成 Xposed 接口实现深度功能
- **脚本引擎**：内置 kr-script 脚本引擎，可对 AOSP/MIUI/Flyme/OPPO/vivo 等系统进行定制
- **硬件测试**：屏幕测试、性能跑分、功耗测试
- **充电控制**：充电状态监控、充电曲线记录
- **FPS 监控**：逐帧渲染分析、Jank 卡顿检测

### 技术特征

| 维度 | 说明 |
|------|------|
| 架构 | Java 原生 Android App，无 Kotlin 业务代码 |
| 混淆 | ProGuard/R8 全量混淆（`a/` 包 3334 个文件）|
| 原生代码 | 1 个 arm64-v8a `.so`（NDK r21，stripped）|
| 脚本引擎 | 内置 kr-script 引擎，含 141 个 Shell 脚本 |
| 系统接口 | ROOT Shell 执行 / JNI / Xposed / AccessibilityService / NotificationListener |
| 权限级别 | 30+ 权限，含 `WRITE_SECURE_SETTINGS`、`SYSTEM_ALERT_WINDOW` 等高级权限 |

---

## 反编译概况

| 项目 | 数值 |
|------|------|
| APK 文件 | `scene_9.3.1.apk`（~7.2 MB）|
| Java 源码总量 | 3,594 个文件（~20 MB）|
| 非混淆源码（`com.omarea`）| **153 个文件**（99.9% 成功解码，2427 类中仅 3 个错误）|
| 混淆代码（`a/` 包）| 3,334 个文件（ProGuard 混淆，函数名语义丢失）|
| AndroidX / Kotlin 标准库 | 107 个文件（来自依赖库，非业务代码）|
| 原生库 | 1 个 `libnative-lib.so`（arm64-v8a, NDK r21）|
| Shell 脚本 | 141 个（kr-script 引擎）|
| Asset 资源 | 216 个文件 |
| 布局/资源 | `extracted/res/` 完整保留（layout/drawable/xml 等）|

---

## 目录结构

```
反编译scene/
├── scene_9.3.1.apk          # 原始 APK
├── extracted/                # APK 解压产物
│   ├── AndroidManifest.xml   # 清单文件（二进制 axml 格式）
│   ├── assets/               # 资源资产
│   │   ├── kr-script/        # 脚本引擎（核心！）
│   │   ├── addin/            # 附加功能脚本
│   │   ├── toolkit/          # 工具包（busybox、binder 工具）
│   │   ├── custom-command/   # 自定义命令
│   │   ├── categories.json   # 应用分类配置
│   │   ├── kr-script.conf    # 脚本引擎配置
│   │   ├── xposed_init       # Xposed 入口配置
│   │   └── ...
│   ├── lib/                  # 原生库
│   │   └── arm64-v8a/libnative-lib.so
│   ├── res/                  # Android 资源（布局/图片/颜色等）
│   └── kotlin/               # Kotlin 标准库元数据
│
├── decompiled/               # Java 反编译产物
│   ├── sources/              # Java 源代码
│   │   ├── com/omarea/       # 核心业务代码（153 文件）
│   │   └── a/                # 混淆代码（3334 文件）
│   └── resources/            # 反编译资源（当前为空）
│
├── README.md                 # 本文档
├── 模块分析.md               # 各模块详细分析
└── 架构与技术细节.md          # 架构设计与关键技术机制
```

---

## 模块速查表

| 模块 | 路径 | 文件数 | 说明 |
|------|------|--------|------|
| **vtools** | `com.omarea.vtools` | **56** | 核心功能：Activity 界面 + Service + 广播接收器 |
| **ui** | `com.omarea.ui` | **42** | 自定义 View：图表、模糊特效、FPS 监测、充电曲线 |
| **model** | `com.omarea.model` | **27** | 数据模型：CpuStatus、BatteryStatus、ProcessInfo 等 |
| **krscript** | `com.omarea.krscript` | **15** | 脚本引擎模型：ActionNode、PageNode、ShellHandler 等 |
| **scene_mode** | `com.omarea.scene_mode` | **4** | 场景模式切换（通知监听+广播+快捷设置磁贴）|
| **common** | `com.omarea.common` | **4** | 公共 UI 组件（抗锯齿滚动视图、圆形进度条）|
| **xposed** | `com.omarea.xposed` | **2** | Xposed 接口 |
| **data** | `com.omarea.data` | **1** | 数据层（电池广播接收器）|
| **sysmbol** | `com.omarea.sysmbol` | **1** | 渲染性能选项 |

> 详细分析见 [模块分析.md](./模块分析.md)

---

## 关键文件索引

### 入口与配置

| 文件 | 用途 |
|------|------|
| `com.omarea.Scene.java` | 应用入口（Application 类）|
| `vtools/activities/ActivityMain.java` | 主 Activity |
| `vtools/activities/ActivityStartSplash.java` | 启动页 |
| `assets/kr-script.conf` | kr-script 引擎核心配置 |
| `assets/xposed_init` | Xposed 模块注册（→ `XposedInterface`）|

### 核心功能 Activity

| 文件 | 用途 |
|------|------|
| `ActivityCpuControl.java` | CPU 控制 |
| `ActivityChargeControl.java` / `ActivityChargeStat.java` | 充电控制/统计 |
| `ActivityPerfOptions.java` / `ActivityPerfBench.java` | 性能选项/跑分 |
| `ActivityPowerStat.java` / `ActivityPowerBench.java` | 功耗统计/测试 |
| `ActivityFpsSession.java` / `ActivityFpsSessions.java` | FPS 帧率会话 |
| `ActivityFreezeApps.java` | 应用冻结 |
| `ActivityProcess.java` | 进程管理 |
| `ActivitySwap.java` | Swap/ZRam 控制 |
| `ActivityMiuiThermal.java` | MIUI 温控配置 |
| `ActivityAutoClick.java` | 自动点击 |

### 后台服务

| 文件 | 用途 |
|------|------|
| `services/BootService.java` | 开机自启服务 |
| `services/KeepAliveService.java` | 保活服务 |
| `services/CompileService.java` | Dex2oat 编译服务 |
| `ReceiverBoot.java` | 开机广播接收器 |
| `AccessibilitySceneMode.java` | 无障碍服务实现 |
| `scene_mode/NotificationListenerService.java` | 通知监听（场景触发）|

---

## 快速导航

- 想了解**各模块的类清单和功能** → [模块分析.md](./模块分析.md)
- 想了解**kr-script 脚本引擎、Xposed、权限体系等机制** → [架构与技术细节.md](./架构与技术细节.md)
- 想定位**某个具体 Activity/类** → 在 [模块分析.md](./模块分析.md) 的对应章节中搜索
