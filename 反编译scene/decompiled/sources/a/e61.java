package a;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class e61 extends jp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b61 f5971a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d61 f703a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f704a;
    public boolean b;

    public e61(b61 b61Var, d61 d61Var) {
        f92.d(b61Var, "mAdapter");
        this.f5971a = b61Var;
        this.f703a = d61Var;
        this.f704a = true;
    }

    @Override // a.jp
    public void A(RecyclerView.d0 d0Var, int i) {
        if (i != 0) {
            c61 c61Var = (c61) d0Var;
            f92.b(c61Var);
            c61Var.N();
        }
        super.A(d0Var, i);
    }

    @Override // a.jp
    public void B(RecyclerView.d0 d0Var, int i) {
        f92.d(d0Var, "viewHolder");
        this.f5971a.b(d0Var.j());
    }

    @Override // a.jp
    public void c(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        f92.d(recyclerView, "recyclerView");
        f92.d(d0Var, "viewHolder");
        super.c(recyclerView, d0Var);
        ((c61) d0Var).M();
    }

    @Override // a.jp
    public int k(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
        f92.d(recyclerView, "recyclerView");
        f92.d(d0Var, "viewHolder");
        return jp.t(15, 48);
    }

    @Override // a.jp
    public boolean q() {
        d61 d61Var = this.f703a;
        return d61Var != null ? d61Var.a() : this.b;
    }

    @Override // a.jp
    public boolean r() {
        d61 d61Var = this.f703a;
        return d61Var != null ? d61Var.b() : this.f704a;
    }

    @Override // a.jp
    public boolean y(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
        f92.d(recyclerView, "recyclerView");
        f92.d(d0Var, "viewHolder");
        f92.d(d0Var2, "target");
        if (d0Var.l() != d0Var2.l()) {
            return false;
        }
        this.f5971a.a(d0Var.j(), d0Var2.j());
        return true;
    }
}
