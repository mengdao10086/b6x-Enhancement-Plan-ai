package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.c3;

/* JADX INFO: loaded from: classes5.dex */
@s1
@y0
public interface i0<S> extends c3<S> {

    public static final class a {
        public static <S, R> R a(@yt.k i0<S> i0Var, R r10, @yt.k ik.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) c3.a.a(i0Var, r10, pVar);
        }

        @yt.l
        public static <S, E extends CoroutineContext.a> E b(@yt.k i0<S> i0Var, @yt.k CoroutineContext.b<E> bVar) {
            return (E) c3.a.b(i0Var, bVar);
        }

        @yt.k
        public static <S> CoroutineContext c(@yt.k i0<S> i0Var, @yt.k CoroutineContext.b<?> bVar) {
            return c3.a.c(i0Var, bVar);
        }

        @yt.k
        public static <S> CoroutineContext d(@yt.k i0<S> i0Var, @yt.k CoroutineContext coroutineContext) {
            return c3.a.d(i0Var, coroutineContext);
        }
    }

    @yt.k
    CoroutineContext I(@yt.k CoroutineContext.a aVar);

    @yt.k
    i0<S> i1();
}
