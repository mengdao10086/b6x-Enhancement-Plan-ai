package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wo0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g30 f7808a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ xo0 f3462a;

    public wo0(xo0 xo0Var, g30 g30Var) {
        this.f3462a = xo0Var;
        this.f7808a = g30Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f3462a.f3604a.f(this.f3462a.f3605a, this.f7808a);
        } catch (Exception unused) {
        }
    }
}
