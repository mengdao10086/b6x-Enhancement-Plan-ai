package com.tencent.open.utils;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f22823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static HandlerThread f22824d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f22822b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Executor f22821a = c();

    public static class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<Runnable> f22825a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Runnable f22826b;

        private a() {
            this.f22825a = new LinkedList();
        }

        public synchronized void a() {
            Runnable runnablePoll = this.f22825a.poll();
            this.f22826b = runnablePoll;
            if (runnablePoll != null) {
                j.f22821a.execute(runnablePoll);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.f22825a.offer(new Runnable() { // from class: com.tencent.open.utils.j.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        a.this.a();
                    }
                }
            });
            if (this.f22826b == null) {
                a();
            }
        }
    }

    public static void a(Runnable runnable) {
        try {
            f22821a.execute(runnable);
        } catch (RejectedExecutionException unused) {
        }
    }

    public static void b(Runnable runnable) {
        a().post(runnable);
    }

    private static Executor c() {
        return new ThreadPoolExecutor(0, 3, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public static Handler a() {
        if (f22823c == null) {
            synchronized (j.class) {
                HandlerThread handlerThread = new HandlerThread("SDK_SUB");
                f22824d = handlerThread;
                handlerThread.start();
                f22823c = new Handler(f22824d.getLooper());
            }
        }
        return f22823c;
    }

    public static Executor b() {
        return new a();
    }
}
