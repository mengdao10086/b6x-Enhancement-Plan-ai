package vd;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float[][] f52974j = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float[][] f52975k = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f52976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f52977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f52978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f52979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f52980e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f52981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f52982g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f52983h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f52984i;

    public b(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        this.f52976a = f10;
        this.f52977b = f11;
        this.f52978c = f12;
        this.f52979d = f13;
        this.f52980e = f14;
        this.f52981f = f15;
        this.f52982g = f16;
        this.f52983h = f17;
        this.f52984i = f18;
    }

    public static b b(int i10) {
        return c(i10, p.f53111k);
    }

    public static b c(int i10, p pVar) {
        float fK = f.k(((16711680 & i10) >> 16) / 255.0f) * 100.0f;
        float fK2 = f.k(((65280 & i10) >> 8) / 255.0f) * 100.0f;
        float fK3 = f.k((i10 & 255) / 255.0f) * 100.0f;
        float f10 = (0.41233894f * fK) + (0.35762063f * fK2) + (0.18051042f * fK3);
        float f11 = (0.2126f * fK) + (0.7152f * fK2) + (0.0722f * fK3);
        float f12 = (fK * 0.01932141f) + (fK2 * 0.11916382f) + (fK3 * 0.9503448f);
        float[][] fArr = f52974j;
        float f13 = (fArr[0][0] * f10) + (fArr[0][1] * f11) + (fArr[0][2] * f12);
        float f14 = (fArr[1][0] * f10) + (fArr[1][1] * f11) + (fArr[1][2] * f12);
        float f15 = (f10 * fArr[2][0]) + (f11 * fArr[2][1]) + (f12 * fArr[2][2]);
        float f16 = pVar.i()[0] * f13;
        float f17 = pVar.i()[1] * f14;
        float f18 = pVar.i()[2] * f15;
        float fPow = (float) Math.pow(((double) (pVar.c() * Math.abs(f16))) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (pVar.c() * Math.abs(f17))) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (pVar.c() * Math.abs(f18))) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f16) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f17) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f18) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d10 = fSignum3;
        float f19 = ((float) (((((double) fSignum) * 11.0d) + (((double) fSignum2) * (-12.0d))) + d10)) / 11.0f;
        float f20 = ((float) (((double) (fSignum + fSignum2)) - (d10 * 2.0d))) / 9.0f;
        float f21 = fSignum2 * 20.0f;
        float f22 = (((fSignum * 20.0f) + f21) + (21.0f * fSignum3)) / 20.0f;
        float f23 = (((fSignum * 40.0f) + f21) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f20, f19)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f24 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f23 * pVar.f()) / pVar.a(), pVar.b() * pVar.j())) * 100.0f;
        float fB = (4.0f / pVar.b()) * ((float) Math.sqrt(fPow4 / 100.0f)) * (pVar.a() + 4.0f) * pVar.d();
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, pVar.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(Math.toRadians(((double) fAtan2) < 20.14d ? 360.0f + fAtan2 : fAtan2) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * pVar.g()) * pVar.h()) * ((float) Math.hypot(r5, r1))) / (f22 + 0.305f), 0.9d)) * ((float) Math.sqrt(((double) fPow4) / 100.0d));
        float fD = fPow5 * pVar.d();
        float fSqrt = ((float) Math.sqrt((r1 * pVar.b()) / (pVar.a() + 4.0f))) * 50.0f;
        float f25 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog1p = ((float) Math.log1p(0.0228f * fD)) * 43.85965f;
        double d11 = f24;
        return new b(fAtan2, fPow5, fPow4, fB, fD, fSqrt, f25, fLog1p * ((float) Math.cos(d11)), fLog1p * ((float) Math.sin(d11)));
    }

    public static b d(float f10, float f11, float f12) {
        return e(f10, f11, f12, p.f53111k);
    }

    public static b e(float f10, float f11, float f12, p pVar) {
        float fB = (4.0f / pVar.b()) * ((float) Math.sqrt(((double) f10) / 100.0d)) * (pVar.a() + 4.0f) * pVar.d();
        float fD = f11 * pVar.d();
        float fSqrt = ((float) Math.sqrt(((f11 / ((float) Math.sqrt(r4))) * pVar.b()) / (pVar.a() + 4.0f))) * 50.0f;
        float f13 = (1.7f * f10) / ((0.007f * f10) + 1.0f);
        float fLog1p = ((float) Math.log1p(((double) fD) * 0.0228d)) * 43.85965f;
        double d10 = (3.1415927f * f12) / 180.0f;
        return new b(f12, f11, f10, fB, fD, fSqrt, f13, fLog1p * ((float) Math.cos(d10)), fLog1p * ((float) Math.sin(d10)));
    }

    public static b f(float f10, float f11, float f12) {
        return g(f10, f11, f12, p.f53111k);
    }

    public static b g(float f10, float f11, float f12, p pVar) {
        double d10 = f11;
        double d11 = f12;
        double dExpm1 = (Math.expm1(Math.hypot(d10, d11) * 0.02280000038444996d) / 0.02280000038444996d) / ((double) pVar.d());
        double dAtan2 = Math.atan2(d11, d10) * 57.29577951308232d;
        if (dAtan2 < 0.0d) {
            dAtan2 += 360.0d;
        }
        return e(f10 / (1.0f - ((f10 - 100.0f) * 0.007f)), (float) dExpm1, (float) dAtan2, pVar);
    }

    public float a(b bVar) {
        float fN = n() - bVar.n();
        float fH = h() - bVar.h();
        float fI = i() - bVar.i();
        return (float) (Math.pow(Math.sqrt((fN * fN) + (fH * fH) + (fI * fI)), 0.63d) * 1.41d);
    }

    public float h() {
        return this.f52983h;
    }

    public float i() {
        return this.f52984i;
    }

    public float j() {
        return this.f52977b;
    }

    public float k() {
        return this.f52976a;
    }

    public int l() {
        return r(p.f53111k);
    }

    public float m() {
        return this.f52978c;
    }

    public float n() {
        return this.f52982g;
    }

    public float o() {
        return this.f52980e;
    }

    public float p() {
        return this.f52979d;
    }

    public float q() {
        return this.f52981f;
    }

    public int r(p pVar) {
        float fPow = (float) Math.pow(((double) ((((double) j()) == 0.0d || ((double) m()) == 0.0d) ? 0.0f : j() / ((float) Math.sqrt(((double) m()) / 100.0d)))) / Math.pow(1.64d - Math.pow(0.29d, pVar.e()), 0.73d), 1.1111111111111112d);
        double dK = (k() * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + dK) + 3.8d)) * 0.25f;
        float fA = pVar.a() * ((float) Math.pow(((double) m()) / 100.0d, (1.0d / ((double) pVar.b())) / ((double) pVar.j())));
        float fG = fCos * 3846.1538f * pVar.g() * pVar.h();
        float f10 = fA / pVar.f();
        float fSin = (float) Math.sin(dK);
        float fCos2 = (float) Math.cos(dK);
        float f11 = (((0.305f + f10) * 23.0f) * fPow) / (((fG * 23.0f) + ((11.0f * fPow) * fCos2)) + ((fPow * 108.0f) * fSin));
        float f12 = fCos2 * f11;
        float f13 = f11 * fSin;
        float f14 = f10 * 460.0f;
        float f15 = (((451.0f * f12) + f14) + (288.0f * f13)) / 1403.0f;
        float f16 = ((f14 - (891.0f * f12)) - (261.0f * f13)) / 1403.0f;
        float fSignum = Math.signum(f15) * (100.0f / pVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f15)) * 27.13d) / (400.0d - ((double) Math.abs(f15)))), 2.380952380952381d));
        float fSignum2 = Math.signum(f16) * (100.0f / pVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f16)) * 27.13d) / (400.0d - ((double) Math.abs(f16)))), 2.380952380952381d));
        float fSignum3 = Math.signum(((f14 - (f12 * 220.0f)) - (f13 * 6300.0f)) / 1403.0f) * (100.0f / pVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r6)) * 27.13d) / (400.0d - ((double) Math.abs(r6)))), 2.380952380952381d));
        float f17 = fSignum / pVar.i()[0];
        float f18 = fSignum2 / pVar.i()[1];
        float f19 = fSignum3 / pVar.i()[2];
        float[][] fArr = f52975k;
        return f.i((fArr[0][0] * f17) + (fArr[0][1] * f18) + (fArr[0][2] * f19), (fArr[1][0] * f17) + (fArr[1][1] * f18) + (fArr[1][2] * f19), (f17 * fArr[2][0]) + (f18 * fArr[2][1]) + (f19 * fArr[2][2]));
    }
}
