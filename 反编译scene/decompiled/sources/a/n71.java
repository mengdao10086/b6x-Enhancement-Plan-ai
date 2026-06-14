package a;

import com.omarea.vtools.activities.ActivityAddin;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class n71 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityAddin f6884a;

    public n71(ActivityAddin activityAddin, ActivityAddin activityAddin2, ActivityAddin activityAddin3) {
        this.f6884a = activityAddin3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        new oh1(this.f6884a).i();
    }
}
