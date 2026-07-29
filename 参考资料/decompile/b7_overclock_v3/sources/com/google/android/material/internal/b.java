package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.common.collect.LinkedHashMultimap;
import g.n0;
import g.p0;
import g.v0;
import ie.a;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class b {

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final String f20347v0 = "CollapsingTextHelper";

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final String f20348w0 = "…";

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final float f20349x0 = 0.5f;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final boolean f20350y0 = false;
    public Typeface A;
    public Typeface B;
    public Typeface C;
    public ie.a D;
    public ie.a E;

    @p0
    public CharSequence G;

    @p0
    public CharSequence H;
    public boolean I;
    public boolean K;

    @p0
    public Bitmap L;
    public Paint M;
    public float N;
    public float O;
    public float P;
    public float Q;
    public float R;
    public int S;
    public int[] T;
    public boolean U;

    @n0
    public final TextPaint V;

    @n0
    public final TextPaint W;
    public TimeInterpolator X;
    public TimeInterpolator Y;
    public float Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f20352a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public float f20353a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f20354b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f20355b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20356c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public ColorStateList f20357c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f20358d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public float f20359d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f20360e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public float f20361e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f20362f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public float f20363f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @n0
    public final Rect f20364g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public ColorStateList f20365g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public final Rect f20366h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public float f20367h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @n0
    public final RectF f20368i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public float f20369i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public float f20371j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public StaticLayout f20373k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public float f20375l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public float f20377m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ColorStateList f20378n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public float f20379n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ColorStateList f20380o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public CharSequence f20381o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f20382p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f20384q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f20386r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f20388s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f20390t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    @p0
    public p f20391t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f20392u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f20393v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Typeface f20394w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Typeface f20395x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Typeface f20396y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Typeface f20397z;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final boolean f20346u0 = false;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    @n0
    public static final Paint f20351z0 = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20370j = 16;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f20372k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f20374l = 15.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f20376m = 15.0f;
    public TextUtils.TruncateAt F = TextUtils.TruncateAt.END;
    public boolean J = true;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f20383p0 = 1;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public float f20385q0 = 0.0f;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public float f20387r0 = 1.0f;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f20389s0 = StaticLayoutBuilderCompat.f20316o;

    public class a implements a.InterfaceC0379a {
        public a() {
        }

        @Override // ie.a.InterfaceC0379a
        public void a(Typeface typeface) {
            b.this.m0(typeface);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.b$b, reason: collision with other inner class name */
    public class C0207b implements a.InterfaceC0379a {
        public C0207b() {
        }

        @Override // ie.a.InterfaceC0379a
        public void a(Typeface typeface) {
            b.this.x0(typeface);
        }
    }

    public b(View view) {
        this.f20352a = view;
        TextPaint textPaint = new TextPaint(129);
        this.V = textPaint;
        this.W = new TextPaint(textPaint);
        this.f20366h = new Rect();
        this.f20364g = new Rect();
        this.f20368i = new RectF();
        this.f20360e = e();
        a0(view.getContext().getResources().getConfiguration());
    }

    public static boolean U(float f10, float f11) {
        return Math.abs(f10 - f11) < 1.0E-5f;
    }

    public static float Z(float f10, float f11, float f12, @p0 TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f12 = timeInterpolator.getInterpolation(f12);
        }
        return kd.a.a(f10, f11, f12);
    }

    @g.l
    public static int a(@g.l int i10, @g.l int i11, @g.x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        float f11 = 1.0f - f10;
        return Color.argb(Math.round((Color.alpha(i10) * f11) + (Color.alpha(i11) * f10)), Math.round((Color.red(i10) * f11) + (Color.red(i11) * f10)), Math.round((Color.green(i10) * f11) + (Color.green(i11) * f10)), Math.round((Color.blue(i10) * f11) + (Color.blue(i11) * f10)));
    }

    public static boolean e0(@n0 Rect rect, int i10, int i11, int i12, int i13) {
        return rect.left == i10 && rect.top == i11 && rect.right == i12 && rect.bottom == i13;
    }

    public ColorStateList A() {
        return this.f20378n;
    }

    public void A0(boolean z10) {
        this.f20356c = z10;
    }

    public float B() {
        R(this.W);
        return (-this.W.ascent()) + this.W.descent();
    }

    public void B0(float f10) {
        this.f20358d = f10;
        this.f20360e = e();
    }

    public int C() {
        return this.f20370j;
    }

    @v0(23)
    public void C0(int i10) {
        this.f20389s0 = i10;
    }

    public float D() {
        R(this.W);
        return -this.W.ascent();
    }

    public final void D0(float f10) {
        h(f10);
        boolean z10 = f20346u0 && this.N != 1.0f;
        this.K = z10;
        if (z10) {
            n();
        }
        u0.n1(this.f20352a);
    }

    public float E() {
        return this.f20374l;
    }

    @v0(23)
    public void E0(float f10) {
        this.f20385q0 = f10;
    }

    public Typeface F() {
        Typeface typeface = this.f20397z;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @v0(23)
    public void F0(@g.x(from = 0.0d) float f10) {
        this.f20387r0 = f10;
    }

    public float G() {
        return this.f20354b;
    }

    public void G0(int i10) {
        if (i10 != this.f20383p0) {
            this.f20383p0 = i10;
            j();
            c0();
        }
    }

    public float H() {
        return this.f20360e;
    }

    public void H0(TimeInterpolator timeInterpolator) {
        this.X = timeInterpolator;
        c0();
    }

    @v0(23)
    public int I() {
        return this.f20389s0;
    }

    public void I0(boolean z10) {
        this.J = z10;
    }

    public int J() {
        StaticLayout staticLayout = this.f20373k0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public final boolean J0(int[] iArr) {
        this.T = iArr;
        if (!X()) {
            return false;
        }
        c0();
        return true;
    }

    @v0(23)
    public float K() {
        return this.f20373k0.getSpacingAdd();
    }

    @v0(23)
    public void K0(@p0 p pVar) {
        if (this.f20391t0 != pVar) {
            this.f20391t0 = pVar;
            d0(true);
        }
    }

    @v0(23)
    public float L() {
        return this.f20373k0.getSpacingMultiplier();
    }

    public void L0(@p0 CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.H = null;
            j();
            c0();
        }
    }

    public int M() {
        return this.f20383p0;
    }

    public void M0(TimeInterpolator timeInterpolator) {
        this.Y = timeInterpolator;
        c0();
    }

    public final Layout.Alignment N() {
        int iD = androidx.core.view.m.d(this.f20370j, this.I ? 1 : 0) & 7;
        return iD != 1 ? iD != 5 ? this.I ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.I ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
    }

    public void N0(@n0 TextUtils.TruncateAt truncateAt) {
        this.F = truncateAt;
        c0();
    }

    @p0
    public TimeInterpolator O() {
        return this.X;
    }

    public void O0(Typeface typeface) {
        boolean zN0 = n0(typeface);
        boolean zY0 = y0(typeface);
        if (zN0 || zY0) {
            c0();
        }
    }

    @p0
    public CharSequence P() {
        return this.G;
    }

    public final boolean P0() {
        return this.f20383p0 > 1 && (!this.I || this.f20356c) && !this.K;
    }

    public final void Q(@n0 TextPaint textPaint) {
        textPaint.setTextSize(this.f20376m);
        textPaint.setTypeface(this.f20394w);
        textPaint.setLetterSpacing(this.f20367h0);
    }

    public final void R(@n0 TextPaint textPaint) {
        textPaint.setTextSize(this.f20374l);
        textPaint.setTypeface(this.f20397z);
        textPaint.setLetterSpacing(this.f20369i0);
    }

    @n0
    public TextUtils.TruncateAt S() {
        return this.F;
    }

    public final void T(float f10) {
        if (this.f20356c) {
            this.f20368i.set(f10 < this.f20360e ? this.f20364g : this.f20366h);
            return;
        }
        this.f20368i.left = Z(this.f20364g.left, this.f20366h.left, f10, this.X);
        this.f20368i.top = Z(this.f20384q, this.f20386r, f10, this.X);
        this.f20368i.right = Z(this.f20364g.right, this.f20366h.right, f10, this.X);
        this.f20368i.bottom = Z(this.f20364g.bottom, this.f20366h.bottom, f10, this.X);
    }

    public final boolean V() {
        return u0.Z(this.f20352a) == 1;
    }

    public boolean W() {
        return this.J;
    }

    public final boolean X() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f20380o;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f20378n) != null && colorStateList.isStateful());
    }

    public final boolean Y(@n0 CharSequence charSequence, boolean z10) {
        return (z10 ? y0.m.f56207d : y0.m.f56206c).b(charSequence, 0, charSequence.length());
    }

    public void a0(@n0 Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f20396y;
            if (typeface != null) {
                this.f20395x = ie.g.b(configuration, typeface);
            }
            Typeface typeface2 = this.B;
            if (typeface2 != null) {
                this.A = ie.g.b(configuration, typeface2);
            }
            Typeface typeface3 = this.f20395x;
            if (typeface3 == null) {
                typeface3 = this.f20396y;
            }
            this.f20394w = typeface3;
            Typeface typeface4 = this.A;
            if (typeface4 == null) {
                typeface4 = this.B;
            }
            this.f20397z = typeface4;
            d0(true);
        }
    }

    public final void b(boolean z10) {
        StaticLayout staticLayout;
        i(1.0f, z10);
        CharSequence charSequence = this.H;
        if (charSequence != null && (staticLayout = this.f20373k0) != null) {
            this.f20381o0 = TextUtils.ellipsize(charSequence, this.V, staticLayout.getWidth(), this.F);
        }
        CharSequence charSequence2 = this.f20381o0;
        float fB0 = 0.0f;
        if (charSequence2 != null) {
            this.f20375l0 = b0(this.V, charSequence2);
        } else {
            this.f20375l0 = 0.0f;
        }
        int iD = androidx.core.view.m.d(this.f20372k, this.I ? 1 : 0);
        int i10 = iD & 112;
        if (i10 == 48) {
            this.f20386r = this.f20366h.top;
        } else if (i10 != 80) {
            this.f20386r = this.f20366h.centerY() - ((this.V.descent() - this.V.ascent()) / 2.0f);
        } else {
            this.f20386r = this.f20366h.bottom + this.V.ascent();
        }
        int i11 = iD & androidx.core.view.m.f5027d;
        if (i11 == 1) {
            this.f20390t = this.f20366h.centerX() - (this.f20375l0 / 2.0f);
        } else if (i11 != 5) {
            this.f20390t = this.f20366h.left;
        } else {
            this.f20390t = this.f20366h.right - this.f20375l0;
        }
        i(0.0f, z10);
        float height = this.f20373k0 != null ? r10.getHeight() : 0.0f;
        StaticLayout staticLayout2 = this.f20373k0;
        if (staticLayout2 == null || this.f20383p0 <= 1) {
            CharSequence charSequence3 = this.H;
            if (charSequence3 != null) {
                fB0 = b0(this.V, charSequence3);
            }
        } else {
            fB0 = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.f20373k0;
        this.f20382p = staticLayout3 != null ? staticLayout3.getLineCount() : 0;
        int iD2 = androidx.core.view.m.d(this.f20370j, this.I ? 1 : 0);
        int i12 = iD2 & 112;
        if (i12 == 48) {
            this.f20384q = this.f20364g.top;
        } else if (i12 != 80) {
            this.f20384q = this.f20364g.centerY() - (height / 2.0f);
        } else {
            this.f20384q = (this.f20364g.bottom - height) + this.V.descent();
        }
        int i13 = iD2 & androidx.core.view.m.f5027d;
        if (i13 == 1) {
            this.f20388s = this.f20364g.centerX() - (fB0 / 2.0f);
        } else if (i13 != 5) {
            this.f20388s = this.f20364g.left;
        } else {
            this.f20388s = this.f20364g.right - fB0;
        }
        j();
        D0(this.f20354b);
    }

    public final float b0(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public final void c() {
        g(this.f20354b);
    }

    public void c0() {
        d0(false);
    }

    public final float d(@g.x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        float f11 = this.f20360e;
        return f10 <= f11 ? kd.a.b(1.0f, 0.0f, this.f20358d, f11, f10) : kd.a.b(0.0f, 1.0f, f11, 1.0f, f10);
    }

    public void d0(boolean z10) {
        if ((this.f20352a.getHeight() <= 0 || this.f20352a.getWidth() <= 0) && !z10) {
            return;
        }
        b(z10);
        c();
    }

    public final float e() {
        float f10 = this.f20358d;
        return f10 + ((1.0f - f10) * 0.5f);
    }

    public final boolean f(@n0 CharSequence charSequence) {
        boolean zV = V();
        return this.J ? Y(charSequence, zV) : zV;
    }

    public void f0(int i10, int i11, int i12, int i13) {
        if (e0(this.f20366h, i10, i11, i12, i13)) {
            return;
        }
        this.f20366h.set(i10, i11, i12, i13);
        this.U = true;
    }

    public final void g(float f10) {
        float f11;
        T(f10);
        if (!this.f20356c) {
            this.f20392u = Z(this.f20388s, this.f20390t, f10, this.X);
            this.f20393v = Z(this.f20384q, this.f20386r, f10, this.X);
            D0(f10);
            f11 = f10;
        } else if (f10 < this.f20360e) {
            this.f20392u = this.f20388s;
            this.f20393v = this.f20384q;
            D0(0.0f);
            f11 = 0.0f;
        } else {
            this.f20392u = this.f20390t;
            this.f20393v = this.f20386r - Math.max(0, this.f20362f);
            D0(1.0f);
            f11 = 1.0f;
        }
        TimeInterpolator timeInterpolator = kd.a.f37167b;
        i0(1.0f - Z(0.0f, 1.0f, 1.0f - f10, timeInterpolator));
        t0(Z(1.0f, 0.0f, f10, timeInterpolator));
        if (this.f20380o != this.f20378n) {
            this.V.setColor(a(y(), w(), f11));
        } else {
            this.V.setColor(w());
        }
        float f12 = this.f20367h0;
        float f13 = this.f20369i0;
        if (f12 != f13) {
            this.V.setLetterSpacing(Z(f13, f12, f10, timeInterpolator));
        } else {
            this.V.setLetterSpacing(f12);
        }
        this.P = Z(this.f20359d0, this.Z, f10, null);
        this.Q = Z(this.f20361e0, this.f20353a0, f10, null);
        this.R = Z(this.f20363f0, this.f20355b0, f10, null);
        int iA = a(x(this.f20365g0), x(this.f20357c0), f10);
        this.S = iA;
        this.V.setShadowLayer(this.P, this.Q, this.R, iA);
        if (this.f20356c) {
            this.V.setAlpha((int) (d(f10) * this.V.getAlpha()));
        }
        u0.n1(this.f20352a);
    }

    public void g0(@n0 Rect rect) {
        f0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void h(float f10) {
        i(f10, false);
    }

    public void h0(int i10) {
        ie.d dVar = new ie.d(this.f20352a.getContext(), i10);
        if (dVar.i() != null) {
            this.f20380o = dVar.i();
        }
        if (dVar.j() != 0.0f) {
            this.f20376m = dVar.j();
        }
        ColorStateList colorStateList = dVar.f32320c;
        if (colorStateList != null) {
            this.f20357c0 = colorStateList;
        }
        this.f20353a0 = dVar.f32325h;
        this.f20355b0 = dVar.f32326i;
        this.Z = dVar.f32327j;
        this.f20367h0 = dVar.f32329l;
        ie.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        this.E = new ie.a(new a(), dVar.e());
        dVar.h(this.f20352a.getContext(), this.E);
        c0();
    }

    public final void i(float f10, boolean z10) {
        float f11;
        float f12;
        Typeface typeface;
        if (this.G == null) {
            return;
        }
        float fWidth = this.f20366h.width();
        float fWidth2 = this.f20364g.width();
        if (U(f10, 1.0f)) {
            f11 = this.f20376m;
            f12 = this.f20367h0;
            this.N = 1.0f;
            typeface = this.f20394w;
        } else {
            float f13 = this.f20374l;
            float f14 = this.f20369i0;
            Typeface typeface2 = this.f20397z;
            if (U(f10, 0.0f)) {
                this.N = 1.0f;
            } else {
                this.N = Z(this.f20374l, this.f20376m, f10, this.Y) / this.f20374l;
            }
            float f15 = this.f20376m / this.f20374l;
            fWidth = (!z10 && fWidth2 * f15 > fWidth) ? Math.min(fWidth / f15, fWidth2) : fWidth2;
            f11 = f13;
            f12 = f14;
            typeface = typeface2;
        }
        if (fWidth > 0.0f) {
            boolean z11 = this.O != f11;
            boolean z12 = this.f20371j0 != f12;
            boolean z13 = this.C != typeface;
            StaticLayout staticLayout = this.f20373k0;
            boolean z14 = z11 || z12 || (staticLayout != null && (fWidth > ((float) staticLayout.getWidth()) ? 1 : (fWidth == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z13 || this.U;
            this.O = f11;
            this.f20371j0 = f12;
            this.C = typeface;
            this.U = false;
            this.V.setLinearText(this.N != 1.0f);
            z = z14;
        }
        if (this.H == null || z) {
            this.V.setTextSize(this.O);
            this.V.setTypeface(this.C);
            this.V.setLetterSpacing(this.f20371j0);
            this.I = f(this.G);
            StaticLayout staticLayoutK = k(P0() ? this.f20383p0 : 1, fWidth, this.I);
            this.f20373k0 = staticLayoutK;
            this.H = staticLayoutK.getText();
        }
    }

    public final void i0(float f10) {
        this.f20377m0 = f10;
        u0.n1(this.f20352a);
    }

    public final void j() {
        Bitmap bitmap = this.L;
        if (bitmap != null) {
            bitmap.recycle();
            this.L = null;
        }
    }

    public void j0(ColorStateList colorStateList) {
        if (this.f20380o != colorStateList) {
            this.f20380o = colorStateList;
            c0();
        }
    }

    public final StaticLayout k(int i10, float f10, boolean z10) {
        StaticLayout staticLayoutA;
        try {
            staticLayoutA = StaticLayoutBuilderCompat.c(this.G, this.V, (int) f10).e(this.F).i(z10).d(i10 == 1 ? Layout.Alignment.ALIGN_NORMAL : N()).h(false).k(i10).j(this.f20385q0, this.f20387r0).g(this.f20389s0).m(this.f20391t0).a();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e10) {
            e10.getCause().getMessage();
            staticLayoutA = null;
        }
        return (StaticLayout) androidx.core.util.o.l(staticLayoutA);
    }

    public void k0(int i10) {
        if (this.f20372k != i10) {
            this.f20372k = i10;
            c0();
        }
    }

    public void l(@n0 Canvas canvas) {
        int iSave = canvas.save();
        if (this.H == null || this.f20368i.width() <= 0.0f || this.f20368i.height() <= 0.0f) {
            return;
        }
        this.V.setTextSize(this.O);
        float f10 = this.f20392u;
        float f11 = this.f20393v;
        boolean z10 = this.K && this.L != null;
        float f12 = this.N;
        if (f12 != 1.0f && !this.f20356c) {
            canvas.scale(f12, f12, f10, f11);
        }
        if (z10) {
            canvas.drawBitmap(this.L, f10, f11, this.M);
            canvas.restoreToCount(iSave);
            return;
        }
        if (!P0() || (this.f20356c && this.f20354b <= this.f20360e)) {
            canvas.translate(f10, f11);
            this.f20373k0.draw(canvas);
        } else {
            m(canvas, this.f20392u - this.f20373k0.getLineStart(0), f11);
        }
        canvas.restoreToCount(iSave);
    }

    public void l0(float f10) {
        if (this.f20376m != f10) {
            this.f20376m = f10;
            c0();
        }
    }

    public final void m(@n0 Canvas canvas, float f10, float f11) {
        int alpha = this.V.getAlpha();
        canvas.translate(f10, f11);
        float f12 = alpha;
        this.V.setAlpha((int) (this.f20379n0 * f12));
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            TextPaint textPaint = this.V;
            textPaint.setShadowLayer(this.P, this.Q, this.R, vd.m.a(this.S, textPaint.getAlpha()));
        }
        this.f20373k0.draw(canvas);
        this.V.setAlpha((int) (this.f20377m0 * f12));
        if (i10 >= 31) {
            TextPaint textPaint2 = this.V;
            textPaint2.setShadowLayer(this.P, this.Q, this.R, vd.m.a(this.S, textPaint2.getAlpha()));
        }
        int lineBaseline = this.f20373k0.getLineBaseline(0);
        CharSequence charSequence = this.f20381o0;
        float f13 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f13, this.V);
        if (i10 >= 31) {
            this.V.setShadowLayer(this.P, this.Q, this.R, this.S);
        }
        if (this.f20356c) {
            return;
        }
        String strTrim = this.f20381o0.toString().trim();
        if (strTrim.endsWith(f20348w0)) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        String str = strTrim;
        this.V.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.f20373k0.getLineEnd(0), str.length()), 0.0f, f13, (Paint) this.V);
    }

    public void m0(Typeface typeface) {
        if (n0(typeface)) {
            c0();
        }
    }

    public final void n() {
        if (this.L != null || this.f20364g.isEmpty() || TextUtils.isEmpty(this.H)) {
            return;
        }
        g(0.0f);
        int width = this.f20373k0.getWidth();
        int height = this.f20373k0.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.L = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.f20373k0.draw(new Canvas(this.L));
        if (this.M == null) {
            this.M = new Paint(3);
        }
    }

    public final boolean n0(Typeface typeface) {
        ie.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f20396y == typeface) {
            return false;
        }
        this.f20396y = typeface;
        Typeface typefaceB = ie.g.b(this.f20352a.getContext().getResources().getConfiguration(), typeface);
        this.f20395x = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.f20396y;
        }
        this.f20394w = typefaceB;
        return true;
    }

    public void o(@n0 RectF rectF, int i10, int i11) {
        this.I = f(this.G);
        rectF.left = Math.max(s(i10, i11), this.f20366h.left);
        rectF.top = this.f20366h.top;
        rectF.right = Math.min(t(rectF, i10, i11), this.f20366h.right);
        rectF.bottom = this.f20366h.top + r();
    }

    public void o0(int i10) {
        this.f20362f = i10;
    }

    public ColorStateList p() {
        return this.f20380o;
    }

    public void p0(int i10, int i11, int i12, int i13) {
        if (e0(this.f20364g, i10, i11, i12, i13)) {
            return;
        }
        this.f20364g.set(i10, i11, i12, i13);
        this.U = true;
    }

    public int q() {
        return this.f20372k;
    }

    public void q0(@n0 Rect rect) {
        p0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public float r() {
        Q(this.W);
        return -this.W.ascent();
    }

    public void r0(float f10) {
        if (this.f20369i0 != f10) {
            this.f20369i0 = f10;
            c0();
        }
    }

    public final float s(int i10, int i11) {
        return (i11 == 17 || (i11 & 7) == 1) ? (i10 / 2.0f) - (this.f20375l0 / 2.0f) : ((i11 & 8388613) == 8388613 || (i11 & 5) == 5) ? this.I ? this.f20366h.left : this.f20366h.right - this.f20375l0 : this.I ? this.f20366h.right - this.f20375l0 : this.f20366h.left;
    }

    public void s0(int i10) {
        ie.d dVar = new ie.d(this.f20352a.getContext(), i10);
        if (dVar.i() != null) {
            this.f20378n = dVar.i();
        }
        if (dVar.j() != 0.0f) {
            this.f20374l = dVar.j();
        }
        ColorStateList colorStateList = dVar.f32320c;
        if (colorStateList != null) {
            this.f20365g0 = colorStateList;
        }
        this.f20361e0 = dVar.f32325h;
        this.f20363f0 = dVar.f32326i;
        this.f20359d0 = dVar.f32327j;
        this.f20369i0 = dVar.f32329l;
        ie.a aVar = this.D;
        if (aVar != null) {
            aVar.c();
        }
        this.D = new ie.a(new C0207b(), dVar.e());
        dVar.h(this.f20352a.getContext(), this.D);
        c0();
    }

    public final float t(@n0 RectF rectF, int i10, int i11) {
        return (i11 == 17 || (i11 & 7) == 1) ? (i10 / 2.0f) + (this.f20375l0 / 2.0f) : ((i11 & 8388613) == 8388613 || (i11 & 5) == 5) ? this.I ? rectF.left + this.f20375l0 : this.f20366h.right : this.I ? this.f20366h.right : rectF.left + this.f20375l0;
    }

    public final void t0(float f10) {
        this.f20379n0 = f10;
        u0.n1(this.f20352a);
    }

    public float u() {
        return this.f20376m;
    }

    public void u0(ColorStateList colorStateList) {
        if (this.f20378n != colorStateList) {
            this.f20378n = colorStateList;
            c0();
        }
    }

    public Typeface v() {
        Typeface typeface = this.f20394w;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void v0(int i10) {
        if (this.f20370j != i10) {
            this.f20370j = i10;
            c0();
        }
    }

    @g.l
    public int w() {
        return x(this.f20380o);
    }

    public void w0(float f10) {
        if (this.f20374l != f10) {
            this.f20374l = f10;
            c0();
        }
    }

    @g.l
    public final int x(@p0 ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.T;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public void x0(Typeface typeface) {
        if (y0(typeface)) {
            c0();
        }
    }

    @g.l
    public final int y() {
        return x(this.f20378n);
    }

    public final boolean y0(Typeface typeface) {
        ie.a aVar = this.D;
        if (aVar != null) {
            aVar.c();
        }
        if (this.B == typeface) {
            return false;
        }
        this.B = typeface;
        Typeface typefaceB = ie.g.b(this.f20352a.getContext().getResources().getConfiguration(), typeface);
        this.A = typefaceB;
        if (typefaceB == null) {
            typefaceB = this.B;
        }
        this.f20397z = typefaceB;
        return true;
    }

    public int z() {
        return this.f20382p;
    }

    public void z0(float f10) {
        float fD = t0.a.d(f10, 0.0f, 1.0f);
        if (fD != this.f20354b) {
            this.f20354b = fD;
            c();
        }
    }
}
