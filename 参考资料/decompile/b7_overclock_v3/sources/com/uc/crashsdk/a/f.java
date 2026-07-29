package com.uc.crashsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f22952a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile HandlerThread f22953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile HandlerThread f22954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile HandlerThread f22955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Handler f22956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Handler f22957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Handler f22958g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Handler f22959h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final HashMap<Object, Object[]> f22960i = new HashMap<>();

    public static Handler a(int i10) {
        if (i10 == 0) {
            if (f22953b == null) {
                a();
            }
            return f22956e;
        }
        if (i10 == 1) {
            if (f22954c == null) {
                b();
            }
            return f22957f;
        }
        if (i10 == 2) {
            if (f22958g == null) {
                f22958g = new Handler(Looper.getMainLooper());
            }
            return f22958g;
        }
        if (i10 == 3) {
            if (f22959h == null) {
                c();
            }
            return f22959h;
        }
        throw new RuntimeException("unknown thread type: " + i10);
    }

    public static boolean b(Runnable runnable) {
        Object[] objArr;
        if (runnable == null) {
            return false;
        }
        HashMap<Object, Object[]> map = f22960i;
        synchronized (map) {
            objArr = map.get(runnable);
        }
        return objArr != null;
    }

    private static synchronized void c() {
        if (f22955d == null) {
            HandlerThread handlerThread = new HandlerThread("CrashSDKAnrHandler", 0);
            f22955d = handlerThread;
            handlerThread.start();
            f22959h = new Handler(f22955d.getLooper());
        }
    }

    private static synchronized void b() {
        if (f22954c == null) {
            HandlerThread handlerThread = new HandlerThread("CrashSDKNormalHandler", 0);
            f22954c = handlerThread;
            handlerThread.start();
            f22957f = new Handler(f22954c.getLooper());
        }
    }

    public static boolean a(int i10, Runnable runnable, long j10) {
        Handler handlerA;
        if (runnable == null || (handlerA = a(i10)) == null) {
            return false;
        }
        e eVar = new e(10, new Object[]{runnable});
        HashMap<Object, Object[]> map = f22960i;
        synchronized (map) {
            map.put(runnable, new Object[]{eVar, Integer.valueOf(i10)});
        }
        return handlerA.postDelayed(eVar, j10);
    }

    public static void a(int i10, Object[] objArr) {
        if (i10 != 10) {
            if (!f22952a) {
                throw new AssertionError();
            }
        } else {
            if (!f22952a && objArr == null) {
                throw new AssertionError();
            }
            Runnable runnable = (Runnable) objArr[0];
            HashMap<Object, Object[]> map = f22960i;
            synchronized (map) {
                if (map.get(runnable) != null) {
                    map.remove(runnable);
                }
            }
            runnable.run();
        }
    }

    public static boolean a(int i10, Runnable runnable) {
        return a(i10, runnable, 0L);
    }

    public static void a(Runnable runnable) {
        Object[] objArr;
        if (runnable == null) {
            return;
        }
        HashMap<Object, Object[]> map = f22960i;
        synchronized (map) {
            objArr = map.get(runnable);
        }
        if (objArr == null) {
            return;
        }
        int iIntValue = ((Integer) objArr[1]).intValue();
        Handler handler = null;
        if (iIntValue == 0) {
            handler = f22956e;
        } else if (iIntValue == 1) {
            handler = f22957f;
        } else if (iIntValue == 2) {
            handler = f22958g;
        }
        if (handler != null) {
            handler.removeCallbacks((Runnable) objArr[0]);
        }
        synchronized (map) {
            if (map.get(runnable) != null) {
                map.remove(runnable);
            }
        }
    }

    private static synchronized void a() {
        if (f22953b == null) {
            HandlerThread handlerThread = new HandlerThread("CrashSDKBkgdHandler", 10);
            f22953b = handlerThread;
            handlerThread.start();
            f22956e = new Handler(f22953b.getLooper());
        }
    }
}
