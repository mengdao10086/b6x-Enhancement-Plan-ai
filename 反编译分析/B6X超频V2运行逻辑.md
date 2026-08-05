# B6X 超频工具 V2 — App 运行逻辑分析

> 来源：`参考资料/decompile/b6_overclock_v2/`（baksmali 反编译，7,232 个 smali，未加固）
> 对应 APK：`参考资料/apk_original/B6 B6X 超频工具 V2.apk`
> 分析日期：2026-08-02

---

## 一、App 总览

**功能定位**：飞智 B6X 超频工具的 V2 版本——通过蓝牙控制飞智散热器/手柄，重点是**制冷（冷 PWM）与温度调节的超频实验模式**。

**技术栈**（从 smali 推断）：
- Kotlin + AndroidX，MVVM 架构（DataBinding + ViewModel + LiveData）
- 依赖飞智官方 SDK `com.flydigi.sdk.waspwing`（WaspWing 系列设备）
- 工具库 `com.blankj.utilcode`（工具集合）、`com.permissionx`（权限）

**包结构**（业务代码极简，逻辑几乎全在 SDK）：
```
com.example.extool/
├── App                      Application 入口
├── MainActivity             启动引导页
├── B6ExperimentalActivity   主功能界面（实验模式）
├── BluetoothViewModel       抽象父类：蓝牙扫描/连接/状态
├── WaspWingViewModel        核心 ViewModel：设备控制
└── databinding/             生成的绑定类
```

## 二、启动流程

```
App.onCreate
  └─ Utils.init(context)                         // blankj 工具库初始化
  └─ WaspWingManager.init(context, DeviceFilter, true)
       // 初始化飞智 SDK，注册设备过滤器；第三个参数 true 推测为自动连接/调试相关

MainActivity（引导页）
  ├─ onCreate → 绑定 btn_setup 按钮
  └─ 点击按钮（Android 11+ 先请求 BLUETOOTH_CONNECT + BLUETOOTH_SCAN 权限）
      └─ showDetail() → startActivity(B6ExperimentalActivity)

B6ExperimentalActivity（主界面）
  ├─ viewModels{} 惰性创建 WaspWingViewModel
  ├─ DataBinding 绑定 ActivityExperimentalB6Binding
  └─ onResume 观察 waspWingInfo / 蓝牙状态等 LiveData → 刷新 UI
```

## 三、核心架构：ViewModel 与 SDK 委托

**WaspWingViewModel**（1040 行 smali）是唯一的业务大脑：

```
WaspWingViewModel
  extends BluetoothViewModel            // 蓝牙通用逻辑
  implements WaspWingGattCallback       // 设备 GATT 回调
```

**数据流**（单向，LiveData 驱动 UI）：
- 设备上报 → SDK 回调 `onDeviceInfoUpdate(WaspWingInfo)` → `postValue` 到 `_waspWingInfo` → UI 观察 `waspWingInfo` 刷新
- 用户操作 → UI 事件 → ViewModel 方法 → 调用 `WaspWingManager` 下发指令

**关键参数范围**（static 常量）：

| 常量 | 值 | 含义 |
|---|---|---|
| `COLD_ADJUST_MIN/MAX` | 0 / 300 (0x12c) | 制冷档位范围 |
| `TEMPERATURE_ADJUST_MIN/MAX` | 1 / 35 (0x23) | 目标温度范围（°C） |
| `WIND_ADJUST_MIN/MAX` | 2000 (0x7d0) / 8000 (0x1f40) | 风速 PWM 范围 |

## 四、设备控制逻辑

所有控制指令都经 `WaspWingManager`（SDK 单例）下发，核心入口是 `setRunMode`。从 smali 调用点可还原出掩码协议：

```
WaspWingManager.setRunMode(
    runMode,           // 运行模式
    targetTemperature, // 目标温度
    ...,               // 若干占位参数（0）
    coldLevel/windLevel, // 档位值
    ...,               // 占位
    mask,              // 更新掩码：0x5c=制冷 0x7c=温度 0x6c=风速
    ...)
```

