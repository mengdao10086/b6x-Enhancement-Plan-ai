package com.flydigi.base.widget.recyclerview.layoutmanager;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ViewPagerLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public static final int f13634d8 = -1;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public static final int f13635e8 = 0;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public static final int f13636f8 = 1;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public static final int f13637g8 = -1;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public static final int f13638h8 = 0;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public static final int f13639i8 = 1;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public static final int f13640j8 = Integer.MAX_VALUE;
    public final SparseArray<View> F7;
    public int G7;
    public int H7;
    public int I7;
    public int J7;
    public int K7;
    public float L7;
    public d M7;
    public boolean N7;
    public boolean O7;
    public boolean P7;
    public int Q7;
    public SavedState R7;
    public float S7;
    public a T7;
    public boolean U7;
    public boolean V7;
    public boolean W7;
    public int X7;
    public int Y7;
    public int Z7;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public Interpolator f13641a8;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public int f13642b8;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public View f13643c8;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f13645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f13646c;

        public class a implements Parcelable.Creator<SavedState> {
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

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f13644a);
            parcel.writeFloat(this.f13645b);
            parcel.writeInt(this.f13646c ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.f13644a = parcel.readInt();
            this.f13645b = parcel.readFloat();
            this.f13646c = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f13644a = savedState.f13644a;
            this.f13645b = savedState.f13645b;
            this.f13646c = savedState.f13646c;
        }
    }

    public interface a {
        void onPageScrollStateChanged(int i10);

        void onPageSelected(int i10);
    }

    public ViewPagerLayoutManager(Context context) {
        this(context, 0, false);
    }

    private void f3() {
        if (this.I7 == 1 || !U2()) {
            this.O7 = this.N7;
        } else {
            this.O7 = !this.N7;
        }
    }

    private int g3(int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        if (Y() == 0 || i10 == 0) {
            return 0;
        }
        r2();
        float f10 = i10;
        float fE3 = f10 / E3();
        if (Math.abs(fE3) < 1.0E-8f) {
            return 0;
        }
        float f11 = this.L7 + fE3;
        if (!this.V7 && f11 < L3()) {
            i10 = (int) (f10 - ((f11 - L3()) * E3()));
        } else if (!this.V7 && f11 > I3()) {
            i10 = (int) ((I3() - this.L7) * E3());
        }
        this.L7 += i10 / E3();
        S3(wVar);
        return i10;
    }

    public final int A3() {
        if (Y() == 0) {
            return 0;
        }
        if (!this.P7) {
            return !this.O7 ? C3() : (o0() - C3()) - 1;
        }
        float fN3 = N3();
        return !this.O7 ? (int) fN3 : (int) (((o0() - 1) * this.S7) + fN3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int B(RecyclerView.b0 b0Var) {
        return z3();
    }

    public final int B3() {
        if (Y() == 0) {
            return 0;
        }
        return !this.P7 ? o0() : (int) (o0() * this.S7);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int C(RecyclerView.b0 b0Var) {
        return A3();
    }

    public int C3() {
        if (o0() == 0) {
            return 0;
        }
        int iD3 = D3();
        if (!this.V7) {
            return Math.abs(iD3);
        }
        int iO0 = !this.O7 ? iD3 >= 0 ? iD3 % o0() : (iD3 % o0()) + o0() : iD3 > 0 ? o0() - (iD3 % o0()) : (-iD3) % o0();
        if (iO0 == o0()) {
            return 0;
        }
        return iO0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int D(RecyclerView.b0 b0Var) {
        return B3();
    }

    public final int D3() {
        float f10 = this.S7;
        if (f10 == 0.0f) {
            return 0;
        }
        return Math.round(this.L7 / f10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int E(RecyclerView.b0 b0Var) {
        return z3();
    }

    public float E3() {
        return 1.0f;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int F(RecyclerView.b0 b0Var) {
        return A3();
    }

    public int F3() {
        int i10 = this.f13642b8;
        return i10 == Integer.MAX_VALUE ? (this.M7.p() - this.H7) / 2 : i10;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int G(RecyclerView.b0 b0Var) {
        return B3();
    }

    public boolean G3() {
        return this.W7;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean H0() {
        return true;
    }

    public boolean H3() {
        return this.V7;
    }

    public float I3() {
        if (this.O7) {
            return 0.0f;
        }
        return (o0() - 1) * this.S7;
    }

    public int J3() {
        return this.Z7;
    }

    public final View K3(RecyclerView.w wVar, RecyclerView.b0 b0Var, int i10) {
        if (i10 >= b0Var.d() || i10 < 0) {
            return null;
        }
        try {
            return wVar.p(i10);
        } catch (Exception unused) {
            return K3(wVar, b0Var, i10 + 1);
        }
    }

    public float L3() {
        if (this.O7) {
            return (-(o0() - 1)) * this.S7;
        }
        return 0.0f;
    }

    public final int M3(int i10) {
        if (this.I7 == 1) {
            if (i10 == 33) {
                return !this.O7 ? 1 : 0;
            }
            if (i10 != 130) {
                return -1;
            }
            return this.O7 ? 1 : 0;
        }
        if (i10 == 17) {
            return !this.O7 ? 1 : 0;
        }
        if (i10 != 66) {
            return -1;
        }
        return this.O7 ? 1 : 0;
    }

    public final float N3() {
        if (this.O7) {
            if (!this.V7) {
                return this.L7;
            }
            float f10 = this.L7;
            if (f10 <= 0.0f) {
                return f10 % (this.S7 * o0());
            }
            float fO0 = o0();
            float f11 = this.S7;
            return (fO0 * (-f11)) + (this.L7 % (f11 * o0()));
        }
        if (!this.V7) {
            return this.L7;
        }
        float f12 = this.L7;
        if (f12 >= 0.0f) {
            return f12 % (this.S7 * o0());
        }
        float fO02 = o0();
        float f13 = this.S7;
        return (fO02 * f13) + (this.L7 % (f13 * o0()));
    }

    public int O3() {
        float fC3;
        float fE3;
        if (this.V7) {
            fC3 = (D3() * this.S7) - this.L7;
            fE3 = E3();
        } else {
            fC3 = (C3() * (!this.O7 ? this.S7 : -this.S7)) - this.L7;
            fE3 = E3();
        }
        return (int) (fC3 * fE3);
    }

    public int P3(int i10) {
        float fD3;
        float fE3;
        if (this.V7) {
            fD3 = ((D3() + (!this.O7 ? i10 - C3() : C3() - i10)) * this.S7) - this.L7;
            fE3 = E3();
        } else {
            fD3 = (i10 * (!this.O7 ? this.S7 : -this.S7)) - this.L7;
            fE3 = E3();
        }
        return (int) (fD3 * fE3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int Q1(int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        if (this.I7 == 1) {
            return 0;
        }
        return g3(i10, wVar, b0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int Q2() {
        return this.I7;
    }

    public final float Q3(int i10) {
        return i10 * (this.O7 ? -this.S7 : this.S7);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public View R(int i10) {
        int iO0 = o0();
        if (iO0 == 0) {
            return null;
        }
        for (int i11 = 0; i11 < this.F7.size(); i11++) {
            int iKeyAt = this.F7.keyAt(i11);
            if (iKeyAt < 0) {
                int i12 = iKeyAt % iO0;
                if (i12 == 0) {
                    i12 = -iO0;
                }
                if (i12 + iO0 == i10) {
                    return this.F7.valueAt(i11);
                }
            } else if (i10 == iKeyAt % iO0) {
                return this.F7.valueAt(i11);
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void R1(int i10) {
        if (this.V7 || (i10 >= 0 && i10 < o0())) {
            this.Q7 = i10;
            this.L7 = (i10 * (this.O7 ? -this.S7 : this.S7)) + this.M7.m() + this.M7.i();
            N1();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public boolean R2() {
        return this.U7;
    }

    public boolean R3() {
        return this.P7;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p S() {
        return new RecyclerView.p(-2, -2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int S1(int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        if (this.I7 == 0) {
            return 0;
        }
        return g3(i10, wVar, b0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public boolean S2() {
        return this.N7;
    }

    public final void S3(RecyclerView.w wVar) {
        int i10;
        int i11;
        int i12;
        H(wVar);
        this.F7.clear();
        int iO0 = o0();
        if (iO0 == 0) {
            return;
        }
        int iD3 = this.O7 ? -D3() : D3();
        int i13 = iD3 - this.X7;
        int i14 = this.Y7 + iD3;
        if (i4()) {
            int i15 = this.Z7;
            if (i15 % 2 == 0) {
                i11 = i15 / 2;
                i12 = (iD3 - i11) + 1;
            } else {
                i11 = (i15 - 1) / 2;
                i12 = iD3 - i11;
            }
            int i16 = i12;
            i14 = i11 + iD3 + 1;
            i13 = i16;
        }
        if (!this.V7) {
            if (i13 < 0) {
                if (i4()) {
                    i14 = this.Z7;
                }
                i13 = 0;
            }
            if (i14 > iO0) {
                i14 = iO0;
            }
        }
        float f10 = Float.MIN_VALUE;
        while (i13 < i14) {
            if (i4() || !W3(Q3(i13) - this.L7)) {
                if (i13 >= iO0) {
                    i10 = i13 % iO0;
                } else if (i13 < 0) {
                    int i17 = (-i13) % iO0;
                    if (i17 == 0) {
                        i17 = iO0;
                    }
                    i10 = iO0 - i17;
                } else {
                    i10 = i13;
                }
                View viewP = wVar.p(i10);
                T0(viewP, 0, 0);
                X3(viewP);
                float fQ3 = Q3(i13) - this.L7;
                T3(viewP, fQ3);
                float fH4 = this.W7 ? h4(viewP, fQ3) : i10;
                if (fH4 > f10) {
                    addView(viewP);
                } else {
                    addView(viewP, 0);
                }
                if (i13 == iD3) {
                    this.f13643c8 = viewP;
                }
                this.F7.put(i13, viewP);
                f10 = fH4;
            }
            i13++;
        }
        this.f13643c8.requestFocus();
    }

    public final void T3(View view, float f10) {
        int iX3 = x3(view, f10);
        int iY3 = y3(view, f10);
        if (this.I7 == 1) {
            int i10 = this.K7;
            int i11 = this.J7;
            Q0(view, i10 + iX3, i11 + iY3, i10 + iX3 + this.H7, i11 + iY3 + this.G7);
        } else {
            int i12 = this.J7;
            int i13 = this.K7;
            Q0(view, i12 + iX3, i13 + iY3, i12 + iX3 + this.G7, i13 + iY3 + this.H7);
        }
        c4(view, f10);
    }

    public float U3() {
        return this.M7.n() - this.J7;
    }

    public float V3() {
        return ((-this.G7) - this.M7.m()) - this.J7;
    }

    public final boolean W3(float f10) {
        return f10 > U3() || f10 < V3();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.g gVar, RecyclerView.g gVar2) {
        removeAllViews();
        this.L7 = 0.0f;
    }

    public final void X3(View view) {
        view.setRotation(0.0f);
        view.setRotationY(0.0f);
        view.setRotationX(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setAlpha(1.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean Y0(RecyclerView recyclerView, ArrayList<View> arrayList, int i10, int i11) {
        int iC3 = C3();
        View viewR = R(iC3);
        if (viewR == null) {
            return true;
        }
        if (recyclerView.hasFocus()) {
            int iM3 = M3(i10);
            if (iM3 != -1) {
                recyclerView.L1(iM3 == 1 ? iC3 - 1 : iC3 + 1);
            }
        } else {
            viewR.addFocusables(arrayList, i10, i11);
        }
        return true;
    }

    public void Y3(int i10) {
        q(null);
        if (this.f13642b8 == i10) {
            return;
        }
        this.f13642b8 = i10;
        removeAllViews();
    }

    public void Z3(boolean z10) {
        q(null);
        if (this.W7 == z10) {
            return;
        }
        this.W7 = z10;
        N1();
    }

    public void a4(boolean z10) {
        q(null);
        if (z10 == this.V7) {
            return;
        }
        this.V7 = z10;
        N1();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void b1(RecyclerView recyclerView, RecyclerView.w wVar) {
        super.b1(recyclerView, wVar);
        if (this.U7) {
            E1(wVar);
            wVar.d();
        }
    }

    public abstract float b4();

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public View c1(View view, int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        return null;
    }

    public abstract void c4(View view, float f10);

    public void d4(int i10) {
        q(null);
        if (this.Z7 == i10) {
            return;
        }
        this.Z7 = i10;
        removeAllViews();
    }

    public void e4(a aVar) {
        this.T7 = aVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void f2(RecyclerView recyclerView, RecyclerView.b0 b0Var, int i10) {
        int iP3;
        int i11;
        if (this.V7) {
            int iC3 = C3();
            int iO0 = o0();
            if (i10 < iC3) {
                int i12 = iC3 - i10;
                int i13 = (iO0 - iC3) + i10;
                i11 = i12 < i13 ? iC3 - i12 : iC3 + i13;
            } else {
                int i14 = i10 - iC3;
                int i15 = (iO0 + iC3) - i10;
                i11 = i14 < i15 ? iC3 + i14 : iC3 - i15;
            }
            iP3 = P3(i11);
        } else {
            iP3 = P3(i10);
        }
        if (this.I7 == 1) {
            recyclerView.I1(0, iP3, this.f13641a8);
        } else {
            recyclerView.I1(iP3, 0, this.f13641a8);
        }
    }

    public void f4(Interpolator interpolator) {
        this.f13641a8 = interpolator;
    }

    public void g4() {
    }

    public float h4(View view, float f10) {
        return 0.0f;
    }

    public final boolean i4() {
        return this.Z7 != -1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void j3(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i10);
        }
        q(null);
        if (i10 == this.I7) {
            return;
        }
        this.I7 = i10;
        this.M7 = null;
        this.f13642b8 = Integer.MAX_VALUE;
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void k3(boolean z10) {
        this.U7 = z10;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void l3(boolean z10) {
        q(null);
        if (z10 == this.N7) {
            return;
        }
        this.N7 = z10;
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void m3(boolean z10) {
        this.P7 = z10;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void q1(RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        float f10;
        float f11;
        if (b0Var.d() == 0) {
            E1(wVar);
            this.L7 = 0.0f;
            return;
        }
        r2();
        f3();
        View viewK3 = K3(wVar, b0Var, 0);
        if (viewK3 == null) {
            E1(wVar);
            this.L7 = 0.0f;
            return;
        }
        T0(viewK3, 0, 0);
        this.G7 = this.M7.e(viewK3);
        this.H7 = this.M7.f(viewK3);
        this.J7 = (this.M7.n() - this.G7) / 2;
        if (this.f13642b8 == Integer.MAX_VALUE) {
            this.K7 = (this.M7.p() - this.H7) / 2;
        } else {
            this.K7 = (this.M7.p() - this.H7) - this.f13642b8;
        }
        this.S7 = b4();
        g4();
        if (this.S7 == 0.0f) {
            this.X7 = 1;
            this.Y7 = 1;
        } else {
            this.X7 = ((int) Math.abs(V3() / this.S7)) + 1;
            this.Y7 = ((int) Math.abs(U3() / this.S7)) + 1;
        }
        SavedState savedState = this.R7;
        if (savedState != null) {
            this.O7 = savedState.f13646c;
            this.Q7 = savedState.f13644a;
            this.L7 = savedState.f13645b;
        }
        int i10 = this.Q7;
        if (i10 != -1) {
            if (this.O7) {
                f10 = i10;
                f11 = -this.S7;
            } else {
                f10 = i10;
                f11 = this.S7;
            }
            this.L7 = (f10 * f11) + this.M7.m() + this.M7.i();
        }
        S3(wVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void r1(RecyclerView.b0 b0Var) {
        super.r1(b0Var);
        this.R7 = null;
        this.Q7 = -1;
    }

    public void r2() {
        if (this.M7 == null) {
            this.M7 = d.b(this, this.I7);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean v() {
        return this.I7 == 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void v1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.R7 = new SavedState((SavedState) parcelable);
            N1();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean w() {
        return this.I7 == 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public Parcelable w1() {
        if (this.R7 != null) {
            return new SavedState(this.R7);
        }
        SavedState savedState = new SavedState();
        savedState.f13644a = this.Q7;
        savedState.f13645b = this.L7;
        savedState.f13646c = this.O7;
        return savedState;
    }

    public int x3(View view, float f10) {
        if (this.I7 == 1) {
            return 0;
        }
        return (int) f10;
    }

    public int y3(View view, float f10) {
        if (this.I7 == 1) {
            return (int) f10;
        }
        return 0;
    }

    public final int z3() {
        if (Y() == 0) {
            return 0;
        }
        if (this.P7) {
            return (int) this.S7;
        }
        return 1;
    }

    public ViewPagerLayoutManager(Context context, int i10, boolean z10) {
        super(context);
        this.F7 = new SparseArray<>();
        this.N7 = false;
        this.O7 = false;
        this.P7 = true;
        this.Q7 = -1;
        this.R7 = null;
        this.V7 = false;
        this.Z7 = -1;
        this.f13642b8 = Integer.MAX_VALUE;
        j3(i10);
        l3(z10);
        V1(false);
    }
}
