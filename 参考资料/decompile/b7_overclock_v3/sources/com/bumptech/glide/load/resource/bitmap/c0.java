package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.bitmap.o;
import g.n0;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class c0 implements c4.f<InputStream, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f12570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.b f12571b;

    public static class a implements o.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclableBufferedInputStream f12572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final v4.e f12573b;

        public a(RecyclableBufferedInputStream recyclableBufferedInputStream, v4.e eVar) {
            this.f12572a = recyclableBufferedInputStream;
            this.f12573b = eVar;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.o.b
        public void a(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) throws IOException {
            IOException iOExceptionC = this.f12573b.c();
            if (iOExceptionC != null) {
                if (bitmap == null) {
                    throw iOExceptionC;
                }
                eVar.e(bitmap);
                throw iOExceptionC;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.o.b
        public void b() {
            this.f12572a.c();
        }
    }

    public c0(o oVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f12570a = oVar;
        this.f12571b = bVar;
    }

    @Override // c4.f
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.engine.s<Bitmap> b(@n0 InputStream inputStream, int i10, int i11, @n0 c4.e eVar) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z10;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z10 = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f12571b);
            z10 = true;
        }
        v4.e eVarD = v4.e.d(recyclableBufferedInputStream);
        try {
            return this.f12570a.g(new v4.k(eVarD), i10, i11, eVar, new a(recyclableBufferedInputStream, eVarD));
        } finally {
            eVarD.f();
            if (z10) {
                recyclableBufferedInputStream.d();
            }
        }
    }

    @Override // c4.f
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@n0 InputStream inputStream, @n0 c4.e eVar) {
        return this.f12570a.s(inputStream);
    }
}
