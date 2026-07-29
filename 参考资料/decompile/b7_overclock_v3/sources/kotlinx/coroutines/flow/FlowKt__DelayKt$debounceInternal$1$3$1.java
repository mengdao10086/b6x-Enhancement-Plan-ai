package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$1\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n*L\n1#1,405:1\n18#2:406\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1$3$1\n*L\n232#1:406\n*E\n"})
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1", f = "Delay.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__DelayKt$debounceInternal$1$3$1 extends SuspendLambda implements ik.l<kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ f<T> $downstream;
    public final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1$3$1(f<? super T> fVar, Ref.ObjectRef<Object> objectRef, kotlin.coroutines.c<? super FlowKt__DelayKt$debounceInternal$1$3$1> cVar) {
        super(1, cVar);
        this.$downstream = fVar;
        this.$lastValue = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> T(@yt.k kotlin.coroutines.c<?> cVar) {
        return new FlowKt__DelayKt$debounceInternal$1$3$1(this.$downstream, this.$lastValue, cVar);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.c to kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1 for r5v1 'this'  kotlin.coroutines.c
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
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L18
            if (r1 != r3) goto L10
            kotlin.u0.n(r6)
            goto L2f
        L10:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L18:
            kotlin.u0.n(r6)
            kotlinx.coroutines.flow.f<T> r6 = r5.$downstream
            kotlinx.coroutines.internal.o0 r1 = kotlinx.coroutines.flow.internal.l.f38719a
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r4 = r5.$lastValue
            T r4 = r4.element
            if (r4 != r1) goto L26
            r4 = r2
        L26:
            r5.label = r3
            java.lang.Object r6 = r6.f(r4, r5)
            if (r6 != r0) goto L2f
            return r0
        L2f:
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r6 = r5.$lastValue
            r6.element = r2
            kotlin.z1 r6 = kotlin.z1.f38230a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.l
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object i(@yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$1) T(cVar)).q0(z1.f38230a);
    }
}
