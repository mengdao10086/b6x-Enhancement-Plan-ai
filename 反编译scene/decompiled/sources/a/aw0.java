package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class aw0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dw0 f5647a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw0(dw0 dw0Var) {
        super(1);
        this.f5647a = dw0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", this.f5647a.f5942a.d(u61.rr_duration_tap));
        l30Var.E("desc", this.f5647a.f5942a.d(u61.rr_duration_tap_desc));
        l30Var.E("visible", "always");
        l30Var.G("field", zv0.f8100a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
