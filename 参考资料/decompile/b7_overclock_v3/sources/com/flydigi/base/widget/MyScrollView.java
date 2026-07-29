package com.flydigi.base.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes2.dex */
public class MyScrollView extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DisplayMetrics f13518a;

    public MyScrollView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        try {
            ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(this.f13518a);
            i11 = View.MeasureSpec.makeMeasureSpec(this.f13518a.heightPixels / 2, Integer.MIN_VALUE);
        } catch (Exception unused) {
        }
        super.onMeasure(i10, i11);
    }

    public MyScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f13518a = new DisplayMetrics();
    }
}
