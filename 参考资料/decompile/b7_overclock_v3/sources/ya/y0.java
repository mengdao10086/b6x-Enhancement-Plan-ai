package ya;

import com.google.android.exoplayer2.source.l;

/* JADX INFO: loaded from: classes3.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l.a f57258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f57259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f57260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f57261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f57262e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f57263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f57264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f57265h;

    public y0(l.a aVar, long j10, long j11, long j12, long j13, boolean z10, boolean z11, boolean z12) {
        this.f57258a = aVar;
        this.f57259b = j10;
        this.f57260c = j11;
        this.f57261d = j12;
        this.f57262e = j13;
        this.f57263f = z10;
        this.f57264g = z11;
        this.f57265h = z12;
    }

    public y0 a(long j10) {
        return j10 == this.f57260c ? this : new y0(this.f57258a, this.f57259b, j10, this.f57261d, this.f57262e, this.f57263f, this.f57264g, this.f57265h);
    }

    public y0 b(long j10) {
        return j10 == this.f57259b ? this : new y0(this.f57258a, j10, this.f57260c, this.f57261d, this.f57262e, this.f57263f, this.f57264g, this.f57265h);
    }

    public boolean equals(@g.p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y0.class != obj.getClass()) {
            return false;
        }
        y0 y0Var = (y0) obj;
        return this.f57259b == y0Var.f57259b && this.f57260c == y0Var.f57260c && this.f57261d == y0Var.f57261d && this.f57262e == y0Var.f57262e && this.f57263f == y0Var.f57263f && this.f57264g == y0Var.f57264g && this.f57265h == y0Var.f57265h && hd.u0.c(this.f57258a, y0Var.f57258a);
    }

    public int hashCode() {
        return ((((((((((((((527 + this.f57258a.hashCode()) * 31) + ((int) this.f57259b)) * 31) + ((int) this.f57260c)) * 31) + ((int) this.f57261d)) * 31) + ((int) this.f57262e)) * 31) + (this.f57263f ? 1 : 0)) * 31) + (this.f57264g ? 1 : 0)) * 31) + (this.f57265h ? 1 : 0);
    }
}
