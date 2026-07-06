package a;

import com.omarea.vtools.activities.ActivityChargeStat;
import java.util.TimerTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class p91 extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityChargeStat f7098a;

    public p91(ActivityChargeStat activityChargeStat) {
        this.f7098a = activityChargeStat;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f7098a.o();
    }
}
