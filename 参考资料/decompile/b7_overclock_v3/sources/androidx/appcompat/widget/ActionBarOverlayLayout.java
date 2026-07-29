package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.j;
import androidx.core.view.j1;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarOverlayLayout extends ViewGroup implements b0, androidx.core.view.i0, androidx.core.view.g0, androidx.core.view.h0 {
    public static final String K0 = "ActionBarOverlayLayout";

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f2030k1 = 600;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int[] f2031v1 = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    public ViewPropertyAnimator A;
    public final AnimatorListenerAdapter B;
    public final Runnable C;
    public final Runnable D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ContentFrameLayout f2034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionBarContainer f2035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c0 f2036e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f2037f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2038g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2039h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2041j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2042k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final androidx.core.view.j0 f2043k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2044l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2045m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f2046n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Rect f2047o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Rect f2048p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f2049q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Rect f2050r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f2051s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Rect f2052t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @g.n0
    public j1 f2053u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @g.n0
    public j1 f2054v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @g.n0
    public j1 f2055w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @g.n0
    public j1 f2056x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public d f2057y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public OverScroller f2058z;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = null;
            actionBarOverlayLayout.f2042k = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = null;
            actionBarOverlayLayout.f2042k = false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.s();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = actionBarOverlayLayout.f2035d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.B);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.s();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = actionBarOverlayLayout.f2035d.animate().translationY(-ActionBarOverlayLayout.this.f2035d.getHeight()).setListener(ActionBarOverlayLayout.this.B);
        }
    }

    public interface d {
        void a();

        void b();

        void c(boolean z10);

        void d();

        void e();

        void f(int i10);
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i10, int i11) {
            super(i10, i11);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public ActionBarOverlayLayout(@g.n0 Context context) {
        this(context, null);
    }

    public final boolean A(float f10) {
        this.f2058z.fling(0, 0, 0, (int) f10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f2058z.getFinalY() > this.f2035d.getHeight();
    }

    @Override // androidx.core.view.h0
    public void B(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        D(view, i10, i11, i12, i13, i14);
    }

    @Override // androidx.core.view.g0
    public void D(View view, int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            onNestedScroll(view, i10, i11, i12, i13);
        }
    }

    @Override // androidx.core.view.g0
    public boolean G(View view, View view2, int i10, int i11) {
        return i11 == 0 && onStartNestedScroll(view, view2, i10);
    }

    @Override // androidx.core.view.g0
    public void H(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    @Override // androidx.core.view.g0
    public void J(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.view.g0
    public void K(View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            onNestedPreScroll(view, i10, i11, iArr);
        }
    }

    @Override // androidx.appcompat.widget.b0
    public void a(Menu menu, j.a aVar) {
        y();
        this.f2036e.a(menu, aVar);
    }

    public final void b() {
        s();
        this.D.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(@g.n0 android.view.View r3, @g.n0 android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$e r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.e) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = 1
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = 1
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = 1
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            goto L36
        L35:
            r0 = r5
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.c(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f2037f == null || this.f2038g) {
            return;
        }
        int bottom = this.f2035d.getVisibility() == 0 ? (int) (this.f2035d.getBottom() + this.f2035d.getTranslationY() + 0.5f) : 0;
        this.f2037f.setBounds(0, bottom, getWidth(), this.f2037f.getIntrinsicHeight() + bottom);
        this.f2037f.draw(canvas);
    }

    @Override // androidx.appcompat.widget.b0
    public boolean e() {
        y();
        return this.f2036e.e();
    }

    @Override // androidx.appcompat.widget.b0
    public void f() {
        y();
        this.f2036e.f();
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.b0
    public boolean g() {
        y();
        return this.f2036e.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f2035d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup, androidx.core.view.i0
    public int getNestedScrollAxes() {
        return this.f2043k0.a();
    }

    @Override // androidx.appcompat.widget.b0
    public CharSequence getTitle() {
        y();
        return this.f2036e.getTitle();
    }

    @Override // androidx.appcompat.widget.b0
    public boolean h() {
        y();
        return this.f2036e.h();
    }

    @Override // androidx.appcompat.widget.b0
    public boolean i() {
        y();
        return this.f2036e.i();
    }

    @Override // androidx.appcompat.widget.b0
    public boolean j() {
        y();
        return this.f2036e.j();
    }

    @Override // androidx.appcompat.widget.b0
    public boolean k() {
        y();
        return this.f2036e.k();
    }

    @Override // androidx.appcompat.widget.b0
    public boolean l() {
        y();
        return this.f2036e.l();
    }

    @Override // androidx.appcompat.widget.b0
    public void m(SparseArray<Parcelable> sparseArray) {
        y();
        this.f2036e.x(sparseArray);
    }

    @Override // androidx.appcompat.widget.b0
    public void n(int i10) {
        y();
        if (i10 == 2) {
            this.f2036e.Q();
        } else if (i10 == 5) {
            this.f2036e.S();
        } else {
            if (i10 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.b0
    public void o() {
        y();
        this.f2036e.n();
    }

    @Override // android.view.View
    @g.v0(21)
    public WindowInsets onApplyWindowInsets(@g.n0 WindowInsets windowInsets) {
        y();
        j1 j1VarL = j1.L(windowInsets, this);
        boolean zC = c(this.f2035d, new Rect(j1VarL.p(), j1VarL.r(), j1VarL.q(), j1VarL.o()), true, true, false, true);
        androidx.core.view.u0.o(this, j1VarL, this.f2046n);
        Rect rect = this.f2046n;
        j1 j1VarX = j1VarL.x(rect.left, rect.top, rect.right, rect.bottom);
        this.f2053u = j1VarX;
        boolean z10 = true;
        if (!this.f2054v.equals(j1VarX)) {
            this.f2054v = this.f2053u;
            zC = true;
        }
        if (this.f2047o.equals(this.f2046n)) {
            z10 = zC;
        } else {
            this.f2047o.set(this.f2046n);
        }
        if (z10) {
            requestLayout();
        }
        return j1VarL.a().c().b().J();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        t(getContext());
        androidx.core.view.u0.v1(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i15 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i16 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i15, i16, measuredWidth + i15, measuredHeight + i16);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int measuredHeight;
        y();
        measureChildWithMargins(this.f2035d, i10, 0, i11, 0);
        e eVar = (e) this.f2035d.getLayoutParams();
        int iMax = Math.max(0, this.f2035d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int iMax2 = Math.max(0, this.f2035d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f2035d.getMeasuredState());
        boolean z10 = (androidx.core.view.u0.C0(this) & 256) != 0;
        if (z10) {
            measuredHeight = this.f2032a;
            if (this.f2040i && this.f2035d.getTabContainer() != null) {
                measuredHeight += this.f2032a;
            }
        } else {
            measuredHeight = this.f2035d.getVisibility() != 8 ? this.f2035d.getMeasuredHeight() : 0;
        }
        this.f2048p.set(this.f2046n);
        j1 j1Var = this.f2053u;
        this.f2055w = j1Var;
        if (this.f2039h || z10) {
            this.f2055w = new j1.b(this.f2055w).h(m0.i.d(j1Var.p(), this.f2055w.r() + measuredHeight, this.f2055w.q(), this.f2055w.o() + 0)).a();
        } else {
            Rect rect = this.f2048p;
            rect.top += measuredHeight;
            rect.bottom += 0;
            this.f2055w = j1Var.x(0, measuredHeight, 0, 0);
        }
        c(this.f2034c, this.f2048p, true, true, true, true);
        if (!this.f2056x.equals(this.f2055w)) {
            j1 j1Var2 = this.f2055w;
            this.f2056x = j1Var2;
            androidx.core.view.u0.p(this.f2034c, j1Var2);
        }
        measureChildWithMargins(this.f2034c, i10, 0, i11, 0);
        e eVar2 = (e) this.f2034c.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f2034c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f2034c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f2034c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i11, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (!this.f2041j || !z10) {
            return false;
        }
        if (A(f11)) {
            b();
        } else {
            z();
        }
        this.f2042k = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f2044l + i11;
        this.f2044l = i14;
        setActionBarHideOffset(i14);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.f2043k0.b(view, view2, i10);
        this.f2044l = getActionBarHideOffset();
        s();
        d dVar = this.f2057y;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        if ((i10 & 2) == 0 || this.f2035d.getVisibility() != 0) {
            return false;
        }
        return this.f2041j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onStopNestedScroll(View view) {
        if (this.f2041j && !this.f2042k) {
            if (this.f2044l <= this.f2035d.getHeight()) {
                x();
            } else {
                w();
            }
        }
        d dVar = this.f2057y;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i10) {
        super.onWindowSystemUiVisibilityChanged(i10);
        y();
        int i11 = this.f2045m ^ i10;
        this.f2045m = i10;
        boolean z10 = (i10 & 4) == 0;
        boolean z11 = (i10 & 256) != 0;
        d dVar = this.f2057y;
        if (dVar != null) {
            dVar.c(!z11);
            if (z10 || !z11) {
                this.f2057y.a();
            } else {
                this.f2057y.d();
            }
        }
        if ((i11 & 256) == 0 || this.f2057y == null) {
            return;
        }
        androidx.core.view.u0.v1(this);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f2033b = i10;
        d dVar = this.f2057y;
        if (dVar != null) {
            dVar.f(i10);
        }
    }

    @Override // androidx.appcompat.widget.b0
    public void p(SparseArray<Parcelable> sparseArray) {
        y();
        this.f2036e.K(sparseArray);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final c0 r(View view) {
        if (view instanceof c0) {
            return (c0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void s() {
        removeCallbacks(this.C);
        removeCallbacks(this.D);
        ViewPropertyAnimator viewPropertyAnimator = this.A;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public void setActionBarHideOffset(int i10) {
        s();
        this.f2035d.setTranslationY(-Math.max(0, Math.min(i10, this.f2035d.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f2057y = dVar;
        if (getWindowToken() != null) {
            this.f2057y.f(this.f2033b);
            int i10 = this.f2045m;
            if (i10 != 0) {
                onWindowSystemUiVisibilityChanged(i10);
                androidx.core.view.u0.v1(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.f2040i = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f2041j) {
            this.f2041j = z10;
            if (z10) {
                return;
            }
            s();
            setActionBarHideOffset(0);
        }
    }

    @Override // androidx.appcompat.widget.b0
    public void setIcon(int i10) {
        y();
        this.f2036e.setIcon(i10);
    }

    @Override // androidx.appcompat.widget.b0
    public void setLogo(int i10) {
        y();
        this.f2036e.setLogo(i10);
    }

    public void setOverlayMode(boolean z10) {
        this.f2039h = z10;
        this.f2038g = z10 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z10) {
    }

    @Override // androidx.appcompat.widget.b0
    public void setUiOptions(int i10) {
    }

    @Override // androidx.appcompat.widget.b0
    public void setWindowCallback(Window.Callback callback) {
        y();
        this.f2036e.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.b0
    public void setWindowTitle(CharSequence charSequence) {
        y();
        this.f2036e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public final void t(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f2031v1);
        this.f2032a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f2037f = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f2038g = context.getApplicationInfo().targetSdkVersion < 19;
        this.f2058z = new OverScroller(context);
    }

    public boolean u() {
        return this.f2041j;
    }

    public boolean v() {
        return this.f2039h;
    }

    public final void w() {
        s();
        postDelayed(this.D, 600L);
    }

    public final void x() {
        s();
        postDelayed(this.C, 600L);
    }

    public void y() {
        if (this.f2034c == null) {
            this.f2034c = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f2035d = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.f2036e = r(findViewById(R.id.action_bar));
        }
    }

    public final void z() {
        s();
        this.C.run();
    }

    public ActionBarOverlayLayout(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2033b = 0;
        this.f2046n = new Rect();
        this.f2047o = new Rect();
        this.f2048p = new Rect();
        this.f2049q = new Rect();
        this.f2050r = new Rect();
        this.f2051s = new Rect();
        this.f2052t = new Rect();
        j1 j1Var = j1.f4928c;
        this.f2053u = j1Var;
        this.f2054v = j1Var;
        this.f2055w = j1Var;
        this.f2056x = j1Var;
        this.B = new a();
        this.C = new b();
        this.D = new c();
        t(context);
        this.f2043k0 = new androidx.core.view.j0(this);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    @Override // androidx.appcompat.widget.b0
    public void setIcon(Drawable drawable) {
        y();
        this.f2036e.setIcon(drawable);
    }
}
