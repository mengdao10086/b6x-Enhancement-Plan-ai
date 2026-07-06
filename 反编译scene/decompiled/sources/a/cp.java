package a;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class cp implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ np f5814a;

    public cp(np npVar) {
        this.f5814a = npVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        np npVar = this.f5814a;
        if (npVar.f2138a == null || !npVar.D()) {
            return;
        }
        np npVar2 = this.f5814a;
        RecyclerView.d0 d0Var = npVar2.f2138a;
        if (d0Var != null) {
            npVar2.y(d0Var);
        }
        np npVar3 = this.f5814a;
        npVar3.f2141a.removeCallbacks(npVar3.f2142a);
        eh.c0(this.f5814a.f2141a, this);
    }
}
