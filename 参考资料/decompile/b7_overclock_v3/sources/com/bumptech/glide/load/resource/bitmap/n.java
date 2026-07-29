package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import g.n0;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class n extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f12603c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12604d = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f12605e = f12604d.getBytes(c4.b.f9745b);

    @Override // c4.b
    public void a(@n0 MessageDigest messageDigest) {
        messageDigest.update(f12605e);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.h
    public Bitmap c(@n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, int i10, int i11) {
        return d0.d(eVar, bitmap, i10, i11);
    }

    @Override // c4.b
    public boolean equals(Object obj) {
        return obj instanceof n;
    }

    @Override // c4.b
    public int hashCode() {
        return 1101716364;
    }
}
