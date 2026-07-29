package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.u;
import kotlin.z1;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.q;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.sync.SemaphoreKt;

/* JADX INFO: loaded from: classes5.dex */
public final class ChannelFlowMerge<T> extends ChannelFlow<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final kotlinx.coroutines.flow.e<kotlinx.coroutines.flow.e<T>> f38677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f38678e;

    public /* synthetic */ ChannelFlowMerge(kotlinx.coroutines.flow.e eVar, int i10, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow, int i12, u uVar) {
        this(eVar, i10, (i12 & 4) != 0 ? EmptyCoroutineContext.f37755a : coroutineContext, (i12 & 8) != 0 ? -2 : i11, (i12 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.k
    public String d() {
        return "concurrency=" + this.f38678e;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.l
    public Object g(@yt.k q<? super T> qVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Object objA = this.f38677d.a(new ChannelFlowMerge$collectTo$2((c2) cVar.b().c(c2.f38296x2), SemaphoreKt.b(this.f38678e, 0, 2, null), qVar, new m(qVar)), cVar);
        return objA == yj.b.h() ? objA : z1.f38230a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.k
    public ChannelFlow<T> h(@yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        return new ChannelFlowMerge(this.f38677d, this.f38678e, coroutineContext, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.k
    public ReceiveChannel<T> m(@yt.k o0 o0Var) {
        return ProduceKt.c(o0Var, this.f38674a, this.f38675b, j());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowMerge(@yt.k kotlinx.coroutines.flow.e<? extends kotlinx.coroutines.flow.e<? extends T>> eVar, int i10, @yt.k CoroutineContext coroutineContext, int i11, @yt.k BufferOverflow bufferOverflow) {
        super(coroutineContext, i11, bufferOverflow);
        this.f38677d = eVar;
        this.f38678e = i10;
    }
}
