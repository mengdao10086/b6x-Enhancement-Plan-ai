package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yc2 extends sf2<qf2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final uc2<?> f7970a;

    public yc2(qf2 qf2Var, uc2<?> uc2Var) {
        super(qf2Var);
        this.f7970a = uc2Var;
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(Throwable th) {
        v(th);
        return m42.f6769a;
    }

    @Override // a.zh2
    public String toString() {
        return "ChildContinuation[" + this.f7970a + ']';
    }

    @Override // a.id2
    public void v(Throwable th) {
        uc2<?> uc2Var = this.f7970a;
        uc2Var.G(uc2Var.u(super.f7784a));
    }
}
