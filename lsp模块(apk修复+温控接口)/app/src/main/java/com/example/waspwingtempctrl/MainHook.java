package com.example.waspwingtempctrl;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.lang.reflect.Method;
import java.util.UUID;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * 飞智散热器 — LSPosed 模块
 *
 * 功能：
 * 1. 控制器层 stopScan 保底
 * 2. ViewModel 层：更新 LiveData，不创建中间态 WaspWingInfo
 * 3. 强制 checkBluetoothPermission=true
 * 4. BLE 连接/断联 → 通过 FIFO 通知 tempctrl 守护进程
 * 5. B6ExpActivity.onResume 检查 BLE 唤醒守护进程
 */
public class MainHook implements IXposedHookLoadPackage {

    // ========== 多设备支持 ==========
    private static final String PACKAGE_B6X = "com.flydigi.waspwing.experimental";
    private static final String PACKAGE_B6X_NEW = "com.flydigi.waspwing.experimentanliuliu";
    private static final String PACKAGE_B7X = "com.fdg.flashplay.farsef";
    private static final String TAG = "[WaspWingTempCtrl]";
    // 双文件路径
    private static final String STATUS_FILE_B6 = "/data/local/tmp/tempctrl_b6x.status";
    private static final String STATUS_FILE_B7 = "/data/local/tmp/tempctrl_b7x.status";
    private static final String LAST_DEV_FILE = "/data/local/tmp/tempctrl_last_dev";  // 上次连接的散热器 MAC（持久化，冷启动自动连接用）
    private static final String AUTO_LAUNCH_EXTRA = "b6x_auto_launch";               // tempctrl 拉起 app 时携带的标志
    // 广播 Action（按 appKind 选择）
    private static final String ACTION_TEMP_B6 = "com.flydigi.SET_TEMPERATURE";      // B6X 温控广播
    private static final String ACTION_TEMP_B7 = "com.flydigi.SET_TEMPERATURE_B7";   // B7X 温控广播

    private static Object capturedWaspWingMgr = null;  // 构造函数钩子捕获的实例
    private static int appKind = 0;      // 当前进程 app 类型：6=B6X, 7=B7X；按包名判定后恒为 6/7，
                                          // 不存在"0=无连接"态（非目标包直接 return）；0 仅作字段初值占位
    private static boolean isNewB6App = false;  // 当前进程是否为新版 B6X app（决定 BLE=1/2）
    // 以下共享状态被 BLE 回调线程写、周期线程读，需 volatile 保证跨线程可见性
    private static volatile boolean bleConnected = false;  // BLE 连接状态（供写 status 文件）
    private static volatile long bleConnectedTimestamp = 0; // 连接 Unix 时间戳（CONNECTED_AT）
    private static String currentStatusFile = STATUS_FILE_B6; // 当前选中的 status 文件
    private static volatile Object lastWaspWingInfo = null;  // 散热器全参数回传状态

    // ========== gatt 有效性跟踪 + 锁死自愈 ==========
    // 跟踪"当前有效 gatt"与"已连接 controller 实例"，下发前校验 static 指向。
    private static volatile BluetoothGatt currentValidGatt = null;   // 最近一次 GATT 连接成功的 gatt（断连清空）
    private static final ConcurrentHashMap<Object, BluetoothGatt> connectedControllers = new ConcurrentHashMap<>();
    private static volatile int lastBcastColdLv = -1, lastBcastRpmLv = -1; // 最近广播下发的目标制冷/风扇（锁死检测基准）
    private static volatile int stallLastCold = -1, stallLastRpm = -1; // 回传停滞快照（锁死检测）
    private static volatile int dispatchStallCount = 0;                // 回传停滞期间累计的下发次数（达 3 次 → 锁死）
    private static final int DISPATCH_STALL_LIMIT = 3;                 // 连续 3 次参数下发后回传仍停滞 → 锁死
    private static volatile long lastForceReconnectAt = 0;              // forceReconnect 防抖（10s 内最多一次）
    private static final long FORCE_RECONNECT_MIN_INTERVAL_MS = 10000;

    // ========== 回传新鲜度验证 + 设备唤醒 + 重连上限 ==========
    // 区分"无新回传"与"回传停滞"：无回传则唤醒设备，连续无效停止自动重连并提示重启 App。
    private static volatile boolean reconnectPending = false;      // markConnected 置 true：重连后等待新回传
    private static volatile long connectStartedAt = 0;             // 最近一次连接成功时间戳（ms，等待新回传计时）
    private static final long INFO_STALE_AFTER_MS = 6000;          // 重连成功后无新回传超时（6s）→ 判定设备无响应
    private static volatile int wakeupAttempts = 0;                // 本次连接已尝试的设备唤醒次数
    private static final int WAKEUP_MAX = 1;                       // 每连接最多唤醒尝试 1 次
    private static volatile long lastWakeupAttemptAt = 0;          // 唤醒尝试防抖（ms）
    private static final long WAKEUP_RETRY_MIN_INTERVAL_MS = 15000;
    private static volatile int stallReconnectCount = 0;           // 连续"无回传"重连次数（锁死会话内累计）
    private static final int STALL_RECONNECT_MAX = 3;              // 连续 3 次重连仍无回传 → 设备固件锁死，停止循环
    private static volatile boolean deviceLockedAlerted = false;   // 设备锁死提示已发出（markConnected 重置）

    // ========== runFetchLoop 崩溃兜底 ==========
    private static final int QUEUE_STALL_THRESHOLD = 6;           // queue 堆积 > 6 条（≈30s 下发量）= runFetchLoop 疑似崩溃
    private static final long QUEUE_TAKEOVER_MS = 5000;           // 守护线程接管判定：同一队首停留超 5s 才消费
    private static volatile boolean consumerThreadStarted = false; // 守护消费线程已启动（幂等，进程内一次）
    private static volatile long consumerThreadStartedAt = 0;      // 守护线程启动防抖（10s 内不重复触发）
    private static final long CONSUMER_START_MIN_INTERVAL_MS = 10000;

    // ========== 设备型号识别 + B6X 自动进入设置界面 ==========
    private static volatile int connectedModel = 0;           // 0=未知, 6=B6X型号, 7=B7X型号（BLE 字段 0/6/7）
    private static volatile int bleLastOwner = 0;             // 上次连接者（BLE_OWNER_LAST：1/2=B6X, 6/7=farsef）；断连保留
    private static volatile long bleLastOwnerAt = 0;          // 上次连接时间戳（Unix 秒，与 bleLastOwner 配套，断连保留）
    private static volatile Activity currentGuideActivity = null;  // 当前可见的 MainActivity（引导页）
    private static volatile boolean autoLaunchPending = false;     // 自动拉起标志已读取，待进入设置界面后后台化
    // Handler 懒加载：fork 阶段主线程 Looper 未创建
    private static Handler sMainHandler = null;
    private static Handler mainHandler() {
        if (sMainHandler == null) sMainHandler = new Handler(Looper.getMainLooper());
        return sMainHandler;
    }
    private static final int AUTO_LAUNCH_TIMEOUT_MS = 2000;        // 兜底：自动进入设置失败时仍退后台
    private static final int AUTO_BACKGROUND_DELAY_MS = 1000;      // 自动拉起后台化延迟：等 1s 再切后台
    private static volatile boolean enteredSetup = false;         // 本进程是否已进入过设置界面

    // ========== 后台自动重连 ==========
    private static volatile BluetoothDevice lastDevice = null;      // 上次连接的 BLE 设备
    private static volatile Object capturedB7Controller = null;     // B7X 混淆控制器（com.flydigi.sdk.waspwing.a）实例，重连用 T0()
    private static ClassLoader appClassLoader = null;      // App 类加载器（后台线程反射用）
    private static volatile boolean loggedReconnectSkip = false;    // 后台重连被跳过（控制器/类加载器未就绪）仅记一次

    // ========== 广播接收诊断（每次连接最多 3 对日志） ==========
    private static final int DIAG_LOG_MAX_PER_CONN = 3;   // 每次连接最多记录的对数
    private static volatile int diagLogCount = 0;          // 当前连接已记录的对数（markConnected 清零）
    private static volatile int setRunModeLogCount = 0;    // "setRunMode 已下发"当前连接已记录条数（markConnected 清零）
    private static final int DIAG_CONN_LOG_MAX = 1;        // 连接诊断日志每连最多条数（connect 进/出、断联等风暴源）
    private static volatile int diagConnLogCount = 0;      // 连接诊断日志计数（markConnected 清零）
    private static volatile boolean loggedReconnectAttempt = false; // "后台重连尝试"每断联只记一次（markConnected 清零）
    private static volatile boolean paramMissingLogged = false;     // 参数回传缺失：状态翻转才打（进入一条/恢复一条）
    private static volatile boolean statusWriteFailLogged = false;  // 状态文件写入失败：状态翻转才打（进入一条/恢复一条）
    private static volatile boolean loggedResolveFallback = false;  // resolveWaspWingManager 兜底失败仅记一次（进程内）

