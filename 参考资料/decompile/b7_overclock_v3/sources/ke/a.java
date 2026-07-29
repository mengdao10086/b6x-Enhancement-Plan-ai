package ke;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.google.android.material.R;
import g.n0;
import h0.d;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class a extends androidx.appcompat.graphics.drawable.c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final double f37190r = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final float f37191s = 1.5f;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final float f37192t = 0.25f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final float f37193u = 0.5f;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final float f37194v = 1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Paint f37195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final Paint f37196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final RectF f37197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f37198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Path f37199f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f37200g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f37201h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f37202i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f37203j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f37204k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f37205l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f37206m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f37207n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f37208o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f37209p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f37210q;

    public a(Context context, Drawable drawable, float f10, float f11, float f12) {
        super(drawable);
        this.f37204k = true;
        this.f37208o = true;
        this.f37210q = false;
        this.f37205l = d.f(context, R.color.design_fab_shadow_start_color);
        this.f37206m = d.f(context, R.color.design_fab_shadow_mid_color);
        this.f37207n = d.f(context, R.color.design_fab_shadow_end_color);
        Paint paint = new Paint(5);
        this.f37195b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f37198e = Math.round(f10);
        this.f37197d = new RectF();
        Paint paint2 = new Paint(paint);
        this.f37196c = paint2;
        paint2.setAntiAlias(false);
        r(f11, f12);
    }

    public static float e(float f10, float f11, boolean z10) {
        return z10 ? (float) (((double) f10) + ((1.0d - f37190r) * ((double) f11))) : f10;
    }

    public static float f(float f10, float f11, boolean z10) {
        return z10 ? (float) (((double) (f10 * 1.5f)) + ((1.0d - f37190r) * ((double) f11))) : f10 * 1.5f;
    }

    public static int s(float f10) {
        int iRound = Math.round(f10);
        return iRound % 2 == 1 ? iRound - 1 : iRound;
    }

    public final void c(@n0 Rect rect) {
        float f10 = this.f37201h;
        float f11 = 1.5f * f10;
        this.f37197d.set(rect.left + f10, rect.top + f11, rect.right - f10, rect.bottom - f11);
        Drawable drawableA = a();
        RectF rectF = this.f37197d;
        drawableA.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        d();
    }

    public final void d() {
        float f10 = this.f37198e;
        RectF rectF = new RectF(-f10, -f10, f10, f10);
        RectF rectF2 = new RectF(rectF);
        float f11 = this.f37202i;
        rectF2.inset(-f11, -f11);
        Path path = this.f37199f;
        if (path == null) {
            this.f37199f = new Path();
        } else {
            path.reset();
        }
        this.f37199f.setFillType(Path.FillType.EVEN_ODD);
        this.f37199f.moveTo(-this.f37198e, 0.0f);
        this.f37199f.rLineTo(-this.f37202i, 0.0f);
        this.f37199f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f37199f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f37199f.close();
        float f12 = -rectF2.top;
        if (f12 > 0.0f) {
            float f13 = this.f37198e / f12;
            this.f37195b.setShader(new RadialGradient(0.0f, 0.0f, f12, new int[]{0, this.f37205l, this.f37206m, this.f37207n}, new float[]{0.0f, f13, ((1.0f - f13) / 2.0f) + f13, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.f37196c.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.f37205l, this.f37206m, this.f37207n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f37196c.setAntiAlias(false);
    }

    @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
    public void draw(@n0 Canvas canvas) {
        if (this.f37204k) {
            c(getBounds());
            this.f37204k = false;
        }
        g(canvas);
        super.draw(canvas);
    }

    public final void g(@n0 Canvas canvas) {
        int i10;
        float f10;
        int i11;
        float f11;
        float f12;
        float f13;
        int iSave = canvas.save();
        canvas.rotate(this.f37209p, this.f37197d.centerX(), this.f37197d.centerY());
        float f14 = this.f37198e;
        float f15 = (-f14) - this.f37202i;
        float f16 = f14 * 2.0f;
        boolean z10 = this.f37197d.width() - f16 > 0.0f;
        boolean z11 = this.f37197d.height() - f16 > 0.0f;
        float f17 = this.f37203j;
        float f18 = f14 / ((f17 - (0.5f * f17)) + f14);
        float f19 = f14 / ((f17 - (0.25f * f17)) + f14);
        float f20 = f14 / ((f17 - (f17 * 1.0f)) + f14);
        int iSave2 = canvas.save();
        RectF rectF = this.f37197d;
        canvas.translate(rectF.left + f14, rectF.top + f14);
        canvas.scale(f18, f19);
        canvas.drawPath(this.f37199f, this.f37195b);
        if (z10) {
            canvas.scale(1.0f / f18, 1.0f);
            i10 = iSave2;
            f10 = f20;
            i11 = iSave;
            f11 = f19;
            canvas.drawRect(0.0f, f15, this.f37197d.width() - f16, -this.f37198e, this.f37196c);
        } else {
            i10 = iSave2;
            f10 = f20;
            i11 = iSave;
            f11 = f19;
        }
        canvas.restoreToCount(i10);
        int iSave3 = canvas.save();
        RectF rectF2 = this.f37197d;
        canvas.translate(rectF2.right - f14, rectF2.bottom - f14);
        float f21 = f10;
        canvas.scale(f18, f21);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f37199f, this.f37195b);
        if (z10) {
            canvas.scale(1.0f / f18, 1.0f);
            f12 = f11;
            f13 = f21;
            canvas.drawRect(0.0f, f15, this.f37197d.width() - f16, (-this.f37198e) + this.f37202i, this.f37196c);
        } else {
            f12 = f11;
            f13 = f21;
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        RectF rectF3 = this.f37197d;
        canvas.translate(rectF3.left + f14, rectF3.bottom - f14);
        canvas.scale(f18, f13);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f37199f, this.f37195b);
        if (z11) {
            canvas.scale(1.0f / f13, 1.0f);
            canvas.drawRect(0.0f, f15, this.f37197d.height() - f16, -this.f37198e, this.f37196c);
        }
        canvas.restoreToCount(iSave4);
        int iSave5 = canvas.save();
        RectF rectF4 = this.f37197d;
        canvas.translate(rectF4.right - f14, rectF4.top + f14);
        float f22 = f12;
        canvas.scale(f18, f22);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f37199f, this.f37195b);
        if (z11) {
            canvas.scale(1.0f / f22, 1.0f);
            canvas.drawRect(0.0f, f15, this.f37197d.height() - f16, -this.f37198e, this.f37196c);
        }
        canvas.restoreToCount(iSave5);
        canvas.restoreToCount(i11);
    }

    @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
    public boolean getPadding(@n0 Rect rect) {
        int iCeil = (int) Math.ceil(f(this.f37201h, this.f37198e, this.f37208o));
        int iCeil2 = (int) Math.ceil(e(this.f37201h, this.f37198e, this.f37208o));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    public float h() {
        return this.f37198e;
    }

    public float i() {
        return this.f37201h;
    }

    public float j() {
        float f10 = this.f37201h;
        return (Math.max(f10, this.f37198e + ((f10 * 1.5f) / 2.0f)) * 2.0f) + (this.f37201h * 1.5f * 2.0f);
    }

    public float k() {
        float f10 = this.f37201h;
        return (Math.max(f10, this.f37198e + (f10 / 2.0f)) * 2.0f) + (this.f37201h * 2.0f);
    }

    public float l() {
        return this.f37203j;
    }

    public void m(boolean z10) {
        this.f37208o = z10;
        invalidateSelf();
    }

    public void n(float f10) {
        float fRound = Math.round(f10);
        if (this.f37198e == fRound) {
            return;
        }
        this.f37198e = fRound;
        this.f37204k = true;
        invalidateSelf();
    }

    public void o(float f10) {
        r(this.f37203j, f10);
    }

    @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f37204k = true;
    }

    public final void p(float f10) {
        if (this.f37209p != f10) {
            this.f37209p = f10;
            invalidateSelf();
        }
    }

    public void q(float f10) {
        r(f10, this.f37201h);
    }

    public void r(float f10, float f11) {
        if (f10 < 0.0f || f11 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float fS = s(f10);
        float fS2 = s(f11);
        if (fS > fS2) {
            if (!this.f37210q) {
                this.f37210q = true;
            }
            fS = fS2;
        }
        if (this.f37203j == fS && this.f37201h == fS2) {
            return;
        }
        this.f37203j = fS;
        this.f37201h = fS2;
        this.f37202i = Math.round(fS * 1.5f);
        this.f37200g = fS2;
        this.f37204k = true;
        invalidateSelf();
    }

    @Override // androidx.appcompat.graphics.drawable.c, android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        super.setAlpha(i10);
        this.f37195b.setAlpha(i10);
        this.f37196c.setAlpha(i10);
    }
}
