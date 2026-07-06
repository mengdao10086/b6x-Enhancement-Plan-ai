package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class is0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ js0 f6438a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public is0(js0 js0Var) {
        super(1);
        this.f6438a = js0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", this.f6438a.f6541a.e(u61.scheduler_fas_governor_p));
        l30Var.E("desc", this.f6438a.f6541a.e(u61.scheduler_fas_governor_p_desc));
        l30Var.E("visible", "always");
        l30Var.G("field", new hs0(this));
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
