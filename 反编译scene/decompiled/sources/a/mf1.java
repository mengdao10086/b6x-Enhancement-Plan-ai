package a;

import com.omarea.vtools.activities.ActivityProcess;
import java.util.TimerTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mf1 extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityProcess f6803a;

    public mf1(ActivityProcess activityProcess) {
        this.f6803a = activityProcess;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f6803a.v();
    }
}
