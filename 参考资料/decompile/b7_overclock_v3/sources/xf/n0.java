package xf;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes7.dex */
public class n0 extends i implements h {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f55273j = 8000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f55274k = 450;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f55275l = 600;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static int f55276m = 8000;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f55277n = 450;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f55278o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f55279p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f55280q = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f55281r = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f55282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f55283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Animator f55284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f55285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f55286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f55287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f55288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f55289h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AnimatorListenerAdapter f55290i;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            n0.this.f55288g = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            n0.this.invalidate();
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            n0.this.f();
        }
    }

    public n0(Context context) {
        this(context, null);
    }

    @Override // xf.i, xf.h
    public void a() {
        if (getVisibility() == 8) {
            setVisibility(0);
            this.f55288g = 0.0f;
            h(false);
        }
    }

    @Override // xf.i, xf.b0
    public FrameLayout.LayoutParams b() {
        return new FrameLayout.LayoutParams(-1, f55281r);
    }

    @Override // xf.i, xf.h
    public void c() {
        this.f55286e = 2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (this.f55288g / 100.0f) * Float.valueOf(getWidth()).floatValue(), getHeight(), this.f55283b);
    }

    public final void f() {
        if (this.f55286e == 2 && this.f55288g == 100.0f) {
            setVisibility(8);
            this.f55288g = 0.0f;
            setAlpha(1.0f);
        }
        this.f55286e = 0;
    }

    public final void g(Context context, AttributeSet attributeSet, int i10) {
        this.f55283b = new Paint();
        this.f55282a = Color.parseColor("#1aad19");
        this.f55283b.setAntiAlias(true);
        this.f55283b.setColor(this.f55282a);
        this.f55283b.setDither(true);
        this.f55283b.setStrokeCap(Paint.Cap.SQUARE);
        this.f55285d = context.getResources().getDisplayMetrics().widthPixels;
        f55281r = com.just.agentweb.a.n(context, 3.0f);
    }

    public final void h(boolean z10) {
        float f10 = z10 ? 100.0f : 95.0f;
        Animator animator = this.f55284c;
        if (animator != null && animator.isStarted()) {
            this.f55284c.cancel();
        }
        float f11 = this.f55288g;
        if (f11 == 0.0f) {
            f11 = 1.0E-8f;
        }
        this.f55288g = f11;
        c0.c("WebIndicator", "mCurrentProgress:" + this.f55288g + " v:" + f10 + "  :" + (1.0f - this.f55288g));
        if (z10) {
            ValueAnimator valueAnimatorOfFloat = null;
            float f12 = this.f55288g;
            if (f12 < 95.0f) {
                valueAnimatorOfFloat = ValueAnimator.ofFloat(f12, 95.0f);
                float f13 = (1.0f - (this.f55288g / 100.0f)) - 0.05f;
                valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                valueAnimatorOfFloat.setDuration((long) (f13 * f55277n));
                valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
                valueAnimatorOfFloat.addUpdateListener(this.f55289h);
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setDuration(600L);
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(95.0f, 100.0f);
            valueAnimatorOfFloat2.setDuration(600L);
            valueAnimatorOfFloat2.addUpdateListener(this.f55289h);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfFloat, valueAnimatorOfFloat2);
            if (valueAnimatorOfFloat != null) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.play(animatorSet).after(valueAnimatorOfFloat);
                animatorSet = animatorSet2;
            }
            animatorSet.addListener(this.f55290i);
            animatorSet.start();
            this.f55284c = animatorSet;
        } else {
            ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(this.f55288g, f10);
            float f14 = (1.0f - (this.f55288g / 100.0f)) - 0.05f;
            valueAnimatorOfFloat3.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat3.setDuration((long) (f14 * f55276m));
            valueAnimatorOfFloat3.addUpdateListener(this.f55289h);
            valueAnimatorOfFloat3.start();
            this.f55284c = valueAnimatorOfFloat3;
        }
        this.f55286e = 1;
        this.f55287f = f10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.f55284c;
        if (animator == null || !animator.isStarted()) {
            return;
        }
        this.f55284c.cancel();
        this.f55284c = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE && size > getContext().getResources().getDisplayMetrics().widthPixels) {
            size = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = f55281r;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f55285d = getMeasuredWidth();
        int i14 = getContext().getResources().getDisplayMetrics().widthPixels;
        int i15 = this.f55285d;
        if (i15 >= i14) {
            f55277n = f55274k;
            f55276m = 8000;
        } else {
            float fFloatValue = i15 / Float.valueOf(i14).floatValue();
            f55276m = (int) (8000.0f * fFloatValue);
            f55277n = (int) (fFloatValue * 450.0f);
        }
        c0.c("WebProgress", "CURRENT_MAX_UNIFORM_SPEED_DURATION" + f55276m);
    }

    @Override // xf.i, xf.h
    public void reset() {
        this.f55288g = 0.0f;
        Animator animator = this.f55284c;
        if (animator == null || !animator.isStarted()) {
            return;
        }
        this.f55284c.cancel();
    }

    public void setColor(int i10) {
        this.f55282a = i10;
        this.f55283b.setColor(i10);
    }

    public void setProgress(float f10) {
        if (getVisibility() == 8) {
            setVisibility(0);
        }
        if (f10 >= 95.0f && this.f55286e != 2) {
            h(true);
        }
    }

    public n0(Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public n0(Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f55285d = 0;
        this.f55286e = 0;
        this.f55287f = 0.0f;
        this.f55288g = 0.0f;
        this.f55289h = new a();
        this.f55290i = new b();
        g(context, attributeSet, i10);
    }

    public void setColor(String str) {
        setColor(Color.parseColor(str));
    }

    @Override // xf.i, xf.h
    public void setProgress(int i10) {
        setProgress(Float.valueOf(i10).floatValue());
    }
}
