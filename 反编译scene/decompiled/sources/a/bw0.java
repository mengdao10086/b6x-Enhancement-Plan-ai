package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bw0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bw0 f5738a = new bw0();

    public bw0() {
        super(1);
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("default", "2000");
        l30Var.E("path", "scroll_delay");
        l30Var.E("type", "number");
        l30Var.E("step", 100);
        l30Var.E("max", 5000);
        l30Var.E("min", 500);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
