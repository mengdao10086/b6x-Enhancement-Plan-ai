package t;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.Arrays;
import java.util.HashMap;
import t.e;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Comparable<d> {
    public static final int A = 4;
    public static final int B = 5;
    public static final int C = 1;
    public static final int D = 0;
    public static String[] K0 = {CommonNetImpl.POSITION, "x", "y", SocializeProtocolConstants.WIDTH, SocializeProtocolConstants.HEIGHT, "pathRotate"};

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f50599k0 = 2;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f50600t = "MotionPaths";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final boolean f50601u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final boolean f50602v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f50603w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f50604x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f50605y = 2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f50606z = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w.d f50607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f50608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f50609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f50610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f50611e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f50612f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f50613g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f50614h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f50615i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f50616j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f50617k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f50618l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f50619m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f50620n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public HashMap<String, a> f50621o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f50622p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f50623q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public double[] f50624r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public double[] f50625s;

    public d() {
        this.f50608b = 0;
        this.f50615i = Float.NaN;
        this.f50616j = Float.NaN;
        this.f50617k = -1;
        this.f50618l = -1;
        this.f50619m = Float.NaN;
        this.f50620n = null;
        this.f50621o = new HashMap<>();
        this.f50622p = 0;
        this.f50624r = new double[18];
        this.f50625s = new double[18];
    }

    public static final float A(float f10, float f11, float f12, float f13, float f14, float f15) {
        return ((f14 - f12) * f10) + ((f15 - f13) * f11) + f13;
    }

    public static final float y(float f10, float f11, float f12, float f13, float f14, float f15) {
        return (((f14 - f12) * f11) - ((f15 - f13) * f10)) + f12;
    }

    public void c(e eVar) {
        this.f50607a = w.d.c(eVar.f50641i.f50650c);
        e.a aVar = eVar.f50641i;
        this.f50617k = aVar.f50651d;
        this.f50618l = aVar.f50648a;
        this.f50615i = aVar.f50655h;
        this.f50608b = aVar.f50652e;
        this.f50623q = aVar.f50649b;
        this.f50616j = eVar.f50642j.f50664d;
        this.f50619m = 0.0f;
        for (String str : eVar.j()) {
            a aVarI = eVar.i(str);
            if (aVarI != null && aVarI.q()) {
                this.f50621o.put(str, aVarI);
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(d dVar) {
        return Float.compare(this.f50610d, dVar.f50610d);
    }

    public void e(b bVar) {
        bVar.F(this.f50616j);
    }

    public final boolean f(float f10, float f11) {
        return (Float.isNaN(f10) || Float.isNaN(f11)) ? Float.isNaN(f10) != Float.isNaN(f11) : Math.abs(f10 - f11) > 1.0E-6f;
    }

    public void g(d dVar, boolean[] zArr, String[] strArr, boolean z10) {
        boolean zF = f(this.f50611e, dVar.f50611e);
        boolean zF2 = f(this.f50612f, dVar.f50612f);
        zArr[0] = zArr[0] | f(this.f50610d, dVar.f50610d);
        boolean z11 = zF | zF2 | z10;
        zArr[1] = zArr[1] | z11;
        zArr[2] = z11 | zArr[2];
        zArr[3] = zArr[3] | f(this.f50613g, dVar.f50613g);
        zArr[4] = f(this.f50614h, dVar.f50614h) | zArr[4];
    }

    public void h(double[] dArr, int[] iArr) {
        float[] fArr = {this.f50610d, this.f50611e, this.f50612f, this.f50613g, this.f50614h, this.f50615i};
        int i10 = 0;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (iArr[i11] < 6) {
                dArr[i10] = fArr[iArr[i11]];
                i10++;
            }
        }
    }

    public void i(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f50613g;
        float f11 = this.f50614h;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f12 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 3) {
                f10 = f12;
            } else if (i12 == 4) {
                f11 = f12;
            }
        }
        fArr[i10] = f10;
        fArr[i10 + 1] = f11;
    }

    public void j(double d10, int[] iArr, double[] dArr, float[] fArr, int i10) {
        float fSin = this.f50611e;
        float fCos = this.f50612f;
        float f10 = this.f50613g;
        float f11 = this.f50614h;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f12 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                fSin = f12;
            } else if (i12 == 2) {
                fCos = f12;
            } else if (i12 == 3) {
                f10 = f12;
            } else if (i12 == 4) {
                f11 = f12;
            }
        }
        b bVar = this.f50620n;
        if (bVar != null) {
            float[] fArr2 = new float[2];
            bVar.r(d10, fArr2, new float[2]);
            float f13 = fArr2[0];
            float f14 = fArr2[1];
            double d11 = f13;
            double d12 = fSin;
            double d13 = fCos;
            fSin = (float) ((d11 + (Math.sin(d13) * d12)) - ((double) (f10 / 2.0f)));
            fCos = (float) ((((double) f14) - (d12 * Math.cos(d13))) - ((double) (f11 / 2.0f)));
        }
        fArr[i10] = fSin + (f10 / 2.0f) + 0.0f;
        fArr[i10 + 1] = fCos + (f11 / 2.0f) + 0.0f;
    }

    public void k(double d10, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f10;
        float f11 = this.f50611e;
        float f12 = this.f50612f;
        float f13 = this.f50613g;
        float f14 = this.f50614h;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f19 = (float) dArr[i10];
            float f20 = (float) dArr2[i10];
            int i11 = iArr[i10];
            if (i11 == 1) {
                f11 = f19;
                f15 = f20;
            } else if (i11 == 2) {
                f12 = f19;
                f17 = f20;
            } else if (i11 == 3) {
                f13 = f19;
                f16 = f20;
            } else if (i11 == 4) {
                f14 = f19;
                f18 = f20;
            }
        }
        float f21 = 2.0f;
        float f22 = (f16 / 2.0f) + f15;
        float fCos = (f18 / 2.0f) + f17;
        b bVar = this.f50620n;
        if (bVar != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            bVar.r(d10, fArr3, fArr4);
            float f23 = fArr3[0];
            float f24 = fArr3[1];
            float f25 = fArr4[0];
            float f26 = fArr4[1];
            double d11 = f11;
            double d12 = f12;
            f10 = f13;
            float fSin = (float) ((((double) f23) + (Math.sin(d12) * d11)) - ((double) (f13 / 2.0f)));
            float fCos2 = (float) ((((double) f24) - (d11 * Math.cos(d12))) - ((double) (f14 / 2.0f)));
            double d13 = f15;
            double d14 = f17;
            float fSin2 = (float) (((double) f25) + (Math.sin(d12) * d13) + (Math.cos(d12) * d14));
            fCos = (float) ((((double) f26) - (d13 * Math.cos(d12))) + (Math.sin(d12) * d14));
            f22 = fSin2;
            f11 = fSin;
            f12 = fCos2;
            f21 = 2.0f;
        } else {
            f10 = f13;
        }
        fArr[0] = f11 + (f10 / f21) + 0.0f;
        fArr[1] = f12 + (f14 / f21) + 0.0f;
        fArr2[0] = f22;
        fArr2[1] = fCos;
    }

    public void l(double d10, int[] iArr, double[] dArr, float[] fArr, int i10) {
        float fSin = this.f50611e;
        float fCos = this.f50612f;
        float f10 = this.f50613g;
        float f11 = this.f50614h;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f12 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                fSin = f12;
            } else if (i12 == 2) {
                fCos = f12;
            } else if (i12 == 3) {
                f10 = f12;
            } else if (i12 == 4) {
                f11 = f12;
            }
        }
        b bVar = this.f50620n;
        if (bVar != null) {
            float[] fArr2 = new float[2];
            bVar.r(d10, fArr2, new float[2]);
            float f13 = fArr2[0];
            float f14 = fArr2[1];
            double d11 = f13;
            double d12 = fSin;
            double d13 = fCos;
            fSin = (float) ((d11 + (Math.sin(d13) * d12)) - ((double) (f10 / 2.0f)));
            fCos = (float) ((((double) f14) - (d12 * Math.cos(d13))) - ((double) (f11 / 2.0f)));
        }
        fArr[i10] = fSin + (f10 / 2.0f) + 0.0f;
        fArr[i10 + 1] = fCos + (f11 / 2.0f) + 0.0f;
    }

    public int m(String str, double[] dArr, int i10) {
        a aVar = this.f50621o.get(str);
        int i11 = 0;
        if (aVar == null) {
            return 0;
        }
        if (aVar.r() == 1) {
            dArr[i10] = aVar.n();
            return 1;
        }
        int iR = aVar.r();
        aVar.o(new float[iR]);
        while (i11 < iR) {
            dArr[i10] = r2[i11];
            i11++;
            i10++;
        }
        return iR;
    }

    public int n(String str) {
        a aVar = this.f50621o.get(str);
        if (aVar == null) {
            return 0;
        }
        return aVar.r();
    }

    public void o(int[] iArr, double[] dArr, float[] fArr, int i10) {
        float f10 = this.f50611e;
        float fCos = this.f50612f;
        float f11 = this.f50613g;
        float f12 = this.f50614h;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            float f13 = (float) dArr[i11];
            int i12 = iArr[i11];
            if (i12 == 1) {
                f10 = f13;
            } else if (i12 == 2) {
                fCos = f13;
            } else if (i12 == 3) {
                f11 = f13;
            } else if (i12 == 4) {
                f12 = f13;
            }
        }
        b bVar = this.f50620n;
        if (bVar != null) {
            float fS = bVar.s();
            float fT = this.f50620n.t();
            double d10 = f10;
            double d11 = fCos;
            float fSin = (float) ((((double) fS) + (Math.sin(d11) * d10)) - ((double) (f11 / 2.0f)));
            fCos = (float) ((((double) fT) - (d10 * Math.cos(d11))) - ((double) (f12 / 2.0f)));
            f10 = fSin;
        }
        float f14 = f11 + f10;
        float f15 = f12 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int i13 = i10 + 1;
        fArr[i10] = f10 + 0.0f;
        int i14 = i13 + 1;
        fArr[i13] = fCos + 0.0f;
        int i15 = i14 + 1;
        fArr[i14] = f14 + 0.0f;
        int i16 = i15 + 1;
        fArr[i15] = fCos + 0.0f;
        int i17 = i16 + 1;
        fArr[i16] = f14 + 0.0f;
        int i18 = i17 + 1;
        fArr[i17] = f15 + 0.0f;
        fArr[i18] = f10 + 0.0f;
        fArr[i18 + 1] = f15 + 0.0f;
    }

    public boolean p(String str) {
        return this.f50621o.containsKey(str);
    }

    public void q(u.e eVar, d dVar, d dVar2) {
        float f10 = eVar.f51748h / 100.0f;
        this.f50609c = f10;
        this.f50608b = eVar.B;
        float f11 = Float.isNaN(eVar.C) ? f10 : eVar.C;
        float f12 = Float.isNaN(eVar.D) ? f10 : eVar.D;
        float f13 = dVar2.f50613g;
        float f14 = dVar.f50613g;
        float f15 = dVar2.f50614h;
        float f16 = dVar.f50614h;
        this.f50610d = this.f50609c;
        float f17 = dVar.f50611e;
        float f18 = dVar.f50612f;
        float f19 = (dVar2.f50611e + (f13 / 2.0f)) - ((f14 / 2.0f) + f17);
        float f20 = (dVar2.f50612f + (f15 / 2.0f)) - (f18 + (f16 / 2.0f));
        float f21 = ((f13 - f14) * f11) / 2.0f;
        this.f50611e = (int) ((f17 + (f19 * f10)) - f21);
        float f22 = ((f15 - f16) * f12) / 2.0f;
        this.f50612f = (int) ((f18 + (f20 * f10)) - f22);
        this.f50613g = (int) (f14 + r9);
        this.f50614h = (int) (f16 + r12);
        float f23 = Float.isNaN(eVar.E) ? f10 : eVar.E;
        float f24 = Float.isNaN(eVar.H) ? 0.0f : eVar.H;
        if (!Float.isNaN(eVar.F)) {
            f10 = eVar.F;
        }
        float f25 = Float.isNaN(eVar.G) ? 0.0f : eVar.G;
        this.f50622p = 0;
        this.f50611e = (int) (((dVar.f50611e + (f23 * f19)) + (f25 * f20)) - f21);
        this.f50612f = (int) (((dVar.f50612f + (f19 * f24)) + (f20 * f10)) - f22);
        this.f50607a = w.d.c(eVar.f51763z);
        this.f50617k = eVar.A;
    }

    public void r(u.e eVar, d dVar, d dVar2) {
        float f10 = eVar.f51748h / 100.0f;
        this.f50609c = f10;
        this.f50608b = eVar.B;
        float f11 = Float.isNaN(eVar.C) ? f10 : eVar.C;
        float f12 = Float.isNaN(eVar.D) ? f10 : eVar.D;
        float f13 = dVar2.f50613g - dVar.f50613g;
        float f14 = dVar2.f50614h - dVar.f50614h;
        this.f50610d = this.f50609c;
        if (!Float.isNaN(eVar.E)) {
            f10 = eVar.E;
        }
        float f15 = dVar.f50611e;
        float f16 = dVar.f50613g;
        float f17 = dVar.f50612f;
        float f18 = dVar.f50614h;
        float f19 = (dVar2.f50611e + (dVar2.f50613g / 2.0f)) - ((f16 / 2.0f) + f15);
        float f20 = (dVar2.f50612f + (dVar2.f50614h / 2.0f)) - ((f18 / 2.0f) + f17);
        float f21 = f19 * f10;
        float f22 = (f13 * f11) / 2.0f;
        this.f50611e = (int) ((f15 + f21) - f22);
        float f23 = f10 * f20;
        float f24 = (f14 * f12) / 2.0f;
        this.f50612f = (int) ((f17 + f23) - f24);
        this.f50613g = (int) (f16 + r7);
        this.f50614h = (int) (f18 + r8);
        float f25 = Float.isNaN(eVar.F) ? 0.0f : eVar.F;
        this.f50622p = 1;
        float f26 = (int) ((dVar.f50611e + f21) - f22);
        float f27 = (int) ((dVar.f50612f + f23) - f24);
        this.f50611e = f26 + ((-f20) * f25);
        this.f50612f = f27 + (f19 * f25);
        this.f50618l = this.f50618l;
        this.f50607a = w.d.c(eVar.f51763z);
        this.f50617k = eVar.A;
    }

    public void s(int i10, int i11, u.e eVar, d dVar, d dVar2) {
        float fMin;
        float f10;
        float f11 = eVar.f51748h / 100.0f;
        this.f50609c = f11;
        this.f50608b = eVar.B;
        this.f50622p = eVar.I;
        float f12 = Float.isNaN(eVar.C) ? f11 : eVar.C;
        float f13 = Float.isNaN(eVar.D) ? f11 : eVar.D;
        float f14 = dVar2.f50613g;
        float f15 = dVar.f50613g;
        float f16 = dVar2.f50614h;
        float f17 = dVar.f50614h;
        this.f50610d = this.f50609c;
        this.f50613g = (int) (f15 + ((f14 - f15) * f12));
        this.f50614h = (int) (f17 + ((f16 - f17) * f13));
        int i12 = eVar.I;
        if (i12 == 1) {
            float f18 = Float.isNaN(eVar.E) ? f11 : eVar.E;
            float f19 = dVar2.f50611e;
            float f20 = dVar.f50611e;
            this.f50611e = (f18 * (f19 - f20)) + f20;
            if (!Float.isNaN(eVar.F)) {
                f11 = eVar.F;
            }
            float f21 = dVar2.f50612f;
            float f22 = dVar.f50612f;
            this.f50612f = (f11 * (f21 - f22)) + f22;
        } else if (i12 != 2) {
            float f23 = Float.isNaN(eVar.E) ? f11 : eVar.E;
            float f24 = dVar2.f50611e;
            float f25 = dVar.f50611e;
            this.f50611e = (f23 * (f24 - f25)) + f25;
            if (!Float.isNaN(eVar.F)) {
                f11 = eVar.F;
            }
            float f26 = dVar2.f50612f;
            float f27 = dVar.f50612f;
            this.f50612f = (f11 * (f26 - f27)) + f27;
        } else {
            if (Float.isNaN(eVar.E)) {
                float f28 = dVar2.f50611e;
                float f29 = dVar.f50611e;
                fMin = ((f28 - f29) * f11) + f29;
            } else {
                fMin = Math.min(f13, f12) * eVar.E;
            }
            this.f50611e = fMin;
            if (Float.isNaN(eVar.F)) {
                float f30 = dVar2.f50612f;
                float f31 = dVar.f50612f;
                f10 = (f11 * (f30 - f31)) + f31;
            } else {
                f10 = eVar.F;
            }
            this.f50612f = f10;
        }
        this.f50618l = dVar.f50618l;
        this.f50607a = w.d.c(eVar.f51763z);
        this.f50617k = eVar.A;
    }

    public void t(int i10, int i11, u.e eVar, d dVar, d dVar2) {
        float f10 = eVar.f51748h / 100.0f;
        this.f50609c = f10;
        this.f50608b = eVar.B;
        float f11 = Float.isNaN(eVar.C) ? f10 : eVar.C;
        float f12 = Float.isNaN(eVar.D) ? f10 : eVar.D;
        float f13 = dVar2.f50613g;
        float f14 = dVar.f50613g;
        float f15 = dVar2.f50614h;
        float f16 = dVar.f50614h;
        this.f50610d = this.f50609c;
        float f17 = dVar.f50611e;
        float f18 = dVar.f50612f;
        float f19 = dVar2.f50611e + (f13 / 2.0f);
        float f20 = dVar2.f50612f + (f15 / 2.0f);
        float f21 = (f13 - f14) * f11;
        this.f50611e = (int) ((f17 + ((f19 - ((f14 / 2.0f) + f17)) * f10)) - (f21 / 2.0f));
        float f22 = (f15 - f16) * f12;
        this.f50612f = (int) ((f18 + ((f20 - (f18 + (f16 / 2.0f))) * f10)) - (f22 / 2.0f));
        this.f50613g = (int) (f14 + f21);
        this.f50614h = (int) (f16 + f22);
        this.f50622p = 2;
        if (!Float.isNaN(eVar.E)) {
            this.f50611e = (int) (eVar.E * ((int) (i10 - this.f50613g)));
        }
        if (!Float.isNaN(eVar.F)) {
            this.f50612f = (int) (eVar.F * ((int) (i11 - this.f50614h)));
        }
        this.f50618l = this.f50618l;
        this.f50607a = w.d.c(eVar.f51763z);
        this.f50617k = eVar.A;
    }

    public void u(float f10, float f11, float f12, float f13) {
        this.f50611e = f10;
        this.f50612f = f11;
        this.f50613g = f12;
        this.f50614h = f13;
    }

    public void v(float f10, float f11, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f16 = (float) dArr[i10];
            double d10 = dArr2[i10];
            int i11 = iArr[i10];
            if (i11 == 1) {
                f12 = f16;
            } else if (i11 == 2) {
                f14 = f16;
            } else if (i11 == 3) {
                f13 = f16;
            } else if (i11 == 4) {
                f15 = f16;
            }
        }
        float f17 = f12 - ((0.0f * f13) / 2.0f);
        float f18 = f14 - ((0.0f * f15) / 2.0f);
        fArr[0] = (f17 * (1.0f - f10)) + (((f13 * 1.0f) + f17) * f10) + 0.0f;
        fArr[1] = (f18 * (1.0f - f11)) + (((f15 * 1.0f) + f18) * f11) + 0.0f;
    }

    public void w(float f10, e eVar, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f11;
        float f12;
        float f13 = this.f50611e;
        float f14 = this.f50612f;
        float f15 = this.f50613g;
        float f16 = this.f50614h;
        if (iArr.length != 0 && this.f50624r.length <= iArr[iArr.length - 1]) {
            int i10 = iArr[iArr.length - 1] + 1;
            this.f50624r = new double[i10];
            this.f50625s = new double[i10];
        }
        Arrays.fill(this.f50624r, Double.NaN);
        for (int i11 = 0; i11 < iArr.length; i11++) {
            this.f50624r[iArr[i11]] = dArr[i11];
            this.f50625s[iArr[i11]] = dArr2[i11];
        }
        float f17 = Float.NaN;
        int i12 = 0;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f20 = 0.0f;
        float f21 = 0.0f;
        while (true) {
            double[] dArr4 = this.f50624r;
            if (i12 >= dArr4.length) {
                break;
            }
            if (Double.isNaN(dArr4[i12]) && (dArr3 == null || dArr3[i12] == 0.0d)) {
                f12 = f17;
            } else {
                double d10 = dArr3 != null ? dArr3[i12] : 0.0d;
                if (!Double.isNaN(this.f50624r[i12])) {
                    d10 = this.f50624r[i12] + d10;
                }
                f12 = f17;
                float f22 = (float) d10;
                float f23 = (float) this.f50625s[i12];
                if (i12 == 1) {
                    f17 = f12;
                    f18 = f23;
                    f13 = f22;
                } else if (i12 == 2) {
                    f17 = f12;
                    f19 = f23;
                    f14 = f22;
                } else if (i12 == 3) {
                    f17 = f12;
                    f20 = f23;
                    f15 = f22;
                } else if (i12 == 4) {
                    f17 = f12;
                    f21 = f23;
                    f16 = f22;
                } else if (i12 == 5) {
                    f17 = f22;
                }
                i12++;
            }
            f17 = f12;
            i12++;
        }
        float f24 = f17;
        b bVar = this.f50620n;
        if (bVar != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            bVar.r(f10, fArr, fArr2);
            float f25 = fArr[0];
            float f26 = fArr[1];
            float f27 = fArr2[0];
            float f28 = fArr2[1];
            double d11 = f13;
            double d12 = f14;
            float fSin = (float) ((((double) f25) + (Math.sin(d12) * d11)) - ((double) (f15 / 2.0f)));
            f11 = f16;
            float fCos = (float) ((((double) f26) - (Math.cos(d12) * d11)) - ((double) (f16 / 2.0f)));
            double d13 = f18;
            double d14 = f19;
            float fSin2 = (float) (((double) f27) + (Math.sin(d12) * d13) + (Math.cos(d12) * d11 * d14));
            float fCos2 = (float) ((((double) f28) - (d13 * Math.cos(d12))) + (d11 * Math.sin(d12) * d14));
            if (dArr2.length >= 2) {
                dArr2[0] = fSin2;
                dArr2[1] = fCos2;
            }
            if (!Float.isNaN(f24)) {
                eVar.R((float) (((double) f24) + Math.toDegrees(Math.atan2(fCos2, fSin2))));
            }
            f13 = fSin;
            f14 = fCos;
        } else {
            f11 = f16;
            if (!Float.isNaN(f24)) {
                eVar.R((float) (((double) 0.0f) + ((double) f24) + Math.toDegrees(Math.atan2(f19 + (f21 / 2.0f), f18 + (f20 / 2.0f)))));
            }
        }
        float f29 = f13 + 0.5f;
        float f30 = f14 + 0.5f;
        eVar.G((int) f29, (int) f30, (int) (f29 + f15), (int) (f30 + f11));
    }

    public void x(b bVar, d dVar) {
        double d10 = ((this.f50611e + (this.f50613g / 2.0f)) - dVar.f50611e) - (dVar.f50613g / 2.0f);
        double d11 = ((this.f50612f + (this.f50614h / 2.0f)) - dVar.f50612f) - (dVar.f50614h / 2.0f);
        this.f50620n = bVar;
        this.f50611e = (float) Math.hypot(d11, d10);
        if (Float.isNaN(this.f50619m)) {
            this.f50612f = (float) (Math.atan2(d11, d10) + 1.5707963267948966d);
        } else {
            this.f50612f = (float) Math.toRadians(this.f50619m);
        }
    }

    public d(int i10, int i11, u.e eVar, d dVar, d dVar2) {
        this.f50608b = 0;
        this.f50615i = Float.NaN;
        this.f50616j = Float.NaN;
        this.f50617k = -1;
        this.f50618l = -1;
        this.f50619m = Float.NaN;
        this.f50620n = null;
        this.f50621o = new HashMap<>();
        this.f50622p = 0;
        this.f50624r = new double[18];
        this.f50625s = new double[18];
        if (dVar.f50618l != -1) {
            s(i10, i11, eVar, dVar, dVar2);
            return;
        }
        int i12 = eVar.I;
        if (i12 == 1) {
            r(eVar, dVar, dVar2);
        } else if (i12 != 2) {
            q(eVar, dVar, dVar2);
        } else {
            t(i10, i11, eVar, dVar, dVar2);
        }
    }
}
