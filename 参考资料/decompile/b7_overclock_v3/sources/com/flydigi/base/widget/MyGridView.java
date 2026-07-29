package com.flydigi.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* JADX INFO: loaded from: classes2.dex */
public class MyGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13517a;

    public MyGridView(Context context) {
        super(context);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public MyGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyGridView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
