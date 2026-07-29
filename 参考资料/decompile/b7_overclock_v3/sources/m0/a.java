package m0;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import g.i1;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: m0.a$a, reason: collision with other inner class name */
    @v0(17)
    public static class C0449a {
        @g.u
        public static boolean a(Bitmap bitmap) {
            return bitmap.hasMipMap();
        }

        @g.u
        public static void b(Bitmap bitmap, boolean z10) {
            bitmap.setHasMipMap(z10);
        }
    }

    @v0(19)
    public static class b {
        @g.u
        public static int a(Bitmap bitmap) {
            return bitmap.getAllocationByteCount();
        }
    }

    @v0(27)
    public static class c {
        @g.u
        public static Bitmap a(Bitmap bitmap) {
            if (bitmap.getConfig() != Bitmap.Config.HARDWARE) {
                return bitmap;
            }
            Bitmap.Config configA = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT >= 31) {
                configA = e.a(bitmap);
            }
            return bitmap.copy(configA, true);
        }

        @g.u
        public static Bitmap b(int i10, int i11, Bitmap bitmap, boolean z10) {
            Bitmap.Config config = bitmap.getConfig();
            ColorSpace colorSpace = bitmap.getColorSpace();
            ColorSpace colorSpace2 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (z10 && !bitmap.getColorSpace().equals(colorSpace2)) {
                config = Bitmap.Config.RGBA_F16;
                colorSpace = colorSpace2;
            } else if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
                config = Bitmap.Config.ARGB_8888;
                if (Build.VERSION.SDK_INT >= 31) {
                    config = e.a(bitmap);
                }
            }
            return Bitmap.createBitmap(i10, i11, config, bitmap.hasAlpha(), colorSpace);
        }

        @g.u
        public static boolean c(Bitmap bitmap) {
            return bitmap.getConfig() == Bitmap.Config.RGBA_F16 && bitmap.getColorSpace().equals(ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB));
        }
    }

    @v0(29)
    public static class d {
        @g.u
        public static void a(Paint paint) {
            paint.setBlendMode(BlendMode.SRC);
        }
    }

    @v0(31)
    public static class e {
        @g.u
        public static Bitmap.Config a(Bitmap bitmap) {
            return bitmap.getHardwareBuffer().getFormat() == 22 ? Bitmap.Config.RGBA_F16 : Bitmap.Config.ARGB_8888;
        }
    }

    @n0
    public static Bitmap a(@n0 Bitmap bitmap, int i10, int i11, @p0 Rect rect, boolean z10) {
        Paint paint;
        double dFloor;
        Paint paint2;
        int i12;
        Rect rect2;
        Bitmap bitmapCreateBitmap;
        if (i10 <= 0 || i11 <= 0) {
            throw new IllegalArgumentException("dstW and dstH must be > 0!");
        }
        if (rect != null && (rect.isEmpty() || rect.left < 0 || rect.right > bitmap.getWidth() || rect.top < 0 || rect.bottom > bitmap.getHeight())) {
            throw new IllegalArgumentException("srcRect must be contained by srcBm!");
        }
        int i13 = Build.VERSION.SDK_INT;
        Bitmap bitmapA = i13 >= 27 ? c.a(bitmap) : bitmap;
        int iWidth = rect != null ? rect.width() : bitmap.getWidth();
        int iHeight = rect != null ? rect.height() : bitmap.getHeight();
        float f10 = i10 / iWidth;
        float f11 = i11 / iHeight;
        int i14 = rect != null ? rect.left : 0;
        int i15 = rect != null ? rect.top : 0;
        if (i14 == 0 && i15 == 0 && i10 == bitmap.getWidth() && i11 == bitmap.getHeight()) {
            return (bitmap.isMutable() && bitmap == bitmapA) ? bitmap.copy(bitmap.getConfig(), true) : bitmapA;
        }
        Paint paint3 = new Paint(1);
        paint3.setFilterBitmap(true);
        if (i13 >= 29) {
            d.a(paint3);
        } else {
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }
        if (iWidth == i10 && iHeight == i11) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i10, i11, bitmapA.getConfig());
            new Canvas(bitmapCreateBitmap2).drawBitmap(bitmapA, -i14, -i15, paint3);
            return bitmapCreateBitmap2;
        }
        double dLog = Math.log(2.0d);
        if (f10 > 1.0f) {
            paint = paint3;
            dFloor = Math.ceil(Math.log(f10) / dLog);
        } else {
            paint = paint3;
            dFloor = Math.floor(Math.log(f10) / dLog);
        }
        int i16 = (int) dFloor;
        int iCeil = (int) (f11 > 1.0f ? Math.ceil(Math.log(f11) / dLog) : Math.floor(Math.log(f11) / dLog));
        Bitmap bitmap2 = null;
        if (!z10 || i13 < 27 || c.c(bitmap)) {
            paint2 = paint;
            i12 = 0;
        } else {
            Bitmap bitmapB = c.b(i16 > 0 ? e(iWidth, i10, 1, i16) : iWidth, iCeil > 0 ? e(iHeight, i11, 1, iCeil) : iHeight, bitmap, true);
            paint2 = paint;
            new Canvas(bitmapB).drawBitmap(bitmapA, -i14, -i15, paint2);
            i15 = 0;
            i14 = 0;
            i12 = 1;
            bitmap2 = bitmapA;
            bitmapA = bitmapB;
        }
        Rect rect3 = new Rect(i14, i15, iWidth, iHeight);
        Rect rect4 = new Rect();
        int i17 = i16;
        int i18 = iCeil;
        while (true) {
            if (i17 == 0 && i18 == 0) {
                break;
            }
            if (i17 < 0) {
                i17++;
            } else if (i17 > 0) {
                i17--;
            }
            if (i18 < 0) {
                i18++;
            } else if (i18 > 0) {
                i18--;
            }
            int i19 = i18;
            Paint paint4 = paint2;
            Rect rect5 = rect3;
            rect4.set(0, 0, e(iWidth, i10, i17, i16), e(iHeight, i11, i19, iCeil));
            boolean z11 = i17 == 0 && i19 == 0;
            boolean z12 = bitmap2 != null && bitmap2.getWidth() == i10 && bitmap2.getHeight() == i11;
            if (bitmap2 == null || bitmap2 == bitmap) {
                rect2 = rect4;
            } else {
                if (z10) {
                    rect2 = rect4;
                    if (Build.VERSION.SDK_INT < 27 || c.c(bitmap2)) {
                    }
                    Rect rect6 = rect2;
                    new Canvas(bitmapCreateBitmap).drawBitmap(bitmapA, rect5, rect6, paint4);
                    rect5.set(rect6);
                    i18 = i19;
                    Bitmap bitmap3 = bitmapA;
                    bitmapA = bitmapCreateBitmap;
                    rect4 = rect6;
                    rect3 = rect5;
                    paint2 = paint4;
                    bitmap2 = bitmap3;
                } else {
                    rect2 = rect4;
                }
                if (!z11 || (z12 && i12 == 0)) {
                    bitmapCreateBitmap = bitmap2;
                }
                Rect rect62 = rect2;
                new Canvas(bitmapCreateBitmap).drawBitmap(bitmapA, rect5, rect62, paint4);
                rect5.set(rect62);
                i18 = i19;
                Bitmap bitmap32 = bitmapA;
                bitmapA = bitmapCreateBitmap;
                rect4 = rect62;
                rect3 = rect5;
                paint2 = paint4;
                bitmap2 = bitmap32;
            }
            if (bitmap2 != bitmap && bitmap2 != null) {
                bitmap2.recycle();
            }
            int iE = e(iWidth, i10, i17 > 0 ? i12 : i17, i16);
            int iE2 = e(iHeight, i11, i19 > 0 ? i12 : i19, iCeil);
            if (Build.VERSION.SDK_INT >= 27) {
                bitmapCreateBitmap = c.b(iE, iE2, bitmap, z10 && !z11);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(iE, iE2, bitmapA.getConfig());
            }
            Rect rect622 = rect2;
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapA, rect5, rect622, paint4);
            rect5.set(rect622);
            i18 = i19;
            Bitmap bitmap322 = bitmapA;
            bitmapA = bitmapCreateBitmap;
            rect4 = rect622;
            rect3 = rect5;
            paint2 = paint4;
            bitmap2 = bitmap322;
        }
        if (bitmap2 != bitmap && bitmap2 != null) {
            bitmap2.recycle();
        }
        return bitmapA;
    }

    public static int b(@n0 Bitmap bitmap) {
        return b.a(bitmap);
    }

    public static boolean c(@n0 Bitmap bitmap) {
        return C0449a.a(bitmap);
    }

    public static void d(@n0 Bitmap bitmap, boolean z10) {
        C0449a.b(bitmap, z10);
    }

    @i1
    public static int e(int i10, int i11, int i12, int i13) {
        return i12 == 0 ? i11 : i12 > 0 ? i10 * (1 << (i13 - i12)) : i11 << ((-i12) - 1);
    }
}
