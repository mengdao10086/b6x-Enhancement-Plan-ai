package rg;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f48773a;

    public d() {
        Paint paint = new Paint();
        this.f48773a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f48773a.setAntiAlias(true);
        this.f48773a.setColor(-5592406);
    }

    public void a(int i10) {
        this.f48773a.setColor(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f48773a.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f48773a.setColorFilter(colorFilter);
    }
}
