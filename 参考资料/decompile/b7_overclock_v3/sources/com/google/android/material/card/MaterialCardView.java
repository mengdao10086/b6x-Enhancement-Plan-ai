package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import com.google.android.material.internal.t;
import com.google.common.collect.LinkedHashMultimap;
import g.l;
import g.n;
import g.n0;
import g.p0;
import g.q;
import g.r;
import g.v;
import g.x;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import le.k;
import le.o;
import le.s;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialCardView extends CardView implements Checkable, s {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f19881o = {R.attr.state_checkable};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f19882p = {R.attr.state_checked};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int[] f19883q = {com.google.android.material.R.attr.state_dragged};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f19884r = com.google.android.material.R.style.Widget_MaterialComponents_CardView;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f19885s = "MaterialCardView";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f19886t = "androidx.cardview.widget.CardView";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f19887u = 8388659;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f19888v = 8388691;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f19889w = 8388661;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f19890x = 8388693;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @n0
    public final qd.a f19891j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f19892k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f19893l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f19894m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f19895n;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public interface b {
        void a(MaterialCardView materialCardView, boolean z10);
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    @n0
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f19891j.j().getBounds());
        return rectF;
    }

    @Override // androidx.cardview.widget.CardView
    @n0
    public ColorStateList getCardBackgroundColor() {
        return this.f19891j.k();
    }

    @n0
    public ColorStateList getCardForegroundColor() {
        return this.f19891j.l();
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    @p0
    public Drawable getCheckedIcon() {
        return this.f19891j.m();
    }

    public int getCheckedIconGravity() {
        return this.f19891j.n();
    }

    @r
    public int getCheckedIconMargin() {
        return this.f19891j.o();
    }

    @r
    public int getCheckedIconSize() {
        return this.f19891j.p();
    }

    @p0
    public ColorStateList getCheckedIconTint() {
        return this.f19891j.q();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f19891j.A().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f19891j.A().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f19891j.A().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f19891j.A().top;
    }

    @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
    public float getProgress() {
        return this.f19891j.u();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f19891j.s();
    }

    public ColorStateList getRippleColor() {
        return this.f19891j.v();
    }

    @Override // le.s
    @n0
    public o getShapeAppearanceModel() {
        return this.f19891j.w();
    }

    @l
    @Deprecated
    public int getStrokeColor() {
        return this.f19891j.x();
    }

    @p0
    public ColorStateList getStrokeColorStateList() {
        return this.f19891j.y();
    }

    @r
    public int getStrokeWidth() {
        return this.f19891j.z();
    }

    @Override // androidx.cardview.widget.CardView
    public void h(int i10, int i11, int i12, int i13) {
        this.f19891j.Y(i10, i11, i12, i13);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f19893l;
    }

    public final void j() {
        if (Build.VERSION.SDK_INT > 26) {
            this.f19891j.i();
        }
    }

    public boolean k() {
        qd.a aVar = this.f19891j;
        return aVar != null && aVar.D();
    }

    public boolean l() {
        return this.f19894m;
    }

    public void m(int i10, int i11, int i12, int i13) {
        super.h(i10, i11, i12, i13);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.f(this, this.f19891j.j());
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + 3);
        if (k()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, f19881o);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, f19882p);
        }
        if (l()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, f19883q);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@n0 AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(f19886t);
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@n0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(f19886t);
        accessibilityNodeInfo.setCheckable(k());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f19891j.H(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f19892k) {
            if (!this.f19891j.C()) {
                this.f19891j.I(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@l int i10) {
        this.f19891j.J(ColorStateList.valueOf(i10));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f10) {
        super.setCardElevation(f10);
        this.f19891j.d0();
    }

    public void setCardForegroundColor(@p0 ColorStateList colorStateList) {
        this.f19891j.K(colorStateList);
    }

    public void setCheckable(boolean z10) {
        this.f19891j.L(z10);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (this.f19893l != z10) {
            toggle();
        }
    }

    public void setCheckedIcon(@p0 Drawable drawable) {
        this.f19891j.N(drawable);
    }

    public void setCheckedIconGravity(int i10) {
        if (this.f19891j.n() != i10) {
            this.f19891j.O(i10);
        }
    }

    public void setCheckedIconMargin(@r int i10) {
        this.f19891j.P(i10);
    }

    public void setCheckedIconMarginResource(@q int i10) {
        if (i10 != -1) {
            this.f19891j.P(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setCheckedIconResource(@v int i10) {
        this.f19891j.N(i.a.b(getContext(), i10));
    }

    public void setCheckedIconSize(@r int i10) {
        this.f19891j.Q(i10);
    }

    public void setCheckedIconSizeResource(@q int i10) {
        if (i10 != 0) {
            this.f19891j.Q(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setCheckedIconTint(@p0 ColorStateList colorStateList) {
        this.f19891j.R(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z10) {
        super.setClickable(z10);
        qd.a aVar = this.f19891j;
        if (aVar != null) {
            aVar.b0();
        }
    }

    public void setDragged(boolean z10) {
        if (this.f19894m != z10) {
            this.f19894m = z10;
            refreshDrawableState();
            j();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f10) {
        super.setMaxCardElevation(f10);
        this.f19891j.f0();
    }

    public void setOnCheckedChangeListener(@p0 b bVar) {
        this.f19895n = bVar;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z10) {
        super.setPreventCornerOverlap(z10);
        this.f19891j.f0();
        this.f19891j.c0();
    }

    public void setProgress(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        this.f19891j.T(f10);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f10) {
        super.setRadius(f10);
        this.f19891j.S(f10);
    }

    public void setRippleColor(@p0 ColorStateList colorStateList) {
        this.f19891j.U(colorStateList);
    }

    public void setRippleColorResource(@n int i10) {
        this.f19891j.U(i.a.a(getContext(), i10));
    }

    @Override // le.s
    public void setShapeAppearanceModel(@n0 o oVar) {
        setClipToOutline(oVar.u(getBoundsAsRectF()));
        this.f19891j.V(oVar);
    }

    public void setStrokeColor(@l int i10) {
        setStrokeColor(ColorStateList.valueOf(i10));
    }

    public void setStrokeWidth(@r int i10) {
        this.f19891j.X(i10);
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z10) {
        super.setUseCompatPadding(z10);
        this.f19891j.f0();
        this.f19891j.c0();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (k() && isEnabled()) {
            this.f19893l = !this.f19893l;
            refreshDrawableState();
            j();
            this.f19891j.M(this.f19893l);
            b bVar = this.f19895n;
            if (bVar != null) {
                bVar.a(this, this.f19893l);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.materialCardViewStyle);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@p0 ColorStateList colorStateList) {
        this.f19891j.J(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f19891j.W(colorStateList);
        invalidate();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialCardView(Context context, AttributeSet attributeSet, int i10) {
        int i11 = f19884r;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f19893l = false;
        this.f19894m = false;
        this.f19892k = true;
        TypedArray typedArrayK = t.k(getContext(), attributeSet, com.google.android.material.R.styleable.MaterialCardView, i10, i11, new int[0]);
        qd.a aVar = new qd.a(this, attributeSet, i10, i11);
        this.f19891j = aVar;
        aVar.J(super.getCardBackgroundColor());
        aVar.Y(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        aVar.G(typedArrayK);
        typedArrayK.recycle();
    }
}
