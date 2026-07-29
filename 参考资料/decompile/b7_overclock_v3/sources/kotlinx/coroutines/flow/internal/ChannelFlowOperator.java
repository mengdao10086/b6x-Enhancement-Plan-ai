package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.internal.f0;
import kotlin.z1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.q;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hk.e
    @yt.k
    public final kotlinx.coroutines.flow.e<S> f38683d;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(@yt.k kotlinx.coroutines.flow.e<? extends S> eVar, @yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        super(coroutineContext, i10, bufferOverflow);
        this.f38683d = eVar;
    }

    public static /* synthetic */ <S, T> Object o(ChannelFlowOperator<S, T> channelFlowOperator, kotlinx.coroutines.flow.f<? super T> fVar, kotlin.coroutines.c<? super z1> cVar) {
        if (channelFlowOperator.f38675b == -3) {
            CoroutineContext coroutineContextB = cVar.b();
            CoroutineContext coroutineContextL = coroutineContextB.L(channelFlowOperator.f38674a);
            if (f0.g(coroutineContextL, coroutineContextB)) {
                Object objR = channelFlowOperator.r(fVar, cVar);
                return objR == yj.b.h() ? objR : z1.f38230a;
            }
            d.b bVar = kotlin.coroutines.d.f37759u2;
            if (f0.g(coroutineContextL.c(bVar), coroutineContextB.c(bVar))) {
                Object objQ = channelFlowOperator.q(fVar, coroutineContextL, cVar);
                return objQ == yj.b.h() ? objQ : z1.f38230a;
            }
        }
        Object objA = super.a(fVar, cVar);
        return objA == yj.b.h() ? objA : z1.f38230a;
    }

    public static /* synthetic */ <S, T> Object p(ChannelFlowOperator<S, T> channelFlowOperator, q<? super T> qVar, kotlin.coroutines.c<? super z1> cVar) {
        Object objR = channelFlowOperator.r(new m(qVar), cVar);
        return objR == yj.b.h() ? objR : z1.f38230a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.e
    @yt.l
    public Object a(@yt.k kotlinx.coroutines.flow.f<? super T> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return o(this, fVar, cVar);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.l
    public Object g(@yt.k q<? super T> qVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return p(this, qVar, cVar);
    }

    public final Object q(kotlinx.coroutines.flow.f<? super T> fVar, CoroutineContext coroutineContext, kotlin.coroutines.c<? super z1> cVar) {
        Object objD = d.d(coroutineContext, d.e(fVar, cVar.b()), null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), cVar, 4, null);
        return objD == yj.b.h() ? objD : z1.f38230a;
    }

    @yt.l
    public abstract Object r(@yt.k kotlinx.coroutines.flow.f<? super T> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.k
    public String toString() {
        return this.f38683d + " -> " + super.toString();
    }
}
