package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final RecyclerView.g f6828a;

    public b(@n0 RecyclerView.g gVar) {
        this.f6828a = gVar;
    }

    @Override // androidx.recyclerview.widget.t
    public void onChanged(int i10, int i11, Object obj) {
        this.f6828a.notifyItemRangeChanged(i10, i11, obj);
    }

    @Override // androidx.recyclerview.widget.t
    public void onInserted(int i10, int i11) {
        this.f6828a.notifyItemRangeInserted(i10, i11);
    }

    @Override // androidx.recyclerview.widget.t
    public void onMoved(int i10, int i11) {
        this.f6828a.notifyItemMoved(i10, i11);
    }

    @Override // androidx.recyclerview.widget.t
    public void onRemoved(int i10, int i11) {
        this.f6828a.notifyItemRangeRemoved(i10, i11);
    }
}
