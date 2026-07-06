package a;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class yf implements wf {
    public static final int e = ViewConfiguration.getLongPressTimeout();
    public static final int f = ViewConfiguration.getTapTimeout();
    public static final int g = ViewConfiguration.getDoubleTapTimeout();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f7977a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f3688a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f3689a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public GestureDetector.OnDoubleTapListener f3690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final GestureDetector.OnGestureListener f3691a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MotionEvent f3692a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public VelocityTracker f3693a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3694a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f3695b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public MotionEvent f3696b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3697b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f3698c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f3699c;
    public float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f3700d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f3701d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f3702e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f3703f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f3704g;

    public yf(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (handler != null) {
            this.f3689a = new xf(this, handler);
        } else {
            this.f3689a = new xf(this);
        }
        this.f3691a = onGestureListener;
        if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
            g((GestureDetector.OnDoubleTapListener) onGestureListener);
        }
        e(context);
    }

    @Override // a.wf
    public boolean a(MotionEvent motionEvent) {
        boolean zOnDoubleTap;
        MotionEvent motionEvent2;
        boolean zOnFling;
        GestureDetector.OnDoubleTapListener onDoubleTapListener;
        int action = motionEvent.getAction();
        if (this.f3693a == null) {
            this.f3693a = VelocityTracker.obtain();
        }
        this.f3693a.addMovement(motionEvent);
        int i = action & 255;
        boolean z = i == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float x = 0.0f;
        float y = 0.0f;
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (actionIndex != i2) {
                x += motionEvent.getX(i2);
                y += motionEvent.getY(i2);
            }
        }
        float f2 = z ? pointerCount - 1 : pointerCount;
        float f3 = x / f2;
        float f4 = y / f2;
        if (i == 0) {
            if (this.f3690a == null) {
                zOnDoubleTap = false;
            } else {
                boolean zHasMessages = this.f3689a.hasMessages(3);
                if (zHasMessages) {
                    this.f3689a.removeMessages(3);
                }
                MotionEvent motionEvent3 = this.f3692a;
                if (motionEvent3 == null || (motionEvent2 = this.f3696b) == null || !zHasMessages || !f(motionEvent3, motionEvent2, motionEvent)) {
                    this.f3689a.sendEmptyMessageDelayed(3, g);
                    zOnDoubleTap = false;
                } else {
                    this.f3703f = true;
                    zOnDoubleTap = this.f3690a.onDoubleTap(this.f3692a) | false | this.f3690a.onDoubleTapEvent(motionEvent);
                }
            }
            this.f7977a = f3;
            this.c = f3;
            this.b = f4;
            this.d = f4;
            MotionEvent motionEvent4 = this.f3692a;
            if (motionEvent4 != null) {
                motionEvent4.recycle();
            }
            this.f3692a = MotionEvent.obtain(motionEvent);
            this.f3701d = true;
            this.f3702e = true;
            this.f3694a = true;
            this.f3699c = false;
            this.f3697b = false;
            if (this.f3704g) {
                this.f3689a.removeMessages(2);
                this.f3689a.sendEmptyMessageAtTime(2, this.f3692a.getDownTime() + ((long) f) + ((long) e));
            }
            this.f3689a.sendEmptyMessageAtTime(1, this.f3692a.getDownTime() + ((long) f));
            return zOnDoubleTap | this.f3691a.onDown(motionEvent);
        }
        if (i == 1) {
            this.f3694a = false;
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            if (this.f3703f) {
                zOnFling = this.f3690a.onDoubleTapEvent(motionEvent) | false;
            } else {
                if (this.f3699c) {
                    this.f3689a.removeMessages(3);
                    this.f3699c = false;
                } else if (this.f3701d) {
                    boolean zOnSingleTapUp = this.f3691a.onSingleTapUp(motionEvent);
                    if (this.f3697b && (onDoubleTapListener = this.f3690a) != null) {
                        onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                    }
                    zOnFling = zOnSingleTapUp;
                } else {
                    VelocityTracker velocityTracker = this.f3693a;
                    int pointerId = motionEvent.getPointerId(0);
                    velocityTracker.computeCurrentVelocity(1000, this.f3700d);
                    float yVelocity = velocityTracker.getYVelocity(pointerId);
                    float xVelocity = velocityTracker.getXVelocity(pointerId);
                    if (Math.abs(yVelocity) > this.f3698c || Math.abs(xVelocity) > this.f3698c) {
                        zOnFling = this.f3691a.onFling(this.f3692a, motionEvent, xVelocity, yVelocity);
                    }
                }
                zOnFling = false;
            }
            MotionEvent motionEvent5 = this.f3696b;
            if (motionEvent5 != null) {
                motionEvent5.recycle();
            }
            this.f3696b = motionEventObtain;
            VelocityTracker velocityTracker2 = this.f3693a;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f3693a = null;
            }
            this.f3703f = false;
            this.f3697b = false;
            this.f3689a.removeMessages(1);
            this.f3689a.removeMessages(2);
        } else {
            if (i != 2) {
                if (i == 3) {
                    b();
                    return false;
                }
                if (i == 5) {
                    this.f7977a = f3;
                    this.c = f3;
                    this.b = f4;
                    this.d = f4;
                    c();
                    return false;
                }
                if (i != 6) {
                    return false;
                }
                this.f7977a = f3;
                this.c = f3;
                this.b = f4;
                this.d = f4;
                this.f3693a.computeCurrentVelocity(1000, this.f3700d);
                int actionIndex2 = motionEvent.getActionIndex();
                int pointerId2 = motionEvent.getPointerId(actionIndex2);
                float xVelocity2 = this.f3693a.getXVelocity(pointerId2);
                float yVelocity2 = this.f3693a.getYVelocity(pointerId2);
                for (int i3 = 0; i3 < pointerCount; i3++) {
                    if (i3 != actionIndex2) {
                        int pointerId3 = motionEvent.getPointerId(i3);
                        if ((this.f3693a.getXVelocity(pointerId3) * xVelocity2) + (this.f3693a.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                            this.f3693a.clear();
                            return false;
                        }
                    }
                }
                return false;
            }
            if (this.f3699c) {
                return false;
            }
            float f5 = this.f7977a - f3;
            float f6 = this.b - f4;
            if (this.f3703f) {
                return false | this.f3690a.onDoubleTapEvent(motionEvent);
            }
            if (!this.f3701d) {
                if (Math.abs(f5) < 1.0f && Math.abs(f6) < 1.0f) {
                    return false;
                }
                boolean zOnScroll = this.f3691a.onScroll(this.f3692a, motionEvent, f5, f6);
                this.f7977a = f3;
                this.b = f4;
                return zOnScroll;
            }
            int i4 = (int) (f3 - this.c);
            int i5 = (int) (f4 - this.d);
            int i6 = (i4 * i4) + (i5 * i5);
            if (i6 > this.f3688a) {
                zOnFling = this.f3691a.onScroll(this.f3692a, motionEvent, f5, f6);
                this.f7977a = f3;
                this.b = f4;
                this.f3701d = false;
                this.f3689a.removeMessages(3);
                this.f3689a.removeMessages(1);
                this.f3689a.removeMessages(2);
            } else {
                zOnFling = false;
            }
            if (i6 > this.f3688a) {
                this.f3702e = false;
            }
        }
        return zOnFling;
    }

    public final void b() {
        this.f3689a.removeMessages(1);
        this.f3689a.removeMessages(2);
        this.f3689a.removeMessages(3);
        this.f3693a.recycle();
        this.f3693a = null;
        this.f3703f = false;
        this.f3694a = false;
        this.f3701d = false;
        this.f3702e = false;
        this.f3697b = false;
        if (this.f3699c) {
            this.f3699c = false;
        }
    }

    public final void c() {
        this.f3689a.removeMessages(1);
        this.f3689a.removeMessages(2);
        this.f3689a.removeMessages(3);
        this.f3703f = false;
        this.f3701d = false;
        this.f3702e = false;
        this.f3697b = false;
        if (this.f3699c) {
            this.f3699c = false;
        }
    }

    public void d() {
        this.f3689a.removeMessages(3);
        this.f3697b = false;
        this.f3699c = true;
        this.f3691a.onLongPress(this.f3692a);
    }

    public final void e(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        if (this.f3691a == null) {
            throw new IllegalArgumentException("OnGestureListener must not be null");
        }
        this.f3704g = true;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
        this.f3698c = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3700d = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f3688a = scaledTouchSlop * scaledTouchSlop;
        this.f3695b = scaledDoubleTapSlop * scaledDoubleTapSlop;
    }

    public final boolean f(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (!this.f3702e || motionEvent3.getEventTime() - motionEvent2.getEventTime() > g) {
            return false;
        }
        int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
        int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
        return (x * x) + (y * y) < this.f3695b;
    }

    public void g(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f3690a = onDoubleTapListener;
    }
}
