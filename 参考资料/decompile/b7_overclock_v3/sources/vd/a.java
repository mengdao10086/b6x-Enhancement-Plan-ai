package vd;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f52972a = 15.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f52973b = 0.5f;

    public static int a(int i10, int i11, float f10) {
        b bVarB = b.b(i10);
        b bVarB2 = b.b(i11);
        float fN = bVarB.n();
        float fH = bVarB.h();
        float fI = bVarB.i();
        return b.f(fN + ((bVarB2.n() - fN) * f10), fH + ((bVarB2.h() - fH) * f10), fI + ((bVarB2.i() - fI) * f10)).l();
    }

    public static int b(int i10, int i11, float f10) {
        return l.b(b.b(a(i10, i11, f10)).k(), b.b(i10).j(), f.l(i10)).m();
    }

    public static int c(int i10, int i11) {
        l lVarC = l.c(i10);
        l lVarC2 = l.c(i11);
        return l.b(n.d(lVarC.g() + (Math.min(n.b(lVarC.g(), lVarC2.g()) * 0.5f, 15.0f) * d(lVarC.g(), lVarC2.g()))), lVarC.f(), lVarC.h()).m();
    }

    public static float d(float f10, float f11) {
        float f12 = f11 - f10;
        float f13 = f12 + 360.0f;
        float f14 = f12 - 360.0f;
        float fAbs = Math.abs(f12);
        float fAbs2 = Math.abs(f13);
        float fAbs3 = Math.abs(f14);
        return (fAbs > fAbs2 || fAbs > fAbs3) ? (fAbs2 > fAbs || fAbs2 > fAbs3) ? ((double) f14) >= 0.0d ? 1.0f : -1.0f : ((double) f13) >= 0.0d ? 1.0f : -1.0f : ((double) f12) >= 0.0d ? 1.0f : -1.0f;
    }
}
