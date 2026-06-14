package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yf2 extends wf2<qf2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ad2 f7980a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final bg2 f3708a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zf2 f3709a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f3710a;

    public yf2(bg2 bg2Var, zf2 zf2Var, ad2 ad2Var, Object obj) {
        super(ad2Var.f5596a);
        this.f3708a = bg2Var;
        this.f3709a = zf2Var;
        this.f7980a = ad2Var;
        this.f3710a = obj;
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(Throwable th) {
        v(th);
        return m42.f6769a;
    }

    @Override // a.zh2
    public String toString() {
        return "ChildCompletion[" + this.f7980a + ", " + this.f3710a + ']';
    }

    @Override // a.id2
    public void v(Throwable th) {
        this.f3708a.P(this.f3709a, this.f7980a, this.f3710a);
    }
}
