package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.m;
import com.umeng.socialize.common.SocializeConstants;
import g.n0;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LinearLayoutManager extends RecyclerView.o implements m.j, RecyclerView.a0.b {
    public static final String C1 = "LinearLayoutManager";
    public static final int C2 = 1;
    public static final float E7 = 0.33333334f;
    public static final boolean K1 = false;
    public static final int K2 = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final int f6541v2 = 0;
    public int A;
    public int B;
    public boolean C;
    public SavedState D;
    public final b K0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final a f6542k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public int f6543k1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6544s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public c f6545t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public w f6546u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f6547v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public int[] f6548v1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f6549w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f6550x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f6551y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f6552z;

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6555c;

        public static class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState() {
        }

        public boolean a() {
            return this.f6553a >= 0;
        }

        public void b() {
            this.f6553a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f6553a);
            parcel.writeInt(this.f6554b);
            parcel.writeInt(this.f6555c ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.f6553a = parcel.readInt();
            this.f6554b = parcel.readInt();
            this.f6555c = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f6553a = savedState.f6553a;
            this.f6554b = savedState.f6554b;
            this.f6555c = savedState.f6555c;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public w f6556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6558c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f6559d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f6560e;

        public a() {
            e();
        }

        public void a() {
            this.f6558c = this.f6559d ? this.f6556a.i() : this.f6556a.n();
        }

        public void b(View view, int i10) {
            if (this.f6559d) {
                this.f6558c = this.f6556a.d(view) + this.f6556a.p();
            } else {
                this.f6558c = this.f6556a.g(view);
            }
            this.f6557b = i10;
        }

        public void c(View view, int i10) {
            int iP = this.f6556a.p();
            if (iP >= 0) {
                b(view, i10);
                return;
            }
            this.f6557b = i10;
            if (this.f6559d) {
                int i11 = (this.f6556a.i() - iP) - this.f6556a.d(view);
                this.f6558c = this.f6556a.i() - i11;
                if (i11 > 0) {
                    int iE = this.f6558c - this.f6556a.e(view);
                    int iN = this.f6556a.n();
                    int iMin = iE - (iN + Math.min(this.f6556a.g(view) - iN, 0));
                    if (iMin < 0) {
                        this.f6558c += Math.min(i11, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iG = this.f6556a.g(view);
            int iN2 = iG - this.f6556a.n();
            this.f6558c = iG;
            if (iN2 > 0) {
                int i12 = (this.f6556a.i() - Math.min(0, (this.f6556a.i() - iP) - this.f6556a.d(view))) - (iG + this.f6556a.e(view));
                if (i12 < 0) {
                    this.f6558c -= Math.min(iN2, -i12);
                }
            }
        }

        public boolean d(View view, RecyclerView.b0 b0Var) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.j() && pVar.b() >= 0 && pVar.b() < b0Var.d();
        }

        public void e() {
            this.f6557b = -1;
            this.f6558c = Integer.MIN_VALUE;
            this.f6559d = false;
            this.f6560e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f6557b + ", mCoordinate=" + this.f6558c + ", mLayoutFromEnd=" + this.f6559d + ", mValid=" + this.f6560e + '}';
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f6562b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6563c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f6564d;

        public void a() {
            this.f6561a = 0;
            this.f6562b = false;
            this.f6563c = false;
            this.f6564d = false;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String f6565n = "LLM#LayoutState";

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f6566o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f6567p = 1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f6568q = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f6569r = -1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f6570s = 1;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f6571t = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6575d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6576e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f6577f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f6578g;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f6582k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f6584m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6572a = true;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f6579h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f6580i = 0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f6581j = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List<RecyclerView.e0> f6583l = null;

        public void a() {
            b(null);
        }

        public void b(View view) {
            View viewG = g(view);
            if (viewG == null) {
                this.f6575d = -1;
            } else {
                this.f6575d = ((RecyclerView.p) viewG.getLayoutParams()).b();
            }
        }

        public boolean c(RecyclerView.b0 b0Var) {
            int i10 = this.f6575d;
            return i10 >= 0 && i10 < b0Var.d();
        }

        public void d() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("avail:");
            sb2.append(this.f6574c);
            sb2.append(", ind:");
            sb2.append(this.f6575d);
            sb2.append(", dir:");
            sb2.append(this.f6576e);
            sb2.append(", offset:");
            sb2.append(this.f6573b);
            sb2.append(", layoutDir:");
            sb2.append(this.f6577f);
        }

        public View e(RecyclerView.w wVar) {
            if (this.f6583l != null) {
                return f();
            }
            View viewP = wVar.p(this.f6575d);
            this.f6575d += this.f6576e;
            return viewP;
        }

        public final View f() {
            int size = this.f6583l.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = this.f6583l.get(i10).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.j() && this.f6575d == pVar.b()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public View g(View view) {
            int iB;
            int size = this.f6583l.size();
            View view2 = null;
            int i10 = Integer.MAX_VALUE;
            for (int i11 = 0; i11 < size; i11++) {
                View view3 = this.f6583l.get(i11).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.j() && (iB = (pVar.b() - this.f6575d) * this.f6576e) >= 0 && iB < i10) {
                    view2 = view3;
                    if (iB == 0) {
                        break;
                    }
                    i10 = iB;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void A(int i10, RecyclerView.o.c cVar) {
        boolean z10;
        int i11;
        SavedState savedState = this.D;
        if (savedState == null || !savedState.a()) {
            f3();
            z10 = this.f6550x;
            i11 = this.A;
            if (i11 == -1) {
                i11 = z10 ? i10 - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.D;
            z10 = savedState2.f6555c;
            i11 = savedState2.f6553a;
        }
        int i12 = z10 ? -1 : 1;
        for (int i13 = 0; i13 < this.f6543k1 && i11 >= 0 && i11 < i10; i13++) {
            cVar.a(i11, 0);
            i11 += i12;
        }
    }

    public final View A2() {
        return D2(Y() - 1, -1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int B(RecyclerView.b0 b0Var) {
        return m2(b0Var);
    }

    public final View B2(RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        return H2(wVar, b0Var, Y() - 1, -1, b0Var.d());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int C(RecyclerView.b0 b0Var) {
        return n2(b0Var);
    }

    public int C2() {
        View viewE2 = E2(Y() - 1, -1, false, true);
        if (viewE2 == null) {
            return -1;
        }
        return u0(viewE2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int D(RecyclerView.b0 b0Var) {
        return o2(b0Var);
    }

    public View D2(int i10, int i11) {
        int i12;
        int i13;
        r2();
        if ((i11 > i10 ? (byte) 1 : i11 < i10 ? (byte) -1 : (byte) 0) == 0) {
            return X(i10);
        }
        if (this.f6546u.g(X(i10)) < this.f6546u.n()) {
            i12 = 16644;
            i13 = 16388;
        } else {
            i12 = 4161;
            i13 = 4097;
        }
        return this.f6544s == 0 ? this.f6715e.a(i10, i11, i12, i13) : this.f6716f.a(i10, i11, i12, i13);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int E(RecyclerView.b0 b0Var) {
        return m2(b0Var);
    }

    public View E2(int i10, int i11, boolean z10, boolean z11) {
        r2();
        int i12 = MediaSessionCompat.M;
        int i13 = z10 ? SocializeConstants.AUTH_EVENT : MediaSessionCompat.M;
        if (!z11) {
            i12 = 0;
        }
        return this.f6544s == 0 ? this.f6715e.a(i10, i11, i13, i12) : this.f6716f.a(i10, i11, i13, i12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int F(RecyclerView.b0 b0Var) {
        return n2(b0Var);
    }

    public final View F2() {
        return this.f6550x ? u2() : A2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int G(RecyclerView.b0 b0Var) {
        return o2(b0Var);
    }

    public final View G2() {
        return this.f6550x ? A2() : u2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean H0() {
        return true;
    }

    public View H2(RecyclerView.w wVar, RecyclerView.b0 b0Var, int i10, int i11, int i12) {
        r2();
        int iN = this.f6546u.n();
        int i13 = this.f6546u.i();
        int i14 = i11 > i10 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i10 != i11) {
            View viewX = X(i10);
            int iU0 = u0(viewX);
            if (iU0 >= 0 && iU0 < i12) {
                if (((RecyclerView.p) viewX.getLayoutParams()).j()) {
                    if (view2 == null) {
                        view2 = viewX;
                    }
                } else {
                    if (this.f6546u.g(viewX) < i13 && this.f6546u.d(viewX) >= iN) {
                        return viewX;
                    }
                    if (view == null) {
                        view = viewX;
                    }
                }
            }
            i10 += i14;
        }
        return view != null ? view : view2;
    }

    public final View I2(RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        return this.f6550x ? v2(wVar, b0Var) : B2(wVar, b0Var);
    }

    public final View J2(RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        return this.f6550x ? B2(wVar, b0Var) : v2(wVar, b0Var);
    }

    public final int K2(int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var, boolean z10) {
        int i11;
        int i12 = this.f6546u.i() - i10;
        if (i12 <= 0) {
            return 0;
        }
        int i13 = -g3(-i12, wVar, b0Var);
        int i14 = i10 + i13;
        if (!z10 || (i11 = this.f6546u.i() - i14) <= 0) {
            return i13;
        }
        this.f6546u.t(i11);
        return i11 + i13;
    }

    public final int L2(int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var, boolean z10) {
        int iN;
        int iN2 = i10 - this.f6546u.n();
        if (iN2 <= 0) {
            return 0;
        }
        int i11 = -g3(iN2, wVar, b0Var);
        int i12 = i10 + i11;
        if (!z10 || (iN = i12 - this.f6546u.n()) <= 0) {
            return i11;
        }
        this.f6546u.t(-iN);
        return i11 - iN;
    }

    public final View M2() {
        return X(this.f6550x ? 0 : Y() - 1);
    }

    public final View N2() {
        return X(this.f6550x ? Y() - 1 : 0);
    }

    @Deprecated
    public int O2(RecyclerView.b0 b0Var) {
        if (b0Var.h()) {
            return this.f6546u.o();
        }
        return 0;
    }

    public int P2() {
        return this.f6543k1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int Q1(int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        if (this.f6544s == 1) {
            return 0;
        }
        return g3(i10, wVar, b0Var);
    }

    public int Q2() {
        return this.f6544s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View R(int i10) {
        int iY = Y();
        if (iY == 0) {
            return null;
        }
        int iU0 = i10 - u0(X(0));
        if (iU0 >= 0 && iU0 < iY) {
            View viewX = X(iU0);
            if (u0(viewX) == i10) {
                return viewX;
            }
        }
        return super.R(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R1(int i10) {
        this.A = i10;
        this.B = Integer.MIN_VALUE;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.b();
        }
        N1();
    }

    public boolean R2() {
        return this.C;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p S() {
        return new RecyclerView.p(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int S1(int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        if (this.f6544s == 0) {
            return 0;
        }
        return g3(i10, wVar, b0Var);
    }

    public boolean S2() {
        return this.f6549w;
    }

    public boolean T2() {
        return this.f6551y;
    }

    public boolean U2() {
        return q0() == 1;
    }

    public boolean V2() {
        return this.f6552z;
    }

    public void W2(RecyclerView.w wVar, RecyclerView.b0 b0Var, c cVar, b bVar) {
        int i10;
        int i11;
        int i12;
        int paddingLeft;
        int iF;
        View viewE = cVar.e(wVar);
        if (viewE == null) {
            bVar.f6562b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) viewE.getLayoutParams();
        if (cVar.f6583l == null) {
            if (this.f6550x == (cVar.f6577f == -1)) {
                addView(viewE);
            } else {
                addView(viewE, 0);
            }
        } else {
            if (this.f6550x == (cVar.f6577f == -1)) {
                m(viewE);
            } else {
                n(viewE, 0);
            }
        }
        T0(viewE, 0, 0);
        bVar.f6561a = this.f6546u.e(viewE);
        if (this.f6544s == 1) {
            if (U2()) {
                iF = B0() - getPaddingRight();
                paddingLeft = iF - this.f6546u.f(viewE);
            } else {
                paddingLeft = getPaddingLeft();
                iF = this.f6546u.f(viewE) + paddingLeft;
            }
            if (cVar.f6577f == -1) {
                int i13 = cVar.f6573b;
                i12 = i13;
                i11 = iF;
                i10 = i13 - bVar.f6561a;
            } else {
                int i14 = cVar.f6573b;
                i10 = i14;
                i11 = iF;
                i12 = bVar.f6561a + i14;
            }
        } else {
            int paddingTop = getPaddingTop();
            int iF2 = this.f6546u.f(viewE) + paddingTop;
            if (cVar.f6577f == -1) {
                int i15 = cVar.f6573b;
                i11 = i15;
                i10 = paddingTop;
                i12 = iF2;
                paddingLeft = i15 - bVar.f6561a;
            } else {
                int i16 = cVar.f6573b;
                i10 = paddingTop;
                i11 = bVar.f6561a + i16;
                i12 = iF2;
                paddingLeft = i16;
            }
        }
        R0(viewE, paddingLeft, i10, i11, i12);
        if (pVar.j() || pVar.g()) {
            bVar.f6563c = true;
        }
        bVar.f6564d = viewE.hasFocusable();
    }

    public final void X2(RecyclerView.w wVar, RecyclerView.b0 b0Var, int i10, int i11) {
        if (!b0Var.n() || Y() == 0 || b0Var.j() || !j2()) {
            return;
        }
        List<RecyclerView.e0> listL = wVar.l();
        int size = listL.size();
        int iU0 = u0(X(0));
        int iE = 0;
        int iE2 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            RecyclerView.e0 e0Var = listL.get(i12);
            if (!e0Var.isRemoved()) {
                if (((e0Var.getLayoutPosition() < iU0) != this.f6550x ? (byte) -1 : (byte) 1) == -1) {
                    iE += this.f6546u.e(e0Var.itemView);
                } else {
                    iE2 += this.f6546u.e(e0Var.itemView);
                }
            }
        }
        this.f6545t.f6583l = listL;
        if (iE > 0) {
            u3(u0(N2()), i10);
            c cVar = this.f6545t;
            cVar.f6579h = iE;
            cVar.f6574c = 0;
            cVar.a();
            s2(wVar, this.f6545t, b0Var, false);
        }
        if (iE2 > 0) {
            s3(u0(M2()), i11);
            c cVar2 = this.f6545t;
            cVar2.f6579h = iE2;
            cVar2.f6574c = 0;
            cVar2.a();
            s2(wVar, this.f6545t, b0Var, false);
        }
        this.f6545t.f6583l = null;
    }

    public final void Y2() {
        for (int i10 = 0; i10 < Y(); i10++) {
            View viewX = X(i10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("item ");
            sb2.append(u0(viewX));
            sb2.append(", coord:");
            sb2.append(this.f6546u.g(viewX));
        }
    }

    public void Z2(RecyclerView.w wVar, RecyclerView.b0 b0Var, a aVar, int i10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a0.b
    public PointF a(int i10) {
        if (Y() == 0) {
            return null;
        }
        int i11 = (i10 < u0(X(0))) != this.f6550x ? -1 : 1;
        return this.f6544s == 0 ? new PointF(i11, 0.0f) : new PointF(0.0f, i11);
    }

    public final void a3(RecyclerView.w wVar, c cVar) {
        if (!cVar.f6572a || cVar.f6584m) {
            return;
        }
        int i10 = cVar.f6578g;
        int i11 = cVar.f6580i;
        if (cVar.f6577f == -1) {
            c3(wVar, i10, i11);
        } else {
            d3(wVar, i10, i11);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b1(RecyclerView recyclerView, RecyclerView.w wVar) {
        super.b1(recyclerView, wVar);
        if (this.C) {
            E1(wVar);
            wVar.d();
        }
    }

    public final void b3(RecyclerView.w wVar, int i10, int i11) {
        if (i10 == i11) {
            return;
        }
        if (i11 <= i10) {
            while (i10 > i11) {
                H1(i10, wVar);
                i10--;
            }
        } else {
            for (int i12 = i11 - 1; i12 >= i10; i12--) {
                H1(i12, wVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View c1(View view, int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        int iP2;
        f3();
        if (Y() == 0 || (iP2 = p2(i10)) == Integer.MIN_VALUE) {
            return null;
        }
        r2();
        r3(iP2, (int) (this.f6546u.o() * 0.33333334f), false, b0Var);
        c cVar = this.f6545t;
        cVar.f6578g = Integer.MIN_VALUE;
        cVar.f6572a = false;
        s2(wVar, cVar, b0Var, true);
        View viewG2 = iP2 == -1 ? G2() : F2();
        View viewN2 = iP2 == -1 ? N2() : M2();
        if (!viewN2.hasFocusable()) {
            return viewG2;
        }
        if (viewG2 == null) {
            return null;
        }
        return viewN2;
    }

    public final void c3(RecyclerView.w wVar, int i10, int i11) {
        int iY = Y();
        if (i10 < 0) {
            return;
        }
        int iH = (this.f6546u.h() - i10) + i11;
        if (this.f6550x) {
            for (int i12 = 0; i12 < iY; i12++) {
                View viewX = X(i12);
                if (this.f6546u.g(viewX) < iH || this.f6546u.r(viewX) < iH) {
                    b3(wVar, 0, i12);
                    return;
                }
            }
            return;
        }
        int i13 = iY - 1;
        for (int i14 = i13; i14 >= 0; i14--) {
            View viewX2 = X(i14);
            if (this.f6546u.g(viewX2) < iH || this.f6546u.r(viewX2) < iH) {
                b3(wVar, i13, i14);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d1(AccessibilityEvent accessibilityEvent) {
        super.d1(accessibilityEvent);
        if (Y() > 0) {
            accessibilityEvent.setFromIndex(y2());
            accessibilityEvent.setToIndex(C2());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean d2() {
        return (n0() == 1073741824 || C0() == 1073741824 || !D0()) ? false : true;
    }

    public final void d3(RecyclerView.w wVar, int i10, int i11) {
        if (i10 < 0) {
            return;
        }
        int i12 = i10 - i11;
        int iY = Y();
        if (!this.f6550x) {
            for (int i13 = 0; i13 < iY; i13++) {
                View viewX = X(i13);
                if (this.f6546u.d(viewX) > i12 || this.f6546u.q(viewX) > i12) {
                    b3(wVar, 0, i13);
                    return;
                }
            }
            return;
        }
        int i14 = iY - 1;
        for (int i15 = i14; i15 >= 0; i15--) {
            View viewX2 = X(i15);
            if (this.f6546u.d(viewX2) > i12 || this.f6546u.q(viewX2) > i12) {
                b3(wVar, i14, i15);
                return;
            }
        }
    }

    public boolean e3() {
        return this.f6546u.l() == 0 && this.f6546u.h() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void f2(RecyclerView recyclerView, RecyclerView.b0 b0Var, int i10) {
        q qVar = new q(recyclerView.getContext());
        qVar.q(i10);
        g2(qVar);
    }

    public final void f3() {
        if (this.f6544s == 1 || !U2()) {
            this.f6550x = this.f6549w;
        } else {
            this.f6550x = !this.f6549w;
        }
    }

    @Override // androidx.recyclerview.widget.m.j
    public void g(@n0 View view, @n0 View view2, int i10, int i11) {
        q("Cannot drop a view during a scroll or layout calculation");
        r2();
        f3();
        int iU0 = u0(view);
        int iU02 = u0(view2);
        byte b10 = iU0 < iU02 ? (byte) 1 : (byte) -1;
        if (this.f6550x) {
            if (b10 == 1) {
                h3(iU02, this.f6546u.i() - (this.f6546u.g(view2) + this.f6546u.e(view)));
                return;
            } else {
                h3(iU02, this.f6546u.i() - this.f6546u.d(view2));
                return;
            }
        }
        if (b10 == -1) {
            h3(iU02, this.f6546u.g(view2));
        } else {
            h3(iU02, this.f6546u.d(view2) - this.f6546u.e(view));
        }
    }

    public int g3(int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        if (Y() == 0 || i10 == 0) {
            return 0;
        }
        r2();
        this.f6545t.f6572a = true;
        int i11 = i10 > 0 ? 1 : -1;
        int iAbs = Math.abs(i10);
        r3(i11, iAbs, true, b0Var);
        c cVar = this.f6545t;
        int iS2 = cVar.f6578g + s2(wVar, cVar, b0Var, false);
        if (iS2 < 0) {
            return 0;
        }
        if (iAbs > iS2) {
            i10 = i11 * iS2;
        }
        this.f6546u.t(-i10);
        this.f6545t.f6582k = i10;
        return i10;
    }

    public void h3(int i10, int i11) {
        this.A = i10;
        this.B = i11;
        SavedState savedState = this.D;
        if (savedState != null) {
            savedState.b();
        }
        N1();
    }

    public void i3(int i10) {
        this.f6543k1 = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean j2() {
        return this.D == null && this.f6547v == this.f6551y;
    }

    public void j3(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i10);
        }
        q(null);
        if (i10 != this.f6544s || this.f6546u == null) {
            w wVarB = w.b(this, i10);
            this.f6546u = wVarB;
            this.f6542k0.f6556a = wVarB;
            this.f6544s = i10;
            N1();
        }
    }

    public void k2(@n0 RecyclerView.b0 b0Var, @n0 int[] iArr) {
        int i10;
        int iO2 = O2(b0Var);
        if (this.f6545t.f6577f == -1) {
            i10 = 0;
        } else {
            i10 = iO2;
            iO2 = 0;
        }
        iArr[0] = iO2;
        iArr[1] = i10;
    }

    public void k3(boolean z10) {
        this.C = z10;
    }

    public void l2(RecyclerView.b0 b0Var, c cVar, RecyclerView.o.c cVar2) {
        int i10 = cVar.f6575d;
        if (i10 < 0 || i10 >= b0Var.d()) {
            return;
        }
        cVar2.a(i10, Math.max(0, cVar.f6578g));
    }

    public void l3(boolean z10) {
        q(null);
        if (z10 == this.f6549w) {
            return;
        }
        this.f6549w = z10;
        N1();
    }

    public final int m2(RecyclerView.b0 b0Var) {
        if (Y() == 0) {
            return 0;
        }
        r2();
        return z.a(b0Var, this.f6546u, x2(!this.f6552z, true), w2(!this.f6552z, true), this, this.f6552z);
    }

    public void m3(boolean z10) {
        this.f6552z = z10;
    }

    public final int n2(RecyclerView.b0 b0Var) {
        if (Y() == 0) {
            return 0;
        }
        r2();
        return z.b(b0Var, this.f6546u, x2(!this.f6552z, true), w2(!this.f6552z, true), this, this.f6552z, this.f6550x);
    }

    public void n3(boolean z10) {
        q(null);
        if (this.f6551y == z10) {
            return;
        }
        this.f6551y = z10;
        N1();
    }

    public final int o2(RecyclerView.b0 b0Var) {
        if (Y() == 0) {
            return 0;
        }
        r2();
        return z.c(b0Var, this.f6546u, x2(!this.f6552z, true), w2(!this.f6552z, true), this, this.f6552z);
    }

    public final boolean o3(RecyclerView.w wVar, RecyclerView.b0 b0Var, a aVar) {
        if (Y() == 0) {
            return false;
        }
        View viewL0 = l0();
        if (viewL0 != null && aVar.d(viewL0, b0Var)) {
            aVar.c(viewL0, u0(viewL0));
            return true;
        }
        if (this.f6547v != this.f6551y) {
            return false;
        }
        View viewI2 = aVar.f6559d ? I2(wVar, b0Var) : J2(wVar, b0Var);
        if (viewI2 == null) {
            return false;
        }
        aVar.b(viewI2, u0(viewI2));
        if (!b0Var.j() && j2()) {
            if (this.f6546u.g(viewI2) >= this.f6546u.i() || this.f6546u.d(viewI2) < this.f6546u.n()) {
                aVar.f6558c = aVar.f6559d ? this.f6546u.i() : this.f6546u.n();
            }
        }
        return true;
    }

    public int p2(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 17 ? i10 != 33 ? i10 != 66 ? (i10 == 130 && this.f6544s == 1) ? 1 : Integer.MIN_VALUE : this.f6544s == 0 ? 1 : Integer.MIN_VALUE : this.f6544s == 1 ? -1 : Integer.MIN_VALUE : this.f6544s == 0 ? -1 : Integer.MIN_VALUE : (this.f6544s != 1 && U2()) ? -1 : 1 : (this.f6544s != 1 && U2()) ? 1 : -1;
    }

    public final boolean p3(RecyclerView.b0 b0Var, a aVar) {
        int i10;
        if (!b0Var.j() && (i10 = this.A) != -1) {
            if (i10 >= 0 && i10 < b0Var.d()) {
                aVar.f6557b = this.A;
                SavedState savedState = this.D;
                if (savedState != null && savedState.a()) {
                    boolean z10 = this.D.f6555c;
                    aVar.f6559d = z10;
                    if (z10) {
                        aVar.f6558c = this.f6546u.i() - this.D.f6554b;
                    } else {
                        aVar.f6558c = this.f6546u.n() + this.D.f6554b;
                    }
                    return true;
                }
                if (this.B != Integer.MIN_VALUE) {
                    boolean z11 = this.f6550x;
                    aVar.f6559d = z11;
                    if (z11) {
                        aVar.f6558c = this.f6546u.i() - this.B;
                    } else {
                        aVar.f6558c = this.f6546u.n() + this.B;
                    }
                    return true;
                }
                View viewR = R(this.A);
                if (viewR == null) {
                    if (Y() > 0) {
                        aVar.f6559d = (this.A < u0(X(0))) == this.f6550x;
                    }
                    aVar.a();
                } else {
                    if (this.f6546u.e(viewR) > this.f6546u.o()) {
                        aVar.a();
                        return true;
                    }
                    if (this.f6546u.g(viewR) - this.f6546u.n() < 0) {
                        aVar.f6558c = this.f6546u.n();
                        aVar.f6559d = false;
                        return true;
                    }
                    if (this.f6546u.i() - this.f6546u.d(viewR) < 0) {
                        aVar.f6558c = this.f6546u.i();
                        aVar.f6559d = true;
                        return true;
                    }
                    aVar.f6558c = aVar.f6559d ? this.f6546u.d(viewR) + this.f6546u.p() : this.f6546u.g(viewR);
                }
                return true;
            }
            this.A = -1;
            this.B = Integer.MIN_VALUE;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void q(String str) {
        if (this.D == null) {
            super.q(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void q1(RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        int i10;
        int i11;
        int i12;
        int i13;
        int iK2;
        int i14;
        View viewR;
        int iG;
        int i15;
        int i16 = -1;
        if (!(this.D == null && this.A == -1) && b0Var.d() == 0) {
            E1(wVar);
            return;
        }
        SavedState savedState = this.D;
        if (savedState != null && savedState.a()) {
            this.A = this.D.f6553a;
        }
        r2();
        this.f6545t.f6572a = false;
        f3();
        View viewL0 = l0();
        a aVar = this.f6542k0;
        if (!aVar.f6560e || this.A != -1 || this.D != null) {
            aVar.e();
            a aVar2 = this.f6542k0;
            aVar2.f6559d = this.f6550x ^ this.f6551y;
            q3(wVar, b0Var, aVar2);
            this.f6542k0.f6560e = true;
        } else if (viewL0 != null && (this.f6546u.g(viewL0) >= this.f6546u.i() || this.f6546u.d(viewL0) <= this.f6546u.n())) {
            this.f6542k0.c(viewL0, u0(viewL0));
        }
        c cVar = this.f6545t;
        cVar.f6577f = cVar.f6582k >= 0 ? 1 : -1;
        int[] iArr = this.f6548v1;
        iArr[0] = 0;
        iArr[1] = 0;
        k2(b0Var, iArr);
        int iMax = Math.max(0, this.f6548v1[0]) + this.f6546u.n();
        int iMax2 = Math.max(0, this.f6548v1[1]) + this.f6546u.j();
        if (b0Var.j() && (i14 = this.A) != -1 && this.B != Integer.MIN_VALUE && (viewR = R(i14)) != null) {
            if (this.f6550x) {
                i15 = this.f6546u.i() - this.f6546u.d(viewR);
                iG = this.B;
            } else {
                iG = this.f6546u.g(viewR) - this.f6546u.n();
                i15 = this.B;
            }
            int i17 = i15 - iG;
            if (i17 > 0) {
                iMax += i17;
            } else {
                iMax2 -= i17;
            }
        }
        a aVar3 = this.f6542k0;
        if (!aVar3.f6559d ? !this.f6550x : this.f6550x) {
            i16 = 1;
        }
        Z2(wVar, b0Var, aVar3, i16);
        H(wVar);
        this.f6545t.f6584m = e3();
        this.f6545t.f6581j = b0Var.j();
        this.f6545t.f6580i = 0;
        a aVar4 = this.f6542k0;
        if (aVar4.f6559d) {
            v3(aVar4);
            c cVar2 = this.f6545t;
            cVar2.f6579h = iMax;
            s2(wVar, cVar2, b0Var, false);
            c cVar3 = this.f6545t;
            i11 = cVar3.f6573b;
            int i18 = cVar3.f6575d;
            int i19 = cVar3.f6574c;
            if (i19 > 0) {
                iMax2 += i19;
            }
            t3(this.f6542k0);
            c cVar4 = this.f6545t;
            cVar4.f6579h = iMax2;
            cVar4.f6575d += cVar4.f6576e;
            s2(wVar, cVar4, b0Var, false);
            c cVar5 = this.f6545t;
            i10 = cVar5.f6573b;
            int i20 = cVar5.f6574c;
            if (i20 > 0) {
                u3(i18, i11);
                c cVar6 = this.f6545t;
                cVar6.f6579h = i20;
                s2(wVar, cVar6, b0Var, false);
                i11 = this.f6545t.f6573b;
            }
        } else {
            t3(aVar4);
            c cVar7 = this.f6545t;
            cVar7.f6579h = iMax2;
            s2(wVar, cVar7, b0Var, false);
            c cVar8 = this.f6545t;
            i10 = cVar8.f6573b;
            int i21 = cVar8.f6575d;
            int i22 = cVar8.f6574c;
            if (i22 > 0) {
                iMax += i22;
            }
            v3(this.f6542k0);
            c cVar9 = this.f6545t;
            cVar9.f6579h = iMax;
            cVar9.f6575d += cVar9.f6576e;
            s2(wVar, cVar9, b0Var, false);
            c cVar10 = this.f6545t;
            i11 = cVar10.f6573b;
            int i23 = cVar10.f6574c;
            if (i23 > 0) {
                s3(i21, i10);
                c cVar11 = this.f6545t;
                cVar11.f6579h = i23;
                s2(wVar, cVar11, b0Var, false);
                i10 = this.f6545t.f6573b;
            }
        }
        if (Y() > 0) {
            if (this.f6550x ^ this.f6551y) {
                int iK22 = K2(i10, wVar, b0Var, true);
                i12 = i11 + iK22;
                i13 = i10 + iK22;
                iK2 = L2(i12, wVar, b0Var, false);
            } else {
                int iL2 = L2(i11, wVar, b0Var, true);
                i12 = i11 + iL2;
                i13 = i10 + iL2;
                iK2 = K2(i13, wVar, b0Var, false);
            }
            i11 = i12 + iK2;
            i10 = i13 + iK2;
        }
        X2(wVar, b0Var, i11, i10);
        if (b0Var.j()) {
            this.f6542k0.e();
        } else {
            this.f6546u.u();
        }
        this.f6547v = this.f6551y;
    }

    public c q2() {
        return new c();
    }

    public final void q3(RecyclerView.w wVar, RecyclerView.b0 b0Var, a aVar) {
        if (p3(b0Var, aVar) || o3(wVar, b0Var, aVar)) {
            return;
        }
        aVar.a();
        aVar.f6557b = this.f6551y ? b0Var.d() - 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void r1(RecyclerView.b0 b0Var) {
        super.r1(b0Var);
        this.D = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.f6542k0.e();
    }

    void r2() {
        if (this.f6545t == null) {
            this.f6545t = q2();
        }
    }

    public final void r3(int i10, int i11, boolean z10, RecyclerView.b0 b0Var) {
        int iN;
        this.f6545t.f6584m = e3();
        this.f6545t.f6577f = i10;
        int[] iArr = this.f6548v1;
        iArr[0] = 0;
        iArr[1] = 0;
        k2(b0Var, iArr);
        int iMax = Math.max(0, this.f6548v1[0]);
        int iMax2 = Math.max(0, this.f6548v1[1]);
        boolean z11 = i10 == 1;
        c cVar = this.f6545t;
        int i12 = z11 ? iMax2 : iMax;
        cVar.f6579h = i12;
        if (!z11) {
            iMax = iMax2;
        }
        cVar.f6580i = iMax;
        if (z11) {
            cVar.f6579h = i12 + this.f6546u.j();
            View viewM2 = M2();
            c cVar2 = this.f6545t;
            cVar2.f6576e = this.f6550x ? -1 : 1;
            int iU0 = u0(viewM2);
            c cVar3 = this.f6545t;
            cVar2.f6575d = iU0 + cVar3.f6576e;
            cVar3.f6573b = this.f6546u.d(viewM2);
            iN = this.f6546u.d(viewM2) - this.f6546u.i();
        } else {
            View viewN2 = N2();
            this.f6545t.f6579h += this.f6546u.n();
            c cVar4 = this.f6545t;
            cVar4.f6576e = this.f6550x ? 1 : -1;
            int iU02 = u0(viewN2);
            c cVar5 = this.f6545t;
            cVar4.f6575d = iU02 + cVar5.f6576e;
            cVar5.f6573b = this.f6546u.g(viewN2);
            iN = (-this.f6546u.g(viewN2)) + this.f6546u.n();
        }
        c cVar6 = this.f6545t;
        cVar6.f6574c = i11;
        if (z10) {
            cVar6.f6574c = i11 - iN;
        }
        cVar6.f6578g = iN;
    }

    public int s2(RecyclerView.w wVar, c cVar, RecyclerView.b0 b0Var, boolean z10) {
        int i10 = cVar.f6574c;
        int i11 = cVar.f6578g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                cVar.f6578g = i11 + i10;
            }
            a3(wVar, cVar);
        }
        int i12 = cVar.f6574c + cVar.f6579h;
        b bVar = this.K0;
        while (true) {
            if ((!cVar.f6584m && i12 <= 0) || !cVar.c(b0Var)) {
                break;
            }
            bVar.a();
            W2(wVar, b0Var, cVar, bVar);
            if (!bVar.f6562b) {
                cVar.f6573b += bVar.f6561a * cVar.f6577f;
                if (!bVar.f6563c || cVar.f6583l != null || !b0Var.j()) {
                    int i13 = cVar.f6574c;
                    int i14 = bVar.f6561a;
                    cVar.f6574c = i13 - i14;
                    i12 -= i14;
                }
                int i15 = cVar.f6578g;
                if (i15 != Integer.MIN_VALUE) {
                    int i16 = i15 + bVar.f6561a;
                    cVar.f6578g = i16;
                    int i17 = cVar.f6574c;
                    if (i17 < 0) {
                        cVar.f6578g = i16 + i17;
                    }
                    a3(wVar, cVar);
                }
                if (z10 && bVar.f6564d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - cVar.f6574c;
    }

    public final void s3(int i10, int i11) {
        this.f6545t.f6574c = this.f6546u.i() - i11;
        c cVar = this.f6545t;
        cVar.f6576e = this.f6550x ? -1 : 1;
        cVar.f6575d = i10;
        cVar.f6577f = 1;
        cVar.f6573b = i11;
        cVar.f6578g = Integer.MIN_VALUE;
    }

    public int t2() {
        View viewE2 = E2(0, Y(), true, false);
        if (viewE2 == null) {
            return -1;
        }
        return u0(viewE2);
    }

    public final void t3(a aVar) {
        s3(aVar.f6557b, aVar.f6558c);
    }

    public final View u2() {
        return D2(0, Y());
    }

    public final void u3(int i10, int i11) {
        this.f6545t.f6574c = i11 - this.f6546u.n();
        c cVar = this.f6545t;
        cVar.f6575d = i10;
        cVar.f6576e = this.f6550x ? 1 : -1;
        cVar.f6577f = -1;
        cVar.f6573b = i11;
        cVar.f6578g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean v() {
        return this.f6544s == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void v1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.D = (SavedState) parcelable;
            N1();
        }
    }

    public final View v2(RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        return H2(wVar, b0Var, 0, Y(), b0Var.d());
    }

    public final void v3(a aVar) {
        u3(aVar.f6557b, aVar.f6558c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean w() {
        return this.f6544s == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable w1() {
        if (this.D != null) {
            return new SavedState(this.D);
        }
        SavedState savedState = new SavedState();
        if (Y() > 0) {
            r2();
            boolean z10 = this.f6547v ^ this.f6550x;
            savedState.f6555c = z10;
            if (z10) {
                View viewM2 = M2();
                savedState.f6554b = this.f6546u.i() - this.f6546u.d(viewM2);
                savedState.f6553a = u0(viewM2);
            } else {
                View viewN2 = N2();
                savedState.f6553a = u0(viewN2);
                savedState.f6554b = this.f6546u.g(viewN2) - this.f6546u.n();
            }
        } else {
            savedState.b();
        }
        return savedState;
    }

    public View w2(boolean z10, boolean z11) {
        return this.f6550x ? E2(0, Y(), z10, z11) : E2(Y() - 1, -1, z10, z11);
    }

    public void w3() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("validating child count ");
        sb2.append(Y());
        if (Y() < 1) {
            return;
        }
        int iU0 = u0(X(0));
        int iG = this.f6546u.g(X(0));
        if (this.f6550x) {
            for (int i10 = 1; i10 < Y(); i10++) {
                View viewX = X(i10);
                int iU02 = u0(viewX);
                int iG2 = this.f6546u.g(viewX);
                if (iU02 < iU0) {
                    Y2();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("detected invalid position. loc invalid? ");
                    sb3.append(iG2 < iG);
                    throw new RuntimeException(sb3.toString());
                }
                if (iG2 > iG) {
                    Y2();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i11 = 1; i11 < Y(); i11++) {
            View viewX2 = X(i11);
            int iU03 = u0(viewX2);
            int iG3 = this.f6546u.g(viewX2);
            if (iU03 < iU0) {
                Y2();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("detected invalid position. loc invalid? ");
                sb4.append(iG3 < iG);
                throw new RuntimeException(sb4.toString());
            }
            if (iG3 < iG) {
                Y2();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    public View x2(boolean z10, boolean z11) {
        return this.f6550x ? E2(Y() - 1, -1, z10, z11) : E2(0, Y(), z10, z11);
    }

    public int y2() {
        View viewE2 = E2(0, Y(), false, true);
        if (viewE2 == null) {
            return -1;
        }
        return u0(viewE2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void z(int i10, int i11, RecyclerView.b0 b0Var, RecyclerView.o.c cVar) {
        if (this.f6544s != 0) {
            i10 = i11;
        }
        if (Y() == 0 || i10 == 0) {
            return;
        }
        r2();
        r3(i10 > 0 ? 1 : -1, Math.abs(i10), true, b0Var);
        l2(b0Var, this.f6545t, cVar);
    }

    public int z2() {
        View viewE2 = E2(Y() - 1, -1, true, false);
        if (viewE2 == null) {
            return -1;
        }
        return u0(viewE2);
    }

    public LinearLayoutManager(Context context, int i10, boolean z10) {
        this.f6544s = 1;
        this.f6549w = false;
        this.f6550x = false;
        this.f6551y = false;
        this.f6552z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.f6542k0 = new a();
        this.K0 = new b();
        this.f6543k1 = 2;
        this.f6548v1 = new int[2];
        j3(i10);
        l3(z10);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f6544s = 1;
        this.f6549w = false;
        this.f6550x = false;
        this.f6551y = false;
        this.f6552z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D = null;
        this.f6542k0 = new a();
        this.K0 = new b();
        this.f6543k1 = 2;
        this.f6548v1 = new int[2];
        RecyclerView.o.d dVarV0 = RecyclerView.o.v0(context, attributeSet, i10, i11);
        j3(dVarV0.f6731a);
        l3(dVarV0.f6733c);
        n3(dVarV0.f6734d);
    }
}
