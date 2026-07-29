package com.blankj.utilcode.util;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11772a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11773b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f11774c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11775d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f11776e = 8;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static abstract class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f11777k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f11778l = 1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f11779m = 2;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f11780n = 1000;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11783c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11784d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11785e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11786f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f11787g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public VelocityTracker f11788h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f11789i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f11790j;

        public b() {
            g(-1, -1);
        }

        public abstract boolean a(View view, int i10, int i11, MotionEvent motionEvent);

        public abstract boolean b(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, MotionEvent motionEvent);

        public abstract boolean c(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, MotionEvent motionEvent);

        public boolean d(View view, MotionEvent motionEvent) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            g(rawX, rawY);
            view.setPressed(true);
            return a(view, rawX, rawY, motionEvent);
        }

        public boolean e(View view, MotionEvent motionEvent) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (this.f11782b == -1) {
                g(rawX, rawY);
                view.setPressed(true);
            }
            if (this.f11786f != 1) {
                if (Math.abs(rawX - this.f11784d) < this.f11781a && Math.abs(rawY - this.f11785e) < this.f11781a) {
                    return true;
                }
                this.f11786f = 1;
                if (Math.abs(rawX - this.f11784d) >= Math.abs(rawY - this.f11785e)) {
                    if (rawX - this.f11784d < 0) {
                        this.f11787g = 1;
                    } else {
                        this.f11787g = 4;
                    }
                } else if (rawY - this.f11785e < 0) {
                    this.f11787g = 2;
                } else {
                    this.f11787g = 8;
                }
            }
            boolean zB = b(view, this.f11787g, rawX, rawY, rawX - this.f11784d, rawY - this.f11785e, rawX - this.f11782b, rawY - this.f11783c, motionEvent);
            this.f11784d = rawX;
            this.f11785e = rawY;
            return zB;
        }

        public boolean f(View view, MotionEvent motionEvent) {
            int i10;
            int i11;
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            VelocityTracker velocityTracker = this.f11788h;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(1000, this.f11789i);
                int xVelocity = (int) this.f11788h.getXVelocity();
                int yVelocity = (int) this.f11788h.getYVelocity();
                this.f11788h.recycle();
                if (Math.abs(xVelocity) < this.f11790j) {
                    xVelocity = 0;
                }
                if (Math.abs(yVelocity) < this.f11790j) {
                    yVelocity = 0;
                }
                this.f11788h = null;
                i10 = xVelocity;
                i11 = yVelocity;
            } else {
                i10 = 0;
                i11 = 0;
            }
            view.setPressed(false);
            boolean zC = c(view, this.f11787g, rawX, rawY, rawX - this.f11782b, rawY - this.f11783c, i10, i11, motionEvent);
            if (motionEvent.getAction() == 1 && this.f11786f == 0) {
                if (motionEvent.getEventTime() - motionEvent.getDownTime() <= 1000) {
                    view.performClick();
                } else {
                    view.performLongClick();
                }
            }
            g(-1, -1);
            return zC;
        }

        public final void g(int i10, int i11) {
            this.f11782b = i10;
            this.f11783c = i11;
            this.f11784d = i10;
            this.f11785e = i11;
            this.f11786f = 0;
            this.f11787g = 0;
            VelocityTracker velocityTracker = this.f11788h;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f11781a == 0) {
                this.f11781a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            }
            if (this.f11789i == 0) {
                this.f11789i = ViewConfiguration.get(view.getContext()).getScaledMaximumFlingVelocity();
            }
            if (this.f11790j == 0) {
                this.f11790j = ViewConfiguration.get(view.getContext()).getScaledMinimumFlingVelocity();
            }
            if (this.f11788h == null) {
                this.f11788h = VelocityTracker.obtain();
            }
            this.f11788h.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                return d(view, motionEvent);
            }
            if (action != 1) {
                if (action == 2) {
                    return e(view, motionEvent);
                }
                if (action != 3) {
                    return false;
                }
            }
            return f(view, motionEvent);
        }
    }

    public g1() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void a(View view, b bVar) {
        if (view == null || bVar == null) {
            return;
        }
        view.setOnTouchListener(bVar);
    }
}
