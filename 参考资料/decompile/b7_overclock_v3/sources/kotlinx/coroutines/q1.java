package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.w0;

/* JADX INFO: loaded from: classes5.dex */
public final class q1 extends ExecutorCoroutineDispatcher implements w0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final Executor f38946d;

    public q1(@yt.k Executor executor) {
        this.f38946d = executor;
        kotlinx.coroutines.internal.d.c(m2());
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executorM2 = m2();
        ExecutorService executorService = executorM2 instanceof ExecutorService ? (ExecutorService) executorM2 : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(@yt.l Object obj) {
        return (obj instanceof q1) && ((q1) obj).m2() == m2();
    }

    @Override // kotlinx.coroutines.w0
    @yt.k
    public g1 h1(long j10, @yt.k Runnable runnable, @yt.k CoroutineContext coroutineContext) {
        Executor executorM2 = m2();
        ScheduledExecutorService scheduledExecutorService = executorM2 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorM2 : null;
        ScheduledFuture<?> scheduledFutureO2 = scheduledExecutorService != null ? o2(scheduledExecutorService, runnable, coroutineContext, j10) : null;
        return scheduledFutureO2 != null ? new f1(scheduledFutureO2) : s0.f38948i.h1(j10, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void h2(@yt.k CoroutineContext coroutineContext, @yt.k Runnable runnable) {
        Runnable runnableI;
        try {
            Executor executorM2 = m2();
            b bVarB = c.b();
            if (bVarB == null || (runnableI = bVarB.i(runnable)) == null) {
                runnableI = runnable;
            }
            executorM2.execute(runnableI);
        } catch (RejectedExecutionException e10) {
            b bVarB2 = c.b();
            if (bVarB2 != null) {
                bVarB2.f();
            }
            n2(coroutineContext, e10);
            d1.c().h2(coroutineContext, runnable);
        }
    }

    public int hashCode() {
        return System.identityHashCode(m2());
    }

    @Override // kotlinx.coroutines.w0
    public void i(long j10, @yt.k o<? super kotlin.z1> oVar) {
        Executor executorM2 = m2();
        ScheduledExecutorService scheduledExecutorService = executorM2 instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorM2 : null;
        ScheduledFuture<?> scheduledFutureO2 = scheduledExecutorService != null ? o2(scheduledExecutorService, new v2(this, oVar), oVar.b(), j10) : null;
        if (scheduledFutureO2 != null) {
            f2.w(oVar, scheduledFutureO2);
        } else {
            s0.f38948i.i(j10, oVar);
        }
    }

    @Override // kotlinx.coroutines.w0
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @yt.l
    public Object m1(long j10, @yt.k kotlin.coroutines.c<? super kotlin.z1> cVar) {
        return w0.a.a(this, j10, cVar);
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @yt.k
    public Executor m2() {
        return this.f38946d;
    }

    public final void n2(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        f2.f(coroutineContext, p1.a("The task was rejected", rejectedExecutionException));
    }

    public final ScheduledFuture<?> o2(ScheduledExecutorService scheduledExecutorService, Runnable runnable, CoroutineContext coroutineContext, long j10) {
        try {
            return scheduledExecutorService.schedule(runnable, j10, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e10) {
            n2(coroutineContext, e10);
            return null;
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @yt.k
    public String toString() {
        return m2().toString();
    }
}
