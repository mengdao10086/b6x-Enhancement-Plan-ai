package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class x implements com.bumptech.glide.load.engine.s<BitmapDrawable>, com.bumptech.glide.load.engine.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f12669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.s<Bitmap> f12670b;

    public x(@n0 Resources resources, @n0 com.bumptech.glide.load.engine.s<Bitmap> sVar) {
        this.f12669a = (Resources) v4.m.d(resources);
        this.f12670b = (com.bumptech.glide.load.engine.s) v4.m.d(sVar);
    }

    @p0
    public static com.bumptech.glide.load.engine.s<BitmapDrawable> f(@n0 Resources resources, @p0 com.bumptech.glide.load.engine.s<Bitmap> sVar) {
        if (sVar == null) {
            return null;
        }
        return new x(resources, sVar);
    }

    @Deprecated
    public static x g(Context context, Bitmap bitmap) {
        return (x) f(context.getResources(), g.f(bitmap, com.bumptech.glide.b.e(context).h()));
    }

    @Deprecated
    public static x h(Resources resources, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) {
        return (x) f(resources, g.f(bitmap, eVar));
    }

    @Override // com.bumptech.glide.load.engine.s
    public void a() {
        this.f12670b.a();
    }

    @Override // com.bumptech.glide.load.engine.o
    public void b() {
        com.bumptech.glide.load.engine.s<Bitmap> sVar = this.f12670b;
        if (sVar instanceof com.bumptech.glide.load.engine.o) {
            ((com.bumptech.glide.load.engine.o) sVar).b();
        }
    }

    @Override // com.bumptech.glide.load.engine.s
    public int c() {
        return this.f12670b.c();
    }

    @Override // com.bumptech.glide.load.engine.s
    @n0
    public Class<BitmapDrawable> d() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.s
    @n0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f12669a, this.f12670b.get());
    }
}
