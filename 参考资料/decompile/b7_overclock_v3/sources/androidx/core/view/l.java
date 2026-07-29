package androidx.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f4981a;

    public interface a {
        boolean a(MotionEvent motionEvent);

        void b(GestureDetector.OnDoubleTapListener onDoubleTapListener);

        void c(boolean z10);

        boolean d();
    }

    public static class b implements a {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final int f4982v = ViewConfiguration.getTapTimeout();

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f4983w = ViewConfiguration.getDoubleTapTimeout();

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final int f4984x = 1;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final int f4985y = 2;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final int f4986z = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4990d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Handler f4991e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final GestureDetector.OnGestureListener f4992f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public GestureDetector.OnDoubleTapListener f4993g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f4994h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f4995i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f4996j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f4997k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f4998l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public MotionEvent f4999m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public MotionEvent f5000n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f5001o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f5002p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f5003q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f5004r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float f5005s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f5006t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public VelocityTracker f5007u;

        public b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.f4991e = new a(handler);
            } else {
                this.f4991e = new a();
            }
            this.f4992f = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                b((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            h(context);
        }

        @Override // androidx.core.view.l.a
        public boolean a(MotionEvent motionEvent) {
            boolean zOnDoubleTap;
            MotionEvent motionEvent2;
            boolean zOnFling;
            GestureDetector.OnDoubleTapListener onDoubleTapListener;
            int action = motionEvent.getAction();
            if (this.f5007u == null) {
                this.f5007u = VelocityTracker.obtain();
            }
            this.f5007u.addMovement(motionEvent);
            int i10 = action & 255;
            boolean z10 = i10 == 6;
            int actionIndex = z10 ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float x10 = 0.0f;
            float y10 = 0.0f;
            for (int i11 = 0; i11 < pointerCount; i11++) {
                if (actionIndex != i11) {
                    x10 += motionEvent.getX(i11);
                    y10 += motionEvent.getY(i11);
                }
            }
            float f10 = z10 ? pointerCount - 1 : pointerCount;
            float f11 = x10 / f10;
            float f12 = y10 / f10;
            if (i10 == 0) {
                if (this.f4993g == null) {
                    zOnDoubleTap = false;
                } else {
                    boolean zHasMessages = this.f4991e.hasMessages(3);
                    if (zHasMessages) {
                        this.f4991e.removeMessages(3);
                    }
                    MotionEvent motionEvent3 = this.f4999m;
                    if (motionEvent3 == null || (motionEvent2 = this.f5000n) == null || !zHasMessages || !i(motionEvent3, motionEvent2, motionEvent)) {
                        this.f4991e.sendEmptyMessageDelayed(3, f4983w);
                        zOnDoubleTap = false;
                    } else {
                        this.f5001o = true;
                        zOnDoubleTap = this.f4993g.onDoubleTap(this.f4999m) | false | this.f4993g.onDoubleTapEvent(motionEvent);
                    }
                }
                this.f5002p = f11;
                this.f5004r = f11;
                this.f5003q = f12;
                this.f5005s = f12;
                MotionEvent motionEvent4 = this.f4999m;
                if (motionEvent4 != null) {
                    motionEvent4.recycle();
                }
                this.f4999m = MotionEvent.obtain(motionEvent);
                this.f4997k = true;
                this.f4998l = true;
                this.f4994h = true;
                this.f4996j = false;
                this.f4995i = false;
                if (this.f5006t) {
                    this.f4991e.removeMessages(2);
                    this.f4991e.sendEmptyMessageAtTime(2, this.f4999m.getDownTime() + ((long) f4982v) + ((long) ViewConfiguration.getLongPressTimeout()));
                }
                this.f4991e.sendEmptyMessageAtTime(1, this.f4999m.getDownTime() + ((long) f4982v));
                return zOnDoubleTap | this.f4992f.onDown(motionEvent);
            }
            if (i10 == 1) {
                this.f4994h = false;
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                if (this.f5001o) {
                    zOnFling = this.f4993g.onDoubleTapEvent(motionEvent) | false;
                } else {
                    if (this.f4996j) {
                        this.f4991e.removeMessages(3);
                        this.f4996j = false;
                    } else if (this.f4997k) {
                        boolean zOnSingleTapUp = this.f4992f.onSingleTapUp(motionEvent);
                        if (this.f4995i && (onDoubleTapListener = this.f4993g) != null) {
                            onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                        }
                        zOnFling = zOnSingleTapUp;
                    } else {
                        VelocityTracker velocityTracker = this.f5007u;
                        int pointerId = motionEvent.getPointerId(0);
                        velocityTracker.computeCurrentVelocity(1000, this.f4990d);
                        float yVelocity = velocityTracker.getYVelocity(pointerId);
                        float xVelocity = velocityTracker.getXVelocity(pointerId);
                        if (Math.abs(yVelocity) > this.f4989c || Math.abs(xVelocity) > this.f4989c) {
                            zOnFling = this.f4992f.onFling(this.f4999m, motionEvent, xVelocity, yVelocity);
                        }
                    }
                    zOnFling = false;
                }
                MotionEvent motionEvent5 = this.f5000n;
                if (motionEvent5 != null) {
                    motionEvent5.recycle();
                }
                this.f5000n = motionEventObtain;
                VelocityTracker velocityTracker2 = this.f5007u;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.f5007u = null;
                }
                this.f5001o = false;
                this.f4995i = false;
                this.f4991e.removeMessages(1);
                this.f4991e.removeMessages(2);
            } else {
                if (i10 != 2) {
                    if (i10 == 3) {
                        e();
                        return false;
                    }
                    if (i10 == 5) {
                        this.f5002p = f11;
                        this.f5004r = f11;
                        this.f5003q = f12;
                        this.f5005s = f12;
                        f();
                        return false;
                    }
                    if (i10 != 6) {
                        return false;
                    }
                    this.f5002p = f11;
                    this.f5004r = f11;
                    this.f5003q = f12;
                    this.f5005s = f12;
                    this.f5007u.computeCurrentVelocity(1000, this.f4990d);
                    int actionIndex2 = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(actionIndex2);
                    float xVelocity2 = this.f5007u.getXVelocity(pointerId2);
                    float yVelocity2 = this.f5007u.getYVelocity(pointerId2);
                    for (int i12 = 0; i12 < pointerCount; i12++) {
                        if (i12 != actionIndex2) {
                            int pointerId3 = motionEvent.getPointerId(i12);
                            if ((this.f5007u.getXVelocity(pointerId3) * xVelocity2) + (this.f5007u.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                                this.f5007u.clear();
                                return false;
                            }
                        }
                    }
                    return false;
                }
                if (this.f4996j) {
                    return false;
                }
                float f13 = this.f5002p - f11;
                float f14 = this.f5003q - f12;
                if (this.f5001o) {
                    return false | this.f4993g.onDoubleTapEvent(motionEvent);
                }
                if (!this.f4997k) {
                    if (Math.abs(f13) < 1.0f && Math.abs(f14) < 1.0f) {
                        return false;
                    }
                    boolean zOnScroll = this.f4992f.onScroll(this.f4999m, motionEvent, f13, f14);
                    this.f5002p = f11;
                    this.f5003q = f12;
                    return zOnScroll;
                }
                int i13 = (int) (f11 - this.f5004r);
                int i14 = (int) (f12 - this.f5005s);
                int i15 = (i13 * i13) + (i14 * i14);
                if (i15 > this.f4987a) {
                    zOnFling = this.f4992f.onScroll(this.f4999m, motionEvent, f13, f14);
                    this.f5002p = f11;
                    this.f5003q = f12;
                    this.f4997k = false;
                    this.f4991e.removeMessages(3);
                    this.f4991e.removeMessages(1);
                    this.f4991e.removeMessages(2);
                } else {
                    zOnFling = false;
                }
                if (i15 > this.f4987a) {
                    this.f4998l = false;
                }
            }
            return zOnFling;
        }

        @Override // androidx.core.view.l.a
        public void b(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f4993g = onDoubleTapListener;
        }

        @Override // androidx.core.view.l.a
        public void c(boolean z10) {
            this.f5006t = z10;
        }

        @Override // androidx.core.view.l.a
        public boolean d() {
            return this.f5006t;
        }

        public final void e() {
            this.f4991e.removeMessages(1);
            this.f4991e.removeMessages(2);
            this.f4991e.removeMessages(3);
            this.f5007u.recycle();
            this.f5007u = null;
            this.f5001o = false;
            this.f4994h = false;
            this.f4997k = false;
            this.f4998l = false;
            this.f4995i = false;
            if (this.f4996j) {
                this.f4996j = false;
            }
        }

        public final void f() {
            this.f4991e.removeMessages(1);
            this.f4991e.removeMessages(2);
            this.f4991e.removeMessages(3);
            this.f5001o = false;
            this.f4997k = false;
            this.f4998l = false;
            this.f4995i = false;
            if (this.f4996j) {
                this.f4996j = false;
            }
        }

        public void g() {
            this.f4991e.removeMessages(3);
            this.f4995i = false;
            this.f4996j = true;
            this.f4992f.onLongPress(this.f4999m);
        }

        public final void h(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            if (this.f4992f == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            this.f5006t = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.f4989c = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f4990d = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f4987a = scaledTouchSlop * scaledTouchSlop;
            this.f4988b = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }

        public final boolean i(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.f4998l || motionEvent3.getEventTime() - motionEvent2.getEventTime() > f4983w) {
                return false;
            }
            int x10 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y10 = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x10 * x10) + (y10 * y10) < this.f4988b;
        }

        public class a extends Handler {
            public a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i10 = message.what;
                if (i10 == 1) {
                    b bVar = b.this;
                    bVar.f4992f.onShowPress(bVar.f4999m);
                    return;
                }
                if (i10 == 2) {
                    b.this.g();
                    return;
                }
                if (i10 != 3) {
                    throw new RuntimeException("Unknown message " + message);
                }
                b bVar2 = b.this;
                GestureDetector.OnDoubleTapListener onDoubleTapListener = bVar2.f4993g;
                if (onDoubleTapListener != null) {
                    if (bVar2.f4994h) {
                        bVar2.f4995i = true;
                    } else {
                        onDoubleTapListener.onSingleTapConfirmed(bVar2.f4999m);
                    }
                }
            }

            public a(Handler handler) {
                super(handler.getLooper());
            }
        }
    }

    public static class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final GestureDetector f5009a;

        public c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f5009a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // androidx.core.view.l.a
        public boolean a(MotionEvent motionEvent) {
            return this.f5009a.onTouchEvent(motionEvent);
        }

        @Override // androidx.core.view.l.a
        public void b(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f5009a.setOnDoubleTapListener(onDoubleTapListener);
        }

        @Override // androidx.core.view.l.a
        public void c(boolean z10) {
            this.f5009a.setIsLongpressEnabled(z10);
        }

        @Override // androidx.core.view.l.a
        public boolean d() {
            return this.f5009a.isLongpressEnabled();
        }
    }

    public l(@g.n0 Context context, @g.n0 GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a() {
        return this.f4981a.d();
    }

    public boolean b(@g.n0 MotionEvent motionEvent) {
        return this.f4981a.a(motionEvent);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void c(boolean z10) {
        this.f4981a.c(z10);
    }

    public void d(@g.p0 GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f4981a.b(onDoubleTapListener);
    }

    public l(@g.n0 Context context, @g.n0 GestureDetector.OnGestureListener onGestureListener, @g.p0 Handler handler) {
        this.f4981a = new c(context, onGestureListener, handler);
    }
}
