package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pv0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qv0 f7152a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pv0(qv0 qv0Var) {
        super(1);
        this.f7152a = qv0Var;
    }

    public final void a(l30 l30Var) throws Exception {
        f92.d(l30Var, "$receiver");
        l30Var.E("default", "high");
        l30Var.E("path", "screen_off");
        l30Var.E("type", "select");
        l30Var.D("options", this.f7152a.f7243a.f3068a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) throws Exception {
        a(l30Var);
        return m42.f6769a;
    }
}
