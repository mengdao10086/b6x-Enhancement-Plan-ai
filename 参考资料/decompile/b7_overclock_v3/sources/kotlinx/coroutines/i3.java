package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public final class i3<U, T extends U> extends kotlinx.coroutines.internal.k0<T> implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @hk.e
    public final long f38756e;

    public i3(long j10, @yt.k kotlin.coroutines.c<? super U> cVar) {
        super(cVar.b(), cVar);
        this.f38756e = j10;
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.JobSupport
    @yt.k
    public String Z0() {
        return super.Z0() + "(timeMillis=" + this.f38756e + ')';
    }

    @Override // java.lang.Runnable
    public void run() {
        h0(TimeoutKt.a(this.f38756e, DelayKt.d(b()), this));
    }
}
