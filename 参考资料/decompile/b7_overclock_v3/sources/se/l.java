package se;

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
import g.x;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import se.u;

/* JADX INFO: loaded from: classes7.dex */
public final class l extends androidx.transition.q {
    public static final f A8;
    public static final f C8;
    public static final float D8 = -1.0f;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public static final int f49727l8 = 0;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public static final int f49728m8 = 1;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public static final int f49729n8 = 2;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public static final int f49730o8 = 0;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public static final int f49731p8 = 1;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public static final int f49732q8 = 2;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public static final int f49733r8 = 3;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public static final int f49734s8 = 0;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public static final int f49735t8 = 1;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public static final int f49736u8 = 2;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public static final String f49738w8 = "materialContainerTransition:bounds";

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public static final String f49739x8 = "materialContainerTransition:shapeAppearance";
    public boolean M7;
    public boolean N7;
    public boolean O7;
    public boolean P7;

    @d0
    public int Q7;

    @d0
    public int R7;

    @d0
    public int S7;

    @g.l
    public int T7;

    @g.l
    public int U7;

    @g.l
    public int V7;

    @g.l
    public int W7;
    public int X7;
    public int Y7;
    public int Z7;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    @p0
    public View f49742a8;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    @p0
    public View f49743b8;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    @p0
    public le.o f49744c8;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    @p0
    public le.o f49745d8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    @p0
    public e f49746e8;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    @p0
    public e f49747f8;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    @p0
    public e f49748g8;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    @p0
    public e f49749h8;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public boolean f49750i8;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public float f49751j8;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public float f49752k8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public static final String f49737v8 = l.class.getSimpleName();

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public static final String[] f49740y8 = {"materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance"};

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    public static final f f49741z8 = new f(new e(0.0f, 0.25f), new e(0.0f, 1.0f), new e(0.0f, 1.0f), new e(0.0f, 0.75f), null);
    public static final f B8 = new f(new e(0.1f, 0.4f), new e(0.1f, 1.0f), new e(0.1f, 1.0f), new e(0.1f, 0.9f), null);

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f49753a;

