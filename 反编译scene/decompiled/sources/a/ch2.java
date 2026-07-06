package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ch2 implements re2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fh2 f5794a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f403a;

    public ch2(fh2 fh2Var, Runnable runnable) {
        this.f5794a = fh2Var;
        this.f403a = runnable;
    }

    @Override // a.re2
    public void b() {
        this.f5794a.f899a.removeCallbacks(this.f403a);
    }
}
