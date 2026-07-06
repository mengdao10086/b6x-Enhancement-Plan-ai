package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class s31 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f7359a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ t31 f2835a;

    public s31(long j, t31 t31Var) {
        this.f7359a = j;
        this.f2835a = t31Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f2835a.b() == this.f7359a) {
            this.f2835a.f2949a.run();
        }
    }
}
