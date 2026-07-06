package androidx.core.widget;

import a.eh;
import a.hg;
import a.ig;
import a.kg;
import a.lj;
import a.mg;
import a.ni;
import a.rf;
import a.si;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
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
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class NestedScrollView extends FrameLayout implements kg, hg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8193a = new a();
    public static final int[] c = {R.attr.fillViewport};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f4190a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4191a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f4192a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ig f4193a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final mg f4194a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f4195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public VelocityTracker f4196a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f4197a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public EdgeEffect f4198a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OverScroller f4199a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f4200a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f4201a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f4202a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public EdgeEffect f4203b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4204b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int[] f4205b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f4206c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4207c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f4208d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f4209e;
    public int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f4210f;
    public int g;

    public static class a extends rf {
        @Override // a.rf
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            si.a(accessibilityEvent, nestedScrollView.getScrollX());
            si.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // a.rf
        public void g(View view, ni niVar) {
            int scrollRange;
            super.g(view, niVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            niVar.a0(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            niVar.u0(true);
            if (nestedScrollView.getScrollY() > 0) {
                niVar.b(ni.a.e);
                niVar.b(ni.a.i);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                niVar.b(ni.a.d);
                niVar.b(ni.a.j);
            }
        }

        @Override // a.rf
        public boolean j(View view, int i, Bundle bundle) {
            if (super.j(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i != 4096) {
                if (i == 8192 || i == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.O(0, iMax, true);
                    return true;
                }
                if (i != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.O(0, iMin, true);
            return true;
        }
    }

    public interface b {
        void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    public static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new lj();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8194a;

        public c(Parcel parcel) {
            super(parcel);
            this.f8194a = parcel.readInt();
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f8194a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f8194a);
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4195a = new Rect();
        this.f4204b = true;
        this.f4207c = false;
        this.f4197a = null;
        this.f4208d = false;
        this.f4210f = true;
        this.e = -1;
        this.f4202a = new int[2];
        this.f4205b = new int[2];
        x();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c, i, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f4194a = new mg(this);
        this.f4193a = new ig(this);
        setNestedScrollingEnabled(true);
        eh.k0(this, f8193a);
    }

    public static boolean A(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && A((View) parent, view2);
    }

    public static int d(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f4190a == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f4190a = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f4190a;
    }

    public final boolean B(View view, int i, int i2) {
        view.getDrawingRect(this.f4195a);
        offsetDescendantRectToMyCoords(view, this.f4195a);
        return this.f4195a.bottom + i >= getScrollY() && this.f4195a.top - i <= getScrollY() + i2;
    }

    public final void C(int i, int i2, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f4193a.e(0, scrollY2, 0, i - scrollY2, null, i2, iArr);
    }

    public final void D(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.e) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f4191a = (int) motionEvent.getY(i);
            this.e = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.f4196a;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean E(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int overScrollMode = getOverScrollMode();
        boolean z4 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z5 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z6 = overScrollMode == 0 || (overScrollMode == 1 && z4);
        boolean z7 = overScrollMode == 0 || (overScrollMode == 1 && z5);
        int i9 = i3 + i;
        int i10 = !z6 ? 0 : i7;
        int i11 = i4 + i2;
        int i12 = !z7 ? 0 : i8;
        int i13 = -i10;
        int i14 = i10 + i5;
        int i15 = -i12;
        int i16 = i12 + i6;
        if (i9 > i14) {
            i9 = i14;
            z2 = true;
        } else if (i9 < i13) {
            z2 = true;
            i9 = i13;
        } else {
            z2 = false;
        }
        if (i11 > i16) {
            i11 = i16;
            z3 = true;
        } else if (i11 < i15) {
            z3 = true;
            i11 = i15;
        } else {
            z3 = false;
        }
        if (z3 && !u(1)) {
            this.f4199a.springBack(i9, i11, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i9, i11, z2, z3);
        return z2 || z3;
    }

    public boolean F(int i) {
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.f4195a.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f4195a;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f4195a.top = getScrollY() - height;
            Rect rect2 = this.f4195a;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f4195a;
        int i2 = rect3.top;
        int i3 = height + i2;
        rect3.bottom = i3;
        return I(i, i2, i3);
    }

    public final void G() {
        VelocityTracker velocityTracker = this.f4196a;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4196a = null;
        }
    }

    public final void H(boolean z) {
        if (z) {
            P(2, 1);
        } else {
            Q(1);
        }
        this.g = getScrollY();
        eh.b0(this);
    }

    public final boolean I(int i, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z = false;
        boolean z2 = i == 33;
        View viewR = r(z2, i2, i3);
        if (viewR == null) {
            viewR = this;
        }
        if (i2 < scrollY || i3 > i4) {
            n(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (viewR != findFocus()) {
            viewR.requestFocus(i);
        }
        return z;
    }

    public final void J(View view) {
        view.getDrawingRect(this.f4195a);
        offsetDescendantRectToMyCoords(view, this.f4195a);
        int iE = e(this.f4195a);
        if (iE != 0) {
            scrollBy(0, iE);
        }
    }

    public final boolean K(Rect rect, boolean z) {
        int iE = e(rect);
        boolean z2 = iE != 0;
        if (z2) {
            if (z) {
                scrollBy(0, iE);
            } else {
                L(0, iE);
            }
        }
        return z2;
    }

    public final void L(int i, int i2) {
        M(i, i2, 250, false);
    }

    public final void M(int i, int i2, int i3, boolean z) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f4192a > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f4199a.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i2 + scrollY, Math.max(0, height - height2))) - scrollY, i3);
            H(z);
        } else {
            if (!this.f4199a.isFinished()) {
                a();
            }
            scrollBy(i, i2);
        }
        this.f4192a = AnimationUtils.currentAnimationTimeMillis();
    }

    public void N(int i, int i2, int i3, boolean z) {
        M(i - getScrollX(), i2 - getScrollY(), i3, z);
    }

    public void O(int i, int i2, boolean z) {
        N(i, i2, 250, z);
    }

    public boolean P(int i, int i2) {
        return this.f4193a.p(i, i2);
    }

    public void Q(int i) {
        this.f4193a.r(i);
    }

    public final void a() {
        this.f4199a.abortAnimation();
        Q(1);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public boolean b(int i) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !B(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            n(maxScrollAmount);
        } else {
            viewFindNextFocus.getDrawingRect(this.f4195a);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f4195a);
            n(e(this.f4195a));
            viewFindNextFocus.requestFocus(i);
        }
        if (viewFindFocus == null || !viewFindFocus.isFocused() || !z(viewFindFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    public final boolean c() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        EdgeEffect edgeEffect;
        if (this.f4199a.isFinished()) {
            return;
        }
        this.f4199a.computeScrollOffset();
        int currY = this.f4199a.getCurrY();
        int i = currY - this.g;
        this.g = currY;
        int[] iArr = this.f4205b;
        boolean z = false;
        iArr[1] = 0;
        f(0, i, iArr, null, 1);
        int i2 = i - this.f4205b[1];
        int scrollRange = getScrollRange();
        if (i2 != 0) {
            int scrollY = getScrollY();
            E(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i3 = i2 - scrollY2;
            int[] iArr2 = this.f4205b;
            iArr2[1] = 0;
            g(0, scrollY2, 0, i3, this.f4202a, 1, iArr2);
            i2 = i3 - this.f4205b[1];
        }
        if (i2 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                z = true;
            }
            if (z) {
                p();
                if (i2 < 0) {
                    if (this.f4198a.isFinished()) {
                        edgeEffect = this.f4198a;
                        edgeEffect.onAbsorb((int) this.f4199a.getCurrVelocity());
                    }
                } else if (this.f4203b.isFinished()) {
                    edgeEffect = this.f4203b;
                    edgeEffect.onAbsorb((int) this.f4199a.getCurrVelocity());
                }
            }
            a();
        }
        if (this.f4199a.isFinished()) {
            Q(1);
        } else {
            eh.b0(this);
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
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

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || q(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f4193a.a(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f4193a.b(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return f(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f4193a.f(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        if (this.f4198a != null) {
            int scrollY = getScrollY();
            int paddingLeft2 = 0;
            if (!this.f4198a.isFinished()) {
                int iSave = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int iMin = Math.min(0, scrollY);
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    paddingLeft = getPaddingLeft() + 0;
                } else {
                    paddingLeft = 0;
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    iMin += getPaddingTop();
                }
                canvas.translate(paddingLeft, iMin);
                this.f4198a.setSize(width, height);
                if (this.f4198a.draw(canvas)) {
                    eh.b0(this);
                }
                canvas.restoreToCount(iSave);
            }
            if (this.f4203b.isFinished()) {
                return;
            }
            int iSave2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int iMax = Math.max(getScrollRange(), scrollY) + height2;
            if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                width2 -= getPaddingLeft() + getPaddingRight();
                paddingLeft2 = 0 + getPaddingLeft();
            }
            if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                height2 -= getPaddingTop() + getPaddingBottom();
                iMax -= getPaddingBottom();
            }
            canvas.translate(paddingLeft2 - width2, iMax);
            canvas.rotate(180.0f, width2, 0.0f);
            this.f4203b.setSize(width2, height2);
            if (this.f4203b.draw(canvas)) {
                eh.b0(this);
            }
            canvas.restoreToCount(iSave2);
        }
    }

    public int e(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i2 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i - verticalFadingEdgeLength : i;
        if (rect.bottom > i2 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i2) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i);
        }
        if (rect.top >= scrollY || rect.bottom >= i2) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i2 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    public boolean f(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.f4193a.d(i, i2, iArr, iArr2, i3);
    }

    public void g(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        this.f4193a.e(i, i2, i3, i4, iArr, i5, iArr2);
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

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f4194a.a();
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

    @Override // a.jg
    public boolean h(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return u(0);
    }

    @Override // a.jg
    public void i(View view, int i, int i2, int[] iArr, int i3) {
        f(i, i2, iArr, null, i3);
    }

    @Override // android.view.View, a.hg
    public boolean isNestedScrollingEnabled() {
        return this.f4193a.l();
    }

    @Override // a.jg
    public void j(View view, View view2, int i, int i2) {
        this.f4194a.c(view, view2, i, i2);
        P(2, i2);
    }

    @Override // a.jg
    public void k(View view, int i, int i2, int i3, int i4, int i5) {
        C(i4, i5, null);
    }

    @Override // a.jg
    public void l(View view, int i) {
        this.f4194a.d(view, i);
        Q(i);
    }

    @Override // a.kg
    public void m(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        C(i4, i5, iArr);
    }

    @Override // android.view.ViewGroup
    public void measureChild(View view, int i, int i2) {
        view.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public final void n(int i) {
        if (i != 0) {
            if (this.f4210f) {
                L(0, i);
            } else {
                scrollBy(0, i);
            }
        }
    }

    public final void o() {
        this.f4208d = false;
        G();
        Q(0);
        EdgeEffect edgeEffect = this.f4198a;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f4203b.onRelease();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4207c = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.f4208d) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i = scrollY - verticalScrollFactorCompat;
                if (i < 0) {
                    scrollRange = 0;
                } else if (i <= scrollRange) {
                    scrollRange = i;
                }
                if (scrollRange != scrollY) {
                    super.scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int measuredHeight = 0;
        this.f4204b = false;
        View view = this.f4197a;
        if (view != null && A(view, this)) {
            J(this.f4197a);
        }
        this.f4197a = null;
        if (!this.f4207c) {
            if (this.f4201a != null) {
                scrollTo(getScrollX(), this.f4201a.f8194a);
                this.f4201a = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iD = d(scrollY, paddingTop, measuredHeight);
            if (iD != scrollY) {
                scrollTo(getScrollX(), iD);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f4207c = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f4209e && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f2, true);
        s((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        i(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        C(i4, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public void onNestedScrollAccepted(View view, View view2, int i) {
        j(view, view2, i, 0);
    }

    @Override // android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        View viewFindNextFocus = rect == null ? focusFinder.findNextFocus(this, null, i) : focusFinder.findNextFocusFromRect(this, rect, i);
        if (viewFindNextFocus == null || z(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.f4201a = cVar;
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f8194a = getScrollY();
        return cVar;
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        b bVar = this.f4200a;
        if (bVar != null) {
            bVar.a(this, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !B(viewFindFocus, 0, i4)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f4195a);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f4195a);
        n(e(this.f4195a));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return h(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, a.lg
    public void onStopNestedScroll(View view) {
        l(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r24) {
        /*
            Method dump skipped, instruction units count: 597
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        if (getOverScrollMode() == 2) {
            this.f4198a = null;
            this.f4203b = null;
        } else if (this.f4198a == null) {
            Context context = getContext();
            this.f4198a = new EdgeEffect(context);
            this.f4203b = new EdgeEffect(context);
        }
    }

    public boolean q(KeyEvent keyEvent) {
        this.f4195a.setEmpty();
        if (!c()) {
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
            return !keyEvent.isAltPressed() ? b(33) : t(33);
        }
        if (keyCode == 20) {
            return !keyEvent.isAltPressed() ? b(130) : t(130);
        }
        if (keyCode != 62) {
            return false;
        }
        F(keyEvent.isShiftPressed() ? 33 : 130);
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
            r4 = r2
            r5 = r4
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
            r10 = r9
            goto L29
        L28:
            r10 = r2
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
            r7 = r9
            goto L41
        L40:
            r7 = r2
        L41:
            if (r5 == 0) goto L48
            if (r10 == 0) goto L50
            if (r7 == 0) goto L50
            goto L4f
        L48:
            if (r10 == 0) goto L4d
            r3 = r6
            r5 = r9
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
        if (this.f4204b) {
            this.f4197a = view2;
        } else {
            J(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return K(rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            G();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f4204b = true;
        super.requestLayout();
    }

    public void s(int i) {
        if (getChildCount() > 0) {
            this.f4199a.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            H(true);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iD = d(i, width, width2);
            int iD2 = d(i2, height, height2);
            if (iD == getScrollX() && iD2 == getScrollY()) {
                return;
            }
            super.scrollTo(iD, iD2);
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f4209e) {
            this.f4209e = z;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.f4193a.m(z);
    }

    public void setOnScrollChangeListener(b bVar) {
        this.f4200a = bVar;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f4210f = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return P(i, 0);
    }

    @Override // android.view.View, a.hg
    public void stopNestedScroll() {
        Q(0);
    }

    public boolean t(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        Rect rect = this.f4195a;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f4195a.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f4195a;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f4195a;
        return I(i, rect3.top, rect3.bottom);
    }

    public boolean u(int i) {
        return this.f4193a.k(i);
    }

    public final boolean v(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    public final void w() {
        VelocityTracker velocityTracker = this.f4196a;
        if (velocityTracker == null) {
            this.f4196a = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    public final void x() {
        this.f4199a = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.b = viewConfiguration.getScaledTouchSlop();
        this.f4206c = viewConfiguration.getScaledMinimumFlingVelocity();
        this.d = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public final void y() {
        if (this.f4196a == null) {
            this.f4196a = VelocityTracker.obtain();
        }
    }

    public final boolean z(View view) {
        return !B(view, 0, getHeight());
    }
}
