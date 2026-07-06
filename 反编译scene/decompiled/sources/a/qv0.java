package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qv0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tv0 f7243a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qv0(tv0 tv0Var) {
        super(1);
        this.f7243a = tv0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", this.f7243a.f7538a.d(u61.rr_standby));
        l30Var.E("desc", this.f7243a.f7538a.d(u61.rr_standby_desc));
        l30Var.E("visible", "always");
        l30Var.G("field", new pv0(this));
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
