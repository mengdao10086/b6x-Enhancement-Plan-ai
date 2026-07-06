package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class e1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w1 f5954a;

    public e1(w1 w1Var) {
        this.f5954a = w1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        w1 w1Var = this.f5954a;
        w1Var.f3341a.showAtLocation(w1Var.f3343a, 55, 0, 0);
        this.f5954a.b0();
        if (!this.f5954a.J0()) {
            this.f5954a.f3343a.setAlpha(1.0f);
            this.f5954a.f3343a.setVisibility(0);
            return;
        }
        this.f5954a.f3343a.setAlpha(0.0f);
        w1 w1Var2 = this.f5954a;
        lh lhVarC = eh.c(w1Var2.f3343a);
        lhVarC.a(1.0f);
        w1Var2.f3330a = lhVarC;
        this.f5954a.f3330a.f(new d1(this));
    }
}
