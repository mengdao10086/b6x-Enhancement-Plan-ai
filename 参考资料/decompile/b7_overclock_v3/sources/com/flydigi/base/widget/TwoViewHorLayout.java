package com.flydigi.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class TwoViewHorLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f13551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f13552b;

    public TwoViewHorLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public void measureChildWithMargins(View view, int i10, int i11, int i12, int i13) {
        super.measureChildWithMargins(view, i10, i11, i12, i13);
        int i14 = ((LinearLayout.LayoutParams) this.f13551a.getLayoutParams()).leftMargin;
        int i15 = ((LinearLayout.LayoutParams) this.f13551a.getLayoutParams()).rightMargin;
        int i16 = ((LinearLayout.LayoutParams) this.f13552b.getLayoutParams()).leftMargin;
        int i17 = ((LinearLayout.LayoutParams) this.f13552b.getLayoutParams()).rightMargin;
        int measuredWidth = this.f13551a.getMeasuredWidth();
        int measuredWidth2 = this.f13552b.getMeasuredWidth();
        int measuredWidth3 = getMeasuredWidth();
        if (i14 + i15 + measuredWidth + i16 + measuredWidth2 + i17 <= measuredWidth3) {
            return;
        }
        this.f13551a.measure(View.MeasureSpec.makeMeasureSpec(((((measuredWidth3 - i14) - i15) - measuredWidth2) - i16) - i17, Integer.MIN_VALUE), i12);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getOrientation() != 0) {
            throw new RuntimeException("only support horizontal");
        }
        if (getChildCount() != 2) {
            throw new RuntimeException("child count must be 2");
        }
        this.f13551a = getChildAt(0);
        this.f13552b = getChildAt(1);
    }

    public TwoViewHorLayout(Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TwoViewHorLayout(Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
