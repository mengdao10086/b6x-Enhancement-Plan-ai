package androidx.emoji2.text;

import ab.v;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import g.n0;
import g.u;
import g.v0;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5344a = 15;

    @v0(28)
    public static class a {
        @u
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    @n0
    @Deprecated
    public static Executor b(@n0 Handler handler) {
        Objects.requireNonNull(handler);
        return new v(handler);
    }

    public static ThreadPoolExecutor c(@n0 final String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactory() { // from class: androidx.emoji2.text.a
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return b.d(str, runnable);
            }
        });
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static /* synthetic */ Thread d(String str, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setPriority(10);
        return thread;
    }

    public static Handler e() {
        return Build.VERSION.SDK_INT >= 28 ? a.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper());
    }
}
