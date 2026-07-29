package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.t0;
import kotlin.z1;
import kotlinx.coroutines.r2;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.k(level = DeprecationLevel.WARNING, message = "ConflatedBroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
@r2
public final class m<E> implements d<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final BroadcastChannelImpl<E> f38384a;

    public m(BroadcastChannelImpl<E> broadcastChannelImpl) {
        this.f38384a = broadcastChannelImpl;
    }

    @Override // kotlinx.coroutines.channels.s
    public boolean C(@yt.l Throwable th2) {
        return this.f38384a.C(th2);
    }

    @Override // kotlinx.coroutines.channels.d
    @yt.k
    public ReceiveChannel<E> E() {
        return this.f38384a.E();
    }

    @Override // kotlinx.coroutines.channels.s
    @yt.k
    public Object F(E e10) {
        return this.f38384a.F(e10);
    }

    @Override // kotlinx.coroutines.channels.s
    @yt.l
    public Object G(E e10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return this.f38384a.G(e10, cVar);
    }

    @Override // kotlinx.coroutines.channels.s
    public boolean H() {
        return this.f38384a.H();
    }

    public final E a() {
        return this.f38384a.M1();
    }

    @yt.l
    public final E b() {
        return this.f38384a.O1();
    }

    @Override // kotlinx.coroutines.channels.d
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Binary compatibility only")
    public /* synthetic */ boolean d(Throwable th2) {
        return this.f38384a.d(th2);
    }

    @Override // kotlinx.coroutines.channels.s
    public void g(@yt.k ik.l<? super Throwable, z1> lVar) {
        this.f38384a.g(lVar);
    }

    @Override // kotlinx.coroutines.channels.d
    public void h(@yt.l CancellationException cancellationException) {
        this.f38384a.h(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.s
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @t0(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e10) {
        return this.f38384a.offer(e10);
    }

    @Override // kotlinx.coroutines.channels.s
    @yt.k
    public kotlinx.coroutines.selects.g<E, s<E>> y() {
        return this.f38384a.y();
    }

    public m() {
        this(new BroadcastChannelImpl(-1));
    }

    public m(E e10) {
        this();
        F(e10);
    }
}
