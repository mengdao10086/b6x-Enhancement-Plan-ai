package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

/* JADX INFO: loaded from: classes5.dex */
public class PreviewViewPager extends ViewPager {
    public PreviewViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public boolean i(View view, boolean z10, int i10, int i11, int i12) {
        return view instanceof ImageViewTouch ? ((ImageViewTouch) view).M(i10) || super.i(view, z10, i10, i11, i12) : super.i(view, z10, i10, i11, i12);
    }
}
