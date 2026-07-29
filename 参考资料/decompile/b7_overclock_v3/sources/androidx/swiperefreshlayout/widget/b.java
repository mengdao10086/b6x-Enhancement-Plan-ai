package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RestrictTo;
import androidx.core.util.o;
import g.n0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class b extends Drawable implements Animatable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f7744i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f7745j = 11.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float f7746k = 3.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f7747l = 12;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f7748m = 6;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f7749n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final float f7750o = 7.5f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final float f7751p = 2.5f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f7752q = 10;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f7753r = 5;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final float f7755t = 0.75f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final float f7756u = 0.5f;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f7757v = 1332;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final float f7758w = 216.0f;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final float f7759x = 0.8f;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final float f7760y = 0.01f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final float f7761z = 0.20999998f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f7762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f7763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Resources f7764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Animator f7765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f7766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Interpolator f7742g = new LinearInterpolator();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Interpolator f7743h = new l1.b();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int[] f7754s = {-16777216};

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f7768a;

        public a(d dVar) {
            this.f7768a = dVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.H(fFloatValue, this.f7768a);
            b.this.e(fFloatValue, this.f7768a, false);
            b.this.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: androidx.swiperefreshlayout.widget.b$b, reason: collision with other inner class name */
    public class C0072b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f7770a;

        public C0072b(d dVar) {
            this.f7770a = dVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.this.e(1.0f, this.f7770a, true);
            this.f7770a.M();
            this.f7770a.v();
            b bVar = b.this;
            if (!bVar.f7767f) {
                bVar.f7766e += 1.0f;
                return;
            }
            bVar.f7767f = false;
            animator.cancel();
            animator.setDuration(1332L);
            animator.start();
            this.f7770a.I(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f7766e = 0.0f;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface c {
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RectF f7772a = new RectF();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f7773b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f7774c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Paint f7775d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f7776e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f7777f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f7778g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f7779h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int[] f7780i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f7781j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f7782k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f7783l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f7784m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f7785n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Path f7786o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f7787p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f7788q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f7789r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f7790s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f7791t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f7792u;

        public d() {
            Paint paint = new Paint();
            this.f7773b = paint;
            Paint paint2 = new Paint();
            this.f7774c = paint2;
            Paint paint3 = new Paint();
            this.f7775d = paint3;
            this.f7776e = 0.0f;
            this.f7777f = 0.0f;
            this.f7778g = 0.0f;
            this.f7779h = 5.0f;
            this.f7787p = 1.0f;
            this.f7791t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        public void A(int i10) {
            this.f7775d.setColor(i10);
        }

        public void B(float f10) {
            this.f7788q = f10;
        }

        public void C(int i10) {
            this.f7792u = i10;
        }

        public void D(ColorFilter colorFilter) {
            this.f7773b.setColorFilter(colorFilter);
        }

        public void E(int i10) {
            this.f7781j = i10;
            this.f7792u = this.f7780i[i10];
        }

        public void F(@n0 int[] iArr) {
            this.f7780i = iArr;
            E(0);
        }

        public void G(float f10) {
            this.f7777f = f10;
        }

        public void H(float f10) {
            this.f7778g = f10;
        }

        public void I(boolean z10) {
            if (this.f7785n != z10) {
                this.f7785n = z10;
            }
        }

        public void J(float f10) {
            this.f7776e = f10;
        }

        public void K(Paint.Cap cap) {
            this.f7773b.setStrokeCap(cap);
        }

        public void L(float f10) {
            this.f7779h = f10;
            this.f7773b.setStrokeWidth(f10);
        }

        public void M() {
            this.f7782k = this.f7776e;
            this.f7783l = this.f7777f;
            this.f7784m = this.f7778g;
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f7772a;
            float f10 = this.f7788q;
            float fMin = (this.f7779h / 2.0f) + f10;
            if (f10 <= 0.0f) {
                fMin = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.f7789r * this.f7787p) / 2.0f, this.f7779h / 2.0f);
            }
            rectF.set(rect.centerX() - fMin, rect.centerY() - fMin, rect.centerX() + fMin, rect.centerY() + fMin);
            float f11 = this.f7776e;
            float f12 = this.f7778g;
            float f13 = (f11 + f12) * 360.0f;
            float f14 = ((this.f7777f + f12) * 360.0f) - f13;
            this.f7773b.setColor(this.f7792u);
            this.f7773b.setAlpha(this.f7791t);
            float f15 = this.f7779h / 2.0f;
            rectF.inset(f15, f15);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f7775d);
            float f16 = -f15;
            rectF.inset(f16, f16);
            canvas.drawArc(rectF, f13, f14, false, this.f7773b);
            b(canvas, f13, f14, rectF);
        }

        public void b(Canvas canvas, float f10, float f11, RectF rectF) {
            if (this.f7785n) {
                Path path = this.f7786o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f7786o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float fMin = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f12 = (this.f7789r * this.f7787p) / 2.0f;
                this.f7786o.moveTo(0.0f, 0.0f);
                this.f7786o.lineTo(this.f7789r * this.f7787p, 0.0f);
                Path path3 = this.f7786o;
                float f13 = this.f7789r;
                float f14 = this.f7787p;
                path3.lineTo((f13 * f14) / 2.0f, this.f7790s * f14);
                this.f7786o.offset((fMin + rectF.centerX()) - f12, rectF.centerY() + (this.f7779h / 2.0f));
                this.f7786o.close();
                this.f7774c.setColor(this.f7792u);
                this.f7774c.setAlpha(this.f7791t);
                canvas.save();
                canvas.rotate(f10 + f11, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f7786o, this.f7774c);
                canvas.restore();
            }
        }

        public int c() {
            return this.f7791t;
        }

        public float d() {
            return this.f7790s;
        }

        public float e() {
            return this.f7787p;
        }

        public float f() {
            return this.f7789r;
        }

        public int g() {
            return this.f7775d.getColor();
        }

        public float h() {
            return this.f7788q;
        }

        public int[] i() {
            return this.f7780i;
        }

        public float j() {
            return this.f7777f;
        }

        public int k() {
            return this.f7780i[l()];
        }

        public int l() {
            return (this.f7781j + 1) % this.f7780i.length;
        }

        public float m() {
            return this.f7778g;
        }

        public boolean n() {
            return this.f7785n;
        }

        public float o() {
            return this.f7776e;
        }

        public int p() {
            return this.f7780i[this.f7781j];
        }

        public float q() {
            return this.f7783l;
        }

        public float r() {
            return this.f7784m;
        }

        public float s() {
            return this.f7782k;
        }

        public Paint.Cap t() {
            return this.f7773b.getStrokeCap();
        }

        public float u() {
            return this.f7779h;
        }

        public void v() {
            E(l());
        }

        public void w() {
            this.f7782k = 0.0f;
            this.f7783l = 0.0f;
            this.f7784m = 0.0f;
            J(0.0f);
            G(0.0f);
            H(0.0f);
        }

        public void x(int i10) {
            this.f7791t = i10;
        }

        public void y(float f10, float f11) {
            this.f7789r = (int) f10;
            this.f7790s = (int) f11;
        }

        public void z(float f10) {
            if (f10 != this.f7787p) {
                this.f7787p = f10;
            }
        }
    }

    public b(@n0 Context context) {
        this.f7764c = ((Context) o.l(context)).getResources();
        d dVar = new d();
        this.f7762a = dVar;
        dVar.F(f7754s);
        E(2.5f);
        G();
    }

    public final void A(float f10) {
        this.f7763b = f10;
    }

    public final void B(float f10, float f11, float f12, float f13) {
        d dVar = this.f7762a;
        float f14 = this.f7764c.getDisplayMetrics().density;
        dVar.L(f11 * f14);
        dVar.B(f10 * f14);
        dVar.E(0);
        dVar.y(f12 * f14, f13 * f14);
    }

    public void C(float f10, float f11) {
        this.f7762a.J(f10);
        this.f7762a.G(f11);
        invalidateSelf();
    }

    public void D(@n0 Paint.Cap cap) {
        this.f7762a.K(cap);
        invalidateSelf();
    }

    public void E(float f10) {
        this.f7762a.L(f10);
        invalidateSelf();
    }

    public void F(int i10) {
        if (i10 == 0) {
            B(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            B(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public final void G() {
        d dVar = this.f7762a;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new a(dVar));
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(f7742g);
        valueAnimatorOfFloat.addListener(new C0072b(dVar));
        this.f7765d = valueAnimatorOfFloat;
    }

    public void H(float f10, d dVar) {
        if (f10 > 0.75f) {
            dVar.C(f((f10 - 0.75f) / 0.25f, dVar.p(), dVar.k()));
        } else {
            dVar.C(dVar.p());
        }
    }

    public final void a(float f10, d dVar) {
        H(f10, dVar);
        float fFloor = (float) (Math.floor(dVar.r() / 0.8f) + 1.0d);
        dVar.J(dVar.s() + (((dVar.q() - 0.01f) - dVar.s()) * f10));
        dVar.G(dVar.q());
        dVar.H(dVar.r() + ((fFloor - dVar.r()) * f10));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f7763b, bounds.exactCenterX(), bounds.exactCenterY());
        this.f7762a.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f10, d dVar, boolean z10) {
        float interpolation;
        float interpolation2;
        if (this.f7767f) {
            a(f10, dVar);
            return;
        }
        if (f10 != 1.0f || z10) {
            float fR = dVar.r();
            if (f10 < 0.5f) {
                interpolation = dVar.s();
                interpolation2 = (f7743h.getInterpolation(f10 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float fS = dVar.s() + 0.79f;
                interpolation = fS - (((1.0f - f7743h.getInterpolation((f10 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                interpolation2 = fS;
            }
            float f11 = fR + (0.20999998f * f10);
            float f12 = (f10 + this.f7766e) * 216.0f;
            dVar.J(interpolation);
            dVar.G(interpolation2);
            dVar.H(f11);
            A(f12);
        }
    }

    public final int f(float f10, int i10, int i11) {
        return ((((i10 >> 24) & 255) + ((int) ((((i11 >> 24) & 255) - r0) * f10))) << 24) | ((((i10 >> 16) & 255) + ((int) ((((i11 >> 16) & 255) - r1) * f10))) << 16) | ((((i10 >> 8) & 255) + ((int) ((((i11 >> 8) & 255) - r2) * f10))) << 8) | ((i10 & 255) + ((int) (f10 * ((i11 & 255) - r8))));
    }

    public boolean g() {
        return this.f7762a.n();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f7762a.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float h() {
        return this.f7762a.d();
    }

    public float i() {
        return this.f7762a.e();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f7765d.isRunning();
    }

    public float j() {
        return this.f7762a.f();
    }

    public int k() {
        return this.f7762a.g();
    }

    public float l() {
        return this.f7762a.h();
    }

    @n0
    public int[] m() {
        return this.f7762a.i();
    }

    public float n() {
        return this.f7762a.j();
    }

    public float o() {
        return this.f7762a.m();
    }

    public final float p() {
        return this.f7763b;
    }

    public float q() {
        return this.f7762a.o();
    }

    @n0
    public Paint.Cap r() {
        return this.f7762a.t();
    }

    public float s() {
        return this.f7762a.u();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f7762a.x(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f7762a.D(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f7765d.cancel();
        this.f7762a.M();
        if (this.f7762a.j() != this.f7762a.o()) {
            this.f7767f = true;
            this.f7765d.setDuration(666L);
            this.f7765d.start();
        } else {
            this.f7762a.E(0);
            this.f7762a.w();
            this.f7765d.setDuration(1332L);
            this.f7765d.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f7765d.cancel();
        A(0.0f);
        this.f7762a.I(false);
        this.f7762a.E(0);
        this.f7762a.w();
        invalidateSelf();
    }

    public void t(float f10, float f11) {
        this.f7762a.y(f10, f11);
        invalidateSelf();
    }

    public void u(boolean z10) {
        this.f7762a.I(z10);
        invalidateSelf();
    }

    public void v(float f10) {
        this.f7762a.z(f10);
        invalidateSelf();
    }

    public void w(int i10) {
        this.f7762a.A(i10);
        invalidateSelf();
    }

    public void x(float f10) {
        this.f7762a.B(f10);
        invalidateSelf();
    }

    public void y(@n0 int... iArr) {
        this.f7762a.F(iArr);
        this.f7762a.E(0);
        invalidateSelf();
    }

    public void z(float f10) {
        this.f7762a.H(f10);
        invalidateSelf();
    }
}
