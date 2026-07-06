package a;

import com.omarea.vtools.activities.ActivityAddin;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class h71 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityAddin f6284a;

    public h71(ActivityAddin activityAddin, ActivityAddin activityAddin2, ActivityAddin activityAddin3) {
        this.f6284a = activityAddin2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        new gi1(this.f6284a).f();
    }
}
