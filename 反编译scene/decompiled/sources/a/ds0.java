package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ds0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ es0 f5933a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ds0(es0 es0Var) {
        super(1);
        this.f5933a = es0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("path", "governor_little");
        l30Var.E("type", "select");
        l30Var.E("options", this.f5933a.f6036a.f6541a.d());
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
