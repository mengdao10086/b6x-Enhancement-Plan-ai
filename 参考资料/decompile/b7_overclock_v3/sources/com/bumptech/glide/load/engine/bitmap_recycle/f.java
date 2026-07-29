package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public class f implements e {
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public long a() {
        return 0L;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void b(int i10) {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void c() {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void d(float f10) {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    public void e(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    @n0
    public Bitmap f(int i10, int i11, Bitmap.Config config) {
        return Bitmap.createBitmap(i10, i11, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.e
    @n0
    public Bitmap g(int i10, int i11, Bitmap.Config config) {
        return f(i10, i11, config);
    }
}
