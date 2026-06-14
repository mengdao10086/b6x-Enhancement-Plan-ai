package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cv0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dv0 f5831a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cv0(dv0 dv0Var) {
        super(1);
        this.f5831a = dv0Var;
    }

    public final void a(l30 l30Var) throws Exception {
        f92.d(l30Var, "$receiver");
        l30Var.E("default", "high");
        l30Var.E("path", "apps_default");
        l30Var.E("type", "select");
        l30Var.D("options", this.f5831a.f5940a.f1070a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) throws Exception {
        a(l30Var);
        return m42.f6769a;
    }
}
