package a;

import android.widget.AbsListView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class j90 extends g92 implements g82<n30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l90 f6488a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AbsListView f1515a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j90(l90 l90Var, AbsListView absListView) {
        super(1);
        this.f6488a = l90Var;
        this.f1515a = absListView;
    }

    public final void a(n30 n30Var) {
        f92.d(n30Var, "it");
        if (this.f6488a.f1781b || this.f6488a.f1778a) {
            return;
        }
        this.f6488a.i(this.f1515a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(n30 n30Var) {
        a(n30Var);
        return m42.f6769a;
    }
}
