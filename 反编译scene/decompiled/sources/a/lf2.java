package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lf2 extends rc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g82<Throwable, m42> f6703a;

    /* JADX WARN: Multi-variable type inference failed */
    public lf2(g82<? super Throwable, m42> g82Var) {
        this.f6703a = g82Var;
    }

    @Override // a.sc2
    public void a(Throwable th) {
        this.f6703a.f(th);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(Throwable th) {
        a(th);
        return m42.f6769a;
    }

    public String toString() {
        return "InvokeOnCancel[" + ce2.a(this.f6703a) + '@' + ce2.b(this) + ']';
    }
}
