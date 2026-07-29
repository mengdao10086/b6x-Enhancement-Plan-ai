package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class i0 extends ViewGroup {
    public static final String A = "androidx.appcompat.widget.LinearLayoutCompat";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f2509p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f2510q = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f2511r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f2512s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f2513t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f2514u = 4;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f2515v = 4;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f2516w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f2517x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f2518y = 2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f2519z = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2524e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2525f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f2526g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2527h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f2528i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f2529j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Drawable f2530k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2531l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2532m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2533n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2534o;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface a {
    }

    public static class b extends LinearLayout.LayoutParams {
        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i10, int i11) {
            super(i10, i11);
        }

        public b(int i10, int i11, float f10) {
            super(i10, i11, f10);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface c {
    }

    public i0(@g.n0 Context context) {
        this(context, null);
    }

    public void A(View view, int i10, int i11, int i12, int i13, int i14) {
        measureChildWithMargins(view, i11, i12, i13, i14);
    }

    /* JADX WARN: Removed duplicated region for block: B:197:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void B(int r38, int r39) {
        /*
            Method dump skipped, instruction units count: 1288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i0.B(int, int):void");
    }

    public int C(int i10) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0330  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void D(int r34, int r35) {
        /*
            Method dump skipped, instruction units count: 911
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i0.D(int, int):void");
    }

    public final void E(View view, int i10, int i11, int i12, int i13) {
        view.layout(i10, i11, i12 + i10, i13 + i11);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i10;
        if (this.f2521b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i11 = this.f2521b;
        if (childCount <= i11) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i11);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f2521b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f2522c;
        if (this.f2523d == 1 && (i10 = this.f2524e & 112) != 48) {
            if (i10 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f2525f) / 2;
            } else if (i10 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f2525f;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((b) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f2521b;
    }

    public Drawable getDividerDrawable() {
        return this.f2530k;
    }

    public int getDividerPadding() {
        return this.f2534o;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        return this.f2531l;
    }

    @g.a0
    public int getGravity() {
        return this.f2524e;
    }

    public int getOrientation() {
        return this.f2523d;
    }

    public int getShowDividers() {
        return this.f2533n;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f2526g;
    }

    void i(Canvas canvas) {
        int right;
        int left;
        int i10;
        int virtualChildCount = getVirtualChildCount();
        boolean zB = h1.b(this);
        for (int i11 = 0; i11 < virtualChildCount; i11++) {
            View viewU = u(i11);
            if (viewU != null && viewU.getVisibility() != 8 && v(i11)) {
                b bVar = (b) viewU.getLayoutParams();
                l(canvas, zB ? viewU.getRight() + ((LinearLayout.LayoutParams) bVar).rightMargin : (viewU.getLeft() - ((LinearLayout.LayoutParams) bVar).leftMargin) - this.f2531l);
            }
        }
        if (v(virtualChildCount)) {
            View viewU2 = u(virtualChildCount - 1);
            if (viewU2 != null) {
                b bVar2 = (b) viewU2.getLayoutParams();
                if (zB) {
                    left = viewU2.getLeft() - ((LinearLayout.LayoutParams) bVar2).leftMargin;
                    i10 = this.f2531l;
                    right = left - i10;
                } else {
                    right = viewU2.getRight() + ((LinearLayout.LayoutParams) bVar2).rightMargin;
                }
            } else if (zB) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i10 = this.f2531l;
                right = left - i10;
            }
            l(canvas, right);
        }
    }

    void j(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i10 = 0; i10 < virtualChildCount; i10++) {
            View viewU = u(i10);
            if (viewU != null && viewU.getVisibility() != 8 && v(i10)) {
                k(canvas, (viewU.getTop() - ((LinearLayout.LayoutParams) ((b) viewU.getLayoutParams())).topMargin) - this.f2532m);
            }
        }
        if (v(virtualChildCount)) {
            View viewU2 = u(virtualChildCount - 1);
            k(canvas, viewU2 == null ? (getHeight() - getPaddingBottom()) - this.f2532m : viewU2.getBottom() + ((LinearLayout.LayoutParams) ((b) viewU2.getLayoutParams())).bottomMargin);
        }
    }

    void k(Canvas canvas, int i10) {
        this.f2530k.setBounds(getPaddingLeft() + this.f2534o, i10, (getWidth() - getPaddingRight()) - this.f2534o, this.f2532m + i10);
        this.f2530k.draw(canvas);
    }

    void l(Canvas canvas, int i10) {
        this.f2530k.setBounds(i10, getPaddingTop() + this.f2534o, this.f2531l + i10, (getHeight() - getPaddingBottom()) - this.f2534o);
        this.f2530k.draw(canvas);
    }

    public final void m(int i10, int i11) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i12 = 0; i12 < i10; i12++) {
            View viewU = u(i12);
            if (viewU.getVisibility() != 8) {
                b bVar = (b) viewU.getLayoutParams();
                if (((LinearLayout.LayoutParams) bVar).height == -1) {
                    int i13 = ((LinearLayout.LayoutParams) bVar).width;
                    ((LinearLayout.LayoutParams) bVar).width = viewU.getMeasuredWidth();
                    measureChildWithMargins(viewU, i11, 0, iMakeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) bVar).width = i13;
                }
            }
        }
    }

    public final void n(int i10, int i11) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i12 = 0; i12 < i10; i12++) {
            View viewU = u(i12);
            if (viewU.getVisibility() != 8) {
                b bVar = (b) viewU.getLayoutParams();
                if (((LinearLayout.LayoutParams) bVar).width == -1) {
                    int i13 = ((LinearLayout.LayoutParams) bVar).height;
                    ((LinearLayout.LayoutParams) bVar).height = viewU.getMeasuredHeight();
                    measureChildWithMargins(viewU, iMakeMeasureSpec, 0, i11, 0);
                    ((LinearLayout.LayoutParams) bVar).height = i13;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        int i10 = this.f2523d;
        if (i10 == 0) {
            return new b(-2, -2);
        }
        if (i10 == 1) {
            return new b(-1, -2);
        }
        return null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f2530k == null) {
            return;
        }
        if (this.f2523d == 1) {
            j(canvas);
        } else {
            i(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(A);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(A);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.f2523d == 1) {
            z(i10, i11, i12, i13);
        } else {
            y(i10, i11, i12, i13);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f2523d == 1) {
            D(i10, i11);
        } else {
            B(i10, i11);
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public int r(View view, int i10) {
        return 0;
    }

    public int s(View view) {
        return 0;
    }

    public void setBaselineAligned(boolean z10) {
        this.f2520a = z10;
    }

    public void setBaselineAlignedChildIndex(int i10) {
        if (i10 >= 0 && i10 < getChildCount()) {
            this.f2521b = i10;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ee.a.f26979d);
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f2530k) {
            return;
        }
        this.f2530k = drawable;
        if (drawable != null) {
            this.f2531l = drawable.getIntrinsicWidth();
            this.f2532m = drawable.getIntrinsicHeight();
        } else {
            this.f2531l = 0;
            this.f2532m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i10) {
        this.f2534o = i10;
    }

    public void setGravity(@g.a0 int i10) {
        if (this.f2524e != i10) {
            if ((8388615 & i10) == 0) {
                i10 |= androidx.core.view.m.f5025b;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            this.f2524e = i10;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i10) {
        int i11 = i10 & androidx.core.view.m.f5027d;
        int i12 = this.f2524e;
        if ((8388615 & i12) != i11) {
            this.f2524e = i11 | ((-8388616) & i12);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z10) {
        this.f2527h = z10;
    }

    public void setOrientation(int i10) {
        if (this.f2523d != i10) {
            this.f2523d = i10;
            requestLayout();
        }
    }

    public void setShowDividers(int i10) {
        if (i10 != this.f2533n) {
            requestLayout();
        }
        this.f2533n = i10;
    }

    public void setVerticalGravity(int i10) {
        int i11 = i10 & 112;
        int i12 = this.f2524e;
        if ((i12 & 112) != i11) {
            this.f2524e = i11 | (i12 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f10) {
        this.f2526g = Math.max(0.0f, f10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int t(View view) {
        return 0;
    }

    public View u(int i10) {
        return getChildAt(i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean v(int i10) {
        if (i10 == 0) {
            return (this.f2533n & 1) != 0;
        }
        if (i10 == getChildCount()) {
            return (this.f2533n & 4) != 0;
        }
        if ((this.f2533n & 2) == 0) {
            return false;
        }
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            if (getChildAt(i11).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    public boolean w() {
        return this.f2520a;
    }

    public boolean x() {
        return this.f2527h;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void y(int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i0.y(int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void z(int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i0.z(int, int, int, int):void");
    }

    public i0(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public i0(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2520a = true;
        this.f2521b = -1;
        this.f2522c = 0;
        this.f2524e = 8388659;
        int[] iArr = R.styleable.LinearLayoutCompat;
        y0 y0VarG = y0.G(context, attributeSet, iArr, i10, 0);
        androidx.core.view.u0.z1(this, context, iArr, attributeSet, y0VarG.B(), i10, 0);
        int iO = y0VarG.o(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (iO >= 0) {
            setOrientation(iO);
        }
        int iO2 = y0VarG.o(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (iO2 >= 0) {
            setGravity(iO2);
        }
        boolean zA = y0VarG.a(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.f2526g = y0VarG.j(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f2521b = y0VarG.o(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f2527h = y0VarG.a(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(y0VarG.h(R.styleable.LinearLayoutCompat_divider));
        this.f2533n = y0VarG.o(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.f2534o = y0VarG.g(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        y0VarG.I();
    }
}
