package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.ImageHeaderParser;
import g.n0;
import g.v0;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@v0(27)
public final class r implements ImageHeaderParser {
    @Override // com.bumptech.glide.load.ImageHeaderParser
    @n0
    public ImageHeaderParser.ImageType a(@n0 ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int b(@n0 ByteBuffer byteBuffer, @n0 com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        return d(v4.a.g(byteBuffer), bVar);
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @n0
    public ImageHeaderParser.ImageType c(@n0 InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int d(@n0 InputStream inputStream, @n0 com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        int iL = new i1.a(inputStream).l(i1.a.C, 1);
        if (iL == 0) {
            return -1;
        }
        return iL;
    }
}
