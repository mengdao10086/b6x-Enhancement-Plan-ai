package m0;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import g.v0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    @yt.k
    public static final Bitmap a(@yt.k Bitmap bitmap, @yt.k ik.l<? super Canvas, z1> block) {
        kotlin.jvm.internal.f0.p(bitmap, "<this>");
        kotlin.jvm.internal.f0.p(block, "block");
        block.i(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean b(@yt.k Bitmap bitmap, @yt.k Point p10) {
        int i10;
        kotlin.jvm.internal.f0.p(bitmap, "<this>");
        kotlin.jvm.internal.f0.p(p10, "p");
        int width = bitmap.getWidth();
        int i11 = p10.x;
        return (i11 >= 0 && i11 < width) && (i10 = p10.y) >= 0 && i10 < bitmap.getHeight();
    }

    public static final boolean c(@yt.k Bitmap bitmap, @yt.k PointF p10) {
        kotlin.jvm.internal.f0.p(bitmap, "<this>");
        kotlin.jvm.internal.f0.p(p10, "p");
        float f10 = p10.x;
        if (f10 >= 0.0f && f10 < bitmap.getWidth()) {
            float f11 = p10.y;
            if (f11 >= 0.0f && f11 < bitmap.getHeight()) {
                return true;
            }
        }
        return false;
    }

    @yt.k
    public static final Bitmap d(int i10, int i11, @yt.k Bitmap.Config config) {
        kotlin.jvm.internal.f0.p(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, config);
        kotlin.jvm.internal.f0.o(bitmapCreateBitmap, "createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    @yt.k
    @SuppressLint({"ClassVerificationFailure"})
    @v0(26)
    public static final Bitmap e(int i10, int i11, @yt.k Bitmap.Config config, boolean z10, @yt.k ColorSpace colorSpace) {
        kotlin.jvm.internal.f0.p(config, "config");
        kotlin.jvm.internal.f0.p(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, config, z10, colorSpace);
        kotlin.jvm.internal.f0.o(bitmapCreateBitmap, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap f(int i10, int i11, Bitmap.Config config, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        kotlin.jvm.internal.f0.p(config, "config");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, config);
        kotlin.jvm.internal.f0.o(bitmapCreateBitmap, "createBitmap(width, height, config)");
        return bitmapCreateBitmap;
    }

    public static /* synthetic */ Bitmap g(int i10, int i11, Bitmap.Config config, boolean z10, ColorSpace colorSpace, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i12 & 8) != 0) {
            z10 = true;
        }
        if ((i12 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            kotlin.jvm.internal.f0.o(colorSpace, "get(ColorSpace.Named.SRGB)");
        }
        kotlin.jvm.internal.f0.p(config, "config");
        kotlin.jvm.internal.f0.p(colorSpace, "colorSpace");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, config, z10, colorSpace);
        kotlin.jvm.internal.f0.o(bitmapCreateBitmap, "createBitmap(width, heig…ig, hasAlpha, colorSpace)");
        return bitmapCreateBitmap;
    }

    public static final int h(@yt.k Bitmap bitmap, int i10, int i11) {
        kotlin.jvm.internal.f0.p(bitmap, "<this>");
        return bitmap.getPixel(i10, i11);
    }

    @yt.k
    public static final Bitmap i(@yt.k Bitmap bitmap, int i10, int i11, boolean z10) {
        kotlin.jvm.internal.f0.p(bitmap, "<this>");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i10, i11, z10);
        kotlin.jvm.internal.f0.o(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static /* synthetic */ Bitmap j(Bitmap bitmap, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            z10 = true;
        }
        kotlin.jvm.internal.f0.p(bitmap, "<this>");
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i10, i11, z10);
        kotlin.jvm.internal.f0.o(bitmapCreateScaledBitmap, "createScaledBitmap(this, width, height, filter)");
        return bitmapCreateScaledBitmap;
    }

    public static final void k(@yt.k Bitmap bitmap, int i10, int i11, @g.l int i12) {
        kotlin.jvm.internal.f0.p(bitmap, "<this>");
        bitmap.setPixel(i10, i11, i12);
    }
}
