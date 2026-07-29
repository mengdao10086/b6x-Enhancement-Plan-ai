package gc;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f29140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f29141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f29142d;

    public b(long j10, long j11) {
        this.f29140b = j10;
        this.f29141c = j11;
        reset();
    }

    @Override // gc.n
    public boolean b() {
        return this.f29142d > this.f29141c;
    }

    public final void e() {
        long j10 = this.f29142d;
        if (j10 < this.f29140b || j10 > this.f29141c) {
            throw new NoSuchElementException();
        }
    }

    public final long f() {
        return this.f29142d;
    }

    @Override // gc.n
    public boolean next() {
        this.f29142d++;
        return !b();
    }

    @Override // gc.n
    public void reset() {
        this.f29142d = this.f29140b - 1;
    }
}
