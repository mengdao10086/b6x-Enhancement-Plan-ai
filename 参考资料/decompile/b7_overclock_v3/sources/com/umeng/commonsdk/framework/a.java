package com.umeng.commonsdk.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.connect.common.Constants;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.c;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import p4.f;

/* JADX INFO: loaded from: classes5.dex */
public class a implements UMImprintChangeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HandlerThread f24004a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Handler f24005b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f24006c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f24007d = 200;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f24008e = 273;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f24009f = 274;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f24010g = 512;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f24011h = 769;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static FileObserverC0259a f24012i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static ConnectivityManager f24013j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static IntentFilter f24014k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile boolean f24015l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static ArrayList<UMSenderStateNotify> f24016m = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f24019p = "report_policy";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f24020q = "report_interval";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f24022s = 15;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f24023t = 3;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f24024u = 90;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static BroadcastReceiver f24027x;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static Object f24017n = new Object();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static ReentrantLock f24018o = new ReentrantLock();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static boolean f24021r = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static int f24025v = 15;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static Object f24026w = new Object();

    /* JADX INFO: renamed from: com.umeng.commonsdk.framework.a$a, reason: collision with other inner class name */
    public static class FileObserverC0259a extends FileObserver {
        public FileObserverC0259a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i10, String str) {
            if ((i10 & 8) != 8) {
                return;
            }
            ULog.d("--->>> envelope file created >>> " + str);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            a.c(273);
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f24013j = (ConnectivityManager) appContext.getSystemService("connectivity");
        }
        f24027x = new BroadcastReceiver() { // from class: com.umeng.commonsdk.framework.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, b.a(context).a(), null);
                }
            }
        };
    }

    public a(Context context, Handler handler) {
        if (f24013j == null) {
            Context appContext = UMGlobalContext.getAppContext();
            if (f24013j != null) {
                f24013j = (ConnectivityManager) appContext.getSystemService("connectivity");
            }
        }
        f24006c = handler;
        try {
            if (f24004a == null) {
                HandlerThread handlerThread = new HandlerThread("NetWorkSender");
                f24004a = handlerThread;
                handlerThread.start();
                if (f24012i == null) {
                    FileObserverC0259a fileObserverC0259a = new FileObserverC0259a(UMFrUtils.getEnvelopeDirPath(context));
                    f24012i = fileObserverC0259a;
                    fileObserverC0259a.startWatching();
                    ULog.d("--->>> FileMonitor has already started!");
                }
                j();
                if (f24005b == null) {
                    f24005b = new Handler(f24004a.getLooper()) { // from class: com.umeng.commonsdk.framework.a.2
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            int i10 = message.what;
                            if (i10 == 273) {
                                ULog.d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                                try {
                                    a.f24018o.tryLock(1L, TimeUnit.SECONDS);
                                    try {
                                        a.n();
                                    } catch (Throwable unused) {
                                    }
                                    a.f24018o.unlock();
                                    return;
                                } catch (Throwable unused2) {
                                    return;
                                }
                            }
                            if (i10 == 274) {
                                a.l();
                            } else {
                                if (i10 != 512) {
                                    return;
                                }
                                a.m();
                            }
                        }
                    };
                }
                ImprintHandler.getImprintService(context).registImprintCallback(f24019p, this);
                ImprintHandler.getImprintService(context).registImprintCallback(f24020q, this);
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
        }
    }

    public static int b() {
        int i10;
        synchronized (f24026w) {
            i10 = f24025v;
        }
        return i10;
    }

    public static void c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(int i10) {
        Handler handler;
        if (!f24015l || (handler = f24005b) == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i10;
        f24005b.sendMessage(messageObtainMessage);
    }

    public static void d() {
        if (f24018o.tryLock()) {
            try {
                b(273);
            } finally {
                f24018o.unlock();
            }
        }
    }

    public static void e() {
        a(274, 3000);
    }

    private void j() {
        synchronized (f24026w) {
            if (Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE.equals(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), f24019p, ""))) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                f24021r = true;
                f24025v = 15;
                int iIntValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), f24020q, Constants.VIA_REPORT_TYPE_WPA_STATE)).intValue();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + iIntValue);
                if (iIntValue < 3 || iIntValue > 90) {
                    f24025v = 15;
                } else {
                    f24025v = iIntValue * 1000;
                }
            } else {
                f24021r = false;
            }
        }
    }

    private static void k() {
        if (f24004a != null) {
            f24004a = null;
        }
        if (f24005b != null) {
            f24005b = null;
        }
        if (f24006c != null) {
            f24006c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        int size;
        synchronized (f24017n) {
            ArrayList<UMSenderStateNotify> arrayList = f24016m;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                for (int i10 = 0; i10 < size; i10++) {
                    f24016m.get(i10).onSenderIdle();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        ULog.d("--->>> handleProcessNext: Enter...");
        if (f24015l) {
            Context appContext = UMModuleRegister.getAppContext();
            try {
                if (UMFrUtils.envelopeFileNumber(appContext) > 0) {
                    ULog.d("--->>> The envelope file exists.");
                    if (UMFrUtils.envelopeFileNumber(appContext) > 200) {
                        ULog.d("--->>> Number of envelope files is greater than 200, remove old files first.");
                        UMFrUtils.removeRedundantEnvelopeFiles(appContext, 200);
                    }
                    File envelopeFile = UMFrUtils.getEnvelopeFile(appContext);
                    if (envelopeFile != null) {
                        String path = envelopeFile.getPath();
                        ULog.d("--->>> Ready to send envelope file [" + path + "].");
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send envelope file [ " + path + "].");
                        if (!new c(appContext).a(envelopeFile)) {
                            ULog.d("--->>> Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                        ULog.d("--->>> Send envelope file success, delete it.");
                        if (!UMFrUtils.removeEnvelopeFile(envelopeFile)) {
                            ULog.d("--->>> Failed to delete already processed file. We try again after delete failed.");
                            UMFrUtils.removeEnvelopeFile(envelopeFile);
                        }
                        c(273);
                        return;
                    }
                }
                e();
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(appContext, th2);
            }
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        synchronized (f24026w) {
            if (f24019p.equals(str)) {
                if (Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE.equals(str2)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                    f24021r = true;
                } else {
                    f24021r = false;
                }
            }
            if (f24020q.equals(str)) {
                int iIntValue = Integer.valueOf(str2).intValue();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + iIntValue);
                if (iIntValue < 3 || iIntValue > 90) {
                    f24025v = 15000;
                } else {
                    f24025v = iIntValue * 1000;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + f24025v);
            }
        }
    }

    public static void a(Context context) {
        if (f24013j != null || context == null) {
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        f24013j = connectivityManager;
        if (connectivityManager != null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> createCMIfNeeded:注册网络状态监听器。");
            b(context);
        }
    }

    public static void b(Context context) {
        if (DeviceConfig.checkPermission(context, f.f46367b) && f24013j != null && f24014k == null) {
            IntentFilter intentFilter = new IntentFilter();
            f24014k = intentFilter;
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (f24027x != null) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器。");
                context.registerReceiver(f24027x, f24014k);
            }
        }
    }

    public static void a(UMSenderStateNotify uMSenderStateNotify) {
        synchronized (f24017n) {
            try {
                if (f24016m == null) {
                    f24016m = new ArrayList<>();
                }
                if (uMSenderStateNotify != null) {
                    for (int i10 = 0; i10 < f24016m.size(); i10++) {
                        if (uMSenderStateNotify == f24016m.get(i10)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> addConnStateObserver: input item has exist.");
                            return;
                        }
                    }
                    f24016m.add(uMSenderStateNotify);
                }
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th2);
            }
        }
    }

    private static void b(int i10) {
        Handler handler;
        if (!f24015l || (handler = f24005b) == null || handler.hasMessages(i10)) {
            return;
        }
        Message messageObtainMessage = f24005b.obtainMessage();
        messageObtainMessage.what = i10;
        f24005b.sendMessage(messageObtainMessage);
    }

    public static boolean a() {
        boolean z10;
        synchronized (f24026w) {
            z10 = f24021r;
        }
        return z10;
    }

    public static void a(boolean z10) {
        int size;
        f24015l = z10;
        if (z10) {
            synchronized (f24017n) {
                ArrayList<UMSenderStateNotify> arrayList = f24016m;
                if (arrayList != null && (size = arrayList.size()) > 0) {
                    for (int i10 = 0; i10 < size; i10++) {
                        f24016m.get(i10).onConnectionAvailable();
                    }
                }
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "网络状态通知：尝试发送 MSG_PROCESS_NEXT");
            d();
            return;
        }
        ULog.i("--->>> network disconnected.");
        f24015l = false;
    }

    private static void a(int i10, long j10) {
        Handler handler;
        if (!f24015l || (handler = f24005b) == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i10;
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> sendMsgDelayed: " + j10);
        f24005b.sendMessageDelayed(messageObtainMessage, j10);
    }

    private static void a(int i10, int i11) {
        Handler handler;
        if (!f24015l || (handler = f24005b) == null) {
            return;
        }
        handler.removeMessages(i10);
        Message messageObtainMessage = f24005b.obtainMessage();
        messageObtainMessage.what = i10;
        f24005b.sendMessageDelayed(messageObtainMessage, i11);
    }
}
