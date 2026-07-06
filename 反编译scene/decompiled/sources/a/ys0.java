package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ys0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dt0 f8008a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ys0(dt0 dt0Var) {
        super(1);
        this.f8008a = dt0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", this.f8008a.f5935a.e(u61.scheduler_fas_conservative));
        l30Var.E("desc", this.f8008a.f5935a.e(u61.scheduler_fas_conservative_desc));
        l30Var.E("visible", "always");
        l30Var.G("field", new xs0(this));
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
