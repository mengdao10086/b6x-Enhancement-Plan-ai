package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class i72 extends f72 {
    @Override // a.f72
    public void a(Throwable th, Throwable th2) {
        f92.d(th, "cause");
        f92.d(th2, "exception");
        th.addSuppressed(th2);
    }
}
