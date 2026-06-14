package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dh2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fh2 f5902a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ tc2 f562a;

    public dh2(fh2 fh2Var, tc2 tc2Var) {
        this.f5902a = fh2Var;
        this.f562a = tc2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f562a.e(this.f5902a, m42.f6769a);
    }
}
