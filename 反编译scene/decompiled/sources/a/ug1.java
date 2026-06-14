package a;

import com.omarea.Scene;
import com.omarea.vtools.activities.ActivitySwap;
import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ug1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivitySwap.u f7594a;
    public final /* synthetic */ boolean b;

    public ug1(ActivitySwap.u uVar, boolean z) {
        this.f7594a = uVar;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Timer timerM = ActivitySwap.this.M();
        if (this.b) {
            ActivitySwap.this.f5510a.D();
        } else {
            ActivitySwap.this.f5510a.E();
        }
        timerM.cancel();
        Scene.f4798a.i(new tg1(this));
    }
}
