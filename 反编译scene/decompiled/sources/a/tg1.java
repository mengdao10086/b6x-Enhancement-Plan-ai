package a;

import com.omarea.vtools.activities.ActivitySwap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class tg1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ug1 f7498a;

    public tg1(ug1 ug1Var) {
        this.f7498a = ug1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivitySwap.l(ActivitySwap.this).edit().putBoolean(hz0.f1282a.s0(), false).apply();
        ActivitySwap.j(ActivitySwap.this).c();
        ActivitySwap.this.B().i();
    }
}
