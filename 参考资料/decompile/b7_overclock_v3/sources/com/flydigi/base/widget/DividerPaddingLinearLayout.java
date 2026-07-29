package com.flydigi.base.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes2.dex */
public class DividerPaddingLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f13408h = {R.attr.divider, R.attr.showDividers, R.attr.dividerPadding, R.attr.layout_marginTop, R.attr.layout_marginBottom, R.attr.layout_marginStart, R.attr.layout_marginEnd};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f13409i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f13410j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f13411k = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f13412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13418g;

    public DividerPaddingLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13416e = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f13408h);
        setDividerDrawable(typedArrayObtainStyledAttributes.getDrawable(0));
        this.f13414c = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f13415d = this.f13416e;
        this.f13413b = typedArrayObtainStyledAttributes.getInteger(1, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void a(Canvas canvas) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt != null && childAt.getVisibility() != 8 && e(i10)) {
                d(canvas, childAt.getLeft() - ((LinearLayout.LayoutParams) childAt.getLayoutParams()).leftMargin);
            }
        }
    }

    public final void b(Canvas canvas) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt != null && childAt.getVisibility() != 8 && e(i10)) {
                c(canvas, childAt.getTop() - ((LinearLayout.LayoutParams) childAt.getLayoutParams()).topMargin);
            }
        }
    }

    public final void c(Canvas canvas, int i10) {
        this.f13412a.setBounds(getPaddingLeft() + this.f13415d, i10, (getWidth() - getPaddingRight()) - this.f13416e, this.f13418g + i10);
        this.f13412a.draw(canvas);
    }

    public void d(Canvas canvas, int i10) {
        this.f13412a.setBounds(i10, getPaddingTop() + this.f13415d, this.f13417f + i10, (getHeight() - getPaddingBottom()) - this.f13416e);
        this.f13412a.draw(canvas);
    }

    public boolean e(int i10) {
        if (i10 == 0 || i10 == getChildCount() || (this.f13413b & 2) == 0) {
            return false;
        }
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            if (getChildAt(i11).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    public void f() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int iIndexOfChild = indexOfChild(childAt);
            int orientation = getOrientation();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (e(iIndexOfChild)) {
                if (orientation == 1) {
                    layoutParams.topMargin = this.f13418g;
                } else {
                    layoutParams.leftMargin = this.f13417f;
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f13412a != null) {
            if (getOrientation() == 1) {
                b(canvas);
            } else {
                a(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        f();
        super.onMeasure(i10, i11);
    }

    @Override // android.widget.LinearLayout
    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f13412a) {
            return;
        }
        this.f13412a = drawable;
        if (drawable != null) {
            this.f13417f = drawable.getIntrinsicWidth();
            this.f13418g = drawable.getIntrinsicHeight();
        } else {
            this.f13417f = 0;
            this.f13418g = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPaddingLeft(int i10) {
        this.f13415d = i10;
    }

    public void setDividerPaddingRight(int i10) {
        this.f13416e = i10;
    }
}
