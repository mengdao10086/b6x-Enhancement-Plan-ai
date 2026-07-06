package a;

import com.omarea.vtools.activities.ActivitySwap;
import java.util.TimerTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ng1 extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivitySwap f6913a;

    public ng1(ActivitySwap activitySwap) {
        this.f6913a = activitySwap;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f6913a.B().i();
    }
}
