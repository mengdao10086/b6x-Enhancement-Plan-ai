package androidx.appcompat.widget;

import a.c7;
import a.d7;
import a.eh;
import a.jg;
import a.kg;
import a.lg;
import a.mg;
import a.sh;
import a.t;
import a.uc;
import a.v4;
import a.y;
import a.z8;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements c7, lg, jg, kg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f8146a = {t.actionBarSize, R.attr.windowContentOverlay};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d7 f4026a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final mg f4027a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public sh f4028a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AnimatorListenerAdapter f4029a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f4030a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f4031a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewPropertyAnimator f4032a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OverScroller f4033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActionBarContainer f4034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f4035a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ContentFrameLayout f4036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f4037a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public sh f4038b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Rect f4039b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Runnable f4040b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4041b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public sh f4042c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Rect f4043c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4044c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public sh f4045d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final Rect f4046d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f4047d;
    public final Rect e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f4048e;
    public final Rect f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f4049f;
    public final Rect g;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f4032a = null;
            actionBarOverlayLayout.f4049f = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f4032a = null;
            actionBarOverlayLayout.f4049f = false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f4032a = actionBarOverlayLayout.f4034a.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f4029a);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f4032a = actionBarOverlayLayout.f4034a.animate().translationY(-ActionBarOverlayLayout.this.f4034a.getHeight()).setListener(ActionBarOverlayLayout.this.f4029a);
        }
    }

    public interface d {
        void a();

        void b();

        void c();

        void d();

        void e(int i);

        void f(boolean z);
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(int i, int i2) {
            super(i, i2);
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.f4030a = new Rect();
        this.f4039b = new Rect();
        this.f4043c = new Rect();
        this.f4046d = new Rect();
        this.e = new Rect();
        this.f = new Rect();
        this.g = new Rect();
        sh shVar = sh.f7396a;
        this.f4028a = shVar;
        this.f4038b = shVar;
        this.f4042c = shVar;
        this.f4045d = shVar;
        this.f4029a = new a();
        this.f4037a = new b();
        this.f4040b = new c();
        v(context);
        this.f4027a = new mg(this);
    }

    public final void A() {
        u();
        this.f4037a.run();
    }

    public final boolean B(float f) {
        this.f4033a.fling(0, 0, 0, (int) f, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f4033a.getFinalY() > this.f4034a.getHeight();
    }

    @Override // a.c7
    public void a() {
        z();
        this.f4026a.a();
    }

    @Override // a.c7
    public void b(Menu menu, v4.a aVar) {
        z();
        this.f4026a.b(menu, aVar);
    }

    @Override // a.c7
    public boolean c() {
        z();
        return this.f4026a.c();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // a.c7
    public boolean d() {
        z();
        return this.f4026a.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f4031a == null || this.f4041b) {
            return;
        }
        int bottom = this.f4034a.getVisibility() == 0 ? (int) (this.f4034a.getBottom() + this.f4034a.getTranslationY() + 0.5f) : 0;
        this.f4031a.setBounds(0, bottom, getWidth(), this.f4031a.getIntrinsicHeight() + bottom);
        this.f4031a.draw(canvas);
    }

    @Override // a.c7
    public boolean e() {
        z();
        return this.f4026a.e();
    }

    @Override // a.c7
    public boolean f() {
        z();
        return this.f4026a.f();
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        z();
        boolean zQ = q(this.f4034a, rect, true, true, false, true);
        this.f4046d.set(rect);
        z8.a(this, this.f4046d, this.f4030a);
        if (!this.e.equals(this.f4046d)) {
            this.e.set(this.f4046d);
            zQ = true;
        }
        if (!this.f4039b.equals(this.f4030a)) {
            this.f4039b.set(this.f4030a);
            zQ = true;
        }
        if (zQ) {
            requestLayout();
        }
        return true;
    }

    @Override // a.c7
    public boolean g() {
        z();
        return this.f4026a.g();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f4034a;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f4027a.a();
    }

    public CharSequence getTitle() {
        z();
        return this.f4026a.getTitle();
    }

    @Override // a.jg
    public boolean h(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // a.jg
    public void i(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    @Override // a.jg
    public void j(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // a.jg
    public void k(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // a.jg
    public void l(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // a.kg
    public void m(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        k(view, i, i2, i3, i4, i5);
    }

    @Override // a.c7
    public void n(int i) {
        z();
        if (i == 2) {
            this.f4026a.s();
        } else if (i == 5) {
            this.f4026a.k();
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // a.c7
    public void o() {
        z();
        this.f4026a.n();
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        z();
        sh shVarS = sh.s(windowInsets);
        boolean zQ = q(this.f4034a, new Rect(shVarS.g(), shVarS.i(), shVarS.h(), shVarS.f()), true, true, false, true);
        eh.f(this, shVarS, this.f4030a);
        Rect rect = this.f4030a;
        sh shVarJ = shVarS.j(rect.left, rect.top, rect.right, rect.bottom);
        this.f4028a = shVarJ;
        boolean z = true;
        if (!this.f4038b.equals(shVarJ)) {
            this.f4038b = this.f4028a;
            zQ = true;
        }
        if (this.f4039b.equals(this.f4030a)) {
            z = zQ;
        } else {
            this.f4039b.set(this.f4030a);
        }
        if (z) {
            requestLayout();
        }
        return shVarS.a().c().b().r();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v(getContext());
        eh.h0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int measuredHeight;
        sh shVarA;
        z();
        measureChildWithMargins(this.f4034a, i, 0, i2, 0);
        e eVar = (e) this.f4034a.getLayoutParams();
        int iMax = Math.max(0, this.f4034a.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int iMax2 = Math.max(0, this.f4034a.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f4034a.getMeasuredState());
        boolean z = (eh.J(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f4025a;
            if (this.f4047d && this.f4034a.getTabContainer() != null) {
                measuredHeight += this.f4025a;
            }
        } else {
            measuredHeight = this.f4034a.getVisibility() != 8 ? this.f4034a.getMeasuredHeight() : 0;
        }
        this.f4043c.set(this.f4030a);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f4042c = this.f4028a;
        } else {
            this.f.set(this.f4046d);
        }
        if (!this.f4044c && !z) {
            Rect rect = this.f4043c;
            rect.top += measuredHeight;
            rect.bottom += 0;
            if (Build.VERSION.SDK_INT >= 21) {
                shVarA = this.f4042c.j(0, measuredHeight, 0, 0);
                this.f4042c = shVarA;
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            uc ucVarB = uc.b(this.f4042c.g(), this.f4042c.i() + measuredHeight, this.f4042c.h(), this.f4042c.f() + 0);
            sh.a aVar = new sh.a(this.f4042c);
            aVar.c(ucVarB);
            shVarA = aVar.a();
            this.f4042c = shVarA;
        } else {
            Rect rect2 = this.f;
            rect2.top += measuredHeight;
            rect2.bottom += 0;
        }
        q(this.f4036a, this.f4043c, true, true, true, true);
        if (Build.VERSION.SDK_INT >= 21 && !this.f4045d.equals(this.f4042c)) {
            sh shVar = this.f4042c;
            this.f4045d = shVar;
            eh.g(this.f4036a, shVar);
        } else if (Build.VERSION.SDK_INT < 21 && !this.g.equals(this.f)) {
            this.g.set(this.f);
            this.f4036a.a(this.f);
        }
        measureChildWithMargins(this.f4036a, i, 0, i2, 0);
        e eVar2 = (e) this.f4036a.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f4036a.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f4036a.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f4036a.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f4048e || !z) {
            return false;
        }
        if (B(f2)) {
            p();
        } else {
            A();
        }
        this.f4049f = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.c + i2;
        this.c = i5;
        setActionBarHideOffset(i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f4027a.b(view, view2, i);
        this.c = getActionBarHideOffset();
        u();
        d dVar = this.f4035a;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f4034a.getVisibility() != 0) {
            return false;
        }
        return this.f4048e;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public void onStopNestedScroll(View view) {
        if (this.f4048e && !this.f4049f) {
            if (this.c <= this.f4034a.getHeight()) {
                y();
            } else {
                x();
            }
        }
        d dVar = this.f4035a;
        if (dVar != null) {
            dVar.c();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        z();
        int i2 = this.d ^ i;
        this.d = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        d dVar = this.f4035a;
        if (dVar != null) {
            dVar.f(!z2);
            if (z || !z2) {
                this.f4035a.b();
            } else {
                this.f4035a.d();
            }
        }
        if ((i2 & 256) == 0 || this.f4035a == null) {
            return;
        }
        eh.h0(this);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.b = i;
        d dVar = this.f4035a;
        if (dVar != null) {
            dVar.e(i);
        }
    }

    public final void p() {
        u();
        this.f4040b.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
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
            r5 = r0
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = r0
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = r0
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.q(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i) {
        u();
        this.f4034a.setTranslationY(-Math.max(0, Math.min(i, this.f4034a.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f4035a = dVar;
        if (getWindowToken() != null) {
            this.f4035a.e(this.b);
            int i = this.d;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                eh.h0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f4047d = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f4048e) {
            this.f4048e = z;
            if (z) {
                return;
            }
            u();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        z();
        this.f4026a.r(i);
    }

    public void setIcon(Drawable drawable) {
        z();
        this.f4026a.v(drawable);
    }

    public void setLogo(int i) {
        z();
        this.f4026a.h(i);
    }

    public void setOverlayMode(boolean z) {
        this.f4044c = z;
        this.f4041b = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // a.c7
    public void setWindowCallback(Window.Callback callback) {
        z();
        this.f4026a.setWindowCallback(callback);
    }

    @Override // a.c7
    public void setWindowTitle(CharSequence charSequence) {
        z();
        this.f4026a.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final d7 t(View view) {
        if (view instanceof d7) {
            return (d7) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void u() {
        removeCallbacks(this.f4037a);
        removeCallbacks(this.f4040b);
        ViewPropertyAnimator viewPropertyAnimator = this.f4032a;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void v(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f8146a);
        this.f4025a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f4031a = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f4041b = context.getApplicationInfo().targetSdkVersion < 19;
        this.f4033a = new OverScroller(context);
    }

    public boolean w() {
        return this.f4044c;
    }

    public final void x() {
        u();
        postDelayed(this.f4040b, 600L);
    }

    public final void y() {
        u();
        postDelayed(this.f4037a, 600L);
    }

    public void z() {
        if (this.f4036a == null) {
            this.f4036a = (ContentFrameLayout) findViewById(y.action_bar_activity_content);
            this.f4034a = (ActionBarContainer) findViewById(y.action_bar_container);
            this.f4026a = t(findViewById(y.action_bar));
        }
    }
}
