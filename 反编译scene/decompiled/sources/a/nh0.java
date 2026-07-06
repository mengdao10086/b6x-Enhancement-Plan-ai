package a;

import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nh0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ oh0 f6914a;

    public nh0(oh0 oh0Var) {
        this.f6914a = oh0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6914a.f2246a.setBackground(null);
        Runnable runnable = this.f6914a.f2247a;
        if (runnable != null) {
            runnable.run();
        }
        this.f6914a.f7021a.c();
        Scene.c.p(Scene.f4798a, "OK ^_^", 0, 2, null);
    }
}
