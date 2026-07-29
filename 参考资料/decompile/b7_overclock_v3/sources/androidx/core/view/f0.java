package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes2.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewParent f4872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewParent f4873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f4874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f4876e;

    public f0(@g.n0 View view) {
        this.f4874c = view;
    }

    public boolean a(float f10, float f11, boolean z10) {
        ViewParent viewParentI;
        if (!m() || (viewParentI = i(0)) == null) {
            return false;
        }
        return z0.c(viewParentI, this.f4874c, f10, f11, z10);
    }

    public boolean b(float f10, float f11) {
        ViewParent viewParentI;
        if (!m() || (viewParentI = i(0)) == null) {
            return false;
        }
        return z0.d(viewParentI, this.f4874c, f10, f11);
    }

    public boolean c(int i10, int i11, @g.p0 int[] iArr, @g.p0 int[] iArr2) {
        return d(i10, i11, iArr, iArr2, 0);
    }

    public boolean d(int i10, int i11, @g.p0 int[] iArr, @g.p0 int[] iArr2, int i12) {
        ViewParent viewParentI;
        int i13;
        int i14;
        if (!m() || (viewParentI = i(i12)) == null) {
            return false;
        }
        if (i10 == 0 && i11 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        if (iArr2 != null) {
            this.f4874c.getLocationInWindow(iArr2);
            i13 = iArr2[0];
            i14 = iArr2[1];
        } else {
            i13 = 0;
            i14 = 0;
        }
        if (iArr == null) {
            iArr = j();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        z0.f(viewParentI, this.f4874c, i10, i11, iArr, i12);
        if (iArr2 != null) {
            this.f4874c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i13;
            iArr2[1] = iArr2[1] - i14;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public void e(int i10, int i11, int i12, int i13, @g.p0 int[] iArr, int i14, @g.p0 int[] iArr2) {
        h(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public boolean f(int i10, int i11, int i12, int i13, @g.p0 int[] iArr) {
        return h(i10, i11, i12, i13, iArr, 0, null);
    }

    public boolean g(int i10, int i11, int i12, int i13, @g.p0 int[] iArr, int i14) {
        return h(i10, i11, i12, i13, iArr, i14, null);
    }

    public final boolean h(int i10, int i11, int i12, int i13, @g.p0 int[] iArr, int i14, @g.p0 int[] iArr2) {
        ViewParent viewParentI;
        int i15;
        int i16;
        int[] iArr3;
        if (!m() || (viewParentI = i(i14)) == null) {
            return false;
        }
        if (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f4874c.getLocationInWindow(iArr);
            i15 = iArr[0];
            i16 = iArr[1];
        } else {
            i15 = 0;
            i16 = 0;
        }
        if (iArr2 == null) {
            int[] iArrJ = j();
            iArrJ[0] = 0;
            iArrJ[1] = 0;
            iArr3 = iArrJ;
        } else {
            iArr3 = iArr2;
        }
        z0.i(viewParentI, this.f4874c, i10, i11, i12, i13, i14, iArr3);
        if (iArr != null) {
            this.f4874c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i15;
            iArr[1] = iArr[1] - i16;
        }
        return true;
    }

    public final ViewParent i(int i10) {
        if (i10 == 0) {
            return this.f4872a;
        }
        if (i10 != 1) {
            return null;
        }
        return this.f4873b;
    }

    public final int[] j() {
        if (this.f4876e == null) {
            this.f4876e = new int[2];
        }
        return this.f4876e;
    }

    public boolean k() {
        return l(0);
    }

    public boolean l(int i10) {
        return i(i10) != null;
    }

    public boolean m() {
        return this.f4875d;
    }

    public void n() {
        u0.G2(this.f4874c);
    }

    public void o(@g.n0 View view) {
        u0.G2(this.f4874c);
    }

    public void p(boolean z10) {
        if (this.f4875d) {
            u0.G2(this.f4874c);
        }
        this.f4875d = z10;
    }

    public final void q(int i10, ViewParent viewParent) {
        if (i10 == 0) {
            this.f4872a = viewParent;
        } else {
            if (i10 != 1) {
                return;
            }
            this.f4873b = viewParent;
        }
    }

    public boolean r(int i10) {
        return s(i10, 0);
    }

    public boolean s(int i10, int i11) {
        if (l(i11)) {
            return true;
        }
        if (!m()) {
            return false;
        }
        View view = this.f4874c;
        for (ViewParent parent = this.f4874c.getParent(); parent != null; parent = parent.getParent()) {
            if (z0.m(parent, view, this.f4874c, i10, i11)) {
                q(i11, parent);
                z0.k(parent, view, this.f4874c, i10, i11);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void t() {
        u(0);
    }

    public void u(int i10) {
        ViewParent viewParentI = i(i10);
        if (viewParentI != null) {
            z0.o(viewParentI, this.f4874c, i10);
            q(i10, null);
        }
    }
}
