package kotlinx.coroutines;

import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.w0;

/* JADX INFO: loaded from: classes5.dex */
@y1
public interface x0 extends w0 {

    public static final class a {
        @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
        @yt.l
        public static Object a(@yt.k x0 x0Var, long j10, @yt.k kotlin.coroutines.c<? super kotlin.z1> cVar) {
            Object objA = w0.a.a(x0Var, j10, cVar);
            return objA == yj.b.h() ? objA : kotlin.z1.f38230a;
        }

        @yt.k
        public static g1 b(@yt.k x0 x0Var, long j10, @yt.k Runnable runnable, @yt.k CoroutineContext coroutineContext) {
            return w0.a.b(x0Var, j10, runnable, coroutineContext);
        }
    }

    @yt.k
    String z1(long j10);
}
