package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import g.n0;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class i extends RecyclerView.n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f19432c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f19433d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f19434e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f19435f = {android.R.attr.listDivider};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f19436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19437b;

    public i(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f19435f);
        this.f19436a = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        q(3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void d(@n0 Rect outRect, @n0 View view, RecyclerView parent, @n0 RecyclerView.b0 state) {
        int iP0 = parent.p0(view);
        if (iP0 == 0) {
            return;
        }
        if (!l() && !m()) {
            outRect.set(0, 0, 0, 0);
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
        List<f> flexLines = flexboxLayoutManager.getFlexLines();
        p(outRect, iP0, flexboxLayoutManager, flexLines, flexboxLayoutManager.getFlexDirection());
        o(outRect, iP0, flexboxLayoutManager, flexLines);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void f(@n0 Canvas canvas, @n0 RecyclerView parent, @n0 RecyclerView.b0 state) {
        i(canvas, parent);
        j(canvas, parent);
    }

    public final void i(Canvas canvas, RecyclerView parent) {
        int top2;
        int intrinsicHeight;
        int left;
        int right;
        int i10;
        int iMin;
        int left2;
        if (l()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            int left3 = parent.getLeft() - parent.getPaddingLeft();
            int right2 = parent.getRight() + parent.getPaddingRight();
            int childCount = parent.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = parent.getChildAt(i11);
                RecyclerView.p pVar = (RecyclerView.p) childAt.getLayoutParams();
                if (flexDirection == 3) {
                    intrinsicHeight = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
                    top2 = this.f19436a.getIntrinsicHeight() + intrinsicHeight;
                } else {
                    top2 = childAt.getTop() - ((ViewGroup.MarginLayoutParams) pVar).topMargin;
                    intrinsicHeight = top2 - this.f19436a.getIntrinsicHeight();
                }
                if (!flexboxLayoutManager.k()) {
                    left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) pVar).leftMargin;
                    right = childAt.getRight();
                    i10 = ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
                } else if (flexboxLayoutManager.V2()) {
                    iMin = Math.min(childAt.getRight() + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + this.f19436a.getIntrinsicWidth(), right2);
                    left2 = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) pVar).leftMargin;
                    this.f19436a.setBounds(left2, intrinsicHeight, iMin, top2);
                    this.f19436a.draw(canvas);
                } else {
                    left = Math.max((childAt.getLeft() - ((ViewGroup.MarginLayoutParams) pVar).leftMargin) - this.f19436a.getIntrinsicWidth(), left3);
                    right = childAt.getRight();
                    i10 = ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
                }
                int i12 = left;
                iMin = right + i10;
                left2 = i12;
                this.f19436a.setBounds(left2, intrinsicHeight, iMin, top2);
                this.f19436a.draw(canvas);
            }
        }
    }

    public final void j(Canvas canvas, RecyclerView parent) {
        int left;
        int intrinsicWidth;
        int iMax;
        int bottom;
        int i10;
        int i11;
        if (m()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
            int top2 = parent.getTop() - parent.getPaddingTop();
            int bottom2 = parent.getBottom() + parent.getPaddingBottom();
            int childCount = parent.getChildCount();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = parent.getChildAt(i12);
                RecyclerView.p pVar = (RecyclerView.p) childAt.getLayoutParams();
                if (flexboxLayoutManager.V2()) {
                    intrinsicWidth = childAt.getRight() + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
                    left = this.f19436a.getIntrinsicWidth() + intrinsicWidth;
                } else {
                    left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) pVar).leftMargin;
                    intrinsicWidth = left - this.f19436a.getIntrinsicWidth();
                }
                if (flexboxLayoutManager.k()) {
                    iMax = childAt.getTop() - ((ViewGroup.MarginLayoutParams) pVar).topMargin;
                    bottom = childAt.getBottom();
                    i10 = ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
                } else if (flexDirection == 3) {
                    int iMin = Math.min(childAt.getBottom() + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + this.f19436a.getIntrinsicHeight(), bottom2);
                    iMax = childAt.getTop() - ((ViewGroup.MarginLayoutParams) pVar).topMargin;
                    i11 = iMin;
                    this.f19436a.setBounds(intrinsicWidth, iMax, left, i11);
                    this.f19436a.draw(canvas);
                } else {
                    iMax = Math.max((childAt.getTop() - ((ViewGroup.MarginLayoutParams) pVar).topMargin) - this.f19436a.getIntrinsicHeight(), top2);
                    bottom = childAt.getBottom();
                    i10 = ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
                }
                i11 = bottom + i10;
                this.f19436a.setBounds(intrinsicWidth, iMax, left, i11);
                this.f19436a.draw(canvas);
            }
        }
    }

    public final boolean k(int position, List<f> flexLines, FlexboxLayoutManager layoutManager) {
        int iR2 = layoutManager.R2(position);
        if ((iR2 == -1 || iR2 >= layoutManager.getFlexLinesInternal().size() || layoutManager.getFlexLinesInternal().get(iR2).f19415o != position) && position != 0) {
            return flexLines.size() != 0 && flexLines.get(flexLines.size() - 1).f19416p == position - 1;
        }
        return true;
    }

    public final boolean l() {
        return (this.f19437b & 1) > 0;
    }

    public final boolean m() {
        return (this.f19437b & 2) > 0;
    }

    public void n(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.f19436a = drawable;
    }

    public final void o(Rect outRect, int position, FlexboxLayoutManager layoutManager, List<f> flexLines) {
        if (flexLines.size() == 0 || layoutManager.R2(position) == 0) {
            return;
        }
        if (layoutManager.k()) {
            if (l()) {
                outRect.top = this.f19436a.getIntrinsicHeight();
                outRect.bottom = 0;
                return;
            } else {
                outRect.top = 0;
                outRect.bottom = 0;
                return;
            }
        }
        if (m()) {
            if (layoutManager.V2()) {
                outRect.right = this.f19436a.getIntrinsicWidth();
                outRect.left = 0;
            } else {
                outRect.left = this.f19436a.getIntrinsicWidth();
                outRect.right = 0;
            }
        }
    }

    public final void p(Rect outRect, int position, FlexboxLayoutManager layoutManager, List<f> flexLines, int flexDirection) {
        if (k(position, flexLines, layoutManager)) {
            return;
        }
        if (layoutManager.k()) {
            if (!m()) {
                outRect.left = 0;
                outRect.right = 0;
                return;
            } else if (layoutManager.V2()) {
                outRect.right = this.f19436a.getIntrinsicWidth();
                outRect.left = 0;
                return;
            } else {
                outRect.left = this.f19436a.getIntrinsicWidth();
                outRect.right = 0;
                return;
            }
        }
        if (!l()) {
            outRect.top = 0;
            outRect.bottom = 0;
        } else if (flexDirection == 3) {
            outRect.bottom = this.f19436a.getIntrinsicHeight();
            outRect.top = 0;
        } else {
            outRect.top = this.f19436a.getIntrinsicHeight();
            outRect.bottom = 0;
        }
    }

    public void q(int orientation) {
        this.f19437b = orientation;
    }
}
