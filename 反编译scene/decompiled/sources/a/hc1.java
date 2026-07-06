package a;

import com.omarea.vtools.activities.ActivityFreezeApps;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hc1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityFreezeApps.b0 f6301a;

    public hc1(ActivityFreezeApps.b0 b0Var) {
        this.f6301a = b0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityFreezeApps.b0 b0Var = this.f6301a;
        ActivityFreezeApps.this.removeAndUninstall(b0Var.f5297a);
        ActivityFreezeApps.this.loadData();
    }
}
