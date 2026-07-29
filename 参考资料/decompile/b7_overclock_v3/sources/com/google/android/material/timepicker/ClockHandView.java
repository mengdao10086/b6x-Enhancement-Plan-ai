package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.u0;
import com.google.android.material.R;
import g.p0;
import g.r;
import g.t0;
import g.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
class ClockHandView extends View {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f21064r = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ValueAnimator f21065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f21066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f21067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f21068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f21069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<d> f21071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f21072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f21073i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f21074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f21075k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @t0
    public final int f21076l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f21077m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f21078n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c f21079o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public double f21080p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f21081q;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.this.n(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface c {
        void f(@x(from = 0.0d, to = 360.0d) float f10, boolean z10);
    }

    public interface d {
        void e(@x(from = 0.0d, to = 360.0d) float f10, boolean z10);
    }

    public ClockHandView(Context context) {
        this(context, null);
    }

    public void b(d dVar) {
        this.f21071g.add(dVar);
    }

    public final void c(Canvas canvas) {
        int height = getHeight() / 2;
        float width = getWidth() / 2;
        float fCos = (this.f21081q * ((float) Math.cos(this.f21080p))) + width;
        float f10 = height;
        float fSin = (this.f21081q * ((float) Math.sin(this.f21080p))) + f10;
        this.f21074j.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f21072h, this.f21074j);
        double dSin = Math.sin(this.f21080p);
        double dCos = Math.cos(this.f21080p);
        this.f21074j.setStrokeWidth(this.f21076l);
        canvas.drawLine(width, f10, r1 + ((int) (dCos * d)), height + ((int) (d * dSin)), this.f21074j);
        canvas.drawCircle(width, f10, this.f21073i, this.f21074j);
    }

    public RectF d() {
        return this.f21075k;
    }

    public final int e(float f10, float f11) {
        int degrees = ((int) Math.toDegrees(Math.atan2(f11 - (getHeight() / 2), f10 - (getWidth() / 2)))) + 90;
        return degrees < 0 ? degrees + 360 : degrees;
    }

    @x(from = 0.0d, to = 360.0d)
    public float f() {
        return this.f21077m;
    }

    public int g() {
        return this.f21072h;
    }

    public final Pair<Float, Float> h(float f10) {
        float f11 = f();
        if (Math.abs(f11 - f10) > 180.0f) {
            if (f11 > 180.0f && f10 < 180.0f) {
                f10 += 360.0f;
            }
            if (f11 < 180.0f && f10 > 180.0f) {
                f11 += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(f11), Float.valueOf(f10));
    }

    public final boolean i(float f10, float f11, boolean z10, boolean z11, boolean z12) {
        float fE = e(f10, f11);
        boolean z13 = false;
        boolean z14 = f() != fE;
        if (z11 && z14) {
            return true;
        }
        if (!z14 && !z10) {
            return false;
        }
        if (z12 && this.f21066b) {
            z13 = true;
        }
        m(fE, z13);
        return true;
    }

    public void j(boolean z10) {
        this.f21066b = z10;
    }

    public void k(@r int i10) {
        this.f21081q = i10;
        invalidate();
    }

    public void l(@x(from = 0.0d, to = 360.0d) float f10) {
        m(f10, false);
    }

    public void m(@x(from = 0.0d, to = 360.0d) float f10, boolean z10) {
        ValueAnimator valueAnimator = this.f21065a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z10) {
            n(f10, false);
            return;
        }
        Pair<Float, Float> pairH = h(f10);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(((Float) pairH.first).floatValue(), ((Float) pairH.second).floatValue());
        this.f21065a = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(200L);
        this.f21065a.addUpdateListener(new a());
        this.f21065a.addListener(new b());
        this.f21065a.start();
    }

    public final void n(@x(from = 0.0d, to = 360.0d) float f10, boolean z10) {
        float f11 = f10 % 360.0f;
        this.f21077m = f11;
        this.f21080p = Math.toRadians(f11 - 90.0f);
        int height = getHeight() / 2;
        float width = (getWidth() / 2) + (this.f21081q * ((float) Math.cos(this.f21080p)));
        float fSin = height + (this.f21081q * ((float) Math.sin(this.f21080p)));
        RectF rectF = this.f21075k;
        int i10 = this.f21072h;
        rectF.set(width - i10, fSin - i10, width + i10, fSin + i10);
        Iterator<d> it2 = this.f21071g.iterator();
        while (it2.hasNext()) {
            it2.next().e(f11, z10);
        }
        invalidate();
    }

    public void o(c cVar) {
        this.f21079o = cVar;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        l(f());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        boolean z12;
        c cVar;
        int actionMasked = motionEvent.getActionMasked();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i10 = (int) (x10 - this.f21067c);
                int i11 = (int) (y10 - this.f21068d);
                this.f21069e = (i10 * i10) + (i11 * i11) > this.f21070f;
                boolean z13 = this.f21078n;
                z10 = actionMasked == 1;
                z11 = z13;
            } else {
                z10 = false;
                z11 = false;
            }
            z12 = false;
        } else {
            this.f21067c = x10;
            this.f21068d = y10;
            this.f21069e = true;
            this.f21078n = false;
            z10 = false;
            z11 = false;
            z12 = true;
        }
        boolean zI = i(x10, y10, z11, z12, z10) | this.f21078n;
        this.f21078n = zI;
        if (zI && z10 && (cVar = this.f21079o) != null) {
            cVar.f(e(x10, y10), this.f21069e);
        }
        return true;
    }

    public ClockHandView(Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    public ClockHandView(Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21071g = new ArrayList();
        Paint paint = new Paint();
        this.f21074j = paint;
        this.f21075k = new RectF();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockHandView, i10, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.f21081q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_materialCircleRadius, 0);
        this.f21072h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_selectorSize, 0);
        this.f21076l = getResources().getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f21073i = r6.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        l(0.0f);
        this.f21070f = ViewConfiguration.get(context).getScaledTouchSlop();
        u0.R1(this, 2);
        typedArrayObtainStyledAttributes.recycle();
    }
}
