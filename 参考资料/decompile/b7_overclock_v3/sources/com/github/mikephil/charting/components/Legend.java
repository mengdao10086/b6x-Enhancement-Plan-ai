package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.List;
import ka.b;
import xa.c;
import xa.k;
import xa.l;

/* JADX INFO: loaded from: classes3.dex */
public class Legend extends b {
    public float A;
    public boolean B;
    public List<c> C;
    public List<Boolean> D;
    public List<c> E;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.github.mikephil.charting.components.a[] f16590g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.github.mikephil.charting.components.a[] f16591h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f16592i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LegendHorizontalAlignment f16593j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LegendVerticalAlignment f16594k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LegendOrientation f16595l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f16596m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LegendDirection f16597n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LegendForm f16598o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f16599p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f16600q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DashPathEffect f16601r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f16602s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f16603t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f16604u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f16605v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f16606w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f16607x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f16608y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f16609z;

    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    public enum LegendForm {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    public enum LegendHorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    public enum LegendOrientation {
        HORIZONTAL,
        VERTICAL
    }

    public enum LegendVerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16610a;

        static {
            int[] iArr = new int[LegendOrientation.values().length];
            f16610a = iArr;
            try {
                iArr[LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16610a[LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public Legend() {
        this.f16590g = new com.github.mikephil.charting.components.a[0];
        this.f16592i = false;
        this.f16593j = LegendHorizontalAlignment.LEFT;
        this.f16594k = LegendVerticalAlignment.BOTTOM;
        this.f16595l = LegendOrientation.HORIZONTAL;
        this.f16596m = false;
        this.f16597n = LegendDirection.LEFT_TO_RIGHT;
        this.f16598o = LegendForm.SQUARE;
        this.f16599p = 8.0f;
        this.f16600q = 3.0f;
        this.f16601r = null;
        this.f16602s = 6.0f;
        this.f16603t = 0.0f;
        this.f16604u = 5.0f;
        this.f16605v = 3.0f;
        this.f16606w = 0.95f;
        this.f16607x = 0.0f;
        this.f16608y = 0.0f;
        this.f16609z = 0.0f;
        this.A = 0.0f;
        this.B = false;
        this.C = new ArrayList(16);
        this.D = new ArrayList(16);
        this.E = new ArrayList(16);
        this.f37111e = k.e(10.0f);
        this.f37108b = k.e(5.0f);
        this.f37109c = k.e(3.0f);
    }

    public float A(Paint paint) {
        float f10 = 0.0f;
        for (com.github.mikephil.charting.components.a aVar : this.f16590g) {
            String str = aVar.f16618a;
            if (str != null) {
                float fA = k.a(paint, str);
                if (fA > f10) {
                    f10 = fA;
                }
            }
        }
        return f10;
    }

    public float B(Paint paint) {
        float fE = k.e(this.f16604u);
        float f10 = 0.0f;
        float f11 = 0.0f;
        for (com.github.mikephil.charting.components.a aVar : this.f16590g) {
            float fE2 = k.e(Float.isNaN(aVar.f16620c) ? this.f16599p : aVar.f16620c);
            if (fE2 > f11) {
                f11 = fE2;
            }
            String str = aVar.f16618a;
            if (str != null) {
                float fD = k.d(paint, str);
                if (fD > f10) {
                    f10 = fD;
                }
            }
        }
        return f10 + f11 + fE;
    }

    public LegendOrientation C() {
        return this.f16595l;
    }

    public float D() {
        return this.f16605v;
    }

    public LegendVerticalAlignment E() {
        return this.f16594k;
    }

    public float F() {
        return this.f16602s;
    }

    public float G() {
        return this.f16603t;
    }

    public boolean H() {
        return this.f16596m;
    }

    public boolean I() {
        return this.f16592i;
    }

    public boolean J() {
        return this.B;
    }

    public void K() {
        this.f16592i = false;
    }

    public void L(List<com.github.mikephil.charting.components.a> list) {
        this.f16590g = (com.github.mikephil.charting.components.a[]) list.toArray(new com.github.mikephil.charting.components.a[list.size()]);
        this.f16592i = true;
    }

    public void M(com.github.mikephil.charting.components.a[] aVarArr) {
        this.f16590g = aVarArr;
        this.f16592i = true;
    }

    public void N(LegendDirection legendDirection) {
        this.f16597n = legendDirection;
    }

    public void O(boolean z10) {
        this.f16596m = z10;
    }

    public void P(List<com.github.mikephil.charting.components.a> list) {
        this.f16590g = (com.github.mikephil.charting.components.a[]) list.toArray(new com.github.mikephil.charting.components.a[list.size()]);
    }

    public void Q(List<com.github.mikephil.charting.components.a> list) {
        this.f16591h = (com.github.mikephil.charting.components.a[]) list.toArray(new com.github.mikephil.charting.components.a[list.size()]);
    }

    public void R(int[] iArr, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < Math.min(iArr.length, strArr.length); i10++) {
            com.github.mikephil.charting.components.a aVar = new com.github.mikephil.charting.components.a();
            int i11 = iArr[i10];
            aVar.f16623f = i11;
            aVar.f16618a = strArr[i10];
            if (i11 == 1122868 || i11 == 0) {
                aVar.f16619b = LegendForm.NONE;
            } else if (i11 == 1122867) {
                aVar.f16619b = LegendForm.EMPTY;
            }
            arrayList.add(aVar);
        }
        this.f16591h = (com.github.mikephil.charting.components.a[]) arrayList.toArray(new com.github.mikephil.charting.components.a[arrayList.size()]);
    }

    public void S(com.github.mikephil.charting.components.a[] aVarArr) {
        if (aVarArr == null) {
            aVarArr = new com.github.mikephil.charting.components.a[0];
        }
        this.f16591h = aVarArr;
    }

    public void T(LegendForm legendForm) {
        this.f16598o = legendForm;
    }

    public void U(DashPathEffect dashPathEffect) {
        this.f16601r = dashPathEffect;
    }

    public void V(float f10) {
        this.f16600q = f10;
    }

    public void W(float f10) {
        this.f16599p = f10;
    }

    public void X(float f10) {
        this.f16604u = f10;
    }

    public void Y(LegendHorizontalAlignment legendHorizontalAlignment) {
        this.f16593j = legendHorizontalAlignment;
    }

    public void Z(float f10) {
        this.f16606w = f10;
    }

    public void a0(LegendOrientation legendOrientation) {
        this.f16595l = legendOrientation;
    }

    public void b0(float f10) {
        this.f16605v = f10;
    }

    public void c0(LegendVerticalAlignment legendVerticalAlignment) {
        this.f16594k = legendVerticalAlignment;
    }

    public void d0(boolean z10) {
        this.B = z10;
    }

    public void e0(float f10) {
        this.f16602s = f10;
    }

    public void f0(float f10) {
        this.f16603t = f10;
    }

    public void m(Paint paint, l lVar) {
        float f10;
        float f11;
        float f12;
        float fE = k.e(this.f16599p);
        float fE2 = k.e(this.f16605v);
        float fE3 = k.e(this.f16604u);
        float fE4 = k.e(this.f16602s);
        float fE5 = k.e(this.f16603t);
        boolean z10 = this.B;
        com.github.mikephil.charting.components.a[] aVarArr = this.f16590g;
        int length = aVarArr.length;
        this.A = B(paint);
        this.f16609z = A(paint);
        int i10 = a.f16610a[this.f16595l.ordinal()];
        if (i10 == 1) {
            float fT = k.t(paint);
            float fMax = 0.0f;
            float f13 = 0.0f;
            float fD = 0.0f;
            boolean z11 = false;
            for (int i11 = 0; i11 < length; i11++) {
                com.github.mikephil.charting.components.a aVar = aVarArr[i11];
                boolean z12 = aVar.f16619b != LegendForm.NONE;
                float fE6 = Float.isNaN(aVar.f16620c) ? fE : k.e(aVar.f16620c);
                String str = aVar.f16618a;
                if (!z11) {
                    fD = 0.0f;
                }
                if (z12) {
                    if (z11) {
                        fD += fE2;
                    }
                    fD += fE6;
                }
                if (str != null) {
                    if (z12 && !z11) {
                        fD += fE3;
                    } else if (z11) {
                        fMax = Math.max(fMax, fD);
                        f13 += fT + fE5;
                        fD = 0.0f;
                        z11 = false;
                    }
                    fD += k.d(paint, str);
                    if (i11 < length - 1) {
                        f13 += fT + fE5;
                    }
                } else {
                    fD += fE6;
                    if (i11 < length - 1) {
                        fD += fE2;
                    }
                    z11 = true;
                }
                fMax = Math.max(fMax, fD);
            }
            this.f16607x = fMax;
            this.f16608y = f13;
        } else if (i10 == 2) {
            float fT2 = k.t(paint);
            float fV = k.v(paint) + fE5;
            float fK = lVar.k() * this.f16606w;
            this.D.clear();
            this.C.clear();
            this.E.clear();
            int i12 = 0;
            float fMax2 = 0.0f;
            int i13 = -1;
            float f14 = 0.0f;
            float f15 = 0.0f;
            while (i12 < length) {
                com.github.mikephil.charting.components.a aVar2 = aVarArr[i12];
                float f16 = fE;
                float f17 = fE4;
                boolean z13 = aVar2.f16619b != LegendForm.NONE;
                float fE7 = Float.isNaN(aVar2.f16620c) ? f16 : k.e(aVar2.f16620c);
                String str2 = aVar2.f16618a;
                com.github.mikephil.charting.components.a[] aVarArr2 = aVarArr;
                float f18 = fV;
                this.D.add(Boolean.FALSE);
                float f19 = i13 == -1 ? 0.0f : f14 + fE2;
                if (str2 != null) {
                    f10 = fE2;
                    this.C.add(k.b(paint, str2));
                    f11 = f19 + (z13 ? fE3 + fE7 : 0.0f) + this.C.get(i12).f54979c;
                } else {
                    f10 = fE2;
                    float f20 = fE7;
                    this.C.add(c.b(0.0f, 0.0f));
                    f11 = f19 + (z13 ? f20 : 0.0f);
                    if (i13 == -1) {
                        i13 = i12;
                    }
                }
                if (str2 != null || i12 == length - 1) {
                    float f21 = f15;
                    float f22 = f21 == 0.0f ? 0.0f : f17;
                    if (!z10 || f21 == 0.0f || fK - f21 >= f22 + f11) {
                        f12 = f21 + f22 + f11;
                    } else {
                        this.E.add(c.b(f21, fT2));
                        float fMax3 = Math.max(fMax2, f21);
                        this.D.set(i13 > -1 ? i13 : i12, Boolean.TRUE);
                        fMax2 = fMax3;
                        f12 = f11;
                    }
                    if (i12 == length - 1) {
                        this.E.add(c.b(f12, fT2));
                        fMax2 = Math.max(fMax2, f12);
                    }
                    f15 = f12;
                }
                if (str2 != null) {
                    i13 = -1;
                }
                i12++;
                fE2 = f10;
                fE = f16;
                fE4 = f17;
                fV = f18;
                f14 = f11;
                aVarArr = aVarArr2;
            }
            float f23 = fV;
            this.f16607x = fMax2;
            this.f16608y = (fT2 * this.E.size()) + (f23 * (this.E.size() == 0 ? 0 : this.E.size() - 1));
        }
        this.f16608y += this.f37109c;
        this.f16607x += this.f37108b;
    }

    public List<Boolean> n() {
        return this.D;
    }

    public List<c> o() {
        return this.C;
    }

    public List<c> p() {
        return this.E;
    }

    public LegendDirection q() {
        return this.f16597n;
    }

    public com.github.mikephil.charting.components.a[] r() {
        return this.f16590g;
    }

    public com.github.mikephil.charting.components.a[] s() {
        return this.f16591h;
    }

    public LegendForm t() {
        return this.f16598o;
    }

    public DashPathEffect u() {
        return this.f16601r;
    }

    public float v() {
        return this.f16600q;
    }

    public float w() {
        return this.f16599p;
    }

    public float x() {
        return this.f16604u;
    }

    public LegendHorizontalAlignment y() {
        return this.f16593j;
    }

    public float z() {
        return this.f16606w;
    }

    public Legend(com.github.mikephil.charting.components.a[] aVarArr) {
        this();
        if (aVarArr != null) {
            this.f16590g = aVarArr;
            return;
        }
        throw new IllegalArgumentException("entries array is NULL");
    }
}
