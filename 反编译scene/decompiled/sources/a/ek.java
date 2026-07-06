package a;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ek extends rf {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public dk f759a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View f761a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AccessibilityManager f762a;
    public static final Rect d = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fk<ni> f6014a = new bk();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final gk<ja<ni>, ni> f757a = new ck();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f760a = new Rect();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Rect f764b = new Rect();

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final Rect f765c = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f763a = new int[2];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f758a = Integer.MIN_VALUE;
    public int b = Integer.MIN_VALUE;
    public int c = Integer.MIN_VALUE;

    public ek(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.f761a = view;
        this.f762a = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (eh.w(view) == 0) {
            eh.t0(view, 1);
        }
    }

    public static Rect D(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else {
            if (i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            rect.set(0, -1, width, -1);
        }
        return rect;
    }

    public static int F(int i) {
        if (i == 19) {
            return 33;
        }
        if (i != 21) {
            return i != 22 ? 130 : 66;
        }
        return 17;
    }

    public final int A() {
        return this.b;
    }

    public abstract int B(float f, float f2);

    public abstract void C(List<Integer> list);

    public final boolean E(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f761a.getWindowVisibility() != 0) {
            return false;
        }
        View view = this.f761a;
        do {
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                return parent != null;
            }
            view = (View) parent;
            if (view.getAlpha() <= 0.0f) {
                break;
            }
        } while (view.getVisibility() == 0);
        return false;
    }

    public final boolean G(int i, Rect rect) {
        Object objD;
        ja<ni> jaVarY = y();
        int i2 = this.b;
        ni niVarE = i2 == Integer.MIN_VALUE ? null : jaVarY.e(i2);
        if (i == 1 || i == 2) {
            objD = ik.d(jaVarY, f757a, f6014a, niVarE, i, eh.y(this.f761a) == 1, false);
        } else {
            if (i != 17 && i != 33 && i != 66 && i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect2 = new Rect();
            int i3 = this.b;
            if (i3 != Integer.MIN_VALUE) {
                z(i3, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                D(this.f761a, i, rect2);
            }
            objD = ik.c(jaVarY, f757a, f6014a, niVarE, rect2, i);
        }
        ni niVar = (ni) objD;
        return T(niVar != null ? jaVarY.i(jaVarY.h(niVar)) : Integer.MIN_VALUE);
    }

    public ni H(int i) {
        return i == -1 ? u() : t(i);
    }

    public final void I(boolean z, int i, Rect rect) {
        int i2 = this.b;
        if (i2 != Integer.MIN_VALUE) {
            o(i2);
        }
        if (z) {
            G(i, rect);
        }
    }

    public abstract boolean J(int i, int i2, Bundle bundle);

    public void K(AccessibilityEvent accessibilityEvent) {
    }

    public void L(int i, AccessibilityEvent accessibilityEvent) {
    }

    public abstract void M(ni niVar);

    public abstract void N(int i, ni niVar);

    public abstract void O(int i, boolean z);

    public boolean P(int i, int i2, Bundle bundle) {
        return i != -1 ? Q(i, i2, bundle) : R(i2, bundle);
    }

    public final boolean Q(int i, int i2, Bundle bundle) {
        return i2 != 1 ? i2 != 2 ? i2 != 64 ? i2 != 128 ? J(i, i2, bundle) : n(i) : S(i) : o(i) : T(i);
    }

    public final boolean R(int i, Bundle bundle) {
        return eh.a0(this.f761a, i, bundle);
    }

    public final boolean S(int i) {
        int i2;
        if (!this.f762a.isEnabled() || !this.f762a.isTouchExplorationEnabled() || (i2 = this.f758a) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            n(i2);
        }
        this.f758a = i;
        this.f761a.invalidate();
        U(i, 32768);
        return true;
    }

    public final boolean T(int i) {
        int i2;
        if ((!this.f761a.isFocused() && !this.f761a.requestFocus()) || (i2 = this.b) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            o(i2);
        }
        this.b = i;
        O(i, true);
        U(i, 8);
        return true;
    }

    public final boolean U(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.f762a.isEnabled() || (parent = this.f761a.getParent()) == null) {
            return false;
        }
        return hh.h(parent, this.f761a, q(i, i2));
    }

    public final void V(int i) {
        int i2 = this.c;
        if (i2 == i) {
            return;
        }
        this.c = i;
        U(i, 128);
        U(i2, 256);
    }

    @Override // a.rf
    public ri b(View view) {
        if (this.f759a == null) {
            this.f759a = new dk(this);
        }
        return this.f759a;
    }

    @Override // a.rf
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        K(accessibilityEvent);
    }

    @Override // a.rf
    public void g(View view, ni niVar) {
        super.g(view, niVar);
        M(niVar);
    }

    public final boolean n(int i) {
        if (this.f758a != i) {
            return false;
        }
        this.f758a = Integer.MIN_VALUE;
        this.f761a.invalidate();
        U(i, 65536);
        return true;
    }

    public final boolean o(int i) {
        if (this.b != i) {
            return false;
        }
        this.b = Integer.MIN_VALUE;
        O(i, false);
        U(i, 8);
        return true;
    }

    public final boolean p() {
        int i = this.b;
        return i != Integer.MIN_VALUE && J(i, 16, null);
    }

    public final AccessibilityEvent q(int i, int i2) {
        return i != -1 ? r(i, i2) : s(i2);
    }

    public final AccessibilityEvent r(int i, int i2) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
        ni niVarH = H(i);
        accessibilityEventObtain.getText().add(niVarH.w());
        accessibilityEventObtain.setContentDescription(niVarH.r());
        accessibilityEventObtain.setScrollable(niVarH.J());
        accessibilityEventObtain.setPassword(niVarH.I());
        accessibilityEventObtain.setEnabled(niVarH.E());
        accessibilityEventObtain.setChecked(niVarH.C());
        L(i, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(niVarH.p());
        si.c(accessibilityEventObtain, this.f761a, i);
        accessibilityEventObtain.setPackageName(this.f761a.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    public final AccessibilityEvent s(int i) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i);
        this.f761a.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    public final ni t(int i) {
        ni niVarN = ni.N();
        niVarN.g0(true);
        niVarN.i0(true);
        niVarN.a0("android.view.View");
        niVarN.W(d);
        niVarN.X(d);
        niVarN.q0(this.f761a);
        N(i, niVarN);
        if (niVarN.w() == null && niVarN.r() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        niVarN.m(this.f764b);
        if (this.f764b.equals(d)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int iK = niVarN.k();
        if ((iK & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((iK & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        niVarN.o0(this.f761a.getContext().getPackageName());
        niVarN.y0(this.f761a, i);
        if (this.f758a == i) {
            niVarN.U(true);
            niVarN.a(128);
        } else {
            niVarN.U(false);
            niVarN.a(64);
        }
        boolean z = this.b == i;
        if (z) {
            niVarN.a(2);
        } else if (niVarN.F()) {
            niVarN.a(1);
        }
        niVarN.j0(z);
        this.f761a.getLocationOnScreen(this.f763a);
        niVarN.n(this.f760a);
        if (this.f760a.equals(d)) {
            niVarN.m(this.f760a);
            if (niVarN.f6917a != -1) {
                ni niVarN2 = ni.N();
                for (int i2 = niVarN.f6917a; i2 != -1; i2 = niVarN2.f6917a) {
                    niVarN2.r0(this.f761a, -1);
                    niVarN2.W(d);
                    N(i2, niVarN2);
                    niVarN2.m(this.f764b);
                    Rect rect = this.f760a;
                    Rect rect2 = this.f764b;
                    rect.offset(rect2.left, rect2.top);
                }
                niVarN2.R();
            }
            this.f760a.offset(this.f763a[0] - this.f761a.getScrollX(), this.f763a[1] - this.f761a.getScrollY());
        }
        if (this.f761a.getLocalVisibleRect(this.f765c)) {
            this.f765c.offset(this.f763a[0] - this.f761a.getScrollX(), this.f763a[1] - this.f761a.getScrollY());
            if (this.f760a.intersect(this.f765c)) {
                niVarN.X(this.f760a);
                if (E(this.f760a)) {
                    niVarN.B0(true);
                }
            }
        }
        return niVarN;
    }

    public final ni u() {
        ni niVarO = ni.O(this.f761a);
        eh.Y(this.f761a, niVarO);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        if (niVarO.o() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            niVarO.d(this.f761a, ((Integer) arrayList.get(i)).intValue());
        }
        return niVarO;
    }

    public final boolean v(MotionEvent motionEvent) {
        if (!this.f762a.isEnabled() || !this.f762a.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iB = B(motionEvent.getX(), motionEvent.getY());
            V(iB);
            return iB != Integer.MIN_VALUE;
        }
        if (action != 10 || this.c == Integer.MIN_VALUE) {
            return false;
        }
        V(Integer.MIN_VALUE);
        return true;
    }

    public final boolean w(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 61) {
            if (keyEvent.hasNoModifiers()) {
                return G(2, null);
            }
            if (keyEvent.hasModifiers(1)) {
                return G(1, null);
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
                    int iF = F(keyCode);
                    int repeatCount = keyEvent.getRepeatCount() + 1;
                    boolean z = false;
                    while (i < repeatCount && G(iF, null)) {
                        i++;
                        z = true;
                    }
                    return z;
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
        return this.f758a;
    }

    public final ja<ni> y() {
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        ja<ni> jaVar = new ja<>();
        for (int i = 0; i < arrayList.size(); i++) {
            jaVar.j(i, t(i));
        }
        return jaVar;
    }

    public final void z(int i, Rect rect) {
        H(i).m(rect);
    }
}
