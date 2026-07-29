package com.google.android.material.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.q;
import com.google.android.material.internal.t;
import g.c1;
import g.d1;
import g.f;
import g.k1;
import g.l;
import g.n;
import g.n0;
import g.p0;
import g.r;
import g.t0;
import g.v;
import ie.d;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import je.b;
import kd.h;
import le.j;
import m0.g;
import n0.c;
import n0.i;
import vd.m;

/* JADX INFO: loaded from: classes3.dex */
public class a extends j implements i, Drawable.Callback, q.b {
    public static final boolean F8 = false;
    public static final String H8 = "http://schemas.android.com/apk/res-auto";
    public static final int I8 = 24;

    @n0
    public WeakReference<InterfaceC0204a> A8;
    public TextUtils.TruncateAt B8;

    @p0
    public ColorStateList C1;

    @p0
    public CharSequence C2;
    public boolean C8;
    public int D8;

    @p0
    public Drawable E7;
    public boolean E8;

    @p0
    public ColorStateList F7;
    public float G7;
    public boolean H7;
    public boolean I7;

    @p0
    public Drawable J7;

    @p0
    public ColorStateList K0;
    public float K1;
    public boolean K2;

    @p0
    public Drawable K7;

    @p0
    public ColorStateList L7;
    public float M7;

    @p0
    public CharSequence N7;
    public boolean O7;
    public boolean P7;

    @p0
    public Drawable Q7;

    @p0
    public ColorStateList R7;

    @p0
    public h S7;

    @p0
    public h T7;
    public float U7;
    public float V7;
    public float W7;
    public float X7;
    public float Y7;
    public float Z7;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public float f19950a8;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public float f19951b8;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    @n0
    public final Context f19952c8;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public final Paint f19953d8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    @p0
    public final Paint f19954e8;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public final Paint.FontMetrics f19955f8;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public final RectF f19956g8;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public final PointF f19957h8;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public final Path f19958i8;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    @n0
    public final q f19959j8;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    @p0
    public ColorStateList f19960k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public float f19961k1;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    @l
    public int f19962k8;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    @l
    public int f19963l8;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    @l
    public int f19964m8;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    @l
    public int f19965n8;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    @l
    public int f19966o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    @l
    public int f19967p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public boolean f19968q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    @l
    public int f19969r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public int f19970s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    @p0
    public ColorFilter f19971t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    @p0
    public PorterDuffColorFilter f19972u8;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public float f19973v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    @p0
    public ColorStateList f19974v2;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    @p0
    public ColorStateList f19975v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    @p0
    public PorterDuff.Mode f19976w8;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public int[] f19977x8;

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public boolean f19978y8;

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    @p0
    public ColorStateList f19979z8;
    public static final int[] G8 = {R.attr.state_enabled};
    public static final ShapeDrawable J8 = new ShapeDrawable(new OvalShape());

