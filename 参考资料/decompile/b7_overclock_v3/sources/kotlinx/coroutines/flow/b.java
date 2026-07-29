package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/flow/ChannelAsFlow\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,176:1\n1#2:177\n*E\n"})
public final class b<T> extends ChannelFlow<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final AtomicIntegerFieldUpdater f38667f = AtomicIntegerFieldUpdater.newUpdater(b.class, "consumed");

    @hk.v
    private volatile int consumed;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final ReceiveChannel<T> f38668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f38669e;

    public /* synthetic */ b(ReceiveChannel receiveChannel, boolean z10, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, int i11, kotlin.jvm.internal.u uVar) {
        this(receiveChannel, z10, (i11 & 4) != 0 ? EmptyCoroutineContext.f37755a : coroutineContext, (i11 & 8) != 0 ? -3 : i10, (i11 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.e
    @yt.l
    public Object a(@yt.k f<? super T> fVar, @yt.k kotlin.coroutines.c<? super z1> cVar) throws Throwable {
        if (this.f38675b != -3) {
            Object objA = super.a(fVar, cVar);
            return objA == yj.b.h() ? objA : z1.f38230a;
        }
        n();
        Object objE = FlowKt__ChannelsKt.e(fVar, this.f38668d, this.f38669e, cVar);
        return objE == yj.b.h() ? objE : z1.f38230a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.k
    public String d() {
        return "channel=" + this.f38668d;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.l
    public Object g(@yt.k kotlinx.coroutines.channels.q<? super T> qVar, @yt.k kotlin.coroutines.c<? super z1> cVar) throws Throwable {
        Object objE = FlowKt__ChannelsKt.e(new kotlinx.coroutines.flow.internal.m(qVar), this.f38668d, this.f38669e, cVar);
        return objE == yj.b.h() ? objE : z1.f38230a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.k
    public ChannelFlow<T> h(@yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        return new b(this.f38668d, this.f38669e, coroutineContext, i10, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.k
    public e<T> i() {
        return new b(this.f38668d, this.f38669e, null, 0, null, 28, null);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @yt.k
    public ReceiveChannel<T> m(@yt.k o0 o0Var) {
        n();
        return this.f38675b == -3 ? this.f38668d : super.m(o0Var);
    }

    public final void n() {
        if (this.f38669e) {
            if (!(f38667f.getAndSet(this, 1) == 0)) {
                throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@yt.k ReceiveChannel<? extends T> receiveChannel, boolean z10, @yt.k CoroutineContext coroutineContext, int i10, @yt.k BufferOverflow bufferOverflow) {
        super(coroutineContext, i10, bufferOverflow);
        this.f38668d = receiveChannel;
        this.f38669e = z10;
        this.consumed = 0;
    }
}