**功能 → 方法 → 掩码对照**：

| UI 操作 | ViewModel 方法 | 掩码 | 生效字段 | 边界检查 |
|---|---|---|---|---|
| 制冷 +/- | `upColdPwm` / `downColdPwm` | 0x5c | realColdLevel ±1 | [0, 300] |
| 风速 +/- | `upWindPwm` / `downWindPwm` | 0x6c | realWindLevel ±1 | 下界 2000；**上界实际限 6000**（0x1770，与 WIND_ADJUST_MAX=8000 不一致，疑似 UI 分级限制） |
| 温度 +/- | `upTargetTemperature` / `downTargetTemperature` | 0x7c | targetTemperature ±1 | [1, 35]，下界 5 时停止 |
| 拖动设置制冷 | `updateColdPwm(value, fromUser)` | 0x5c | 直接设为 value | fromUser=true 才下发 |
| 拖动设置风速 | `updateWindPwm(value, fromUser)` | 0x6c | 直接设为 value | 同上 |
| 默认温度 | `updateDefaultTemperature(value, fromUser)` | 0x7c | 直接设为 value | 同上 |
| 模式选择 | `updateDefaultMode(checkedId, isChecked)` | 0x7c | checkedId==某id→runMode=0，否则 2；温度取当前或默认 10 | isChecked=true 才下发 |
| LED 开关 | `switchLed(state)` | — | `setLightOn()` / `setLightOff()` | 直接切换 |

## 五、实验模式（超频核心）

`enableExperimentalMode(enabled)` 是 V2 的核心能力：

```
setExperimentalRunMode(
    enabled,         // 开关
    coldLevel + 1,   // 实验档位 = 制冷档位 + 1（超一档）
    null, ...)
```

**自动同步机制**：`onDeviceInfoUpdate` 里设备回报 `experimentalRunModeValue` 后，若该值与 `realColdLevel + 1` 不一致，**自动重新下发** `setExperimentalRunMode(1, realColdLevel + 1)`——保证实验模式在设备端持续生效。

**逆向要点**：实验模式的本质是把制冷档位推高 1 档（突破正常 UI 上限）。这对 b6x 增强计划的启示：正常档位上限 300 被 SDK 或固件限制，实验模式是解锁更高制冷的开关。

## 六、BLE 通信（SDK 封装层）

- **扫描**：`WaspWingManager.startScan(topActivity, 2)`（参数 2 推测为扫描类型）；扫描回调由父类 `BluetoothViewModel`（implements `ScanDeviceCallback`）处理，`onDeviceFound` 提供设备列表
- **连接**：`connectGattWith(device)` / `disconnect()`，父类实现 `ConnectionStateCallback` / `BluetoothStateCallback`
- **GATT 回调**：`WaspWingGattCallback` 的大部分方法委托 SDK 默认实现（DefaultImpls），仅 `onDeviceInfoUpdate`（状态上报）和 `onDeviceDisconnected`（断连清零）有自定义逻辑
- **协议细节**：指令格式、服务 UUID、数据包解析**全部封装在 SDK 内部**（`com/flydigi/sdk/waspwing`），静态反编译只能看到调用点。如需协议级分析，需反编译 SDK 源码或抓包 BLE

## 七、断连处理

`onDeviceDisconnected`：将 `WaspWingInfo` 全字段置空（copy 默认值）后 `postValue`，UI 回到未连接状态。

---

## 附：与 b6_devtool（散热器开发者工具）的对比

两 app 同源（同架构、同 SDK、同 `B6ExperimentalActivity` 命名）：
- `飞智散热器开发者工具运行逻辑.md` 已覆盖 b6_devtool 的 BLE 四层修复流程（见 `完整修复历程.md`）
- 本 V2 版聚焦**实验模式超频**，是 b6x 增强计划的直接研究标的

> 注：B8X 超频工具 V2 为加固 APK，无法静态分析，见 [B8X加固壳层分析.md](B8X加固壳层分析.md)。
