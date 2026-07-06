package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dt0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kt0 f5935a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f599a;
    public final /* synthetic */ String b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ boolean f600b;
    public final /* synthetic */ boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dt0(kt0 kt0Var, String str, String str2, boolean z, boolean z2) {
        super(1);
        this.f5935a = kt0Var;
        this.f599a = str;
        this.b = str2;
        this.f600b = z;
        this.c = z2;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        l30Var.E("title", "Scene FAS");
        l30Var.E("visible", this.f599a);
        l30Var.E("items", new m30((g82<? super l30, m42>[]) new g82[]{new os0(this), new qs0(this), new ws0(this), new ys0(this), new at0(this), new ct0(this)}));
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
