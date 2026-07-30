package com.example.waspwingtempctrl;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import java.io.FileOutputStream;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Iterator;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * 飞智散热器 — LSPosed 模块
 *
 * 修复（v1.0）：
 * 1. 控制器层 stopScan 保底
 * 2. ViewModel 层：更新 LiveData，但不创建中间态 WaspWingInfo（避免干扰正常数据流）
 * 3. 强制 checkBluetoothPermission=true（Android 16 权限导致 discoverServices 不走）
 *
 * 智能温控唤醒（v2.0）：
 * 4. BLE 连接/断联 → 通过 FIFO 通知 tempctrl 守护进程
 * 5. B6ExperimentalActivity.onResume → 检查 BLE 状态 → 唤醒守护进程
 */
public class MainHook implements IXposedHookLoadPackage {

    // ========== 多设备支持（v2.5） ==========
    private static final String PACKAGE_B6X = "com.flydigi.waspwing.experimental";
    private static final String PACKAGE_B7X = "com.fdg.flashplay.farsef";
    private static final String TAG = "[WaspWingTempCtrl]";
    // 双文件路径
    private static final String STATUS_FILE_B6 = "/data/local/tmp/tempctrl_b6x.status";
    private static final String STATUS_FILE_B7 = "/data/local/tmp/tempctrl_b7x.status";

    private static Object capturedWaspWingMgr = null;  // 构造函数钩子捕获的实例
    private static int lastSetMode = 0;     // 上次 setRunMode 的 mode
    private static int lastSetColdOC = 0;   // 上次固定功率的 coldOC
    private static int deviceType = 0;      // 0=无连接, 6=B6X, 7=B7X
    private static boolean bleConnected = false;  // BLE 连接状态（供写 status 文件）
    private static long bleConnectedTimestamp = 0; // 连接 Unix 时间戳（CONNECTED_AT）
    private static String currentStatusFile = STATUS_FILE_B6; // 当前选中的 status 文件
    private static Object lastWaspWingInfo = null;  // 散热器全参数回传（v2.3）

    // ========== 后台自动重连（v2.4） ==========
    private static BluetoothDevice lastDevice = null;      // 上次连接的 BLE 设备
    private static ClassLoader appClassLoader = null;      // App 类加载器（后台线程反射用）

    // ========== 智能温控广播接收器（v2.0） ==========
    // 接收 tempctrl 发送的 am broadcast，调用 setRunMode 控制散热器

