package a;

import com.omarea.Scene;
import com.omarea.vtools.activities.ActivitySwap;
import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class eh1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6004a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivitySwap.a0 f736a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f737a;

    public eh1(ActivitySwap.a0 a0Var, String str, int i) {
        this.f736a = a0Var;
        this.f737a = str;
        this.f6004a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if ((ActivitySwap.this.f5510a.s() && (!f92.a(this.f737a, ActivitySwap.this.f5510a.e()))) || this.f6004a != ActivitySwap.this.f5510a.r()) {
            Timer timerS = ActivitySwap.this.S();
            ActivitySwap.this.f5510a.G();
            timerS.cancel();
        }
        Scene.f4798a.i(new ch1(this));
        ActivitySwap.this.f5510a.B(this.f6004a, this.f737a);
        ActivitySwap.this.B().i();
        Scene.f4798a.i(new dh1(this));
    }
}
