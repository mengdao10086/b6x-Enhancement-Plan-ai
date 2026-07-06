package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class se2 extends rc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final re2 f7390a;

    public se2(re2 re2Var) {
        this.f7390a = re2Var;
    }

    @Override // a.sc2
    public void a(Throwable th) {
        this.f7390a.b();
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(Throwable th) {
        a(th);
        return m42.f6769a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f7390a + ']';
    }
}
