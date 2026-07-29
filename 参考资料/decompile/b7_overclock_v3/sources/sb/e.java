package sb;

import hb.a0;
import hb.b0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements a0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f49583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f49584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f49585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f49586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f49587h;

    public e(c cVar, int i10, long j10, long j11) {
        this.f49583d = cVar;
        this.f49584e = i10;
        this.f49585f = j10;
        long j12 = (j11 - j10) / ((long) cVar.f49576e);
        this.f49586g = j12;
        this.f49587h = b(j12);
    }

    public final long b(long j10) {
        return u0.h1(j10 * ((long) this.f49584e), 1000000L, this.f49583d.f49574c);
    }

    @Override // hb.a0
    public boolean e() {
        return true;
    }

    @Override // hb.a0
    public a0.a g(long j10) {
        long jU = u0.u((((long) this.f49583d.f49574c) * j10) / (((long) this.f49584e) * 1000000), 0L, this.f49586g - 1);
        long j11 = this.f49585f + (((long) this.f49583d.f49576e) * jU);
        long jB = b(jU);
        b0 b0Var = new b0(jB, j11);
        if (jB >= j10 || jU == this.f49586g - 1) {
            return new a0.a(b0Var);
        }
        long j12 = jU + 1;
        return new a0.a(b0Var, new b0(b(j12), this.f49585f + (((long) this.f49583d.f49576e) * j12)));
    }

    @Override // hb.a0
    public long h() {
        return this.f49587h;
    }
}