    // ========== 智能温控广播接收器 ==========
    // 接收 tempctrl 发送的 am broadcast，调用 setRunMode 控制散热器

    private static void registerTemperatureReceiver(Context ctx) {
        try {
            // B6X 用 B6 的 Action，B7X 用 B7 的 Action
            String action = (appKind == 7) ? ACTION_TEMP_B7 : ACTION_TEMP_B6;
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

                        // 诊断：每次连接最多 3 对——"收到广播参数" + "1s 后散热器实际回传"
                        logDiagOnBroadcast(mode, temperature, windOC, coldOC, windLevel);

                        // 调用 setRunMode——优先用构造函数捕获的实例，其次试单例
                        try {
                            Object inst = resolveWaspWingManager(context);
                            if (inst != null) {
                                // B7X WaspWingManager(t9.j) 的 setRunMode 更名为 W
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

    /** 连接诊断日志门控：每连接最多 DIAG_CONN_LOG_MAX 条。 */
    private static boolean diagConnLogAllowed() {
        if (diagConnLogCount >= DIAG_CONN_LOG_MAX) return false;
        diagConnLogCount++;
        return true;
    }

    /**
     * 诊断：每次连接最多记录 DIAG_LOG_MAX_PER_CONN 对日志——
     * ① 立即记"收到广播参数"
     * ② 延迟 1s 记散热器实际回传（验证 setRunMode 已下发且设备响应）
     */
    private static void logDiagOnBroadcast(final int mode, final int temperature,
                                           final int windOC, final int coldOC, final int windLevel) {
        if (diagLogCount >= DIAG_LOG_MAX_PER_CONN) return;
        diagLogCount++;
        XposedBridge.log(TAG + " 收到广播 mode=" + mode + " temp=" + temperature
                + " windOC=" + windOC + " coldOC=" + coldOC + " windLv=" + windLevel);
        mainHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder();
                Object info = lastWaspWingInfo;
                if (info != null) {
                    try {
                        Object rpm = XposedHelpers.callMethod(info, "getRealWindLevel");
                        Object cold = XposedHelpers.callMethod(info, "getRealColdLevel");
                        sb.append(" RPM=").append(rpm).append(" 制冷=").append(cold);
                        Object hot = XposedHelpers.callMethod(info, "getHotSurfaceTemperature");
                        if (hot != null) sb.append(" 热端=").append(((Number) hot).intValue() * 10);
                        Object tgt = XposedHelpers.callMethod(info, "getTargetTemperature");
                        if (tgt != null) sb.append(" 目标=").append(((Number) tgt).intValue() * 10);
                    } catch (Throwable t) {
                        sb.append(" 读回传异常=").append(t.getMessage());
                    }
                } else {
                    sb.append(" 无回传（lastWaspWingInfo 未就绪）");
                }
                XposedBridge.log(TAG + " [诊断] 1s后散热器实际" + sb);
            }
        }, 1000);
    }

    // ========== 双文件状态写入 ==========
    // 根据 appKind 写对应文件（b6x.status 或 _b7x.status）
    // tempctrl 通过 stat() 检查文件 mtime 判断进程存活
    private static synchronized void writeStatusFile() {
        try {
            StringBuilder sb = new StringBuilder();
            // BLE 字段：0=未连接；B7X=型号(6/7)；B6X=1/2 区分两 app
            int bleVal = bleConnected ? bleOwnerCode() : 0;
            sb.append("BLE=").append(bleVal).append("\n");
            sb.append("CONNECTED_AT=").append(bleConnectedTimestamp).append("\n");
            sb.append("BLE_OWNER_LAST=").append(bleLastOwner).append(" ").append(bleLastOwnerAt).append("\n");

            // 散热器全参数回传
            try {
                if (lastWaspWingInfo != null) {
                    // 运行模式：getRunMode() → int，0=固定功率(手动), 1=智能
                    appendGetterValue(sb, lastWaspWingInfo, "getRunMode", "RUN_MODE");

                    // 热端温度：getHotSurfaceTemperature() → byte(°C) → 0.1°C
                    appendTenthValue(sb, lastWaspWingInfo, "getHotSurfaceTemperature", "HOT_TEMP");

                    // 冷端温度：getTemp + getTempDecimal → 0.1°C
                    Object cold = XposedHelpers.callMethod(lastWaspWingInfo, "getTemperature");
                    Object coldDec = XposedHelpers.callMethod(lastWaspWingInfo, "getTemperatureDecimal");
                    if (cold != null && coldDec != null) {
                        // 用 Number.intValue() 兼容 Byte/Short/Integer 等返回值类型
                        int c = ((Number) cold).intValue();
                        int d = ((Number) coldDec).intValue();
                        if (d >= 10) d = (d + 5) / 10;  // 多位小数 → 四舍五入到 0.1°C
                        // 负温度换算：c 为带符号整数°C，d 恒为正小数位，负温结果为 c*10 - d
                        sb.append("COLD_TEMP=").append((c < 0) ? c * 10 - d : c * 10 + d).append("\n");
                    }

                    // 实际风扇转速（经超频逻辑折算）：getRealWindLevel()
                    appendGetterValue(sb, lastWaspWingInfo, "getRealWindLevel", "RPM_REAL");

                    // 实际制冷强度（经超频逻辑折算）：getRealColdLevel()
                    appendGetterValue(sb, lastWaspWingInfo, "getRealColdLevel", "COLD_REAL");

                    // 目标温度：getTargetTemperature() → int(°C) → 0.1°C
                    appendTenthValue(sb, lastWaspWingInfo, "getTargetTemperature", "TARGET_TEMP");
                    // 回传恢复：此前缺失则补一条（状态翻转才打）
                    if (paramMissingLogged) {
                        paramMissingLogged = false;
                        XposedBridge.log(TAG + " 参数回传已恢复");
                    }
                } else if (bleConnected) {
                    // 参数回传缺失：BLE 已连接但 lastWaspWingInfo 未就绪（如首包未到/回传断）
                    if (!paramMissingLogged) {
                        paramMissingLogged = true;
                        XposedBridge.log(TAG + " 参数回传缺失: lastWaspWingInfo 未就绪（BLE 已连接但无回传）");
                    }
                }
            } catch (Throwable t) {
                XposedBridge.log(TAG + " 参数回传异常: " + t.getMessage());
            }

            // 跨进程写竞争：先写临时文件 (.tmp) 再原子 rename 替换目标，读者只看到完整内容。
            byte[] data = sb.toString().getBytes();
            boolean atomicOk = false;
            try {
                File tmp = new File(currentStatusFile + ".tmp");
                FileOutputStream fos = new FileOutputStream(tmp);
                fos.write(data);
                fos.close();
                File dst = new File(currentStatusFile);
                if (tmp.renameTo(dst)) {
                    atomicOk = true;
                } else {
                    tmp.delete();
                }
            } catch (Throwable t) {
                // 原子写不可行（目录无写权限等）→ 走直接覆盖写兜底
            }
            if (!atomicOk) {
                FileOutputStream direct = new FileOutputStream(currentStatusFile);
                direct.write(data);
                direct.close();
            }
            // 写入成功：此前失败则补一条恢复（状态翻转才打）
            if (statusWriteFailLogged) {
                statusWriteFailLogged = false;
                XposedBridge.log(TAG + " 写入状态文件已恢复");
            }
            checkCommandStall();   // 锁死检测（每秒，回传停滞且≠目标时触发重连自愈）
        } catch (Throwable e) {
            if (!statusWriteFailLogged) {
                statusWriteFailLogged = true;
                XposedBridge.log(TAG + " 写入状态文件失败: " + currentStatusFile
                        + " 异常类型=" + e.getClass().getSimpleName()
                        + " msg=" + e.getMessage());
            }
        }
    }

    private static void startPeriodicStatusWrite() {
        Thread t = new Thread(() -> {
            int tick = 0;   // 状态写 1s，后台重连保持 5s 节奏
            while (true) {
                try {
                    tick++;
                    writeStatusFile();   // 每 1 秒写一次 status（供 daemon 3s 判死 + WebUI 曲线）

                    // ═══ 后台自动重连 ═══
                    // 保持 5 秒节奏（tick%5==0）
                    // 设备锁死（多次重连无回传）时停止自动重连，等用户强制重启 App
                    if (tick % 5 == 0 && !bleConnected && lastDevice != null && !deviceLockedAlerted) {
                        try {
                            if (appKind == 7) {
                                // B7X 无 connectGattWith（仅 B6X 有），改用 T0() 重连其 M() 设备
                                if (capturedB7Controller != null) {
                                    XposedHelpers.callMethod(capturedB7Controller, "T0");
                                    // 尝试仅记一次（每断联，markConnected 清零）
                                    if (!loggedReconnectAttempt) {
                                        loggedReconnectAttempt = true;
                                        XposedBridge.log(TAG + " 后台重连尝试(b7x T0) -> "
                                                + lastDevice.getAddress());
                                    }
                                } else if (!loggedReconnectSkip) {
                                    loggedReconnectSkip = true;
                                    XposedBridge.log(TAG + " 后台重连跳过: capturedB7Controller 未捕获（b7x 重连不可用）");
                                }
                            } else {
                                if (appClassLoader == null) {
                                    if (!loggedReconnectSkip) {
                                        loggedReconnectSkip = true;
                                        XposedBridge.log(TAG + " 后台重连跳过: appClassLoader 为 null（B6X findClass 无法进行）");
                                    }
                                } else {
                                    Class<?> mgrCls = XposedHelpers.findClass(
                                            "com.flydigi.sdk.waspwing.WaspWingManager", appClassLoader);
                                    XposedHelpers.callStaticMethod(mgrCls, "connectGattWith", lastDevice);
                                    // 尝试仅记一次（每断联，markConnected 清零）
                                    if (!loggedReconnectAttempt) {
                                        loggedReconnectAttempt = true;
                                        XposedBridge.log(TAG + " 后台重连尝试 -> " + lastDevice.getAddress());
                                    }
                                }
                            }
                        } catch (Throwable t2) {
                            // 重连失败静默跳过（仅"尝试"首次输出），等下一周期
                        }
                    }

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                } catch (Exception e) {
                    if (!statusWriteFailLogged) {
                        statusWriteFailLogged = true;
                        XposedBridge.log(TAG + " 状态写入异常: " + e.getMessage());
                    }
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
            appKind = 6;
            currentStatusFile = STATUS_FILE_B6;
            isNewB6App = lpparam.packageName.equals(PACKAGE_B6X_NEW);
        } else if (lpparam.packageName.equals(PACKAGE_B7X)) {
            appKind = 7;
            currentStatusFile = STATUS_FILE_B7;
        } else {
            XposedBridge.log(TAG + " 跳过非目标包: " + lpparam.packageName);
            return;
        }

        XposedBridge.log(TAG + " 模块已加载到 " + lpparam.packageName
                + " (appKind=" + appKind + ")");
        appClassLoader = lpparam.classLoader;  // 保存类加载器供后台重连线程使用

        // 各修复分区按固定顺序注册（顺序影响 Xposed 回调执行次序，不可随意调整）
        hookControllerStopScan(lpparam);              // 修复 #1：控制器层停扫描（双设备）
        if (appKind == 6) hookB6ViewModelFix(lpparam);   // 修复 #2：ViewModel LiveData（仅 B6X）
        if (appKind == 6) hookB6Diagnostics(lpparam);    // 修复 #3/#4 + 诊断钩子（仅 B6X）
        hookCommonDisconnect(lpparam);                // 公共 BLE 断联（双设备）
        hookRunFetchLoopCpuFix(lpparam);              // runFetchLoop CPU 满载修复（双设备）
        if (appKind == 6) hookB6Activity(lpparam);       // 唤醒 + 自动进入设置界面（仅 B6X）
        hookWaspWingManagerCapture(lpparam);          // 捕获 WaspWingManager 实例（双设备）
        hookSyncConnectedController(lpparam);         // static controller 同步到已连接实例（仅 B6X）
        if (appKind == 7) hookB7Obfuscated(lpparam);     // c0.s1 + 混淆适配（仅 B7X）
        hookApplicationCreate(lpparam);               // 广播接收器 + 定时状态写入（双设备）
        hookAutoLaunch(lpparam);                      // 自动拉起标志 → Activity 后台化（双设备）
    }

    // ========== 各 Hook 分区实现 ==========

    /**
     * 标准 hook 样板：loadClass + findAndHookMethod + 日志。
     * loadClass 或 findAndHookMethod 抛错都打 failLog。
     * successLog 传 null 时不打成功日志。
     */
    private static void hookClassMethod(ClassLoader cl, String className, String methodName,
                                        String successLog, String failLog,
                                        Object... parameterTypesAndCallback) {
        try {
            Class<?> clazz = cl.loadClass(className);
            XposedHelpers.findAndHookMethod(clazz, methodName, parameterTypesAndCallback);
            if (successLog != null) {
                XposedBridge.log(TAG + " 已钩住 " + successLog);
            }
        } catch (Throwable t) {
            XposedBridge.log(TAG + " " + failLog + ": " + t.getMessage());
        }
    }

    /** 修复 #1：控制器层 — 设备连接后停扫描（双设备共用） */
    private static void hookControllerStopScan(XC_LoadPackage.LoadPackageParam lpparam) {
        hookClassMethod(lpparam.classLoader, "com.flydigi.sdk.bluetooth.AbstractBluetoothController",
                "onDeviceConnected", "AbstractBluetoothController.onDeviceConnected", "钩控制器失败",
                BluetoothDevice.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        try {
                            // 先记录连接状态，再停扫描
                            markConnected(null);  // onDeviceConnected 无 gatt 参数，不保存设备引用
                            try {
                                Object controller = param.thisObject;
                                XposedHelpers.callMethod(controller, "stopScan");
                                XposedHelpers.setBooleanField(controller, "inScanning", false);
                            } catch (Throwable t) {
                                XposedBridge.log(TAG + " 控制器停扫描失败(忽略): " + t.getMessage());
                            }
                            XposedBridge.log(TAG + " 控制器：扫描已停止，" + getDeviceLabel() + " BLE 已连接");
                            writeStatusFile();  // 连接事件立刻写 status 文件
                        } catch (Throwable t) {
                            XposedBridge.log(TAG + " 控制器修复异常: " + t.getMessage());
                        }
                    }
                });
    }

    /** 修复 #2（仅 B6X）：ViewModel 层连接后更新 LiveData */
    private static void hookB6ViewModelFix(XC_LoadPackage.LoadPackageParam lpparam) {
        hookClassMethod(lpparam.classLoader, "com.example.extool.BluetoothViewModel",
                "onDeviceConnected", "BluetoothViewModel.onDeviceConnected", "钩 BluetoothViewModel 失败",
                BluetoothDevice.class, new XC_MethodHook() {
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

                                // BluetoothViewModel extends ViewModel，无该字段
                                // 该字段在 WaspWingViewModel 上；回传由 onDeviceInfoUpdate 接管
                            }

                            XposedBridge.log(TAG + " ViewModel 修复完成");
                        } catch (Throwable t) {
                            XposedBridge.log(TAG + " ViewModel 修复异常: " + t.getMessage());
                        }
                    }
                });
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

