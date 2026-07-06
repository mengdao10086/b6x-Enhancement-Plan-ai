package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kv0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ lv0 f6645a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kv0(lv0 lv0Var) {
        super(1);
        this.f6645a = lv0Var;
    }

    public final void a(l30 l30Var) throws Exception {
        f92.d(l30Var, "$receiver");
        l30Var.E("default", "low");
        l30Var.E("path", "low_battery_mode");
        l30Var.E("type", "select");
        l30Var.D("options", this.f6645a.f6741a.f2305a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) throws Exception {
        a(l30Var);
        return m42.f6769a;
    }
}
