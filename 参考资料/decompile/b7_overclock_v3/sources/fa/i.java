package fa;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.flydigi.data.DataConstant;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.d0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ6\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\tH\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¨\u0006\u001c"}, d2 = {"Lfa/i;", "", "Ljava/io/File;", "imageFile", "", "reqWidth", "reqHeight", "Landroid/graphics/Bitmap$CompressFormat;", "compressFormat", "", "quality", "", "destinationPath", "c", "Landroid/graphics/Bitmap;", "d", "Landroid/graphics/BitmapFactory$Options;", "options", "a", "candidate", "targetOptions", "", "b", "Landroid/graphics/Bitmap$Config;", DataConstant.CONFIG_FOLDER, "e", "<init>", "()V", "imagepicker_release"}, k = 1, mv = {1, 5, 1})
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final i f28011a = new i();

    @d0(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f28012a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            iArr[Bitmap.Config.RGB_565.ordinal()] = 2;
            iArr[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            iArr[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            f28012a = iArr;
        }
    }

    public final int a(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        if (i12 <= i11 && i13 <= i10) {
            return 1;
        }
        int i14 = 2;
        int i15 = i12 / 2;
        int i16 = i13 / 2;
        while (i15 / i14 >= i11 && i16 / i14 >= i10) {
            i14 *= 2;
        }
        return i14;
    }

    public final boolean b(Bitmap bitmap, BitmapFactory.Options options) {
        int i10 = options.outWidth;
        int i11 = options.inSampleSize;
        int i12 = (i10 / i11) * (options.outHeight / i11);
        Bitmap.Config config = bitmap.getConfig();
        f0.o(config, "candidate.config");
        return i12 * e(config) <= bitmap.getAllocationByteCount();
    }

    @yt.k
    public final File c(@yt.k File imageFile, float f10, float f11, @yt.k Bitmap.CompressFormat compressFormat, int i10, @yt.k String destinationPath) throws Throwable {
        FileOutputStream fileOutputStream;
        f0.p(imageFile, "imageFile");
        f0.p(compressFormat, "compressFormat");
        f0.p(destinationPath, "destinationPath");
        File parentFile = new File(destinationPath).getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(destinationPath);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            Bitmap bitmapD = d(imageFile, f10, f11);
            f0.m(bitmapD);
            bitmapD.compress(compressFormat, i10, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return new File(destinationPath);
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                fileOutputStream2.flush();
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    public final Bitmap d(File file, float f10, float f11) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        int i10 = options.outHeight;
        int i11 = options.outWidth;
        float f12 = i11;
        float f13 = i10;
        float f14 = f12 / f13;
        float f15 = f10 / f11;
        if (f13 > f11 || f12 > f10) {
            if (f14 < f15) {
                i11 = (int) ((f11 / f13) * f12);
                i10 = (int) f11;
            } else {
                if (f14 > f15) {
                    f11 = (f10 / f12) * f13;
                }
                i10 = (int) f11;
                i11 = (int) f10;
            }
        }
        options.inSampleSize = a(options, i11, i10);
        options.inJustDecodeBounds = false;
        if (bitmapDecodeFile != null && b(bitmapDecodeFile, options)) {
            options.inMutable = true;
            options.inBitmap = bitmapDecodeFile;
        }
        options.inTempStorage = new byte[16384];
        try {
            bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        } catch (OutOfMemoryError e10) {
            e10.printStackTrace();
        }
        Bitmap bitmapCreateBitmap = null;
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(i11, i10, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e11) {
            e11.printStackTrace();
        }
        Bitmap bitmap = bitmapCreateBitmap;
        float f16 = i11;
        float f17 = f16 / options.outWidth;
        float f18 = i10;
        float f19 = f18 / options.outHeight;
        float f20 = f16 / 2.0f;
        float f21 = f18 / 2.0f;
        Matrix matrix = new Matrix();
        matrix.setScale(f17, f19, f20, f21);
        f0.m(bitmap);
        Canvas canvas = new Canvas(bitmap);
        canvas.setMatrix(matrix);
        f0.m(bitmapDecodeFile);
        canvas.drawBitmap(bitmapDecodeFile, f20 - (bitmapDecodeFile.getWidth() / 2), f21 - (bitmapDecodeFile.getHeight() / 2), new Paint(2));
        bitmapDecodeFile.recycle();
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), new Matrix(), true);
    }

    public final int e(Bitmap.Config config) {
        int i10 = a.f28012a[config.ordinal()];
        if (i10 != 1) {
            return (i10 == 2 || i10 == 3) ? 2 : 1;
        }
        return 4;
    }
}
