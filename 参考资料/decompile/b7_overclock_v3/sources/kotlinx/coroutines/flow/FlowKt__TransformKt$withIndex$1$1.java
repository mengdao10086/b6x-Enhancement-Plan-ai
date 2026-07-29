package kotlinx.coroutines.flow;

import kotlin.collections.h0;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nTransform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt$withIndex$1$1\n+ 2 FlowExceptions.common.kt\nkotlinx/coroutines/flow/internal/FlowExceptions_commonKt\n*L\n1#1,136:1\n32#2,4:137\n*S KotlinDebug\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt$withIndex$1$1\n*L\n71#1:137,4\n*E\n"})
public final class FlowKt__TransformKt$withIndex$1$1<T> implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f<h0<? extends T>> f38626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f38627b;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__TransformKt$withIndex$1$1(f<? super h0<? extends T>> fVar, Ref.IntRef intRef) {
        this.f38626a = fVar;
        this.f38627b = intRef;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.f
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(T r8, @yt.k kotlin.coroutines.c<? super kotlin.z1> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$withIndex$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__TransformKt$withIndex$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$withIndex$1$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__TransformKt$withIndex$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$withIndex$1$1$emit$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.u0.n(r9)
            goto L4e
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L31:
            kotlin.u0.n(r9)
            kotlinx.coroutines.flow.f<kotlin.collections.h0<? extends T>> r9 = r7.f38626a
            kotlin.collections.h0 r2 = new kotlin.collections.h0
            kotlin.jvm.internal.Ref$IntRef r4 = r7.f38627b
            int r5 = r4.element
            int r6 = r5 + 1
            r4.element = r6
            if (r5 < 0) goto L51
            r2.<init>(r5, r8)
            r0.label = r3
            java.lang.Object r8 = r9.f(r2, r0)
            if (r8 != r1) goto L4e
            return r1
        L4e:
            kotlin.z1 r8 = kotlin.z1.f38230a
            return r8
        L51:
            java.lang.ArithmeticException r8 = new java.lang.ArithmeticException
            java.lang.String r9 = "Index overflow has happened"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$withIndex$1$1.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
