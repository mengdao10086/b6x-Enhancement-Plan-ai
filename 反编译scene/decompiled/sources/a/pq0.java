package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pq0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qq0 f7139a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pq0(qq0 qq0Var) {
        super(1);
        this.f7139a = qq0Var;
    }

    public final void a(l30 l30Var) throws Exception {
        f92.d(l30Var, "$receiver");
        l30Var.E("use", "whitelist");
        qq0 qq0Var = this.f7139a;
        l30Var.E("big_min_freq", qq0Var.f2597a.clusters.get(qq0Var.f7230a.f6687a).min_freq);
        qq0 qq0Var2 = this.f7139a;
        l30Var.E("middle_min_freq", qq0Var2.f2597a.clusters.get(qq0Var2.f7230a.f6687a).min_freq);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        qq0 qq0Var3 = this.f7139a;
        sb.append(qq0Var3.f2597a.clusters.get(qq0Var3.f7230a.f6687a).max_freq);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        qq0 qq0Var4 = this.f7139a;
        sb2.append(qq0Var4.f2597a.clusters.get(qq0Var4.b.f6687a).max_freq);
        l30Var.H("freq", new String[]{sb.toString(), sb2.toString()});
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) throws Exception {
        a(l30Var);
        return m42.f6769a;
    }
}
