package ya;

/* JADX INFO: loaded from: classes3.dex */
public final class h1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h1 f56784d = new h1(1.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f56785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f56786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f56787c;

    public h1(float f10) {
        this(f10, 1.0f);
    }

    public long a(long j10) {
        return j10 * ((long) this.f56787c);
    }

    @g.j
    public h1 b(float f10) {
        return new h1(f10, this.f56786b);
    }

    public boolean equals(@g.p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h1.class != obj.getClass()) {
            return false;
        }
        h1 h1Var = (h1) obj;
        return this.f56785a == h1Var.f56785a && this.f56786b == h1Var.f56786b;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.f56785a)) * 31) + Float.floatToRawIntBits(this.f56786b);
    }

    public String toString() {
        return hd.u0.I("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f56785a), Float.valueOf(this.f56786b));
    }

    public h1(float f10, float f11) {
        hd.a.a(f10 > 0.0f);
        hd.a.a(f11 > 0.0f);
        this.f56785a = f10;
        this.f56786b = f11;
        this.f56787c = Math.round(f10 * 1000.0f);
    }
}
