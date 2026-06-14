package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cw0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dw0 f5833a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cw0(dw0 dw0Var) {
        super(1);
        this.f5833a = dw0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", this.f5833a.f5942a.d(u61.rr_duration_scroll));
        l30Var.E("desc", this.f5833a.f5942a.d(u61.rr_duration_scroll_desc));
        l30Var.E("visible", "always");
        l30Var.G("field", bw0.f5738a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
