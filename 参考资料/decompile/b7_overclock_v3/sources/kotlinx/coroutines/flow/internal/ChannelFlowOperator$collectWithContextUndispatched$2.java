package kotlinx.coroutines.flow.internal;

import ik.p;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", i = {}, l = {rc.c.f48464l0}, m = "invokeSuspend", n = {}, s = {})
public final class ChannelFlowOperator$collectWithContextUndispatched$2<T> extends SuspendLambda implements p<kotlinx.coroutines.flow.f<? super T>, kotlin.coroutines.c<? super z1>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ChannelFlowOperator<S, T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlowOperator$collectWithContextUndispatched$2(ChannelFlowOperator<S, T> channelFlowOperator, kotlin.coroutines.c<? super ChannelFlowOperator$collectWithContextUndispatched$2> cVar) {
        super(2, cVar);
        this.this$0 = channelFlowOperator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        ChannelFlowOperator$collectWithContextUndispatched$2 channelFlowOperator$collectWithContextUndispatched$2 = new ChannelFlowOperator$collectWithContextUndispatched$2(this.this$0, cVar);
        channelFlowOperator$collectWithContextUndispatched$2.L$0 = obj;
        return channelFlowOperator$collectWithContextUndispatched$2;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.c to kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2<T> for r3v1 'this'  kotlin.coroutines.c
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final java.lang.Object q0(@yt.k java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r3.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.u0.n(r4)
            goto L29
        Lf:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L17:
            kotlin.u0.n(r4)
            java.lang.Object r4 = r3.L$0
            kotlinx.coroutines.flow.f r4 = (kotlinx.coroutines.flow.f) r4
            kotlinx.coroutines.flow.internal.ChannelFlowOperator<S, T> r1 = r3.this$0
            r3.label = r2
            java.lang.Object r4 = r1.r(r4, r3)
            if (r4 != r0) goto L29
            return r0
        L29:
            kotlin.z1 r4 = kotlin.z1.f38230a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlinx.coroutines.flow.f<? super T> fVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((ChannelFlowOperator$collectWithContextUndispatched$2) M(fVar, cVar)).q0(z1.f38230a);
    }
}
