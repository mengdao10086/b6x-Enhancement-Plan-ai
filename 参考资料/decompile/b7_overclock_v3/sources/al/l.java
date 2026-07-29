package al;

import kotlinx.coroutines.r0;

/* JADX INFO: loaded from: classes5.dex */
public final class l extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    @yt.k
    public final Runnable f748c;

    public l(@yt.k Runnable runnable, long j10, @yt.k j jVar) {
        super(j10, jVar);
        this.f748c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f748c.run();
        } finally {
            this.f746b.W();
        }
    }

    @yt.k
    public String toString() {
        return "Task[" + r0.a(this.f748c) + '@' + r0.b(this.f748c) + ", " + this.f745a + ", " + this.f746b + ']';
    }
}
