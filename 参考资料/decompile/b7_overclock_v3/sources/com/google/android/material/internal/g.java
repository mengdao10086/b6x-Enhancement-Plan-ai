package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import com.google.android.material.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class g extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20418d;

    public g(@n0 Context context) {
        this(context, null);
    }

    public static int a(int i10, int i11, int i12) {
        return i11 != Integer.MIN_VALUE ? i11 != 1073741824 ? i12 : i10 : Math.min(i12, i10);
    }

    public int b(@n0 View view) {
        Object tag = view.getTag(R.id.row_index_key);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean c() {
        return this.f20417c;
    }

    public final void d(@n0 Context context, @p0 AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        this.f20415a = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        this.f20416b = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_itemSpacing, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int getItemSpacing() {
        return this.f20416b;
    }

    public int getLineSpacing() {
        return this.f20415a;
    }

    public int getRowCount() {
        return this.f20418d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int iB;
        int iC;
        if (getChildCount() == 0) {
            this.f20418d = 0;
            return;
        }
        this.f20418d = 1;
        boolean z11 = u0.Z(this) == 1;
        int paddingRight = z11 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z11 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i14 = (i12 - i10) - paddingLeft;
        int measuredWidth = paddingRight;
        int i15 = paddingTop;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.row_index_key, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    iC = androidx.core.view.r.c(marginLayoutParams);
                    iB = androidx.core.view.r.b(marginLayoutParams);
                } else {
                    iB = 0;
                    iC = 0;
                }
                int measuredWidth2 = measuredWidth + iC + childAt.getMeasuredWidth();
                if (!this.f20417c && measuredWidth2 > i14) {
                    i15 = this.f20415a + paddingTop;
                    this.f20418d++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(R.id.row_index_key, Integer.valueOf(this.f20418d - 1));
                int i17 = measuredWidth + iC;
                int measuredWidth3 = childAt.getMeasuredWidth() + i17;
                int measuredHeight = childAt.getMeasuredHeight() + i15;
                if (z11) {
                    childAt.layout(i14 - measuredWidth3, i15, (i14 - measuredWidth) - iC, measuredHeight);
                } else {
                    childAt.layout(i17, i15, measuredWidth3, measuredHeight);
                }
                measuredWidth += iC + iB + childAt.getMeasuredWidth() + this.f20416b;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int paddingLeft;
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i11);
        int i14 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i14 - getPaddingRight();
        int i15 = paddingTop;
        int i16 = 0;
        for (int i17 = 0; i17 < getChildCount(); i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i10, i11);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i12 = marginLayoutParams.leftMargin + 0;
                    i13 = marginLayoutParams.rightMargin + 0;
                } else {
                    i12 = 0;
                    i13 = 0;
                }
                int i18 = paddingLeft2;
                if (paddingLeft2 + i12 + childAt.getMeasuredWidth() <= paddingRight || c()) {
                    paddingLeft = i18;
                } else {
                    paddingLeft = getPaddingLeft();
                    i15 = this.f20415a + paddingTop;
                }
                int measuredWidth = paddingLeft + i12 + childAt.getMeasuredWidth();
                int measuredHeight = i15 + childAt.getMeasuredHeight();
                if (measuredWidth > i16) {
                    i16 = measuredWidth;
                }
                paddingLeft2 = paddingLeft + i12 + i13 + childAt.getMeasuredWidth() + this.f20416b;
                if (i17 == getChildCount() - 1) {
                    i16 += i13;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i16 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    public void setItemSpacing(int i10) {
        this.f20416b = i10;
    }

    public void setLineSpacing(int i10) {
        this.f20415a = i10;
    }

    public void setSingleLine(boolean z10) {
        this.f20417c = z10;
    }

    public g(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public g(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f20417c = false;
        d(context, attributeSet);
    }

    @TargetApi(21)
    public g(@n0 Context context, @p0 AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f20417c = false;
        d(context, attributeSet);
    }
}
