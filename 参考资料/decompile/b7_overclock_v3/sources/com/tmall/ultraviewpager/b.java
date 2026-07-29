package com.tmall.ultraviewpager;

import android.graphics.Bitmap;
import android.util.SparseIntArray;
import com.tmall.ultraviewpager.UltraViewPager;

/* JADX INFO: loaded from: classes5.dex */
public interface b {
    void a(int i10, SparseIntArray sparseIntArray);

    a b(int i10, int i11, int i12, int i13, int i14, int i15);

    void c(int i10, int i11);

    a d(Bitmap bitmap, Bitmap bitmap2, int i10);

    void e();

    void f();

    a g(int i10, int i11, int i12, int i13);

    a h(int i10, int i11, int i12);

    void i(UltraViewPager.ScrollDirection scrollDirection);

    a j();

    boolean k();

    boolean l();

    void m(int i10, int i11, int i12, int i13);

    void setAutoMeasureHeight(boolean z10);

    void setAutoScroll(int i10);

    void setHGap(int i10);

    void setInfiniteLoop(boolean z10);

    void setInfiniteRatio(int i10);

    void setItemRatio(double d10);

    void setMaxHeight(int i10);

    void setMaxWidth(int i10);

    void setMultiScreen(float f10);

    void setRatio(float f10);

    void setScrollMode(UltraViewPager.ScrollMode scrollMode);
}
