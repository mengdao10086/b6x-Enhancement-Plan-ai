package a;

import com.omarea.Scene;
import com.omarea.vtools.activities.ActivityFreezeApps;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gc1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityFreezeApps.x f6194a;

    public gc1(ActivityFreezeApps.x xVar) {
        this.f6194a = xVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Scene.f4798a.i(new fc1(this));
    }
}
