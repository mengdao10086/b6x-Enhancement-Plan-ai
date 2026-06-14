package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lr0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qr0 f6733a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lr0(qr0 qr0Var) {
        super(1);
        this.f6733a = qr0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("label", this.f6733a.f7232a.f7325a.f7425a.c(u61.schedule_env_skey_sc_game));
        l30Var.E("value", "scene+game");
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
