package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ns0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ os0 f6944a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ns0(os0 os0Var) {
        super(1);
        this.f6944a = os0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("path", "target_cluster");
        l30Var.E("type", "select");
        l30Var.E("default", "0");
        l30Var.E("options", new m30((g82<? super l30, m42>[]) new g82[]{new ks0(this), new ls0(this), new ms0(this)}));
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
