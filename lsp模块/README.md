# 飞智温控增强 — LSPosed 模块

> 本目录是 git 子模块的一部分，非独立仓库。git 操作在父目录 `飞智b6x增强计划/` 中执行。

---

## 功能

- **内置原生配置界面**：状态 / 配置 · 曲线 / 日志三页（底部页签，左右跟手滑动切页），取代原 WebUI；标题栏右侧设置按钮进入界面参数设置页
- **返回键收后台**：返回键会结束整个任务时把散热器 app 收进后台而不退出（可在设置页关闭）
- **一键部署守护进程**：C 守护程序（`daemon/tempctrl.c`）随 APK 打包，装好 APK 后在状态页一键部署，**无需刷 Magisk 模块**；配置与日志存 APK 私有目录，卸载即清
- **BLE 修复**：修复 Android 16 上飞智散热器工具（B6X + B7X）无法连接的 4 层连环 Bug（[完整修复历程](../参考资料/完整修复历程.md)）
- **双设备支持**：自动检测包名选择 B6X 老 app（`com.flydigi.waspwing.experimental`）、B6X 新 app（`com.flydigi.waspwing.experimentanliuliu`）或 B7X（`com.fdg.flashplay.farsef`）钩子集，B7X WaspWingManager 混淆名 `t9.j` 自动 fallback
- **双广播接口**：接收 `com.flydigi.SET_TEMPERATURE`（B6X）或 `com.flydigi.SET_TEMPERATURE_B7`（B7X）广播，将参数转发到对应 SDK 的 `setRunMode()`
- **双 status 文件心跳**：每 1 秒写入 BLE 状态及散热器运行参数到 `/data/local/tmp/tempctrl_b6x.status` / `tempctrl_b7x.status`，含 `CONNECTED_AT` 时间戳供仲裁
- **CPU 占用修复**：修复 DefaultDispatcher 线程空队列忙等导致的 100% CPU 占用
- **上次设备持久化 + 启动自动连接**：连接时保存散热器 MAC，app 冷启动后自动恢复并重连，无需手动点"开始设置"；配合守护进程自动拉起（`b6x_auto_launch` 标志）实现拉起即连、自动后台化
- **锁死自愈**：修复 B6X 重连后散热器不再响应控制命令——下发前校验 static controller 的 gatt 有效性并自动重新同步到有效实例；连续 3 次参数下发后回传仍停滞且 ≠ 目标时自动强制重连。另覆盖"命令消费协程崩溃"场景：命令队列堆积时启动守护线程接管消费，重连无法恢复也能自愈。详见 [CHANGELOG.md](../CHANGELOG.md)

---

## 安装

1. 编译或下载 APK
2. 安装到手机（允许未知来源应用）
3. 在 LSPosed 中**启用模块**，作用域勾选 `com.flydigi.waspwing.experimental` 和 `com.flydigi.waspwing.experimentanliuliu`（B6X 两个 app）以及 `com.fdg.flashplay.farsef`（B7X）
4. **强制停止**目标 App 或重启手机

> 需要 LSPosed ≥ 1.8。

---

## 广播协议

### 接口

| 设备 | Action |
|------|--------|
| B6X | `com.flydigi.SET_TEMPERATURE` |
| B7X | `com.flydigi.SET_TEMPERATURE_B7` |

> 模块自动根据 `deviceType`（由 `handleLoadPackage` 的包名判断）选择对应 Action。两个 Action 参数格式相同。

### 参数

| Extra | 类型 | 说明 |
|-------|------|------|
| `mode` | int | 0=智能温控, 1=固定功率 |
| `temperature` | int | 目标温度 (°C)，智能温控模式 |
| `windOC` | int | 风扇固定转速 (RPM)，固定功率模式 |
| `coldOC` | int | 制冷片强度（B6X: 0-194, B7X: 0-255），固定功率模式。194=SDK/硬件上限，190=温控默认下发上限（`PID_COLD_RANGE` 可调） |
| `windLevel` | int | 风扇转速上限 (RPM)，智能温控模式 |
| `modeCustom` | int | 保留（传 0） |
| `extra` | int | 保留（传 0） |

> ⚠️ **编码注意**：下发 `mode`（0=智能温控 / 1=固定功率）与设备回传的 `RUN_MODE`（0=固定功率 / 1=智能）**编码相反**，解析/比对时勿混淆。

```bash
# B6X 智能温控：目标 16°C，风扇上限 4000RPM
am broadcast -a com.flydigi.SET_TEMPERATURE \
    --ei mode 0 --ei temperature 16 --ei windLevel 4000

# B7X 固定功率：风扇 6000RPM，制冷强度 200
am broadcast -a com.flydigi.SET_TEMPERATURE_B7 \
    --ei mode 1 --ei windOC 6000 --ei coldOC 200
```

---

## 源码结构

本模块分两部分：`app/`（Android 工程：Xposed 钩子 + 原生配置界面）与 `daemon/`（C 守护程序源码与构建脚本，CI 编译后注入 `app/src/main/assets/tempctrl-arm64`）。

> 目录与文件的权威清单见仓库根 [CLAUDE.md](../CLAUDE.md) 的「关键文件索引」表（全仓库以该表为准）；
> 架构、进程协作与各文件落点见仓库根 [逻辑说明.md](../逻辑说明.md)。

---

## status 文件协议

