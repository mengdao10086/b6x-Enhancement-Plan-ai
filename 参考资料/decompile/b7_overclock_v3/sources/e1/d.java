package e1;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.u0;
import g.f0;
import g.n0;
import g.p0;
import g.t0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 1;
    public static final int D = 2;
    public static final int E = 4;
    public static final int F = 8;
    public static final int G = 15;
    public static final int H = 1;
    public static final int I = 2;
    public static final int J = 3;
    public static final int K = 20;
    public static final int L = 256;
    public static final int M = 600;
    public static final Interpolator N = new a();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f26572x = "ViewDragHelper";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f26573y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f26574z = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f26575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f26576b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f26578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f26579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f26580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float[] f26581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f26582h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f26583i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f26584j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f26585k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VelocityTracker f26586l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f26587m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f26588n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f26589o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f26590p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f26591q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public OverScroller f26592r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c f26593s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f26594t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f26595u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ViewGroup f26596v;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f26577c = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Runnable f26597w = new b();

    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.R(0);
        }
    }

    public static abstract class c {
        public int a(@n0 View view, int i10, int i11) {
            return 0;
        }

        public int b(@n0 View view, int i10, int i11) {
            return 0;
        }

        public int c(int i10) {
            return i10;
        }

        public int d(@n0 View view) {
            return 0;
        }

        public int e(@n0 View view) {
            return 0;
        }

        public void f(int i10, int i11) {
        }

        public boolean g(int i10) {
            return false;
        }

        public void h(int i10, int i11) {
        }

        public void i(@n0 View view, int i10) {
        }

        public void j(int i10) {
        }

        public void k(@n0 View view, int i10, int i11, @t0 int i12, @t0 int i13) {
        }

        public void l(@n0 View view, float f10, float f11) {
        }

        public abstract boolean m(@n0 View view, int i10);
    }

    public d(@n0 Context context, @n0 ViewGroup viewGroup, @n0 c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f26596v = viewGroup;
        this.f26593s = cVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i10 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f26590p = i10;
        this.f26589o = i10;
        this.f26576b = viewConfiguration.getScaledTouchSlop();
        this.f26587m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f26588n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f26592r = new OverScroller(context, N);
    }

    public static d p(@n0 ViewGroup viewGroup, float f10, @n0 c cVar) {
        d dVarQ = q(viewGroup, cVar);
        dVarQ.f26576b = (int) (dVarQ.f26576b * (1.0f / f10));
        return dVarQ;
    }

    public static d q(@n0 ViewGroup viewGroup, @n0 c cVar) {
        return new d(viewGroup.getContext(), viewGroup, cVar);
    }

    @t0
    public int A() {
        return this.f26590p;
    }

    @t0
    public int B() {
        return this.f26589o;
    }

    public final int C(int i10, int i11) {
        int i12 = i10 < this.f26596v.getLeft() + this.f26589o ? 1 : 0;
        if (i11 < this.f26596v.getTop() + this.f26589o) {
            i12 |= 4;
        }
        if (i10 > this.f26596v.getRight() - this.f26589o) {
            i12 |= 2;
        }
        return i11 > this.f26596v.getBottom() - this.f26589o ? i12 | 8 : i12;
    }

    public float D() {
        return this.f26588n;
    }

    @t0
    public int E() {
        return this.f26576b;
    }

    public int F() {
        return this.f26575a;
    }

    public boolean G(int i10, int i11) {
        return L(this.f26594t, i10, i11);
    }

    public boolean H(int i10) {
        int length = this.f26582h.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (I(i10, i11)) {
                return true;
            }
        }
        return false;
    }

    public boolean I(int i10, int i11) {
        return J(i11) && (i10 & this.f26582h[i11]) != 0;
    }

    public boolean J(int i10) {
        return ((1 << i10) & this.f26585k) != 0;
    }

    public final boolean K(int i10) {
        if (J(i10)) {
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Ignoring pointerId=");
        sb2.append(i10);
        sb2.append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public boolean L(@p0 View view, int i10, int i11) {
        return view != null && i10 >= view.getLeft() && i10 < view.getRight() && i11 >= view.getTop() && i11 < view.getBottom();
    }

    public void M(@n0 MotionEvent motionEvent) {
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            c();
        }
        if (this.f26586l == null) {
            this.f26586l = VelocityTracker.obtain();
        }
        this.f26586l.addMovement(motionEvent);
        int i11 = 0;
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewV = v((int) x10, (int) y10);
            P(x10, y10, pointerId);
            Y(viewV, pointerId);
            int i12 = this.f26582h[pointerId];
            int i13 = this.f26591q;
            if ((i12 & i13) != 0) {
                this.f26593s.h(i12 & i13, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f26575a == 1) {
                N();
            }
            c();
            return;
        }
        if (actionMasked == 2) {
            if (this.f26575a == 1) {
                if (K(this.f26577c)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f26577c);
                    float x11 = motionEvent.getX(iFindPointerIndex);
                    float y11 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f26580f;
                    int i14 = this.f26577c;
                    int i15 = (int) (x11 - fArr[i14]);
                    int i16 = (int) (y11 - this.f26581g[i14]);
                    t(this.f26594t.getLeft() + i15, this.f26594t.getTop() + i16, i15, i16);
                    Q(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i11 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i11);
                if (K(pointerId2)) {
                    float x12 = motionEvent.getX(i11);
                    float y12 = motionEvent.getY(i11);
                    float f10 = x12 - this.f26578d[pointerId2];
                    float f11 = y12 - this.f26579e[pointerId2];
                    O(f10, f11, pointerId2);
                    if (this.f26575a != 1) {
                        View viewV2 = v((int) x12, (int) y12);
                        if (h(viewV2, f10, f11) && Y(viewV2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i11++;
            }
            Q(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f26575a == 1) {
                r(0.0f, 0.0f);
            }
            c();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x13 = motionEvent.getX(actionIndex);
            float y13 = motionEvent.getY(actionIndex);
            P(x13, y13, pointerId3);
            if (this.f26575a != 0) {
                if (G((int) x13, (int) y13)) {
                    Y(this.f26594t, pointerId3);
                    return;
                }
                return;
            } else {
                Y(v((int) x13, (int) y13), pointerId3);
                int i17 = this.f26582h[pointerId3];
                int i18 = this.f26591q;
                if ((i17 & i18) != 0) {
                    this.f26593s.h(i17 & i18, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f26575a == 1 && pointerId4 == this.f26577c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i11 >= pointerCount2) {
                    i10 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i11);
                if (pointerId5 != this.f26577c) {
                    View viewV3 = v((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
                    View view = this.f26594t;
                    if (viewV3 == view && Y(view, pointerId5)) {
                        i10 = this.f26577c;
                        break;
                    }
                }
                i11++;
            }
            if (i10 == -1) {
                N();
            }
        }
        l(pointerId4);
    }

    public final void N() {
        this.f26586l.computeCurrentVelocity(1000, this.f26587m);
        r(i(this.f26586l.getXVelocity(this.f26577c), this.f26588n, this.f26587m), i(this.f26586l.getYVelocity(this.f26577c), this.f26588n, this.f26587m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [e1.d$c] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void O(float f10, float f11, int i10) {
        boolean zE = e(f10, f11, i10, 1);
        ?? r02 = zE;
        if (e(f11, f10, i10, 4)) {
            r02 = (zE ? 1 : 0) | 4;
        }
        ?? r03 = r02;
        if (e(f10, f11, i10, 2)) {
            r03 = (r02 == true ? 1 : 0) | 2;
        }
        ?? r04 = r03;
        if (e(f11, f10, i10, 8)) {
            r04 = (r03 == true ? 1 : 0) | 8;
        }
        if (r04 != 0) {
            int[] iArr = this.f26583i;
            iArr[i10] = iArr[i10] | r04;
            this.f26593s.f(r04, i10);
        }
    }

    public final void P(float f10, float f11, int i10) {
        u(i10);
        float[] fArr = this.f26578d;
        this.f26580f[i10] = f10;
        fArr[i10] = f10;
        float[] fArr2 = this.f26579e;
        this.f26581g[i10] = f11;
        fArr2[i10] = f11;
        this.f26582h[i10] = C((int) f10, (int) f11);
        this.f26585k |= 1 << i10;
    }

    public final void Q(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (K(pointerId)) {
                float x10 = motionEvent.getX(i10);
                float y10 = motionEvent.getY(i10);
                this.f26580f[pointerId] = x10;
                this.f26581g[pointerId] = y10;
            }
        }
    }

    public void R(int i10) {
        this.f26596v.removeCallbacks(this.f26597w);
        if (this.f26575a != i10) {
            this.f26575a = i10;
            this.f26593s.j(i10);
            if (this.f26575a == 0) {
                this.f26594t = null;
            }
        }
    }

    public void S(@t0 @f0(from = 0) int i10) {
        this.f26589o = i10;
    }

    public void T(int i10) {
        this.f26591q = i10;
    }

    public void U(float f10) {
        this.f26588n = f10;
    }

    public boolean V(int i10, int i11) {
        if (this.f26595u) {
            return x(i10, i11, (int) this.f26586l.getXVelocity(this.f26577c), (int) this.f26586l.getYVelocity(this.f26577c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean W(@g.n0 android.view.MotionEvent r17) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.d.W(android.view.MotionEvent):boolean");
    }

    public boolean X(@n0 View view, int i10, int i11) {
        this.f26594t = view;
        this.f26577c = -1;
        boolean zX = x(i10, i11, 0, 0);
        if (!zX && this.f26575a == 0 && this.f26594t != null) {
            this.f26594t = null;
        }
        return zX;
    }

    public boolean Y(View view, int i10) {
        if (view == this.f26594t && this.f26577c == i10) {
            return true;
        }
        if (view == null || !this.f26593s.m(view, i10)) {
            return false;
        }
        this.f26577c = i10;
        d(view, i10);
        return true;
    }

    public void a() {
        c();
        if (this.f26575a == 2) {
            int currX = this.f26592r.getCurrX();
            int currY = this.f26592r.getCurrY();
            this.f26592r.abortAnimation();
            int currX2 = this.f26592r.getCurrX();
            int currY2 = this.f26592r.getCurrY();
            this.f26593s.k(this.f26594t, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        R(0);
    }

    public boolean b(@n0 View view, boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i15 = i12 + scrollX;
                if (i15 >= childAt.getLeft() && i15 < childAt.getRight() && (i14 = i13 + scrollY) >= childAt.getTop() && i14 < childAt.getBottom() && b(childAt, true, i10, i11, i15 - childAt.getLeft(), i14 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z10 && (view.canScrollHorizontally(-i10) || view.canScrollVertically(-i11));
    }

    public void c() {
        this.f26577c = -1;
        k();
        VelocityTracker velocityTracker = this.f26586l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f26586l = null;
        }
    }

    public void d(@n0 View view, int i10) {
        if (view.getParent() == this.f26596v) {
            this.f26594t = view;
            this.f26577c = i10;
            this.f26593s.i(view, i10);
            R(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f26596v + ee.a.f26979d);
    }

    public final boolean e(float f10, float f11, int i10, int i11) {
        float fAbs = Math.abs(f10);
        float fAbs2 = Math.abs(f11);
        if ((this.f26582h[i10] & i11) != i11 || (this.f26591q & i11) == 0 || (this.f26584j[i10] & i11) == i11 || (this.f26583i[i10] & i11) == i11) {
            return false;
        }
        int i12 = this.f26576b;
        if (fAbs <= i12 && fAbs2 <= i12) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.f26593s.g(i11)) {
            return (this.f26583i[i10] & i11) == 0 && fAbs > ((float) this.f26576b);
        }
        int[] iArr = this.f26584j;
        iArr[i10] = iArr[i10] | i11;
        return false;
    }

    public boolean f(int i10) {
        int length = this.f26578d.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (g(i10, i11)) {
                return true;
            }
        }
        return false;
    }

    public boolean g(int i10, int i11) {
        if (!J(i11)) {
            return false;
        }
        boolean z10 = (i10 & 1) == 1;
        boolean z11 = (i10 & 2) == 2;
        float f10 = this.f26580f[i11] - this.f26578d[i11];
        float f11 = this.f26581g[i11] - this.f26579e[i11];
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f26576b) : z11 && Math.abs(f11) > ((float) this.f26576b);
        }
        float f12 = (f10 * f10) + (f11 * f11);
        int i12 = this.f26576b;
        return f12 > ((float) (i12 * i12));
    }

    public final boolean h(View view, float f10, float f11) {
        if (view == null) {
            return false;
        }
        boolean z10 = this.f26593s.d(view) > 0;
        boolean z11 = this.f26593s.e(view) > 0;
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f26576b) : z11 && Math.abs(f11) > ((float) this.f26576b);
        }
        float f12 = (f10 * f10) + (f11 * f11);
        int i10 = this.f26576b;
        return f12 > ((float) (i10 * i10));
    }

    public final float i(float f10, float f11, float f12) {
        float fAbs = Math.abs(f10);
        if (fAbs < f11) {
            return 0.0f;
        }
        return fAbs > f12 ? f10 > 0.0f ? f12 : -f12 : f10;
    }

    public final int j(int i10, int i11, int i12) {
        int iAbs = Math.abs(i10);
        if (iAbs < i11) {
            return 0;
        }
        return iAbs > i12 ? i10 > 0 ? i12 : -i12 : i10;
    }

    public final void k() {
        float[] fArr = this.f26578d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f26579e, 0.0f);
        Arrays.fill(this.f26580f, 0.0f);
        Arrays.fill(this.f26581g, 0.0f);
        Arrays.fill(this.f26582h, 0);
        Arrays.fill(this.f26583i, 0);
        Arrays.fill(this.f26584j, 0);
        this.f26585k = 0;
    }

    public final void l(int i10) {
        if (this.f26578d == null || !J(i10)) {
            return;
        }
        this.f26578d[i10] = 0.0f;
        this.f26579e[i10] = 0.0f;
        this.f26580f[i10] = 0.0f;
        this.f26581g[i10] = 0.0f;
        this.f26582h[i10] = 0;
        this.f26583i[i10] = 0;
        this.f26584j[i10] = 0;
        this.f26585k = (~(1 << i10)) & this.f26585k;
    }

    public final int m(int i10, int i11, int i12) {
        if (i10 == 0) {
            return 0;
        }
        int width = this.f26596v.getWidth();
        float f10 = width / 2;
        float fS = f10 + (s(Math.min(1.0f, Math.abs(i10) / width)) * f10);
        int iAbs = Math.abs(i11);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fS / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i10) / i12) + 1.0f) * 256.0f), 600);
    }

    public final int n(View view, int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        int iJ = j(i12, (int) this.f26588n, (int) this.f26587m);
        int iJ2 = j(i13, (int) this.f26588n, (int) this.f26587m);
        int iAbs = Math.abs(i10);
        int iAbs2 = Math.abs(i11);
        int iAbs3 = Math.abs(iJ);
        int iAbs4 = Math.abs(iJ2);
        int i14 = iAbs3 + iAbs4;
        int i15 = iAbs + iAbs2;
        if (iJ != 0) {
            f10 = iAbs3;
            f11 = i14;
        } else {
            f10 = iAbs;
            f11 = i15;
        }
        float f14 = f10 / f11;
        if (iJ2 != 0) {
            f12 = iAbs4;
            f13 = i14;
        } else {
            f12 = iAbs2;
            f13 = i15;
        }
        return (int) ((m(i10, iJ, this.f26593s.d(view)) * f14) + (m(i11, iJ2, this.f26593s.e(view)) * (f12 / f13)));
    }

    public boolean o(boolean z10) {
        if (this.f26575a == 2) {
            boolean zComputeScrollOffset = this.f26592r.computeScrollOffset();
            int currX = this.f26592r.getCurrX();
            int currY = this.f26592r.getCurrY();
            int left = currX - this.f26594t.getLeft();
            int top2 = currY - this.f26594t.getTop();
            if (left != 0) {
                u0.e1(this.f26594t, left);
            }
            if (top2 != 0) {
                u0.f1(this.f26594t, top2);
            }
            if (left != 0 || top2 != 0) {
                this.f26593s.k(this.f26594t, currX, currY, left, top2);
            }
            if (zComputeScrollOffset && currX == this.f26592r.getFinalX() && currY == this.f26592r.getFinalY()) {
                this.f26592r.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z10) {
                    this.f26596v.post(this.f26597w);
                } else {
                    R(0);
                }
            }
        }
        return this.f26575a == 2;
    }

    public final void r(float f10, float f11) {
        this.f26595u = true;
        this.f26593s.l(this.f26594t, f10, f11);
        this.f26595u = false;
        if (this.f26575a == 1) {
            R(0);
        }
    }

    public final float s(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    public final void t(int i10, int i11, int i12, int i13) {
        int left = this.f26594t.getLeft();
        int top2 = this.f26594t.getTop();
        if (i12 != 0) {
            i10 = this.f26593s.a(this.f26594t, i10, i12);
            u0.e1(this.f26594t, i10 - left);
        }
        int i14 = i10;
        if (i13 != 0) {
            i11 = this.f26593s.b(this.f26594t, i11, i13);
            u0.f1(this.f26594t, i11 - top2);
        }
        int i15 = i11;
        if (i12 == 0 && i13 == 0) {
            return;
        }
        this.f26593s.k(this.f26594t, i14, i15, i14 - left, i15 - top2);
    }

    public final void u(int i10) {
        float[] fArr = this.f26578d;
        if (fArr == null || fArr.length <= i10) {
            int i11 = i10 + 1;
            float[] fArr2 = new float[i11];
            float[] fArr3 = new float[i11];
            float[] fArr4 = new float[i11];
            float[] fArr5 = new float[i11];
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f26579e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f26580f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f26581g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f26582h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f26583i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f26584j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f26578d = fArr2;
            this.f26579e = fArr3;
            this.f26580f = fArr4;
            this.f26581g = fArr5;
            this.f26582h = iArr;
            this.f26583i = iArr2;
            this.f26584j = iArr3;
        }
    }

    @p0
    public View v(int i10, int i11) {
        for (int childCount = this.f26596v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f26596v.getChildAt(this.f26593s.c(childCount));
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void w(int i10, int i11, int i12, int i13) {
        if (!this.f26595u) {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        }
        this.f26592r.fling(this.f26594t.getLeft(), this.f26594t.getTop(), (int) this.f26586l.getXVelocity(this.f26577c), (int) this.f26586l.getYVelocity(this.f26577c), i10, i12, i11, i13);
        R(2);
    }

    public final boolean x(int i10, int i11, int i12, int i13) {
        int left = this.f26594t.getLeft();
        int top2 = this.f26594t.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top2;
        if (i14 == 0 && i15 == 0) {
            this.f26592r.abortAnimation();
            R(0);
            return false;
        }
        this.f26592r.startScroll(left, top2, i14, i15, n(this.f26594t, i14, i15, i12, i13));
        R(2);
        return true;
    }

    public int y() {
        return this.f26577c;
    }

    @p0
    public View z() {
        return this.f26594t;
    }
}
