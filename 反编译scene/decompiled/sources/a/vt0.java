package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vt0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vt0 f7723a = new vt0();

    public vt0() {
        super(1);
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", "CPU使用率");
        l30Var.E("desc", "需要主动压缩和主动回写时，如果CPU使用率高于此值，延缓执行");
        l30Var.E("visible", "always");
        l30Var.G("field", ut0.f7630a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
