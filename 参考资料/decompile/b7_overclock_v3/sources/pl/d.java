package pl;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import g.n0;
import g.p0;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f46707a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Handler f46709c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f46708b = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f46710d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Executor f46711e = Executors.newFixedThreadPool(4, new b());

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f46712a;

        public a(Object obj) {
            this.f46712a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.i().removeCallbacksAndMessages(this.f46712a);
        }
    }

    public static class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f46713a = -1;

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@n0 Runnable runnable) {
            this.f46713a++;
            return new Thread(runnable, "ThreadUtils: " + this.f46713a);
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f46714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0531d f46715b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f46716a;

            public a(Object obj) {
                this.f46716a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.f46715b.a(this.f46716a);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }

        public c(e eVar, InterfaceC0531d interfaceC0531d) {
            this.f46714a = eVar;
            this.f46715b = interfaceC0531d;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object objA;
            try {
                objA = this.f46714a.a();
            } catch (Throwable th2) {
                th2.printStackTrace();
                objA = null;
            }
            if (this.f46715b == null) {
                return;
            }
            d.p(new a(objA));
        }
    }

    /* JADX INFO: renamed from: pl.d$d, reason: collision with other inner class name */
    public interface InterfaceC0531d<T> {
        void a(@p0 T t10);
    }

    public interface e<T> {
        @p0
        T a();
    }

    public static void b(Context context) {
        if (context != null) {
            i().removeCallbacksAndMessages(Integer.valueOf(context.hashCode()));
        }
    }

    public static void c(Runnable runnable) {
        i().removeCallbacks(runnable);
    }

    public static void d(Context context) {
        if (context != null) {
            k().removeCallbacksAndMessages(Integer.valueOf(context.hashCode()));
        }
    }

    public static void e(Runnable runnable) {
        k().removeCallbacks(runnable);
    }

    public static void f(Context context, long j10) {
        if (context != null) {
            r(new a(Integer.valueOf(context.hashCode())), j10);
        }
    }

    public static void g(Runnable runnable) {
        if (runnable != null) {
            try {
                f46711e.execute(runnable);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static <T> void h(e<T> eVar, InterfaceC0531d<T> interfaceC0531d) {
        if (eVar == null) {
            return;
        }
        f46711e.execute(new c(eVar, interfaceC0531d));
    }

    public static Handler i() {
        Handler handler;
        synchronized (f46710d) {
            if (f46709c == null) {
                HandlerThread handlerThread = new HandlerThread("daemon-handler-thread");
                handlerThread.start();
                f46709c = new Handler(handlerThread.getLooper());
            }
            handler = f46709c;
        }
        return handler;
    }

    public static String j() {
        return Thread.currentThread().getName() + " : " + Thread.currentThread().getId();
    }

    public static Handler k() {
        Handler handler;
        synchronized (f46708b) {
            if (f46707a == null) {
                f46707a = new Handler(Looper.getMainLooper());
            }
            handler = f46707a;
        }
        return handler;
    }

    public static boolean l() {
        return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
    }

    public static boolean m(Context context, Runnable runnable) {
        return context == null ? n(runnable) : i().postAtTime(runnable, Integer.valueOf(context.hashCode()), SystemClock.uptimeMillis());
    }

    public static boolean n(Runnable runnable) {
        return i().post(runnable);
    }

    public static boolean o(Context context, Runnable runnable) {
        return context == null ? p(runnable) : k().postAtTime(runnable, Integer.valueOf(context.hashCode()), SystemClock.uptimeMillis());
    }

    public static boolean p(Runnable runnable) {
        return k().post(runnable);
    }

    public static boolean q(Context context, Runnable runnable, long j10) {
        return context == null ? r(runnable, j10) : i().postAtTime(runnable, Integer.valueOf(context.hashCode()), SystemClock.uptimeMillis() + j10);
    }

    public static boolean r(Runnable runnable, long j10) {
        return i().postDelayed(runnable, j10);
    }

    public static boolean s(Context context, Runnable runnable, long j10) {
        return context == null ? t(runnable, j10) : k().postAtTime(runnable, Integer.valueOf(context.hashCode()), SystemClock.uptimeMillis() + j10);
    }

    public static boolean t(Runnable runnable, long j10) {
        return k().postDelayed(runnable, j10);
    }

    public static boolean u() {
        return i().getLooper() == Looper.myLooper();
    }

    public static boolean v() {
        return k().getLooper() == Looper.myLooper();
    }

    public static void w(String str) {
        if (v()) {
            return;
        }
        throw new RuntimeException("ThreadUtils safeCheck alert " + str);
    }
}
