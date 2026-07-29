package hc;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hb.e f30940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f30941c;

    public g(hb.e eVar, long j10) {
        this.f30940b = eVar;
        this.f30941c = j10;
    }

    @Override // hc.e
    public long a(long j10) {
        return this.f30940b.f30830h[(int) j10] - this.f30941c;
    }

    @Override // hc.e
    public long b(long j10, long j11) {
        return this.f30940b.f30829g[(int) j10];
    }

    @Override // hc.e
    public long c(long j10, long j11) {
        return 0L;
    }

    @Override // hc.e
    public long d(long j10, long j11) {
        return ya.g.f56663b;
    }

    @Override // hc.e
    public ic.h e(long j10) {
        return new ic.h(null, this.f30940b.f30828f[(int) j10], r0.f30827e[r9]);
    }

    @Override // hc.e
    public long f(long j10, long j11) {
        return this.f30940b.b(j10 + this.f30941c);
    }

    @Override // hc.e
    public boolean g() {
        return true;
    }

    @Override // hc.e
    public long h() {
        return 0L;
    }

    @Override // hc.e
    public int i(long j10) {
        return this.f30940b.f30826d;
    }

    @Override // hc.e
    public int j(long j10, long j11) {
        return this.f30940b.f30826d;
    }
}
