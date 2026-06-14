package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lu0 extends g92 implements g82<l30, m42> {
    public final /* synthetic */ boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lu0(boolean z) {
        super(1);
        this.b = z;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("visible", this.b ? "always" : "never");
        l30Var.I("items", new g82[]{au0.f5642a, cu0.f5829a, eu0.f6042a, gu0.f6244a, iu0.f6444a, ku0.f6642a});
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
