package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ft0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gt0 f6137a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ft0(gt0 gt0Var) {
        super(1);
        this.f6137a = gt0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", this.f6137a.f6241a.e(u61.scheduler_fas_margin_offset));
        l30Var.E("desc", this.f6137a.f6241a.e(u61.scheduler_fas_margin_offset_desc));
        l30Var.E("visible", "always");
        l30Var.G("field", et0.f6039a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
