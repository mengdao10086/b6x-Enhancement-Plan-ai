package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ad2 extends sf2<bg2> implements zc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd2 f5596a;

    public ad2(bg2 bg2Var, bd2 bd2Var) {
        super(bg2Var);
        this.f5596a = bd2Var;
    }

    @Override // a.zc2
    public boolean e(Throwable th) {
        return ((bg2) super.f7784a).N(th);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(Throwable th) {
        v(th);
        return m42.f6769a;
    }

    @Override // a.zh2
    public String toString() {
        return "ChildHandle[" + this.f5596a + ']';
    }

    @Override // a.id2
    public void v(Throwable th) {
        this.f5596a.j((jg2) super.f7784a);
    }
}
