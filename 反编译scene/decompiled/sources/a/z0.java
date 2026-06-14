package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class z0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w1 f8022a;

    public z0(w1 w1Var) {
        this.f8022a = w1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        w1 w1Var = this.f8022a;
        if ((w1Var.d & 1) != 0) {
            w1Var.a0(0);
        }
        w1 w1Var2 = this.f8022a;
        if ((w1Var2.d & 4096) != 0) {
            w1Var2.a0(108);
        }
        w1 w1Var3 = this.f8022a;
        w1Var3.s = false;
        w1Var3.d = 0;
    }
}
