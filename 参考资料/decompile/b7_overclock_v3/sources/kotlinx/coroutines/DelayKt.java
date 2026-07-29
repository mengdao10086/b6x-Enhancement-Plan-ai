package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/DelayKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,162:1\n314#2,11:163\n314#2,11:174\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/DelayKt\n*L\n106#1:163,11\n127#1:174,11\n*E\n"})
public final class DelayKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(@yt.k kotlin.coroutines.c<?> r4) throws java.lang.Throwable {
        /*
            boolean r0 = r4 instanceof kotlinx.coroutines.DelayKt$awaitCancellation$1
            if (r0 == 0) goto L13
            r0 = r4
            kotlinx.coroutines.DelayKt$awaitCancellation$1 r0 = (kotlinx.coroutines.DelayKt$awaitCancellation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.DelayKt$awaitCancellation$1 r0 = new kotlinx.coroutines.DelayKt$awaitCancellation$1
            r0.<init>(r4)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L2d:
            kotlin.u0.n(r4)
            goto L52
        L31:
            kotlin.u0.n(r4)
            r0.label = r3
            kotlinx.coroutines.p r4 = new kotlinx.coroutines.p
            kotlin.coroutines.c r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.d(r0)
            r4.<init>(r2, r3)
            r4.Q()
            java.lang.Object r4 = r4.C()
            java.lang.Object r2 = yj.b.h()
            if (r4 != r2) goto L4f
            zj.f.c(r0)
        L4f:
            if (r4 != r1) goto L52
            return r1
        L52:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DelayKt.a(kotlin.coroutines.c):java.lang.Object");
    }

    @yt.l
    public static final Object b(long j10, @yt.k kotlin.coroutines.c<? super kotlin.z1> cVar) {
        if (j10 <= 0) {
            return kotlin.z1.f38230a;
        }
        p pVar = new p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.Q();
        if (j10 < Long.MAX_VALUE) {
            d(pVar.b()).i(j10, pVar);
        }
        Object objC = pVar.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objC == yj.b.h() ? objC : kotlin.z1.f38230a;
    }

    @yt.l
    public static final Object c(long j10, @yt.k kotlin.coroutines.c<? super kotlin.z1> cVar) {
        Object objB = b(e(j10), cVar);
        return objB == yj.b.h() ? objB : kotlin.z1.f38230a;
    }

    @yt.k
    public static final w0 d(@yt.k CoroutineContext coroutineContext) {
        CoroutineContext.a aVarC = coroutineContext.c(kotlin.coroutines.d.f37759u2);
        w0 w0Var = aVarC instanceof w0 ? (w0) aVarC : null;
        return w0Var == null ? t0.a() : w0Var;
    }

    public static final long e(long j10) {
        if (uk.e.j(j10, uk.e.f52169b.W()) > 0) {
            return qk.v.v(uk.e.M(j10), 1L);
        }
        return 0L;
    }
}
