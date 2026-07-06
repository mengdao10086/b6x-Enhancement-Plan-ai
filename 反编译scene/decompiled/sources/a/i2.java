package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static i2 f6368a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1303a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f1304a;
    public long b;

    public static i2 b() {
        if (f6368a == null) {
            f6368a = new i2();
        }
        return f6368a;
    }

    public void a(long j, double d, double d2) {
        double d3 = (0.01720197f * ((j - 946728000000L) / 8.64E7f)) + 6.24006f;
        double dSin = (Math.sin(d3) * 0.03341960161924362d) + d3 + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double dRound = ((double) (Math.round(((double) (r3 - 9.0E-4f)) - r9) + 9.0E-4f)) + ((-d2) / 360.0d) + (Math.sin(d3) * 0.0053d) + (Math.sin(2.0d * dSin) * (-0.0069d));
        double dAsin = Math.asin(Math.sin(dSin) * Math.sin(0.4092797040939331d));
        double d4 = 0.01745329238474369d * d;
        double dSin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d4) * Math.sin(dAsin))) / (Math.cos(d4) * Math.cos(dAsin));
        if (dSin2 >= 1.0d) {
            this.f1303a = 1;
        } else {
            if (dSin2 > -1.0d) {
                double dAcos = (float) (Math.acos(dSin2) / 6.283185307179586d);
                this.f1304a = Math.round((dRound + dAcos) * 8.64E7d) + 946728000000L;
                long jRound = Math.round((dRound - dAcos) * 8.64E7d) + 946728000000L;
                this.b = jRound;
                if (jRound >= j || this.f1304a <= j) {
                    this.f1303a = 1;
                    return;
                } else {
                    this.f1303a = 0;
                    return;
                }
            }
            this.f1303a = 0;
        }
        this.f1304a = -1L;
        this.b = -1L;
    }
}
