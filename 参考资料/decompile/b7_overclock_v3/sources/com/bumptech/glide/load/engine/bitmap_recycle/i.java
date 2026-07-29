package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements a<int[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12304a = "IntegerArrayPool";

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public int a() {
        return 4;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int b(int[] iArr) {
        return iArr.length;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int[] newArray(int i10) {
        return new int[i10];
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public String h() {
        return f12304a;
    }
}
