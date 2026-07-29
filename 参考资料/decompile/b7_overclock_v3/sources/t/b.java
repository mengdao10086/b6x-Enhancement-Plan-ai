package t;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import u.f;
import u.g;
import w.e0;
import w.f0;
import w.g0;
import w.h;
import w.i;
import w.m;
import w.o;
import w.t;
import w.w;

/* JADX INFO: loaded from: classes2.dex */
public class b implements w {
    public static final int T = 0;
    public static final int U = 1;
    public static final int V = 2;
    public static final int W = 3;
    public static final int X = 4;
    public static final int Y = 5;
    public static final int Z = 0;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f50529a0 = 1;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f50530b0 = 2;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f50531c0 = 3;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f50532d0 = 4;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f50533e0 = 5;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f50534f0 = 6;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f50535g0 = 1;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f50536h0 = 2;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final String f50537i0 = "MotionController";

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final boolean f50538j0 = false;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final boolean f50539k0 = false;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final int f50540l0 = 0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final int f50541m0 = 1;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final int f50542n0 = 2;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final int f50543o0 = 3;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final int f50544p0 = 4;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final int f50545q0 = 5;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final int f50546r0 = -1;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final int f50547s0 = -2;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final int f50548t0 = -3;
    public String[] A;
    public int[] B;
    public HashMap<String, t> H;
    public HashMap<String, o> I;
    public HashMap<String, h> J;
    public g[] K;
    public String[] S;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f50550i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f50551j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f50552k;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public w.b[] f50558q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public w.b f50559r;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f50563v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f50564w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int[] f50565x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public double[] f50566y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public double[] f50567z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m f50549h = new m();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f50553l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f50554m = new d();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public d f50555n = new d();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c f50556o = new c();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c f50557p = new c();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f50560s = Float.NaN;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f50561t = 0.0f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f50562u = 1.0f;
    public int C = 4;
    public float[] D = new float[4];
    public ArrayList<d> E = new ArrayList<>();
    public float[] F = new float[1];
    public ArrayList<u.b> G = new ArrayList<>();
    public int L = -1;
    public int M = -1;
    public e N = null;
    public int O = -1;
    public float P = Float.NaN;
    public w.c Q = null;
    public boolean R = false;

    public static class a implements w.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f50568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w.d f50569b;

        public a(w.d dVar) {
            this.f50569b = dVar;
        }

        @Override // w.c
        public float a() {
            return (float) this.f50569b.b(this.f50568a);
        }

