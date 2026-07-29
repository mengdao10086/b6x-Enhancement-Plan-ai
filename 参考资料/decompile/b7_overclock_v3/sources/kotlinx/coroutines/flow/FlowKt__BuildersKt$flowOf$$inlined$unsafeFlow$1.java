package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.t0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n1#1,112:1\n123#2,4:113\n*E\n"})
public final class FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object[] f38499a;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,112:1\n*E\n"})
    @zj.d(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1", f = "Builders.kt", i = {0, 0}, l = {114}, m = "collect", n = {"this", "$this$flowOf_u24lambda_u248"}, s = {"L$0", "L$1"})
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
            return FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1.this.a(null, this);
        }
    }

    public FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(Object[] objArr) {
        this.f38499a = objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object, kotlinx.coroutines.flow.f] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005d -> B:19:0x0060). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.e
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@yt.k kotlinx.coroutines.flow.f<? super T> r7, @yt.k kotlin.coroutines.c<? super kotlin.z1> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            int r7 = r0.I$1
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$1
            kotlinx.coroutines.flow.f r4 = (kotlinx.coroutines.flow.f) r4
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 r5 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1) r5
            kotlin.u0.n(r8)
            r8 = r4
            goto L60
        L36:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3e:
            kotlin.u0.n(r8)
            r8 = 0
            java.lang.Object[] r2 = r6.f38499a
            int r2 = r2.length
            r5 = r6
            r8 = r7
            r7 = r2
            r2 = 0
        L49:
            if (r2 >= r7) goto L62
            java.lang.Object[] r4 = r5.f38499a
            r4 = r4[r2]
            r0.L$0 = r5
            r0.L$1 = r8
            r0.I$0 = r2
            r0.I$1 = r7
            r0.label = r3
            java.lang.Object r4 = r8.f(r4, r0)
            if (r4 != r1) goto L60
            return r1
        L60:
            int r2 = r2 + r3
            goto L49
        L62:
            kotlin.z1 r7 = kotlin.z1.f38230a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1.a(kotlinx.coroutines.flow.f, kotlin.coroutines.c):java.lang.Object");
    }
}
