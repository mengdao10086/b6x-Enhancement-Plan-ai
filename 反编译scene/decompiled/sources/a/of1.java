package a;

import com.omarea.vtools.activities.ActivityQuickStart;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class of1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityQuickStart.a f7017a;

    public of1(ActivityQuickStart.a aVar) {
        this.f7017a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityQuickStart activityQuickStart = (ActivityQuickStart) this.f7017a.f5475a.get();
        if (activityQuickStart != null) {
            activityQuickStart.g();
        }
    }
}
