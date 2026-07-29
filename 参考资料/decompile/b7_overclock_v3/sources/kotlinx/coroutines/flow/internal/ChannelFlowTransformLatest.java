package kotlinx.coroutines.flow.internal;

import ik.q;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.p0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/internal/ChannelFlowTransformLatest\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n1#2:101\n*E\n"})
public final class ChannelFlowTransformLatest<T, R> extends ChannelFlowOperator<T, R> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final q<kotlinx.coroutines.flow.f<? super R>, T, kotlin.coroutines.c<? super z1>, Object> f38684e;

    public /* synthetic */ ChannelFlowTransformLatest(q qVar, kotlinx.coroutines.flow.e eVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, int i11, u uVar) {
        this(qVar, eVar, (i11 & 4) != 0 ? EmptyCoroutineContext.f37755a : coroutineContext, (i11 & 8) != 0 ? -2 : i10, (i11 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.k
    public ChannelFlow<R> h(@yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        return new ChannelFlowTransformLatest(this.f38684e, this.f38683d, coroutineContext, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    @yt.l
    public Object r(@yt.k kotlinx.coroutines.flow.f<? super R> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Object objG = p0.g(new ChannelFlowTransformLatest$flowCollect$3(this, fVar, null), cVar);
        return objG == yj.b.h() ? objG : z1.f38230a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest(@yt.k q<? super kotlinx.coroutines.flow.f<? super R>, ? super T, ? super kotlin.coroutines.c<? super z1>, ? extends Object> qVar, @yt.k kotlinx.coroutines.flow.e<? extends T> eVar, @yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        super(eVar, coroutineContext, i10, bufferOverflow);
        this.f38684e = qVar;
    }
}
