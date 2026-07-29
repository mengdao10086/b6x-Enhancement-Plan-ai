package v4;

import g.i1;
import g.n0;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Executor f52678a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Executor f52679b = new b();

    public class a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@n0 Runnable runnable) {
            o.x(runnable);
        }
    }

    public class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@n0 Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a() {
        return f52679b;
    }

    public static Executor b() {
        return f52678a;
    }

    @i1
    public static void c(ExecutorService executorService) {
        executorService.shutdownNow();
        try {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (executorService.awaitTermination(5L, timeUnit)) {
                return;
            }
            executorService.shutdownNow();
            if (executorService.awaitTermination(5L, timeUnit)) {
            } else {
                throw new RuntimeException("Failed to shutdown");
            }
        } catch (InterruptedException e10) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e10);
        }
    }
}
