package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dl1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fl1 f5913a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f579a;

    public dl1(fl1 fl1Var, String str) {
        this.f5913a = fl1Var;
        this.f579a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5913a.u(this.f579a);
    }
}
