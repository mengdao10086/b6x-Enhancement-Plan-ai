package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class mc implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6791a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ nc f1914a;

    public mc(nc ncVar, int i) {
        this.f1914a = ncVar;
        this.f6791a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1914a.d(this.f6791a);
    }
}