            // === 修复 #4：强制 checkBluetoothPermission 返回 true ===
            XposedHelpers.findAndHookMethod(leCtrl, "checkBluetoothPermission",
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            param.setResult(true);
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 checkBluetoothPermission（强制返回 true）");

            // ===== 诊断钩子（调试用，保留） =====
            // 公共断连钩子（BluetoothGatt.disconnect 双设备通用）已覆盖。

            // 诊断 0：BluetoothGatt.discoverServices() — 验证是否被调用
            XposedHelpers.findAndHookMethod(
                    BluetoothGatt.class, "discoverServices",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            if (!diagConnLogAllowed()) return;
                            BluetoothGatt gatt = (BluetoothGatt) param.thisObject;
                            String devName = gatt.getDevice() != null
                                    ? gatt.getDevice().getName() : "null";
                            XposedBridge.log(TAG + " [诊断] discoverServices 被调用"
                                    + " device=" + devName);
                        }
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            if (!diagConnLogAllowed()) return;
                            Object result = param.getResult();
                            XposedBridge.log(TAG + " [诊断] discoverServices 返回 "
                                    + (result != null ? result : "null"));  // L9：防御 getResult() 为 null
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 BluetoothGatt.discoverServices");

            // 诊断 3a：LeDataInteractionController.connect()
            XposedHelpers.findAndHookMethod(leCtrl, "connect",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            if (!diagConnLogAllowed()) return;
                            Object ctrl = param.thisObject;
                            Object dev = XposedHelpers.callMethod(ctrl, "getMBluetoothDevice");
                            int state = XposedHelpers.getIntField(ctrl, "mDataConnectState");
                            XposedBridge.log(TAG + " [诊断] connect() 进入"
                                    + " device=" + (dev != null ? dev.toString() : "null")
                                    + " state=" + state);
                        }
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            if (!diagConnLogAllowed()) return;
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
                                if (diagConnLogAllowed())
                                    XposedBridge.log(TAG + " BLE 断联（onConnectionStateChange）"
                                            + " device=" + (lastDevice != null ? lastDevice.getAddress() : "null"));
                                writeStatusFile();  // 远程断连立刻写 status 文件
                            }
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 GattCallback.onConnectionStateChange（远程断联检测）");

