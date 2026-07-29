package com.github.mikephil.charting.listener;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.ChartTouchListener;
import ja.f;
import oa.d;
import qa.e;
import xa.g;
import xa.k;
import xa.l;

/* JADX INFO: loaded from: classes3.dex */
public class a extends ChartTouchListener<ja.b<? extends la.c<? extends qa.b<? extends Entry>>>> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Matrix f16655m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Matrix f16656n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public g f16657o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public g f16658p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f16659q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f16660r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f16661s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public e f16662t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public VelocityTracker f16663u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f16664v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public g f16665w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public g f16666x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f16667y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f16668z;

    public a(ja.b<? extends la.c<? extends qa.b<? extends Entry>>> bVar, Matrix matrix, float f10) {
        super(bVar);
        this.f16655m = new Matrix();
        this.f16656n = new Matrix();
        this.f16657o = g.c(0.0f, 0.0f);
        this.f16658p = g.c(0.0f, 0.0f);
        this.f16659q = 1.0f;
        this.f16660r = 1.0f;
        this.f16661s = 1.0f;
        this.f16664v = 0L;
        this.f16665w = g.c(0.0f, 0.0f);
        this.f16666x = g.c(0.0f, 0.0f);
        this.f16655m = matrix;
        this.f16667y = k.e(f10);
        this.f16668z = k.e(3.5f);
    }

    public static float k(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
    }

    public static float l(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
    }

    public static void n(g gVar, MotionEvent motionEvent) {
        float x10 = motionEvent.getX(0) + motionEvent.getX(1);
        float y10 = motionEvent.getY(0) + motionEvent.getY(1);
        gVar.f54987c = x10 / 2.0f;
        gVar.f54988d = y10 / 2.0f;
    }

    public static float t(MotionEvent motionEvent) {
        float x10 = motionEvent.getX(0) - motionEvent.getX(1);
        float y10 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x10 * x10) + (y10 * y10));
    }

    public void h() {
        g gVar = this.f16666x;
        if (gVar.f54987c == 0.0f && gVar.f54988d == 0.0f) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f16666x.f54987c *= ((ja.b) this.f16654e).getDragDecelerationFrictionCoef();
        this.f16666x.f54988d *= ((ja.b) this.f16654e).getDragDecelerationFrictionCoef();
        float f10 = (jCurrentAnimationTimeMillis - this.f16664v) / 1000.0f;
        g gVar2 = this.f16666x;
        float f11 = gVar2.f54987c * f10;
        float f12 = gVar2.f54988d * f10;
        g gVar3 = this.f16665w;
        float f13 = gVar3.f54987c + f11;
        gVar3.f54987c = f13;
        float f14 = gVar3.f54988d + f12;
        gVar3.f54988d = f14;
        MotionEvent motionEventObtain = MotionEvent.obtain(jCurrentAnimationTimeMillis, jCurrentAnimationTimeMillis, 2, f13, f14, 0);
        o(motionEventObtain, ((ja.b) this.f16654e).u0() ? this.f16665w.f54987c - this.f16657o.f54987c : 0.0f, ((ja.b) this.f16654e).v0() ? this.f16665w.f54988d - this.f16657o.f54988d : 0.0f);
        motionEventObtain.recycle();
        this.f16655m = ((ja.b) this.f16654e).getViewPortHandler().S(this.f16655m, this.f16654e, false);
        this.f16664v = jCurrentAnimationTimeMillis;
        if (Math.abs(this.f16666x.f54987c) >= 0.01d || Math.abs(this.f16666x.f54988d) >= 0.01d) {
            k.K(this.f16654e);
            return;
        }
        ((ja.b) this.f16654e).p();
        ((ja.b) this.f16654e).postInvalidate();
        u();
    }

    public Matrix i() {
        return this.f16655m;
    }

    public g j(float f10, float f11) {
        l viewPortHandler = ((ja.b) this.f16654e).getViewPortHandler();
        return g.c(f10 - viewPortHandler.P(), m() ? -(f11 - viewPortHandler.R()) : -((((ja.b) this.f16654e).getMeasuredHeight() - f11) - viewPortHandler.O()));
    }

    public final boolean m() {
        e eVar;
        return (this.f16662t == null && ((ja.b) this.f16654e).p0()) || ((eVar = this.f16662t) != null && ((ja.b) this.f16654e).f(eVar.a1()));
    }

    public final void o(MotionEvent motionEvent, float f10, float f11) {
        this.f16650a = ChartTouchListener.ChartGesture.DRAG;
        this.f16655m.set(this.f16656n);
        b onChartGestureListener = ((ja.b) this.f16654e).getOnChartGestureListener();
        if (m()) {
            if (this.f16654e instanceof f) {
                f10 = -f10;
            } else {
                f11 = -f11;
            }
        }
        this.f16655m.postTranslate(f10, f11);
        if (onChartGestureListener != null) {
            onChartGestureListener.g(motionEvent, f10, f11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.f16650a = ChartTouchListener.ChartGesture.DOUBLE_TAP;
        b onChartGestureListener = ((ja.b) this.f16654e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.f(motionEvent);
        }
        if (((ja.b) this.f16654e).s0() && ((la.c) ((ja.b) this.f16654e).getData()).r() > 0) {
            g gVarJ = j(motionEvent.getX(), motionEvent.getY());
            T t10 = this.f16654e;
            ((ja.b) t10).R0(((ja.b) t10).B0() ? 1.4f : 1.0f, ((ja.b) this.f16654e).C0() ? 1.4f : 1.0f, gVarJ.f54987c, gVarJ.f54988d);
            if (((ja.b) this.f16654e).N()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Double-Tap, Zooming In, x: ");
                sb2.append(gVarJ.f54987c);
                sb2.append(", y: ");
                sb2.append(gVarJ.f54988d);
            }
            g.h(gVarJ);
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        this.f16650a = ChartTouchListener.ChartGesture.FLING;
        b onChartGestureListener = ((ja.b) this.f16654e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.c(motionEvent, motionEvent2, f10, f11);
        }
        return super.onFling(motionEvent, motionEvent2, f10, f11);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.f16650a = ChartTouchListener.ChartGesture.LONG_PRESS;
        b onChartGestureListener = ((ja.b) this.f16654e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.e(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f16650a = ChartTouchListener.ChartGesture.SINGLE_TAP;
        b onChartGestureListener = ((ja.b) this.f16654e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.d(motionEvent);
        }
        if (!((ja.b) this.f16654e).M()) {
            return false;
        }
        e(((ja.b) this.f16654e).x(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return super.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (this.f16663u == null) {
            this.f16663u = VelocityTracker.obtain();
        }
        this.f16663u.addMovement(motionEvent);
        if (motionEvent.getActionMasked() == 3 && (velocityTracker = this.f16663u) != null) {
            velocityTracker.recycle();
            this.f16663u = null;
        }
        if (this.f16651b == 0) {
            this.f16653d.onTouchEvent(motionEvent);
        }
        if (!((ja.b) this.f16654e).t0() && !((ja.b) this.f16654e).B0() && !((ja.b) this.f16654e).C0()) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1) {
                VelocityTracker velocityTracker2 = this.f16663u;
                int pointerId = motionEvent.getPointerId(0);
                velocityTracker2.computeCurrentVelocity(1000, k.x());
                float yVelocity = velocityTracker2.getYVelocity(pointerId);
                float xVelocity = velocityTracker2.getXVelocity(pointerId);
                if ((Math.abs(xVelocity) > k.y() || Math.abs(yVelocity) > k.y()) && this.f16651b == 1 && ((ja.b) this.f16654e).I()) {
                    u();
                    this.f16664v = AnimationUtils.currentAnimationTimeMillis();
                    this.f16665w.f54987c = motionEvent.getX();
                    this.f16665w.f54988d = motionEvent.getY();
                    g gVar = this.f16666x;
                    gVar.f54987c = xVelocity;
                    gVar.f54988d = yVelocity;
                    k.K(this.f16654e);
                }
                int i10 = this.f16651b;
                if (i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5) {
                    ((ja.b) this.f16654e).p();
                    ((ja.b) this.f16654e).postInvalidate();
                }
                this.f16651b = 0;
                ((ja.b) this.f16654e).w();
                VelocityTracker velocityTracker3 = this.f16663u;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f16663u = null;
                }
                b(motionEvent);
            } else if (action == 2) {
                int i11 = this.f16651b;
                if (i11 == 1) {
                    ((ja.b) this.f16654e).t();
                    o(motionEvent, ((ja.b) this.f16654e).u0() ? motionEvent.getX() - this.f16657o.f54987c : 0.0f, ((ja.b) this.f16654e).v0() ? motionEvent.getY() - this.f16657o.f54988d : 0.0f);
                } else if (i11 == 2 || i11 == 3 || i11 == 4) {
                    ((ja.b) this.f16654e).t();
                    if (((ja.b) this.f16654e).B0() || ((ja.b) this.f16654e).C0()) {
                        q(motionEvent);
                    }
                } else if (i11 == 0 && Math.abs(ChartTouchListener.a(motionEvent.getX(), this.f16657o.f54987c, motionEvent.getY(), this.f16657o.f54988d)) > this.f16667y && ((ja.b) this.f16654e).t0()) {
                    if ((((ja.b) this.f16654e).x0() && ((ja.b) this.f16654e).o0()) ? false : true) {
                        float fAbs = Math.abs(motionEvent.getX() - this.f16657o.f54987c);
                        float fAbs2 = Math.abs(motionEvent.getY() - this.f16657o.f54988d);
                        if ((((ja.b) this.f16654e).u0() || fAbs2 >= fAbs) && (((ja.b) this.f16654e).v0() || fAbs2 <= fAbs)) {
                            this.f16650a = ChartTouchListener.ChartGesture.DRAG;
                            this.f16651b = 1;
                        }
                    } else if (((ja.b) this.f16654e).y0()) {
                        this.f16650a = ChartTouchListener.ChartGesture.DRAG;
                        if (((ja.b) this.f16654e).y0()) {
                            p(motionEvent);
                        }
                    }
                }
            } else if (action == 3) {
                this.f16651b = 0;
                b(motionEvent);
            } else if (action != 5) {
                if (action == 6) {
                    k.M(motionEvent, this.f16663u);
                    this.f16651b = 5;
                }
            } else if (motionEvent.getPointerCount() >= 2) {
                ((ja.b) this.f16654e).t();
                r(motionEvent);
                this.f16659q = k(motionEvent);
                this.f16660r = l(motionEvent);
                float fT = t(motionEvent);
                this.f16661s = fT;
                if (fT > 10.0f) {
                    if (((ja.b) this.f16654e).A0()) {
                        this.f16651b = 4;
                    } else if (((ja.b) this.f16654e).B0() != ((ja.b) this.f16654e).C0()) {
                        this.f16651b = ((ja.b) this.f16654e).B0() ? 2 : 3;
                    } else {
                        this.f16651b = this.f16659q > this.f16660r ? 2 : 3;
                    }
                }
                n(this.f16658p, motionEvent);
            }
        } else {
            g(motionEvent);
            u();
            r(motionEvent);
        }
        this.f16655m = ((ja.b) this.f16654e).getViewPortHandler().S(this.f16655m, this.f16654e, true);
        return true;
    }

    public final void p(MotionEvent motionEvent) {
        d dVarX = ((ja.b) this.f16654e).x(motionEvent.getX(), motionEvent.getY());
        if (dVarX == null || dVarX.a(this.f16652c)) {
            return;
        }
        this.f16652c = dVarX;
        ((ja.b) this.f16654e).F(dVarX, true);
    }

    public final void q(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() >= 2) {
            b onChartGestureListener = ((ja.b) this.f16654e).getOnChartGestureListener();
            float fT = t(motionEvent);
            if (fT > this.f16668z) {
                g gVar = this.f16658p;
                g gVarJ = j(gVar.f54987c, gVar.f54988d);
                l viewPortHandler = ((ja.b) this.f16654e).getViewPortHandler();
                int i10 = this.f16651b;
                if (i10 == 4) {
                    this.f16650a = ChartTouchListener.ChartGesture.PINCH_ZOOM;
                    float f10 = fT / this.f16661s;
                    boolean z10 = f10 < 1.0f;
                    boolean zC = z10 ? viewPortHandler.c() : viewPortHandler.a();
                    boolean zD = z10 ? viewPortHandler.d() : viewPortHandler.b();
                    float f11 = ((ja.b) this.f16654e).B0() ? f10 : 1.0f;
                    float f12 = ((ja.b) this.f16654e).C0() ? f10 : 1.0f;
                    if (zD || zC) {
                        this.f16655m.set(this.f16656n);
                        this.f16655m.postScale(f11, f12, gVarJ.f54987c, gVarJ.f54988d);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.b(motionEvent, f11, f12);
                        }
                    }
                } else if (i10 == 2 && ((ja.b) this.f16654e).B0()) {
                    this.f16650a = ChartTouchListener.ChartGesture.X_ZOOM;
                    float fK = k(motionEvent) / this.f16659q;
                    if (fK < 1.0f ? viewPortHandler.c() : viewPortHandler.a()) {
                        this.f16655m.set(this.f16656n);
                        this.f16655m.postScale(fK, 1.0f, gVarJ.f54987c, gVarJ.f54988d);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.b(motionEvent, fK, 1.0f);
                        }
                    }
                } else if (this.f16651b == 3 && ((ja.b) this.f16654e).C0()) {
                    this.f16650a = ChartTouchListener.ChartGesture.Y_ZOOM;
                    float fL = l(motionEvent) / this.f16660r;
                    if (fL < 1.0f ? viewPortHandler.d() : viewPortHandler.b()) {
                        this.f16655m.set(this.f16656n);
                        this.f16655m.postScale(1.0f, fL, gVarJ.f54987c, gVarJ.f54988d);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.b(motionEvent, 1.0f, fL);
                        }
                    }
                }
                g.h(gVarJ);
            }
        }
    }

    public final void r(MotionEvent motionEvent) {
        this.f16656n.set(this.f16655m);
        this.f16657o.f54987c = motionEvent.getX();
        this.f16657o.f54988d = motionEvent.getY();
        this.f16662t = ((ja.b) this.f16654e).h0(motionEvent.getX(), motionEvent.getY());
    }

    public void s(float f10) {
        this.f16667y = k.e(f10);
    }

    public void u() {
        g gVar = this.f16666x;
        gVar.f54987c = 0.0f;
        gVar.f54988d = 0.0f;
    }
}
