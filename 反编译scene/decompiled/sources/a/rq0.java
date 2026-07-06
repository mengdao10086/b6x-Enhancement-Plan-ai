package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rq0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sq0 f7323a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rq0(sq0 sq0Var) {
        super(1);
        this.f7323a = sq0Var;
    }

    public final void a(l30 l30Var) throws Exception {
        f92.d(l30Var, "$receiver");
        l30Var.E("use", "whitelist");
        sq0 sq0Var = this.f7323a;
        l30Var.E("big_min_freq", sq0Var.f2916a.clusters.get(sq0Var.f7422a.f6687a).min_freq);
        sq0 sq0Var2 = this.f7323a;
        l30Var.E("middle_min_freq", sq0Var2.f2916a.clusters.get(sq0Var2.f7422a.f6687a).min_freq);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sq0 sq0Var3 = this.f7323a;
        sb.append(sq0Var3.f2916a.clusters.get(sq0Var3.f7422a.f6687a).max_freq);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sq0 sq0Var4 = this.f7323a;
        sb2.append(sq0Var4.f2916a.clusters.get(sq0Var4.b.f6687a).max_freq);
        l30Var.H("freq", new String[]{sb.toString(), sb2.toString()});
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) throws Exception {
        a(l30Var);
        return m42.f6769a;
    }
}
