package kotlinx.coroutines.flow.internal;

import java.util.Iterator;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.q;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,100:1\n1855#2,2:101\n*S KotlinDebug\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge\n*L\n95#1:101,2\n*E\n"})
public final class ChannelLimitedFlowMerge<T> extends ChannelFlow<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final Iterable<kotlinx.coroutines.flow.e<T>> f38689d;

    public /* synthetic */ ChannelLimitedFlowMerge(Iterable iterable, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, int i11, u uVar) {
        this(iterable, (i11 & 2) != 0 ? EmptyCoroutineContext.f37755a : coroutineContext, (i11 & 4) != 0 ? -2 : i10, (i11 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.l
    public Object g(@yt.k q<? super T> qVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        m mVar = new m(qVar);
        Iterator<kotlinx.coroutines.flow.e<T>> it2 = this.f38689d.iterator();
        while (it2.hasNext()) {
            kotlinx.coroutines.j.f(qVar, null, null, new ChannelLimitedFlowMerge$collectTo$2$1(it2.next(), mVar, null), 3, null);
        }
        return z1.f38230a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.k
    public ChannelFlow<T> h(@yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        return new ChannelLimitedFlowMerge(this.f38689d, coroutineContext, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.k
    public ReceiveChannel<T> m(@yt.k o0 o0Var) {
        return ProduceKt.c(o0Var, this.f38674a, this.f38675b, j());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelLimitedFlowMerge(@yt.k Iterable<? extends kotlinx.coroutines.flow.e<? extends T>> iterable, @yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        super(coroutineContext, i10, bufferOverflow);
        this.f38689d = iterable;
    }
}
