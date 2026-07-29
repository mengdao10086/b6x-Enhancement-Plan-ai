package ni;

import io.objectbox.BoxStore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
@li.c
public class e extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BoxStore f42198a;

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicInteger f42199d = new AtomicInteger();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadGroup f42200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f42201b = "ObjectBox-" + f42199d.incrementAndGet() + "-Thread-";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f42202c = new AtomicInteger();

        public a() {
            SecurityManager securityManager = System.getSecurityManager();
            this.f42200a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f42200a, runnable, this.f42201b + this.f42202c.incrementAndGet());
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            return thread;
        }
    }

    public e(BoxStore boxStore) {
        super(0, Integer.MAX_VALUE, 20L, TimeUnit.SECONDS, new SynchronousQueue(), new a());
        this.f42198a = boxStore;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th2) {
        super.afterExecute(runnable, th2);
        this.f42198a.P();
    }
}
