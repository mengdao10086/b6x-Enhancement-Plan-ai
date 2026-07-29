package z9;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f57959k = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f57960a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f57961b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScaleGestureDetector f57962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VelocityTracker f57963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f57964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f57965f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f57966g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f57967h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f57968i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f57969j;

    public class a implements ScaleGestureDetector.OnScaleGestureListener {
        public a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            if (scaleFactor < 0.0f) {
                return true;
            }
            c.this.f57969j.b(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public c(Context context, d dVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f57968i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f57967h = viewConfiguration.getScaledTouchSlop();
        this.f57969j = dVar;
        this.f57962c = new ScaleGestureDetector(context, new a());
    }

    public final float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f57961b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    public final float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f57961b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    public boolean d() {
        return this.f57964e;
    }

    public boolean e() {
        return this.f57962c.isInProgress();
    }

    public boolean f(MotionEvent motionEvent) {
        try {
            this.f57962c.onTouchEvent(motionEvent);
            return g(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public final boolean g(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f57960a = motionEvent.getPointerId(0);
            VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
            this.f57963d = velocityTrackerObtain;
            if (velocityTrackerObtain != null) {
                velocityTrackerObtain.addMovement(motionEvent);
            }
            this.f57965f = b(motionEvent);
            this.f57966g = c(motionEvent);
            this.f57964e = false;
        } else if (action == 1) {
            this.f57960a = -1;
            if (this.f57964e && this.f57963d != null) {
                this.f57965f = b(motionEvent);
                this.f57966g = c(motionEvent);
                this.f57963d.addMovement(motionEvent);
                this.f57963d.computeCurrentVelocity(1000);
                float xVelocity = this.f57963d.getXVelocity();
                float yVelocity = this.f57963d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f57968i) {
                    this.f57969j.c(this.f57965f, this.f57966g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker = this.f57963d;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f57963d = null;
            }
        } else if (action == 2) {
            float fB = b(motionEvent);
            float fC = c(motionEvent);
            float f10 = fB - this.f57965f;
            float f11 = fC - this.f57966g;
            if (!this.f57964e) {
                this.f57964e = Math.sqrt((double) ((f10 * f10) + (f11 * f11))) >= ((double) this.f57967h);
            }
            if (this.f57964e) {
                this.f57969j.a(f10, f11);
                this.f57965f = fB;
                this.f57966g = fC;
                VelocityTracker velocityTracker2 = this.f57963d;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f57960a = -1;
            VelocityTracker velocityTracker3 = this.f57963d;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f57963d = null;
            }
        } else if (action == 6) {
            int iB = m.b(motionEvent.getAction());
            if (motionEvent.getPointerId(iB) == this.f57960a) {
                int i10 = iB == 0 ? 1 : 0;
                this.f57960a = motionEvent.getPointerId(i10);
                this.f57965f = motionEvent.getX(i10);
                this.f57966g = motionEvent.getY(i10);
            }
        }
        int i11 = this.f57960a;
        this.f57961b = motionEvent.findPointerIndex(i11 != -1 ? i11 : 0);
        return true;
    }
}
