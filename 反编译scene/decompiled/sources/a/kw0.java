package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kw0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kw0 f6648a = new kw0();

    public kw0() {
        super(1);
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("path", "display_modes");
        l30Var.E("type", "text");
        l30Var.E("default", "-1 -1 -1");
        l30Var.E("hint", "High - Middle - Low");
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
