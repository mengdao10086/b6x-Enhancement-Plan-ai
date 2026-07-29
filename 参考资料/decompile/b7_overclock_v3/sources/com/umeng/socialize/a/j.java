package com.umeng.socialize.a;

import android.os.AsyncTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24557a = "UMExecutor";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f24558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile ExecutorService f24559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ThreadFactory f24560d = new ThreadFactory() { // from class: com.umeng.socialize.a.j.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f24561a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Azx-" + this.f24561a.incrementAndGet());
        }
    };

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f24562a;

        public a(Runnable runnable) {
            this.f24562a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Runnable runnable = this.f24562a;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable th2) {
                m.d(j.f24557a, "error:", th2.getMessage());
            }
        }
    }

    private static ScheduledThreadPoolExecutor a() {
        if (f24558b == null) {
            synchronized (j.class) {
                if (f24558b == null) {
                    f24558b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f24560d);
                    f24558b.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    f24558b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f24558b;
    }

    private static ExecutorService b() {
        if (f24559c == null) {
            synchronized (j.class) {
                if (f24559c == null) {
                    f24559c = Executors.newSingleThreadExecutor(f24560d);
                }
            }
        }
        return f24559c;
    }

    public static Future<?> c(Runnable runnable) {
        try {
            return a().submit(d(runnable));
        } catch (Throwable th2) {
            m.d(f24557a, "submit error:", th2.getMessage());
            return null;
        }
    }

    private static Runnable d(Runnable runnable) {
        return new a(runnable);
    }

    public static void b(Runnable runnable) {
        try {
            a().execute(d(runnable));
        } catch (Throwable th2) {
            m.d(f24557a, "execute error:", th2.getMessage());
        }
    }

    @SafeVarargs
    public static <Params, Progress, Result> void a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            return;
        }
        try {
            asyncTask.executeOnExecutor(a(), paramsArr);
        } catch (Throwable th2) {
            m.d(f24557a, "executeOnExecutor error:", th2.getMessage());
        }
    }

    public static void a(Runnable runnable) {
        try {
            b().submit(d(runnable));
        } catch (Throwable th2) {
            m.d(f24557a, "submitSingleTask error:", th2.getMessage());
        }
    }

    public static void a(Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j10, timeUnit);
        } catch (Throwable th2) {
            m.d(f24557a, "schedule error:", th2.getMessage());
        }
    }
}
