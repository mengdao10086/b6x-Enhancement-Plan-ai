package qj;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import g.n0;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes5.dex */
public class d extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f47375c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f47376d = "jp.wasabeef.glide.transformations.GrayscaleTransformation.1";

    @Override // qj.a, c4.b
    public void a(@n0 MessageDigest messageDigest) {
        messageDigest.update(f47376d.getBytes(c4.b.f9745b));
    }

    @Override // qj.a
    public Bitmap c(@n0 Context context, @n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, int i10, int i11) {
        Bitmap bitmapF = eVar.f(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapF);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapF;
    }

    @Override // qj.a, c4.b
    public boolean equals(Object obj) {
        return obj instanceof d;
    }

    @Override // qj.a, c4.b
    public int hashCode() {
        return -1580689316;
    }

    public String toString() {
        return "GrayscaleTransformation()";
    }
}
