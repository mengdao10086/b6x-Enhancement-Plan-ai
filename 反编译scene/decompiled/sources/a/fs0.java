package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fs0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gs0 f6134a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fs0(gs0 gs0Var) {
        super(1);
        this.f6134a = gs0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("path", "governor_middle");
        l30Var.E("type", "select");
        l30Var.E("options", this.f6134a.f6238a.f6541a.d());
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
