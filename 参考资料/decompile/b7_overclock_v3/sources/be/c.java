package be;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;
import g.f0;
import g.l;
import g.n0;
import g.p0;
import g.r;
import le.o;
import le.p;
import m0.g;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class c extends Drawable {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final float f9395q = 1.3333f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Paint f9397b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @r
    public float f9403h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public int f9404i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @l
    public int f9405j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @l
    public int f9406k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @l
    public int f9407l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @l
    public int f9408m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public o f9410o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public ColorStateList f9411p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f9396a = p.k();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f9398c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f9399d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RectF f9400e = new RectF();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f9401f = new RectF();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f9402g = new b();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f9409n = true;

    public class b extends Drawable.ConstantState {
        public b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @n0
        public Drawable newDrawable() {
            return c.this;
        }
    }

    public c(o oVar) {
        this.f9410o = oVar;
        Paint paint = new Paint(1);
        this.f9397b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @n0
    public final Shader a() {
        copyBounds(this.f9399d);
        float fHeight = this.f9403h / r0.height();
        return new LinearGradient(0.0f, r0.top, 0.0f, r0.bottom, new int[]{g.t(this.f9404i, this.f9408m), g.t(this.f9405j, this.f9408m), g.t(g.B(this.f9405j, 0), this.f9408m), g.t(g.B(this.f9407l, 0), this.f9408m), g.t(this.f9407l, this.f9408m), g.t(this.f9406k, this.f9408m)}, new float[]{0.0f, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP);
    }

    @n0
    public RectF b() {
        this.f9401f.set(getBounds());
        return this.f9401f;
    }

    public o c() {
        return this.f9410o;
    }

    public void d(@p0 ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f9408m = colorStateList.getColorForState(getState(), this.f9408m);
        }
        this.f9411p = colorStateList;
        this.f9409n = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@n0 Canvas canvas) {
        if (this.f9409n) {
            this.f9397b.setShader(a());
            this.f9409n = false;
        }
        float strokeWidth = this.f9397b.getStrokeWidth() / 2.0f;
        copyBounds(this.f9399d);
        this.f9400e.set(this.f9399d);
        float fMin = Math.min(this.f9410o.r().a(b()), this.f9400e.width() / 2.0f);
        if (this.f9410o.u(b())) {
            this.f9400e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f9400e, fMin, fMin, this.f9397b);
        }
    }

    public void e(@r float f10) {
        if (this.f9403h != f10) {
            this.f9403h = f10;
            this.f9397b.setStrokeWidth(f10 * 1.3333f);
            this.f9409n = true;
            invalidateSelf();
        }
    }

    public void f(@l int i10, @l int i11, @l int i12, @l int i13) {
        this.f9404i = i10;
        this.f9405j = i11;
        this.f9406k = i12;
        this.f9407l = i13;
    }

    public void g(o oVar) {
        this.f9410o = oVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @p0
    public Drawable.ConstantState getConstantState() {
        return this.f9402g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f9403h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@n0 Outline outline) {
        if (this.f9410o.u(b())) {
            outline.setRoundRect(getBounds(), this.f9410o.r().a(b()));
            return;
        }
        copyBounds(this.f9399d);
        this.f9400e.set(this.f9399d);
        this.f9396a.d(this.f9410o, 1.0f, this.f9400e, this.f9398c);
        if (this.f9398c.isConvex()) {
            outline.setConvexPath(this.f9398c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@n0 Rect rect) {
        if (!this.f9410o.u(b())) {
            return true;
        }
        int iRound = Math.round(this.f9403h);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f9411p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f9409n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f9411p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f9408m)) != this.f9408m) {
            this.f9409n = true;
            this.f9408m = colorForState;
        }
        if (this.f9409n) {
            invalidateSelf();
        }
        return this.f9409n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@f0(from = 0, to = or.a.f44396a) int i10) {
        this.f9397b.setAlpha(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@p0 ColorFilter colorFilter) {
        this.f9397b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
