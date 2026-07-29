package androidx.appcompat.app;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static p f1693d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f1694e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f1695f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f1696g = 0.017453292f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float f1697h = 9.0E-4f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final float f1698i = -0.10471976f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f1699j = 0.0334196f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float f1700k = 3.49066E-4f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float f1701l = 5.236E-6f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float f1702m = 0.4092797f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final long f1703n = 946728000000L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1706c;

    public static p b() {
        if (f1693d == null) {
            f1693d = new p();
        }
        return f1693d;
    }

    public void a(long j10, double d10, double d11) {
        double d12 = (0.01720197f * ((j10 - f1703n) / 8.64E7f)) + 6.24006f;
        double dSin = (Math.sin(d12) * 0.03341960161924362d) + d12 + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double dRound = ((double) (Math.round(((double) (r3 - 9.0E-4f)) - r9) + 9.0E-4f)) + ((-d11) / 360.0d) + (Math.sin(d12) * 0.0053d) + (Math.sin(2.0d * dSin) * (-0.0069d));
        double dAsin = Math.asin(Math.sin(dSin) * Math.sin(0.4092797040939331d));
        double d13 = 0.01745329238474369d * d10;
        double dSin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d13) * Math.sin(dAsin))) / (Math.cos(d13) * Math.cos(dAsin));
        if (dSin2 >= 1.0d) {
            this.f1706c = 1;
            this.f1704a = -1L;
            this.f1705b = -1L;
        } else {
            if (dSin2 <= -1.0d) {
                this.f1706c = 0;
                this.f1704a = -1L;
                this.f1705b = -1L;
                return;
            }
            double dAcos = (float) (Math.acos(dSin2) / 6.283185307179586d);
            this.f1704a = Math.round((dRound + dAcos) * 8.64E7d) + f1703n;
            long jRound = Math.round((dRound - dAcos) * 8.64E7d) + f1703n;
            this.f1705b = jRound;
            if (jRound >= j10 || this.f1704a <= j10) {
                this.f1706c = 1;
            } else {
                this.f1706c = 0;
            }
        }
    }
}
