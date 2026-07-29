package e1;

import a1.e;
import a1.f;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.m;
import androidx.core.view.u0;
import e1.b;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends androidx.core.view.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f26551n = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f26552o = -1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f26553p = "android.view.View";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Rect f26554q = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final b.a<a1.d> f26555r = new C0304a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final b.InterfaceC0305b<m<a1.d>, a1.d> f26556s = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AccessibilityManager f26561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f26562i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c f26563j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f26557d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f26558e = new Rect();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f26559f = new Rect();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f26560g = new int[2];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f26564k = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f26565l = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f26566m = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e1.a$a, reason: collision with other inner class name */
    public class C0304a implements b.a<a1.d> {
        @Override // e1.b.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(a1.d dVar, Rect rect) {
            dVar.s(rect);
        }
    }

    public class b implements b.InterfaceC0305b<m<a1.d>, a1.d> {
        @Override // e1.b.InterfaceC0305b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a1.d a(m<a1.d> mVar, int i10) {
            return mVar.y(i10);
        }

        @Override // e1.b.InterfaceC0305b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int b(m<a1.d> mVar) {
            return mVar.x();
        }
    }

    public class c extends e {
        public c() {
        }

        @Override // a1.e
        public a1.d b(int i10) {
            return a1.d.I0(a.this.L(i10));
        }

        @Override // a1.e
        public a1.d d(int i10) {
            int i11 = i10 == 2 ? a.this.f26564k : a.this.f26565l;
            if (i11 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i11);
        }

        @Override // a1.e
        public boolean f(int i10, int i11, Bundle bundle) {
            return a.this.T(i10, i11, bundle);
        }
    }

    public a(@n0 View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f26562i = view;
        this.f26561h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (u0.V(view) == 0) {
            u0.R1(view, 1);
        }
    }

    public static Rect E(@n0 View view, int i10, @n0 Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i10 == 17) {
            rect.set(width, 0, width, height);
        } else if (i10 == 33) {
            rect.set(0, height, width, height);
        } else if (i10 == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i10 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    public static int J(int i10) {
        if (i10 == 19) {
            return 33;
        }
        if (i10 != 21) {
            return i10 != 22 ? 130 : 66;
        }
        return 17;
    }

    @Deprecated
    public int A() {
        return x();
    }

    public final int B() {
        return this.f26565l;
    }

    public abstract int C(float f10, float f11);

    public abstract void D(List<Integer> list);

    public final void F() {
        H(-1, 1);
    }

    public final void G(int i10) {
        H(i10, 0);
    }

    public final void H(int i10, int i11) {
        ViewParent parent;
        if (i10 == Integer.MIN_VALUE || !this.f26561h.isEnabled() || (parent = this.f26562i.getParent()) == null) {
            return;
        }
        AccessibilityEvent accessibilityEventQ = q(i10, 2048);
        a1.b.i(accessibilityEventQ, i11);
        parent.requestSendAccessibilityEvent(this.f26562i, accessibilityEventQ);
    }

    public final boolean I(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f26562i.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.f26562i.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    public final boolean K(int i10, @p0 Rect rect) {
        a1.d dVar;
        m<a1.d> mVarY = y();
        int i11 = this.f26565l;
        a1.d dVarH = i11 == Integer.MIN_VALUE ? null : mVarY.h(i11);
        if (i10 == 1 || i10 == 2) {
            dVar = (a1.d) e1.b.d(mVarY, f26556s, f26555r, dVarH, i10, u0.Z(this.f26562i) == 1, false);
        } else {
            if (i10 != 17 && i10 != 33 && i10 != 66 && i10 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i12 = this.f26565l;
            if (i12 != Integer.MIN_VALUE) {
                z(i12, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                E(this.f26562i, i10, rect2);
            }
            dVar = (a1.d) e1.b.c(mVarY, f26556s, f26555r, dVarH, rect2, i10);
        }
        return X(dVar != null ? mVarY.m(mVarY.k(dVar)) : Integer.MIN_VALUE);
    }

    @n0
    public a1.d L(int i10) {
        return i10 == -1 ? u() : t(i10);
    }

    public final void M(boolean z10, int i10, @p0 Rect rect) {
        int i11 = this.f26565l;
        if (i11 != Integer.MIN_VALUE) {
            o(i11);
        }
        if (z10) {
            K(i10, rect);
        }
    }

    public abstract boolean N(int i10, int i11, @p0 Bundle bundle);

    public void O(@n0 AccessibilityEvent accessibilityEvent) {
    }

    public void P(int i10, @n0 AccessibilityEvent accessibilityEvent) {
    }

    public void Q(@n0 a1.d dVar) {
    }

    public abstract void R(int i10, @n0 a1.d dVar);

    public void S(int i10, boolean z10) {
    }

    public boolean T(int i10, int i11, Bundle bundle) {
        return i10 != -1 ? U(i10, i11, bundle) : V(i11, bundle);
    }

    public final boolean U(int i10, int i11, Bundle bundle) {
        return i11 != 1 ? i11 != 2 ? i11 != 64 ? i11 != 128 ? N(i10, i11, bundle) : n(i10) : W(i10) : o(i10) : X(i10);
    }

    public final boolean V(int i10, Bundle bundle) {
        return u0.l1(this.f26562i, i10, bundle);
    }

    public final boolean W(int i10) {
        int i11;
        if (!this.f26561h.isEnabled() || !this.f26561h.isTouchExplorationEnabled() || (i11 = this.f26564k) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            n(i11);
        }
        this.f26564k = i10;
        this.f26562i.invalidate();
        Y(i10, 32768);
        return true;
    }

    public final boolean X(int i10) {
        int i11;
        if ((!this.f26562i.isFocused() && !this.f26562i.requestFocus()) || (i11 = this.f26565l) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            o(i11);
        }
        if (i10 == Integer.MIN_VALUE) {
            return false;
        }
        this.f26565l = i10;
        S(i10, true);
        Y(i10, 8);
        return true;
    }

    public final boolean Y(int i10, int i11) {
        ViewParent parent;
        if (i10 == Integer.MIN_VALUE || !this.f26561h.isEnabled() || (parent = this.f26562i.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f26562i, q(i10, i11));
    }

    public final void Z(int i10) {
        int i11 = this.f26566m;
        if (i11 == i10) {
            return;
        }
        this.f26566m = i10;
        Y(i10, 128);
        Y(i11, 256);
    }

    @Override // androidx.core.view.a
    public e b(View view) {
        if (this.f26563j == null) {
            this.f26563j = new c();
        }
        return this.f26563j;
    }

    @Override // androidx.core.view.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        O(accessibilityEvent);
    }

    @Override // androidx.core.view.a
    public void g(View view, a1.d dVar) {
        super.g(view, dVar);
        Q(dVar);
    }

    public final boolean n(int i10) {
        if (this.f26564k != i10) {
            return false;
        }
        this.f26564k = Integer.MIN_VALUE;
        this.f26562i.invalidate();
        Y(i10, 65536);
        return true;
    }

    public final boolean o(int i10) {
        if (this.f26565l != i10) {
            return false;
        }
        this.f26565l = Integer.MIN_VALUE;
        S(i10, false);
        Y(i10, 8);
        return true;
    }

    public final boolean p() {
        int i10 = this.f26565l;
        return i10 != Integer.MIN_VALUE && N(i10, 16, null);
    }

    public final AccessibilityEvent q(int i10, int i11) {
        return i10 != -1 ? r(i10, i11) : s(i11);
    }

    public final AccessibilityEvent r(int i10, int i11) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i11);
        a1.d dVarL = L(i10);
        accessibilityEventObtain.getText().add(dVarL.W());
        accessibilityEventObtain.setContentDescription(dVarL.A());
        accessibilityEventObtain.setScrollable(dVarL.B0());
        accessibilityEventObtain.setPassword(dVarL.z0());
        accessibilityEventObtain.setEnabled(dVarL.s0());
        accessibilityEventObtain.setChecked(dVarL.m0());
        P(i10, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(dVarL.w());
        f.Y(accessibilityEventObtain, this.f26562i, i10);
        accessibilityEventObtain.setPackageName(this.f26562i.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    public final AccessibilityEvent s(int i10) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i10);
        this.f26562i.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    @n0
    public final a1.d t(int i10) {
        a1.d dVarH0 = a1.d.H0();
        dVarH0.l1(true);
        dVarH0.n1(true);
        dVarH0.b1("android.view.View");
        Rect rect = f26554q;
        dVarH0.W0(rect);
        dVarH0.X0(rect);
        dVarH0.F1(this.f26562i);
        R(i10, dVarH0);
        if (dVarH0.W() == null && dVarH0.A() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        dVarH0.s(this.f26558e);
        if (this.f26558e.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int iP = dVarH0.p();
        if ((iP & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((iP & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        dVarH0.D1(this.f26562i.getContext().getPackageName());
        dVarH0.Q1(this.f26562i, i10);
        if (this.f26564k == i10) {
            dVarH0.T0(true);
            dVarH0.a(128);
        } else {
            dVarH0.T0(false);
            dVarH0.a(64);
        }
        boolean z10 = this.f26565l == i10;
        if (z10) {
            dVarH0.a(2);
        } else if (dVarH0.t0()) {
            dVarH0.a(1);
        }
        dVarH0.o1(z10);
        this.f26562i.getLocationOnScreen(this.f26560g);
        dVarH0.t(this.f26557d);
        if (this.f26557d.equals(rect)) {
            dVarH0.s(this.f26557d);
            if (dVarH0.f103b != -1) {
                a1.d dVarH02 = a1.d.H0();
                for (int i11 = dVarH0.f103b; i11 != -1; i11 = dVarH02.f103b) {
                    dVarH02.G1(this.f26562i, -1);
                    dVarH02.W0(f26554q);
                    R(i11, dVarH02);
                    dVarH02.s(this.f26558e);
                    Rect rect2 = this.f26557d;
                    Rect rect3 = this.f26558e;
                    rect2.offset(rect3.left, rect3.top);
                }
                dVarH02.N0();
            }
            this.f26557d.offset(this.f26560g[0] - this.f26562i.getScrollX(), this.f26560g[1] - this.f26562i.getScrollY());
        }
        if (this.f26562i.getLocalVisibleRect(this.f26559f)) {
            this.f26559f.offset(this.f26560g[0] - this.f26562i.getScrollX(), this.f26560g[1] - this.f26562i.getScrollY());
            if (this.f26557d.intersect(this.f26559f)) {
                dVarH0.X0(this.f26557d);
                if (I(this.f26557d)) {
                    dVarH0.e2(true);
                }
            }
        }
        return dVarH0;
    }

    @n0
    public final a1.d u() {
        a1.d dVarJ0 = a1.d.J0(this.f26562i);
        u0.i1(this.f26562i, dVarJ0);
        ArrayList arrayList = new ArrayList();
        D(arrayList);
        if (dVarJ0.v() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            dVarJ0.d(this.f26562i, ((Integer) arrayList.get(i10)).intValue());
        }
        return dVarJ0;
    }

    public final boolean v(@n0 MotionEvent motionEvent) {
        if (!this.f26561h.isEnabled() || !this.f26561h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iC = C(motionEvent.getX(), motionEvent.getY());
            Z(iC);
            return iC != Integer.MIN_VALUE;
        }
        if (action != 10 || this.f26566m == Integer.MIN_VALUE) {
            return false;
        }
        Z(Integer.MIN_VALUE);
        return true;
    }

    public final boolean w(@n0 KeyEvent keyEvent) {
        int i10 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return K(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return K(1, null);
            }
            return false;
        }
        if (keyCode != 66) {
            switch (keyCode) {
                case 19:
                case 20:
                case 21:
                case 22:
                    if (!keyEvent.hasNoModifiers()) {
                        return false;
                    }
                    int iJ = J(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z10 = false;
                    while (i10 < repeatCount && K(iJ, null)) {
                        i10++;
                        z10 = true;
                    }
                    return z10;
                case 23:
                    break;
                default:
                    return false;
            }
        }
        if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        p();
        return true;
    }

    public final int x() {
        return this.f26564k;
    }

    public final m<a1.d> y() {
        ArrayList arrayList = new ArrayList();
        D(arrayList);
        m<a1.d> mVar = new m<>();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            mVar.n(arrayList.get(i10).intValue(), t(arrayList.get(i10).intValue()));
        }
        return mVar;
    }

    public final void z(int i10, Rect rect) {
        L(i10).s(rect);
    }
}
