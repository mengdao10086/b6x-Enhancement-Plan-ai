package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public final class p0 {
    @yt.k
    public static final o0 a(@yt.k CoroutineContext coroutineContext) {
        if (coroutineContext.c(c2.f38296x2) == null) {
            coroutineContext = coroutineContext.L(h2.c(null, 1, null));
        }
        return new kotlinx.coroutines.internal.g(coroutineContext);
    }

    @yt.k
    public static final o0 b() {
        return new kotlinx.coroutines.internal.g(b3.c(null, 1, null).L(d1.e()));
    }

    public static final void c(@yt.k o0 o0Var, @yt.k String str, @yt.l Throwable th2) {
        d(o0Var, p1.a(str, th2));
    }

    public static final void d(@yt.k o0 o0Var, @yt.l CancellationException cancellationException) {
        c2 c2Var = (c2) o0Var.W().c(c2.f38296x2);
        if (c2Var != null) {
            c2Var.h(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + o0Var).toString());
    }

    public static /* synthetic */ void e(o0 o0Var, String str, Throwable th2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            th2 = null;
        }
        c(o0Var, str, th2);
    }

    public static /* synthetic */ void f(o0 o0Var, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        d(o0Var, cancellationException);
    }

    @yt.l
    public static final <R> Object g(@yt.k ik.p<? super o0, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar, @yt.k kotlin.coroutines.c<? super R> cVar) {
        kotlinx.coroutines.internal.k0 k0Var = new kotlinx.coroutines.internal.k0(cVar.b(), cVar);
        Object objE = zk.b.e(k0Var, k0Var, pVar);
        if (objE == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objE;
    }

    @yt.l
    public static final Object h(@yt.k kotlin.coroutines.c<? super CoroutineContext> cVar) {
        return cVar.b();
    }

    public static final Object i(kotlin.coroutines.c<? super CoroutineContext> cVar) {
        kotlin.jvm.internal.c0.e(3);
        throw null;
    }

    public static final void j(@yt.k o0 o0Var) {
        f2.z(o0Var.W());
    }

    public static final boolean k(@yt.k o0 o0Var) {
        c2 c2Var = (c2) o0Var.W().c(c2.f38296x2);
        if (c2Var != null) {
            return c2Var.isActive();
        }
        return true;
    }

    public static /* synthetic */ void l(o0 o0Var) {
    }

    @yt.k
    public static final o0 m(@yt.k o0 o0Var, @yt.k CoroutineContext coroutineContext) {
        return new kotlinx.coroutines.internal.g(o0Var.W().L(coroutineContext));
    }
}
