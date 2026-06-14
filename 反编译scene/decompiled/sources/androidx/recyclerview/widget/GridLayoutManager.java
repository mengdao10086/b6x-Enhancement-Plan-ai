package androidx.recyclerview.widget;

import a.ni;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f8214a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseIntArray f4291a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f4292a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View[] f4293a;
    public final SparseIntArray b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int[] f4294b;
    public int j;
    public boolean m;
    public boolean n;

    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int e(int i, int i2) {
            return i % i2;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i) {
            return 1;
        }
    }

    public static class b extends RecyclerView.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8215a;
        public int b;

        public b(int i, int i2) {
            super(i, i2);
            this.f8215a = -1;
            this.b = 0;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8215a = -1;
            this.b = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8215a = -1;
            this.b = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f8215a = -1;
            this.b = 0;
        }

        public int u() {
            return this.f8215a;
        }

        public int v() {
            return this.b;
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseIntArray f8216a = new SparseIntArray();
        public final SparseIntArray b = new SparseIntArray();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4295a = false;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4296b = false;

        public static int a(SparseIntArray sparseIntArray, int i) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        public int b(int i, int i2) {
            if (!this.f4296b) {
                return d(i, i2);
            }
            int i3 = this.b.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iD = d(i, i2);
            this.b.put(i, iD);
            return iD;
        }

        public int c(int i, int i2) {
            if (!this.f4295a) {
                return e(i, i2);
            }
            int i3 = this.f8216a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iE = e(i, i2);
            this.f8216a.put(i, iE);
            return iE;
        }

        public int d(int i, int i2) {
            int i3;
            int i4;
            int iC;
            int iA;
            if (!this.f4296b || (iA = a(this.b, i)) == -1) {
                i3 = 0;
                i4 = 0;
                iC = 0;
            } else {
                i3 = this.b.get(iA);
                i4 = iA + 1;
                iC = c(iA, i2) + f(iA);
                if (iC == i2) {
                    i3++;
                    iC = 0;
                }
            }
            int iF = f(i);
            while (i4 < i) {
                int iF2 = f(i4);
                iC += iF2;
                if (iC == i2) {
                    i3++;
                    iC = 0;
                } else if (iC > i2) {
                    i3++;
                    iC = iF2;
                }
                i4++;
            }
            return iC + iF > i2 ? i3 + 1 : i3;
        }

        public abstract int e(int i, int i2);

        public abstract int f(int i);

        public void g() {
            this.b.clear();
        }

        public void h() {
            this.f8216a.clear();
        }
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.m = false;
        this.j = -1;
        this.f4291a = new SparseIntArray();
        this.b = new SparseIntArray();
        this.f4292a = new a();
        this.f8214a = new Rect();
        j3(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.m = false;
        this.j = -1;
        this.f4291a = new SparseIntArray();
        this.b = new SparseIntArray();
        this.f4292a = new a();
        this.f8214a = new Rect();
        j3(RecyclerView.o.n0(context, attributeSet, i, i2).b);
    }

    public static int[] W2(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int B(RecyclerView.a0 a0Var) {
        return this.n ? Y2(a0Var) : super.B(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int C(RecyclerView.a0 a0Var) {
        return this.n ? Z2(a0Var) : super.C(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int C1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        k3();
        b3();
        return super.C1(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int E(RecyclerView.a0 a0Var) {
        return this.n ? Y2(a0Var) : super.E(a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int E1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        k3();
        b3();
        return super.E1(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int F(RecyclerView.a0 a0Var) {
        return this.n ? Z2(a0Var) : super.F(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I1(Rect rect, int i, int i2) {
        int iX;
        int iX2;
        if (this.f4294b == null) {
            super.I1(rect, i, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (((LinearLayoutManager) this).f == 1) {
            iX2 = RecyclerView.o.x(i2, rect.height() + paddingTop, k0());
            int[] iArr = this.f4294b;
            iX = RecyclerView.o.x(i, iArr[iArr.length - 1] + paddingLeft, l0());
        } else {
            iX = RecyclerView.o.x(i, rect.width() + paddingLeft, l0());
            int[] iArr2 = this.f4294b;
            iX2 = RecyclerView.o.x(i2, iArr2[iArr2.length - 1] + paddingTop, k0());
        }
        H1(iX, iX2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void K2(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.K2(false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p N() {
        return ((LinearLayoutManager) this).f == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p O(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p P(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
    
        if (r13 == (r2 > r15)) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0107  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View P0(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.v r26, androidx.recyclerview.widget.RecyclerView.a0 r27) {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.P0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean P1() {
        return ((LinearLayoutManager) this).f4300a == null && !this.m;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void R1(RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, RecyclerView.o.a aVar) {
        int iF = this.j;
        for (int i = 0; i < this.j && cVar.c(a0Var) && iF > 0; i++) {
            int i2 = cVar.c;
            aVar.a(i2, Math.max(0, cVar.f));
            iF -= this.f4292a.f(i2);
            cVar.c += cVar.d;
        }
    }

    public final void T2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i, boolean z) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = -1;
        if (z) {
            i3 = 1;
            i5 = i;
            i2 = 0;
        } else {
            i2 = i - 1;
            i3 = -1;
        }
        while (i2 != i5) {
            View view = this.f4293a[i2];
            b bVar = (b) view.getLayoutParams();
            int iF3 = f3(vVar, a0Var, m0(view));
            bVar.b = iF3;
            bVar.f8215a = i4;
            i4 += iF3;
            i2 += i3;
        }
    }

    public final void U2() {
        int iT = T();
        for (int i = 0; i < iT; i++) {
            b bVar = (b) S(i).getLayoutParams();
            int iQ = bVar.q();
            this.f4291a.put(iQ, bVar.v());
            this.b.put(iQ, bVar.u());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void V0(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, ni niVar) {
        int iV;
        int iU;
        int iV2;
        boolean z;
        boolean z2;
        int iU2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.U0(view, niVar);
            return;
        }
        b bVar = (b) layoutParams;
        int iD3 = d3(vVar, a0Var, bVar.q());
        if (((LinearLayoutManager) this).f == 0) {
            iU2 = bVar.u();
            iV = bVar.v();
            iV2 = 1;
            z = false;
            z2 = false;
            iU = iD3;
        } else {
            iV = 1;
            iU = bVar.u();
            iV2 = bVar.v();
            z = false;
            z2 = false;
            iU2 = iD3;
        }
        niVar.d0(ni.c.a(iU2, iV, iU, iV2, z, z2));
    }

    public final void V2(int i) {
        this.f4294b = W2(this.f4294b, this.j, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int X(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (((LinearLayoutManager) this).f == 1) {
            return this.j;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return d3(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView recyclerView, int i, int i2) {
        this.f4292a.h();
        this.f4292a.g();
    }

    public final void X2() {
        this.f4291a.clear();
        this.b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView recyclerView) {
        this.f4292a.h();
        this.f4292a.g();
    }

    public final int Y2(RecyclerView.a0 a0Var) {
        if (T() != 0 && a0Var.b() != 0) {
            X1();
            boolean zV2 = v2();
            View viewC2 = c2(!zV2, true);
            View viewB2 = b2(!zV2, true);
            if (viewC2 != null && viewB2 != null) {
                int iB = this.f4292a.b(m0(viewC2), this.j);
                int iB2 = this.f4292a.b(m0(viewB2), this.j);
                int iMax = ((LinearLayoutManager) this).f4304i ? Math.max(0, ((this.f4292a.b(a0Var.b() - 1, this.j) + 1) - Math.max(iB, iB2)) - 1) : Math.max(0, Math.min(iB, iB2));
                if (zV2) {
                    return Math.round((iMax * (Math.abs(((LinearLayoutManager) this).f8217a.d(viewB2) - ((LinearLayoutManager) this).f8217a.g(viewC2)) / ((this.f4292a.b(m0(viewB2), this.j) - this.f4292a.b(m0(viewC2), this.j)) + 1))) + (((LinearLayoutManager) this).f8217a.m() - ((LinearLayoutManager) this).f8217a.g(viewC2)));
                }
                return iMax;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Z0(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f4292a.h();
        this.f4292a.g();
    }

    public final int Z2(RecyclerView.a0 a0Var) {
        if (T() != 0 && a0Var.b() != 0) {
            X1();
            View viewC2 = c2(!v2(), true);
            View viewB2 = b2(!v2(), true);
            if (viewC2 != null && viewB2 != null) {
                if (!v2()) {
                    return this.f4292a.b(a0Var.b() - 1, this.j) + 1;
                }
                int iD = ((LinearLayoutManager) this).f8217a.d(viewB2) - ((LinearLayoutManager) this).f8217a.g(viewC2);
                int iB = this.f4292a.b(m0(viewC2), this.j);
                return (int) ((iD / ((this.f4292a.b(m0(viewB2), this.j) - iB) + 1)) * (this.f4292a.b(a0Var.b() - 1, this.j) + 1));
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a1(RecyclerView recyclerView, int i, int i2) {
        this.f4292a.h();
        this.f4292a.g();
    }

    public final void a3(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int iE3 = e3(vVar, a0Var, aVar.f8218a);
        if (z) {
            while (iE3 > 0) {
                int i2 = aVar.f8218a;
                if (i2 <= 0) {
                    return;
                }
                int i3 = i2 - 1;
                aVar.f8218a = i3;
                iE3 = e3(vVar, a0Var, i3);
            }
            return;
        }
        int iB = a0Var.b() - 1;
        int i4 = aVar.f8218a;
        while (i4 < iB) {
            int i5 = i4 + 1;
            int iE32 = e3(vVar, a0Var, i5);
            if (iE32 <= iE3) {
                break;
            }
            i4 = i5;
            iE3 = iE32;
        }
        aVar.f8218a = i4;
    }

    public final void b3() {
        View[] viewArr = this.f4293a;
        if (viewArr == null || viewArr.length != this.j) {
            this.f4293a = new View[this.j];
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f4292a.h();
        this.f4292a.g();
    }

    public int c3(int i, int i2) {
        if (((LinearLayoutManager) this).f != 1 || !u2()) {
            int[] iArr = this.f4294b;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.f4294b;
        int i3 = this.j;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void d1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (a0Var.e()) {
            U2();
        }
        super.d1(vVar, a0Var);
        X2();
    }

    public final int d3(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i) {
        if (!a0Var.e()) {
            return this.f4292a.b(i, this.j);
        }
        int iF = vVar.f(i);
        if (iF != -1) {
            return this.f4292a.b(iF, this.j);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void e1(RecyclerView.a0 a0Var) {
        super.e1(a0Var);
        this.m = false;
    }

    public final int e3(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i) {
        if (!a0Var.e()) {
            return this.f4292a.c(i, this.j);
        }
        int i2 = this.b.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iF = vVar.f(i);
        if (iF != -1) {
            return this.f4292a.c(iF, this.j);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    public final int f3(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i) {
        if (!a0Var.e()) {
            return this.f4292a.f(i);
        }
        int i2 = this.f4291a.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iF = vVar.f(i);
        if (iF != -1) {
            return this.f4292a.f(iF);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    public final void g3(float f, int i) {
        V2(Math.max(Math.round(f * this.j), i));
    }

    public final void h3(View view, int i, boolean z) {
        int iU;
        int iU2;
        b bVar = (b) view.getLayoutParams();
        Rect rect = ((RecyclerView.p) bVar).f8237a;
        int i2 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i3 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int iC3 = c3(bVar.f8215a, bVar.b);
        if (((LinearLayoutManager) this).f == 1) {
            iU2 = RecyclerView.o.U(iC3, i, i3, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            iU = RecyclerView.o.U(((LinearLayoutManager) this).f8217a.n(), h0(), i2, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int iU3 = RecyclerView.o.U(iC3, i, i2, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int iU4 = RecyclerView.o.U(((LinearLayoutManager) this).f8217a.n(), u0(), i3, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            iU = iU3;
            iU2 = iU4;
        }
        i3(view, iU2, iU, z);
    }

    public final void i3(View view, int i, int i2, boolean z) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z ? N1(view, i, i2, pVar) : L1(view, i, i2, pVar)) {
            view.measure(i, i2);
        }
    }

    public void j3(int i) {
        if (i == this.j) {
            return;
        }
        this.m = true;
        if (i >= 1) {
            this.j = i;
            this.f4292a.h();
            z1();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
    }

    public final void k3() {
        int iG0;
        int paddingTop;
        if (t2() == 1) {
            iG0 = t0() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            iG0 = g0() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        V2(iG0 - paddingTop);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View l2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i, int i2, int i3) {
        X1();
        int iM = ((LinearLayoutManager) this).f8217a.m();
        int i4 = ((LinearLayoutManager) this).f8217a.i();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewS = S(i);
            int iM0 = m0(viewS);
            if (iM0 >= 0 && iM0 < i3 && e3(vVar, a0Var, iM0) == 0) {
                if (((RecyclerView.p) viewS.getLayoutParams()).s()) {
                    if (view2 == null) {
                        view2 = viewS;
                    }
                } else {
                    if (((LinearLayoutManager) this).f8217a.g(viewS) < i4 && ((LinearLayoutManager) this).f8217a.d(viewS) >= iM) {
                        return viewS;
                    }
                    if (view == null) {
                        view = viewS;
                    }
                }
            }
            i += i5;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int p0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (((LinearLayoutManager) this).f == 0) {
            return this.j;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return d3(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean w(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0218  */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v19 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void w2(androidx.recyclerview.widget.RecyclerView.v r18, androidx.recyclerview.widget.RecyclerView.a0 r19, androidx.recyclerview.widget.LinearLayoutManager.c r20, androidx.recyclerview.widget.LinearLayoutManager.b r21) {
        /*
            Method dump skipped, instruction units count: 563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.w2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void y2(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i) {
        super.y2(vVar, a0Var, aVar, i);
        k3();
        if (a0Var.b() > 0 && !a0Var.e()) {
            a3(vVar, a0Var, aVar, i);
        }
        b3();
    }
}
