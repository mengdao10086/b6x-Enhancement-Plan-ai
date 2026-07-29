package com.flydigi.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class CompactViewPager extends ViewPager {
    public CompactViewPager(@n0 Context context) {
        super(context);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public CompactViewPager(@n0 Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