        @Override // w.c
        public float getInterpolation(float f10) {
            this.f50568a = f10;
            return (float) this.f50569b.a(f10);
        }
    }

    public b(e eVar) {
        c0(eVar);
    }

    public static w.c A(int i10, String str, int i11) {
        if (i10 != -1) {
            return null;
        }
        return new a(w.d.c(str));
    }

    public d B(int i10) {
        return this.E.get(i10);
    }

    public int C(int i10, int[] iArr) {
        float[] fArr = new float[2];
        int i11 = 0;
        int i12 = 0;
        for (u.b bVar : this.G) {
            int i13 = bVar.f51751k;
            if (i13 == i10 || i10 != -1) {
                iArr[i12] = 0;
                int i14 = i12 + 1;
                iArr[i14] = i13;
                int i15 = i14 + 1;
                int i16 = bVar.f51748h;
                iArr[i15] = i16;
                double d10 = i16 / 100.0f;
                this.f50558q[0].d(d10, this.f50566y);
                this.f50554m.j(d10, this.f50565x, this.f50566y, fArr, 0);
                int i17 = i15 + 1;
                iArr[i17] = Float.floatToIntBits(fArr[0]);
                int i18 = i17 + 1;
                iArr[i18] = Float.floatToIntBits(fArr[1]);
                if (bVar instanceof u.e) {
                    u.e eVar = (u.e) bVar;
                    int i19 = i18 + 1;
                    iArr[i19] = eVar.I;
                    int i20 = i19 + 1;
                    iArr[i20] = Float.floatToIntBits(eVar.E);
                    i18 = i20 + 1;
                    iArr[i18] = Float.floatToIntBits(eVar.F);
                }
                int i21 = i18 + 1;
                iArr[i12] = i21 - i12;
                i11++;
                i12 = i21;
            }
        }
        return i11;
    }

    public float D(int i10, float f10, float f11) {
        d dVar = this.f50555n;
        float f12 = dVar.f50611e;
        d dVar2 = this.f50554m;
        float f13 = dVar2.f50611e;
        float f14 = f12 - f13;
        float f15 = dVar.f50612f;
        float f16 = dVar2.f50612f;
        float f17 = f15 - f16;
        float f18 = f13 + (dVar2.f50613g / 2.0f);
        float f19 = f16 + (dVar2.f50614h / 2.0f);
        float fHypot = (float) Math.hypot(f14, f17);
        if (fHypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f20 = f10 - f18;
        float f21 = f11 - f19;
        if (((float) Math.hypot(f20, f21)) == 0.0f) {
            return 0.0f;
        }
        float f22 = (f20 * f14) + (f21 * f17);
        if (i10 == 0) {
            return f22 / fHypot;
        }
        if (i10 == 1) {
            return (float) Math.sqrt((fHypot * fHypot) - (f22 * f22));
        }
        if (i10 == 2) {
            return f20 / f14;
        }
        if (i10 == 3) {
            return f21 / f14;
        }
        if (i10 == 4) {
            return f20 / f17;
        }
        if (i10 != 5) {
            return 0.0f;
        }
        return f21 / f17;
    }

    public int E(int[] iArr, float[] fArr) {
        int i10 = 0;
        int i11 = 0;
        for (u.b bVar : this.G) {
            int i12 = bVar.f51748h;
            iArr[i10] = (bVar.f51751k * 1000) + i12;
            double d10 = i12 / 100.0f;
            this.f50558q[0].d(d10, this.f50566y);
            this.f50554m.j(d10, this.f50565x, this.f50566y, fArr, i11);
            i11 += 2;
            i10++;
        }
        return i10;
    }

    public double[] F(double d10) {
        this.f50558q[0].d(d10, this.f50566y);
        w.b bVar = this.f50559r;
        if (bVar != null) {
            double[] dArr = this.f50566y;
            if (dArr.length > 0) {
                bVar.d(d10, dArr);
            }
        }
        return this.f50566y;
    }

    public u.e G(int i10, int i11, float f10, float f11) {
        w.e eVar = new w.e();
        d dVar = this.f50554m;
        float f12 = dVar.f50611e;
        eVar.f53435b = f12;
        float f13 = dVar.f50612f;
        eVar.f53437d = f13;
        eVar.f53436c = f12 + dVar.f50613g;
        eVar.f53434a = f13 + dVar.f50614h;
        w.e eVar2 = new w.e();
        d dVar2 = this.f50555n;
        float f14 = dVar2.f50611e;
        eVar2.f53435b = f14;
        float f15 = dVar2.f50612f;
        eVar2.f53437d = f15;
        eVar2.f53436c = f14 + dVar2.f50613g;
        eVar2.f53434a = f15 + dVar2.f50614h;
        for (u.b bVar : this.G) {
            if (bVar instanceof u.e) {
                u.e eVar3 = (u.e) bVar;
                if (eVar3.B(i10, i11, eVar, eVar2, f10, f11)) {
                    return eVar3;
                }
            }
        }
        return null;
    }

    public void H(float f10, int i10, int i11, float f11, float f12, float[] fArr) {
        float fO = o(f10, this.F);
        HashMap<String, o> map = this.I;
        o oVar = map == null ? null : map.get("translationX");
        HashMap<String, o> map2 = this.I;
        o oVar2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, o> map3 = this.I;
        o oVar3 = map3 == null ? null : map3.get("rotationZ");
        HashMap<String, o> map4 = this.I;
        o oVar4 = map4 == null ? null : map4.get("scaleX");
        HashMap<String, o> map5 = this.I;
        o oVar5 = map5 == null ? null : map5.get("scaleY");
        HashMap<String, h> map6 = this.J;
        h hVar = map6 == null ? null : map6.get("translationX");
        HashMap<String, h> map7 = this.J;
        h hVar2 = map7 == null ? null : map7.get("translationY");
        HashMap<String, h> map8 = this.J;
        h hVar3 = map8 == null ? null : map8.get("rotationZ");
        HashMap<String, h> map9 = this.J;
        h hVar4 = map9 == null ? null : map9.get("scaleX");
        HashMap<String, h> map10 = this.J;
        h hVar5 = map10 != null ? map10.get("scaleY") : null;
        f0 f0Var = new f0();
        f0Var.b();
        f0Var.d(oVar3, fO);
        f0Var.h(oVar, oVar2, fO);
        f0Var.f(oVar4, oVar5, fO);
        f0Var.c(hVar3, fO);
        f0Var.g(hVar, hVar2, fO);
        f0Var.e(hVar4, hVar5, fO);
        w.b bVar = this.f50559r;
        if (bVar != null) {
            double[] dArr = this.f50566y;
            if (dArr.length > 0) {
                double d10 = fO;
                bVar.d(d10, dArr);
                this.f50559r.g(d10, this.f50567z);
                this.f50554m.v(f11, f12, fArr, this.f50565x, this.f50567z, this.f50566y);
            }
            f0Var.a(f11, f12, i10, i11, fArr);
            return;
        }
        int i12 = 0;
        if (this.f50558q == null) {
            d dVar = this.f50555n;
            float f13 = dVar.f50611e;
            d dVar2 = this.f50554m;
            float f14 = f13 - dVar2.f50611e;
            h hVar6 = hVar5;
            float f15 = dVar.f50612f - dVar2.f50612f;
            h hVar7 = hVar4;
            float f16 = (dVar.f50613g - dVar2.f50613g) + f14;
            float f17 = (dVar.f50614h - dVar2.f50614h) + f15;
            fArr[0] = (f14 * (1.0f - f11)) + (f16 * f11);
            fArr[1] = (f15 * (1.0f - f12)) + (f17 * f12);
            f0Var.b();
            f0Var.d(oVar3, fO);
            f0Var.h(oVar, oVar2, fO);
            f0Var.f(oVar4, oVar5, fO);
            f0Var.c(hVar3, fO);
            f0Var.g(hVar, hVar2, fO);
            f0Var.e(hVar7, hVar6, fO);
            f0Var.a(f11, f12, i10, i11, fArr);
            return;
        }
        double dO = o(fO, this.F);
        this.f50558q[0].g(dO, this.f50567z);
        this.f50558q[0].d(dO, this.f50566y);
        float f18 = this.F[0];
        while (true) {
            double[] dArr2 = this.f50567z;
            if (i12 >= dArr2.length) {
                this.f50554m.v(f11, f12, fArr, this.f50565x, dArr2, this.f50566y);
                f0Var.a(f11, f12, i10, i11, fArr);
                return;
            } else {
                dArr2[i12] = dArr2[i12] * ((double) f18);
                i12++;
            }
        }
    }

    public final float I() {
        char c10;
        float fHypot;
        float[] fArr = new float[2];
        float f10 = 1.0f / 99;
        double d10 = 0.0d;
        double d11 = 0.0d;
        float f11 = 0.0f;
        int i10 = 0;
        while (i10 < 100) {
            float f12 = i10 * f10;
            double dA = f12;
            w.d dVar = this.f50554m.f50607a;
            float f13 = Float.NaN;
            float f14 = 0.0f;
            for (d dVar2 : this.E) {
                w.d dVar3 = dVar2.f50607a;
                if (dVar3 != null) {
                    float f15 = dVar2.f50609c;
                    if (f15 < f12) {
                        dVar = dVar3;
                        f14 = f15;
                    } else if (Float.isNaN(f13)) {
                        f13 = dVar2.f50609c;
                    }
                }
            }
            if (dVar != null) {
                if (Float.isNaN(f13)) {
                    f13 = 1.0f;
                }
                dA = (((float) dVar.a((f12 - f14) / r17)) * (f13 - f14)) + f14;
            }
            this.f50558q[0].d(dA, this.f50566y);
            float f16 = f11;
            int i11 = i10;
            this.f50554m.j(dA, this.f50565x, this.f50566y, fArr, 0);
            if (i11 > 0) {
                c10 = 0;
                fHypot = (float) (((double) f16) + Math.hypot(d11 - ((double) fArr[1]), d10 - ((double) fArr[0])));
            } else {
                c10 = 0;
                fHypot = f16;
            }
            d10 = fArr[c10];
            i10 = i11 + 1;
            f11 = fHypot;
            d11 = fArr[1];
        }
        return f11;
    }

    public float J() {
        return this.f50554m.f50614h;
    }

    public float K() {
        return this.f50554m.f50613g;
    }

    public float L() {
        return this.f50554m.f50611e;
    }

    public float M() {
        return this.f50554m.f50612f;
    }

    public int N() {
        return this.M;
    }

    public e O() {
        return this.f50550i;
    }

    public final void P(d dVar) {
        d dVar2 = null;
        for (d dVar3 : this.E) {
            if (dVar.f50610d == dVar3.f50610d) {
                dVar2 = dVar3;
            }
        }
        if (dVar2 != null) {
            this.E.remove(dVar2);
        }
        if (Collections.binarySearch(this.E, dVar) == 0) {
            e0.f("MotionController", " KeyPath position \"" + dVar.f50610d + "\" outside of range");
        }
        this.E.add((-r0) - 1, dVar);
    }

    public boolean Q(e eVar, float f10, long j10, w.g gVar) {
        double d10;
        float fO = o(f10, null);
        int i10 = this.O;
        if (i10 != -1) {
            float f11 = 1.0f / i10;
            float fFloor = ((float) Math.floor(fO / f11)) * f11;
            float f12 = (fO % f11) / f11;
            if (!Float.isNaN(this.P)) {
                f12 = (f12 + this.P) % 1.0f;
            }
            w.c cVar = this.Q;
            fO = ((cVar != null ? cVar.getInterpolation(f12) : ((double) f12) > 0.5d ? 1.0f : 0.0f) * f11) + fFloor;
        }
        float f13 = fO;
        HashMap<String, o> map = this.I;
        if (map != null) {
            Iterator<o> it2 = map.values().iterator();
            while (it2.hasNext()) {
                it2.next().h(eVar, f13);
            }
        }
        w.b[] bVarArr = this.f50558q;
        if (bVarArr != null) {
            double d11 = f13;
            bVarArr[0].d(d11, this.f50566y);
            this.f50558q[0].g(d11, this.f50567z);
            w.b bVar = this.f50559r;
            if (bVar != null) {
                double[] dArr = this.f50566y;
                if (dArr.length > 0) {
                    bVar.d(d11, dArr);
                    this.f50559r.g(d11, this.f50567z);
                }
            }
            if (this.R) {
                d10 = d11;
            } else {
                d10 = d11;
                this.f50554m.w(f13, eVar, this.f50565x, this.f50566y, this.f50567z, null);
            }
            if (this.M != -1) {
                if (this.N == null) {
                    this.N = eVar.n().f(this.M);
                }
                if (this.N != null) {
                    float fW = (r1.w() + this.N.h()) / 2.0f;
                    float fL = (this.N.l() + this.N.q()) / 2.0f;
                    if (eVar.q() - eVar.l() > 0 && eVar.h() - eVar.w() > 0) {
                        eVar.N(fL - eVar.l());
                        eVar.O(fW - eVar.w());
                    }
                }
            }
            int i11 = 1;
            while (true) {
                w.b[] bVarArr2 = this.f50558q;
                if (i11 >= bVarArr2.length) {
                    break;
                }
                bVarArr2[i11].e(d10, this.D);
                this.f50554m.f50621o.get(this.A[i11 - 1]).w(eVar, this.D);
                i11++;
            }
            c cVar2 = this.f50556o;
            if (cVar2.f50574b == 0) {
                if (f13 <= 0.0f) {
                    eVar.b0(cVar2.f50575c);
                } else if (f13 >= 1.0f) {
                    eVar.b0(this.f50557p.f50575c);
                } else if (this.f50557p.f50575c != cVar2.f50575c) {
                    eVar.b0(4);
                }
            }
            if (this.K != null) {
                int i12 = 0;
                while (true) {
                    g[] gVarArr = this.K;
                    if (i12 >= gVarArr.length) {
                        break;
                    }
                    gVarArr[i12].v(f13, eVar);
                    i12++;
                }
            }
        } else {
            d dVar = this.f50554m;
            float f14 = dVar.f50611e;
            d dVar2 = this.f50555n;
            float f15 = f14 + ((dVar2.f50611e - f14) * f13);
            float f16 = dVar.f50612f;
            float f17 = f16 + ((dVar2.f50612f - f16) * f13);
            float f18 = dVar.f50613g;
            float f19 = f18 + ((dVar2.f50613g - f18) * f13);
            float f20 = dVar.f50614h;
            float f21 = f15 + 0.5f;
            float f22 = f17 + 0.5f;
            eVar.G((int) f21, (int) f22, (int) (f21 + f19), (int) (f22 + f20 + ((dVar2.f50614h - f20) * f13)));
        }
        HashMap<String, h> map2 = this.J;
        if (map2 == null) {
            return false;
        }
        for (h hVar : map2.values()) {
            if (hVar instanceof h.f) {
                double[] dArr2 = this.f50567z;
                ((h.f) hVar).l(eVar, f13, dArr2[0], dArr2[1]);
            } else {
                hVar.h(eVar, f13);
            }
        }
        return false;
    }

    public String R() {
        return this.f50550i.m();
    }

    public void S(e eVar, u.e eVar2, float f10, float f11, String[] strArr, float[] fArr) {
        w.e eVar3 = new w.e();
        d dVar = this.f50554m;
        float f12 = dVar.f50611e;
        eVar3.f53435b = f12;
        float f13 = dVar.f50612f;
        eVar3.f53437d = f13;
        eVar3.f53436c = f12 + dVar.f50613g;
        eVar3.f53434a = f13 + dVar.f50614h;
        w.e eVar4 = new w.e();
        d dVar2 = this.f50555n;
        float f14 = dVar2.f50611e;
        eVar4.f53435b = f14;
        float f15 = dVar2.f50612f;
        eVar4.f53437d = f15;
        eVar4.f53436c = f14 + dVar2.f50613g;
        eVar4.f53434a = f15 + dVar2.f50614h;
        eVar2.C(eVar, eVar3, eVar4, f10, f11, strArr, fArr);
    }

    public final void T(d dVar) {
        dVar.u(this.f50550i.E(), this.f50550i.F(), this.f50550i.D(), this.f50550i.k());
    }

    public void U(m mVar, m mVar2, int i10, int i11, int i12) {
        if (i10 == 1) {
            int i13 = mVar.f53540b + mVar.f53541c;
            mVar2.f53540b = ((mVar.f53542d + mVar.f53539a) - mVar.b()) / 2;
            mVar2.f53542d = i12 - ((i13 + mVar.a()) / 2);
            mVar2.f53541c = mVar2.f53540b + mVar.b();
            mVar2.f53539a = mVar2.f53542d + mVar.a();
            return;
        }
        if (i10 == 2) {
            int i14 = mVar.f53540b + mVar.f53541c;
            mVar2.f53540b = i11 - (((mVar.f53542d + mVar.f53539a) + mVar.b()) / 2);
            mVar2.f53542d = (i14 - mVar.a()) / 2;
            mVar2.f53541c = mVar2.f53540b + mVar.b();
            mVar2.f53539a = mVar2.f53542d + mVar.a();
            return;
        }
        if (i10 == 3) {
            int i15 = mVar.f53540b + mVar.f53541c;
            mVar2.f53540b = ((mVar.a() / 2) + mVar.f53542d) - (i15 / 2);
            mVar2.f53542d = i12 - ((i15 + mVar.a()) / 2);
            mVar2.f53541c = mVar2.f53540b + mVar.b();
            mVar2.f53539a = mVar2.f53542d + mVar.a();
            return;
        }
        if (i10 != 4) {
            return;
        }
        int i16 = mVar.f53540b + mVar.f53541c;
        mVar2.f53540b = i11 - (((mVar.f53539a + mVar.f53542d) + mVar.b()) / 2);
        mVar2.f53542d = (i16 - mVar.a()) / 2;
        mVar2.f53541c = mVar2.f53540b + mVar.b();
        mVar2.f53539a = mVar2.f53542d + mVar.a();
    }

    public void V(e eVar) {
        d dVar = this.f50554m;
        dVar.f50609c = 0.0f;
        dVar.f50610d = 0.0f;
        this.R = true;
        dVar.u(eVar.E(), eVar.F(), eVar.D(), eVar.k());
        this.f50555n.u(eVar.E(), eVar.F(), eVar.D(), eVar.k());
        this.f50556o.n(eVar);
        this.f50557p.n(eVar);
    }

    public void W(int i10) {
        this.f50554m.f50608b = i10;
    }

    public void X(e eVar) {
        d dVar = this.f50555n;
        dVar.f50609c = 1.0f;
        dVar.f50610d = 1.0f;
        T(dVar);
        this.f50555n.u(eVar.l(), eVar.w(), eVar.D(), eVar.k());
        this.f50555n.c(eVar);
        this.f50557p.n(eVar);
    }

    public void Y(int i10) {
        this.L = i10;
    }

    public void Z(e eVar) {
        d dVar = this.f50554m;
        dVar.f50609c = 0.0f;
        dVar.f50610d = 0.0f;
        dVar.u(eVar.E(), eVar.F(), eVar.D(), eVar.k());
        this.f50554m.c(eVar);
        this.f50556o.n(eVar);
    }

    @Override // w.w
    public boolean a(int i10, int i11) {
        if (i10 != 509) {
            return i10 == 704;
        }
        Y(i11);
        return true;
    }

    public void a0(g0 g0Var, e eVar, int i10, int i11, int i12) {
        d dVar = this.f50554m;
        dVar.f50609c = 0.0f;
        dVar.f50610d = 0.0f;
        m mVar = new m();
        if (i10 == 1) {
            int i13 = g0Var.f53458b + g0Var.f53460d;
            mVar.f53540b = ((g0Var.f53459c + g0Var.f53461e) - g0Var.c()) / 2;
            mVar.f53542d = i11 - ((i13 + g0Var.b()) / 2);
            mVar.f53541c = mVar.f53540b + g0Var.c();
            mVar.f53539a = mVar.f53542d + g0Var.b();
        } else if (i10 == 2) {
            int i14 = g0Var.f53458b + g0Var.f53460d;
            mVar.f53540b = i12 - (((g0Var.f53459c + g0Var.f53461e) + g0Var.c()) / 2);
            mVar.f53542d = (i14 - g0Var.b()) / 2;
            mVar.f53541c = mVar.f53540b + g0Var.c();
            mVar.f53539a = mVar.f53542d + g0Var.b();
        }
        this.f50554m.u(mVar.f53540b, mVar.f53542d, mVar.b(), mVar.a());
        this.f50556o.o(mVar, eVar, i10, g0Var.f53457a);
    }

    @Override // w.w
    public boolean b(int i10, float f10) {
        return false;
    }

    public void b0(int i10) {
        this.M = i10;
        this.N = null;
    }

    @Override // w.w
    public boolean c(int i10, String str) {
        if (705 == i10) {
            System.out.println("TYPE_INTERPOLATOR  " + str);
            this.Q = A(-1, str, 0);
        }
        return false;
    }

    public void c0(e eVar) {
        this.f50550i = eVar;
    }

    @Override // w.w
    public boolean d(int i10, boolean z10) {
        return false;
    }

    public void d0(int i10, int i11, float f10, long j10) {
        ArrayList arrayList;
        String[] strArr;
        Class<double> cls;
        int i12;
        t.a aVar;
        o oVarF;
        t.a aVar2;
        Integer num;
        Iterator<String> it2;
        o oVarF2;
        t.a aVar3;
        Class<double> cls2 = double.class;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int i13 = this.L;
        if (i13 != -1) {
            this.f50554m.f50617k = i13;
        }
        this.f50556o.g(this.f50557p, hashSet2);
        ArrayList<u.b> arrayList2 = this.G;
        if (arrayList2 != null) {
            arrayList = null;
            for (u.b bVar : arrayList2) {
                if (bVar instanceof u.e) {
                    u.e eVar = (u.e) bVar;
                    P(new d(i10, i11, eVar, this.f50554m, this.f50555n));
                    int i14 = eVar.f51762y;
                    if (i14 != -1) {
                        this.f50553l = i14;
                    }
                } else if (bVar instanceof u.d) {
                    bVar.i(hashSet3);
                } else if (bVar instanceof f) {
                    bVar.i(hashSet);
                } else if (bVar instanceof g) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((g) bVar);
                } else {
                    bVar.q(map);
                    bVar.i(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.K = (g[]) arrayList.toArray(new g[0]);
        }
        char c10 = 1;
        if (!hashSet2.isEmpty()) {
            this.I = new HashMap<>();
            Iterator<String> it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                String next = it3.next();
                if (next.startsWith("CUSTOM,")) {
                    i.b bVar2 = new i.b();
                    String str = next.split(ag.c.f654g)[c10];
                    for (u.b bVar3 : this.G) {
                        Iterator<String> it4 = it3;
                        HashMap<String, t.a> map2 = bVar3.f51752l;
                        if (map2 != null && (aVar3 = map2.get(str)) != null) {
                            bVar2.a(bVar3.f51748h, aVar3);
                        }
                        it3 = it4;
                    }
                    it2 = it3;
                    oVarF2 = o.e(next, bVar2);
                } else {
                    it2 = it3;
                    oVarF2 = o.f(next, j10);
                }
                if (oVarF2 != null) {
                    oVarF2.i(next);
                    this.I.put(next, oVarF2);
                }
                it3 = it2;
                c10 = 1;
            }
            ArrayList<u.b> arrayList3 = this.G;
            if (arrayList3 != null) {
                for (u.b bVar4 : arrayList3) {
                    if (bVar4 instanceof u.c) {
                        bVar4.f(this.I);
                    }
                }
            }
            this.f50556o.c(this.I, 0);
            this.f50557p.c(this.I, 100);
            for (String str2 : this.I.keySet()) {
                int iIntValue = (!map.containsKey(str2) || (num = map.get(str2)) == null) ? 0 : num.intValue();
                o oVar = this.I.get(str2);
                if (oVar != null) {
                    oVar.j(iIntValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.H == null) {
                this.H = new HashMap<>();
            }
            for (String str3 : hashSet) {
                if (!this.H.containsKey(str3)) {
                    if (str3.startsWith("CUSTOM,")) {
                        i.b bVar5 = new i.b();
                        String str4 = str3.split(ag.c.f654g)[1];
                        for (u.b bVar6 : this.G) {
                            HashMap<String, t.a> map3 = bVar6.f51752l;
                            if (map3 != null && (aVar2 = map3.get(str4)) != null) {
                                bVar5.a(bVar6.f51748h, aVar2);
                            }
                        }
                        oVarF = o.e(str3, bVar5);
                    } else {
                        oVarF = o.f(str3, j10);
                    }
                    if (oVarF != null) {
                        oVarF.i(str3);
                    }
                }
            }
            ArrayList<u.b> arrayList4 = this.G;
            if (arrayList4 != null) {
                for (u.b bVar7 : arrayList4) {
                    if (bVar7 instanceof f) {
                        ((f) bVar7).v(this.H);
                    }
                }
            }
            for (String str5 : this.H.keySet()) {
                this.H.get(str5).f(map.containsKey(str5) ? map.get(str5).intValue() : 0);
            }
        }
        int i15 = 2;
        int size = this.E.size() + 2;
        d[] dVarArr = new d[size];
        dVarArr[0] = this.f50554m;
        dVarArr[size - 1] = this.f50555n;
        if (this.E.size() > 0 && this.f50553l == u.b.f51736m) {
            this.f50553l = 0;
        }
        Iterator<d> it5 = this.E.iterator();
        int i16 = 1;
        while (it5.hasNext()) {
            dVarArr[i16] = it5.next();
            i16++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str6 : this.f50555n.f50621o.keySet()) {
            if (this.f50554m.f50621o.containsKey(str6)) {
                if (!hashSet2.contains("CUSTOM," + str6)) {
                    hashSet4.add(str6);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.A = strArr2;
        this.B = new int[strArr2.length];
        int i17 = 0;
        while (true) {
            strArr = this.A;
            if (i17 >= strArr.length) {
                break;
            }
            String str7 = strArr[i17];
            this.B[i17] = 0;
            int i18 = 0;
            while (true) {
                if (i18 >= size) {
                    break;
                }
                if (dVarArr[i18].f50621o.containsKey(str7) && (aVar = dVarArr[i18].f50621o.get(str7)) != null) {
                    int[] iArr = this.B;
                    iArr[i17] = iArr[i17] + aVar.r();
                    break;
                }
                i18++;
            }
            i17++;
        }
        boolean z10 = dVarArr[0].f50617k != -1;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i19 = 1; i19 < size; i19++) {
            dVarArr[i19].g(dVarArr[i19 - 1], zArr, this.A, z10);
        }
        int i20 = 0;
        for (int i21 = 1; i21 < length; i21++) {
            if (zArr[i21]) {
                i20++;
            }
        }
        this.f50565x = new int[i20];
        int iMax = Math.max(2, i20);
        this.f50566y = new double[iMax];
        this.f50567z = new double[iMax];
        int i22 = 0;
        for (int i23 = 1; i23 < length; i23++) {
            if (zArr[i23]) {
                this.f50565x[i22] = i23;
                i22++;
            }
        }
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) cls2, size, this.f50565x.length);
        double[] dArr2 = new double[size];
        for (int i24 = 0; i24 < size; i24++) {
            dVarArr[i24].h(dArr[i24], this.f50565x);
            dArr2[i24] = dVarArr[i24].f50609c;
        }
        int i25 = 0;
        while (true) {
            int[] iArr2 = this.f50565x;
            if (i25 >= iArr2.length) {
                break;
            }
            if (iArr2[i25] < d.K0.length) {
                String str8 = d.K0[this.f50565x[i25]] + " [";
                for (int i26 = 0; i26 < size; i26++) {
                    str8 = str8 + dArr[i26][i25];
                }
            }
            i25++;
        }
        this.f50558q = new w.b[this.A.length + 1];
        int i27 = 0;
        while (true) {
            String[] strArr3 = this.A;
            if (i27 >= strArr3.length) {
                break;
            }
            String str9 = strArr3[i27];
            int i28 = 0;
            int i29 = 0;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i28 < size) {
                if (dVarArr[i28].p(str9)) {
                    if (dArr4 == null) {
                        dArr3 = new double[size];
                        int[] iArr3 = new int[i15];
                        iArr3[1] = dVarArr[i28].n(str9);
                        i12 = 0;
                        iArr3[0] = size;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) cls2, iArr3);
                    } else {
                        i12 = 0;
                    }
                    cls = cls2;
                    dArr3[i29] = dVarArr[i28].f50609c;
                    dVarArr[i28].m(str9, dArr4[i29], i12);
                    i29++;
                } else {
                    cls = cls2;
                }
                i28++;
                cls2 = cls;
                i15 = 2;
            }
            i27++;
            this.f50558q[i27] = w.b.a(this.f50553l, Arrays.copyOf(dArr3, i29), (double[][]) Arrays.copyOf(dArr4, i29));
            cls2 = cls2;
            i15 = 2;
        }
        Class<double> cls3 = cls2;
        this.f50558q[0] = w.b.a(this.f50553l, dArr2, dArr);
        if (dVarArr[0].f50617k != -1) {
            int[] iArr4 = new int[size];
            double[] dArr5 = new double[size];
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) cls3, size, 2);
            for (int i30 = 0; i30 < size; i30++) {
                iArr4[i30] = dVarArr[i30].f50617k;
                dArr5[i30] = dVarArr[i30].f50609c;
                dArr6[i30][0] = dVarArr[i30].f50611e;
                dArr6[i30][1] = dVarArr[i30].f50612f;
            }
            this.f50559r = w.b.b(iArr4, dArr5, dArr6);
        }
        float fI = Float.NaN;
        this.J = new HashMap<>();
        if (this.G != null) {
            for (String str10 : hashSet3) {
                h hVarD = h.d(str10);
                if (hVarD != null) {
                    if (hVarD.k() && Float.isNaN(fI)) {
                        fI = I();
                    }
                    hVarD.i(str10);
                    this.J.put(str10, hVarD);
                }
            }
            for (u.b bVar8 : this.G) {
                if (bVar8 instanceof u.d) {
                    ((u.d) bVar8).v(this.J);
                }
            }
            Iterator<h> it6 = this.J.values().iterator();
            while (it6.hasNext()) {
                it6.next().j(fI);
            }
        }
    }

    @Override // w.w
    public int e(String str) {
        return 0;
    }

    public void e0(b bVar) {
        this.f50554m.x(bVar, bVar.f50554m);
        this.f50555n.x(bVar, bVar.f50555n);
    }

    public void f(u.b bVar) {
        this.G.add(bVar);
    }

    public void g(ArrayList<u.b> arrayList) {
        this.G.addAll(arrayList);
    }

    public void h(float[] fArr, int i10) {
        float f10 = 1.0f / (i10 - 1);
        HashMap<String, o> map = this.I;
        if (map != null) {
            map.get("translationX");
        }
        HashMap<String, o> map2 = this.I;
        if (map2 != null) {
            map2.get("translationY");
        }
        HashMap<String, h> map3 = this.J;
        if (map3 != null) {
            map3.get("translationX");
        }
        HashMap<String, h> map4 = this.J;
        if (map4 != null) {
            map4.get("translationY");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            float fMin = i11 * f10;
            float f11 = this.f50562u;
            float f12 = 0.0f;
            if (f11 != 1.0f) {
                float f13 = this.f50561t;
                if (fMin < f13) {
                    fMin = 0.0f;
                }
                if (fMin > f13 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f13) * f11, 1.0f);
                }
            }
            double dA = fMin;
            w.d dVar = this.f50554m.f50607a;
            float f14 = Float.NaN;
            for (d dVar2 : this.E) {
                w.d dVar3 = dVar2.f50607a;
                if (dVar3 != null) {
                    float f15 = dVar2.f50609c;
                    if (f15 < fMin) {
                        dVar = dVar3;
                        f12 = f15;
                    } else if (Float.isNaN(f14)) {
                        f14 = dVar2.f50609c;
                    }
                }
            }
            if (dVar != null) {
                if (Float.isNaN(f14)) {
                    f14 = 1.0f;
                }
                dA = (((float) dVar.a((fMin - f12) / r11)) * (f14 - f12)) + f12;
            }
            this.f50558q[0].d(dA, this.f50566y);
            w.b bVar = this.f50559r;
            if (bVar != null) {
                double[] dArr = this.f50566y;
                if (dArr.length > 0) {
                    bVar.d(dA, dArr);
                }
            }
            this.f50554m.i(this.f50565x, this.f50566y, fArr, i11 * 2);
        }
    }

    public int i(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] dArrH = this.f50558q[0].h();
        if (iArr != null) {
            Iterator<d> it2 = this.E.iterator();
            int i10 = 0;
            while (it2.hasNext()) {
                iArr[i10] = it2.next().f50622p;
                i10++;
            }
        }
        int i11 = 0;
        for (double d10 : dArrH) {
            this.f50558q[0].d(d10, this.f50566y);
            this.f50554m.i(this.f50565x, this.f50566y, fArr, i11);
            i11 += 2;
        }
        return i11 / 2;
    }

    public int j(float[] fArr, int[] iArr, int[] iArr2) {
        if (fArr == null) {
            return 0;
        }
        double[] dArrH = this.f50558q[0].h();
        if (iArr != null) {
            Iterator<d> it2 = this.E.iterator();
            int i10 = 0;
            while (it2.hasNext()) {
                iArr[i10] = it2.next().f50622p;
                i10++;
            }
        }
        if (iArr2 != null) {
            Iterator<d> it3 = this.E.iterator();
            int i11 = 0;
            while (it3.hasNext()) {
                iArr2[i11] = (int) (it3.next().f50610d * 100.0f);
                i11++;
            }
        }
        int i12 = 0;
        for (int i13 = 0; i13 < dArrH.length; i13++) {
            this.f50558q[0].d(dArrH[i13], this.f50566y);
            this.f50554m.j(dArrH[i13], this.f50565x, this.f50566y, fArr, i12);
            i12 += 2;
        }
        return i12 / 2;
    }

    public void k(float[] fArr, int i10) {
        double dA;
        float f10 = 1.0f;
        float f11 = 1.0f / (i10 - 1);
        HashMap<String, o> map = this.I;
        o oVar = map == null ? null : map.get("translationX");
        HashMap<String, o> map2 = this.I;
        o oVar2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, h> map3 = this.J;
        h hVar = map3 == null ? null : map3.get("translationX");
        HashMap<String, h> map4 = this.J;
        h hVar2 = map4 != null ? map4.get("translationY") : null;
        int i11 = 0;
        while (i11 < i10) {
            float fMin = i11 * f11;
            float f12 = this.f50562u;
            if (f12 != f10) {
                float f13 = this.f50561t;
                if (fMin < f13) {
                    fMin = 0.0f;
                }
                if (fMin > f13 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f13) * f12, f10);
                }
            }
            float f14 = fMin;
            double d10 = f14;
            w.d dVar = this.f50554m.f50607a;
            float f15 = Float.NaN;
            float f16 = 0.0f;
            for (d dVar2 : this.E) {
                w.d dVar3 = dVar2.f50607a;
                double d11 = d10;
                if (dVar3 != null) {
                    float f17 = dVar2.f50609c;
                    if (f17 < f14) {
                        f16 = f17;
                        dVar = dVar3;
                    } else if (Float.isNaN(f15)) {
                        f15 = dVar2.f50609c;
                    }
                }
                d10 = d11;
            }
            double d12 = d10;
            if (dVar != null) {
                if (Float.isNaN(f15)) {
                    f15 = 1.0f;
                }
                dA = (((float) dVar.a((f14 - f16) / r5)) * (f15 - f16)) + f16;
            } else {
                dA = d12;
            }
            this.f50558q[0].d(dA, this.f50566y);
            w.b bVar = this.f50559r;
            if (bVar != null) {
                double[] dArr = this.f50566y;
                if (dArr.length > 0) {
                    bVar.d(dA, dArr);
                }
            }
            int i12 = i11 * 2;
            int i13 = i11;
            this.f50554m.j(dA, this.f50565x, this.f50566y, fArr, i12);
            if (hVar != null) {
                fArr[i12] = fArr[i12] + hVar.a(f14);
            } else if (oVar != null) {
                fArr[i12] = fArr[i12] + oVar.a(f14);
            }
            if (hVar2 != null) {
                int i14 = i12 + 1;
                fArr[i14] = fArr[i14] + hVar2.a(f14);
            } else if (oVar2 != null) {
                int i15 = i12 + 1;
                fArr[i15] = fArr[i15] + oVar2.a(f14);
            }
            i11 = i13 + 1;
            f10 = 1.0f;
        }
    }

    public void l(float f10, float[] fArr, int i10) {
        this.f50558q[0].d(o(f10, null), this.f50566y);
        this.f50554m.o(this.f50565x, this.f50566y, fArr, i10);
    }

    public void m(float[] fArr, int i10) {
        float f10 = 1.0f / (i10 - 1);
        for (int i11 = 0; i11 < i10; i11++) {
            this.f50558q[0].d(o(i11 * f10, null), this.f50566y);
            this.f50554m.o(this.f50565x, this.f50566y, fArr, i11 * 8);
        }
    }

    public void n(boolean z10) {
    }

    public final float o(float f10, float[] fArr) {
        float f11 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f12 = this.f50562u;
            if (f12 != 1.0d) {
                float f13 = this.f50561t;
                if (f10 < f13) {
                    f10 = 0.0f;
                }
                if (f10 > f13 && f10 < 1.0d) {
                    f10 = Math.min((f10 - f13) * f12, 1.0f);
                }
            }
        }
        w.d dVar = this.f50554m.f50607a;
        float f14 = Float.NaN;
        for (d dVar2 : this.E) {
            w.d dVar3 = dVar2.f50607a;
            if (dVar3 != null) {
                float f15 = dVar2.f50609c;
                if (f15 < f10) {
                    dVar = dVar3;
                    f11 = f15;
                } else if (Float.isNaN(f14)) {
                    f14 = dVar2.f50609c;
                }
            }
        }
        if (dVar != null) {
            float f16 = (Float.isNaN(f14) ? 1.0f : f14) - f11;
            double d10 = (f10 - f11) / f16;
            f10 = (((float) dVar.a(d10)) * f16) + f11;
            if (fArr != null) {
                fArr[0] = (float) dVar.b(d10);
            }
        }
        return f10;
    }

    public int p() {
        return this.f50554m.f50618l;
    }

    public int q(String str, float[] fArr, int i10) {
        o oVar = this.I.get(str);
        if (oVar == null) {
            return -1;
        }
        for (int i11 = 0; i11 < fArr.length; i11++) {
            fArr[i11] = oVar.a(i11 / (fArr.length - 1));
        }
        return fArr.length;
    }

    public void r(double d10, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f50558q[0].d(d10, dArr);
        this.f50558q[0].g(d10, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.f50554m.k(d10, this.f50565x, dArr, fArr, dArr2, fArr2);
    }

    public float s() {
        return this.f50563v;
    }

    public float t() {
        return this.f50564w;
    }

    public String toString() {
        return " start: x: " + this.f50554m.f50611e + " y: " + this.f50554m.f50612f + " end: x: " + this.f50555n.f50611e + " y: " + this.f50555n.f50612f;
    }

    public void u(float f10, float f11, float f12, float[] fArr) {
        double[] dArr;
        float fO = o(f10, this.F);
        w.b[] bVarArr = this.f50558q;
        int i10 = 0;
        if (bVarArr == null) {
            d dVar = this.f50555n;
            float f13 = dVar.f50611e;
            d dVar2 = this.f50554m;
            float f14 = f13 - dVar2.f50611e;
            float f15 = dVar.f50612f - dVar2.f50612f;
            float f16 = (dVar.f50613g - dVar2.f50613g) + f14;
            float f17 = (dVar.f50614h - dVar2.f50614h) + f15;
            fArr[0] = (f14 * (1.0f - f11)) + (f16 * f11);
            fArr[1] = (f15 * (1.0f - f12)) + (f17 * f12);
            return;
        }
        double d10 = fO;
        bVarArr[0].g(d10, this.f50567z);
        this.f50558q[0].d(d10, this.f50566y);
        float f18 = this.F[0];
        while (true) {
            dArr = this.f50567z;
            if (i10 >= dArr.length) {
                break;
            }
            dArr[i10] = dArr[i10] * ((double) f18);
            i10++;
        }
        w.b bVar = this.f50559r;
        if (bVar == null) {
            this.f50554m.v(f11, f12, fArr, this.f50565x, dArr, this.f50566y);
            return;
        }
        double[] dArr2 = this.f50566y;
        if (dArr2.length > 0) {
            bVar.d(d10, dArr2);
            this.f50559r.g(d10, this.f50567z);
            this.f50554m.v(f11, f12, fArr, this.f50565x, this.f50567z, this.f50566y);
        }
    }

    public int v() {
        int iMax = this.f50554m.f50608b;
        Iterator<d> it2 = this.E.iterator();
        while (it2.hasNext()) {
            iMax = Math.max(iMax, it2.next().f50608b);
        }
        return Math.max(iMax, this.f50555n.f50608b);
    }

    public float w() {
        return this.f50555n.f50614h;
    }

    public float x() {
        return this.f50555n.f50613g;
    }

    public float y() {
        return this.f50555n.f50611e;
    }

    public float z() {
        return this.f50555n.f50612f;
    }
}
