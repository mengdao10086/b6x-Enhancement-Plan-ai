package a;

import com.omarea.vtools.activities.ActivityPowerBench;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class he1 implements s80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityPowerBench.m f6307a;

    public he1(ActivityPowerBench.m mVar) {
        this.f6307a = mVar;
    }

    @Override // a.s80
    public void a(List<n30> list, boolean[] zArr) {
        f92.d(list, "selected");
        f92.d(zArr, "status");
        n30 n30Var = (n30) i52.A(list);
        ty0 ty0VarR = ActivityPowerBench.this.R();
        String strE = n30Var.e();
        f92.b(strE);
        ArrayList<qy0> arrayListH = ty0VarR.h(Long.parseLong(strE));
        Object objB = n30Var.b();
        if (objB == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.store.PowerBenchStore.StatSession");
        }
        ActivityPowerBench.this.S((ry0) objB, arrayListH);
    }
}
