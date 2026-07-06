package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class tq0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ uq0 f7524a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tq0(uq0 uq0Var) {
        super(1);
        this.f7524a = uq0Var;
    }

    public final void a(l30 l30Var) throws Exception {
        f92.d(l30Var, "$receiver");
        l30Var.E("use", "whitelist");
        uq0 uq0Var = this.f7524a;
        l30Var.E("big_min_freq", uq0Var.f3205a.clusters.get(uq0Var.f7622a.f6687a).min_freq);
        uq0 uq0Var2 = this.f7524a;
        l30Var.E("middle_min_freq", uq0Var2.f3205a.clusters.get(uq0Var2.f7622a.f6687a).min_freq);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        uq0 uq0Var3 = this.f7524a;
        sb.append(uq0Var3.f3205a.clusters.get(uq0Var3.f7622a.f6687a).max_freq);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        uq0 uq0Var4 = this.f7524a;
        sb2.append(uq0Var4.f3205a.clusters.get(uq0Var4.b.f6687a).max_freq);
        l30Var.H("freq", new String[]{sb.toString(), sb2.toString()});
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) throws Exception {
        a(l30Var);
        return m42.f6769a;
    }
}
