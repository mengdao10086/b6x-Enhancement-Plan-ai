package te;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.ArcMotion;
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import com.google.android.material.internal.b0;
import com.google.common.collect.LinkedHashMultimap;
import g.d0;
import g.d1;
import g.n0;
import g.p0;
import g.v0;
import g.x;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import te.v;

/* JADX INFO: loaded from: classes7.dex */
@v0(21)
public final class l extends Transition {
    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 0;
    public static final int C1 = 2;
    public static final String C2 = "materialContainerTransition:shapeAppearance";
    public static final int D = 1;
    public static final f F7;
    public static final f H7;
    public static final float I7 = -1.0f;
    public static final int K0 = 3;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f51118k0 = 2;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f51119k1 = 0;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f51120v1 = 1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final String f51121v2 = "materialContainerTransition:bounds";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f51122z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f51123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f51124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f51125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f51126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @d0
    public int f51127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @d0
    public int f51128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @d0
    public int f51129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.l
    public int f51130h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.l
    public int f51131i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.l
    public int f51132j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.l
    public int f51133k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f51134l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f51135m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f51136n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public View f51137o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @p0
    public View f51138p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @p0
    public le.o f51139q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public le.o f51140r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @p0
    public e f51141s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @p0
    public e f51142t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @p0
    public e f51143u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @p0
    public e f51144v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f51145w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f51146x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f51147y;
    public static final String K1 = l.class.getSimpleName();
    public static final String[] K2 = {"materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance"};
    public static final f E7 = new f(new e(0.0f, 0.25f), new e(0.0f, 1.0f), new e(0.0f, 1.0f), new e(0.0f, 0.75f), null);
    public static final f G7 = new f(new e(0.1f, 0.4f), new e(0.1f, 1.0f), new e(0.1f, 1.0f), new e(0.1f, 0.9f), null);

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f51148a;

