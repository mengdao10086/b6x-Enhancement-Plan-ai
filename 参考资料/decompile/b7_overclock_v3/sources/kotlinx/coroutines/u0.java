package kotlinx.coroutines;

import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.c2;

/* JADX INFO: loaded from: classes5.dex */
public interface u0<T> extends c2 {

    public static final class a {
        public static <T, R> R b(@yt.k u0<? extends T> u0Var, R r10, @yt.k ik.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) c2.a.d(u0Var, r10, pVar);
        }

        @yt.l
        public static <T, E extends CoroutineContext.a> E c(@yt.k u0<? extends T> u0Var, @yt.k CoroutineContext.b<E> bVar) {
            return (E) c2.a.e(u0Var, bVar);
        }

        @yt.k
        public static <T> CoroutineContext d(@yt.k u0<? extends T> u0Var, @yt.k CoroutineContext.b<?> bVar) {
            return c2.a.h(u0Var, bVar);
        }

        @yt.k
        public static <T> CoroutineContext e(@yt.k u0<? extends T> u0Var, @yt.k CoroutineContext coroutineContext) {
            return c2.a.i(u0Var, coroutineContext);
        }

        @kotlin.k(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @yt.k
        public static <T> c2 f(@yt.k u0<? extends T> u0Var, @yt.k c2 c2Var) {
            return c2.a.j(u0Var, c2Var);
        }
    }

    @yt.k
    kotlinx.coroutines.selects.e<T> M();

    @s1
    @yt.l
    Throwable P();

    @yt.l
    Object b0(@yt.k kotlin.coroutines.c<? super T> cVar);

    @s1
    T u();
}
