package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.t0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,112:1\n77#2:113\n78#2,7:115\n329#3:114\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n77#1:114\n*E\n"})
public final class FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ik.p f38520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f38521b;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1\n*L\n1#1,112:1\n*E\n"})
    @zj.d(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1", f = "Emitters.kt", i = {0, 0, 0}, l = {116, 120}, m = "collect", n = {"this", "$this$onStart_u24lambda_u241", "safeCollector"}, s = {"L$0", "L$1", "L$2"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        public Object L$0;
        public Object L$1;
        public Object L$2;
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
            return FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.this.a(null, this);
        }
    }

    public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(ik.p pVar, e eVar) {
        this.f38520a = pVar;
        this.f38521b = eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.e
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(@yt.k kotlinx.coroutines.flow.f<? super T> r7, @yt.k kotlin.coroutines.c<? super kotlin.z1> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L46
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.u0.n(r8)
            goto L83
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r7 = r0.L$2
            kotlinx.coroutines.flow.internal.SafeCollector r7 = (kotlinx.coroutines.flow.internal.SafeCollector) r7
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.f r2 = (kotlinx.coroutines.flow.f) r2
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r4 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1) r4
            kotlin.u0.n(r8)     // Catch: java.lang.Throwable -> L44
            goto L6e
        L44:
            r8 = move-exception
            goto L8a
        L46:
            kotlin.u0.n(r8)
            kotlinx.coroutines.flow.internal.SafeCollector r8 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlin.coroutines.CoroutineContext r2 = r0.b()
            r8.<init>(r7, r2)
            ik.p r2 = r6.f38520a     // Catch: java.lang.Throwable -> L86
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L86
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L86
            r0.L$2 = r8     // Catch: java.lang.Throwable -> L86
            r0.label = r4     // Catch: java.lang.Throwable -> L86
            r4 = 6
            kotlin.jvm.internal.c0.e(r4)     // Catch: java.lang.Throwable -> L86
            java.lang.Object r2 = r2.r0(r8, r0)     // Catch: java.lang.Throwable -> L86
            r4 = 7
            kotlin.jvm.internal.c0.e(r4)     // Catch: java.lang.Throwable -> L86
            if (r2 != r1) goto L6b
            return r1
        L6b:
            r4 = r6
            r2 = r7
            r7 = r8
        L6e:
            r7.u0()
            kotlinx.coroutines.flow.e r7 = r4.f38521b
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r7 = r7.a(r2, r0)
            if (r7 != r1) goto L83
            return r1
        L83:
            kotlin.z1 r7 = kotlin.z1.f38230a
            return r7
        L86:
            r7 = move-exception
            r5 = r8
            r8 = r7
            r7 = r5
        L8a:
            r7.u0()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.a(kotlinx.coroutines.flow.f, kotlin.coroutines.c):java.lang.Object");
    }
}
