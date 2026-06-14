package a;

import com.omarea.vtools.activities.ActivityAddin;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class m71 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityAddin f6780a;

    public m71(ActivityAddin activityAddin, ActivityAddin activityAddin2, ActivityAddin activityAddin3) {
        this.f6780a = activityAddin3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        new yk1(this.f6780a).b(hz0.f1282a.X());
    }
}
