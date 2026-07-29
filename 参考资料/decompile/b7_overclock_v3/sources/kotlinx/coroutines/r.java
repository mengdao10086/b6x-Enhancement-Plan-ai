package kotlinx.coroutines;

import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nCancellableContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CompletionHandler.kt\nkotlinx/coroutines/CompletionHandlerKt\n*L\n1#1,386:1\n1#2:387\n19#3:388\n*S KotlinDebug\n*F\n+ 1 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n380#1:388\n*E\n"})
public final class r {
    @y1
    public static final void a(@yt.k o<?> oVar, @yt.k g1 g1Var) {
        oVar.B(new h1(g1Var));
    }

    @yt.k
    public static final <T> p<T> b(@yt.k kotlin.coroutines.c<? super T> cVar) {
        if (!(cVar instanceof kotlinx.coroutines.internal.k)) {
            return new p<>(cVar, 1);
        }
        p<T> pVarL = ((kotlinx.coroutines.internal.k) cVar).l();
        if (pVarL != null) {
            if (!pVarL.V()) {
                pVarL = null;
            }
            if (pVarL != null) {
                return pVarL;
            }
        }
        return new p<>(cVar, 2);
    }

    @yt.l
    public static final <T> Object c(@yt.k ik.l<? super o<? super T>, kotlin.z1> lVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        p pVar = new p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.Q();
        lVar.i(pVar);
        Object objC = pVar.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objC;
    }

    public static final <T> Object d(ik.l<? super o<? super T>, kotlin.z1> lVar, kotlin.coroutines.c<? super T> cVar) {
        kotlin.jvm.internal.c0.e(0);
        p pVar = new p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.Q();
        lVar.i(pVar);
        Object objC = pVar.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        kotlin.jvm.internal.c0.e(1);
        return objC;
    }

    @yt.l
    public static final <T> Object e(@yt.k ik.l<? super p<? super T>, kotlin.z1> lVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        p pVarB = b(IntrinsicsKt__IntrinsicsJvmKt.d(cVar));
        try {
            lVar.i(pVarB);
            Object objC = pVarB.C();
            if (objC == yj.b.h()) {
                zj.f.c(cVar);
            }
            return objC;
        } catch (Throwable th2) {
            pVarB.U();
            throw th2;
        }
    }

    public static final <T> Object f(ik.l<? super p<? super T>, kotlin.z1> lVar, kotlin.coroutines.c<? super T> cVar) {
        kotlin.jvm.internal.c0.e(0);
        p pVarB = b(IntrinsicsKt__IntrinsicsJvmKt.d(cVar));
        try {
            lVar.i(pVarB);
            Object objC = pVarB.C();
            if (objC == yj.b.h()) {
                zj.f.c(cVar);
            }
            kotlin.jvm.internal.c0.e(1);
            return objC;
        } catch (Throwable th2) {
            pVarB.U();
            throw th2;
        }
    }
}
