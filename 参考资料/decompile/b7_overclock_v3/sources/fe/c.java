package fe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.y0;
import androidx.core.view.j1;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.t;
import com.google.android.material.navigation.NavigationBarView;
import g.i0;
import g.n0;
import g.p0;
import g.t0;

/* JADX INFO: loaded from: classes3.dex */
public class c extends NavigationBarView {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f28132p = 49;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f28133q = 7;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f28134r = 49;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f28135s = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f28136l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public View f28137m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @p0
    public Boolean f28138n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public Boolean f28139o;

    public class a implements b0.e {
        public a() {
        }

        @Override // com.google.android.material.internal.b0.e
        @n0
        public j1 a(View view, @n0 j1 j1Var, @n0 b0.f fVar) {
            c cVar = c.this;
            if (cVar.u(cVar.f28138n)) {
                fVar.f20408b += j1Var.f(j1.m.i()).f40560b;
            }
            c cVar2 = c.this;
            if (cVar2.u(cVar2.f28139o)) {
                fVar.f20410d += j1Var.f(j1.m.i()).f40562d;
            }
            boolean z10 = u0.Z(view) == 1;
            int iP = j1Var.p();
            int iQ = j1Var.q();
            int i10 = fVar.f20407a;
            if (z10) {
                iP = iQ;
            }
            fVar.f20407a = i10 + iP;
            fVar.a(view);
            return j1Var;
        }
    }

    public c(@n0 Context context) {
        this(context, null);
    }

    private b getNavigationRailMenuView() {
        return (b) getMenuView();
    }

    @p0
    public View getHeaderView() {
        return this.f28137m;
    }

    public int getItemMinimumHeight() {
        return ((b) getMenuView()).getItemMinimumHeight();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    public void n(@i0 int i10) {
        o(LayoutInflater.from(getContext()).inflate(i10, (ViewGroup) this, false));
    }

    public void o(@n0 View view) {
        t();
        this.f28137m = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.f28136l;
        addView(view, 0, layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        b navigationRailMenuView = getNavigationRailMenuView();
        int i14 = 0;
        if (r()) {
            int bottom = this.f28137m.getBottom() + this.f28136l;
            int top2 = navigationRailMenuView.getTop();
            if (top2 < bottom) {
                i14 = bottom - top2;
            }
        } else if (navigationRailMenuView.u()) {
            i14 = this.f28136l;
        }
        if (i14 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i14, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i14);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int iS = s(i10);
        super.onMeasure(iS, i11);
        if (r()) {
            measureChild(getNavigationRailMenuView(), iS, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.f28137m.getMeasuredHeight()) - this.f28136l, Integer.MIN_VALUE));
        }
    }

    public final void p() {
        b0.d(this, new a());
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public b d(@n0 Context context) {
        return new b(context);
    }

    public final boolean r() {
        View view = this.f28137m;
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    public final int s(int i10) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i10) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i10;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
    }

    public void setItemMinimumHeight(@t0 int i10) {
        ((b) getMenuView()).setItemMinimumHeight(i10);
    }

    public void setMenuGravity(int i10) {
        getNavigationRailMenuView().setMenuGravity(i10);
    }

    public void t() {
        View view = this.f28137m;
        if (view != null) {
            removeView(view);
            this.f28137m = null;
        }
    }

    public final boolean u(Boolean bool) {
        return bool != null ? bool.booleanValue() : u0.U(this);
    }

    public c(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationRailStyle);
    }

    public c(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, R.style.Widget_MaterialComponents_NavigationRailView);
    }

    public c(@n0 Context context, @p0 AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f28138n = null;
        this.f28139o = null;
        this.f28136l = getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin);
        y0 y0VarL = t.l(getContext(), attributeSet, R.styleable.NavigationRailView, i10, i11, new int[0]);
        int iU = y0VarL.u(R.styleable.NavigationRailView_headerLayout, 0);
        if (iU != 0) {
            n(iU);
        }
        setMenuGravity(y0VarL.o(R.styleable.NavigationRailView_menuGravity, 49));
        int i12 = R.styleable.NavigationRailView_itemMinHeight;
        if (y0VarL.C(i12)) {
            setItemMinimumHeight(y0VarL.g(i12, -1));
        }
        int i13 = R.styleable.NavigationRailView_paddingTopSystemWindowInsets;
        if (y0VarL.C(i13)) {
            this.f28138n = Boolean.valueOf(y0VarL.a(i13, false));
        }
        int i14 = R.styleable.NavigationRailView_paddingBottomSystemWindowInsets;
        if (y0VarL.C(i14)) {
            this.f28139o = Boolean.valueOf(y0VarL.a(i14, false));
        }
        y0VarL.I();
        p();
    }
}
