package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ws0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dt0 f7818a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ws0(dt0 dt0Var) {
        super(1);
        this.f7818a = dt0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", this.f7818a.f5935a.e(u61.scheduler_fas_rt_adj));
        l30Var.E("desc", this.f7818a.f5935a.e(u61.scheduler_fas_rt_adj_desc));
        l30Var.E("visible", "always");
        l30Var.G("field", new vs0(this));
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
