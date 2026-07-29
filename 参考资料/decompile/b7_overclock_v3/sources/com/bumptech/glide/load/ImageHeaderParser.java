package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.bitmap_recycle.b;
import g.n0;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface ImageHeaderParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12166a = -1;

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        ANIMATED_WEBP(true),
        AVIF(true),
        UNKNOWN(false);

        private final boolean hasAlpha;

        ImageType(boolean z10) {
            this.hasAlpha = z10;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }

        public boolean isWebp() {
            int i10 = a.f12167a[ordinal()];
            return i10 == 1 || i10 == 2 || i10 == 3;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12167a;

        static {
            int[] iArr = new int[ImageType.values().length];
            f12167a = iArr;
            try {
                iArr[ImageType.WEBP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12167a[ImageType.WEBP_A.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12167a[ImageType.ANIMATED_WEBP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @n0
    ImageType a(@n0 ByteBuffer byteBuffer) throws IOException;

    int b(@n0 ByteBuffer byteBuffer, @n0 b bVar) throws IOException;

    @n0
    ImageType c(@n0 InputStream inputStream) throws IOException;

    int d(@n0 InputStream inputStream, @n0 b bVar) throws IOException;
}
