package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements a<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12297a = "ByteArrayPool";

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public int a() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int b(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public byte[] newArray(int i10) {
        return new byte[i10];
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public String h() {
        return f12297a;
    }
}
