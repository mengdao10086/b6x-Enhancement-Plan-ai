package a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class m7 extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f6777a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1895a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f1896a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f1897a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1898b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int[] f1899b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f1900c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    public static class a extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f6778a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f1901a;

        public a(int i, int i2) {
            super(i, i2);
            this.f1901a = -1;
            this.f6778a = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1901a = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c0.LinearLayoutCompat_Layout);
            this.f6778a = typedArrayObtainStyledAttributes.getFloat(c0.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f1901a = typedArrayObtainStyledAttributes.getInt(c0.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            typedArrayObtainStyledAttributes.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1901a = -1;
        }
    }

    public m7(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public m7(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1898b = true;
        this.f1895a = -1;
        this.b = 0;
        this.d = 8388659;
        o8 o8VarV = o8.v(context, attributeSet, c0.LinearLayoutCompat, i, 0);
        eh.i0(this, context, c0.LinearLayoutCompat, attributeSet, o8VarV.r(), i, 0);
        int iK = o8VarV.k(c0.LinearLayoutCompat_android_orientation, -1);
        if (iK >= 0) {
            setOrientation(iK);
        }
        int iK2 = o8VarV.k(c0.LinearLayoutCompat_android_gravity, -1);
        if (iK2 >= 0) {
            setGravity(iK2);
        }
        boolean zA = o8VarV.a(c0.LinearLayoutCompat_android_baselineAligned, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.f6777a = o8VarV.i(c0.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f1895a = o8VarV.k(c0.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1900c = o8VarV.a(c0.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(o8VarV.g(c0.LinearLayoutCompat_divider));
        this.h = o8VarV.k(c0.LinearLayoutCompat_showDividers, 0);
        this.i = o8VarV.f(c0.LinearLayoutCompat_dividerPadding, 0);
        o8VarV.w();
    }

    public final void A(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void g(Canvas canvas) {
        int right;
        int left;
        int paddingRight;
        int virtualChildCount = getVirtualChildCount();
        boolean zB = z8.b(this);
        for (int i = 0; i < virtualChildCount; i++) {
            View viewS = s(i);
            if (viewS != null && viewS.getVisibility() != 8 && t(i)) {
                a aVar = (a) viewS.getLayoutParams();
                j(canvas, zB ? viewS.getRight() + ((ViewGroup.MarginLayoutParams) aVar).rightMargin : (viewS.getLeft() - ((ViewGroup.MarginLayoutParams) aVar).leftMargin) - this.f);
            }
        }
        if (t(virtualChildCount)) {
            View viewS2 = s(virtualChildCount - 1);
            if (viewS2 != null) {
                a aVar2 = (a) viewS2.getLayoutParams();
                if (zB) {
                    left = viewS2.getLeft();
                    paddingRight = ((ViewGroup.MarginLayoutParams) aVar2).leftMargin;
                    right = (left - paddingRight) - this.f;
                } else {
                    right = viewS2.getRight() + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                }
            } else if (zB) {
                right = getPaddingLeft();
            } else {
                left = getWidth();
                paddingRight = getPaddingRight();
                right = (left - paddingRight) - this.f;
            }
            j(canvas, right);
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.f1895a < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.f1895a;
        if (childCount <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f1895a == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.b;
        if (this.c == 1 && (i = this.d & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.e) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.e;
            }
        }
        return bottom + ((ViewGroup.MarginLayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1895a;
    }

    public Drawable getDividerDrawable() {
        return this.f1896a;
    }

    public int getDividerPadding() {
        return this.i;
    }

    public int getDividerWidth() {
        return this.f;
    }

    public int getGravity() {
        return this.d;
    }

    public int getOrientation() {
        return this.c;
    }

    public int getShowDividers() {
        return this.h;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f6777a;
    }

    public void h(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View viewS = s(i);
            if (viewS != null && viewS.getVisibility() != 8 && t(i)) {
                i(canvas, (viewS.getTop() - ((ViewGroup.MarginLayoutParams) ((a) viewS.getLayoutParams())).topMargin) - this.g);
            }
        }
        if (t(virtualChildCount)) {
            View viewS2 = s(virtualChildCount - 1);
            i(canvas, viewS2 == null ? (getHeight() - getPaddingBottom()) - this.g : viewS2.getBottom() + ((ViewGroup.MarginLayoutParams) ((a) viewS2.getLayoutParams())).bottomMargin);
        }
    }

    public void i(Canvas canvas, int i) {
        this.f1896a.setBounds(getPaddingLeft() + this.i, i, (getWidth() - getPaddingRight()) - this.i, this.g + i);
        this.f1896a.draw(canvas);
    }

    public void j(Canvas canvas, int i) {
        this.f1896a.setBounds(i, getPaddingTop() + this.i, this.f + i, (getHeight() - getPaddingBottom()) - this.i);
        this.f1896a.draw(canvas);
    }

    public final void k(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View viewS = s(i3);
            if (viewS.getVisibility() != 8) {
                a aVar = (a) viewS.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).height == -1) {
                    int i4 = ((ViewGroup.MarginLayoutParams) aVar).width;
                    ((ViewGroup.MarginLayoutParams) aVar).width = viewS.getMeasuredWidth();
                    measureChildWithMargins(viewS, i2, 0, iMakeMeasureSpec, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).width = i4;
                }
            }
        }
    }

    public final void l(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View viewS = s(i3);
            if (viewS.getVisibility() != 8) {
                a aVar = (a) viewS.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).width == -1) {
                    int i4 = ((ViewGroup.MarginLayoutParams) aVar).height;
                    ((ViewGroup.MarginLayoutParams) aVar).height = viewS.getMeasuredHeight();
                    measureChildWithMargins(viewS, iMakeMeasureSpec, 0, i2, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).height = i4;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i = this.c;
        if (i == 0) {
            return new a(-2, -2);
        }
        if (i == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f1896a == null) {
            return;
        }
        if (this.c == 1) {
            h(canvas);
        } else {
            g(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.c == 1) {
            v(i, i2, i3, i4);
        } else {
            u(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.c == 1) {
            z(i, i2);
        } else {
            x(i, i2);
        }
    }

    public int p(View view, int i) {
        return 0;
    }

    public int q(View view) {
        return 0;
    }

    public int r(View view) {
        return 0;
    }

    public View s(int i) {
        return getChildAt(i);
    }

    public void setBaselineAligned(boolean z) {
        this.f1898b = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.f1895a = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f1896a) {
            return;
        }
        this.f1896a = drawable;
        if (drawable != null) {
            this.f = drawable.getIntrinsicWidth();
            this.g = drawable.getIntrinsicHeight();
        } else {
            this.f = 0;
            this.g = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.i = i;
    }

    public void setGravity(int i) {
        if (this.d != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.d = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.d;
        if ((8388615 & i3) != i2) {
            this.d = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f1900c = z;
    }

    public void setOrientation(int i) {
        if (this.c != i) {
            this.c = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.h) {
            requestLayout();
        }
        this.h = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.d;
        if ((i3 & 112) != i2) {
            this.d = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.f6777a = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean t(int i) {
        if (i == 0) {
            return (this.h & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.h & 4) != 0;
        }
        if ((this.h & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u(int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.m7.u(int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void v(int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.m7.v(int, int, int, int):void");
    }

    public void w(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x03b4 A[PHI: r3
  0x03b4: PHI (r3v36 int) = (r3v32 int), (r3v37 int) binds: [B:168:0x03b2, B:164:0x03a7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void x(int r39, int r40) {
        /*
            Method dump skipped, instruction units count: 1277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.m7.x(int, int):void");
    }

    public int y(int i) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x02de A[PHI: r10
  0x02de: PHI (r10v21 int) = (r10v19 int), (r10v22 int) binds: [B:135:0x02dc, B:131:0x02d1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x032b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void z(int r34, int r35) {
        /*
            Method dump skipped, instruction units count: 906
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.m7.z(int, int):void");
    }
}
