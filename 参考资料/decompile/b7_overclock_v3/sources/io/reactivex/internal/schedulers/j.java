package io.reactivex.internal.schedulers;

import dj.o;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f35206a = "rx2.purge-enabled";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f35207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f35208c = "rx2.purge-period-seconds";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f35209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReference<ScheduledExecutorService> f35210e = new AtomicReference<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<ScheduledThreadPoolExecutor, Object> f35211f = new ConcurrentHashMap();

    public static final class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            for (ScheduledThreadPoolExecutor scheduledThreadPoolExecutor : new ArrayList(j.f35211f.keySet())) {
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    j.f35211f.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    public static final class b implements o<String, String> {
        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(String str) throws Exception {
            return System.getProperty(str);
        }
    }

    static {
        b bVar = new b();
        boolean zB = b(true, f35206a, true, true, bVar);
        f35207b = zB;
        f35209d = c(zB, f35208c, 1, 1, bVar);
        e();
    }

    public j() {
        throw new IllegalStateException("No instances!");
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        f(f35207b, scheduledExecutorServiceNewScheduledThreadPool);
        return scheduledExecutorServiceNewScheduledThreadPool;
    }

    public static boolean b(boolean z10, String str, boolean z11, boolean z12, o<String, String> oVar) {
        if (!z10) {
            return z12;
        }
        try {
            String strApply = oVar.apply(str);
            return strApply == null ? z11 : "true".equals(strApply);
        } catch (Throwable unused) {
            return z11;
        }
    }

    public static int c(boolean z10, String str, int i10, int i11, o<String, String> oVar) {
        if (!z10) {
            return i11;
        }
        try {
            String strApply = oVar.apply(str);
            return strApply == null ? i10 : Integer.parseInt(strApply);
        } catch (Throwable unused) {
            return i10;
        }
    }

    public static void d() {
        ScheduledExecutorService andSet = f35210e.getAndSet(null);
        if (andSet != null) {
            andSet.shutdownNow();
        }
        f35211f.clear();
    }

    public static void e() {
        g(f35207b);
    }

    public static void f(boolean z10, ScheduledExecutorService scheduledExecutorService) {
        if (z10 && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f35211f.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    public static void g(boolean z10) {
        if (!z10) {
            return;
        }
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = f35210e;
            ScheduledExecutorService scheduledExecutorService = atomicReference.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
            if (atomicReference.compareAndSet(scheduledExecutorService, scheduledExecutorServiceNewScheduledThreadPool)) {
                a aVar = new a();
                int i10 = f35209d;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(aVar, i10, i10, TimeUnit.SECONDS);
                return;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
    }
}
