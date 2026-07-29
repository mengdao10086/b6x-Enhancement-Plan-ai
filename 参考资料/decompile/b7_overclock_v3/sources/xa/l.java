package xa;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f55024a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f55025b = new RectF();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f55026c = 0.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f55027d = 0.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f55028e = 1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f55029f = Float.MAX_VALUE;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f55030g = 1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f55031h = Float.MAX_VALUE;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f55032i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f55033j = 1.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f55034k = 0.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f55035l = 0.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f55036m = 0.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f55037n = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float[] f55038o = new float[9];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Matrix f55039p = new Matrix();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float[] f55040q = new float[9];

    public float A() {
        return this.f55035l;
    }

    public boolean B() {
        return this.f55027d > 0.0f && this.f55026c > 0.0f;
    }

    public boolean C() {
        return this.f55036m <= 0.0f && this.f55037n <= 0.0f;
    }

    public boolean D() {
        return E() && F();
    }

    public boolean E() {
        float f10 = this.f55032i;
        float f11 = this.f55030g;
        return f10 <= f11 && f11 <= 1.0f;
    }

    public boolean F() {
        float f10 = this.f55033j;
        float f11 = this.f55028e;
        return f10 <= f11 && f11 <= 1.0f;
    }

    public boolean G(float f10, float f11) {
        return L(f10) && M(f11);
    }

    public boolean H(float f10) {
        return this.f55025b.bottom >= ((float) ((int) (f10 * 100.0f))) / 100.0f;
    }

    public boolean I(float f10) {
        return this.f55025b.left <= f10 + 1.0f;
    }

    public boolean J(float f10) {
        return this.f55025b.right >= (((float) ((int) (f10 * 100.0f))) / 100.0f) - 1.0f;
    }

    public boolean K(float f10) {
        return this.f55025b.top <= f10;
    }

    public boolean L(float f10) {
        return I(f10) && J(f10);
    }

    public boolean M(float f10) {
        return K(f10) && H(f10);
    }

    public void N(Matrix matrix, RectF rectF) {
        float fHeight;
        matrix.getValues(this.f55040q);
        float[] fArr = this.f55040q;
        float f10 = fArr[2];
        float f11 = fArr[0];
        float f12 = fArr[5];
        float f13 = fArr[4];
        this.f55032i = Math.min(Math.max(this.f55030g, f11), this.f55031h);
        this.f55033j = Math.min(Math.max(this.f55028e, f13), this.f55029f);
        float fWidth = 0.0f;
        if (rectF != null) {
            fWidth = rectF.width();
            fHeight = rectF.height();
        } else {
            fHeight = 0.0f;
        }
        this.f55034k = Math.min(Math.max(f10, ((-fWidth) * (this.f55032i - 1.0f)) - this.f55036m), this.f55036m);
        float fMax = Math.max(Math.min(f12, (fHeight * (this.f55033j - 1.0f)) + this.f55037n), -this.f55037n);
        this.f55035l = fMax;
        float[] fArr2 = this.f55040q;
        fArr2[2] = this.f55034k;
        fArr2[0] = this.f55032i;
        fArr2[5] = fMax;
        fArr2[4] = this.f55033j;
        matrix.setValues(fArr2);
    }

    public float O() {
        return this.f55027d - this.f55025b.bottom;
    }

    public float P() {
        return this.f55025b.left;
    }

    public float Q() {
        return this.f55026c - this.f55025b.right;
    }

    public float R() {
        return this.f55025b.top;
    }

    public Matrix S(Matrix matrix, View view, boolean z10) {
        this.f55024a.set(matrix);
        N(this.f55024a, this.f55025b);
        if (z10) {
            view.invalidate();
        }
        matrix.set(this.f55024a);
        return matrix;
    }

    public void T(Matrix matrix) {
        matrix.reset();
        matrix.set(this.f55024a);
        matrix.postScale(1.0f, 1.0f, 0.0f, 0.0f);
    }

    public void U(float f10, float f11, float f12, float f13) {
        this.f55025b.set(f10, f11, this.f55026c - f12, this.f55027d - f13);
    }

    public void V(float f10, float f11) {
        float fP = P();
        float fR = R();
        float fQ = Q();
        float fO = O();
        this.f55027d = f11;
        this.f55026c = f10;
        U(fP, fR, fQ, fO);
    }

    public void W(float f10) {
        this.f55036m = k.e(f10);
    }

    public void X(float f10) {
        this.f55037n = k.e(f10);
    }

    public void Y(float f10) {
        if (f10 == 0.0f) {
            f10 = Float.MAX_VALUE;
        }
        this.f55031h = f10;
        N(this.f55024a, this.f55025b);
    }

    public void Z(float f10) {
        if (f10 == 0.0f) {
            f10 = Float.MAX_VALUE;
        }
        this.f55029f = f10;
        N(this.f55024a, this.f55025b);
    }

    public boolean a() {
        return this.f55032i < this.f55031h;
    }

    public void a0(float f10, float f11) {
        if (f10 < 1.0f) {
            f10 = 1.0f;
        }
        if (f11 == 0.0f) {
            f11 = Float.MAX_VALUE;
        }
        this.f55030g = f10;
        this.f55031h = f11;
        N(this.f55024a, this.f55025b);
    }

    public boolean b() {
        return this.f55033j < this.f55029f;
    }

    public void b0(float f10, float f11) {
        if (f10 < 1.0f) {
            f10 = 1.0f;
        }
        if (f11 == 0.0f) {
            f11 = Float.MAX_VALUE;
        }
        this.f55028e = f10;
        this.f55029f = f11;
        N(this.f55024a, this.f55025b);
    }

    public boolean c() {
        return this.f55032i > this.f55030g;
    }

    public void c0(float f10) {
        if (f10 < 1.0f) {
            f10 = 1.0f;
        }
        this.f55030g = f10;
        N(this.f55024a, this.f55025b);
    }

    public boolean d() {
        return this.f55033j > this.f55028e;
    }

    public void d0(float f10) {
        if (f10 < 1.0f) {
            f10 = 1.0f;
        }
        this.f55028e = f10;
        N(this.f55024a, this.f55025b);
    }

    public void e(float[] fArr, View view) {
        Matrix matrix = this.f55039p;
        matrix.reset();
        matrix.set(this.f55024a);
        matrix.postTranslate(-(fArr[0] - P()), -(fArr[1] - R()));
        S(matrix, view, true);
    }

    public Matrix e0(float f10, float f11) {
        Matrix matrix = new Matrix();
        g0(f10, f11, matrix);
        return matrix;
    }

    public float f() {
        return this.f55025b.bottom;
    }

    public Matrix f0(float f10, float f11, float f12, float f13) {
        Matrix matrix = new Matrix();
        matrix.set(this.f55024a);
        matrix.setScale(f10, f11, f12, f13);
        return matrix;
    }

    public float g() {
        return this.f55025b.height();
    }

    public void g0(float f10, float f11, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f55024a);
        matrix.setScale(f10, f11);
    }

    public float h() {
        return this.f55025b.left;
    }

    public Matrix h0(float[] fArr) {
        Matrix matrix = new Matrix();
        i0(fArr, matrix);
        return matrix;
    }

    public float i() {
        return this.f55025b.right;
    }

    public void i0(float[] fArr, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f55024a);
        matrix.postTranslate(-(fArr[0] - P()), -(fArr[1] - R()));
    }

    public float j() {
        return this.f55025b.top;
    }

    public Matrix j0(float f10, float f11) {
        Matrix matrix = new Matrix();
        m0(f10, f11, matrix);
        return matrix;
    }

    public float k() {
        return this.f55025b.width();
    }

    public Matrix k0(float f10, float f11, float f12, float f13) {
        Matrix matrix = new Matrix();
        l0(f10, f11, f12, f13, matrix);
        return matrix;
    }

    public Matrix l() {
        Matrix matrix = new Matrix();
        m(matrix);
        return matrix;
    }

    public void l0(float f10, float f11, float f12, float f13, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f55024a);
        matrix.postScale(f10, f11, f12, f13);
    }

    public void m(Matrix matrix) {
        this.f55030g = 1.0f;
        this.f55028e = 1.0f;
        matrix.set(this.f55024a);
        float[] fArr = this.f55038o;
        for (int i10 = 0; i10 < 9; i10++) {
            fArr[i10] = 0.0f;
        }
        matrix.getValues(fArr);
        fArr[2] = 0.0f;
        fArr[5] = 0.0f;
        fArr[0] = 1.0f;
        fArr[4] = 1.0f;
        matrix.setValues(fArr);
    }

    public void m0(float f10, float f11, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f55024a);
        matrix.postScale(f10, f11);
    }

    public float n() {
        return this.f55027d;
    }

    public Matrix n0(float f10, float f11) {
        Matrix matrix = new Matrix();
        o0(f10, f11, matrix);
        return matrix;
    }

    public float o() {
        return this.f55026c;
    }

    public void o0(float f10, float f11, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f55024a);
        matrix.postScale(1.4f, 1.4f, f10, f11);
    }

    public g p() {
        return g.c(this.f55025b.centerX(), this.f55025b.centerY());
    }

    public Matrix p0(float f10, float f11) {
        Matrix matrix = new Matrix();
        q0(f10, f11, matrix);
        return matrix;
    }

    public RectF q() {
        return this.f55025b;
    }

    public void q0(float f10, float f11, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f55024a);
        matrix.postScale(0.7f, 0.7f, f10, f11);
    }

    public Matrix r() {
        return this.f55024a;
    }

    public float s() {
        return this.f55031h;
    }

    public float t() {
        return this.f55029f;
    }

    public float u() {
        return this.f55030g;
    }

    public float v() {
        return this.f55028e;
    }

    public float w() {
        return this.f55032i;
    }

    public float x() {
        return this.f55033j;
    }

    public float y() {
        return Math.min(this.f55025b.width(), this.f55025b.height());
    }

    public float z() {
        return this.f55034k;
    }
}
