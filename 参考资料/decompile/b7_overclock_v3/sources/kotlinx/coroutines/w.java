package kotlinx.coroutines;

import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.c2;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.k(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@y1
public interface w extends c2 {

    public static final class a {
        public static <R> R b(@yt.k w wVar, R r10, @yt.k ik.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) c2.a.d(wVar, r10, pVar);
        }

        @yt.l
        public static <E extends CoroutineContext.a> E c(@yt.k w wVar, @yt.k CoroutineContext.b<E> bVar) {
            return (E) c2.a.e(wVar, bVar);
        }

        @yt.k
        public static CoroutineContext d(@yt.k w wVar, @yt.k CoroutineContext.b<?> bVar) {
            return c2.a.h(wVar, bVar);
        }

        @yt.k
        public static CoroutineContext e(@yt.k w wVar, @yt.k CoroutineContext coroutineContext) {
            return c2.a.i(wVar, coroutineContext);
        }

        @kotlin.k(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @yt.k
        public static c2 f(@yt.k w wVar, @yt.k c2 c2Var) {
            return c2.a.j(wVar, c2Var);
        }
    }

    @y1
    void G0(@yt.k s2 s2Var);
}
