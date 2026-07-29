package kotlinx.coroutines;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nThreadPoolDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThreadPoolDispatcher.kt\nkotlinx/coroutines/ThreadPoolDispatcherKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,72:1\n1#2:73\n*E\n"})
public final class g3 {
    @y0
    @yt.k
    public static final ExecutorCoroutineDispatcher b(final int i10, @yt.k final String str) {
        if (i10 >= 1) {
            final AtomicInteger atomicInteger = new AtomicInteger();
            return r1.d(Executors.newScheduledThreadPool(i10, new ThreadFactory() { // from class: kotlinx.coroutines.f3
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return g3.c(i10, str, atomicInteger, runnable);
                }
            }));
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + i10 + " specified").toString());
    }

    public static final Thread c(int i10, String str, AtomicInteger atomicInteger, Runnable runnable) {
        if (i10 != 1) {
            str = str + '-' + atomicInteger.incrementAndGet();
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }

    @y0
    @yt.k
    public static final ExecutorCoroutineDispatcher d(@yt.k String str) {
        return b(1, str);
    }
}
