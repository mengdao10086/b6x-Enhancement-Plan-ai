package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hw0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mw0 f6349a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hw0(mw0 mw0Var) {
        super(1);
        this.f6349a = mw0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", this.f6349a.f6848a.d(u61.rr_strict));
        l30Var.E("desc", this.f6349a.f6848a.d(u61.rr_strict_desc));
        l30Var.E("visible", "always");
        l30Var.G("field", gw0.f6249a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
