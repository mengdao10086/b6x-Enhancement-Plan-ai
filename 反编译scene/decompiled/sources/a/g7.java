package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class g7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h7 f6177a;

    public g7(h7 h7Var) {
        this.f6177a = h7Var;
    }

    public void a() {
        h7 h7Var = this.f6177a;
        h7Var.f1126a = null;
        h7Var.removeCallbacks(this);
    }

    public void b() {
        this.f6177a.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        h7 h7Var = this.f6177a;
        h7Var.f1126a = null;
        h7Var.drawableStateChanged();
    }
}
