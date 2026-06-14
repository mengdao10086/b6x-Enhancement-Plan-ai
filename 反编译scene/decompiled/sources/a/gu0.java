package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gu0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gu0 f6244a = new gu0();

    public gu0() {
        super(1);
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", "内存使用率");
        l30Var.E("desc", "在一般应用中，内存使用率超过此值，杀死部分后台");
        l30Var.E("visible", "always");
        l30Var.G("field", fu0.f6140a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
