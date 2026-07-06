package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bs0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cs0 f5729a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs0(cs0 cs0Var) {
        super(1);
        this.f5729a = cs0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", this.f5729a.f5824a.e(u61.schedule_fas_engine));
        l30Var.E("desc", this.f5729a.f5824a.e(u61.schedule_fas_engine_desc));
        l30Var.E("visible", "always");
        l30Var.G("field", as0.f5638a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
