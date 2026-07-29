package qj;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import g.n0;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes5.dex */
public class e extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f47377d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f47378e = "jp.wasabeef.glide.transformations.MaskTransformation.1";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Paint f47379f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f47380c;

    static {
        Paint paint = new Paint();
        f47379f = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public e(int i10) {
        this.f47380c = i10;
    }

    @Override // qj.a, c4.b
    public void a(@n0 MessageDigest messageDigest) {
        messageDigest.update((f47378e + this.f47380c).getBytes(c4.b.f9745b));
    }

    @Override // qj.a
    public Bitmap c(@n0 Context context, @n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, int i10, int i11) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapF = eVar.f(width, height, Bitmap.Config.ARGB_8888);
        bitmapF.setHasAlpha(true);
        Drawable drawableA = rj.a.a(context.getApplicationContext(), this.f47380c);
        Canvas canvas = new Canvas(bitmapF);
        drawableA.setBounds(0, 0, width, height);
        drawableA.draw(canvas);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, f47379f);
        return bitmapF;
    }

    @Override // qj.a, c4.b
    public boolean equals(Object obj) {
        return (obj instanceof e) && ((e) obj).f47380c == this.f47380c;
    }

    @Override // qj.a, c4.b
    public int hashCode() {
        return (-1949385457) + (this.f47380c * 10);
    }

    public String toString() {
        return "MaskTransformation(maskId=" + this.f47380c + ee.a.f26979d;
    }
}
