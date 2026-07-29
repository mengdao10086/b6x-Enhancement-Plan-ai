package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
public final class r1 {
    @s1
    public static /* synthetic */ void a() {
    }

    @yt.k
    public static final Executor b(@yt.k CoroutineDispatcher coroutineDispatcher) {
        Executor executorM2;
        ExecutorCoroutineDispatcher executorCoroutineDispatcher = coroutineDispatcher instanceof ExecutorCoroutineDispatcher ? (ExecutorCoroutineDispatcher) coroutineDispatcher : null;
        return (executorCoroutineDispatcher == null || (executorM2 = executorCoroutineDispatcher.m2()) == null) ? new c1(coroutineDispatcher) : executorM2;
    }

    @hk.h(name = w.h.f53783c)
    @yt.k
    public static final CoroutineDispatcher c(@yt.k Executor executor) {
        CoroutineDispatcher coroutineDispatcher;
        c1 c1Var = executor instanceof c1 ? (c1) executor : null;
        return (c1Var == null || (coroutineDispatcher = c1Var.f38295a) == null) ? new q1(executor) : coroutineDispatcher;
    }

    @hk.h(name = w.h.f53783c)
    @yt.k
    public static final ExecutorCoroutineDispatcher d(@yt.k ExecutorService executorService) {
        return new q1(executorService);
    }
}
