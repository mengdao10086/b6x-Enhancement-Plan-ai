package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kr0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qr0 f6633a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kr0(qr0 qr0Var) {
        super(1);
        this.f6633a = qr0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("label", this.f6633a.f7232a.f7325a.f7425a.c(u61.schedule_env_skey_ocr_cam));
        l30Var.E("value", "ocr+camera");
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
