package a;

import com.omarea.vtools.activities.ActivityCpuControl;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class x91 implements ActivityCpuControl.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityCpuControl.j f7866a;

    public x91(ActivityCpuControl.j jVar) {
        this.f7866a = jVar;
    }

    @Override // com.omarea.vtools.activities.ActivityCpuControl.a
    public void a(boolean[] zArr) {
        f92.d(zArr, "result");
        ActivityCpuControl.this.f5220b.cpusetSysBg = ActivityCpuControl.this.V(zArr);
        x60 x60Var = x60.f7856a;
        String str = ActivityCpuControl.this.f5220b.cpusetSysBg;
        f92.c(str, "status.cpusetSysBg");
        x60Var.j("/dev/cpuset/system-background/cpus", str);
    }
}
