package a;

import android.os.SystemClock;
import com.omarea.vtools.AccessibilitySceneMode;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hq0 extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6333a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ iq0 f1201a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Timer f1202a;
    public final /* synthetic */ int b;

    public hq0(Timer timer, int i, iq0 iq0Var) {
        this.f1202a = timer;
        this.b = i;
        this.f1201a = iq0Var;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (!f92.a(this.f1202a, this.f1201a.f1403a)) {
            cancel();
            return;
        }
        if (SystemClock.uptimeMillis() - AccessibilitySceneMode.f8452a.a() < 60000) {
            this.f1201a.T(false);
        }
        int i = this.f6333a + this.b;
        this.f6333a = i;
        int i2 = i % 60;
        this.f6333a = i2;
        if (i2 == 0) {
            qc2.d(xd2.a(qe2.b()), null, null, new gq0(this, null), 3, null);
        }
    }
}
