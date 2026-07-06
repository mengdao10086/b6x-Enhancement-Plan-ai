package a;

import com.omarea.Scene;
import com.omarea.vtools.activities.ActivitySwap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rg1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7298a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivitySwap.p f2740a;

    public rg1(ActivitySwap.p pVar, int i) {
        this.f2740a = pVar;
        this.f7298a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Scene.f4798a.i(new pg1(this));
        ActivitySwap.this.f5510a.A(this.f7298a);
        ActivitySwap.l(ActivitySwap.this).edit().putInt(hz0.f1282a.v0(), this.f7298a).apply();
        ActivitySwap.this.B().i();
        Scene.f4798a.i(new qg1(this, System.currentTimeMillis() - jCurrentTimeMillis));
    }
}
