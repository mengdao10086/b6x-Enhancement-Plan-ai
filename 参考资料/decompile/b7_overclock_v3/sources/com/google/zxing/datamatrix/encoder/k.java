package com.google.zxing.datamatrix.encoder;

import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import v7.a;

/* JADX INFO: loaded from: classes7.dex */
public class k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final k[] f21353i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static k[] f21354j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f21359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f21360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f21361g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f21362h;

    static {
        k[] kVarArr = {new k(false, 3, 5, 8, 8, 1), new k(false, 5, 7, 10, 10, 1), new k(true, 5, 7, 16, 6, 1), new k(false, 8, 10, 12, 12, 1), new k(true, 10, 11, 14, 6, 2), new k(false, 12, 12, 14, 14, 1), new k(true, 16, 14, 24, 10, 1), new k(false, 18, 14, 16, 16, 1), new k(false, 22, 18, 18, 18, 1), new k(true, 22, 18, 16, 10, 2), new k(false, 30, 20, 20, 20, 1), new k(true, 32, 24, 16, 14, 2), new k(false, 36, 24, 22, 22, 1), new k(false, 44, 28, 24, 24, 1), new k(true, 49, 28, 22, 14, 2), new k(false, 62, 36, 14, 14, 4), new k(false, 86, 42, 16, 16, 4), new k(false, 114, 48, 18, 18, 4), new k(false, 144, 56, 20, 20, 4), new k(false, mb.e.f41073w1, 68, 22, 22, 4), new k(false, a.c.f52774j, 84, 24, 24, 4, 102, 42), new k(false, 280, 112, 14, 14, 16, 140, 56), new k(false, 368, 144, 16, 16, 16, 92, 36), new k(false, 456, 192, 18, 18, 16, 114, 48), new k(false, 576, 224, 20, 20, 16, 144, 56), new k(false, 696, gg.b.J, 22, 22, 16, mb.e.f41073w1, 68), new k(false, 816, 336, 24, 24, 16, 136, 56), new k(false, 1050, 408, 18, 18, 36, HideBottomViewOnScrollBehavior.f19616g, 68), new k(false, 1304, 496, 20, 20, 36, 163, 62), new d()};
        f21353i = kVarArr;
        f21354j = kVarArr;
    }

    public k(boolean z10, int i10, int i11, int i12, int i13, int i14) {
        this(z10, i10, i11, i12, i13, i14, i10, i11);
    }

    public static k m(int i10) {
        return p(i10, SymbolShapeHint.FORCE_NONE, true);
    }

    public static k n(int i10, SymbolShapeHint symbolShapeHint) {
        return p(i10, symbolShapeHint, true);
    }

    public static k o(int i10, SymbolShapeHint symbolShapeHint, ve.c cVar, ve.c cVar2, boolean z10) {
        for (k kVar : f21354j) {
            if (!(symbolShapeHint == SymbolShapeHint.FORCE_SQUARE && kVar.f21355a) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || kVar.f21355a) && ((cVar == null || (kVar.k() >= cVar.b() && kVar.j() >= cVar.a())) && ((cVar2 == null || (kVar.k() <= cVar2.b() && kVar.j() <= cVar2.a())) && i10 <= kVar.f21356b)))) {
                return kVar;
            }
        }
        if (!z10) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i10);
    }

    public static k p(int i10, SymbolShapeHint symbolShapeHint, boolean z10) {
        return o(i10, symbolShapeHint, null, null, z10);
    }

    public static k q(int i10, boolean z10, boolean z11) {
        return p(i10, z10 ? SymbolShapeHint.FORCE_NONE : SymbolShapeHint.FORCE_SQUARE, z11);
    }

    public static void r(k[] kVarArr) {
        f21354j = kVarArr;
    }

    public int a() {
        return this.f21356b + this.f21357c;
    }

    public final int b() {
        return this.f21356b;
    }

    public int c(int i10) {
        return this.f21361g;
    }

    public final int d() {
        return this.f21357c;
    }

    public final int e(int i10) {
        return this.f21362h;
    }

    public final int f() {
        int i10 = this.f21360f;
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2 && i10 != 4) {
                if (i10 == 16) {
                    return 4;
                }
                if (i10 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i11;
    }

    public int g() {
        return this.f21356b / this.f21361g;
    }

    public final int h() {
        return l() * this.f21359e;
    }

    public final int i() {
        return f() * this.f21358d;
    }

    public final int j() {
        return h() + (l() * 2);
    }

    public final int k() {
        return i() + (f() * 2);
    }

    public final int l() {
        int i10 = this.f21360f;
        if (i10 == 1 || i10 == 2) {
            return 1;
        }
        if (i10 == 4) {
            return 2;
        }
        if (i10 == 16) {
            return 4;
        }
        if (i10 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f21355a ? "Rectangular Symbol:" : "Square Symbol:");
        sb2.append(" data region ");
        sb2.append(this.f21358d);
        sb2.append('x');
        sb2.append(this.f21359e);
        sb2.append(", symbol size ");
        sb2.append(k());
        sb2.append('x');
        sb2.append(j());
        sb2.append(", symbol data size ");
        sb2.append(i());
        sb2.append('x');
        sb2.append(h());
        sb2.append(", codewords ");
        sb2.append(this.f21356b);
        sb2.append('+');
        sb2.append(this.f21357c);
        return sb2.toString();
    }

    public k(boolean z10, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f21355a = z10;
        this.f21356b = i10;
        this.f21357c = i11;
        this.f21358d = i12;
        this.f21359e = i13;
        this.f21360f = i14;
        this.f21361g = i15;
        this.f21362h = i16;
    }
}
