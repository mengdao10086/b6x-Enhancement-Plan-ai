package com.google.android.material.appbar;

import a1.d;
import a1.g;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.e0;
import androidx.core.view.j1;
import androidx.core.view.k0;
import androidx.core.view.u0;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.t;
import g.d0;
import g.i1;
import g.l;
import g.n0;
import g.p0;
import g.r;
import g.v;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import le.j;
import le.k;

/* JADX INFO: loaded from: classes3.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f19447t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f19448u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f19449v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f19450w = 4;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f19451x = 8;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f19452y = R.style.Widget_Design_AppBarLayout;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f19453z = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f19458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public j1 f19460g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<c> f19461h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f19462i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f19463j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f19464k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f19465l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @d0
    public int f19466m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @p0
    public WeakReference<View> f19467n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public ValueAnimator f19468o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<g> f19469p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int[] f19470q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public Drawable f19471r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Behavior f19472s;

    public static class BaseBehavior<T extends AppBarLayout> extends ld.a<T> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f19473s = 600;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f19474l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f19475m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public ValueAnimator f19476n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public SavedState f19477o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @p0
        public WeakReference<View> f19478p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public e f19479q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f19480r;

        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CoordinatorLayout f19486a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f19487b;

            public a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f19486a = coordinatorLayout;
                this.f19487b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@n0 ValueAnimator valueAnimator) {
                BaseBehavior.this.X(this.f19486a, this.f19487b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        public class b extends androidx.core.view.a {
            public b() {
            }

            @Override // androidx.core.view.a
            public void g(View view, @n0 a1.d dVar) {
                super.g(view, dVar);
                dVar.M1(BaseBehavior.this.f19480r);
                dVar.b1(ScrollView.class.getName());
            }
        }

        public class c implements a1.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CoordinatorLayout f19490a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f19491b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ View f19492c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f19493d;

            public c(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10) {
                this.f19490a = coordinatorLayout;
                this.f19491b = appBarLayout;
                this.f19492c = view;
                this.f19493d = i10;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // a1.g
            public boolean a(@n0 View view, @p0 g.a aVar) {
                BaseBehavior.this.r(this.f19490a, this.f19491b, this.f19492c, 0, this.f19493d, new int[]{0, 0}, 1);
                return true;
            }
        }

        public class d implements a1.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AppBarLayout f19495a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f19496b;

            public d(AppBarLayout appBarLayout, boolean z10) {
                this.f19495a = appBarLayout;
                this.f19496b = z10;
            }

            @Override // a1.g
            public boolean a(@n0 View view, @p0 g.a aVar) {
                this.f19495a.setExpanded(this.f19496b);
                return true;
            }
        }

        public static abstract class e<T extends AppBarLayout> {
            public abstract boolean a(@n0 T t10);
        }

        public BaseBehavior() {
        }

        public static boolean i0(int i10, int i11) {
            return (i10 & i11) == i11;
        }

        @p0
        public static View l0(@n0 AppBarLayout appBarLayout, int i10) {
            int iAbs = Math.abs(i10);
            int childCount = appBarLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = appBarLayout.getChildAt(i11);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
        public void D(CoordinatorLayout coordinatorLayout, @n0 T t10, View view, int i10) {
            if (this.f19475m == 0 || i10 == 1) {
                G0(coordinatorLayout, t10);
                if (t10.p()) {
                    t10.C(t10.F(view));
                }
            }
            this.f19478p = new WeakReference<>(view);
        }

        public void B0(@p0 SavedState savedState, boolean z10) {
            if (this.f19477o == null || z10) {
                this.f19477o = savedState;
            }
        }

        @p0
        public SavedState C0(@p0 Parcelable parcelable, @n0 T t10) {
            int iH = H();
            int childCount = t10.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = t10.getChildAt(i10);
                int bottom = childAt.getBottom() + iH;
                if (childAt.getTop() + iH <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.f5282b;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    boolean z10 = iH == 0;
                    savedState.f19482d = z10;
                    savedState.f19481c = !z10 && (-iH) >= t10.getTotalScrollRange();
                    savedState.f19483e = i10;
                    savedState.f19485g = bottom == u0.e0(childAt) + t10.getTopInset();
                    savedState.f19484f = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return null;
        }

        public void D0(@p0 e eVar) {
            this.f19479q = eVar;
        }

        @Override // ld.a
        /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
        public int Y(@n0 CoordinatorLayout coordinatorLayout, @n0 T t10, int i10, int i11, int i12) {
            int iU = U();
            int i13 = 0;
            if (i11 == 0 || iU < i11 || iU > i12) {
                this.f19474l = 0;
            } else {
                int iE = t0.a.e(i10, i11, i12);
                if (iU != iE) {
                    int iQ0 = t10.l() ? q0(t10, iE) : iE;
                    boolean zN = N(iQ0);
                    int i14 = iU - iE;
                    this.f19474l = iE - iQ0;
                    if (zN) {
                        while (i13 < t10.getChildCount()) {
                            f fVar = (f) t10.getChildAt(i13).getLayoutParams();
                            d dVarB = fVar.b();
                            if (dVarB != null && (fVar.c() & 1) != 0) {
                                dVarB.a(t10, t10.getChildAt(i13), H());
                            }
                            i13++;
                        }
                    }
                    if (!zN && t10.l()) {
                        coordinatorLayout.j(t10);
                    }
                    t10.r(H());
                    I0(coordinatorLayout, t10, iE, iE < iU ? -1 : 1, false);
                    i13 = i14;
                }
            }
            H0(coordinatorLayout, t10);
            return i13;
        }

        public final boolean F0(@n0 CoordinatorLayout coordinatorLayout, @n0 T t10) {
            List<View> listR = coordinatorLayout.r(t10);
            int size = listR.size();
            for (int i10 = 0; i10 < size; i10++) {
                CoordinatorLayout.c cVarF = ((CoordinatorLayout.g) listR.get(i10).getLayoutParams()).f();
                if (cVarF instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) cVarF).S() != 0;
                }
            }
            return false;
        }

        public final void G0(CoordinatorLayout coordinatorLayout, @n0 T t10) {
            int topInset = t10.getTopInset() + t10.getPaddingTop();
            int iU = U() - topInset;
            int iM0 = m0(t10, iU);
            if (iM0 >= 0) {
                View childAt = t10.getChildAt(iM0);
                f fVar = (f) childAt.getLayoutParams();
                int iC = fVar.c();
                if ((iC & 17) == 17) {
                    int topInset2 = -childAt.getTop();
                    int iE0 = -childAt.getBottom();
                    if (iM0 == 0 && u0.U(t10) && u0.U(childAt)) {
                        topInset2 -= t10.getTopInset();
                    }
                    if (i0(iC, 2)) {
                        iE0 += u0.e0(childAt);
                    } else if (i0(iC, 5)) {
                        int iE02 = u0.e0(childAt) + iE0;
                        if (iU < iE02) {
                            topInset2 = iE02;
                        } else {
                            iE0 = iE02;
                        }
                    }
                    if (i0(iC, 32)) {
                        topInset2 += ((LinearLayout.LayoutParams) fVar).topMargin;
                        iE0 -= ((LinearLayout.LayoutParams) fVar).bottomMargin;
                    }
                    d0(coordinatorLayout, t10, t0.a.e(f0(iU, iE0, topInset2) + topInset, -t10.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        public final void H0(CoordinatorLayout coordinatorLayout, @n0 T t10) {
            View viewN0;
            u0.r1(coordinatorLayout, d.a.f118r.b());
            u0.r1(coordinatorLayout, d.a.f119s.b());
            if (t10.getTotalScrollRange() == 0 || (viewN0 = n0(coordinatorLayout)) == null || !j0(t10)) {
                return;
            }
            if (!u0.G0(coordinatorLayout)) {
                u0.B1(coordinatorLayout, new b());
            }
            this.f19480r = b0(coordinatorLayout, t10, viewN0);
        }

        public final void I0(@n0 CoordinatorLayout coordinatorLayout, @n0 T t10, int i10, int i11, boolean z10) {
            View viewL0 = l0(t10, i10);
            boolean zF = false;
            if (viewL0 != null) {
                int iC = ((f) viewL0.getLayoutParams()).c();
                if ((iC & 1) != 0) {
                    int iE0 = u0.e0(viewL0);
                    if (i11 <= 0 || (iC & 12) == 0 ? !((iC & 2) == 0 || (-i10) < (viewL0.getBottom() - iE0) - t10.getTopInset()) : (-i10) >= (viewL0.getBottom() - iE0) - t10.getTopInset()) {
                        zF = true;
                    }
                }
            }
            if (t10.p()) {
                zF = t10.F(k0(coordinatorLayout));
            }
            boolean zC = t10.C(zF);
            if (z10 || (zC && F0(coordinatorLayout, t10))) {
                t10.jumpDrawablesToCurrentState();
            }
        }

        @Override // ld.a
        public int U() {
            return H() + this.f19474l;
        }

        public final boolean b0(CoordinatorLayout coordinatorLayout, @n0 T t10, @n0 View view) {
            boolean z10 = false;
            if (U() != (-t10.getTotalScrollRange())) {
                c0(coordinatorLayout, t10, d.a.f118r, false);
                z10 = true;
            }
            if (U() != 0) {
                if (!view.canScrollVertically(-1)) {
                    c0(coordinatorLayout, t10, d.a.f119s, true);
                    return true;
                }
                int i10 = -t10.getDownNestedPreScrollRange();
                if (i10 != 0) {
                    u0.u1(coordinatorLayout, d.a.f119s, null, new c(coordinatorLayout, t10, view, i10));
                    return true;
                }
            }
            return z10;
        }

        public final void c0(CoordinatorLayout coordinatorLayout, @n0 T t10, @n0 d.a aVar, boolean z10) {
            u0.u1(coordinatorLayout, aVar, null, new d(t10, z10));
        }

        public final void d0(CoordinatorLayout coordinatorLayout, @n0 T t10, int i10, float f10) {
            int iAbs = Math.abs(U() - i10);
            float fAbs = Math.abs(f10);
            e0(coordinatorLayout, t10, i10, fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / t10.getHeight()) + 1.0f) * 150.0f));
        }

        public final void e0(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11) {
            int iU = U();
            if (iU == i10) {
                ValueAnimator valueAnimator = this.f19476n;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f19476n.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f19476n;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f19476n = valueAnimator3;
                valueAnimator3.setInterpolator(kd.a.f37170e);
                this.f19476n.addUpdateListener(new a(coordinatorLayout, t10));
            } else {
                valueAnimator2.cancel();
            }
            this.f19476n.setDuration(Math.min(i11, 600));
            this.f19476n.setIntValues(iU, i10);
            this.f19476n.start();
        }

        public final int f0(int i10, int i11, int i12) {
            return i10 < (i11 + i12) / 2 ? i11 : i12;
        }

        @Override // ld.a
        /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
        public boolean P(T t10) {
            e eVar = this.f19479q;
            if (eVar != null) {
                return eVar.a(t10);
            }
            WeakReference<View> weakReference = this.f19478p;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        public final boolean h0(@n0 CoordinatorLayout coordinatorLayout, @n0 T t10, @n0 View view) {
            return t10.n() && coordinatorLayout.getHeight() - view.getHeight() <= t10.getHeight();
        }

        public final boolean j0(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (((f) appBarLayout.getChildAt(i10).getLayoutParams()).f19516a != 0) {
                    return true;
                }
            }
            return false;
        }

        @p0
        public final View k0(@n0 CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if ((childAt instanceof e0) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        public final int m0(@n0 T t10, int i10) {
            int childCount = t10.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = t10.getChildAt(i11);
                int top2 = childAt.getTop();
                int bottom = childAt.getBottom();
                f fVar = (f) childAt.getLayoutParams();
                if (i0(fVar.c(), 32)) {
                    top2 -= ((LinearLayout.LayoutParams) fVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) fVar).bottomMargin;
                }
                int i12 = -i10;
                if (top2 <= i12 && bottom >= i12) {
                    return i11;
                }
            }
            return -1;
        }

        @p0
        public final View n0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if (((CoordinatorLayout.g) childAt.getLayoutParams()).f() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // ld.a
        /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
        public int S(@n0 T t10) {
            return -t10.getDownNestedScrollRange();
        }

        @Override // ld.a
        /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
        public int T(@n0 T t10) {
            return t10.getTotalScrollRange();
        }

        public final int q0(@n0 T t10, int i10) {
            int iAbs = Math.abs(i10);
            int childCount = t10.getChildCount();
            int topInset = 0;
            int i11 = 0;
            while (true) {
                if (i11 >= childCount) {
                    break;
                }
                View childAt = t10.getChildAt(i11);
                f fVar = (f) childAt.getLayoutParams();
                Interpolator interpolatorD = fVar.d();
                if (iAbs < childAt.getTop() || iAbs > childAt.getBottom()) {
                    i11++;
                } else if (interpolatorD != null) {
                    int iC = fVar.c();
                    if ((iC & 1) != 0) {
                        topInset = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) fVar).topMargin + ((LinearLayout.LayoutParams) fVar).bottomMargin;
                        if ((iC & 2) != 0) {
                            topInset -= u0.e0(childAt);
                        }
                    }
                    if (u0.U(childAt)) {
                        topInset -= t10.getTopInset();
                    }
                    if (topInset > 0) {
                        float f10 = topInset;
                        return Integer.signum(i10) * (childAt.getTop() + Math.round(f10 * interpolatorD.getInterpolation((iAbs - childAt.getTop()) / f10)));
                    }
                }
            }
            return i10;
        }

        @i1
        public boolean r0() {
            ValueAnimator valueAnimator = this.f19476n;
            return valueAnimator != null && valueAnimator.isRunning();
        }

        @Override // ld.a
        /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
        public void V(@n0 CoordinatorLayout coordinatorLayout, @n0 T t10) {
            G0(coordinatorLayout, t10);
            if (t10.p()) {
                t10.C(t10.F(k0(coordinatorLayout)));
            }
        }

        @Override // ld.d, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
        public boolean m(@n0 CoordinatorLayout coordinatorLayout, @n0 T t10, int i10) {
            boolean zM = super.m(coordinatorLayout, t10, i10);
            int pendingAction = t10.getPendingAction();
            SavedState savedState = this.f19477o;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z10 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i11 = -t10.getUpNestedPreScrollRange();
                        if (z10) {
                            d0(coordinatorLayout, t10, i11, 0.0f);
                        } else {
                            X(coordinatorLayout, t10, i11);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z10) {
                            d0(coordinatorLayout, t10, 0, 0.0f);
                        } else {
                            X(coordinatorLayout, t10, 0);
                        }
                    }
                }
            } else if (savedState.f19481c) {
                X(coordinatorLayout, t10, -t10.getTotalScrollRange());
            } else if (savedState.f19482d) {
                X(coordinatorLayout, t10, 0);
            } else {
                View childAt = t10.getChildAt(savedState.f19483e);
                X(coordinatorLayout, t10, (-childAt.getBottom()) + (this.f19477o.f19485g ? u0.e0(childAt) + t10.getTopInset() : Math.round(childAt.getHeight() * this.f19477o.f19484f)));
            }
            t10.w();
            this.f19477o = null;
            N(t0.a.e(H(), -t10.getTotalScrollRange(), 0));
            I0(coordinatorLayout, t10, H(), 0, true);
            t10.r(H());
            H0(coordinatorLayout, t10);
            return zM;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
        public boolean n(@n0 CoordinatorLayout coordinatorLayout, @n0 T t10, int i10, int i11, int i12, int i13) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.g) t10.getLayoutParams())).height != -2) {
                return super.n(coordinatorLayout, t10, i10, i11, i12, i13);
            }
            coordinatorLayout.O(t10, i10, i11, View.MeasureSpec.makeMeasureSpec(0, 0), i13);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
        public void r(CoordinatorLayout coordinatorLayout, @n0 T t10, View view, int i10, int i11, int[] iArr, int i12) {
            int i13;
            int downNestedPreScrollRange;
            if (i11 != 0) {
                if (i11 < 0) {
                    int i14 = -t10.getTotalScrollRange();
                    i13 = i14;
                    downNestedPreScrollRange = t10.getDownNestedPreScrollRange() + i14;
                } else {
                    i13 = -t10.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                if (i13 != downNestedPreScrollRange) {
                    iArr[1] = W(coordinatorLayout, t10, i11, i13, downNestedPreScrollRange);
                }
            }
            if (t10.p()) {
                t10.C(t10.F(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
        public void u(CoordinatorLayout coordinatorLayout, @n0 T t10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            if (i13 < 0) {
                iArr[1] = W(coordinatorLayout, t10, i13, -t10.getDownNestedScrollRange(), 0);
            }
            if (i13 == 0) {
                H0(coordinatorLayout, t10);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
        public void y(@n0 CoordinatorLayout coordinatorLayout, @n0 T t10, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                B0((SavedState) parcelable, true);
                super.y(coordinatorLayout, t10, this.f19477o.a());
            } else {
                super.y(coordinatorLayout, t10, parcelable);
                this.f19477o = null;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
        public Parcelable z(@n0 CoordinatorLayout coordinatorLayout, @n0 T t10) {
            Parcelable parcelableZ = super.z(coordinatorLayout, t10);
            SavedState savedStateC0 = C0(parcelableZ, t10);
            return savedStateC0 == null ? parcelableZ : savedStateC0;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
        public boolean B(@n0 CoordinatorLayout coordinatorLayout, @n0 T t10, @n0 View view, View view2, int i10, int i11) {
            ValueAnimator valueAnimator;
            boolean z10 = (i10 & 2) != 0 && (t10.p() || h0(coordinatorLayout, t10, view));
            if (z10 && (valueAnimator = this.f19476n) != null) {
                valueAnimator.cancel();
            }
            this.f19478p = null;
            this.f19475m = i11;
            return z10;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f19481c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f19482d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f19483e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public float f19484f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public boolean f19485g;

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

            public SavedState(@n0 Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f19481c = parcel.readByte() != 0;
                this.f19482d = parcel.readByte() != 0;
                this.f19483e = parcel.readInt();
                this.f19484f = parcel.readFloat();
                this.f19485g = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@n0 Parcel parcel, int i10) {
                super.writeToParcel(parcel, i10);
                parcel.writeByte(this.f19481c ? (byte) 1 : (byte) 0);
                parcel.writeByte(this.f19482d ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f19483e);
                parcel.writeFloat(this.f19484f);
                parcel.writeByte(this.f19485g ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {

        public static abstract class a extends BaseBehavior.e<AppBarLayout> {
        }

        public Behavior() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: A0 */
        public /* bridge */ /* synthetic */ void D(CoordinatorLayout coordinatorLayout, @n0 AppBarLayout appBarLayout, View view, int i10) {
            super.D(coordinatorLayout, appBarLayout, view, i10);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void D0(@p0 BaseBehavior.e eVar) {
            super.D0(eVar);
        }

        @Override // ld.a, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean E(@n0 CoordinatorLayout coordinatorLayout, @n0 View view, @n0 MotionEvent motionEvent) {
            return super.E(coordinatorLayout, view, motionEvent);
        }

        @Override // ld.d
        public /* bridge */ /* synthetic */ int G() {
            return super.G();
        }

        @Override // ld.d
        public /* bridge */ /* synthetic */ int H() {
            return super.H();
        }

        @Override // ld.d
        public /* bridge */ /* synthetic */ boolean I() {
            return super.I();
        }

        @Override // ld.d
        public /* bridge */ /* synthetic */ boolean J() {
            return super.J();
        }

        @Override // ld.d
        public /* bridge */ /* synthetic */ void L(boolean z10) {
            super.L(z10);
        }

        @Override // ld.d
        public /* bridge */ /* synthetic */ boolean M(int i10) {
            return super.M(i10);
        }

        @Override // ld.d
        public /* bridge */ /* synthetic */ boolean N(int i10) {
            return super.N(i10);
        }

        @Override // ld.d
        public /* bridge */ /* synthetic */ void O(boolean z10) {
            super.O(z10);
        }

        @Override // ld.a, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean l(@n0 CoordinatorLayout coordinatorLayout, @n0 View view, @n0 MotionEvent motionEvent) {
            return super.l(coordinatorLayout, view, motionEvent);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: t0 */
        public /* bridge */ /* synthetic */ boolean m(@n0 CoordinatorLayout coordinatorLayout, @n0 AppBarLayout appBarLayout, int i10) {
            return super.m(coordinatorLayout, appBarLayout, i10);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: u0 */
        public /* bridge */ /* synthetic */ boolean n(@n0 CoordinatorLayout coordinatorLayout, @n0 AppBarLayout appBarLayout, int i10, int i11, int i12, int i13) {
            return super.n(coordinatorLayout, appBarLayout, i10, i11, i12, i13);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: v0 */
        public /* bridge */ /* synthetic */ void r(CoordinatorLayout coordinatorLayout, @n0 AppBarLayout appBarLayout, View view, int i10, int i11, int[] iArr, int i12) {
            super.r(coordinatorLayout, appBarLayout, view, i10, i11, iArr, i12);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: w0 */
        public /* bridge */ /* synthetic */ void u(CoordinatorLayout coordinatorLayout, @n0 AppBarLayout appBarLayout, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            super.u(coordinatorLayout, appBarLayout, view, i10, i11, i12, i13, i14, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: x0 */
        public /* bridge */ /* synthetic */ void y(@n0 CoordinatorLayout coordinatorLayout, @n0 AppBarLayout appBarLayout, Parcelable parcelable) {
            super.y(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: y0 */
        public /* bridge */ /* synthetic */ Parcelable z(@n0 CoordinatorLayout coordinatorLayout, @n0 AppBarLayout appBarLayout) {
            return super.z(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: z0 */
        public /* bridge */ /* synthetic */ boolean B(@n0 CoordinatorLayout coordinatorLayout, @n0 AppBarLayout appBarLayout, @n0 View view, View view2, int i10, int i11) {
            return super.B(coordinatorLayout, appBarLayout, view, view2, i10, i11);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends ld.b {
        public ScrollingViewBehavior() {
        }

        public static int Z(@n0 AppBarLayout appBarLayout) {
            CoordinatorLayout.c cVarF = ((CoordinatorLayout.g) appBarLayout.getLayoutParams()).f();
            if (cVarF instanceof BaseBehavior) {
                return ((BaseBehavior) cVarF).U();
            }
            return 0;
        }

        @Override // ld.d
        public /* bridge */ /* synthetic */ int G() {
            return super.G();
        }

        @Override // ld.d
        public /* bridge */ /* synthetic */ int H() {
            return super.H();
        }

        @Override // ld.d
        public /* bridge */ /* synthetic */ boolean I() {
            return super.I();
        }

        @Override // ld.d
        public /* bridge */ /* synthetic */ boolean J() {
            return super.J();
        }

        @Override // ld.d
        public /* bridge */ /* synthetic */ void L(boolean z10) {
            super.L(z10);
        }

        @Override // ld.d
        public /* bridge */ /* synthetic */ boolean M(int i10) {
            return super.M(i10);
        }

        @Override // ld.d
        public /* bridge */ /* synthetic */ boolean N(int i10) {
            return super.N(i10);
        }

        @Override // ld.d
        public /* bridge */ /* synthetic */ void O(boolean z10) {
            super.O(z10);
        }

        @Override // ld.b
        public float R(View view) {
            int i10;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int iZ = Z(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iZ > downNestedPreScrollRange) && (i10 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iZ / i10) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // ld.b
        public int T(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.T(view);
        }

        @Override // ld.b
        @p0
        /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
        public AppBarLayout P(@n0 List<View> list) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = list.get(i10);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        public final void a0(@n0 View view, @n0 View view2) {
            CoordinatorLayout.c cVarF = ((CoordinatorLayout.g) view2.getLayoutParams()).f();
            if (cVarF instanceof BaseBehavior) {
                u0.f1(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) cVarF).f19474l) + U()) - Q(view2));
            }
        }

        public final void b0(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.p()) {
                    appBarLayout.C(appBarLayout.F(view));
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean f(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean i(@n0 CoordinatorLayout coordinatorLayout, @n0 View view, @n0 View view2) {
            a0(view, view2);
            b0(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void j(@n0 CoordinatorLayout coordinatorLayout, @n0 View view, @n0 View view2) {
            if (view2 instanceof AppBarLayout) {
                u0.r1(coordinatorLayout, d.a.f118r.b());
                u0.r1(coordinatorLayout, d.a.f119s.b());
                u0.B1(coordinatorLayout, null);
            }
        }

        @Override // ld.d, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean m(@n0 CoordinatorLayout coordinatorLayout, @n0 View view, int i10) {
            return super.m(coordinatorLayout, view, i10);
        }

        @Override // ld.b, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean n(@n0 CoordinatorLayout coordinatorLayout, @n0 View view, int i10, int i11, int i12, int i13) {
            return super.n(coordinatorLayout, view, i10, i11, i12, i13);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean x(@n0 CoordinatorLayout coordinatorLayout, @n0 View view, @n0 Rect rect, boolean z10) {
            AppBarLayout appBarLayoutP = P(coordinatorLayout.q(view));
            if (appBarLayoutP != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f39580d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    appBarLayoutP.x(false, !z10);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            W(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public class a implements k0 {
        public a() {
        }

        @Override // androidx.core.view.k0
        public j1 a(View view, j1 j1Var) {
            return AppBarLayout.this.s(j1Var);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f19499a;

        public b(j jVar) {
            this.f19499a = jVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@n0 ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f19499a.n0(fFloatValue);
            if (AppBarLayout.this.f19471r instanceof j) {
                ((j) AppBarLayout.this.f19471r).n0(fFloatValue);
            }
            Iterator it2 = AppBarLayout.this.f19469p.iterator();
            while (it2.hasNext()) {
                ((g) it2.next()).a(fFloatValue, this.f19499a.D());
            }
        }
    }

    public interface c<T extends AppBarLayout> {
        void a(T t10, int i10);
    }

    public static abstract class d {
        public abstract void a(@n0 AppBarLayout appBarLayout, @n0 View view, float f10);
    }

    public static class e extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final float f19501c = 0.3f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f19502a = new Rect();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f19503b = new Rect();

        public static void b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.d
        public void a(@n0 AppBarLayout appBarLayout, @n0 View view, float f10) {
            b(this.f19502a, appBarLayout, view);
            float fAbs = this.f19502a.top - Math.abs(f10);
            if (fAbs > 0.0f) {
                u0.M1(view, null);
                view.setTranslationY(0.0f);
                return;
            }
            float fD = 1.0f - t0.a.d(Math.abs(fAbs / this.f19502a.height()), 0.0f, 1.0f);
            float fHeight = (-fAbs) - ((this.f19502a.height() * 0.3f) * (1.0f - (fD * fD)));
            view.setTranslationY(fHeight);
            view.getDrawingRect(this.f19503b);
            this.f19503b.offset(0, (int) (-fHeight));
            u0.M1(view, this.f19503b);
        }
    }

    public interface g {
        void a(@r float f10, @l int i10);
    }

    public interface h extends c<AppBarLayout> {
        @Override // com.google.android.material.appbar.AppBarLayout.c
        void a(AppBarLayout appBarLayout, int i10);
    }

    public AppBarLayout(@n0 Context context) {
        this(context, null);
    }

    public final boolean A(boolean z10) {
        if (this.f19463j == z10) {
            return false;
        }
        this.f19463j = z10;
        refreshDrawableState();
        return true;
    }

    public boolean B(boolean z10) {
        return D(z10, true);
    }

    public boolean C(boolean z10) {
        return D(z10, !this.f19462i);
    }

    public boolean D(boolean z10, boolean z11) {
        if (!z11 || this.f19464k == z10) {
            return false;
        }
        this.f19464k = z10;
        refreshDrawableState();
        if (!this.f19465l || !(getBackground() instanceof j)) {
            return true;
        }
        H((j) getBackground(), z10);
        return true;
    }

    public final boolean E() {
        return this.f19471r != null && getTopInset() > 0;
    }

    public boolean F(@p0 View view) {
        View viewH = h(view);
        if (viewH != null) {
            view = viewH;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    public final boolean G() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || u0.U(childAt)) ? false : true;
    }

    public final void H(@n0 j jVar, boolean z10) {
        float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
        float f10 = z10 ? 0.0f : dimension;
        if (!z10) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.f19468o;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, dimension);
        this.f19468o = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
        this.f19468o.setInterpolator(kd.a.f37166a);
        this.f19468o.addUpdateListener(new b(jVar));
        this.f19468o.start();
    }

    public final void I() {
        setWillNotDraw(!E());
    }

    public void c(@n0 g gVar) {
        this.f19469p.add(gVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f;
    }

    public void d(@p0 c cVar) {
        if (this.f19461h == null) {
            this.f19461h = new ArrayList();
        }
        if (cVar == null || this.f19461h.contains(cVar)) {
            return;
        }
        this.f19461h.add(cVar);
    }

    @Override // android.view.View
    public void draw(@n0 Canvas canvas) {
        super.draw(canvas);
        if (E()) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.f19454a);
            this.f19471r.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f19471r;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public void e(h hVar) {
        d(hVar);
    }

    public void f() {
        this.f19469p.clear();
    }

    public final void g() {
        WeakReference<View> weakReference = this.f19467n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f19467n = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    @n0
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.f19472s = behavior;
        return behavior;
    }

    public int getDownNestedPreScrollRange() {
        int iMin;
        int iE0;
        int i10 = this.f19456c;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = fVar.f19516a;
                if ((i12 & 5) != 5) {
                    if (i11 > 0) {
                        break;
                    }
                } else {
                    int i13 = ((LinearLayout.LayoutParams) fVar).topMargin + ((LinearLayout.LayoutParams) fVar).bottomMargin;
                    if ((i12 & 8) != 0) {
                        iE0 = u0.e0(childAt);
                    } else if ((i12 & 2) != 0) {
                        iE0 = measuredHeight - u0.e0(childAt);
                    } else {
                        iMin = i13 + measuredHeight;
                        if (childCount == 0 && u0.U(childAt)) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                        i11 += iMin;
                    }
                    iMin = i13 + iE0;
                    if (childCount == 0) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i11 += iMin;
                }
            }
        }
        int iMax = Math.max(0, i11);
        this.f19456c = iMax;
        return iMax;
    }

    public int getDownNestedScrollRange() {
        int i10 = this.f19457d;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int iE0 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) fVar).topMargin + ((LinearLayout.LayoutParams) fVar).bottomMargin;
                int i12 = fVar.f19516a;
                if ((i12 & 1) == 0) {
                    break;
                }
                iE0 += measuredHeight;
                if ((i12 & 2) != 0) {
                    iE0 -= u0.e0(childAt);
                    break;
                }
            }
            i11++;
        }
        int iMax = Math.max(0, iE0);
        this.f19457d = iMax;
        return iMax;
    }

    @d0
    public int getLiftOnScrollTargetViewId() {
        return this.f19466m;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int iE0 = u0.e0(this);
        if (iE0 == 0) {
            int childCount = getChildCount();
            iE0 = childCount >= 1 ? u0.e0(getChildAt(childCount - 1)) : 0;
            if (iE0 == 0) {
                return getHeight() / 3;
            }
        }
        return (iE0 * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f19459f;
    }

    @p0
    public Drawable getStatusBarForeground() {
        return this.f19471r;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @i1
    public final int getTopInset() {
        j1 j1Var = this.f19460g;
        if (j1Var != null) {
            return j1Var.r();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i10 = this.f19455b;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int iE0 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = fVar.f19516a;
                if ((i12 & 1) == 0) {
                    break;
                }
                iE0 += measuredHeight + ((LinearLayout.LayoutParams) fVar).topMargin + ((LinearLayout.LayoutParams) fVar).bottomMargin;
                if (i11 == 0 && u0.U(childAt)) {
                    iE0 -= getTopInset();
                }
                if ((i12 & 2) != 0) {
                    iE0 -= u0.e0(childAt);
                    break;
                }
            }
            i11++;
        }
        int iMax = Math.max(0, iE0);
        this.f19455b = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @p0
    public final View h(@p0 View view) {
        int i10;
        if (this.f19467n == null && (i10 = this.f19466m) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i10) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.f19466m);
            }
            if (viewFindViewById != null) {
                this.f19467n = new WeakReference<>(viewFindViewById);
            }
        }
        WeakReference<View> weakReference = this.f19467n;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LinearLayout.LayoutParams ? new f((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    public boolean l() {
        return this.f19458e;
    }

    public final boolean m() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (((f) getChildAt(i10).getLayoutParams()).e()) {
                return true;
            }
        }
        return false;
    }

    public boolean n() {
        return getTotalScrollRange() != 0;
    }

    public final void o() {
        Behavior behavior = this.f19472s;
        BaseBehavior.SavedState savedStateC0 = (behavior == null || this.f19455b == -1 || this.f19459f != 0) ? null : behavior.C0(AbsSavedState.f5282b, this);
        this.f19455b = -1;
        this.f19456c = -1;
        this.f19457d = -1;
        if (savedStateC0 != null) {
            this.f19472s.B0(savedStateC0, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i10) {
        if (this.f19470q == null) {
            this.f19470q = new int[4];
        }
        int[] iArr = this.f19470q;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i10 + iArr.length);
        boolean z10 = this.f19463j;
        int i11 = R.attr.state_liftable;
        if (!z10) {
            i11 = -i11;
        }
        iArr[0] = i11;
        iArr[1] = (z10 && this.f19464k) ? R.attr.state_lifted : -R.attr.state_lifted;
        int i12 = R.attr.state_collapsible;
        if (!z10) {
            i12 = -i12;
        }
        iArr[2] = i12;
        iArr[3] = (z10 && this.f19464k) ? R.attr.state_collapsed : -R.attr.state_collapsed;
        return LinearLayout.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        boolean z11 = true;
        if (u0.U(this) && G()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                u0.f1(getChildAt(childCount), topInset);
            }
        }
        o();
        this.f19458e = false;
        int childCount2 = getChildCount();
        int i14 = 0;
        while (true) {
            if (i14 >= childCount2) {
                break;
            }
            if (((f) getChildAt(i14).getLayoutParams()).d() != null) {
                this.f19458e = true;
                break;
            }
            i14++;
        }
        Drawable drawable = this.f19471r;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f19462i) {
            return;
        }
        if (!this.f19465l && !m()) {
            z11 = false;
        }
        A(z11);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        if (mode != 1073741824 && u0.U(this) && G()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = t0.a.e(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i11));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        o();
    }

    public boolean p() {
        return this.f19465l;
    }

    public boolean q() {
        return this.f19464k;
    }

    public void r(int i10) {
        this.f19454a = i10;
        if (!willNotDraw()) {
            u0.n1(this);
        }
        List<c> list = this.f19461h;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                c cVar = this.f19461h.get(i11);
                if (cVar != null) {
                    cVar.a(this, i10);
                }
            }
        }
    }

    public j1 s(j1 j1Var) {
        j1 j1Var2 = u0.U(this) ? j1Var : null;
        if (!androidx.core.util.j.a(this.f19460g, j1Var2)) {
            this.f19460g = j1Var2;
            I();
            requestLayout();
        }
        return j1Var;
    }

    @Override // android.view.View
    @v0(21)
    public void setElevation(float f10) {
        super.setElevation(f10);
        k.d(this, f10);
    }

    public void setExpanded(boolean z10) {
        x(z10, u0.U0(this));
    }

    public void setLiftOnScroll(boolean z10) {
        this.f19465l = z10;
    }

    public void setLiftOnScrollTargetView(@p0 View view) {
        this.f19466m = -1;
        if (view == null) {
            g();
        } else {
            this.f19467n = new WeakReference<>(view);
        }
    }

    public void setLiftOnScrollTargetViewId(@d0 int i10) {
        this.f19466m = i10;
        g();
    }

    public void setLiftableOverrideEnabled(boolean z10) {
        this.f19462i = z10;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i10) {
        if (i10 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i10);
    }

    public void setStatusBarForeground(@p0 Drawable drawable) {
        Drawable drawable2 = this.f19471r;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f19471r = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f19471r.setState(getDrawableState());
                }
                n0.c.m(this.f19471r, u0.Z(this));
                this.f19471r.setVisible(getVisibility() == 0, false);
                this.f19471r.setCallback(this);
            }
            I();
            u0.n1(this);
        }
    }

    public void setStatusBarForegroundColor(@l int i10) {
        setStatusBarForeground(new ColorDrawable(i10));
    }

    public void setStatusBarForegroundResource(@v int i10) {
        setStatusBarForeground(i.a.b(getContext(), i10));
    }

    @Deprecated
    public void setTargetElevation(float f10) {
        ld.f.b(this, f10);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f19471r;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
    }

    public boolean t(@n0 g gVar) {
        return this.f19469p.remove(gVar);
    }

    public void u(@p0 c cVar) {
        List<c> list = this.f19461h;
        if (list == null || cVar == null) {
            return;
        }
        list.remove(cVar);
    }

    public void v(h hVar) {
        u(hVar);
    }

    @Override // android.view.View
    public boolean verifyDrawable(@n0 Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f19471r;
    }

    public void w() {
        this.f19459f = 0;
    }

    public void x(boolean z10, boolean z11) {
        y(z10, z11, true);
    }

    public final void y(boolean z10, boolean z11, boolean z12) {
        this.f19459f = (z10 ? 1 : 2) | (z11 ? 4 : 0) | (z12 ? 8 : 0);
        requestLayout();
    }

    public boolean z(boolean z10) {
        this.f19462i = true;
        return A(z10);
    }

    public AppBarLayout(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.appBarLayoutStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AppBarLayout(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        int i11 = f19452y;
        super(pe.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        this.f19455b = -1;
        this.f19456c = -1;
        this.f19457d = -1;
        this.f19459f = 0;
        this.f19469p = new ArrayList();
        Context context2 = getContext();
        setOrientation(1);
        int i12 = Build.VERSION.SDK_INT;
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            ld.f.a(this);
        }
        ld.f.c(this, attributeSet, i10, i11);
        TypedArray typedArrayK = t.k(context2, attributeSet, R.styleable.AppBarLayout, i10, i11, new int[0]);
        u0.I1(this, typedArrayK.getDrawable(R.styleable.AppBarLayout_android_background));
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            j jVar = new j();
            jVar.o0(ColorStateList.valueOf(colorDrawable.getColor()));
            jVar.Z(context2);
            u0.I1(this, jVar);
        }
        int i13 = R.styleable.AppBarLayout_expanded;
        if (typedArrayK.hasValue(i13)) {
            y(typedArrayK.getBoolean(i13, false), false, false);
        }
        if (typedArrayK.hasValue(R.styleable.AppBarLayout_elevation)) {
            ld.f.b(this, typedArrayK.getDimensionPixelSize(r12, 0));
        }
        if (i12 >= 26) {
            int i14 = R.styleable.AppBarLayout_android_keyboardNavigationCluster;
            if (typedArrayK.hasValue(i14)) {
                setKeyboardNavigationCluster(typedArrayK.getBoolean(i14, false));
            }
            int i15 = R.styleable.AppBarLayout_android_touchscreenBlocksFocus;
            if (typedArrayK.hasValue(i15)) {
                setTouchscreenBlocksFocus(typedArrayK.getBoolean(i15, false));
            }
        }
        this.f19465l = typedArrayK.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
        this.f19466m = typedArrayK.getResourceId(R.styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(typedArrayK.getDrawable(R.styleable.AppBarLayout_statusBarForeground));
        typedArrayK.recycle();
        u0.a2(this, new a());
    }

    public static class f extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f19504d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f19505e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f19506f = 2;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f19507g = 4;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f19508h = 8;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f19509i = 16;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f19510j = 32;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f19511k = 5;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f19512l = 17;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f19513m = 10;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f19514n = 0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f19515o = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f19517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Interpolator f19518c;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface a {
        }

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f19516a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.f19516a = typedArrayObtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            f(a(typedArrayObtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollEffect, 0)));
            int i10 = R.styleable.AppBarLayout_Layout_layout_scrollInterpolator;
            if (typedArrayObtainStyledAttributes.hasValue(i10)) {
                this.f19518c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(i10, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        @p0
        public final d a(int i10) {
            if (i10 != 1) {
                return null;
            }
            return new e();
        }

        @p0
        public d b() {
            return this.f19517b;
        }

        public int c() {
            return this.f19516a;
        }

        public Interpolator d() {
            return this.f19518c;
        }

        public boolean e() {
            int i10 = this.f19516a;
            return (i10 & 1) == 1 && (i10 & 10) != 0;
        }

        public void f(@p0 d dVar) {
            this.f19517b = dVar;
        }

        public void g(int i10) {
            this.f19516a = i10;
        }

        public void h(Interpolator interpolator) {
            this.f19518c = interpolator;
        }

        public f(int i10, int i11) {
            super(i10, i11);
            this.f19516a = 1;
        }

        public f(int i10, int i11, float f10) {
            super(i10, i11, f10);
            this.f19516a = 1;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f19516a = 1;
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f19516a = 1;
        }

        @v0(19)
        public f(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f19516a = 1;
        }

        @v0(19)
        public f(@n0 f fVar) {
            super((LinearLayout.LayoutParams) fVar);
            this.f19516a = 1;
            this.f19516a = fVar.f19516a;
            this.f19517b = fVar.f19517b;
            this.f19518c = fVar.f19518c;
        }
    }
}
