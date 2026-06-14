package a;

import com.omarea.vtools.activities.ActivityCpuControl;
import java.util.TimerTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ia1 extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityCpuControl f6392a;

    public ia1(ActivityCpuControl activityCpuControl) {
        this.f6392a = activityCpuControl;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.f6392a.c) {
            qc2.d(xd2.a(qe2.b()), null, null, new ha1(this, null), 3, null);
        }
    }
}
