package a;

import com.omarea.vtools.activities.ActivityFreezeApps;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pb1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityFreezeApps.f f7101a;

    public pb1(ActivityFreezeApps.f fVar) {
        this.f7101a = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            ActivityFreezeApps.this.loadData();
            ActivityFreezeApps.access$getProcessBarDialog$p(ActivityFreezeApps.this).c();
        } catch (Exception unused) {
        }
    }
}
