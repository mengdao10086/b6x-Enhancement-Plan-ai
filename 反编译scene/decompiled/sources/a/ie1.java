package a;

import com.omarea.vtools.activities.ActivityPowerBench;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ie1 extends g92 implements g82<n30, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityPowerBench.m f6404a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ie1(ActivityPowerBench.m mVar) {
        super(1);
        this.f6404a = mVar;
    }

    public final boolean a(n30 n30Var) {
        f92.d(n30Var, "it");
        ty0 ty0VarR = ActivityPowerBench.this.R();
        String strE = n30Var.e();
        f92.b(strE);
        ty0VarR.c(Long.parseLong(strE));
        return true;
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ Boolean f(n30 n30Var) {
        a(n30Var);
        return Boolean.TRUE;
    }
}
