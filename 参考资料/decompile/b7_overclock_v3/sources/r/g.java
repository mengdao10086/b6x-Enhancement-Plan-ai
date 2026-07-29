package r;

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
import androidx.cardview.R;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class g extends Drawable {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final double f47659q = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final float f47660r = 1.5f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static a f47661s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f47662a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f47664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint f47665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f47666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f47667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Path f47668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f47669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f47670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f47671j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ColorStateList f47672k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f47674m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f47675n;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f47673l = true;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f47676o = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f47677p = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f47663b = new Paint(5);

    public interface a {
        void a(Canvas canvas, RectF rectF, float f10, Paint paint);
    }

    public g(Resources resources, ColorStateList colorStateList, float f10, float f11, float f12) {
        this.f47674m = resources.getColor(R.color.cardview_shadow_start_color);
        this.f47675n = resources.getColor(R.color.cardview_shadow_end_color);
        this.f47662a = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        n(colorStateList);
        Paint paint = new Paint(5);
        this.f47664c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f47667f = (int) (f10 + 0.5f);
        this.f47666e = new RectF();
        Paint paint2 = new Paint(this.f47664c);
        this.f47665d = paint2;
        paint2.setAntiAlias(false);
        s(f11, f12);
    }

    public static float c(float f10, float f11, boolean z10) {
        return z10 ? (float) (((double) f10) + ((1.0d - f47659q) * ((double) f11))) : f10;
    }

    public static float d(float f10, float f11, boolean z10) {
        return z10 ? (float) (((double) (f10 * 1.5f)) + ((1.0d - f47659q) * ((double) f11))) : f10 * 1.5f;
    }

    public final void a(Rect rect) {
        float f10 = this.f47669h;
        float f11 = 1.5f * f10;
        this.f47666e.set(rect.left + f10, rect.top + f11, rect.right - f10, rect.bottom - f11);
        b();
    }

    public final void b() {
        float f10 = this.f47667f;
        RectF rectF = new RectF(-f10, -f10, f10, f10);
        RectF rectF2 = new RectF(rectF);
        float f11 = this.f47670i;
        rectF2.inset(-f11, -f11);
        Path path = this.f47668g;
        if (path == null) {
            this.f47668g = new Path();
        } else {
            path.reset();
        }
        this.f47668g.setFillType(Path.FillType.EVEN_ODD);
        this.f47668g.moveTo(-this.f47667f, 0.0f);
        this.f47668g.rLineTo(-this.f47670i, 0.0f);
        this.f47668g.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f47668g.arcTo(rectF, 270.0f, -90.0f, false);
        this.f47668g.close();
        float f12 = this.f47667f;
        float f13 = f12 / (this.f47670i + f12);
        Paint paint = this.f47664c;
        float f14 = this.f47667f + this.f47670i;
        int i10 = this.f47674m;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f14, new int[]{i10, i10, this.f47675n}, new float[]{0.0f, f13, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f47665d;
        float f15 = this.f47667f;
        float f16 = this.f47670i;
        int i11 = this.f47674m;
        paint2.setShader(new LinearGradient(0.0f, (-f15) + f16, 0.0f, (-f15) - f16, new int[]{i11, i11, this.f47675n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f47665d.setAntiAlias(false);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f47673l) {
            a(getBounds());
            this.f47673l = false;
        }
        canvas.translate(0.0f, this.f47671j / 2.0f);
        e(canvas);
        canvas.translate(0.0f, (-this.f47671j) / 2.0f);
        f47661s.a(canvas, this.f47666e, this.f47667f, this.f47663b);
    }

    public final void e(Canvas canvas) {
        float f10 = this.f47667f;
        float f11 = (-f10) - this.f47670i;
        float f12 = f10 + this.f47662a + (this.f47671j / 2.0f);
        float f13 = f12 * 2.0f;
        boolean z10 = this.f47666e.width() - f13 > 0.0f;
        boolean z11 = this.f47666e.height() - f13 > 0.0f;
        int iSave = canvas.save();
        RectF rectF = this.f47666e;
        canvas.translate(rectF.left + f12, rectF.top + f12);
        canvas.drawPath(this.f47668g, this.f47664c);
        if (z10) {
            canvas.drawRect(0.0f, f11, this.f47666e.width() - f13, -this.f47667f, this.f47665d);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        RectF rectF2 = this.f47666e;
        canvas.translate(rectF2.right - f12, rectF2.bottom - f12);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f47668g, this.f47664c);
        if (z10) {
            canvas.drawRect(0.0f, f11, this.f47666e.width() - f13, (-this.f47667f) + this.f47670i, this.f47665d);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        RectF rectF3 = this.f47666e;
        canvas.translate(rectF3.left + f12, rectF3.bottom - f12);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f47668g, this.f47664c);
        if (z11) {
            canvas.drawRect(0.0f, f11, this.f47666e.height() - f13, -this.f47667f, this.f47665d);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        RectF rectF4 = this.f47666e;
        canvas.translate(rectF4.right - f12, rectF4.top + f12);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f47668g, this.f47664c);
        if (z11) {
            canvas.drawRect(0.0f, f11, this.f47666e.height() - f13, -this.f47667f, this.f47665d);
        }
        canvas.restoreToCount(iSave4);
    }

    public ColorStateList f() {
        return this.f47672k;
    }

    public float g() {
        return this.f47667f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(d(this.f47669h, this.f47667f, this.f47676o));
        int iCeil2 = (int) Math.ceil(c(this.f47669h, this.f47667f, this.f47676o));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    public void h(Rect rect) {
        getPadding(rect);
    }

    public float i() {
        return this.f47669h;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f47672k;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    public float j() {
        float f10 = this.f47669h;
        return (Math.max(f10, this.f47667f + this.f47662a + ((f10 * 1.5f) / 2.0f)) * 2.0f) + (((this.f47669h * 1.5f) + this.f47662a) * 2.0f);
    }

    public float k() {
        float f10 = this.f47669h;
        return (Math.max(f10, this.f47667f + this.f47662a + (f10 / 2.0f)) * 2.0f) + ((this.f47669h + this.f47662a) * 2.0f);
    }

    public float l() {
        return this.f47671j;
    }

    public void m(boolean z10) {
        this.f47676o = z10;
        invalidateSelf();
    }

    public final void n(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f47672k = colorStateList;
        this.f47663b.setColor(colorStateList.getColorForState(getState(), this.f47672k.getDefaultColor()));
    }

    public void o(@p0 ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f47673l = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f47672k;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f47663b.getColor() == colorForState) {
            return false;
        }
        this.f47663b.setColor(colorForState);
        this.f47673l = true;
        invalidateSelf();
        return true;
    }

    public void p(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f10 + ". Must be >= 0");
        }
        float f11 = (int) (f10 + 0.5f);
        if (this.f47667f == f11) {
            return;
        }
        this.f47667f = f11;
        this.f47673l = true;
        invalidateSelf();
    }

    public void q(float f10) {
        s(this.f47671j, f10);
    }

    public void r(float f10) {
        s(f10, this.f47669h);
    }

    public final void s(float f10, float f11) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f10 + ". Must be >= 0");
        }
        if (f11 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f11 + ". Must be >= 0");
        }
        float fT = t(f10);
        float fT2 = t(f11);
        if (fT > fT2) {
            if (!this.f47677p) {
                this.f47677p = true;
            }
            fT = fT2;
        }
        if (this.f47671j == fT && this.f47669h == fT2) {
            return;
        }
        this.f47671j = fT;
        this.f47669h = fT2;
        this.f47670i = (int) ((fT * 1.5f) + this.f47662a + 0.5f);
        this.f47673l = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f47663b.setAlpha(i10);
        this.f47664c.setAlpha(i10);
        this.f47665d.setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f47663b.setColorFilter(colorFilter);
    }

    public final int t(float f10) {
        int i10 = (int) (f10 + 0.5f);
        return i10 % 2 == 1 ? i10 - 1 : i10;
    }
}
