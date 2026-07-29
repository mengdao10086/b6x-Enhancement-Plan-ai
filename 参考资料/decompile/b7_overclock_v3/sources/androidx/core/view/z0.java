package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes2.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5152a = "ViewParentCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int[] f5153b;

    @g.v0(19)
    public static class a {
        @g.u
        public static void a(ViewParent viewParent, View view, View view2, int i10) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i10);
        }
    }

    @g.v0(21)
    public static class b {
        @g.u
        public static boolean a(ViewParent viewParent, View view, float f10, float f11, boolean z10) {
            return viewParent.onNestedFling(view, f10, f11, z10);
        }

        @g.u
        public static boolean b(ViewParent viewParent, View view, float f10, float f11) {
            return viewParent.onNestedPreFling(view, f10, f11);
        }

        @g.u
        public static void c(ViewParent viewParent, View view, int i10, int i11, int[] iArr) {
            viewParent.onNestedPreScroll(view, i10, i11, iArr);
        }

        @g.u
        public static void d(ViewParent viewParent, View view, int i10, int i11, int i12, int i13) {
            viewParent.onNestedScroll(view, i10, i11, i12, i13);
        }

        @g.u
        public static void e(ViewParent viewParent, View view, View view2, int i10) {
            viewParent.onNestedScrollAccepted(view, view2, i10);
        }

        @g.u
        public static boolean f(ViewParent viewParent, View view, View view2, int i10) {
            return viewParent.onStartNestedScroll(view, view2, i10);
        }

        @g.u
        public static void g(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    public static int[] a() {
        int[] iArr = f5153b;
        if (iArr == null) {
            f5153b = new int[2];
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return f5153b;
    }

    public static void b(@g.n0 ViewParent viewParent, @g.n0 View view, @g.n0 View view2, int i10) {
        a.a(viewParent, view, view2, i10);
    }

    public static boolean c(@g.n0 ViewParent viewParent, @g.n0 View view, float f10, float f11, boolean z10) {
        try {
            return b.a(viewParent, view, f10, f11, z10);
        } catch (AbstractMethodError unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ViewParent ");
            sb2.append(viewParent);
            sb2.append(" does not implement interface method onNestedFling");
            return false;
        }
    }

    public static boolean d(@g.n0 ViewParent viewParent, @g.n0 View view, float f10, float f11) {
        try {
            return b.b(viewParent, view, f10, f11);
        } catch (AbstractMethodError unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ViewParent ");
            sb2.append(viewParent);
            sb2.append(" does not implement interface method onNestedPreFling");
            return false;
        }
    }

    public static void e(@g.n0 ViewParent viewParent, @g.n0 View view, int i10, int i11, @g.n0 int[] iArr) {
        f(viewParent, view, i10, i11, iArr, 0);
    }

    public static void f(@g.n0 ViewParent viewParent, @g.n0 View view, int i10, int i11, @g.n0 int[] iArr, int i12) {
        if (viewParent instanceof g0) {
            ((g0) viewParent).K(view, i10, i11, iArr, i12);
            return;
        }
        if (i12 == 0) {
            try {
                b.c(viewParent, view, i10, i11, iArr);
            } catch (AbstractMethodError unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ViewParent ");
                sb2.append(viewParent);
                sb2.append(" does not implement interface method onNestedPreScroll");
            }
        }
    }

    public static void g(@g.n0 ViewParent viewParent, @g.n0 View view, int i10, int i11, int i12, int i13) {
        i(viewParent, view, i10, i11, i12, i13, 0, a());
    }

    public static void h(@g.n0 ViewParent viewParent, @g.n0 View view, int i10, int i11, int i12, int i13, int i14) {
        i(viewParent, view, i10, i11, i12, i13, i14, a());
    }

    public static void i(@g.n0 ViewParent viewParent, @g.n0 View view, int i10, int i11, int i12, int i13, int i14, @g.n0 int[] iArr) {
        if (viewParent instanceof h0) {
            ((h0) viewParent).B(view, i10, i11, i12, i13, i14, iArr);
            return;
        }
        iArr[0] = iArr[0] + i12;
        iArr[1] = iArr[1] + i13;
        if (viewParent instanceof g0) {
            ((g0) viewParent).D(view, i10, i11, i12, i13, i14);
            return;
        }
        if (i14 == 0) {
            try {
                b.d(viewParent, view, i10, i11, i12, i13);
            } catch (AbstractMethodError unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ViewParent ");
                sb2.append(viewParent);
                sb2.append(" does not implement interface method onNestedScroll");
            }
        }
    }

    public static void j(@g.n0 ViewParent viewParent, @g.n0 View view, @g.n0 View view2, int i10) {
        k(viewParent, view, view2, i10, 0);
    }

    public static void k(@g.n0 ViewParent viewParent, @g.n0 View view, @g.n0 View view2, int i10, int i11) {
        if (viewParent instanceof g0) {
            ((g0) viewParent).H(view, view2, i10, i11);
            return;
        }
        if (i11 == 0) {
            try {
                b.e(viewParent, view, view2, i10);
            } catch (AbstractMethodError unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ViewParent ");
                sb2.append(viewParent);
                sb2.append(" does not implement interface method onNestedScrollAccepted");
            }
        }
    }

    public static boolean l(@g.n0 ViewParent viewParent, @g.n0 View view, @g.n0 View view2, int i10) {
        return m(viewParent, view, view2, i10, 0);
    }

    public static boolean m(@g.n0 ViewParent viewParent, @g.n0 View view, @g.n0 View view2, int i10, int i11) {
        if (viewParent instanceof g0) {
            return ((g0) viewParent).G(view, view2, i10, i11);
        }
        if (i11 != 0) {
            return false;
        }
        try {
            return b.f(viewParent, view, view2, i10);
        } catch (AbstractMethodError unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ViewParent ");
            sb2.append(viewParent);
            sb2.append(" does not implement interface method onStartNestedScroll");
            return false;
        }
    }

    public static void n(@g.n0 ViewParent viewParent, @g.n0 View view) {
        o(viewParent, view, 0);
    }

    public static void o(@g.n0 ViewParent viewParent, @g.n0 View view, int i10) {
        if (viewParent instanceof g0) {
            ((g0) viewParent).J(view, i10);
            return;
        }
        if (i10 == 0) {
            try {
                b.g(viewParent, view);
            } catch (AbstractMethodError unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ViewParent ");
                sb2.append(viewParent);
                sb2.append(" does not implement interface method onStopNestedScroll");
            }
        }
    }

    @Deprecated
    public static boolean p(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }
}
