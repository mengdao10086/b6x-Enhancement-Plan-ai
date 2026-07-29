package com.umeng.umzid;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ScheduledThreadPoolExecutor f24874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ThreadFactory f24875b = new a();

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AtomicInteger f24876a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ZIDThreadPoolExecutor" + this.f24876a.addAndGet(1));
            return thread;
        }
    }

    public static ScheduledThreadPoolExecutor a() {
        if (f24874a == null) {
            synchronized (c.class) {
                if (f24874a == null) {
                    f24874a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4, f24875b);
                }
            }
        }
        return f24874a;
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable unused) {
        }
    }
}
