package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class b11 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c11 f5663a;

    public b11(c11 c11Var) {
        this.f5663a = c11Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5663a.f5749a.notifyDataSetChanged();
        this.f5663a.f5749a.f6664a.c();
    }
}
