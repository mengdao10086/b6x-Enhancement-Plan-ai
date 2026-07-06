package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class eu0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final eu0 f6042a = new eu0();

    public eu0() {
        super(1);
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", "Swap空闲比例");
        l30Var.E("desc", "RAM空闲比例低于20%，且Swap空闲比例低于此值，杀死部分后台");
        l30Var.E("visible", "never");
        l30Var.G("field", du0.f5938a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
