package a;

import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vp0 implements c90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wp0 f7714a;

    public vp0(wp0 wp0Var, Runnable runnable) {
        this.f7714a = wp0Var;
    }

    @Override // a.c90
    public void a(List<n30> list, boolean[] zArr) {
        f92.d(list, "selected");
        f92.d(zArr, "status");
        a70.j(((n30) i52.A(list)).e());
        qc2.d(xd2.a(qe2.b()), null, null, new up0(this, null), 3, null);
    }
}
