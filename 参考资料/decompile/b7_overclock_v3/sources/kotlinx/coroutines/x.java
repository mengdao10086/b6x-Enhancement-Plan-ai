package kotlinx.coroutines;

import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.u0;

/* JADX INFO: loaded from: classes5.dex */
public interface x<T> extends u0<T> {

    public static final class a {
        public static <T, R> R b(@yt.k x<T> xVar, R r10, @yt.k ik.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) u0.a.b(xVar, r10, pVar);
        }

        @yt.l
        public static <T, E extends CoroutineContext.a> E c(@yt.k x<T> xVar, @yt.k CoroutineContext.b<E> bVar) {
            return (E) u0.a.c(xVar, bVar);
        }

        @yt.k
        public static <T> CoroutineContext d(@yt.k x<T> xVar, @yt.k CoroutineContext.b<?> bVar) {
            return u0.a.d(xVar, bVar);
        }

        @yt.k
        public static <T> CoroutineContext e(@yt.k x<T> xVar, @yt.k CoroutineContext coroutineContext) {
            return u0.a.e(xVar, coroutineContext);
        }

        @kotlin.k(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @yt.k
        public static <T> c2 f(@yt.k x<T> xVar, @yt.k c2 c2Var) {
            return u0.a.f(xVar, c2Var);
        }
    }

    boolean l(@yt.k Throwable th2);

    boolean u1(T t10);
}
