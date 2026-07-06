package a;

import com.omarea.vtools.activities.ActivityCpuControl;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ka1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityCpuControl.u f6589a;

    public ka1(ActivityCpuControl.u uVar) {
        this.f6589a = uVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityCpuControl.this.finish();
    }
}
