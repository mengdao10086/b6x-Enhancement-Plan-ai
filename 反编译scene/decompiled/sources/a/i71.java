package a;

import com.omarea.vtools.activities.ActivityAddin;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class i71 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityAddin f6382a;

    public i71(ActivityAddin activityAddin, ActivityAddin activityAddin2, ActivityAddin activityAddin3) {
        this.f6382a = activityAddin3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        new ei1(this.f6382a).b();
    }
}
