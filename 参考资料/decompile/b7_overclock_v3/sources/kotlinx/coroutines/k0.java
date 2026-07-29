package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public interface k0 extends CoroutineContext.a {

    /* JADX INFO: renamed from: w2, reason: collision with root package name */
    @yt.k
    public static final b f38888w2 = b.f38889a;

    public static final class a {
        public static <R> R a(@yt.k k0 k0Var, R r10, @yt.k ik.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) CoroutineContext.a.C0431a.a(k0Var, r10, pVar);
        }

        @yt.l
        public static <E extends CoroutineContext.a> E b(@yt.k k0 k0Var, @yt.k CoroutineContext.b<E> bVar) {
            return (E) CoroutineContext.a.C0431a.b(k0Var, bVar);
        }

        @yt.k
        public static CoroutineContext c(@yt.k k0 k0Var, @yt.k CoroutineContext.b<?> bVar) {
            return CoroutineContext.a.C0431a.c(k0Var, bVar);
        }

        @yt.k
        public static CoroutineContext d(@yt.k k0 k0Var, @yt.k CoroutineContext coroutineContext) {
            return CoroutineContext.a.C0431a.d(k0Var, coroutineContext);
        }
    }

    public static final class b implements CoroutineContext.b<k0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f38889a = new b();
    }

    void V1(@yt.k CoroutineContext coroutineContext, @yt.k Throwable th2);
}
