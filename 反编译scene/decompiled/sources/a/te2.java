package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class te2 extends wf2<qf2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final re2 f7494a;

    public te2(qf2 qf2Var, re2 re2Var) {
        super(qf2Var);
        this.f7494a = re2Var;
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(Throwable th) {
        v(th);
        return m42.f6769a;
    }

    @Override // a.zh2
    public String toString() {
        return "DisposeOnCompletion[" + this.f7494a + ']';
    }

    @Override // a.id2
    public void v(Throwable th) {
        this.f7494a.b();
    }
}
