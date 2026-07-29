package com.uc.crashsdk;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.connect.common.Constants;
import com.uc.crashsdk.a.h;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import f0.v;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class b {
    private static boolean A = false;
    private static boolean B = false;
    private static boolean C = false;
    private static boolean D = false;
    private static boolean E = false;
    private static boolean F = false;
    private static String H = null;
    private static int I = 0;
    private static boolean J = false;
    private static boolean K = false;
    private static boolean L = true;
    private static RandomAccessFile M = null;
    private static boolean N = false;
    private static String P = null;
    private static boolean Q = false;
    private static volatile Object[] R = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f22989a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f23001b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f23002c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f23003d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f23005f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f23006g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f23007h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ boolean f23008i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f23009j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f23010k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f23011l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static String f23012m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static String f23013n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static String f23014o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static String f23015p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static String f23016q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static String f23017r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static String f23018s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static String f23019t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static String f23020u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static String f23021v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static String f23022w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static boolean f23023x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static boolean f23024y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static volatile boolean f23025z;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f23004e = new Object();
    private static final Object G = new Object();
    private static final Object O = new Object();
    private static Runnable S = new com.uc.crashsdk.a.e(101);
    private static boolean T = false;
    private static long U = 0;
    private static final Object V = new Object();
    private static long W = 0;
    private static boolean X = false;
    private static boolean Y = false;
    private static boolean Z = false;

    /* JADX INFO: renamed from: aa, reason: collision with root package name */
    private static long f22990aa = 0;

    /* JADX INFO: renamed from: ab, reason: collision with root package name */
    private static final WeakHashMap<Activity, Integer> f22991ab = new WeakHashMap<>();

    /* JADX INFO: renamed from: ac, reason: collision with root package name */
    private static boolean f22992ac = false;

    /* JADX INFO: renamed from: ad, reason: collision with root package name */
    private static String f22993ad = null;

    /* JADX INFO: renamed from: ae, reason: collision with root package name */
    private static boolean f22994ae = false;

    /* JADX INFO: renamed from: af, reason: collision with root package name */
    private static boolean f22995af = false;

    /* JADX INFO: renamed from: ag, reason: collision with root package name */
    private static boolean f22996ag = false;

    /* JADX INFO: renamed from: ah, reason: collision with root package name */
    private static boolean f22997ah = false;

    /* JADX INFO: renamed from: ai, reason: collision with root package name */
    private static boolean f22998ai = false;

    /* JADX INFO: renamed from: aj, reason: collision with root package name */
    private static final Object f22999aj = new Object();

    /* JADX INFO: renamed from: ak, reason: collision with root package name */
    private static PendingIntent f23000ak = null;

    public static boolean A() {
        return Y || !ad();
    }

    public static boolean B() {
        return Y && !f23023x;
    }

    public static void C() {
        com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(100));
    }

    public static void D() {
        String str;
        if (!f23003d || (str = f22993ad) == null) {
            return;
        }
        JNIBridge.set(129, str);
    }

    public static String E() {
        String str = f22993ad;
        return str == null ? "" : str;
    }

    public static boolean F() {
        if (!f22994ae) {
            if (!com.uc.crashsdk.a.g.a(a.f22909a) && a.f22909a.equals(e.h())) {
                f22995af = true;
                if (f23003d) {
                    JNIBridge.set(2, true);
                }
            }
            f22994ae = true;
        }
        return f22995af;
    }

    public static void G() {
        f22996ag = true;
        if (f23003d) {
            JNIBridge.set(34, true);
        }
    }

    public static boolean H() {
        return f22996ag;
    }

    public static int I() {
        boolean zU = U();
        return t() ? zU ? 3 : 6 : s() ? zU ? 2 : 5 : zU ? 4 : 1;
    }

    public static int J() {
        boolean zV = V();
        boolean zW = W();
        boolean zX = X();
        if (t()) {
            if (zV) {
                return 12;
            }
            if (zW) {
                return 14;
            }
            return zX ? 16 : 98;
        }
        if (!s()) {
            return 1;
        }
        if (zV) {
            return 11;
        }
        if (zW) {
            return 13;
        }
        return zX ? 15 : 97;
    }

    public static void K() {
        if (f23003d) {
            JNIBridge.nativeSet(27, I, Constants.VIA_REPORT_TYPE_SET_AVATAR, null);
            JNIBridge.set(30, L);
        }
    }

    public static boolean L() {
        if (!f22998ai) {
            synchronized (f22999aj) {
                if (!f22998ai) {
                    f22997ah = ae();
                    f22998ai = true;
                }
            }
        }
        return f22997ah;
    }

    public static void M() {
        if (e.F() || L() || f23000ak != null || g.h() < 0) {
            return;
        }
        try {
            Context contextA = com.uc.crashsdk.a.g.a();
            Intent launchIntentForPackage = contextA.getPackageManager().getLaunchIntentForPackage(contextA.getPackageName());
            launchIntentForPackage.addFlags(335544320);
            f23000ak = PendingIntent.getActivity(contextA, 0, launchIntentForPackage, 0);
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
    }

    public static boolean N() {
        if (f23000ak == null) {
            com.uc.crashsdk.a.a.b("Restart intent is null!");
            return false;
        }
        try {
            com.uc.crashsdk.a.a.a("crashsdk", "restarting ...");
            ((AlarmManager) com.uc.crashsdk.a.g.a().getSystemService(v.K0)).set(1, System.currentTimeMillis() + 200, f23000ak);
            return true;
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return false;
        }
    }

    public static /* synthetic */ boolean O() {
        f22992ac = true;
        return true;
    }

    private static String Q() {
        if (f23009j == null) {
            f23009j = d(com.google.android.exoplayer2.offline.a.f17428f);
        }
        return f23009j;
    }

    private static String R() {
        if (f23011l == null) {
            f23011l = d("ctn");
        }
        return f23011l;
    }

    private static String S() {
        if (f23012m == null) {
            f23012m = d("cta");
        }
        return f23012m;
    }

    private static void T() {
        if (f23025z || f23024y) {
            return;
        }
        synchronized (G) {
            if (f23025z) {
                return;
            }
            f(g.W());
            String strP = p();
            File file = new File(b());
            File file2 = new File(R());
            A = "f".equals(strP);
            B = "b".equals(strP);
            D = file.exists();
            boolean zExists = file2.exists();
            E = zExists;
            boolean z10 = D || zExists;
            C = z10;
            if (!z10 && (A || B)) {
                boolean zR = r();
                F = zR;
                C = zR;
            }
            try {
                if (z()) {
                    Z();
                }
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            f23025z = true;
        }
    }

    private static boolean U() {
        T();
        return C;
    }

    private static boolean V() {
        T();
        return D;
    }

    private static boolean W() {
        T();
        return E;
    }

    private static boolean X() {
        T();
        return F;
    }

    private static void Y() {
        if (f23003d) {
            JNIBridge.set(26, f23023x);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0041 -> B:29:0x0044). Please report as a decompilation issue!!! */
    private static void Z() {
        if (!T) {
            T = true;
            try {
                new File(b()).delete();
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            try {
                new File(R()).delete();
            } catch (Throwable th3) {
                com.uc.crashsdk.a.g.a(th3);
            }
            try {
                if (f23003d) {
                    JNIBridge.cmd(16);
                } else {
                    new File(S()).delete();
                }
            } catch (Throwable th4) {
                com.uc.crashsdk.a.g.a(th4);
            }
        }
        Object[] objArrAb = ab();
        if (!objArrAb[0].equals(P) && R == null) {
            a(objArrAb);
        } else {
            Q = true;
            aa();
        }
    }

    public static String a() {
        String str = H;
        if (str != null) {
            return str;
        }
        String strH = e.h();
        if (com.uc.crashsdk.a.g.a(strH)) {
            H = "LLUN";
        } else {
            int i10 = 0;
            if (strH.length() > 48) {
                int length = strH.length() - 48;
                strH = strH.substring(0, 48);
                i10 = length;
            }
            StringBuilder sb2 = new StringBuilder();
            byte[] bytes = strH.getBytes();
            for (int length2 = bytes.length - 1; length2 >= 0; length2--) {
                byte b10 = bytes[length2];
                if (b10 == 46) {
                    sb2.append('0');
                } else if (b10 == 58) {
                    sb2.append('1');
                } else if (b10 >= 97 && b10 <= 122) {
                    sb2.append((char) ((b10 + 65) - 97));
                } else if (b10 >= 65 && b10 <= 90) {
                    sb2.append((char) b10);
                } else if (b10 < 48 || b10 > 57) {
                    sb2.append('2');
                } else {
                    sb2.append((char) b10);
                }
            }
            if (i10 > 0) {
                sb2.append(String.valueOf(i10));
            }
            H = sb2.toString();
        }
        return H;
    }

    private static void aa() {
        if (!com.uc.crashsdk.a.f.b(S)) {
            com.uc.crashsdk.a.f.a(1, S);
            return;
        }
        Object[] objArr = R;
        if (objArr == null || !ab()[0].equals(objArr[0])) {
            com.uc.crashsdk.a.f.a(S);
            com.uc.crashsdk.a.f.a(1, S);
        }
    }

    private static Object[] ab() {
        synchronized (V) {
            long j10 = W + 1;
            W = j10;
            if (f23023x) {
                return new Object[]{"e", Long.valueOf(j10)};
            }
            if (B()) {
                return new Object[]{"f", Long.valueOf(W)};
            }
            return new Object[]{"b", Long.valueOf(W)};
        }
    }

    private static Object ac() {
        Object objA;
        Object objA2 = a((Application) com.uc.crashsdk.a.g.a(), (Class<?>) Application.class, "mLoadedApk");
        if (objA2 != null && (objA = a(objA2, (Class<?>) null, "mActivityThread")) != null) {
            return objA;
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentActivityThread", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, new Object[0]);
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
        return null;
    }

    private static boolean ad() {
        String strA = com.uc.crashsdk.a.g.a(new File("/proc/self/cgroup"), 512, false);
        if (com.uc.crashsdk.a.g.a(strA)) {
            return false;
        }
        return strA.contains("/bg_non_interactive") || strA.contains("/background");
    }

    private static boolean ae() {
        try {
            Method declaredMethod = Process.class.getDeclaredMethod("isIsolated", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, new Object[0]);
                if (objInvoke != null && (objInvoke instanceof Boolean)) {
                    return ((Boolean) objInvoke).booleanValue();
                }
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
        int iMyUid = Process.myUid() % 100000;
        return iMyUid >= 99000 && iMyUid <= 99999;
    }

    public static String b() {
        if (f23010k == null) {
            f23010k = d("ctj");
        }
        return f23010k;
    }

    private static String d(String str) {
        return g.W() + a() + j3.b.f36044h + str;
    }

    private static File[] e(String str) {
        if (!f23008i && str.length() <= 0) {
            throw new AssertionError();
        }
        File[] fileArrListFiles = new File(g.W()).listFiles();
        if (fileArrListFiles == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : fileArrListFiles) {
            if (file.getPath().endsWith(str)) {
                arrayList.add(file);
            }
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    public static File[] f() {
        return e(".stcb");
    }

    public static String g() {
        if (f23021v == null) {
            f23021v = d("bati");
        }
        return f23021v;
    }

    public static String h() {
        if (f23022w == null) {
            f23022w = d("hdr");
        }
        return f23022w;
    }

    public static String i() {
        if (f23016q == null) {
            f23016q = g.W() + CommonNetImpl.UP;
        }
        return f23016q;
    }

    public static String j() {
        if (f23017r == null) {
            f23017r = g.W() + "authu";
        }
        return f23017r;
    }

    public static String k() {
        if (f23018s == null) {
            f23018s = g.W() + "statu";
        }
        return f23018s;
    }

    public static String l() {
        if (f23019t == null) {
            f23019t = g.W() + "poli";
        }
        return f23019t;
    }

    public static String m() {
        if (f23020u == null) {
            f23020u = g.W() + "ver";
        }
        return f23020u;
    }

    public static String n() {
        return g.W() + "bvu";
    }

    public static String o() {
        return g.W() + "fds";
    }

    public static String p() {
        return com.uc.crashsdk.a.g.a(new File(Q()), 8, false);
    }

    public static boolean q() {
        return f23024y;
    }

    public static boolean r() {
        if (!J) {
            if (f23003d) {
                K = JNIBridge.cmd(15) == 1;
            } else {
                K = new File(S()).exists();
            }
            J = true;
        }
        return K;
    }

    public static boolean s() {
        T();
        return A;
    }

    public static boolean t() {
        T();
        return B;
    }

    public static boolean u() {
        return f23023x;
    }

    public static void v() {
        boolean z10;
        f(g.W());
        f23024y = true;
        A = false;
        B = false;
        C = false;
        D = false;
        E = false;
        F = false;
        String[] strArr = {".st", ".wa", ".callback", ".ctn", ".ctj", ".cta", ".signal"};
        String[] strArr2 = {CommonNetImpl.UP, "authu", "statu", "poli"};
        File[] fileArrListFiles = new File(g.W()).listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                String name = file.getName();
                int i10 = 0;
                while (true) {
                    if (i10 >= 7) {
                        z10 = false;
                        break;
                    } else {
                        if (name.endsWith(strArr[i10])) {
                            z10 = true;
                            break;
                        }
                        i10++;
                    }
                }
                if (!z10) {
                    int i11 = 0;
                    while (true) {
                        if (i11 >= 4) {
                            break;
                        }
                        if (name.equals(strArr2[i11])) {
                            z10 = true;
                            break;
                        }
                        i11++;
                    }
                }
                if (z10) {
                    com.uc.crashsdk.a.a.a("crashsdk", "delete file: " + file.getPath());
                    com.uc.crashsdk.a.g.a(file);
                }
            }
        }
        Z();
    }

    public static void w() {
        if (f23023x) {
            return;
        }
        f23023x = true;
        if (L() || e.u()) {
            return;
        }
        f(g.W());
        Y();
        Z();
    }

    public static boolean x() {
        return f(g.W());
    }

    public static boolean y() {
        return f(g.X());
    }

    public static boolean z() {
        return X || !ad();
    }

    public static String c() {
        if (f23013n == null) {
            f23013n = d("st");
        }
        return f23013n;
    }

    public static File[] d() {
        return e(".st");
    }

    private static boolean f(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            return true;
        }
        com.uc.crashsdk.a.a.a("crashsdk", "Crash log directory was placed by a file!", null);
        if (!file.delete()) {
            return false;
        }
        file.mkdirs();
        return true;
    }

    public static String b(String str) {
        return "debug.crs." + str;
    }

    public static void b(boolean z10) {
        if (e.u()) {
            return;
        }
        if (z10 && f23023x) {
            g.O();
            f23023x = false;
            Y();
        }
        boolean z11 = e.F() || L();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (X && !Y && z10) {
            long j10 = f22990aa;
            if (j10 != 0 && !z11 && jCurrentTimeMillis - j10 > 1800000) {
                com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(104), 1000L);
            }
        }
        f22990aa = jCurrentTimeMillis;
        Y = z10;
        if (z10) {
            X = true;
        }
        if (f23003d) {
            JNIBridge.nativeSetForeground(z10);
        }
        if (f23023x || z11) {
            return;
        }
        T();
        Z();
        if (z10) {
            a.a(false);
            if (!Z) {
                e.B();
                Z = true;
            }
        }
        if (!N) {
            aa();
        }
        e.c(z10);
    }

    public static boolean c(int i10) {
        return (i10 & I) != 0;
    }

    public static String e() {
        if (f23014o == null) {
            f23014o = d("stcb");
        }
        return f23014o;
    }

    public static String a(String str) {
        if (str == null || str.length() <= 0 || !str.endsWith(".st")) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(".st");
        if (!f23008i && iLastIndexOf < 0) {
            throw new AssertionError();
        }
        String strSubstring = str.substring(0, iLastIndexOf);
        if (strSubstring.length() <= 0) {
            return null;
        }
        return strSubstring + ".stcb";
    }

    public static void a(boolean z10) {
        L = z10;
        if (f23003d) {
            JNIBridge.set(30, z10);
        }
    }

    public static void b(int i10) {
        I = i10;
        K();
    }

    private static void a(Object[] objArr) {
        R = objArr;
        synchronized (O) {
            String str = (String) objArr[0];
            long jLongValue = ((Long) objArr[1]).longValue();
            if (jLongValue < U) {
                com.uc.crashsdk.a.a.c("crashsdk", String.format(Locale.US, "Update state generation %d, last is: %d", Long.valueOf(jLongValue), Long.valueOf(U)));
                return;
            }
            U = jLongValue;
            String strQ = Q();
            if (f23003d) {
                RandomAccessFile randomAccessFile = M;
                if (randomAccessFile != null) {
                    com.uc.crashsdk.a.g.a(randomAccessFile);
                    M = null;
                }
                boolean zNativeChangeState = JNIBridge.nativeChangeState(strQ, str, N);
                N = false;
                if (!zNativeChangeState) {
                    com.uc.crashsdk.a.a.b("write state failed: " + str);
                }
            } else {
                RandomAccessFile randomAccessFile2 = M;
                if (randomAccessFile2 == null || N) {
                    if (randomAccessFile2 != null) {
                        com.uc.crashsdk.a.g.a(randomAccessFile2);
                        M = null;
                    }
                    try {
                        RandomAccessFile randomAccessFile3 = new RandomAccessFile(strQ, "rw");
                        M = randomAccessFile3;
                        randomAccessFile3.seek(0L);
                        N = false;
                    } catch (Exception e10) {
                        com.uc.crashsdk.a.g.a(e10);
                    }
                }
                try {
                    M.write(str.getBytes());
                    M.seek(0L);
                } catch (Exception e11) {
                    com.uc.crashsdk.a.g.a(e11);
                }
            }
            P = str;
            R = null;
        }
    }

    public static void b(Context context) {
        com.uc.crashsdk.a.a.a("Restart APP");
        if (context == null) {
            return;
        }
        if (f23015p == null) {
            f23015p = d(zc.f.f58393w);
        }
        File file = new File(f23015p);
        long j10 = -1;
        try {
            j10 = Long.parseLong(com.uc.crashsdk.a.g.d(file));
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
        boolean z10 = false;
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        if (g.h() >= 0 && (j10 <= 0 || jCurrentTimeMillis - j10 > g.h())) {
            f(g.W());
            com.uc.crashsdk.a.g.a(file, String.valueOf(jCurrentTimeMillis));
            z10 = true;
        }
        com.uc.crashsdk.a.a.a("lastTime: " + j10 + ", currentTime: " + jCurrentTimeMillis + ", needRestart: " + z10);
        if (z10) {
            try {
                d.a(true);
            } catch (Throwable th3) {
                com.uc.crashsdk.a.g.a(th3);
            }
            N();
        }
    }

    public static boolean a(Context context) {
        try {
            ((Application) context).registerActivityLifecycleCallbacks(new c());
            if (!g.L()) {
                return true;
            }
            C();
            return true;
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return false;
        }
    }

    public static void a(int i10) {
        Object objA;
        Activity activity;
        int i11;
        boolean z10 = false;
        boolean z11 = true;
        switch (i10) {
            case 100:
                Object objAc = ac();
                if (objAc == null || (objA = a(objAc, (Class<?>) null, "mActivities")) == null) {
                    return;
                }
                try {
                    Iterator it2 = ((Map) objA).entrySet().iterator();
                    boolean z12 = false;
                    while (it2.hasNext()) {
                        Object value = ((Map.Entry) it2.next()).getValue();
                        if (value != null && (activity = (Activity) a(value, (Class<?>) null, androidx.appcompat.widget.c.f2369r)) != null) {
                            boolean zBooleanValue = ((Boolean) a(value, (Class<?>) null, "paused")).booleanValue();
                            boolean zBooleanValue2 = ((Boolean) a(value, (Class<?>) null, "stopped")).booleanValue();
                            WeakHashMap<Activity, Integer> weakHashMap = f22991ab;
                            synchronized (weakHashMap) {
                                if (zBooleanValue || zBooleanValue2) {
                                    i11 = 2;
                                } else {
                                    i11 = 1;
                                    z12 = true;
                                }
                                weakHashMap.put(activity, Integer.valueOf(i11));
                                break;
                            }
                        }
                        z10 = true;
                    }
                    if (z10) {
                        b(z12);
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    com.uc.crashsdk.a.g.a(th2);
                    return;
                }
            case 101:
                try {
                    if (new File(Q()).exists()) {
                        z11 = false;
                    }
                    N = z11;
                    if (z11 || Q) {
                        a(ab());
                        Q = false;
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    com.uc.crashsdk.a.g.a(th3);
                    return;
                }
            case 102:
                com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(103));
                return;
            case 103:
                try {
                    com.uc.crashsdk.a.g.a(new File(S()));
                    return;
                } catch (Throwable th4) {
                    com.uc.crashsdk.a.g.a(th4);
                    return;
                }
            case 104:
                h.d();
                f.a(102);
                if (F()) {
                    e.C();
                    return;
                }
                return;
            default:
                if (!f23008i) {
                    throw new AssertionError();
                }
                return;
        }
    }

    private static Object a(Object obj, Class<?> cls, String str) {
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            cls = obj.getClass();
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return null;
        }
    }

    public static boolean a(Object obj, String str, com.uc.crashsdk.a.e eVar) {
        FileChannel channel;
        boolean zA;
        synchronized (obj) {
            FileChannel fileChannel = null;
            fileLockLock = null;
            FileLock fileLockLock = null;
            FileChannel fileChannel2 = null;
            boolean zA2 = false;
            if (f23003d) {
                int iNativeOpenFile = JNIBridge.nativeOpenFile(str);
                if (iNativeOpenFile < 0) {
                    com.uc.crashsdk.a.a.a("crashsdk", "Can not open file: " + str, null);
                    return false;
                }
                try {
                    boolean zNativeLockFile = JNIBridge.nativeLockFile(iNativeOpenFile, true);
                    try {
                        zA = eVar.a();
                        return zA;
                    } finally {
                        if (zNativeLockFile) {
                            JNIBridge.nativeLockFile(iNativeOpenFile, false);
                        }
                    }
                } finally {
                    JNIBridge.nativeCloseFile(iNativeOpenFile);
                }
            }
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e10) {
                    com.uc.crashsdk.a.g.a(e10);
                }
            }
            try {
                try {
                    channel = new RandomAccessFile(file, "rw").getChannel();
                } catch (Throwable th2) {
                    th = th2;
                    com.uc.crashsdk.a.g.a(fileChannel2);
                    throw th;
                }
            } catch (Exception e11) {
                try {
                    com.uc.crashsdk.a.g.a(e11);
                    channel = null;
                } catch (Exception e12) {
                    e = e12;
                    com.uc.crashsdk.a.g.a(e);
                    com.uc.crashsdk.a.g.a(fileChannel);
                    zA = zA2;
                    return zA;
                }
            }
            if (channel != null) {
                try {
                    try {
                        fileLockLock = channel.lock();
                    } catch (Exception e13) {
                        try {
                            com.uc.crashsdk.a.g.a(e13);
                        } catch (Exception e14) {
                            e = e14;
                            fileChannel = channel;
                            com.uc.crashsdk.a.g.a(e);
                            com.uc.crashsdk.a.g.a(fileChannel);
                        }
                    }
                } catch (Throwable th3) {
                    fileChannel2 = channel;
                    th = th3;
                    com.uc.crashsdk.a.g.a(fileChannel2);
                    throw th;
                }
            }
            try {
                zA2 = eVar.a();
                com.uc.crashsdk.a.g.a(channel);
                zA = zA2;
                return zA;
            } finally {
                if (fileLockLock != null) {
                    try {
                        fileLockLock.release();
                    } catch (Exception e15) {
                        com.uc.crashsdk.a.g.a(e15);
                    }
                }
            }
        }
    }
}
