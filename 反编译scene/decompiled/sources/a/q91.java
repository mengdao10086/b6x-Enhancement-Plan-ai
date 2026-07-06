package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class q91 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g50 f7190a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ r91 f2555a;

    public q91(r91 r91Var, g50 g50Var) {
        this.f2555a = r91Var;
        this.f7190a = g50Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2555a.f7284a.j(this.f7190a);
    }
}
