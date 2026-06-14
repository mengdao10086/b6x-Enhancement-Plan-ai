package a;

import com.omarea.Scene;
import com.omarea.vtools.activities.ActivityFreezeApps;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sb1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityFreezeApps.h f7381a;

    public sb1(ActivityFreezeApps.h hVar) {
        this.f7381a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Scene.f4798a.i(new rb1(this));
    }
}
