package kotlinx.coroutines.flow.internal;

import ik.p;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
public final class ChannelFlow$collect$2 extends SuspendLambda implements p<o0, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ kotlinx.coroutines.flow.f<T> $collector;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ChannelFlow<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlow$collect$2(kotlinx.coroutines.flow.f<? super T> fVar, ChannelFlow<T> channelFlow, kotlin.coroutines.c<? super ChannelFlow$collect$2> cVar) {
        super(2, cVar);
        this.$collector = fVar;
        this.this$0 = channelFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        ChannelFlow$collect$2 channelFlow$collect$2 = new ChannelFlow$collect$2(this.$collector, this.this$0, cVar);
        channelFlow$collect$2.L$0 = obj;
        return channelFlow$collect$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            o0 o0Var = (o0) this.L$0;
            kotlinx.coroutines.flow.f<T> fVar = this.$collector;
            ReceiveChannel receiveChannelM = this.this$0.m(o0Var);
            this.label = 1;
            if (kotlinx.coroutines.flow.g.l0(fVar, receiveChannelM, this) == objH) {
                return objH;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u0.n(obj);
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((ChannelFlow$collect$2) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
