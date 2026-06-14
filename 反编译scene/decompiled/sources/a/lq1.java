package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lq1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ iz0 f6732a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ mq1 f1846a;

    public lq1(mq1 mq1Var, iz0 iz0Var) {
        this.f1846a = mq1Var;
        this.f6732a = iz0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1846a.c(this.f6732a);
    }
}
