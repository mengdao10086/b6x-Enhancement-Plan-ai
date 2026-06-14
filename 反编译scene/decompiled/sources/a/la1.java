package a;

import com.omarea.vtools.activities.ActivityCpuControl;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class la1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityCpuControl.v f6688a;

    public la1(ActivityCpuControl.v vVar) {
        this.f6688a = vVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityCpuControl.this.f5212a.b(this.f6688a.f5237a);
    }
}