            // 诊断 3d：controller 的 onGattConnected
            XposedHelpers.findAndHookMethod(wingCtrl, "onGattConnected",
                    BluetoothGatt.class, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            BluetoothGatt gatt = (BluetoothGatt) param.args[0];
                            // 重连路径也刷新 CONNECTED_AT；并保存设备引用
                            markConnected(gatt);
                            autoEnterSetup();  // 引导页可见时自动进入设置界面
                            // [底层]：GATT 层连接确认；同一次连接的权威日志在控制器层 onDeviceConnected
                            XposedBridge.log(TAG + " [底层] BLE 已连接（onGattConnected）"
                                    + " device=" + (lastDevice != null ? lastDevice.getAddress() : "null"));
                            writeStatusFile();  // 连接事件立刻写 status 文件
                            // 检查 discoverServices 结果（诊断：常态输出）
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
                            lastWaspWingInfo = info;    // 捕获散热器全参数回传
                            reconnectPending = false;   // 收到新回传，重连新鲜度验证通过
                            stallReconnectCount = 0;    // 设备恢复响应，清零连续无回传重连计数
                            updateModelFromInfo(info);  // 型号识别 + 同步 BLE_OWNER_LAST
                            // 改 experimentalRunModeValue 使 self-repair 跳过；须在原方法前
                            blockSelfRepair(info);
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 SDK WaspwingViewModel.onDeviceInfoUpdate（beforeHook）");

            // App 层 WaspWingViewModel.onDeviceInfoUpdate — 自修复
            // 方法先 postValue 再查 experimentalRunModeValue；须在原方法前
            XposedHelpers.findAndHookMethod(appVm, "onDeviceInfoUpdate",
                    waspInfoCls, new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            Object info = param.args[0];
                            lastWaspWingInfo = info;
                            reconnectPending = false;   // 收到新回传，重连新鲜度验证通过
                            stallReconnectCount = 0;    // 设备恢复响应，清零连续无回传重连计数
                            updateModelFromInfo(info);  // 型号识别 + 同步 BLE_OWNER_LAST
                            // 设 experimentalRunModeValue = realCold + 1，防自修
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
                            // 断连保留 CONNECTED_AT / BLE_OWNER_LAST（上次连接信息供仲裁）
                            markDisconnected((BluetoothGatt) param.thisObject);
                            // [底层]：本地 disconnect；权威在 onConnectionStateChange
                            if (diagConnLogAllowed())
                                XposedBridge.log(TAG + " [底层] BLE 断联 device="
                                        + (lastDevice != null ? lastDevice.getAddress() : "null"));
                            writeStatusFile();  // 断连事件立刻写 status 文件
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 BluetoothGatt.disconnect（双设备通用）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 BluetoothGatt.disconnect 失败: " + t.getMessage());
        }
    }

