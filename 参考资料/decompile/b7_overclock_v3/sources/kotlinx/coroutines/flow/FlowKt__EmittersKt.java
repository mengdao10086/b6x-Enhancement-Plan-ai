package kotlinx.coroutines.flow;

import kotlin.jvm.internal.t0;
import kotlin.s0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,222:1\n106#2:223\n106#2:224\n106#2:225\n106#2:226\n75#3:227\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n50#1:223\n76#1:224\n146#1:225\n181#1:226\n218#1:227\n*E\n"})
public final /* synthetic */ class FlowKt__EmittersKt {
    public static final void b(@yt.k f<?> fVar) {
        if (fVar instanceof x) {
            throw ((x) fVar).f38744a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object c(kotlinx.coroutines.flow.f<? super T> r4, ik.q<? super kotlinx.coroutines.flow.f<? super T>, ? super java.lang.Throwable, ? super kotlin.coroutines.c<? super kotlin.z1>, ? extends java.lang.Object> r5, java.lang.Throwable r6, kotlin.coroutines.c<? super kotlin.z1> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$invokeSafely$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            kotlin.u0.n(r7)     // Catch: java.lang.Throwable -> L47
            goto L44
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.u0.n(r7)
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L47
            r0.label = r3     // Catch: java.lang.Throwable -> L47
            java.lang.Object r4 = r5.A(r4, r6, r0)     // Catch: java.lang.Throwable -> L47
            if (r4 != r1) goto L44
            return r1
        L44:
            kotlin.z1 r4 = kotlin.z1.f38230a
            return r4
        L47:
            r4 = move-exception
            if (r6 == 0) goto L4f
            if (r6 == r4) goto L4f
            kotlin.o.a(r4, r6)
        L4f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt.c(kotlinx.coroutines.flow.f, ik.q, java.lang.Throwable, kotlin.coroutines.c):java.lang.Object");
    }

    @yt.k
    public static final <T> e<T> d(@yt.k e<? extends T> eVar, @yt.k ik.q<? super f<? super T>, ? super Throwable, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar) {
        return new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(eVar, qVar);
    }

    @yt.k
    public static final <T> e<T> e(@yt.k e<? extends T> eVar, @yt.k ik.p<? super f<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        return new FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(eVar, pVar);
    }

    @yt.k
    public static final <T> e<T> f(@yt.k e<? extends T> eVar, @yt.k ik.p<? super f<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar) {
        return new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(pVar, eVar);
    }

    @yt.k
    public static final <T, R> e<R> g(@yt.k e<? extends T> eVar, @kotlin.b @yt.k ik.q<? super f<? super R>, ? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar) {
        return g.J0(new FlowKt__EmittersKt$transform$1(eVar, qVar, null));
    }

    @s0
    @yt.k
    public static final <T, R> e<R> h(@yt.k e<? extends T> eVar, @kotlin.b @yt.k ik.q<? super f<? super R>, ? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar) {
        return new FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1(eVar, qVar);
    }
}
