package t;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.state.o;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Set;
import w.a0;
import w.v;
import w.w;

/* JADX INFO: loaded from: classes2.dex */
public class e implements w {
    public static final int A = 0;
    public static final int B = 0;
    public static final int C = -1;
    public static final int D = -1;
    public static final int E = -2;
    public static final int F = Integer.MIN_VALUE;
    public static final int G = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f50626m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f50627n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f50628o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f50629p = -2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f50630q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f50631r = 4;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f50632s = -3;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f50633t = -4;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f50634u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f50635v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f50636w = 2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f50637x = 3;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f50638y = 4;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f50639z = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public o f50640h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f50641i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f50642j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f50643k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f50644l;

    public static class a {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f50645n = -2;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f50646o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f50647p = -3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f50648a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f50649b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f50650c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f50651d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f50652e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f50653f = Float.NaN;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f50654g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f50655h = Float.NaN;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f50656i = Float.NaN;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f50657j = -1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f50658k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f50659l = -3;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f50660m = -1;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f50661a = 4;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f50662b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f50663c = 1.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f50664d = Float.NaN;
    }

    public e() {
        this.f50640h = new o();
        this.f50641i = new a();
        this.f50642j = new b();
    }

    public float A(int i10) {
        switch (i10) {
            case 303:
                return this.f50640h.f3192p;
            case 304:
                return this.f50640h.f3187k;
            case 305:
                return this.f50640h.f3188l;
            case 306:
                return this.f50640h.f3189m;
            case 307:
            default:
                return Float.NaN;
            case 308:
                return this.f50640h.f3184h;
            case 309:
                return this.f50640h.f3185i;
            case 310:
                return this.f50640h.f3186j;
            case 311:
                return this.f50640h.f3190n;
            case 312:
                return this.f50640h.f3191o;
            case 313:
                return this.f50640h.f3182f;
            case 314:
                return this.f50640h.f3183g;
            case 315:
                return this.f50643k;
            case w.a.f53655q /* 316 */:
                return this.f50644l;
        }
    }

    public int B() {
        return this.f50642j.f50661a;
    }

    public o C() {
        return this.f50640h;
    }

    public int D() {
        o oVar = this.f50640h;
        return oVar.f3180d - oVar.f3178b;
    }

    public int E() {
        return this.f50640h.f3178b;
    }

    public int F() {
        return this.f50640h.f3179c;
    }

    public void G(int i10, int i11, int i12, int i13) {
        H(i10, i11, i12, i13);
    }

    public void H(int i10, int i11, int i12, int i13) {
        if (this.f50640h == null) {
            this.f50640h = new o((ConstraintWidget) null);
        }
        o oVar = this.f50640h;
        oVar.f3179c = i11;
        oVar.f3178b = i10;
        oVar.f3180d = i12;
        oVar.f3181e = i13;
    }

    public void I(String str, int i10, float f10) {
        this.f50640h.v(str, i10, f10);
    }

    public void J(String str, int i10, int i11) {
        this.f50640h.w(str, i10, i11);
    }

    public void K(String str, int i10, String str2) {
        this.f50640h.x(str, i10, str2);
    }

    public void L(String str, int i10, boolean z10) {
        this.f50640h.y(str, i10, z10);
    }

    public void M(CustomAttribute customAttribute, float[] fArr) {
        this.f50640h.v(customAttribute.f3034b, 901, fArr[0]);
    }

    public void N(float f10) {
        this.f50640h.f3182f = f10;
    }

    public void O(float f10) {
        this.f50640h.f3183g = f10;
    }

    public void P(float f10) {
        this.f50640h.f3184h = f10;
    }

    public void Q(float f10) {
        this.f50640h.f3185i = f10;
    }

    public void R(float f10) {
        this.f50640h.f3186j = f10;
    }

    public void S(float f10) {
        this.f50640h.f3190n = f10;
    }

    public void T(float f10) {
        this.f50640h.f3191o = f10;
    }

    public void U(float f10) {
        this.f50640h.f3187k = f10;
    }

    public void V(float f10) {
        this.f50640h.f3188l = f10;
    }

    public void W(float f10) {
        this.f50640h.f3189m = f10;
    }