    /* JADX INFO: renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    public interface InterfaceC0204a {
        void a();
    }

    public a(@n0 Context context, AttributeSet attributeSet, @f int i10, @d1 int i11) {
        super(context, attributeSet, i10, i11);
        this.f19973v1 = -1.0f;
        this.f19953d8 = new Paint(1);
        this.f19955f8 = new Paint.FontMetrics();
        this.f19956g8 = new RectF();
        this.f19957h8 = new PointF();
        this.f19958i8 = new Path();
        this.f19970s8 = 255;
        this.f19976w8 = PorterDuff.Mode.SRC_IN;
        this.A8 = new WeakReference<>(null);
        Z(context);
        this.f19952c8 = context;
        q qVar = new q(this);
        this.f19959j8 = qVar;
        this.C2 = "";
        qVar.e().density = context.getResources().getDisplayMetrics().density;
        this.f19954e8 = null;
        int[] iArr = G8;
        setState(iArr);
        f3(iArr);
        this.C8 = true;
        if (b.f36351a) {
            J8.setTint(-1);
        }
    }

    public static boolean V1(@p0 int[] iArr, @f int i10) {
        if (iArr == null) {
            return false;
        }
        for (int i11 : iArr) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    @n0
    public static a a1(@n0 Context context, @p0 AttributeSet attributeSet, @f int i10, @d1 int i11) {
        a aVar = new a(context, attributeSet, i10, i11);
        aVar.i2(attributeSet, i10, i11);
        return aVar;
    }

    @n0
    public static a b1(@n0 Context context, @k1 int i10) {
        AttributeSet attributeSetG = yd.a.g(context, i10, "chip");
        int styleAttribute = attributeSetG.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = com.google.android.material.R.style.Widget_MaterialComponents_Chip_Entry;
        }
        return a1(context, attributeSetG, com.google.android.material.R.attr.chipStandaloneStyle, styleAttribute);
    }

    public static boolean f2(@p0 ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean g2(@p0 Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static boolean h2(@p0 d dVar) {
        return (dVar == null || dVar.i() == null || !dVar.i().isStateful()) ? false : true;
    }

    public float A1() {
        return this.f19950a8;
    }

    public void A2(@g.q int i10) {
        z2(this.f19952c8.getResources().getDimension(i10));
    }

    public void A3(@d1 int i10) {
        z3(new d(this.f19952c8, i10));
    }

    public float B1() {
        return this.M7;
    }

    public void B2(@p0 Drawable drawable) {
        Drawable drawableQ1 = q1();
        if (drawableQ1 != drawable) {
            float fR0 = R0();
            this.E7 = drawable != null ? c.r(drawable).mutate() : null;
            float fR02 = R0();
            O3(drawableQ1);
            if (M3()) {
                P0(this.E7);
            }
            invalidateSelf();
            if (fR0 != fR02) {
                j2();
            }
        }
    }

    public void B3(@l int i10) {
        C3(ColorStateList.valueOf(i10));
    }

    public float C1() {
        return this.Z7;
    }

    @Deprecated
    public void C2(boolean z10) {
        K2(z10);
    }

    public void C3(@p0 ColorStateList colorStateList) {
        d dVarQ1 = Q1();
        if (dVarQ1 != null) {
            dVarQ1.k(colorStateList);
            invalidateSelf();
        }
    }

    @n0
    public int[] D1() {
        return this.f19977x8;
    }

    @Deprecated
    public void D2(@g.h int i10) {
        J2(i10);
    }

    public void D3(float f10) {
        if (this.Y7 != f10) {
            this.Y7 = f10;
            invalidateSelf();
            j2();
        }
    }

    @p0
    public ColorStateList E1() {
        return this.L7;
    }

    public void E2(@v int i10) {
        B2(i.a.b(this.f19952c8, i10));
    }

    public void E3(@g.q int i10) {
        D3(this.f19952c8.getResources().getDimension(i10));
    }

    public void F1(@n0 RectF rectF) {
        U0(getBounds(), rectF);
    }

    public void F2(float f10) {
        if (this.G7 != f10) {
            float fR0 = R0();
            this.G7 = f10;
            float fR02 = R0();
            invalidateSelf();
            if (fR0 != fR02) {
                j2();
            }
        }
    }

    public void F3(@c1 int i10) {
        y3(this.f19952c8.getResources().getString(i10));
    }

    public final float G1() {
        Drawable drawable = this.f19968q8 ? this.Q7 : this.E7;
        float fCeil = this.G7;
        if (fCeil <= 0.0f && drawable != null) {
            fCeil = (float) Math.ceil(b0.e(this.f19952c8, 24));
            if (drawable.getIntrinsicHeight() <= fCeil) {
                return drawable.getIntrinsicHeight();
            }
        }
        return fCeil;
    }

    public void G2(@g.q int i10) {
        F2(this.f19952c8.getResources().getDimension(i10));
    }

    public void G3(@r float f10) {
        d dVarQ1 = Q1();
        if (dVarQ1 != null) {
            dVarQ1.l(f10);
            this.f19959j8.e().setTextSize(f10);
            a();
        }
    }

    public final float H1() {
        Drawable drawable = this.f19968q8 ? this.Q7 : this.E7;
        float f10 = this.G7;
        return (f10 > 0.0f || drawable == null) ? f10 : drawable.getIntrinsicWidth();
    }

    public void H2(@p0 ColorStateList colorStateList) {
        this.H7 = true;
        if (this.F7 != colorStateList) {
            this.F7 = colorStateList;
            if (M3()) {
                c.o(this.E7, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void H3(float f10) {
        if (this.X7 != f10) {
            this.X7 = f10;
            invalidateSelf();
            j2();
        }
    }

    public TextUtils.TruncateAt I1() {
        return this.B8;
    }

    public void I2(@n int i10) {
        H2(i.a.a(this.f19952c8, i10));
    }

    public void I3(@g.q int i10) {
        H3(this.f19952c8.getResources().getDimension(i10));
    }

    @p0
    public h J1() {
        return this.T7;
    }

    public void J2(@g.h int i10) {
        K2(this.f19952c8.getResources().getBoolean(i10));
    }

    public void J3(boolean z10) {
        if (this.f19978y8 != z10) {
            this.f19978y8 = z10;
            P3();
            onStateChange(getState());
        }
    }

    public float K1() {
        return this.W7;
    }

    public void K2(boolean z10) {
        if (this.K2 != z10) {
            boolean zM3 = M3();
            this.K2 = z10;
            boolean zM32 = M3();
            if (zM3 != zM32) {
                if (zM32) {
                    P0(this.E7);
                } else {
                    O3(this.E7);
                }
                invalidateSelf();
                j2();
            }
        }
    }

    public boolean K3() {
        return this.C8;
    }

    public float L1() {
        return this.V7;
    }

    public void L2(float f10) {
        if (this.f19961k1 != f10) {
            this.f19961k1 = f10;
            invalidateSelf();
            j2();
        }
    }

    public final boolean L3() {
        return this.P7 && this.Q7 != null && this.f19968q8;
    }

    @t0
    public int M1() {
        return this.D8;
    }

    public void M2(@g.q int i10) {
        L2(this.f19952c8.getResources().getDimension(i10));
    }

    public final boolean M3() {
        return this.K2 && this.E7 != null;
    }

    @p0
    public ColorStateList N1() {
        return this.f19974v2;
    }

    public void N2(float f10) {
        if (this.U7 != f10) {
            this.U7 = f10;
            invalidateSelf();
            j2();
        }
    }

    public final boolean N3() {
        return this.I7 && this.J7 != null;
    }

    @p0
    public h O1() {
        return this.S7;
    }

    public void O2(@g.q int i10) {
        N2(this.f19952c8.getResources().getDimension(i10));
    }

    public final void O3(@p0 Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public final void P0(@p0 Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        c.m(drawable, c.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.J7) {
            if (drawable.isStateful()) {
                drawable.setState(D1());
            }
            c.o(drawable, this.L7);
            return;
        }
        Drawable drawable2 = this.E7;
        if (drawable == drawable2 && this.H7) {
            c.o(drawable2, this.F7);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    @p0
    public CharSequence P1() {
        return this.C2;
    }

    public void P2(@p0 ColorStateList colorStateList) {
        if (this.C1 != colorStateList) {
            this.C1 = colorStateList;
            if (this.E8) {
                F0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void P3() {
        this.f19979z8 = this.f19978y8 ? b.e(this.f19974v2) : null;
    }

    public final void Q0(@n0 Rect rect, @n0 RectF rectF) {
        rectF.setEmpty();
        if (M3() || L3()) {
            float f10 = this.U7 + this.V7;
            float fH1 = H1();
            if (c.f(this) == 0) {
                float f11 = rect.left + f10;
                rectF.left = f11;
                rectF.right = f11 + fH1;
            } else {
                float f12 = rect.right - f10;
                rectF.right = f12;
                rectF.left = f12 - fH1;
            }
            float fG1 = G1();
            float fExactCenterY = rect.exactCenterY() - (fG1 / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fG1;
        }
    }

    @p0
    public d Q1() {
        return this.f19959j8.d();
    }

    public void Q2(@n int i10) {
        P2(i.a.a(this.f19952c8, i10));
    }

    @TargetApi(21)
    public final void Q3() {
        this.K7 = new RippleDrawable(b.e(N1()), this.J7, J8);
    }

    public float R0() {
        if (M3() || L3()) {
            return this.V7 + H1() + this.W7;
        }
        return 0.0f;
    }

    public float R1() {
        return this.Y7;
    }

    public void R2(float f10) {
        if (this.K1 != f10) {
            this.K1 = f10;
            this.f19953d8.setStrokeWidth(f10);
            if (this.E8) {
                super.I0(f10);
            }
            invalidateSelf();
        }
    }

    public final void S0(@n0 Rect rect, @n0 RectF rectF) {
        rectF.set(rect);
        if (N3()) {
            float f10 = this.f19951b8 + this.f19950a8 + this.M7 + this.Z7 + this.Y7;
            if (c.f(this) == 0) {
                rectF.right = rect.right - f10;
            } else {
                rectF.left = rect.left + f10;
            }
        }
    }

    public float S1() {
        return this.X7;
    }

    public void S2(@g.q int i10) {
        R2(this.f19952c8.getResources().getDimension(i10));
    }

    public final void T0(@n0 Rect rect, @n0 RectF rectF) {
        rectF.setEmpty();
        if (N3()) {
            float f10 = this.f19951b8 + this.f19950a8;
            if (c.f(this) == 0) {
                float f11 = rect.right - f10;
                rectF.right = f11;
                rectF.left = f11 - this.M7;
            } else {
                float f12 = rect.left + f10;
                rectF.left = f12;
                rectF.right = f12 + this.M7;
            }
            float fExactCenterY = rect.exactCenterY();
            float f13 = this.M7;
            float f14 = fExactCenterY - (f13 / 2.0f);
            rectF.top = f14;
            rectF.bottom = f14 + f13;
        }
    }

    @p0
    public final ColorFilter T1() {
        ColorFilter colorFilter = this.f19971t8;
        return colorFilter != null ? colorFilter : this.f19972u8;
    }

    public final void T2(@p0 ColorStateList colorStateList) {
        if (this.f19960k0 != colorStateList) {
            this.f19960k0 = colorStateList;
            onStateChange(getState());
        }
    }

    public final void U0(@n0 Rect rect, @n0 RectF rectF) {
        rectF.setEmpty();
        if (N3()) {
            float f10 = this.f19951b8 + this.f19950a8 + this.M7 + this.Z7 + this.Y7;
            if (c.f(this) == 0) {
                float f11 = rect.right;
                rectF.right = f11;
                rectF.left = f11 - f10;
            } else {
                int i10 = rect.left;
                rectF.left = i10;
                rectF.right = i10 + f10;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public boolean U1() {
        return this.f19978y8;
    }

    public void U2(@p0 Drawable drawable) {
        Drawable drawableY1 = y1();
        if (drawableY1 != drawable) {
            float fV0 = V0();
            this.J7 = drawable != null ? c.r(drawable).mutate() : null;
            if (b.f36351a) {
                Q3();
            }
            float fV02 = V0();
            O3(drawableY1);
            if (N3()) {
                P0(this.J7);
            }
            invalidateSelf();
            if (fV0 != fV02) {
                j2();
            }
        }
    }

    public float V0() {
        if (N3()) {
            return this.Z7 + this.M7 + this.f19950a8;
        }
        return 0.0f;
    }

    public void V2(@p0 CharSequence charSequence) {
        if (this.N7 != charSequence) {
            this.N7 = y0.a.c().m(charSequence);
            invalidateSelf();
        }
    }

    public final void W0(@n0 Rect rect, @n0 RectF rectF) {
        rectF.setEmpty();
        if (this.C2 != null) {
            float fR0 = this.U7 + R0() + this.X7;
            float fV0 = this.f19951b8 + V0() + this.Y7;
            if (c.f(this) == 0) {
                rectF.left = rect.left + fR0;
                rectF.right = rect.right - fV0;
            } else {
                rectF.left = rect.left + fV0;
                rectF.right = rect.right - fR0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public boolean W1() {
        return this.O7;
    }

    @Deprecated
    public void W2(boolean z10) {
        j3(z10);
    }

    public final float X0() {
        this.f19959j8.e().getFontMetrics(this.f19955f8);
        Paint.FontMetrics fontMetrics = this.f19955f8;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    @Deprecated
    public boolean X1() {
        return Y1();
    }

    @Deprecated
    public void X2(@g.h int i10) {
        i3(i10);
    }

    @n0
    public Paint.Align Y0(@n0 Rect rect, @n0 PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.C2 != null) {
            float fR0 = this.U7 + R0() + this.X7;
            if (c.f(this) == 0) {
                pointF.x = rect.left + fR0;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - fR0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - X0();
        }
        return align;
    }

    public boolean Y1() {
        return this.P7;
    }

    public void Y2(float f10) {
        if (this.f19950a8 != f10) {
            this.f19950a8 = f10;
            invalidateSelf();
            if (N3()) {
                j2();
            }
        }
    }

    public final boolean Z0() {
        return this.P7 && this.Q7 != null && this.O7;
    }

    @Deprecated
    public boolean Z1() {
        return a2();
    }

    public void Z2(@g.q int i10) {
        Y2(this.f19952c8.getResources().getDimension(i10));
    }

    @Override // com.google.android.material.internal.q.b
    public void a() {
        j2();
        invalidateSelf();
    }

    public boolean a2() {
        return this.K2;
    }

    public void a3(@v int i10) {
        U2(i.a.b(this.f19952c8, i10));
    }

    @Deprecated
    public boolean b2() {
        return d2();
    }

    public void b3(float f10) {
        if (this.M7 != f10) {
            this.M7 = f10;
            invalidateSelf();
            if (N3()) {
                j2();
            }
        }
    }

    public final void c1(@n0 Canvas canvas, @n0 Rect rect) {
        if (L3()) {
            Q0(rect, this.f19956g8);
            RectF rectF = this.f19956g8;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.Q7.setBounds(0, 0, (int) this.f19956g8.width(), (int) this.f19956g8.height());
            this.Q7.draw(canvas);
            canvas.translate(-f10, -f11);
        }
    }

    public boolean c2() {
        return g2(this.J7);
    }

    public void c3(@g.q int i10) {
        b3(this.f19952c8.getResources().getDimension(i10));
    }

    public final void d1(@n0 Canvas canvas, @n0 Rect rect) {
        if (this.E8) {
            return;
        }
        this.f19953d8.setColor(this.f19963l8);
        this.f19953d8.setStyle(Paint.Style.FILL);
        this.f19953d8.setColorFilter(T1());
        this.f19956g8.set(rect);
        canvas.drawRoundRect(this.f19956g8, o1(), o1(), this.f19953d8);
    }

    public boolean d2() {
        return this.I7;
    }

    public void d3(float f10) {
        if (this.Z7 != f10) {
            this.Z7 = f10;
            invalidateSelf();
            if (N3()) {
                j2();
            }
        }
    }

    @Override // le.j, android.graphics.drawable.Drawable
    public void draw(@n0 Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i10 = this.f19970s8;
        int iA = i10 < 255 ? pd.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i10) : 0;
        g1(canvas, bounds);
        d1(canvas, bounds);
        if (this.E8) {
            super.draw(canvas);
        }
        f1(canvas, bounds);
        i1(canvas, bounds);
        e1(canvas, bounds);
        c1(canvas, bounds);
        if (this.C8) {
            k1(canvas, bounds);
        }
        h1(canvas, bounds);
        j1(canvas, bounds);
        if (this.f19970s8 < 255) {
            canvas.restoreToCount(iA);
        }
    }

    public final void e1(@n0 Canvas canvas, @n0 Rect rect) {
        if (M3()) {
            Q0(rect, this.f19956g8);
            RectF rectF = this.f19956g8;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.E7.setBounds(0, 0, (int) this.f19956g8.width(), (int) this.f19956g8.height());
            this.E7.draw(canvas);
            canvas.translate(-f10, -f11);
        }
    }

    public boolean e2() {
        return this.E8;
    }

    public void e3(@g.q int i10) {
        d3(this.f19952c8.getResources().getDimension(i10));
    }

    public final void f1(@n0 Canvas canvas, @n0 Rect rect) {
        if (this.K1 <= 0.0f || this.E8) {
            return;
        }
        this.f19953d8.setColor(this.f19965n8);
        this.f19953d8.setStyle(Paint.Style.STROKE);
        if (!this.E8) {
            this.f19953d8.setColorFilter(T1());
        }
        RectF rectF = this.f19956g8;
        float f10 = rect.left;
        float f11 = this.K1;
        rectF.set(f10 + (f11 / 2.0f), rect.top + (f11 / 2.0f), rect.right - (f11 / 2.0f), rect.bottom - (f11 / 2.0f));
        float f12 = this.f19973v1 - (this.K1 / 2.0f);
        canvas.drawRoundRect(this.f19956g8, f12, f12, this.f19953d8);
    }

    public boolean f3(@n0 int[] iArr) {
        if (Arrays.equals(this.f19977x8, iArr)) {
            return false;
        }
        this.f19977x8 = iArr;
        if (N3()) {
            return k2(getState(), iArr);
        }
        return false;
    }

    public final void g1(@n0 Canvas canvas, @n0 Rect rect) {
        if (this.E8) {
            return;
        }
        this.f19953d8.setColor(this.f19962k8);
        this.f19953d8.setStyle(Paint.Style.FILL);
        this.f19956g8.set(rect);
        canvas.drawRoundRect(this.f19956g8, o1(), o1(), this.f19953d8);
    }

    public void g3(@p0 ColorStateList colorStateList) {
        if (this.L7 != colorStateList) {
            this.L7 = colorStateList;
            if (N3()) {
                c.o(this.J7, colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // le.j, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f19970s8;
    }

    @Override // android.graphics.drawable.Drawable
    @p0
    public ColorFilter getColorFilter() {
        return this.f19971t8;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f19961k1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.U7 + R0() + this.X7 + this.f19959j8.f(P1().toString()) + this.Y7 + V0() + this.f19951b8), this.D8);
    }

    @Override // le.j, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // le.j, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@n0 Outline outline) {
        if (this.E8) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.f19973v1);
        } else {
            outline.setRoundRect(bounds, this.f19973v1);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public final void h1(@n0 Canvas canvas, @n0 Rect rect) {
        if (N3()) {
            T0(rect, this.f19956g8);
            RectF rectF = this.f19956g8;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.J7.setBounds(0, 0, (int) this.f19956g8.width(), (int) this.f19956g8.height());
            if (b.f36351a) {
                this.K7.setBounds(this.J7.getBounds());
                this.K7.jumpToCurrentState();
                this.K7.draw(canvas);
            } else {
                this.J7.draw(canvas);
            }
            canvas.translate(-f10, -f11);
        }
    }

    public void h3(@n int i10) {
        g3(i.a.a(this.f19952c8, i10));
    }

    public final void i1(@n0 Canvas canvas, @n0 Rect rect) {
        this.f19953d8.setColor(this.f19966o8);
        this.f19953d8.setStyle(Paint.Style.FILL);
        this.f19956g8.set(rect);
        if (!this.E8) {
            canvas.drawRoundRect(this.f19956g8, o1(), o1(), this.f19953d8);
        } else {
            h(new RectF(rect), this.f19958i8);
            super.q(canvas, this.f19953d8, this.f19958i8, v());
        }
    }

    public final void i2(@p0 AttributeSet attributeSet, @f int i10, @d1 int i11) {
        TypedArray typedArrayK = t.k(this.f19952c8, attributeSet, com.google.android.material.R.styleable.Chip, i10, i11, new int[0]);
        this.E8 = typedArrayK.hasValue(com.google.android.material.R.styleable.Chip_shapeAppearance);
        T2(ie.c.a(this.f19952c8, typedArrayK, com.google.android.material.R.styleable.Chip_chipSurfaceColor));
        v2(ie.c.a(this.f19952c8, typedArrayK, com.google.android.material.R.styleable.Chip_chipBackgroundColor));
        L2(typedArrayK.getDimension(com.google.android.material.R.styleable.Chip_chipMinHeight, 0.0f));
        int i12 = com.google.android.material.R.styleable.Chip_chipCornerRadius;
        if (typedArrayK.hasValue(i12)) {
            x2(typedArrayK.getDimension(i12, 0.0f));
        }
        P2(ie.c.a(this.f19952c8, typedArrayK, com.google.android.material.R.styleable.Chip_chipStrokeColor));
        R2(typedArrayK.getDimension(com.google.android.material.R.styleable.Chip_chipStrokeWidth, 0.0f));
        t3(ie.c.a(this.f19952c8, typedArrayK, com.google.android.material.R.styleable.Chip_rippleColor));
        y3(typedArrayK.getText(com.google.android.material.R.styleable.Chip_android_text));
        d dVarG = ie.c.g(this.f19952c8, typedArrayK, com.google.android.material.R.styleable.Chip_android_textAppearance);
        dVarG.l(typedArrayK.getDimension(com.google.android.material.R.styleable.Chip_android_textSize, dVarG.j()));
        if (Build.VERSION.SDK_INT < 23) {
            dVarG.k(ie.c.a(this.f19952c8, typedArrayK, com.google.android.material.R.styleable.Chip_android_textColor));
        }
        z3(dVarG);
        int i13 = typedArrayK.getInt(com.google.android.material.R.styleable.Chip_android_ellipsize, 0);
        if (i13 == 1) {
            l3(TextUtils.TruncateAt.START);
        } else if (i13 == 2) {
            l3(TextUtils.TruncateAt.MIDDLE);
        } else if (i13 == 3) {
            l3(TextUtils.TruncateAt.END);
        }
        K2(typedArrayK.getBoolean(com.google.android.material.R.styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(H8, "chipIconEnabled") != null && attributeSet.getAttributeValue(H8, "chipIconVisible") == null) {
            K2(typedArrayK.getBoolean(com.google.android.material.R.styleable.Chip_chipIconEnabled, false));
        }
        B2(ie.c.e(this.f19952c8, typedArrayK, com.google.android.material.R.styleable.Chip_chipIcon));
        int i14 = com.google.android.material.R.styleable.Chip_chipIconTint;
        if (typedArrayK.hasValue(i14)) {
            H2(ie.c.a(this.f19952c8, typedArrayK, i14));
        }
        F2(typedArrayK.getDimension(com.google.android.material.R.styleable.Chip_chipIconSize, -1.0f));
        j3(typedArrayK.getBoolean(com.google.android.material.R.styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(H8, "closeIconEnabled") != null && attributeSet.getAttributeValue(H8, "closeIconVisible") == null) {
            j3(typedArrayK.getBoolean(com.google.android.material.R.styleable.Chip_closeIconEnabled, false));
        }
        U2(ie.c.e(this.f19952c8, typedArrayK, com.google.android.material.R.styleable.Chip_closeIcon));
        g3(ie.c.a(this.f19952c8, typedArrayK, com.google.android.material.R.styleable.Chip_closeIconTint));
        b3(typedArrayK.getDimension(com.google.android.material.R.styleable.Chip_closeIconSize, 0.0f));
        l2(typedArrayK.getBoolean(com.google.android.material.R.styleable.Chip_android_checkable, false));
        u2(typedArrayK.getBoolean(com.google.android.material.R.styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(H8, "checkedIconEnabled") != null && attributeSet.getAttributeValue(H8, "checkedIconVisible") == null) {
            u2(typedArrayK.getBoolean(com.google.android.material.R.styleable.Chip_checkedIconEnabled, false));
        }
        n2(ie.c.e(this.f19952c8, typedArrayK, com.google.android.material.R.styleable.Chip_checkedIcon));
        int i15 = com.google.android.material.R.styleable.Chip_checkedIconTint;
        if (typedArrayK.hasValue(i15)) {
            r2(ie.c.a(this.f19952c8, typedArrayK, i15));
        }
        w3(h.c(this.f19952c8, typedArrayK, com.google.android.material.R.styleable.Chip_showMotionSpec));
        m3(h.c(this.f19952c8, typedArrayK, com.google.android.material.R.styleable.Chip_hideMotionSpec));
        N2(typedArrayK.getDimension(com.google.android.material.R.styleable.Chip_chipStartPadding, 0.0f));
        q3(typedArrayK.getDimension(com.google.android.material.R.styleable.Chip_iconStartPadding, 0.0f));
        o3(typedArrayK.getDimension(com.google.android.material.R.styleable.Chip_iconEndPadding, 0.0f));
        H3(typedArrayK.getDimension(com.google.android.material.R.styleable.Chip_textStartPadding, 0.0f));
        D3(typedArrayK.getDimension(com.google.android.material.R.styleable.Chip_textEndPadding, 0.0f));
        d3(typedArrayK.getDimension(com.google.android.material.R.styleable.Chip_closeIconStartPadding, 0.0f));
        Y2(typedArrayK.getDimension(com.google.android.material.R.styleable.Chip_closeIconEndPadding, 0.0f));
        z2(typedArrayK.getDimension(com.google.android.material.R.styleable.Chip_chipEndPadding, 0.0f));
        s3(typedArrayK.getDimensionPixelSize(com.google.android.material.R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        typedArrayK.recycle();
    }

    public void i3(@g.h int i10) {
        j3(this.f19952c8.getResources().getBoolean(i10));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@n0 Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // le.j, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return f2(this.f19960k0) || f2(this.K0) || f2(this.C1) || (this.f19978y8 && f2(this.f19979z8)) || h2(this.f19959j8.d()) || Z0() || g2(this.E7) || g2(this.Q7) || f2(this.f19975v8);
    }

    public final void j1(@n0 Canvas canvas, @n0 Rect rect) {
        Paint paint = this.f19954e8;
        if (paint != null) {
            paint.setColor(g.B(-16777216, 127));
            canvas.drawRect(rect, this.f19954e8);
            if (M3() || L3()) {
                Q0(rect, this.f19956g8);
                canvas.drawRect(this.f19956g8, this.f19954e8);
            }
            if (this.C2 != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f19954e8);
            }
            if (N3()) {
                T0(rect, this.f19956g8);
                canvas.drawRect(this.f19956g8, this.f19954e8);
            }
            this.f19954e8.setColor(g.B(-65536, 127));
            S0(rect, this.f19956g8);
            canvas.drawRect(this.f19956g8, this.f19954e8);
            this.f19954e8.setColor(g.B(-16711936, 127));
            U0(rect, this.f19956g8);
            canvas.drawRect(this.f19956g8, this.f19954e8);
        }
    }

    public void j2() {
        InterfaceC0204a interfaceC0204a = this.A8.get();
        if (interfaceC0204a != null) {
            interfaceC0204a.a();
        }
    }

    public void j3(boolean z10) {
        if (this.I7 != z10) {
            boolean zN3 = N3();
            this.I7 = z10;
            boolean zN32 = N3();
            if (zN3 != zN32) {
                if (zN32) {
                    P0(this.J7);
                } else {
                    O3(this.J7);
                }
                invalidateSelf();
                j2();
            }
        }
    }

    public final void k1(@n0 Canvas canvas, @n0 Rect rect) {
        if (this.C2 != null) {
            Paint.Align alignY0 = Y0(rect, this.f19957h8);
            W0(rect, this.f19956g8);
            if (this.f19959j8.d() != null) {
                this.f19959j8.e().drawableState = getState();
                this.f19959j8.k(this.f19952c8);
            }
            this.f19959j8.e().setTextAlign(alignY0);
            int iSave = 0;
            boolean z10 = Math.round(this.f19959j8.f(P1().toString())) > Math.round(this.f19956g8.width());
            if (z10) {
                iSave = canvas.save();
                canvas.clipRect(this.f19956g8);
            }
            CharSequence charSequenceEllipsize = this.C2;
            if (z10 && this.B8 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f19959j8.e(), this.f19956g8.width(), this.B8);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF = this.f19957h8;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.f19959j8.e());
            if (z10) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    public final boolean k2(@n0 int[] iArr, @n0 int[] iArr2) {
        boolean z10;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.f19960k0;
        int iL = l(colorStateList != null ? colorStateList.getColorForState(iArr, this.f19962k8) : 0);
        boolean state = true;
        if (this.f19962k8 != iL) {
            this.f19962k8 = iL;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.K0;
        int iL2 = l(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f19963l8) : 0);
        if (this.f19963l8 != iL2) {
            this.f19963l8 = iL2;
            zOnStateChange = true;
        }
        int iM = m.m(iL, iL2);
        if ((this.f19964m8 != iM) | (y() == null)) {
            this.f19964m8 = iM;
            o0(ColorStateList.valueOf(iM));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.C1;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f19965n8) : 0;
        if (this.f19965n8 != colorForState) {
            this.f19965n8 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.f19979z8 == null || !b.f(iArr)) ? 0 : this.f19979z8.getColorForState(iArr, this.f19966o8);
        if (this.f19966o8 != colorForState2) {
            this.f19966o8 = colorForState2;
            if (this.f19978y8) {
                zOnStateChange = true;
            }
        }
        int colorForState3 = (this.f19959j8.d() == null || this.f19959j8.d().i() == null) ? 0 : this.f19959j8.d().i().getColorForState(iArr, this.f19967p8);
        if (this.f19967p8 != colorForState3) {
            this.f19967p8 = colorForState3;
            zOnStateChange = true;
        }
        boolean z11 = V1(getState(), R.attr.state_checked) && this.O7;
        if (this.f19968q8 == z11 || this.Q7 == null) {
            z10 = false;
        } else {
            float fR0 = R0();
            this.f19968q8 = z11;
            if (fR0 != R0()) {
                zOnStateChange = true;
                z10 = true;
            } else {
                zOnStateChange = true;
                z10 = false;
            }
        }
        ColorStateList colorStateList4 = this.f19975v8;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.f19969r8) : 0;
        if (this.f19969r8 != colorForState4) {
            this.f19969r8 = colorForState4;
            this.f19972u8 = yd.a.j(this, this.f19975v8, this.f19976w8);
        } else {
            state = zOnStateChange;
        }
        if (g2(this.E7)) {
            state |= this.E7.setState(iArr);
        }
        if (g2(this.Q7)) {
            state |= this.Q7.setState(iArr);
        }
        if (g2(this.J7)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.J7.setState(iArr3);
        }
        if (b.f36351a && g2(this.K7)) {
            state |= this.K7.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z10) {
            j2();
        }
        return state;
    }

    public void k3(@p0 InterfaceC0204a interfaceC0204a) {
        this.A8 = new WeakReference<>(interfaceC0204a);
    }

    @p0
    public Drawable l1() {
        return this.Q7;
    }

    public void l2(boolean z10) {
        if (this.O7 != z10) {
            this.O7 = z10;
            float fR0 = R0();
            if (!z10 && this.f19968q8) {
                this.f19968q8 = false;
            }
            float fR02 = R0();
            invalidateSelf();
            if (fR0 != fR02) {
                j2();
            }
        }
    }

    public void l3(@p0 TextUtils.TruncateAt truncateAt) {
        this.B8 = truncateAt;
    }

    @p0
    public ColorStateList m1() {
        return this.R7;
    }

    public void m2(@g.h int i10) {
        l2(this.f19952c8.getResources().getBoolean(i10));
    }

    public void m3(@p0 h hVar) {
        this.T7 = hVar;
    }

    @p0
    public ColorStateList n1() {
        return this.K0;
    }

    public void n2(@p0 Drawable drawable) {
        if (this.Q7 != drawable) {
            float fR0 = R0();
            this.Q7 = drawable;
            float fR02 = R0();
            O3(this.Q7);
            P0(this.Q7);
            invalidateSelf();
            if (fR0 != fR02) {
                j2();
            }
        }
    }

    public void n3(@g.b int i10) {
        m3(h.d(this.f19952c8, i10));
    }

    public float o1() {
        return this.E8 ? S() : this.f19973v1;
    }

    @Deprecated
    public void o2(boolean z10) {
        u2(z10);
    }

    public void o3(float f10) {
        if (this.W7 != f10) {
            float fR0 = R0();
            this.W7 = f10;
            float fR02 = R0();
            invalidateSelf();
            if (fR0 != fR02) {
                j2();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i10) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i10);
        if (M3()) {
            zOnLayoutDirectionChanged |= c.m(this.E7, i10);
        }
        if (L3()) {
            zOnLayoutDirectionChanged |= c.m(this.Q7, i10);
        }
        if (N3()) {
            zOnLayoutDirectionChanged |= c.m(this.J7, i10);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        boolean zOnLevelChange = super.onLevelChange(i10);
        if (M3()) {
            zOnLevelChange |= this.E7.setLevel(i10);
        }
        if (L3()) {
            zOnLevelChange |= this.Q7.setLevel(i10);
        }
        if (N3()) {
            zOnLevelChange |= this.J7.setLevel(i10);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // le.j, android.graphics.drawable.Drawable, com.google.android.material.internal.q.b
    public boolean onStateChange(@n0 int[] iArr) {
        if (this.E8) {
            super.onStateChange(iArr);
        }
        return k2(iArr, D1());
    }

    public float p1() {
        return this.f19951b8;
    }

    @Deprecated
    public void p2(@g.h int i10) {
        u2(this.f19952c8.getResources().getBoolean(i10));
    }

    public void p3(@g.q int i10) {
        o3(this.f19952c8.getResources().getDimension(i10));
    }

    @p0
    public Drawable q1() {
        Drawable drawable = this.E7;
        if (drawable != null) {
            return c.q(drawable);
        }
        return null;
    }

    public void q2(@v int i10) {
        n2(i.a.b(this.f19952c8, i10));
    }

    public void q3(float f10) {
        if (this.V7 != f10) {
            float fR0 = R0();
            this.V7 = f10;
            float fR02 = R0();
            invalidateSelf();
            if (fR0 != fR02) {
                j2();
            }
        }
    }

    public float r1() {
        return this.G7;
    }

    public void r2(@p0 ColorStateList colorStateList) {
        if (this.R7 != colorStateList) {
            this.R7 = colorStateList;
            if (Z0()) {
                c.o(this.Q7, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void r3(@g.q int i10) {
        q3(this.f19952c8.getResources().getDimension(i10));
    }

    @p0
    public ColorStateList s1() {
        return this.F7;
    }

    public void s2(@n int i10) {
        r2(i.a.a(this.f19952c8, i10));
    }

    public void s3(@t0 int i10) {
        this.D8 = i10;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@n0 Drawable drawable, @n0 Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j10);
        }
    }

    @Override // le.j, android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f19970s8 != i10) {
            this.f19970s8 = i10;
            invalidateSelf();
        }
    }

    @Override // le.j, android.graphics.drawable.Drawable
    public void setColorFilter(@p0 ColorFilter colorFilter) {
        if (this.f19971t8 != colorFilter) {
            this.f19971t8 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // le.j, android.graphics.drawable.Drawable, n0.i
    public void setTintList(@p0 ColorStateList colorStateList) {
        if (this.f19975v8 != colorStateList) {
            this.f19975v8 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // le.j, android.graphics.drawable.Drawable, n0.i
    public void setTintMode(@n0 PorterDuff.Mode mode) {
        if (this.f19976w8 != mode) {
            this.f19976w8 = mode;
            this.f19972u8 = yd.a.j(this, this.f19975v8, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        if (M3()) {
            visible |= this.E7.setVisible(z10, z11);
        }
        if (L3()) {
            visible |= this.Q7.setVisible(z10, z11);
        }
        if (N3()) {
            visible |= this.J7.setVisible(z10, z11);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public float t1() {
        return this.f19961k1;
    }

    public void t2(@g.h int i10) {
        u2(this.f19952c8.getResources().getBoolean(i10));
    }

    public void t3(@p0 ColorStateList colorStateList) {
        if (this.f19974v2 != colorStateList) {
            this.f19974v2 = colorStateList;
            P3();
            onStateChange(getState());
        }
    }

    public float u1() {
        return this.U7;
    }

    public void u2(boolean z10) {
        if (this.P7 != z10) {
            boolean zL3 = L3();
            this.P7 = z10;
            boolean zL32 = L3();
            if (zL3 != zL32) {
                if (zL32) {
                    P0(this.Q7);
                } else {
                    O3(this.Q7);
                }
                invalidateSelf();
                j2();
            }
        }
    }

    public void u3(@n int i10) {
        t3(i.a.a(this.f19952c8, i10));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@n0 Drawable drawable, @n0 Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    @p0
    public ColorStateList v1() {
        return this.C1;
    }

    public void v2(@p0 ColorStateList colorStateList) {
        if (this.K0 != colorStateList) {
            this.K0 = colorStateList;
            onStateChange(getState());
        }
    }

    public void v3(boolean z10) {
        this.C8 = z10;
    }

    public float w1() {
        return this.K1;
    }

    public void w2(@n int i10) {
        v2(i.a.a(this.f19952c8, i10));
    }

    public void w3(@p0 h hVar) {
        this.S7 = hVar;
    }

    public void x1(@n0 RectF rectF) {
        S0(getBounds(), rectF);
    }

    @Deprecated
    public void x2(float f10) {
        if (this.f19973v1 != f10) {
            this.f19973v1 = f10;
            setShapeAppearanceModel(getShapeAppearanceModel().w(f10));
        }
    }

    public void x3(@g.b int i10) {
        w3(h.d(this.f19952c8, i10));
    }

    @p0
    public Drawable y1() {
        Drawable drawable = this.J7;
        if (drawable != null) {
            return c.q(drawable);
        }
        return null;
    }

    @Deprecated
    public void y2(@g.q int i10) {
        x2(this.f19952c8.getResources().getDimension(i10));
    }

    public void y3(@p0 CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.C2, charSequence)) {
            return;
        }
        this.C2 = charSequence;
        this.f19959j8.j(true);
        invalidateSelf();
        j2();
    }

    @p0
    public CharSequence z1() {
        return this.N7;
    }

    public void z2(float f10) {
        if (this.f19951b8 != f10) {
            this.f19951b8 = f10;
            invalidateSelf();
            j2();
        }
    }

    public void z3(@p0 d dVar) {
        this.f19959j8.i(dVar, this.f19952c8);
    }
}
