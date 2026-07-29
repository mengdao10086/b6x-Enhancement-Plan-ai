package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1\n*L\n1#1,222:1\n*E\n"})
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1", f = "Emitters.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__EmittersKt$transform$1<R> extends SuspendLambda implements ik.p<f<? super R>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ e<T> $this_transform;
    public final /* synthetic */ ik.q<f<? super R>, T, kotlin.coroutines.c<? super z1>, Object> $transform;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1, reason: invalid class name */
    @t0({"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1$1\n*L\n1#1,222:1\n*E\n"})
    public static final class AnonymousClass1<T> implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.q<f<? super R>, T, kotlin.coroutines.c<? super z1>, Object> f38522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f<R> f38523b;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(ik.q<? super f<? super R>, ? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar, f<? super R> fVar) {
            this.f38522a = qVar;
            this.f38523b = fVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @yt.l
        public final Object a(T t10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
            c0.e(4);
            new FlowKt__EmittersKt$transform$1$1$emit$1(this, cVar);
            c0.e(5);
            this.f38522a.A((f<? super R>) this.f38523b, t10, cVar);
            return z1.f38230a;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlinx.coroutines.flow.f
        @yt.l
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object f(T r5, @yt.k kotlin.coroutines.c<? super kotlin.z1> r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r6
                kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.result
                java.lang.Object r1 = yj.b.h()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                kotlin.u0.n(r6)
                goto L41
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                kotlin.u0.n(r6)
                ik.q<kotlinx.coroutines.flow.f<? super R>, T, kotlin.coroutines.c<? super kotlin.z1>, java.lang.Object> r6 = r4.f38522a
                kotlinx.coroutines.flow.f<R> r2 = r4.f38523b
                r0.label = r3
                java.lang.Object r5 = r6.A(r2, r5, r0)
                if (r5 != r1) goto L41
                return r1
            L41:
                kotlin.z1 r5 = kotlin.z1.f38230a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1.AnonymousClass1.f(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__EmittersKt$transform$1(e<? extends T> eVar, ik.q<? super f<? super R>, ? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar, kotlin.coroutines.c<? super FlowKt__EmittersKt$transform$1> cVar) {
        super(2, cVar);
        this.$this_transform = eVar;
        this.$transform = qVar;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.c to kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1<R> for r3v1 'this'  kotlin.coroutines.c
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @yt.l
    public final java.lang.Object F0(@yt.k java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r4 = r3.L$0
            kotlinx.coroutines.flow.f r4 = (kotlinx.coroutines.flow.f) r4
            kotlinx.coroutines.flow.e<T> r0 = r3.$this_transform
            kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1 r1 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1
            ik.q<kotlinx.coroutines.flow.f<? super R>, T, kotlin.coroutines.c<? super kotlin.z1>, java.lang.Object> r2 = r3.$transform
            r1.<init>(r2, r4)
            r4 = 0
            kotlin.jvm.internal.c0.e(r4)
            r0.a(r1, r3)
            r4 = 1
            kotlin.jvm.internal.c0.e(r4)
            kotlin.z1 r4 = kotlin.z1.f38230a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1.F0(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        FlowKt__EmittersKt$transform$1 flowKt__EmittersKt$transform$1 = new FlowKt__EmittersKt$transform$1(this.$this_transform, this.$transform, cVar);
        flowKt__EmittersKt$transform$1.L$0 = obj;
        return flowKt__EmittersKt$transform$1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.c to kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1<R> for r5v1 'this'  kotlin.coroutines.c
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final java.lang.Object q0(@yt.k java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.u0.n(r6)
            goto L30
        Lf:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L17:
            kotlin.u0.n(r6)
            java.lang.Object r6 = r5.L$0
            kotlinx.coroutines.flow.f r6 = (kotlinx.coroutines.flow.f) r6
            kotlinx.coroutines.flow.e<T> r1 = r5.$this_transform
            kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1 r3 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1
            ik.q<kotlinx.coroutines.flow.f<? super R>, T, kotlin.coroutines.c<? super kotlin.z1>, java.lang.Object> r4 = r5.$transform
            r3.<init>(r4, r6)
            r5.label = r2
            java.lang.Object r6 = r1.a(r3, r5)
            if (r6 != r0) goto L30
            return r0
        L30:
            kotlin.z1 r6 = kotlin.z1.f38230a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k f<? super R> fVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((FlowKt__EmittersKt$transform$1) M(fVar, cVar)).q0(z1.f38230a);
    }
}
