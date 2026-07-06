package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class s40 extends g92 implements g82<String, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tc2 f7361a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s40(tc2 tc2Var) {
        super(1);
        this.f7361a = tc2Var;
    }

    public final void a(String str) {
        f92.d(str, "it");
        tc2 tc2Var = this.f7361a;
        e42 e42Var = g42.f6169a;
        g42.a(str);
        tc2Var.y(str);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(String str) {
        a(str);
        return m42.f6769a;
    }
}
