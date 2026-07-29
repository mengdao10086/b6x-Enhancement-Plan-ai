package j0;

import g.n0;
import g.p0;
import g.x;
import kotlin.jvm.internal.v;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f35945j = 0.2f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float f35946k = 1.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float f35947l = 0.4f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float f35948m = 0.01f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f35949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f35950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f35951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f35952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f35953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f35954f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f35955g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f35956h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f35957i;

    public a(float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        this.f35949a = f10;
        this.f35950b = f11;
        this.f35951c = f12;
        this.f35952d = f13;
        this.f35953e = f14;
        this.f35954f = f15;
        this.f35955g = f16;
        this.f35956h = f17;
        this.f35957i = f18;
    }

    @p0
    public static a b(@x(from = 0.0d, to = 360.0d) float f10, @x(from = 0.0d, to = v.f37959d, toInclusive = false) float f11, @x(from = 0.0d, to = m0.g.f40541b) float f12) {
        float f13 = 1000.0f;
        a aVar = null;
        float f14 = 1000.0f;
        float f15 = 100.0f;
        float f16 = 0.0f;
        while (Math.abs(f16 - f15) > 0.01f) {
            float f17 = ((f15 - f16) / 2.0f) + f16;
            int iS = e(f17, f11, f10).s();
            float fB = b.b(iS);
            float fAbs = Math.abs(f12 - fB);
            if (fAbs < 0.2f) {
                a aVarC = c(iS);
                float fA = aVarC.a(e(aVarC.k(), aVarC.i(), f10));
                if (fA <= 1.0f) {
                    aVar = aVarC;
                    f13 = fAbs;
                    f14 = fA;
                }
            }
            if (f13 == 0.0f && f14 == 0.0f) {
                break;
            }
            if (fB < f12) {
                f16 = f17;
            } else {
                f15 = f17;
            }
        }
        return aVar;
    }

    @n0
    public static a c(@g.l int i10) {
        return d(i10, o.f36008k);
    }

    @n0
    public static a d(@g.l int i10, @n0 o oVar) {
        float[] fArrF = b.f(i10);
        float[][] fArr = b.f35958a;
        float f10 = (fArrF[0] * fArr[0][0]) + (fArrF[1] * fArr[0][1]) + (fArrF[2] * fArr[0][2]);
        float f11 = (fArrF[0] * fArr[1][0]) + (fArrF[1] * fArr[1][1]) + (fArrF[2] * fArr[1][2]);
        float f12 = (fArrF[0] * fArr[2][0]) + (fArrF[1] * fArr[2][1]) + (fArrF[2] * fArr[2][2]);
        float f13 = oVar.i()[0] * f10;
        float f14 = oVar.i()[1] * f11;
        float f15 = oVar.i()[2] * f12;
        float fPow = (float) Math.pow(((double) (oVar.c() * Math.abs(f13))) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow(((double) (oVar.c() * Math.abs(f14))) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow(((double) (oVar.c() * Math.abs(f15))) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f13) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f14) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f15) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d10 = fSignum3;
        float f16 = ((float) (((((double) fSignum) * 11.0d) + (((double) fSignum2) * (-12.0d))) + d10)) / 11.0f;
        float f17 = ((float) (((double) (fSignum + fSignum2)) - (d10 * 2.0d))) / 9.0f;
        float f18 = fSignum2 * 20.0f;
        float f19 = (((fSignum * 20.0f) + f18) + (21.0f * fSignum3)) / 20.0f;
        float f20 = (((fSignum * 40.0f) + f18) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f17, f16)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f21 = fAtan2;
        float f22 = (3.1415927f * f21) / 180.0f;
        float fPow4 = ((float) Math.pow((f20 * oVar.f()) / oVar.a(), oVar.b() * oVar.j())) * 100.0f;
        float fD = oVar.d() * (4.0f / oVar.b()) * ((float) Math.sqrt(fPow4 / 100.0f)) * (oVar.a() + 4.0f);
        float fPow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, oVar.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) (((double) f21) < 20.14d ? 360.0f + f21 : f21)) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * oVar.g()) * oVar.h()) * ((float) Math.sqrt((f16 * f16) + (f17 * f17)))) / (f19 + 0.305f), 0.9d)) * ((float) Math.sqrt(((double) fPow4) / 100.0d));
        float fD2 = fPow5 * oVar.d();
        float fSqrt = ((float) Math.sqrt((r2 * oVar.b()) / (oVar.a() + 4.0f))) * 50.0f;
        float f23 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * fD2) + 1.0f)) * 43.85965f;
        double d11 = f22;
        return new a(f21, fPow5, fPow4, fD, fD2, fSqrt, f23, fLog * ((float) Math.cos(d11)), fLog * ((float) Math.sin(d11)));
    }

    @n0
    public static a e(@x(from = 0.0d, to = m0.g.f40541b) float f10, @x(from = 0.0d, to = v.f37959d, toInclusive = false) float f11, @x(from = 0.0d, to = 360.0d) float f12) {
        return f(f10, f11, f12, o.f36008k);
    }

    @n0
    public static a f(@x(from = 0.0d, to = m0.g.f40541b) float f10, @x(from = 0.0d, to = v.f37959d, toInclusive = false) float f11, @x(from = 0.0d, to = 360.0d) float f12, o oVar) {
        float fB = (4.0f / oVar.b()) * ((float) Math.sqrt(((double) f10) / 100.0d)) * (oVar.a() + 4.0f) * oVar.d();
        float fD = f11 * oVar.d();
        float fSqrt = ((float) Math.sqrt(((f11 / ((float) Math.sqrt(r4))) * oVar.b()) / (oVar.a() + 4.0f))) * 50.0f;
        float f13 = (1.7f * f10) / ((0.007f * f10) + 1.0f);
        float fLog = ((float) Math.log((((double) fD) * 0.0228d) + 1.0d)) * 43.85965f;
        double d10 = (3.1415927f * f12) / 180.0f;
        return new a(f12, f11, f10, fB, fD, fSqrt, f13, fLog * ((float) Math.cos(d10)), fLog * ((float) Math.sin(d10)));
    }

    public static int p(@x(from = 0.0d, to = 360.0d) float f10, @x(from = 0.0d, to = v.f37959d, toInclusive = false) float f11, @x(from = 0.0d, to = m0.g.f40541b) float f12) {
        return q(f10, f11, f12, o.f36008k);
    }

    @g.l
    public static int q(@x(from = 0.0d, to = 360.0d) float f10, @x(from = 0.0d, to = v.f37959d, toInclusive = false) float f11, @x(from = 0.0d, to = m0.g.f40541b) float f12, @n0 o oVar) {
        if (f11 < 1.0d || Math.round(f12) <= 0.0d || Math.round(f12) >= 100.0d) {
            return b.a(f12);
        }
        float fMin = f10 < 0.0f ? 0.0f : Math.min(360.0f, f10);
        float f13 = f11;
        a aVar = null;
        float f14 = 0.0f;
        boolean z10 = true;
        while (Math.abs(f14 - f11) >= 0.4f) {
            a aVarB = b(fMin, f13, f12);
            if (z10) {
                if (aVarB != null) {
                    return aVarB.r(oVar);
                }
                z10 = false;
            } else if (aVarB == null) {
                f11 = f13;
            } else {
                f14 = f13;
                aVar = aVarB;
            }
            f13 = ((f11 - f14) / 2.0f) + f14;
        }
        return aVar == null ? b.a(f12) : aVar.r(oVar);
    }

    public float a(@n0 a aVar) {
        float fL = l() - aVar.l();
        float fG = g() - aVar.g();
        float fH = h() - aVar.h();
        return (float) (Math.pow(Math.sqrt((fL * fL) + (fG * fG) + (fH * fH)), 0.63d) * 1.41d);
    }

    @x(from = v.f37960e, fromInclusive = false, to = v.f37959d, toInclusive = false)
    public float g() {
        return this.f35956h;
    }

    @x(from = v.f37960e, fromInclusive = false, to = v.f37959d, toInclusive = false)
    public float h() {
        return this.f35957i;
    }

    @x(from = 0.0d, to = v.f37959d, toInclusive = false)
    public float i() {
        return this.f35950b;
    }

    @x(from = 0.0d, to = 360.0d, toInclusive = false)
    public float j() {
        return this.f35949a;
    }

    @x(from = 0.0d, to = m0.g.f40541b)
    public float k() {
        return this.f35951c;
    }

    @x(from = 0.0d, to = m0.g.f40541b)
    public float l() {
        return this.f35955g;
    }

    @x(from = 0.0d, to = v.f37959d, toInclusive = false)
    public float m() {
        return this.f35953e;
    }

    @x(from = 0.0d, to = v.f37959d, toInclusive = false)
    public float n() {
        return this.f35952d;
    }

    @x(from = 0.0d, to = v.f37959d, toInclusive = false)
    public float o() {
        return this.f35954f;
    }

    @g.l
    public int r(@n0 o oVar) {
        float fPow = (float) Math.pow(((double) ((((double) i()) == 0.0d || ((double) k()) == 0.0d) ? 0.0f : i() / ((float) Math.sqrt(((double) k()) / 100.0d)))) / Math.pow(1.64d - Math.pow(0.29d, oVar.e()), 0.73d), 1.1111111111111112d);
        double dJ = (j() * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + dJ) + 3.8d)) * 0.25f;
        float fA = oVar.a() * ((float) Math.pow(((double) k()) / 100.0d, (1.0d / ((double) oVar.b())) / ((double) oVar.j())));
        float fG = fCos * 3846.1538f * oVar.g() * oVar.h();
        float f10 = fA / oVar.f();
        float fSin = (float) Math.sin(dJ);
        float fCos2 = (float) Math.cos(dJ);
        float f11 = (((0.305f + f10) * 23.0f) * fPow) / (((fG * 23.0f) + ((11.0f * fPow) * fCos2)) + ((fPow * 108.0f) * fSin));
        float f12 = fCos2 * f11;
        float f13 = f11 * fSin;
        float f14 = f10 * 460.0f;
        float f15 = (((451.0f * f12) + f14) + (288.0f * f13)) / 1403.0f;
        float f16 = ((f14 - (891.0f * f12)) - (261.0f * f13)) / 1403.0f;
        float fSignum = Math.signum(f15) * (100.0f / oVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f15)) * 27.13d) / (400.0d - ((double) Math.abs(f15)))), 2.380952380952381d));
        float fSignum2 = Math.signum(f16) * (100.0f / oVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(f16)) * 27.13d) / (400.0d - ((double) Math.abs(f16)))), 2.380952380952381d));
        float fSignum3 = Math.signum(((f14 - (f12 * 220.0f)) - (f13 * 6300.0f)) / 1403.0f) * (100.0f / oVar.c()) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r6)) * 27.13d) / (400.0d - ((double) Math.abs(r6)))), 2.380952380952381d));
        float f17 = fSignum / oVar.i()[0];
        float f18 = fSignum2 / oVar.i()[1];
        float f19 = fSignum3 / oVar.i()[2];
        float[][] fArr = b.f35959b;
        return m0.g.g((fArr[0][0] * f17) + (fArr[0][1] * f18) + (fArr[0][2] * f19), (fArr[1][0] * f17) + (fArr[1][1] * f18) + (fArr[1][2] * f19), (f17 * fArr[2][0]) + (f18 * fArr[2][1]) + (f19 * fArr[2][2]));
    }

    @g.l
    public int s() {
        return r(o.f36008k);
    }
}
