package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class zb0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ac0 f8054a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ g30 f3824a;

    public zb0(ac0 ac0Var, g30 g30Var) {
        this.f8054a = ac0Var;
        this.f3824a = g30Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f8054a.f5591a.f6300a.f1352a.evaluateJavascript(this.f8054a.f57a + "(" + this.f3824a + ")", new yb0(this));
    }
}
