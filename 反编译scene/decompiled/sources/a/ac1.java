package a;

import com.omarea.Scene;
import com.omarea.vtools.activities.ActivityFreezeApps;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ac1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityFreezeApps.p f5592a;

    public ac1(ActivityFreezeApps.p pVar) {
        this.f5592a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Scene.f4798a.i(new zb1(this));
    }
}
