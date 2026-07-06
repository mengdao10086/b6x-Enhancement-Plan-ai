package a;

import android.os.Handler;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class n60 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r60 f6880a;

    public n60(r60 r60Var) {
        this.f6880a = r60Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handlerC;
        Handler handlerC2;
        Boolean bool;
        Process processD = this.f6880a.d();
        f92.b(processD);
        if (processD.waitFor() == 0) {
            handlerC = this.f6880a.c();
            handlerC2 = this.f6880a.c();
            bool = Boolean.TRUE;
        } else {
            handlerC = this.f6880a.c();
            handlerC2 = this.f6880a.c();
            bool = Boolean.FALSE;
        }
        handlerC.sendMessage(handlerC2.obtainMessage(10, bool));
        this.f6880a.a();
    }
}
