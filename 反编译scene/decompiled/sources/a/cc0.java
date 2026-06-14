package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class cc0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dc0 f5778a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ g30 f378a;

    public cc0(dc0 dc0Var, g30 g30Var) {
        this.f5778a = dc0Var;
        this.f378a = g30Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5778a.f5882a.f6300a.f1352a.evaluateJavascript(this.f5778a.f546a + "(" + this.f378a + ")", new bc0(this));
    }
}
