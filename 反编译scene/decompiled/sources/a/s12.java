package a;

import java.util.TimerTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class s12 extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u12 f7353a;

    public s12(u12 u12Var) {
        this.f7353a = u12Var;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f7353a.t();
    }
}
