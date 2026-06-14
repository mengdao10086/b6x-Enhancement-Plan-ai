package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jt0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kt0 f6544a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jt0(kt0 kt0Var) {
        super(1);
        this.f6544a = kt0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", "Debug");
        l30Var.E("items", new m30((g82<? super l30, m42>[]) new g82[]{new it0(this)}));
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
