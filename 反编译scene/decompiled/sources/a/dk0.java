package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class dk0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ek0 f5911a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ gk0 f577a;

    public dk0(ek0 ek0Var, gk0 gk0Var) {
        this.f5911a = ek0Var;
        this.f577a = gk0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        ek0 ek0Var = this.f5911a;
        ek0Var.f767a.removeView(ek0Var.f766a);
        this.f5911a.f6015a.a(this.f577a);
    }
}
