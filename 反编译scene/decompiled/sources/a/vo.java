package a;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class vo extends RecyclerView.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yo f7711a;

    public vo(yo yoVar) {
        this.f7711a = yoVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void b(RecyclerView recyclerView, int i, int i2) {
        this.f7711a.C(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
    }
}
