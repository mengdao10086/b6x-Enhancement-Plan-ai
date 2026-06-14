package a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class fq extends RecyclerView.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f6128a = true;

    public abstract boolean A(RecyclerView.d0 d0Var);

    public final void B(RecyclerView.d0 d0Var) {
        J(d0Var);
        h(d0Var);
    }

    public final void C(RecyclerView.d0 d0Var) {
        K(d0Var);
    }

    public final void D(RecyclerView.d0 d0Var, boolean z) {
        L(d0Var, z);
        h(d0Var);
    }

    public final void E(RecyclerView.d0 d0Var, boolean z) {
        M(d0Var, z);
    }

    public final void F(RecyclerView.d0 d0Var) {
        N(d0Var);
        h(d0Var);
    }

    public final void G(RecyclerView.d0 d0Var) {
        O(d0Var);
    }

    public final void H(RecyclerView.d0 d0Var) {
        P(d0Var);
        h(d0Var);
    }

    public final void I(RecyclerView.d0 d0Var) {
        Q(d0Var);
    }

    public void J(RecyclerView.d0 d0Var) {
    }

    public void K(RecyclerView.d0 d0Var) {
    }

    public void L(RecyclerView.d0 d0Var, boolean z) {
    }

    public void M(RecyclerView.d0 d0Var, boolean z) {
    }

    public void N(RecyclerView.d0 d0Var) {
    }

    public void O(RecyclerView.d0 d0Var) {
    }

    public void P(RecyclerView.d0 d0Var) {
    }

    public void Q(RecyclerView.d0 d0Var) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        return (bVar == null || (bVar.f8233a == bVar2.f8233a && bVar.b == bVar2.b)) ? x(d0Var) : z(d0Var, bVar.f8233a, bVar.b, bVar2.f8233a, bVar2.b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean b(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i;
        int i2;
        int i3 = bVar.f8233a;
        int i4 = bVar.b;
        if (d0Var2.J()) {
            int i5 = bVar.f8233a;
            i2 = bVar.b;
            i = i5;
        } else {
            i = bVar2.f8233a;
            i2 = bVar2.b;
        }
        return y(d0Var, d0Var2, i3, i4, i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean c(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        int i = bVar.f8233a;
        int i2 = bVar.b;
        View view = d0Var.f4387a;
        int left = bVar2 == null ? view.getLeft() : bVar2.f8233a;
        int top = bVar2 == null ? view.getTop() : bVar2.b;
        if (d0Var.v() || (i == left && i2 == top)) {
            return A(d0Var);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return z(d0Var, i, i2, left, top);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean d(RecyclerView.d0 d0Var, RecyclerView.l.b bVar, RecyclerView.l.b bVar2) {
        if (bVar.f8233a != bVar2.f8233a || bVar.b != bVar2.b) {
            return z(d0Var, bVar.f8233a, bVar.b, bVar2.f8233a, bVar2.b);
        }
        F(d0Var);
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean f(RecyclerView.d0 d0Var) {
        return !this.f6128a || d0Var.t();
    }

    public abstract boolean x(RecyclerView.d0 d0Var);

    public abstract boolean y(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i, int i2, int i3, int i4);

    public abstract boolean z(RecyclerView.d0 d0Var, int i, int i2, int i3, int i4);
}
