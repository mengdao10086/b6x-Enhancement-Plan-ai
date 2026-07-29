package r;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@v0(21)
public class f extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f47648a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f47650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f47651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f47652e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ColorStateList f47655h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public PorterDuffColorFilter f47656i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ColorStateList f47657j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f47653f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f47654g = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f47658k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f47649b = new Paint(5);

    public f(ColorStateList colorStateList, float f10) {
        this.f47648a = f10;
        e(colorStateList);
        this.f47650c = new RectF();
        this.f47651d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public ColorStateList b() {
        return this.f47655h;
    }

    public float c() {
        return this.f47652e;
    }

    public float d() {
        return this.f47648a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z10;
        Paint paint = this.f47649b;
        if (this.f47656i == null || paint.getColorFilter() != null) {
            z10 = false;
        } else {
            paint.setColorFilter(this.f47656i);
            z10 = true;
        }
        RectF rectF = this.f47650c;
        float f10 = this.f47648a;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        if (z10) {
            paint.setColorFilter(null);
        }
    }

    public final void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f47655h = colorStateList;
        this.f47649b.setColor(colorStateList.getColorForState(getState(), this.f47655h.getDefaultColor()));
    }

    public void f(@p0 ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    public void g(float f10, boolean z10, boolean z11) {
        if (f10 == this.f47652e && this.f47653f == z10 && this.f47654g == z11) {
            return;
        }
        this.f47652e = f10;
        this.f47653f = z10;
        this.f47654g = z11;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f47651d, this.f47648a);
    }

    public void h(float f10) {
        if (f10 == this.f47648a) {
            return;
        }
        this.f47648a = f10;
        i(null);
        invalidateSelf();
    }

    public final void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f47650c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f47651d.set(rect);
        if (this.f47653f) {
            this.f47651d.inset((int) Math.ceil(g.c(this.f47652e, this.f47648a, this.f47654g)), (int) Math.ceil(g.d(this.f47652e, this.f47648a, this.f47654g)));
            this.f47650c.set(this.f47651d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f47657j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f47655h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f47655h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z10 = colorForState != this.f47649b.getColor();
        if (z10) {
            this.f47649b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f47657j;
        if (colorStateList2 == null || (mode = this.f47658k) == null) {
            return z10;
        }
        this.f47656i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f47649b.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f47649b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f47657j = colorStateList;
        this.f47656i = a(colorStateList, this.f47658k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f47658k = mode;
        this.f47656i = a(this.f47657j, mode);
        invalidateSelf();
    }
}
