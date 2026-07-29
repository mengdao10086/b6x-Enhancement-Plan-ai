package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowKt__ErrorsKt$catchImpl$2<T> implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f<T> f38530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Throwable> f38531b;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ErrorsKt$catchImpl$2(f<? super T> fVar, Ref.ObjectRef<Throwable> objectRef) {
        this.f38530a = fVar;
        this.f38531b = objectRef;
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
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2 r5 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2) r5
            kotlin.u0.n(r6)     // Catch: java.lang.Throwable -> L2d
            goto L47
        L2d:
            r6 = move-exception
            goto L4c
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.u0.n(r6)
            kotlinx.coroutines.flow.f<T> r6 = r4.f38530a     // Catch: java.lang.Throwable -> L4a
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L4a
            r0.label = r3     // Catch: java.lang.Throwable -> L4a
            java.lang.Object r5 = r6.f(r5, r0)     // Catch: java.lang.Throwable -> L4a
            if (r5 != r1) goto L47
            return r1
        L47:
            kotlin.z1 r5 = kotlin.z1.f38230a
            return r5
        L4a:
            r6 = move-exception
            r5 = r4
        L4c:
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Throwable> r5 = r5.f38531b
            r5.element = r6
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
