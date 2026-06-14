package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class au0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final au0 f5642a = new au0();

    public au0() {
        super(1);
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", "主动清理");
        l30Var.E("desc", "符合下列条件时，主动杀死一些进程。如果你没有后台留存太好的烦恼，请不要开启这个选项。");
        l30Var.E("visible", "always");
        l30Var.G("field", zt0.f8096a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
