package a;

import com.omarea.vtools.activities.ActivityFreezeApps;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ic1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityFreezeApps.d0 f6398a;

    public ic1(ActivityFreezeApps.d0 d0Var) {
        this.f6398a = d0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityFreezeApps.access$getProcessBarDialog$p(ActivityFreezeApps.this).c();
        ActivityFreezeApps.this.loadData();
    }
}
