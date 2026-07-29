package ya;

/* JADX INFO: loaded from: classes3.dex */
public final class t1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t1 f57070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final t1 f57071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final t1 f57072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final t1 f57073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final t1 f57074g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f57075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f57076b;

    static {
        t1 t1Var = new t1(0L, 0L);
        f57070c = t1Var;
        f57071d = new t1(Long.MAX_VALUE, Long.MAX_VALUE);
        f57072e = new t1(Long.MAX_VALUE, 0L);
        f57073f = new t1(0L, Long.MAX_VALUE);
        f57074g = t1Var;
    }

    public t1(long j10, long j11) {
        hd.a.a(j10 >= 0);
        hd.a.a(j11 >= 0);
        this.f57075a = j10;
        this.f57076b = j11;
    }

    public long a(long j10, long j11, long j12) {
        long j13 = this.f57075a;
        if (j13 == 0 && this.f57076b == 0) {
            return j10;
        }
        long jR1 = hd.u0.r1(j10, j13, Long.MIN_VALUE);
        long jB = hd.u0.b(j10, this.f57076b, Long.MAX_VALUE);
        boolean z10 = jR1 <= j11 && j11 <= jB;
        boolean z11 = jR1 <= j12 && j12 <= jB;
        return (z10 && z11) ? Math.abs(j11 - j10) <= Math.abs(j12 - j10) ? j11 : j12 : z10 ? j11 : z11 ? j12 : jR1;
    }

    public boolean equals(@g.p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t1.class != obj.getClass()) {
            return false;
        }
        t1 t1Var = (t1) obj;
        return this.f57075a == t1Var.f57075a && this.f57076b == t1Var.f57076b;
    }

    public int hashCode() {
        return (((int) this.f57075a) * 31) + ((int) this.f57076b);
    }
}
