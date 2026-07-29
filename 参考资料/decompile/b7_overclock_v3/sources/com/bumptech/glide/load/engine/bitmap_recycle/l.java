package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public interface l {
    String a(int i10, int i11, Bitmap.Config config);

    int b(Bitmap bitmap);

    String c(Bitmap bitmap);

    void e(Bitmap bitmap);

    @p0
    Bitmap f(int i10, int i11, Bitmap.Config config);

    @p0
    Bitmap removeLast();
}
