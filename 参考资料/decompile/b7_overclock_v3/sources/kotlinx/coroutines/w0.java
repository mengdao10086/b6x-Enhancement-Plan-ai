package kotlinx.coroutines;

import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* JADX INFO: loaded from: classes5.dex */
@y1
public interface w0 {

    @kotlin.jvm.internal.t0({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/Delay$DefaultImpls\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,162:1\n314#2,11:163\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/Delay$DefaultImpls\n*L\n30#1:163,11\n*E\n"})
    public static final class a {
        @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
        @yt.l
        public static Object a(@yt.k w0 w0Var, long j10, @yt.k kotlin.coroutines.c<? super kotlin.z1> cVar) {
            if (j10 <= 0) {
                return kotlin.z1.f38230a;
            }
            p pVar = new p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
            pVar.Q();
            w0Var.i(j10, pVar);
            Object objC = pVar.C();
            if (objC == yj.b.h()) {
                zj.f.c(cVar);
            }
            return objC == yj.b.h() ? objC : kotlin.z1.f38230a;
        }

        @yt.k
        public static g1 b(@yt.k w0 w0Var, long j10, @yt.k Runnable runnable, @yt.k CoroutineContext coroutineContext) {
            return t0.a().h1(j10, runnable, coroutineContext);
        }
    }

    @yt.k
    g1 h1(long j10, @yt.k Runnable runnable, @yt.k CoroutineContext coroutineContext);

    void i(long j10, @yt.k o<? super kotlin.z1> oVar);

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @yt.l
    Object m1(long j10, @yt.k kotlin.coroutines.c<? super kotlin.z1> cVar);
}
