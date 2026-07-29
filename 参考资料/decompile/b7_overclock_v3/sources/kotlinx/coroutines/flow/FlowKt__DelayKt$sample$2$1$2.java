package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$2\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,405:1\n18#2:406\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$sample$2$1$2\n*L\n299#1:406\n*E\n"})
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$2", f = "Delay.kt", i = {}, l = {299}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__DelayKt$sample$2$1$2 extends SuspendLambda implements ik.p<z1, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ f<T> $downstream;
    public final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$sample$2$1$2(Ref.ObjectRef<Object> objectRef, f<? super T> fVar, kotlin.coroutines.c<? super FlowKt__DelayKt$sample$2$1$2> cVar) {
        super(2, cVar);
        this.$lastValue = objectRef;
        this.$downstream = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        return new FlowKt__DelayKt$sample$2$1$2(this.$lastValue, this.$downstream, cVar);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.c to kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$2 for r5v1 'this'  kotlin.coroutines.c
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
            goto L36
        Lf:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L17:
            kotlin.u0.n(r6)
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r6 = r5.$lastValue
            T r1 = r6.element
            if (r1 != 0) goto L23
            kotlin.z1 r6 = kotlin.z1.f38230a
            return r6
        L23:
            r3 = 0
            r6.element = r3
            kotlinx.coroutines.flow.f<T> r6 = r5.$downstream
            kotlinx.coroutines.internal.o0 r4 = kotlinx.coroutines.flow.internal.l.f38719a
            if (r1 != r4) goto L2d
            r1 = r3
        L2d:
            r5.label = r2
            java.lang.Object r6 = r6.f(r1, r5)
            if (r6 != r0) goto L36
            return r0
        L36:
            kotlin.z1 r6 = kotlin.z1.f38230a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$1$2.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k z1 z1Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((FlowKt__DelayKt$sample$2$1$2) M(z1Var, cVar)).q0(z1.f38230a);
    }
}
