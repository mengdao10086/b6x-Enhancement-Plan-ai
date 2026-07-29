package mh;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes5.dex */
public class d extends Drawable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f41219b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f41221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f41222e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f41218a = new Paint(2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41220c = 255;

    public d(Bitmap bitmap) {
        b(bitmap);
    }

    public Bitmap a() {
        return this.f41219b;
    }

    public void b(Bitmap bitmap) {
        this.f41219b = bitmap;
        if (bitmap != null) {
            this.f41221d = bitmap.getWidth();
            this.f41222e = this.f41219b.getHeight();
        } else {
            this.f41222e = 0;
            this.f41221d = 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f41219b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.f41219b, (Rect) null, getBounds(), this.f41218a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f41220c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f41222e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f41221d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f41222e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f41221d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f41220c = i10;
        this.f41218a.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f41218a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z10) {
        this.f41218a.setFilterBitmap(z10);
    }
}
