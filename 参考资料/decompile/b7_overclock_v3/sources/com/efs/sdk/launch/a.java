package com.efs.sdk.launch;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f12978a = "com.efs.sdk.launch.a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f12979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ThreadFactory f12980c = new ThreadFactory() { // from class: com.efs.sdk.launch.a.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AtomicInteger f12981a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("LaunchThreadPoolExecutor" + this.f12981a.addAndGet(1));
            return thread;
        }
    };

    private static ScheduledThreadPoolExecutor a() {
        if (f12979b == null) {
            synchronized (a.class) {
                if (f12979b == null) {
                    f12979b = new ScheduledThreadPoolExecutor(4, f12980c);
                }
            }
        }
        return f12979b;
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
