package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cr0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sr0 f5821a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cr0(sr0 sr0Var) {
        super(1);
        this.f5821a = sr0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", this.f5821a.f7425a.c(u61.schedule_env_d_gpu_boost));
        l30Var.E("desc", this.f5821a.f7425a.c(u61.schedule_env_d_gpu_boost_desc));
        l30Var.E("visible", "always");
        l30Var.G("field", new br0(this));
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
