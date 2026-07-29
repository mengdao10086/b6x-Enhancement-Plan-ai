package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/BuildersKt__BuildersKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,102:1\n1#2:103\n*E\n"})
public final /* synthetic */ class i {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> T a(@yt.k kotlin.coroutines.CoroutineContext r4, @yt.k ik.p<? super kotlinx.coroutines.o0, ? super kotlin.coroutines.c<? super T>, ? extends java.lang.Object> r5) throws java.lang.InterruptedException {
        /*
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            kotlin.coroutines.d$b r1 = kotlin.coroutines.d.f37759u2
            kotlin.coroutines.CoroutineContext$a r1 = r4.c(r1)
            kotlin.coroutines.d r1 = (kotlin.coroutines.d) r1
            if (r1 != 0) goto L1f
            kotlinx.coroutines.e3 r1 = kotlinx.coroutines.e3.f38471a
            kotlinx.coroutines.k1 r1 = r1.b()
            kotlinx.coroutines.u1 r2 = kotlinx.coroutines.u1.f39074a
            kotlin.coroutines.CoroutineContext r4 = r4.L(r1)
            kotlin.coroutines.CoroutineContext r4 = kotlinx.coroutines.CoroutineContextKt.e(r2, r4)
            goto L42
        L1f:
            boolean r2 = r1 instanceof kotlinx.coroutines.k1
            r3 = 0
            if (r2 == 0) goto L27
            kotlinx.coroutines.k1 r1 = (kotlinx.coroutines.k1) r1
            goto L28
        L27:
            r1 = r3
        L28:
            if (r1 == 0) goto L36
            boolean r2 = r1.y2()
            if (r2 == 0) goto L31
            r3 = r1
        L31:
            if (r3 != 0) goto L34
            goto L36
        L34:
            r1 = r3
            goto L3c
        L36:
            kotlinx.coroutines.e3 r1 = kotlinx.coroutines.e3.f38471a
            kotlinx.coroutines.k1 r1 = r1.a()
        L3c:
            kotlinx.coroutines.u1 r2 = kotlinx.coroutines.u1.f39074a
            kotlin.coroutines.CoroutineContext r4 = kotlinx.coroutines.CoroutineContextKt.e(r2, r4)
        L42:
            kotlinx.coroutines.f r2 = new kotlinx.coroutines.f
            r2.<init>(r4, r0, r1)
            kotlinx.coroutines.CoroutineStart r4 = kotlinx.coroutines.CoroutineStart.DEFAULT
            r2.I1(r4, r2, r5)
            java.lang.Object r4 = r2.J1()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.i.a(kotlin.coroutines.CoroutineContext, ik.p):java.lang.Object");
    }

    public static /* synthetic */ Object b(CoroutineContext coroutineContext, ik.p pVar, int i10, Object obj) throws InterruptedException {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f37755a;
        }
        return h.f(coroutineContext, pVar);
    }
}
