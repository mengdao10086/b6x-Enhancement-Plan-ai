package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rt0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yt0 f7330a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rt0(yt0 yt0Var) {
        super(1);
        this.f7330a = yt0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", "主动压缩/回写");
        l30Var.E("desc", "允许SCENE定期检查内存使用情况，在必要时主动执行压缩/回写");
        l30Var.E("visible", this.f7330a.b ? "always" : "never");
        l30Var.G("field", qt0.f7237a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