        public a(h hVar) {
            this.f49753a = hVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f49753a.o(valueAnimator.getAnimatedFraction());
        }
    }

    public class b extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f49755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f49756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f49757c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View f49758d;

        public b(View view, h hVar, View view2, View view3) {
            this.f49755a = view;
            this.f49756b = hVar;
            this.f49757c = view2;
            this.f49758d = view3;
        }

        @Override // se.t, androidx.transition.q.h
        public void a(@n0 androidx.transition.q qVar) {
            b0.i(this.f49755a).a(this.f49756b);
            this.f49757c.setAlpha(0.0f);
            this.f49758d.setAlpha(0.0f);
        }

        @Override // se.t, androidx.transition.q.h
        public void c(@n0 androidx.transition.q qVar) {
            l.this.p0(this);
            if (l.this.N7) {
                return;
            }
            this.f49757c.setAlpha(1.0f);
            this.f49758d.setAlpha(1.0f);
            b0.i(this.f49755a).b(this.f49756b);
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
        public final float f49760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
        public final float f49761b;

        public e(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f11) {
            this.f49760a = f10;
            this.f49761b = f11;
        }

        @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
        public float c() {
            return this.f49761b;
        }

        @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
        public float d() {
            return this.f49760a;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final e f49762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @n0
        public final e f49763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @n0
        public final e f49764c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @n0
        public final e f49765d;

        public /* synthetic */ f(e eVar, e eVar2, e eVar3, e eVar4, a aVar) {
            this(eVar, eVar2, eVar3, eVar4);
        }

        public f(@n0 e eVar, @n0 e eVar2, @n0 e eVar3, @n0 e eVar4) {
            this.f49762a = eVar;
            this.f49763b = eVar2;
            this.f49764c = eVar3;
            this.f49765d = eVar4;
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
        public final se.a B;
        public final se.f C;
        public final boolean D;
        public final Paint E;
        public final Path F;
        public se.c G;
        public se.h H;
        public RectF I;
        public float J;
        public float K;
        public float L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f49766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RectF f49767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final le.o f49768c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f49769d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f49770e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final RectF f49771f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final le.o f49772g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f49773h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Paint f49774i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Paint f49775j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Paint f49776k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final Paint f49777l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final Paint f49778m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final j f49779n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final PathMeasure f49780o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final float f49781p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final float[] f49782q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final boolean f49783r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final float f49784s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final float f49785t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final boolean f49786u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final le.j f49787v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final RectF f49788w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final RectF f49789x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final RectF f49790y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final RectF f49791z;

        public class a implements u.c {
            public a() {
            }

            @Override // se.u.c
            public void a(Canvas canvas) {
                h.this.f49766a.draw(canvas);
            }
        }

        public class b implements u.c {
            public b() {
            }

            @Override // se.u.c
            public void a(Canvas canvas) {
                h.this.f49770e.draw(canvas);
            }
        }

        public /* synthetic */ h(g2.k kVar, View view, RectF rectF, le.o oVar, float f10, View view2, RectF rectF2, le.o oVar2, float f11, int i10, int i11, int i12, int i13, boolean z10, boolean z11, se.a aVar, se.f fVar, f fVar2, boolean z12, a aVar2) {
            this(kVar, view, rectF, oVar, f10, view2, rectF2, oVar2, f11, i10, i11, i12, i13, z10, z11, aVar, fVar, fVar2, z12);
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
            if (this.f49778m.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.f49778m);
            }
            int iSave = this.D ? canvas.save() : -1;
            if (this.f49786u && this.J > 0.0f) {
                h(canvas);
            }
            this.f49779n.a(canvas);
            n(canvas, this.f49774i);
            if (this.G.f49696c) {
                l(canvas);
                k(canvas);
            } else {
                k(canvas);
                l(canvas);
            }
            if (this.D) {
                canvas.restoreToCount(iSave);
                f(canvas, this.f49788w, this.F, -65281);
                g(canvas, this.f49789x, -256);
                g(canvas, this.f49788w, -16711936);
                g(canvas, this.f49791z, -16711681);
                g(canvas, this.f49790y, -16776961);
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
            canvas.clipPath(this.f49779n.d(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT > 28) {
                j(canvas);
            } else {
                i(canvas);
            }
            canvas.restore();
        }

        public final void i(Canvas canvas) {
            le.j jVar = this.f49787v;
            RectF rectF = this.I;
            jVar.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            this.f49787v.n0(this.J);
            this.f49787v.B0((int) this.K);
            this.f49787v.setShapeAppearanceModel(this.f49779n.c());
            this.f49787v.draw(canvas);
        }

        public final void j(Canvas canvas) {
            le.o oVarC = this.f49779n.c();
            if (!oVarC.u(this.I)) {
                canvas.drawPath(this.f49779n.d(), this.f49777l);
            } else {
                float fA = oVarC.r().a(this.I);
                canvas.drawRoundRect(this.I, fA, fA, this.f49777l);
            }
        }

        public final void k(Canvas canvas) {
            n(canvas, this.f49776k);
            Rect bounds = getBounds();
            RectF rectF = this.f49790y;
            u.w(canvas, bounds, rectF.left, rectF.top, this.H.f49717b, this.G.f49695b, new b());
        }

        public final void l(Canvas canvas) {
            n(canvas, this.f49775j);
            Rect bounds = getBounds();
            RectF rectF = this.f49788w;
            u.w(canvas, bounds, rectF.left, rectF.top, this.H.f49716a, this.G.f49694a, new a());
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
            this.f49778m.setAlpha((int) (this.f49783r ? u.k(0.0f, 255.0f, f10) : u.k(255.0f, 0.0f, f10)));
            this.f49780o.getPosTan(this.f49781p * f10, this.f49782q, null);
            float[] fArr = this.f49782q;
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
                this.f49780o.getPosTan(this.f49781p * f11, fArr, null);
                float[] fArr2 = this.f49782q;
                f13 += (f13 - fArr2[0]) * f12;
                f14 += (f14 - fArr2[1]) * f12;
            }
            float f15 = f13;
            float f16 = f14;
            se.h hVarA = this.C.a(f10, ((Float) androidx.core.util.o.l(Float.valueOf(this.A.f49763b.f49760a))).floatValue(), ((Float) androidx.core.util.o.l(Float.valueOf(this.A.f49763b.f49761b))).floatValue(), this.f49767b.width(), this.f49767b.height(), this.f49771f.width(), this.f49771f.height());
            this.H = hVarA;
            RectF rectF = this.f49788w;
            float f17 = hVarA.f49718c;
            rectF.set(f15 - (f17 / 2.0f), f16, (f17 / 2.0f) + f15, hVarA.f49719d + f16);
            RectF rectF2 = this.f49790y;
            se.h hVar = this.H;
            float f18 = hVar.f49720e;
            rectF2.set(f15 - (f18 / 2.0f), f16, f15 + (f18 / 2.0f), hVar.f49721f + f16);
            this.f49789x.set(this.f49788w);
            this.f49791z.set(this.f49790y);
            float fFloatValue = ((Float) androidx.core.util.o.l(Float.valueOf(this.A.f49764c.f49760a))).floatValue();
            float fFloatValue2 = ((Float) androidx.core.util.o.l(Float.valueOf(this.A.f49764c.f49761b))).floatValue();
            boolean zC = this.C.c(this.H);
            RectF rectF3 = zC ? this.f49789x : this.f49791z;
            float fL = u.l(0.0f, 1.0f, fFloatValue, fFloatValue2, f10);
            if (!zC) {
                fL = 1.0f - fL;
            }
            this.C.b(rectF3, fL, this.H);
            this.I = new RectF(Math.min(this.f49789x.left, this.f49791z.left), Math.min(this.f49789x.top, this.f49791z.top), Math.max(this.f49789x.right, this.f49791z.right), Math.max(this.f49789x.bottom, this.f49791z.bottom));
            this.f49779n.b(f10, this.f49768c, this.f49772g, this.f49788w, this.f49789x, this.f49791z, this.A.f49765d);
            this.J = u.k(this.f49769d, this.f49773h, f10);
            float fD = d(this.I, this.f49784s);
            float fE = e(this.I, this.f49785t);
            float f19 = this.J;
            float f20 = (int) (fE * f19);
            this.K = f20;
            this.f49777l.setShadowLayer(f19, (int) (fD * f19), f20, 754974720);
            this.G = this.B.a(f10, ((Float) androidx.core.util.o.l(Float.valueOf(this.A.f49762a.f49760a))).floatValue(), ((Float) androidx.core.util.o.l(Float.valueOf(this.A.f49762a.f49761b))).floatValue(), 0.35f);
            if (this.f49775j.getColor() != 0) {
                this.f49775j.setAlpha(this.G.f49694a);
            }
            if (this.f49776k.getColor() != 0) {
                this.f49776k.setAlpha(this.G.f49695b);
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

        public h(g2.k kVar, View view, RectF rectF, le.o oVar, float f10, View view2, RectF rectF2, le.o oVar2, float f11, @g.l int i10, @g.l int i11, @g.l int i12, int i13, boolean z10, boolean z11, se.a aVar, se.f fVar, f fVar2, boolean z12) {
            Paint paint = new Paint();
            this.f49774i = paint;
            Paint paint2 = new Paint();
            this.f49775j = paint2;
            Paint paint3 = new Paint();
            this.f49776k = paint3;
            this.f49777l = new Paint();
            Paint paint4 = new Paint();
            this.f49778m = paint4;
            this.f49779n = new j();
            this.f49782q = new float[]{rectF.centerX(), rectF.top};
            le.j jVar = new le.j();
            this.f49787v = jVar;
            Paint paint5 = new Paint();
            this.E = paint5;
            this.F = new Path();
            this.f49766a = view;
            this.f49767b = rectF;
            this.f49768c = oVar;
            this.f49769d = f10;
            this.f49770e = view2;
            this.f49771f = rectF2;
            this.f49772g = oVar2;
            this.f49773h = f11;
            this.f49783r = z10;
            this.f49786u = z11;
            this.B = aVar;
            this.C = fVar;
            this.A = fVar2;
            this.D = z12;
            WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(new DisplayMetrics());
            this.f49784s = r12.widthPixels;
            this.f49785t = r12.heightPixels;
            paint.setColor(i10);
            paint2.setColor(i11);
            paint3.setColor(i12);
            jVar.o0(ColorStateList.valueOf(0));
            jVar.x0(2);
            jVar.u0(false);
            jVar.v0(-7829368);
            RectF rectF3 = new RectF(rectF);
            this.f49788w = rectF3;
            this.f49789x = new RectF(rectF3);
            RectF rectF4 = new RectF(rectF3);
            this.f49790y = rectF4;
            this.f49791z = new RectF(rectF4);
            PointF pointFM = m(rectF);
            PointF pointFM2 = m(rectF2);
            PathMeasure pathMeasure = new PathMeasure(kVar.a(pointFM.x, pointFM.y, pointFM2.x, pointFM2.y), false);
            this.f49780o = pathMeasure;
            this.f49781p = pathMeasure.getLength();
            paint4.setStyle(Paint.Style.FILL);
            paint4.setShader(u.c(i13));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            p(0.0f);
        }
    }

    static {
        a aVar = null;
        A8 = new f(new e(0.6f, 0.9f), new e(0.0f, 1.0f), new e(0.0f, 0.9f), new e(0.3f, 0.9f), aVar);
        C8 = new f(new e(0.6f, 0.9f), new e(0.0f, 0.9f), new e(0.0f, 0.9f), new e(0.2f, 0.9f), aVar);
    }

    public l() {
        this.M7 = false;
        this.N7 = false;
        this.O7 = false;
        this.P7 = false;
        this.Q7 = R.id.content;
        this.R7 = -1;
        this.S7 = -1;
        this.T7 = 0;
        this.U7 = 0;
        this.V7 = 0;
        this.W7 = 1375731712;
        this.X7 = 0;
        this.Y7 = 0;
        this.Z7 = 0;
        this.f49750i8 = Build.VERSION.SDK_INT >= 28;
        this.f49751j8 = -1.0f;
        this.f49752k8 = -1.0f;
    }

    public static RectF J0(View view, @p0 View view2, float f10, float f11) {
        if (view2 == null) {
            return new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
        }
        RectF rectFG = u.g(view2);
        rectFG.offset(f10, f11);
        return rectFG;
    }

    public static le.o K0(@n0 View view, @n0 RectF rectF, @p0 le.o oVar) {
        return u.b(a1(view, oVar), rectF);
    }

    public static void L0(@n0 g2.q qVar, @p0 View view, @d0 int i10, @p0 le.o oVar) {
        if (i10 != -1) {
            qVar.f28973b = u.f(qVar.f28973b, i10);
        } else if (view != null) {
            qVar.f28973b = view;
        } else {
            View view2 = qVar.f28973b;
            int i11 = com.google.android.material.R.id.mtrl_motion_snapshot_view;
            if (view2.getTag(i11) instanceof View) {
                View view3 = (View) qVar.f28973b.getTag(i11);
                qVar.f28973b.setTag(i11, null);
                qVar.f28973b = view3;
            }
        }
        View view4 = qVar.f28973b;
        if (!u0.U0(view4) && view4.getWidth() == 0 && view4.getHeight() == 0) {
            return;
        }
        RectF rectFH = view4.getParent() == null ? u.h(view4) : u.g(view4);
        qVar.f28972a.put("materialContainerTransition:bounds", rectFH);
        qVar.f28972a.put("materialContainerTransition:shapeAppearance", K0(view4, rectFH, oVar));
    }

    public static float O0(float f10, View view) {
        return f10 != -1.0f ? f10 : u0.R(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static le.o a1(@n0 View view, @p0 le.o oVar) {
        if (oVar != null) {
            return oVar;
        }
        int i10 = com.google.android.material.R.id.mtrl_motion_snapshot_view;
        if (view.getTag(i10) instanceof le.o) {
            return (le.o) view.getTag(i10);
        }
        Context context = view.getContext();
        int iJ1 = j1(context);
        return iJ1 != -1 ? le.o.b(context, iJ1, 0).m() : view instanceof le.s ? ((le.s) view).getShapeAppearanceModel() : le.o.a().m();
    }

    @d1
    public static int j1(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{com.google.android.material.R.attr.transitionShapeAppearance});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public void A1(@p0 e eVar) {
        this.f49746e8 = eVar;
    }

    public void B1(int i10) {
        this.Z7 = i10;
    }

    @Override // androidx.transition.q
    public void C0(@p0 g2.k kVar) {
        super.C0(kVar);
        this.O7 = true;
    }

    public void C1(boolean z10) {
        this.N7 = z10;
    }

    public void D1(@p0 e eVar) {
        this.f49748g8 = eVar;
    }

    public void E1(@p0 e eVar) {
        this.f49747f8 = eVar;
    }

    public void F1(@g.l int i10) {
        this.W7 = i10;
    }

    public void G1(@p0 e eVar) {
        this.f49749h8 = eVar;
    }

    public void H1(@g.l int i10) {
        this.U7 = i10;
    }

    public final f I0(boolean z10) {
        g2.k kVarN = N();
        return ((kVarN instanceof androidx.transition.b) || (kVarN instanceof k)) ? h1(z10, B8, C8) : h1(z10, f49741z8, A8);
    }

    public void I1(float f10) {
        this.f49751j8 = f10;
    }

    public void J1(@p0 le.o oVar) {
        this.f49744c8 = oVar;
    }

    public void K1(@p0 View view) {
        this.f49742a8 = view;
    }

    public void L1(@d0 int i10) {
        this.R7 = i10;
    }

    @g.l
    public int M0() {
        return this.T7;
    }

    public void M1(int i10) {
        this.X7 = i10;
    }

    @d0
    public int N0() {
        return this.Q7;
    }

    @g.l
    public int P0() {
        return this.V7;
    }

    public float Q0() {
        return this.f49752k8;
    }

    @p0
    public le.o R0() {
        return this.f49745d8;
    }

    @p0
    public View S0() {
        return this.f49743b8;
    }

    @d0
    public int T0() {
        return this.S7;
    }

    public int U0() {
        return this.Y7;
    }

    @p0
    public e V0() {
        return this.f49746e8;
    }

    public int W0() {
        return this.Z7;
    }

    @p0
    public e X0() {
        return this.f49748g8;
    }

    @p0
    public e Y0() {
        return this.f49747f8;
    }

    @g.l
    public int Z0() {
        return this.W7;
    }

    @Override // androidx.transition.q
    @p0
    public String[] a0() {
        return f49740y8;
    }

    @p0
    public e b1() {
        return this.f49749h8;
    }

    @g.l
    public int c1() {
        return this.U7;
    }

    public float d1() {
        return this.f49751j8;
    }

    @p0
    public le.o e1() {
        return this.f49744c8;
    }

    @p0
    public View f1() {
        return this.f49742a8;
    }

    @d0
    public int g1() {
        return this.R7;
    }

    public final f h1(boolean z10, f fVar, f fVar2) {
        if (!z10) {
            fVar = fVar2;
        }
        return new f((e) u.d(this.f49746e8, fVar.f49762a), (e) u.d(this.f49747f8, fVar.f49763b), (e) u.d(this.f49748g8, fVar.f49764c), (e) u.d(this.f49749h8, fVar.f49765d), null);
    }

    public int i1() {
        return this.X7;
    }

    @Override // androidx.transition.q
    public void j(@n0 g2.q qVar) {
        L0(qVar, this.f49743b8, this.S7, this.f49745d8);
    }

    public boolean k1() {
        return this.M7;
    }

    public boolean l1() {
        return this.f49750i8;
    }

    @Override // androidx.transition.q
    public void m(@n0 g2.q qVar) {
        L0(qVar, this.f49742a8, this.R7, this.f49744c8);
    }

    public final boolean m1(@n0 RectF rectF, @n0 RectF rectF2) {
        int i10 = this.X7;
        if (i10 == 0) {
            return u.a(rectF2) > u.a(rectF);
        }
        if (i10 == 1) {
            return true;
        }
        if (i10 == 2) {
            return false;
        }
        throw new IllegalArgumentException("Invalid transition direction: " + this.X7);
    }

    public boolean n1() {
        return this.N7;
    }

    public final void o1(Context context, boolean z10) {
        u.r(this, context, com.google.android.material.R.attr.motionEasingEmphasizedInterpolator, kd.a.f37167b);
        u.q(this, context, z10 ? com.google.android.material.R.attr.motionDurationLong2 : com.google.android.material.R.attr.motionDurationMedium4);
        if (this.O7) {
            return;
        }
        u.s(this, context, com.google.android.material.R.attr.motionPath);
    }

    public void p1(@g.l int i10) {
        this.T7 = i10;
        this.U7 = i10;
        this.V7 = i10;
    }

    @Override // androidx.transition.q
    @p0
    public Animator q(@n0 ViewGroup viewGroup, @p0 g2.q qVar, @p0 g2.q qVar2) {
        View viewE;
        View view;
        if (qVar != null && qVar2 != null) {
            RectF rectF = (RectF) qVar.f28972a.get("materialContainerTransition:bounds");
            le.o oVar = (le.o) qVar.f28972a.get("materialContainerTransition:shapeAppearance");
            if (rectF != null && oVar != null) {
                RectF rectF2 = (RectF) qVar2.f28972a.get("materialContainerTransition:bounds");
                le.o oVar2 = (le.o) qVar2.f28972a.get("materialContainerTransition:shapeAppearance");
                if (rectF2 != null && oVar2 != null) {
                    View view2 = qVar.f28973b;
                    View view3 = qVar2.f28973b;
                    View view4 = view3.getParent() != null ? view3 : view2;
                    if (this.Q7 == view4.getId()) {
                        viewE = (View) view4.getParent();
                        view = view4;
                    } else {
                        viewE = u.e(view4, this.Q7);
                        view = null;
                    }
                    RectF rectFG = u.g(viewE);
                    float f10 = -rectFG.left;
                    float f11 = -rectFG.top;
                    RectF rectFJ0 = J0(viewE, view, f10, f11);
                    rectF.offset(f10, f11);
                    rectF2.offset(f10, f11);
                    boolean zM1 = m1(rectF, rectF2);
                    if (!this.P7) {
                        o1(view4.getContext(), zM1);
                    }
                    h hVar = new h(N(), view2, rectF, oVar, O0(this.f49751j8, view2), view3, rectF2, oVar2, O0(this.f49752k8, view3), this.T7, this.U7, this.V7, this.W7, zM1, this.f49750i8, se.b.a(this.Y7, zM1), se.g.a(this.Z7, zM1, rectF, rectF2), I0(zM1), this.M7, null);
                    hVar.setBounds(Math.round(rectFJ0.left), Math.round(rectFJ0.top), Math.round(rectFJ0.right), Math.round(rectFJ0.bottom));
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    valueAnimatorOfFloat.addUpdateListener(new a(hVar));
                    a(new b(viewE, hVar, view2, view3));
                    return valueAnimatorOfFloat;
                }
            }
        }
        return null;
    }

    public void q1(@g.l int i10) {
        this.T7 = i10;
    }

    public void r1(boolean z10) {
        this.M7 = z10;
    }

    public void s1(@d0 int i10) {
        this.Q7 = i10;
    }

    public void t1(boolean z10) {
        this.f49750i8 = z10;
    }

    public void u1(@g.l int i10) {
        this.V7 = i10;
    }

    public void v1(float f10) {
        this.f49752k8 = f10;
    }

    public void w1(@p0 le.o oVar) {
        this.f49745d8 = oVar;
    }

    public void x1(@p0 View view) {
        this.f49743b8 = view;
    }

    public void y1(@d0 int i10) {
        this.S7 = i10;
    }

    public void z1(int i10) {
        this.Y7 = i10;
    }

    public l(@n0 Context context, boolean z10) {
        this.M7 = false;
        this.N7 = false;
        this.O7 = false;
        this.P7 = false;
        this.Q7 = R.id.content;
        this.R7 = -1;
        this.S7 = -1;
        this.T7 = 0;
        this.U7 = 0;
        this.V7 = 0;
        this.W7 = 1375731712;
        this.X7 = 0;
        this.Y7 = 0;
        this.Z7 = 0;
        this.f49750i8 = Build.VERSION.SDK_INT >= 28;
        this.f49751j8 = -1.0f;
        this.f49752k8 = -1.0f;
        o1(context, z10);
        this.P7 = true;
    }
}
