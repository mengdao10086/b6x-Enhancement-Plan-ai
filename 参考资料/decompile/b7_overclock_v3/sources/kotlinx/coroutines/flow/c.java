package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.z1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: loaded from: classes5.dex */
public class c<T> extends ChannelFlow<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final ik.p<kotlinx.coroutines.channels.q<? super T>, kotlin.coroutines.c<? super z1>, Object> f38670d;

    public /* synthetic */ c(ik.p pVar, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, int i11, kotlin.jvm.internal.u uVar) {
        this(pVar, (i11 & 2) != 0 ? EmptyCoroutineContext.f37755a : coroutineContext, (i11 & 4) != 0 ? -2 : i10, (i11 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    public static /* synthetic */ <T> Object n(c<T> cVar, kotlinx.coroutines.channels.q<? super T> qVar, kotlin.coroutines.c<? super z1> cVar2) {
        Object objR0 = cVar.f38670d.r0(qVar, cVar2);
        return objR0 == yj.b.h() ? objR0 : z1.f38230a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.l
    public Object g(@yt.k kotlinx.coroutines.channels.q<? super T> qVar, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return n(this, qVar, cVar);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.k
    public ChannelFlow<T> h(@yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        return new c(this.f38670d, coroutineContext, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.k
    public String toString() {
        return "block[" + this.f38670d + "] -> " + super.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@yt.k ik.p<? super kotlinx.coroutines.channels.q<? super T>, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar, @yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        super(coroutineContext, i10, bufferOverflow);
        this.f38670d = pVar;
    }
}
