package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import g.n0;
import g.v0;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@v0(api = 28)
public final class f implements c4.f<ImageDecoder.Source, Bitmap> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12593b = "BitmapImageDecoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.e f12594a = new com.bumptech.glide.load.engine.bitmap_recycle.f();

    @Override // c4.f
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.s<Bitmap> b(@n0 ImageDecoder.Source source, int i10, int i11, @n0 c4.e eVar) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new j4.a(i10, i11, eVar));
        if (Log.isLoggable(f12593b, 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Decoded [");
            sb2.append(bitmapDecodeBitmap.getWidth());
            sb2.append("x");
            sb2.append(bitmapDecodeBitmap.getHeight());
            sb2.append("] for [");
            sb2.append(i10);
            sb2.append("x");
            sb2.append(i11);
            sb2.append("]");
        }
        return new g(bitmapDecodeBitmap, this.f12594a);
    }

    @Override // c4.f
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@n0 ImageDecoder.Source source, @n0 c4.e eVar) throws IOException {
        return true;
    }
}
