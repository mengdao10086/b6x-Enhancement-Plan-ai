package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.Toolbar;
import androidx.core.util.j;
import androidx.core.view.j1;
import androidx.core.view.k0;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.p;
import com.google.android.material.internal.t;
import g.d1;
import g.f0;
import g.l;
import g.n0;
import g.p0;
import g.v;
import g.v0;
import g.x;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    public static final int D = R.style.Widget_Design_CollapsingToolbar;
    public static final int K0 = 0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f19519k0 = 600;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f19520k1 = 1;
    public boolean A;
    public int B;
    public boolean C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f19521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public ViewGroup f19523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public View f19524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f19525e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f19527g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19528h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f19529i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f19530j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @n0
    public final com.google.android.material.internal.b f19531k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @n0
    public final zd.a f19532l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f19533m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f19534n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public Drawable f19535o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public Drawable f19536p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f19537q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f19538r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ValueAnimator f19539s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f19540t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f19541u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AppBarLayout.h f19542v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f19543w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f19544x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @p0
    public j1 f19545y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f19546z;

    public class a implements k0 {
        public a() {
        }

        @Override // androidx.core.view.k0
        public j1 a(View view, @n0 j1 j1Var) {
            return CollapsingToolbarLayout.this.s(j1Var);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@n0 ValueAnimator valueAnimator) {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public class d implements AppBarLayout.h {
        public d() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.h, com.google.android.material.appbar.AppBarLayout.c
        public void a(AppBarLayout appBarLayout, int i10) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.f19543w = i10;
            j1 j1Var = collapsingToolbarLayout.f19545y;
            int iR = j1Var != null ? j1Var.r() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i11);
                c cVar = (c) childAt.getLayoutParams();
                ld.e eVarK = CollapsingToolbarLayout.k(childAt);
                int i12 = cVar.f19553a;
                if (i12 == 1) {
                    eVarK.k(t0.a.e(-i10, 0, CollapsingToolbarLayout.this.i(childAt)));
                } else if (i12 == 2) {
                    eVarK.k(Math.round((-i10) * cVar.f19554b));
                }
            }
            CollapsingToolbarLayout.this.A();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.f19536p != null && iR > 0) {
                u0.n1(collapsingToolbarLayout2);
            }
            int height = (CollapsingToolbarLayout.this.getHeight() - u0.e0(CollapsingToolbarLayout.this)) - iR;
            float f10 = height;
            CollapsingToolbarLayout.this.f19531k.B0(Math.min(1.0f, (r0 - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger()) / f10));
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout3.f19531k.o0(collapsingToolbarLayout3.f19543w + height);
            CollapsingToolbarLayout.this.f19531k.z0(Math.abs(i10) / f10);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @v0(23)
    public interface e extends p {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface f {
    }

    public CollapsingToolbarLayout(@n0 Context context) {
        this(context, null);
    }

    public static int h(@n0 View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public static CharSequence j(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getTitle();
        }
        return null;
    }

    @n0
    public static ld.e k(@n0 View view) {
        int i10 = R.id.view_offset_helper;
        ld.e eVar = (ld.e) view.getTag(i10);
        if (eVar != null) {
            return eVar;
        }
        ld.e eVar2 = new ld.e(view);
        view.setTag(i10, eVar2);
        return eVar2;
    }

    public static boolean q(View view) {
        return (view instanceof Toolbar) || (view instanceof android.widget.Toolbar);
    }

    public final void A() {
        if (this.f19535o == null && this.f19536p == null) {
            return;
        }
        setScrimsShown(getHeight() + this.f19543w < getScrimVisibleHeightTrigger());
    }

    public final void B(int i10, int i11, int i12, int i13, boolean z10) {
        View view;
        if (!this.f19533m || (view = this.f19525e) == null) {
            return;
        }
        boolean z11 = u0.O0(view) && this.f19525e.getVisibility() == 0;
        this.f19534n = z11;
        if (z11 || z10) {
            boolean z12 = u0.Z(this) == 1;
            v(z12);
            this.f19531k.p0(z12 ? this.f19528h : this.f19526f, this.f19530j.top + this.f19527g, (i12 - i10) - (z12 ? this.f19526f : this.f19528h), (i13 - i11) - this.f19529i);
            this.f19531k.d0(z10);
        }
    }

    public final void C() {
        if (this.f19523c != null && this.f19533m && TextUtils.isEmpty(this.f19531k.P())) {
            setTitle(j(this.f19523c));
        }
    }

    public final void a(int i10) {
        d();
        ValueAnimator valueAnimator = this.f19539s;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f19539s = valueAnimator2;
            valueAnimator2.setInterpolator(i10 > this.f19537q ? kd.a.f37168c : kd.a.f37169d);
            this.f19539s.addUpdateListener(new b());
        } else if (valueAnimator.isRunning()) {
            this.f19539s.cancel();
        }
        this.f19539s.setDuration(this.f19540t);
        this.f19539s.setIntValues(this.f19537q, i10);
        this.f19539s.start();
    }

    public final TextUtils.TruncateAt b(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 3 ? TextUtils.TruncateAt.END : TextUtils.TruncateAt.MARQUEE : TextUtils.TruncateAt.MIDDLE : TextUtils.TruncateAt.START;
    }

    public final void c(AppBarLayout appBarLayout) {
        if (o()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public final void d() {
        if (this.f19521a) {
            ViewGroup viewGroup = null;
            this.f19523c = null;
            this.f19524d = null;
            int i10 = this.f19522b;
            if (i10 != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i10);
                this.f19523c = viewGroup2;
                if (viewGroup2 != null) {
                    this.f19524d = e(viewGroup2);
                }
            }
            if (this.f19523c == null) {
                int childCount = getChildCount();
                int i11 = 0;
                while (true) {
                    if (i11 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i11);
                    if (q(childAt)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                    i11++;
                }
                this.f19523c = viewGroup;
            }
            z();
            this.f19521a = false;
        }
    }

    @Override // android.view.View
    public void draw(@n0 Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        d();
        if (this.f19523c == null && (drawable = this.f19535o) != null && this.f19537q > 0) {
            drawable.mutate().setAlpha(this.f19537q);
            this.f19535o.draw(canvas);
        }
        if (this.f19533m && this.f19534n) {
            if (this.f19523c == null || this.f19535o == null || this.f19537q <= 0 || !o() || this.f19531k.G() >= this.f19531k.H()) {
                this.f19531k.l(canvas);
            } else {
                int iSave = canvas.save();
                canvas.clipRect(this.f19535o.getBounds(), Region.Op.DIFFERENCE);
                this.f19531k.l(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        if (this.f19536p == null || this.f19537q <= 0) {
            return;
        }
        j1 j1Var = this.f19545y;
        int iR = j1Var != null ? j1Var.r() : 0;
        if (iR > 0) {
            this.f19536p.setBounds(0, -this.f19543w, getWidth(), iR - this.f19543w);
            this.f19536p.mutate().setAlpha(this.f19537q);
            this.f19536p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        boolean z10;
        if (this.f19535o == null || this.f19537q <= 0 || !r(view)) {
            z10 = false;
        } else {
            y(this.f19535o, view, getWidth(), getHeight());
            this.f19535o.mutate().setAlpha(this.f19537q);
            this.f19535o.draw(canvas);
            z10 = true;
        }
        return super.drawChild(canvas, view, j10) || z10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f19536p;
        boolean zJ0 = false;
        if (drawable != null && drawable.isStateful()) {
            zJ0 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f19535o;
        if (drawable2 != null && drawable2.isStateful()) {
            zJ0 |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.b bVar = this.f19531k;
        if (bVar != null) {
            zJ0 |= bVar.J0(drawableState);
        }
        if (zJ0) {
            invalidate();
        }
    }

    @n0
    public final View e(@n0 View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public c generateDefaultLayoutParams() {
        return new c(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    public int getCollapsedTitleGravity() {
        return this.f19531k.q();
    }

    @n0
    public Typeface getCollapsedTitleTypeface() {
        return this.f19531k.v();
    }

    @p0
    public Drawable getContentScrim() {
        return this.f19535o;
    }

    public int getExpandedTitleGravity() {
        return this.f19531k.C();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f19529i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f19528h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f19526f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f19527g;
    }

    @n0
    public Typeface getExpandedTitleTypeface() {
        return this.f19531k.F();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @v0(23)
    public int getHyphenationFrequency() {
        return this.f19531k.I();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLineCount() {
        return this.f19531k.J();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @v0(23)
    public float getLineSpacingAdd() {
        return this.f19531k.K();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @v0(23)
    public float getLineSpacingMultiplier() {
        return this.f19531k.L();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.f19531k.M();
    }

    public int getScrimAlpha() {
        return this.f19537q;
    }

    public long getScrimAnimationDuration() {
        return this.f19540t;
    }

    public int getScrimVisibleHeightTrigger() {
        int i10 = this.f19541u;
        if (i10 >= 0) {
            return i10 + this.f19546z + this.B;
        }
        j1 j1Var = this.f19545y;
        int iR = j1Var != null ? j1Var.r() : 0;
        int iE0 = u0.e0(this);
        return iE0 > 0 ? Math.min((iE0 * 2) + iR, getHeight()) : getHeight() / 3;
    }

    @p0
    public Drawable getStatusBarScrim() {
        return this.f19536p;
    }

    @p0
    public CharSequence getTitle() {
        if (this.f19533m) {
            return this.f19531k.P();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.f19544x;
    }

    @p0
    public TimeInterpolator getTitlePositionInterpolator() {
        return this.f19531k.O();
    }

    @n0
    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.f19531k.S();
    }

    public final int i(@n0 View view) {
        return ((getHeight() - k(view).c()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((c) view.getLayoutParams())).bottomMargin;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean l() {
        return this.C;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean m() {
        return this.A;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean n() {
        return this.f19531k.W();
    }

    public final boolean o() {
        return this.f19544x == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            c(appBarLayout);
            u0.O1(this, u0.U(appBarLayout));
            if (this.f19542v == null) {
                this.f19542v = new d();
            }
            appBarLayout.e(this.f19542v);
            u0.v1(this);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(@n0 Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f19531k.a0(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.h hVar = this.f19542v;
        if (hVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).v(hVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        j1 j1Var = this.f19545y;
        if (j1Var != null) {
            int iR = j1Var.r();
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                if (!u0.U(childAt) && childAt.getTop() < iR) {
                    u0.f1(childAt, iR);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i15 = 0; i15 < childCount2; i15++) {
            k(getChildAt(i15)).h();
        }
        B(i10, i11, i12, i13, false);
        C();
        A();
        int childCount3 = getChildCount();
        for (int i16 = 0; i16 < childCount3; i16++) {
            k(getChildAt(i16)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        d();
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        j1 j1Var = this.f19545y;
        int iR = j1Var != null ? j1Var.r() : 0;
        if ((mode == 0 || this.A) && iR > 0) {
            this.f19546z = iR;
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + iR, 1073741824));
        }
        if (this.C && this.f19531k.M() > 1) {
            C();
            B(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int iZ = this.f19531k.z();
            if (iZ > 1) {
                this.B = Math.round(this.f19531k.B()) * (iZ - 1);
                super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.B, 1073741824));
            }
        }
        ViewGroup viewGroup = this.f19523c;
        if (viewGroup != null) {
            View view = this.f19524d;
            if (view == null || view == this) {
                setMinimumHeight(h(viewGroup));
            } else {
                setMinimumHeight(h(view));
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        Drawable drawable = this.f19535o;
        if (drawable != null) {
            x(drawable, i10, i11);
        }
    }

    public boolean p() {
        return this.f19533m;
    }

    public final boolean r(View view) {
        View view2 = this.f19524d;
        if (view2 == null || view2 == this) {
            if (view == this.f19523c) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    public j1 s(@n0 j1 j1Var) {
        j1 j1Var2 = u0.U(this) ? j1Var : null;
        if (!j.a(this.f19545y, j1Var2)) {
            this.f19545y = j1Var2;
            requestLayout();
        }
        return j1Var.c();
    }

    public void setCollapsedTitleGravity(int i10) {
        this.f19531k.k0(i10);
    }

    public void setCollapsedTitleTextAppearance(@d1 int i10) {
        this.f19531k.h0(i10);
    }

    public void setCollapsedTitleTextColor(@l int i10) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setCollapsedTitleTypeface(@p0 Typeface typeface) {
        this.f19531k.m0(typeface);
    }

    public void setContentScrim(@p0 Drawable drawable) {
        Drawable drawable2 = this.f19535o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f19535o = drawableMutate;
            if (drawableMutate != null) {
                x(drawableMutate, getWidth(), getHeight());
                this.f19535o.setCallback(this);
                this.f19535o.setAlpha(this.f19537q);
            }
            u0.n1(this);
        }
    }

    public void setContentScrimColor(@l int i10) {
        setContentScrim(new ColorDrawable(i10));
    }

    public void setContentScrimResource(@v int i10) {
        setContentScrim(h0.d.i(getContext(), i10));
    }

    public void setExpandedTitleColor(@l int i10) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setExpandedTitleGravity(int i10) {
        this.f19531k.v0(i10);
    }

    public void setExpandedTitleMarginBottom(int i10) {
        this.f19529i = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i10) {
        this.f19528h = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i10) {
        this.f19526f = i10;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i10) {
        this.f19527g = i10;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@d1 int i10) {
        this.f19531k.s0(i10);
    }

    public void setExpandedTitleTextColor(@n0 ColorStateList colorStateList) {
        this.f19531k.u0(colorStateList);
    }

    public void setExpandedTitleTypeface(@p0 Typeface typeface) {
        this.f19531k.x0(typeface);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExtraMultilineHeightEnabled(boolean z10) {
        this.C = z10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceApplySystemWindowInsetTop(boolean z10) {
        this.A = z10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @v0(23)
    public void setHyphenationFrequency(int i10) {
        this.f19531k.C0(i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @v0(23)
    public void setLineSpacingAdd(float f10) {
        this.f19531k.E0(f10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @v0(23)
    public void setLineSpacingMultiplier(@x(from = 0.0d) float f10) {
        this.f19531k.F0(f10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int i10) {
        this.f19531k.G0(i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRtlTextDirectionHeuristicsEnabled(boolean z10) {
        this.f19531k.I0(z10);
    }

    public void setScrimAlpha(int i10) {
        ViewGroup viewGroup;
        if (i10 != this.f19537q) {
            if (this.f19535o != null && (viewGroup = this.f19523c) != null) {
                u0.n1(viewGroup);
            }
            this.f19537q = i10;
            u0.n1(this);
        }
    }

    public void setScrimAnimationDuration(@f0(from = 0) long j10) {
        this.f19540t = j10;
    }

    public void setScrimVisibleHeightTrigger(@f0(from = 0) int i10) {
        if (this.f19541u != i10) {
            this.f19541u = i10;
            A();
        }
    }

    public void setScrimsShown(boolean z10) {
        u(z10, u0.U0(this) && !isInEditMode());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @v0(23)
    public void setStaticLayoutBuilderConfigurer(@p0 e eVar) {
        this.f19531k.K0(eVar);
    }

    public void setStatusBarScrim(@p0 Drawable drawable) {
        Drawable drawable2 = this.f19536p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f19536p = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f19536p.setState(getDrawableState());
                }
                n0.c.m(this.f19536p, u0.Z(this));
                this.f19536p.setVisible(getVisibility() == 0, false);
                this.f19536p.setCallback(this);
                this.f19536p.setAlpha(this.f19537q);
            }
            u0.n1(this);
        }
    }

    public void setStatusBarScrimColor(@l int i10) {
        setStatusBarScrim(new ColorDrawable(i10));
    }

    public void setStatusBarScrimResource(@v int i10) {
        setStatusBarScrim(h0.d.i(getContext(), i10));
    }

    public void setTitle(@p0 CharSequence charSequence) {
        this.f19531k.L0(charSequence);
        w();
    }

    public void setTitleCollapseMode(int i10) {
        this.f19544x = i10;
        boolean zO = o();
        this.f19531k.A0(zO);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            c((AppBarLayout) parent);
        }
        if (zO && this.f19535o == null) {
            setContentScrimColor(this.f19532l.g(getResources().getDimension(R.dimen.design_appbar_elevation)));
        }
    }

    public void setTitleEllipsize(@n0 TextUtils.TruncateAt truncateAt) {
        this.f19531k.N0(truncateAt);
    }

    public void setTitleEnabled(boolean z10) {
        if (z10 != this.f19533m) {
            this.f19533m = z10;
            w();
            z();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(@p0 TimeInterpolator timeInterpolator) {
        this.f19531k.H0(timeInterpolator);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f19536p;
        if (drawable != null && drawable.isVisible() != z10) {
            this.f19536p.setVisible(z10, false);
        }
        Drawable drawable2 = this.f19535o;
        if (drawable2 == null || drawable2.isVisible() == z10) {
            return;
        }
        this.f19535o.setVisible(z10, false);
    }

    public void t(int i10, int i11, int i12, int i13) {
        this.f19526f = i10;
        this.f19527g = i11;
        this.f19528h = i12;
        this.f19529i = i13;
        requestLayout();
    }

    public void u(boolean z10, boolean z11) {
        if (this.f19538r != z10) {
            if (z11) {
                a(z10 ? 255 : 0);
            } else {
                setScrimAlpha(z10 ? 255 : 0);
            }
            this.f19538r = z10;
        }
    }

    public final void v(boolean z10) {
        int titleMarginBottom;
        int titleMarginEnd;
        int titleMarginTop;
        View view = this.f19524d;
        if (view == null) {
            view = this.f19523c;
        }
        int i10 = i(view);
        com.google.android.material.internal.d.a(this, this.f19525e, this.f19530j);
        ViewGroup viewGroup = this.f19523c;
        int titleMarginStart = 0;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            titleMarginStart = toolbar.getTitleMarginStart();
            titleMarginEnd = toolbar.getTitleMarginEnd();
            titleMarginTop = toolbar.getTitleMarginTop();
            titleMarginBottom = toolbar.getTitleMarginBottom();
        } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
            titleMarginBottom = 0;
            titleMarginEnd = 0;
            titleMarginTop = 0;
        } else {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            titleMarginStart = toolbar2.getTitleMarginStart();
            titleMarginEnd = toolbar2.getTitleMarginEnd();
            titleMarginTop = toolbar2.getTitleMarginTop();
            titleMarginBottom = toolbar2.getTitleMarginBottom();
        }
        com.google.android.material.internal.b bVar = this.f19531k;
        Rect rect = this.f19530j;
        int i11 = rect.left + (z10 ? titleMarginEnd : titleMarginStart);
        int i12 = rect.top + i10 + titleMarginTop;
        int i13 = rect.right;
        if (!z10) {
            titleMarginStart = titleMarginEnd;
        }
        bVar.f0(i11, i12, i13 - titleMarginStart, (rect.bottom + i10) - titleMarginBottom);
    }

    @Override // android.view.View
    public boolean verifyDrawable(@n0 Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f19535o || drawable == this.f19536p;
    }

    public final void w() {
        setContentDescription(getTitle());
    }

    public final void x(@n0 Drawable drawable, int i10, int i11) {
        y(drawable, this.f19523c, i10, i11);
    }

    public final void y(@n0 Drawable drawable, @p0 View view, int i10, int i11) {
        if (o() && view != null && this.f19533m) {
            i11 = view.getBottom();
        }
        drawable.setBounds(0, 0, i10, i11);
    }

    public final void z() {
        View view;
        if (!this.f19533m && (view = this.f19525e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f19525e);
            }
        }
        if (!this.f19533m || this.f19523c == null) {
            return;
        }
        if (this.f19525e == null) {
            this.f19525e = new View(getContext());
        }
        if (this.f19525e.getParent() == null) {
            this.f19523c.addView(this.f19525e, -1, -1);
        }
    }

    public CollapsingToolbarLayout(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.collapsingToolbarLayoutStyle);
    }

    public void setCollapsedTitleTextColor(@n0 ColorStateList colorStateList) {
        this.f19531k.j0(colorStateList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CollapsingToolbarLayout(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        int i11 = D;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f19521a = true;
        this.f19530j = new Rect();
        this.f19541u = -1;
        this.f19546z = 0;
        this.B = 0;
        Context context2 = getContext();
        com.google.android.material.internal.b bVar = new com.google.android.material.internal.b(this);
        this.f19531k = bVar;
        bVar.M0(kd.a.f37170e);
        bVar.I0(false);
        this.f19532l = new zd.a(context2);
        TypedArray typedArrayK = t.k(context2, attributeSet, R.styleable.CollapsingToolbarLayout, i10, i11, new int[0]);
        bVar.v0(typedArrayK.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        bVar.k0(typedArrayK.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = typedArrayK.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.f19529i = dimensionPixelSize;
        this.f19528h = dimensionPixelSize;
        this.f19527g = dimensionPixelSize;
        this.f19526f = dimensionPixelSize;
        int i12 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart;
        if (typedArrayK.hasValue(i12)) {
            this.f19526f = typedArrayK.getDimensionPixelSize(i12, 0);
        }
        int i13 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd;
        if (typedArrayK.hasValue(i13)) {
            this.f19528h = typedArrayK.getDimensionPixelSize(i13, 0);
        }
        int i14 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop;
        if (typedArrayK.hasValue(i14)) {
            this.f19527g = typedArrayK.getDimensionPixelSize(i14, 0);
        }
        int i15 = R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom;
        if (typedArrayK.hasValue(i15)) {
            this.f19529i = typedArrayK.getDimensionPixelSize(i15, 0);
        }
        this.f19533m = typedArrayK.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(typedArrayK.getText(R.styleable.CollapsingToolbarLayout_title));
        bVar.s0(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        bVar.h0(androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        int i16 = R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance;
        if (typedArrayK.hasValue(i16)) {
            bVar.s0(typedArrayK.getResourceId(i16, 0));
        }
        int i17 = R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance;
        if (typedArrayK.hasValue(i17)) {
            bVar.h0(typedArrayK.getResourceId(i17, 0));
        }
        int i18 = R.styleable.CollapsingToolbarLayout_titleTextEllipsize;
        if (typedArrayK.hasValue(i18)) {
            setTitleEllipsize(b(typedArrayK.getInt(i18, -1)));
        }
        int i19 = R.styleable.CollapsingToolbarLayout_expandedTitleTextColor;
        if (typedArrayK.hasValue(i19)) {
            bVar.u0(ie.c.a(context2, typedArrayK, i19));
        }
        int i20 = R.styleable.CollapsingToolbarLayout_collapsedTitleTextColor;
        if (typedArrayK.hasValue(i20)) {
            bVar.j0(ie.c.a(context2, typedArrayK, i20));
        }
        this.f19541u = typedArrayK.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        int i21 = R.styleable.CollapsingToolbarLayout_maxLines;
        if (typedArrayK.hasValue(i21)) {
            bVar.G0(typedArrayK.getInt(i21, 1));
        }
        int i22 = R.styleable.CollapsingToolbarLayout_titlePositionInterpolator;
        if (typedArrayK.hasValue(i22)) {
            bVar.H0(AnimationUtils.loadInterpolator(context2, typedArrayK.getResourceId(i22, 0)));
        }
        this.f19540t = typedArrayK.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(typedArrayK.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(typedArrayK.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        setTitleCollapseMode(typedArrayK.getInt(R.styleable.CollapsingToolbarLayout_titleCollapseMode, 0));
        this.f19522b = typedArrayK.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        this.A = typedArrayK.getBoolean(R.styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, false);
        this.C = typedArrayK.getBoolean(R.styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, false);
        typedArrayK.recycle();
        setWillNotDraw(false);
        u0.a2(this, new a());
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public static class c extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final float f19549c = 0.5f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f19550d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f19551e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f19552f = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f19554b;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f19553a = 0;
            this.f19554b = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.f19553a = typedArrayObtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            d(typedArrayObtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            typedArrayObtainStyledAttributes.recycle();
        }

        public int a() {
            return this.f19553a;
        }

        public float b() {
            return this.f19554b;
        }

        public void c(int i10) {
            this.f19553a = i10;
        }

        public void d(float f10) {
            this.f19554b = f10;
        }

        public c(int i10, int i11) {
            super(i10, i11);
            this.f19553a = 0;
            this.f19554b = 0.5f;
        }

        public c(int i10, int i11, int i12) {
            super(i10, i11, i12);
            this.f19553a = 0;
            this.f19554b = 0.5f;
        }

        public c(@n0 ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f19553a = 0;
            this.f19554b = 0.5f;
        }

        public c(@n0 ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f19553a = 0;
            this.f19554b = 0.5f;
        }

        @v0(19)
        public c(@n0 FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f19553a = 0;
            this.f19554b = 0.5f;
        }

        @v0(19)
        public c(@n0 c cVar) {
            super((FrameLayout.LayoutParams) cVar);
            this.f19553a = 0;
            this.f19554b = 0.5f;
            this.f19553a = cVar.f19553a;
            this.f19554b = cVar.f19554b;
        }
    }
}
