package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vv0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yv0 f7728a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vv0(yv0 yv0Var) {
        super(1);
        this.f7728a = yv0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", this.f7728a.f8013a.d(u61.rr_brightness_threshold));
        l30Var.E("desc", this.f7728a.f8013a.d(u61.rr_brightness_threshold_desc));
        l30Var.E("visible", "always");
        l30Var.G("field", uv0.f7635a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
