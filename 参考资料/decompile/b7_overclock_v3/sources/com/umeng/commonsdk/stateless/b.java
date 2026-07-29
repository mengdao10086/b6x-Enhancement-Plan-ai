package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.content.IntentFilter;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.an;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f24131a = 273;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f24132b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static HandlerThread f24133c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Handler f24134d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f24136f = 274;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f24137g = 275;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f24138h = 512;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static a f24139i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static IntentFilter f24140j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile boolean f24141k;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Object f24135e = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static LinkedList<String> f24142l = new LinkedList<>();

    public static class a extends FileObserver {
        public a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i10, String str) {
            if ((i10 & 8) != 8) {
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            b.a(274);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007c A[Catch: all -> 0x007e, DONT_GENERATE, TryCatch #1 {, blocks: (B:21:0x007c, B:20:0x0079, B:5:0x0008, B:7:0x0010, B:9:0x0014, B:11:0x0024, B:13:0x004b, B:14:0x0055, B:15:0x0066, B:17:0x006a), top: B:26:0x0008, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(android.content.Context r6) {
        /*
            r5 = this;
            r5.<init>()
            java.lang.Object r0 = com.umeng.commonsdk.stateless.b.f24135e
            monitor-enter(r0)
            if (r6 == 0) goto L7c
            android.content.Context r1 = r6.getApplicationContext()     // Catch: java.lang.Throwable -> L78
            com.umeng.commonsdk.stateless.b.f24132b = r1     // Catch: java.lang.Throwable -> L78
            if (r1 == 0) goto L7c
            android.os.HandlerThread r1 = com.umeng.commonsdk.stateless.b.f24133c     // Catch: java.lang.Throwable -> L78
            if (r1 != 0) goto L7c
            android.os.HandlerThread r1 = new android.os.HandlerThread     // Catch: java.lang.Throwable -> L78
            java.lang.String r2 = "SL-NetWorkSender"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L78
            com.umeng.commonsdk.stateless.b.f24133c = r1     // Catch: java.lang.Throwable -> L78
            r1.start()     // Catch: java.lang.Throwable -> L78
            com.umeng.commonsdk.stateless.b$a r1 = com.umeng.commonsdk.stateless.b.f24139i     // Catch: java.lang.Throwable -> L78
            if (r1 != 0) goto L66
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L78
            r1.<init>()     // Catch: java.lang.Throwable -> L78
            android.content.Context r2 = com.umeng.commonsdk.stateless.b.f24132b     // Catch: java.lang.Throwable -> L78
            java.io.File r2 = r2.getFilesDir()     // Catch: java.lang.Throwable -> L78
            r1.append(r2)     // Catch: java.lang.Throwable -> L78
            java.lang.String r2 = java.io.File.separator     // Catch: java.lang.Throwable -> L78
            r1.append(r2)     // Catch: java.lang.Throwable -> L78
            java.lang.String r2 = com.umeng.commonsdk.stateless.a.f24125f     // Catch: java.lang.Throwable -> L78
            r1.append(r2)     // Catch: java.lang.Throwable -> L78
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L78
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L78
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L78
            boolean r3 = r2.exists()     // Catch: java.lang.Throwable -> L78
            if (r3 != 0) goto L55
            java.lang.String r3 = "MobclickRT"
            java.lang.String r4 = "--->>> 2号数据仓目录不存在，创建之。"
            com.umeng.commonsdk.debug.UMRTLog.e(r3, r4)     // Catch: java.lang.Throwable -> L78
            r2.mkdir()     // Catch: java.lang.Throwable -> L78
        L55:
            com.umeng.commonsdk.stateless.b$a r2 = new com.umeng.commonsdk.stateless.b$a     // Catch: java.lang.Throwable -> L78
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L78
            com.umeng.commonsdk.stateless.b.f24139i = r2     // Catch: java.lang.Throwable -> L78
            r2.startWatching()     // Catch: java.lang.Throwable -> L78
            java.lang.String r1 = "MobclickRT"
            java.lang.String r2 = "--->>> 2号数据仓File Monitor启动."
            com.umeng.commonsdk.debug.UMRTLog.e(r1, r2)     // Catch: java.lang.Throwable -> L78
        L66:
            android.os.Handler r1 = com.umeng.commonsdk.stateless.b.f24134d     // Catch: java.lang.Throwable -> L78
            if (r1 != 0) goto L7c
            com.umeng.commonsdk.stateless.b$1 r1 = new com.umeng.commonsdk.stateless.b$1     // Catch: java.lang.Throwable -> L78
            android.os.HandlerThread r2 = com.umeng.commonsdk.stateless.b.f24133c     // Catch: java.lang.Throwable -> L78
            android.os.Looper r2 = r2.getLooper()     // Catch: java.lang.Throwable -> L78
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L78
            com.umeng.commonsdk.stateless.b.f24134d = r1     // Catch: java.lang.Throwable -> L78
            goto L7c
        L78:
            r1 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r1)     // Catch: java.lang.Throwable -> L7e
        L7c:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            return
        L7e:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.b.<init>(android.content.Context):void");
    }

    public static void a(boolean z10) {
        f24141k = z10;
        if (!z10) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络断连： 2号数据仓");
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络可用： 触发2号数据仓信封消费动作。");
            b(274);
        }
    }

    public static void b(int i10) {
        Handler handler;
        try {
            if (!f24141k || (handler = f24134d) == null || handler.hasMessages(i10)) {
                return;
            }
            Message messageObtainMessage = f24134d.obtainMessage();
            messageObtainMessage.what = i10;
            f24134d.sendMessage(messageObtainMessage);
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(f24132b, th2);
        }
    }

    public static void c() {
        b(f24137g);
    }

    public static void d() {
        b(512);
    }

    private static void i() {
        File[] fileArrC = d.c(f24132b);
        if (fileArrC != null) {
            if (f24142l.size() > 0) {
                f24142l.clear();
            }
            for (File file : fileArrC) {
                f24142l.add(file.getAbsolutePath());
            }
        }
    }

    private static String j() {
        String str = null;
        try {
            String strPeek = f24142l.peek();
            if (strPeek == null) {
                return strPeek;
            }
            try {
                f24142l.removeFirst();
                return strPeek;
            } catch (Throwable unused) {
                str = strPeek;
                return str;
            }
        } catch (Throwable unused2) {
        }
    }

    private static void k() {
        String strPollFirst;
        if (f24142l.size() <= 0) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            strPollFirst = f24142l.pollFirst();
            if (!TextUtils.isEmpty(strPollFirst)) {
                File file = new File(strPollFirst);
                if (file.exists()) {
                    c cVar = new c(f24132b);
                    byte[] bArrA = null;
                    try {
                        bArrA = d.a(strPollFirst);
                    } catch (Exception unused) {
                    }
                    String name = file.getName();
                    String strSubstring = !TextUtils.isEmpty(name) ? name.substring(0, 1) : "u";
                    String strC = d.c(d.d(name));
                    if (cVar.a(bArrA, strC, com.umeng.commonsdk.vchannel.a.f24436c.equalsIgnoreCase(strC) ? com.umeng.commonsdk.vchannel.a.f24434a : "", strSubstring) && !file.delete()) {
                        file.delete();
                    }
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                }
            }
        } while (strPollFirst != null);
        f24142l.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        File fileA;
        if (!f24141k || f24132b == null) {
            return;
        }
        do {
            try {
                fileA = d.a(f24132b);
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(f24132b, th2);
            }
            if (fileA != null && fileA.getParentFile() != null && !TextUtils.isEmpty(fileA.getParentFile().getName())) {
                c cVar = new c(f24132b);
                String str = new String(Base64.decode(fileA.getParentFile().getName(), 0));
                if (!com.umeng.commonsdk.internal.a.f24029a.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.f24030b.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.G.equalsIgnoreCase(str)) {
                    ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
                    byte[] bArrA = null;
                    try {
                        bArrA = d.a(fileA.getAbsolutePath());
                    } catch (Exception unused) {
                    }
                    String str2 = com.umeng.commonsdk.vchannel.a.f24436c.equalsIgnoreCase(str) ? com.umeng.commonsdk.vchannel.a.f24434a : "";
                    String str3 = UMServerURL.PATH_SHARE.equalsIgnoreCase(str) ? an.aB : "u";
                    if (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str)) {
                        str3 = "p";
                    }
                    if (!cVar.a(bArrA, str, str2, str3)) {
                        ULog.i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                        return;
                    }
                    ULog.i("walle", "[stateless] Send envelope file success, delete it.");
                    File file = new File(fileA.getAbsolutePath());
                    if (!file.delete()) {
                        ULog.i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                        file.delete();
                    }
                    m();
                }
                new File(fileA.getAbsolutePath()).delete();
            }
        } while (fileA != null);
        m();
    }

    private static void m() {
        try {
            File file = new File(f24132b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f24124e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
                d.a(file);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        if (!f24141k || f24132b == null) {
            return;
        }
        i();
        k();
        c();
    }

    private static void o() {
        try {
            File file = new File(f24132b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f24124e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
                b(273);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p() {
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
    }

    public static boolean a() {
        synchronized (f24135e) {
            return f24139i != null;
        }
    }

    public static void b() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>信封构建成功： 触发2号数据仓信封消费动作。");
        b(274);
    }

    public static void a(int i10) {
        Handler handler;
        if (!f24141k || (handler = f24134d) == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i10;
        f24134d.sendMessage(messageObtainMessage);
    }
}
