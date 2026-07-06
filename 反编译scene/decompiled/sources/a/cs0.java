package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cs0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kt0 f5824a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f442a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cs0(kt0 kt0Var, String str) {
        super(1);
        this.f5824a = kt0Var;
        this.f442a = str;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", "General");
        l30Var.E("visible", this.f442a);
        l30Var.E("items", new m30((g82<? super l30, m42>[]) new g82[]{new bs0(this)}));
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
