package mh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.WindowManager;
import g.n0;
import g.p0;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41215a = "content";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f41216b = "BitmapLoadUtils";

    public static int a(@n0 BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        int i14 = 1;
        if (i12 > i11 || i13 > i10) {
            while (true) {
                if (i12 / i14 <= i11 && i13 / i14 <= i10) {
                    break;
                }
                i14 *= 2;
            }
        }
        return i14;
    }

    public static int b(@n0 Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        int iSqrt = (int) Math.sqrt(Math.pow(point.x, 2.0d) + Math.pow(point.y, 2.0d));
        Canvas canvas = new Canvas();
        int iMin = Math.min(canvas.getMaximumBitmapWidth(), canvas.getMaximumBitmapHeight());
        if (iMin > 0) {
            iSqrt = Math.min(iSqrt, iMin);
        }
        int iC = c.c();
        if (iC > 0) {
            iSqrt = Math.min(iSqrt, iC);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("maxBitmapSize: ");
        sb2.append(iSqrt);
        return iSqrt;
    }

    public static void c(@p0 Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void d(@n0 Context context, @n0 Uri uri, @p0 Uri uri2, int i10, int i11, jh.b bVar) {
        new lh.b(context, uri, uri2, i10, i11, bVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static int e(int i10) {
        switch (i10) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static int f(int i10) {
        return (i10 == 2 || i10 == 7 || i10 == 4 || i10 == 5) ? -1 : 1;
    }

    public static int g(@n0 Context context, @n0 Uri uri) {
        int iG = 0;
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                return 0;
            }
            iG = new f(inputStreamOpenInputStream).g();
            c(inputStreamOpenInputStream);
            return iG;
        } catch (IOException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getExifOrientation: ");
            sb2.append(uri.toString());
            return iG;
        }
    }

    public static boolean h(Uri uri) {
        return uri != null && "content".equals(uri.getScheme());
    }

    public static Bitmap i(@n0 Bitmap bitmap, @n0 Matrix matrix) {
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return !bitmap.sameAs(bitmapCreateBitmap) ? bitmapCreateBitmap : bitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }
}
