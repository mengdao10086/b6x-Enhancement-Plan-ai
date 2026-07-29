package qj;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import g.n0;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes5.dex */
public class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f47369d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f47370e = "jp.wasabeef.glide.transformations.ColorFilterTransformation.1";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f47371c;

    public b(int i10) {
        this.f47371c = i10;
    }

    @Override // qj.a, c4.b
    public void a(@n0 MessageDigest messageDigest) {
        messageDigest.update((f47370e + this.f47371c).getBytes(c4.b.f9745b));
    }

    @Override // qj.a
    public Bitmap c(@n0 Context context, @n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, int i10, int i11) {
        Bitmap bitmapF = eVar.f(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapF);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColorFilter(new PorterDuffColorFilter(this.f47371c, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapF;
    }

    @Override // qj.a, c4.b
    public boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).f47371c == this.f47371c;
    }

    @Override // qj.a, c4.b
    public int hashCode() {
        return 705373712 + (this.f47371c * 10);
    }

    public String toString() {
        return "ColorFilterTransformation(color=" + this.f47371c + ee.a.f26979d;
    }
}
