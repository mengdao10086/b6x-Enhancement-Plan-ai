package androidx.core.widget;

import a1.d;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.RestrictTo;
import androidx.core.view.b0;
import androidx.core.view.d0;
import androidx.core.view.f0;
import androidx.core.view.h0;
import androidx.core.view.j0;
import androidx.core.view.q0;
import androidx.core.view.u0;
import g.i1;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class NestedScrollView extends FrameLayout implements h0, d0, q0 {
    public static final int B = 250;
    public static final float C = 0.5f;
    public static final float C1 = 4.0f;
    public static final String D = "NestedScrollView";
    public static final float K0 = 0.015f;
    public static final int K1 = -1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f5154k0 = 250;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final float f5155k1 = 0.35f;
    public c A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f5158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f5160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OverScroller f5161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @i1
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @n0
    public EdgeEffect f5162e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @i1
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @n0
    public EdgeEffect f5163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5164g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5165h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5166i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f5167j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f5168k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VelocityTracker f5169l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5170m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5171n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f5172o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f5173p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f5174q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f5175r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int[] f5176s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int[] f5177t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f5178u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f5179v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public SavedState f5180w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final j0 f5181x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final f0 f5182y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f5183z;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final float f5156v1 = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final a f5157v2 = new a();
    public static final int[] C2 = {R.attr.fillViewport};

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5184a;

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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @n0
        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f5184a + zc.a.f58317e;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f5184a);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f5184a = parcel.readInt();
        }
    }

    public static class a extends androidx.core.view.a {
        @Override // androidx.core.view.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            a1.f.N(accessibilityEvent, nestedScrollView.getScrollX());
            a1.f.P(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.a
        public void g(View view, a1.d dVar) {
            int scrollRange;
            super.g(view, dVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            dVar.b1(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            dVar.M1(true);
            if (nestedScrollView.getScrollY() > 0) {
                dVar.b(d.a.f119s);
                dVar.b(d.a.D);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                dVar.b(d.a.f118r);
                dVar.b(d.a.F);
            }
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i10, Bundle bundle) {
            if (super.j(view, i10, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i10 != 4096) {
                if (i10 == 8192 || i10 == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.d0(0, iMax, true);
                    return true;
                }
                if (i10 != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.d0(0, iMin, true);
            return true;
        }
    }

    @v0(21)
    public static class b {
        @g.u
        public static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    public interface c {
        void a(@n0 NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13);
    }

    public NestedScrollView(@n0 Context context) {
        this(context, null);
    }

    public static boolean F(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && F((View) parent, view2);
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f5183z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f5183z = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f5183z;
    }

    public static int k(int i10, int i11, int i12) {
        if (i11 >= i12 || i10 < 0) {
            return 0;
        }
        return i11 + i10 > i12 ? i12 - i11 : i10;
    }

    public boolean A() {
        return this.f5170m;
    }

    @Override // androidx.core.view.h0
    public void B(@n0 View view, int i10, int i11, int i12, int i13, int i14, @n0 int[] iArr) {
        L(i13, i14, iArr);
    }

    public final boolean C(View view) {
        return !I(view, 0, getHeight());
    }

    @Override // androidx.core.view.g0
    public void D(@n0 View view, int i10, int i11, int i12, int i13, int i14) {
        L(i13, i14, null);
    }

    public boolean E() {
        return this.f5171n;
    }

    @Override // androidx.core.view.g0
    public boolean G(@n0 View view, @n0 View view2, int i10, int i11) {
        return (i10 & 2) != 0;
    }

    @Override // androidx.core.view.g0
    public void H(@n0 View view, @n0 View view2, int i10, int i11) {
        this.f5181x.c(view, view2, i10, i11);
        f(2, i11);
    }

    public final boolean I(View view, int i10, int i11) {
        view.getDrawingRect(this.f5160c);
        offsetDescendantRectToMyCoords(view, this.f5160c);
        return this.f5160c.bottom + i10 >= getScrollY() && this.f5160c.top - i10 <= getScrollY() + i11;
    }

    @Override // androidx.core.view.g0
    public void J(@n0 View view, int i10) {
        this.f5181x.e(view, i10);
        g(i10);
    }

    @Override // androidx.core.view.g0
    public void K(@n0 View view, int i10, int i11, @n0 int[] iArr, int i12) {
        b(i10, i11, iArr, null, i12);
    }

    public final void L(int i10, int i11, @p0 int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i10);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f5182y.e(0, scrollY2, 0, i10 - scrollY2, null, i11, iArr);
    }

    public final void M(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f5175r) {
            int i10 = actionIndex == 0 ? 1 : 0;
            this.f5164g = (int) motionEvent.getY(i10);
            this.f5175r = motionEvent.getPointerId(i10);
            VelocityTracker velocityTracker = this.f5169l;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean N(int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, boolean r21) {
        /*
            r12 = this;
            r0 = r12
            int r1 = r12.getOverScrollMode()
            int r2 = r12.computeHorizontalScrollRange()
            int r3 = r12.computeHorizontalScrollExtent()
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L13
            r2 = 1
            goto L14
        L13:
            r2 = 0
        L14:
            int r3 = r12.computeVerticalScrollRange()
            int r6 = r12.computeVerticalScrollExtent()
            if (r3 <= r6) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = 0
        L21:
            if (r1 == 0) goto L2a
            if (r1 != r5) goto L28
            if (r2 == 0) goto L28
            goto L2a
        L28:
            r2 = 0
            goto L2b
        L2a:
            r2 = 1
        L2b:
            if (r1 == 0) goto L34
            if (r1 != r5) goto L32
            if (r3 == 0) goto L32
            goto L34
        L32:
            r1 = 0
            goto L35
        L34:
            r1 = 1
        L35:
            int r3 = r15 + r13
            if (r2 != 0) goto L3b
            r2 = 0
            goto L3d
        L3b:
            r2 = r19
        L3d:
            int r6 = r16 + r14
            if (r1 != 0) goto L43
            r1 = 0
            goto L45
        L43:
            r1 = r20
        L45:
            int r7 = -r2
            int r2 = r2 + r17
            int r8 = -r1
            int r1 = r1 + r18
            if (r3 <= r2) goto L50
            r3 = r2
        L4e:
            r2 = 1
            goto L55
        L50:
            if (r3 >= r7) goto L54
            r3 = r7
            goto L4e
        L54:
            r2 = 0
        L55:
            if (r6 <= r1) goto L5a
            r6 = r1
        L58:
            r1 = 1
            goto L5f
        L5a:
            if (r6 >= r8) goto L5e
            r6 = r8
            goto L58
        L5e:
            r1 = 0
        L5f:
            if (r1 == 0) goto L7e
            boolean r7 = r12.d(r5)
            if (r7 != 0) goto L7e
            android.widget.OverScroller r7 = r0.f5161d
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r12.getScrollRange()
            r13 = r7
            r14 = r3
            r15 = r6
            r16 = r8
            r17 = r9
            r18 = r10
            r19 = r11
            r13.springBack(r14, r15, r16, r17, r18, r19)
        L7e:
            r12.onOverScrolled(r3, r6, r2, r1)
            if (r2 != 0) goto L85
            if (r1 == 0) goto L86
        L85:
            r4 = 1
        L86:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.N(int, int, int, int, int, int, int, int, boolean):boolean");
    }

    public boolean O(int i10) {
        boolean z10 = i10 == 130;
        int height = getHeight();
        if (z10) {
            this.f5160c.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f5160c;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f5160c.top = getScrollY() - height;
            Rect rect2 = this.f5160c;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f5160c;
        int i11 = rect3.top;
        int i12 = height + i11;
        rect3.bottom = i12;
        return S(i10, i11, i12);
    }

    public final void P() {
        VelocityTracker velocityTracker = this.f5169l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f5169l = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int Q(int r4, float r5) {
        /*
            r3 = this;
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r4 = (float) r4
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            android.widget.EdgeEffect r0 = r3.f5162e
            float r0 = androidx.core.widget.j.d(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L31
            android.widget.EdgeEffect r0 = r3.f5162e
            float r4 = -r4
            float r4 = androidx.core.widget.j.j(r0, r4, r5)
            float r4 = -r4
            android.widget.EdgeEffect r5 = r3.f5162e
            float r5 = androidx.core.widget.j.d(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.f5162e
            r5.onRelease()
        L2f:
            r1 = r4
            goto L54
        L31:
            android.widget.EdgeEffect r0 = r3.f5163f
            float r0 = androidx.core.widget.j.d(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L54
            android.widget.EdgeEffect r0 = r3.f5163f
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r5
            float r4 = androidx.core.widget.j.j(r0, r4, r2)
            android.widget.EdgeEffect r5 = r3.f5163f
            float r5 = androidx.core.widget.j.d(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.f5163f
            r5.onRelease()
            goto L2f
        L54:
            int r4 = r3.getHeight()
            float r4 = (float) r4
            float r1 = r1 * r4
            int r4 = java.lang.Math.round(r1)
            if (r4 == 0) goto L64
            r3.invalidate()
        L64:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.Q(int, float):int");
    }

    public final void R(boolean z10) {
        if (z10) {
            f(2, 1);
        } else {
            g(1);
        }
        this.f5179v = getScrollY();
        u0.n1(this);
    }

    public final boolean S(int i10, int i11, int i12) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i13 = height + scrollY;
        boolean z10 = false;
        boolean z11 = i10 == 33;
        View viewR = r(z11, i11, i12);
        if (viewR == null) {
            viewR = this;
        }
        if (i11 < scrollY || i12 > i13) {
            T(z11 ? i11 - scrollY : i12 - i13, 0, 1, true);
            z10 = true;
        }
        if (viewR != findFocus()) {
            viewR.requestFocus(i10);
        }
        return z10;
    }

    public final int T(int i10, int i11, int i12, boolean z10) {
        int i13;
        int i14;
        if (i12 == 1) {
            f(2, i12);
        }
        boolean z11 = false;
        if (b(0, i10, this.f5177t, this.f5176s, i12)) {
            i13 = i10 - this.f5177t[1];
            i14 = this.f5176s[1] + 0;
        } else {
            i13 = i10;
            i14 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        boolean z12 = i() && !z10;
        boolean z13 = N(0, i13, 0, scrollY, 0, scrollRange, 0, 0, true) && !d(i12);
        int scrollY2 = getScrollY() - scrollY;
        int[] iArr = this.f5177t;
        iArr[1] = 0;
        c(0, scrollY2, 0, i13 - scrollY2, this.f5176s, i12, iArr);
        int i15 = i14 + this.f5176s[1];
        int i16 = i13 - this.f5177t[1];
        int i17 = scrollY + i16;
        if (i17 < 0) {
            if (z12) {
                j.j(this.f5162e, (-i16) / getHeight(), i11 / getWidth());
                if (!this.f5163f.isFinished()) {
                    this.f5163f.onRelease();
                }
            }
        } else if (i17 > scrollRange && z12) {
            j.j(this.f5163f, i16 / getHeight(), 1.0f - (i11 / getWidth()));
            if (!this.f5162e.isFinished()) {
                this.f5162e.onRelease();
            }
        }
        if (this.f5162e.isFinished() && this.f5163f.isFinished()) {
            z11 = z13;
        } else {
            u0.n1(this);
        }
        if (z11 && i12 == 0) {
            this.f5169l.clear();
        }
        if (i12 == 1) {
            g(i12);
            this.f5162e.onRelease();
            this.f5163f.onRelease();
        }
        return i15;
    }

    public final void U(View view) {
        view.getDrawingRect(this.f5160c);
        offsetDescendantRectToMyCoords(view, this.f5160c);
        int iL = l(this.f5160c);
        if (iL != 0) {
            scrollBy(0, iL);
        }
    }

    public final boolean V(Rect rect, boolean z10) {
        int iL = l(rect);
        boolean z11 = iL != 0;
        if (z11) {
            if (z10) {
                scrollBy(0, iL);
            } else {
                X(0, iL);
            }
        }
        return z11;
    }

    public final boolean W(@n0 EdgeEffect edgeEffect, int i10) {
        if (i10 > 0) {
            return true;
        }
        return u(-i10) < j.d(edgeEffect) * ((float) getHeight());
    }

    public final void X(int i10, int i11) {
        Z(i10, i11, 250, false);
    }

    public final void Y(int i10, int i11, int i12) {
        Z(i10, i11, i12, false);
    }

    public final void Z(int i10, int i11, int i12, boolean z10) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f5159b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f5161d.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i11 + scrollY, Math.max(0, height - height2))) - scrollY, i12);
            R(z10);
        } else {
            if (!this.f5161d.isFinished()) {
                e();
            }
            scrollBy(i10, i11);
        }
        this.f5159b = AnimationUtils.currentAnimationTimeMillis();
    }

    @Override // androidx.core.view.c0
    public boolean a(int i10, int i11, int i12, int i13, @p0 int[] iArr, int i14) {
        return this.f5182y.g(i10, i11, i12, i13, iArr, i14);
    }

    public final void a0(int i10, int i11) {
        c0(i10, i11, 250, false);
    }

    @Override // android.view.ViewGroup
    public void addView(@n0 View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // androidx.core.view.c0
    public boolean b(int i10, int i11, @p0 int[] iArr, @p0 int[] iArr2, int i12) {
        return this.f5182y.d(i10, i11, iArr, iArr2, i12);
    }

    public final void b0(int i10, int i11, int i12) {
        c0(i10, i11, i12, false);
    }

    @Override // androidx.core.view.d0
    public void c(int i10, int i11, int i12, int i13, @p0 int[] iArr, int i14, @n0 int[] iArr2) {
        this.f5182y.e(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public void c0(int i10, int i11, int i12, boolean z10) {
        Z(i10 - getScrollX(), i11 - getScrollY(), i12, z10);
    }

    @Override // android.view.View, androidx.core.view.q0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.q0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.q0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f5161d.isFinished()) {
            return;
        }
        this.f5161d.computeScrollOffset();
        int currY = this.f5161d.getCurrY();
        int iM = m(currY - this.f5179v);
        this.f5179v = currY;
        int[] iArr = this.f5177t;
        boolean z10 = false;
        iArr[1] = 0;
        b(0, iM, iArr, null, 1);
        int i10 = iM - this.f5177t[1];
        int scrollRange = getScrollRange();
        if (i10 != 0) {
            int scrollY = getScrollY();
            N(0, i10, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i11 = i10 - scrollY2;
            int[] iArr2 = this.f5177t;
            iArr2[1] = 0;
            c(0, scrollY2, 0, i11, this.f5176s, 1, iArr2);
            i10 = i11 - this.f5177t[1];
        }
        if (i10 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                z10 = true;
            }
            if (z10) {
                if (i10 < 0) {
                    if (this.f5162e.isFinished()) {
                        this.f5162e.onAbsorb((int) this.f5161d.getCurrVelocity());
                    }
                } else if (this.f5163f.isFinished()) {
                    this.f5163f.onAbsorb((int) this.f5161d.getCurrVelocity());
                }
            }
            e();
        }
        if (this.f5161d.isFinished()) {
            g(1);
        } else {
            u0.n1(this);
        }
    }

    @Override // android.view.View, androidx.core.view.q0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.q0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View, androidx.core.view.q0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    @Override // androidx.core.view.c0
    public boolean d(int i10) {
        return this.f5182y.l(i10);
    }

    public void d0(int i10, int i11, boolean z10) {
        c0(i10, i11, 250, z10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || q(keyEvent);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean dispatchNestedFling(float f10, float f11, boolean z10) {
        return this.f5182y.a(f10, f11, z10);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean dispatchNestedPreFling(float f10, float f11) {
        return this.f5182y.b(f10, f11);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean dispatchNestedPreScroll(int i10, int i11, @p0 int[] iArr, @p0 int[] iArr2) {
        return b(i10, i11, iArr, iArr2, 0);
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, @p0 int[] iArr) {
        return this.f5182y.f(i10, i11, i12, i13, iArr);
    }

    @Override // android.view.View
    public void draw(@n0 Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        int paddingLeft2 = 0;
        if (!this.f5162e.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (b.a(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                paddingLeft = getPaddingLeft() + 0;
            } else {
                paddingLeft = 0;
            }
            if (b.a(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            this.f5162e.setSize(width, height);
            if (this.f5162e.draw(canvas)) {
                u0.n1(this);
            }
            canvas.restoreToCount(iSave);
        }
        if (this.f5163f.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (b.a(this)) {
            width2 -= getPaddingLeft() + getPaddingRight();
            paddingLeft2 = 0 + getPaddingLeft();
        }
        if (b.a(this)) {
            height2 -= getPaddingTop() + getPaddingBottom();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, 0.0f);
        this.f5163f.setSize(width2, height2);
        if (this.f5163f.draw(canvas)) {
            u0.n1(this);
        }
        canvas.restoreToCount(iSave2);
    }

    public final void e() {
        this.f5161d.abortAnimation();
        g(1);
    }

    public final boolean e0(MotionEvent motionEvent) {
        boolean z10;
        if (j.d(this.f5162e) != 0.0f) {
            j.j(this.f5162e, 0.0f, motionEvent.getX() / getWidth());
            z10 = true;
        } else {
            z10 = false;
        }
        if (j.d(this.f5163f) == 0.0f) {
            return z10;
        }
        j.j(this.f5163f, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    @Override // androidx.core.view.c0
    public boolean f(int i10, int i11) {
        return this.f5182y.s(i10, i11);
    }

    @Override // androidx.core.view.c0
    public void g(int i10) {
        this.f5182y.u(i10);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup, androidx.core.view.i0
    public int getNestedScrollAxes() {
        return this.f5181x.a();
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public boolean h(int i10) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i10);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !I(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i10 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i10 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i10 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            T(maxScrollAmount, 0, 1, true);
        } else {
            viewFindNextFocus.getDrawingRect(this.f5160c);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f5160c);
            T(l(this.f5160c), 0, 1, true);
            viewFindNextFocus.requestFocus(i10);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused() && C(viewFindFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean hasNestedScrollingParent() {
        return d(0);
    }

    public final boolean i() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0) {
            return overScrollMode == 1 && getScrollRange() > 0;
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean isNestedScrollingEnabled() {
        return this.f5182y.m();
    }

    public final boolean j() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public int l(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i10 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i11 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i10 - verticalFadingEdgeLength : i10;
        int i12 = rect.bottom;
        if (i12 > i11 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i11) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i10);
        }
        if (rect.top >= scrollY || i12 >= i11) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i11 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    public int m(int i10) {
        int height = getHeight();
        if (i10 > 0 && j.d(this.f5162e) != 0.0f) {
            int iRound = Math.round(((-height) / 4.0f) * j.j(this.f5162e, ((-i10) * 4.0f) / height, 0.5f));
            if (iRound != i10) {
                this.f5162e.finish();
            }
            return i10 - iRound;
        }
        if (i10 >= 0 || j.d(this.f5163f) == 0.0f) {
            return i10;
        }
        float f10 = height;
        int iRound2 = Math.round((f10 / 4.0f) * j.j(this.f5163f, (i10 * 4.0f) / f10, 0.5f));
        if (iRound2 != i10) {
            this.f5163f.finish();
        }
        return i10 - iRound2;
    }

    @Override // android.view.ViewGroup
    public void measureChild(@n0 View view, int i10, int i11) {
        view.measure(FrameLayout.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public final void n(int i10) {
        if (i10 != 0) {
            if (this.f5171n) {
                X(0, i10);
            } else {
                scrollBy(0, i10);
            }
        }
    }

    public final boolean o(int i10) {
        if (j.d(this.f5162e) != 0.0f) {
            if (W(this.f5162e, i10)) {
                this.f5162e.onAbsorb(i10);
            } else {
                s(-i10);
            }
        } else {
            if (j.d(this.f5163f) == 0.0f) {
                return false;
            }
            int i11 = -i10;
            if (W(this.f5163f, i11)) {
                this.f5163f.onAbsorb(i11);
            } else {
                s(i11);
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f5166i = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(@n0 MotionEvent motionEvent) {
        float axisValue;
        int width;
        if (motionEvent.getAction() != 8 || this.f5168k) {
            return false;
        }
        if (b0.l(motionEvent, 2)) {
            axisValue = motionEvent.getAxisValue(9);
            width = (int) motionEvent.getX();
        } else if (b0.l(motionEvent, 4194304)) {
            float axisValue2 = motionEvent.getAxisValue(26);
            width = getWidth() / 2;
            axisValue = axisValue2;
        } else {
            axisValue = 0.0f;
            width = 0;
        }
        if (axisValue == 0.0f) {
            return false;
        }
        T(-((int) (axisValue * getVerticalScrollFactorCompat())), width, 1, b0.l(motionEvent, 8194));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0075  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(@g.n0 android.view.MotionEvent r12) {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int measuredHeight = 0;
        this.f5165h = false;
        View view = this.f5167j;
        if (view != null && F(view, this)) {
            U(this.f5167j);
        }
        this.f5167j = null;
        if (!this.f5166i) {
            if (this.f5180w != null) {
                scrollTo(getScrollX(), this.f5180w.f5184a);
                this.f5180w = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iK = k(scrollY, paddingTop, measuredHeight);
            if (iK != scrollY) {
                scrollTo(getScrollX(), iK);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f5166i = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f5170m && View.MeasureSpec.getMode(i11) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public boolean onNestedFling(@n0 View view, float f10, float f11, boolean z10) {
        if (z10) {
            return false;
        }
        dispatchNestedFling(0.0f, f11, true);
        s((int) f11);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public boolean onNestedPreFling(@n0 View view, float f10, float f11) {
        return dispatchNestedPreFling(f10, f11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onNestedPreScroll(@n0 View view, int i10, int i11, @n0 int[] iArr) {
        K(view, i10, i11, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onNestedScroll(@n0 View view, int i10, int i11, int i12, int i13) {
        L(i13, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onNestedScrollAccepted(@n0 View view, @n0 View view2, int i10) {
        H(view, view2, i10, 0);
    }

    @Override // android.view.View
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        super.scrollTo(i10, i11);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        if (i10 == 2) {
            i10 = 130;
        } else if (i10 == 1) {
            i10 = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i10) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i10);
        if (viewFindNextFocus == null || C(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i10, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f5180w = savedState;
        requestLayout();
    }

    @Override // android.view.View
    @n0
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5184a = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        c cVar = this.A;
        if (cVar != null) {
            cVar.a(this, i10, i11, i12, i13);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !I(viewFindFocus, 0, i13)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f5160c);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f5160c);
        n(l(this.f5160c));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public boolean onStartNestedScroll(@n0 View view, @n0 View view2, int i10) {
        return G(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.i0
    public void onStopNestedScroll(@n0 View view) {
        J(view, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@n0 MotionEvent motionEvent) {
        ViewParent parent;
        y();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f5178u = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.f5178u);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f5169l;
                velocityTracker.computeCurrentVelocity(1000, this.f5174q);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f5175r);
                if (Math.abs(yVelocity) >= this.f5173p) {
                    if (!o(yVelocity)) {
                        int i10 = -yVelocity;
                        float f10 = i10;
                        if (!dispatchNestedPreFling(0.0f, f10)) {
                            dispatchNestedFling(0.0f, f10, true);
                            s(i10);
                        }
                    }
                } else if (this.f5161d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    u0.n1(this);
                }
                p();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f5175r);
                if (iFindPointerIndex == -1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid pointerId=");
                    sb2.append(this.f5175r);
                    sb2.append(" in onTouchEvent");
                } else {
                    int y10 = (int) motionEvent.getY(iFindPointerIndex);
                    int i11 = this.f5164g - y10;
                    int iQ = i11 - Q(i11, motionEvent.getX(iFindPointerIndex));
                    if (!this.f5168k && Math.abs(iQ) > this.f5172o) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f5168k = true;
                        iQ = iQ > 0 ? iQ - this.f5172o : iQ + this.f5172o;
                    }
                    if (this.f5168k) {
                        int iT = T(iQ, (int) motionEvent.getX(iFindPointerIndex), 0, false);
                        this.f5164g = y10 - iT;
                        this.f5178u += iT;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f5168k && getChildCount() > 0 && this.f5161d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    u0.n1(this);
                }
                p();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f5164g = (int) motionEvent.getY(actionIndex);
                this.f5175r = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                M(motionEvent);
                this.f5164g = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f5175r));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.f5168k && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f5161d.isFinished()) {
                e();
            }
            z((int) motionEvent.getY(), motionEvent.getPointerId(0));
        }
        VelocityTracker velocityTracker2 = this.f5169l;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public final void p() {
        this.f5175r = -1;
        this.f5168k = false;
        P();
        g(0);
        this.f5162e.onRelease();
        this.f5163f.onRelease();
    }

    public boolean q(@n0 KeyEvent keyEvent) {
        this.f5160c.setEmpty();
        if (!j()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
            return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            return !keyEvent.isAltPressed() ? h(33) : t(33);
        }
        if (keyCode == 20) {
            return !keyEvent.isAltPressed() ? h(130) : t(130);
        }
        if (keyCode != 62) {
            return false;
        }
        O(keyEvent.isShiftPressed() ? 33 : 130);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View r(boolean r13, int r14, int r15) {
        /*
            r12 = this;
            r0 = 2
            java.util.ArrayList r0 = r12.getFocusables(r0)
            int r1 = r0.size()
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
        Ld:
            if (r4 >= r1) goto L53
            java.lang.Object r6 = r0.get(r4)
            android.view.View r6 = (android.view.View) r6
            int r7 = r6.getTop()
            int r8 = r6.getBottom()
            r9 = 1
            if (r14 >= r8) goto L50
            if (r7 >= r15) goto L50
            if (r14 >= r7) goto L28
            if (r8 >= r15) goto L28
            r10 = 1
            goto L29
        L28:
            r10 = 0
        L29:
            if (r3 != 0) goto L2e
            r3 = r6
            r5 = r10
            goto L50
        L2e:
            if (r13 == 0) goto L36
            int r11 = r3.getTop()
            if (r7 < r11) goto L3e
        L36:
            if (r13 != 0) goto L40
            int r7 = r3.getBottom()
            if (r8 <= r7) goto L40
        L3e:
            r7 = 1
            goto L41
        L40:
            r7 = 0
        L41:
            if (r5 == 0) goto L48
            if (r10 == 0) goto L50
            if (r7 == 0) goto L50
            goto L4f
        L48:
            if (r10 == 0) goto L4d
            r3 = r6
            r5 = 1
            goto L50
        L4d:
            if (r7 == 0) goto L50
        L4f:
            r3 = r6
        L50:
            int r4 = r4 + 1
            goto Ld
        L53:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.r(boolean, int, int):android.view.View");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f5165h) {
            this.f5167j = view2;
        } else {
            U(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(@n0 View view, Rect rect, boolean z10) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return V(rect, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        if (z10) {
            P();
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f5165h = true;
        super.requestLayout();
    }

    public void s(int i10) {
        if (getChildCount() > 0) {
            this.f5161d.fling(getScrollX(), getScrollY(), 0, i10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            R(true);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i10, int i11) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iK = k(i10, width, width2);
            int iK2 = k(i11, height, height2);
            if (iK == getScrollX() && iK2 == getScrollY()) {
                return;
            }
            super.scrollTo(iK, iK2);
        }
    }

    public void setFillViewport(boolean z10) {
        if (z10 != this.f5170m) {
            this.f5170m = z10;
            requestLayout();
        }
    }

    @Override // android.view.View, androidx.core.view.e0
    public void setNestedScrollingEnabled(boolean z10) {
        this.f5182y.p(z10);
    }

    public void setOnScrollChangeListener(@p0 c cVar) {
        this.A = cVar;
    }

    public void setSmoothScrollingEnabled(boolean z10) {
        this.f5171n = z10;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View, androidx.core.view.e0
    public boolean startNestedScroll(int i10) {
        return f(i10, 0);
    }

    @Override // android.view.View, androidx.core.view.e0
    public void stopNestedScroll() {
        g(0);
    }

    public boolean t(int i10) {
        int childCount;
        boolean z10 = i10 == 130;
        int height = getHeight();
        Rect rect = this.f5160c;
        rect.top = 0;
        rect.bottom = height;
        if (z10 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f5160c.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f5160c;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f5160c;
        return S(i10, rect3.top, rect3.bottom);
    }

    public final float u(int i10) {
        double dLog = Math.log((Math.abs(i10) * 0.35f) / (this.f5158a * 0.015f));
        float f10 = f5156v1;
        return (float) (((double) (this.f5158a * 0.015f)) * Math.exp((((double) f10) / (((double) f10) - 1.0d)) * dLog));
    }

    public final boolean v(int i10, int i11) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i11 >= childAt.getTop() - scrollY && i11 < childAt.getBottom() - scrollY && i10 >= childAt.getLeft() && i10 < childAt.getRight();
    }

    public final void w() {
        VelocityTracker velocityTracker = this.f5169l;
        if (velocityTracker == null) {
            this.f5169l = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    public final void x() {
        this.f5161d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f5172o = viewConfiguration.getScaledTouchSlop();
        this.f5173p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f5174q = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public final void y() {
        if (this.f5169l == null) {
            this.f5169l = VelocityTracker.obtain();
        }
    }

    public final void z(int i10, int i11) {
        this.f5164g = i10;
        this.f5175r = i11;
        f(2, 0);
    }

    public NestedScrollView(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.R.attr.nestedScrollViewStyle);
    }

    public NestedScrollView(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f5160c = new Rect();
        this.f5165h = true;
        this.f5166i = false;
        this.f5167j = null;
        this.f5168k = false;
        this.f5171n = true;
        this.f5175r = -1;
        this.f5176s = new int[2];
        this.f5177t = new int[2];
        this.f5162e = j.a(context, attributeSet);
        this.f5163f = j.a(context, attributeSet);
        this.f5158a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        x();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2, i10, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f5181x = new j0(this);
        this.f5182y = new f0(this);
        setNestedScrollingEnabled(true);
        u0.B1(this, f5157v2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10) {
        if (getChildCount() <= 0) {
            super.addView(view, i10);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i10, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
