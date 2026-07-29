package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes5.dex */
public final class s extends c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final AtomicIntegerFieldUpdater f38947c = AtomicIntegerFieldUpdater.newUpdater(s.class, "_resumed");

    @hk.v
    private volatile int _resumed;

    public s(@yt.k kotlin.coroutines.c<?> cVar, @yt.l Throwable th2, boolean z10) {
        if (th2 == null) {
            th2 = new CancellationException("Continuation " + cVar + " was cancelled normally");
        }
        super(th2, z10);
        this._resumed = 0;
    }

    public final boolean c() {
        return f38947c.compareAndSet(this, 0, 1);
    }
}
