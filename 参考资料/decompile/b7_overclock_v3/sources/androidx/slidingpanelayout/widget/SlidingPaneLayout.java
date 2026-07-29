package androidx.slidingpanelayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.u0;
import androidx.customview.view.AbsSavedState;
import e1.d;
import g.l;
import g.n0;
import g.p0;
import g.t0;
import g.v;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SlidingPaneLayout extends ViewGroup {
    public static final int A = 400;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f7645x = "SlidingPaneLayout";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f7646y = 32;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f7647z = -858993460;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f7650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f7651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f7654g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f7655h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f7656i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7657j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f7658k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7659l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f7660m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f7661n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public e f7662o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e1.d f7663p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f7664q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f7665r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f7666s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList<b> f7667t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Method f7668u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Field f7669v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f7670w;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7671c;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f7671c ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f7671c = parcel.readInt() != 0;
        }
    }

    public class a extends androidx.core.view.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect f7672d = new Rect();

        public a() {
        }

        @Override // androidx.core.view.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // androidx.core.view.a
        public void g(View view, a1.d dVar) {
            a1.d dVarI0 = a1.d.I0(dVar);
            super.g(view, dVarI0);
            n(dVar, dVarI0);
            dVarI0.N0();
            dVar.b1(SlidingPaneLayout.class.getName());
            dVar.P1(view);
            Object objL0 = u0.l0(view);
            if (objL0 instanceof View) {
                dVar.F1((View) objL0);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i10);
                if (!o(childAt) && childAt.getVisibility() == 0) {
                    u0.R1(childAt, 1);
                    dVar.c(childAt);
                }
            }
        }

        @Override // androidx.core.view.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (o(view)) {
                return false;
            }
            return super.i(viewGroup, view, accessibilityEvent);
        }

        public final void n(a1.d dVar, a1.d dVar2) {
            Rect rect = this.f7672d;
            dVar2.s(rect);
            dVar.W0(rect);
            dVar2.t(rect);
            dVar.X0(rect);
            dVar.e2(dVar2.G0());
            dVar.D1(dVar2.P());
            dVar.b1(dVar2.w());
            dVar.f1(dVar2.A());
            dVar.l1(dVar2.s0());
            dVar.c1(dVar2.n0());
            dVar.n1(dVar2.t0());
            dVar.o1(dVar2.u0());
            dVar.T0(dVar2.k0());
            dVar.N1(dVar2.C0());
            dVar.y1(dVar2.x0());
            dVar.a(dVar2.p());
            dVar.B1(dVar2.N());
        }

        public boolean o(View view) {
            return SlidingPaneLayout.this.j(view);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f7674a;

        public b(View view) {
            this.f7674a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f7674a.getParent() == SlidingPaneLayout.this) {
                this.f7674a.setLayerType(0, null);
                SlidingPaneLayout.this.i(this.f7674a);
            }
            SlidingPaneLayout.this.f7667t.remove(this);
        }
    }

    public class c extends d.c {
        public c() {
        }

        @Override // e1.d.c
        public int a(View view, int i10, int i11) {
            d dVar = (d) SlidingPaneLayout.this.f7654g.getLayoutParams();
            if (SlidingPaneLayout.this.k()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) dVar).rightMargin) + SlidingPaneLayout.this.f7654g.getWidth());
                return Math.max(Math.min(i10, width), width - SlidingPaneLayout.this.f7657j);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
            return Math.min(Math.max(i10, paddingLeft), SlidingPaneLayout.this.f7657j + paddingLeft);
        }

        @Override // e1.d.c
        public int b(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // e1.d.c
        public int d(View view) {
            return SlidingPaneLayout.this.f7657j;
        }

        @Override // e1.d.c
        public void f(int i10, int i11) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.f7663p.d(slidingPaneLayout.f7654g, i11);
        }

        @Override // e1.d.c
        public void i(View view, int i10) {
            SlidingPaneLayout.this.r();
        }

        @Override // e1.d.c
        public void j(int i10) {
            if (SlidingPaneLayout.this.f7663p.F() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.f7655h != 0.0f) {
                    slidingPaneLayout.g(slidingPaneLayout.f7654g);
                    SlidingPaneLayout.this.f7664q = true;
                } else {
                    slidingPaneLayout.v(slidingPaneLayout.f7654g);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.f(slidingPaneLayout2.f7654g);
                    SlidingPaneLayout.this.f7664q = false;
                }
            }
        }

        @Override // e1.d.c
        public void k(View view, int i10, int i11, int i12, int i13) {
            SlidingPaneLayout.this.n(i10);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // e1.d.c
        public void l(View view, float f10, float f11) {
            int paddingLeft;
            d dVar = (d) view.getLayoutParams();
            if (SlidingPaneLayout.this.k()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) dVar).rightMargin;
                if (f10 < 0.0f || (f10 == 0.0f && SlidingPaneLayout.this.f7655h > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f7657j;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f7654g.getWidth();
            } else {
                paddingLeft = ((ViewGroup.MarginLayoutParams) dVar).leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f10 > 0.0f || (f10 == 0.0f && SlidingPaneLayout.this.f7655h > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.f7657j;
                }
            }
            SlidingPaneLayout.this.f7663p.V(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // e1.d.c
        public boolean m(View view, int i10) {
            if (SlidingPaneLayout.this.f7658k) {
                return false;
            }
            return ((d) view.getLayoutParams()).f7679b;
        }
    }

    public interface e {
        void a(@n0 View view, float f10);

        void b(@n0 View view);

        void c(@n0 View view);
    }

    public static class f implements e {
        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.e
        public void a(View view, float f10) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.e
        public void b(View view) {
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.e
        public void c(View view) {
        }
    }

    public SlidingPaneLayout(@n0 Context context) {
        this(context, null);
    }

    public static boolean w(View view) {
        return view.isOpaque();
    }

    public boolean a(View view, boolean z10, int i10, int i11, int i12) {
        int i13;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i14 = i11 + scrollX;
                if (i14 >= childAt.getLeft() && i14 < childAt.getRight() && (i13 = i12 + scrollY) >= childAt.getTop() && i13 < childAt.getBottom() && a(childAt, true, i10, i14 - childAt.getLeft(), i13 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z10) {
            if (view.canScrollHorizontally(k() ? i10 : -i10)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean b() {
        return this.f7653f;
    }

    public boolean c() {
        return d(this.f7654g, 0);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f7663p.o(true)) {
            if (this.f7653f) {
                u0.n1(this);
            } else {
                this.f7663p.a();
            }
        }
    }

    public final boolean d(View view, int i10) {
        if (!this.f7665r && !u(0.0f, i10)) {
            return false;
        }
        this.f7664q = false;
        return true;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i10;
        int right;
        super.draw(canvas);
        Drawable drawable = k() ? this.f7651d : this.f7650c;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top2 = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (k()) {
            right = childAt.getRight();
            i10 = intrinsicWidth + right;
        } else {
            int left = childAt.getLeft();
            int i11 = left - intrinsicWidth;
            i10 = left;
            right = i11;
        }
        drawable.setBounds(right, top2, i10, bottom);
        drawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        d dVar = (d) view.getLayoutParams();
        int iSave = canvas.save();
        if (this.f7653f && !dVar.f7679b && this.f7654g != null) {
            canvas.getClipBounds(this.f7666s);
            if (k()) {
                Rect rect = this.f7666s;
                rect.left = Math.max(rect.left, this.f7654g.getRight());
            } else {
                Rect rect2 = this.f7666s;
                rect2.right = Math.min(rect2.right, this.f7654g.getLeft());
            }
            canvas.clipRect(this.f7666s);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j10);
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    public final void e(View view, float f10, int i10) {
        d dVar = (d) view.getLayoutParams();
        if (f10 > 0.0f && i10 != 0) {
            int i11 = (((int) ((((-16777216) & i10) >>> 24) * f10)) << 24) | (i10 & 16777215);
            if (dVar.f7681d == null) {
                dVar.f7681d = new Paint();
            }
            dVar.f7681d.setColorFilter(new PorterDuffColorFilter(i11, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, dVar.f7681d);
            }
            i(view);
            return;
        }
        if (view.getLayerType() != 0) {
            Paint paint = dVar.f7681d;
            if (paint != null) {
                paint.setColorFilter(null);
            }
            b bVar = new b(view);
            this.f7667t.add(bVar);
            u0.p1(this, bVar);
        }
    }

    public void f(View view) {
        e eVar = this.f7662o;
        if (eVar != null) {
            eVar.c(view);
        }
        sendAccessibilityEvent(32);
    }

    public void g(View view) {
        e eVar = this.f7662o;
        if (eVar != null) {
            eVar.b(view);
        }
        sendAccessibilityEvent(32);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new d();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new d((ViewGroup.MarginLayoutParams) layoutParams) : new d(layoutParams);
    }

    @l
    public int getCoveredFadeColor() {
        return this.f7649b;
    }

    @t0
    public int getParallaxDistance() {
        return this.f7659l;
    }

    @l
    public int getSliderFadeColor() {
        return this.f7648a;
    }

    public void h(View view) {
        e eVar = this.f7662o;
        if (eVar != null) {
            eVar.a(view, this.f7655h);
        }
    }

    public void i(View view) {
        u0.V1(view, ((d) view.getLayoutParams()).f7681d);
    }

    public boolean j(View view) {
        if (view == null) {
            return false;
        }
        return this.f7653f && ((d) view.getLayoutParams()).f7680c && this.f7655h > 0.0f;
    }

    public boolean k() {
        return u0.Z(this) == 1;
    }

    public boolean l() {
        return !this.f7653f || this.f7655h == 1.0f;
    }

    public boolean m() {
        return this.f7653f;
    }

    public void n(int i10) {
        if (this.f7654g == null) {
            this.f7655h = 0.0f;
            return;
        }
        boolean zK = k();
        d dVar = (d) this.f7654g.getLayoutParams();
        int width = this.f7654g.getWidth();
        if (zK) {
            i10 = (getWidth() - i10) - width;
        }
        float paddingRight = (i10 - ((zK ? getPaddingRight() : getPaddingLeft()) + (zK ? ((ViewGroup.MarginLayoutParams) dVar).rightMargin : ((ViewGroup.MarginLayoutParams) dVar).leftMargin))) / this.f7657j;
        this.f7655h = paddingRight;
        if (this.f7659l != 0) {
            q(paddingRight);
        }
        if (dVar.f7680c) {
            e(this.f7654g, this.f7655h, this.f7648a);
        }
        h(this.f7654g);
    }

    public boolean o() {
        return p(this.f7654g, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7665r = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7665r = true;
        int size = this.f7667t.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f7667t.get(i10).run();
        }
        this.f7667t.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f7653f && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f7664q = !this.f7663p.L(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f7653f || (this.f7658k && actionMasked != 0)) {
            this.f7663p.c();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            this.f7663p.c();
            return false;
        }
        if (actionMasked == 0) {
            this.f7658k = false;
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            this.f7660m = x10;
            this.f7661n = y10;
            if (this.f7663p.L(this.f7654g, (int) x10, (int) y10) && j(this.f7654g)) {
                z10 = true;
            }
            return this.f7663p.W(motionEvent) || z10;
        }
        if (actionMasked == 2) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            float fAbs = Math.abs(x11 - this.f7660m);
            float fAbs2 = Math.abs(y11 - this.f7661n);
            if (fAbs > this.f7663p.E() && fAbs2 > fAbs) {
                this.f7663p.c();
                this.f7658k = true;
                return false;
            }
        }
        z10 = false;
        if (this.f7663p.W(motionEvent)) {
            return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        boolean zK = k();
        if (zK) {
            this.f7663p.T(2);
        } else {
            this.f7663p.T(1);
        }
        int i18 = i12 - i10;
        int paddingRight = zK ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = zK ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f7665r) {
            this.f7655h = (this.f7653f && this.f7664q) ? 1.0f : 0.0f;
        }
        int i19 = paddingRight;
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt = getChildAt(i20);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (dVar.f7679b) {
                    int i21 = i18 - paddingLeft;
                    int iMin = (Math.min(paddingRight, i21 - this.f7652e) - i19) - (((ViewGroup.MarginLayoutParams) dVar).leftMargin + ((ViewGroup.MarginLayoutParams) dVar).rightMargin);
                    this.f7657j = iMin;
                    int i22 = zK ? ((ViewGroup.MarginLayoutParams) dVar).rightMargin : ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
                    dVar.f7680c = ((i19 + i22) + iMin) + (measuredWidth / 2) > i21;
                    int i23 = (int) (iMin * this.f7655h);
                    i19 += i22 + i23;
                    this.f7655h = i23 / iMin;
                    i14 = 0;
                } else if (!this.f7653f || (i15 = this.f7659l) == 0) {
                    i19 = paddingRight;
                    i14 = 0;
                } else {
                    i14 = (int) ((1.0f - this.f7655h) * i15);
                    i19 = paddingRight;
                }
                if (zK) {
                    i17 = (i18 - i19) + i14;
                    i16 = i17 - measuredWidth;
                } else {
                    i16 = i19 - i14;
                    i17 = i16 + measuredWidth;
                }
                childAt.layout(i16, paddingTop, i17, childAt.getMeasuredHeight() + paddingTop);
                paddingRight += childAt.getWidth();
            }
        }
        if (this.f7665r) {
            if (this.f7653f) {
                if (this.f7659l != 0) {
                    q(this.f7655h);
                }
                if (((d) this.f7654g.getLayoutParams()).f7680c) {
                    e(this.f7654g, this.f7655h, this.f7648a);
                }
            } else {
                for (int i24 = 0; i24 < childCount; i24++) {
                    e(getChildAt(i24), 0.0f, this.f7648a);
                }
            }
            v(this.f7654g);
        }
        this.f7665r = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7 A[PHI: r13
  0x00a7: PHI (r13v2 float) = (r13v1 float), (r13v7 float) binds: [B:32:0x009e, B:34:0x00a3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0135  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r21, int r22) {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        if (savedState.f7671c) {
            o();
        } else {
            c();
        }
        this.f7664q = savedState.f7671c;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7671c = m() ? l() : this.f7664q;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            this.f7665r = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f7653f) {
            return super.onTouchEvent(motionEvent);
        }
        this.f7663p.M(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            this.f7660m = x10;
            this.f7661n = y10;
        } else if (actionMasked == 1 && j(this.f7654g)) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            float f10 = x11 - this.f7660m;
            float f11 = y11 - this.f7661n;
            int iE = this.f7663p.E();
            if ((f10 * f10) + (f11 * f11) < iE * iE && this.f7663p.L(this.f7654g, (int) x11, (int) y11)) {
                d(this.f7654g, 0);
            }
        }
        return true;
    }

    public final boolean p(View view, int i10) {
        if (!this.f7665r && !u(1.0f, i10)) {
            return false;
        }
        this.f7664q = true;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(float r10) {
        /*
            r9 = this;
            boolean r0 = r9.k()
            android.view.View r1 = r9.f7654g
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$d r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.d) r1
            boolean r2 = r1.f7680c
            r3 = 0
            if (r2 == 0) goto L1c
            if (r0 == 0) goto L16
            int r1 = r1.rightMargin
            goto L18
        L16:
            int r1 = r1.leftMargin
        L18:
            if (r1 > 0) goto L1c
            r1 = 1
            goto L1d
        L1c:
            r1 = 0
        L1d:
            int r2 = r9.getChildCount()
        L21:
            if (r3 >= r2) goto L59
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.f7654g
            if (r4 != r5) goto L2c
            goto L56
        L2c:
            float r5 = r9.f7656i
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.f7659l
            float r8 = (float) r7
            float r5 = r5 * r8
            int r5 = (int) r5
            r9.f7656i = r10
            float r8 = r6 - r10
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            int r5 = r5 - r7
            if (r0 == 0) goto L44
            int r5 = -r5
        L44:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L56
            float r5 = r9.f7656i
            if (r0 == 0) goto L4f
            float r5 = r5 - r6
            goto L51
        L4f:
            float r5 = r6 - r5
        L51:
            int r6 = r9.f7649b
            r9.e(r4, r5, r6)
        L56:
            int r3 = r3 + 1
            goto L21
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.q(float):void");
    }

    public void r() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.f7653f) {
            return;
        }
        this.f7664q = view == this.f7654g;
    }

    @Deprecated
    public void s() {
        c();
    }

    public void setCoveredFadeColor(@l int i10) {
        this.f7649b = i10;
    }

    public void setPanelSlideListener(@p0 e eVar) {
        this.f7662o = eVar;
    }

    public void setParallaxDistance(@t0 int i10) {
        this.f7659l = i10;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(@p0 Drawable drawable) {
        this.f7650c = drawable;
    }

    public void setShadowDrawableRight(@p0 Drawable drawable) {
        this.f7651d = drawable;
    }

    @Deprecated
    public void setShadowResource(@v int i10) {
        setShadowDrawable(getResources().getDrawable(i10));
    }

    public void setShadowResourceLeft(int i10) {
        setShadowDrawableLeft(h0.d.i(getContext(), i10));
    }

    public void setShadowResourceRight(int i10) {
        setShadowDrawableRight(h0.d.i(getContext(), i10));
    }

    public void setSliderFadeColor(@l int i10) {
        this.f7648a = i10;
    }

    @Deprecated
    public void t() {
        o();
    }

    public boolean u(float f10, int i10) {
        int paddingLeft;
        if (!this.f7653f) {
            return false;
        }
        boolean zK = k();
        d dVar = (d) this.f7654g.getLayoutParams();
        if (zK) {
            paddingLeft = (int) (getWidth() - (((getPaddingRight() + ((ViewGroup.MarginLayoutParams) dVar).rightMargin) + (f10 * this.f7657j)) + this.f7654g.getWidth()));
        } else {
            paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin + (f10 * this.f7657j));
        }
        e1.d dVar2 = this.f7663p;
        View view = this.f7654g;
        if (!dVar2.X(view, paddingLeft, view.getTop())) {
            return false;
        }
        r();
        u0.n1(this);
        return true;
    }

    public void v(View view) {
        int left;
        int right;
        int top2;
        int bottom;
        View childAt;
        boolean z10;
        View view2 = view;
        boolean zK = k();
        int width = zK ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = zK ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !w(view)) {
            left = 0;
            right = 0;
            top2 = 0;
            bottom = 0;
        } else {
            left = view.getLeft();
            right = view.getRight();
            top2 = view.getTop();
            bottom = view.getBottom();
        }
        int childCount = getChildCount();
        int i10 = 0;
        while (i10 < childCount && (childAt = getChildAt(i10)) != view2) {
            if (childAt.getVisibility() == 8) {
                z10 = zK;
            } else {
                z10 = zK;
                childAt.setVisibility((Math.max(zK ? paddingLeft : width, childAt.getLeft()) < left || Math.max(paddingTop, childAt.getTop()) < top2 || Math.min(zK ? width : paddingLeft, childAt.getRight()) > right || Math.min(height, childAt.getBottom()) > bottom) ? 0 : 4);
            }
            i10++;
            view2 = view;
            zK = z10;
        }
    }

    public static class d extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int[] f7677e = {R.attr.layout_weight};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f7678a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7679b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f7680c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Paint f7681d;

        public d() {
            super(-1, -1);
            this.f7678a = 0.0f;
        }

        public d(int i10, int i11) {
            super(i10, i11);
            this.f7678a = 0.0f;
        }

        public d(@n0 ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7678a = 0.0f;
        }

        public d(@n0 ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f7678a = 0.0f;
        }

        public d(@n0 d dVar) {
            super((ViewGroup.MarginLayoutParams) dVar);
            this.f7678a = 0.0f;
            this.f7678a = dVar.f7678a;
        }

        public d(@n0 Context context, @p0 AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7678a = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f7677e);
            this.f7678a = typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    public SlidingPaneLayout(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7648a = f7647z;
        this.f7665r = true;
        this.f7666s = new Rect();
        this.f7667t = new ArrayList<>();
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f7652e = (int) ((32.0f * f10) + 0.5f);
        setWillNotDraw(false);
        u0.B1(this, new a());
        u0.R1(this, 1);
        e1.d dVarP = e1.d.p(this, 0.5f, new c());
        this.f7663p = dVarP;
        dVarP.U(f10 * 400.0f);
    }
}