模块每 1 秒覆写两个 status 文件，按设备类型选路径：

| 设备 | 路径 |
|------|------|
| B6X | `/data/local/tmp/tempctrl_b6x.status` |
| B7X | `/data/local/tmp/tempctrl_b7x.status` |

每个文件包含以下字段供 tempctrl 守护进程解析：

### 写入端（LSPosed 模块 → 文件）

| 行 | 说明 | 来源 | 单位 |
|----|------|------|------|
| `BLE=0/1/2/6/7` | BLE 状态与连接者编码：0=未连接；B6X 文件 1=老 app / 2=新 app；B7X 文件 6/7=实际连接的散热器型号（B7X app 连 B6X 型号设备时=6） | `bleOwnerCode()`（B6X 按包名 1/2；B7X 按 `connectedModel` 6/7） | int |
| `CONNECTED_AT=` | 连接时间戳（Unix 秒），供"先连者优先"仲裁；断连保留、重连刷新 | `System.currentTimeMillis()/1000` | Unix timestamp |
| `BLE_OWNER_LAST=<值> <时间>` | 上次连接者（1/2/6/7）+ 连接时间（Unix 秒）；连接时更新、断连保留、型号修正时同步值 | `bleLastOwner` + `bleLastOwnerAt` | int int |
| `RUN_MODE=` | 散热器当前运行模式 | `WaspWingInfo.getRunMode()` | int（0=固定功率, 1=智能） |
| `HOT_TEMP=` | 热端温度 | `getHotSurfaceTemperature()` byte ×10 | 0.1°C |
| `COLD_TEMP=` | 冷端温度 | `getTemperature()` ×10 + `getTemperatureDecimal()` | 0.1°C |
| `RPM_REAL=` | 实际风扇转速（经超频逻辑折算） | `getRealWindLevel()` | int |
| `COLD_REAL=` | 实际制冷强度（经超频逻辑折算） | `getRealColdLevel()` | int |
| `TARGET_TEMP=` | 散热器目标温度 | `getTargetTemperature()` int ×10 | 0.1°C |

### 解析端（tempctrl `read_status_ble_both` → `select_active_device`）

```
BLE=1
CONNECTED_AT=1823456789
RUN_MODE=1
HOT_TEMP=420        ← 42.0°C
COLD_TEMP=58         ← 5.8°C
RPM_REAL=77
COLD_REAL=115
TARGET_TEMP=180     ← 18.0°C
```

### 注意
- 温度字段全部使用 0.1°C 内部单位（C 端 `atoi()` 直接解析，无需浮点）
- `lastWaspWingInfo` 为 `null` 时只输出 `BLE=` + `CONNECTED_AT=` + `BLE_OWNER_LAST=` 行（模块启动初期或 WaspWingInfo 未就绪）
- 文件名区分设备；文件内部 `BLE=` 按设备编码：B6X 文件 1/2（区分两个 app），B7X 文件 6/7（实际散热器型号），断连统一为 0

---

## 界面开关文件协议（daemon → 钩子）

`UI_BACK_HIDE`（「返回退出自动隐藏后台」，设置页可关）是唯一需要送达宿主编进程的界面开关。
界面与钩子分属两个进程、不共享内存，故由 daemon 转写成一行标志文件，钩子每次返回键读一次：

| 项 | 值 |
|---|---|
| 路径 | `/data/local/tmp/tempctrl_uiprefs` |
| 内容 | `BACK_HIDE=0/1`（换行结尾；`.tmp` + `rename` 原子替换） |
| 写入方 | tempctrl daemon（root），每次配置重载时按需写（值未变不写） |
| 读取方 | `MainHook.readBackHideEnabled()`（宿主 app 进程），**读不到按 1（开启）处理** |

> 方向与 status 文件相反：status 是「钩子写、daemon 读」，本文件是「daemon 写、钩子读」。

---

## 编译

**Android Studio**：打开本目录 → Build → Build APK

**命令行**：
```bash
cd lsp模块
export ANDROID_HOME=/path/to/Android/Sdk
./gradlew assembleRelease
```

> 本地构建出的 APK 内**不含** `assets/tempctrl-arm64`（C 二进制由 CI 编译后注入），
> 部署时 `Deployer.probe()` 会如实报「APK 内资源不完整」。

**GitHub Actions**：推送 `v*` 标签或手动触发 workflow_dispatch。产物名 `b6x-EP-v<versionName>.apk`。

---

## 验证

```bash
adb logcat -s WaspWingTempCtrl
```

---

## 注意事项

| 风险 | 说明 |
|------|------|
| `RECEIVER_EXPORTED` | `am broadcast` 从系统进程发广播，模块需 `RECEIVER_EXPORTED` 才能在 Android 14+ 收到 |
| `convertFromDevice()` | 不要调用该方法——它创建全默认值 WaspWingInfo，触发状态循环导致 UI 闪烁 |
| catch(Throwable) | `NoSuchMethodError` 继承自 `Error` 而非 `Exception`，所有外层 try 块必须用 `Throwable` 捕获 |

---

## 常见问题

**Q: 模块不生效？**
A: 确保 LSPosed ≥ 1.8，模块启用后**强制停止目标 App** 或重启手机。

**Q: 发送广播后温度没变化？**
A: 检查：① LSPosed 中模块已勾选且作用域正确；② App BLE 已连接。
