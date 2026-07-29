package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.y0;
import androidx.core.view.j1;
import androidx.core.view.m;
import androidx.core.view.u0;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.k;
import com.google.android.material.internal.l;
import com.google.android.material.internal.n;
import com.google.android.material.internal.t;
import g.d0;
import g.d1;
import g.i0;
import g.n0;
import g.p0;
import g.q;
import g.r;
import g.t0;
import g.v;
import h0.d;
import l.g;
import le.j;
import le.o;
import le.p;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationView extends n {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int[] f20526s = {R.attr.state_checked};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int[] f20527t = {-16842910};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f20528u = com.google.android.material.R.style.Widget_Design_NavigationView;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f20529v = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final k f20530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f20531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f20532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f20533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f20534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MenuInflater f20535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewTreeObserver.OnGlobalLayoutListener f20536l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f20537m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f20538n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f20539o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @t0
    public int f20540p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @p0
    public Path f20541q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final RectF f20542r;

    public class a implements e.a {
        public a() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(e eVar, MenuItem menuItem) {
            c cVar = NavigationView.this.f20532h;
            return cVar != null && cVar.a(menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(e eVar) {
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NavigationView navigationView = NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.f20534j);
            boolean z10 = NavigationView.this.f20534j[1] == 0;
            NavigationView.this.f20531g.F(z10);
            NavigationView navigationView2 = NavigationView.this;
            navigationView2.setDrawTopInsetForeground(z10 && navigationView2.m());
            Activity activityA = com.google.android.material.internal.c.a(NavigationView.this.getContext());
            if (activityA != null) {
                boolean z11 = activityA.findViewById(R.id.content).getHeight() == NavigationView.this.getHeight();
                boolean z12 = Color.alpha(activityA.getWindow().getNavigationBarColor()) != 0;
                NavigationView navigationView3 = NavigationView.this;
                navigationView3.setDrawBottomInsetForeground(z11 && z12 && navigationView3.l());
            }
        }
    }

    public interface c {
        boolean a(@n0 MenuItem menuItem);
    }

    public NavigationView(@n0 Context context) {
        this(context, null);
    }

    private MenuInflater getMenuInflater() {
        if (this.f20535k == null) {
            this.f20535k = new g(getContext());
        }
        return this.f20535k;
    }

    @Override // com.google.android.material.internal.n
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void a(@n0 j1 j1Var) {
        this.f20531g.k(j1Var);
    }

    public void d(@n0 View view) {
        this.f20531g.d(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@n0 Canvas canvas) {
        if (this.f20541q == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.clipPath(this.f20541q);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    @p0
    public final ColorStateList e(int i10) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i10, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListA = i.a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i11 = typedValue.data;
        int defaultColor = colorStateListA.getDefaultColor();
        int[] iArr = f20527t;
        return new ColorStateList(new int[][]{iArr, f20526s, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateListA.getColorForState(iArr, defaultColor), i11, defaultColor});
    }

    @n0
    public final Drawable f(@n0 y0 y0Var) {
        return g(y0Var, ie.c.b(getContext(), y0Var, com.google.android.material.R.styleable.NavigationView_itemShapeFillColor));
    }

    @n0
    public final Drawable g(@n0 y0 y0Var, @p0 ColorStateList colorStateList) {
        j jVar = new j(o.b(getContext(), y0Var.u(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance, 0), y0Var.u(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).m());
        jVar.o0(colorStateList);
        return new InsetDrawable((Drawable) jVar, y0Var.g(com.google.android.material.R.styleable.NavigationView_itemShapeInsetStart, 0), y0Var.g(com.google.android.material.R.styleable.NavigationView_itemShapeInsetTop, 0), y0Var.g(com.google.android.material.R.styleable.NavigationView_itemShapeInsetEnd, 0), y0Var.g(com.google.android.material.R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    @p0
    public MenuItem getCheckedItem() {
        return this.f20531g.o();
    }

    @t0
    public int getDividerInsetEnd() {
        return this.f20531g.p();
    }

    @t0
    public int getDividerInsetStart() {
        return this.f20531g.q();
    }

    public int getHeaderCount() {
        return this.f20531g.r();
    }

    @p0
    public Drawable getItemBackground() {
        return this.f20531g.t();
    }

    @r
    public int getItemHorizontalPadding() {
        return this.f20531g.u();
    }

    @r
    public int getItemIconPadding() {
        return this.f20531g.v();
    }

    @p0
    public ColorStateList getItemIconTintList() {
        return this.f20531g.y();
    }

    public int getItemMaxLines() {
        return this.f20531g.w();
    }

    @p0
    public ColorStateList getItemTextColor() {
        return this.f20531g.x();
    }

    @t0
    public int getItemVerticalPadding() {
        return this.f20531g.z();
    }

    @n0
    public Menu getMenu() {
        return this.f20530f;
    }

    @t0
    public int getSubheaderInsetEnd() {
        return this.f20531g.A();
    }

    @t0
    public int getSubheaderInsetStart() {
        return this.f20531g.B();
    }

    public View h(int i10) {
        return this.f20531g.s(i10);
    }

    public final boolean i(@n0 y0 y0Var) {
        return y0Var.C(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance) || y0Var.C(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    public View j(@i0 int i10) {
        return this.f20531g.C(i10);
    }

    public void k(int i10) {
        this.f20531g.Z(true);
        getMenuInflater().inflate(i10, this.f20530f);
        this.f20531g.Z(false);
        this.f20531g.c(false);
    }

    public boolean l() {
        return this.f20538n;
    }

    public boolean m() {
        return this.f20537m;
    }

    public final void n(@t0 int i10, @t0 int i11) {
        if (!(getParent() instanceof DrawerLayout) || this.f20540p <= 0 || !(getBackground() instanceof j)) {
            this.f20541q = null;
            this.f20542r.setEmpty();
            return;
        }
        j jVar = (j) getBackground();
        o.b bVarV = jVar.getShapeAppearanceModel().v();
        if (m.d(this.f20539o, u0.Z(this)) == 3) {
            bVarV.P(this.f20540p);
            bVarV.C(this.f20540p);
        } else {
            bVarV.K(this.f20540p);
            bVarV.x(this.f20540p);
        }
        jVar.setShapeAppearanceModel(bVarV.m());
        if (this.f20541q == null) {
            this.f20541q = new Path();
        }
        this.f20541q.reset();
        this.f20542r.set(0.0f, 0.0f, i10, i11);
        p.k().d(jVar.getShapeAppearanceModel(), jVar.z(), this.f20542r, this.f20541q);
        invalidate();
    }

    public void o(@n0 View view) {
        this.f20531g.E(view);
    }

    @Override // com.google.android.material.internal.n, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        le.k.e(this);
    }

    @Override // com.google.android.material.internal.n, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f20536l);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == Integer.MIN_VALUE) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), this.f20533i), 1073741824);
        } else if (mode == 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(this.f20533i, 1073741824);
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f20530f.U(savedState.f20543c);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f20543c = bundle;
        this.f20530f.W(bundle);
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        n(i10, i11);
    }

    public final void p() {
        this.f20536l = new b();
        getViewTreeObserver().addOnGlobalLayoutListener(this.f20536l);
    }

    public void setBottomInsetScrimEnabled(boolean z10) {
        this.f20538n = z10;
    }

    public void setCheckedItem(@d0 int i10) {
        MenuItem menuItemFindItem = this.f20530f.findItem(i10);
        if (menuItemFindItem != null) {
            this.f20531g.G((h) menuItemFindItem);
        }
    }

    public void setDividerInsetEnd(@t0 int i10) {
        this.f20531g.H(i10);
    }

    public void setDividerInsetStart(@t0 int i10) {
        this.f20531g.I(i10);
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        le.k.d(this, f10);
    }

    public void setItemBackground(@p0 Drawable drawable) {
        this.f20531g.K(drawable);
    }

    public void setItemBackgroundResource(@v int i10) {
        setItemBackground(d.i(getContext(), i10));
    }

    public void setItemHorizontalPadding(@r int i10) {
        this.f20531g.M(i10);
    }

    public void setItemHorizontalPaddingResource(@q int i10) {
        this.f20531g.M(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconPadding(@r int i10) {
        this.f20531g.N(i10);
    }

    public void setItemIconPaddingResource(int i10) {
        this.f20531g.N(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconSize(@r int i10) {
        this.f20531g.O(i10);
    }

    public void setItemIconTintList(@p0 ColorStateList colorStateList) {
        this.f20531g.P(colorStateList);
    }

    public void setItemMaxLines(int i10) {
        this.f20531g.Q(i10);
    }

    public void setItemTextAppearance(@d1 int i10) {
        this.f20531g.R(i10);
    }

    public void setItemTextColor(@p0 ColorStateList colorStateList) {
        this.f20531g.S(colorStateList);
    }

    public void setItemVerticalPadding(@t0 int i10) {
        this.f20531g.T(i10);
    }

    public void setItemVerticalPaddingResource(@q int i10) {
        this.f20531g.T(getResources().getDimensionPixelSize(i10));
    }

    public void setNavigationItemSelectedListener(@p0 c cVar) {
        this.f20532h = cVar;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i10) {
        super.setOverScrollMode(i10);
        l lVar = this.f20531g;
        if (lVar != null) {
            lVar.U(i10);
        }
    }

    public void setSubheaderInsetEnd(@t0 int i10) {
        this.f20531g.X(i10);
    }

    public void setSubheaderInsetStart(@t0 int i10) {
        this.f20531g.X(i10);
    }

    public void setTopInsetScrimEnabled(boolean z10) {
        this.f20537m = z10;
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public Bundle f20543c;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @p0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@n0 Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @n0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(@n0 Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @n0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(@n0 Parcel parcel, @p0 ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f20543c = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@n0 Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeBundle(this.f20543c);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.navigationViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NavigationView(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        ColorStateList colorStateListE;
        int i11 = f20528u;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        l lVar = new l();
        this.f20531g = lVar;
        this.f20534j = new int[2];
        this.f20537m = true;
        this.f20538n = true;
        this.f20539o = 0;
        this.f20540p = 0;
        this.f20542r = new RectF();
        Context context2 = getContext();
        k kVar = new k(context2);
        this.f20530f = kVar;
        y0 y0VarL = t.l(context2, attributeSet, com.google.android.material.R.styleable.NavigationView, i10, i11, new int[0]);
        int i12 = com.google.android.material.R.styleable.NavigationView_android_background;
        if (y0VarL.C(i12)) {
            u0.I1(this, y0VarL.h(i12));
        }
        this.f20540p = y0VarL.g(com.google.android.material.R.styleable.NavigationView_drawerLayoutCornerSize, 0);
        this.f20539o = y0VarL.o(com.google.android.material.R.styleable.NavigationView_android_layout_gravity, 0);
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            o oVarM = o.e(context2, attributeSet, i10, i11).m();
            Drawable background = getBackground();
            j jVar = new j(oVarM);
            if (background instanceof ColorDrawable) {
                jVar.o0(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            jVar.Z(context2);
            u0.I1(this, jVar);
        }
        if (y0VarL.C(com.google.android.material.R.styleable.NavigationView_elevation)) {
            setElevation(y0VarL.g(r2, 0));
        }
        setFitsSystemWindows(y0VarL.a(com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.f20533i = y0VarL.g(com.google.android.material.R.styleable.NavigationView_android_maxWidth, 0);
        int i13 = com.google.android.material.R.styleable.NavigationView_subheaderColor;
        ColorStateList colorStateListD = y0VarL.C(i13) ? y0VarL.d(i13) : null;
        int i14 = com.google.android.material.R.styleable.NavigationView_subheaderTextAppearance;
        int iU = y0VarL.C(i14) ? y0VarL.u(i14, 0) : 0;
        if (iU == 0 && colorStateListD == null) {
            colorStateListD = e(R.attr.textColorSecondary);
        }
        int i15 = com.google.android.material.R.styleable.NavigationView_itemIconTint;
        if (y0VarL.C(i15)) {
            colorStateListE = y0VarL.d(i15);
        } else {
            colorStateListE = e(R.attr.textColorSecondary);
        }
        int i16 = com.google.android.material.R.styleable.NavigationView_itemTextAppearance;
        int iU2 = y0VarL.C(i16) ? y0VarL.u(i16, 0) : 0;
        int i17 = com.google.android.material.R.styleable.NavigationView_itemIconSize;
        if (y0VarL.C(i17)) {
            setItemIconSize(y0VarL.g(i17, 0));
        }
        int i18 = com.google.android.material.R.styleable.NavigationView_itemTextColor;
        ColorStateList colorStateListD2 = y0VarL.C(i18) ? y0VarL.d(i18) : null;
        if (iU2 == 0 && colorStateListD2 == null) {
            colorStateListD2 = e(R.attr.textColorPrimary);
        }
        Drawable drawableH = y0VarL.h(com.google.android.material.R.styleable.NavigationView_itemBackground);
        if (drawableH == null && i(y0VarL)) {
            drawableH = f(y0VarL);
            ColorStateList colorStateListB = ie.c.b(context2, y0VarL, com.google.android.material.R.styleable.NavigationView_itemRippleColor);
            if (colorStateListB != null) {
                lVar.L(new RippleDrawable(je.b.e(colorStateListB), null, g(y0VarL, null)));
            }
        }
        int i19 = com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding;
        if (y0VarL.C(i19)) {
            setItemHorizontalPadding(y0VarL.g(i19, 0));
        }
        int i20 = com.google.android.material.R.styleable.NavigationView_itemVerticalPadding;
        if (y0VarL.C(i20)) {
            setItemVerticalPadding(y0VarL.g(i20, 0));
        }
        setDividerInsetStart(y0VarL.g(com.google.android.material.R.styleable.NavigationView_dividerInsetStart, 0));
        setDividerInsetEnd(y0VarL.g(com.google.android.material.R.styleable.NavigationView_dividerInsetEnd, 0));
        setSubheaderInsetStart(y0VarL.g(com.google.android.material.R.styleable.NavigationView_subheaderInsetStart, 0));
        setSubheaderInsetEnd(y0VarL.g(com.google.android.material.R.styleable.NavigationView_subheaderInsetEnd, 0));
        setTopInsetScrimEnabled(y0VarL.a(com.google.android.material.R.styleable.NavigationView_topInsetScrimEnabled, this.f20537m));
        setBottomInsetScrimEnabled(y0VarL.a(com.google.android.material.R.styleable.NavigationView_bottomInsetScrimEnabled, this.f20538n));
        int iG = y0VarL.g(com.google.android.material.R.styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(y0VarL.o(com.google.android.material.R.styleable.NavigationView_itemMaxLines, 1));
        kVar.X(new a());
        lVar.J(1);
        lVar.i(context2, kVar);
        if (iU != 0) {
            lVar.Y(iU);
        }
        lVar.V(colorStateListD);
        lVar.P(colorStateListE);
        lVar.U(getOverScrollMode());
        if (iU2 != 0) {
            lVar.R(iU2);
        }
        lVar.S(colorStateListD2);
        lVar.K(drawableH);
        lVar.N(iG);
        kVar.b(lVar);
        addView((View) lVar.m(this));
        int i21 = com.google.android.material.R.styleable.NavigationView_menu;
        if (y0VarL.C(i21)) {
            k(y0VarL.u(i21, 0));
        }
        int i22 = com.google.android.material.R.styleable.NavigationView_headerLayout;
        if (y0VarL.C(i22)) {
            j(y0VarL.u(i22, 0));
        }
        y0VarL.I();
        p();
    }

    public void setCheckedItem(@n0 MenuItem menuItem) {
        MenuItem menuItemFindItem = this.f20530f.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.f20531g.G((h) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
