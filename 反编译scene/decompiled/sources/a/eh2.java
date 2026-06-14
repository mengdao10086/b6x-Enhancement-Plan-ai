package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class eh2 extends g92 implements g82<Throwable, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fh2 f6005a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f738a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eh2(fh2 fh2Var, Runnable runnable) {
        super(1);
        this.f6005a = fh2Var;
        this.f738a = runnable;
    }

    public final void a(Throwable th) {
        this.f6005a.f899a.removeCallbacks(this.f738a);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(Throwable th) {
        a(th);
        return m42.f6769a;
    }
}
