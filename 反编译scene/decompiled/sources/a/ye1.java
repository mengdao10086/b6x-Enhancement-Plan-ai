package a;

import com.omarea.ui.power.PowerStatView;
import com.omarea.vtools.activities.ActivityPowerStat;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ye1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityPowerStat.j f7975a;

    public ye1(ActivityPowerStat.j jVar) {
        this.f7975a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PowerStatView powerStatView = (PowerStatView) ActivityPowerStat.this._$_findCachedViewById(t61.view_time);
        if (powerStatView != null) {
            powerStatView.invalidate();
        }
    }
}
