package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nv0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ov0 f6952a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nv0(ov0 ov0Var) {
        super(1);
        this.f6952a = ov0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", this.f6952a.f7058a.d(u61.rr_battery_threshold));
        l30Var.E("desc", this.f6952a.f7058a.d(u61.rr_battery_threshold_desc));
        l30Var.E("visible", "always");
        l30Var.G("field", mv0.f6846a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
