package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.i;
import androidx.appcompat.widget.o;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.r0;
import androidx.core.view.u0;
import androidx.core.widget.w;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.a;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.c0;
import com.google.android.material.internal.t;
import com.google.android.material.stateful.ExtendableSavedState;
import g.d0;
import g.i1;
import g.l;
import g.n0;
import g.p0;
import g.q;
import g.t0;
import g.v;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kd.h;
import kd.k;
import le.s;

/* JADX INFO: loaded from: classes3.dex */
public class FloatingActionButton extends c0 implements r0, w, ae.a, s, CoordinatorLayout.b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f20195r = "FloatingActionButton";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f20196s = "expandableWidgetHelper";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f20197t = R.style.Widget_Design_FloatingActionButton;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f20198u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f20199v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f20200w = -1;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f20201x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f20202y = 470;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public ColorStateList f20203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public PorterDuff.Mode f20204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public ColorStateList f20205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public PorterDuff.Mode f20206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public ColorStateList f20207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f20209h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f20210i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20211j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f20212k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f20213l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Rect f20214m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f20215n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @n0
    public final o f20216o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @n0
    public final ae.c f20217p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.google.android.material.floatingactionbutton.a f20218q;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: G */
        public /* bridge */ /* synthetic */ boolean b(@n0 CoordinatorLayout coordinatorLayout, @n0 FloatingActionButton floatingActionButton, @n0 Rect rect) {
            return super.b(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ boolean H() {
            return super.H();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: K */
        public /* bridge */ /* synthetic */ boolean i(CoordinatorLayout coordinatorLayout, @n0 FloatingActionButton floatingActionButton, View view) {
            return super.i(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: L */
        public /* bridge */ /* synthetic */ boolean m(@n0 CoordinatorLayout coordinatorLayout, @n0 FloatingActionButton floatingActionButton, int i10) {
            return super.m(coordinatorLayout, floatingActionButton, i10);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ void M(boolean z10) {
            super.M(z10);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        @i1
        public /* bridge */ /* synthetic */ void N(b bVar) {
            super.N(bVar);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void h(@n0 CoordinatorLayout.g gVar) {
            super.h(gVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public class a implements a.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f20223a;

        public a(b bVar) {
            this.f20223a = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.a.k
        public void a() {
            this.f20223a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.a.k
        public void b() {
            this.f20223a.a(FloatingActionButton.this);
        }
    }

    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    public class c implements ke.c {
        public c() {
        }

        @Override // ke.c
        public void a(int i10, int i11, int i12, int i13) {
            FloatingActionButton.this.f20214m.set(i10, i11, i12, i13);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i10 + floatingActionButton.f20211j, i11 + FloatingActionButton.this.f20211j, i12 + FloatingActionButton.this.f20211j, i13 + FloatingActionButton.this.f20211j);
        }

        @Override // ke.c
        public float b() {
            return FloatingActionButton.this.getSizeDimension() / 2.0f;
        }

        @Override // ke.c
        public void c(@p0 Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // ke.c
        public boolean d() {
            return FloatingActionButton.this.f20213l;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface d {
    }

    public class e<T extends FloatingActionButton> implements a.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final k<T> f20226a;

        public e(@n0 k<T> kVar) {
            this.f20226a = kVar;
        }

        @Override // com.google.android.material.floatingactionbutton.a.j
        public void a() {
            this.f20226a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.a.j
        public void b() {
            this.f20226a.a(FloatingActionButton.this);
        }

        public boolean equals(@p0 Object obj) {
            return (obj instanceof e) && ((e) obj).f20226a.equals(this.f20226a);
        }

        public int hashCode() {
            return this.f20226a.hashCode();
        }
    }

    public FloatingActionButton(@n0 Context context) {
        this(context, null);
    }

    private com.google.android.material.floatingactionbutton.a getImpl() {
        if (this.f20218q == null) {
            this.f20218q = h();
        }
        return this.f20218q;
    }

    public static int v(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i10, size);
        }
        if (mode == 0) {
            return i10;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    @p0
    public final a.k A(@p0 b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    public void d(@n0 Animator.AnimatorListener animatorListener) {
        getImpl().e(animatorListener);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().E(getDrawableState());
    }

    public void e(@n0 Animator.AnimatorListener animatorListener) {
        getImpl().f(animatorListener);
    }

    public void f(@n0 k<? extends FloatingActionButton> kVar) {
        getImpl().g(new e(kVar));
    }

    public void g() {
        setCustomSize(0);
    }

    @Override // android.view.View
    @p0
    public ColorStateList getBackgroundTintList() {
        return this.f20203b;
    }

    @Override // android.view.View
    @p0
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f20204c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @n0
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().n();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().q();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().t();
    }

    @p0
    public Drawable getContentBackground() {
        return getImpl().m();
    }

    @t0
    public int getCustomSize() {
        return this.f20210i;
    }

    @Override // ae.a
    public int getExpandedComponentIdHint() {
        return this.f20217p.b();
    }

    @p0
    public h getHideMotionSpec() {
        return getImpl().p();
    }

    @l
    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f20207f;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    @p0
    public ColorStateList getRippleColorStateList() {
        return this.f20207f;
    }

    @Override // le.s
    @n0
    public le.o getShapeAppearanceModel() {
        return (le.o) androidx.core.util.o.l(getImpl().u());
    }

    @p0
    public h getShowMotionSpec() {
        return getImpl().v();
    }

    public int getSize() {
        return this.f20209h;
    }

    public int getSizeDimension() {
        return k(this.f20209h);
    }

    @Override // androidx.core.view.r0
    @p0
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.r0
    @p0
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.w
    @p0
    public ColorStateList getSupportImageTintList() {
        return this.f20205d;
    }

    @Override // androidx.core.widget.w
    @p0
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f20206e;
    }

    public boolean getUseCompatPadding() {
        return this.f20213l;
    }

    @n0
    public final com.google.android.material.floatingactionbutton.a h() {
        return new be.d(this, new c());
    }

    @Deprecated
    public boolean i(@n0 Rect rect) {
        if (!u0.U0(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        q(rect);
        return true;
    }

    @Override // ae.b
    public boolean isExpanded() {
        return this.f20217p.c();
    }

    public void j(@n0 Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        q(rect);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().A();
    }

    public final int k(int i10) {
        int i11 = this.f20210i;
        if (i11 != 0) {
            return i11;
        }
        Resources resources = getResources();
        return i10 != -1 ? i10 != 1 ? resources.getDimensionPixelSize(R.dimen.design_fab_size_normal) : resources.getDimensionPixelSize(R.dimen.design_fab_size_mini) : Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? k(1) : k(0);
    }

    public void l() {
        m(null);
    }

    public void m(@p0 b bVar) {
        n(bVar, true);
    }

    public void n(@p0 b bVar, boolean z10) {
        getImpl().w(A(bVar), z10);
    }

    public boolean o() {
        return getImpl().y();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().B();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().D();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        int sizeDimension = getSizeDimension();
        this.f20211j = (sizeDimension - this.f20212k) / 2;
        getImpl().i0();
        int iMin = Math.min(v(sizeDimension, i10), v(sizeDimension, i11));
        Rect rect = this.f20214m;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.a());
        this.f20217p.d((Bundle) androidx.core.util.o.l(extendableSavedState.f20766c.get(f20196s)));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(parcelableOnSaveInstanceState);
        extendableSavedState.f20766c.put(f20196s, this.f20217p.e());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@n0 MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && i(this.f20215n) && !this.f20215n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean p() {
        return getImpl().z();
    }

    public final void q(@n0 Rect rect) {
        int i10 = rect.left;
        Rect rect2 = this.f20214m;
        rect.left = i10 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    public final void r() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f20205d;
        if (colorStateList == null) {
            n0.c.c(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f20206e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(i.e(colorForState, mode));
    }

    public void s(@n0 Animator.AnimatorListener animatorListener) {
        getImpl().K(animatorListener);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
    }

    @Override // android.view.View
    public void setBackgroundTintList(@p0 ColorStateList colorStateList) {
        if (this.f20203b != colorStateList) {
            this.f20203b = colorStateList;
            getImpl().O(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@p0 PorterDuff.Mode mode) {
        if (this.f20204c != mode) {
            this.f20204c = mode;
            getImpl().P(mode);
        }
    }

    public void setCompatElevation(float f10) {
        getImpl().Q(f10);
    }

    public void setCompatElevationResource(@q int i10) {
        setCompatElevation(getResources().getDimension(i10));
    }

    public void setCompatHoveredFocusedTranslationZ(float f10) {
        getImpl().T(f10);
    }

    public void setCompatHoveredFocusedTranslationZResource(@q int i10) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i10));
    }

    public void setCompatPressedTranslationZ(float f10) {
        getImpl().X(f10);
    }

    public void setCompatPressedTranslationZResource(@q int i10) {
        setCompatPressedTranslationZ(getResources().getDimension(i10));
    }

    public void setCustomSize(@t0 int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i10 != this.f20210i) {
            this.f20210i = i10;
            requestLayout();
        }
    }

    @Override // android.view.View
    @v0(21)
    public void setElevation(float f10) {
        super.setElevation(f10);
        getImpl().j0(f10);
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        if (z10 != getImpl().o()) {
            getImpl().R(z10);
            requestLayout();
        }
    }

    @Override // ae.b
    public boolean setExpanded(boolean z10) {
        return this.f20217p.f(z10);
    }

    @Override // ae.a
    public void setExpandedComponentIdHint(@d0 int i10) {
        this.f20217p.g(i10);
    }

    public void setHideMotionSpec(@p0 h hVar) {
        getImpl().S(hVar);
    }

    public void setHideMotionSpecResource(@g.b int i10) {
        setHideMotionSpec(h.d(getContext(), i10));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@p0 Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().h0();
            if (this.f20205d != null) {
                r();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(@v int i10) {
        this.f20216o.i(i10);
        r();
    }

    public void setMaxImageSize(int i10) {
        this.f20212k = i10;
        getImpl().V(i10);
    }

    public void setRippleColor(@l int i10) {
        setRippleColor(ColorStateList.valueOf(i10));
    }

    @Override // android.view.View
    public void setScaleX(float f10) {
        super.setScaleX(f10);
        getImpl().I();
    }

    @Override // android.view.View
    public void setScaleY(float f10) {
        super.setScaleY(f10);
        getImpl().I();
    }

    @i1
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowPaddingEnabled(boolean z10) {
        getImpl().Z(z10);
    }

    @Override // le.s
    public void setShapeAppearanceModel(@n0 le.o oVar) {
        getImpl().a0(oVar);
    }

    public void setShowMotionSpec(@p0 h hVar) {
        getImpl().b0(hVar);
    }

    public void setShowMotionSpecResource(@g.b int i10) {
        setShowMotionSpec(h.d(getContext(), i10));
    }

    public void setSize(int i10) {
        this.f20210i = 0;
        if (i10 != this.f20209h) {
            this.f20209h = i10;
            requestLayout();
        }
    }

    @Override // androidx.core.view.r0
    public void setSupportBackgroundTintList(@p0 ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.r0
    public void setSupportBackgroundTintMode(@p0 PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.w
    public void setSupportImageTintList(@p0 ColorStateList colorStateList) {
        if (this.f20205d != colorStateList) {
            this.f20205d = colorStateList;
            r();
        }
    }

    @Override // androidx.core.widget.w
    public void setSupportImageTintMode(@p0 PorterDuff.Mode mode) {
        if (this.f20206e != mode) {
            this.f20206e = mode;
            r();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f10) {
        super.setTranslationX(f10);
        getImpl().J();
    }

    @Override // android.view.View
    public void setTranslationY(float f10) {
        super.setTranslationY(f10);
        getImpl().J();
    }

    @Override // android.view.View
    public void setTranslationZ(float f10) {
        super.setTranslationZ(f10);
        getImpl().J();
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f20213l != z10) {
            this.f20213l = z10;
            getImpl().C();
        }
    }

    @Override // com.google.android.material.internal.c0, android.widget.ImageView, android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    public void t(@n0 Animator.AnimatorListener animatorListener) {
        getImpl().L(animatorListener);
    }

    public void u(@n0 k<? extends FloatingActionButton> kVar) {
        getImpl().M(new e(kVar));
    }

    public boolean w() {
        return getImpl().o();
    }

    public void x() {
        y(null);
    }

    public void y(@p0 b bVar) {
        z(bVar, true);
    }

    public void z(@p0 b bVar, boolean z10) {
        getImpl().f0(A(bVar), z10);
    }

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final boolean f20219d = true;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f20220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f20221b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f20222c;

        public BaseBehavior() {
            this.f20222c = true;
        }

        public static boolean I(@n0 View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.g) {
                return ((CoordinatorLayout.g) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public boolean b(@n0 CoordinatorLayout coordinatorLayout, @n0 FloatingActionButton floatingActionButton, @n0 Rect rect) {
            Rect rect2 = floatingActionButton.f20214m;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public boolean H() {
            return this.f20222c;
        }

        public final void J(@n0 CoordinatorLayout coordinatorLayout, @n0 FloatingActionButton floatingActionButton) {
            Rect rect = floatingActionButton.f20214m;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.g gVar = (CoordinatorLayout.g) floatingActionButton.getLayoutParams();
            int i10 = 0;
            int i11 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) gVar).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) gVar).leftMargin ? -rect.left : 0;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin) {
                i10 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) gVar).topMargin) {
                i10 = -rect.top;
            }
            if (i10 != 0) {
                u0.f1(floatingActionButton, i10);
            }
            if (i11 != 0) {
                u0.e1(floatingActionButton, i11);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
        public boolean i(CoordinatorLayout coordinatorLayout, @n0 FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                P(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!I(view)) {
                return false;
            }
            Q(view, floatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
        public boolean m(@n0 CoordinatorLayout coordinatorLayout, @n0 FloatingActionButton floatingActionButton, int i10) {
            List<View> listQ = coordinatorLayout.q(floatingActionButton);
            int size = listQ.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = listQ.get(i11);
                if (!(view instanceof AppBarLayout)) {
                    if (I(view) && Q(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (P(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.N(floatingActionButton, i10);
            J(coordinatorLayout, floatingActionButton);
            return true;
        }

        public void M(boolean z10) {
            this.f20222c = z10;
        }

        @i1
        public void N(b bVar) {
            this.f20221b = bVar;
        }

        public final boolean O(@n0 View view, @n0 FloatingActionButton floatingActionButton) {
            return this.f20222c && ((CoordinatorLayout.g) floatingActionButton.getLayoutParams()).e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        public final boolean P(CoordinatorLayout coordinatorLayout, @n0 AppBarLayout appBarLayout, @n0 FloatingActionButton floatingActionButton) {
            if (!O(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f20220a == null) {
                this.f20220a = new Rect();
            }
            Rect rect = this.f20220a;
            com.google.android.material.internal.d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.n(this.f20221b, false);
                return true;
            }
            floatingActionButton.z(this.f20221b, false);
            return true;
        }

        public final boolean Q(@n0 View view, @n0 FloatingActionButton floatingActionButton) {
            if (!O(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.g) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.n(this.f20221b, false);
                return true;
            }
            floatingActionButton.z(this.f20221b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void h(@n0 CoordinatorLayout.g gVar) {
            if (gVar.f4560h == 0) {
                gVar.f4560h = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.f20222c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public FloatingActionButton(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.floatingActionButtonStyle);
    }

    public void setRippleColor(@p0 ColorStateList colorStateList) {
        if (this.f20207f != colorStateList) {
            this.f20207f = colorStateList;
            getImpl().Y(this.f20207f);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FloatingActionButton(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        int i11 = f20197t;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f20214m = new Rect();
        this.f20215n = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayK = t.k(context2, attributeSet, R.styleable.FloatingActionButton, i10, i11, new int[0]);
        this.f20203b = ie.c.a(context2, typedArrayK, R.styleable.FloatingActionButton_backgroundTint);
        this.f20204c = b0.m(typedArrayK.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.f20207f = ie.c.a(context2, typedArrayK, R.styleable.FloatingActionButton_rippleColor);
        this.f20209h = typedArrayK.getInt(R.styleable.FloatingActionButton_fabSize, -1);
        this.f20210i = typedArrayK.getDimensionPixelSize(R.styleable.FloatingActionButton_fabCustomSize, 0);
        this.f20208g = typedArrayK.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayK.getDimension(R.styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = typedArrayK.getDimension(R.styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = typedArrayK.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.f20213l = typedArrayK.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mtrl_fab_min_touch_target);
        setMaxImageSize(typedArrayK.getDimensionPixelSize(R.styleable.FloatingActionButton_maxImageSize, 0));
        h hVarC = h.c(context2, typedArrayK, R.styleable.FloatingActionButton_showMotionSpec);
        h hVarC2 = h.c(context2, typedArrayK, R.styleable.FloatingActionButton_hideMotionSpec);
        le.o oVarM = le.o.g(context2, attributeSet, i10, i11, le.o.f39664m).m();
        boolean z10 = typedArrayK.getBoolean(R.styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(typedArrayK.getBoolean(R.styleable.FloatingActionButton_android_enabled, true));
        typedArrayK.recycle();
        o oVar = new o(this);
        this.f20216o = oVar;
        oVar.g(attributeSet, i10);
        this.f20217p = new ae.c(this);
        getImpl().a0(oVarM);
        getImpl().x(this.f20203b, this.f20204c, this.f20207f, this.f20208g);
        getImpl().W(dimensionPixelSize);
        getImpl().Q(dimension);
        getImpl().T(dimension2);
        getImpl().X(dimension3);
        getImpl().b0(hVarC);
        getImpl().S(hVarC2);
        getImpl().R(z10);
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}
