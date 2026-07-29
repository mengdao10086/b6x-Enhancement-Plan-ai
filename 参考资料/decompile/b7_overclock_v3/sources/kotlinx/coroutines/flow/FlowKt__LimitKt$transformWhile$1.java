package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$transformWhile$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,141:1\n126#2,15:142\n*S KotlinDebug\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$transformWhile$1\n*L\n119#1:142,15\n*E\n"})
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1", f = "Limit.kt", i = {0}, l = {rc.c.f48464l0}, m = "invokeSuspend", n = {"collector$iv"}, s = {"L$0"})
public final class FlowKt__LimitKt$transformWhile$1<R> extends SuspendLambda implements ik.p<f<? super R>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ e<T> $this_transformWhile;
    public final /* synthetic */ ik.q<f<? super R>, T, kotlin.coroutines.c<? super Boolean>, Object> $transform;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$transformWhile$1(e<? extends T> eVar, ik.q<? super f<? super R>, ? super T, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> qVar, kotlin.coroutines.c<? super FlowKt__LimitKt$transformWhile$1> cVar) {
        super(2, cVar);
        this.$this_transformWhile = eVar;
        this.$transform = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        FlowKt__LimitKt$transformWhile$1 flowKt__LimitKt$transformWhile$1 = new FlowKt__LimitKt$transformWhile$1(this.$this_transformWhile, this.$transform, cVar);
        flowKt__LimitKt$transformWhile$1.L$0 = obj;
        return flowKt__LimitKt$transformWhile$1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.c to kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1<R> for r5v1 'this'  kotlin.coroutines.c
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
            if (r1 == 0) goto L1d
            if (r1 != r2) goto L15
            java.lang.Object r0 = r5.L$0
            kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1) r0
            kotlin.u0.n(r6)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L13
            goto L3d
        L13:
            r6 = move-exception
            goto L3a
        L15:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1d:
            kotlin.u0.n(r6)
            java.lang.Object r6 = r5.L$0
            kotlinx.coroutines.flow.f r6 = (kotlinx.coroutines.flow.f) r6
            kotlinx.coroutines.flow.e<T> r1 = r5.$this_transformWhile
            ik.q<kotlinx.coroutines.flow.f<? super R>, T, kotlin.coroutines.c<? super java.lang.Boolean>, java.lang.Object> r3 = r5.$transform
            kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 r4 = new kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1
            r4.<init>(r3, r6)
            r5.L$0 = r4     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L38
            r5.label = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L38
            java.lang.Object r6 = r1.a(r4, r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L38
            if (r6 != r0) goto L3d
            return r0
        L38:
            r6 = move-exception
            r0 = r4
        L3a:
            kotlinx.coroutines.flow.internal.h.b(r6, r0)
        L3d:
            kotlin.z1 r6 = kotlin.z1.f38230a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k f<? super R> fVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((FlowKt__LimitKt$transformWhile$1) M(fVar, cVar)).q0(z1.f38230a);
    }
}
