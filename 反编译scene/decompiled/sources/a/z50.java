package a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class z50 {
    public Bitmap a(Bitmap bitmap, float f) {
        float height = f / bitmap.getHeight();
        return b(bitmap, height, height);
    }

    public Bitmap b(Bitmap bitmap, float f, float f2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        return bitmapCreateBitmap != null ? bitmapCreateBitmap : bitmap;
    }

    public Bitmap c(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public Bitmap d(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 1;
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream, null, options);
            fileInputStream.close();
            return bitmapDecodeStream;
        } catch (Exception unused) {
            return null;
        }
    }

    public void e(Bitmap bitmap, String str, Boolean bool) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (bool.booleanValue()) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            } else {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
            }
            fileOutputStream.close();
            System.out.println("----------save success-------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
