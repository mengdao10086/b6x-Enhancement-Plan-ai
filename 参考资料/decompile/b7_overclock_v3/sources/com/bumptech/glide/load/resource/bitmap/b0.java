package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import g.n0;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12566d = "com.bumptech.glide.load.resource.bitmap.RoundedCorners";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f12567e = f12566d.getBytes(c4.b.f9745b);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12568c;

    public b0(int i10) {
        v4.m.a(i10 > 0, "roundingRadius must be greater than 0.");
        this.f12568c = i10;
    }

    @Override // c4.b
    public void a(@n0 MessageDigest messageDigest) {
        messageDigest.update(f12567e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f12568c).array());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.h
    public Bitmap c(@n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, int i10, int i11) {
        return d0.q(eVar, bitmap, this.f12568c);
    }

    @Override // c4.b
    public boolean equals(Object obj) {
        return (obj instanceof b0) && this.f12568c == ((b0) obj).f12568c;
    }

    @Override // c4.b
    public int hashCode() {
        return v4.o.p(-569625254, v4.o.o(this.f12568c));
    }
}
