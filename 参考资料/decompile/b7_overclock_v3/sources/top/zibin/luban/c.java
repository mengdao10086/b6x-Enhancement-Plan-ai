package top.zibin.luban;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f51526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f51527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f51528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f51529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f51530e;

    public c(d dVar, File file, boolean z10) throws IOException {
        this.f51527b = file;
        this.f51526a = dVar;
        this.f51530e = z10;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeStream(dVar.open(), null, options);
        this.f51528c = options.outWidth;
        this.f51529d = options.outHeight;
    }

    public File a() throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = b();
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.f51526a.open(), null, options);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Checker checker = Checker.SINGLE;
        if (checker.isJPG(this.f51526a.open())) {
            bitmapDecodeStream = c(bitmapDecodeStream, checker.getOrientation(this.f51526a.open()));
        }
        bitmapDecodeStream.compress(this.f51530e ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, 60, byteArrayOutputStream);
        bitmapDecodeStream.recycle();
        FileOutputStream fileOutputStream = new FileOutputStream(this.f51527b);
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();
        byteArrayOutputStream.close();
        return this.f51527b;
    }

    public final int b() {
        int i10 = this.f51528c;
        if (i10 % 2 == 1) {
            i10++;
        }
        this.f51528c = i10;
        int i11 = this.f51529d;
        if (i11 % 2 == 1) {
            i11++;
        }
        this.f51529d = i11;
        int iMax = Math.max(i10, i11);
        float fMin = Math.min(this.f51528c, this.f51529d) / iMax;
        if (fMin > 1.0f || fMin <= 0.5625d) {
            double d10 = fMin;
            if (d10 > 0.5625d || d10 <= 0.5d) {
                return (int) Math.ceil(((double) iMax) / (1280.0d / d10));
            }
            int i12 = iMax / 1280;
            if (i12 == 0) {
                return 1;
            }
            return i12;
        }
        if (iMax < 1664) {
            return 1;
        }
        if (iMax < 4990) {
            return 2;
        }
        if (iMax > 4990 && iMax < 10240) {
            return 4;
        }
        int i13 = iMax / 1280;
        if (i13 == 0) {
            return 1;
        }
        return i13;
    }

    public final Bitmap c(Bitmap bitmap, int i10) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i10);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
