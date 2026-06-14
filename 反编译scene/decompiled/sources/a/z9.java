package a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class z9 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f8047a = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static y9 f3804a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f3805a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f3806a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f3807a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Path f3809a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f3810a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f3812b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Paint f3813b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final int f3815c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Paint f3816c;
    public float d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3811a = true;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3814b = true;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f3817c = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f3808a = new Paint(5);

    public z9(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.f3812b = resources.getColor(m9.cardview_shadow_start_color);
        this.f3815c = resources.getColor(m9.cardview_shadow_end_color);
        this.f3806a = resources.getDimensionPixelSize(n9.cardview_compat_inset_shadow);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.f3813b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f3805a = (int) (f + 0.5f);
        this.f3810a = new RectF();
        Paint paint2 = new Paint(this.f3813b);
        this.f3816c = paint2;
        paint2.setAntiAlias(false);
        s(f2, f3);
    }

    public static float c(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f8047a) * ((double) f2))) : f;
    }

    public static float d(float f, float f2, boolean z) {
        float f3 = f * 1.5f;
        return z ? (float) (((double) f3) + ((1.0d - f8047a) * ((double) f2))) : f3;
    }

    public final void a(Rect rect) {
        float f = this.b;
        float f2 = 1.5f * f;
        this.f3810a.set(rect.left + f, rect.top + f2, rect.right - f, rect.bottom - f2);
        b();
    }

    public final void b() {
        float f = this.f3805a;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.c;
        rectF2.inset(-f2, -f2);
        Path path = this.f3809a;
        if (path == null) {
            this.f3809a = new Path();
        } else {
            path.reset();
        }
        this.f3809a.setFillType(Path.FillType.EVEN_ODD);
        this.f3809a.moveTo(-this.f3805a, 0.0f);
        this.f3809a.rLineTo(-this.c, 0.0f);
        this.f3809a.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f3809a.arcTo(rectF, 270.0f, -90.0f, false);
        this.f3809a.close();
        float f3 = this.f3805a;
        float f4 = f3 / (this.c + f3);
        Paint paint = this.f3813b;
        float f5 = this.f3805a + this.c;
        int i = this.f3812b;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f5, new int[]{i, i, this.f3815c}, new float[]{0.0f, f4, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f3816c;
        float f6 = this.f3805a;
        float f7 = this.c;
        int i2 = this.f3812b;
        paint2.setShader(new LinearGradient(0.0f, (-f6) + f7, 0.0f, (-f6) - f7, new int[]{i2, i2, this.f3815c}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f3816c.setAntiAlias(false);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f3811a) {
            a(getBounds());
            this.f3811a = false;
        }
        canvas.translate(0.0f, this.d / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.d) / 2.0f);
        f3804a.a(canvas, this.f3810a, this.f3805a, this.f3808a);
    }

    public final void e(Canvas canvas) {
        float f = this.f3805a;
        float f2 = (-f) - this.c;
        float f3 = f + this.f3806a + (this.d / 2.0f);
        float f4 = f3 * 2.0f;
        boolean z = this.f3810a.width() - f4 > 0.0f;
        boolean z2 = this.f3810a.height() - f4 > 0.0f;
        int iSave = canvas.save();
        RectF rectF = this.f3810a;
        canvas.translate(rectF.left + f3, rectF.top + f3);
        canvas.drawPath(this.f3809a, this.f3813b);
        if (z) {
            canvas.drawRect(0.0f, f2, this.f3810a.width() - f4, -this.f3805a, this.f3816c);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        RectF rectF2 = this.f3810a;
        canvas.translate(rectF2.right - f3, rectF2.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f3809a, this.f3813b);
        if (z) {
            canvas.drawRect(0.0f, f2, this.f3810a.width() - f4, (-this.f3805a) + this.c, this.f3816c);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        RectF rectF3 = this.f3810a;
        canvas.translate(rectF3.left + f3, rectF3.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f3809a, this.f3813b);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.f3810a.height() - f4, -this.f3805a, this.f3816c);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        RectF rectF4 = this.f3810a;
        canvas.translate(rectF4.right - f3, rectF4.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f3809a, this.f3813b);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.f3810a.height() - f4, -this.f3805a, this.f3816c);
        }
        canvas.restoreToCount(iSave4);
    }

    public ColorStateList f() {
        return this.f3807a;
    }

    public float g() {
        return this.f3805a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(d(this.b, this.f3805a, this.f3814b));
        int iCeil2 = (int) Math.ceil(c(this.b, this.f3805a, this.f3814b));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    public void h(Rect rect) {
        getPadding(rect);
    }

    public float i() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f3807a;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    public float j() {
        float f = this.b;
        return (Math.max(f, this.f3805a + this.f3806a + ((f * 1.5f) / 2.0f)) * 2.0f) + (((this.b * 1.5f) + this.f3806a) * 2.0f);
    }

    public float k() {
        float f = this.b;
        return (Math.max(f, this.f3805a + this.f3806a + (f / 2.0f)) * 2.0f) + ((this.b + this.f3806a) * 2.0f);
    }

    public float l() {
        return this.d;
    }

    public void m(boolean z) {
        this.f3814b = z;
        invalidateSelf();
    }

    public final void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f3807a = colorStateList;
        this.f3808a.setColor(colorStateList.getColorForState(getState(), this.f3807a.getDefaultColor()));
    }

    public void o(ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f3811a = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f3807a;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f3808a.getColor() == colorForState) {
            return false;
        }
        this.f3808a.setColor(colorForState);
        this.f3811a = true;
        invalidateSelf();
        return true;
    }

    public void p(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
        float f2 = (int) (f + 0.5f);
        if (this.f3805a == f2) {
            return;
        }
        this.f3805a = f2;
        this.f3811a = true;
        invalidateSelf();
    }

    public void q(float f) {
        s(this.d, f);
    }

    public void r(float f) {
        s(f, this.b);
    }

    public final void s(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        }
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        }
        float fT = t(f);
        float fT2 = t(f2);
        if (fT > fT2) {
            if (!this.f3817c) {
                this.f3817c = true;
            }
            fT = fT2;
        }
        if (this.d == fT && this.b == fT2) {
            return;
        }
        this.d = fT;
        this.b = fT2;
        this.c = (int) ((fT * 1.5f) + this.f3806a + 0.5f);
        this.f3811a = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f3808a.setAlpha(i);
        this.f3813b.setAlpha(i);
        this.f3816c.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3808a.setColorFilter(colorFilter);
    }

    public final int t(float f) {
        int i = (int) (f + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }
}
