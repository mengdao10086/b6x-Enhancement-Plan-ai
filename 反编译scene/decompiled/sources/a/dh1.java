package a;

import com.omarea.vtools.activities.ActivitySwap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dh1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ eh1 f5901a;

    public dh1(eh1 eh1Var) {
        this.f5901a = eh1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivitySwap.j(ActivitySwap.this).c();
    }
}
