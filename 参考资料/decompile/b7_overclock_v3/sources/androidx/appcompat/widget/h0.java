package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class h0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f2485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f2488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f2489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f2490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2492h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f2493i = new int[2];

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = h0.this.f2488d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h0.this.e();
        }
    }

    public h0(View view) {
        this.f2488d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f2485a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f2486b = tapTimeout;
        this.f2487c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public static boolean h(View view, float f10, float f11, float f12) {
        float f13 = -f12;
        return f10 >= f13 && f11 >= f13 && f10 < ((float) (view.getRight() - view.getLeft())) + f12 && f11 < ((float) (view.getBottom() - view.getTop())) + f12;
    }

    public final void a() {
        Runnable runnable = this.f2490f;
        if (runnable != null) {
            this.f2488d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f2489e;
        if (runnable2 != null) {
            this.f2488d.removeCallbacks(runnable2);
        }
    }

    public abstract m.f b();

    public boolean c() {
        m.f fVarB = b();
        if (fVarB == null || fVarB.d()) {
            return true;
        }
        fVarB.a();
        return true;
    }

    public boolean d() {
        m.f fVarB = b();
        if (fVarB == null || !fVarB.d()) {
            return true;
        }
        fVarB.dismiss();
        return true;
    }

    public void e() {
        a();
        View view = this.f2488d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f2491g = true;
        }
    }

    public final boolean f(MotionEvent motionEvent) {
        e0 e0Var;
        View view = this.f2488d;
        m.f fVarB = b();
        if (fVarB == null || !fVarB.d() || (e0Var = (e0) fVarB.k()) == null || !e0Var.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, motionEventObtainNoHistory);
        j(e0Var, motionEventObtainNoHistory);
        boolean zF = e0Var.f(motionEventObtainNoHistory, this.f2492h);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zF && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f2488d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.f2492h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f2485a
            boolean r6 = h(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.a()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.f2492h = r6
            java.lang.Runnable r6 = r5.f2489e
            if (r6 != 0) goto L52
            androidx.appcompat.widget.h0$a r6 = new androidx.appcompat.widget.h0$a
            r6.<init>()
            r5.f2489e = r6
        L52:
            java.lang.Runnable r6 = r5.f2489e
            int r1 = r5.f2486b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f2490f
            if (r6 != 0) goto L65
            androidx.appcompat.widget.h0$b r6 = new androidx.appcompat.widget.h0$b
            r6.<init>()
            r5.f2490f = r6
        L65:
            java.lang.Runnable r6 = r5.f2490f
            int r1 = r5.f2487c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.h0.g(android.view.MotionEvent):boolean");
    }

    public final boolean i(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f2493i);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    public final boolean j(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f2493i);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z10;
        boolean z11 = this.f2491g;
        if (z11) {
            z10 = f(motionEvent) || !d();
        } else {
            z10 = g(motionEvent) && c();
            if (z10) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f2488d.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f2491g = z10;
        return z10 || z11;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f2491g = false;
        this.f2492h = -1;
        Runnable runnable = this.f2489e;
        if (runnable != null) {
            this.f2488d.removeCallbacks(runnable);
        }
    }
}