        public a(h hVar) {
            this.f51148a = hVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f51148a.o(valueAnimator.getAnimatedFraction());
        }
    }

    public class b extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f51150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f51151b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f51152c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View f51153d;

        public b(View view, h hVar, View view2, View view3) {
            this.f51150a = view;
            this.f51151b = hVar;
            this.f51152c = view2;
            this.f51153d = view3;
        }

        @Override // te.u, android.transition.Transition.TransitionListener
        public void onTransitionEnd(@n0 Transition transition) {
            l.this.removeListener(this);
            if (l.this.f51124b) {
                return;
            }
            this.f51152c.setAlpha(1.0f);
            this.f51153d.setAlpha(1.0f);
            b0.i(this.f51150a).b(this.f51151b);
        }

        @Override // te.u, android.transition.Transition.TransitionListener
        public void onTransitionStart(@n0 Transition transition) {
            b0.i(this.f51150a).a(this.f51151b);
            this.f51152c.setAlpha(0.0f);
            this.f51153d.setAlpha(0.0f);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface c {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface d {
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
        public final float f51155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
        public final float f51156b;

        public e(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f11) {
            this.f51155a = f10;
            this.f51156b = f11;
        }

        @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
        public float c() {
            return this.f51156b;
        }

        @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
        public float d() {
            return this.f51155a;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final e f51157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @n0
        public final e f51158b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @n0
        public final e f51159c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @n0
        public final e f51160d;

        public /* synthetic */ f(e eVar, e eVar2, e eVar3, e eVar4, a aVar) {
            this(eVar, eVar2, eVar3, eVar4);
        }

        public f(@n0 e eVar, @n0 e eVar2, @n0 e eVar3, @n0 e eVar4) {
            this.f51157a = eVar;
            this.f51158b = eVar2;
            this.f51159c = eVar3;
            this.f51160d = eVar4;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface g {
    }

    public static final class h extends Drawable {
        public static final int M = 754974720;
        public static final int N = -7829368;
        public static final float O = 0.3f;
        public static final float P = 1.5f;
        public final f A;
        public final te.a B;
        public final te.f C;
        public final boolean D;
        public final Paint E;
        public final Path F;
        public te.c G;
        public te.h H;
        public RectF I;
        public float J;
        public float K;
        public float L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f51161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RectF f51162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final le.o f51163c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f51164d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f51165e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final RectF f51166f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final le.o f51167g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f51168h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Paint f51169i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Paint f51170j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Paint f51171k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Paint f51172l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Paint f51173m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final j f51174n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final PathMeasure f51175o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final float f51176p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final float[] f51177q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final boolean f51178r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final float f51179s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final float f51180t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final boolean f51181u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final le.j f51182v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final RectF f51183w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final RectF f51184x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final RectF f51185y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final RectF f51186z;

        public class a implements v.c {
            public a() {
            }

            @Override // te.v.c
            public void a(Canvas canvas) {
                h.this.f51161a.draw(canvas);
            }
        }

        public class b implements v.c {
            public b() {
            }

            @Override // te.v.c
            public void a(Canvas canvas) {
                h.this.f51165e.draw(canvas);
            }
        }

        public /* synthetic */ h(PathMotion pathMotion, View view, RectF rectF, le.o oVar, float f10, View view2, RectF rectF2, le.o oVar2, float f11, int i10, int i11, int i12, int i13, boolean z10, boolean z11, te.a aVar, te.f fVar, f fVar2, boolean z12, a aVar2) {
            this(pathMotion, view, rectF, oVar, f10, view2, rectF2, oVar2, f11, i10, i11, i12, i13, z10, z11, aVar, fVar, fVar2, z12);
        }

        public static float d(RectF rectF, float f10) {
            return ((rectF.centerX() / (f10 / 2.0f)) - 1.0f) * 0.3f;
        }

        public static float e(RectF rectF, float f10) {
            return (rectF.centerY() / f10) * 1.5f;
        }

        public static PointF m(RectF rectF) {
            return new PointF(rectF.centerX(), rectF.top);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@n0 Canvas canvas) {
            if (this.f51173m.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.f51173m);
            }
            int iSave = this.D ? canvas.save() : -1;
            if (this.f51181u && this.J > 0.0f) {
                h(canvas);
            }
            this.f51174n.a(canvas);
            n(canvas, this.f51169i);
            if (this.G.f51087c) {
                l(canvas);
                k(canvas);
            } else {
                k(canvas);
                l(canvas);
            }
            if (this.D) {
                canvas.restoreToCount(iSave);
                f(canvas, this.f51183w, this.F, -65281);
                g(canvas, this.f51184x, -256);
                g(canvas, this.f51183w, -16711936);
                g(canvas, this.f51186z, -16711681);
                g(canvas, this.f51185y, -16776961);
            }
        }

        public final void f(Canvas canvas, RectF rectF, Path path, @g.l int i10) {
            PointF pointFM = m(rectF);
            if (this.L == 0.0f) {
                path.reset();
                path.moveTo(pointFM.x, pointFM.y);
            } else {
                path.lineTo(pointFM.x, pointFM.y);
                this.E.setColor(i10);
                canvas.drawPath(path, this.E);
            }
        }

        public final void g(Canvas canvas, RectF rectF, @g.l int i10) {
            this.E.setColor(i10);
            canvas.drawRect(rectF, this.E);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        public final void h(Canvas canvas) {
            canvas.save();
            canvas.clipPath(this.f51174n.d(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT > 28) {
                j(canvas);
            } else {
                i(canvas);
            }
            canvas.restore();
        }

        public final void i(Canvas canvas) {
            le.j jVar = this.f51182v;
            RectF rectF = this.I;
            jVar.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            this.f51182v.n0(this.J);
            this.f51182v.B0((int) this.K);
            this.f51182v.setShapeAppearanceModel(this.f51174n.c());
            this.f51182v.draw(canvas);
        }

        public final void j(Canvas canvas) {
            le.o oVarC = this.f51174n.c();
            if (!oVarC.u(this.I)) {
                canvas.drawPath(this.f51174n.d(), this.f51172l);
            } else {
                float fA = oVarC.r().a(this.I);
                canvas.drawRoundRect(this.I, fA, fA, this.f51172l);
            }
        }

        public final void k(Canvas canvas) {
            n(canvas, this.f51171k);
            Rect bounds = getBounds();
            RectF rectF = this.f51185y;
            v.w(canvas, bounds, rectF.left, rectF.top, this.H.f51108b, this.G.f51086b, new b());
        }

        public final void l(Canvas canvas) {
            n(canvas, this.f51170j);
            Rect bounds = getBounds();
            RectF rectF = this.f51183w;
            v.w(canvas, bounds, rectF.left, rectF.top, this.H.f51107a, this.G.f51085a, new a());
        }

        public final void n(Canvas canvas, Paint paint) {
            if (paint.getColor() == 0 || paint.getAlpha() <= 0) {
                return;
            }
            canvas.drawRect(getBounds(), paint);
        }

        public final void o(float f10) {
            if (this.L != f10) {
                p(f10);
            }
        }

        public final void p(float f10) {
            float f11;
            float f12;
            this.L = f10;
            this.f51173m.setAlpha((int) (this.f51178r ? v.k(0.0f, 255.0f, f10) : v.k(255.0f, 0.0f, f10)));
            this.f51175o.getPosTan(this.f51176p * f10, this.f51177q, null);
            float[] fArr = this.f51177q;
            float f13 = fArr[0];
            float f14 = fArr[1];
            if (f10 > 1.0f || f10 < 0.0f) {
                if (f10 > 1.0f) {
                    f11 = 0.99f;
                    f12 = (f10 - 1.0f) / 0.00999999f;
                } else {
                    f11 = 0.01f;
                    f12 = (f10 / 0.01f) * (-1.0f);
                }
                this.f51175o.getPosTan(this.f51176p * f11, fArr, null);
                float[] fArr2 = this.f51177q;
                f13 += (f13 - fArr2[0]) * f12;
                f14 += (f14 - fArr2[1]) * f12;
            }
            float f15 = f13;
            float f16 = f14;
            te.h hVarA = this.C.a(f10, ((Float) androidx.core.util.o.l(Float.valueOf(this.A.f51158b.f51155a))).floatValue(), ((Float) androidx.core.util.o.l(Float.valueOf(this.A.f51158b.f51156b))).floatValue(), this.f51162b.width(), this.f51162b.height(), this.f51166f.width(), this.f51166f.height());
            this.H = hVarA;
            RectF rectF = this.f51183w;
            float f17 = hVarA.f51109c;
            rectF.set(f15 - (f17 / 2.0f), f16, (f17 / 2.0f) + f15, hVarA.f51110d + f16);
            RectF rectF2 = this.f51185y;
            te.h hVar = this.H;
            float f18 = hVar.f51111e;
            rectF2.set(f15 - (f18 / 2.0f), f16, f15 + (f18 / 2.0f), hVar.f51112f + f16);
            this.f51184x.set(this.f51183w);
            this.f51186z.set(this.f51185y);
            float fFloatValue = ((Float) androidx.core.util.o.l(Float.valueOf(this.A.f51159c.f51155a))).floatValue();
            float fFloatValue2 = ((Float) androidx.core.util.o.l(Float.valueOf(this.A.f51159c.f51156b))).floatValue();
            boolean zC = this.C.c(this.H);
            RectF rectF3 = zC ? this.f51184x : this.f51186z;
            float fL = v.l(0.0f, 1.0f, fFloatValue, fFloatValue2, f10);
            if (!zC) {
                fL = 1.0f - fL;
            }
            this.C.b(rectF3, fL, this.H);
            this.I = new RectF(Math.min(this.f51184x.left, this.f51186z.left), Math.min(this.f51184x.top, this.f51186z.top), Math.max(this.f51184x.right, this.f51186z.right), Math.max(this.f51184x.bottom, this.f51186z.bottom));
            this.f51174n.b(f10, this.f51163c, this.f51167g, this.f51183w, this.f51184x, this.f51186z, this.A.f51160d);
            this.J = v.k(this.f51164d, this.f51168h, f10);
            float fD = d(this.I, this.f51179s);
            float fE = e(this.I, this.f51180t);
            float f19 = this.J;
            float f20 = (int) (fE * f19);
            this.K = f20;
            this.f51172l.setShadowLayer(f19, (int) (fD * f19), f20, 754974720);
            this.G = this.B.a(f10, ((Float) androidx.core.util.o.l(Float.valueOf(this.A.f51157a.f51155a))).floatValue(), ((Float) androidx.core.util.o.l(Float.valueOf(this.A.f51157a.f51156b))).floatValue(), 0.35f);
            if (this.f51170j.getColor() != 0) {
                this.f51170j.setAlpha(this.G.f51085a);
            }
            if (this.f51171k.getColor() != 0) {
                this.f51171k.setAlpha(this.G.f51086b);
            }
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i10) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@p0 ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }

        public h(PathMotion pathMotion, View view, RectF rectF, le.o oVar, float f10, View view2, RectF rectF2, le.o oVar2, float f11, @g.l int i10, @g.l int i11, @g.l int i12, int i13, boolean z10, boolean z11, te.a aVar, te.f fVar, f fVar2, boolean z12) {
            Paint paint = new Paint();
            this.f51169i = paint;
            Paint paint2 = new Paint();
            this.f51170j = paint2;
            Paint paint3 = new Paint();
            this.f51171k = paint3;
            this.f51172l = new Paint();
            Paint paint4 = new Paint();
            this.f51173m = paint4;
            this.f51174n = new j();
            this.f51177q = new float[]{rectF.centerX(), rectF.top};
            le.j jVar = new le.j();
            this.f51182v = jVar;
            Paint paint5 = new Paint();
            this.E = paint5;
            this.F = new Path();
            this.f51161a = view;
            this.f51162b = rectF;
            this.f51163c = oVar;
            this.f51164d = f10;
            this.f51165e = view2;
            this.f51166f = rectF2;
            this.f51167g = oVar2;
            this.f51168h = f11;
            this.f51178r = z10;
            this.f51181u = z11;
            this.B = aVar;
            this.C = fVar;
            this.A = fVar2;
            this.D = z12;
            WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(new DisplayMetrics());
            this.f51179s = r12.widthPixels;
            this.f51180t = r12.heightPixels;
            paint.setColor(i10);
            paint2.setColor(i11);
            paint3.setColor(i12);
            jVar.o0(ColorStateList.valueOf(0));
            jVar.x0(2);
            jVar.u0(false);
            jVar.v0(-7829368);
            RectF rectF3 = new RectF(rectF);
            this.f51183w = rectF3;
            this.f51184x = new RectF(rectF3);
            RectF rectF4 = new RectF(rectF3);
            this.f51185y = rectF4;
            this.f51186z = new RectF(rectF4);
            PointF pointFM = m(rectF);
            PointF pointFM2 = m(rectF2);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(pointFM.x, pointFM.y, pointFM2.x, pointFM2.y), false);
            this.f51175o = pathMeasure;
            this.f51176p = pathMeasure.getLength();
            paint4.setStyle(Paint.Style.FILL);
            paint4.setShader(v.c(i13));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            p(0.0f);
        }
    }

    static {
        a aVar = null;
        F7 = new f(new e(0.6f, 0.9f), new e(0.0f, 1.0f), new e(0.0f, 0.9f), new e(0.3f, 0.9f), aVar);
        H7 = new f(new e(0.6f, 0.9f), new e(0.0f, 0.9f), new e(0.0f, 0.9f), new e(0.2f, 0.9f), aVar);
    }

    public l() {
        this.f51123a = false;
        this.f51124b = false;
        this.f51125c = false;
        this.f51126d = false;
        this.f51127e = R.id.content;
        this.f51128f = -1;
        this.f51129g = -1;
        this.f51130h = 0;
        this.f51131i = 0;
        this.f51132j = 0;
        this.f51133k = 1375731712;
        this.f51134l = 0;
        this.f51135m = 0;
        this.f51136n = 0;
        this.f51145w = Build.VERSION.SDK_INT >= 28;
        this.f51146x = -1.0f;
        this.f51147y = -1.0f;
    }

    @d1
    public static int D(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{com.google.android.material.R.attr.transitionShapeAppearance});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static RectF c(View view, @p0 View view2, float f10, float f11) {
        if (view2 == null) {
            return new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        }
        RectF rectFG = v.g(view2);
        rectFG.offset(f10, f11);
        return rectFG;
    }

    public static le.o d(@n0 View view, @n0 RectF rectF, @p0 le.o oVar) {
        return v.b(t(view, oVar), rectF);
    }

    public static void e(@n0 TransitionValues transitionValues, @p0 View view, @d0 int i10, @p0 le.o oVar) {
        if (i10 != -1) {
            transitionValues.view = v.f(transitionValues.view, i10);
        } else if (view != null) {
            transitionValues.view = view;
        } else {
            View view2 = transitionValues.view;
            int i11 = com.google.android.material.R.id.mtrl_motion_snapshot_view;
            if (view2.getTag(i11) instanceof View) {
                View view3 = (View) transitionValues.view.getTag(i11);
                transitionValues.view.setTag(i11, null);
                transitionValues.view = view3;
            }
        }
        View view4 = transitionValues.view;
        if (!u0.U0(view4) && view4.getWidth() == 0 && view4.getHeight() == 0) {
            return;
        }
        RectF rectFH = view4.getParent() == null ? v.h(view4) : v.g(view4);
        transitionValues.values.put("materialContainerTransition:bounds", rectFH);
        transitionValues.values.put("materialContainerTransition:shapeAppearance", d(view4, rectFH, oVar));
    }

    public static float h(float f10, View view) {
        return f10 != -1.0f ? f10 : u0.R(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static le.o t(@n0 View view, @p0 le.o oVar) {
        if (oVar != null) {
            return oVar;
        }
        int i10 = com.google.android.material.R.id.mtrl_motion_snapshot_view;
        if (view.getTag(i10) instanceof le.o) {
            return (le.o) view.getTag(i10);
        }
        Context context = view.getContext();
        int iD = D(context);
        return iD != -1 ? le.o.b(context, iD, 0).m() : view instanceof le.s ? ((le.s) view).getShapeAppearanceModel() : le.o.a().m();
    }

    @d0
    public int A() {
        return this.f51128f;
    }

    public final f B(boolean z10, f fVar, f fVar2) {
        if (!z10) {
            fVar = fVar2;
        }
        return new f((e) v.d(this.f51141s, fVar.f51157a), (e) v.d(this.f51142t, fVar.f51158b), (e) v.d(this.f51143u, fVar.f51159c), (e) v.d(this.f51144v, fVar.f51160d), null);
    }

    public int C() {
        return this.f51134l;
    }

    public boolean E() {
        return this.f51123a;
    }

    public boolean F() {
        return this.f51145w;
    }

    public final boolean G(@n0 RectF rectF, @n0 RectF rectF2) {
        int i10 = this.f51134l;
        if (i10 == 0) {
            return v.a(rectF2) > v.a(rectF);
        }
        if (i10 == 1) {
            return true;
        }
        if (i10 == 2) {
            return false;
        }
        throw new IllegalArgumentException("Invalid transition direction: " + this.f51134l);
    }

    public boolean H() {
        return this.f51124b;
    }

    public final void I(Context context, boolean z10) {
        v.r(this, context, com.google.android.material.R.attr.motionEasingEmphasizedInterpolator, kd.a.f37167b);
        v.q(this, context, z10 ? com.google.android.material.R.attr.motionDurationLong2 : com.google.android.material.R.attr.motionDurationMedium4);
        if (this.f51125c) {
            return;
        }
        v.s(this, context, com.google.android.material.R.attr.motionPath);
    }

    public void J(@g.l int i10) {
        this.f51130h = i10;
        this.f51131i = i10;
        this.f51132j = i10;
    }

    public void K(@g.l int i10) {
        this.f51130h = i10;
    }

    public void L(boolean z10) {
        this.f51123a = z10;
    }

    public void N(@d0 int i10) {
        this.f51127e = i10;
    }

    public void O(boolean z10) {
        this.f51145w = z10;
    }

    public void P(@g.l int i10) {
        this.f51132j = i10;
    }

    public void Q(float f10) {
        this.f51147y = f10;
    }

    public void R(@p0 le.o oVar) {
        this.f51140r = oVar;
    }

    public void S(@p0 View view) {
        this.f51138p = view;
    }

    public void V(@d0 int i10) {
        this.f51129g = i10;
    }

    public void Y(int i10) {
        this.f51135m = i10;
    }

    public void a0(@p0 e eVar) {
        this.f51141s = eVar;
    }

    public final f b(boolean z10) {
        PathMotion pathMotion = getPathMotion();
        return ((pathMotion instanceof ArcMotion) || (pathMotion instanceof k)) ? B(z10, G7, H7) : B(z10, E7, F7);
    }

    public void c0(int i10) {
        this.f51136n = i10;
    }

    @Override // android.transition.Transition
    public void captureEndValues(@n0 TransitionValues transitionValues) {
        e(transitionValues, this.f51138p, this.f51129g, this.f51140r);
    }

    @Override // android.transition.Transition
    public void captureStartValues(@n0 TransitionValues transitionValues) {
        e(transitionValues, this.f51137o, this.f51128f, this.f51139q);
    }

    @Override // android.transition.Transition
    @p0
    public Animator createAnimator(@n0 ViewGroup viewGroup, @p0 TransitionValues transitionValues, @p0 TransitionValues transitionValues2) {
        View viewE;
        View view;
        if (transitionValues != null && transitionValues2 != null) {
            RectF rectF = (RectF) transitionValues.values.get("materialContainerTransition:bounds");
            le.o oVar = (le.o) transitionValues.values.get("materialContainerTransition:shapeAppearance");
            if (rectF != null && oVar != null) {
                RectF rectF2 = (RectF) transitionValues2.values.get("materialContainerTransition:bounds");
                le.o oVar2 = (le.o) transitionValues2.values.get("materialContainerTransition:shapeAppearance");
                if (rectF2 != null && oVar2 != null) {
                    View view2 = transitionValues.view;
                    View view3 = transitionValues2.view;
                    View view4 = view3.getParent() != null ? view3 : view2;
                    if (this.f51127e == view4.getId()) {
                        viewE = (View) view4.getParent();
                        view = view4;
                    } else {
                        viewE = v.e(view4, this.f51127e);
                        view = null;
                    }
                    RectF rectFG = v.g(viewE);
                    float f10 = -rectFG.left;
                    float f11 = -rectFG.top;
                    RectF rectFC = c(viewE, view, f10, f11);
                    rectF.offset(f10, f11);
                    rectF2.offset(f10, f11);
                    boolean zG = G(rectF, rectF2);
                    if (!this.f51126d) {
                        I(view4.getContext(), zG);
                    }
                    h hVar = new h(getPathMotion(), view2, rectF, oVar, h(this.f51146x, view2), view3, rectF2, oVar2, h(this.f51147y, view3), this.f51130h, this.f51131i, this.f51132j, this.f51133k, zG, this.f51145w, te.b.a(this.f51135m, zG), te.g.a(this.f51136n, zG, rectF, rectF2), b(zG), this.f51123a, null);
                    hVar.setBounds(Math.round(rectFC.left), Math.round(rectFC.top), Math.round(rectFC.right), Math.round(rectFC.bottom));
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    valueAnimatorOfFloat.addUpdateListener(new a(hVar));
                    addListener(new b(viewE, hVar, view2, view3));
                    return valueAnimatorOfFloat;
                }
            }
        }
        return null;
    }

    public void d0(boolean z10) {
        this.f51124b = z10;
    }

    public void e0(@p0 e eVar) {
        this.f51143u = eVar;
    }

    @g.l
    public int f() {
        return this.f51130h;
    }

    public void f0(@p0 e eVar) {
        this.f51142t = eVar;
    }

    @d0
    public int g() {
        return this.f51127e;
    }

    public void g0(@g.l int i10) {
        this.f51133k = i10;
    }

    @Override // android.transition.Transition
    @p0
    public String[] getTransitionProperties() {
        return K2;
    }

    public void h0(@p0 e eVar) {
        this.f51144v = eVar;
    }

    @g.l
    public int i() {
        return this.f51132j;
    }

    public void i0(@g.l int i10) {
        this.f51131i = i10;
    }

    public float j() {
        return this.f51147y;
    }

    public void j0(float f10) {
        this.f51146x = f10;
    }

    @p0
    public le.o k() {
        return this.f51140r;
    }

    public void k0(@p0 le.o oVar) {
        this.f51139q = oVar;
    }

    @p0
    public View l() {
        return this.f51138p;
    }

    public void l0(@p0 View view) {
        this.f51137o = view;
    }

    @d0
    public int m() {
        return this.f51129g;
    }

    public void m0(@d0 int i10) {
        this.f51128f = i10;
    }

    public int n() {
        return this.f51135m;
    }

    public void n0(int i10) {
        this.f51134l = i10;
    }

    @p0
    public e o() {
        return this.f51141s;
    }

    public int p() {
        return this.f51136n;
    }

    @p0
    public e q() {
        return this.f51143u;
    }

    @p0
    public e r() {
        return this.f51142t;
    }

    @g.l
    public int s() {
        return this.f51133k;
    }

    @Override // android.transition.Transition
    public void setPathMotion(@p0 PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.f51125c = true;
    }

    @p0
    public e u() {
        return this.f51144v;
    }

    @g.l
    public int v() {
        return this.f51131i;
    }

    public float w() {
        return this.f51146x;
    }

    @p0
    public le.o x() {
        return this.f51139q;
    }

    @p0
    public View y() {
        return this.f51137o;
    }

    public l(@n0 Context context, boolean z10) {
        this.f51123a = false;
        this.f51124b = false;
        this.f51125c = false;
        this.f51126d = false;
        this.f51127e = R.id.content;
        this.f51128f = -1;
        this.f51129g = -1;
        this.f51130h = 0;
        this.f51131i = 0;
        this.f51132j = 0;
        this.f51133k = 1375731712;
        this.f51134l = 0;
        this.f51135m = 0;
        this.f51136n = 0;
        this.f51145w = Build.VERSION.SDK_INT >= 28;
        this.f51146x = -1.0f;
        this.f51147y = -1.0f;
        I(context, z10);
        this.f51126d = true;
    }
}
