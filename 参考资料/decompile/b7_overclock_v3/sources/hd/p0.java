package hd;

/* JADX INFO: loaded from: classes3.dex */
public final class p0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f31114e = Long.MAX_VALUE;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f31115f = 8589934592L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.b0("this")
    public boolean f31116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.b0("this")
    public long f31117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.b0("this")
    public long f31118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.b0("this")
    public long f31119d = ya.g.f56663b;

    public p0(long j10) {
        this.f31117b = j10;
    }

    public static long f(long j10) {
        return (j10 * 1000000) / 90000;
    }

    public static long i(long j10) {
        return (j10 * 90000) / 1000000;
    }

    public static long j(long j10) {
        return i(j10) % 8589934592L;
    }

    public synchronized long a(long j10) {
        if (j10 == ya.g.f56663b) {
            return ya.g.f56663b;
        }
        if (this.f31119d != ya.g.f56663b) {
            this.f31119d = j10;
        } else {
            long j11 = this.f31117b;
            if (j11 != Long.MAX_VALUE) {
                this.f31118c = j11 - j10;
            }
            this.f31119d = j10;
            notifyAll();
        }
        return j10 + this.f31118c;
    }

    public synchronized long b(long j10) {
        if (j10 == ya.g.f56663b) {
            return ya.g.f56663b;
        }
        long j11 = this.f31119d;
        if (j11 != ya.g.f56663b) {
            long jI = i(j11);
            long j12 = (4294967296L + jI) / 8589934592L;
            long j13 = ((j12 - 1) * 8589934592L) + j10;
            j10 += j12 * 8589934592L;
            if (Math.abs(j13 - jI) < Math.abs(j10 - jI)) {
                j10 = j13;
            }
        }
        return a(f(j10));
    }

    public synchronized long c() {
        return this.f31117b;
    }

    public synchronized long d() {
        long j10;
        long j11 = this.f31119d;
        j10 = ya.g.f56663b;
        if (j11 != ya.g.f56663b) {
            j10 = this.f31118c + j11;
        } else {
            long j12 = this.f31117b;
            if (j12 != Long.MAX_VALUE) {
                j10 = j12;
            }
        }
        return j10;
    }

    public synchronized long e() {
        long j10;
        long j11 = this.f31117b;
        j10 = ya.g.f56663b;
        if (j11 == Long.MAX_VALUE) {
            j10 = 0;
        } else if (this.f31119d != ya.g.f56663b) {
            j10 = this.f31118c;
        }
        return j10;
    }

    public synchronized void g(long j10) {
        this.f31117b = j10;
        this.f31119d = ya.g.f56663b;
        this.f31116a = false;
    }

    public synchronized void h(boolean z10, long j10) throws InterruptedException {
        if (z10) {
            try {
                if (!this.f31116a) {
                    this.f31117b = j10;
                    this.f31116a = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (!z10 || j10 != this.f31117b) {
            while (this.f31119d == ya.g.f56663b) {
                wait();
            }
        }
    }
}
