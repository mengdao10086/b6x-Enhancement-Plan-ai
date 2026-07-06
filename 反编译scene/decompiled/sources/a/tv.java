package a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class tv<V extends View> extends vv<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VelocityTracker f7536a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OverScroller f3063a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f3064a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3065a;
    public int c;
    public int d;
    public int e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final V f3066a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final CoordinatorLayout f3067a;

        public a(CoordinatorLayout coordinatorLayout, V v) {
            this.f3067a = coordinatorLayout;
            this.f3066a = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f3066a == null || (overScroller = tv.this.f3063a) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                tv.this.N(this.f3067a, this.f3066a);
                return;
            }
            tv tvVar = tv.this;
            tvVar.P(this.f3067a, this.f3066a, tvVar.f3063a.getCurrY());
            eh.c0(this.f3066a, this);
        }
    }

    public tv() {
        this.c = -1;
        this.e = -1;
    }

    public tv(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = -1;
        this.e = -1;
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
    public boolean D(androidx.coordinatorlayout.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
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
            r12 = r2
            goto L1c
        L1b:
            r12 = r3
        L1c:
            int r13 = r14.getPointerId(r12)
            r11.c = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.d = r12
            goto L4c
        L2d:
            int r0 = r11.c
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r3
        L36:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.d
            int r7 = r1 - r0
            r11.d = r0
            int r8 = r11.K(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.O(r5, r6, r7, r8, r9)
        L4c:
            r12 = r3
            goto L81
        L4e:
            android.view.VelocityTracker r0 = r11.f7536a
            if (r0 == 0) goto L72
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f7536a
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f7536a
            int r4 = r11.c
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.L(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.J(r6, r7, r8, r9, r10)
            r12 = r2
            goto L73
        L72:
            r12 = r3
        L73:
            r11.f3065a = r3
            r11.c = r1
            android.view.VelocityTracker r13 = r11.f7536a
            if (r13 == 0) goto L81
            r13.recycle()
            r13 = 0
            r11.f7536a = r13
        L81:
            android.view.VelocityTracker r13 = r11.f7536a
            if (r13 == 0) goto L88
            r13.addMovement(r14)
        L88:
            boolean r13 = r11.f3065a
            if (r13 != 0) goto L90
            if (r12 == 0) goto L8f
            goto L90
        L8f:
            r2 = r3
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.tv.D(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract boolean H(V v);

    public final void I() {
        if (this.f7536a == null) {
            this.f7536a = VelocityTracker.obtain();
        }
    }

    public final boolean J(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        Runnable runnable = this.f3064a;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.f3064a = null;
        }
        if (this.f3063a == null) {
            this.f3063a = new OverScroller(v.getContext());
        }
        this.f3063a.fling(0, E(), 0, Math.round(f), 0, 0, i, i2);
        if (!this.f3063a.computeScrollOffset()) {
            N(coordinatorLayout, v);
            return false;
        }
        a aVar = new a(coordinatorLayout, v);
        this.f3064a = aVar;
        eh.c0(v, aVar);
        return true;
    }

    public abstract int K(V v);

    public abstract int L(V v);

    public abstract int M();

    public abstract void N(CoordinatorLayout coordinatorLayout, V v);

    public final int O(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return Q(coordinatorLayout, v, M() - i, i2, i3);
    }

    public int P(CoordinatorLayout coordinatorLayout, V v, int i) {
        return Q(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public abstract int Q(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.e < 0) {
            this.e = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f3065a) {
            int i = this.c;
            if (i == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y - this.d) > this.e) {
                this.d = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.c = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            boolean z = H(v) && coordinatorLayout.B(v, x, y2);
            this.f3065a = z;
            if (z) {
                this.d = y2;
                this.c = motionEvent.getPointerId(0);
                I();
                OverScroller overScroller = this.f3063a;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f3063a.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f7536a;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }
}
