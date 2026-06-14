package a;

import com.omarea.vtools.activities.ActivityCpuControl;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class w91 implements ActivityCpuControl.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityCpuControl.i f7768a;

    public w91(ActivityCpuControl.i iVar) {
        this.f7768a = iVar;
    }

    @Override // com.omarea.vtools.activities.ActivityCpuControl.a
    public void a(boolean[] zArr) {
        f92.d(zArr, "result");
        ActivityCpuControl.this.f5220b.cpusetBg = ActivityCpuControl.this.V(zArr);
        x60 x60Var = x60.f7856a;
        String str = ActivityCpuControl.this.f5220b.cpusetBg;
        f92.c(str, "status.cpusetBg");
        x60Var.j("/dev/cpuset/background/cpus", str);
    }
}
