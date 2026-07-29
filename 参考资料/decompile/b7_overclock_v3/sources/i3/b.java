package i3;

import j3.f;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class b extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f31813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f31814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f31815d = 30;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile b f31816e;

    public class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            h3.a.f30402e.error("ARouter::", "Task rejected, too many task!");
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f31812a = iAvailableProcessors;
        int i10 = iAvailableProcessors + 1;
        f31813b = i10;
        f31814c = i10;
    }

    public b(int i10, int i11, long j10, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i10, i11, j10, timeUnit, blockingQueue, threadFactory, new a());
    }

    public static b a() {
        if (f31816e == null) {
            synchronized (b.class) {
                if (f31816e == null) {
                    f31816e = new b(f31813b, f31814c, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(64), new c());
                }
            }
        }
        return f31816e;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th2) {
        super.afterExecute(runnable, th2);
        if (th2 == null && (runnable instanceof Future)) {
            try {
                ((Future) runnable).get();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (CancellationException e10) {
                th2 = e10;
            } catch (ExecutionException e11) {
                th2 = e11.getCause();
            }
        }
        if (th2 != null) {
            h3.a.f30402e.warning("ARouter::", "Running task appeared exception! Thread [" + Thread.currentThread().getName() + "], because [" + th2.getMessage() + "]\n" + f.a(th2.getStackTrace()));
        }
    }
}
