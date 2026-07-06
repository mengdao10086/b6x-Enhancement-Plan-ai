package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class fc0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g30 f6092a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ gc0 f882a;

    public fc0(gc0 gc0Var, g30 g30Var) {
        this.f882a = gc0Var;
        this.f6092a = g30Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f882a.f6193a.f6300a.f1352a.evaluateJavascript(this.f882a.f995a + "(" + this.f6092a + ")", new ec0(this));
    }
}
