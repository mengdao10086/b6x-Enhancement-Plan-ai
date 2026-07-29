package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nChannelCoroutine.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelCoroutine.kt\nkotlinx/coroutines/channels/ChannelCoroutine\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,41:1\n705#2,2:42\n705#2,2:44\n705#2,2:46\n*S KotlinDebug\n*F\n+ 1 ChannelCoroutine.kt\nkotlinx/coroutines/channels/ChannelCoroutine\n*L\n21#1:42,2\n26#1:44,2\n32#1:46,2\n*E\n"})
public class h<E> extends kotlinx.coroutines.a<z1> implements g<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final g<E> f38376d;

    public h(@yt.k CoroutineContext coroutineContext, @yt.k g<E> gVar, boolean z10, boolean z11) {
        super(coroutineContext, z10, z11);
        this.f38376d = gVar;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @yt.l
    public Object A(@yt.k kotlin.coroutines.c<? super E> cVar) {
        return this.f38376d.A(cVar);
    }

    public boolean C(@yt.l Throwable th2) {
        return this.f38376d.C(th2);
    }

    @yt.k
    public Object F(E e10) {
        return this.f38376d.F(e10);
    }

    @yt.l
    public Object G(E e10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return this.f38376d.G(e10, cVar);
    }

    @Override // kotlinx.coroutines.channels.s
    public boolean H() {
        return this.f38376d.H();
    }

    @yt.k
    public final g<E> J1() {
        return this.f38376d;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.c2
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        j0(new JobCancellationException(n0(), null, this));
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.c2
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean d(Throwable th2) {
        j0(new JobCancellationException(n0(), null, this));
        return true;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean e() {
        return this.f38376d.e();
    }

    @Override // kotlinx.coroutines.channels.s
    public void g(@yt.k ik.l<? super Throwable, z1> lVar) {
        this.f38376d.g(lVar);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.c2
    public final void h(@yt.l CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(n0(), null, this);
        }
        j0(cancellationException);
    }

    @yt.k
    public final g<E> i() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        return this.f38376d.isEmpty();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @yt.k
    public ChannelIterator<E> iterator() {
        return this.f38376d.iterator();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @yt.k
    public kotlinx.coroutines.selects.e<E> j() {
        return this.f38376d.j();
    }

    @Override // kotlinx.coroutines.JobSupport
    public void j0(@yt.k Throwable th2) {
        CancellationException cancellationExceptionW1 = JobSupport.w1(this, th2, null, 1, null);
        this.f38376d.h(cancellationExceptionW1);
        h0(cancellationExceptionW1);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @yt.k
    public kotlinx.coroutines.selects.e<j<E>> o() {
        return this.f38376d.o();
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @kotlin.t0(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e10) {
        return this.f38376d.offer(e10);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @kotlin.t0(expression = "tryReceive().getOrNull()", imports = {}))
    @yt.l
    public E poll() {
        return this.f38376d.poll();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @yt.k
    public kotlinx.coroutines.selects.e<E> q() {
        return this.f38376d.q();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @yt.k
    public Object s() {
        return this.f38376d.s();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @kotlin.t0(expression = "receiveCatching().getOrNull()", imports = {}))
    @yt.l
    @bk.h
    public Object t(@yt.k kotlin.coroutines.c<? super E> cVar) {
        return this.f38376d.t(cVar);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @yt.l
    public Object v(@yt.k kotlin.coroutines.c<? super j<? extends E>> cVar) {
        Object objV = this.f38376d.v(cVar);
        yj.b.h();
        return objV;
    }

    @yt.k
    public kotlinx.coroutines.selects.g<E, s<E>> y() {
        return this.f38376d.y();
    }
}
