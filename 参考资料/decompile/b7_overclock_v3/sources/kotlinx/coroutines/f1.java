package kotlinx.coroutines;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes5.dex */
public final class f1 implements g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Future<?> f38475a;

    public f1(@yt.k Future<?> future) {
        this.f38475a = future;
    }

    @Override // kotlinx.coroutines.g1
    public void dispose() {
        this.f38475a.cancel(false);
    }

    @yt.k
    public String toString() {
        return "DisposableFutureHandle[" + this.f38475a + ']';
    }
}
