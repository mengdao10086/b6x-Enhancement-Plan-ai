package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import g.n0;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class a<DataType> implements c4.f<DataType, BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c4.f<DataType, Bitmap> f12559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f12560b;

    public a(Context context, c4.f<DataType, Bitmap> fVar) {
        this(context.getResources(), fVar);
    }

    @Override // c4.f
    public boolean a(@n0 DataType datatype, @n0 c4.e eVar) throws IOException {
        return this.f12559a.a(datatype, eVar);
    }

    @Override // c4.f
    public com.bumptech.glide.load.engine.s<BitmapDrawable> b(@n0 DataType datatype, int i10, int i11, @n0 c4.e eVar) throws IOException {
        return x.f(this.f12560b, this.f12559a.b(datatype, i10, i11, eVar));
    }

    @Deprecated
    public a(Resources resources, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, c4.f<DataType, Bitmap> fVar) {
        this(resources, fVar);
    }

    public a(@n0 Resources resources, @n0 c4.f<DataType, Bitmap> fVar) {
        this.f12560b = (Resources) v4.m.d(resources);
        this.f12559a = (c4.f) v4.m.d(fVar);
    }
}
