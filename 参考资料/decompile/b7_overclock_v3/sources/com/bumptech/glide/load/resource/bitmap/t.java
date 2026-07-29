package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import g.n0;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f12629g = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f12630h = f12629g.getBytes(c4.b.f9745b);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f12631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f12632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f12633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f12634f;

    public t(float f10, float f11, float f12, float f13) {
        this.f12631c = f10;
        this.f12632d = f11;
        this.f12633e = f12;
        this.f12634f = f13;
    }

    @Override // c4.b
    public void a(@n0 MessageDigest messageDigest) {
        messageDigest.update(f12630h);
        messageDigest.update(ByteBuffer.allocate(16).putFloat(this.f12631c).putFloat(this.f12632d).putFloat(this.f12633e).putFloat(this.f12634f).array());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.h
    public Bitmap c(@n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, int i10, int i11) {
        return d0.p(eVar, bitmap, this.f12631c, this.f12632d, this.f12633e, this.f12634f);
    }

    @Override // c4.b
    public boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f12631c == tVar.f12631c && this.f12632d == tVar.f12632d && this.f12633e == tVar.f12633e && this.f12634f == tVar.f12634f;
    }

    @Override // c4.b
    public int hashCode() {
        return v4.o.n(this.f12634f, v4.o.n(this.f12633e, v4.o.n(this.f12632d, v4.o.p(-2013597734, v4.o.m(this.f12631c)))));
    }
}
