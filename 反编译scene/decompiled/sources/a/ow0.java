package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ow0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rw0 f7061a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ow0(rw0 rw0Var) {
        super(1);
        this.f7061a = rw0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("label", this.f7061a.d(u61.rr_120) + " (120Hz)");
        l30Var.E("value", "high");
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
