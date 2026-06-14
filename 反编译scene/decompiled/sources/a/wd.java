package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class wd implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7776a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ke f3424a;

    public wd(xd xdVar, ke keVar, int i) {
        this.f3424a = keVar;
        this.f7776a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3424a.a(this.f7776a);
    }
}
