package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import g.n0;
import g.p0;
import g.v0;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12168a = 5242880;

    /* JADX INFO: renamed from: com.bumptech.glide.load.a$a, reason: collision with other inner class name */
    public class C0119a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f12169a;

        public C0119a(InputStream inputStream) {
            this.f12169a = inputStream;
        }

        @Override // com.bumptech.glide.load.a.h
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.c(this.f12169a);
            } finally {
                this.f12169a.reset();
            }
        }
    }

    public class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f12170a;

        public b(ByteBuffer byteBuffer) {
            this.f12170a = byteBuffer;
        }

        @Override // com.bumptech.glide.load.a.h
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            return imageHeaderParser.a(this.f12170a);
        }
    }

    public class c implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ParcelFileDescriptorRewinder f12171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bumptech.glide.load.engine.bitmap_recycle.b f12172b;

        public c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f12171a = parcelFileDescriptorRewinder;
            this.f12172b = bVar;
        }

        @Override // com.bumptech.glide.load.a.h
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws Throwable {
            RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(this.f12171a.a().getFileDescriptor()), this.f12172b);
                try {
                    ImageHeaderParser.ImageType imageTypeC = imageHeaderParser.c(recyclableBufferedInputStream2);
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    this.f12171a.a();
                    return imageTypeC;
                } catch (Throwable th2) {
                    th = th2;
                    recyclableBufferedInputStream = recyclableBufferedInputStream2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    this.f12171a.a();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public class d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f12173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bumptech.glide.load.engine.bitmap_recycle.b f12174b;

        public d(ByteBuffer byteBuffer, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f12173a = byteBuffer;
            this.f12174b = bVar;
        }

        @Override // com.bumptech.glide.load.a.g
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            return imageHeaderParser.b(this.f12173a, this.f12174b);
        }
    }

    public class e implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f12175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bumptech.glide.load.engine.bitmap_recycle.b f12176b;

        public e(InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f12175a = inputStream;
            this.f12176b = bVar;
        }

        @Override // com.bumptech.glide.load.a.g
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.d(this.f12175a, this.f12176b);
            } finally {
                this.f12175a.reset();
            }
        }
    }

    public class f implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ParcelFileDescriptorRewinder f12177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bumptech.glide.load.engine.bitmap_recycle.b f12178b;

        public f(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
            this.f12177a = parcelFileDescriptorRewinder;
            this.f12178b = bVar;
        }

        @Override // com.bumptech.glide.load.a.g
        public int a(ImageHeaderParser imageHeaderParser) throws Throwable {
            RecyclableBufferedInputStream recyclableBufferedInputStream = null;
            try {
                RecyclableBufferedInputStream recyclableBufferedInputStream2 = new RecyclableBufferedInputStream(new FileInputStream(this.f12177a.a().getFileDescriptor()), this.f12178b);
                try {
                    int iD = imageHeaderParser.d(recyclableBufferedInputStream2, this.f12178b);
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (IOException unused) {
                    }
                    this.f12177a.a();
                    return iD;
                } catch (Throwable th2) {
                    th = th2;
                    recyclableBufferedInputStream = recyclableBufferedInputStream2;
                    if (recyclableBufferedInputStream != null) {
                        try {
                            recyclableBufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    this.f12177a.a();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public interface g {
        int a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    public interface h {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    @v0(21)
    public static int a(@n0 List<ImageHeaderParser> list, @n0 ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @n0 com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        return d(list, new f(parcelFileDescriptorRewinder, bVar));
    }

    public static int b(@n0 List<ImageHeaderParser> list, @p0 InputStream inputStream, @n0 com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return d(list, new e(inputStream, bVar));
    }

    public static int c(@n0 List<ImageHeaderParser> list, @p0 ByteBuffer byteBuffer, @n0 com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        if (byteBuffer == null) {
            return -1;
        }
        return d(list, new d(byteBuffer, bVar));
    }

    public static int d(@n0 List<ImageHeaderParser> list, g gVar) throws IOException {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            int iA = gVar.a(list.get(i10));
            if (iA != -1) {
                return iA;
            }
        }
        return -1;
    }

    @n0
    @v0(21)
    public static ImageHeaderParser.ImageType e(@n0 List<ImageHeaderParser> list, @n0 ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @n0 com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        return h(list, new c(parcelFileDescriptorRewinder, bVar));
    }

    @n0
    public static ImageHeaderParser.ImageType f(@n0 List<ImageHeaderParser> list, @p0 InputStream inputStream, @n0 com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return h(list, new C0119a(inputStream));
    }

    @n0
    public static ImageHeaderParser.ImageType g(@n0 List<ImageHeaderParser> list, @p0 ByteBuffer byteBuffer) throws IOException {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : h(list, new b(byteBuffer));
    }

    @n0
    public static ImageHeaderParser.ImageType h(@n0 List<ImageHeaderParser> list, h hVar) throws IOException {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            ImageHeaderParser.ImageType imageTypeA = hVar.a(list.get(i10));
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
