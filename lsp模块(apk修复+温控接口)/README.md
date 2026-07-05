# LSPosed 模块 — 飞智 B6X 增强计划

> 本目录是 git 子模块的一部分，非独立仓库。git 操作在父目录 `飞智b6x增强计划/` 中执行。

---

## 功能

- **BLE 修复**：修复 Android 16 上飞智散热器开发者工具无法连接的 4 层连环 Bug（[完整修复历程](../参考资料/完整修复历程.md)）
- **广播接口**：接收 `com.flydigi.SET_TEMPERATURE` 广播，将参数转发到 `WaspWingManager.setRunMode()`
- **status 文件心跳 + 散热器全参数回传**：每 5 秒写入 BLE 状态及散热器运行参数到 `/data/local/tmp/tempctrl.status`，供 tempctrl 读取。包含 7 个字段（详见 [status 文件协议](#status-文件协议)）
- **CPU 占用修复**：修复 DefaultDispatcher 线程空队列忙等导致的 100% CPU 占用

---

## 安装

1. 编译或下载 APK
2. 安装到手机（允许未知来源应用）
3. 在 LSPosed 中**启用模块**，作用域勾选 `com.flydigi.waspwing.experimental`
4. **强制停止**目标 App 或重启手机

> 需要 LSPosed ≥ 1.8。

---

## 广播协议

### 接口

```
Action: com.flydigi.SET_TEMPERATURE
```

### 参数

| Extra | 类型 | 说明 |
|-------|------|------|
| `mode` | int | 0=智能温控, 1=固定功率 |
| `temperature` | int | 目标温度 (°C)，智能温控模式 |
| `windOC` | int | 风扇固定转速 (RPM)，固定功率模式 |
| `coldOC` | int | 制冷片强度 (0-194)，固定功率模式 |
| `windLevel` | int | 风扇转速上限 (RPM)，智能温控模式 |
| `modeCustom` | int | 保留（传 0） |
| `extra` | int | 保留（传 0） |

### 示例

```bash
# 智能温控：目标 16°C，风扇上限 4000RPM
am broadcast -a com.flydigi.SET_TEMPERATURE \
    --ei mode 0 --ei temperature 16 --ei windLevel 4000

# 固定功率：风扇 2900RPM，制冷强度 80
am broadcast -a com.flydigi.SET_TEMPERATURE \
    --ei mode 1 --ei windOC 2900 --ei coldOC 80
```

---

## 源码结构

```
app/src/main/
├── AndroidManifest.xml       ← 模块声明 + Xposed 元数据
├── assets/xposed_init        ← Xposed 入口点声明
└── java/.../
    ├── MainHook.java         ← 核心：Xposed 钩子 + 广播接收
    └── (其他辅助类)
```

---

## status 文件协议

模块每 5 秒覆写 `/data/local/tmp/tempctrl.status`，包含 7 个字段供 tempctrl 守护进程解析：

### 写入端（LSPosed 模块 → 文件）

| 行 | 说明 | 来源 | 单位 |
|----|------|------|------|
| `BLE=0/1` | BLE 连接状态 | `onDeviceConnected` / `disconnect` 等事件 | bool |
| `RUN_MODE=` | 散热器当前运行模式 | `WaspWingInfo.getRunMode()` | int（0=固定功率, 1=智能） |
| `HOT_TEMP=` | 热端温度 | `getHotSurfaceTemperature()` byte ×10 | 0.1°C |
| `COLD_TEMP=` | 冷端温度 | `getTemperature()` ×10 + `getTemperatureDecimal()` | 0.1°C |
| `RPM_REAL=` | 实际风扇转速（经超频逻辑折算） | `getRealWindLevel()` | int |
| `COLD_REAL=` | 实际制冷强度（经超频逻辑折算） | `getRealColdLevel()` | int |
| `TARGET_TEMP=` | 散热器目标温度 | `getTargetTemperature()` int ×10 | 0.1°C |

### 解析端（tempctrl `read_status_ble`）

```
BLE=1
RUN_MODE=1
HOT_TEMP=420        ← 42.0°C
COLD_TEMP=58         ← 5.8°C
RPM_REAL=77
COLD_REAL=115
TARGET_TEMP=180     ← 18.0°C
```

### 注意
- 温度字段全部使用 0.1°C 内部单位（C 端 `atoi()` 直接解析，无需浮点）
- `lastWaspWingInfo` 为 `null` 时只输出 `BLE=` 行（模块启动初期或 WaspWingInfo 未就绪）

---

## 编译

**Android Studio**：打开本目录 → Build → Build APK

**命令行**：
```bash
cd lsp模块(apk修复+温控接口)
export ANDROID_HOME=/path/to/Android/Sdk
./gradlew assembleRelease
```

**GitHub Actions**：推送 `v*` 标签或手动触发 workflow_dispatch。

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
