package oj;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class a extends Drawable implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f43403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f43404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f43405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f43406d;

    public a(Bitmap bitmap) {
        this.f43403a = bitmap;
        if (bitmap != null) {
            this.f43405c = bitmap.getWidth();
            this.f43406d = this.f43403a.getHeight();
        } else {
            this.f43405c = 0;
            this.f43406d = 0;
        }
        Paint paint = new Paint();
        this.f43404b = paint;
        paint.setDither(true);
        this.f43404b.setFilterBitmap(true);
    }

    @Override // oj.b
    public Bitmap a() {
        return this.f43403a;
    }

    public Paint b() {
        return this.f43404b;
    }

    public void c(boolean z10) {
        this.f43404b.setAntiAlias(z10);
        invalidateSelf();
    }

    public void d(Bitmap bitmap) {
        this.f43403a = bitmap;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f43403a;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.f43403a, 0.0f, 0.0f, this.f43404b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f43406d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f43405c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f43406d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f43405c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f43404b.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f43404b.setColorFilter(colorFilter);
    }

    public a(Resources resources, InputStream inputStream) {
        this(BitmapFactory.decodeStream(inputStream));
    }
}
