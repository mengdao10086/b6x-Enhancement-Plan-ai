package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ab0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f5589a;
    public final /* synthetic */ Runnable b;

    public ab0(Runnable runnable, Runnable runnable2) {
        this.f5589a = runnable;
        this.b = runnable2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f5589a.run();
            this.b.run();
        } catch (Exception unused) {
        }
    }
}
