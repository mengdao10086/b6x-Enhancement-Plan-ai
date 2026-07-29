package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes5.dex */
public final class a2 extends d2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final AtomicIntegerFieldUpdater f38267f = AtomicIntegerFieldUpdater.newUpdater(a2.class, "_invoked");

    @hk.v
    private volatile int _invoked;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final ik.l<Throwable, kotlin.z1> f38268e;

    /* JADX WARN: Multi-variable type inference failed */
    public a2(@yt.k ik.l<? super Throwable, kotlin.z1> lVar) {
        this.f38268e = lVar;
    }

    @Override // kotlinx.coroutines.e0
    public void R(@yt.l Throwable th2) {
        if (f38267f.compareAndSet(this, 0, 1)) {
            this.f38268e.i(th2);
        }
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
        R(th2);
        return kotlin.z1.f38230a;
    }
}
