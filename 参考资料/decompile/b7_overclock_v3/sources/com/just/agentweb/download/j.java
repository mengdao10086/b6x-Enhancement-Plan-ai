package com.just.agentweb.download;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import xf.h0;

/* JADX INFO: loaded from: classes7.dex */
public class j implements h0<Executor> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BlockingQueue<Runnable> f21989h = new LinkedBlockingQueue(128);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f21994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ThreadPoolExecutor f21995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ThreadFactory f21996g;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f21997a = new AtomicInteger(1);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SecurityManager f21998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ThreadGroup f21999c;

        public a() {
            SecurityManager securityManager = System.getSecurityManager();
            this.f21998b = securityManager;
            this.f21999c = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f21999c, runnable, "pool-agentweb-thread-" + this.f21997a.getAndIncrement());
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(1);
            return thread;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f22001a = new j(null);
    }

    public /* synthetic */ j(a aVar) {
        this();
    }

    public static j b() {
        return b.f22001a;
    }

    public final void c() {
        ThreadPoolExecutor threadPoolExecutor = this.f21995f;
        if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
            this.f21995f.shutdownNow();
        }
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(this.f21991b, this.f21992c, 15L, TimeUnit.SECONDS, f21989h, this.f21996g);
        this.f21995f = threadPoolExecutor2;
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
    }

    @Override // xf.h0
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Executor a() {
        return this.f21995f;
    }

    public j() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        this.f21990a = iAvailableProcessors;
        this.f21991b = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        this.f21992c = (iAvailableProcessors * 2) + 1;
        this.f21993d = 15;
        this.f21994e = getClass().getSimpleName();
        this.f21996g = new a();
        c();
    }
}
