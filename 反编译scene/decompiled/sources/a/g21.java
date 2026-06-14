package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class g21 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l21 f6161a;

    public g21(l21 l21Var) {
        this.f6161a = l21Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6161a.notifyDataSetChanged();
        this.f6161a.f1721a.c();
    }
}
