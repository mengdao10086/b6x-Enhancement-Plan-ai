package a;

import com.omarea.vtools.activities.ActivityFreezeApps;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fc1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gc1 f6093a;

    public fc1(gc1 gc1Var) {
        this.f6093a = gc1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityFreezeApps.this.loadData();
        ActivityFreezeApps.access$getProcessBarDialog$p(ActivityFreezeApps.this).c();
    }
}
