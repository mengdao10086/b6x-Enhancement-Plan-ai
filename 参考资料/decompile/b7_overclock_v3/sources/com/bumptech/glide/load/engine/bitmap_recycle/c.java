package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import g.i1;

/* JADX INFO: loaded from: classes2.dex */
public class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f12289a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h<a, Bitmap> f12290b = new h<>();

    @i1
    public static class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f12291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12293c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Bitmap.Config f12294d;

        public a(b bVar) {
            this.f12291a = bVar;
        }

        public void a(int i10, int i11, Bitmap.Config config) {
            this.f12292b = i10;
            this.f12293c = i11;
            this.f12294d = config;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
        public void b() {
            this.f12291a.c(this);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f12292b == aVar.f12292b && this.f12293c == aVar.f12293c && this.f12294d == aVar.f12294d;
        }

        public int hashCode() {
            int i10 = ((this.f12292b * 31) + this.f12293c) * 31;
            Bitmap.Config config = this.f12294d;
            return i10 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.d(this.f12292b, this.f12293c, this.f12294d);
        }
    }

    @i1
    public static class b extends d<a> {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        public a e(int i10, int i11, Bitmap.Config config) {
            a aVarB = b();
            aVarB.a(i10, i11, config);
            return aVarB;
        }
    }

    public static String d(int i10, int i11, Bitmap.Config config) {
        return "[" + i10 + "x" + i11 + "], " + config;
    }

    public static String g(Bitmap bitmap) {
        return d(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public String a(int i10, int i11, Bitmap.Config config) {
        return d(i10, i11, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public int b(Bitmap bitmap) {
        return v4.o.h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public String c(Bitmap bitmap) {
        return g(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public void e(Bitmap bitmap) {
        this.f12290b.d(this.f12289a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public Bitmap f(int i10, int i11, Bitmap.Config config) {
        return this.f12290b.a(this.f12289a.e(i10, i11, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public Bitmap removeLast() {
        return this.f12290b.f();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f12290b;
    }
}
