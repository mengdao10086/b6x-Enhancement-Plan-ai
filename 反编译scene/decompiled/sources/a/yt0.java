package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yt0 extends g92 implements g82<l30, m42> {
    public final /* synthetic */ boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yt0(boolean z) {
        super(1);
        this.b = z;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("visible", this.b ? "always" : "never");
        l30Var.E("desc", "谨慎配置各项阈值，避免压缩或回写被无限触发");
        l30Var.I("items", new g82[]{new rt0(this), tt0.f7531a, vt0.f7723a, xt0.f7918a});
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
