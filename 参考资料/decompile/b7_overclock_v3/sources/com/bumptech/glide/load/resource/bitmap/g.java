package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class g implements com.bumptech.glide.load.engine.s<Bitmap>, com.bumptech.glide.load.engine.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f12595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.e f12596b;

    public g(@n0 Bitmap bitmap, @n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        this.f12595a = (Bitmap) v4.m.e(bitmap, "Bitmap must not be null");
        this.f12596b = (com.bumptech.glide.load.engine.bitmap_recycle.e) v4.m.e(eVar, "BitmapPool must not be null");
    }

    @p0
    public static g f(@p0 Bitmap bitmap, @n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new g(bitmap, eVar);
    }

    @Override // com.bumptech.glide.load.engine.s
    public void a() {
        this.f12596b.e(this.f12595a);
    }

    @Override // com.bumptech.glide.load.engine.o
    public void b() {
        this.f12595a.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.s
    public int c() {
        return v4.o.h(this.f12595a);
    }

    @Override // com.bumptech.glide.load.engine.s
    @n0
    public Class<Bitmap> d() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.s
    @n0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.f12595a;
    }
}
