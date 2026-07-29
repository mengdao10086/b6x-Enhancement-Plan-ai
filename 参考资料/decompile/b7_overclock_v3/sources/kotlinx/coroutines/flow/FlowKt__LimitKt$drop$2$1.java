package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowKt__LimitKt$drop$2$1<T> implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f38539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f38540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f<T> f38541c;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$drop$2$1(Ref.IntRef intRef, int i10, f<? super T> fVar) {
        this.f38539a = intRef;
        this.f38540b = i10;
        this.f38541c = fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.f
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(T r6, @yt.k kotlin.coroutines.c<? super kotlin.z1> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.u0.n(r7)
            goto L47
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.u0.n(r7)
            kotlin.jvm.internal.Ref$IntRef r7 = r5.f38539a
            int r2 = r7.element
            int r4 = r5.f38540b
            if (r2 < r4) goto L4a
            kotlinx.coroutines.flow.f<T> r7 = r5.f38541c
            r0.label = r3
            java.lang.Object r6 = r7.f(r6, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            kotlin.z1 r6 = kotlin.z1.f38230a
            return r6
        L4a:
            int r2 = r2 + r3
            r7.element = r2
            kotlin.z1 r6 = kotlin.z1.f38230a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
