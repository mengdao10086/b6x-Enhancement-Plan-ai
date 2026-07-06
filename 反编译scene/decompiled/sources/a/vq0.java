package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vq0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wq0 f7716a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vq0(wq0 wq0Var) {
        super(1);
        this.f7716a = wq0Var;
    }

    public final void a(l30 l30Var) throws Exception {
        f92.d(l30Var, "$receiver");
        l30Var.E("use", "whitelist");
        wq0 wq0Var = this.f7716a;
        l30Var.E("big_min_freq", wq0Var.f3468a.clusters.get(wq0Var.f7813a.f6687a).min_freq);
        wq0 wq0Var2 = this.f7716a;
        l30Var.E("middle_min_freq", wq0Var2.f3468a.clusters.get(wq0Var2.f7813a.f6687a).min_freq);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        wq0 wq0Var3 = this.f7716a;
        sb.append(wq0Var3.f3468a.clusters.get(wq0Var3.f7813a.f6687a).max_freq);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        wq0 wq0Var4 = this.f7716a;
        sb2.append(wq0Var4.f3468a.clusters.get(wq0Var4.b.f6687a).max_freq);
        l30Var.H("freq", new String[]{sb.toString(), sb2.toString()});
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) throws Exception {
        a(l30Var);
        return m42.f6769a;
    }
}
