package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nf2 extends wf2<qf2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g82<Throwable, m42> f6911a;

    /* JADX WARN: Multi-variable type inference failed */
    public nf2(qf2 qf2Var, g82<? super Throwable, m42> g82Var) {
        super(qf2Var);
        this.f6911a = g82Var;
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(Throwable th) {
        v(th);
        return m42.f6769a;
    }

    @Override // a.zh2
    public String toString() {
        return "InvokeOnCompletion[" + ce2.a(this) + '@' + ce2.b(this) + ']';
    }

    @Override // a.id2
    public void v(Throwable th) {
        this.f6911a.f(th);
    }
}
