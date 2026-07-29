package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowKt__EmittersKt$onEmpty$1$1<T> implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f38518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f<T> f38519b;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__EmittersKt$onEmpty$1$1(Ref.BooleanRef booleanRef, f<? super T> fVar) {
        this.f38518a = booleanRef;
        this.f38519b = fVar;
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
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1$emit$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.u0.n(r6)
            goto L44
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.u0.n(r6)
            kotlin.jvm.internal.Ref$BooleanRef r6 = r4.f38518a
            r2 = 0
            r6.element = r2
            kotlinx.coroutines.flow.f<T> r6 = r4.f38519b
            r0.label = r3
            java.lang.Object r5 = r6.f(r5, r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            kotlin.z1 r5 = kotlin.z1.f38230a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
