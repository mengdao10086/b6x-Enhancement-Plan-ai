package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import g.n0;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class l extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12599c = "com.bumptech.glide.load.resource.bitmap.CenterCrop";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f12600d = f12599c.getBytes(c4.b.f9745b);

    @Override // c4.b
    public void a(@n0 MessageDigest messageDigest) {
        messageDigest.update(f12600d);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.h
    public Bitmap c(@n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, int i10, int i11) {
        return d0.b(eVar, bitmap, i10, i11);
    }

    @Override // c4.b
    public boolean equals(Object obj) {
        return obj instanceof l;
    }

    @Override // c4.b
    public int hashCode() {
        return -599754482;
    }
}
