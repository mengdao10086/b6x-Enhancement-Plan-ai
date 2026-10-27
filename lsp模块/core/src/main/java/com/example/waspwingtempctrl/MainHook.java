package com.example.waspwingtempctrl;

import android.app.Activity;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.lang.reflect.Method;
import java.util.UUID;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * 飞智散热器 — LSPosed 模块。
 * 模块功能、钩子清单与注册时机见 app/逻辑说明.md §1。
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
    // 界面开关标志文件（守护进程写、本进程读）；界面 → 钩子的唯一通道。
    // 跨进程通道说明见 app/逻辑说明.md §1.4，写入端见 tempctrl.c 的 UIPREFS_PATH。
    private static final String UIPREFS_FILE = "/data/local/tmp/tempctrl_uiprefs";
    // ===== 修复 #5：SDK 类型门禁放行（仅目标包、仅 connect() 执行期、仅目标地址）=====
    // 动机：冷启动只能凭地址重建设备对象，getType() 恒为 UNKNOWN，SDK 的 connect() 因此在
    //   发令前直接拒绝（日志 "current device is not a valid BLE device"），后台重连永不生效。
    // 边界与开关语义见 参数定义/params.def.json 的 UI_GATE_LE；结论依据见 app/逻辑说明.md §1.7。
    private static final String GATE_LE_PREFIX = "GATE_LE=";   // 界面开关（守护进程转写进 uiprefs）
    private static final long GATE_LE_CACHE_MS = 30 * 1000L;   // 开关缓存（读不到按默认=开）
    private static final ThreadLocal<Boolean> gateLeActive = new ThreadLocal<>();  // 仅 connect() 执行期置位
    private static volatile boolean gateLeCfg = true;          // 开关当前值（默认开）
    private static volatile long gateLeCfgAt = 0;              // 开关上次读取时刻（0=未读过）
    private static long gateLeLogAt = 0;                       // "门禁放行"日志限频
    // 修复 #4 的适用边界：-1=未知（按放行处理，保留 Android 16 修复）、1=已授予、0=未授予。
    // 全新安装时宿主尚未申请 BLUETOOTH_CONNECT，无条件放行会让 SDK 走到 connectGatt() 抛 SecurityException。
    private static volatile int btConnectPerm = -1;
    // 上次设备 MAC 落点（宿主 app 私有目录，各包各记，按包名拼死路径）。
    // 落点选择与冷启动自动连接的说明见 app/逻辑说明.md §1.6；在 handleLoadPackage 里赋值。
    private static String lastDevFile = null;
    private static final String AUTO_LAUNCH_EXTRA = "b6x_auto_launch";               // tempctrl 拉起 app 时携带的标志
    private static final String ACTION_TEMP_B6 = "com.flydigi.SET_TEMPERATURE";      // B6X 温控广播
    private static final String ACTION_TEMP_B7 = "com.flydigi.SET_TEMPERATURE_B7";   // B7X 温控广播
    // setRunMode 方法名候选（按 app 类型选；B7X 混淆为 W）
    private static final String[] SET_RUN_MODE_NAMES_B6 = {"setRunMode"};
    private static final String[] SET_RUN_MODE_NAMES_B7 = {"setRunMode", "W"};

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
    private static volatile boolean enteredSetup = false;         // 本前台会话是否已进入过设置界面
    // ========== 前台会话判定：每次进入前台跳一次设置页（见 app/逻辑说明.md §1.6）==========
    // resumedActivityCount：当前处于 resumed 的 Activity 数（0=无前台 Activity）。onResume +1 / onPause -1。
    private static final AtomicInteger resumedActivityCount = new AtomicInteger();
    // appBackgrounded：最后一个 Activity 停止且计数归零（非返回/旋转）→ 退后台待定标记；
    //   只武装、不改 enteredSetup，由下一次 onResume 按「设置页 / 引导页」两条路径消费。
    private static volatile boolean appBackgrounded = false;
    // setupResumeHookReady：设置页 onResume 钩子注册成功才启用复位机制；失败则退回进程级行为（降级不更坏）。
    private static volatile boolean setupResumeHookReady = false;

    // ========== B7X 自动进入控制页（farsef，见 app/逻辑说明.md §1.6）==========
    // 与 B6X 的 enteredSetup/appBackgrounded/resumedActivityCount 完全独立：进程内只会注册其中一条分支。
    private static volatile boolean b7EnteredControl = false;    // 本前台会话是否已进入过控制页
    private static volatile boolean b7AppBackgrounded = false;   // 整应用退到后台待定（只由 B7X 分支维护）
    private static volatile boolean b7AutoLaunchSession = false;  // 本次前台会话由守护进程拉起
    private static volatile Activity b7AutoEnterFrom = null;     // 本次自动跳转的发起 Activity（识别跳转引起的 onStop）
    private static final AtomicInteger b7ResumedCount = new AtomicInteger();  // 已 resumed 的 Activity 数（B7X 独立计数）
    private static volatile String lastWaspwingCodeCache = null;  // 上次散热器型号码（内存缓存，避免每包回传都落盘）
    private static String lastDevCodeFile = null;                 // 型号码落点（B7X 包私有目录，handleLoadPackage 赋值）
    private static volatile long b7AutoEnterLogAt = 0;            // 自动进入失败日志限频
    private static final long B7_AUTO_ENTER_LOG_MIN_INTERVAL_MS = 60000;
    private static final String B7_MAIN_ACTIVITY = "com.game.motionelf.activity.ActivityStart";
    private static final String B7_HOME_FRAGMENT = "com.flydigi.device_manager.ui.home.DeviceHomeFragment";
    private static final String B7_DETAIL_ACTIVITY = "com.flydigi.device_manager.ui.detail.DetailActivity";
    private static final String EXTRA_KEY_DEVICE_TYPE = "key_device_type";
    private static final String EXTRA_KEY_DEVICE_CODE = "key_device_code";
    private static final String EXTRA_IP_TYPE = "ip_type";

    // ========== 后台自动重连 ==========
    private static volatile BluetoothDevice lastDevice = null;      // 上次连接的 BLE 设备
    private static ClassLoader appClassLoader = null;      // App 类加载器（后台线程反射用）
    private static volatile boolean loggedReconnectSkip = false;    // 后台重连被跳过（控制器/类加载器未就绪）仅记一次
    private static volatile boolean needFreshObject = false;        // B：冷启动对象待换（取"类型已知"对象，markConnected 清）
    // 息屏退避用的屏幕状态（取法与缓存策略见 reconnectIntervalTicks）：
    // appContext 由 Application.onCreate 钩子（主线程）写、tick 线程读 → volatile；
    // 另两个字段只有 tick 线程读写、不与任何线程共享，故不加 volatile。
    private static volatile Context appContext = null;   // 宿主 Application Context（进程内常驻，仅用于取系统服务）
    private static int screenProbedAtTick = 0;           // 上次探测的 tick（tick 自 1 起；首个可能触发重连的 tick 必已探测）
    private static boolean screenInteractive = true;     // 缓存值：初值与"取不到"一律按亮屏
    private static final int SCREEN_PROBE_TICKS = 5;     // 探测间隔（秒）：isInteractive() 是一次到 system_server 的调用，不每秒问
    private static final int RECONNECT_INTERVAL_SCREEN_ON_TICKS = 5;    // 亮屏重连间隔（原节奏，秒）
    private static final int RECONNECT_INTERVAL_SCREEN_OFF_TICKS = 10;  // 息屏重连间隔（用户拍板值，秒）

    // ========== 加固二：连续失败后自扫取新设备重连 ==========
    // 重连是真实蓝牙连接尝试，失败/重试都只在 tick 线程发生，故下列字段无需 volatile（scanInFlight
    // 除外：它由扫描回调线程读写）。语义与取舍见 app/逻辑说明.md §1.2「连续失败后自扫」。
    private static volatile int reconnectFailStreak = 0;   // 连续重连尝试未连上的次数（markConnected 清零）
    private static final int SCAN_AFTER_FAILURES = 3;      // 连续失败达此值才触发自扫（亮屏≈15s、息屏≈30s）
    private static final long SCAN_RECONNECT_COOLDOWN_MS = 60 * 1000;  // 自扫重连冷却（秒级节流，防持续扫描）
    private static final long SCAN_TIMEOUT_MS = 8 * 1000;              // 单次自扫上限（到点自动停扫）
    private static volatile boolean scanInFlight = false;  // 自扫进行中（回调线程与 tick 线程共享）
    private static volatile long lastScanReconnectAt = 0;  // 上次自扫发起时刻（冷却计时，markConnected 清零）

    // ========== P1：门禁有界自解 + 发令降频（见 app/逻辑说明.md §1.2）==========
    // stuckStateTicks：tick 线程自增、markConnected（SDK hook 线程）复位 → 跨线程，故 volatile（同 reconnectFailStreak）。
    // lastStuckClearAt：仅 tick 线程读写 → 不加 volatile。
    private static volatile int stuckStateTicks = 0;  // readConnectState() 连续 ∈{1,2} 的秒数（tick 自增 / markConnected 复位）
    private static long lastStuckClearAt = 0;      // 上次「有界清状态」动作时刻（限频计时）
    private static final int RECONNECT_BACKOFF_AFTER = 6;            // 连续失败达此值 → 发令降频
    private static final int RECONNECT_BACKOFF_INTERVAL_TICKS = 30;  // 降频态发令节拍（秒）
    private static final int STUCK_STATE_CLEAR_AFTER_TICKS = 30;     // state∈{1,2} 连续达此秒数才清（>SDK 5s 建连超时，不误拆）
    private static final long STUCK_STATE_CLEAR_COOLDOWN_MS = 60 * 1000;  // 清状态动作限频

    // ========== R1·任务2：不受限频的 state 观测（30s 一条，仅 tick 线程读写）==========
    // 动机：`后台重连尝试`/`重连循环心跳` 是 5min 限频，上线后分不清「修好了」与「本来就会好」、
    // 也分不清 state「卡 2」与「争用」。此观测不受 5min 限频，但按 30s 节流（每秒读 state、30s 才输出）。
    private static int lastObservedState = Integer.MIN_VALUE;  // 上次观测到的 state（哨兵=未观测过）
    private static long observedStateSince = 0;                // 进入当前 state 的时刻（ms，算持续时长）
    private static long lastStateObsLogAt = 0;                 // 上次输出时刻（30s 节流）
    private static final long STATE_OBS_LOG_INTERVAL_MS = 30 * 1000;  // 观测输出间隔（不刷屏：≤2 条/分）

    // ========== M2：SDK 扫描自锁（inScanning）解除 + 扫描侧观测 ==========
    // 动机：SDK 的「正在扫描」标志在 startLeScan() 内先置 true、唯一清除点是 stopScan()（只在连接成功后触发）；
    //   一次被拒/被停的扫描 → 标志留真 → 其后所有 startScan() 被「已经在扫描中了」静默拒 → 死锁只能 kill。
    //   本块在「App 请求扫描且标志已为真」时，走 SDK 自身 stopScan() 入口清标志、放行本次扫描（不裸写字段）。
    private static final AtomicInteger scanRejectCount = new AtomicInteger();  // 扫描入口到达时标志已为真的累计次数（= 若模块不介入则会被 SDK 拒的次数；钩子线程写 / tick 读）
    private static final AtomicLong lastScanUnlockAt = new AtomicLong();       // 上次解自锁动作时刻（限频计时；CAS 保证并发下只放行一次）
    private static final long SCAN_UNLOCK_MIN_INTERVAL_MS = 5000;  // 解自锁动作限频（防 App 连发请求时反复停/起）

    // ========== 断连自动开蓝牙（BT_AUTO_ENABLE_SEC）==========
    // 触发点：maybeScanReconnect 的「蓝牙未开启」分支（tick 线程）。一律交守护进程（root）执行，
    // 钩子只写请求；限频＝两次之间至少间隔 N 秒（0=关闭），时间戳落盘以跨宿主进程重启有效。
    // 仅在 tick 线程读写，无跨线程共享，故缓存字段无需 volatile。
    private static final String BT_REQ_FILE = "/data/local/tmp/tempctrl_bt_req";
    private static String btOnAtFile = null;      // 限频时间戳落点（宿主私有目录，各包各记）
    private static int btSecCache = -1;           // BT_ON_SEC 缓存值（-1=未读）
    private static long btSecReadAt = 0;          // 上次读 uiprefs 的时刻
    private static final long BT_SEC_CACHE_MS = 30000;  // 配置缓存时长（避免每 tick 读文件）
    private static final int BT_SEC_DEFAULT = 300;      // 读不到配置时按默认 300（功能开启）

    // ========== 广播接收诊断（每次连接最多 3 对日志） ==========
    private static final int DIAG_LOG_MAX_PER_CONN = 3;   // 每次连接最多记录的对数
    private static volatile int diagLogCount = 0;          // 当前连接已记录的对数（markConnected 清零）
    private static volatile int setRunModeLogCount = 0;    // "setRunMode 已下发"当前连接已记录条数（markConnected 清零）
    private static final int DIAG_CONN_LOG_MAX = 1;        // 连接诊断日志每连最多条数（connect 进/出、断联等风暴源）
    private static volatile int diagConnLogCount = 0;      // 连接诊断日志计数（markConnected 清零）
    // ========== 后台重连日志限频（方案 3；节奏为用户拍板值 5 分钟） ==========
    // 使「零输出 ≠ 无尝试」：断连期间即使重连块跑了成百上千次，日志里也能看到周期性的尝试/心跳。
    private static final long RECONNECT_LOG_INTERVAL_MS = 5 * 60 * 1000; // 重连类日志限频间隔（5 分钟）
    private static volatile long lastReconnectAttemptLogAt = 0;  // 上次"后台重连尝试"日志时间（markConnected 清零）
    private static volatile long lastReconnectHeartbeatAt = 0;   // 上次重连循环心跳日志时间（markConnected 清零）
    // ---- 诊断门控拆分（进入/退出/断连各自独立，避免「进入」把窗口吃掉）----
    private static volatile long lastConnEnterLogAt = 0;         // "connect() 进入"限频（markConnected 清零）
    private static volatile long lastConnExitLogAt = 0;          // "connect() 退出"限频（独立窗口，markConnected 清零）
    private static volatile boolean disconnectLogged = false;    // 本断连周期是否已记（边沿触发，markConnected 清）
    private static final long DISCONNECT_LOG_COOLDOWN_MS = 10 * 1000;   // 断连去重硬冷却（同一物理断连的重复回调）
    private static volatile long lastDisconnectLogAt = 0;        // 上次断连日志时间（冷却计时）
    // ---- 连接期异常留痕（不再静默吞掉；Q3）----
    private static volatile int reconnectExCount = 0;            // 连接/扫描期异常累计次数（全进程，不清零）
    private static volatile long lastReconnectExLogAt = 0;       // 连接期异常日志限频（防风暴）
    // ---- 自扫诊断计数（P3；每轮自扫开始时重置）----
    private static volatile int scanCallbackCount = 0;           // 本轮自扫收到的回调数
    private static volatile int scanAddrMismatchCount = 0;       // 本轮自扫地址不符数
    private static volatile int scanAddrErrCount = 0;            // 本轮自扫取地址/回调异常数
    private static volatile int scanAddrThrewLogCount = 0;       // 本轮"取地址抛异常"明细日志上限计数（R2 镜像，单列防被占满）
    private static volatile boolean paramMissingLogged = false;     // 参数回传缺失：状态翻转才打（进入一条/恢复一条）
    private static volatile boolean statusWriteFailLogged = false;  // 状态文件写入失败：状态翻转才打（进入一条/恢复一条）
    private static volatile boolean loggedResolveFallback = false;  // resolveWaspWingManager 兜底失败仅记一次（进程内）

    // ========== 智能温控广播接收器 ==========
    // 接收 tempctrl 发送的 am broadcast，调用 setRunMode 控制散热器

    private static void registerTemperatureReceiver(Context ctx) {
        try {
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

    // ========== 诊断日志门控（拆分后）==========
    // 拆分动机：此前「进入 / 退出 / 断连」共用一个 5 分钟窗口，进入（微秒级）把窗口吃掉后
    // 退出永不可达；故三类事件各自独立门控，互不吃窗口（见 app/逻辑说明.md §1.2）。
    // 三类事件与限频策略：
    //   ① 进入类（connect() 进入）：5min 窗口（连接失败风暴源）
    //   ② 结果类（connect() 退出）：独立的 5min 窗口——退出必须可见，且带 gatt + throwable
    //   ③ 断连类（onConnectionStateChange / disconnect / b7x a.T1）：边沿触发（每断连 1 条）+ 10s 冷却

    /** 进入类事件限频（connect() 进入）。 */
    private static boolean connEnterLogAllowed() {
        long now = System.currentTimeMillis();
        if (now - lastConnEnterLogAt < RECONNECT_LOG_INTERVAL_MS) return false;
        lastConnEnterLogAt = now;
        return true;
    }

    /** 结果类事件限频（connect() 退出）；与进入自列独立窗口，进入不再吃掉它。 */
    private static boolean connExitLogAllowed() {
        long now = System.currentTimeMillis();
        if (now - lastConnExitLogAt < RECONNECT_LOG_INTERVAL_MS) return false;
        lastConnExitLogAt = now;
        return true;
    }

    /** 断连类事件门控：边沿触发（每断连周期 1 条）+ 10s 硬冷却。 */
    private static boolean disconnectLogAllowed() {
        if (disconnectLogged) return false;
        long now = System.currentTimeMillis();
        if (now - lastDisconnectLogAt < DISCONNECT_LOG_COOLDOWN_MS) return false;
        disconnectLogged = true;
        lastDisconnectLogAt = now;
        return true;
    }

    /** 连接/扫描期异常留痕：累计计数，日志按 RECONNECT_LOG_INTERVAL_MS 限频（不刷屏）。 */
    private static void logReconnectExOnce(String msg) {
        reconnectExCount++;
        long now = System.currentTimeMillis();
        if (now - lastReconnectExLogAt < RECONNECT_LOG_INTERVAL_MS) return;
        lastReconnectExLogAt = now;
        XposedBridge.log(TAG + " 后台重连异常留痕: " + msg + "（累计 " + reconnectExCount + " 次）");
    }

    /** 设备类型可读名（用于预探测日志）。 */
    private static String typeDesc(int t) {
        switch (t) {
            case BluetoothDevice.DEVICE_TYPE_CLASSIC: return "CLASSIC";
            case BluetoothDevice.DEVICE_TYPE_LE:      return "LE";
            case BluetoothDevice.DEVICE_TYPE_DUAL:    return "DUAL";
            case BluetoothDevice.DEVICE_TYPE_UNKNOWN: return "UNKNOWN";
            default:                                   return String.valueOf(t);
        }
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
    // tempctrl 通过 stat() 检查文件 mtime 判断进程存活
    private static synchronized void writeStatusFile() {
        try {
            StringBuilder sb = new StringBuilder();
            // status 文件各字段的语义与量纲见 ../README.md 的 status 协议表
            int bleVal = bleConnected ? bleOwnerCode() : 0;
            sb.append("BLE=").append(bleVal).append("\n");
            sb.append("CONNECTED_AT=").append(bleConnectedTimestamp).append("\n");
            sb.append("BLE_OWNER_LAST=").append(bleLastOwner).append(" ").append(bleLastOwnerAt).append("\n");

            // 散热器全参数回传
            try {
                if (lastWaspWingInfo != null) {
                    appendGetterValue(sb, lastWaspWingInfo, "getRunMode", "RUN_MODE");

                    appendTenthValue(sb, lastWaspWingInfo, "getHotSurfaceTemperature", "HOT_TEMP");

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

                    appendGetterValue(sb, lastWaspWingInfo, "getRealWindLevel", "RPM_REAL");

                    appendGetterValue(sb, lastWaspWingInfo, "getRealColdLevel", "COLD_REAL");

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
            int tick = 0;   // 状态写 1s；后台重连亮屏 5s、息屏 10s（见 reconnectIntervalTicks）
            while (true) {
                try {
                    tick++;
                    writeStatusFile();   // 每 1 秒写一次 status（供 daemon 3s 判死 + 曲线页）

                    // ① 有界清状态：断连期每秒查一次门禁是否卡死（独立于发令）
                    if (!bleConnected) {
                        maybeClearStuckControllerState();
                    }

                    // ═══ 后台自动重连（亮屏 5s / 息屏 10s；连续失败≥6 降频 30s，见 app/逻辑说明.md §1.2）═══
                    // 设备锁死（多次重连无回传）时停止自动重连，等用户强制重启 App
                    if (!bleConnected && lastDevice != null && !deviceLockedAlerted
                            && tick % reconnectIntervalTicks(tick) == 0) {
                        tryReconnectOnce();   // 只发令 + 连续失败转自扫重连（见 app/逻辑说明.md §1.2）
                    }

                    // ═══ 重连循环心跳（方案 3）：仅断连时每 5 分钟一条，使「循环在跑」在日志上可见 ═══
                    if (!bleConnected) logReconnectHeartbeat();

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

    /** 后台重连管理器类名：B6X=WaspWingManager，B7X 混淆=t9.j */
    private static String reconnectMgrClassName() {
        return (appKind == 7) ? "t9.j" : "com.flydigi.sdk.waspwing.WaspWingManager";
    }

    /** 后台重连接口名：B6X=connectGattWith，B7X=t9.j.E */
    private static String reconnectMethodName() {
        return (appKind == 7) ? "E" : "connectGattWith";
    }

    /**
     * 后台重连一次（v2.7 语义：只发令、只按限频记日志，绝不在重连过程中动 SDK 状态或主动断 gatt）。
     *
     * 回归说明：此前（021a95c5）在发令后 ~1s 复查状态并「清状态 + 断 gatt」自愈，但 BLE 建连是异步的，
     * 1s 窗口内状态常未推进 → 把正在建立的连接误判为「未发起」并拆掉，形成「发起即拆」的循环而永不重连。
     * 本方法改回只发令；连续失败达阈值后改走「自扫取新设备重连」（见 maybeScanReconnect）。
     * 任一反射失败只记录并按时间限频输出，绝不向 tick 循环抛出。
     */
    private static void tryReconnectOnce() {
        try {
            if (appClassLoader == null) {
                if (!loggedReconnectSkip) {
                    loggedReconnectSkip = true;
                    XposedBridge.log(TAG + " 后台重连跳过: appClassLoader 为 null（findClass 无法进行）");
                }
                return;
            }
            reconnectFailStreak++;   // 每次尝试都先计一次（连接成功由 markConnected 清零）

            // B：冷启动对象待换 → 先取一个"类型已知"的设备对象（反射构造 → getRemoteLeDevice → getRemoteDevice）
            if (needFreshObject) {
                needFreshObject = false;
                try {
                    BluetoothDevice fresh = buildFreshDevice(lastDevice.getAddress());
                    if (fresh != null) lastDevice = fresh;
                } catch (Throwable t) {
                    logReconnectExOnce("取新对象异常 " + t.getClass().getSimpleName() + ": " + t.getMessage());
                }
            }

            // 连续失败达阈值 → 自扫取新设备对象再连（对齐手动路径）；冷却与超时见 maybeScanReconnect
            if (reconnectFailStreak >= SCAN_AFTER_FAILURES) maybeScanReconnect();

            Class<?> mgrCls = XposedHelpers.findClass(reconnectMgrClassName(), appClassLoader);
            // 取 static 控制器实例（字段缺失时 dic 为 null）；只为把状态读进日志，不用于改状态
            Object dic = null;
            try {
                dic = XposedHelpers.getStaticObjectField(mgrCls, dicFieldName());
            } catch (Throwable ignored) { /* dic 保持 null */ }
            int stateBefore = readConnectState(dic);      // 发令前读状态（-1=不可读）

            // P4：发令前预探测设备类型——把「陈旧对象卡 getType() 门禁（R2）」与「设备不在场（R1）」分开。
            // Q3 裁决：抛 SecurityException 视为"疑似 R2 命中"，跳过本次发令并转自扫（发令也必被 SDK 的 GATE-A 拒）。
            int typeProbe = -1;
            try {
                typeProbe = (lastDevice == null) ? -1 : lastDevice.getType();
            } catch (SecurityException se) {
                logReconnectExOnce("R2 命中: 陈旧对象 getType() 抛 SecurityException（疑似 BLUETOOTH_CONNECT 门禁）"
                        + "，跳过本次发令并转自扫");
                maybeScanReconnect();
                return;
            } catch (Throwable t) {
                logReconnectExOnce("预探测 getType() 异常 " + t.getClass().getSimpleName() + "，照常发令");
            }
            // P4 续：显式非 BLE 类型（CLASSIC 等）**只记录、不阻断**——拒绝交回 SDK 自己的 GATE-A 判定。
            // 理由：阻断分支一旦因类型元数据错误 / ROM 类型语义差异 / B7X 路径（GATE-A 是否同样存在未证）
            // 而误判，会每轮提前 return、后台永久不再发起连接（用户不可见），风险远大于「省一次 IPC」的收益。
            // UNKNOWN(0) 与探测失败(-1) 亦照常发令；判据见 app/逻辑说明.md §1.2。
            if (typeProbe > 0 && typeProbe != BluetoothDevice.DEVICE_TYPE_LE
                    && typeProbe != BluetoothDevice.DEVICE_TYPE_DUAL) {
                logReconnectExOnce("GATE-A 观察: 设备类型=" + typeDesc(typeProbe)
                        + " 非 BLE（仍发令，交回 SDK 判定）");
            }

            try {
                XposedHelpers.callStaticMethod(mgrCls, reconnectMethodName(), lastDevice);
            } catch (SecurityException se) {
                // R2 唯一能露头的地方：不再静默吞掉
                logReconnectExOnce("R2 命中: 发令期 SecurityException -> " + se.getMessage());
                maybeScanReconnect();
            } catch (Throwable t) {
                logReconnectExOnce("发令异常 " + t.getClass().getSimpleName() + ": " + t.getMessage());
            }

            // "真发起连接"按时间限频记录一条（方案 3；每断连不再只记一次）
            if (reconnectAttemptLogAllowed()) {
                XposedBridge.log(TAG + " 后台重连尝试 -> " + lastDevice.getAddress()
                        + " state=" + stateDesc(stateBefore) + " type=" + typeDesc(typeProbe));
            }
        } catch (Throwable t) {
            // 反射/未知异常不再完全静默：限频留痕 + 计数，仍不上抛（保持 tick 存活）
            logReconnectExOnce("重连块异常 " + t.getClass().getSimpleName() + ": " + t.getMessage());
        }
    }

    /**
     * 加固三（B）：构造一个"类型已知"的设备对象，替代冷启动 {@code getRemoteDevice} 的陈旧对象
     * （陈旧对象的 getType() 可能走 IPC 并卡权限门禁）。三级退回，绝不会比现状更差：
     *   ① 反射 BluetoothDevice(mac, DEVICE_TYPE_LE)：类型随构造写入，getType() 本地返回、不查 IPC；
     *   ② BluetoothAdapter.getRemoteLeDevice(mac, ADDRESS_TYPE_PUBLIC)（API33+；仍受 BLUETOOTH_CONNECT 管）；
     *   ③ 退回 BluetoothAdapter.getRemoteDevice(mac)（现状行为）。
     * 每级成功/失败各留一条日志；全失败返回 null（调用方保持原对象）。仅 tick 线程调用。
     */
    private static BluetoothDevice buildFreshDevice(String addr) {
        if (addr == null) return null;
        // ① 反射构造类型已知对象
        try {
            BluetoothDevice d = (BluetoothDevice) XposedHelpers.newInstance(
                    BluetoothDevice.class, addr, BluetoothDevice.DEVICE_TYPE_LE);
            if (d != null) {
                XposedBridge.log(TAG + " 后台重连取新对象: 反射构造 BluetoothDevice(mac,LE) 成功");
                return d;
            }
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 后台重连取新对象: 反射构造失败 " + t.getClass().getSimpleName());
        }
        // ② getRemoteLeDevice（API33+）
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            try {
                BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
                if (adapter != null) {
                    BluetoothDevice d = adapter.getRemoteLeDevice(addr, BluetoothDevice.ADDRESS_TYPE_PUBLIC);
                    if (d != null) {
                        XposedBridge.log(TAG + " 后台重连取新对象: getRemoteLeDevice 成功");
                        return d;
                    }
                }
            } catch (Throwable t) {
                XposedBridge.log(TAG + " 后台重连取新对象: getRemoteLeDevice 失败 "
                        + t.getClass().getSimpleName() + ": " + t.getMessage());
            }
        }
        // ③ 退回现状
        try {
            BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
            if (adapter != null) {
                BluetoothDevice d = adapter.getRemoteDevice(addr);
                XposedBridge.log(TAG + " 后台重连取新对象: 退回 getRemoteDevice（现状行为）");
                return d;
            }
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 后台重连取新对象: getRemoteDevice 失败 " + t.getMessage());
        }
        return null;
    }

    /**
     * 加固二：连续失败达 SCAN_AFTER_FAILURES 次后，模块自己扫一次，用扫描到的**新设备对象**发起连接
     * （对齐「手动打开 App」那条有效路径——手动侧也是先 scan、再 connectGattWith(新 device)）。
     * 冷却 SCAN_RECONNECT_COOLDOWN_MS 限频、单次上限 SCAN_TIMEOUT_MS 自动停扫；
     * 权限/服务取不到或扫描失败一律吞掉并记一条，退回普通重连。只在 tick 线程调用。
     */
    private static void maybeScanReconnect() {
        long now = System.currentTimeMillis();
        if (scanInFlight) return;
        if (now - lastScanReconnectAt < SCAN_RECONNECT_COOLDOWN_MS) return;
        final BluetoothDevice target = lastDevice;
        if (target == null) return;
        final String targetAddr = target.getAddress();
        if (targetAddr == null) { logScanSkip("设备地址为空"); return; }
        lastScanReconnectAt = now;
        try {
            Context ctx = appContext;
            if (ctx == null) { logScanSkip("appContext 未就绪"); return; }
            BluetoothManager bm = (BluetoothManager) ctx.getSystemService(Context.BLUETOOTH_SERVICE);
            BluetoothAdapter adapter = (bm != null) ? bm.getAdapter() : null;
            if (adapter == null || !adapter.isEnabled()) {
                logScanSkip("蓝牙未开启");
                maybeAutoEnableBtOnce();   // 断连自动开蓝牙（限频；0=关闭），见 app/逻辑说明.md §1.2
                return;
            }
            final BluetoothLeScanner scanner = adapter.getBluetoothLeScanner();
            if (scanner == null) { logScanSkip("扫描器不可用"); return; }

            final ScanCallback cb = new ScanCallback() {
                // 注：下方 ScanSettings 未设 setReportDelay ⇒ 批模式不启用，onBatchScanResults 不会被调用，故只需覆写
                //     onScanResult。若将来启用 setReportDelay，须一并覆写 onBatchScanResults 做同样的软件地址筛选。
                @Override
                public void onScanResult(int callbackType, ScanResult result) {
                    if (!scanInFlight) return;   // 命中/超时后、stopScan 生效前的迟到回调：丢弃（防重复汇总/重复连接）
                    scanCallbackCount++;   // P3：本轮回调计数
                    try {
                        BluetoothDevice dev = (result == null) ? null : result.getDevice();
                        if (dev == null) {
                            scanAddrErrCount++;
                            if (scanAddrErrCount <= 3) logScanSkip("扫描回调设备为空");   // 每轮上限 3 条，防刷屏
                            return;
                        }
                        String addr;
                        try {
                            addr = dev.getAddress();
                        } catch (Throwable t) {
                            // 扫描侧取地址异常 = R2 在扫描侧的镜像（权限缺失/脱敏）
                            scanAddrErrCount++;
                            scanAddrThrewLogCount++;   // 单列上限：即使 dev==null 占满共用上限，本类明细仍可辨
                            if (scanAddrThrewLogCount <= 3)
                                logScanSkip("扫描侧取地址异常 " + t.getClass().getSimpleName() + "（疑似权限/脱敏）");
                            return;
                        }
                        if (targetAddr == null || !targetAddr.equals(addr)) {
                            scanAddrMismatchCount++;
                            if (scanAddrMismatchCount <= 3) {   // 低频：最多记 3 条不符样本（可识别 02:00:… 脱敏）
                                XposedBridge.log(TAG + " 后台重连硬自愈: 地址不符 recv=" + addr
                                        + " want=" + targetAddr);
                            }
                            return;
                        }
                        scanInFlight = false;
                        try { scanner.stopScan(this); } catch (Throwable ignored) { }
                        XposedBridge.log(TAG + " 后台重连硬自愈: 自扫命中 dev=" + addr);
                        logScanSummary();   // 命中即结束，落一条汇总
                        connectWithScannedDevice(dev);
                    } catch (Throwable t) {
                        scanAddrErrCount++;
                        if (scanAddrErrCount <= 3)
                            logScanSkip("自扫回调异常 " + t.getClass().getSimpleName() + ": " + t.getMessage());
                    }
                }
                @Override
                public void onScanFailed(int errorCode) {
                    scanInFlight = false;
                    logScanSkip("扫描失败 code=" + errorCode);
                    logScanSummary();
                }
            };
            ScanSettings settings = new ScanSettings.Builder()
                    .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY).build();
            scanCallbackCount = 0;         // P3：本轮诊断计数归零
            scanAddrMismatchCount = 0;
            scanAddrErrCount = 0;
            scanAddrThrewLogCount = 0;
            scanInFlight = true;
            // 广扫（空过滤）：本 ROM 对「带设备地址过滤」的扫描要求特权权限、直接拒绝（MIUI PERMISSION DENIED），
            //   使模块永远拿不到新设备对象。改空过滤后过门（同 SDK 自身做法），再在回调里按地址软件筛选。
            scanner.startScan(Collections.emptyList(), settings, cb);
            XposedBridge.log(TAG + " 后台重连硬自愈: 连续 " + reconnectFailStreak
                    + " 次未连上，启动扫描取新设备对象重连 -> " + targetAddr);
            // 超时兜底停扫（找到设备时已在回调里置 scanInFlight=false，这里只兜超时）
            mainHandler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (!scanInFlight) return;
                    scanInFlight = false;
                    try { scanner.stopScan(cb); } catch (Throwable ignored) { }
                    logScanSummary();   // 超时停扫：落一条汇总（区分 R1/R4）
                }
            }, SCAN_TIMEOUT_MS);
        } catch (Throwable t) {
            scanInFlight = false;
            logScanSkip(t.getMessage());
        }
    }

    /** 用扫描到的**新**设备对象发起连接（对齐手动路径）；成功发令后重置连续失败计数。 */
    private static void connectWithScannedDevice(BluetoothDevice dev) {
        try {
            if (appClassLoader == null) { logScanSkip("appClassLoader 为 null"); return; }
            Class<?> mgrCls = XposedHelpers.findClass(reconnectMgrClassName(), appClassLoader);
            lastDevice = dev;             // 后续周期也用这个更"新鲜"的对象
            reconnectFailStreak = 0;      // 换了设备对象，连续失败重新计数
            XposedHelpers.callStaticMethod(mgrCls, reconnectMethodName(), dev);
            XposedBridge.log(TAG + " 后台重连硬自愈: 已改用扫描设备重连 -> " + dev.getAddress());
        } catch (Throwable t) {
            logScanSkip(t.getMessage());
        }
    }

    /** 自扫相关失败/跳过的一条日志（受冷却节流，实际 ≤1 条/SCAN_RECONNECT_COOLDOWN_MS）。 */
    private static void logScanSkip(String msg) {
        XposedBridge.log(TAG + " 后台重连硬自愈跳过: " + msg);
    }

    /** 自扫结束汇总（P3）：一条日志分清「没扫到(R1) / 地址不符(R4) / 回调内异常(R2 镜像)」。 */
    private static void logScanSummary() {
        XposedBridge.log(TAG + " 后台重连硬自愈: 自扫结束 回调=" + scanCallbackCount
                + " 地址不符=" + scanAddrMismatchCount + " 回调异常=" + scanAddrErrCount
                + "（回调=0：未收到广播——可能是设备不在场、扫描被系统拒绝或扫描未真正下发，需结合 ScanController 日志判别）");
    }

    /** 读控制器连接状态：B6X=mDataConnectState，B7X=E；dic 为 null 或读取失败 → -1。 */
    private static int readConnectState(Object dic) {
        if (dic == null) return -1;
        try {
            return XposedHelpers.getIntField(dic, stateFieldName());
        } catch (Throwable t) {
            return -1;
        }
    }

    /** 状态值的人类可读描述（-1=不可读），仅用于日志。 */
    private static String stateDesc(int state) {
        return (state < 0) ? "?" : String.valueOf(state);
    }

    /** 读控制器扫描标志：B6X=inScanning，B7X=f16228r；dic 为 null 或读取失败 → false。仅用于观测。 */
    private static boolean readInScanning(Object dic) {
        if (dic == null) return false;
        try {
            return XposedHelpers.getBooleanField(dic, inScanningFieldName());
        } catch (Throwable t) {
            return false;
        }
    }

    /**
     * ① 有界清状态（P1 核心修复）：门禁卡死的自解。SDK 的 {@code connectWith()} 在控制器
     * {@code mDataConnectState ∈ {1,2}} 时静默 return，模块重连与 App 手动连接都会被挡死。
     * 每秒查一次：state 连续 ∈{1,2} 达 {@link #STUCK_STATE_CLEAR_AFTER_TICKS}s（用 tick 计数，不 sleep）
     * 即判卡死 → 走 SDK 自己的断连入口清状态。用 ∈{1,2} 而非「非 0」，排除读失败 -1 误清。
     * 仅在 tick 线程调用。
     */
    private static void maybeClearStuckControllerState() {
        if (appClassLoader == null) { stuckStateTicks = 0; return; }
        Object dic;
        try {
            Class<?> mgrCls = XposedHelpers.findClass(reconnectMgrClassName(), appClassLoader);
            dic = XposedHelpers.getStaticObjectField(mgrCls, dicFieldName());
        } catch (Throwable t) {
            stuckStateTicks = 0;   // 取不到控制器：不计时、不动作
            return;
        }
        int st = readConnectState(dic);
        observeConnectState(st, readInScanning(dic));   // 任务2：不受限频的观测（30s 一条；含扫描侧 inScanning）
        if (st != 1 && st != 2) {   // 0=空闲、-1=读失败、其它：一律清零
            stuckStateTicks = 0;
            return;
        }
        stuckStateTicks++;
        if (stuckStateTicks < STUCK_STATE_CLEAR_AFTER_TICKS) return;
        long now = System.currentTimeMillis();
        if (now - lastStuckClearAt < STUCK_STATE_CLEAR_COOLDOWN_MS) return;
        lastStuckClearAt = now;
        stuckStateTicks = 0;
        clearStuckControllerState(dic);
    }

    /**
     * 任务2：不受 5min 限频的观测。每次调用（断连期每秒）读一次，但**每
     * {@link #STATE_OBS_LOG_INTERVAL_MS}(30s) 才输出一条**，输出当前 state 与该值「已持续」秒数，
     * 并附带扫描侧信号（{@code inScanning} 标志 + 被拒累计次数，M2 观测扩展）：
     * 持续秒数很小 ⇒ 门禁在快速翻转（争用）；持续秒数逐条增大且 state=2 ⇒ 卡死；inScanning=true 而
     * 长时间无进展 ⇒ 扫描侧卡死（M2）。据此可分辨「卡 2 vs 争用」并验收两项修复是否生效。
     * 仅 tick 线程调用（无并发）。
     */
    private static void observeConnectState(int st, boolean scanning) {
        long now = System.currentTimeMillis();
        if (st != lastObservedState) {
            lastObservedState = st;
            observedStateSince = now;
        }
        if (now - lastStateObsLogAt < STATE_OBS_LOG_INTERVAL_MS) return;
        lastStateObsLogAt = now;
        XposedBridge.log(TAG + " 状态观测: state=" + stateDesc(st)
                + " 已持续 " + ((now - observedStateSince) / 1000) + "s"
                + " inScanning=" + scanning + " 自锁命中累计=" + scanRejectCount.get());
    }

    /**
     * 调 SDK 自己的断连入口把 {@code mDataConnectState} 置 0（<b>严禁裸写该字段</b>）：
     * 首选 {@code disconnectManually()}（其 {@code onGattDisconnected} 同步置 0 + close），
     * 退回 {@code disconnectGatt()}；都失败只记一条，60s 后由限频重试。
     *
     * <p><b>调用后复读 state 再定日志措辞</b>：SDK 的 {@code disconnectManually()} 内部
     * {@code if (mBluetoothGatt != null)}，gatt 为空时纯空转、state 清不掉——「调用不抛异常」不等于
     * 「已清」。故以复读到的 state 判定成功/未清，避免日志误导（真机排障时关键）。
     */
    private static void clearStuckControllerState(Object dic) {
        String entry = null;
        try {
            XposedHelpers.callMethod(dic, "disconnectManually");
            entry = "disconnectManually()";
        } catch (Throwable t) {
            try {
                XposedHelpers.callMethod(dic, "disconnectGatt");
                entry = "disconnectGatt()";
            } catch (Throwable t2) {
                XposedBridge.log(TAG + " 有界清状态失败: " + t2.getClass().getSimpleName()
                        + ": " + t2.getMessage());
                return;
            }
        }
        int after = readConnectState(dic);   // 复读：不以「调用不抛异常」当成功
        if (after == 0) {
            XposedBridge.log(TAG + " 有界清状态: 调 SDK " + entry + " 后 state→0，门禁已清");
        } else {
            XposedBridge.log(TAG + " 有界清状态: 调 SDK " + entry + " 后 state 仍=" + stateDesc(after)
                    + "（gatt 为空时该入口空转、清不掉；60s 后重试）");
        }
    }

    /** "后台重连尝试"日志限频（RECONNECT_LOG_INTERVAL_MS 一条）；返回本次是否输出。 */
    private static boolean reconnectAttemptLogAllowed() {
        long now = System.currentTimeMillis();
        if (now - lastReconnectAttemptLogAt < RECONNECT_LOG_INTERVAL_MS) return false;
        lastReconnectAttemptLogAt = now;
        return true;
    }

    /**
     * 重连循环心跳（方案 3）：仅在断连时、每 RECONNECT_LOG_INTERVAL_MS 输出一条，
     * 让「循环在跑但没发起」与「循环停了」在日志上可区分。只在 tick 线程调用，读 screenInteractive 无并发问题。
     */
    private static void logReconnectHeartbeat() {
        long now = System.currentTimeMillis();
        if (now - lastReconnectHeartbeatAt < RECONNECT_LOG_INTERVAL_MS) return;
        lastReconnectHeartbeatAt = now;
        XposedBridge.log(TAG + " 重连循环心跳: 仍断连（屏幕 " + (screenInteractive ? "亮" : "灭")
                + "），tick 线程持续推进");
    }

    /**
     * 后台重连节奏：亮屏 5s、息屏 10s；连续失败达 {@link #RECONNECT_BACKOFF_AFTER} 次则降频为
     * {@link #RECONNECT_BACKOFF_INTERVAL_TICKS}s（由来、取法缓存与失败兜底见 app/逻辑说明.md §1.2）。
     *
     * @param tick 1Hz tick 计数（等价秒数）
     * @return 本次 tick 的重连间隔（秒）
     */
    private static int reconnectIntervalTicks(int tick) {
        // ② 发令降频：连续失败达阈值 → 节拍固定 30s（连上由 markConnected 复位 reconnectFailStreak）；
        //    判据是「连续失败次数」，与自扫结果无关（见 app/逻辑说明.md §1.2）。
        if (reconnectFailStreak >= RECONNECT_BACKOFF_AFTER) {
            return RECONNECT_BACKOFF_INTERVAL_TICKS;
        }
        if (tick - screenProbedAtTick >= SCREEN_PROBE_TICKS) {
            screenProbedAtTick = tick;
            Boolean interactive = null;   // null = 未取到 → 兜底亮屏
            try {
                Context ctx = appContext;
                PowerManager pm = (ctx == null) ? null
                        : (PowerManager) ctx.getSystemService(Context.POWER_SERVICE);
                if (pm != null) interactive = pm.isInteractive();
            } catch (Throwable t) {
                // 探测异常按亮屏兜底，不冒泡打断 tick 循环
            }
            screenInteractive = (interactive != null) ? interactive : true;   // 取不到 → 亮屏
        }
        return screenInteractive ? RECONNECT_INTERVAL_SCREEN_ON_TICKS
                : RECONNECT_INTERVAL_SCREEN_OFF_TICKS;
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
            lastDevFile = lastDevFileFor(isNewB6App ? PACKAGE_B6X_NEW : PACKAGE_B6X);
            btOnAtFile = btOnAtFileFor(isNewB6App ? PACKAGE_B6X_NEW : PACKAGE_B6X);
        } else if (lpparam.packageName.equals(PACKAGE_B7X)) {
            appKind = 7;
            currentStatusFile = STATUS_FILE_B7;
            lastDevFile = lastDevFileFor(PACKAGE_B7X);
            btOnAtFile = btOnAtFileFor(PACKAGE_B7X);
            lastDevCodeFile = lastDevCodeFileFor(PACKAGE_B7X);
        } else {
            XposedBridge.log(TAG + " 跳过非目标包: " + lpparam.packageName);
            return;
        }

        XposedBridge.log(TAG + " 模块已加载到 " + lpparam.packageName
                + " (appKind=" + appKind + ")");
        appClassLoader = lpparam.classLoader;  // 保存类加载器供后台重连线程使用

        // 各修复分区按固定顺序注册（顺序影响 Xposed 回调执行次序，不可随意调整）
        hookControllerStopScan(lpparam);              // 修复 #1：控制器层停扫描（双设备）
        hookControllerScanEntry(lpparam);             // M2：扫描入口解 SDK 扫描自锁（双设备）
        if (appKind == 6) hookB6ViewModelFix(lpparam);   // 修复 #2：ViewModel LiveData（仅 B6X）
        if (appKind == 6) hookB6Diagnostics(lpparam);    // 修复 #3/#4 + 诊断钩子（仅 B6X）
        hookCommonDisconnect(lpparam);                // 公共 BLE 断联（双设备）
        // 修复 #5：SDK 类型门禁放行（仅老 B6X app；新包/B7X 未验证同门禁，暂不装）
        if (PACKAGE_B6X.equals(lpparam.packageName)) hookDeviceTypeGate(lpparam);
        hookRunFetchLoopCpuFix(lpparam);              // runFetchLoop CPU 满载修复（双设备）
        if (appKind == 6) hookB6Activity(lpparam);       // 自动进入设置界面（仅 B6X）
        if (appKind == 7) hookB7Activity(lpparam);       // 自动进入控制页（仅 B7X）
        hookWaspWingManagerCapture(lpparam);          // 捕获 WaspWingManager 实例（双设备）
        hookSyncConnectedController(lpparam);         // static controller 同步到已连接实例（仅 B6X）
        hookGattConnectTimeoutClose(lpparam);         // 加固一：连接超时补 gatt.close（双设备）
        if (appKind == 7) hookB7Obfuscated(lpparam);     // c0.s1 + 混淆适配（仅 B7X）
        hookApplicationCreate(lpparam);               // 广播接收器 + 定时状态写入（双设备）
        hookAutoLaunch(lpparam);                      // 自动拉起标志 → Activity 后台化（双设备）
        hookBackToBackground(lpparam);                // 返回退出 → 收进后台而非退出（双设备）
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

    /**
     * 修复 #1：控制器层 — 设备连接后停扫描（保底）。B6X 连接成功点 =
     * {@code AbstractBluetoothController.onDeviceConnected}；B7X 的 {@code AbstractBluetoothController}
     * **无** {@code onDeviceConnected}（连接成功点在 {@code com.flydigi.sdk.waspwing.a.S1}），故 B7X 侧在
     * {@code hookB7Obfuscated} 的 S1 钩子里调同一个 {@link #stopControllerScan}（见 app/逻辑说明.md §1.5）。
     */
    private static void hookControllerStopScan(XC_LoadPackage.LoadPackageParam lpparam) {
        hookClassMethod(lpparam.classLoader, "com.flydigi.sdk.bluetooth.AbstractBluetoothController",
                "onDeviceConnected", "AbstractBluetoothController.onDeviceConnected", "钩控制器失败",
                BluetoothDevice.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        try {
                            markConnected(null);  // onDeviceConnected 无 gatt 参数，不保存设备引用
                            stopControllerScan(param.thisObject);
                            XposedBridge.log(TAG + " 控制器：扫描已停止，" + getDeviceLabel() + " BLE 已连接");
                            writeStatusFile();  // 连接事件立刻写 status 文件
                        } catch (Throwable t) {
                            XposedBridge.log(TAG + " 控制器修复异常: " + t.getMessage());
                        }
                    }
                });
    }

    /**
     * 连接成功后停扫描（保底）：走 SDK 自身 stopScan 入口（B6X {@code stopScan()} / B7X {@code F0()}），
     * 并复位扫描标志（B6X {@code inScanning} / B7X {@code f16228r}）。方法名/字段名按 appKind 分流
     * （见 {@link #stopScanMethodName} / {@link #inScanningFieldName}）；B6X 在 {@code onDeviceConnected}、
     * B7X 在 {@code a.S1} 各自的连接成功点调用。失败只记日志、不上抛（保持调用方流程）。
     */
    private static void stopControllerScan(Object controller) {
        try {
            XposedHelpers.callMethod(controller, stopScanMethodName());
            XposedHelpers.setBooleanField(controller, inScanningFieldName(), false);
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 控制器停扫描失败(忽略): " + t.getMessage());
        }
    }

    /**
     * M2：SDK 扫描自锁解除。SDK 的「正在扫描」标志（B6X {@code inScanning} / B7X {@code f16228r}）在
     * {@code startLeScan()}（B7X {@code A0()}）内先置 true、唯一清除点是 {@code stopScan()}（B7X {@code F0()}），
     * 而后者只在连接成功后触发。一次被拒/被停的扫描即让标志留真 ⇒ 其后所有扫描请求被「已经在扫描中了」静默拒
     * ⇒ 死锁只能 kill。本钩子在扫描入口处：若标志已为真（本次请求将被拒），走 SDK 自身 stopScan() 入口清标志、
     * 放行本次扫描（<b>不裸写字段</b>）。只在「App 主动请求扫描且标志已为真」时动作；此时会**先停掉当前扫描再放行
     * 新请求**——若当前扫描是正常进行中的（App 又发了一次请求），等价于中断后重启，因原请求本就会被 SDK 拒，
     * 代价可忽略。双设备共用：方法名按 appKind 分流（见 scanEntryMethodName / stopScanMethodName / inScanningFieldName）。
     */
    private static void hookControllerScanEntry(XC_LoadPackage.LoadPackageParam lpparam) {
        hookClassMethod(lpparam.classLoader, "com.flydigi.sdk.bluetooth.AbstractBluetoothController",
                scanEntryMethodName(), "AbstractBluetoothController." + scanEntryMethodName() + "（扫描入口·解自锁）",
                "钩扫描入口失败",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                        try {
                            Object controller = param.thisObject;
                            if (!XposedHelpers.getBooleanField(controller, inScanningFieldName())) {
                                return;   // 标志为假 = 正常路径，不动作
                            }
                            scanRejectCount.incrementAndGet();   // 本次请求到达时标志已为真（若不介入则会被 SDK 以「已经在扫描中了」拒）：计数
                            long now = System.currentTimeMillis();
                            long prev = lastScanUnlockAt.get();
                            if (now - prev < SCAN_UNLOCK_MIN_INTERVAL_MS) return;   // 限频（CAS 保证并发下只放行一次）
                            if (!lastScanUnlockAt.compareAndSet(prev, now)) return;
                            // SDK 自身入口：清标志 + 停残留扫描（蓝牙不支持时 SDK 会提前返回、清不动，属极端场景，扫描本就无意义）
                            XposedHelpers.callMethod(controller, stopScanMethodName());
                            XposedBridge.log(TAG + " 扫描自锁已清: " + inScanningFieldName()
                                    + " true→false（App 扫描请求放行）");
                        } catch (Throwable t) {
                            logReconnectExOnce("扫描入口解自锁异常 " + t.getClass().getSimpleName()
                                    + ": " + t.getMessage());
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

                            XposedHelpers.callMethod(vm, "stopScan");

                            if (device != null) {
                                String name = device.getName();
                                String addr = device.getAddress();

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

    /** SDK 与 App 层 onDeviceInfoUpdate 共用的回调体。 */
    private static final XC_MethodHook infoUpdateHook = new XC_MethodHook() {
        @Override
        protected void beforeHookedMethod(MethodHookParam param) {
            handleInfoUpdate(param.args[0]);
        }
    };

    /** 捕获全参数回传 + 重置重连新鲜度标记 + 型号识别 + 屏蔽 App 自修复。 */
    private static void handleInfoUpdate(Object info) {
        lastWaspWingInfo = info;    // 捕获散热器全参数回传
        reconnectPending = false;   // 收到新回传，重连新鲜度验证通过
        stallReconnectCount = 0;    // 设备恢复响应，清零连续无回传重连计数
        updateModelFromInfo(info);  // 型号识别 + 同步 BLE_OWNER_LAST
        blockSelfRepair(info);      // 改 experimentalRunModeValue 使 self-repair 跳过（须在原方法前）
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

            // === 修复 #4：仅在「实测已授予」时替 SDK 放行权限检查 ===
            // 宿主 connect() / onGattConnected() 的第一道门就是它；未授予时保持 SDK 原判断，
            // 让其安全早退，避免强制放行后 getType()/connectGatt() 抛 SecurityException（宿主链路无 try/catch）。
            XposedHelpers.findAndHookMethod(leCtrl, "checkBluetoothPermission",
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            if (btConnectPerm == 0) return;   // 实测未授予：交回 SDK 自行早退
                            param.setResult(true);
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 checkBluetoothPermission（实测已授予才放行）");

            // ===== 诊断钩子（调试用，保留） =====
            // 公共断连钩子（BluetoothGatt.disconnect 双设备通用）已覆盖。

            // BluetoothGatt.discoverServices() 诊断
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
                                    + (result != null ? result : "null"));  // 防御 getResult() 为 null
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 BluetoothGatt.discoverServices");

            // LeDataInteractionController.connect() 诊断
            XposedHelpers.findAndHookMethod(leCtrl, "connect",
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            gateLeActive.set(Boolean.TRUE);   // 修复 #5：标记「SDK 连接期」，供 getType 钩子放行
                            probeBtConnectPermission();       // 修复 #4 边界：与崩溃同线程实测权限，供权限钩子判定
                            if (!connEnterLogAllowed()) return;
                            Object ctrl = param.thisObject;
                            Object dev = XposedHelpers.callMethod(ctrl, "getMBluetoothDevice");
                            int state = XposedHelpers.getIntField(ctrl, "mDataConnectState");
                            XposedBridge.log(TAG + " [诊断] connect() 进入"
                                    + " device=" + (dev != null ? dev.toString() : "null")
                                    + " state=" + state);
                        }
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            gateLeActive.remove();            // 修复 #5：连接期结束，立即失效（异常路径同样执行）
                            if (!connExitLogAllowed()) return;
                            Object ctrl = param.thisObject;
                            Object gatt = XposedHelpers.getObjectField(ctrl, "mBluetoothGatt");
                            Throwable th = param.getThrowable();
                            // 退出独立门控（不再被进入吃掉）；带 throwable 类名可判定 R2「异常在 connectGatt 之前」
                            XposedBridge.log(TAG + " [诊断] connect() 退出"
                                    + " gatt=" + (gatt != null ? "有值" : "null")
                                    + " throwable=" + (th != null ? th.getClass().getSimpleName() : "null"));
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 LeDataInteractionController.connect");

            // GattCallback（远程断联检测 onConnectionStateChange 用）
            Class<?> gattCb = lpparam.classLoader.loadClass(
                    "com.flydigi.sdk.bluetooth.LeDataInteractionController$mGattCallback$1");

            // 远程 BLE 断联检测（散热器超出范围/关机/蓝牙异常断开时的回调）
            XposedHelpers.findAndHookMethod(gattCb, "onConnectionStateChange",
                    BluetoothGatt.class, int.class, int.class, new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            int newState = (int) param.args[2];
                            if (newState == 0) {  // BluetoothProfile.STATE_DISCONNECTED
                                markDisconnected((BluetoothGatt) param.args[0]);
                                if (disconnectLogAllowed())
                                    XposedBridge.log(TAG + " BLE 断联（onConnectionStateChange）"
                                            + " device=" + (lastDevice != null ? lastDevice.getAddress() : "null"));
                                writeStatusFile();  // 远程断连立刻写 status 文件
                            }
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 GattCallback.onConnectionStateChange（远程断联检测）");

            // controller 的 onGattConnected（BLE 状态恢复）
            XposedHelpers.findAndHookMethod(wingCtrl, "onGattConnected",
                    BluetoothGatt.class, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            BluetoothGatt gatt = (BluetoothGatt) param.args[0];
                            // 重连路径也刷新 CONNECTED_AT；并保存设备引用
                            markConnected(gatt);
                            autoEnterSetup();  // 引导页可见时自动进入设置界面
                            writeStatusFile();  // 连接事件立刻写 status 文件
                        }
                    });
            XposedBridge.log(TAG + " 已钩住 WaspWingDataInteractionController.onGattConnected（BLE 状态恢复）");

            XposedHelpers.findAndHookMethod(sdkVm, "onDeviceInfoUpdate",
                    waspInfoCls, infoUpdateHook);
            XposedBridge.log(TAG + " 已钩住 SDK WaspwingViewModel.onDeviceInfoUpdate（beforeHook）");

            // App 层 WaspWingViewModel.onDeviceInfoUpdate — 自修复
            XposedHelpers.findAndHookMethod(appVm, "onDeviceInfoUpdate",
                    waspInfoCls, infoUpdateHook);
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
                            if (disconnectLogAllowed())
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

    /**
     * 修复 #5：SDK 类型门禁放行。
     *
     * <p>宿主 SDK 的 {@code LeDataInteractionController.connect()} 在发令前判 {@code BluetoothDevice.getType()}，
     * 只接受 LE(2)/DUAL(3)，否则打 {@code current device is not a valid BLE device} 并直接 return。冷启动时
     * 模块只能凭地址重建设备对象（{@code getRemoteDevice}/{@code getRemoteLeDevice}），其类型恒为 UNKNOWN，
     * 于是后台重连永远停在门禁前（依据见 app/逻辑说明.md §1.7）。
     *
     * <p>本钩子只在三个条件同时成立时把返回值改成 LE：① 当前线程处于 SDK {@code connect()} 执行期
     * （{@link #gateLeActive}，由 connect 钩子置/清）；② 设备地址等于 {@link #lastDevice} 的地址；
     * ③ 界面开关 {@code GATE_LE} 非 0（缺省开）。缺一即原样返回，故不影响模块自身的类型探针
     * （它在 tick 线程调用，不在连接期），也不影响其它设备与经典通道的门禁。
     */
    private static void hookDeviceTypeGate(XC_LoadPackage.LoadPackageParam lpparam) {
        try {
            XposedHelpers.findAndHookMethod(BluetoothDevice.class, "getType", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    try {
                        if (!Boolean.TRUE.equals(gateLeActive.get())) return;   // 非 SDK 连接期：不干预
                        if (param.getThrowable() != null) return;               // 原方法已抛异常：不吞异常、不改结果
                        Object r = param.getResult();
                        if (r instanceof Integer && (Integer) r == BluetoothDevice.DEVICE_TYPE_LE) return;
                        Object self = param.thisObject;
                        if (!(self instanceof BluetoothDevice)) return;
                        BluetoothDevice dev = (BluetoothDevice) self;
                        BluetoothDevice target = lastDevice;
                        if (target == null) return;
                        String addr = dev.getAddress();
                        if (addr == null || !addr.equals(target.getAddress())) return;   // 只放行目标设备
                        if (!readGateLeEnabled()) return;                                // 开关关闭：保持原行为
                        param.setResult(BluetoothDevice.DEVICE_TYPE_LE);
                        if (gateLeLogAllowed())
                            XposedBridge.log(TAG + " [修复] getType 门禁放行 -> " + addr);
                    } catch (Throwable ignored) {
                        // 任何异常都不改结果（退化为原行为），也不向宿主抛出
                    }
                }
            });
            XposedBridge.log(TAG + " 已钩住 BluetoothDevice.getType（类型门禁·仅连接期放行目标设备）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 BluetoothDevice.getType 失败: " + t.getMessage());
        }
    }

    /**
     * 读界面开关 {@code GATE_LE=0/1}（守护进程写 {@link #UIPREFS_FILE}，与 UI_BACK_HIDE 同通道）。
     * 读不到 / 无该行 / 值异常一律按默认值「开」，只有明确的 0 才关闭。带 30s 缓存，改动最迟半分钟生效。
     */
    private static boolean readGateLeEnabled() {
        long now = System.currentTimeMillis();
        if (gateLeCfgAt != 0 && now - gateLeCfgAt < GATE_LE_CACHE_MS) return gateLeCfg;
        gateLeCfgAt = now;
        boolean v = true;
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(UIPREFS_FILE));
            try {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.startsWith(GATE_LE_PREFIX)) {
                        v = !"0".equals(line.substring(GATE_LE_PREFIX.length()).trim());
                        break;
                    }
                }
            } finally {
                br.close();
            }
        } catch (Throwable ignored) {
            // 文件不存在属正常（守护进程尚未写过），走默认值
        }
        gateLeCfg = v;
        return v;
    }

    /**
     * 实测 {@code BLUETOOTH_CONNECT} 是否已授予，结果缓存到 {@link #btConnectPerm}。
     * 由 {@code connect()} 的 before 钩子调用（与崩溃同线程），供 {@code checkBluetoothPermission} 钩子判定：
     * 未授予（0）时不替 SDK 放行，让它自己早退；未知（-1）仍放行，保留 Android 16 修复。
     * 取不到 Context / 低版本 / 任何异常一律保持未知，绝不阻断。
     */
    private static void probeBtConnectPermission() {
        try {
            Context ctx = appContext;
            if (ctx == null || Build.VERSION.SDK_INT <= Build.VERSION_CODES.R) return;
            btConnectPerm = (ctx.checkSelfPermission("android.permission.BLUETOOTH_CONNECT")
                    == PackageManager.PERMISSION_GRANTED) ? 1 : 0;
        } catch (Throwable ignored) {
            // 探测失败保持未知（-1）：按放行处理，不改变原有 Android 16 修复
        }
    }

    /**
     * 全新安装守卫：两项「附近的设备」运行时权限是否都已授予。
     * 仅用于「是否自动跳设置页」——未授予时留在引导页，由宿主的按钮流程一次性申请
     * BLUETOOTH_CONNECT + BLUETOOTH_SCAN；SDK≤30、取不到 Context 或任何异常一律返回 true（不阻断）。
     */
    private static boolean hasNearbyPermissions(Context ctx) {
        if (ctx == null || Build.VERSION.SDK_INT <= Build.VERSION_CODES.R) return true;
        try {
            return ctx.checkSelfPermission("android.permission.BLUETOOTH_SCAN")
                    == PackageManager.PERMISSION_GRANTED
                    && ctx.checkSelfPermission("android.permission.BLUETOOTH_CONNECT")
                    == PackageManager.PERMISSION_GRANTED;
        } catch (Throwable t) {
            return true;
        }
    }

    /** "门禁放行"日志限频（5 分钟一条，与重连类日志同口径）。 */
    private static boolean gateLeLogAllowed() {
        long now = System.currentTimeMillis();
        if (now - gateLeLogAt < RECONNECT_LOG_INTERVAL_MS) return false;
        gateLeLogAt = now;
        return true;
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

    /** B6X 专属：启动自动进入设置界面 */
    private static void hookB6Activity(XC_LoadPackage.LoadPackageParam lpparam) {
        // ========== B6X 启动自动进入设置界面（事件驱动） ==========
        // 行为：每次 App 进入前台跳一次设置页（冷启动 / 后台切回）；同一前台会话内从设置页返回引导页不再弹回。
        // 判据：resumedActivityCount 归零 + 最后一个 Activity 停止且非返回/旋转 → 退后台待定标记；
        //       下次 onResume 消费：设置页置 enteredSetup=true，引导页开新会话后再自动进入。
        try {
            XposedHelpers.findAndHookMethod(android.app.Activity.class, "onResume", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    resumedActivityCount.incrementAndGet();
                    if (isMainActivity(param.thisObject)) {
                        // 从后台切回引导页：开新一轮前台会话，允许本次自动进入（第一条消费路径）
                        if (appBackgrounded && setupResumeHookReady) {
                            appBackgrounded = false;
                            if (enteredSetup) {
                                enteredSetup = false;
                                XposedBridge.log(TAG + " 前台会话重新开始：enteredSetup 复位");
                            }
                        }
                        currentGuideActivity = (Activity) param.thisObject;
                        autoEnterSetup();  // 已连接则立即跳；未连接则等 onGattConnected 触发
                        autoStartSetup();  // 冷启动自动进入设置界面；其 onResume 会 tryConnect()
                    }
                }
            });
            XposedHelpers.findAndHookMethod(android.app.Activity.class, "onPause", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) {
                    if (resumedActivityCount.decrementAndGet() < 0) {
                        resumedActivityCount.set(0);   // 钩子晚装等异常时序的防御性钳位
                    }
                    if (isMainActivity(param.thisObject)
                            && currentGuideActivity == param.thisObject) {
                        currentGuideActivity = null;
                    }
                }
            });
            Class<?> b6ExpAct = lpparam.classLoader.loadClass("com.example.extool.B6ExperimentalActivity");
            // 宿主签名为 onCreate(Landroid/os/Bundle;)V —— 必须传 Bundle.class，否则本钩子注册失败（此前漏参即此因）。
            //   注：本轮删除「设置页退让」onResume 钩子后，onCreate 已是本 try 内最后一个钩子，其失败不再连带后续钩子。
            XposedHelpers.findAndHookMethod(b6ExpAct, "onCreate", Bundle.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    enteredSetup = true;  // 已进入过设置界面，此后不再自动跳
                }
            });
            XposedBridge.log(TAG + " 已钩住 Activity 基类生命周期（MainActivity 自动进入设置界面）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩自动进入设置界面失败: " + t.getMessage());
        }

        // ========== 前台会话判定：退后台只武装待定标记（独立 try，失败退回进程级行为） ==========
        try {
            XposedHelpers.findAndHookMethod(android.app.Activity.class, "onStop", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    try {
                        if (resumedActivityCount.get() != 0) return;   // 仍有前台 Activity：页面切换，不是退后台
                        Activity act = (Activity) param.thisObject;
                        // 返回键 finish、旋转重建都不算退后台；对话框只有 onPause、分屏/可见 PiP 不会 onStop
                        if (act.isFinishing() || act.isChangingConfigurations()) return;
                        appBackgrounded = true;   // 只武装；是否复位 enteredSetup 由下次 onResume 决定
                    } catch (Throwable t) {
                        // 判定失败按「未退后台」处理：不复位，等同当前进程级行为
                    }
                }
            });
            XposedBridge.log(TAG + " 已钩住 Activity.onStop（前台会话结束判定）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 Activity.onStop 失败（自动进入设置界面退回进程级行为）: " + t.getMessage());
        }

        // ========== 设置页 onResume：补「切回时人已在设置页」漏口（第二条消费路径） ==========
        try {
            Class<?> b6ExpAct = lpparam.classLoader.loadClass("com.example.extool.B6ExperimentalActivity");
            XposedHelpers.findAndHookMethod(b6ExpAct, "onResume", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    enteredSetup = true;       // 此刻人就在设置页 = 本次前台会话已进过
                    appBackgrounded = false;   // 消费退后台标记：返回引导页不会弹回
                }
            });
            setupResumeHookReady = true;
            XposedBridge.log(TAG + " 已钩住 B6ExperimentalActivity.onResume（设置页 = 已进入判定）");
        } catch (Throwable t) {
            setupResumeHookReady = false;   // 闸门关闭：退后台标记永不消费，enteredSetup 保持进程级语义
            XposedBridge.log(TAG + " 钩设置页 onResume 失败（自动进入设置界面退回进程级行为）: " + t.getMessage());
        }
    }

    /**
     * B7X 专属：自动进入设备控制页（farsef）。
     * 行为与 B6X 一致：每次回到前台且设备首页可见时进一次；同一前台会话内从控制页返回不再弹回；
     * 守护进程拉起的会话不进入。控制页是独立 Activity（DetailActivity），会话判定用 Activity 级信号。
     * 任一宿主类/extra 不可用只记日志并放弃本次进入，绝不上抛（见 app/逻辑说明.md §1.6）。
     */
    private static void hookB7Activity(XC_LoadPackage.LoadPackageParam lpparam) {
        // ========== 前台会话计数 + 控制页识别 ==========
        try {
            XposedHelpers.findAndHookMethod(Activity.class, "onResume", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    try {
                        b7ResumedCount.incrementAndGet();
                        Activity act = (Activity) param.thisObject;
                        if (isB7DetailActivity(act)) {
                            b7EnteredControl = true;    // 已进过控制页（含用户手动进入）
                            b7AppBackgrounded = false;  // 回到控制页：消费退后台标记
                        }
                    } catch (Throwable t) { /* 会话判定失败不阻断宿主 */ }
                }
            });
            XposedHelpers.findAndHookMethod(Activity.class, "onPause", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) {
                    if (b7ResumedCount.decrementAndGet() < 0) {
                        b7ResumedCount.set(0);   // 钩子晚装等异常时序的防御性钳位
                    }
                }
            });
            XposedHelpers.findAndHookMethod(Activity.class, "onStop", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    try {
                        if (b7ResumedCount.get() != 0) return;   // 仍有前台 Activity：页面切换，不是退后台
                        Activity act = (Activity) param.thisObject;
                        // 返回键 finish、旋转重建都不算退后台；对话框只有 onPause、分屏/可见 PiP 不会 onStop
                        if (act.isFinishing() || act.isChangingConfigurations()) return;
                        if (act == b7AutoEnterFrom) {
                            // 本模块自动跳转引起的停止（新 Activity 已在上面）：不是退后台，
                            // 否则从控制页返回时会误判成新会话而再次弹入。
                            b7AutoEnterFrom = null;
                            return;
                        }
                        b7AppBackgrounded = true;   // 只武装；是否复位 b7EnteredControl 由下次设备首页 onResume 决定
                        // 本次前台会话到此结束：daemon 会话豁免必须同步失效。否则从最近任务恢复
                        // （Activity 不重建、也不走 onNewIntent）会永久命中 onB7HomeResumed 开头的 return。
                        b7AutoLaunchSession = false;
                    } catch (Throwable t) { /* 判定失败按「未退后台」处理 */ }
                }
            });
            // 守护进程在已有任务上二次拉起（onNewIntent）时同步会话标记
            XposedHelpers.findAndHookMethod(Activity.class, "onNewIntent", Intent.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    try {
                        Intent intent = (Intent) param.args[0];
                        b7AutoLaunchSession = intent != null
                                && "1".equals(intent.getStringExtra(AUTO_LAUNCH_EXTRA));
                    } catch (Throwable t) { /* 读不到按非 daemon 会话处理 */ }
                }
            });
            XposedBridge.log(TAG + " 已钩住 Activity 生命周期（B7X 自动进入控制页·会话判定）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 B7X 会话判定失败（不自动进入控制页）: " + t.getMessage());
        }

        // ========== 触发点：设备首页 onResume（协议/权限门之后才存在） ==========
        hookClassMethod(lpparam.classLoader, B7_HOME_FRAGMENT, "f4",
                "DeviceHomeFragment.f4（B7X 自动进入控制页）",
                "钩 DeviceHomeFragment.f4 失败（B7X 不自动进入控制页）",
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        try {
                            onB7HomeResumed(param.thisObject);
                        } catch (Throwable t) {
                            b7AutoEnterLog("B7X 自动进入控制页异常: " + t.getMessage());
                        }
                    }
                });
    }

    /** 设备首页可见时的自动进入决策（只在主线程 onResume 回调里调用）。 */
    private static void onB7HomeResumed(Object fragment) {
        // 守护进程拉起的会话：保持现有「拉起即后台」，不进入
        if (autoLaunchPending || b7AutoLaunchSession) return;
        if (b7AppBackgrounded) {
            b7AppBackgrounded = false;
            if (b7EnteredControl) {   // 退后台再回来 = 新前台会话
                b7EnteredControl = false;
                XposedBridge.log(TAG + " B7X 前台会话重新开始");
            }
        }
        if (b7EnteredControl) return;   // 本次会话已进过（含用户从控制页手动返回）
        Activity act = b7FragmentActivity(fragment);
        if (act == null || act.isFinishing()) return;
        if (!hasNearbyPermissions(act)) return;   // 权限未授予：不绕过宿主的授权流程
        String code = loadLastWaspwingCode();
        if (code == null) {
            b7AutoEnterLog("B7X 自动进入控制页跳过：未取得设备码");
            return;
        }
        if (!isB7AutoEnterCode(code)) {
            b7AutoEnterLog("B7X 自动进入控制页跳过：型号 " + code + " 不在自动进入范围");
            return;
        }
        b7EnteredControl = true;   // 先占位去重；启动失败再回退
        if (!startB7ControlPage(act, code)) b7EnteredControl = false;
    }

    /** 取 Fragment 所属 Activity；取不到返回 null。 */
    private static Activity b7FragmentActivity(Object fragment) {
        try {
            Object ctx = XposedHelpers.callMethod(fragment, "getActivity");
            return (ctx instanceof Activity) ? (Activity) ctx : null;
        } catch (Throwable t) {
            return null;
        }
    }

    /** 是否为 B7X 的散热器控制页（type=3 且设备码属于 waspwing；老机型只用于去重）。 */
    private static boolean isB7DetailActivity(Activity act) {
        try {
            if (!B7_DETAIL_ACTIVITY.equals(act.getClass().getName())) return false;
            Intent intent = act.getIntent();
            if (intent == null || intent.getIntExtra(EXTRA_KEY_DEVICE_TYPE, 1) != 3) return false;
            return isB7WaspwingCode(intent.getStringExtra(EXTRA_KEY_DEVICE_CODE));
        } catch (Throwable t) {
            return false;
        }
    }

    /** waspwing 全量设备码（含老机型）：用于「已进过控制页」的判定。 */
    private static boolean isB7WaspwingCode(String code) {
        if (code == null) return false;
        switch (code) {
            case "b3":
            case "b5":
            case "b5p":
            case "b6":
            case "b6x":
            case "b7":
            case "b7x":
                return true;
            default:
                return false;
        }
    }

    /** 主动进入的目标：仅 6/7 两代（老机型不主动进入）。 */
    private static boolean isB7AutoEnterCode(String code) {
        return "b6".equals(code) || "b6x".equals(code)
                || "b7".equals(code) || "b7x".equals(code);
    }

    /**
     * 启动宿主控制页 DetailActivity（显式 Intent，宿主 onCreate 会跑 ARouter 注入读 extras）。
     * 失败只记日志并返回 false，不崩宿主。
     */
    private static boolean startB7ControlPage(Activity from, String code) {
        try {
            Intent intent = new Intent();
            intent.setClassName(from.getPackageName(), B7_DETAIL_ACTIVITY);
            intent.putExtra(EXTRA_KEY_DEVICE_TYPE, 3);
            intent.putExtra(EXTRA_KEY_DEVICE_CODE, code);
            intent.putExtra(EXTRA_IP_TYPE, -1);          // 宿主默认值即 -1，显式传以对齐路由参数
            intent.putExtra("b7x_auto_enter", true);     // 仅供本模块识别，宿主忽略未知 extra
            b7AutoEnterFrom = from;                       // 本次跳转引起的 onStop 不算退后台
            from.startActivity(intent);
            XposedBridge.log(TAG + " B7X 自动进入控制页 code=" + code);
            return true;
        } catch (Throwable t) {
            b7AutoEnterFrom = null;
            b7AutoEnterLog("B7X 自动进入控制页失败: " + t.getMessage());
            return false;
        }
    }

    /** 型号码落点：宿主 app 私有目录（与上次设备 MAC 同套路，按包名拼死路径）。 */
    private static String lastDevCodeFileFor(String pkg) {
        return "/data/data/" + pkg + "/files/tempctrl_last_dev_code";
    }

    /** 持久化上次散热器型号码（每包回传都会走这里，值未变不写盘）。 */
    private static void saveLastWaspwingCode(String code) {
        if (lastDevCodeFile == null || code == null) return;
        String c = code.trim();
        if (c.isEmpty() || c.equals(lastWaspwingCodeCache)) return;
        try {
            File parent = new File(lastDevCodeFile).getParentFile();
            if (parent != null) parent.mkdirs();
            FileOutputStream fos = new FileOutputStream(lastDevCodeFile);
            fos.write((c + "\n").getBytes());
            fos.close();
            lastWaspwingCodeCache = c;
        } catch (Throwable t) {
            b7AutoEnterLog("B7X 保存设备码失败: " + t.getMessage());
        }
    }

    /** 读取上次散热器型号码：内存缓存 → 落盘文件 → 反射宿主 v5.a.j().k() 兜底；都拿不到返回 null。 */
    private static String loadLastWaspwingCode() {
        String code = lastWaspwingCodeCache;
        if (code != null) return code;
        code = readLastWaspwingCodeFile();
        if (code == null) code = readWaspwingCodeFromHost();
        if (code != null) {
            lastWaspwingCodeCache = code;
            saveLastWaspwingCode(code);   // 反射兜底取到的也落盘，下次冷启动不再依赖宿主内部实现
        }
        return code;
    }

    /** 读模块自己落的型号码文件；无文件/读失败返回 null（从未连接过属正常路径）。 */
    private static String readLastWaspwingCodeFile() {
        if (lastDevCodeFile == null) return null;
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(lastDevCodeFile));
            String line = br.readLine();
            br.close();
            return (line != null && !line.trim().isEmpty()) ? line.trim() : null;
        } catch (Throwable t) {
            return null;
        }
    }

    /** 反射宿主持久化的散热器信息兜底：v5.a.j().k().getDeviceCode()；失败返回 null。 */
    private static String readWaspwingCodeFromHost() {
        try {
            ClassLoader cl = appClassLoader;
            if (cl == null) return null;
            Class<?> holder = cl.loadClass("v5.a");   // 宿主设备信息单例
            Object inst = XposedHelpers.callStaticMethod(holder, "j");
            if (inst == null) return null;
            Object info = XposedHelpers.callMethod(inst, "k");
            if (info == null) return null;
            Object codeObj = XposedHelpers.callMethod(info, "getDeviceCode");
            if (codeObj == null) return null;
            String code = String.valueOf(codeObj).trim();
            return (code.isEmpty() || "null".equals(code)) ? null : code;
        } catch (Throwable t) {
            b7AutoEnterLog("B7X 反射读取宿主设备码失败: " + t.getMessage());
            return null;
        }
    }

    /** 自动进入相关失败日志限频（60s 一条）。 */
    private static void b7AutoEnterLog(String msg) {
        long now = System.currentTimeMillis();
        if (now - b7AutoEnterLogAt < B7_AUTO_ENTER_LOG_MIN_INTERVAL_MS) return;
        b7AutoEnterLogAt = now;
        XposedBridge.log(TAG + " " + msg);
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
        if (appKind != 6) return;  // 仅 B6X（B7X 走 hookB7Obfuscated 的连接状态修正）
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

            // 收包者定基准：B6X 数据到达时把 currentValidGatt 重绑到真在收包的 gatt，
            // 消除「命令写进失效 gatt 被静默丢弃」窗口（见 app/逻辑说明.md §1.3）。
            try {
                XposedHelpers.findAndHookMethod(
                        lpparam.classLoader.loadClass(
                                "com.flydigi.sdk.bluetooth.LeDataInteractionController$mGattCallback$1"),
                        "onCharacteristicChanged",
                        BluetoothGatt.class, android.bluetooth.BluetoothGattCharacteristic.class,
                        new XC_MethodHook() {
                            @Override
                            protected void afterHookedMethod(MethodHookParam param) {
                                if (!bleConnected) return;
                                BluetoothGatt gatt = (BluetoothGatt) param.args[0];
                                if (gatt != null) {
                                    currentValidGatt = gatt;   // 收包实例 = 真在通信的 gatt，作下发基准
                                }
                            }
                        });
                XposedBridge.log(TAG + " 已钩住 LeDataInteractionController.onCharacteristicChanged（收包锚点）");
            } catch (Throwable t) {
                XposedBridge.log(TAG + " 钩 onCharacteristicChanged 失败: " + t.getMessage());
            }
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 onGattConnected 失败: " + t.getMessage());
        }
    }

    /**
     * 加固一：hook SDK 的连接超时路径，替 SDK 补上失败路径漏掉的 gatt.close()（堵句柄泄漏）。
     *
     * SDK 的 connect() 每发起一次连接就新建一个 mBluetoothGatt；5 秒未连上时，超时回调只把状态置回 0
     * （B6X `onGattConnectTimeout` / B7X `c0.R1`），**不 close 该 gatt** —— 每次失败都漏一个 GATT 客户端
     * 句柄，耗尽后再也连不上（长断联后"进程存活却不重连"的成因之一）。此处在其 after 回调里补 close()。
     * 只关「已确认未连上」(state==0) 的当前句柄，不追正在建立的连接；hook 失配只记日志、退回现状。
     */
    private static void hookGattConnectTimeoutClose(XC_LoadPackage.LoadPackageParam lpparam) {
        String clsName = (appKind == 7)
                ? "com.flydigi.sdk.bluetooth.c0"                             // B7X 混淆基类
                : "com.flydigi.sdk.bluetooth.LeDataInteractionController";   // B6X
        String method = (appKind == 7) ? "R1" : "onGattConnectTimeout";
        try {
            Class<?> cls = lpparam.classLoader.loadClass(clsName);
            XposedHelpers.findAndHookMethod(cls, method, BluetoothDevice.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    try {
                        int st = XposedHelpers.getIntField(param.thisObject, stateFieldName());
                        if (st != 0) return;   // 状态已非空闲：新一轮连接可能已在建，不碰
                        Object gatt = XposedHelpers.getObjectField(param.thisObject, gattFieldName());
                        if (gatt instanceof BluetoothGatt) {
                            ((BluetoothGatt) gatt).close();   // 只关句柄；字段留给下次 connect() 覆盖
                        } else {
                            // 异常面留痕：本该有句柄却为空（限频，不刷屏）
                            logReconnectExOnce("加固一: 超时补 close 跳过（句柄为空）");
                        }
                    } catch (Throwable t) {
                        // 字段缺失/关闭失败不再静默：留痕 + 计数（限频）
                        logReconnectExOnce("加固一: 超时补 close 失败 "
                                + t.getClass().getSimpleName() + ": " + t.getMessage());
                    }
                }
            });
            XposedBridge.log(TAG + " 已钩住 " + clsName + "." + method + "（超时补 close，堵句柄泄漏）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩连接超时补 close 失败: " + t.getMessage());
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
        // 混淆类 com.flydigi.sdk.waspwing.a 的方法映射（S1=连接成功 / T1=断连 / Z0=特征分发）
        // 与 B7X 连接修复见 app/逻辑说明.md §1.5。

        // 连接成功 → 置状态 + 型号识别 + 捕获参数 + 写状态
        hookClassMethod(lpparam.classLoader, "com.flydigi.sdk.waspwing.a",
                "S1", "b7x a.S1（连接状态 + 型号识别）", "钩 b7x a.S1 失败",
                BluetoothGatt.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        try {
                            // 型号未知按包名兜底，随后 X.getDeviceCode() 修正
                            markConnected((BluetoothGatt) param.args[0]);
                            captureInfoFromController(param.thisObject);
                            stopControllerScan(param.thisObject);   // B7X 连接成功后停扫描（对齐 B6X 的 hookControllerStopScan）
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

        // 数据分发 → 刷新回传 + 型号修正（7→6）+ 同步 owner
        hookClassMethod(lpparam.classLoader, "com.flydigi.sdk.waspwing.a",
                "Z0", "b7x a.Z0（数据回传 + 型号识别）", "钩 b7x a.Z0 失败",
                UUID.class, byte[].class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        captureInfoFromController(param.thisObject);
                    }
                });

        // 断连（远程/本地统一入口 a.T1）→ 置未连接 + 写状态
        hookClassMethod(lpparam.classLoader, "com.flydigi.sdk.waspwing.a",
                "T1", "b7x a.T1（断连检测）", "钩 b7x a.T1 失败",
                BluetoothGatt.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) {
                        try {
                            markDisconnected((BluetoothGatt) param.args[0]);
                            if (disconnectLogAllowed())
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
                        appContext = ctx;      // 存下宿主 Context，供 tick 线程取 PowerManager（息屏退避用）
                        registerTemperatureReceiver(ctx);
                        restoreLastDevice();   // 冷启动恢复上次设备引用，后台重连自动接管
                        startPeriodicStatusWrite();
                    }
                });
    }

    // ========== 上次设备持久化 + 自动拉起后台化 ==========

    /**
     * 上次设备 MAC 的落点：宿主 app 私有目录，各包各记。
     * 冷启动时本方法可能早于 Application 挂载运行，getFilesDir() 拿不到 context，
     * 故直接按包名拼死路径。
     */
    private static String lastDevFileFor(String pkg) {
        return "/data/data/" + pkg + "/files/tempctrl_last_dev";
    }

    /** 断连自动开蓝牙的限频时间戳落点（宿主 app 私有目录，各包各记；钩子自建自用） */
    private static String btOnAtFileFor(String pkg) {
        return "/data/data/" + pkg + "/files/tempctrl_bt_on_at";
    }

    /** 持久化上次连接的散热器 MAC（供冷启动自动连接 / 自动拉起使用） */
    private static void saveLastDeviceAddress(String addr) {
        if (lastDevFile == null) return;
        try {
            // 未用 getFilesDir()，不能假定 files/ 已存在，写前先建父目录
            File parent = new File(lastDevFile).getParentFile();
            if (parent != null) parent.mkdirs();
            // 用 FileOutputStream 直写地址并补 \n；读取时 trim
            FileOutputStream fos = new FileOutputStream(lastDevFile);
            fos.write((addr + "\n").getBytes());
            fos.close();
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 保存设备 MAC 失败: " + t.getMessage());
        }
    }

    /** 读取持久化的上次设备 MAC；无记录返回 null */
    private static String loadLastDeviceAddress() {
        if (lastDevFile == null) return null;
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(lastDevFile));
            String line = br.readLine();
            br.close();
            return (line != null && !line.trim().isEmpty()) ? line.trim() : null;
        } catch (Throwable t) {
            // 冷启动读取失败（每进程一次，低频）：区分"无记录"与"读文件异常"
            XposedBridge.log(TAG + " 读取上次设备 MAC 失败: " + lastDevFile
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
            lastDevice = adapter.getRemoteDevice(addr);   // 兜底对象：供 tick 守卫通过 + 取得目标地址
            needFreshObject = true;                        // B：首轮重连前尝试换成"类型已知"对象
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
                                    if (appKind == 7) b7AutoLaunchSession = true;  // 守护进程拉起：不自动进控制页
                                    scheduleAutoLaunchTimeout(act);  // 兜底：自动进入设置失败时仍退后台
                                } else if (appKind == 7
                                        && B7_MAIN_ACTIVITY.equals(act.getClass().getName())) {
                                    b7AutoLaunchSession = false;  // 用户主动打开 app：开新会话
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
                    backgroundForAutoLaunch(act);
                }
            });
            XposedBridge.log(TAG + " 已钩住 Activity.onCreate/onResume（b6x_auto_launch 后台化）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 auto_launch 失败: " + t.getMessage());
        }
    }

    /**
     * 自动拉起（守护进程拉起）：把当前任务切到后台（界面已就绪；连接由后台重连线程完成；事件触发时同步切，无固定延迟）。
     * 与返回键路径同源：开关开启时一并从最近任务隐藏（见 {@link #excludeFromRecents}）。
     */
    private static void backgroundForAutoLaunch(final Activity act) {
        backgroundActivity(act, "自动拉起");
        if (readBackHideEnabled()) excludeFromRecents(act);   // 与返回键路径一致：开关开则隐藏，失败不影响上面的收后台
    }

    /** 把当前任务切到后台，不动最近任务（是否隐藏由调用方自行决定）；{@code reason} 只进日志。 */
    private static void backgroundActivity(final Activity act, String reason) {
        try {
            act.moveTaskToBack(true);
            XposedBridge.log(TAG + " app 已切后台（" + reason + "）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 后台化失败（" + reason + "）：" + t.getMessage());
        }
    }

    /**
     * 把本任务从「最近任务」列表里摘掉（只影响任务列表、不动进程存活；属附加动作，
     * 失败不影响调用方）。定位本任务靠 {@code task.getId() == act.getTaskId()}。
     * 理由见 app/逻辑说明.md §1.4。
     */
    private static void excludeFromRecents(final Activity act) {
        try {
            ActivityManager am = (ActivityManager) act.getSystemService(Context.ACTIVITY_SERVICE);
            if (am == null) {
                XposedBridge.log(TAG + " 从最近任务隐藏失败: 取不到 ActivityManager");
                return;
            }
            for (ActivityManager.AppTask task : am.getAppTasks()) {
                ActivityManager.RecentTaskInfo info = task.getTaskInfo();
                if (info != null && info.id == act.getTaskId()) {
                    task.setExcludeFromRecents(true);
                    XposedBridge.log(TAG + " 已从最近任务隐藏（taskId=" + info.id + "）");
                    return;
                }
            }
            XposedBridge.log(TAG + " 从最近任务隐藏失败: 未匹配到本任务（taskId=" + act.getTaskId() + "）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 从最近任务隐藏失败: " + t.getMessage());
        }
    }

    /**
     * 读界面上的「返回隐藏后台」开关（守护进程写的 {@code BACK_HIDE=0/1}）。
     * 每次读以做到改即生效；读不到一律 true（默认开启）。见 app/逻辑说明.md §1.4。
     */
    private static boolean readBackHideEnabled() {
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(UIPREFS_FILE));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("BACK_HIDE=")) {
                    String v = line.substring("BACK_HIDE=".length()).trim();
                    br.close();
                    return !"0".equals(v);   // 只有明确的 0 才关闭
                }
            }
            br.close();
        } catch (Throwable ignored) {
            // 文件不存在属正常（守护进程尚未写过），走默认值
        }
        return true;
    }

    /**
     * 断连自动开蓝牙的间隔秒数（读守护进程写的 {@code BT_ON_SEC=}；带 30s 缓存）。
     * 读不到按默认 300（功能开启）；≤0 表示关闭本功能。只在 tick 线程调用。
     */
    private static int btAutoEnableSec() {
        long now = System.currentTimeMillis();
        if (btSecCache >= 0 && now - btSecReadAt < BT_SEC_CACHE_MS) return btSecCache;
        int v = BT_SEC_DEFAULT;
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(UIPREFS_FILE));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("BT_ON_SEC=")) {
                    v = Integer.parseInt(line.substring("BT_ON_SEC=".length()).trim());
                    break;
                }
            }
            br.close();
        } catch (Throwable ignored) {
            // 文件不存在（守护进程尚未写过）或解析失败：按默认值
        }
        btSecCache = v;
        btSecReadAt = now;
        return v;
    }

    /**
     * 断连自动开蓝牙：限频通过则写一次请求，交守护进程（root）执行。只在 tick 线程调用。
     * 限频时间戳落盘（宿主私有目录），跨宿主进程重启有效（进程被杀重启也不清零）。
     */
    private static void maybeAutoEnableBtOnce() {
        try {
            int sec = btAutoEnableSec();
            if (sec <= 0) return;                    // 0=关闭本功能
            if (!btCooldownPassed(sec)) return;
            try {
                FileOutputStream fos = new FileOutputStream(BT_REQ_FILE);
                fos.write(("REQ=" + (System.currentTimeMillis() / 1000L) + "\n").getBytes());
                fos.close();
                XposedBridge.log(TAG + " 自动开蓝牙: 已请求守护进程开启（间隔 " + sec + "s）");
            } catch (Throwable t) {
                // 文件缺失（守护进程未运行/未预建）或不可写：记一条，下个冷却窗再试
                XposedBridge.log(TAG + " 自动开蓝牙: 写请求失败（守护进程未运行？）: " + t.getMessage());
            }
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 自动开蓝牙异常: " + t.getMessage());
        }
    }

    /** 限频判定：距上次已过 ≥sec 秒才放行，放行即刻把当前时间落盘。读/写失败一律放行。 */
    private static boolean btCooldownPassed(int sec) {
        if (btOnAtFile == null) return true;
        long now = System.currentTimeMillis();
        long last = 0;
        try {
            BufferedReader br = new BufferedReader(new java.io.FileReader(btOnAtFile));
            String line = br.readLine();
            br.close();
            if (line != null && !line.trim().isEmpty()) last = Long.parseLong(line.trim());
        } catch (Throwable ignored) {
            // 无记录 / 读失败：视为可放行
        }
        if (last > 0 && now - last < sec * 1000L) return false;
        try {
            File parent = new File(btOnAtFile).getParentFile();
            if (parent != null) parent.mkdirs();
            FileOutputStream fos = new FileOutputStream(btOnAtFile);
            fos.write((now + "\n").getBytes());
            fos.close();
        } catch (Throwable ignored) {
            // 落盘失败：本次仍放行，下轮按无记录重判
        }
        return true;
    }

    /** 返回键不接管的页面：宿主 APK 里借壳的透明转发页（不是用户可见页面） */
    private static final String[] BACK_HIDE_SKIP_ACTIVITIES = {
            "com.blankj.utilcode.util.UtilsTransActivity",   // 含 UtilsTransActivity4MainProcess
            "rx_activity_result2.HolderActivity",
    };

    /**
     * 该 Activity 是否在返回键接管范围内（排除宿主 APK 的透明转发页，见
     * {@link #BACK_HIDE_SKIP_ACTIVITIES}）。理由见 app/逻辑说明.md §1.4。
     */
    private static boolean isBackHideTargetActivity(final Activity act) {
        String cls = act.getClass().getName();
        for (String skip : BACK_HIDE_SKIP_ACTIVITIES) {
            if (cls.startsWith(skip)) return false;
        }
        return true;
    }

    /**
     * 返回键退出时把 app 收进后台 + 从最近任务隐藏，而不是真正退出。
     *
     * <p>接管判据、为何不再硬要求 isTaskRoot、两处钩子的必要性、排除表与预测性返回的处理，
     * 见 app/逻辑说明.md §1.4。
     *
     * <p>未验证：B7X（farsef）是否同为 {@code AppCompatActivity}（见 app/逻辑说明.md §10）；
     * androidx 类缺失时只跳过主钩子、保留兜底，不崩。
     */
    private static void hookBackToBackground(XC_LoadPackage.LoadPackageParam lpparam) {
        // 回调体两处共用一份，判据与开关读取保持一致
        final XC_MethodHook backHook = new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) {
                try {
                    Activity act = (Activity) param.thisObject;
                    boolean switchOn = readBackHideEnabled();   // 返回键是低频事件，每次读一次以做到改即生效
                    boolean taskRoot = act.isTaskRoot();
                    boolean inScope = taskRoot || isBackHideTargetActivity(act);
                    if (switchOn && !act.isFinishing() && inScope) {
                        param.setResult(null);               // 阻断默认的 finish
                        backgroundActivity(act, "返回键");   // 收后台（保进程、BLE 不断）
                        excludeFromRecents(act);             // 从最近任务隐藏（仅返回键路径；失败不影响上面的收后台）
                        return;
                    }
                    // 判据不成立也要留痕：真机靠这行区分"回调没进"与"进了但判据不成立"
                    XposedBridge.log(TAG + " 返回键未接管: isTaskRoot=" + taskRoot
                            + " 在范围内=" + inScope
                            + " pkg=" + act.getPackageName()
                            + " cls=" + act.getClass().getName()
                            + " finishing=" + act.isFinishing()
                            + " 开关=" + switchOn);
                } catch (Throwable t) {
                    XposedBridge.log(TAG + " 返回键后台化失败: " + t.getMessage());
                }
            }
        };

        // 主钩子：androidx ComponentActivity 重写的那份，宿主真实返回入口
        try {
            Class<?> componentActivity =
                    lpparam.classLoader.loadClass("androidx.activity.ComponentActivity");
            XposedHelpers.findAndHookMethod(componentActivity, "onBackPressed", backHook);
            XposedBridge.log(TAG + " 已钩住 ComponentActivity.onBackPressed（返回退出改为隐藏后台）");
        } catch (ClassNotFoundException e) {
            XposedBridge.log(TAG + " 无 androidx.activity.ComponentActivity，仅用 Activity 兜底钩子");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 ComponentActivity.onBackPressed 失败: " + t.getMessage());
        }

        // 兜底钩子：非 androidx 页面（与主钩子互斥，同一次返回只走一个）
        try {
            XposedHelpers.findAndHookMethod(Activity.class, "onBackPressed", backHook);
            XposedBridge.log(TAG + " 已钩住 Activity.onBackPressed（兜底）");
        } catch (Throwable t) {
            XposedBridge.log(TAG + " 钩 onBackPressed 失败: " + t.getMessage());
        }
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
                backgroundForAutoLaunch(act);
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
    /** 扫描标志字段名：B6X=inScanning，B7X=f16228r（AbstractBluetoothController，双设备同构） */
    private static String inScanningFieldName() { return (appKind == 7) ? "f16228r" : "inScanning"; }
    /** 扫描入口方法名（无参，内部检查并拒绝重复扫描）：B6X=startLeScan，B7X=A0 */
    private static String scanEntryMethodName() { return (appKind == 7) ? "A0" : "startLeScan"; }
    /** 停扫描方法名（无参，唯一清除扫描标志处）：B6X=stopScan，B7X=F0 */
    private static String stopScanMethodName() { return (appKind == 7) ? "F0" : "stopScan"; }

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

        // 状态自愈兜底：GATT 已就绪但 state≠2 时强制同步 state=2。
        // 风险登记（不改行为）：这是全仓唯一「裸写」SDK mDataConnectState 的位置（受 gatt!=null && st!=2 双重约束）。
        //   若此写入与 SDK 自身状态机不一致（gatt 实为陈旧/已断），会造成「模块以为已连、SDK 实为未连」的去同步，
        //   属独立审查 F9 与 B 报告点名的风险来源之一。保留既有语义，仅登记。
        try {
            // 字段名由常量表按 app 类型选择
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
        String[] names = (appKind == 7) ? SET_RUN_MODE_NAMES_B7 : SET_RUN_MODE_NAMES_B6;
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
            // 字段名由常量表按 app 类型选择
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
        // ③ 达上限：设备锁死，停止自动重连
        reconnectPending = false;
        if (!deviceLockedAlerted) {
            deviceLockedAlerted = true;
            XposedBridge.log(TAG + " 设备锁死: 连续 " + STALL_RECONNECT_MAX
                    + " 次重连仍无回传，停止自动重连，请强制重启 App（散热器重启无效）");
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
                    && dispatchStallCount >= DISPATCH_STALL_LIMIT);

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
        String dicField = dicFieldName();   // 常量表按 app 类型选择
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
                Object headSeen = null;    // 上次观察到的队首对象（接管判定用）
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
                        // 250ms 轮询（原 50ms；粒度论证见 app/逻辑说明.md §1.3）
                        Thread.sleep(250);
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

    private static volatile Class<?> sMainActivityClass = null;   // 已解析的 MainActivity 类（成功才缓存）

    /**
     * 判断对象是否为 B6X app 的 MainActivity（编译期无 app 类）。
     * 改用 app 类加载器 loadClass + isInstance（无子类）。
     * 首次解析成功后缓存类；解析失败不缓存（如 B7X 包无该类）。
     */
    private static boolean isMainActivity(Object obj) {
        try {
            Class<?> cls = sMainActivityClass;
            if (cls == null) {
                cls = obj.getClass().getClassLoader()
                        .loadClass("com.example.extool.MainActivity");
                sMainActivityClass = cls;
            }
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
        enterSetupActivity(act, true, "自动进入设置界面", null);
    }

    /**
     * 冷启动自动进设置界面；B6ExpActivity.onResume 未连 tryConnect。
     * enteredSetup 防重入：已进入过 / 从设置返回时不触发。
     */
    private static void autoStartSetup() {
        if (enteredSetup || bleConnected || currentGuideActivity == null) return;
        final Activity act = currentGuideActivity;
        // 全新安装：宿主尚未授予「附近的设备」权限。此时不自动跳设置页——设置页内的扫描只申请
        // BLUETOOTH_SCAN，连接时会因缺 BLUETOOTH_CONNECT 失败/崩溃；留在引导页让用户点按钮一次性申请两项。
        if (!hasNearbyPermissions(act)) {
            XposedBridge.log(TAG + " 冷启动未自动进入设置界面：蓝牙权限未授予，请先在引导页授权");
            return;
        }
        currentGuideActivity = null;  // 先清空去重
        enterSetupActivity(act, false, "冷启动进入设置界面", "冷启动自动进入设置界面（自动连接）");
    }

    /**
     * 进入 B6ExperimentalActivity 的公共实现。
     *
     * @param finishGuide   true=进入后 finish 引导页（autoEnterSetup 语义）
     * @param failLogPrefix 失败日志前缀（"自动进入设置界面" / "冷启动进入设置界面"）
     * @param okLog         成功日志；null 时不打
     */
    private static void enterSetupActivity(final Activity act, final boolean finishGuide,
                                           final String failLogPrefix, final String okLog) {
        try {
            final Class<?> b6ExpCls = act.getClassLoader()
                    .loadClass("com.example.extool.B6ExperimentalActivity");
            act.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Intent intent = new Intent(act, b6ExpCls);
                        act.startActivity(intent);
                        if (finishGuide) act.finish();
                        if (okLog != null) XposedBridge.log(TAG + " " + okLog);
                    } catch (Throwable t) {
                        XposedBridge.log(TAG + " " + failLogPrefix + "失败: " + t.getMessage());
                    }
                }
            });
        } catch (Throwable t) {
            XposedBridge.log(TAG + " " + failLogPrefix + " loadClass 失败: " + t.getMessage());
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
            // B7X 混淆管理器 t9.j 的 Kotlin 单例字段 f50990a（反编译确认）
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
     * 由 BLE 回调线程调用，字段均 volatile。
     */
    private static void markConnected(BluetoothGatt gatt) {
        // 记录上一连接状态，用于判断是否"断连→连接"翻转（决定唤醒次数是否重置）
        boolean wasConnected = bleConnected;
        bleConnected = true;
        diagLogCount = 0;            // 新连接：重置广播接收诊断计数（每连最多记录 DIAG_LOG_MAX_PER_CONN 对）
        setRunModeLogCount = 0;      // 新连接：重置"setRunMode 已下发"计数（每连最多 3 条）
        diagConnLogCount = 0;        // 新连接：重置连接诊断日志计数（每连最多 DIAG_CONN_LOG_MAX 条）
        lastReconnectAttemptLogAt = 0;   // 新连接：重置"后台重连尝试"限频计时（下条断连后首试立即可见）
        lastReconnectHeartbeatAt = 0;    // 新连接：重置重连心跳计时
        lastConnEnterLogAt = 0;          // 新连接：重置"进入"限频（进入/退出各自独立窗口）
        lastConnExitLogAt = 0;           // 新连接：重置"退出"限频
        disconnectLogged = false;        // 新连接：断连边沿标志复位（下个断连周期可再记一条）
        // 注意：不清 lastDisconnectLogAt —— 10s 冷却跨连接周期仍有效，防"连上-又断开"快速抖动刷屏
        lastReconnectExLogAt = 0;        // 新连接：重置连接期异常限频（异常计数 reconnectExCount 累计不清）
        needFreshObject = false;          // 新连接：设备对象已新鲜，无需再换
        reconnectFailStreak = 0;         // 新连接：连续失败归零（断开自扫的触发）
        stuckStateTicks = 0;             // 新连接：门禁卡死计时归零（严格化「连续 ≥30s」，防跨连接累计）
        lastScanReconnectAt = 0;         // 新连接：重置自扫重连冷却（下次断连达阈值即可再扫）
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
            Object codeObj = XposedHelpers.callMethod(info, "getDeviceCode");
            connectedModel = modelFromDeviceCode(codeObj);
            // B7X：顺手把原始型号码落盘，供下次冷启动自动进入控制页（值未变不写盘）
            if (appKind == 7 && codeObj != null) saveLastWaspwingCode(String.valueOf(codeObj));
            refreshLastOwnerIfNeeded();  // 型号修正后同步 BLE_OWNER_LAST
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
                // 收包者定基准：B7X 收包时把 currentValidGatt 重绑到该 controller 的 gatt（见 app/逻辑说明.md §1.3）。
                BluetoothGatt g = connectedControllers.get(ctrl);
                if (g != null) currentValidGatt = g;
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
