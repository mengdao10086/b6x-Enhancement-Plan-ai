package j0;

import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final o f36008k = k(b.f35960c, (float) ((((double) b.h(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f36009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f36010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f36011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f36012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f36013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f36014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f36015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f36016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f36017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f36018j;

    public o(float f10, float f11, float f12, float f13, float f14, float f15, float[] fArr, float f16, float f17, float f18) {
        this.f36014f = f10;
        this.f36009a = f11;
        this.f36010b = f12;
        this.f36011c = f13;
        this.f36012d = f14;
        this.f36013e = f15;
        this.f36015g = fArr;
        this.f36016h = f16;
        this.f36017i = f17;
        this.f36018j = f18;
    }

    @n0
    public static o k(@n0 float[] fArr, float f10, float f11, float f12, boolean z10) {
        float[][] fArr2 = b.f35958a;
        float f13 = (fArr[0] * fArr2[0][0]) + (fArr[1] * fArr2[0][1]) + (fArr[2] * fArr2[0][2]);
        float f14 = (fArr[0] * fArr2[1][0]) + (fArr[1] * fArr2[1][1]) + (fArr[2] * fArr2[1][2]);
        float f15 = (fArr[0] * fArr2[2][0]) + (fArr[1] * fArr2[2][1]) + (fArr[2] * fArr2[2][2]);
        float f16 = (f12 / 10.0f) + 0.8f;
        float fD = ((double) f16) >= 0.9d ? b.d(0.59f, 0.69f, (f16 - 0.9f) * 10.0f) : b.d(0.525f, 0.59f, (f16 - 0.8f) * 10.0f);
        float fExp = z10 ? 1.0f : (1.0f - (((float) Math.exp(((-f10) - 42.0f) / 92.0f)) * 0.2777778f)) * f16;
        double d10 = fExp;
        if (d10 > 1.0d) {
            fExp = 1.0f;
        } else if (d10 < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr3 = {(((100.0f / f13) * fExp) + 1.0f) - fExp, (((100.0f / f14) * fExp) + 1.0f) - fExp, (((100.0f / f15) * fExp) + 1.0f) - fExp};
        float f17 = 1.0f / ((5.0f * f10) + 1.0f);
        float f18 = f17 * f17 * f17 * f17;
        float f19 = 1.0f - f18;
        float fCbrt = (f18 * f10) + (0.1f * f19 * f19 * ((float) Math.cbrt(((double) f10) * 5.0d)));
        float fH = b.h(f11) / fArr[1];
        double d11 = fH;
        float fSqrt = ((float) Math.sqrt(d11)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d11, 0.2d));
        float[] fArr4 = {(float) Math.pow(((double) ((fArr3[0] * fCbrt) * f13)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr3[1] * fCbrt) * f14)) / 100.0d, 0.42d), (float) Math.pow(((double) ((fArr3[2] * fCbrt) * f15)) / 100.0d, 0.42d)};
        float[] fArr5 = {(fArr4[0] * 400.0f) / (fArr4[0] + 27.13f), (fArr4[1] * 400.0f) / (fArr4[1] + 27.13f), (fArr4[2] * 400.0f) / (fArr4[2] + 27.13f)};
        return new o(fH, ((fArr5[0] * 2.0f) + fArr5[1] + (fArr5[2] * 0.05f)) * fPow, fPow, fPow, fD, f16, fArr3, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public float a() {
        return this.f36009a;
    }

    public float b() {
        return this.f36012d;
    }

    public float c() {
        return this.f36016h;
    }

    public float d() {
        return this.f36017i;
    }

    public float e() {
        return this.f36014f;
    }

    public float f() {
        return this.f36010b;
    }

    public float g() {
        return this.f36013e;
    }

    public float h() {
        return this.f36011c;
    }

    @n0
    public float[] i() {
        return this.f36015g;
    }

    public float j() {
        return this.f36018j;
    }
}
