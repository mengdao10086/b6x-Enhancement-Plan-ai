package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sr0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tr0 f7425a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sr0(tr0 tr0Var, boolean z, boolean z2, boolean z3, boolean z4) {
        super(1);
        this.f7425a = tr0Var;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = z4;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", this.f7425a.c(u61.schedule_env_reboot_tip));
        l30Var.I("items", new g82[]{new cr0(this), new er0(this), new gr0(this), new ir0(this), new rr0(this)});
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
