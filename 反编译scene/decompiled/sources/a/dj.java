package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class dj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ej f5906a;

    public dj(ej ejVar) {
        this.f5906a = ejVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ej ejVar = this.f5906a;
        if (ejVar.e) {
            if (ejVar.f749c) {
                ejVar.f749c = false;
                ejVar.f742a.m();
            }
            cj cjVar = this.f5906a.f742a;
            if (cjVar.h() || !this.f5906a.u()) {
                this.f5906a.e = false;
                return;
            }
            ej ejVar2 = this.f5906a;
            if (ejVar2.d) {
                ejVar2.d = false;
                ejVar2.c();
            }
            cjVar.a();
            this.f5906a.j(cjVar.b(), cjVar.c());
            eh.c0(this.f5906a.f743a, this);
        }
    }
}
