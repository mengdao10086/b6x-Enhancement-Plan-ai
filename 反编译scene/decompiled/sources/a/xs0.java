package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xs0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ys0 f7916a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xs0(ys0 ys0Var) {
        super(1);
        this.f7916a = ys0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("path", "conservative");
        l30Var.E("type", "boolean");
        l30Var.E("default", this.f7916a.f8008a.c ? "1" : "0");
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
