package androidx.recyclerview.widget;

import a.eq;
import a.np;
import a.rp;
import a.wp;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements np.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wp f8217a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f4297a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f4298a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f4299a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f4300a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f4301a;
    public int f;
    public int g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f4302g;
    public int h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f4303h;
    public int i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public boolean f4304i;
    public boolean j;
    public boolean k;
    public boolean l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8218a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public wp f4305a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4306a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4307b;

        public a() {
            e();
        }

        public void a() {
            this.b = this.f4306a ? this.f4305a.i() : this.f4305a.m();
        }

        public void b(View view, int i) {
            this.b = this.f4306a ? this.f4305a.d(view) + this.f4305a.o() : this.f4305a.g(view);
            this.f8218a = i;
        }

        public void c(View view, int i) {
            int iO = this.f4305a.o();
            if (iO >= 0) {
                b(view, i);
                return;
            }
            this.f8218a = i;
            if (this.f4306a) {
                int i2 = (this.f4305a.i() - iO) - this.f4305a.d(view);
                this.b = this.f4305a.i() - i2;
                if (i2 > 0) {
                    int iE = this.b - this.f4305a.e(view);
                    int iM = this.f4305a.m();
                    int iMin = iE - (iM + Math.min(this.f4305a.g(view) - iM, 0));
                    if (iMin < 0) {
                        this.b += Math.min(i2, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG = this.f4305a.g(view);
            int iM2 = iG - this.f4305a.m();
            this.b = iG;
            if (iM2 > 0) {
                int i3 = (this.f4305a.i() - Math.min(0, (this.f4305a.i() - iO) - this.f4305a.d(view))) - (iG + this.f4305a.e(view));
                if (i3 < 0) {
                    this.b -= Math.min(iM2, -i3);
                }
            }
        }

        public boolean d(View view, RecyclerView.a0 a0Var) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.s() && pVar.q() >= 0 && pVar.q() < a0Var.b();
        }

        public void e() {
            this.f8218a = -1;
            this.b = Integer.MIN_VALUE;
            this.f4306a = false;
            this.f4307b = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f8218a + ", mCoordinate=" + this.b + ", mLayoutFromEnd=" + this.f4306a + ", mValid=" + this.f4307b + '}';
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8219a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4308a;
        public boolean b;
        public boolean c;

        public void a() {
            this.f8219a = 0;
            this.f4308a = false;
            this.b = false;
            this.c = false;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8220a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4311b;
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f4312c;
        public int d;
        public int e;
        public int f;
        public int i;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4310a = true;
        public int g = 0;
        public int h = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public List<RecyclerView.d0> f4309a = null;

        public void a() {
            b(null);
        }

        public void b(View view) {
            View viewF = f(view);
            this.c = viewF == null ? -1 : ((RecyclerView.p) viewF.getLayoutParams()).q();
        }

        public boolean c(RecyclerView.a0 a0Var) {
            int i = this.c;
            return i >= 0 && i < a0Var.b();
        }

        public View d(RecyclerView.v vVar) {
            if (this.f4309a != null) {
                return e();
            }
            View viewO = vVar.o(this.c);
            this.c += this.d;
            return viewO;
        }

        public final View e() {
            int size = this.f4309a.size();
            for (int i = 0; i < size; i++) {
                View view = this.f4309a.get(i).f4387a;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.s() && this.c == pVar.q()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public View f(View view) {
            int iQ;
            int size = this.f4309a.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.f4309a.get(i2).f4387a;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.s() && (iQ = (pVar.q() - this.c) * this.d) >= 0 && iQ < i) {
                    view2 = view3;
                    if (iQ == 0) {
                        break;
                    }
                    i = iQ;
                }
            }
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new rp();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8221a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4313b;

        public d() {
        }

        public d(Parcel parcel) {
            this.f8221a = parcel.readInt();
            this.b = parcel.readInt();
            this.f4313b = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f8221a = dVar.f8221a;
            this.b = dVar.b;
            this.f4313b = dVar.f4313b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean q() {
            return this.f8221a >= 0;
        }

        public void r() {
            this.f8221a = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f8221a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.f4313b ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f = 1;
        this.f4303h = false;
        this.f4304i = false;
        this.j = false;
        this.k = true;
        this.g = -1;
        this.h = Integer.MIN_VALUE;
        this.f4300a = null;
        this.f4297a = new a();
        this.f4298a = new b();
        this.i = 2;
        this.f4301a = new int[2];
        H2(i);
        I2(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f = 1;
        this.f4303h = false;
        this.f4304i = false;
        this.j = false;
        this.k = true;
        this.g = -1;
        this.h = Integer.MIN_VALUE;
        this.f4300a = null;
        this.f4297a = new a();
        this.f4298a = new b();
        this.i = 2;
        this.f4301a = new int[2];
        RecyclerView.o.b bVarN0 = RecyclerView.o.n0(context, attributeSet, i, i2);
        H2(bVarN0.f8236a);
        I2(bVarN0.f4410a);
        K2(bVarN0.f4411b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int A(RecyclerView.a0 a0Var) {
        return S1(a0Var);
    }

    public final void A2(RecyclerView.v vVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                t1(i, vVar);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                t1(i3, vVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int B(RecyclerView.a0 a0Var) {
        return T1(a0Var);
    }

    public final void B2(RecyclerView.v vVar, int i, int i2) {
        int iT = T();
        if (i < 0) {
            return;
        }
        int iH = (this.f8217a.h() - i) + i2;
        if (this.f4304i) {
            for (int i3 = 0; i3 < iT; i3++) {
                View viewS = S(i3);
                if (this.f8217a.g(viewS) < iH || this.f8217a.q(viewS) < iH) {
                    A2(vVar, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = iT - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View viewS2 = S(i5);
            if (this.f8217a.g(viewS2) < iH || this.f8217a.q(viewS2) < iH) {
                A2(vVar, i4, i5);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int C(RecyclerView.a0 a0Var) {
        return U1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int C1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f == 1) {
            return 0;
        }
        return F2(i, vVar, a0Var);
    }

    public final void C2(RecyclerView.v vVar, int i, int i2) {
        if (i < 0) {
            return;
        }
        int i3 = i - i2;
        int iT = T();
        if (!this.f4304i) {
            for (int i4 = 0; i4 < iT; i4++) {
                View viewS = S(i4);
                if (this.f8217a.d(viewS) > i3 || this.f8217a.p(viewS) > i3) {
                    A2(vVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = iT - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View viewS2 = S(i6);
            if (this.f8217a.d(viewS2) > i3 || this.f8217a.p(viewS2) > i3) {
                A2(vVar, i5, i6);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int D(RecyclerView.a0 a0Var) {
        return S1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D1(int i) {
        this.g = i;
        this.h = Integer.MIN_VALUE;
        d dVar = this.f4300a;
        if (dVar != null) {
            dVar.r();
        }
        z1();
    }

    public boolean D2() {
        return this.f8217a.k() == 0 && this.f8217a.h() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int E(RecyclerView.a0 a0Var) {
        return T1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int E1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.f == 0) {
            return 0;
        }
        return F2(i, vVar, a0Var);
    }

    public final void E2() {
        this.f4304i = (this.f == 1 || !u2()) ? this.f4303h : !this.f4303h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int F(RecyclerView.a0 a0Var) {
        return U1(a0Var);
    }

    public int F2(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (T() == 0 || i == 0) {
            return 0;
        }
        X1();
        this.f4299a.f4310a = true;
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        O2(i2, iAbs, true, a0Var);
        c cVar = this.f4299a;
        int iY1 = cVar.f + Y1(vVar, cVar, a0Var, false);
        if (iY1 < 0) {
            return 0;
        }
        if (iAbs > iY1) {
            i = i2 * iY1;
        }
        this.f8217a.r(-i);
        this.f4299a.i = i;
        return i;
    }

    public void G2(int i, int i2) {
        this.g = i;
        this.h = i2;
        d dVar = this.f4300a;
        if (dVar != null) {
            dVar.r();
        }
        z1();
    }

    public void H2(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        q(null);
        if (i != this.f || this.f8217a == null) {
            wp wpVarB = wp.b(this, i);
            this.f8217a = wpVarB;
            this.f4297a.f4305a = wpVarB;
            this.f = i;
            z1();
        }
    }

    public void I2(boolean z) {
        q(null);
        if (z == this.f4303h) {
            return;
        }
        this.f4303h = z;
        z1();
    }

    public void J2(boolean z) {
        this.k = z;
    }

    public void K2(boolean z) {
        q(null);
        if (this.j == z) {
            return;
        }
        this.j = z;
        z1();
    }

    public final boolean L2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (T() == 0) {
            return false;
        }
        View viewF0 = f0();
        if (viewF0 != null && aVar.d(viewF0, a0Var)) {
            aVar.c(viewF0, m0(viewF0));
            return true;
        }
        if (this.f4302g != this.j) {
            return false;
        }
        View viewM2 = aVar.f4306a ? m2(vVar, a0Var) : n2(vVar, a0Var);
        if (viewM2 == null) {
            return false;
        }
        aVar.b(viewM2, m0(viewM2));
        if (!a0Var.e() && P1()) {
            if (this.f8217a.g(viewM2) >= this.f8217a.i() || this.f8217a.d(viewM2) < this.f8217a.m()) {
                aVar.b = aVar.f4306a ? this.f8217a.i() : this.f8217a.m();
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View M(int i) {
        int iT = T();
        if (iT == 0) {
            return null;
        }
        int iM0 = i - m0(S(0));
        if (iM0 >= 0 && iM0 < iT) {
            View viewS = S(iM0);
            if (m0(viewS) == i) {
                return viewS;
            }
        }
        return super.M(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean M1() {
        return (h0() == 1073741824 || u0() == 1073741824 || !v0()) ? false : true;
    }

    public final boolean M2(RecyclerView.a0 a0Var, a aVar) {
        int i;
        if (!a0Var.e() && (i = this.g) != -1) {
            if (i >= 0 && i < a0Var.b()) {
                aVar.f8218a = this.g;
                d dVar = this.f4300a;
                if (dVar != null && dVar.q()) {
                    boolean z = this.f4300a.f4313b;
                    aVar.f4306a = z;
                    aVar.b = z ? this.f8217a.i() - this.f4300a.b : this.f8217a.m() + this.f4300a.b;
                    return true;
                }
                if (this.h != Integer.MIN_VALUE) {
                    boolean z2 = this.f4304i;
                    aVar.f4306a = z2;
                    aVar.b = z2 ? this.f8217a.i() - this.h : this.f8217a.m() + this.h;
                    return true;
                }
                View viewM = M(this.g);
                if (viewM == null) {
                    if (T() > 0) {
                        aVar.f4306a = (this.g < m0(S(0))) == this.f4304i;
                    }
                    aVar.a();
                } else {
                    if (this.f8217a.e(viewM) > this.f8217a.n()) {
                        aVar.a();
                        return true;
                    }
                    if (this.f8217a.g(viewM) - this.f8217a.m() < 0) {
                        aVar.b = this.f8217a.m();
                        aVar.f4306a = false;
                        return true;
                    }
                    if (this.f8217a.i() - this.f8217a.d(viewM) < 0) {
                        aVar.b = this.f8217a.i();
                        aVar.f4306a = true;
                        return true;
                    }
                    aVar.b = aVar.f4306a ? this.f8217a.d(viewM) + this.f8217a.o() : this.f8217a.g(viewM);
                }
                return true;
            }
            this.g = -1;
            this.h = Integer.MIN_VALUE;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p N() {
        return new RecyclerView.p(-2, -2);
    }

    public final void N2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar) {
        if (M2(a0Var, aVar) || L2(vVar, a0Var, aVar)) {
            return;
        }
        aVar.a();
        aVar.f8218a = this.j ? a0Var.b() - 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void O0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.O0(recyclerView, vVar);
        if (this.l) {
            q1(vVar);
            vVar.c();
        }
    }

    public final void O2(int i, int i2, boolean z, RecyclerView.a0 a0Var) {
        int iM;
        this.f4299a.f4312c = D2();
        this.f4299a.e = i;
        int[] iArr = this.f4301a;
        iArr[0] = 0;
        iArr[1] = 0;
        Q1(a0Var, iArr);
        int iMax = Math.max(0, this.f4301a[0]);
        int iMax2 = Math.max(0, this.f4301a[1]);
        boolean z2 = i == 1;
        this.f4299a.g = z2 ? iMax2 : iMax;
        c cVar = this.f4299a;
        if (!z2) {
            iMax = iMax2;
        }
        cVar.h = iMax;
        if (z2) {
            this.f4299a.g += this.f8217a.j();
            View viewQ2 = q2();
            this.f4299a.d = this.f4304i ? -1 : 1;
            c cVar2 = this.f4299a;
            int iM0 = m0(viewQ2);
            c cVar3 = this.f4299a;
            cVar2.c = iM0 + cVar3.d;
            cVar3.f8220a = this.f8217a.d(viewQ2);
            iM = this.f8217a.d(viewQ2) - this.f8217a.i();
        } else {
            View viewR2 = r2();
            this.f4299a.g += this.f8217a.m();
            this.f4299a.d = this.f4304i ? 1 : -1;
            c cVar4 = this.f4299a;
            int iM02 = m0(viewR2);
            c cVar5 = this.f4299a;
            cVar4.c = iM02 + cVar5.d;
            cVar5.f8220a = this.f8217a.g(viewR2);
            iM = (-this.f8217a.g(viewR2)) + this.f8217a.m();
        }
        c cVar6 = this.f4299a;
        cVar6.b = i2;
        if (z) {
            cVar6.b = i2 - iM;
        }
        this.f4299a.f = iM;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View P0(View view, int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int iV1;
        E2();
        if (T() == 0 || (iV1 = V1(i)) == Integer.MIN_VALUE) {
            return null;
        }
        X1();
        O2(iV1, (int) (this.f8217a.n() * 0.33333334f), false, a0Var);
        c cVar = this.f4299a;
        cVar.f = Integer.MIN_VALUE;
        cVar.f4310a = false;
        Y1(vVar, cVar, a0Var, true);
        View viewK2 = iV1 == -1 ? k2() : j2();
        View viewR2 = iV1 == -1 ? r2() : q2();
        if (!viewR2.hasFocusable()) {
            return viewK2;
        }
        if (viewK2 == null) {
            return null;
        }
        return viewR2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean P1() {
        return this.f4300a == null && this.f4302g == this.j;
    }

    public final void P2(int i, int i2) {
        this.f4299a.b = this.f8217a.i() - i2;
        this.f4299a.d = this.f4304i ? -1 : 1;
        c cVar = this.f4299a;
        cVar.c = i;
        cVar.e = 1;
        cVar.f8220a = i2;
        cVar.f = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Q0(AccessibilityEvent accessibilityEvent) {
        super.Q0(accessibilityEvent);
        if (T() > 0) {
            accessibilityEvent.setFromIndex(d2());
            accessibilityEvent.setToIndex(g2());
        }
    }

    public void Q1(RecyclerView.a0 a0Var, int[] iArr) {
        int i;
        int iS2 = s2(a0Var);
        if (this.f4299a.e == -1) {
            i = 0;
        } else {
            i = iS2;
            iS2 = 0;
        }
        iArr[0] = iS2;
        iArr[1] = i;
    }

    public final void Q2(a aVar) {
        P2(aVar.f8218a, aVar.b);
    }

    public void R1(RecyclerView.a0 a0Var, c cVar, RecyclerView.o.a aVar) {
        int i = cVar.c;
        if (i < 0 || i >= a0Var.b()) {
            return;
        }
        aVar.a(i, Math.max(0, cVar.f));
    }

    public final void R2(int i, int i2) {
        this.f4299a.b = i2 - this.f8217a.m();
        c cVar = this.f4299a;
        cVar.c = i;
        cVar.d = this.f4304i ? 1 : -1;
        c cVar2 = this.f4299a;
        cVar2.e = -1;
        cVar2.f8220a = i2;
        cVar2.f = Integer.MIN_VALUE;
    }

    public final int S1(RecyclerView.a0 a0Var) {
        if (T() == 0) {
            return 0;
        }
        X1();
        return eq.a(a0Var, this.f8217a, c2(!this.k, true), b2(!this.k, true), this, this.k);
    }

    public final void S2(a aVar) {
        R2(aVar.f8218a, aVar.b);
    }

    public final int T1(RecyclerView.a0 a0Var) {
        if (T() == 0) {
            return 0;
        }
        X1();
        return eq.b(a0Var, this.f8217a, c2(!this.k, true), b2(!this.k, true), this, this.k, this.f4304i);
    }

    public final int U1(RecyclerView.a0 a0Var) {
        if (T() == 0) {
            return 0;
        }
        X1();
        return eq.c(a0Var, this.f8217a, c2(!this.k, true), b2(!this.k, true), this, this.k);
    }

    public int V1(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.f == 1) ? 1 : Integer.MIN_VALUE : this.f == 0 ? 1 : Integer.MIN_VALUE : this.f == 1 ? -1 : Integer.MIN_VALUE : this.f == 0 ? -1 : Integer.MIN_VALUE : (this.f != 1 && u2()) ? -1 : 1 : (this.f != 1 && u2()) ? 1 : -1;
    }

    public c W1() {
        return new c();
    }

    public void X1() {
        if (this.f4299a == null) {
            this.f4299a = W1();
        }
    }

    public int Y1(RecyclerView.v vVar, c cVar, RecyclerView.a0 a0Var, boolean z) {
        int i = cVar.b;
        int i2 = cVar.f;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.f = i2 + i;
            }
            z2(vVar, cVar);
        }
        int i3 = cVar.b + cVar.g;
        b bVar = this.f4298a;
        while (true) {
            if ((!cVar.f4312c && i3 <= 0) || !cVar.c(a0Var)) {
                break;
            }
            bVar.a();
            w2(vVar, a0Var, cVar, bVar);
            if (!bVar.f4308a) {
                cVar.f8220a += bVar.f8219a * cVar.e;
                if (!bVar.b || cVar.f4309a != null || !a0Var.e()) {
                    int i4 = cVar.b;
                    int i5 = bVar.f8219a;
                    cVar.b = i4 - i5;
                    i3 -= i5;
                }
                int i6 = cVar.f;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + bVar.f8219a;
                    cVar.f = i7;
                    int i8 = cVar.b;
                    if (i8 < 0) {
                        cVar.f = i7 + i8;
                    }
                    z2(vVar, cVar);
                }
                if (z && bVar.c) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.b;
    }

    public final View Z1() {
        return h2(0, T());
    }

    public final View a2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return l2(vVar, a0Var, 0, T(), a0Var.b());
    }

    public View b2(boolean z, boolean z2) {
        int iT;
        int iT2;
        if (this.f4304i) {
            iT = 0;
            iT2 = T();
        } else {
            iT = T() - 1;
            iT2 = -1;
        }
        return i2(iT, iT2, z, z2);
    }

    public View c2(boolean z, boolean z2) {
        int iT;
        int iT2;
        if (this.f4304i) {
            iT = T() - 1;
            iT2 = -1;
        } else {
            iT = 0;
            iT2 = T();
        }
        return i2(iT, iT2, z, z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int iO2;
        int i5;
        View viewM;
        int iG;
        int i6;
        int i7 = -1;
        if (!(this.f4300a == null && this.g == -1) && a0Var.b() == 0) {
            q1(vVar);
            return;
        }
        d dVar = this.f4300a;
        if (dVar != null && dVar.q()) {
            this.g = this.f4300a.f8221a;
        }
        X1();
        this.f4299a.f4310a = false;
        E2();
        View viewF0 = f0();
        if (!this.f4297a.f4307b || this.g != -1 || this.f4300a != null) {
            this.f4297a.e();
            a aVar = this.f4297a;
            aVar.f4306a = this.f4304i ^ this.j;
            N2(vVar, a0Var, aVar);
            this.f4297a.f4307b = true;
        } else if (viewF0 != null && (this.f8217a.g(viewF0) >= this.f8217a.i() || this.f8217a.d(viewF0) <= this.f8217a.m())) {
            this.f4297a.c(viewF0, m0(viewF0));
        }
        c cVar = this.f4299a;
        cVar.e = cVar.i >= 0 ? 1 : -1;
        int[] iArr = this.f4301a;
        iArr[0] = 0;
        iArr[1] = 0;
        Q1(a0Var, iArr);
        int iMax = Math.max(0, this.f4301a[0]) + this.f8217a.m();
        int iMax2 = Math.max(0, this.f4301a[1]) + this.f8217a.j();
        if (a0Var.e() && (i5 = this.g) != -1 && this.h != Integer.MIN_VALUE && (viewM = M(i5)) != null) {
            if (this.f4304i) {
                i6 = this.f8217a.i() - this.f8217a.d(viewM);
                iG = this.h;
            } else {
                iG = this.f8217a.g(viewM) - this.f8217a.m();
                i6 = this.h;
            }
            int i8 = i6 - iG;
            if (i8 > 0) {
                iMax += i8;
            } else {
                iMax2 -= i8;
            }
        }
        if (!this.f4297a.f4306a ? !this.f4304i : this.f4304i) {
            i7 = 1;
        }
        y2(vVar, a0Var, this.f4297a, i7);
        G(vVar);
        this.f4299a.f4312c = D2();
        this.f4299a.f4311b = a0Var.e();
        this.f4299a.h = 0;
        a aVar2 = this.f4297a;
        if (aVar2.f4306a) {
            S2(aVar2);
            c cVar2 = this.f4299a;
            cVar2.g = iMax;
            Y1(vVar, cVar2, a0Var, false);
            c cVar3 = this.f4299a;
            i2 = cVar3.f8220a;
            int i9 = cVar3.c;
            int i10 = cVar3.b;
            if (i10 > 0) {
                iMax2 += i10;
            }
            Q2(this.f4297a);
            c cVar4 = this.f4299a;
            cVar4.g = iMax2;
            cVar4.c += cVar4.d;
            Y1(vVar, cVar4, a0Var, false);
            c cVar5 = this.f4299a;
            i = cVar5.f8220a;
            int i11 = cVar5.b;
            if (i11 > 0) {
                R2(i9, i2);
                c cVar6 = this.f4299a;
                cVar6.g = i11;
                Y1(vVar, cVar6, a0Var, false);
                i2 = this.f4299a.f8220a;
            }
        } else {
            Q2(aVar2);
            c cVar7 = this.f4299a;
            cVar7.g = iMax2;
            Y1(vVar, cVar7, a0Var, false);
            c cVar8 = this.f4299a;
            i = cVar8.f8220a;
            int i12 = cVar8.c;
            int i13 = cVar8.b;
            if (i13 > 0) {
                iMax += i13;
            }
            S2(this.f4297a);
            c cVar9 = this.f4299a;
            cVar9.g = iMax;
            cVar9.c += cVar9.d;
            Y1(vVar, cVar9, a0Var, false);
            c cVar10 = this.f4299a;
            i2 = cVar10.f8220a;
            int i14 = cVar10.b;
            if (i14 > 0) {
                P2(i12, i);
                c cVar11 = this.f4299a;
                cVar11.g = i14;
                Y1(vVar, cVar11, a0Var, false);
                i = this.f4299a.f8220a;
            }
        }
        if (T() > 0) {
            if (this.f4304i ^ this.j) {
                int iO22 = o2(i, vVar, a0Var, true);
                i3 = i2 + iO22;
                i4 = i + iO22;
                iO2 = p2(i3, vVar, a0Var, false);
            } else {
                int iP2 = p2(i2, vVar, a0Var, true);
                i3 = i2 + iP2;
                i4 = i + iP2;
                iO2 = o2(i4, vVar, a0Var, false);
            }
            i2 = i3 + iO2;
            i = i4 + iO2;
        }
        x2(vVar, a0Var, i2, i);
        if (a0Var.e()) {
            this.f4297a.e();
        } else {
            this.f8217a.s();
        }
        this.f4302g = this.j;
    }

    public int d2() {
        View viewI2 = i2(0, T(), false, true);
        if (viewI2 == null) {
            return -1;
        }
        return m0(viewI2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void e1(RecyclerView.a0 a0Var) {
        super.e1(a0Var);
        this.f4300a = null;
        this.g = -1;
        this.h = Integer.MIN_VALUE;
        this.f4297a.e();
    }

    public final View e2() {
        return h2(T() - 1, -1);
    }

    public final View f2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return l2(vVar, a0Var, T() - 1, -1, a0Var.b());
    }

    @Override // a.np.a
    public void g(View view, View view2, int i, int i2) {
        int iG;
        q("Cannot drop a view during a scroll or layout calculation");
        X1();
        E2();
        int iM0 = m0(view);
        int iM02 = m0(view2);
        byte b2 = iM0 < iM02 ? (byte) 1 : (byte) -1;
        if (this.f4304i) {
            if (b2 == 1) {
                G2(iM02, this.f8217a.i() - (this.f8217a.g(view2) + this.f8217a.e(view)));
                return;
            }
            iG = this.f8217a.i() - this.f8217a.d(view2);
        } else {
            if (b2 != -1) {
                G2(iM02, this.f8217a.d(view2) - this.f8217a.e(view));
                return;
            }
            iG = this.f8217a.g(view2);
        }
        G2(iM02, iG);
    }

    public int g2() {
        View viewI2 = i2(T() - 1, -1, false, true);
        if (viewI2 == null) {
            return -1;
        }
        return m0(viewI2);
    }

    public View h2(int i, int i2) {
        int i3;
        int i4;
        X1();
        if ((i2 > i ? (byte) 1 : i2 < i ? (byte) -1 : (byte) 0) == 0) {
            return S(i);
        }
        if (this.f8217a.g(S(i)) < this.f8217a.m()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return (this.f == 0 ? ((RecyclerView.o) this).f4401a : ((RecyclerView.o) this).f4405b).a(i, i2, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i1(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.f4300a = (d) parcelable;
            z1();
        }
    }

    public View i2(int i, int i2, boolean z, boolean z2) {
        X1();
        return (this.f == 0 ? ((RecyclerView.o) this).f4401a : ((RecyclerView.o) this).f4405b).a(i, i2, z ? 24579 : 320, z2 ? 320 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable j1() {
        if (this.f4300a != null) {
            return new d(this.f4300a);
        }
        d dVar = new d();
        if (T() > 0) {
            X1();
            boolean z = this.f4302g ^ this.f4304i;
            dVar.f4313b = z;
            if (z) {
                View viewQ2 = q2();
                dVar.b = this.f8217a.i() - this.f8217a.d(viewQ2);
                dVar.f8221a = m0(viewQ2);
            } else {
                View viewR2 = r2();
                dVar.f8221a = m0(viewR2);
                dVar.b = this.f8217a.g(viewR2) - this.f8217a.m();
            }
        } else {
            dVar.r();
        }
        return dVar;
    }

    public final View j2() {
        return this.f4304i ? Z1() : e2();
    }

    public final View k2() {
        return this.f4304i ? e2() : Z1();
    }

    public View l2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i, int i2, int i3) {
        X1();
        int iM = this.f8217a.m();
        int i4 = this.f8217a.i();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewS = S(i);
            int iM0 = m0(viewS);
            if (iM0 >= 0 && iM0 < i3) {
                if (((RecyclerView.p) viewS.getLayoutParams()).s()) {
                    if (view2 == null) {
                        view2 = viewS;
                    }
                } else {
                    if (this.f8217a.g(viewS) < i4 && this.f8217a.d(viewS) >= iM) {
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

    public final View m2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f4304i ? a2(vVar, a0Var) : f2(vVar, a0Var);
    }

    public final View n2(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f4304i ? f2(vVar, a0Var) : a2(vVar, a0Var);
    }

    public final int o2(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int i2;
        int i3 = this.f8217a.i() - i;
        if (i3 <= 0) {
            return 0;
        }
        int i4 = -F2(-i3, vVar, a0Var);
        int i5 = i + i4;
        if (!z || (i2 = this.f8217a.i() - i5) <= 0) {
            return i4;
        }
        this.f8217a.r(i2);
        return i2 + i4;
    }

    public final int p2(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int iM;
        int iM2 = i - this.f8217a.m();
        if (iM2 <= 0) {
            return 0;
        }
        int i2 = -F2(iM2, vVar, a0Var);
        int i3 = i + i2;
        if (!z || (iM = i3 - this.f8217a.m()) <= 0) {
            return i2;
        }
        this.f8217a.r(-iM);
        return i2 - iM;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void q(String str) {
        if (this.f4300a == null) {
            super.q(str);
        }
    }

    public final View q2() {
        return S(this.f4304i ? 0 : T() - 1);
    }

    public final View r2() {
        return S(this.f4304i ? T() - 1 : 0);
    }

    @Deprecated
    public int s2(RecyclerView.a0 a0Var) {
        if (a0Var.d()) {
            return this.f8217a.n();
        }
        return 0;
    }

    public int t2() {
        return this.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean u() {
        return this.f == 0;
    }

    public boolean u2() {
        return i0() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean v() {
        return this.f == 1;
    }

    public boolean v2() {
        return this.k;
    }

    public void w2(RecyclerView.v vVar, RecyclerView.a0 a0Var, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int paddingLeft;
        int iF;
        View viewD = cVar.d(vVar);
        if (viewD == null) {
            bVar.f4308a = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) viewD.getLayoutParams();
        if (cVar.f4309a == null) {
            if (this.f4304i == (cVar.e == -1)) {
                n(viewD);
            } else {
                o(viewD, 0);
            }
        } else {
            if (this.f4304i == (cVar.e == -1)) {
                l(viewD);
            } else {
                m(viewD, 0);
            }
        }
        G0(viewD, 0, 0);
        bVar.f8219a = this.f8217a.e(viewD);
        if (this.f == 1) {
            if (u2()) {
                iF = t0() - getPaddingRight();
                paddingLeft = iF - this.f8217a.f(viewD);
            } else {
                paddingLeft = getPaddingLeft();
                iF = this.f8217a.f(viewD) + paddingLeft;
            }
            int i4 = cVar.e;
            int i5 = cVar.f8220a;
            if (i4 == -1) {
                i3 = i5;
                i2 = iF;
                i = i5 - bVar.f8219a;
            } else {
                i = i5;
                i2 = iF;
                i3 = bVar.f8219a + i5;
            }
        } else {
            int paddingTop = getPaddingTop();
            int iF2 = this.f8217a.f(viewD) + paddingTop;
            int i6 = cVar.e;
            int i7 = cVar.f8220a;
            if (i6 == -1) {
                i2 = i7;
                i = paddingTop;
                i3 = iF2;
                paddingLeft = i7 - bVar.f8219a;
            } else {
                i = paddingTop;
                i2 = bVar.f8219a + i7;
                i3 = iF2;
                paddingLeft = i7;
            }
        }
        F0(viewD, paddingLeft, i, i2, i3);
        if (pVar.s() || pVar.r()) {
            bVar.b = true;
        }
        bVar.c = viewD.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean x0() {
        return true;
    }

    public final void x2(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i, int i2) {
        if (!a0Var.g() || T() == 0 || a0Var.e() || !P1()) {
            return;
        }
        List<RecyclerView.d0> listK = vVar.k();
        int size = listK.size();
        int iM0 = m0(S(0));
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.d0 d0Var = listK.get(i5);
            if (!d0Var.v()) {
                byte b2 = (d0Var.m() < iM0) != this.f4304i ? (byte) -1 : (byte) 1;
                int iE = this.f8217a.e(d0Var.f4387a);
                if (b2 == -1) {
                    i3 += iE;
                } else {
                    i4 += iE;
                }
            }
        }
        this.f4299a.f4309a = listK;
        if (i3 > 0) {
            R2(m0(r2()), i);
            c cVar = this.f4299a;
            cVar.g = i3;
            cVar.b = 0;
            cVar.a();
            Y1(vVar, this.f4299a, a0Var, false);
        }
        if (i4 > 0) {
            P2(m0(q2()), i2);
            c cVar2 = this.f4299a;
            cVar2.g = i4;
            cVar2.b = 0;
            cVar2.a();
            Y1(vVar, this.f4299a, a0Var, false);
        }
        this.f4299a.f4309a = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void y(int i, int i2, RecyclerView.a0 a0Var, RecyclerView.o.a aVar) {
        if (this.f != 0) {
            i = i2;
        }
        if (T() == 0 || i == 0) {
            return;
        }
        X1();
        O2(i > 0 ? 1 : -1, Math.abs(i), true, a0Var);
        R1(a0Var, this.f4299a, aVar);
    }

    public void y2(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void z(int i, RecyclerView.o.a aVar) {
        boolean z;
        int i2;
        d dVar = this.f4300a;
        if (dVar == null || !dVar.q()) {
            E2();
            z = this.f4304i;
            i2 = this.g;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            d dVar2 = this.f4300a;
            z = dVar2.f4313b;
            i2 = dVar2.f8221a;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.i && i2 >= 0 && i2 < i; i4++) {
            aVar.a(i2, 0);
            i2 += i3;
        }
    }

    public final void z2(RecyclerView.v vVar, c cVar) {
        if (!cVar.f4310a || cVar.f4312c) {
            return;
        }
        int i = cVar.f;
        int i2 = cVar.h;
        if (cVar.e == -1) {
            B2(vVar, i, i2);
        } else {
            C2(vVar, i, i2);
        }
    }
}
