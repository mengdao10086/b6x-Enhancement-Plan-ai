package hb;

import hb.a0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public class f implements a0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f30836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f30837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f30838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f30839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f30840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f30841i;

    public f(long j10, long j11, int i10, int i11) {
        this.f30836d = j10;
        this.f30837e = j11;
        this.f30838f = i11 == -1 ? 1 : i11;
        this.f30840h = i10;
        if (j10 == -1) {
            this.f30839g = -1L;
            this.f30841i = ya.g.f56663b;
        } else {
            this.f30839g = j10 - j11;
            this.f30841i = f(j10, j11, i10);
        }
    }

    public static long f(long j10, long j11, int i10) {
        return ((Math.max(0L, j10 - j11) * 8) * 1000000) / ((long) i10);
    }

    public final long b(long j10) {
        long j11 = (j10 * ((long) this.f30840h)) / 8000000;
        int i10 = this.f30838f;
        return this.f30837e + u0.u((j11 / ((long) i10)) * ((long) i10), 0L, this.f30839g - ((long) i10));
    }

    public long c(long j10) {
        return f(j10, this.f30837e, this.f30840h);
    }

    @Override // hb.a0
    public boolean e() {
        return this.f30839g != -1;
    }

    @Override // hb.a0
    public a0.a g(long j10) {
        if (this.f30839g == -1) {
            return new a0.a(new b0(0L, this.f30837e));
        }
        long jB = b(j10);
        long jC = c(jB);
        b0 b0Var = new b0(jC, jB);
        if (jC < j10) {
            int i10 = this.f30838f;
            if (((long) i10) + jB < this.f30836d) {
                long j11 = jB + ((long) i10);
                return new a0.a(b0Var, new b0(c(j11), j11));
            }
        }
        return new a0.a(b0Var);
    }

    @Override // hb.a0
    public long h() {
        return this.f30841i;
    }
}
