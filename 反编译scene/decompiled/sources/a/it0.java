package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class it0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jt0 f6441a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public it0(jt0 jt0Var) {
        super(1);
        this.f6441a = jt0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", this.f6441a.f6544a.e(u61.fas_notify));
        l30Var.E("desc", this.f6441a.f6544a.e(u61.fas_notify_desc));
        l30Var.E("visible", "always");
        l30Var.G("field", ht0.f6341a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
