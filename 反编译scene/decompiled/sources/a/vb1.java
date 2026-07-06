package a;

import com.omarea.vtools.activities.ActivityFreezeApps;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vb1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wb1 f7676a;

    public vb1(wb1 wb1Var) {
        this.f7676a = wb1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityFreezeApps.access$getProcessBarDialog$p(ActivityFreezeApps.this).c();
        ActivityFreezeApps.this.loadData();
    }
}
