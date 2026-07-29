package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.t0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,112:1\n53#2,3:113\n66#2,4:116\n*E\n"})
public final class FlowKt__LimitKt$take$$inlined$unsafeFlow$1<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f38545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f38546b;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,112:1\n*E\n"})
    @zj.d(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1", f = "Limit.kt", i = {0}, l = {115}, m = "collect", n = {"$this$take_u24lambda_u244"}, s = {"L$0"})
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
            return FlowKt__LimitKt$take$$inlined$unsafeFlow$1.this.a(null, this);
        }
    }

    public FlowKt__LimitKt$take$$inlined$unsafeFlow$1(e eVar, int i10) {
        this.f38545a = eVar;
        this.f38546b = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, kotlinx.coroutines.flow.f, kotlinx.coroutines.flow.f<? super T>] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlinx.coroutines.flow.f] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v9 */
    @Override // kotlinx.coroutines.flow.e
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@yt.k kotlinx.coroutines.flow.f<? super T> r7, @yt.k kotlin.coroutines.c<? super kotlin.z1> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.L$0
            kotlinx.coroutines.flow.f r7 = (kotlinx.coroutines.flow.f) r7
            kotlin.u0.n(r8)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            goto L55
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.u0.n(r8)
            kotlin.jvm.internal.Ref$IntRef r8 = new kotlin.jvm.internal.Ref$IntRef
            r8.<init>()
            kotlinx.coroutines.flow.e r2 = r6.f38545a     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1 r4 = new kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            int r5 = r6.f38546b     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            r4.<init>(r8, r5, r7)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            r0.L$0 = r7     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            r0.label = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            java.lang.Object r7 = r2.a(r4, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L51
            if (r7 != r1) goto L55
            return r1
        L51:
            r8 = move-exception
            kotlinx.coroutines.flow.internal.h.b(r8, r7)
        L55:
            kotlin.z1 r7 = kotlin.z1.f38230a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1.a(kotlinx.coroutines.flow.f, kotlin.coroutines.c):java.lang.Object");
    }
}
