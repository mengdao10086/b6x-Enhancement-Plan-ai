package a;

import com.omarea.vtools.activities.ActivityFreezeApps;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rb1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ sb1 f7287a;

    public rb1(sb1 sb1Var) {
        this.f7287a = sb1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityFreezeApps.access$getProcessBarDialog$p(ActivityFreezeApps.this).c();
        ActivityFreezeApps.this.loadData();
    }
}
