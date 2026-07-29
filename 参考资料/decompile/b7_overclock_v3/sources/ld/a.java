package ld;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.u0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a<V extends View> extends d<V> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f39569k = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public Runnable f39570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OverScroller f39571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f39572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f39573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f39574h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f39575i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public VelocityTracker f39576j;

    /* JADX INFO: renamed from: ld.a$a, reason: collision with other inner class name */
    public class RunnableC0443a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CoordinatorLayout f39577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V f39578b;

        public RunnableC0443a(CoordinatorLayout coordinatorLayout, V v10) {
            this.f39577a = coordinatorLayout;
            this.f39578b = v10;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f39578b == null || (overScroller = a.this.f39571e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                a.this.V(this.f39577a, this.f39578b);
                return;
            }
            a aVar = a.this;
            aVar.X(this.f39577a, this.f39578b, aVar.f39571e.getCurrY());
            u0.p1(this.f39578b, this);
        }
    }

    public a() {
        this.f39573g = -1;
        this.f39575i = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean E(@g.n0 androidx.coordinatorlayout.widget.CoordinatorLayout r12, @g.n0 V r13, @g.n0 android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L4e
            r4 = 2
            if (r0 == r4) goto L2d
            r12 = 3
            if (r0 == r12) goto L72
            r12 = 6
            if (r0 == r12) goto L13
            goto L4c
        L13:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L1b
            r12 = 1
            goto L1c
        L1b:
            r12 = 0
        L1c:
            int r13 = r14.getPointerId(r12)
            r11.f39573g = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.f39574h = r12
            goto L4c
        L2d:
            int r0 = r11.f39573g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r3
        L36:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.f39574h
            int r7 = r1 - r0
            r11.f39574h = r0
            int r8 = r11.S(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.W(r5, r6, r7, r8, r9)
        L4c:
            r12 = 0
            goto L81
        L4e:
            android.view.VelocityTracker r0 = r11.f39576j
            if (r0 == 0) goto L72
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f39576j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f39576j
            int r4 = r11.f39573g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.T(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.R(r6, r7, r8, r9, r10)
            r12 = 1
            goto L73
        L72:
            r12 = 0
        L73:
            r11.f39572f = r3
            r11.f39573g = r1
            android.view.VelocityTracker r13 = r11.f39576j
            if (r13 == 0) goto L81
            r13.recycle()
            r13 = 0
            r11.f39576j = r13
        L81:
            android.view.VelocityTracker r13 = r11.f39576j
            if (r13 == 0) goto L88
            r13.addMovement(r14)
        L88:
            boolean r13 = r11.f39572f
            if (r13 != 0) goto L90
            if (r12 == 0) goto L8f
            goto L90
        L8f:
            r2 = 0
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ld.a.E(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public boolean P(V v10) {
        return false;
    }

    public final void Q() {
        if (this.f39576j == null) {
            this.f39576j = VelocityTracker.obtain();
        }
    }

    public final boolean R(CoordinatorLayout coordinatorLayout, @n0 V v10, int i10, int i11, float f10) {
        Runnable runnable = this.f39570d;
        if (runnable != null) {
            v10.removeCallbacks(runnable);
            this.f39570d = null;
        }
        if (this.f39571e == null) {
            this.f39571e = new OverScroller(v10.getContext());
        }
        this.f39571e.fling(0, H(), 0, Math.round(f10), 0, 0, i10, i11);
        if (!this.f39571e.computeScrollOffset()) {
            V(coordinatorLayout, v10);
            return false;
        }
        RunnableC0443a runnableC0443a = new RunnableC0443a(coordinatorLayout, v10);
        this.f39570d = runnableC0443a;
        u0.p1(v10, runnableC0443a);
        return true;
    }

    public int S(@n0 V v10) {
        return -v10.getHeight();
    }

    public int T(@n0 V v10) {
        return v10.getHeight();
    }

    public int U() {
        return H();
    }

    public void V(CoordinatorLayout coordinatorLayout, V v10) {
    }

    public final int W(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12) {
        return Y(coordinatorLayout, v10, U() - i10, i11, i12);
    }

    public int X(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        return Y(coordinatorLayout, v10, i10, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int Y(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12) {
        int iE;
        int iH = H();
        if (i11 == 0 || iH < i11 || iH > i12 || iH == (iE = t0.a.e(i10, i11, i12))) {
            return 0;
        }
        N(iE);
        return iH - iE;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f39575i < 0) {
            this.f39575i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f39572f) {
            int i10 = this.f39573g;
            if (i10 == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i10)) == -1) {
                return false;
            }
            int y10 = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y10 - this.f39574h) > this.f39575i) {
                this.f39574h = y10;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f39573g = -1;
            int x10 = (int) motionEvent.getX();
            int y11 = (int) motionEvent.getY();
            boolean z10 = P(v10) && coordinatorLayout.A(v10, x10, y11);
            this.f39572f = z10;
            if (z10) {
                this.f39574h = y11;
                this.f39573g = motionEvent.getPointerId(0);
                Q();
                OverScroller overScroller = this.f39571e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f39571e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f39576j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39573g = -1;
        this.f39575i = -1;
    }
}
