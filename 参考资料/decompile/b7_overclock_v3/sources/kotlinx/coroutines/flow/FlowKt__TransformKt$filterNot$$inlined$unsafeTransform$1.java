package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,112:1\n51#2,5:113\n*E\n"})
public final class FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1<T> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f38599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ik.p f38600b;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2, reason: invalid class name */
    @t0({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,222:1\n29#2,2:223\n*E\n"})
    public static final class AnonymousClass2<T> implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f38601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ik.p f38602b;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
        @t0({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1$emit$1\n*L\n1#1,222:1\n*E\n"})
        @zj.d(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0, 0}, l = {223, 223}, m = "emit", n = {"value", "$this$filterNot_u24lambda_u241"}, s = {"L$0", "L$1"})
        public static final class AnonymousClass1 extends ContinuationImpl {
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
                return AnonymousClass2.this.f(null, this);
            }
        }

        public AnonymousClass2(f fVar, ik.p pVar) {
            this.f38601a = fVar;
            this.f38602b = pVar;
        }

        @yt.l
        public final Object a(Object obj, @yt.k kotlin.coroutines.c cVar) {
            c0.e(4);
            new AnonymousClass1(cVar);
            c0.e(5);
            f fVar = this.f38601a;
            if (!((Boolean) this.f38602b.r0(obj, cVar)).booleanValue()) {
                c0.e(0);
                fVar.f(obj, cVar);
                c0.e(1);
            }
            return z1.f38230a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.f
        @yt.l
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object f(T r7, @yt.k kotlin.coroutines.c<? super kotlin.z1> r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                if (r0 == 0) goto L13
                r0 = r8
                kotlinx.coroutines.flow.FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2$1
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = yj.b.h()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L3e
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                kotlin.u0.n(r8)
                goto L6c
            L2c:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L34:
                java.lang.Object r7 = r0.L$1
                kotlinx.coroutines.flow.f r7 = (kotlinx.coroutines.flow.f) r7
                java.lang.Object r2 = r0.L$0
                kotlin.u0.n(r8)
                goto L56
            L3e:
                kotlin.u0.n(r8)
                kotlinx.coroutines.flow.f r8 = r6.f38601a
                ik.p r2 = r6.f38602b
                r0.L$0 = r7
                r0.L$1 = r8
                r0.label = r4
                java.lang.Object r2 = r2.r0(r7, r0)
                if (r2 != r1) goto L52
                return r1
            L52:
                r5 = r2
                r2 = r7
                r7 = r8
                r8 = r5
            L56:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 != 0) goto L6c
                r8 = 0
                r0.L$0 = r8
                r0.L$1 = r8
                r0.label = r3
                java.lang.Object r7 = r7.f(r2, r0)
                if (r7 != r1) goto L6c
                return r1
            L6c:
                kotlin.z1 r7 = kotlin.z1.f38230a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1.AnonymousClass2.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
        }
    }

    public FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1(e eVar, ik.p pVar) {
        this.f38599a = eVar;
        this.f38600b = pVar;
    }

    @Override // kotlinx.coroutines.flow.e
    @yt.l
    public Object a(@yt.k f fVar, @yt.k kotlin.coroutines.c cVar) {
        Object objA = this.f38599a.a(new AnonymousClass2(fVar, this.f38600b), cVar);
        return objA == yj.b.h() ? objA : z1.f38230a;
    }

    @yt.l
    public Object d(@yt.k f fVar, @yt.k kotlin.coroutines.c cVar) {
        c0.e(4);
        new ContinuationImpl(cVar) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1.1
            public int label;
            public /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @yt.l
            public final Object q0(@yt.k Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1.this.a(null, this);
            }
        };
        c0.e(5);
        e eVar = this.f38599a;
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(fVar, this.f38600b);
        c0.e(0);
        eVar.a(anonymousClass2, cVar);
        c0.e(1);
        return z1.f38230a;
    }
}
