package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a0 extends RecyclerView.l {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final boolean f6825m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f6826n = "SimpleItemAnimator";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f6827l = true;

    public abstract boolean D(RecyclerView.e0 e0Var);

    public abstract boolean E(RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2, int i10, int i11, int i12, int i13);

    public abstract boolean F(RecyclerView.e0 e0Var, int i10, int i11, int i12, int i13);

    public abstract boolean G(RecyclerView.e0 e0Var);

    public final void H(RecyclerView.e0 e0Var) {
        Q(e0Var);
        h(e0Var);
    }

    public final void I(RecyclerView.e0 e0Var) {
        R(e0Var);
    }

    public final void J(RecyclerView.e0 e0Var, boolean z10) {
        S(e0Var, z10);
        h(e0Var);
    }

    public final void K(RecyclerView.e0 e0Var, boolean z10) {
        T(e0Var, z10);
    }

    public final void L(RecyclerView.e0 e0Var) {
        U(e0Var);
        h(e0Var);
    }

    public final void M(RecyclerView.e0 e0Var) {
        V(e0Var);
    }

    public final void N(RecyclerView.e0 e0Var) {
        W(e0Var);
        h(e0Var);
    }

    public final void O(RecyclerView.e0 e0Var) {
        X(e0Var);
    }

    public boolean P() {
        return this.f6827l;
    }

    public void Q(RecyclerView.e0 e0Var) {
    }

    public void R(RecyclerView.e0 e0Var) {
    }

    public void S(RecyclerView.e0 e0Var, boolean z10) {
    }

    public void T(RecyclerView.e0 e0Var, boolean z10) {
    }

    public void U(RecyclerView.e0 e0Var) {
    }

    public void V(RecyclerView.e0 e0Var) {
    }

    public void W(RecyclerView.e0 e0Var) {
    }

    public void X(RecyclerView.e0 e0Var) {
    }

    public void Y(boolean z10) {
        this.f6827l = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(@n0 RecyclerView.e0 e0Var, @p0 RecyclerView.l.d dVar, @n0 RecyclerView.l.d dVar2) {
        int i10;
        int i11;
        return (dVar == null || ((i10 = dVar.f6705a) == (i11 = dVar2.f6705a) && dVar.f6706b == dVar2.f6706b)) ? D(e0Var) : F(e0Var, i10, dVar.f6706b, i11, dVar2.f6706b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean b(@n0 RecyclerView.e0 e0Var, @n0 RecyclerView.e0 e0Var2, @n0 RecyclerView.l.d dVar, @n0 RecyclerView.l.d dVar2) {
        int i10;
        int i11;
        int i12 = dVar.f6705a;
        int i13 = dVar.f6706b;
        if (e0Var2.shouldIgnore()) {
            int i14 = dVar.f6705a;
            i11 = dVar.f6706b;
            i10 = i14;
        } else {
            i10 = dVar2.f6705a;
            i11 = dVar2.f6706b;
        }
        return E(e0Var, e0Var2, i12, i13, i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean c(@n0 RecyclerView.e0 e0Var, @n0 RecyclerView.l.d dVar, @p0 RecyclerView.l.d dVar2) {
        int i10 = dVar.f6705a;
        int i11 = dVar.f6706b;
        View view = e0Var.itemView;
        int left = dVar2 == null ? view.getLeft() : dVar2.f6705a;
        int top2 = dVar2 == null ? view.getTop() : dVar2.f6706b;
        if (e0Var.isRemoved() || (i10 == left && i11 == top2)) {
            return G(e0Var);
        }
        view.layout(left, top2, view.getWidth() + left, view.getHeight() + top2);
        return F(e0Var, i10, i11, left, top2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean d(@n0 RecyclerView.e0 e0Var, @n0 RecyclerView.l.d dVar, @n0 RecyclerView.l.d dVar2) {
        int i10 = dVar.f6705a;
        int i11 = dVar2.f6705a;
        if (i10 != i11 || dVar.f6706b != dVar2.f6706b) {
            return F(e0Var, i10, dVar.f6706b, i11, dVar2.f6706b);
        }
        L(e0Var);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean f(@n0 RecyclerView.e0 e0Var) {
        return !this.f6827l || e0Var.isInvalid();
    }
}
