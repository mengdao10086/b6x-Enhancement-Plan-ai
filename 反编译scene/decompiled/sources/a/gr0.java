package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gr0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sr0 f6235a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gr0(sr0 sr0Var) {
        super(1);
        this.f6235a = sr0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", this.f6235a.f7425a.c(u61.schedule_env_d_lb));
        l30Var.E("desc", this.f6235a.f7425a.c(u61.schedule_env_d_lb_desc));
        l30Var.E("visible", this.f6235a.d ? "never" : "always");
        l30Var.G("field", fr0.f6132a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
