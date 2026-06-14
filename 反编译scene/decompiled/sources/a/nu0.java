package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nu0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ou0 f6949a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nu0(ou0 ou0Var) {
        super(1);
        this.f6949a = ou0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", "状态提示");
        l30Var.E("desc", "执行操作时弹出通知，以便检查工作状态");
        ou0 ou0Var = this.f6949a;
        l30Var.E("visible", (ou0Var.b || ou0Var.c) ? "always" : "never");
        l30Var.G("field", mu0.f6843a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
