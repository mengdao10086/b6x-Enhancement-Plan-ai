# 飞智 B6X 增强计划 — LSPosed 模块

## 简介

**飞智 B6X 增强计划**是一个为飞智 B6X 散热器开发者工具（`com.flydigi.waspwing.experimental`）提供修复和扩展功能的 LSPosed 模块。

> **代码仓库注意**：本目录（`lsp模块（apk修复+温控接口）/`）是项目的一部分，不是独立仓库。所有 git 操作在父目录 `飞智b6x增强计划/`（git 子模块）中进行。

### 主要功能

| 版本 | 功能 | 状态 |
|------|------|------|
| **v1.0** | 修复 Android 16 (API 36) 上蓝牙扫描生命周期崩溃导致无法连接散热器的问题 | ✅ 已发布 |
| **v2.0** | 智能温控后台守护程序的广播接口 + status 文件心跳检测 + 三重检查存活检测 + BLE 重连状态恢复 | ✅ 已发布 |

---

## 一、修复内容（v1.0）

本模块修复了飞智散热器开发者工具在 **Android 16** 上无法使用的 4 层 Bug：

| 层级 | 问题 | 修复方式 |
|------|------|---------|
| 控制器层 | 设备连接后扫描未停止，影响后续 BLE 操作 | 拦截 `onDeviceConnected` → 调用 `stopScan()` |
| ViewModel 层 | BluetoothViewModel 的 LiveData 未及时更新 | 拦截 `onDeviceConnected` → 手动 postValue |
| UI 层 | 智能温控模式下 UI 闪烁（convertFromDevice 副作用） | 不创建中间态 WaspWingInfo，等正常 BLE 数据流 |
| Android 16 | `checkBluetoothPermission()` 在 BLE 回调线程返回 false，导致 `discoverServices()` 从未被调用 | 强制返回 true |

## 二、智能温控扩展（v2.0）

### 2.1 系统架构

```
 ┌─ 手机 ──────────────────────────────────────────────────┐
 │                                                         │
 │  飞智 App 进程                        Root 进程          │
 │  ┌──────────────────────┐   status 文件  ┌───────────────┐  │
 │  │ LSPosed 模块          │ ◄───心跳───── │ tempctrl      │  │
 │  │                      │  进程存活检测 │ C 守护程序     │  │
 │  │ BLE 连接/断联        │             │ 每 5 秒：     │  │
 │  │ (tempctrl 自行检测   │             │ 读温度→决策→  │  │
 │  │  进程存活)           │             │ 下发指令      │  │
 │  │                      │             │               │  │
 │  │ ←── am broadcast ────│──指令───────│               │  │
 │  │       mode/temp/     │             │               │  │
 │  │       windOC/coldOC  │             └───────────────┘  │
 │  │          ↓                                          │
 │  │  WaspWingManager                                     │
 │  │  .setRunMode(7 params)                              │
 │  │  .setRunMode(7 params)                              │
 │  │          ↓                                          │
 │  │     BLE 指令 → 散热器                                │
 │  └──────────────────────┘                              │
 └────────────────────────────────────────────────────────┘
```

### 2.2 进程检测与控制通信

使用 **双重检查检测**：status 文件 mtime 心跳 + BLE=1 状态。模块每 5 秒写入一次 status 文件，tempctrl 检测 mtime 是否在 16 秒内（已移除 pgrep，模块心跳足以判断存活）：

```
tempctrl 侧（C 守护程序）：
  每轮主循环开头：
    1. 读 /data/local/tmp/tempctrl.status 获取 BLE=0/1
    2. stat(status 文件).mtime 距现在 ≤ 16秒？
    两者都通过才算存活，任一失败即断联
    └─ 断联 → 等待复活（模块+BLE 都恢复才视为复活）
        └─ 恢复后保持当前状态，强制重发当前档位（不重置状态）

模块侧（LSPosed）：
  onDeviceConnected / disconnect 钩子 → 更新 bleConnected 状态
  后台线程每 5 秒：FileOutputStream("/data/local/tmp/tempctrl.status")
    → 写 "BLE=0\n" 或 "BLE=1\n"
  （直接 Java 文件 I/O，不走 su，无 KSU 命名空间问题）
```

**⚠️ 旧版 FIFO 废弃原因**：KernelSU 下 App 进程无权限写 `/data/local/tmp/`，
`Runtime.exec("su", "-c", "echo > fifo")` 在 KSU 中不可靠。改为 status 文件后，
由 daemon（root）创建文件并设 0666 权限，App 进程直接 Java I/O 写入，无权限问题。

### 2.3 档位定义

