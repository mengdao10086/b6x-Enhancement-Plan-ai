package a;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class lk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Interpolator f6715a = new jk();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f1807a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1808a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f1809a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public VelocityTracker f1810a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f1811a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ViewGroup f1812a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OverScroller f1813a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1815a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float[] f1816a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f1817a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f1818b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float[] f1819b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int[] f1820b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public float[] f1821c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int[] f1822c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public float[] f1823d;
    public int e;
    public int f;
    public int c = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f1814a = new kk(this);

    public static abstract class a {
        public abstract int a(View view, int i, int i2);

        public abstract int b(View view, int i, int i2);

        public int c(int i) {
            return i;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i, int i2) {
        }

        public boolean g(int i) {
            return false;
        }

        public void h(int i, int i2) {
        }

        public void i(View view, int i) {
        }

        public abstract void j(int i);

        public abstract void k(View view, int i, int i2, int i3, int i4);

        public abstract void l(View view, float f, float f2);

        public abstract boolean m(View view, int i);
    }

    public lk(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f1812a = viewGroup;
        this.f1809a = aVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.e = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f1818b = viewConfiguration.getScaledTouchSlop();
        this.f1807a = viewConfiguration.getScaledMaximumFlingVelocity();
        this.b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1813a = new OverScroller(context, f6715a);
    }

    public static lk n(ViewGroup viewGroup, float f, a aVar) {
        lk lkVarO = o(viewGroup, aVar);
        lkVarO.f1818b = (int) (lkVarO.f1818b * (1.0f / f));
        return lkVarO;
    }

    public static lk o(ViewGroup viewGroup, a aVar) {
        return new lk(viewGroup.getContext(), viewGroup, aVar);
    }

    public boolean A(int i, int i2) {
        return D(this.f1811a, i, i2);
    }

    public boolean B(int i) {
        return ((1 << i) & this.d) != 0;
    }

    public final boolean C(int i) {
        if (B(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public boolean D(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public void E(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f1810a == null) {
            this.f1810a = VelocityTracker.obtain();
        }
        this.f1810a.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewT = t((int) x, (int) y);
            H(x, y, pointerId);
            P(viewT, pointerId);
            int i3 = this.f1817a[pointerId];
            int i4 = this.f;
            if ((i3 & i4) != 0) {
                this.f1809a.h(i3 & i4, pointerId);
                return;
            }
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (this.f1808a != 1) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (i2 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i2);
                        if (C(pointerId2)) {
                            float x2 = motionEvent.getX(i2);
                            float y2 = motionEvent.getY(i2);
                            float f = x2 - this.f1816a[pointerId2];
                            float f2 = y2 - this.f1819b[pointerId2];
                            G(f, f2, pointerId2);
                            if (this.f1808a != 1) {
                                View viewT2 = t((int) x2, (int) y2);
                                if (f(viewT2, f, f2) && P(viewT2, pointerId2)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        i2++;
                    }
                } else {
                    if (!C(this.c)) {
                        return;
                    }
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.c);
                    float x3 = motionEvent.getX(iFindPointerIndex);
                    float y3 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f1821c;
                    int i5 = this.c;
                    int i6 = (int) (x3 - fArr[i5]);
                    int i7 = (int) (y3 - this.f1823d[i5]);
                    r(this.f1811a.getLeft() + i6, this.f1811a.getTop() + i7, i6, i7);
                }
                I(motionEvent);
                return;
            }
            if (actionMasked != 3) {
                if (actionMasked == 5) {
                    int pointerId3 = motionEvent.getPointerId(actionIndex);
                    float x4 = motionEvent.getX(actionIndex);
                    float y4 = motionEvent.getY(actionIndex);
                    H(x4, y4, pointerId3);
                    if (this.f1808a != 0) {
                        if (A((int) x4, (int) y4)) {
                            P(this.f1811a, pointerId3);
                            return;
                        }
                        return;
                    } else {
                        P(t((int) x4, (int) y4), pointerId3);
                        int i8 = this.f1817a[pointerId3];
                        int i9 = this.f;
                        if ((i8 & i9) != 0) {
                            this.f1809a.h(i8 & i9, pointerId3);
                            return;
                        }
                        return;
                    }
                }
                if (actionMasked != 6) {
                    return;
                }
                int pointerId4 = motionEvent.getPointerId(actionIndex);
                if (this.f1808a == 1 && pointerId4 == this.c) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    while (true) {
                        if (i2 >= pointerCount2) {
                            i = -1;
                            break;
                        }
                        int pointerId5 = motionEvent.getPointerId(i2);
                        if (pointerId5 != this.c) {
                            View viewT3 = t((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                            View view = this.f1811a;
                            if (viewT3 == view && P(view, pointerId5)) {
                                i = this.c;
                                break;
                            }
                        }
                        i2++;
                    }
                    if (i == -1) {
                        F();
                    }
                }
                j(pointerId4);
                return;
            }
            if (this.f1808a == 1) {
                p(0.0f, 0.0f);
            }
        } else if (this.f1808a == 1) {
            F();
        }
        a();
    }

    public final void F() {
        this.f1810a.computeCurrentVelocity(1000, this.f1807a);
        p(g(this.f1810a.getXVelocity(this.c), this.b, this.f1807a), g(this.f1810a.getYVelocity(this.c), this.b, this.f1807a));
    }

    public final void G(float f, float f2, int i) {
        int i2 = c(f, f2, i, 1) ? 1 : 0;
        if (c(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (c(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (c(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f1820b;
            iArr[i] = iArr[i] | i2;
            this.f1809a.f(i2, i);
        }
    }

    public final void H(float f, float f2, int i) {
        s(i);
        float[] fArr = this.f1816a;
        this.f1821c[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f1819b;
        this.f1823d[i] = f2;
        fArr2[i] = f2;
        this.f1817a[i] = x((int) f, (int) f2);
        this.d |= 1 << i;
    }

    public final void I(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (C(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f1821c[pointerId] = x;
                this.f1823d[pointerId] = y;
            }
        }
    }

    public void J(int i) {
        this.f1812a.removeCallbacks(this.f1814a);
        if (this.f1808a != i) {
            this.f1808a = i;
            this.f1809a.j(i);
            if (this.f1808a == 0) {
                this.f1811a = null;
            }
        }
    }

    public void K(int i) {
        this.f = i;
    }

    public void L(float f) {
        this.b = f;
    }

    public boolean M(int i, int i2) {
        if (this.f1815a) {
            return u(i, i2, (int) this.f1810a.getXVelocity(this.c), (int) this.f1810a.getYVelocity(this.c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean N(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.lk.N(android.view.MotionEvent):boolean");
    }

    public boolean O(View view, int i, int i2) {
        this.f1811a = view;
        this.c = -1;
        boolean zU = u(i, i2, 0, 0);
        if (!zU && this.f1808a == 0 && this.f1811a != null) {
            this.f1811a = null;
        }
        return zU;
    }

    public boolean P(View view, int i) {
        if (view == this.f1811a && this.c == i) {
            return true;
        }
        if (view == null || !this.f1809a.m(view, i)) {
            return false;
        }
        this.c = i;
        b(view, i);
        return true;
    }

    public void a() {
        this.c = -1;
        i();
        VelocityTracker velocityTracker = this.f1810a;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1810a = null;
        }
    }

    public void b(View view, int i) {
        if (view.getParent() == this.f1812a) {
            this.f1811a = view;
            this.c = i;
            this.f1809a.i(view, i);
            J(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f1812a + ")");
    }

    public final boolean c(float f, float f2, int i, int i2) {
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f2);
        if ((this.f1817a[i] & i2) != i2 || (this.f & i2) == 0 || (this.f1822c[i] & i2) == i2 || (this.f1820b[i] & i2) == i2) {
            return false;
        }
        int i3 = this.f1818b;
        if (fAbs <= i3 && fAbs2 <= i3) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.f1809a.g(i2)) {
            return (this.f1820b[i] & i2) == 0 && fAbs > ((float) this.f1818b);
        }
        int[] iArr = this.f1822c;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    public boolean d(int i) {
        int length = this.f1816a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (e(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean e(int i, int i2) {
        if (!B(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f1821c[i2] - this.f1816a[i2];
        float f2 = this.f1823d[i2] - this.f1819b[i2];
        if (!z || !z2) {
            return z ? Math.abs(f) > ((float) this.f1818b) : z2 && Math.abs(f2) > ((float) this.f1818b);
        }
        float f3 = (f * f) + (f2 * f2);
        int i3 = this.f1818b;
        return f3 > ((float) (i3 * i3));
    }

    public final boolean f(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f1809a.d(view) > 0;
        boolean z2 = this.f1809a.e(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f) > ((float) this.f1818b) : z2 && Math.abs(f2) > ((float) this.f1818b);
        }
        float f3 = (f * f) + (f2 * f2);
        int i = this.f1818b;
        return f3 > ((float) (i * i));
    }

    public final float g(float f, float f2, float f3) {
        float fAbs = Math.abs(f);
        if (fAbs < f2) {
            return 0.0f;
        }
        return fAbs > f3 ? f > 0.0f ? f3 : -f3 : f;
    }

    public final int h(int i, int i2, int i3) {
        int iAbs = Math.abs(i);
        if (iAbs < i2) {
            return 0;
        }
        return iAbs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    public final void i() {
        float[] fArr = this.f1816a;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f1819b, 0.0f);
        Arrays.fill(this.f1821c, 0.0f);
        Arrays.fill(this.f1823d, 0.0f);
        Arrays.fill(this.f1817a, 0);
        Arrays.fill(this.f1820b, 0);
        Arrays.fill(this.f1822c, 0);
        this.d = 0;
    }

    public final void j(int i) {
        if (this.f1816a == null || !B(i)) {
            return;
        }
        this.f1816a[i] = 0.0f;
        this.f1819b[i] = 0.0f;
        this.f1821c[i] = 0.0f;
        this.f1823d[i] = 0.0f;
        this.f1817a[i] = 0;
        this.f1820b[i] = 0;
        this.f1822c[i] = 0;
        this.d = (~(1 << i)) & this.d;
    }

    public final int k(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f1812a.getWidth();
        float f = width / 2;
        float fQ = f + (q(Math.min(1.0f, Math.abs(i) / width)) * f);
        int iAbs = Math.abs(i2);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fQ / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f), 600);
    }

    public final int l(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int iH = h(i3, (int) this.b, (int) this.f1807a);
        int iH2 = h(i4, (int) this.b, (int) this.f1807a);
        int iAbs = Math.abs(i);
        int iAbs2 = Math.abs(i2);
        int iAbs3 = Math.abs(iH);
        int iAbs4 = Math.abs(iH2);
        int i5 = iAbs3 + iAbs4;
        int i6 = iAbs + iAbs2;
        if (iH != 0) {
            f = iAbs3;
            f2 = i5;
        } else {
            f = iAbs;
            f2 = i6;
        }
        float f5 = f / f2;
        if (iH2 != 0) {
            f3 = iAbs4;
            f4 = i5;
        } else {
            f3 = iAbs2;
            f4 = i6;
        }
        return (int) ((k(i, iH, this.f1809a.d(view)) * f5) + (k(i2, iH2, this.f1809a.e(view)) * (f3 / f4)));
    }

    public boolean m(boolean z) {
        if (this.f1808a == 2) {
            boolean zComputeScrollOffset = this.f1813a.computeScrollOffset();
            int currX = this.f1813a.getCurrX();
            int currY = this.f1813a.getCurrY();
            int left = currX - this.f1811a.getLeft();
            int top = currY - this.f1811a.getTop();
            if (left != 0) {
                eh.V(this.f1811a, left);
            }
            if (top != 0) {
                eh.W(this.f1811a, top);
            }
            if (left != 0 || top != 0) {
                this.f1809a.k(this.f1811a, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f1813a.getFinalX() && currY == this.f1813a.getFinalY()) {
                this.f1813a.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z) {
                    this.f1812a.post(this.f1814a);
                } else {
                    J(0);
                }
            }
        }
        return this.f1808a == 2;
    }

    public final void p(float f, float f2) {
        this.f1815a = true;
        this.f1809a.l(this.f1811a, f, f2);
        this.f1815a = false;
        if (this.f1808a == 1) {
            J(0);
        }
    }

    public final float q(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    public final void r(int i, int i2, int i3, int i4) {
        int left = this.f1811a.getLeft();
        int top = this.f1811a.getTop();
        if (i3 != 0) {
            i = this.f1809a.a(this.f1811a, i, i3);
            eh.V(this.f1811a, i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.f1809a.b(this.f1811a, i2, i4);
            eh.W(this.f1811a, i2 - top);
        }
        int i6 = i2;
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.f1809a.k(this.f1811a, i5, i6, i5 - left, i6 - top);
    }

    public final void s(int i) {
        float[] fArr = this.f1816a;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            float[] fArr6 = this.f1816a;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.f1819b;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.f1821c;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.f1823d;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.f1817a;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f1820b;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f1822c;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f1816a = fArr2;
            this.f1819b = fArr3;
            this.f1821c = fArr4;
            this.f1823d = fArr5;
            this.f1817a = iArr;
            this.f1820b = iArr2;
            this.f1822c = iArr3;
        }
    }

    public View t(int i, int i2) {
        for (int childCount = this.f1812a.getChildCount() - 1; childCount >= 0; childCount--) {
            ViewGroup viewGroup = this.f1812a;
            this.f1809a.c(childCount);
            View childAt = viewGroup.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean u(int i, int i2, int i3, int i4) {
        int left = this.f1811a.getLeft();
        int top = this.f1811a.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f1813a.abortAnimation();
            J(0);
            return false;
        }
        this.f1813a.startScroll(left, top, i5, i6, l(this.f1811a, i5, i6, i3, i4));
        J(2);
        return true;
    }

    public View v() {
        return this.f1811a;
    }

    public int w() {
        return this.e;
    }

    public final int x(int i, int i2) {
        int i3 = i < this.f1812a.getLeft() + this.e ? 1 : 0;
        if (i2 < this.f1812a.getTop() + this.e) {
            i3 |= 4;
        }
        if (i > this.f1812a.getRight() - this.e) {
            i3 |= 2;
        }
        return i2 > this.f1812a.getBottom() - this.e ? i3 | 8 : i3;
    }

    public int y() {
        return this.f1818b;
    }

    public int z() {
        return this.f1808a;
    }
}
