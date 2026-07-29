package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.DeprecationLevel;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nBroadcast.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastCoroutine\n+ 2 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n1#1,202:1\n705#2,2:203\n705#2,2:205\n*S KotlinDebug\n*F\n+ 1 Broadcast.kt\nkotlinx/coroutines/channels/BroadcastCoroutine\n*L\n152#1:203,2\n157#1:205,2\n*E\n"})
public class f<E> extends kotlinx.coroutines.a<z1> implements q<E>, d<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final d<E> f38365d;

    public f(@yt.k CoroutineContext coroutineContext, @yt.k d<E> dVar, boolean z10) {
        super(coroutineContext, false, z10);
        this.f38365d = dVar;
        N0((c2) coroutineContext.c(c2.f38296x2));
    }

    @Override // kotlinx.coroutines.channels.s
    public boolean C(@yt.l Throwable th2) {
        boolean zC = this.f38365d.C(th2);
        start();
        return zC;
    }

    @Override // kotlinx.coroutines.channels.d
    @yt.k
    public ReceiveChannel<E> E() {
        return this.f38365d.E();
    }

    @Override // kotlinx.coroutines.channels.s
    @yt.k
    public Object F(E e10) {
        return this.f38365d.F(e10);
    }

    @Override // kotlinx.coroutines.channels.s
    @yt.l
    public Object G(E e10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        return this.f38365d.G(e10, cVar);
    }

    @Override // kotlinx.coroutines.a
    public void G1(@yt.k Throwable th2, boolean z10) {
        if (this.f38365d.C(th2) || z10) {
            return;
        }
        l0.b(b(), th2);
    }

    @Override // kotlinx.coroutines.channels.s
    public boolean H() {
        return this.f38365d.H();
    }

    @yt.k
    public final d<E> J1() {
        return this.f38365d;
    }

    @Override // kotlinx.coroutines.a
    /* JADX INFO: renamed from: K1, reason: merged with bridge method [inline-methods] */
    public void H1(@yt.k z1 z1Var) {
        s.a.a(this.f38365d, null, 1, null);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.c2
    @kotlin.k(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean d(Throwable th2) {
        if (th2 == null) {
            th2 = new JobCancellationException(n0(), null, this);
        }
        j0(th2);
        return true;
    }

    @Override // kotlinx.coroutines.channels.s
    public void g(@yt.k ik.l<? super Throwable, z1> lVar) {
        this.f38365d.g(lVar);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.c2
    public final void h(@yt.l CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(n0(), null, this);
        }
        j0(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.q
    @yt.k
    public s<E> i() {
        return this;
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.JobSupport, kotlinx.coroutines.c2
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.JobSupport
    public void j0(@yt.k Throwable th2) {
        CancellationException cancellationExceptionW1 = JobSupport.w1(this, th2, null, 1, null);
        this.f38365d.h(cancellationExceptionW1);
        h0(cancellationExceptionW1);
    }

    @Override // kotlinx.coroutines.channels.s
    @kotlin.k(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @kotlin.t0(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e10) {
        return this.f38365d.offer(e10);
    }

    @Override // kotlinx.coroutines.channels.s
    @yt.k
    public kotlinx.coroutines.selects.g<E, s<E>> y() {
        return this.f38365d.y();
    }
}