    private static void registerTemperatureReceiver(Context ctx) {
        try {
            // B6X 用原有 Action，B7X 用新 Action
            String action = (deviceType == 7)
                ? "com.flydigi.SET_TEMPERATURE_B7"
                : "com.flydigi.SET_TEMPERATURE";
            IntentFilter filter = new IntentFilter(action);
            ctx.registerReceiver(new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    try {
                        int mode        = intent.getIntExtra("mode", 0);
                        int temperature = intent.getIntExtra("temperature", 20);
                        int windOC      = intent.getIntExtra("windOC", 0);
                        int coldOC      = intent.getIntExtra("coldOC", 0);
                        int windLevel   = intent.getIntExtra("windLevel", 0);
                        int modeCustom  = intent.getIntExtra("modeCustom", 0);
                        int extra       = intent.getIntExtra("extra", 0);

                        XposedBridge.log(TAG + " 收到广播 mode=" + mode
                                + " temp=" + temperature + " windOC=" + windOC
                                + " coldOC=" + coldOC + " windLv=" + windLevel);

                        // 调用 setRunMode——优先用构造函数捕获的实例，其次试单例
                        try {
                            Object inst = capturedWaspWingMgr;
                            if (inst == null) {
                                // 构造函数还没触发过，试单例方式兜底
                                Class<?> mgrCls = context.getClassLoader()
                                        .loadClass("com.flydigi.sdk.waspwing.WaspWingManager");
                                String[] methods = {"getInstance", "get", "getDefault"};
                                for (String m : methods) {
                                    try {
                                        inst = XposedHelpers.callStaticMethod(mgrCls, m);
                                        if (inst != null) break;
                                    } catch (Throwable t) { /* next */ }
                                }
                                if (inst == null) {
                                    try {
                                        // Kotlin object singleton: ClassName.INSTANCE
                                        inst = XposedHelpers.getStaticObjectField(mgrCls, "INSTANCE");
                                    } catch (Throwable t) { /* ok */ }
                                }
                            }

                            if (inst != null) {
                                // 记录本次 mode 值，用于 onDeviceInfoUpdate 中修正 UI 闪烁
                                lastSetMode = mode;
                                lastSetColdOC = coldOC;

                                XposedHelpers.callMethod(inst, "setRunMode",
                                        mode, temperature, windOC, coldOC,
                                        windLevel, modeCustom, extra);
                            } else {
                                XposedBridge.log(TAG + " setRunMode 失败: WaspWingManager 实例未就绪");
                            }
                        } catch (Throwable t) {
                            XposedBridge.log(TAG + " setRunMode 异常: " + t.getMessage());
                        }
                    } catch (Throwable t) {
                        XposedBridge.log(TAG + " 广播处理崩溃: " + t);
                    }
                }
            }, filter, Context.RECEIVER_EXPORTED);
            XposedBridge.log(TAG + " 已注册 SET_TEMPERATURE 广播接收器 (RECEIVER_EXPORTED)");
        } catch (Exception e) {
            XposedBridge.log(TAG + " 注册广播接收器失败: " + e.getMessage());
        }
    }

    // ========== 双文件状态写入（v2.5） ==========
    // 根据 deviceType 写入对应文件：/data/local/tmp/tempctrl_b6x.status 或 _b7x.status
    // tempctrl 通过 stat() 检查文件 mtime 判断进程存活
    private static void writeStatusFile() {
        try {
            FileOutputStream fos = new FileOutputStream(currentStatusFile);
            StringBuilder sb = new StringBuilder();
            sb.append("BLE=").append(bleConnected ? "1" : "0").append("\n");
            sb.append("CONNECTED_AT=").append(bleConnectedTimestamp).append("\n");

            // v2.3：散热器全参数回传
            try {
                if (lastWaspWingInfo != null) {
                    // 运行模式：getRunMode() → int，0=固定功率(手动), 1=智能
                    Object runMode = XposedHelpers.callMethod(lastWaspWingInfo, "getRunMode");
                    if (runMode != null)
                        sb.append("RUN_MODE=").append(runMode).append("\n");

                    // 热端温度：getHotSurfaceTemperature() → byte(°C) → 0.1°C
                    Object hot = XposedHelpers.callMethod(lastWaspWingInfo, "getHotSurfaceTemperature");
                    if (hot != null)
                        sb.append("HOT_TEMP=").append(((Number)hot).intValue() * 10).append("\n");

                    // 冷端温度：getTemperature()(整数°C) + getTemperatureDecimal()(小数位) → 0.1°C
                    Object cold = XposedHelpers.callMethod(lastWaspWingInfo, "getTemperature");
                    Object coldDec = XposedHelpers.callMethod(lastWaspWingInfo, "getTemperatureDecimal");
                    if (cold != null && coldDec != null) {
                        int c = (Integer)cold;
                        int d = (Integer)coldDec;
                        if (d >= 10) d = (d + 5) / 10;  // 多位小数 → 四舍五入到 0.1°C
                        sb.append("COLD_TEMP=").append(c * 10 + d).append("\n");
                    }

                    // 实际风扇转速（经超频逻辑折算）：getRealWindLevel()
                    Object rpmReal = XposedHelpers.callMethod(lastWaspWingInfo, "getRealWindLevel");
                    if (rpmReal != null)
                        sb.append("RPM_REAL=").append(rpmReal).append("\n");

                    // 实际制冷强度（经超频逻辑折算）：getRealColdLevel()
                    Object coldReal = XposedHelpers.callMethod(lastWaspWingInfo, "getRealColdLevel");
                    if (coldReal != null)
                        sb.append("COLD_REAL=").append(coldReal).append("\n");

                    // 目标温度：getTargetTemperature() → int(°C) → 0.1°C
                    Object tgtTemp = XposedHelpers.callMethod(lastWaspWingInfo, "getTargetTemperature");
                    if (tgtTemp != null)
                        sb.append("TARGET_TEMP=").append(((Integer)tgtTemp) * 10).append("\n");
                }
            } catch (Throwable t) {
                XposedBridge.log(TAG + " 参数回传异常: " + t.getMessage());
            }

            fos.write(sb.toString().getBytes());
            fos.close();
        } catch (Exception e) {
            XposedBridge.log(TAG + " 写入状态文件失败: " + e.getMessage());
        }
    }

    private static void startPeriodicStatusWrite() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    writeStatusFile();

                    // ═══ 后台自动重连（v2.4） ═══
                    // BLE 断连后立即尝试重连（通过 SDK 自身重连通道）
                    if (!bleConnected && lastDevice != null) {
                        try {
                            Class<?> mgrCls = XposedHelpers.findClass(
                                    "com.flydigi.sdk.waspwing.WaspWingManager", appClassLoader);
                            XposedHelpers.callStaticMethod(mgrCls, "connectGattWith", lastDevice);
                            XposedBridge.log(TAG + " 后台重连尝试 -> " + lastDevice.getAddress());
                        } catch (Throwable t2) {
                            XposedBridge.log(TAG + " 后台重连失败: " + t2.getMessage());
                            // connectGattWith 可能会因内部状态抛异常，静默跳过等下一周期
                        }
                    }

                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    break;
                } catch (Exception e) {
                    XposedBridge.log(TAG + " 状态写入异常: " + e.getMessage());
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        XposedBridge.log(TAG + " LoadPackage: " + lpparam.packageName);

        // 判断设备类型
        if (lpparam.packageName.equals(PACKAGE_B6X)) {
            deviceType = 6;
            currentStatusFile = STATUS_FILE_B6;
        } else if (lpparam.packageName.equals(PACKAGE_B7X)) {
            deviceType = 7;
            currentStatusFile = STATUS_FILE_B7;
        } else {
            XposedBridge.log(TAG + " 跳过非目标包: " + lpparam.packageName);
            return;
        }

        XposedBridge.log(TAG + " 模块已加载到 " + lpparam.packageName
                + " (deviceType=" + deviceType + ")");
        appClassLoader = lpparam.classLoader;  // 保存类加载器供后台重连线程使用

        // ========== 修复 #1：控制器层 — 设备连接后停扫描 ==========
        // 两设备共用：AbstractBluetoothController 类名保留
        try {
            Class<?> controllerClass = lpparam.classLoader.loadClass(
                    "com.flydigi.sdk.bluetooth.AbstractBluetoothController");

            XposedHelpers.findAndHookMethod(
                    controllerClass,
                    "onDeviceConnected",
                    BluetoothDevice.class,
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            try {
                                Object controller = param.thisObject;
                                XposedHelpers.callMethod(controller, "stopScan");
                                XposedHelpers.setBooleanField(controller, "inScanning", false);
                                bleConnected = true;
                                bleConnectedTimestamp = System.currentTimeMillis() / 1000L;
                                XposedBridge.log(TAG + " 控制器：扫描已停止，" + getDeviceLabel() + " BLE 已连接");
                            } catch (Exception e) {
                                XposedBridge.log(TAG + " 控制器修复异常: " + e.getMessage());
                            }
                        }
                    }
            );
            XposedBridge.log(TAG + " 已钩住 AbstractBluetoothController.onDeviceConnected");
        } catch (Exception e) {
            XposedBridge.log(TAG + " 钩控制器失败: " + e.getMessage());
        }

        // ========== 修复 #2（仅 B6X）：ViewModel 层 — 连接后更新 UI LiveData ==========
        if (deviceType == 6) {
            try {
                Class<?> btVmClass = lpparam.classLoader.loadClass(
                        "com.example.extool.BluetoothViewModel");

            XposedHelpers.findAndHookMethod(
                    btVmClass,
                    "onDeviceConnected",
                    BluetoothDevice.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            try {
                                BluetoothDevice device = (BluetoothDevice) param.args[0];
                                Object vm = param.thisObject;

                                // 停止扫描
                                XposedHelpers.callMethod(vm, "stopScan");

                                if (device != null) {
                                    String name = device.getName();
                                    String addr = device.getAddress();

                                    // 更新基础 LiveData
                                    Object nameMd = XposedHelpers.getObjectField(
                                            vm, "_bluetoothNameLiveData");
                                    XposedHelpers.callMethod(nameMd, "postValue", name);

                                    Object macMd = XposedHelpers.getObjectField(
                                            vm, "_macLiveData");
                                    XposedHelpers.callMethod(macMd, "postValue", addr);

                                    Object connMd = XposedHelpers.getObjectField(
                                            vm, "_connectLiveData");
                                    XposedHelpers.callMethod(connMd, "postValue", true);

                                    // === _waspWingInfo：如有现有值则标记 connected=true ===
                                    // 注意：不要用 convertFromDevice 创建新实例！
                                    // 原因：convertFromDevice 创建的 WaspWingInfo 所有字段为默认值，
                                    // 其中 experimentalRunModeValue=null，会触发 App.onDeviceInfoUpdate
                                    // 里的 setExperimentalRunMode(true, coldLevel+1) 逻辑，导致
                                    // 状态循环和 UI 闪烁。让正常 GATT 数据流填充即可。
                                    try {
                                        Object waspInfoMd = XposedHelpers.getObjectField(
                                                vm, "_waspWingInfo");
                                        Object currentInfo = XposedHelpers.callMethod(
                                                waspInfoMd, "getValue");

                                        if (currentInfo != null) {
                                            XposedHelpers.callMethod(
                                                    currentInfo, "setConnected", true);
                                            XposedHelpers.callMethod(
                                                    waspInfoMd, "postValue", currentInfo);
                                            XposedBridge.log(TAG + " waspWingInfo 已更新 (connected=true)");
                                        }
                                        // currentInfo == null：不创建新对象，等正常数据流填充
                                    } catch (Exception e2) {
                                        XposedBridge.log(TAG + " 更新 waspWingInfo 失败: "
                                                + e2.getMessage());
                                    }
                                }

                                XposedBridge.log(TAG + " ViewModel 修复完成");
                            } catch (Exception e) {
                                XposedBridge.log(TAG + " ViewModel 修复异常: " + e.getMessage());
                            }
                        }
                    }
            );

            XposedBridge.log(TAG + " 已钩住 BluetoothViewModel.onDeviceConnected");
        } catch (Exception e) {
            XposedBridge.log(TAG + " 钩 BluetoothViewModel 失败: " + e.getMessage());
        }
        } // end if (deviceType == 6)

        // ========== B6X 专属：修复 #3（权限）+ 诊断钩子 ==========
        if (deviceType == 6) {
        try {
            Class<?> sdkVm = lpparam.classLoader.loadClass(
                    "com.flydigi.sdk.waspwing.WaspwingViewModel");
            Class<?> waspInfoCls = lpparam.classLoader.loadClass(
                    "com.flydigi.sdk.waspwing.WaspWingInfo");
            Class<?> leCtrl = lpparam.classLoader.loadClass(
                    "com.flydigi.sdk.bluetooth.LeDataInteractionController");
            Class<?> wingCtrl = lpparam.classLoader.loadClass(
                    "com.flydigi.sdk.waspwing.WaspWingDataInteractionController");
            Class<?> appVm = lpparam.classLoader.loadClass(
                    "com.example.extool.WaspWingViewModel");

            // ===== 修复 #4：强制 checkBluetoothPermission 返回 true（Android 16 权限问题） =====
            // 根因：Android 16 (SDK 36) 上，SDK 内部检查 BLUETOOTH_CONNECT 权限可能失败
            // 导致 onGattConnected() 提前 return，discoverServices() 从未被执行
            XposedHelpers.findAndHookMethod(leCtrl, "checkBluetoothPermission",
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            param.setResult(true);
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 checkBluetoothPermission（强制返回 true）");

            // ===== BLE 断联检测 =====
            XposedHelpers.findAndHookMethod(
                    BluetoothGatt.class, "disconnect",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            bleConnected = false;
                            // 保存设备引用供后台重连
                            BluetoothGatt gatt = (BluetoothGatt) param.thisObject;
                            if (gatt != null && gatt.getDevice() != null) {
                                lastDevice = gatt.getDevice();
                            }
                            XposedBridge.log(TAG + " BLE 断联"
                                    + " device=" + (lastDevice != null ? lastDevice.getAddress() : "null"));
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 BluetoothGatt.disconnect（状态标记）");

            // ===== 诊断钩子（调试用，保留） =====

            // 诊断 0：BluetoothGatt.discoverServices() — 验证是否被调用
            XposedHelpers.findAndHookMethod(
                    BluetoothGatt.class, "discoverServices",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            BluetoothGatt gatt = (BluetoothGatt) param.thisObject;
                            String devName = gatt.getDevice() != null
                                    ? gatt.getDevice().getName() : "null";
                            XposedBridge.log(TAG + " [诊断] discoverServices 被调用"
                                    + " device=" + devName);
                        }
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            boolean result = (Boolean) param.getResult();
                            XposedBridge.log(TAG + " [诊断] discoverServices 返回 " + result);
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 BluetoothGatt.discoverServices");

            // 诊断 3a：LeDataInteractionController.connect() — 是否实际执行 connectGatt
            XposedHelpers.findAndHookMethod(leCtrl, "connect",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            Object ctrl = param.thisObject;
                            Object dev = XposedHelpers.callMethod(ctrl, "getMBluetoothDevice");
                            int state = XposedHelpers.getIntField(ctrl, "mDataConnectState");
                            XposedBridge.log(TAG + " [诊断] connect() 进入"
                                    + " device=" + (dev != null ? dev.toString() : "null")
                                    + " state=" + state);
                        }
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            Object ctrl = param.thisObject;
                            Object gatt = XposedHelpers.getObjectField(ctrl, "mBluetoothGatt");
                            XposedBridge.log(TAG + " [诊断] connect() 退出"
                                    + " gatt=" + (gatt != null ? "有值" : "null"));
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 LeDataInteractionController.connect");

            // 诊断 3b：GattCallback 服务发现 — 是否完成
            Class<?> gattCb = lpparam.classLoader.loadClass(
                    "com.flydigi.sdk.bluetooth.LeDataInteractionController$mGattCallback$1");
            XposedHelpers.findAndHookMethod(gattCb, "onServicesDiscovered",
                    BluetoothGatt.class, int.class, new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            XposedBridge.log(TAG + " [诊断] onServicesDiscovered 被调用了"
                                    + " status=" + param.args[1]);
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 GattCallback.onServicesDiscovered");

            // 远程 BLE 断联检测（散热器超出范围/关机/蓝牙异常断开时的回调）
            XposedHelpers.findAndHookMethod(gattCb, "onConnectionStateChange",
                    BluetoothGatt.class, int.class, int.class, new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            int newState = (int) param.args[2];
                            if (newState == 0) {  // BluetoothProfile.STATE_DISCONNECTED
                                bleConnected = false;
                                BluetoothGatt gatt = (BluetoothGatt) param.args[0];
                                if (gatt != null && gatt.getDevice() != null) {
                                    lastDevice = gatt.getDevice();
                                }
                                XposedBridge.log(TAG + " BLE 断联（onConnectionStateChange）"
                                        + " device=" + (lastDevice != null ? lastDevice.getAddress() : "null"));
                            }
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 GattCallback.onConnectionStateChange（远程断联检测）");

            // 诊断 3d：WaspWingDataInteractionController.onGattConnected — GATT 连接成功
            // 同时用于修复 BLE 断联后重连时 bleConnected 未恢复的问题
            XposedHelpers.findAndHookMethod(wingCtrl, "onGattConnected",
                    BluetoothGatt.class, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            bleConnected = true;  // 重连后恢复 BLE 状态
                            // 保存设备引用供后台重连使用（v2.4）
                            BluetoothGatt gatt = (BluetoothGatt) param.args[0];
                            if (gatt != null && gatt.getDevice() != null) {
                                lastDevice = gatt.getDevice();
                            }
                            XposedBridge.log(TAG + " BLE 已连接（onGattConnected）"
                                    + " device=" + (lastDevice != null ? lastDevice.getAddress() : "null"));
                            // 检查 discoverServices 结果
                            if (gatt != null) {
                                XposedBridge.log(TAG + " [诊断]   services="
                                        + (gatt.getServices() != null ? gatt.getServices().size() : 0));
                            }
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 WaspWingDataInteractionController.onGattConnected（BLE 状态恢复）");

            // 诊断 3c：SDK ViewModel 的 onGattConnected
            XposedHelpers.findAndHookMethod(sdkVm, "onGattConnected",
                    BluetoothDevice.class, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            BluetoothDevice d = (BluetoothDevice) param.args[0];
                            Object thisVm = param.thisObject;
                            Object ld = XposedHelpers.getObjectField(thisVm, "_connectedLiveData");
                            Object val = XposedHelpers.callMethod(ld, "getValue");
                            XposedBridge.log(TAG + " [诊断] SDK.onGattConnected"
                                    + " device=" + (d != null ? d.getAddress() : "null")
                                    + " _connectedLiveData=" + (val != null ? "有值" : "null"));
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 SDK WaspwingViewModel.onGattConnected");

            // SDK onDeviceInfoUpdate — 只留一次，验证数据到达
            XposedHelpers.findAndHookMethod(sdkVm, "onDeviceInfoUpdate",
                    waspInfoCls, new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            Object info = param.args[0];
                            lastWaspWingInfo = info;  // v2.3：捕获散热器全参数回传

                            // 修正 experimentalRunModeValue，阻止 App 自修复触发 BLE 命令竞争
                            // 必须在 original method 执行前修正，因为 self-repair 在
                            // original method 内部检查条件并发命令。beforeHookedMethod
                            // 确保值已修正，self-repair 检查通过后跳过无命令发出。
                            try {
                                Object realCold = XposedHelpers.callMethod(info, "getRealColdLevel");
                                if (realCold != null) {
                                    XposedHelpers.setIntField(info, "experimentalRunModeValue",
                                            ((Integer) realCold) + 1);
                                }
                            } catch (Throwable t) { /* 字段可能不存在 */ }

                            Boolean connected = (Boolean) XposedHelpers.callMethod(info, "isConnected");
                            Integer wind = (Integer) XposedHelpers.callMethod(info, "getRealWindLevel");
                            XposedBridge.log(TAG + " [诊断] SDK.onDeviceInfoUpdate"
                                    + " connected=" + connected
                                    + " windLevel(real)=" + wind);
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 SDK WaspwingViewModel.onDeviceInfoUpdate（beforeHook）");

            // App 层 WaspWingViewModel.onDeviceInfoUpdate — 自修复逻辑在此
            // 方法先 postValue(info) 再检查 experimentalRunModeValue。
            // 必须用 beforeHookedMethod 在 original 执行前修正值，
            // 否则 self-repair 在 original 内部已发出 setExperimentalRunMode 命令。
            XposedHelpers.findAndHookMethod(appVm, "onDeviceInfoUpdate",
                    waspInfoCls, new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            Object info = param.args[0];
                            lastWaspWingInfo = info;

                            // 设 experimentalRunModeValue = realColdLevel + 1
                            // 满足 self-repair 的跳过条件，阻止 BLE 命令发出。
                            try {
                                Object realCold = XposedHelpers.callMethod(info, "getRealColdLevel");
                                if (realCold != null) {
                                    XposedHelpers.setIntField(info, "experimentalRunModeValue",
                                            ((Integer) realCold) + 1);
                                }
                            } catch (Throwable t) { /* ok */ }

                            Boolean connected = (Boolean) XposedHelpers.callMethod(info, "isConnected");
                            Integer wind = (Integer) XposedHelpers.callMethod(info, "getRealWindLevel");
                            XposedBridge.log(TAG + " [诊断] App.onDeviceInfoUpdate"
                                    + " connected=" + connected
                                    + " windLevel(real)=" + wind);
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 App WaspWingViewModel.onDeviceInfoUpdate（beforeHook）");

        } catch (Exception e) {
            XposedBridge.log(TAG + " 钩诊断失败: " + e.getMessage());
        }

        } // end if (deviceType == 6)

        // ========== 公共 BLE 断联检测（BluetoothGatt 标准 API，双设备通用） ==========
        try {
            XposedHelpers.findAndHookMethod(
                    BluetoothGatt.class, "disconnect",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            bleConnected = false;
                            bleConnectedTimestamp = 0;
                            BluetoothGatt gatt = (BluetoothGatt) param.thisObject;
                            if (gatt != null && gatt.getDevice() != null) {
                                lastDevice = gatt.getDevice();
                            }
                            XposedBridge.log(TAG + " BLE 断联 device="
                                    + (lastDevice != null ? lastDevice.getAddress() : "null"));
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 BluetoothGatt.disconnect（双设备通用）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 BluetoothGatt.disconnect 失败: " + t.getMessage());
        }

        // ========== 修复 DefaultDispatcher 线程 100% CPU（runFetchLoop 空队列忙等） ==========
        // SDK 的 AbstractDataInteractionController.runFetchLoop 在命令队列为空时
        // 无限循环 peek()，无协程挂起点，导致 Dispatchers.Default 线程吃满一个核心。
        // 修复方法一：在 AbstractDataInteractionController 构造函数中替换队列
        // 方法二：钩住 runFetchLoop 注入等 待（已废弃，协程挂起函数难包装）
        // 这里使用方法一，同时用 hookAllConstructors 兜底确保捕获所有子类构造。
        try {
            Class<?> absCtrl = lpparam.classLoader.loadClass(
                    "com.flydigi.sdk.bluetooth.AbstractDataInteractionController");
            // 使用 hookAllConstructors 而非 findAndHookMethod(<init>)，
            // 避免子类签名不匹配导致钩子不触发的问题
            XposedBridge.hookAllConstructors(absCtrl, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    try {
                        Object ctrl = param.thisObject;
                        Object originalQueue = XposedHelpers.getObjectField(
                                ctrl, "mConcurrentLinkedQueue");

                        // 包装 ConcurrentLinkedQueue：peek 空时 sleep 100ms
                        ConcurrentLinkedQueue<Object> wrapped =
                                new ConcurrentLinkedQueue<Object>() {
                            @Override
                            public Object peek() {
                                Object result = super.peek();
                                if (result == null) {
                                    try {
                                        Thread.sleep(50);
                                    } catch (InterruptedException e) {
                                        Thread.currentThread().interrupt();
                                    }
                                }
                                return result;
                            }
                        };

                        // 把原队列中已有数据搬过来
                        if (originalQueue instanceof ConcurrentLinkedQueue) {
                            ConcurrentLinkedQueue<?> src =
                                    (ConcurrentLinkedQueue<?>) originalQueue;
                            while (true) {
                                Object item = src.poll();
                                if (item == null) break;
                                wrapped.add(item);
                            }
                        }

                        // volatile 字段，替换后运行中的协程线程立即可见
                        XposedHelpers.setObjectField(ctrl,
                                "mConcurrentLinkedQueue", wrapped);

                        XposedBridge.log(TAG
                                + " runFetchLoop 队列已替换（空待 sleep 50ms）");
                    } catch (Exception e) {
                        XposedBridge.log(TAG
                                + " runFetchLoop 队列替换失败: " + e.getMessage());
                    }
                }
            });
            XposedBridge.log(TAG + " 已钩住 AbstractDataInteractionController 构造"
                    + "（修复 runFetchLoop CPU 满载）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 AbstractDataInteractionController 失败: "
                    + t.getMessage());
        }

        // ========== 智能温控唤醒（仅 B6X）：B6ExperimentalActivity.onResume ==========
        if (deviceType == 6) {
            try {
                Class<?> b6ExpAct = lpparam.classLoader.loadClass(
                        "com.flydigi.waspwing.experimental.B6ExperimentalActivity");

                XposedHelpers.findAndHookMethod(b6ExpAct, "onResume",
                        new XC_MethodHook() {
                            @Override
                            protected void afterHookedMethod(MethodHookParam param) {
                                try {
                                    Object vm = XposedHelpers.callMethod(param.thisObject, "getViewModel");
                                    Object connLd = XposedHelpers.getObjectField(vm, "_connectLiveData");
                                    Boolean isConnected = (Boolean) XposedHelpers.callMethod(connLd, "getValue");

                                    if (isConnected != null && isConnected) {
                                        XposedBridge.log(TAG + " onResume + BLE 已连接");
                                    } else {
                                        XposedBridge.log(TAG + " onResume 但 BLE 未连接，不唤醒");
                                    }
                                } catch (Exception e) {
                                    XposedBridge.log(TAG + " onResume 检查 BLE 状态失败: " + e.getMessage());
                                }
                            }
                        });

                XposedBridge.log(TAG + " 已钩住 B6ExperimentalActivity.onResume");

            } catch (Throwable t) {
                XposedBridge.log(TAG + " 钩 B6ExperimentalActivity 失败: " + t.getMessage());
            }
        } // end B6X-only hooks

        // ========== 捕获 WaspWingManager 实例（双设备） ==========
        // B6X：原名 com.flydigi.sdk.waspwing.WaspWingManager
        // B7X：混淆 t9.j，先试原名再试混淆名
        boolean mgrHooked = false;
        try {
            Class<?> mgrCls = lpparam.classLoader.loadClass(
                    "com.flydigi.sdk.waspwing.WaspWingManager");
            XposedBridge.hookAllConstructors(mgrCls, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    capturedWaspWingMgr = param.thisObject;
                    XposedBridge.log(TAG + " 已捕获 WaspWingManager 实例");
                }
            });
            XposedBridge.log(TAG + " 已钩住 WaspWingManager 构造函数");
            mgrHooked = true;

            // 屏蔽 App 自修复（仅 B6X）
            if (deviceType == 6) {
                try {
                    XposedHelpers.findAndHookMethod(mgrCls, "setExperimentalRunMode",
                            boolean.class, Integer.class, Integer.class,
                            new XC_MethodHook() {
                                @Override
                                protected void beforeHookedMethod(MethodHookParam param) {
                                    XposedBridge.log(TAG + " 拦截 setExperimentalRunMode("
                                            + param.args[0] + ", " + param.args[1]
                                            + ", " + param.args[2] + ")");
                                    param.setResult(null);
                                }
                            });
                    XposedBridge.log(TAG + " 已钩住 setExperimentalRunMode（已屏蔽）");
                } catch (Throwable t) { /* B6X only */ }
            }
        } catch (Throwable t) {
            if (deviceType == 7) {
                // B7X：WaspWingManager 混淆为 t9.j
                try {
                    Class<?> mgrCls = lpparam.classLoader.loadClass("t9.j");
                    XposedBridge.hookAllConstructors(mgrCls, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            capturedWaspWingMgr = param.thisObject;
                            XposedBridge.log(TAG + " 已捕获 WaspWingManager(t9.j) 实例");
                        }
                    });
                    XposedBridge.log(TAG + " 已钩住 WaspWingManager(t9.j) 构造函数");
                    mgrHooked = true;
                } catch (Throwable t2) {
                    XposedBridge.log(TAG + " WaspWingManager 原名+混淆均不可用");
                }
            } else {
                XposedBridge.log(TAG + " 钩 WaspWingManager 失败: " + t.getMessage());
            }
        }

        // ========== 广播接收器注册 + 定时状态写入 ==========
        try {
            Class<?> appClass = lpparam.classLoader.loadClass("android.app.Application");
            XposedHelpers.findAndHookMethod(appClass, "onCreate", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    Context ctx = (Context) param.thisObject;
                    registerTemperatureReceiver(ctx);
                    startPeriodicStatusWrite();
                }
            });
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 Application.onCreate 失败: " + t.getMessage());
        }
    }

    // ========== 辅助 ==========
    private static String getDeviceLabel() {
        return (deviceType == 7) ? "B7X" : "B6X";
    }
}
