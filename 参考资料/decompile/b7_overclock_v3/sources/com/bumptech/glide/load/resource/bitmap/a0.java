package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import g.n0;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class a0 extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12561d = "com.bumptech.glide.load.resource.bitmap.Rotate";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f12562e = f12561d.getBytes(c4.b.f9745b);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12563c;

    public a0(int i10) {
        this.f12563c = i10;
    }

    @Override // c4.b
    public void a(@n0 MessageDigest messageDigest) {
        messageDigest.update(f12562e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f12563c).array());
    }

    @Override // com.bumptech.glide.load.resource.bitmap.h
    public Bitmap c(@n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, int i10, int i11) {
        return d0.n(bitmap, this.f12563c);
    }

    @Override // c4.b
    public boolean equals(Object obj) {
        return (obj instanceof a0) && this.f12563c == ((a0) obj).f12563c;
    }

    @Override // c4.b
    public int hashCode() {
        return v4.o.p(-950519196, v4.o.o(this.f12563c));
    }
}
