package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wv0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xv0 f7826a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wv0(xv0 xv0Var) {
        super(1);
        this.f7826a = xv0Var;
    }

    public final void a(l30 l30Var) throws Exception {
        f92.d(l30Var, "$receiver");
        l30Var.E("default", "high");
        l30Var.E("path", "low_brightness");
        l30Var.E("type", "select");
        l30Var.D("options", this.f7826a.f7922a.f3775a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) throws Exception {
        a(l30Var);
        return m42.f6769a;
    }
}
