package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
public interface c3<S> extends CoroutineContext.a {

    public static final class a {
        public static <S, R> R a(@yt.k c3<S> c3Var, R r10, @yt.k ik.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) CoroutineContext.a.C0431a.a(c3Var, r10, pVar);
        }

        @yt.l
        public static <S, E extends CoroutineContext.a> E b(@yt.k c3<S> c3Var, @yt.k CoroutineContext.b<E> bVar) {
            return (E) CoroutineContext.a.C0431a.b(c3Var, bVar);
        }

        @yt.k
        public static <S> CoroutineContext c(@yt.k c3<S> c3Var, @yt.k CoroutineContext.b<?> bVar) {
            return CoroutineContext.a.C0431a.c(c3Var, bVar);
        }

        @yt.k
        public static <S> CoroutineContext d(@yt.k c3<S> c3Var, @yt.k CoroutineContext coroutineContext) {
            return CoroutineContext.a.C0431a.d(c3Var, coroutineContext);
        }
    }

    S Y1(@yt.k CoroutineContext coroutineContext);

    void p1(@yt.k CoroutineContext coroutineContext, S s10);
}
