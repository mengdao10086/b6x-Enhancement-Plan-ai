package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.v;
import g.i1;
import g.p0;
import g.v0;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f12606f = "Downsampler";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c4.d<DecodeFormat> f12607g = c4.d.g("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c4.d<PreferredColorSpace> f12608h = c4.d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Deprecated
    public static final c4.d<DownsampleStrategy> f12609i = DownsampleStrategy.f12538h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c4.d<Boolean> f12610j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final c4.d<Boolean> f12611k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f12612l = "image/vnd.wap.wbmp";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f12613m = "image/x-ico";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Set<String> f12614n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final b f12615o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Set<ImageHeaderParser.ImageType> f12616p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Queue<BitmapFactory.Options> f12617q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.e f12618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DisplayMetrics f12619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.b f12620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<ImageHeaderParser> f12621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u f12622e = u.d();

    public class a implements b {
        @Override // com.bumptech.glide.load.resource.bitmap.o.b
        public void a(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.o.b
        public void b() {
        }
    }

    public interface b {
        void a(com.bumptech.glide.load.engine.bitmap_recycle.e eVar, Bitmap bitmap) throws IOException;

        void b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        f12610j = c4.d.g("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f12611k = c4.d.g("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f12614n = Collections.unmodifiableSet(new HashSet(Arrays.asList(f12612l, f12613m)));
        f12615o = new a();
        f12616p = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f12617q = v4.o.f(0);
    }

    public o(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this.f12621d = list;
        this.f12619b = (DisplayMetrics) v4.m.d(displayMetrics);
        this.f12618a = (com.bumptech.glide.load.engine.bitmap_recycle.e) v4.m.d(eVar);
        this.f12620c = (com.bumptech.glide.load.engine.bitmap_recycle.b) v4.m.d(bVar);
    }

    public static int A(double d10) {
        return (int) (d10 + 0.5d);
    }

    @TargetApi(26)
    public static void B(BitmapFactory.Options options, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, int i10, int i11) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.g(i10, i11, config);
    }

    public static int a(double d10) {
        int iO = o(d10);
        int iA = A(((double) iO) * d10);
        return A((d10 / ((double) (iA / iO))) * ((double) iA));
    }

    public static void c(ImageHeaderParser.ImageType imageType, v vVar, b bVar, com.bumptech.glide.load.engine.bitmap_recycle.e eVar, DownsampleStrategy downsampleStrategy, int i10, int i11, int i12, int i13, int i14, BitmapFactory.Options options) throws IOException {
        int i15;
        int i16;
        int i17;
        int iFloor;
        double dFloor;
        int iRound;
        if (i11 <= 0 || i12 <= 0) {
            if (Log.isLoggable(f12606f, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to determine dimensions for: ");
                sb2.append(imageType);
                sb2.append(" with target [");
                sb2.append(i13);
                sb2.append("x");
                sb2.append(i14);
                sb2.append("]");
                return;
            }
            return;
        }
        if (u(i10)) {
            i16 = i11;
            i15 = i12;
        } else {
            i15 = i11;
            i16 = i12;
        }
        float fB = downsampleStrategy.b(i15, i16, i13, i14);
        if (fB <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + downsampleStrategy + ", source: [" + i11 + "x" + i12 + "], target: [" + i13 + "x" + i14 + "]");
        }
        DownsampleStrategy.SampleSizeRounding sampleSizeRoundingA = downsampleStrategy.a(i15, i16, i13, i14);
        if (sampleSizeRoundingA == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f10 = i15;
        float f11 = i16;
        int iA = i15 / A(fB * f10);
        int iA2 = i16 / A(fB * f11);
        DownsampleStrategy.SampleSizeRounding sampleSizeRounding = DownsampleStrategy.SampleSizeRounding.MEMORY;
        int iMax = sampleSizeRoundingA == sampleSizeRounding ? Math.max(iA, iA2) : Math.min(iA, iA2);
        int i18 = Build.VERSION.SDK_INT;
        if (i18 > 23 || !f12614n.contains(options.outMimeType)) {
            int iMax2 = Math.max(1, Integer.highestOneBit(iMax));
            if (sampleSizeRoundingA == sampleSizeRounding && iMax2 < 1.0f / fB) {
                iMax2 <<= 1;
            }
            i17 = iMax2;
        } else {
            i17 = 1;
        }
        options.inSampleSize = i17;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(i17, 8);
            iFloor = (int) Math.ceil(f10 / fMin);
            iRound = (int) Math.ceil(f11 / fMin);
            int i19 = i17 / 8;
            if (i19 > 0) {
                iFloor /= i19;
                iRound /= i19;
            }
        } else {
            if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                float f12 = i17;
                iFloor = (int) Math.floor(f10 / f12);
                dFloor = Math.floor(f11 / f12);
            } else if (imageType.isWebp()) {
                if (i18 >= 24) {
                    float f13 = i17;
                    iFloor = Math.round(f10 / f13);
                    iRound = Math.round(f11 / f13);
                } else {
                    float f14 = i17;
                    iFloor = (int) Math.floor(f10 / f14);
                    dFloor = Math.floor(f11 / f14);
                }
            } else if (i15 % i17 == 0 && i16 % i17 == 0) {
                iFloor = i15 / i17;
                iRound = i16 / i17;
            } else {
                int[] iArrP = p(vVar, options, bVar, eVar);
                iFloor = iArrP[0];
                iRound = iArrP[1];
            }
            iRound = (int) dFloor;
        }
        double dB = downsampleStrategy.b(iFloor, iRound, i13, i14);
        options.inTargetDensity = a(dB);
        options.inDensity = o(dB);
        if (v(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable(f12606f, 2)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Calculate scaling, source: [");
            sb3.append(i11);
            sb3.append("x");
            sb3.append(i12);
            sb3.append("], degreesToRotate: ");
            sb3.append(i10);
            sb3.append(", target: [");
            sb3.append(i13);
            sb3.append("x");
            sb3.append(i14);
            sb3.append("], power of two scaled: [");
            sb3.append(iFloor);
            sb3.append("x");
            sb3.append(iRound);
            sb3.append("], exact scale factor: ");
            sb3.append(fB);
            sb3.append(", power of 2 sample size: ");
            sb3.append(i17);
            sb3.append(", adjusted scale factor: ");
            sb3.append(dB);
            sb3.append(", target density: ");
            sb3.append(options.inTargetDensity);
            sb3.append(", density: ");
            sb3.append(options.inDensity);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap l(com.bumptech.glide.load.resource.bitmap.v r4, android.graphics.BitmapFactory.Options r5, com.bumptech.glide.load.resource.bitmap.o.b r6, com.bumptech.glide.load.engine.bitmap_recycle.e r7) throws java.io.IOException {
        /*
            boolean r0 = r5.inJustDecodeBounds
            if (r0 != 0) goto La
            r6.b()
            r4.c()
        La:
            int r0 = r5.outWidth
            int r1 = r5.outHeight
            java.lang.String r2 = r5.outMimeType
            java.util.concurrent.locks.Lock r3 = com.bumptech.glide.load.resource.bitmap.d0.i()
            r3.lock()
            android.graphics.Bitmap r4 = r4.b(r5)     // Catch: java.lang.Throwable -> L23 java.lang.IllegalArgumentException -> L25
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.resource.bitmap.d0.i()
            r5.unlock()
            return r4
        L23:
            r4 = move-exception
            goto L49
        L25:
            r3 = move-exception
            java.io.IOException r0 = x(r3, r0, r1, r2, r5)     // Catch: java.lang.Throwable -> L23
            java.lang.String r1 = "Downsampler"
            r2 = 3
            boolean r1 = android.util.Log.isLoggable(r1, r2)     // Catch: java.lang.Throwable -> L23
            android.graphics.Bitmap r1 = r5.inBitmap     // Catch: java.lang.Throwable -> L23
            if (r1 == 0) goto L48
            r7.e(r1)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L47
            r1 = 0
            r5.inBitmap = r1     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L47
            android.graphics.Bitmap r4 = l(r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L23 java.io.IOException -> L47
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.resource.bitmap.d0.i()
            r5.unlock()
            return r4
        L47:
            throw r0     // Catch: java.lang.Throwable -> L23
        L48:
            throw r0     // Catch: java.lang.Throwable -> L23
        L49:
            java.util.concurrent.locks.Lock r5 = com.bumptech.glide.load.resource.bitmap.d0.i()
            r5.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.o.l(com.bumptech.glide.load.resource.bitmap.v, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.o$b, com.bumptech.glide.load.engine.bitmap_recycle.e):android.graphics.Bitmap");
    }

    @p0
    @TargetApi(19)
    public static String m(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ee.a.f26979d);
    }

    public static synchronized BitmapFactory.Options n() {
        BitmapFactory.Options optionsPoll;
        Queue<BitmapFactory.Options> queue = f12617q;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            z(optionsPoll);
        }
        return optionsPoll;
    }

    public static int o(double d10) {
        if (d10 > 1.0d) {
            d10 = 1.0d / d10;
        }
        return (int) Math.round(d10 * 2.147483647E9d);
    }

    public static int[] p(v vVar, BitmapFactory.Options options, b bVar, com.bumptech.glide.load.engine.bitmap_recycle.e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        l(vVar, options, bVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public static String q(BitmapFactory.Options options) {
        return m(options.inBitmap);
    }

    public static boolean u(int i10) {
        return i10 == 90 || i10 == 270;
    }

    public static boolean v(BitmapFactory.Options options) {
        int i10;
        int i11 = options.inTargetDensity;
        return i11 > 0 && (i10 = options.inDensity) > 0 && i11 != i10;
    }

    public static void w(int i10, int i11, String str, BitmapFactory.Options options, Bitmap bitmap, int i12, int i13, long j10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Decoded ");
        sb2.append(m(bitmap));
        sb2.append(" from [");
        sb2.append(i10);
        sb2.append("x");
        sb2.append(i11);
        sb2.append("] ");
        sb2.append(str);
        sb2.append(" with inBitmap ");
        sb2.append(q(options));
        sb2.append(" for [");
        sb2.append(i12);
        sb2.append("x");
        sb2.append(i13);
        sb2.append("], sample size: ");
        sb2.append(options.inSampleSize);
        sb2.append(", density: ");
        sb2.append(options.inDensity);
        sb2.append(", target density: ");
        sb2.append(options.inTargetDensity);
        sb2.append(", thread: ");
        sb2.append(Thread.currentThread().getName());
        sb2.append(", duration: ");
        sb2.append(v4.i.a(j10));
    }

    public static IOException x(IllegalArgumentException illegalArgumentException, int i10, int i11, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i10 + ", outHeight: " + i11 + ", outMimeType: " + str + ", inBitmap: " + q(options), illegalArgumentException);
    }

    public static void y(BitmapFactory.Options options) {
        z(options);
        Queue<BitmapFactory.Options> queue = f12617q;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    public static void z(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public final boolean C(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public final void b(v vVar, DecodeFormat decodeFormat, boolean z10, boolean z11, BitmapFactory.Options options, int i10, int i11) {
        if (this.f12622e.k(i10, i11, options, z10, z11)) {
            return;
        }
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        boolean zHasAlpha = false;
        try {
            zHasAlpha = vVar.d().hasAlpha();
        } catch (IOException unused) {
            if (Log.isLoggable(f12606f, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot determine whether the image has alpha or not from header, format ");
                sb2.append(decodeFormat);
            }
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    @v0(21)
    public com.bumptech.glide.load.engine.s<Bitmap> d(ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, c4.e eVar) throws IOException {
        return e(new v.e(parcelFileDescriptor, this.f12621d, this.f12620c), i10, i11, eVar, f12615o);
    }

    public final com.bumptech.glide.load.engine.s<Bitmap> e(v vVar, int i10, int i11, c4.e eVar, b bVar) throws IOException {
        byte[] bArr = (byte[]) this.f12620c.f(65536, byte[].class);
        BitmapFactory.Options optionsN = n();
        optionsN.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) eVar.c(f12607g);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) eVar.c(f12608h);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) eVar.c(DownsampleStrategy.f12538h);
        boolean zBooleanValue = ((Boolean) eVar.c(f12610j)).booleanValue();
        c4.d<Boolean> dVar = f12611k;
        try {
            return g.f(k(vVar, optionsN, downsampleStrategy, decodeFormat, preferredColorSpace, eVar.c(dVar) != null && ((Boolean) eVar.c(dVar)).booleanValue(), i10, i11, zBooleanValue, bVar), this.f12618a);
        } finally {
            y(optionsN);
            this.f12620c.put(bArr);
        }
    }

    public com.bumptech.glide.load.engine.s<Bitmap> f(InputStream inputStream, int i10, int i11, c4.e eVar) throws IOException {
        return g(inputStream, i10, i11, eVar, f12615o);
    }

    public com.bumptech.glide.load.engine.s<Bitmap> g(InputStream inputStream, int i10, int i11, c4.e eVar, b bVar) throws IOException {
        return e(new v.d(inputStream, this.f12621d, this.f12620c), i10, i11, eVar, bVar);
    }

    public com.bumptech.glide.load.engine.s<Bitmap> h(ByteBuffer byteBuffer, int i10, int i11, c4.e eVar) throws IOException {
        return e(new v.b(byteBuffer, this.f12621d, this.f12620c), i10, i11, eVar, f12615o);
    }

    @i1
    public void i(File file, int i10, int i11, c4.e eVar) throws IOException {
        e(new v.c(file, this.f12621d, this.f12620c), i10, i11, eVar, f12615o);
    }

    @i1
    public void j(byte[] bArr, int i10, int i11, c4.e eVar) throws IOException {
        e(new v.a(bArr, this.f12621d, this.f12620c), i10, i11, eVar, f12615o);
    }

    public final Bitmap k(v vVar, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z10, int i10, int i11, boolean z11, b bVar) throws IOException {
        int i12;
        int i13;
        String str;
        ColorSpace colorSpace;
        int iRound;
        int iRound2;
        long jB = v4.i.b();
        int[] iArrP = p(vVar, options, bVar, this.f12618a);
        boolean z12 = false;
        int i14 = iArrP[0];
        int i15 = iArrP[1];
        String str2 = options.outMimeType;
        boolean z13 = (i14 == -1 || i15 == -1) ? false : z10;
        int iA = vVar.a();
        int iJ = d0.j(iA);
        boolean zM = d0.m(iA);
        if (i10 == Integer.MIN_VALUE) {
            i12 = i11;
            i13 = u(iJ) ? i15 : i14;
        } else {
            i12 = i11;
            i13 = i10;
        }
        int i16 = i12 == Integer.MIN_VALUE ? u(iJ) ? i14 : i15 : i12;
        ImageHeaderParser.ImageType imageTypeD = vVar.d();
        c(imageTypeD, vVar, bVar, this.f12618a, downsampleStrategy, iJ, i14, i15, i13, i16, options);
        b(vVar, decodeFormat, z13, zM, options, i13, i16);
        int i17 = Build.VERSION.SDK_INT;
        int i18 = options.inSampleSize;
        if (C(imageTypeD)) {
            if (i14 < 0 || i15 < 0 || !z11) {
                float f10 = v(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i19 = options.inSampleSize;
                float f11 = i19;
                int iCeil = (int) Math.ceil(i14 / f11);
                int iCeil2 = (int) Math.ceil(i15 / f11);
                iRound = Math.round(iCeil * f10);
                iRound2 = Math.round(iCeil2 * f10);
                str = f12606f;
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Calculated target [");
                    sb2.append(iRound);
                    sb2.append("x");
                    sb2.append(iRound2);
                    sb2.append("] for source [");
                    sb2.append(i14);
                    sb2.append("x");
                    sb2.append(i15);
                    sb2.append("], sampleSize: ");
                    sb2.append(i19);
                    sb2.append(", targetDensity: ");
                    sb2.append(options.inTargetDensity);
                    sb2.append(", density: ");
                    sb2.append(options.inDensity);
                    sb2.append(", density multiplier: ");
                    sb2.append(f10);
                }
            } else {
                str = f12606f;
                iRound = i13;
                iRound2 = i16;
            }
            if (iRound > 0 && iRound2 > 0) {
                B(options, this.f12618a, iRound, iRound2);
            }
        } else {
            str = f12606f;
        }
        if (preferredColorSpace != null) {
            if (i17 >= 28) {
                if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) {
                    z12 = true;
                }
                options.inPreferredColorSpace = ColorSpace.get(z12 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
            } else if (i17 >= 26) {
                options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
        }
        Bitmap bitmapL = l(vVar, options, bVar, this.f12618a);
        bVar.a(this.f12618a, bitmapL);
        if (Log.isLoggable(str, 2)) {
            w(i14, i15, str2, options, bitmapL, i10, i11, jB);
        }
        Bitmap bitmapO = null;
        if (bitmapL != null) {
            bitmapL.setDensity(this.f12619b.densityDpi);
            bitmapO = d0.o(this.f12618a, bitmapL, iA);
            if (!bitmapL.equals(bitmapO)) {
                this.f12618a.e(bitmapL);
            }
        }
        return bitmapO;
    }

    public boolean r(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }

    public boolean s(InputStream inputStream) {
        return true;
    }

    public boolean t(ByteBuffer byteBuffer) {
        return true;
    }
}
