package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import g.n0;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements e<InputStream> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f12209b = 5242880;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclableBufferedInputStream f12210a;

    public static final class a implements e.a<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bumptech.glide.load.engine.bitmap_recycle.b f12211a;

        public a(com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f12211a = bVar;
        }

        @Override // com.bumptech.glide.load.data.e.a
        @n0
        public Class<InputStream> a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.e.a
        @n0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public e<InputStream> b(InputStream inputStream) {
            return new k(inputStream, this.f12211a);
        }
    }

    public k(InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        this.f12210a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(5242880);
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
        this.f12210a.d();
    }

    public void c() {
        this.f12210a.c();
    }

    @Override // com.bumptech.glide.load.data.e
    @n0
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public InputStream a() throws IOException {
        this.f12210a.reset();
        return this.f12210a;
    }
}
