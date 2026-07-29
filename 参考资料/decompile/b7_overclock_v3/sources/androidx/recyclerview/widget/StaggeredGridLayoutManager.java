package androidx.recyclerview.widget;

import a1.d;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.a0.b {
    public static final String H7 = "StaggeredGridLManager";
    public static final boolean I7 = false;
    public static final int J7 = 0;
    public static final int K7 = 1;
    public static final int L7 = 0;

    @Deprecated
    public static final int M7 = 1;
    public static final int N7 = 2;
    public static final int O7 = Integer.MIN_VALUE;
    public static final float P7 = 0.33333334f;
    public BitSet B;
    public SavedState C1;
    public int[] F7;
    public int K1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f6758k1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public d[] f6760t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @n0
    public w f6761u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @n0
    public w f6762v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public boolean f6763v1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6765w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6766x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @n0
    public final p f6767y;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6759s = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f6768z = false;
    public boolean A = false;
    public int C = -1;
    public int D = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public LazySpanLookup f6757k0 = new LazySpanLookup();
    public int K0 = 2;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public final Rect f6764v2 = new Rect();
    public final b C2 = new b();
    public boolean K2 = false;
    public boolean E7 = true;
    public final Runnable G7 = new a();

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6778c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int[] f6779d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6780e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int[] f6781f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<LazySpanLookup.FullSpanItem> f6782g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f6783h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f6784i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f6785j;

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

        public void a() {
            this.f6779d = null;
            this.f6778c = 0;
            this.f6776a = -1;
            this.f6777b = -1;
        }

        public void b() {
            this.f6779d = null;
            this.f6778c = 0;
            this.f6780e = 0;
            this.f6781f = null;
            this.f6782g = null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f6776a);
            parcel.writeInt(this.f6777b);
            parcel.writeInt(this.f6778c);
            if (this.f6778c > 0) {
                parcel.writeIntArray(this.f6779d);
            }
            parcel.writeInt(this.f6780e);
            if (this.f6780e > 0) {
                parcel.writeIntArray(this.f6781f);
            }
            parcel.writeInt(this.f6783h ? 1 : 0);
            parcel.writeInt(this.f6784i ? 1 : 0);
            parcel.writeInt(this.f6785j ? 1 : 0);
            parcel.writeList(this.f6782g);
        }

        public SavedState(Parcel parcel) {
            this.f6776a = parcel.readInt();
            this.f6777b = parcel.readInt();
            int i10 = parcel.readInt();
            this.f6778c = i10;
            if (i10 > 0) {
                int[] iArr = new int[i10];
                this.f6779d = iArr;
                parcel.readIntArray(iArr);
            }
            int i11 = parcel.readInt();
            this.f6780e = i11;
            if (i11 > 0) {
                int[] iArr2 = new int[i11];
                this.f6781f = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f6783h = parcel.readInt() == 1;
            this.f6784i = parcel.readInt() == 1;
            this.f6785j = parcel.readInt() == 1;
            this.f6782g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f6778c = savedState.f6778c;
            this.f6776a = savedState.f6776a;
            this.f6777b = savedState.f6777b;
            this.f6779d = savedState.f6779d;
            this.f6780e = savedState.f6780e;
            this.f6781f = savedState.f6781f;
            this.f6783h = savedState.f6783h;
            this.f6784i = savedState.f6784i;
            this.f6785j = savedState.f6785j;
            this.f6782g = savedState.f6782g;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.q2();
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6788b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6789c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f6790d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f6791e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int[] f6792f;

        public b() {
            c();
        }

        public void a() {
            this.f6788b = this.f6789c ? StaggeredGridLayoutManager.this.f6761u.i() : StaggeredGridLayoutManager.this.f6761u.n();
        }

        public void b(int i10) {
            if (this.f6789c) {
                this.f6788b = StaggeredGridLayoutManager.this.f6761u.i() - i10;
            } else {
                this.f6788b = StaggeredGridLayoutManager.this.f6761u.n() + i10;
            }
        }

        public void c() {
            this.f6787a = -1;
            this.f6788b = Integer.MIN_VALUE;
            this.f6789c = false;
            this.f6790d = false;
            this.f6791e = false;
            int[] iArr = this.f6792f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        public void d(d[] dVarArr) {
            int length = dVarArr.length;
            int[] iArr = this.f6792f;
            if (iArr == null || iArr.length < length) {
                this.f6792f = new int[StaggeredGridLayoutManager.this.f6760t.length];
            }
            for (int i10 = 0; i10 < length; i10++) {
                this.f6792f[i10] = dVarArr[i10].u(Integer.MIN_VALUE);
            }
        }
    }

    public static class c extends RecyclerView.p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f6794g = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d f6795e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f6796f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int C() {
            d dVar = this.f6795e;
            if (dVar == null) {
                return -1;
            }
            return dVar.f6802e;
        }

        public boolean F() {
            return this.f6796f;
        }

        public void M(boolean z10) {
            this.f6796f = z10;
        }

        public c(int i10, int i11) {
            super(i10, i11);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(RecyclerView.p pVar) {
            super(pVar);
        }
    }

    public class d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f6797g = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList<View> f6798a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6799b = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6800c = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6801d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f6802e;

        public d(int i10) {
            this.f6802e = i10;
        }

        public void A(int i10) {
            this.f6799b = i10;
            this.f6800c = i10;
        }

        public void a(View view) {
            c cVarS = s(view);
            cVarS.f6795e = this;
            this.f6798a.add(view);
            this.f6800c = Integer.MIN_VALUE;
            if (this.f6798a.size() == 1) {
                this.f6799b = Integer.MIN_VALUE;
            }
            if (cVarS.j() || cVarS.g()) {
                this.f6801d += StaggeredGridLayoutManager.this.f6761u.e(view);
            }
        }

        public void b(boolean z10, int i10) {
            int iQ = z10 ? q(Integer.MIN_VALUE) : u(Integer.MIN_VALUE);
            e();
            if (iQ == Integer.MIN_VALUE) {
                return;
            }
            if (!z10 || iQ >= StaggeredGridLayoutManager.this.f6761u.i()) {
                if (z10 || iQ <= StaggeredGridLayoutManager.this.f6761u.n()) {
                    if (i10 != Integer.MIN_VALUE) {
                        iQ += i10;
                    }
                    this.f6800c = iQ;
                    this.f6799b = iQ;
                }
            }
        }

        public void c() {
            LazySpanLookup.FullSpanItem fullSpanItemF;
            ArrayList<View> arrayList = this.f6798a;
            View view = arrayList.get(arrayList.size() - 1);
            c cVarS = s(view);
            this.f6800c = StaggeredGridLayoutManager.this.f6761u.d(view);
            if (cVarS.f6796f && (fullSpanItemF = StaggeredGridLayoutManager.this.f6757k0.f(cVarS.b())) != null && fullSpanItemF.f6773b == 1) {
                this.f6800c += fullSpanItemF.a(this.f6802e);
            }
        }

        public void d() {
            LazySpanLookup.FullSpanItem fullSpanItemF;
            View view = this.f6798a.get(0);
            c cVarS = s(view);
            this.f6799b = StaggeredGridLayoutManager.this.f6761u.g(view);
            if (cVarS.f6796f && (fullSpanItemF = StaggeredGridLayoutManager.this.f6757k0.f(cVarS.b())) != null && fullSpanItemF.f6773b == -1) {
                this.f6799b -= fullSpanItemF.a(this.f6802e);
            }
        }

        public void e() {
            this.f6798a.clear();
            v();
            this.f6801d = 0;
        }

        public int f() {
            return StaggeredGridLayoutManager.this.f6768z ? n(this.f6798a.size() - 1, -1, true) : n(0, this.f6798a.size(), true);
        }

        public int g() {
            return StaggeredGridLayoutManager.this.f6768z ? m(this.f6798a.size() - 1, -1, true) : m(0, this.f6798a.size(), true);
        }

        public int h() {
            return StaggeredGridLayoutManager.this.f6768z ? n(this.f6798a.size() - 1, -1, false) : n(0, this.f6798a.size(), false);
        }

        public int i() {
            return StaggeredGridLayoutManager.this.f6768z ? n(0, this.f6798a.size(), true) : n(this.f6798a.size() - 1, -1, true);
        }

        public int j() {
            return StaggeredGridLayoutManager.this.f6768z ? m(0, this.f6798a.size(), true) : m(this.f6798a.size() - 1, -1, true);
        }

        public int k() {
            return StaggeredGridLayoutManager.this.f6768z ? n(0, this.f6798a.size(), false) : n(this.f6798a.size() - 1, -1, false);
        }

        public int l(int i10, int i11, boolean z10, boolean z11, boolean z12) {
            int iN = StaggeredGridLayoutManager.this.f6761u.n();
            int i12 = StaggeredGridLayoutManager.this.f6761u.i();
            int i13 = i11 > i10 ? 1 : -1;
            while (i10 != i11) {
                View view = this.f6798a.get(i10);
                int iG = StaggeredGridLayoutManager.this.f6761u.g(view);
                int iD = StaggeredGridLayoutManager.this.f6761u.d(view);
                boolean z13 = false;
                boolean z14 = !z12 ? iG >= i12 : iG > i12;
                if (!z12 ? iD > iN : iD >= iN) {
                    z13 = true;
                }
                if (z14 && z13) {
                    if (z10 && z11) {
                        if (iG >= iN && iD <= i12) {
                            return StaggeredGridLayoutManager.this.u0(view);
                        }
                    } else {
                        if (z11) {
                            return StaggeredGridLayoutManager.this.u0(view);
                        }
                        if (iG < iN || iD > i12) {
                            return StaggeredGridLayoutManager.this.u0(view);
                        }
                    }
                }
                i10 += i13;
            }
            return -1;
        }

        public int m(int i10, int i11, boolean z10) {
            return l(i10, i11, false, false, z10);
        }

        public int n(int i10, int i11, boolean z10) {
            return l(i10, i11, z10, true, false);
        }

        public int o() {
            return this.f6801d;
        }

        public int p() {
            int i10 = this.f6800c;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            c();
            return this.f6800c;
        }

        public int q(int i10) {
            int i11 = this.f6800c;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f6798a.size() == 0) {
                return i10;
            }
            c();
            return this.f6800c;
        }

        public View r(int i10, int i11) {
            View view = null;
            if (i11 != -1) {
                int size = this.f6798a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f6798a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f6768z && staggeredGridLayoutManager.u0(view2) >= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f6768z && staggeredGridLayoutManager2.u0(view2) <= i10) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f6798a.size();
                int i12 = 0;
                while (i12 < size2) {
                    View view3 = this.f6798a.get(i12);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f6768z && staggeredGridLayoutManager3.u0(view3) <= i10) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f6768z && staggeredGridLayoutManager4.u0(view3) >= i10) || !view3.hasFocusable()) {
                        break;
                    }
                    i12++;
                    view = view3;
                }
            }
            return view;
        }

        public c s(View view) {
            return (c) view.getLayoutParams();
        }

        public int t() {
            int i10 = this.f6799b;
            if (i10 != Integer.MIN_VALUE) {
                return i10;
            }
            d();
            return this.f6799b;
        }

        public int u(int i10) {
            int i11 = this.f6799b;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            if (this.f6798a.size() == 0) {
                return i10;
            }
            d();
            return this.f6799b;
        }

        public void v() {
            this.f6799b = Integer.MIN_VALUE;
            this.f6800c = Integer.MIN_VALUE;
        }

        public void w(int i10) {
            int i11 = this.f6799b;
            if (i11 != Integer.MIN_VALUE) {
                this.f6799b = i11 + i10;
            }
            int i12 = this.f6800c;
            if (i12 != Integer.MIN_VALUE) {
                this.f6800c = i12 + i10;
            }
        }

        public void x() {
            int size = this.f6798a.size();
            View viewRemove = this.f6798a.remove(size - 1);
            c cVarS = s(viewRemove);
            cVarS.f6795e = null;
            if (cVarS.j() || cVarS.g()) {
                this.f6801d -= StaggeredGridLayoutManager.this.f6761u.e(viewRemove);
            }
            if (size == 1) {
                this.f6799b = Integer.MIN_VALUE;
            }
            this.f6800c = Integer.MIN_VALUE;
        }

        public void y() {
            View viewRemove = this.f6798a.remove(0);
            c cVarS = s(viewRemove);
            cVarS.f6795e = null;
            if (this.f6798a.size() == 0) {
                this.f6800c = Integer.MIN_VALUE;
            }
            if (cVarS.j() || cVarS.g()) {
                this.f6801d -= StaggeredGridLayoutManager.this.f6761u.e(viewRemove);
            }
            this.f6799b = Integer.MIN_VALUE;
        }

        public void z(View view) {
            c cVarS = s(view);
            cVarS.f6795e = this;
            this.f6798a.add(0, view);
            this.f6799b = Integer.MIN_VALUE;
            if (this.f6798a.size() == 1) {
                this.f6800c = Integer.MIN_VALUE;
            }
            if (cVarS.j() || cVarS.g()) {
                this.f6801d += StaggeredGridLayoutManager.this.f6761u.e(view);
            }
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        RecyclerView.o.d dVarV0 = RecyclerView.o.v0(context, attributeSet, i10, i11);
        p3(dVarV0.f6731a);
        r3(dVarV0.f6732b);
        q3(dVarV0.f6733c);
        this.f6767y = new p();
        y2();
    }

    public int[] A2(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f6759s];
        } else if (iArr.length < this.f6759s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f6759s + ", array size:" + iArr.length);
        }
        for (int i10 = 0; i10 < this.f6759s; i10++) {
            iArr[i10] = this.f6760t[i10].f();
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int B(RecyclerView.b0 b0Var) {
        return s2(b0Var);
    }

    public final int B2(int i10) {
        int iY = Y();
        for (int i11 = 0; i11 < iY; i11++) {
            int iU0 = u0(X(i11));
            if (iU0 >= 0 && iU0 < i10) {
                return iU0;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int C(RecyclerView.b0 b0Var) {
        return t2(b0Var);
    }

    public View C2(boolean z10) {
        int iN = this.f6761u.n();
        int i10 = this.f6761u.i();
        View view = null;
        for (int iY = Y() - 1; iY >= 0; iY--) {
            View viewX = X(iY);
            int iG = this.f6761u.g(viewX);
            int iD = this.f6761u.d(viewX);
            if (iD > iN && iG < i10) {
                if (iD <= i10 || !z10) {
                    return viewX;
                }
                if (view == null) {
                    view = viewX;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int D(RecyclerView.b0 b0Var) {
        return u2(b0Var);
    }

    public View D2(boolean z10) {
        int iN = this.f6761u.n();
        int i10 = this.f6761u.i();
        int iY = Y();
        View view = null;
        for (int i11 = 0; i11 < iY; i11++) {
            View viewX = X(i11);
            int iG = this.f6761u.g(viewX);
            if (this.f6761u.d(viewX) > iN && iG < i10) {
                if (iG >= iN || !z10) {
                    return viewX;
                }
                if (view == null) {
                    view = viewX;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int E(RecyclerView.b0 b0Var) {
        return s2(b0Var);
    }

    public int E2() {
        View viewC2 = this.A ? C2(true) : D2(true);
        if (viewC2 == null) {
            return -1;
        }
        return u0(viewC2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int F(RecyclerView.b0 b0Var) {
        return t2(b0Var);
    }

    public int[] F2(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f6759s];
        } else if (iArr.length < this.f6759s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f6759s + ", array size:" + iArr.length);
        }
        for (int i10 = 0; i10 < this.f6759s; i10++) {
            iArr[i10] = this.f6760t[i10].h();
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int G(RecyclerView.b0 b0Var) {
        return u2(b0Var);
    }

    public int[] G2(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f6759s];
        } else if (iArr.length < this.f6759s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f6759s + ", array size:" + iArr.length);
        }
        for (int i10 = 0; i10 < this.f6759s; i10++) {
            iArr[i10] = this.f6760t[i10].i();
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean H0() {
        return this.K0 != 0;
    }

    public final int H2(int i10) {
        for (int iY = Y() - 1; iY >= 0; iY--) {
            int iU0 = u0(X(iY));
            if (iU0 >= 0 && iU0 < i10) {
                return iU0;
            }
        }
        return 0;
    }

    public int[] I2(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f6759s];
        } else if (iArr.length < this.f6759s) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f6759s + ", array size:" + iArr.length);
        }
        for (int i10 = 0; i10 < this.f6759s; i10++) {
            iArr[i10] = this.f6760t[i10].k();
        }
        return iArr;
    }

    public final void J2(RecyclerView.w wVar, RecyclerView.b0 b0Var, boolean z10) {
        int i10;
        int iO2 = O2(Integer.MIN_VALUE);
        if (iO2 != Integer.MIN_VALUE && (i10 = this.f6761u.i() - iO2) > 0) {
            int i11 = i10 - (-l3(-i10, wVar, b0Var));
            if (!z10 || i11 <= 0) {
                return;
            }
            this.f6761u.t(i11);
        }
    }

    public final void K2(RecyclerView.w wVar, RecyclerView.b0 b0Var, boolean z10) {
        int iN;
        int iR2 = R2(Integer.MAX_VALUE);
        if (iR2 != Integer.MAX_VALUE && (iN = iR2 - this.f6761u.n()) > 0) {
            int iL3 = iN - l3(iN, wVar, b0Var);
            if (!z10 || iL3 <= 0) {
                return;
            }
            this.f6761u.t(-iL3);
        }
    }

    public int L2() {
        if (Y() == 0) {
            return 0;
        }
        return u0(X(0));
    }

    public int M2() {
        return this.K0;
    }

    public int N2() {
        int iY = Y();
        if (iY == 0) {
            return 0;
        }
        return u0(X(iY - 1));
    }

    public final int O2(int i10) {
        int iQ = this.f6760t[0].q(i10);
        for (int i11 = 1; i11 < this.f6759s; i11++) {
            int iQ2 = this.f6760t[i11].q(i10);
            if (iQ2 > iQ) {
                iQ = iQ2;
            }
        }
        return iQ;
    }

    public final int P2(int i10) {
        int iU = this.f6760t[0].u(i10);
        for (int i11 = 1; i11 < this.f6759s; i11++) {
            int iU2 = this.f6760t[i11].u(i10);
            if (iU2 > iU) {
                iU = iU2;
            }
        }
        return iU;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int Q1(int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        return l3(i10, wVar, b0Var);
    }

    public final int Q2(int i10) {
        int iQ = this.f6760t[0].q(i10);
        for (int i11 = 1; i11 < this.f6759s; i11++) {
            int iQ2 = this.f6760t[i11].q(i10);
            if (iQ2 < iQ) {
                iQ = iQ2;
            }
        }
        return iQ;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R1(int i10) {
        SavedState savedState = this.C1;
        if (savedState != null && savedState.f6776a != i10) {
            savedState.a();
        }
        this.C = i10;
        this.D = Integer.MIN_VALUE;
        N1();
    }

    public final int R2(int i10) {
        int iU = this.f6760t[0].u(i10);
        for (int i11 = 1; i11 < this.f6759s; i11++) {
            int iU2 = this.f6760t[i11].u(i10);
            if (iU2 < iU) {
                iU = iU2;
            }
        }
        return iU;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p S() {
        return this.f6765w == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int S1(int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        return l3(i10, wVar, b0Var);
    }

    public final d S2(p pVar) {
        int i10;
        int i11;
        int i12 = -1;
        if (d3(pVar.f7172e)) {
            i10 = this.f6759s - 1;
            i11 = -1;
        } else {
            i10 = 0;
            i12 = this.f6759s;
            i11 = 1;
        }
        d dVar = null;
        if (pVar.f7172e == 1) {
            int i13 = Integer.MAX_VALUE;
            int iN = this.f6761u.n();
            while (i10 != i12) {
                d dVar2 = this.f6760t[i10];
                int iQ = dVar2.q(iN);
                if (iQ < i13) {
                    dVar = dVar2;
                    i13 = iQ;
                }
                i10 += i11;
            }
            return dVar;
        }
        int i14 = Integer.MIN_VALUE;
        int i15 = this.f6761u.i();
        while (i10 != i12) {
            d dVar3 = this.f6760t[i10];
            int iU = dVar3.u(i15);
            if (iU > i14) {
                dVar = dVar3;
                i14 = iU;
            }
            i10 += i11;
        }
        return dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p T(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    public int T2() {
        return this.f6765w;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p U(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    public boolean U2() {
        return this.f6768z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void V0(int i10) {
        super.V0(i10);
        for (int i11 = 0; i11 < this.f6759s; i11++) {
            this.f6760t[i11].w(i10);
        }
    }

    public int V2() {
        return this.f6759s;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(int i10) {
        super.W0(i10);
        for (int i11 = 0; i11 < this.f6759s; i11++) {
            this.f6760t[i11].w(i10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void W2(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L9
            int r0 = r6.N2()
            goto Ld
        L9:
            int r0 = r6.L2()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1a
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1c
        L16:
            int r2 = r7 + 1
            r3 = r8
            goto L1d
        L1a:
            int r2 = r7 + r8
        L1c:
            r3 = r7
        L1d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.f6757k0
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L3c
            r5 = 2
            if (r9 == r5) goto L36
            if (r9 == r1) goto L2b
            goto L41
        L2b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f6757k0
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.f6757k0
            r7.j(r8, r4)
            goto L41
        L36:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f6757k0
            r9.k(r7, r8)
            goto L41
        L3c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f6757k0
            r9.j(r7, r8)
        L41:
            if (r2 > r0) goto L44
            return
        L44:
            boolean r7 = r6.A
            if (r7 == 0) goto L4d
            int r7 = r6.L2()
            goto L51
        L4d:
            int r7 = r6.N2()
        L51:
            if (r3 > r7) goto L56
            r6.N1()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.W2(int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View X2() {
        /*
            r12 = this;
            int r0 = r12.Y()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f6759s
            r2.<init>(r3)
            int r3 = r12.f6759s
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f6765w
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.Z2()
            if (r3 == 0) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = -1
        L21:
            boolean r6 = r12.A
            if (r6 == 0) goto L27
            r6 = -1
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L2b:
            if (r0 >= r6) goto L2e
            r5 = 1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.X(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r8.f6795e
            int r9 = r9.f6802e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r8.f6795e
            boolean r9 = r12.r2(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r8.f6795e
            int r9 = r9.f6802e
            r2.clear(r9)
        L54:
            boolean r9 = r8.f6796f
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.X(r9)
            boolean r10 = r12.A
            if (r10 == 0) goto L77
            androidx.recyclerview.widget.w r10 = r12.f6761u
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.w r11 = r12.f6761u
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            androidx.recyclerview.widget.w r10 = r12.f6761u
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.w r11 = r12.f6761u
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = 1
            goto L8b
        L8a:
            r10 = 0
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r8 = r8.f6795e
            int r8 = r8.f6802e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r9.f6795e
            int r9 = r9.f6802e
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = 1
            goto La1
        La0:
            r8 = 0
        La1:
            if (r3 >= 0) goto La5
            r9 = 1
            goto La6
        La5:
            r9 = 0
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.X2():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y1(Rect rect, int i10, int i11) {
        int iY;
        int iY2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f6765w == 1) {
            iY2 = RecyclerView.o.y(i11, rect.height() + paddingTop, s0());
            iY = RecyclerView.o.y(i10, (this.f6766x * this.f6759s) + paddingLeft, t0());
        } else {
            iY = RecyclerView.o.y(i10, rect.width() + paddingLeft, t0());
            iY2 = RecyclerView.o.y(i11, (this.f6766x * this.f6759s) + paddingTop, s0());
        }
        X1(iY, iY2);
    }

    public void Y2() {
        this.f6757k0.b();
        N1();
    }

    public boolean Z2() {
        return q0() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a0.b
    public PointF a(int i10) {
        int iP2 = p2(i10);
        PointF pointF = new PointF();
        if (iP2 == 0) {
            return null;
        }
        if (this.f6765w == 0) {
            pointF.x = iP2;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iP2;
        }
        return pointF;
    }

    public final void a3(View view, int i10, int i11, boolean z10) {
        u(view, this.f6764v2);
        c cVar = (c) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.f6764v2;
        int iZ3 = z3(i10, i12 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i13 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.f6764v2;
        int iZ32 = z3(i11, i13 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z10 ? e2(view, iZ3, iZ32, cVar) : c2(view, iZ3, iZ32, cVar)) {
            view.measure(iZ3, iZ32);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b1(RecyclerView recyclerView, RecyclerView.w wVar) {
        super.b1(recyclerView, wVar);
        I1(this.G7);
        for (int i10 = 0; i10 < this.f6759s; i10++) {
            this.f6760t[i10].e();
        }
        recyclerView.requestLayout();
    }

    public final void b3(View view, c cVar, boolean z10) {
        if (cVar.f6796f) {
            if (this.f6765w == 1) {
                a3(view, this.K1, RecyclerView.o.Z(m0(), n0(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z10);
                return;
            } else {
                a3(view, RecyclerView.o.Z(B0(), C0(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.K1, z10);
                return;
            }
        }
        if (this.f6765w == 1) {
            a3(view, RecyclerView.o.Z(this.f6766x, C0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false), RecyclerView.o.Z(m0(), n0(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) cVar).height, true), z10);
        } else {
            a3(view, RecyclerView.o.Z(B0(), C0(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) cVar).width, true), RecyclerView.o.Z(this.f6766x, n0(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false), z10);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    @p0
    public View c1(View view, int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        View viewQ;
        View viewR;
        if (Y() == 0 || (viewQ = Q(view)) == null) {
            return null;
        }
        k3();
        int iV2 = v2(i10);
        if (iV2 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) viewQ.getLayoutParams();
        boolean z10 = cVar.f6796f;
        d dVar = cVar.f6795e;
        int iN2 = iV2 == 1 ? N2() : L2();
        w3(iN2, b0Var);
        o3(iV2);
        p pVar = this.f6767y;
        pVar.f7170c = pVar.f7171d + iN2;
        pVar.f7169b = (int) (this.f6761u.o() * 0.33333334f);
        p pVar2 = this.f6767y;
        pVar2.f7175h = true;
        pVar2.f7168a = false;
        z2(wVar, pVar2, b0Var);
        this.f6758k1 = this.A;
        if (!z10 && (viewR = dVar.r(iN2, iV2)) != null && viewR != viewQ) {
            return viewR;
        }
        if (d3(iV2)) {
            for (int i11 = this.f6759s - 1; i11 >= 0; i11--) {
                View viewR2 = this.f6760t[i11].r(iN2, iV2);
                if (viewR2 != null && viewR2 != viewQ) {
                    return viewR2;
                }
            }
        } else {
            for (int i12 = 0; i12 < this.f6759s; i12++) {
                View viewR3 = this.f6760t[i12].r(iN2, iV2);
                if (viewR3 != null && viewR3 != viewQ) {
                    return viewR3;
                }
            }
        }
        boolean z11 = (this.f6768z ^ true) == (iV2 == -1);
        if (!z10) {
            View viewR4 = R(z11 ? dVar.g() : dVar.j());
            if (viewR4 != null && viewR4 != viewQ) {
                return viewR4;
            }
        }
        if (d3(iV2)) {
            for (int i13 = this.f6759s - 1; i13 >= 0; i13--) {
                if (i13 != dVar.f6802e) {
                    View viewR5 = R(z11 ? this.f6760t[i13].g() : this.f6760t[i13].j());
                    if (viewR5 != null && viewR5 != viewQ) {
                        return viewR5;
                    }
                }
            }
        } else {
            for (int i14 = 0; i14 < this.f6759s; i14++) {
                View viewR6 = R(z11 ? this.f6760t[i14].g() : this.f6760t[i14].j());
                if (viewR6 != null && viewR6 != viewQ) {
                    return viewR6;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c3(androidx.recyclerview.widget.RecyclerView.w r9, androidx.recyclerview.widget.RecyclerView.b0 r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c3(androidx.recyclerview.widget.RecyclerView$w, androidx.recyclerview.widget.RecyclerView$b0, boolean):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int d0(RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        return this.f6765w == 1 ? this.f6759s : super.d0(wVar, b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d1(AccessibilityEvent accessibilityEvent) {
        super.d1(accessibilityEvent);
        if (Y() > 0) {
            View viewD2 = D2(false);
            View viewC2 = C2(false);
            if (viewD2 == null || viewC2 == null) {
                return;
            }
            int iU0 = u0(viewD2);
            int iU02 = u0(viewC2);
            if (iU0 < iU02) {
                accessibilityEvent.setFromIndex(iU0);
                accessibilityEvent.setToIndex(iU02);
            } else {
                accessibilityEvent.setFromIndex(iU02);
                accessibilityEvent.setToIndex(iU0);
            }
        }
    }

    public final boolean d3(int i10) {
        if (this.f6765w == 0) {
            return (i10 == -1) != this.A;
        }
        return ((i10 == -1) == this.A) == Z2();
    }

    public void e3(int i10, RecyclerView.b0 b0Var) {
        int iL2;
        int i11;
        if (i10 > 0) {
            iL2 = N2();
            i11 = 1;
        } else {
            iL2 = L2();
            i11 = -1;
        }
        this.f6767y.f7168a = true;
        w3(iL2, b0Var);
        o3(i11);
        p pVar = this.f6767y;
        pVar.f7170c = iL2 + pVar.f7171d;
        pVar.f7169b = Math.abs(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void f2(RecyclerView recyclerView, RecyclerView.b0 b0Var, int i10) {
        q qVar = new q(recyclerView.getContext());
        qVar.q(i10);
        g2(qVar);
    }

    public final void f3(View view) {
        for (int i10 = this.f6759s - 1; i10 >= 0; i10--) {
            this.f6760t[i10].z(view);
        }
    }

    public final void g3(RecyclerView.w wVar, p pVar) {
        if (!pVar.f7168a || pVar.f7176i) {
            return;
        }
        if (pVar.f7169b == 0) {
            if (pVar.f7172e == -1) {
                h3(wVar, pVar.f7174g);
                return;
            } else {
                i3(wVar, pVar.f7173f);
                return;
            }
        }
        if (pVar.f7172e != -1) {
            int iQ2 = Q2(pVar.f7174g) - pVar.f7174g;
            i3(wVar, iQ2 < 0 ? pVar.f7173f : Math.min(iQ2, pVar.f7169b) + pVar.f7173f);
        } else {
            int i10 = pVar.f7173f;
            int iP2 = i10 - P2(i10);
            h3(wVar, iP2 < 0 ? pVar.f7174g : pVar.f7174g - Math.min(iP2, pVar.f7169b));
        }
    }

    public final void h3(RecyclerView.w wVar, int i10) {
        for (int iY = Y() - 1; iY >= 0; iY--) {
            View viewX = X(iY);
            if (this.f6761u.g(viewX) < i10 || this.f6761u.r(viewX) < i10) {
                return;
            }
            c cVar = (c) viewX.getLayoutParams();
            if (cVar.f6796f) {
                for (int i11 = 0; i11 < this.f6759s; i11++) {
                    if (this.f6760t[i11].f6798a.size() == 1) {
                        return;
                    }
                }
                for (int i12 = 0; i12 < this.f6759s; i12++) {
                    this.f6760t[i12].x();
                }
            } else if (cVar.f6795e.f6798a.size() == 1) {
                return;
            } else {
                cVar.f6795e.x();
            }
            G1(viewX, wVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i1(RecyclerView.w wVar, RecyclerView.b0 b0Var, View view, a1.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.h1(view, dVar);
            return;
        }
        c cVar = (c) layoutParams;
        if (this.f6765w == 0) {
            dVar.e1(d.e.h(cVar.C(), cVar.f6796f ? this.f6759s : 1, -1, -1, false, false));
        } else {
            dVar.e1(d.e.h(-1, -1, cVar.C(), cVar.f6796f ? this.f6759s : 1, false, false));
        }
    }

    public final void i3(RecyclerView.w wVar, int i10) {
        while (Y() > 0) {
            View viewX = X(0);
            if (this.f6761u.d(viewX) > i10 || this.f6761u.q(viewX) > i10) {
                return;
            }
            c cVar = (c) viewX.getLayoutParams();
            if (cVar.f6796f) {
                for (int i11 = 0; i11 < this.f6759s; i11++) {
                    if (this.f6760t[i11].f6798a.size() == 1) {
                        return;
                    }
                }
                for (int i12 = 0; i12 < this.f6759s; i12++) {
                    this.f6760t[i12].y();
                }
            } else if (cVar.f6795e.f6798a.size() == 1) {
                return;
            } else {
                cVar.f6795e.y();
            }
            G1(viewX, wVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean j2() {
        return this.C1 == null;
    }

    public final void j3() {
        if (this.f6762v.l() == 1073741824) {
            return;
        }
        float fMax = 0.0f;
        int iY = Y();
        for (int i10 = 0; i10 < iY; i10++) {
            View viewX = X(i10);
            float fE = this.f6762v.e(viewX);
            if (fE >= fMax) {
                if (((c) viewX.getLayoutParams()).F()) {
                    fE = (fE * 1.0f) / this.f6759s;
                }
                fMax = Math.max(fMax, fE);
            }
        }
        int i11 = this.f6766x;
        int iRound = Math.round(fMax * this.f6759s);
        if (this.f6762v.l() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.f6762v.o());
        }
        x3(iRound);
        if (this.f6766x == i11) {
            return;
        }
        for (int i12 = 0; i12 < iY; i12++) {
            View viewX2 = X(i12);
            c cVar = (c) viewX2.getLayoutParams();
            if (!cVar.f6796f) {
                if (Z2() && this.f6765w == 1) {
                    int i13 = this.f6759s;
                    int i14 = cVar.f6795e.f6802e;
                    viewX2.offsetLeftAndRight(((-((i13 - 1) - i14)) * this.f6766x) - ((-((i13 - 1) - i14)) * i11));
                } else {
                    int i15 = cVar.f6795e.f6802e;
                    int i16 = this.f6766x * i15;
                    int i17 = i15 * i11;
                    if (this.f6765w == 1) {
                        viewX2.offsetLeftAndRight(i16 - i17);
                    } else {
                        viewX2.offsetTopAndBottom(i16 - i17);
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void k1(RecyclerView recyclerView, int i10, int i11) {
        W2(i10, i11, 1);
    }

    public final void k2(View view) {
        for (int i10 = this.f6759s - 1; i10 >= 0; i10--) {
            this.f6760t[i10].a(view);
        }
    }

    public final void k3() {
        if (this.f6765w == 1 || !Z2()) {
            this.A = this.f6768z;
        } else {
            this.A = !this.f6768z;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void l1(RecyclerView recyclerView) {
        this.f6757k0.b();
        N1();
    }

    public final void l2(b bVar) {
        SavedState savedState = this.C1;
        int i10 = savedState.f6778c;
        if (i10 > 0) {
            if (i10 == this.f6759s) {
                for (int i11 = 0; i11 < this.f6759s; i11++) {
                    this.f6760t[i11].e();
                    SavedState savedState2 = this.C1;
                    int i12 = savedState2.f6779d[i11];
                    if (i12 != Integer.MIN_VALUE) {
                        i12 += savedState2.f6784i ? this.f6761u.i() : this.f6761u.n();
                    }
                    this.f6760t[i11].A(i12);
                }
            } else {
                savedState.b();
                SavedState savedState3 = this.C1;
                savedState3.f6776a = savedState3.f6777b;
            }
        }
        SavedState savedState4 = this.C1;
        this.f6763v1 = savedState4.f6785j;
        q3(savedState4.f6783h);
        k3();
        SavedState savedState5 = this.C1;
        int i13 = savedState5.f6776a;
        if (i13 != -1) {
            this.C = i13;
            bVar.f6789c = savedState5.f6784i;
        } else {
            bVar.f6789c = this.A;
        }
        if (savedState5.f6780e > 1) {
            LazySpanLookup lazySpanLookup = this.f6757k0;
            lazySpanLookup.f6770a = savedState5.f6781f;
            lazySpanLookup.f6771b = savedState5.f6782g;
        }
    }

    public int l3(int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        if (Y() == 0 || i10 == 0) {
            return 0;
        }
        e3(i10, b0Var);
        int iZ2 = z2(wVar, this.f6767y, b0Var);
        if (this.f6767y.f7169b >= iZ2) {
            i10 = i10 < 0 ? -iZ2 : iZ2;
        }
        this.f6761u.t(-i10);
        this.f6758k1 = this.A;
        p pVar = this.f6767y;
        pVar.f7169b = 0;
        g3(wVar, pVar);
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void m1(RecyclerView recyclerView, int i10, int i11, int i12) {
        W2(i10, i11, 8);
    }

    public boolean m2() {
        int iQ = this.f6760t[0].q(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f6759s; i10++) {
            if (this.f6760t[i10].q(Integer.MIN_VALUE) != iQ) {
                return false;
            }
        }
        return true;
    }

    public void m3(int i10, int i11) {
        SavedState savedState = this.C1;
        if (savedState != null) {
            savedState.a();
        }
        this.C = i10;
        this.D = i11;
        N1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void n1(RecyclerView recyclerView, int i10, int i11) {
        W2(i10, i11, 2);
    }

    public boolean n2() {
        int iU = this.f6760t[0].u(Integer.MIN_VALUE);
        for (int i10 = 1; i10 < this.f6759s; i10++) {
            if (this.f6760t[i10].u(Integer.MIN_VALUE) != iU) {
                return false;
            }
        }
        return true;
    }

    public void n3(int i10) {
        q(null);
        if (i10 == this.K0) {
            return;
        }
        if (i10 != 0 && i10 != 2) {
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
        this.K0 = i10;
        N1();
    }

    public final void o2(View view, c cVar, p pVar) {
        if (pVar.f7172e == 1) {
            if (cVar.f6796f) {
                k2(view);
                return;
            } else {
                cVar.f6795e.a(view);
                return;
            }
        }
        if (cVar.f6796f) {
            f3(view);
        } else {
            cVar.f6795e.z(view);
        }
    }

    public final void o3(int i10) {
        p pVar = this.f6767y;
        pVar.f7172e = i10;
        pVar.f7171d = this.A != (i10 == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p1(RecyclerView recyclerView, int i10, int i11, Object obj) {
        W2(i10, i11, 4);
    }

    public final int p2(int i10) {
        if (Y() == 0) {
            return this.A ? 1 : -1;
        }
        return (i10 < L2()) != this.A ? -1 : 1;
    }

    public void p3(int i10) {
        if (i10 != 0 && i10 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        q(null);
        if (i10 == this.f6765w) {
            return;
        }
        this.f6765w = i10;
        w wVar = this.f6761u;
        this.f6761u = this.f6762v;
        this.f6762v = wVar;
        N1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void q(String str) {
        if (this.C1 == null) {
            super.q(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void q1(RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        c3(wVar, b0Var, true);
    }

    public boolean q2() {
        int iL2;
        int iN2;
        if (Y() == 0 || this.K0 == 0 || !G0()) {
            return false;
        }
        if (this.A) {
            iL2 = N2();
            iN2 = L2();
        } else {
            iL2 = L2();
            iN2 = N2();
        }
        if (iL2 == 0 && X2() != null) {
            this.f6757k0.b();
            O1();
            N1();
            return true;
        }
        if (!this.K2) {
            return false;
        }
        int i10 = this.A ? -1 : 1;
        int i11 = iN2 + 1;
        LazySpanLookup.FullSpanItem fullSpanItemE = this.f6757k0.e(iL2, i11, i10, true);
        if (fullSpanItemE == null) {
            this.K2 = false;
            this.f6757k0.d(i11);
            return false;
        }
        LazySpanLookup.FullSpanItem fullSpanItemE2 = this.f6757k0.e(iL2, fullSpanItemE.f6772a, i10 * (-1), true);
        if (fullSpanItemE2 == null) {
            this.f6757k0.d(fullSpanItemE.f6772a);
        } else {
            this.f6757k0.d(fullSpanItemE2.f6772a + 1);
        }
        O1();
        N1();
        return true;
    }

    public void q3(boolean z10) {
        q(null);
        SavedState savedState = this.C1;
        if (savedState != null && savedState.f6783h != z10) {
            savedState.f6783h = z10;
        }
        this.f6768z = z10;
        N1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void r1(RecyclerView.b0 b0Var) {
        super.r1(b0Var);
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.C1 = null;
        this.C2.c();
    }

    public final boolean r2(d dVar) {
        if (this.A) {
            if (dVar.p() < this.f6761u.i()) {
                ArrayList<View> arrayList = dVar.f6798a;
                return !dVar.s(arrayList.get(arrayList.size() - 1)).f6796f;
            }
        } else if (dVar.t() > this.f6761u.n()) {
            return !dVar.s(dVar.f6798a.get(0)).f6796f;
        }
        return false;
    }

    public void r3(int i10) {
        q(null);
        if (i10 != this.f6759s) {
            Y2();
            this.f6759s = i10;
            this.B = new BitSet(this.f6759s);
            this.f6760t = new d[this.f6759s];
            for (int i11 = 0; i11 < this.f6759s; i11++) {
                this.f6760t[i11] = new d(i11);
            }
            N1();
        }
    }

    public final int s2(RecyclerView.b0 b0Var) {
        if (Y() == 0) {
            return 0;
        }
        return z.a(b0Var, this.f6761u, D2(!this.E7), C2(!this.E7), this, this.E7);
    }

    public final void s3(int i10, int i11) {
        for (int i12 = 0; i12 < this.f6759s; i12++) {
            if (!this.f6760t[i12].f6798a.isEmpty()) {
                y3(this.f6760t[i12], i10, i11);
            }
        }
    }

    public final int t2(RecyclerView.b0 b0Var) {
        if (Y() == 0) {
            return 0;
        }
        return z.b(b0Var, this.f6761u, D2(!this.E7), C2(!this.E7), this, this.E7, this.A);
    }

    public final boolean t3(RecyclerView.b0 b0Var, b bVar) {
        bVar.f6787a = this.f6758k1 ? H2(b0Var.d()) : B2(b0Var.d());
        bVar.f6788b = Integer.MIN_VALUE;
        return true;
    }

    public final int u2(RecyclerView.b0 b0Var) {
        if (Y() == 0) {
            return 0;
        }
        return z.c(b0Var, this.f6761u, D2(!this.E7), C2(!this.E7), this, this.E7);
    }

    public boolean u3(RecyclerView.b0 b0Var, b bVar) {
        int i10;
        if (!b0Var.j() && (i10 = this.C) != -1) {
            if (i10 >= 0 && i10 < b0Var.d()) {
                SavedState savedState = this.C1;
                if (savedState == null || savedState.f6776a == -1 || savedState.f6778c < 1) {
                    View viewR = R(this.C);
                    if (viewR != null) {
                        bVar.f6787a = this.A ? N2() : L2();
                        if (this.D != Integer.MIN_VALUE) {
                            if (bVar.f6789c) {
                                bVar.f6788b = (this.f6761u.i() - this.D) - this.f6761u.d(viewR);
                            } else {
                                bVar.f6788b = (this.f6761u.n() + this.D) - this.f6761u.g(viewR);
                            }
                            return true;
                        }
                        if (this.f6761u.e(viewR) > this.f6761u.o()) {
                            bVar.f6788b = bVar.f6789c ? this.f6761u.i() : this.f6761u.n();
                            return true;
                        }
                        int iG = this.f6761u.g(viewR) - this.f6761u.n();
                        if (iG < 0) {
                            bVar.f6788b = -iG;
                            return true;
                        }
                        int i11 = this.f6761u.i() - this.f6761u.d(viewR);
                        if (i11 < 0) {
                            bVar.f6788b = i11;
                            return true;
                        }
                        bVar.f6788b = Integer.MIN_VALUE;
                    } else {
                        int i12 = this.C;
                        bVar.f6787a = i12;
                        int i13 = this.D;
                        if (i13 == Integer.MIN_VALUE) {
                            bVar.f6789c = p2(i12) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i13);
                        }
                        bVar.f6790d = true;
                    }
                } else {
                    bVar.f6788b = Integer.MIN_VALUE;
                    bVar.f6787a = this.C;
                }
                return true;
            }
            this.C = -1;
            this.D = Integer.MIN_VALUE;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean v() {
        return this.f6765w == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void v1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.C1 = (SavedState) parcelable;
            N1();
        }
    }

    public final int v2(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 17 ? i10 != 33 ? i10 != 66 ? (i10 == 130 && this.f6765w == 1) ? 1 : Integer.MIN_VALUE : this.f6765w == 0 ? 1 : Integer.MIN_VALUE : this.f6765w == 1 ? -1 : Integer.MIN_VALUE : this.f6765w == 0 ? -1 : Integer.MIN_VALUE : (this.f6765w != 1 && Z2()) ? -1 : 1 : (this.f6765w != 1 && Z2()) ? 1 : -1;
    }

    public void v3(RecyclerView.b0 b0Var, b bVar) {
        if (u3(b0Var, bVar) || t3(b0Var, bVar)) {
            return;
        }
        bVar.a();
        bVar.f6787a = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean w() {
        return this.f6765w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable w1() {
        int iU;
        int iN;
        int[] iArr;
        if (this.C1 != null) {
            return new SavedState(this.C1);
        }
        SavedState savedState = new SavedState();
        savedState.f6783h = this.f6768z;
        savedState.f6784i = this.f6758k1;
        savedState.f6785j = this.f6763v1;
        LazySpanLookup lazySpanLookup = this.f6757k0;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f6770a) == null) {
            savedState.f6780e = 0;
        } else {
            savedState.f6781f = iArr;
            savedState.f6780e = iArr.length;
            savedState.f6782g = lazySpanLookup.f6771b;
        }
        if (Y() > 0) {
            savedState.f6776a = this.f6758k1 ? N2() : L2();
            savedState.f6777b = E2();
            int i10 = this.f6759s;
            savedState.f6778c = i10;
            savedState.f6779d = new int[i10];
            for (int i11 = 0; i11 < this.f6759s; i11++) {
                if (this.f6758k1) {
                    iU = this.f6760t[i11].q(Integer.MIN_VALUE);
                    if (iU != Integer.MIN_VALUE) {
                        iN = this.f6761u.i();
                        iU -= iN;
                    }
                } else {
                    iU = this.f6760t[i11].u(Integer.MIN_VALUE);
                    if (iU != Integer.MIN_VALUE) {
                        iN = this.f6761u.n();
                        iU -= iN;
                    }
                }
                savedState.f6779d[i11] = iU;
            }
        } else {
            savedState.f6776a = -1;
            savedState.f6777b = -1;
            savedState.f6778c = 0;
        }
        return savedState;
    }

    public final LazySpanLookup.FullSpanItem w2(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f6774c = new int[this.f6759s];
        for (int i11 = 0; i11 < this.f6759s; i11++) {
            fullSpanItem.f6774c[i11] = i10 - this.f6760t[i11].q(i10);
        }
        return fullSpanItem;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w3(int r5, androidx.recyclerview.widget.RecyclerView.b0 r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.p r0 = r4.f6767y
            r1 = 0
            r0.f7169b = r1
            r0.f7170c = r5
            boolean r0 = r4.O0()
            r2 = 1
            if (r0 == 0) goto L2e
            int r6 = r6.g()
            r0 = -1
            if (r6 == r0) goto L2e
            boolean r0 = r4.A
            if (r6 >= r5) goto L1b
            r5 = 1
            goto L1c
        L1b:
            r5 = 0
        L1c:
            if (r0 != r5) goto L25
            androidx.recyclerview.widget.w r5 = r4.f6761u
            int r5 = r5.o()
            goto L2f
        L25:
            androidx.recyclerview.widget.w r5 = r4.f6761u
            int r5 = r5.o()
            r6 = r5
            r5 = 0
            goto L30
        L2e:
            r5 = 0
        L2f:
            r6 = 0
        L30:
            boolean r0 = r4.c0()
            if (r0 == 0) goto L4d
            androidx.recyclerview.widget.p r0 = r4.f6767y
            androidx.recyclerview.widget.w r3 = r4.f6761u
            int r3 = r3.n()
            int r3 = r3 - r6
            r0.f7173f = r3
            androidx.recyclerview.widget.p r6 = r4.f6767y
            androidx.recyclerview.widget.w r0 = r4.f6761u
            int r0 = r0.i()
            int r0 = r0 + r5
            r6.f7174g = r0
            goto L5d
        L4d:
            androidx.recyclerview.widget.p r0 = r4.f6767y
            androidx.recyclerview.widget.w r3 = r4.f6761u
            int r3 = r3.h()
            int r3 = r3 + r5
            r0.f7174g = r3
            androidx.recyclerview.widget.p r5 = r4.f6767y
            int r6 = -r6
            r5.f7173f = r6
        L5d:
            androidx.recyclerview.widget.p r5 = r4.f6767y
            r5.f7175h = r1
            r5.f7168a = r2
            androidx.recyclerview.widget.w r6 = r4.f6761u
            int r6 = r6.l()
            if (r6 != 0) goto L74
            androidx.recyclerview.widget.w r6 = r4.f6761u
            int r6 = r6.h()
            if (r6 != 0) goto L74
            r1 = 1
        L74:
            r5.f7176i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.w3(int, androidx.recyclerview.widget.RecyclerView$b0):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean x(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int x0(RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        return this.f6765w == 0 ? this.f6759s : super.x0(wVar, b0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x1(int i10) {
        if (i10 == 0) {
            q2();
        }
    }

    public final LazySpanLookup.FullSpanItem x2(int i10) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f6774c = new int[this.f6759s];
        for (int i11 = 0; i11 < this.f6759s; i11++) {
            fullSpanItem.f6774c[i11] = this.f6760t[i11].u(i10) - i10;
        }
        return fullSpanItem;
    }

    public void x3(int i10) {
        this.f6766x = i10 / this.f6759s;
        this.K1 = View.MeasureSpec.makeMeasureSpec(i10, this.f6762v.l());
    }

    public final void y2() {
        this.f6761u = w.b(this, this.f6765w);
        this.f6762v = w.b(this, 1 - this.f6765w);
    }

    public final void y3(d dVar, int i10, int i11) {
        int iO = dVar.o();
        if (i10 == -1) {
            if (dVar.t() + iO <= i11) {
                this.B.set(dVar.f6802e, false);
            }
        } else if (dVar.p() - iO >= i11) {
            this.B.set(dVar.f6802e, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void z(int i10, int i11, RecyclerView.b0 b0Var, RecyclerView.o.c cVar) {
        int iQ;
        int iU;
        if (this.f6765w != 0) {
            i10 = i11;
        }
        if (Y() == 0 || i10 == 0) {
            return;
        }
        e3(i10, b0Var);
        int[] iArr = this.F7;
        if (iArr == null || iArr.length < this.f6759s) {
            this.F7 = new int[this.f6759s];
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.f6759s; i13++) {
            p pVar = this.f6767y;
            if (pVar.f7171d == -1) {
                iQ = pVar.f7173f;
                iU = this.f6760t[i13].u(iQ);
            } else {
                iQ = this.f6760t[i13].q(pVar.f7174g);
                iU = this.f6767y.f7174g;
            }
            int i14 = iQ - iU;
            if (i14 >= 0) {
                this.F7[i12] = i14;
                i12++;
            }
        }
        Arrays.sort(this.F7, 0, i12);
        for (int i15 = 0; i15 < i12 && this.f6767y.a(b0Var); i15++) {
            cVar.a(this.f6767y.f7170c, this.F7[i15]);
            p pVar2 = this.f6767y;
            pVar2.f7170c += pVar2.f7171d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    public final int z2(RecyclerView.w wVar, p pVar, RecyclerView.b0 b0Var) {
        int i10;
        d dVarS2;
        int iE;
        int i11;
        int iE2;
        int iE3;
        ?? r92 = 0;
        this.B.set(0, this.f6759s, true);
        if (this.f6767y.f7176i) {
            i10 = pVar.f7172e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i10 = pVar.f7172e == 1 ? pVar.f7174g + pVar.f7169b : pVar.f7173f - pVar.f7169b;
        }
        s3(pVar.f7172e, i10);
        int i12 = this.A ? this.f6761u.i() : this.f6761u.n();
        boolean z10 = false;
        while (pVar.a(b0Var) && (this.f6767y.f7176i || !this.B.isEmpty())) {
            View viewB = pVar.b(wVar);
            c cVar = (c) viewB.getLayoutParams();
            int iB = cVar.b();
            int iG = this.f6757k0.g(iB);
            boolean z11 = iG == -1;
            if (z11) {
                dVarS2 = cVar.f6796f ? this.f6760t[r92] : S2(pVar);
                this.f6757k0.n(iB, dVarS2);
            } else {
                dVarS2 = this.f6760t[iG];
            }
            d dVar = dVarS2;
            cVar.f6795e = dVar;
            if (pVar.f7172e == 1) {
                addView(viewB);
            } else {
                addView(viewB, r92);
            }
            b3(viewB, cVar, r92);
            if (pVar.f7172e == 1) {
                int iO2 = cVar.f6796f ? O2(i12) : dVar.q(i12);
                int iE4 = this.f6761u.e(viewB) + iO2;
                if (z11 && cVar.f6796f) {
                    LazySpanLookup.FullSpanItem fullSpanItemW2 = w2(iO2);
                    fullSpanItemW2.f6773b = -1;
                    fullSpanItemW2.f6772a = iB;
                    this.f6757k0.a(fullSpanItemW2);
                }
                i11 = iE4;
                iE = iO2;
            } else {
                int iR2 = cVar.f6796f ? R2(i12) : dVar.u(i12);
                iE = iR2 - this.f6761u.e(viewB);
                if (z11 && cVar.f6796f) {
                    LazySpanLookup.FullSpanItem fullSpanItemX2 = x2(iR2);
                    fullSpanItemX2.f6773b = 1;
                    fullSpanItemX2.f6772a = iB;
                    this.f6757k0.a(fullSpanItemX2);
                }
                i11 = iR2;
            }
            if (cVar.f6796f && pVar.f7171d == -1) {
                if (z11) {
                    this.K2 = true;
                } else {
                    if (!(pVar.f7172e == 1 ? m2() : n2())) {
                        LazySpanLookup.FullSpanItem fullSpanItemF = this.f6757k0.f(iB);
                        if (fullSpanItemF != null) {
                            fullSpanItemF.f6775d = true;
                        }
                        this.K2 = true;
                    }
                }
            }
            o2(viewB, cVar, pVar);
            if (Z2() && this.f6765w == 1) {
                int i13 = cVar.f6796f ? this.f6762v.i() : this.f6762v.i() - (((this.f6759s - 1) - dVar.f6802e) * this.f6766x);
                iE3 = i13;
                iE2 = i13 - this.f6762v.e(viewB);
            } else {
                int iN = cVar.f6796f ? this.f6762v.n() : (dVar.f6802e * this.f6766x) + this.f6762v.n();
                iE2 = iN;
                iE3 = this.f6762v.e(viewB) + iN;
            }
            if (this.f6765w == 1) {
                R0(viewB, iE2, iE, iE3, i11);
            } else {
                R0(viewB, iE, iE2, i11, iE3);
            }
            if (cVar.f6796f) {
                s3(this.f6767y.f7172e, i10);
            } else {
                y3(dVar, this.f6767y.f7172e, i10);
            }
            g3(wVar, this.f6767y);
            if (this.f6767y.f7175h && viewB.hasFocusable()) {
                if (cVar.f6796f) {
                    this.B.clear();
                } else {
                    this.B.set(dVar.f6802e, false);
                }
            }
            z10 = true;
            r92 = 0;
        }
        if (!z10) {
            g3(wVar, this.f6767y);
        }
        int iN2 = this.f6767y.f7172e == -1 ? this.f6761u.n() - R2(this.f6761u.n()) : O2(this.f6761u.i()) - this.f6761u.i();
        if (iN2 > 0) {
            return Math.min(pVar.f7169b, iN2);
        }
        return 0;
    }

    public final int z3(int i10, int i11, int i12) {
        if (i11 == 0 && i12 == 0) {
            return i10;
        }
        int mode = View.MeasureSpec.getMode(i10);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i10) - i11) - i12), mode) : i10;
    }

    public static class LazySpanLookup {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6769c = 10;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f6770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<FullSpanItem> f6771b;

        public void a(FullSpanItem fullSpanItem) {
            if (this.f6771b == null) {
                this.f6771b = new ArrayList();
            }
            int size = this.f6771b.size();
            for (int i10 = 0; i10 < size; i10++) {
                FullSpanItem fullSpanItem2 = this.f6771b.get(i10);
                if (fullSpanItem2.f6772a == fullSpanItem.f6772a) {
                    this.f6771b.remove(i10);
                }
                if (fullSpanItem2.f6772a >= fullSpanItem.f6772a) {
                    this.f6771b.add(i10, fullSpanItem);
                    return;
                }
            }
            this.f6771b.add(fullSpanItem);
        }

        public void b() {
            int[] iArr = this.f6770a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f6771b = null;
        }

        public void c(int i10) {
            int[] iArr = this.f6770a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i10, 10) + 1];
                this.f6770a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i10 >= iArr.length) {
                int[] iArr3 = new int[o(i10)];
                this.f6770a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f6770a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int d(int i10) {
            List<FullSpanItem> list = this.f6771b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f6771b.get(size).f6772a >= i10) {
                        this.f6771b.remove(size);
                    }
                }
            }
            return h(i10);
        }

        public FullSpanItem e(int i10, int i11, int i12, boolean z10) {
            List<FullSpanItem> list = this.f6771b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                FullSpanItem fullSpanItem = this.f6771b.get(i13);
                int i14 = fullSpanItem.f6772a;
                if (i14 >= i11) {
                    return null;
                }
                if (i14 >= i10 && (i12 == 0 || fullSpanItem.f6773b == i12 || (z10 && fullSpanItem.f6775d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem f(int i10) {
            List<FullSpanItem> list = this.f6771b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f6771b.get(size);
                if (fullSpanItem.f6772a == i10) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public int g(int i10) {
            int[] iArr = this.f6770a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            return iArr[i10];
        }

        public int h(int i10) {
            int[] iArr = this.f6770a;
            if (iArr == null || i10 >= iArr.length) {
                return -1;
            }
            int i11 = i(i10);
            if (i11 == -1) {
                int[] iArr2 = this.f6770a;
                Arrays.fill(iArr2, i10, iArr2.length, -1);
                return this.f6770a.length;
            }
            int i12 = i11 + 1;
            Arrays.fill(this.f6770a, i10, i12, -1);
            return i12;
        }

        public final int i(int i10) {
            if (this.f6771b == null) {
                return -1;
            }
            FullSpanItem fullSpanItemF = f(i10);
            if (fullSpanItemF != null) {
                this.f6771b.remove(fullSpanItemF);
            }
            int size = this.f6771b.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    i11 = -1;
                    break;
                }
                if (this.f6771b.get(i11).f6772a >= i10) {
                    break;
                }
                i11++;
            }
            if (i11 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = this.f6771b.get(i11);
            this.f6771b.remove(i11);
            return fullSpanItem.f6772a;
        }

        public void j(int i10, int i11) {
            int[] iArr = this.f6770a;
            if (iArr == null || i10 >= iArr.length) {
                return;
            }
            int i12 = i10 + i11;
            c(i12);
            int[] iArr2 = this.f6770a;
            System.arraycopy(iArr2, i10, iArr2, i12, (iArr2.length - i10) - i11);
            Arrays.fill(this.f6770a, i10, i12, -1);
            l(i10, i11);
        }

        public void k(int i10, int i11) {
            int[] iArr = this.f6770a;
            if (iArr == null || i10 >= iArr.length) {
                return;
            }
            int i12 = i10 + i11;
            c(i12);
            int[] iArr2 = this.f6770a;
            System.arraycopy(iArr2, i12, iArr2, i10, (iArr2.length - i10) - i11);
            int[] iArr3 = this.f6770a;
            Arrays.fill(iArr3, iArr3.length - i11, iArr3.length, -1);
            m(i10, i11);
        }

        public final void l(int i10, int i11) {
            List<FullSpanItem> list = this.f6771b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f6771b.get(size);
                int i12 = fullSpanItem.f6772a;
                if (i12 >= i10) {
                    fullSpanItem.f6772a = i12 + i11;
                }
            }
        }

        public final void m(int i10, int i11) {
            List<FullSpanItem> list = this.f6771b;
            if (list == null) {
                return;
            }
            int i12 = i10 + i11;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f6771b.get(size);
                int i13 = fullSpanItem.f6772a;
                if (i13 >= i10) {
                    if (i13 < i12) {
                        this.f6771b.remove(size);
                    } else {
                        fullSpanItem.f6772a = i13 - i11;
                    }
                }
            }
        }

        public void n(int i10, d dVar) {
            c(i10);
            this.f6770a[i10] = dVar.f6802e;
        }

        public int o(int i10) {
            int length = this.f6770a.length;
            while (length <= i10) {
                length *= 2;
            }
            return length;
        }

        @SuppressLint({"BanParcelableUsage"})
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6772a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f6773b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int[] f6774c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f6775d;

            public static class a implements Parcelable.Creator<FullSpanItem> {
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public FullSpanItem[] newArray(int i10) {
                    return new FullSpanItem[i10];
                }
            }

            public FullSpanItem(Parcel parcel) {
                this.f6772a = parcel.readInt();
                this.f6773b = parcel.readInt();
                this.f6775d = parcel.readInt() == 1;
                int i10 = parcel.readInt();
                if (i10 > 0) {
                    int[] iArr = new int[i10];
                    this.f6774c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int a(int i10) {
                int[] iArr = this.f6774c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i10];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f6772a + ", mGapDir=" + this.f6773b + ", mHasUnwantedGapAfter=" + this.f6775d + ", mGapPerSpan=" + Arrays.toString(this.f6774c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                parcel.writeInt(this.f6772a);
                parcel.writeInt(this.f6773b);
                parcel.writeInt(this.f6775d ? 1 : 0);
                int[] iArr = this.f6774c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f6774c);
                }
            }

            public FullSpanItem() {
            }
        }
    }

    public StaggeredGridLayoutManager(int i10, int i11) {
        this.f6765w = i11;
        r3(i10);
        this.f6767y = new p();
        y2();
    }
}
