package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 implements c4.f<Bitmap, Bitmap> {

    public static final class a implements com.bumptech.glide.load.engine.s<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f12592a;

        public a(@n0 Bitmap bitmap) {
            this.f12592a = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.s
        public void a() {
        }

        @Override // com.bumptech.glide.load.engine.s
        @n0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.f12592a;
        }

        @Override // com.bumptech.glide.load.engine.s
        public int c() {
            return v4.o.h(this.f12592a);
        }

        @Override // com.bumptech.glide.load.engine.s
        @n0
        public Class<Bitmap> d() {
            return Bitmap.class;
        }
    }

    @Override // c4.f
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.s<Bitmap> b(@n0 Bitmap bitmap, int i10, int i11, @n0 c4.e eVar) {
        return new a(bitmap);
    }

    @Override // c4.f
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@n0 Bitmap bitmap, @n0 c4.e eVar) {
        return true;
    }
}
