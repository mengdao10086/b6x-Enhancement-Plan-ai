package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import g.p0;
import g.v0;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface v {

    public static final class a implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f12653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<ImageHeaderParser> f12654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bumptech.glide.load.engine.bitmap_recycle.b f12655c;

        public a(byte[] bArr, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f12653a = bArr;
            this.f12654b = list;
            this.f12655c = bVar;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        public int a() throws IOException {
            return com.bumptech.glide.load.a.c(this.f12654b, ByteBuffer.wrap(this.f12653a), this.f12655c);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        @p0
        public Bitmap b(BitmapFactory.Options options) {
            byte[] bArr = this.f12653a;
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        public void c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        public ImageHeaderParser.ImageType d() throws IOException {
            return com.bumptech.glide.load.a.g(this.f12654b, ByteBuffer.wrap(this.f12653a));
        }
    }

    public static final class b implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f12656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<ImageHeaderParser> f12657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bumptech.glide.load.engine.bitmap_recycle.b f12658c;

        public b(ByteBuffer byteBuffer, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f12656a = byteBuffer;
            this.f12657b = list;
            this.f12658c = bVar;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        public int a() throws IOException {
            return com.bumptech.glide.load.a.c(this.f12657b, v4.a.d(this.f12656a), this.f12658c);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        @p0
        public Bitmap b(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(e(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        public void c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        public ImageHeaderParser.ImageType d() throws IOException {
            return com.bumptech.glide.load.a.g(this.f12657b, v4.a.d(this.f12656a));
        }

        public final InputStream e() {
            return v4.a.g(v4.a.d(this.f12656a));
        }
    }

    public static final class c implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f12659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<ImageHeaderParser> f12660b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bumptech.glide.load.engine.bitmap_recycle.b f12661c;

        public c(File file, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f12659a = file;
            this.f12660b = list;
            this.f12661c = bVar;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        public int a() throws Throwable {
            RecyclableBufferedInputStream recyclableBufferedInputStream;
            Throwable th2;
            try {
                recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(this.f12659a), this.f12661c);
                try {
                    int iB = com.bumptech.glide.load.a.b(this.f12660b, recyclableBufferedInputStream, this.f12661c);
                    try {
                        recyclableBufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    return iB;
                } catch (Throwable th3) {
                    th2 = th3;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                recyclableBufferedInputStream = null;
                th2 = th4;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        @p0
        public Bitmap b(BitmapFactory.Options options) throws Throwable {
            RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(this.f12659a), this.f12661c);
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(recyclableBufferedInputStream2, null, options);
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return bitmapDecodeStream;
                } catch (Throwable th2) {
                    th = th2;
                    recyclableBufferedInputStream = recyclableBufferedInputStream2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        public void c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        public ImageHeaderParser.ImageType d() throws Throwable {
            RecyclableBufferedInputStream recyclableBufferedInputStream;
            Throwable th2;
            try {
                recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(this.f12659a), this.f12661c);
                try {
                    ImageHeaderParser.ImageType imageTypeF = com.bumptech.glide.load.a.f(this.f12660b, recyclableBufferedInputStream, this.f12661c);
                    try {
                        recyclableBufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    return imageTypeF;
                } catch (Throwable th3) {
                    th2 = th3;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                recyclableBufferedInputStream = null;
                th2 = th4;
            }
        }
    }

    public static final class d implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bumptech.glide.load.data.k f12662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bumptech.glide.load.engine.bitmap_recycle.b f12663b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<ImageHeaderParser> f12664c;

        public d(InputStream inputStream, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f12663b = (com.bumptech.glide.load.engine.bitmap_recycle.b) v4.m.d(bVar);
            this.f12664c = (List) v4.m.d(list);
            this.f12662a = new com.bumptech.glide.load.data.k(inputStream, bVar);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        public int a() throws IOException {
            return com.bumptech.glide.load.a.b(this.f12664c, this.f12662a.a(), this.f12663b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        @p0
        public Bitmap b(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.f12662a.a(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        public void c() {
            this.f12662a.c();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        public ImageHeaderParser.ImageType d() throws IOException {
            return com.bumptech.glide.load.a.f(this.f12664c, this.f12662a.a(), this.f12663b);
        }
    }

    @v0(21)
    public static final class e implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bumptech.glide.load.engine.bitmap_recycle.b f12665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<ImageHeaderParser> f12666b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ParcelFileDescriptorRewinder f12667c;

        public e(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f12665a = (com.bumptech.glide.load.engine.bitmap_recycle.b) v4.m.d(bVar);
            this.f12666b = (List) v4.m.d(list);
            this.f12667c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        public int a() throws IOException {
            return com.bumptech.glide.load.a.a(this.f12666b, this.f12667c, this.f12665a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        @p0
        public Bitmap b(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f12667c.a().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        public void c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.v
        public ImageHeaderParser.ImageType d() throws IOException {
            return com.bumptech.glide.load.a.e(this.f12666b, this.f12667c, this.f12665a);
        }
    }

    int a() throws IOException;

    @p0
    Bitmap b(BitmapFactory.Options options) throws IOException;

    void c();

    ImageHeaderParser.ImageType d() throws IOException;
}
