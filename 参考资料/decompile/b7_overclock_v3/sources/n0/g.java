package n0;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends Drawable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f41720n = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f41721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f41722b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BitmapShader f41725e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f41727g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f41731k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f41732l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f41733m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f41723c = 119;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f41724d = new Paint(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Matrix f41726f = new Matrix();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Rect f41728h = new Rect();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f41729i = new RectF();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f41730j = true;

    public g(Resources resources, Bitmap bitmap) {
        this.f41722b = 160;
        if (resources != null) {
            this.f41722b = resources.getDisplayMetrics().densityDpi;
        }
        this.f41721a = bitmap;
        if (bitmap != null) {
            a();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f41725e = new BitmapShader(bitmap, tileMode, tileMode);
        } else {
            this.f41733m = -1;
            this.f41732l = -1;
            this.f41725e = null;
        }
    }

    public static boolean j(float f10) {
        return f10 > 0.05f;
    }

    public final void a() {
        this.f41732l = this.f41721a.getScaledWidth(this.f41722b);
        this.f41733m = this.f41721a.getScaledHeight(this.f41722b);
    }

    @p0
    public final Bitmap b() {
        return this.f41721a;
    }

    public float c() {
        return this.f41727g;
    }

    public int d() {
        return this.f41723c;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@n0 Canvas canvas) {
        Bitmap bitmap = this.f41721a;
        if (bitmap == null) {
            return;
        }
        t();
        if (this.f41724d.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.f41728h, this.f41724d);
            return;
        }
        RectF rectF = this.f41729i;
        float f10 = this.f41727g;
        canvas.drawRoundRect(rectF, f10, f10, this.f41724d);
    }

    @n0
    public final Paint e() {
        return this.f41724d;
    }

    public void f(int i10, int i11, int i12, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    public boolean g() {
        return this.f41724d.isAntiAlias();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f41724d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f41724d.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f41733m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f41732l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        return (this.f41723c != 119 || this.f41731k || (bitmap = this.f41721a) == null || bitmap.hasAlpha() || this.f41724d.getAlpha() < 255 || j(this.f41727g)) ? -3 : -1;
    }

    public boolean h() {
        throw new UnsupportedOperationException();
    }

    public boolean i() {
        return this.f41731k;
    }

    public void k(boolean z10) {
        this.f41724d.setAntiAlias(z10);
        invalidateSelf();
    }

    public void l(boolean z10) {
        this.f41731k = z10;
        this.f41730j = true;
        if (!z10) {
            m(0.0f);
            return;
        }
        s();
        this.f41724d.setShader(this.f41725e);
        invalidateSelf();
    }

    public void m(float f10) {
        if (this.f41727g == f10) {
            return;
        }
        this.f41731k = false;
        if (j(f10)) {
            this.f41724d.setShader(this.f41725e);
        } else {
            this.f41724d.setShader(null);
        }
        this.f41727g = f10;
        invalidateSelf();
    }

    public void n(int i10) {
        if (this.f41723c != i10) {
            this.f41723c = i10;
            this.f41730j = true;
            invalidateSelf();
        }
    }

    public void o(boolean z10) {
        throw new UnsupportedOperationException();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@n0 Rect rect) {
        super.onBoundsChange(rect);
        if (this.f41731k) {
            s();
        }
        this.f41730j = true;
    }

    public void p(int i10) {
        if (this.f41722b != i10) {
            if (i10 == 0) {
                i10 = 160;
            }
            this.f41722b = i10;
            if (this.f41721a != null) {
                a();
            }
            invalidateSelf();
        }
    }

    public void q(@n0 Canvas canvas) {
        p(canvas.getDensity());
    }

    public void r(@n0 DisplayMetrics displayMetrics) {
        p(displayMetrics.densityDpi);
    }

    public final void s() {
        this.f41727g = Math.min(this.f41733m, this.f41732l) / 2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (i10 != this.f41724d.getAlpha()) {
            this.f41724d.setAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f41724d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        this.f41724d.setDither(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z10) {
        this.f41724d.setFilterBitmap(z10);
        invalidateSelf();
    }

    public void t() {
        if (this.f41730j) {
            if (this.f41731k) {
                int iMin = Math.min(this.f41732l, this.f41733m);
                f(this.f41723c, iMin, iMin, getBounds(), this.f41728h);
                int iMin2 = Math.min(this.f41728h.width(), this.f41728h.height());
                this.f41728h.inset(Math.max(0, (this.f41728h.width() - iMin2) / 2), Math.max(0, (this.f41728h.height() - iMin2) / 2));
                this.f41727g = iMin2 * 0.5f;
            } else {
                f(this.f41723c, this.f41732l, this.f41733m, getBounds(), this.f41728h);
            }
            this.f41729i.set(this.f41728h);
            if (this.f41725e != null) {
                Matrix matrix = this.f41726f;
                RectF rectF = this.f41729i;
                matrix.setTranslate(rectF.left, rectF.top);
                this.f41726f.preScale(this.f41729i.width() / this.f41721a.getWidth(), this.f41729i.height() / this.f41721a.getHeight());
                this.f41725e.setLocalMatrix(this.f41726f);
                this.f41724d.setShader(this.f41725e);
            }
            this.f41730j = false;
        }
    }
}
