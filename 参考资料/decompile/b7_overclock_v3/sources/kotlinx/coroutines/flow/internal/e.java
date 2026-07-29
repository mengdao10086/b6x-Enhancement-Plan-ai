package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.u;
import kotlin.z1;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes5.dex */
public final class e<T> extends ChannelFlowOperator<T, T> {
    public /* synthetic */ e(kotlinx.coroutines.flow.e eVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, int i11, u uVar) {
        this(eVar, (i11 & 2) != 0 ? EmptyCoroutineContext.f37755a : coroutineContext, (i11 & 4) != 0 ? -3 : i10, (i11 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.k
    public ChannelFlow<T> h(@yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        return new e(this.f38683d, coroutineContext, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.k
    public kotlinx.coroutines.flow.e<T> i() {
        return (kotlinx.coroutines.flow.e<T>) this.f38683d;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    @yt.l
    public Object r(@yt.k kotlinx.coroutines.flow.f<? super T> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        Object objA = this.f38683d.a((kotlinx.coroutines.flow.f<? super S>) fVar, cVar);
        return objA == yj.b.h() ? objA : z1.f38230a;
    }

    public e(@yt.k kotlinx.coroutines.flow.e<? extends T> eVar, @yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        super(eVar, coroutineContext, i10, bufferOverflow);
    }
}
