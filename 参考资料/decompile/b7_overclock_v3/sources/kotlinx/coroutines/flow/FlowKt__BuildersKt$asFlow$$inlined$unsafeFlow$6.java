package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.t0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,112:1\n154#2:113\n155#2,2:115\n157#2:118\n13579#3:114\n13580#3:117\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n154#1:114\n154#1:117\n*E\n"})
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object[] f38494a;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6$1, reason: invalid class name */
    @t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,112:1\n*E\n"})
    @zj.d(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6", f = "Builders.kt", i = {0, 0}, l = {115}, m = "collect", n = {"$this$asFlow_u24lambda_u2411", "$this$forEach$iv"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        public int I$0;
        public int I$1;
        public Object L$0;
        public Object L$1;
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
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6.this.a(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(Object[] objArr) {
        this.f38494a = objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object, kotlinx.coroutines.flow.f] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005b -> B:19:0x005e). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.e
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@yt.k kotlinx.coroutines.flow.f<? super T> r8, @yt.k kotlin.coroutines.c<? super kotlin.z1> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6$1 r0 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6$1 r0 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            int r8 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$1
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.f r5 = (kotlinx.coroutines.flow.f) r5
            kotlin.u0.n(r9)
            r9 = r5
            goto L5e
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3e:
            kotlin.u0.n(r9)
            java.lang.Object[] r9 = r7.f38494a
            r2 = 0
            int r4 = r9.length
            r6 = r9
            r9 = r8
            r8 = r4
            r4 = r6
        L49:
            if (r2 >= r8) goto L60
            r5 = r4[r2]
            r0.L$0 = r9
            r0.L$1 = r4
            r0.I$0 = r2
            r0.I$1 = r8
            r0.label = r3
            java.lang.Object r5 = r9.f(r5, r0)
            if (r5 != r1) goto L5e
            return r1
        L5e:
            int r2 = r2 + r3
            goto L49
        L60:
            kotlin.z1 r8 = kotlin.z1.f38230a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6.a(kotlinx.coroutines.flow.f, kotlin.coroutines.c):java.lang.Object");
    }
}
