package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import c4.d;
import g.i1;
import g.n0;
import g.p0;
import g.v0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class VideoDecoder<T> implements c4.f<T, Bitmap> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12546d = "VideoDecoder";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f12547e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @i1
    public static final int f12548f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c4.d<Long> f12549g = c4.d.b("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c4.d<Integer> f12550h = c4.d.b("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final e f12551i = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f<T> f12552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.e f12553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f12554c;

    public static final class VideoDecoderException extends RuntimeException {
        private static final long serialVersionUID = -2556382523004027815L;

        public VideoDecoderException() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    public class a implements d.b<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f12555a = ByteBuffer.allocate(8);

        @Override // c4.d.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@n0 byte[] bArr, @n0 Long l10, @n0 MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f12555a) {
                this.f12555a.position(0);
                messageDigest.update(this.f12555a.putLong(l10.longValue()).array());
            }
        }
    }

    public class b implements d.b<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f12556a = ByteBuffer.allocate(4);

        @Override // c4.d.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@n0 byte[] bArr, @n0 Integer num, @n0 MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f12556a) {
                this.f12556a.position(0);
                messageDigest.update(this.f12556a.putInt(num.intValue()).array());
            }
        }
    }

    public static final class c implements f<AssetFileDescriptor> {
        public c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    @v0(23)
    public static final class d implements f<ByteBuffer> {

        public class a extends MediaDataSource {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ByteBuffer f12557a;

            public a(ByteBuffer byteBuffer) {
                this.f12557a = byteBuffer;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.f12557a.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j10, byte[] bArr, int i10, int i11) {
                if (j10 >= this.f12557a.limit()) {
                    return -1;
                }
                this.f12557a.position((int) j10);
                int iMin = Math.min(i11, this.f12557a.remaining());
                this.f12557a.get(bArr, i10, iMin);
                return iMin;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new a(byteBuffer));
        }
    }

    @i1
    public static class e {
        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    @i1
    public interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t10);
    }

    public static final class g implements f<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.resource.bitmap.VideoDecoder.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    public VideoDecoder(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, f<T> fVar) {
        this(eVar, fVar, f12551i);
    }

    public static c4.f<AssetFileDescriptor, Bitmap> c(com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        return new VideoDecoder(eVar, new c(null));
    }

    @v0(api = 23)
    public static c4.f<ByteBuffer, Bitmap> d(com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        return new VideoDecoder(eVar, new d());
    }

    @p0
    public static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j10, int i10, int i11, int i12, DownsampleStrategy downsampleStrategy) {
        Bitmap bitmapG = (Build.VERSION.SDK_INT < 27 || i11 == Integer.MIN_VALUE || i12 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f12536f) ? null : g(mediaMetadataRetriever, j10, i10, i11, i12, downsampleStrategy);
        if (bitmapG == null) {
            bitmapG = f(mediaMetadataRetriever, j10, i10);
        }
        if (bitmapG != null) {
            return bitmapG;
        }
        throw new VideoDecoderException();
    }

    public static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j10, int i10) {
        return mediaMetadataRetriever.getFrameAtTime(j10, i10);
    }

    @p0
    @TargetApi(27)
    public static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j10, int i10, int i11, int i12, DownsampleStrategy downsampleStrategy) {
        try {
            int i13 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i14 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i15 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i15 == 90 || i15 == 270) {
                i14 = i13;
                i13 = i14;
            }
            float fB = downsampleStrategy.b(i13, i14, i11, i12);
            return mediaMetadataRetriever.getScaledFrameAtTime(j10, i10, Math.round(i13 * fB), Math.round(fB * i14));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static c4.f<ParcelFileDescriptor, Bitmap> h(com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        return new VideoDecoder(eVar, new g());
    }

    @Override // c4.f
    public boolean a(@n0 T t10, @n0 c4.e eVar) {
        return true;
    }

    @Override // c4.f
    public com.bumptech.glide.load.engine.s<Bitmap> b(@n0 T t10, int i10, int i11, @n0 c4.e eVar) throws IOException {
        long jLongValue = ((Long) eVar.c(f12549g)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) eVar.c(f12550h);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) eVar.c(DownsampleStrategy.f12538h);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.f12537g;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever mediaMetadataRetrieverA = this.f12554c.a();
        try {
            this.f12552a.a(mediaMetadataRetrieverA, t10);
            return com.bumptech.glide.load.resource.bitmap.g.f(e(mediaMetadataRetrieverA, jLongValue, num.intValue(), i10, i11, downsampleStrategy2), this.f12553b);
        } finally {
            if (Build.VERSION.SDK_INT >= 29) {
                mediaMetadataRetrieverA.close();
            } else {
                mediaMetadataRetrieverA.release();
            }
        }
    }

    @i1
    public VideoDecoder(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, f<T> fVar, e eVar2) {
        this.f12553b = eVar;
        this.f12552a = fVar;
        this.f12554c = eVar2;
    }
}
