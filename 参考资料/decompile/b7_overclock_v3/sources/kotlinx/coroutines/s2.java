package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.c2;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.k(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@y1
public interface s2 extends c2 {

    public static final class a {
        public static <R> R b(@yt.k s2 s2Var, R r10, @yt.k ik.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) c2.a.d(s2Var, r10, pVar);
        }

        @yt.l
        public static <E extends CoroutineContext.a> E c(@yt.k s2 s2Var, @yt.k CoroutineContext.b<E> bVar) {
            return (E) c2.a.e(s2Var, bVar);
        }

        @yt.k
        public static CoroutineContext d(@yt.k s2 s2Var, @yt.k CoroutineContext.b<?> bVar) {
            return c2.a.h(s2Var, bVar);
        }

        @yt.k
        public static CoroutineContext e(@yt.k s2 s2Var, @yt.k CoroutineContext coroutineContext) {
            return c2.a.i(s2Var, coroutineContext);
        }

        @kotlin.k(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @yt.k
        public static c2 f(@yt.k s2 s2Var, @yt.k c2 c2Var) {
            return c2.a.j(s2Var, c2Var);
        }
    }

    @y1
    @yt.k
    CancellationException C1();
}
