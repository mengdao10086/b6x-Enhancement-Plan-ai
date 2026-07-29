package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.c0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d0<T2> extends c0.b<T2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.g f6878a;

    public d0(RecyclerView.g gVar) {
        this.f6878a = gVar;
    }

    @Override // androidx.recyclerview.widget.c0.b
    public void d(int i10, int i11) {
        this.f6878a.notifyItemRangeChanged(i10, i11);
    }

    @Override // androidx.recyclerview.widget.c0.b, androidx.recyclerview.widget.t
    public void onChanged(int i10, int i11, Object obj) {
        this.f6878a.notifyItemRangeChanged(i10, i11, obj);
    }

    @Override // androidx.recyclerview.widget.t
    public void onInserted(int i10, int i11) {
        this.f6878a.notifyItemRangeInserted(i10, i11);
    }

    @Override // androidx.recyclerview.widget.t
    public void onMoved(int i10, int i11) {
        this.f6878a.notifyItemMoved(i10, i11);
    }

    @Override // androidx.recyclerview.widget.t
    public void onRemoved(int i10, int i11) {
        this.f6878a.notifyItemRangeRemoved(i10, i11);
    }
}
