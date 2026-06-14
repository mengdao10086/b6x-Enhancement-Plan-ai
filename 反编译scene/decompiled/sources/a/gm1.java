package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gm1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nm1 f6222a;
    public final /* synthetic */ boolean b;

    public gm1(nm1 nm1Var, boolean z) {
        this.f6222a = nm1Var;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b) {
            u90.e(this.f6222a.f2114a, null, 1, null);
        } else {
            this.f6222a.f2114a.c();
        }
    }
}
