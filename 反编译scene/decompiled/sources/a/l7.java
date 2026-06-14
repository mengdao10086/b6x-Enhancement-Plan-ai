package a;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class l7 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f6680a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f1761a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View f1762a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f1763a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f1764a = new int[2];
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Runnable f1765b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1766b;
    public int c;

    public l7(View view) {
        this.f1762a = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f6680a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1761a = tapTimeout;
        this.b = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public static boolean h(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    public final void a() {
        Runnable runnable = this.f1765b;
        if (runnable != null) {
            this.f1762a.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1763a;
        if (runnable2 != null) {
            this.f1762a.removeCallbacks(runnable2);
        }
    }

    public abstract y4 b();

    public abstract boolean c();

    public boolean d() {
        y4 y4VarB = b();
        if (y4VarB == null || !y4VarB.a()) {
            return true;
        }
        y4VarB.dismiss();
        return true;
    }

    public void e() {
        a();
        View view = this.f1762a;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f1766b = true;
        }
    }

    public final boolean f(MotionEvent motionEvent) {
        h7 h7Var;
        View view = this.f1762a;
        y4 y4VarB = b();
        if (y4VarB == null || !y4VarB.a() || (h7Var = (h7) y4VarB.e()) == null || !h7Var.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, motionEventObtainNoHistory);
        j(h7Var, motionEventObtainNoHistory);
        boolean zE = h7Var.e(motionEventObtainNoHistory, this.c);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zE && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f1762a
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
            int r1 = r5.c
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f6680a
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
            r5.c = r6
            java.lang.Runnable r6 = r5.f1763a
            if (r6 != 0) goto L52
            a.j7 r6 = new a.j7
            r6.<init>(r5)
            r5.f1763a = r6
        L52:
            java.lang.Runnable r6 = r5.f1763a
            int r1 = r5.f1761a
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f1765b
            if (r6 != 0) goto L65
            a.k7 r6 = new a.k7
            r6.<init>(r5)
            r5.f1765b = r6
        L65:
            java.lang.Runnable r6 = r5.f1765b
            int r1 = r5.b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.l7.g(android.view.MotionEvent):boolean");
    }

    public final boolean i(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f1764a);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    public final boolean j(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f1764a);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f1766b;
        if (z2) {
            z = f(motionEvent) || !d();
        } else {
            z = g(motionEvent) && c();
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1762a.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f1766b = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f1766b = false;
        this.c = -1;
        Runnable runnable = this.f1763a;
        if (runnable != null) {
            this.f1762a.removeCallbacks(runnable);
        }
    }
}
