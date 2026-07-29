package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.core.view.c0;
import androidx.core.view.d0;
import androidx.core.view.e0;
import androidx.core.view.f0;
import androidx.core.view.g0;
import androidx.core.view.h0;
import androidx.core.view.i0;
import androidx.core.view.j0;
import androidx.core.view.u0;
import androidx.core.widget.n;
import g.i1;
import g.l;
import g.n0;
import g.p0;
import g.t0;

/* JADX INFO: loaded from: classes2.dex */
public class SwipeRefreshLayout extends ViewGroup implements h0, g0, d0, c0, i0, e0 {
    public static final int H7 = 0;
    public static final int I7 = 1;
    public static final int J7 = -1;

    @i1
    public static final int K7 = 40;

    @i1
    public static final int L7 = 56;
    public static final int N7 = 255;
    public static final int O7 = 76;
    public static final float P7 = 2.0f;
    public static final int Q7 = -1;
    public static final float R7 = 0.5f;
    public static final float S7 = 0.8f;
    public static final int T7 = 150;
    public static final int U7 = 300;
    public static final int V7 = 200;
    public static final int W7 = 200;
    public static final int X7 = 64;
    public int A;
    public int B;
    public androidx.swiperefreshlayout.widget.b C;
    public boolean C1;
    public i C2;
    public Animation D;
    public Animation.AnimationListener E7;
    public final Animation F7;
    public final Animation G7;
    public Animation K0;
    public int K1;
    public boolean K2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f7688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f7689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f7692e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f7693f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j0 f7694g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f0 f7695h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f7696i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f7697j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f7698k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public Animation f7699k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public Animation f7700k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f7701l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f7702m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f7703n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f7704o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f7705p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f7706q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f7707r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f7708s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f7709t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final DecelerateInterpolator f7710u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public androidx.swiperefreshlayout.widget.a f7711v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public Animation f7712v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public boolean f7713v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f7714w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f7715x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f7716y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f7717z;
    public static final String M7 = SwipeRefreshLayout.class.getSimpleName();
    public static final int[] Y7 = {R.attr.enabled};

    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j jVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f7690c) {
                swipeRefreshLayout.r();
                return;
            }
            swipeRefreshLayout.C.setAlpha(255);
            SwipeRefreshLayout.this.C.start();
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            if (swipeRefreshLayout2.C1 && (jVar = swipeRefreshLayout2.f7689b) != null) {
                jVar.r();
            }
            SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
            swipeRefreshLayout3.f7703n = swipeRefreshLayout3.f7711v.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class b extends Animation {
        public b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(f10);
        }
    }

    public class c extends Animation {
        public c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.setAnimationProgress(1.0f - f10);
        }
    }

    public class d extends Animation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f7722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f7723b;

        public d(int i10, int i11) {
            this.f7722a = i10;
            this.f7723b = i11;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.C.setAlpha((int) (this.f7722a + ((this.f7723b - r0) * f10)));
        }
    }

    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f7708s) {
                return;
            }
            swipeRefreshLayout.z(null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class f extends Animation {
        public f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            int iAbs = !swipeRefreshLayout.f7713v2 ? swipeRefreshLayout.A - Math.abs(swipeRefreshLayout.f7717z) : swipeRefreshLayout.A;
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((swipeRefreshLayout2.f7715x + ((int) ((iAbs - r1) * f10))) - swipeRefreshLayout2.f7711v.getTop());
            SwipeRefreshLayout.this.C.v(1.0f - f10);
        }
    }

    public class g extends Animation {
        public g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout.this.p(f10);
        }
    }

    public class h extends Animation {
        public h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f10, Transformation transformation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            float f11 = swipeRefreshLayout.f7716y;
            swipeRefreshLayout.setAnimationProgress(f11 + ((-f11) * f10));
            SwipeRefreshLayout.this.p(f10);
        }
    }

    public interface i {
        boolean a(@n0 SwipeRefreshLayout swipeRefreshLayout, @p0 View view);
    }

    public interface j {
        void r();
    }

    public SwipeRefreshLayout(@n0 Context context) {
        this(context, null);
    }

    private void setColorViewAlpha(int i10) {
        this.f7711v.getBackground().setAlpha(i10);
        this.C.setAlpha(i10);
    }

    public final void A(int i10, Animation.AnimationListener animationListener) {
        this.f7715x = i10;
        this.f7716y = this.f7711v.getScaleX();
        h hVar = new h();
        this.f7712v1 = hVar;
        hVar.setDuration(150L);
        if (animationListener != null) {
            this.f7711v.c(animationListener);
        }
        this.f7711v.clearAnimation();
        this.f7711v.startAnimation(this.f7712v1);
    }

    @Override // androidx.core.view.h0
    public void B(@n0 View view, int i10, int i11, int i12, int i13, int i14, @n0 int[] iArr) {
        if (i14 != 0) {
            return;
        }
        int i15 = iArr[1];
        c(i10, i11, i12, i13, this.f7697j, i14, iArr);
        int i16 = i13 - (iArr[1] - i15);
        if ((i16 == 0 ? i13 + this.f7697j[1] : i16) >= 0 || i()) {
            return;
        }
        float fAbs = this.f7693f + Math.abs(r1);
        this.f7693f = fAbs;
        o(fAbs);
        iArr[1] = iArr[1] + i16;
    }

    public final void C(Animation.AnimationListener animationListener) {
        this.f7711v.setVisibility(0);
        this.C.setAlpha(255);
        b bVar = new b();
        this.D = bVar;
        bVar.setDuration(this.f7702m);
        if (animationListener != null) {
            this.f7711v.c(animationListener);
        }
        this.f7711v.clearAnimation();
        this.f7711v.startAnimation(this.D);
    }

    @Override // androidx.core.view.g0
    public void D(View view, int i10, int i11, int i12, int i13, int i14) {
        B(view, i10, i11, i12, i13, i14, this.f7698k);
    }

    @Override // androidx.core.view.g0
    public boolean G(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            return onStartNestedScroll(view, view2, i10);
        }
        return false;
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

    @Override // androidx.core.view.c0
    public boolean a(int i10, int i11, int i12, int i13, int[] iArr, int i14) {
        return i14 == 0 && this.f7695h.g(i10, i11, i12, i13, iArr, i14);
    }

    @Override // androidx.core.view.c0
    public boolean b(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        return i12 == 0 && dispatchNestedPreScroll(i10, i11, iArr, iArr2);
    }

    @Override // androidx.core.view.d0
    public void c(int i10, int i11, int i12, int i13, @p0 int[] iArr, int i14, @n0 int[] iArr2) {
        if (i14 == 0) {
            this.f7695h.e(i10, i11, i12, i13, iArr, i14, iArr2);
        }
    }

    @Override // androidx.core.view.c0
    public boolean d(int i10) {
        return i10 == 0 && hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.f7695h.a(f10, f11, z10);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.f7695h.b(f10, f11);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean dispatchNestedPreScroll(int i10, int i11, int[] iArr, int[] iArr2) {
        return this.f7695h.c(i10, i11, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, int[] iArr) {
        return this.f7695h.f(i10, i11, i12, i13, iArr);
    }

    public final void e(int i10, Animation.AnimationListener animationListener) {
        this.f7715x = i10;
        this.F7.reset();
        this.F7.setDuration(200L);
        this.F7.setInterpolator(this.f7710u);
        if (animationListener != null) {
            this.f7711v.c(animationListener);
        }
        this.f7711v.clearAnimation();
        this.f7711v.startAnimation(this.F7);
    }

    @Override // androidx.core.view.c0
    public boolean f(int i10, int i11) {
        return i11 == 0 && startNestedScroll(i10);
    }

    @Override // androidx.core.view.c0
    public void g(int i10) {
        if (i10 == 0) {
            stopNestedScroll();
        }
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        int i12 = this.f7714w;
        return i12 < 0 ? i11 : i11 == i10 + (-1) ? i12 : i11 >= i12 ? i11 + 1 : i11;
    }

    @Override // android.view.ViewGroup, androidx.core.view.i0
    public int getNestedScrollAxes() {
        return this.f7694g.a();
    }

    public int getProgressCircleDiameter() {
        return this.K1;
    }

    public int getProgressViewEndOffset() {
        return this.A;
    }

    public int getProgressViewStartOffset() {
        return this.f7717z;
    }

    public final void h(int i10, Animation.AnimationListener animationListener) {
        if (this.f7708s) {
            A(i10, animationListener);
            return;
        }
        this.f7715x = i10;
        this.G7.reset();
        this.G7.setDuration(200L);
        this.G7.setInterpolator(this.f7710u);
        if (animationListener != null) {
            this.f7711v.c(animationListener);
        }
        this.f7711v.clearAnimation();
        this.f7711v.startAnimation(this.G7);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean hasNestedScrollingParent() {
        return this.f7695h.k();
    }

    public boolean i() {
        i iVar = this.C2;
        if (iVar != null) {
            return iVar.a(this, this.f7688a);
        }
        View view = this.f7688a;
        return view instanceof ListView ? n.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean isNestedScrollingEnabled() {
        return this.f7695h.m();
    }

    public final void j() {
        this.f7711v = new androidx.swiperefreshlayout.widget.a(getContext());
        androidx.swiperefreshlayout.widget.b bVar = new androidx.swiperefreshlayout.widget.b(getContext());
        this.C = bVar;
        bVar.F(1);
        this.f7711v.setImageDrawable(this.C);
        this.f7711v.setVisibility(8);
        addView(this.f7711v);
    }

    public final void k() {
        if (this.f7688a == null) {
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                if (!childAt.equals(this.f7711v)) {
                    this.f7688a = childAt;
                    return;
                }
            }
        }
    }

    public final void l(float f10) {
        if (f10 > this.f7692e) {
            u(true, true);
            return;
        }
        this.f7690c = false;
        this.C.C(0.0f, 0.0f);
        h(this.f7703n, this.f7708s ? null : new e());
        this.C.u(false);
    }

    public final boolean m(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    public boolean n() {
        return this.f7690c;
    }

    public final void o(float f10) {
        this.C.u(true);
        float fMin = Math.min(1.0f, Math.abs(f10 / this.f7692e));
        float fMax = (((float) Math.max(((double) fMin) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f10) - this.f7692e;
        int i10 = this.B;
        if (i10 <= 0) {
            i10 = this.f7713v2 ? this.A - this.f7717z : this.A;
        }
        float f11 = i10;
        double dMax = Math.max(0.0f, Math.min(fAbs, f11 * 2.0f) / f11) / 4.0f;
        float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * 2.0f;
        int i11 = this.f7717z + ((int) ((f11 * fMin) + (f11 * fPow * 2.0f)));
        if (this.f7711v.getVisibility() != 0) {
            this.f7711v.setVisibility(0);
        }
        if (!this.f7708s) {
            this.f7711v.setScaleX(1.0f);
            this.f7711v.setScaleY(1.0f);
        }
        if (this.f7708s) {
            setAnimationProgress(Math.min(1.0f, f10 / this.f7692e));
        }
        if (f10 < this.f7692e) {
            if (this.C.getAlpha() > 76 && !m(this.K0)) {
                y();
            }
        } else if (this.C.getAlpha() < 255 && !m(this.f7700k1)) {
            x();
        }
        this.C.C(0.0f, Math.min(0.8f, fMax * 0.8f));
        this.C.v(Math.min(1.0f, fMax));
        this.C.z((((fMax * 0.4f) - 0.25f) + (fPow * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i11 - this.f7703n);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        r();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0051  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            r4.k()
            int r0 = r5.getActionMasked()
            boolean r1 = r4.f7709t
            r2 = 0
            if (r1 == 0) goto L10
            if (r0 != 0) goto L10
            r4.f7709t = r2
        L10:
            boolean r1 = r4.isEnabled()
            if (r1 == 0) goto L7a
            boolean r1 = r4.f7709t
            if (r1 != 0) goto L7a
            boolean r1 = r4.i()
            if (r1 != 0) goto L7a
            boolean r1 = r4.f7690c
            if (r1 != 0) goto L7a
            boolean r1 = r4.f7701l
            if (r1 == 0) goto L29
            goto L7a
        L29:
            if (r0 == 0) goto L56
            r1 = 1
            r3 = -1
            if (r0 == r1) goto L51
            r1 = 2
            if (r0 == r1) goto L3d
            r1 = 3
            if (r0 == r1) goto L51
            r1 = 6
            if (r0 == r1) goto L39
            goto L77
        L39:
            r4.q(r5)
            goto L77
        L3d:
            int r0 = r4.f7707r
            if (r0 != r3) goto L42
            return r2
        L42:
            int r0 = r5.findPointerIndex(r0)
            if (r0 >= 0) goto L49
            return r2
        L49:
            float r5 = r5.getY(r0)
            r4.w(r5)
            goto L77
        L51:
            r4.f7706q = r2
            r4.f7707r = r3
            goto L77
        L56:
            int r0 = r4.f7717z
            androidx.swiperefreshlayout.widget.a r1 = r4.f7711v
            int r1 = r1.getTop()
            int r0 = r0 - r1
            r4.setTargetOffsetTopAndBottom(r0)
            int r0 = r5.getPointerId(r2)
            r4.f7707r = r0
            r4.f7706q = r2
            int r0 = r5.findPointerIndex(r0)
            if (r0 >= 0) goto L71
            return r2
        L71:
            float r5 = r5.getY(r0)
            r4.f7705p = r5
        L77:
            boolean r5 = r4.f7706q
            return r5
        L7a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f7688a == null) {
            k();
        }
        View view = this.f7688a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.f7711v.getMeasuredWidth();
        int measuredHeight2 = this.f7711v.getMeasuredHeight();
        int i14 = measuredWidth / 2;
        int i15 = measuredWidth2 / 2;
        int i16 = this.f7703n;
        this.f7711v.layout(i14 - i15, i16, i14 + i15, measuredHeight2 + i16);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f7688a == null) {
            k();
        }
        View view = this.f7688a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f7711v.measure(View.MeasureSpec.makeMeasureSpec(this.K1, 1073741824), View.MeasureSpec.makeMeasureSpec(this.K1, 1073741824));
        this.f7714w = -1;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            if (getChildAt(i12) == this.f7711v) {
                this.f7714w = i12;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return dispatchNestedFling(f10, f11, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        if (i11 > 0) {
            float f10 = this.f7693f;
            if (f10 > 0.0f) {
                float f11 = i11;
                if (f11 > f10) {
                    iArr[1] = (int) f10;
                    this.f7693f = 0.0f;
                } else {
                    this.f7693f = f10 - f11;
                    iArr[1] = i11;
                }
                o(this.f7693f);
            }
        }
        if (this.f7713v2 && i11 > 0 && this.f7693f == 0.0f && Math.abs(i11 - iArr[1]) > 0) {
            this.f7711v.setVisibility(8);
        }
        int[] iArr2 = this.f7696i;
        if (dispatchNestedPreScroll(i10 - iArr[0], i11 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        B(view, i10, i11, i12, i13, 0, this.f7698k);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.f7694g.b(view, view2, i10);
        startNestedScroll(i10 & 2);
        this.f7693f = 0.0f;
        this.f7701l = true;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRefreshing(savedState.f7718a);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f7690c);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return (!isEnabled() || this.f7709t || this.f7690c || (i10 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onStopNestedScroll(View view) {
        this.f7694g.d(view);
        this.f7701l = false;
        float f10 = this.f7693f;
        if (f10 > 0.0f) {
            l(f10);
            this.f7693f = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f7709t && actionMasked == 0) {
            this.f7709t = false;
        }
        if (!isEnabled() || this.f7709t || i() || this.f7690c || this.f7701l) {
            return false;
        }
        if (actionMasked == 0) {
            this.f7707r = motionEvent.getPointerId(0);
            this.f7706q = false;
        } else {
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f7707r);
                if (iFindPointerIndex < 0) {
                    return false;
                }
                if (this.f7706q) {
                    float y10 = (motionEvent.getY(iFindPointerIndex) - this.f7704o) * 0.5f;
                    this.f7706q = false;
                    l(y10);
                }
                this.f7707r = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.f7707r);
                if (iFindPointerIndex2 < 0) {
                    return false;
                }
                float y11 = motionEvent.getY(iFindPointerIndex2);
                w(y11);
                if (this.f7706q) {
                    float f10 = (y11 - this.f7704o) * 0.5f;
                    if (f10 <= 0.0f) {
                        return false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    o(f10);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        return false;
                    }
                    this.f7707r = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    q(motionEvent);
                }
            }
        }
        return true;
    }

    public void p(float f10) {
        setTargetOffsetTopAndBottom((this.f7715x + ((int) ((this.f7717z - r0) * f10))) - this.f7711v.getTop());
    }

    public final void q(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f7707r) {
            this.f7707r = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    public void r() {
        this.f7711v.clearAnimation();
        this.C.stop();
        this.f7711v.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f7708s) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.f7717z - this.f7703n);
        }
        this.f7703n = this.f7711v.getTop();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        ViewParent parent;
        View view = this.f7688a;
        if (view == null || u0.W0(view)) {
            super.requestDisallowInterceptTouchEvent(z10);
        } else {
            if (this.K2 || (parent = getParent()) == null) {
                return;
            }
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    public void s(boolean z10, int i10) {
        this.A = i10;
        this.f7708s = z10;
        this.f7711v.invalidate();
    }

    public void setAnimationProgress(float f10) {
        this.f7711v.setScaleX(f10);
        this.f7711v.setScaleY(f10);
    }

    @Deprecated
    public void setColorScheme(@g.n int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(@l int... iArr) {
        k();
        this.C.y(iArr);
    }

    public void setColorSchemeResources(@g.n int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr2[i10] = h0.d.f(context, iArr[i10]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i10) {
        this.f7692e = i10;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (z10) {
            return;
        }
        r();
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z10) {
        this.K2 = z10;
    }

    @Override // android.view.View, androidx.core.view.e0
    public void setNestedScrollingEnabled(boolean z10) {
        this.f7695h.p(z10);
    }

    public void setOnChildScrollUpCallback(@p0 i iVar) {
        this.C2 = iVar;
    }

    public void setOnRefreshListener(@p0 j jVar) {
        this.f7689b = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i10) {
        setProgressBackgroundColorSchemeResource(i10);
    }

    public void setProgressBackgroundColorSchemeColor(@l int i10) {
        this.f7711v.setBackgroundColor(i10);
    }

    public void setProgressBackgroundColorSchemeResource(@g.n int i10) {
        setProgressBackgroundColorSchemeColor(h0.d.f(getContext(), i10));
    }

    public void setRefreshing(boolean z10) {
        if (!z10 || this.f7690c == z10) {
            u(z10, false);
            return;
        }
        this.f7690c = z10;
        setTargetOffsetTopAndBottom((!this.f7713v2 ? this.A + this.f7717z : this.A) - this.f7703n);
        this.C1 = false;
        C(this.E7);
    }

    public void setSize(int i10) {
        if (i10 == 0 || i10 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i10 == 0) {
                this.K1 = (int) (displayMetrics.density * 56.0f);
            } else {
                this.K1 = (int) (displayMetrics.density * 40.0f);
            }
            this.f7711v.setImageDrawable(null);
            this.C.F(i10);
            this.f7711v.setImageDrawable(this.C);
        }
    }

    public void setSlingshotDistance(@t0 int i10) {
        this.B = i10;
    }

    public void setTargetOffsetTopAndBottom(int i10) {
        this.f7711v.bringToFront();
        u0.f1(this.f7711v, i10);
        this.f7703n = this.f7711v.getTop();
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean startNestedScroll(int i10) {
        return this.f7695h.r(i10);
    }

    @Override // android.view.View, androidx.core.view.e0
    public void stopNestedScroll() {
        this.f7695h.t();
    }

    public void t(boolean z10, int i10, int i11) {
        this.f7708s = z10;
        this.f7717z = i10;
        this.A = i11;
        this.f7713v2 = true;
        r();
        this.f7690c = false;
    }

    public final void u(boolean z10, boolean z11) {
        if (this.f7690c != z10) {
            this.C1 = z11;
            k();
            this.f7690c = z10;
            if (z10) {
                e(this.f7703n, this.E7);
            } else {
                z(this.E7);
            }
        }
    }

    public final Animation v(int i10, int i11) {
        d dVar = new d(i10, i11);
        dVar.setDuration(300L);
        this.f7711v.c(null);
        this.f7711v.clearAnimation();
        this.f7711v.startAnimation(dVar);
        return dVar;
    }

    public final void w(float f10) {
        float f11 = this.f7705p;
        float f12 = f10 - f11;
        int i10 = this.f7691d;
        if (f12 <= i10 || this.f7706q) {
            return;
        }
        this.f7704o = f11 + i10;
        this.f7706q = true;
        this.C.setAlpha(76);
    }

    public final void x() {
        this.f7700k1 = v(this.C.getAlpha(), 255);
    }

    public final void y() {
        this.K0 = v(this.C.getAlpha(), 76);
    }

    public void z(Animation.AnimationListener animationListener) {
        c cVar = new c();
        this.f7699k0 = cVar;
        cVar.setDuration(150L);
        this.f7711v.c(animationListener);
        this.f7711v.clearAnimation();
        this.f7711v.startAnimation(this.f7699k0);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f7718a;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable, boolean z10) {
            super(parcelable);
            this.f7718a = z10;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.f7718a ? (byte) 1 : (byte) 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f7718a = parcel.readByte() != 0;
        }
    }

    public SwipeRefreshLayout(@n0 Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7690c = false;
        this.f7692e = -1.0f;
        this.f7696i = new int[2];
        this.f7697j = new int[2];
        this.f7698k = new int[2];
        this.f7707r = -1;
        this.f7714w = -1;
        this.E7 = new a();
        this.F7 = new f();
        this.G7 = new g();
        this.f7691d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f7702m = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f7710u = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.K1 = (int) (displayMetrics.density * 40.0f);
        j();
        setChildrenDrawingOrderEnabled(true);
        int i10 = (int) (displayMetrics.density * 64.0f);
        this.A = i10;
        this.f7692e = i10;
        this.f7694g = new j0(this);
        this.f7695h = new f0(this);
        setNestedScrollingEnabled(true);
        int i11 = -this.K1;
        this.f7703n = i11;
        this.f7717z = i11;
        p(1.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Y7);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
    }
}
