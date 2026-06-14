package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bu0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bu0 f5733a = new bu0();

    public bu0() {
        super(1);
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("path", "kill_ram_free");
        l30Var.E("type", "number");
        l30Var.E("default", "12");
        l30Var.E("min", 7);
        l30Var.E("max", 20);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
