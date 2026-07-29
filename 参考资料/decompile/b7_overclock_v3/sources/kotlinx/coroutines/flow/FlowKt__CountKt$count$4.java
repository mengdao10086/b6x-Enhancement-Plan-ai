package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowKt__CountKt$count$4<T> implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ik.p<T, kotlin.coroutines.c<? super Boolean>, Object> f38506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f38507b;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__CountKt$count$4(ik.p<? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, Ref.IntRef intRef) {
        this.f38506a = pVar;
        this.f38507b = intRef;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.f
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(T r5, @yt.k kotlin.coroutines.c<? super kotlin.z1> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__CountKt$count$4$emit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__CountKt$count$4$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__CountKt$count$4$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__CountKt$count$4$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$4$emit$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__CountKt$count$4 r5 = (kotlinx.coroutines.flow.FlowKt__CountKt$count$4) r5
            kotlin.u0.n(r6)
            goto L46
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.u0.n(r6)
            ik.p<T, kotlin.coroutines.c<? super java.lang.Boolean>, java.lang.Object> r6 = r4.f38506a
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.r0(r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            r5 = r4
        L46:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L55
            kotlin.jvm.internal.Ref$IntRef r5 = r5.f38507b
            int r6 = r5.element
            int r6 = r6 + r3
            r5.element = r6
        L55:
            kotlin.z1 r5 = kotlin.z1.f38230a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CountKt$count$4.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
