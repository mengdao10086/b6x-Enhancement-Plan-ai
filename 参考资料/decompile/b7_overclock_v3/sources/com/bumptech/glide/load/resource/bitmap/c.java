package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public class c extends l4.c<BitmapDrawable> implements com.bumptech.glide.load.engine.o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.e f12569b;

    public c(BitmapDrawable bitmapDrawable, com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        super(bitmapDrawable);
        this.f12569b = eVar;
    }

    @Override // com.bumptech.glide.load.engine.s
    public void a() {
        this.f12569b.e(((BitmapDrawable) this.f39446a).getBitmap());
    }

    @Override // l4.c, com.bumptech.glide.load.engine.o
    public void b() {
        ((BitmapDrawable) this.f39446a).getBitmap().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.s
    public int c() {
        return v4.o.h(((BitmapDrawable) this.f39446a).getBitmap());
    }

    @Override // com.bumptech.glide.load.engine.s
    @n0
    public Class<BitmapDrawable> d() {
        return BitmapDrawable.class;
    }
}
