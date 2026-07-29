package kotlinx.coroutines;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes5.dex */
public final class k extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Future<?> f38887a;

    public k(@yt.k Future<?> future) {
        this.f38887a = future;
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
        s(th2);
        return kotlin.z1.f38230a;
    }

    @Override // kotlinx.coroutines.n
    public void s(@yt.l Throwable th2) {
        if (th2 != null) {
            this.f38887a.cancel(false);
        }
    }

    @yt.k
    public String toString() {
        return "CancelFutureOnCancel[" + this.f38887a + ']';
    }
}
