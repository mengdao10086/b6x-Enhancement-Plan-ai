package kotlinx.coroutines.flow.internal;

import ik.p;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.channels.q;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
public final class ChannelFlow$collectToFun$1<T> extends SuspendLambda implements p<q<? super T>, kotlin.coroutines.c<? super z1>, Object> {
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ChannelFlow<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelFlow$collectToFun$1(ChannelFlow<T> channelFlow, kotlin.coroutines.c<? super ChannelFlow$collectToFun$1> cVar) {
        super(2, cVar);
        this.this$0 = channelFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        ChannelFlow$collectToFun$1 channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1(this.this$0, cVar);
        channelFlow$collectToFun$1.L$0 = obj;
        return channelFlow$collectToFun$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            q<? super T> qVar = (q) this.L$0;
            ChannelFlow<T> channelFlow = this.this$0;
            this.label = 1;
            if (channelFlow.g(qVar, this) == objH) {
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
    public final Object r0(@yt.k q<? super T> qVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((ChannelFlow$collectToFun$1) M(qVar, cVar)).q0(z1.f38230a);
    }
}
