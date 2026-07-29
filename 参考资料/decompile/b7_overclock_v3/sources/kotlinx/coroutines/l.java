package kotlinx.coroutines;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes5.dex */
public final class l extends i2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final Future<?> f38895e;

    public l(@yt.k Future<?> future) {
        this.f38895e = future;
    }

    @Override // kotlinx.coroutines.e0
    public void R(@yt.l Throwable th2) {
        if (th2 != null) {
            this.f38895e.cancel(false);
        }
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
        R(th2);
        return kotlin.z1.f38230a;
    }
}
