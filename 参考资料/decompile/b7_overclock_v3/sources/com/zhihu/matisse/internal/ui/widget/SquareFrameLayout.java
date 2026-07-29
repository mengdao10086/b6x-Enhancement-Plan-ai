package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes5.dex */
public class SquareFrameLayout extends FrameLayout {
    public SquareFrameLayout(Context context) {
        super(context);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i10);
    }

    public SquareFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
