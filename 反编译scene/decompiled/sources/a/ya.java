package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ya implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bb f7961a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Object f3670a;

    public ya(bb bbVar, Object obj) {
        this.f7961a = bbVar;
        this.f3670a = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7961a.f253a = this.f3670a;
    }
}
