package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes5.dex */
public class c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final AtomicIntegerFieldUpdater f38293b = AtomicIntegerFieldUpdater.newUpdater(c0.class, "_handled");

    @hk.v
    private volatile int _handled;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public final Throwable f38294a;

    public c0(@yt.k Throwable th2, boolean z10) {
        this.f38294a = th2;
        this._handled = z10 ? 1 : 0;
    }

    public final boolean a() {
        return f38293b.get(this) != 0;
    }

    public final boolean b() {
        return f38293b.compareAndSet(this, 0, 1);
    }

    @yt.k
    public String toString() {
        return r0.a(this) + '[' + this.f38294a + ']';
    }

    public /* synthetic */ c0(Throwable th2, boolean z10, int i10, kotlin.jvm.internal.u uVar) {
        this(th2, (i10 & 2) != 0 ? false : z10);
    }
}
