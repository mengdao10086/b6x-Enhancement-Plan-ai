package a;

import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gv0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rw0 f6246a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ List f1070a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gv0(rw0 rw0Var, List list) {
        super(1);
        this.f6246a = rw0Var;
        this.f1070a = list;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", this.f6246a.d(u61.rr_apps));
        l30Var.E("items", new m30((g82<? super l30, m42>[]) new g82[]{new dv0(this), new fv0(this)}));
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
