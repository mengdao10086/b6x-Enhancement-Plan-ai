package a;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class fp implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6125a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ mp f933a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ np f934a;

    public fp(np npVar, mp mpVar, int i) {
        this.f934a = npVar;
        this.f933a = mpVar;
        this.f6125a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecyclerView recyclerView = this.f934a.f2141a;
        if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
            return;
        }
        mp mpVar = this.f933a;
        if (mpVar.f1975b || mpVar.f1973a.j() == -1) {
            return;
        }
        RecyclerView.l itemAnimator = this.f934a.f2141a.getItemAnimator();
        if ((itemAnimator == null || !itemAnimator.q(null)) && !this.f934a.w()) {
            this.f934a.f2133a.B(this.f933a.f1973a, this.f6125a);
        } else {
            this.f934a.f2141a.post(this);
        }
    }
}
