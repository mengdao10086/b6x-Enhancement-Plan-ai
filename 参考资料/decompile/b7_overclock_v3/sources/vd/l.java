package vd;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f53090d = 0.4f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f53091e = 1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f53092f = 0.2f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f53093g = 1.0E-9f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float f53094h = 0.01f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f53095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f53096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f53097c;

    public l(float f10, float f11, float f12) {
        k(d(f10, f11, f12));
    }

    public static b a(float f10, float f11, float f12) {
        float f13 = 1000.0f;
        b bVar = null;
        float f14 = 1000.0f;
        float f15 = 100.0f;
        float f16 = 0.0f;
        while (Math.abs(f16 - f15) > 0.01f) {
            float f17 = ((f15 - f16) / 2.0f) + f16;
            int iL = b.d(f17, f11, f10).l();
            float fL = f.l(iL);
            float fAbs = Math.abs(f12 - fL);
            if (fAbs < 0.2f) {
                b bVarB = b.b(iL);
                float fA = bVarB.a(b.d(bVarB.m(), bVarB.j(), f10));
                if (fA <= 1.0f && fA <= f13) {
                    bVar = bVarB;
                    f14 = fAbs;
                    f13 = fA;
                }
            }
            if (f14 == 0.0f && f13 < 1.0E-9f) {
                break;
            }
            if (fL < f12) {
                f16 = f17;
            } else {
                f15 = f17;
            }
        }
        return bVar;
    }

    public static l b(float f10, float f11, float f12) {
        return new l(f10, f11, f12);
    }

    public static l c(int i10) {
        b bVarB = b.b(i10);
        return new l(bVarB.k(), bVarB.j(), f.l(i10));
    }

    public static int d(float f10, float f11, float f12) {
        return e(f10, f11, f12, p.f53111k);
    }

    public static int e(float f10, float f11, float f12, p pVar) {
        if (f11 < 1.0d || Math.round(f12) <= 0.0d || Math.round(f12) >= 100.0d) {
            return f.f(f12);
        }
        float fD = n.d(f10);
        float f13 = f11;
        b bVar = null;
        float f14 = 0.0f;
        boolean z10 = true;
        while (Math.abs(f14 - f11) >= 0.4f) {
            b bVarA = a(fD, f13, f12);
            if (z10) {
                if (bVarA != null) {
                    return bVarA.r(pVar);
                }
                z10 = false;
            } else if (bVarA == null) {
                f11 = f13;
            } else {
                f14 = f13;
                bVar = bVarA;
            }
            f13 = ((f11 - f14) / 2.0f) + f14;
        }
        return bVar == null ? f.f(f12) : bVar.r(pVar);
    }

    public float f() {
        return this.f53096b;
    }

    public float g() {
        return this.f53095a;
    }

    public float h() {
        return this.f53097c;
    }

    public void i(float f10) {
        k(d(this.f53095a, f10, this.f53097c));
    }

    public void j(float f10) {
        k(d(n.d(f10), this.f53096b, this.f53097c));
    }

    public final void k(int i10) {
        b bVarB = b.b(i10);
        float fL = f.l(i10);
        this.f53095a = bVarB.k();
        this.f53096b = bVarB.j();
        this.f53097c = fL;
    }

    public void l(float f10) {
        k(d(this.f53095a, this.f53096b, f10));
    }

    public int m() {
        return d(this.f53095a, this.f53096b, this.f53097c);
    }
}
