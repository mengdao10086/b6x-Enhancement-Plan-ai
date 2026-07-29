package qd;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.card.MaterialCardView;
import com.google.common.collect.LinkedHashMultimap;
import g.d1;
import g.l;
import g.n0;
import g.p0;
import g.r;
import g.v0;
import g.x;
import ie.c;
import je.b;
import le.e;
import le.f;
import le.j;
import le.n;
import le.o;
import vd.m;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f47286u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final double f47287v = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final float f47288w = 1.5f;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f47289x = 2;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Drawable f47290y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final MaterialCardView f47291a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final j f47293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final j f47294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @r
    public int f47295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @r
    public int f47296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f47297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @r
    public int f47298h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public Drawable f47299i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public Drawable f47300j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public ColorStateList f47301k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public ColorStateList f47302l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public o f47303m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @p0
    public ColorStateList f47304n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public Drawable f47305o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public LayerDrawable f47306p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @p0
    public j f47307q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public j f47308r;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f47310t;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Rect f47292b = new Rect();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f47309s = false;

    /* JADX INFO: renamed from: qd.a$a, reason: collision with other inner class name */
    public class C0544a extends InsetDrawable {
        public C0544a(Drawable drawable, int i10, int i11, int i12, int i13) {
            super(drawable, i10, i11, i12, i13);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    static {
        f47290y = Build.VERSION.SDK_INT <= 28 ? new ColorDrawable() : null;
    }

    public a(@n0 MaterialCardView materialCardView, AttributeSet attributeSet, int i10, @d1 int i11) {
        this.f47291a = materialCardView;
        j jVar = new j(materialCardView.getContext(), attributeSet, i10, i11);
        this.f47293c = jVar;
        jVar.Z(materialCardView.getContext());
        jVar.v0(-12303292);
        o.b bVarV = jVar.getShapeAppearanceModel().v();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R.styleable.CardView, i10, R.style.CardView);
        int i12 = R.styleable.CardView_cardCornerRadius;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            bVarV.o(typedArrayObtainStyledAttributes.getDimension(i12, 0.0f));
        }
        this.f47294d = new j();
        V(bVarV.m());
        typedArrayObtainStyledAttributes.recycle();
    }

    @n0
    public Rect A() {
        return this.f47292b;
    }

    @n0
    public final Drawable B(Drawable drawable) {
        int iCeil;
        int i10;
        if (this.f47291a.getUseCompatPadding()) {
            int iCeil2 = (int) Math.ceil(d());
            iCeil = (int) Math.ceil(c());
            i10 = iCeil2;
        } else {
            iCeil = 0;
            i10 = 0;
        }
        return new C0544a(drawable, iCeil, i10, iCeil, i10);
    }

    public boolean C() {
        return this.f47309s;
    }

    public boolean D() {
        return this.f47310t;
    }

    public final boolean E() {
        return (this.f47297g & 80) == 80;
    }

    public final boolean F() {
        return (this.f47297g & 8388613) == 8388613;
    }

    public void G(@n0 TypedArray typedArray) {
        ColorStateList colorStateListA = c.a(this.f47291a.getContext(), typedArray, R.styleable.MaterialCardView_strokeColor);
        this.f47304n = colorStateListA;
        if (colorStateListA == null) {
            this.f47304n = ColorStateList.valueOf(-1);
        }
        this.f47298h = typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_strokeWidth, 0);
        boolean z10 = typedArray.getBoolean(R.styleable.MaterialCardView_android_checkable, false);
        this.f47310t = z10;
        this.f47291a.setLongClickable(z10);
        this.f47302l = c.a(this.f47291a.getContext(), typedArray, R.styleable.MaterialCardView_checkedIconTint);
        N(c.e(this.f47291a.getContext(), typedArray, R.styleable.MaterialCardView_checkedIcon));
        Q(typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconSize, 0));
        P(typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconMargin, 0));
        this.f47297g = typedArray.getInteger(R.styleable.MaterialCardView_checkedIconGravity, 8388661);
        ColorStateList colorStateListA2 = c.a(this.f47291a.getContext(), typedArray, R.styleable.MaterialCardView_rippleColor);
        this.f47301k = colorStateListA2;
        if (colorStateListA2 == null) {
            this.f47301k = ColorStateList.valueOf(m.d(this.f47291a, R.attr.colorControlHighlight));
        }
        K(c.a(this.f47291a.getContext(), typedArray, R.styleable.MaterialCardView_cardForegroundColor));
        g0();
        d0();
        h0();
        this.f47291a.setBackgroundInternal(B(this.f47293c));
        Drawable drawableR = this.f47291a.isClickable() ? r() : this.f47294d;
        this.f47299i = drawableR;
        this.f47291a.setForeground(B(drawableR));
    }

    public void H(int i10, int i11) {
        int iCeil;
        int i12;
        int i13;
        if (this.f47306p != null) {
            int iCeil2 = 0;
            if (this.f47291a.getUseCompatPadding()) {
                iCeil = (int) Math.ceil(d() * 2.0f);
                iCeil2 = (int) Math.ceil(c() * 2.0f);
            } else {
                iCeil = 0;
            }
            int i14 = F() ? ((i10 - this.f47295e) - this.f47296f) - iCeil2 : this.f47295e;
            int i15 = E() ? this.f47295e : ((i11 - this.f47295e) - this.f47296f) - iCeil;
            int i16 = F() ? this.f47295e : ((i10 - this.f47295e) - this.f47296f) - iCeil2;
            int i17 = E() ? ((i11 - this.f47295e) - this.f47296f) - iCeil : this.f47295e;
            if (u0.Z(this.f47291a) == 1) {
                i13 = i16;
                i12 = i14;
            } else {
                i12 = i16;
                i13 = i14;
            }
            this.f47306p.setLayerInset(2, i13, i17, i12, i15);
        }
    }

    public void I(boolean z10) {
        this.f47309s = z10;
    }

    public void J(ColorStateList colorStateList) {
        this.f47293c.o0(colorStateList);
    }

    public void K(@p0 ColorStateList colorStateList) {
        j jVar = this.f47294d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        jVar.o0(colorStateList);
    }

    public void L(boolean z10) {
        this.f47310t = z10;
    }

    public void M(boolean z10) {
        Drawable drawable = this.f47300j;
        if (drawable != null) {
            drawable.setAlpha(z10 ? 255 : 0);
        }
    }

    public void N(@p0 Drawable drawable) {
        if (drawable != null) {
            Drawable drawableMutate = n0.c.r(drawable).mutate();
            this.f47300j = drawableMutate;
            n0.c.o(drawableMutate, this.f47302l);
            M(this.f47291a.isChecked());
        } else {
            this.f47300j = f47290y;
        }
        LayerDrawable layerDrawable = this.f47306p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, this.f47300j);
        }
    }

    public void O(int i10) {
        this.f47297g = i10;
        H(this.f47291a.getMeasuredWidth(), this.f47291a.getMeasuredHeight());
    }

    public void P(@r int i10) {
        this.f47295e = i10;
    }

    public void Q(@r int i10) {
        this.f47296f = i10;
    }

    public void R(@p0 ColorStateList colorStateList) {
        this.f47302l = colorStateList;
        Drawable drawable = this.f47300j;
        if (drawable != null) {
            n0.c.o(drawable, colorStateList);
        }
    }

    public void S(float f10) {
        V(this.f47303m.w(f10));
        this.f47299i.invalidateSelf();
        if (a0() || Z()) {
            c0();
        }
        if (a0()) {
            f0();
        }
    }

    public void T(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        this.f47293c.p0(f10);
        j jVar = this.f47294d;
        if (jVar != null) {
            jVar.p0(f10);
        }
        j jVar2 = this.f47308r;
        if (jVar2 != null) {
            jVar2.p0(f10);
        }
    }

    public void U(@p0 ColorStateList colorStateList) {
        this.f47301k = colorStateList;
        g0();
    }

    public void V(@n0 o oVar) {
        this.f47303m = oVar;
        this.f47293c.setShapeAppearanceModel(oVar);
        this.f47293c.u0(!r0.e0());
        j jVar = this.f47294d;
        if (jVar != null) {
            jVar.setShapeAppearanceModel(oVar);
        }
        j jVar2 = this.f47308r;
        if (jVar2 != null) {
            jVar2.setShapeAppearanceModel(oVar);
        }
        j jVar3 = this.f47307q;
        if (jVar3 != null) {
            jVar3.setShapeAppearanceModel(oVar);
        }
    }

    public void W(ColorStateList colorStateList) {
        if (this.f47304n == colorStateList) {
            return;
        }
        this.f47304n = colorStateList;
        h0();
    }

    public void X(@r int i10) {
        if (i10 == this.f47298h) {
            return;
        }
        this.f47298h = i10;
        h0();
    }

    public void Y(int i10, int i11, int i12, int i13) {
        this.f47292b.set(i10, i11, i12, i13);
        c0();
    }

    public final boolean Z() {
        return this.f47291a.getPreventCornerOverlap() && !e();
    }

    public final float a() {
        return Math.max(Math.max(b(this.f47303m.q(), this.f47293c.S()), b(this.f47303m.s(), this.f47293c.T())), Math.max(b(this.f47303m.k(), this.f47293c.u()), b(this.f47303m.i(), this.f47293c.t())));
    }

    public final boolean a0() {
        return this.f47291a.getPreventCornerOverlap() && e() && this.f47291a.getUseCompatPadding();
    }

    public final float b(e eVar, float f10) {
        if (eVar instanceof n) {
            return (float) ((1.0d - f47287v) * ((double) f10));
        }
        if (eVar instanceof f) {
            return f10 / 2.0f;
        }
        return 0.0f;
    }

    public void b0() {
        Drawable drawable = this.f47299i;
        Drawable drawableR = this.f47291a.isClickable() ? r() : this.f47294d;
        this.f47299i = drawableR;
        if (drawable != drawableR) {
            e0(drawableR);
        }
    }

    public final float c() {
        return this.f47291a.getMaxCardElevation() + (a0() ? a() : 0.0f);
    }

    public void c0() {
        int iA = (int) ((Z() || a0() ? a() : 0.0f) - t());
        MaterialCardView materialCardView = this.f47291a;
        Rect rect = this.f47292b;
        materialCardView.m(rect.left + iA, rect.top + iA, rect.right + iA, rect.bottom + iA);
    }

    public final float d() {
        return (this.f47291a.getMaxCardElevation() * 1.5f) + (a0() ? a() : 0.0f);
    }

    public void d0() {
        this.f47293c.n0(this.f47291a.getCardElevation());
    }

    public final boolean e() {
        return this.f47293c.e0();
    }

    public final void e0(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 23 || !(this.f47291a.getForeground() instanceof InsetDrawable)) {
            this.f47291a.setForeground(B(drawable));
        } else {
            ((InsetDrawable) this.f47291a.getForeground()).setDrawable(drawable);
        }
    }

    @n0
    public final Drawable f() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        j jVarH = h();
        this.f47307q = jVarH;
        jVarH.o0(this.f47301k);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, this.f47307q);
        return stateListDrawable;
    }

    public void f0() {
        if (!C()) {
            this.f47291a.setBackgroundInternal(B(this.f47293c));
        }
        this.f47291a.setForeground(B(this.f47299i));
    }

    @n0
    public final Drawable g() {
        if (!b.f36351a) {
            return f();
        }
        this.f47308r = h();
        return new RippleDrawable(this.f47301k, null, this.f47308r);
    }

    public final void g0() {
        Drawable drawable;
        if (b.f36351a && (drawable = this.f47305o) != null) {
            ((RippleDrawable) drawable).setColor(this.f47301k);
            return;
        }
        j jVar = this.f47307q;
        if (jVar != null) {
            jVar.o0(this.f47301k);
        }
    }

    @n0
    public final j h() {
        return new j(this.f47303m);
    }

    public void h0() {
        this.f47294d.E0(this.f47298h, this.f47304n);
    }

    @v0(api = 23)
    public void i() {
        Drawable drawable = this.f47305o;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i10 = bounds.bottom;
            this.f47305o.setBounds(bounds.left, bounds.top, bounds.right, i10 - 1);
            this.f47305o.setBounds(bounds.left, bounds.top, bounds.right, i10);
        }
    }

    @n0
    public j j() {
        return this.f47293c;
    }

    public ColorStateList k() {
        return this.f47293c.y();
    }

    public ColorStateList l() {
        return this.f47294d.y();
    }

    @p0
    public Drawable m() {
        return this.f47300j;
    }

    public int n() {
        return this.f47297g;
    }

    @r
    public int o() {
        return this.f47295e;
    }

    @r
    public int p() {
        return this.f47296f;
    }

    @p0
    public ColorStateList q() {
        return this.f47302l;
    }

    @n0
    public final Drawable r() {
        if (this.f47305o == null) {
            this.f47305o = g();
        }
        if (this.f47306p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f47305o, this.f47294d, this.f47300j});
            this.f47306p = layerDrawable;
            layerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.f47306p;
    }

    public float s() {
        return this.f47293c.S();
    }

    public final float t() {
        if (this.f47291a.getPreventCornerOverlap() && this.f47291a.getUseCompatPadding()) {
            return (float) ((1.0d - f47287v) * ((double) this.f47291a.getCardViewRadius()));
        }
        return 0.0f;
    }

    @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
    public float u() {
        return this.f47293c.z();
    }

    @p0
    public ColorStateList v() {
        return this.f47301k;
    }

    public o w() {
        return this.f47303m;
    }

    @l
    public int x() {
        ColorStateList colorStateList = this.f47304n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    @p0
    public ColorStateList y() {
        return this.f47304n;
    }

    @r
    public int z() {
        return this.f47298h;
    }
}