> 档位映射使用查表法，基于实测数据（`zone核心温度数值对比.xlsx` Sheet2）。

| 档位 | 模式 | 目标温度 | 风扇转速 | 制冷片 | 说明 |
|------|------|---------|---------|--------|------|
| 12 | 固定功率 | — | 6000RPM | 185 | 制冷峰值，紧急4+ |
| 11 | 固定功率 | — | 5500RPM | 175 | |
| 10 | 固定功率 | — | 5000RPM | 160 | 紧急3+ |
| 9 | 固定功率 | — | 4500RPM | 145 | |
| 8 | 固定功率 | — | 4000RPM | 125 | 紧急2+ |
| 7 | 固定功率 | — | 3500RPM | 100 | |
| 6 | 固定功率 | — | 3050RPM | 75 | 紧急1+ |
| 5 | 固定功率 | — | 2650RPM | 55 | LEVEL_INIT |
| 4 | 固定功率 | — | 2300RPM | 35 | |
| 3 | 固定功率 | — | 2000RPM | 20 | |
| 2 | 固定功率 | — | 2000RPM | 10 | |
| 1 | 固定功率 | — | 2000RPM | 5 | α待机 |

**setRunMode 参数映射：**
```
setRunMode(mode, targetTemperature,
           windLevelOverclock, coldLevelOverclock,
           windLevel, modeCustom, extra)
```
- `mode=0`（智能温控）：`targetTemperature` + `windLevel`（风扇转速上限）
- `mode=1`（固定功率）：`windLevelOverclock`（风扇转速）+ `coldLevelOverclock`（制冷片强度）

---

## 三、编译方法

### 3.1 编译 LSPosed 模块

**Android Studio：** 用 Android Studio 打开 `lsp模块（apk修复+温控接口）/` 目录 → Build → Build APK

**命令行：**
```bash
cd lsp模块（apk修复+温控接口）
export ANDROID_HOME=/path/to/Android/Sdk
./gradlew assembleRelease
```

**GitHub Actions：** 推送 tag（`v*`）或手动触发 workflow_dispatch 即可自动编译。

---

## 四、安装与使用

### 4.1 安装模块

1. 编译或下载 APK
2. 安装到手机（允许未知来源应用）
3. 在 LSPosed 中启用模块，作用域勾选 `com.flydigi.waspwing.experimental`
4. 强制停止目标 App 或重启手机

### 4.2 部署 C 守护程序（v2.0）

编译后将 `tempctrl` 放入 Magisk 模块目录，编写 `service.sh` 启动。

### 4.3 Shell 手动测试广播

```bash
# 智能温控：目标 16°C，风扇上限 4000RPM
am broadcast -a com.flydigi.SET_TEMPERATURE \
    --ei mode 0 --ei temperature 16 --ei windLevel 4000

# 固定功率：风扇 2900RPM，制冷 80
am broadcast -a com.flydigi.SET_TEMPERATURE \
    --ei mode 1 --ei windOC 2900 --ei coldOC 80
```

---

## 五、模块文件结构

```
app/
├── src/main/
│   ├── AndroidManifest.xml       ← 模块声明 + Xposed 元数据
│   ├── assets/xposed_init        ← Xposed 入口
│   └── java/.../MainHook.java    ← 核心注入代码（修复 + 广播接收处理）
├── build.gradle.kts
├── settings.gradle.kts
└── gradle/
```

---

## 六、验证

```bash
# 查看模块日志
adb logcat -s WaspWingTempCtrl

# 查看 tempctrl 日志
adb shell cat /cache/tempctrl.log
```

---

## 七、常见问题

**Q: 模块不生效？**
A: 确保 LSPosed ≥ 1.8，模块启用后**强制停止目标 App** 或重启手机。

**Q: 发送广播后温度没变？**
A: 检查① LSPosed 中模块已勾选且作用域正确 ② App BLE 已连接。

**Q: C 守护程序没在运行？**
A: 检查 Magisk 模块的 `service.sh` 是否正确，查看 `/cache/tempctrl.log`。

---

## 八、注意事项 / 已知风险

| 风险 | 说明 |
|------|------|
| `RECEIVER_EXPORTED` 权限 | `am broadcast` 从系统进程发广播，模块需 `RECEIVER_EXPORTED` 才能收到（Android 14+） |
| BLE 重连时序 | `BluetoothGatt.disconnect()` 钩子可能被多次触发（已移除 FIFO，不影响） |
| `convertFromDevice()` 禁用 | 不要调用该方法——它创建全默认值 WaspWingInfo，触发循环导致 UI 闪烁 |
