package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class f2 {
    public static final void A(@yt.k c2 c2Var) {
        h2.y(c2Var);
    }

    @yt.k
    public static final c2 B(@yt.k CoroutineContext coroutineContext) {
        return h2.z(coroutineContext);
    }

    public static final boolean C(@yt.k CoroutineContext coroutineContext) {
        return h2.A(coroutineContext);
    }

    @yt.k
    public static final a0 a(@yt.l c2 c2Var) {
        return h2.a(c2Var);
    }

    public static final void f(@yt.k CoroutineContext coroutineContext, @yt.l CancellationException cancellationException) {
        h2.f(coroutineContext, cancellationException);
    }

    public static final void g(@yt.k c2 c2Var, @yt.k String str, @yt.l Throwable th2) {
        h2.g(c2Var, str, th2);
    }

    @yt.l
    public static final Object l(@yt.k c2 c2Var, @yt.k kotlin.coroutines.c<? super kotlin.z1> cVar) {
        return h2.l(c2Var, cVar);
    }

    public static final void o(@yt.k CoroutineContext coroutineContext, @yt.l CancellationException cancellationException) {
        h2.o(coroutineContext, cancellationException);
    }

    public static final void r(@yt.k c2 c2Var, @yt.l CancellationException cancellationException) {
        h2.r(c2Var, cancellationException);
    }

    public static final void w(@yt.k o<?> oVar, @yt.k Future<?> future) {
        g2.a(oVar, future);
    }

    @y1
    @yt.k
    public static final g1 x(@yt.k c2 c2Var, @yt.k Future<?> future) {
        return g2.b(c2Var, future);
    }

    @yt.k
    public static final g1 y(@yt.k c2 c2Var, @yt.k g1 g1Var) {
        return h2.w(c2Var, g1Var);
    }

    public static final void z(@yt.k CoroutineContext coroutineContext) {
        h2.x(coroutineContext);
    }
}
