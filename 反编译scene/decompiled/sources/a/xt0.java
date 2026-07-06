package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xt0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xt0 f7918a = new xt0();

    public xt0() {
        super(1);
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", "游戏检测");
        l30Var.E("desc", "运行游戏期间不执行主动压缩和主动回写(由SCENE管理设备性能时生效)");
        l30Var.E("visible", "never");
        l30Var.G("field", wt0.f7821a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
