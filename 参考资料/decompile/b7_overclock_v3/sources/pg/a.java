package pg;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import g.l;
import g.n;
import g.n0;
import mg.g;
import mg.j;

/* JADX INFO: loaded from: classes5.dex */
public class a extends rg.b implements g {
    public static final byte A = 1;
    public static final byte B = 2;
    public static final byte C = 3;
    public static final byte D = 4;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final byte f46610z = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f46611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f46612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f46613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f46614g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f46615h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f46616i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Path f46617j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Paint f46618k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f46619l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f46620m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f46621n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f46622o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f46623p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f46624q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f46625r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f46626s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f46627t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f46628u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f46629v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f46630w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Animator f46631x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public RectF f46632y;

    /* JADX INFO: renamed from: pg.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0529a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46633a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f46633a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46633a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte f46634a;

        public b(byte b10) {
            this.f46634a = b10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            byte b10 = this.f46634a;
            if (b10 == 0) {
                a.this.f46630w = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (1 == b10) {
                a aVar = a.this;
                if (aVar.f46615h) {
                    valueAnimator.cancel();
                    return;
                }
                aVar.f46620m = ((Integer) valueAnimator.getAnimatedValue()).intValue() / 2;
            } else if (2 == b10) {
                a.this.f46623p = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (3 == b10) {
                a.this.f46626s = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (4 == b10) {
                a.this.f46627t = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
            a.this.invalidate();
        }
    }

    public a(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = isInEditMode() ? getHeight() : this.f46622o;
        u(canvas, width);
        g(canvas, width, height);
        o(canvas, width, height);
        t(canvas, width, height);
        super.dispatchDraw(canvas);
    }

    @Override // rg.b, mg.h
    public void f(float f10, int i10, int i11) {
        this.f46621n = i10;
        invalidate();
    }

    public void g(Canvas canvas, int i10, int i11) {
        if (this.f46623p > 0.0f) {
            this.f46618k.setColor(this.f46611d);
            float fJ = tg.b.j(i11);
            float f10 = i10;
            float f11 = (f10 * 1.0f) / 7.0f;
            float f12 = this.f46624q;
            float f13 = (f11 * f12) - (f12 > 1.0f ? ((f12 - 1.0f) * f11) / f12 : 0.0f);
            float f14 = i11;
            float f15 = f14 - (f12 > 1.0f ? (((f12 - 1.0f) * f14) / 2.0f) / f12 : 0.0f);
            int i12 = 0;
            while (i12 < 7) {
                i12++;
                float f16 = f15;
                this.f46618k.setAlpha((int) (((double) (this.f46623p * (1 - ((Math.abs(r10) / 7) * 2)) * 255)) * (1.0d - (1.0d / Math.pow((((double) fJ) / 800.0d) + 1.0d, 15.0d)))));
                float f17 = this.f46625r * (1.0f - (1.0f / ((fJ / 10.0f) + 1.0f)));
                canvas.drawCircle(((f10 / 2.0f) - (f17 / 2.0f)) + ((i12 - 4) * f13), f16 / 2.0f, f17, this.f46618k);
                f15 = f16;
            }
            this.f46618k.setAlpha(255);
        }
    }

    @Override // rg.b, sg.f
    public void h(@n0 j jVar, @n0 RefreshState refreshState, @n0 RefreshState refreshState2) {
        int i10 = C0529a.f46633a[refreshState2.ordinal()];
        if (i10 == 1 || i10 == 2) {
            this.f46623p = 1.0f;
            this.f46630w = 0.0f;
            this.f46626s = 0.0f;
        }
    }

    @Override // rg.b, mg.h
    public void i(@n0 j jVar, int i10, int i11) {
        this.f46619l = i10 - 1;
        this.f46615h = false;
        tg.b bVar = new tg.b(tg.b.f51277c);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setInterpolator(bVar);
        valueAnimatorOfFloat.addUpdateListener(new b((byte) 2));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(bVar);
        valueAnimatorOfFloat2.addUpdateListener(new b((byte) 0));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 360);
        valueAnimatorOfInt.setDuration(720L);
        valueAnimatorOfInt.setRepeatCount(-1);
        valueAnimatorOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfInt.addUpdateListener(new b((byte) 4));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(valueAnimatorOfFloat, valueAnimatorOfFloat2, valueAnimatorOfInt);
        animatorSet.start();
        int i12 = this.f46620m;
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(i12, 0, -((int) (i12 * 0.8f)), 0, -((int) (i12 * 0.4f)), 0);
        valueAnimatorOfInt2.addUpdateListener(new b((byte) 1));
        valueAnimatorOfInt2.setInterpolator(new tg.b(tg.b.f51277c));
        valueAnimatorOfInt2.setDuration(800L);
        valueAnimatorOfInt2.start();
        this.f46631x = animatorSet;
    }

    @Override // rg.b, mg.h
    public boolean j() {
        return this.f46616i;
    }

    @Override // rg.b, mg.h
    public int l(@n0 j jVar, boolean z10) {
        Animator animator = this.f46631x;
        if (animator != null) {
            animator.removeAllListeners();
            this.f46631x.end();
            this.f46631x = null;
        }
        int width = getWidth();
        int i10 = this.f46622o;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f46628u, (float) Math.sqrt((width * width) + (i10 * i10)));
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.addUpdateListener(new b((byte) 3));
        valueAnimatorOfFloat.start();
        return 400;
    }

    public void o(Canvas canvas, int i10, int i11) {
        if (this.f46631x != null || isInEditMode()) {
            float f10 = this.f46628u;
            float f11 = this.f46630w;
            float f12 = f10 * f11;
            float f13 = this.f46629v * f11;
            this.f46618k.setColor(this.f46611d);
            this.f46618k.setStyle(Paint.Style.FILL);
            float f14 = i10 / 2.0f;
            float f15 = i11 / 2.0f;
            canvas.drawCircle(f14, f15, f12, this.f46618k);
            this.f46618k.setStyle(Paint.Style.STROKE);
            float f16 = f13 + f12;
            canvas.drawCircle(f14, f15, f16, this.f46618k);
            this.f46618k.setColor((this.f46612e & 16777215) | 1426063360);
            this.f46618k.setStyle(Paint.Style.FILL);
            this.f46632y.set(f14 - f12, f15 - f12, f14 + f12, f12 + f15);
            canvas.drawArc(this.f46632y, 270.0f, this.f46627t, true, this.f46618k);
            this.f46618k.setStyle(Paint.Style.STROKE);
            this.f46632y.set(f14 - f16, f15 - f16, f14 + f16, f15 + f16);
            canvas.drawArc(this.f46632y, 270.0f, this.f46627t, false, this.f46618k);
            this.f46618k.setStyle(Paint.Style.FILL);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.f46631x;
        if (animator != null) {
            animator.removeAllListeners();
            this.f46631x.end();
            this.f46631x = null;
        }
    }

    @Override // rg.b, mg.h
    public void r(boolean z10, float f10, int i10, int i11, int i12) {
        this.f46622o = i10;
        if (z10 || this.f46615h) {
            this.f46615h = true;
            this.f46619l = Math.min(i11, i10);
            this.f46620m = (int) (Math.max(0, i10 - i11) * 1.9f);
            this.f46624q = f10;
            invalidate();
        }
    }

    @Override // rg.b, mg.h
    @Deprecated
    public void setPrimaryColors(@l int... iArr) {
        if (iArr.length > 0 && !this.f46613f) {
            y(iArr[0]);
            this.f46613f = false;
        }
        if (iArr.length <= 1 || this.f46614g) {
            return;
        }
        v(iArr[1]);
        this.f46614g = false;
    }

    public void t(Canvas canvas, int i10, int i11) {
        if (this.f46626s > 0.0f) {
            this.f46618k.setColor(this.f46611d);
            canvas.drawCircle(i10 / 2.0f, i11 / 2.0f, this.f46626s, this.f46618k);
        }
    }

    public void u(Canvas canvas, int i10) {
        this.f46617j.reset();
        this.f46617j.lineTo(0.0f, this.f46619l);
        Path path = this.f46617j;
        int i11 = this.f46621n;
        float f10 = i11 >= 0 ? i11 : i10 / 2.0f;
        float f11 = i10;
        path.quadTo(f10, this.f46620m + r3, f11, this.f46619l);
        this.f46617j.lineTo(f11, 0.0f);
        this.f46618k.setColor(this.f46612e);
        canvas.drawPath(this.f46617j, this.f46618k);
    }

    public a v(@l int i10) {
        this.f46611d = i10;
        this.f46614g = true;
        return this;
    }

    public a w(@n int i10) {
        v(h0.d.f(getContext(), i10));
        return this;
    }

    public a x(boolean z10) {
        this.f46616i = z10;
        if (!z10) {
            this.f46621n = -1;
        }
        return this;
    }

    public a y(@l int i10) {
        this.f46612e = i10;
        this.f46613f = true;
        return this;
    }

    public a z(@n int i10) {
        y(h0.d.f(getContext(), i10));
        return this;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f46616i = false;
        this.f46621n = -1;
        this.f46622o = 0;
        this.f46627t = 0;
        this.f46628u = 0.0f;
        this.f46629v = 0.0f;
        this.f46630w = 0.0f;
        this.f46632y = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f48755b = ng.b.f42145f;
        this.f46617j = new Path();
        Paint paint = new Paint();
        this.f46618k = paint;
        paint.setAntiAlias(true);
        this.f46625r = tg.b.d(7.0f);
        this.f46628u = tg.b.d(20.0f);
        this.f46629v = tg.b.d(7.0f);
        this.f46618k.setStrokeWidth(tg.b.d(3.0f));
        setMinimumHeight(tg.b.d(100.0f));
        if (isInEditMode()) {
            this.f46619l = 1000;
            this.f46630w = 1.0f;
            this.f46627t = 270;
        } else {
            this.f46630w = 0.0f;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BezierRadarHeader);
        this.f46616i = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BezierRadarHeader_srlEnableHorizontalDrag, this.f46616i);
        int i10 = R.styleable.BezierRadarHeader_srlAccentColor;
        v(typedArrayObtainStyledAttributes.getColor(i10, -1));
        int i11 = R.styleable.BezierRadarHeader_srlPrimaryColor;
        y(typedArrayObtainStyledAttributes.getColor(i11, -14540254));
        this.f46614g = typedArrayObtainStyledAttributes.hasValue(i10);
        this.f46613f = typedArrayObtainStyledAttributes.hasValue(i11);
        typedArrayObtainStyledAttributes.recycle();
    }
}
