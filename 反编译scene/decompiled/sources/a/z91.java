package a;

import com.omarea.vtools.activities.ActivityCpuControl;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class z91 implements ActivityCpuControl.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityCpuControl.l f8049a;

    public z91(ActivityCpuControl.l lVar) {
        this.f8049a = lVar;
    }

    @Override // com.omarea.vtools.activities.ActivityCpuControl.a
    public void a(boolean[] zArr) {
        f92.d(zArr, "result");
        ActivityCpuControl.this.f5220b.cpusetTop = ActivityCpuControl.this.V(zArr);
        x60 x60Var = x60.f7856a;
        String str = ActivityCpuControl.this.f5220b.cpusetTop;
        f92.c(str, "status.cpusetTop");
        x60Var.j("/dev/cpuset/top-app/cpus", str);
    }
}
