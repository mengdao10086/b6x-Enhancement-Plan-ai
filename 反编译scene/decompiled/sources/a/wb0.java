package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class wb0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g30 f7771a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ xb0 f3418a;

    public wb0(xb0 xb0Var, g30 g30Var) {
        this.f3418a = xb0Var;
        this.f7771a = g30Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3418a.f7873a.f6300a.f1352a.evaluateJavascript(this.f3418a.f3567a + "(" + this.f7771a + ")", new vb0(this));
    }
}