    public boolean X(int i10, float f10) {
        switch (i10) {
            case 303:
                this.f50640h.f3192p = f10;
                return true;
            case 304:
                this.f50640h.f3187k = f10;
                return true;
            case 305:
                this.f50640h.f3188l = f10;
                return true;
            case 306:
                this.f50640h.f3189m = f10;
                return true;
            case 307:
            default:
                return false;
            case 308:
                this.f50640h.f3184h = f10;
                return true;
            case 309:
                this.f50640h.f3185i = f10;
                return true;
            case 310:
                this.f50640h.f3186j = f10;
                return true;
            case 311:
                this.f50640h.f3190n = f10;
                return true;
            case 312:
                this.f50640h.f3191o = f10;
                return true;
            case 313:
                this.f50640h.f3182f = f10;
                return true;
            case 314:
                this.f50640h.f3183g = f10;
                return true;
            case 315:
                this.f50643k = f10;
                return true;
            case w.a.f53655q /* 316 */:
                this.f50644l = f10;
                return true;
        }
    }

    public boolean Y(int i10, float f10) {
        switch (i10) {
            case 600:
                this.f50641i.f50653f = f10;
                return true;
            case 601:
                this.f50641i.f50655h = f10;
                return true;
            case 602:
                this.f50641i.f50656i = f10;
                return true;
            default:
                return false;
        }
    }

    public boolean Z(int i10, int i11) {
        switch (i10) {
            case w.e.f53733u /* 605 */:
                this.f50641i.f50648a = i11;
                return true;
            case w.e.f53734v /* 606 */:
                this.f50641i.f50649b = i11;
                return true;
            case w.e.f53735w /* 607 */:
                this.f50641i.f50651d = i11;
                return true;
            case w.e.f53736x /* 608 */:
                this.f50641i.f50652e = i11;
                return true;
            case w.e.f53737y /* 609 */:
                this.f50641i.f50654g = i11;
                return true;
            case w.e.f53738z /* 610 */:
                this.f50641i.f50657j = i11;
                return true;
            case w.e.A /* 611 */:
                this.f50641i.f50659l = i11;
                return true;
            case w.e.B /* 612 */:
                this.f50641i.f50660m = i11;
                return true;
            default:
                return false;
        }
    }

    @Override // w.w
    public boolean a(int i10, int i11) {
        return X(i10, i11);
    }

    public boolean a0(int i10, String str) {
        if (i10 == 603) {
            this.f50641i.f50650c = str;
            return true;
        }
        if (i10 != 604) {
            return false;
        }
        this.f50641i.f50658k = str;
        return true;
    }

    @Override // w.w
    public boolean b(int i10, float f10) {
        if (X(i10, f10)) {
            return true;
        }
        return Y(i10, f10);
    }

    public void b0(int i10) {
        this.f50642j.f50661a = i10;
    }

    @Override // w.w
    public boolean c(int i10, String str) {
        return a0(i10, str);
    }

    @Override // w.w
    public boolean d(int i10, boolean z10) {
        return false;
    }

    @Override // w.w
    public int e(String str) {
        int iA = v.a(str);
        return iA != -1 ? iA : a0.a(str);
    }

    public e f(int i10) {
        return null;
    }

    public float g() {
        return this.f50642j.f50663c;
    }

    public int h() {
        return this.f50640h.f3181e;
    }

    public t.a i(String str) {
        return this.f50640h.g(str);
    }

    public Set<String> j() {
        return this.f50640h.h();
    }

    public int k() {
        o oVar = this.f50640h;
        return oVar.f3181e - oVar.f3179c;
    }

    public int l() {
        return this.f50640h.f3178b;
    }

    public String m() {
        return this.f50640h.k();
    }

    public e n() {
        return null;
    }

    public float o() {
        return this.f50640h.f3182f;
    }

    public float p() {
        return this.f50640h.f3183g;
    }

    public int q() {
        return this.f50640h.f3180d;
    }

    public float r() {
        return this.f50640h.f3184h;
    }

    public float s() {
        return this.f50640h.f3185i;
    }

    public float t() {
        return this.f50640h.f3186j;
    }

    public String toString() {
        return this.f50640h.f3178b + ", " + this.f50640h.f3179c + ", " + this.f50640h.f3180d + ", " + this.f50640h.f3181e;
    }

    public float u() {
        return this.f50640h.f3190n;
    }

    public float v() {
        return this.f50640h.f3191o;
    }

    public int w() {
        return this.f50640h.f3179c;
    }

    public float x() {
        return this.f50640h.f3187k;
    }

    public float y() {
        return this.f50640h.f3188l;
    }

    public float z() {
        return this.f50640h.f3189m;
    }

    public e(o oVar) {
        this.f50640h = new o();
        this.f50641i = new a();
        this.f50642j = new b();
        this.f50640h = oVar;
    }
}
