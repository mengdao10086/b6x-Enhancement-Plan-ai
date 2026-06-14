package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class a3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d3 f5564a;

    public a3(d3 d3Var) {
        this.f5564a = d3Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5564a.a(true);
        this.f5564a.invalidateSelf();
    }
}
