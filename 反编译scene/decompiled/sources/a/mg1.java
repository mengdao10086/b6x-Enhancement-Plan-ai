package a;

import com.omarea.vtools.activities.ActivitySwap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mg1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivitySwap.f f6807a;

    public mg1(ActivitySwap.f fVar) {
        this.f6807a = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivitySwap.l(ActivitySwap.this).edit().putBoolean(hz0.f1282a.s0(), false).apply();
        ActivitySwap.this.f5513a.f(ActivitySwap.l(ActivitySwap.this));
        s60.f7366a.a("sync\nsleep 2\nsvc power reboot || reboot");
    }
}
