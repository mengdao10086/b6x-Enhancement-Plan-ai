package a;

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

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class x9 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f7864a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f3552a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuffColorFilter f3555a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f3556a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f3557a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ColorStateList f3559b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3558a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3560b = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuff.Mode f3554a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f3553a = new Paint(5);

    public x9(ColorStateList colorStateList, float f) {
        this.f7864a = f;
        e(colorStateList);
        this.f3557a = new RectF();
        this.f3556a = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public ColorStateList b() {
        return this.f3552a;
    }

    public float c() {
        return this.b;
    }

    public float d() {
        return this.f7864a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f3553a;
        if (this.f3555a == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f3555a);
            z = true;
        }
        RectF rectF = this.f3557a;
        float f = this.f7864a;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    public final void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f3552a = colorStateList;
        this.f3553a.setColor(colorStateList.getColorForState(getState(), this.f3552a.getDefaultColor()));
    }

    public void f(ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    public void g(float f, boolean z, boolean z2) {
        if (f == this.b && this.f3558a == z && this.f3560b == z2) {
            return;
        }
        this.b = f;
        this.f3558a = z;
        this.f3560b = z2;
        i(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f3556a, this.f7864a);
    }

    public void h(float f) {
        if (f == this.f7864a) {
            return;
        }
        this.f7864a = f;
        i(null);
        invalidateSelf();
    }

    public final void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f3557a.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f3556a.set(rect);
        if (this.f3558a) {
            this.f3556a.inset((int) Math.ceil(z9.c(this.b, this.f7864a, this.f3560b)), (int) Math.ceil(z9.d(this.b, this.f7864a, this.f3560b)));
            this.f3557a.set(this.f3556a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f3559b;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f3552a) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f3552a;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f3553a.getColor();
        if (z) {
            this.f3553a.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f3559b;
        if (colorStateList2 == null || (mode = this.f3554a) == null) {
            return z;
        }
        this.f3555a = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f3553a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3553a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f3559b = colorStateList;
        this.f3555a = a(colorStateList, this.f3554a);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f3554a = mode;
        this.f3555a = a(this.f3559b, mode);
        invalidateSelf();
    }
}
