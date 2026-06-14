package a;

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

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class xw extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f7923a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f3613a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public nz f3614a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f3617a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f3618a;
    public int b;
    public int c;
    public int d;
    public int e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final rz f3615a = new rz();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Path f3619a = new Path();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f3620a = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f3621a = new RectF();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final RectF f3623b = new RectF();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ww f3616a = new ww(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3622a = true;

    public xw(nz nzVar) {
        this.f3614a = nzVar;
        Paint paint = new Paint(1);
        this.f3618a = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    public final Shader a() {
        copyBounds(this.f3620a);
        float fHeight = this.f7923a / r0.height();
        return new LinearGradient(0.0f, r0.top, 0.0f, r0.bottom, new int[]{tc.b(this.f3613a, this.e), tc.b(this.b, this.e), tc.b(tc.d(this.b, 0), this.e), tc.b(tc.d(this.d, 0), this.e), tc.b(this.d, this.e), tc.b(this.c, this.e)}, new float[]{0.0f, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP);
    }

    public RectF b() {
        this.f3623b.set(getBounds());
        return this.f3623b;
    }

    public void c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.e = colorStateList.getColorForState(getState(), this.e);
        }
        this.f3617a = colorStateList;
        this.f3622a = true;
        invalidateSelf();
    }

    public void d(float f) {
        if (this.f7923a != f) {
            this.f7923a = f;
            this.f3618a.setStrokeWidth(f * 1.3333f);
            this.f3622a = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f3622a) {
            this.f3618a.setShader(a());
            this.f3622a = false;
        }
        float strokeWidth = this.f3618a.getStrokeWidth() / 2.0f;
        copyBounds(this.f3620a);
        this.f3621a.set(this.f3620a);
        float fMin = Math.min(this.f3614a.p().a(b()), this.f3621a.width() / 2.0f);
        if (this.f3614a.s(b())) {
            this.f3621a.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f3621a, fMin, fMin, this.f3618a);
        }
    }

    public void e(int i, int i2, int i3, int i4) {
        this.f3613a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public void f(nz nzVar) {
        this.f3614a = nzVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f3616a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f7923a > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f3614a.s(b())) {
            outline.setRoundRect(getBounds(), this.f3614a.p().a(b()));
            return;
        }
        copyBounds(this.f3620a);
        this.f3621a.set(this.f3620a);
        this.f3615a.d(this.f3614a, 1.0f, this.f3621a, this.f3619a);
        if (this.f3619a.isConvex()) {
            outline.setConvexPath(this.f3619a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        if (!this.f3614a.s(b())) {
            return true;
        }
        int iRound = Math.round(this.f7923a);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f3617a;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f3622a = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f3617a;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.e)) != this.e) {
            this.f3622a = true;
            this.e = colorForState;
        }
        if (this.f3622a) {
            invalidateSelf();
        }
        return this.f3622a;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f3618a.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3618a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
