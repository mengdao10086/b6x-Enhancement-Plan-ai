package i3;

import g.n0;
import java.lang.Thread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ThreadFactory {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f31817d = new AtomicInteger(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f31818a = new AtomicInteger(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadGroup f31819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f31820c;

    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th2) {
            h3.a.f30402e.info("ARouter::", "Running task appeared exception! Thread [" + thread.getName() + "], because [" + th2.getMessage() + "]");
        }
    }

    public c() {
        SecurityManager securityManager = System.getSecurityManager();
        this.f31819b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f31820c = "ARouter task pool No." + f31817d.getAndIncrement() + ", thread No.";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@n0 Runnable runnable) {
        String str = this.f31820c + this.f31818a.getAndIncrement();
        h3.a.f30402e.info("ARouter::", "Thread production, name is [" + str + "]");
        Thread thread = new Thread(this.f31819b, runnable, str, 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        thread.setUncaughtExceptionHandler(new a());
        return thread;
    }
}
