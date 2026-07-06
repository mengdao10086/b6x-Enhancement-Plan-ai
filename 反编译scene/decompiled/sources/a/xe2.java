package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xe2 extends ye2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f7881a;

    public xe2(long j, Runnable runnable) {
        super(j);
        this.f7881a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7881a.run();
    }

    @Override // a.ye2
    public String toString() {
        return super.toString() + this.f7881a.toString();
    }
}
