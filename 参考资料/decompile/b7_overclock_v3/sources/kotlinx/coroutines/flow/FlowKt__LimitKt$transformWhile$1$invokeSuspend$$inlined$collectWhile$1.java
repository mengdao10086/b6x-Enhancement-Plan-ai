package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.t0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$transformWhile$1\n*L\n1#1,141:1\n120#2:142\n*E\n"})
public final class FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ik.q f38554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f38555b;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1, reason: invalid class name */
    @t0({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1$emit$1\n*L\n1#1,141:1\n*E\n"})
    @zj.d(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1", f = "Limit.kt", i = {0}, l = {142}, m = "emit", n = {"this"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.l
        public final Object q0(@yt.k Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1.this.f(null, this);
        }
    }

    public FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1(ik.q qVar, f fVar) {
        this.f38554a = qVar;
        this.f38555b = fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.f
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(T r5, @yt.k kotlin.coroutines.c<? super kotlin.z1> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 r5 = (kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1) r5
            kotlin.u0.n(r6)
            goto L50
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.u0.n(r6)
            ik.q r6 = r4.f38554a
            kotlinx.coroutines.flow.f r2 = r4.f38555b
            r0.L$0 = r4
            r0.label = r3
            r3 = 6
            kotlin.jvm.internal.c0.e(r3)
            java.lang.Object r6 = r6.A(r2, r5, r0)
            r5 = 7
            kotlin.jvm.internal.c0.e(r5)
            if (r6 != r1) goto L4f
            return r1
        L4f:
            r5 = r4
        L50:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L5b
            kotlin.z1 r5 = kotlin.z1.f38230a
            return r5
        L5b:
            kotlinx.coroutines.flow.internal.AbortFlowException r6 = new kotlinx.coroutines.flow.internal.AbortFlowException
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
