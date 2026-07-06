package a;

import com.omarea.data.customer.BatteryReceiver;
import java.util.TimerTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ja0 extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BatteryReceiver f6492a;

    public ja0(BatteryReceiver batteryReceiver) {
        this.f6492a = batteryReceiver;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f6492a.governorRun();
    }
}
