package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class br0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cr0 f5727a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br0(cr0 cr0Var) {
        super(1);
        this.f5727a = cr0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("default", this.f5727a.f5821a.b ? "1" : "0");
        l30Var.E("path", "gpu_lock");
        l30Var.E("type", "boolean");
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
