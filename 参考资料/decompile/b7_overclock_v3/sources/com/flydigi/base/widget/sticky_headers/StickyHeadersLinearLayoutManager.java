package com.flydigi.base.widget.sticky_headers;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.g;
import com.flydigi.base.widget.sticky_headers.a;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class StickyHeadersLinearLayoutManager<T extends RecyclerView.g & com.flydigi.base.widget.sticky_headers.a> extends LinearLayoutManager {
    public T F7;
    public float G7;
    public float H7;
    public final List<Integer> I7;
    public final RecyclerView.i J7;
    public View K7;
    public int L7;
    public int M7;
    public int N7;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Parcelable f13669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13671c;

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
        public void writeToParcel(@n0 Parcel parcel, int i10) {
            parcel.writeParcelable(this.f13669a, i10);
            parcel.writeInt(this.f13670b);
            parcel.writeInt(this.f13671c);
        }

        public SavedState(Parcel parcel) {
            this.f13669a = parcel.readParcelable(SavedState.class.getClassLoader());
            this.f13670b = parcel.readInt();
            this.f13671c = parcel.readInt();
        }
    }

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f13672a;

        public a(ViewTreeObserver viewTreeObserver) {
            this.f13672a = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f13672a.removeOnGlobalLayoutListener(this);
            if (StickyHeadersLinearLayoutManager.this.M7 != -1) {
                StickyHeadersLinearLayoutManager stickyHeadersLinearLayoutManager = StickyHeadersLinearLayoutManager.this;
                stickyHeadersLinearLayoutManager.h3(stickyHeadersLinearLayoutManager.M7, StickyHeadersLinearLayoutManager.this.N7);
                StickyHeadersLinearLayoutManager.this.X3(-1, Integer.MIN_VALUE);
            }
        }
    }

    public class b extends RecyclerView.i {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            StickyHeadersLinearLayoutManager.this.I7.clear();
            int itemCount = StickyHeadersLinearLayoutManager.this.F7.getItemCount();
            for (int i10 = 0; i10 < itemCount; i10++) {
                if (((com.flydigi.base.widget.sticky_headers.a) StickyHeadersLinearLayoutManager.this.F7).a(i10)) {
                    StickyHeadersLinearLayoutManager.this.I7.add(Integer.valueOf(i10));
                }
            }
            if (StickyHeadersLinearLayoutManager.this.K7 == null || StickyHeadersLinearLayoutManager.this.I7.contains(Integer.valueOf(StickyHeadersLinearLayoutManager.this.L7))) {
                return;
            }
            StickyHeadersLinearLayoutManager.this.U3(null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void d(int i10, int i11) {
            int size = StickyHeadersLinearLayoutManager.this.I7.size();
            if (size > 0) {
                for (int iN3 = StickyHeadersLinearLayoutManager.this.N3(i10); iN3 != -1 && iN3 < size; iN3++) {
                    StickyHeadersLinearLayoutManager.this.I7.set(iN3, Integer.valueOf(((Integer) StickyHeadersLinearLayoutManager.this.I7.get(iN3)).intValue() + i11));
                }
            }
            for (int i12 = i10; i12 < i10 + i11; i12++) {
                if (((com.flydigi.base.widget.sticky_headers.a) StickyHeadersLinearLayoutManager.this.F7).a(i12)) {
                    int iN32 = StickyHeadersLinearLayoutManager.this.N3(i12);
                    if (iN32 != -1) {
                        StickyHeadersLinearLayoutManager.this.I7.add(iN32, Integer.valueOf(i12));
                    } else {
                        StickyHeadersLinearLayoutManager.this.I7.add(Integer.valueOf(i12));
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void e(int i10, int i11, int i12) {
            int size = StickyHeadersLinearLayoutManager.this.I7.size();
            if (size > 0) {
                if (i10 < i11) {
                    for (int iN3 = StickyHeadersLinearLayoutManager.this.N3(i10); iN3 != -1 && iN3 < size; iN3++) {
                        int iIntValue = ((Integer) StickyHeadersLinearLayoutManager.this.I7.get(iN3)).intValue();
                        if (iIntValue >= i10 && iIntValue < i10 + i12) {
                            StickyHeadersLinearLayoutManager.this.I7.set(iN3, Integer.valueOf(iIntValue - (i11 - i10)));
                            g(iN3);
                        } else {
                            if (iIntValue < i10 + i12 || iIntValue > i11) {
                                return;
                            }
                            StickyHeadersLinearLayoutManager.this.I7.set(iN3, Integer.valueOf(iIntValue - i12));
                            g(iN3);
                        }
                    }
                    return;
                }
                for (int iN32 = StickyHeadersLinearLayoutManager.this.N3(i11); iN32 != -1 && iN32 < size; iN32++) {
                    int iIntValue2 = ((Integer) StickyHeadersLinearLayoutManager.this.I7.get(iN32)).intValue();
                    if (iIntValue2 >= i10 && iIntValue2 < i10 + i12) {
                        StickyHeadersLinearLayoutManager.this.I7.set(iN32, Integer.valueOf(iIntValue2 + (i11 - i10)));
                        g(iN32);
                    } else {
                        if (iIntValue2 < i11 || iIntValue2 > i10) {
                            return;
                        }
                        StickyHeadersLinearLayoutManager.this.I7.set(iN32, Integer.valueOf(iIntValue2 + i12));
                        g(iN32);
                    }
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void f(int i10, int i11) {
            int size = StickyHeadersLinearLayoutManager.this.I7.size();
            if (size > 0) {
                int i12 = i10 + i11;
                for (int i13 = i12 - 1; i13 >= i10; i13--) {
                    int iL3 = StickyHeadersLinearLayoutManager.this.L3(i13);
                    if (iL3 != -1) {
                        StickyHeadersLinearLayoutManager.this.I7.remove(iL3);
                        size--;
                    }
                }
                if (StickyHeadersLinearLayoutManager.this.K7 != null && !StickyHeadersLinearLayoutManager.this.I7.contains(Integer.valueOf(StickyHeadersLinearLayoutManager.this.L7))) {
                    StickyHeadersLinearLayoutManager.this.U3(null);
                }
                for (int iN3 = StickyHeadersLinearLayoutManager.this.N3(i12); iN3 != -1 && iN3 < size; iN3++) {
                    StickyHeadersLinearLayoutManager.this.I7.set(iN3, Integer.valueOf(((Integer) StickyHeadersLinearLayoutManager.this.I7.get(iN3)).intValue() - i11));
                }
            }
        }

        public final void g(int i10) {
            int iIntValue = ((Integer) StickyHeadersLinearLayoutManager.this.I7.remove(i10)).intValue();
            int iN3 = StickyHeadersLinearLayoutManager.this.N3(iIntValue);
            if (iN3 != -1) {
                StickyHeadersLinearLayoutManager.this.I7.add(iN3, Integer.valueOf(iIntValue));
            } else {
                StickyHeadersLinearLayoutManager.this.I7.add(Integer.valueOf(iIntValue));
            }
        }

        public /* synthetic */ b(StickyHeadersLinearLayoutManager stickyHeadersLinearLayoutManager, a aVar) {
            this();
        }
    }

    public StickyHeadersLinearLayoutManager(Context context) {
        super(context);
        this.I7 = new ArrayList(0);
        this.J7 = new b(this, null);
        this.L7 = -1;
        this.M7 = -1;
        this.N7 = 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int B(RecyclerView.b0 b0Var) {
        K3();
        int iB = super.B(b0Var);
        H3();
        return iB;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int C(RecyclerView.b0 b0Var) {
        K3();
        int iC = super.C(b0Var);
        H3();
        return iC;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int D(RecyclerView.b0 b0Var) {
        K3();
        int iD = super.D(b0Var);
        H3();
        return iD;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int E(RecyclerView.b0 b0Var) {
        K3();
        int iE = super.E(b0Var);
        H3();
        return iE;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int F(RecyclerView.b0 b0Var) {
        K3();
        int iF = super.F(b0Var);
        H3();
        return iF;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int G(RecyclerView.b0 b0Var) {
        K3();
        int iG = super.G(b0Var);
        H3();
        return iG;
    }

    public final void H3() {
        View view = this.K7;
        if (view != null) {
            r(view);
        }
    }

    public final void I3(@n0 RecyclerView.w wVar, int i10) {
        wVar.c(this.K7, i10);
        this.L7 = i10;
        T3(this.K7);
        if (this.M7 != -1) {
            ViewTreeObserver viewTreeObserver = this.K7.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new a(viewTreeObserver));
        }
    }

    public final void J3(@n0 RecyclerView.w wVar, int i10) {
        View viewP = wVar.p(i10);
        T t10 = this.F7;
        if (t10 instanceof a.InterfaceC0133a) {
            ((a.InterfaceC0133a) t10).a(viewP);
        }
        addView(viewP);
        T3(viewP);
        F0(viewP);
        this.K7 = viewP;
        this.L7 = i10;
    }

    public final void K3() {
        View view = this.K7;
        if (view != null) {
            K(view);
        }
    }

    public final int L3(int i10) {
        int size = this.I7.size() - 1;
        int i11 = 0;
        while (i11 <= size) {
            int i12 = (i11 + size) / 2;
            if (this.I7.get(i12).intValue() > i10) {
                size = i12 - 1;
            } else {
                if (this.I7.get(i12).intValue() >= i10) {
                    return i12;
                }
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    public final int M3(int i10) {
        int size = this.I7.size() - 1;
        int i11 = 0;
        while (i11 <= size) {
            int i12 = (i11 + size) / 2;
            if (this.I7.get(i12).intValue() <= i10) {
                if (i12 < this.I7.size() - 1) {
                    int i13 = i12 + 1;
                    if (this.I7.get(i13).intValue() <= i10) {
                        i11 = i13;
                    }
                }
                return i12;
            }
            size = i12 - 1;
        }
        return -1;
    }

    public final int N3(int i10) {
        int size = this.I7.size() - 1;
        int i11 = 0;
        while (i11 <= size) {
            int i12 = (i11 + size) / 2;
            if (i12 > 0) {
                int i13 = i12 - 1;
                if (this.I7.get(i13).intValue() >= i10) {
                    size = i13;
                }
            }
            if (this.I7.get(i12).intValue() >= i10) {
                return i12;
            }
            i11 = i12 + 1;
        }
        return -1;
    }

    public final float O3(View view, View view2) {
        if (Q2() == 1) {
            return this.G7;
        }
        float fB0 = this.G7;
        if (S2()) {
            fB0 += B0() - view.getWidth();
        }
        return view2 != null ? S2() ? Math.max(view2.getRight(), fB0) : Math.min(view2.getLeft() - view.getWidth(), fB0) : fB0;
    }

    public final float P3(View view, View view2) {
        if (Q2() != 1) {
            return this.H7;
        }
        float fM0 = this.H7;
        if (S2()) {
            fM0 += m0() - view.getHeight();
        }
        return view2 != null ? S2() ? Math.max(view2.getBottom(), fM0) : Math.min(view2.getTop() - view.getHeight(), fM0) : fM0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int Q1(int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        K3();
        int iQ1 = super.Q1(i10, wVar, b0Var);
        H3();
        if (iQ1 != 0) {
            a4(wVar, false);
        }
        return iQ1;
    }

    public boolean Q3(View view) {
        return view == this.K7;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void R1(int i10) {
        h3(i10, Integer.MIN_VALUE);
    }

    public final boolean R3(View view) {
        return Q2() == 1 ? S2() ? ((float) view.getBottom()) - view.getTranslationY() > ((float) m0()) + this.H7 : ((float) view.getTop()) + view.getTranslationY() < this.H7 : S2() ? ((float) view.getRight()) - view.getTranslationX() > ((float) B0()) + this.G7 : ((float) view.getLeft()) + view.getTranslationX() < this.G7;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int S1(int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        K3();
        int iS1 = super.S1(i10, wVar, b0Var);
        H3();
        if (iS1 != 0) {
            a4(wVar, false);
        }
        return iS1;
    }

    public final boolean S3(View view, RecyclerView.p pVar) {
        if (pVar.j() || pVar.s()) {
            return false;
        }
        return Q2() == 1 ? S2() ? ((float) view.getTop()) + view.getTranslationY() <= ((float) m0()) + this.H7 : ((float) view.getBottom()) - view.getTranslationY() >= this.H7 : S2() ? ((float) view.getLeft()) + view.getTranslationX() <= ((float) B0()) + this.G7 : ((float) view.getRight()) - view.getTranslationX() >= this.G7;
    }

    public final void T3(View view) {
        T0(view, 0, 0);
        if (Q2() == 1) {
            view.layout(getPaddingLeft(), 0, B0() - getPaddingRight(), view.getMeasuredHeight());
        } else {
            view.layout(0, getPaddingTop(), view.getMeasuredWidth(), m0() - getPaddingBottom());
        }
    }

    public final void U3(@p0 RecyclerView.w wVar) {
        View view = this.K7;
        this.K7 = null;
        this.L7 = -1;
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        T t10 = this.F7;
        if (t10 instanceof a.InterfaceC0133a) {
            ((a.InterfaceC0133a) t10).b(view);
        }
        h2(view);
        K1(view);
        if (wVar != null) {
            wVar.C(view);
        }
    }

    public final void V3(int i10, int i11, boolean z10) {
        X3(-1, Integer.MIN_VALUE);
        if (!z10) {
            super.h3(i10, i11);
            return;
        }
        int iM3 = M3(i10);
        if (iM3 == -1 || L3(i10) != -1) {
            super.h3(i10, i11);
            return;
        }
        int i12 = i10 - 1;
        if (L3(i12) != -1) {
            super.h3(i12, i11);
            return;
        }
        if (this.K7 == null || iM3 != L3(this.L7)) {
            X3(i10, i11);
            super.h3(i10, i11);
        } else {
            if (i11 == Integer.MIN_VALUE) {
                i11 = 0;
            }
            super.h3(i10, i11 + this.K7.getHeight());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W3(RecyclerView.g gVar) {
        T t10 = this.F7;
        if (t10 != null) {
            t10.unregisterAdapterDataObserver(this.J7);
        }
        if (!(gVar instanceof com.flydigi.base.widget.sticky_headers.a)) {
            this.F7 = null;
            this.I7.clear();
        } else {
            this.F7 = gVar;
            gVar.registerAdapterDataObserver(this.J7);
            this.J7.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.g gVar, RecyclerView.g gVar2) {
        super.X0(gVar, gVar2);
        W3(gVar2);
    }

    public final void X3(int i10, int i11) {
        this.M7 = i10;
        this.N7 = i11;
    }

    public void Y3(float f10) {
        this.G7 = f10;
        N1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Z0(RecyclerView recyclerView) {
        super.Z0(recyclerView);
        W3(recyclerView.getAdapter());
    }

    public void Z3(float f10) {
        this.H7 = f10;
        N1();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.a0.b
    public PointF a(int i10) {
        K3();
        PointF pointFA = super.a(i10);
        H3();
        return pointFA;
    }

    public final void a4(RecyclerView.w wVar, boolean z10) {
        View view;
        View viewX;
        int iA;
        View viewX2;
        int size = this.I7.size();
        int iY = Y();
        if (size > 0 && iY > 0) {
            int i10 = 0;
            while (true) {
                view = null;
                if (i10 >= iY) {
                    viewX = null;
                    iA = -1;
                    i10 = -1;
                    break;
                } else {
                    viewX = X(i10);
                    RecyclerView.p pVar = (RecyclerView.p) viewX.getLayoutParams();
                    if (S3(viewX, pVar)) {
                        iA = pVar.a();
                        break;
                    }
                    i10++;
                }
            }
            if (viewX != null && iA != -1) {
                int iM3 = M3(iA);
                int iIntValue = iM3 != -1 ? this.I7.get(iM3).intValue() : -1;
                int i11 = iM3 + 1;
                int iIntValue2 = size > i11 ? this.I7.get(i11).intValue() : -1;
                if (iIntValue != -1 && ((iIntValue != iA || R3(viewX)) && iIntValue2 != iIntValue + 1)) {
                    View view2 = this.K7;
                    if (view2 != null && p0(view2) != this.F7.getItemViewType(iIntValue)) {
                        U3(wVar);
                    }
                    if (this.K7 == null) {
                        J3(wVar, iIntValue);
                    }
                    if (z10 || u0(this.K7) != iIntValue) {
                        I3(wVar, iIntValue);
                    }
                    if (iIntValue2 != -1 && (viewX2 = X(i10 + (iIntValue2 - iA))) != this.K7) {
                        view = viewX2;
                    }
                    View view3 = this.K7;
                    view3.setTranslationX(O3(view3, view));
                    View view4 = this.K7;
                    view4.setTranslationY(P3(view4, view));
                    return;
                }
            }
        }
        if (this.K7 != null) {
            U3(wVar);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public View c1(View view, int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        K3();
        View viewC1 = super.c1(view, i10, wVar, b0Var);
        H3();
        return viewC1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void h3(int i10, int i11) {
        V3(i10, i11, true);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void q1(RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        K3();
        super.q1(wVar, b0Var);
        H3();
        if (b0Var.j()) {
            return;
        }
        a4(wVar, true);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void v1(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.M7 = savedState.f13670b;
            this.N7 = savedState.f13671c;
            parcelable = savedState.f13669a;
        }
        super.v1(parcelable);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public Parcelable w1() {
        SavedState savedState = new SavedState();
        savedState.f13669a = super.w1();
        savedState.f13670b = this.M7;
        savedState.f13671c = this.N7;
        return savedState;
    }

    public StickyHeadersLinearLayoutManager(Context context, int i10, boolean z10) {
        super(context, i10, z10);
        this.I7 = new ArrayList(0);
        this.J7 = new b(this, null);
        this.L7 = -1;
        this.M7 = -1;
        this.N7 = 0;
    }
}
