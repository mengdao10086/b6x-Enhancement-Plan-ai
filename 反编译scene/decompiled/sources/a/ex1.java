package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ex1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fx1 f6051a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f815a;

    public ex1(fx1 fx1Var, String str) {
        this.f6051a = fx1Var;
        this.f815a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6051a.f948a.setText(this.f815a);
    }
}
