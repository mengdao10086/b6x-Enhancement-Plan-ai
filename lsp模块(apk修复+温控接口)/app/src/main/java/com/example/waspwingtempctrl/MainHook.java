package com.example.waspwingtempctrl;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import java.io.FileOutputStream;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.UUID;

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
    private static final String PACKAGE_B6X_NEW = "com.flydigi.waspwing.experimentanliuliu";
    private static final String PACKAGE_B7X = "com.fdg.flashplay.farsef";
    private static final String TAG = "[WaspWingTempCtrl]";
    // 双文件路径
    private static final String STATUS_FILE_B6 = "/data/local/tmp/tempctrl_b6x.status";
    private static final String STATUS_FILE_B7 = "/data/local/tmp/tempctrl_b7x.status";

    private static Object capturedWaspWingMgr = null;  // 构造函数钩子捕获的实例
    private static int deviceType = 0;      // 0=无连接, 6=B6X, 7=B7X
    private static boolean isNewB6App = false;  // v2.5：当前进程是否为新版 B6X app（决定 BLE=1/2）
    // v2.7：以下共享状态被 BLE 回调线程写、周期线程读，需 volatile 保证跨线程可见性（M4）
    private static volatile boolean bleConnected = false;  // BLE 连接状态（供写 status 文件）
    private static volatile long bleConnectedTimestamp = 0; // 连接 Unix 时间戳（CONNECTED_AT）
    private static String currentStatusFile = STATUS_FILE_B6; // 当前选中的 status 文件
    private static volatile Object lastWaspWingInfo = null;  // 散热器全参数回传（v2.3）

    // ========== 设备型号识别 + B6X 自动进入设置界面（v2.6） ==========
    private static volatile int connectedModel = 0;           // 0=未知, 6=B6X型号, 7=B7X型号（BLE 字段 0/6/7）
    private static volatile int bleLastOwner = 0;             // 上次连接者（BLE_OWNER_LAST 值：1/2=B6X app, 6/7=farsef 连的型号）；断连保留
    private static volatile long bleLastOwnerAt = 0;          // 上次连接时间戳（Unix 秒，与 bleLastOwner 配套，断连保留）
    private static volatile Activity currentGuideActivity = null;  // 当前可见的 MainActivity（引导页）
    private static volatile boolean enteredSetup = false;         // 本进程是否已进入过设置界面

    // ========== 后台自动重连（v2.4） ==========
    private static volatile BluetoothDevice lastDevice = null;      // 上次连接的 BLE 设备
    private static volatile Object capturedB7Controller = null;     // B7X 混淆控制器（com.flydigi.sdk.waspwing.a）实例，重连用 T0()
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

                        // 调用 setRunMode——优先用构造函数捕获的实例，其次试单例
                        try {
                            Object inst = resolveWaspWingManager(context);
                            if (inst != null) {
                                // v2.7：B7X 的 WaspWingManager(t9.j) 混淆后 setRunMode 更名为 W(int×7)，
                                // 用 invokeSetRunMode 做原名→混淆名回退，确保 SET_TEMPERATURE_B7 广播可控温
                                invokeSetRunMode(inst, mode, temperature, windOC, coldOC,
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
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 注册广播接收器失败: " + t.getMessage());
        }
    }

    // ========== 双文件状态写入（v2.5） ==========
    // 根据 deviceType 写入对应文件：/data/local/tmp/tempctrl_b6x.status 或 _b7x.status
    // tempctrl 通过 stat() 检查文件 mtime 判断进程存活
    private static synchronized void writeStatusFile() {
        try {
            FileOutputStream fos = new FileOutputStream(currentStatusFile);
            StringBuilder sb = new StringBuilder();
            // BLE 字段：0=未连接；B7X=型号编码(6/7)；B6X 用 1/2 区分两个 app（1=老 app, 2=新 app）
            int bleVal = bleConnected ? bleOwnerCode() : 0;
            sb.append("BLE=").append(bleVal).append("\n");
            sb.append("CONNECTED_AT=").append(bleConnectedTimestamp).append("\n");
            sb.append("BLE_OWNER_LAST=").append(bleLastOwner).append(" ").append(bleLastOwnerAt).append("\n");

            // v2.3：散热器全参数回传
            try {
                if (lastWaspWingInfo != null) {
                    // 运行模式：getRunMode() → int，0=固定功率(手动), 1=智能
                    appendGetterValue(sb, lastWaspWingInfo, "getRunMode", "RUN_MODE");

                    // 热端温度：getHotSurfaceTemperature() → byte(°C) → 0.1°C
                    appendTenthValue(sb, lastWaspWingInfo, "getHotSurfaceTemperature", "HOT_TEMP");

                    // 冷端温度：getTemperature()(整数°C) + getTemperatureDecimal()(小数位) → 0.1°C
                    Object cold = XposedHelpers.callMethod(lastWaspWingInfo, "getTemperature");
                    Object coldDec = XposedHelpers.callMethod(lastWaspWingInfo, "getTemperatureDecimal");
                    if (cold != null && coldDec != null) {
                        int c = (Integer) cold;
                        int d = (Integer) coldDec;
                        if (d >= 10) d = (d + 5) / 10;  // 多位小数 → 四舍五入到 0.1°C
                        sb.append("COLD_TEMP=").append(c * 10 + d).append("\n");
                    }

                    // 实际风扇转速（经超频逻辑折算）：getRealWindLevel()
                    appendGetterValue(sb, lastWaspWingInfo, "getRealWindLevel", "RPM_REAL");

                    // 实际制冷强度（经超频逻辑折算）：getRealColdLevel()
                    appendGetterValue(sb, lastWaspWingInfo, "getRealColdLevel", "COLD_REAL");

                    // 目标温度：getTargetTemperature() → int(°C) → 0.1°C
                    appendTenthValue(sb, lastWaspWingInfo, "getTargetTemperature", "TARGET_TEMP");
                }
            } catch (Throwable t) {
                XposedBridge.log(TAG + " 参数回传异常: " + t.getMessage());
            }

            fos.write(sb.toString().getBytes());
            fos.close();
        } catch (Throwable e) {
            XposedBridge.log(TAG + " 写入状态文件失败: " + e.getMessage());
        }
    }

    private static void startPeriodicStatusWrite() {
        Thread t = new Thread(() -> {
            int tick = 0;   // v2.5：状态写 1s，后台重连保持 5s 节奏
            while (true) {
                try {
                    tick++;
                    writeStatusFile();   // 每 1 秒写一次 status（供 daemon 3s 判死 + WebUI 曲线）

                    // ═══ 后台自动重连（v2.4） ═══
                    // 保持 5 秒节奏（tick%5==0），避免每秒重连轰炸 BLE
                    if (tick % 5 == 0 && !bleConnected && lastDevice != null) {
                        try {
                            if (deviceType == 7) {
                                // B7X：connectGattWith 只存在于 B6X（反编译确认 t9.j 无此方法）；
                                // 改用 B7X 控制器(a) 的实际连接入口 T0()——重连其存储的 M() 设备
                                if (capturedB7Controller != null) {
                                    XposedHelpers.callMethod(capturedB7Controller, "T0");
                                    XposedBridge.log(TAG + " 后台重连尝试(b7x T0) -> "
                                            + lastDevice.getAddress());
                                }
                            } else {
                                Class<?> mgrCls = XposedHelpers.findClass(
                                        "com.flydigi.sdk.waspwing.WaspWingManager", appClassLoader);
                                XposedHelpers.callStaticMethod(mgrCls, "connectGattWith", lastDevice);
                                XposedBridge.log(TAG + " 后台重连尝试 -> " + lastDevice.getAddress());
                            }
                        } catch (Throwable t2) {
                            XposedBridge.log(TAG + " 后台重连失败: " + t2.getMessage());
                            // connectGattWith/T0 可能会因内部状态抛异常，静默跳过等下一周期
                        }
                    }

                    Thread.sleep(1000);
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
        if (lpparam.packageName.equals(PACKAGE_B6X)
                || lpparam.packageName.equals(PACKAGE_B6X_NEW)) {
            deviceType = 6;
            currentStatusFile = STATUS_FILE_B6;
            isNewB6App = lpparam.packageName.equals(PACKAGE_B6X_NEW);
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

        // 各修复分区按固定顺序注册（顺序影响 Xposed 回调执行次序，不可随意调整）
        hookControllerStopScan(lpparam);              // 修复 #1：控制器层停扫描（双设备）
        if (deviceType == 6) hookB6ViewModelFix(lpparam);   // 修复 #2：ViewModel LiveData（仅 B6X）
        if (deviceType == 6) hookB6Diagnostics(lpparam);    // 修复 #3/#4 + 诊断钩子（仅 B6X）
        hookCommonDisconnect(lpparam);                // 公共 BLE 断联（双设备）
        hookRunFetchLoopCpuFix(lpparam);              // runFetchLoop CPU 满载修复（双设备）
        if (deviceType == 6) hookB6Activity(lpparam);       // 唤醒 + 自动进入设置界面（仅 B6X）
        hookWaspWingManagerCapture(lpparam);          // 捕获 WaspWingManager 实例（双设备）
        if (deviceType == 7) hookB7Obfuscated(lpparam);     // c0.s1 + 混淆适配（仅 B7X）
        hookApplicationCreate(lpparam);               // 广播接收器 + 定时状态写入（双设备）
    }

    // ========== 各 Hook 分区实现 ==========

    /** 修复 #1：控制器层 — 设备连接后停扫描（双设备共用） */
    private static void hookControllerStopScan(XC_LoadPackage.LoadPackageParam lpparam) {
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
                                // L4：先记录连接状态，再停扫描——即使 stopScan/字段名在未来版本变化也不丢状态
                                markConnected(null);  // onDeviceConnected 无 gatt 参数，不保存设备引用
                                try {
                                    Object controller = param.thisObject;
                                    XposedHelpers.callMethod(controller, "stopScan");
                                    XposedHelpers.setBooleanField(controller, "inScanning", false);
                                } catch (Throwable t) {
                                    XposedBridge.log(TAG + " 控制器停扫描失败(忽略): " + t.getMessage());
                                }
                                XposedBridge.log(TAG + " 控制器：扫描已停止，" + getDeviceLabel() + " BLE 已连接");
                                writeStatusFile();  // v2.5：连接事件立刻写 status 文件
                            } catch (Throwable t) {
                                XposedBridge.log(TAG + " 控制器修复异常: " + t.getMessage());
                            }
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 AbstractBluetoothController.onDeviceConnected");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩控制器失败: " + t.getMessage());
        }
    }

    /** 修复 #2（仅 B6X）：ViewModel 层 — 连接后更新 UI LiveData */
    private static void hookB6ViewModelFix(XC_LoadPackage.LoadPackageParam lpparam) {
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

                                    // v2.7：原 _waspWingInfo 修正块已删除——
                                    // 反编译确认 BluetoothViewModel 直接 extends ViewModel，无 _waspWingInfo 字段
                                    // （该字段在 com.example.extool.WaspWingViewModel 上），此块必然 NoSuchFieldError。
                                    // 状态回传由 SDK/App 层 onDeviceInfoUpdate 钩子接管（lastWaspWingInfo）。
                                }

                                XposedBridge.log(TAG + " ViewModel 修复完成");
                            } catch (Throwable t) {
                                XposedBridge.log(TAG + " ViewModel 修复异常: " + t.getMessage());
                            }
                        }
                    });

            XposedBridge.log(TAG + " 已钩住 BluetoothViewModel.onDeviceConnected");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 BluetoothViewModel 失败: " + t.getMessage());
        }
    }

    /** 修复 #3/#4 + 诊断钩子（仅 B6X） */
    private static void hookB6Diagnostics(XC_LoadPackage.LoadPackageParam lpparam) {
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

            // ===== 诊断钩子（调试用，保留） =====
            // v2.7：B6X 专属的 BluetoothGatt.disconnect 钩子已删除（M1）——
            // 公共断连钩子（下方 BluetoothGatt.disconnect，双设备通用）行为一致且已覆盖，删除避免重复写状态文件。

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
                            Object result = param.getResult();
                            XposedBridge.log(TAG + " [诊断] discoverServices 返回 "
                                    + (result != null ? result : "null"));  // L9：防御 getResult() 为 null
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
                                markDisconnected((BluetoothGatt) param.args[0]);
                                XposedBridge.log(TAG + " BLE 断联（onConnectionStateChange）"
                                        + " device=" + (lastDevice != null ? lastDevice.getAddress() : "null"));
                                writeStatusFile();  // v2.5：远程断连立刻写 status 文件
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
                            BluetoothGatt gatt = (BluetoothGatt) param.args[0];
                            // M2：重连路径也刷新 CONNECTED_AT，与 onDeviceConnected 对齐；并保存设备引用
                            markConnected(gatt);
                            autoEnterSetup();  // v2.6：引导页可见时自动进入设置界面
                            XposedBridge.log(TAG + " BLE 已连接（onGattConnected）"
                                    + " device=" + (lastDevice != null ? lastDevice.getAddress() : "null"));
                            writeStatusFile();  // v2.5：连接事件立刻写 status 文件
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
                            lastWaspWingInfo = info;    // v2.3：捕获散热器全参数回传
                            updateModelFromInfo(info);  // v2.6 型号识别 + M3 同步 BLE_OWNER_LAST
                            // 修正 experimentalRunModeValue，阻止 App 自修复触发 BLE 命令竞争
                            // 必须在 original method 执行前修正，因为 self-repair 在
                            // original method 内部检查条件并发命令。beforeHookedMethod
                            // 确保值已修正，self-repair 检查通过后跳过无命令发出。
                            blockSelfRepair(info);

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
                            updateModelFromInfo(info);  // v2.6 型号识别 + M3 同步 BLE_OWNER_LAST
                            // 设 experimentalRunModeValue = realColdLevel + 1
                            // 满足 self-repair 的跳过条件，阻止 BLE 命令发出。
                            blockSelfRepair(info);
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 App WaspWingViewModel.onDeviceInfoUpdate（beforeHook）");

        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩诊断失败: " + t.getMessage());
        }
    }

    /** 公共 BLE 断联检测（BluetoothGatt 标准 API，双设备通用） */
    private static void hookCommonDisconnect(XC_LoadPackage.LoadPackageParam lpparam) {
        try {
            XposedHelpers.findAndHookMethod(
                    BluetoothGatt.class, "disconnect",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            // v2.7：断连保留 CONNECTED_AT / BLE_OWNER_LAST（作为"上次连接时间/连接者"供仲裁）
                            markDisconnected((BluetoothGatt) param.thisObject);
                            XposedBridge.log(TAG + " BLE 断联 device="
                                    + (lastDevice != null ? lastDevice.getAddress() : "null"));
                            writeStatusFile();  // v2.5：断连事件立刻写 status 文件
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 BluetoothGatt.disconnect（双设备通用）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 BluetoothGatt.disconnect 失败: " + t.getMessage());
        }
    }

    /** 修复 DefaultDispatcher 线程 100% CPU（runFetchLoop 空队列忙等，双设备） */
    private static void hookRunFetchLoopCpuFix(XC_LoadPackage.LoadPackageParam lpparam) {
        // SDK 的 AbstractDataInteractionController.runFetchLoop 在命令队列为空时
        // 无限循环 peek()，无协程挂起点，导致 Dispatchers.Default 线程吃满一个核心。
        // 修复方法一：在 AbstractDataInteractionController 构造函数中替换队列
        // 方法二：钩住 runFetchLoop 注入等待（已废弃，协程挂起函数难包装）
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

                        // 包装 ConcurrentLinkedQueue：peek 空时 sleep 50ms
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
                    } catch (Throwable t) {
                        XposedBridge.log(TAG
                                + " runFetchLoop 队列替换失败: " + t.getMessage());
                    }
                }
            });
            XposedBridge.log(TAG + " 已钩住 AbstractDataInteractionController 构造"
                    + "（修复 runFetchLoop CPU 满载）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 AbstractDataInteractionController 失败: "
                    + t.getMessage());
        }
    }

    /** B6X 专属：智能温控唤醒 + 启动自动进入设置界面 */
    private static void hookB6Activity(XC_LoadPackage.LoadPackageParam lpparam) {
        // ========== 智能温控唤醒：B6ExperimentalActivity.onResume ==========
        try {
            Class<?> b6ExpAct = lpparam.classLoader.loadClass(
                    "com.example.extool.B6ExperimentalActivity");

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
                            } catch (Throwable t) {
                                XposedBridge.log(TAG + " onResume 检查 BLE 状态失败: " + t.getMessage());
                            }
                        }
                    });

            XposedBridge.log(TAG + " 已钩住 B6ExperimentalActivity.onResume");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 B6ExperimentalActivity 失败: " + t.getMessage());
        }

        // ========== B6X 启动自动进入设置界面（v2.5 修复，事件驱动） ==========
        // Bug1 修复：反编译确认 MainActivity extends AppCompatActivity 且仅重写 onCreate（无 onResume），
        // findAndHookMethod 只查声明方法、不搜继承链 → 原精确钩子必然失败（bug 根因）。
        // 改钩基类 android.app.Activity 的 onResume/onPause/onDestroy（经 AppCompatActivity super 链同样触发），
        // 用 isMainActivity() 识别 MainActivity；enteredSetup 防止"回引导页被弹回"
        try {
            XposedHelpers.findAndHookMethod(android.app.Activity.class, "onResume", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    if (isMainActivity(param.thisObject)) {
                        currentGuideActivity = (Activity) param.thisObject;
                        autoEnterSetup();  // 已连接则立即跳；未连接则等 onGattConnected 触发
                    }
                }
            });
            XposedHelpers.findAndHookMethod(android.app.Activity.class, "onPause", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) {
                    if (isMainActivity(param.thisObject)
                            && currentGuideActivity == param.thisObject) {
                        currentGuideActivity = null;
                    }
                }
            });
            XposedHelpers.findAndHookMethod(android.app.Activity.class, "onDestroy", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) {
                    if (isMainActivity(param.thisObject)
                            && currentGuideActivity == param.thisObject) {
                        currentGuideActivity = null;
                    }
                }
            });
            Class<?> b6ExpAct = lpparam.classLoader.loadClass("com.example.extool.B6ExperimentalActivity");
            XposedHelpers.findAndHookMethod(b6ExpAct, "onCreate", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    enteredSetup = true;  // 已进入过设置界面，此后不再自动跳
                }
            });
            XposedBridge.log(TAG + " 已钩住 Activity 基类生命周期（MainActivity 自动进入设置界面）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩自动进入设置界面失败: " + t.getMessage());
        }
    }

    /** 捕获 WaspWingManager 实例（双设备）；B6X 附屏蔽 App 自修复 */
    private static void hookWaspWingManagerCapture(XC_LoadPackage.LoadPackageParam lpparam) {
        // B6X：原名 com.flydigi.sdk.waspwing.WaspWingManager
        // B7X：混淆 t9.j，先试原名再试混淆名
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
                } catch (Throwable t2) {
                    XposedBridge.log(TAG + " WaspWingManager 原名+混淆均不可用");
                }
            } else {
                XposedBridge.log(TAG + " 钩 WaspWingManager 失败: " + t.getMessage());
            }
        }
    }

    /** B7X 专属：c0.s1() 权限修复 + 完整混淆适配（v2.7） */
    private static void hookB7Obfuscated(XC_LoadPackage.LoadPackageParam lpparam) {
        // ========== c0.s1() 权限检查强制 true（修复 Android 16 连接失败） ==========
        // 根因：B7X 旧版 SDK 用 c0.s1() 检查 BLUETOOTH_CONNECT 权限，Android 16 上返回 false，
        // 导致 connectGatt / discoverServices 都不执行 → 连接超时报"连接出现异常"。
        try {
            Class<?> c0Cls = lpparam.classLoader.loadClass("com.flydigi.sdk.bluetooth.c0");
            XposedHelpers.findAndHookMethod(c0Cls, "s1", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    param.setResult(true);   // 跳过 BLUETOOTH_CONNECT 权限检查，让连接流程走完
                }
            });
            XposedBridge.log(TAG + " 已钩住 c0.s1()（强制返回 true，修复 b7x 连接）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 c0.s1() 失败: " + t.getMessage());
        }

        // ========== B7X 完整混淆适配（v2.7） ==========
        // 依据 b7_overclock_v3 反编译（com.fdg.flashplay.farsef）：
        //   - com.flydigi.sdk.waspwing.a = WaspWingDataInteractionController（混淆类）
        //     - a.S1(BluetoothGatt)：GATT 连接成功点（super.S1 后 this.X = WaspWingInfo.Companion.a(device)，
        //       deviceCode 已由设备名填充）→ H1 连接状态 + H2 型号识别
        //     - a.T1(BluetoothGatt)：GATT 断连统一入口（远程 onConnectionStateChange(0) 与本地 disconnect 都走到这里）→ M7
        //     - a.Z0(UUID, byte[])：特征数据分发（B7X 的 onDeviceInfoUpdate 等价点，this.X 即最新 WaspWingInfo）→ H2 型号修正 + 参数回传
        //     - 构造钩子：捕获控制器实例，供 H4 后台重连调用 T0()（B7X 无 connectGattWith，T0() 是 c0 实际连接入口，
        //       重连其存储的 M() 设备）

        // H4：捕获 B7X 控制器(a) 实例（后台重连用）
        try {
            Class<?> ctrl7 = lpparam.classLoader.loadClass("com.flydigi.sdk.waspwing.a");
            XposedBridge.hookAllConstructors(ctrl7, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    capturedB7Controller = param.thisObject;
                    XposedBridge.log(TAG + " 已捕获 b7x 控制器(a) 实例");
                }
            });
            XposedBridge.log(TAG + " 已钩住 b7x 控制器(a) 构造函数（H4 重连实例捕获）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 捕获 b7x 控制器(a) 失败: " + t.getMessage());
        }

        // H1 + H2：连接成功 → 置状态 + 型号识别 + 捕获参数 + 写状态
        try {
            Class<?> ctrl7 = lpparam.classLoader.loadClass("com.flydigi.sdk.waspwing.a");
            XposedHelpers.findAndHookMethod(ctrl7, "S1",
                    BluetoothGatt.class, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            try {
                                // 型号未知先按包名兜底，随后 X.getDeviceCode() 修正（见 captureInfoFromController）
                                markConnected((BluetoothGatt) param.args[0]);
                                captureInfoFromController(param.thisObject);
                                XposedBridge.log(TAG + " b7x BLE 已连接（a.S1） device="
                                        + (lastDevice != null ? lastDevice.getAddress() : "null")
                                        + " model=" + connectedModel);
                                writeStatusFile();
                            } catch (Throwable t) {
                                XposedBridge.log(TAG + " b7x S1 钩子异常: " + t.getMessage());
                            }
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 b7x a.S1（连接状态 + 型号识别）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 b7x a.S1 失败: " + t.getMessage());
        }

        // H2：数据分发 → 刷新全参数回传 + 型号修正（B7X app 连 B6X 设备时在此 7→6）+ M3 同步 owner
        try {
            Class<?> ctrl7 = lpparam.classLoader.loadClass("com.flydigi.sdk.waspwing.a");
            XposedHelpers.findAndHookMethod(ctrl7, "Z0",
                    UUID.class, byte[].class, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            captureInfoFromController(param.thisObject);
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 b7x a.Z0（数据回传 + 型号识别）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 b7x a.Z0 失败: " + t.getMessage());
        }

        // M7：断连（远程/本地统一入口 a.T1）→ 置未连接 + 写状态
        try {
            Class<?> ctrl7 = lpparam.classLoader.loadClass("com.flydigi.sdk.waspwing.a");
            XposedHelpers.findAndHookMethod(ctrl7, "T1",
                    BluetoothGatt.class, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            try {
                                markDisconnected((BluetoothGatt) param.args[0]);
                                XposedBridge.log(TAG + " b7x BLE 断联（a.T1） device="
                                        + (lastDevice != null ? lastDevice.getAddress() : "null"));
                                writeStatusFile();
                            } catch (Throwable t) {
                                XposedBridge.log(TAG + " b7x T1 钩子异常: " + t.getMessage());
                            }
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 b7x a.T1（断连检测）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 b7x a.T1 失败: " + t.getMessage());
        }
    }

    /** 广播接收器注册 + 定时状态写入 */
    private static void hookApplicationCreate(XC_LoadPackage.LoadPackageParam lpparam) {
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

    /** 连接者编码（BLE / BLE_OWNER_LAST 共用的值）：B6X=1/2（老/新 app），farsef=连接的型号(6/7) */
    private static int bleOwnerCode() {
        if (deviceType == 7)
            return (connectedModel == 6 || connectedModel == 7) ? connectedModel : 7;
        return isNewB6App ? 2 : 1;
    }

    /** 从 WaspWingInfo.getDeviceCode() 映射设备型号：b6/b6x→6, b7/b7x→7，未知→0 */
    private static int modelFromDeviceCode(Object codeObj) {
        try {
            if (codeObj == null) return 0;
            String code = String.valueOf(codeObj);
            if (code.startsWith("b7")) return 7;
            if (code.startsWith("b6")) return 6;
        } catch (Throwable t) { /* 忽略 */ }
        return 0;
    }

    /**
     * v2.7（M3）：connectedModel 被修正（如 B7X app 连 B6X 设备从 7→6）时同步重算 BLE_OWNER_LAST 的值。
     * 仅当已连接且 owner 值发生变化时更新；时间保持连接时间（BLE_OWNER_LAST 语义为"上次连接者+连接时间"，
     * 不能在每次数据包时刷新时间）。
     */
    private static void refreshLastOwnerIfNeeded() {
        if (bleConnected && bleOwnerCode() != bleLastOwner) {
            bleLastOwner = bleOwnerCode();
            XposedBridge.log(TAG + " BLE_OWNER_LAST 已修正 -> " + bleLastOwner);
        }
    }

    /**
     * v2.7（H3）：调用 WaspWingManager.setRunMode。
     * B7X 的 WaspWingManager 混淆为 t9.j，setRunMode 更名为 W(int×7)（反编译确认：W→a.E2），
     * 故先试原名再试混淆名；B6X 只有原名。
     */
    private static void invokeSetRunMode(Object inst, int mode, int temperature, int windOC,
                                        int coldOC, int windLevel, int modeCustom, int extra) {
        String[] names = (deviceType == 7)
                ? new String[]{"setRunMode", "W"}
                : new String[]{"setRunMode"};
        Throwable last = null;
        for (String n : names) {
            try {
                XposedHelpers.callMethod(inst, n, mode, temperature, windOC, coldOC,
                        windLevel, modeCustom, extra);
                return;
            } catch (Throwable t) {
                last = t;
            }
        }
        XposedBridge.log(TAG + " setRunMode 失败: " + (last != null ? last.getMessage() : "无此方法"));
    }

    /**
     * v2.5：判断对象是否为 B6X app 的 MainActivity。
     * 模块编译期类路径不含 app 类（build.gradle 仅 xposed api 依赖），不能直接写 instanceof，
     * 改用 app 类加载器 loadClass + isInstance（语义等同 instanceof；MainActivity 为 final 类无子类）。
     */
    private static boolean isMainActivity(Object obj) {
        try {
            Class<?> cls = obj.getClass().getClassLoader()
                    .loadClass("com.example.extool.MainActivity");
            return cls.isInstance(obj);
        } catch (Throwable t) {
            return false;
        }
    }

    /**
     * v2.6：引导页可见且 BLE 已连、本进程未进过设置界面时，自动进入设置界面。
     * onResume（主线程）与 onGattConnected（BLE 回调线程）共用，内部 runOnUiThread 保证主线程跳转。
     */
    private static void autoEnterSetup() {
        if (!bleConnected || enteredSetup || currentGuideActivity == null) return;
        final Activity act = currentGuideActivity;
        currentGuideActivity = null;  // 先清空去重，防止重复跳转
        try {
            final Class<?> b6ExpCls = act.getClassLoader()
                    .loadClass("com.example.extool.B6ExperimentalActivity");
            act.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Intent intent = new Intent(act, b6ExpCls);
                        act.startActivity(intent);
                        act.finish();
                    } catch (Throwable t) {
                        XposedBridge.log(TAG + " 自动进入设置界面失败: " + t.getMessage());
                    }
                }
            });
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 自动进入设置界面 loadClass 失败: " + t.getMessage());
        }
    }

    /** 设备日志标签：b6x / b7x（小写，与日志约定一致） */
    private static String getDeviceLabel() {
        return (deviceType == 7) ? "b7x" : "b6x";
    }

    /**
     * 获取 WaspWingManager 实例：优先构造函数捕获的实例，其次试单例静态方法，
     * 再试 Kotlin INSTANCE 字段与 B7X 混淆单例（t9.j.f50990a）。
     * 主类 loadClass 失败时向上抛异常（与原逻辑一致，由调用方记录 setRunMode 异常）。
     */
    private static Object resolveWaspWingManager(Context ctx) throws Throwable {
        Object inst = capturedWaspWingMgr;
        if (inst != null) return inst;

        // 构造函数还没触发过，试单例方式兜底
        Class<?> mgrCls = ctx.getClassLoader().loadClass("com.flydigi.sdk.waspwing.WaspWingManager");
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
        if (inst == null && deviceType == 7) {
            // v2.7(H3)：B7X 混淆管理器 t9.j 的 Kotlin 单例字段 f50990a（反编译确认）
            try {
                Class<?> mgrCls7 = ctx.getClassLoader().loadClass("t9.j");
                inst = XposedHelpers.getStaticObjectField(mgrCls7, "f50990a");
            } catch (Throwable t) { /* ok */ }
        }
        return inst;
    }

    /**
     * 记录连接状态（时间戳、连接者、型号兜底）；gatt 非空时顺带保存设备引用供后台重连使用。
     * 由 BLE 回调线程调用，字段均 volatile（M4）。
     */
    private static void markConnected(BluetoothGatt gatt) {
        bleConnected = true;
        bleConnectedTimestamp = System.currentTimeMillis() / 1000L;
        if (connectedModel != 6 && connectedModel != 7)
            connectedModel = (deviceType == 7) ? 7 : 6;  // 型号未知按包名兜底
        bleLastOwner = bleOwnerCode();
        bleLastOwnerAt = bleConnectedTimestamp;
        if (gatt != null && gatt.getDevice() != null) {
            lastDevice = gatt.getDevice();
        }
    }

    /** 记录断连状态：清空 BLE 连接标志 + 型号，并保存设备引用供后台重连使用 */
    private static void markDisconnected(BluetoothGatt gatt) {
        bleConnected = false;
        connectedModel = 0;
        if (gatt != null && gatt.getDevice() != null) {
            lastDevice = gatt.getDevice();
        }
    }

    /** v2.6：从 WaspWingInfo.getDeviceCode() 识别型号并同步 BLE_OWNER_LAST；型号未知保持包名兜底 */
    private static void updateModelFromInfo(Object info) {
        try {
            connectedModel = modelFromDeviceCode(
                    XposedHelpers.callMethod(info, "getDeviceCode"));
            refreshLastOwnerIfNeeded();  // v2.7(M3)：型号修正后同步 BLE_OWNER_LAST
        } catch (Throwable t) { /* 型号未知保持包名兜底 */ }
    }

    /** 修正 experimentalRunModeValue，满足 self-repair 跳过条件，阻止 BLE 命令发出 */
    private static void blockSelfRepair(Object info) {
        try {
            Object realCold = XposedHelpers.callMethod(info, "getRealColdLevel");
            if (realCold != null) {
                XposedHelpers.setIntField(info, "experimentalRunModeValue",
                        ((Integer) realCold) + 1);
            }
        } catch (Throwable t) { /* 字段可能不存在 */ }
    }

    /** 读取控制器混淆字段 X 的 WaspWingInfo：刷新参数回传 + 型号识别 + 同步 owner */
    private static void captureInfoFromController(Object ctrl) {
        try {
            Object info = XposedHelpers.getObjectField(ctrl, "X");
            if (info != null) {
                lastWaspWingInfo = info;
                updateModelFromInfo(info);
            }
        } catch (Throwable t) { /* X 字段不可用则保持包名兜底 */ }
    }

    /** 调用 getter，结果非 null 时追加 "KEY=value" 行（异常由外层统一捕获） */
    private static void appendGetterValue(StringBuilder sb, Object info, String getter, String key) {
        Object value = XposedHelpers.callMethod(info, getter);
        if (value != null) {
            sb.append(key).append("=").append(value).append("\n");
        }
    }

    /** 调用 getter，结果非 null 时按 0.1°C（×10）追加 "KEY=value" 行 */
    private static void appendTenthValue(StringBuilder sb, Object info, String getter, String key) {
        Object value = XposedHelpers.callMethod(info, getter);
        if (value != null) {
            sb.append(key).append("=").append(((Number) value).intValue() * 10).append("\n");
        }
    }
}
