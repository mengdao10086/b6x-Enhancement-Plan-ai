package kotlinx.coroutines;

import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.c2;

/* JADX INFO: loaded from: classes5.dex */
public interface a0 extends c2 {

    public static final class a {
        public static <R> R b(@yt.k a0 a0Var, R r10, @yt.k ik.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) c2.a.d(a0Var, r10, pVar);
        }

        @yt.l
        public static <E extends CoroutineContext.a> E c(@yt.k a0 a0Var, @yt.k CoroutineContext.b<E> bVar) {
            return (E) c2.a.e(a0Var, bVar);
        }

        @yt.k
        public static CoroutineContext d(@yt.k a0 a0Var, @yt.k CoroutineContext.b<?> bVar) {
            return c2.a.h(a0Var, bVar);
        }

        @yt.k
        public static CoroutineContext e(@yt.k a0 a0Var, @yt.k CoroutineContext coroutineContext) {
            return c2.a.i(a0Var, coroutineContext);
        }

        @kotlin.k(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @yt.k
        public static c2 f(@yt.k a0 a0Var, @yt.k c2 c2Var) {
            return c2.a.j(a0Var, c2Var);
        }
    }

    boolean a();

    boolean l(@yt.k Throwable th2);
}
