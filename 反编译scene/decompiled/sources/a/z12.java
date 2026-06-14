package a;

import java.util.TimerTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class z12 extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d22 f8028a;

    public z12(d22 d22Var) {
        this.f8028a = d22Var;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        qc2.d(xd2.a(qe2.b()), null, null, new y12(this, null), 3, null);
    }
}
