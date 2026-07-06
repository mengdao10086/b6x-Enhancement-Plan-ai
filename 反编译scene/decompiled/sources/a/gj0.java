package a;

import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gj0 extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hj0 f6212a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Timer f1020a;

    public gj0(hj0 hj0Var, Timer timer) {
        this.f6212a = hj0Var;
        this.f1020a = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (!f92.a(this.f6212a.f1173a, this.f1020a)) {
            cancel();
        } else {
            this.f6212a.f6316a.i();
        }
    }
}
