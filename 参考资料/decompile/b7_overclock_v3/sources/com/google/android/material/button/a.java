package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.internal.b0;
import g.k;
import g.n0;
import g.p0;
import g.r;
import je.b;
import le.j;
import le.o;
import le.s;
import n0.c;
import vd.m;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @k(api = 21)
    public static final boolean f19859u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final boolean f19860v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MaterialButton f19861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public o f19862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f19867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public PorterDuff.Mode f19869i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public ColorStateList f19870j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public ColorStateList f19871k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public ColorStateList f19872l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public Drawable f19873m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f19877q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public LayerDrawable f19879s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f19880t;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f19874n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f19875o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f19876p = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f19878r = true;

    static {
        int i10 = Build.VERSION.SDK_INT;
        f19859u = true;
        f19860v = i10 <= 22;
    }

    public a(MaterialButton materialButton, @n0 o oVar) {
        this.f19861a = materialButton;
        this.f19862b = oVar;
    }

    public void A(boolean z10) {
        this.f19874n = z10;
        K();
    }

    public void B(@p0 ColorStateList colorStateList) {
        if (this.f19871k != colorStateList) {
            this.f19871k = colorStateList;
            K();
        }
    }

    public void C(int i10) {
        if (this.f19868h != i10) {
            this.f19868h = i10;
            K();
        }
    }

    public void D(@p0 ColorStateList colorStateList) {
        if (this.f19870j != colorStateList) {
            this.f19870j = colorStateList;
            if (f() != null) {
                c.o(f(), this.f19870j);
            }
        }
    }

    public void E(@p0 PorterDuff.Mode mode) {
        if (this.f19869i != mode) {
            this.f19869i = mode;
            if (f() == null || this.f19869i == null) {
                return;
            }
            c.p(f(), this.f19869i);
        }
    }

    public void F(boolean z10) {
        this.f19878r = z10;
    }

    public final void G(@r int i10, @r int i11) {
        int iK0 = u0.k0(this.f19861a);
        int paddingTop = this.f19861a.getPaddingTop();
        int iJ0 = u0.j0(this.f19861a);
        int paddingBottom = this.f19861a.getPaddingBottom();
        int i12 = this.f19865e;
        int i13 = this.f19866f;
        this.f19866f = i11;
        this.f19865e = i10;
        if (!this.f19875o) {
            H();
        }
        u0.d2(this.f19861a, iK0, (paddingTop + i10) - i12, iJ0, (paddingBottom + i11) - i13);
    }

    public final void H() {
        this.f19861a.setInternalBackground(a());
        j jVarF = f();
        if (jVarF != null) {
            jVarF.n0(this.f19880t);
            jVarF.setState(this.f19861a.getDrawableState());
        }
    }

    public final void I(@n0 o oVar) {
        if (f19860v && !this.f19875o) {
            int iK0 = u0.k0(this.f19861a);
            int paddingTop = this.f19861a.getPaddingTop();
            int iJ0 = u0.j0(this.f19861a);
            int paddingBottom = this.f19861a.getPaddingBottom();
            H();
            u0.d2(this.f19861a, iK0, paddingTop, iJ0, paddingBottom);
            return;
        }
        if (f() != null) {
            f().setShapeAppearanceModel(oVar);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(oVar);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(oVar);
        }
    }

    public void J(int i10, int i11) {
        Drawable drawable = this.f19873m;
        if (drawable != null) {
            drawable.setBounds(this.f19863c, this.f19865e, i11 - this.f19864d, i10 - this.f19866f);
        }
    }

    public final void K() {
        j jVarF = f();
        j jVarN = n();
        if (jVarF != null) {
            jVarF.E0(this.f19868h, this.f19871k);
            if (jVarN != null) {
                jVarN.D0(this.f19868h, this.f19874n ? m.d(this.f19861a, R.attr.colorSurface) : 0);
            }
        }
    }

    @n0
    public final InsetDrawable L(Drawable drawable) {
        return new InsetDrawable(drawable, this.f19863c, this.f19865e, this.f19864d, this.f19866f);
    }

    public final Drawable a() {
        j jVar = new j(this.f19862b);
        jVar.Z(this.f19861a.getContext());
        c.o(jVar, this.f19870j);
        PorterDuff.Mode mode = this.f19869i;
        if (mode != null) {
            c.p(jVar, mode);
        }
        jVar.E0(this.f19868h, this.f19871k);
        j jVar2 = new j(this.f19862b);
        jVar2.setTint(0);
        jVar2.D0(this.f19868h, this.f19874n ? m.d(this.f19861a, R.attr.colorSurface) : 0);
        if (f19859u) {
            j jVar3 = new j(this.f19862b);
            this.f19873m = jVar3;
            c.n(jVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(b.e(this.f19872l), L(new LayerDrawable(new Drawable[]{jVar2, jVar})), this.f19873m);
            this.f19879s = rippleDrawable;
            return rippleDrawable;
        }
        je.a aVar = new je.a(this.f19862b);
        this.f19873m = aVar;
        c.o(aVar, b.e(this.f19872l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{jVar2, jVar, this.f19873m});
        this.f19879s = layerDrawable;
        return L(layerDrawable);
    }

    public int b() {
        return this.f19867g;
    }

    public int c() {
        return this.f19866f;
    }

    public int d() {
        return this.f19865e;
    }

    @p0
    public s e() {
        LayerDrawable layerDrawable = this.f19879s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f19879s.getNumberOfLayers() > 2 ? (s) this.f19879s.getDrawable(2) : (s) this.f19879s.getDrawable(1);
    }

    @p0
    public j f() {
        return g(false);
    }

    @p0
    public final j g(boolean z10) {
        LayerDrawable layerDrawable = this.f19879s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return f19859u ? (j) ((LayerDrawable) ((InsetDrawable) this.f19879s.getDrawable(0)).getDrawable()).getDrawable(!z10 ? 1 : 0) : (j) this.f19879s.getDrawable(!z10 ? 1 : 0);
    }

    @p0
    public ColorStateList h() {
        return this.f19872l;
    }

    @n0
    public o i() {
        return this.f19862b;
    }

    @p0
    public ColorStateList j() {
        return this.f19871k;
    }

    public int k() {
        return this.f19868h;
    }

    public ColorStateList l() {
        return this.f19870j;
    }

    public PorterDuff.Mode m() {
        return this.f19869i;
    }

    @p0
    public final j n() {
        return g(true);
    }

    public boolean o() {
        return this.f19875o;
    }

    public boolean p() {
        return this.f19877q;
    }

    public boolean q() {
        return this.f19878r;
    }

    public void r(@n0 TypedArray typedArray) {
        this.f19863c = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.f19864d = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.f19865e = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.f19866f = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        int i10 = R.styleable.MaterialButton_cornerRadius;
        if (typedArray.hasValue(i10)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i10, -1);
            this.f19867g = dimensionPixelSize;
            z(this.f19862b.w(dimensionPixelSize));
            this.f19876p = true;
        }
        this.f19868h = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.f19869i = b0.m(typedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f19870j = ie.c.a(this.f19861a.getContext(), typedArray, R.styleable.MaterialButton_backgroundTint);
        this.f19871k = ie.c.a(this.f19861a.getContext(), typedArray, R.styleable.MaterialButton_strokeColor);
        this.f19872l = ie.c.a(this.f19861a.getContext(), typedArray, R.styleable.MaterialButton_rippleColor);
        this.f19877q = typedArray.getBoolean(R.styleable.MaterialButton_android_checkable, false);
        this.f19880t = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
        this.f19878r = typedArray.getBoolean(R.styleable.MaterialButton_toggleCheckedStateOnClick, true);
        int iK0 = u0.k0(this.f19861a);
        int paddingTop = this.f19861a.getPaddingTop();
        int iJ0 = u0.j0(this.f19861a);
        int paddingBottom = this.f19861a.getPaddingBottom();
        if (typedArray.hasValue(R.styleable.MaterialButton_android_background)) {
            t();
        } else {
            H();
        }
        u0.d2(this.f19861a, iK0 + this.f19863c, paddingTop + this.f19865e, iJ0 + this.f19864d, paddingBottom + this.f19866f);
    }

    public void s(int i10) {
        if (f() != null) {
            f().setTint(i10);
        }
    }

    public void t() {
        this.f19875o = true;
        this.f19861a.setSupportBackgroundTintList(this.f19870j);
        this.f19861a.setSupportBackgroundTintMode(this.f19869i);
    }

    public void u(boolean z10) {
        this.f19877q = z10;
    }

    public void v(int i10) {
        if (this.f19876p && this.f19867g == i10) {
            return;
        }
        this.f19867g = i10;
        this.f19876p = true;
        z(this.f19862b.w(i10));
    }

    public void w(@r int i10) {
        G(this.f19865e, i10);
    }

    public void x(@r int i10) {
        G(i10, this.f19866f);
    }

    public void y(@p0 ColorStateList colorStateList) {
        if (this.f19872l != colorStateList) {
            this.f19872l = colorStateList;
            boolean z10 = f19859u;
            if (z10 && (this.f19861a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f19861a.getBackground()).setColor(b.e(colorStateList));
            } else {
                if (z10 || !(this.f19861a.getBackground() instanceof je.a)) {
                    return;
                }
                ((je.a) this.f19861a.getBackground()).setTintList(b.e(colorStateList));
            }
        }
    }

    public void z(@n0 o oVar) {
        this.f19862b = oVar;
        I(oVar);
    }
}
