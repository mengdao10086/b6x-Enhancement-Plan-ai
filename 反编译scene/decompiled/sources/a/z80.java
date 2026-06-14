package a;

import android.widget.AbsListView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class z80 extends g92 implements g82<n30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b90 f8044a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AbsListView f3798a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z80(b90 b90Var, AbsListView absListView) {
        super(1);
        this.f8044a = b90Var;
        this.f3798a = absListView;
    }

    public final void a(n30 n30Var) {
        f92.d(n30Var, "it");
        if (this.f8044a.A || this.f8044a.z) {
            return;
        }
        this.f8044a.H1(this.f3798a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(n30 n30Var) {
        a(n30Var);
        return m42.f6769a;
    }
}