    /** 修复 DefaultDispatcher 线程 100% CPU */
    private static void hookRunFetchLoopCpuFix(XC_LoadPackage.LoadPackageParam lpparam) {
        // runFetchLoop 在命令队列为空时无限循环 peek()，无协程挂起点，占满一个核心。
        // 在构造函数中替换队列；用 hookAllConstructors 捕获所有子类构造。
        try {
            Class<?> absCtrl = lpparam.classLoader.loadClass(
                    "com.flydigi.sdk.bluetooth.AbstractDataInteractionController");
            // 用 hookAllConstructors 而非 findAndHookMethod(<init>)
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

                        XposedBridge.log(TAG + " runFetchLoop 队列已替换（空待 sleep 50ms）");
                    } catch (Throwable t) {
                        XposedBridge.log(TAG + " runFetchLoop 队列替换失败: " + t.getMessage());
                    }
                }
            });
            XposedBridge.log(TAG + " 已钩住 AbstractDataInteractionController 构造"
                    + "（修复 runFetchLoop CPU 满载）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 AbstractDataInteractionController 失败: " + t.getMessage());
        }
    }

    /** B6X 专属：智能温控唤醒 + 启动自动进入设置界面 */
    private static void hookB6Activity(XC_LoadPackage.LoadPackageParam lpparam) {
        // ========== 智能温控唤醒：B6ExperimentalActivity.onResume
        hookClassMethod(lpparam.classLoader, "com.example.extool.B6ExperimentalActivity",
                "onResume", "B6ExperimentalActivity.onResume", "钩 B6ExperimentalActivity 失败",
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

        // ========== B6X 启动自动进入设置界面（事件驱动） ==========
        // 钩 Activity 基类生命周期，isMainActivity 识别 MainActivity；
        // enteredSetup：已进入设置则不再自动跳
        try {
            XposedHelpers.findAndHookMethod(android.app.Activity.class, "onResume", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    if (isMainActivity(param.thisObject)) {
                        currentGuideActivity = (Activity) param.thisObject;
                        autoEnterSetup();  // 已连接则立即跳；未连接则等 onGattConnected 触发
                        autoStartSetup();  // 冷启动自动进入设置界面；其 onResume 会 tryConnect()
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
            if (appKind == 6) {
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
            if (appKind == 7) {
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

    /**
     * static dataInteractionController 只在 init 赋值。
     * 钩 onGattConnected 把 static 同步到当前实例（state=2）。
     */
    private static void hookSyncConnectedController(XC_LoadPackage.LoadPackageParam lpparam) {
        if (appKind != 6) return;  // 仅 B6X（B7X 走 hookB7Obfuscated 的 H1 连接状态修正）
        try {
            Class<?> ctrlCls = lpparam.classLoader.loadClass(
                    "com.flydigi.sdk.bluetooth.LeDataInteractionController");
            Class<?> mgrCls = lpparam.classLoader.loadClass(
                    "com.flydigi.sdk.waspwing.WaspWingManager");
            XposedHelpers.findAndHookMethod(ctrlCls, "onGattConnected",
                    BluetoothGatt.class, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            try {
                                // thisObject = 刚完成 GATT 连接的 controller（state=2）
                                XposedHelpers.setStaticObjectField(mgrCls,
                                        "dataInteractionController", param.thisObject);
                                // 记录连接实例 + 有效 gatt，供下发前校验 static 指向（防锁死）
                                BluetoothGatt gatt = (BluetoothGatt) param.args[0];
                                currentValidGatt = gatt;
                                connectedControllers.put(param.thisObject, gatt);
                                int st = XposedHelpers.getIntField(param.thisObject, "mDataConnectState");
                                XposedBridge.log(TAG + " dataInteractionController 已同步到已连接实例 state=" + st);
                            } catch (Throwable t) {
                                XposedBridge.log(TAG + " 同步 dataInteractionController 失败: " + t.getMessage());
                            }
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 LeDataInteractionController.onGattConnected（static 同步修复）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 onGattConnected 失败: " + t.getMessage());
        }
    }

    /** B7X 专属：c0.s1() 权限修复 + 完整混淆适配 */
    private static void hookB7Obfuscated(XC_LoadPackage.LoadPackageParam lpparam) {
        // ========== c0.s1() 权限检查强制 true（Android 16 连接失败）
        // c0.s1() 检查 BLUETOOTH_CONNECT 权限，A16 返回 false
        hookClassMethod(lpparam.classLoader, "com.flydigi.sdk.bluetooth.c0",
                "s1", "c0.s1()（强制返回 true，修复 b7x 连接）", "钩 c0.s1() 失败",
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        param.setResult(true);   // 跳过 BLUETOOTH_CONNECT 权限检查，让连接流程走完
                    }
                });

        // ========== B7X 完整混淆适配 ==========
        // com.flydigi.sdk.waspwing.a（混淆类 controller）
        //   a.S1(BluetoothGatt)：GATT 连接成功点 → H1 连接状态 + H2 型号识别
        //   a.T1(BluetoothGatt)：GATT 断连统一入口（远程+本地）→ M7
        //   a.Z0(UUID,byte[])：特征分发（this.X=最新 Info）→ H2 + 回传
        //   构造钩子：捕获控制器实例，供 H4 后台重连调用 T0()（重连其存储的 M() 设备）

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
        hookClassMethod(lpparam.classLoader, "com.flydigi.sdk.waspwing.a",
                "S1", "b7x a.S1（连接状态 + 型号识别）", "钩 b7x a.S1 失败",
                BluetoothGatt.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        try {
                            // 型号未知按包名兜底，随后 X.getDeviceCode() 修正
                            markConnected((BluetoothGatt) param.args[0]);
                            captureInfoFromController(param.thisObject);
                            // static controller(f50991b) 只在 init 赋值
                            // （E≠2 时命令被丢弃）；连接成功时同步 static 到当前实例（E 已=2）
                            try {
                                Class<?> mgrCls7 = lpparam.classLoader.loadClass("t9.j");
                                XposedHelpers.setStaticObjectField(mgrCls7, "f50991b", param.thisObject);
                                // 记录连接实例 + 有效 gatt（B7X 字段 I），供下发前校验防锁死
                                currentValidGatt = (BluetoothGatt) param.args[0];
                                connectedControllers.put(param.thisObject, (BluetoothGatt) param.args[0]);
                                int st = XposedHelpers.getIntField(param.thisObject, "E");
                                XposedBridge.log(TAG + " b7x dataInteractionController 已同步到已连接实例 state=" + st);
                            } catch (Throwable t) {
                                XposedBridge.log(TAG + " b7x 同步 dataInteractionController 失败: " + t.getMessage());
                            }
                            XposedBridge.log(TAG + " b7x BLE 已连接（a.S1） device="
                                    + (lastDevice != null ? lastDevice.getAddress() : "null")
                                    + " model=" + connectedModel);
                            writeStatusFile();
                        } catch (Throwable t) {
                            XposedBridge.log(TAG + " b7x S1 钩子异常: " + t.getMessage());
                        }
                    }
                });

        // H2：数据分发 → 刷新回传 + 型号修正（7→6）+ 同步 owner
        hookClassMethod(lpparam.classLoader, "com.flydigi.sdk.waspwing.a",
                "Z0", "b7x a.Z0（数据回传 + 型号识别）", "钩 b7x a.Z0 失败",
                UUID.class, byte[].class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        captureInfoFromController(param.thisObject);
                    }
                });

        // M7：断连（远程/本地统一入口 a.T1）→ 置未连接 + 写状态
        hookClassMethod(lpparam.classLoader, "com.flydigi.sdk.waspwing.a",
                "T1", "b7x a.T1（断连检测）", "钩 b7x a.T1 失败",
                BluetoothGatt.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        try {
                            markDisconnected((BluetoothGatt) param.args[0]);
                            if (diagConnLogAllowed())
                                XposedBridge.log(TAG + " b7x BLE 断联（a.T1） device="
                                        + (lastDevice != null ? lastDevice.getAddress() : "null"));
                            writeStatusFile();
                        } catch (Throwable t) {
                            XposedBridge.log(TAG + " b7x T1 钩子异常: " + t.getMessage());
                        }
                    }
                });
    }

    /** 广播接收器注册 + 定时状态写入 */
    private static void hookApplicationCreate(XC_LoadPackage.LoadPackageParam lpparam) {
        // 成功日志留空：注册成功后不打日志
        hookClassMethod(lpparam.classLoader, "android.app.Application", "onCreate",
                null, "钩 Application.onCreate 失败",
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        Context ctx = (Context) param.thisObject;
                        registerTemperatureReceiver(ctx);
                        restoreLastDevice();   // 冷启动恢复上次设备引用，后台重连自动接管
                        startPeriodicStatusWrite();
                    }
                });
    }

    // ========== 上次设备持久化 + 自动拉起后台化 ==========

    /** 持久化上次连接的散热器 MAC（供冷启动自动连接 / 自动拉起使用） */
    private static void saveLastDeviceAddress(String addr) {
        try {
            // 用 FileOutputStream 直写地址并补 \n；读取时 trim
            FileOutputStream fos = new FileOutputStream(LAST_DEV_FILE);
            fos.write((addr + "\n").getBytes());
            fos.close();
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 保存设备 MAC 失败: " + t.getMessage());
        }
    }

    /** 读取持久化的上次设备 MAC；无记录返回 null */
    private static String loadLastDeviceAddress() {
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(LAST_DEV_FILE));
            String line = br.readLine();
            br.close();
            return (line != null && !line.trim().isEmpty()) ? line.trim() : null;
        } catch (Throwable t) {
            // 冷启动读取失败（每进程一次，低频）：区分"无记录"与"读文件异常"
            XposedBridge.log(TAG + " 读取上次设备 MAC 失败: " + LAST_DEV_FILE
                    + " 异常类型=" + t.getClass().getSimpleName()
                    + " msg=" + t.getMessage());
            return null;
        }
    }

    /** 冷启动恢复上次设备引用，使后台自动重连在启动后即可工作 */
    private static void restoreLastDevice() {
        if (lastDevice != null || bleConnected) return;
        String addr = loadLastDeviceAddress();
        if (addr == null) return;
        try {
            BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
            if (adapter == null) return;
            lastDevice = adapter.getRemoteDevice(addr);
            XposedBridge.log(TAG + " 已恢复上次设备 " + addr + "，后台重连将自动接管");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 恢复上次设备失败: " + t.getMessage());
        }
    }

    /** 自动拉起：读到 b6x_auto_launch 后非引导页 onResume 后台化 */
    private static void hookAutoLaunch(XC_LoadPackage.LoadPackageParam lpparam) {
        try {
            XposedHelpers.findAndHookMethod(Activity.class, "onCreate", Bundle.class,
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            try {
                                Activity act = (Activity) param.thisObject;
                                Intent intent = act.getIntent();
                                if (intent != null && "1".equals(intent.getStringExtra(AUTO_LAUNCH_EXTRA))) {
                                    intent.removeExtra(AUTO_LAUNCH_EXTRA);  // 只后台化一次
                                    autoLaunchPending = true;
                                    scheduleAutoLaunchTimeout(act);  // 兜底：自动进入设置失败时仍退后台
                                }
                            } catch (Throwable t) {
                                XposedBridge.log(TAG + " auto_launch 标志读取失败: " + t.getMessage());
                            }
                        }
                    });
            XposedHelpers.findAndHookMethod(Activity.class, "onResume", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    if (!autoLaunchPending) return;
                    Activity act = (Activity) param.thisObject;
                    if (isMainActivity(act)) return;   // 引导页：等自动跳转到设置界面后再退后台
                    // 已离开引导页（B6X=进入设置界面；farsef 无引导页概念，首个 Activity 即退）
                    autoLaunchPending = false;
                    cancelAutoLaunchTimeout();
                    backgroundActivity(act);
                }
            });
            XposedBridge.log(TAG + " 已钩住 Activity.onCreate/onResume（b6x_auto_launch 后台化）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 auto_launch 失败: " + t.getMessage());
        }
    }

    /** 自动拉起：把当前任务切到后台（界面已就绪；连接由后台重连线程完成） */
    private static void backgroundActivity(final Activity act) {
        // 延迟 AUTO_BACKGROUND_DELAY_MS 再切后台：留 1s 缓冲
        mainHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    act.moveTaskToBack(true);
                    XposedBridge.log(TAG + " 自动拉起模式：app 已切后台");
                } catch (Throwable t) {
                    XposedBridge.log(TAG + " auto_launch 后台化失败: " + t.getMessage());
                }
            }
        }, AUTO_BACKGROUND_DELAY_MS);
    }

    // 兜底超时：自动进入设置界面未触发（startActivity 失败等）时 2s 后仍退后台
    private static Runnable autoLaunchTimeoutRunnable = null;

    private static void scheduleAutoLaunchTimeout(final Activity act) {
        cancelAutoLaunchTimeout();
        autoLaunchTimeoutRunnable = new Runnable() {
            @Override
            public void run() {
                autoLaunchTimeoutRunnable = null;
                if (!autoLaunchPending) return;
                autoLaunchPending = false;
                backgroundActivity(act);
            }
        };
        mainHandler().postDelayed(autoLaunchTimeoutRunnable, AUTO_LAUNCH_TIMEOUT_MS);
    }

    private static void cancelAutoLaunchTimeout() {
        if (autoLaunchTimeoutRunnable != null) {
            mainHandler().removeCallbacks(autoLaunchTimeoutRunnable);
            autoLaunchTimeoutRunnable = null;
        }
    }

    // ========== 辅助 ==========

    // ========== B6X/B7X SDK 字段名分流 ==========
    /** static 字段名：B6X 原名，B7X=f50991b */
    private static String dicFieldName() { return (appKind == 7) ? "f50991b" : "dataInteractionController"; }
    /** 状态字段名：B6X=mDataConnectState，B7X=E */
    private static String stateFieldName() { return (appKind == 7) ? "E" : "mDataConnectState"; }
    /** gatt 字段名：B6X=mBluetoothGatt，B7X=I */
    private static String gattFieldName() { return (appKind == 7) ? "I" : "mBluetoothGatt"; }

    /** 连接者编码：B6X=1/2（老/新 app），farsef=型号(6/7) */
    private static int bleOwnerCode() {
        if (appKind == 7)
            return (connectedModel == 6 || connectedModel == 7) ? connectedModel : 7;
        return isNewB6App ? 2 : 1;
    }

    /** 从 getDeviceCode() 映射型号：b6→6, b7→7，未知→0 */
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
     * connectedModel 被修正时（如 7→6）同步重算 BLE_OWNER_LAST；
     * 仅当已连接且 owner 值变化时更新，时间保持连接时间。
     */
    private static void refreshLastOwnerIfNeeded() {
        if (bleConnected && bleOwnerCode() != bleLastOwner) {
            bleLastOwner = bleOwnerCode();
            XposedBridge.log(TAG + " BLE_OWNER_LAST 已修正 -> " + bleLastOwner);
        }
    }

    /**
     * 调用 WaspWingManager.setRunMode。
     * WaspWingManager：B6X 的 setRunMode，B7X 混淆为 W
     */
    private static void invokeSetRunMode(Object inst, int mode, int temperature, int windOC,
                                        int coldOC, int windLevel, int modeCustom, int extra) {
        // 下发前确保 static 指向 gatt 有效实例；否则命令被静默丢弃
        if (!ensureUsableController(inst)) {
            XposedBridge.log(TAG + " setRunMode 跳过: static controller 不可用（已触发重连，下周期重试）");
            return;
        }

        // 状态自愈兜底：GATT 已就绪但 state≠2 时强制同步 state=2
        try {
            // P2.15: 字段名由常量表按 app 类型选择
            String dicField = dicFieldName(), stateField = stateFieldName(), gattField = gattFieldName();
            Object dic = XposedHelpers.getStaticObjectField(inst.getClass(), dicField);
            if (dic != null) {
                int st = XposedHelpers.getIntField(dic, stateField);
                Object gatt = XposedHelpers.getObjectField(dic, gattField);
                if (st != 2 && gatt != null) {
                    XposedHelpers.setIntField(dic, stateField, 2);
                    XposedBridge.log(TAG + " 状态自愈: static controller state " + st + "→2（gatt 已就绪）");
                } else if (st == 0 && gatt == null) {
                    XposedBridge.log(TAG + " setRunMode 警告: static controller 未连接(state=0,gatt=null)");
                }
            }
        } catch (Throwable t) {
            // 字段缺失/不可访问时忽略（不影响 setRunMode 主流程）
        }
        String[] names = (appKind == 7)
                ? new String[]{"setRunMode", "W"}
                : new String[]{"setRunMode"};
        Throwable last = null;
        for (String n : names) {
            try {
                XposedHelpers.callMethod(inst, n, mode, temperature, windOC, coldOC,
                        windLevel, modeCustom, extra);
                // 记录最近下发目标（锁死检测基准：目标≠回传且停滞时判定锁死）；仅 callMethod 成功后更新
                lastBcastColdLv = coldOC;
                lastBcastRpmLv = (mode == 0) ? windLevel : windOC;
                dispatchStallCount++;   // 锁死检测：累计下发次数（回传到位/变化时由 checkCommandStall 清零）
                // 下发成功日志每连最多 DIAG_LOG_MAX_PER_CONN 条
                if (setRunModeLogCount < DIAG_LOG_MAX_PER_CONN) {
                    setRunModeLogCount++;
                    XposedBridge.log(TAG + " setRunMode 已下发 method=" + n
                            + " mode=" + mode + " temp=" + temperature
                            + " windOC=" + windOC + " coldOC=" + coldOC
                            + " windLv=" + windLevel + " modeCustom=" + modeCustom
                            + " extra=" + extra);
                }
                return;
            } catch (Throwable t) {
                last = t;
            }
        }
        XposedBridge.log(TAG + " setRunMode 失败: " + (last != null ? last.getMessage() : "无此方法"));
    }

    /**
     * 校验 static dataInteractionController 指向实例的 gatt。
     * 有效 = 实例 gatt 与 currentValidGatt 是同一对象。
     * 失效时从 connectedControllers 找回实例重同步；否则强制重连。
     */
    private static boolean ensureUsableController(Object inst) {
        try {
            // P2.15: 字段名由常量表按 app 类型选择
            String dicField = dicFieldName(), gattField = gattFieldName();
            Object dic = XposedHelpers.getStaticObjectField(inst.getClass(), dicField);
            if (dic == null) {
                forceReconnect();
                return false;
            }
            Object gatt = XposedHelpers.getObjectField(dic, gattField);
            if (gatt != null && gatt == currentValidGatt) return true;  // static 指向有效实例

            // static 指向的 gatt 失效：找回 currentValidGatt 对应实例并重新同步
            for (ConcurrentHashMap.Entry<Object, BluetoothGatt> e : connectedControllers.entrySet()) {
                if (e.getValue() == currentValidGatt) {
                    XposedHelpers.setStaticObjectField(inst.getClass(), dicField, e.getKey());
                    XposedBridge.log(TAG + " ensureUsableController: static 已重新同步到有效实例（gatt 失效恢复）");
                    return true;
                }
            }
            // 当前 gatt 也失效（已断连）：触发重连
            forceReconnect();
            return false;
        } catch (Throwable t) {
            // 字段缺失/不可访问时保守放行（保持原行为，不影响 setRunMode 主流程）
            return true;
        }
    }

    /** 强制重新连接（10s 防抖）：断 gatt → 清队列 → 置断连 → 后台重连接管。 */
    private static void forceReconnect() {
        long now = System.currentTimeMillis();
        if (now - lastForceReconnectAt < FORCE_RECONNECT_MIN_INTERVAL_MS) return;
        lastForceReconnectAt = now;
        clearCommandQueue();  // 重连前清空堆积的无效命令（断连期入队的命令写在旧 gatt 上必然失败）
        try {
            BluetoothGatt g = currentValidGatt;
            if (g != null) g.disconnect();
        } catch (Throwable t) { /* 断开失败忽略 */ }
        markDisconnected(currentValidGatt);  // 置 bleConnected=false，后台重连线程检测后自动接管
        XposedBridge.log(TAG + " forceReconnect: 已触发重新连接（gatt 失效/锁死自愈）");
    }

    /**
     * 重连成功后无新回传 → 分层处置：唤醒 → 重连上限 → 强制重启 App 提示。
     * 由 checkCommandStall 的"回传新鲜度验证"分支调用（每秒最多一次）。
     */
    private static void handleDeviceNoResponse() {
        long now = System.currentTimeMillis();
        // ① 先尝试设备唤醒序列（mode0 关制冷 → 触发固件重新处理命令）
        if (wakeupAttempts < WAKEUP_MAX && now - lastWakeupAttemptAt >= WAKEUP_RETRY_MIN_INTERVAL_MS) {
            wakeupAttempts++;
            lastWakeupAttemptAt = now;
            reconnectPending = true;      // 重置等待，唤醒后重新计时
            connectStartedAt = now;
            dispatchStallCount = 0;
            XposedBridge.log(TAG + " 设备无回传（重连后 " + INFO_STALE_AFTER_MS / 1000
                    + "s 无新数据），尝试唤醒序列 mode0→1");
            invokeDeviceWakeup();
            return;
        }
        // ② 唤醒无效 → 计为重连无效，达上限 → 设备固件锁死
        if (stallReconnectCount < STALL_RECONNECT_MAX) {
            stallReconnectCount++;
            reconnectPending = true;
            connectStartedAt = now;
            dispatchStallCount = 0;
            XposedBridge.log(TAG + " 设备无回传重连 #" + stallReconnectCount + "/" + STALL_RECONNECT_MAX
                    + "（唤醒无效），触发重连");
            forceReconnect();
            return;
        }
        // ③ 达上限：设备锁死，停止自动重连 + 写状态文件提示强制重启 App
        reconnectPending = false;
        if (!deviceLockedAlerted) {
            deviceLockedAlerted = true;
            XposedBridge.log(TAG + " 设备锁死: 连续 " + STALL_RECONNECT_MAX
                    + " 次重连仍无回传，停止自动重连，请强制重启 App（散热器重启无效）");
            try {
                FileOutputStream fos = new FileOutputStream(currentStatusFile, true);
                fos.write("DEVICE_LOCKED=1\n".getBytes());
                fos.close();
            } catch (Throwable t) { /* 状态文件写入失败忽略 */ }
        }
    }

    /** 异步下发 mode0（关制冷）尝试唤醒固件；tempctrl 会恢复 mode1 */
    private static void invokeDeviceWakeup() {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(300);   // 等当前命令处理完
                Object inst = capturedWaspWingMgr;
                if (inst != null) {
                    invokeSetRunMode(inst, 0, 0, 0, 0, 0, 0, 0);   // mode=0 固定功率/关制冷
                } else {
                    XposedBridge.log(TAG + " 唤醒序列失败: WaspWingManager 实例未就绪");
                }
            } catch (Throwable t2) { /* 唤醒失败忽略 */ }
        });
        t.setDaemon(true);
        t.start();
    }

    /**
     * 锁死检测——双信号并行判断、独立处置：
     * ① 队列堆积 > 阈值 → runFetchLoop 疑似崩溃，启动守护线程接管；
     * ② 回传停滞且累计 3 次下发未生效 → 强制重连；两信号可同时触发。
     */
    private static void checkCommandStall() {
        // 设备固件锁死已判定 → 完全退出锁死检测，旧值停滞判定不再触发 forceReconnect
        if (deviceLockedAlerted) { dispatchStallCount = 0; return; }
        if (!bleConnected || lastWaspWingInfo == null) { dispatchStallCount = 0; return; }
        try {
            // ═══ 回传新鲜度验证（先于值停滞判定）═══
            // 重连后长时间无新 onDeviceInfoUpdate → 无回传，仍是旧缓存；
            // 此时值停滞判定会误判并无限重连。
            if (reconnectPending && System.currentTimeMillis() - connectStartedAt > INFO_STALE_AFTER_MS) {
                handleDeviceNoResponse();
                return;   // 设备无响应期间不做旧值停滞判定
            }
            int cold = ((Number) XposedHelpers.callMethod(lastWaspWingInfo, "getRealColdLevel")).intValue();
            int rpm = ((Number) XposedHelpers.callMethod(lastWaspWingInfo, "getRealWindLevel")).intValue();
            // 回传已到位（与最近下发目标一致）→ 完全正常，清零
            if (cold == lastBcastColdLv && rpm == lastBcastRpmLv) {
                dispatchStallCount = 0;
                stallLastCold = cold;
                stallLastRpm = rpm;
                return;
            }
            // ═══ 双信号并行判断、独立处置 ═══
            boolean queueStalled = getCommandQueueSize() > QUEUE_STALL_THRESHOLD;
            boolean deviceStalled = (cold == stallLastCold && rpm == stallLastRpm
                    && dispatchStallCount >= DISPATCH_STALL_LIMIT && lastBcastColdLv >= 0);

            // ① 队列堆积 → 消费协程疑似崩溃，守护线程接管消费（不再依赖重连）
            if (queueStalled) startConsumerThreadIfNeeded();
            // ② 回传停滞 ≥ 3 次下发 → 连接/设备问题，强制重连（与 ① 可同时触发）
            if (deviceStalled) {
                XposedBridge.log(TAG + " 锁死检测: " + DISPATCH_STALL_LIMIT + " 次下发后回传停滞 冷" + cold
                        + " RPM" + rpm + " ≠ 目标 冷" + lastBcastColdLv + " RPM" + lastBcastRpmLv
                        + "，触发重连自愈");
                dispatchStallCount = 0;
                forceReconnect();
            }
            // 两个信号均未触发：回传在变 → 追赶中，清零；停滞但未满 3 次 → 继续累计
            if (!queueStalled && !deviceStalled) {
                if (cold != stallLastCold || rpm != stallLastRpm) {
                    stallLastCold = cold;
                    stallLastRpm = rpm;
                    dispatchStallCount = 0;
                }
            }
        } catch (Throwable t) { /* 回传读取失败忽略 */ }
    }

    /** 读 static controller 实例；失败 null */
    private static Object getStaticController() {
        if (capturedWaspWingMgr == null) return null;
        String dicField = dicFieldName();   // P2.15: 常量表按 app 类型选择
        try {
            return XposedHelpers.getStaticObjectField(capturedWaspWingMgr.getClass(), dicField);
        } catch (Throwable t) { return null; }
    }

    /** 当前命令队列大小（runFetchLoop 是否在消费的判据：堆积 = 消费停摆） */
    private static int getCommandQueueSize() {
        try {
            Object ctrl = getStaticController();
            if (ctrl == null) return 0;
            ConcurrentLinkedQueue<?> q = (ConcurrentLinkedQueue<?>) XposedHelpers.getObjectField(
                    ctrl, "mConcurrentLinkedQueue");
            return q != null ? q.size() : 0;
        } catch (Throwable t) { return 0; }
    }

    /** 清空命令队列（forceReconnect 前调用） */
    private static void clearCommandQueue() {
        try {
            Object ctrl = getStaticController();
            if (ctrl == null) return;
            ConcurrentLinkedQueue<?> q = (ConcurrentLinkedQueue<?>) XposedHelpers.getObjectField(
                    ctrl, "mConcurrentLinkedQueue");
            if (q != null) q.clear();
        } catch (Throwable t) { /* 队列不可用忽略 */ }
    }

    /**
     * 守护消费线程（幂等，10s 防抖，仅 B6X）：state==2 消费；
     * 单条异常 try-catch 不冒泡；B7X processData 已混淆，兜底不覆盖。
     */
    private static void startConsumerThreadIfNeeded() {
        if (appKind != 6) return;  // B7X processData 混淆，兜底暂不覆盖
        long now = System.currentTimeMillis();
        if (consumerThreadStarted
                || now - consumerThreadStartedAt < CONSUMER_START_MIN_INTERVAL_MS) return;
        consumerThreadStartedAt = now;
        try {
            final Class<?> rpCls = appClassLoader.loadClass(
                    "com.flydigi.sdk.bluetooth.data.RequestPack");
            final Method processData = findProcessDataMethod(rpCls);  // 沿继承链查找（声明在父类）
            if (processData == null) {
                XposedBridge.log(TAG + " 守护消费线程启动失败: 未找到 processData");
                return;
            }
            Thread t = new Thread(() -> {
                Object headSeen = null;    // 上次观察到的队首对象（P1.4 接管判定用）
                long headSeenAt = 0;       // 该队首对象首次被观察到的时刻（ms）
                while (true) {
                    try {
                        Object ctrl = getStaticController();
                        if (ctrl != null) {
                            int state = XposedHelpers.getIntField(ctrl, "mDataConnectState");
                            if (state == 2) {
                                ConcurrentLinkedQueue<?> q = (ConcurrentLinkedQueue<?>) XposedHelpers
                                        .getObjectField(ctrl, "mConcurrentLinkedQueue");
                                if (q != null) {
                                    // peek 只取一次存局部变量，消除"判断后二次 peek"的双消费窗口；
                                    // 接管仅当同一队首停留超过 QUEUE_TAKEOVER_MS。
                                    Object head = q.peek();
                                    long nowMs = System.currentTimeMillis();
                                    if (head != null && head == headSeen) {
                                        if (nowMs - headSeenAt > QUEUE_TAKEOVER_MS) {
                                            processData.invoke(ctrl, head);
                                        }
                                    } else {
                                        headSeen = head;   // 队首变化（含变空/换新）：刷新观察基准
                                        headSeenAt = nowMs;
                                    }
                                }
                            }
                        }
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        break;
                    } catch (Throwable t2) {
                        // 单条命令消费失败（gatt 失效等）忽略，继续下一轮——不冒泡保证线程不崩溃
                    }
                }
            });
            t.setDaemon(true);
            t.start();
            consumerThreadStarted = true;
            XposedBridge.log(TAG + " 守护消费线程已启动（runFetchLoop 崩溃接管，queue>"
                    + QUEUE_STALL_THRESHOLD + "）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 守护消费线程启动失败: " + t.getMessage());
        }
    }

    /** 查找 processData(RequestPack) 私有方法（B6X） */
    private static Method findProcessDataMethod(Class<?> rpCls) {
        try {
            Class<?> absCtrl = appClassLoader.loadClass(
                    "com.flydigi.sdk.bluetooth.AbstractDataInteractionController");
            Method m = absCtrl.getDeclaredMethod("processData", rpCls);
            m.setAccessible(true);
            return m;
        } catch (Throwable t) { /* 反射失败忽略 */ }
        return null;
    }

    /**
     * 判断对象是否为 B6X app 的 MainActivity（编译期无 app 类）。
     * 改用 app 类加载器 loadClass + isInstance（无子类）。
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
     * 引导页可见且 BLE 已连、本进程未进过设置界面时，自动进入设置界面。
     * onResume 与 onGattConnected 共用，runOnUiThread 保跳转。
     */
    private static void autoEnterSetup() {
        if (!bleConnected || enteredSetup || currentGuideActivity == null) return;
        final Activity act = currentGuideActivity;
        currentGuideActivity = null;  // 先清空去重
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

    /**
     * 冷启动自动进设置界面；B6ExpActivity.onResume 未连 tryConnect。
     * enteredSetup 防重入：已进入过 / 从设置返回时不触发。
     */
    private static void autoStartSetup() {
        if (enteredSetup || bleConnected || currentGuideActivity == null) return;
        final Activity act = currentGuideActivity;
        currentGuideActivity = null;  // 先清空去重
        try {
            final Class<?> b6ExpCls = act.getClassLoader()
                    .loadClass("com.example.extool.B6ExperimentalActivity");
            act.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Intent intent = new Intent(act, b6ExpCls);
                        act.startActivity(intent);
                        XposedBridge.log(TAG + " 冷启动自动进入设置界面（自动连接）");
                    } catch (Throwable t) {
                        XposedBridge.log(TAG + " 冷启动进入设置界面失败: " + t.getMessage());
                    }
                }
            });
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 冷启动进入设置界面 loadClass 失败: " + t.getMessage());
        }
    }

    /** 设备日志标签：b6x / b7x（小写） */
    private static String getDeviceLabel() {
        return (appKind == 7) ? "b7x" : "b6x";
    }

    /**
     * 获取 WaspWingManager 实例：优先构造函数捕获的实例，其次试单例静态方法，
     * 再试 Kotlin INSTANCE 字段与 B7X 混淆单例（t9.j.f50990a）。
     * 主类 loadClass 失败时向上抛异常，由调用方记录 setRunMode 异常。
     */
    private static Object resolveWaspWingManager(Context ctx) throws Throwable {
        Object inst = capturedWaspWingMgr;
        if (inst != null) return inst;

        // 构造函数还没触发过，试单例方式兜底（日志仅在首次兜底时输出一次）
        boolean firstFallback = !loggedResolveFallback;
        if (firstFallback) loggedResolveFallback = true;
        Class<?> mgrCls = ctx.getClassLoader().loadClass("com.flydigi.sdk.waspwing.WaspWingManager");
        String[] methods = {"getInstance", "get", "getDefault"};
        StringBuilder failed = new StringBuilder();
        for (String m : methods) {
            try {
                inst = XposedHelpers.callStaticMethod(mgrCls, m);
                if (inst != null) {
                    if (firstFallback) XposedBridge.log(TAG + " resolveWaspWingManager: 静态方法 " + m + " 成功");
                    break;
                }
            } catch (Throwable t) {
                if (firstFallback) XposedBridge.log(TAG + " resolveWaspWingManager: 静态方法 " + m + " 失败: " + t.getMessage());
                failed.append(m).append(' ');
            }
        }
        if (inst == null) {
            try {
                // Kotlin object singleton: ClassName.INSTANCE
                inst = XposedHelpers.getStaticObjectField(mgrCls, "INSTANCE");
                if (inst != null) {
                    if (firstFallback) XposedBridge.log(TAG + " resolveWaspWingManager: INSTANCE 字段成功");
                }
            } catch (Throwable t) {
                if (firstFallback) XposedBridge.log(TAG + " resolveWaspWingManager: INSTANCE 字段失败: " + t.getMessage());
                failed.append("INSTANCE ");
            }
        }
        if (inst == null && appKind == 7) {
            // (H3)：B7X 混淆管理器 t9.j 的 Kotlin 单例字段 f50990a（反编译确认）
            try {
                Class<?> mgrCls7 = ctx.getClassLoader().loadClass("t9.j");
                inst = XposedHelpers.getStaticObjectField(mgrCls7, "f50990a");
                if (inst != null) {
                    if (firstFallback) XposedBridge.log(TAG + " resolveWaspWingManager: t9.j.f50990a 成功");
                }
            } catch (Throwable t) {
                if (firstFallback) XposedBridge.log(TAG + " resolveWaspWingManager: t9.j.f50990a 失败: " + t.getMessage());
                failed.append("f50990a ");
            }
        }
        if (inst == null && firstFallback) {
            XposedBridge.log(TAG + " resolveWaspWingManager: 全部兜底失败 [" + failed.toString().trim() + "]");
        }
        return inst;
    }

    /**
     * 记录连接状态（时间戳、连接者、型号兜底）；gatt 非空时顺带保存设备引用供后台重连使用。
     * 由 BLE 回调线程调用，字段均 volatile（M4）。
     */
    private static void markConnected(BluetoothGatt gatt) {
        // P2.13: 记录上一连接状态，用于判断是否"断连→连接"翻转（决定唤醒次数是否重置）
        boolean wasConnected = bleConnected;
        bleConnected = true;
        diagLogCount = 0;            // 新连接：重置广播接收诊断计数（每连最多记录 DIAG_LOG_MAX_PER_CONN 对）
        setRunModeLogCount = 0;      // 新连接：重置"setRunMode 已下发"计数（每连最多 3 条）
        diagConnLogCount = 0;        // 新连接：重置连接诊断日志计数（每连最多 DIAG_CONN_LOG_MAX 条）
        loggedReconnectAttempt = false;  // 新连接：重置"后台重连尝试"一次性标记
        bleConnectedTimestamp = System.currentTimeMillis() / 1000L;
        if (connectedModel != 6 && connectedModel != 7)
            connectedModel = (appKind == 7) ? 7 : 6;  // 型号未知按包名兜底
        bleLastOwner = bleOwnerCode();
        bleLastOwnerAt = bleConnectedTimestamp;
        if (gatt != null && gatt.getDevice() != null) {
            lastDevice = gatt.getDevice();
            currentValidGatt = gatt;   // 记录当前有效 gatt（供下发前校验 static 指向）
            saveLastDeviceAddress(gatt.getDevice().getAddress());   // 持久化 MAC 供冷启动自动连接
        }
        // 重连后进入"等待新回传"验证（区分设备无响应 vs 旧缓存）；设备锁死提示随新连接重置
        reconnectPending = true;
        connectStartedAt = System.currentTimeMillis();
        // 仅断连→连接状态翻转时重置唤醒次数：同一会话内 markConnected 会多次触发，
        // 若每次清零唤醒上限形同虚设；仅真实重连（wasConnected=false）才重置。
        if (!wasConnected) {
            wakeupAttempts = 0;
        }
        deviceLockedAlerted = false;
    }

    /** 记录断连：清 BLE 标志 + 型号 + 有效 gatt，保存设备引用 */
    private static void markDisconnected(BluetoothGatt gatt) {
        bleConnected = false;
        connectedModel = 0;
        currentValidGatt = null;   // gatt 失效，下发前校验会重新同步/触发重连
        if (gatt != null) {
            // 断连时从 connectedControllers 移除该 gatt 对应条目；
            // 用迭代器而非 removeIf：兼容低版本 Android（removeIf 需 API24）
            Iterator<ConcurrentHashMap.Entry<Object, BluetoothGatt>> it =
                    connectedControllers.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue() == gatt) it.remove();
            }
        }
        if (gatt != null && gatt.getDevice() != null) {
            lastDevice = gatt.getDevice();
        }
    }

    /** 从 getDeviceCode() 识别型号并同步 BLE_OWNER_LAST */
    private static void updateModelFromInfo(Object info) {
        try {
            connectedModel = modelFromDeviceCode(
                    XposedHelpers.callMethod(info, "getDeviceCode"));
            refreshLastOwnerIfNeeded();  // (M3)：型号修正后同步 BLE_OWNER_LAST
        } catch (Throwable t) { /* 型号未知保持包名兜底 */ }
    }

    /** 修正 experimentalRunModeValue，使 self-repair 跳 */
    private static void blockSelfRepair(Object info) {
        try {
            Object realCold = XposedHelpers.callMethod(info, "getRealColdLevel");
            if (realCold != null) {
                XposedHelpers.setIntField(info, "experimentalRunModeValue",
                        ((Integer) realCold) + 1);
            }
        } catch (Throwable t) { /* 字段可能不存在 */ }
    }

    /** 读取控制器字段 X 的 WaspWingInfo：刷新回传 + 型号 + owner */
    private static void captureInfoFromController(Object ctrl) {
        try {
            Object info = XposedHelpers.getObjectField(ctrl, "X");
            if (info != null) {
                lastWaspWingInfo = info;
                // 收到新回传即视为"重连新鲜度验证通过"，清除重连待验标记与连续无回传计数。
                reconnectPending = false;
                stallReconnectCount = 0;    // 设备恢复响应，清零连续无回传重连计数
                updateModelFromInfo(info);
            }
        } catch (Throwable t) { /* X 字段不可用则保持包名兜底 */ }
    }

    /** 调用 getter，结果非 null 时追加 "KEY=value" 行 */
    private static void appendGetterValue(StringBuilder sb, Object info, String getter, String key) {
        Object value = XposedHelpers.callMethod(info, getter);
        if (value != null) {
            sb.append(key).append("=").append(value).append("\n");
        }
    }

    /** 调用 getter，结果非 null 时按 ×10 追加 "KEY=value" 行 */
    private static void appendTenthValue(StringBuilder sb, Object info, String getter, String key) {
        Object value = XposedHelpers.callMethod(info, getter);
        if (value != null) {
            sb.append(key).append("=").append(((Number) value).intValue() * 10).append("\n");
        }
    }
}
