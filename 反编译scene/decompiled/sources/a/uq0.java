package a;

import com.omarea.model.CpuStatus;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class uq0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l92 f7622a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CpuStatus f3205a;
    public final /* synthetic */ l92 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uq0(l92 l92Var, l92 l92Var2, zq0 zq0Var, CpuStatus cpuStatus, CpuStatus cpuStatus2, CpuStatus cpuStatus3, CpuStatus cpuStatus4) {
        super(1);
        this.f7622a = l92Var;
        this.b = l92Var2;
        this.f3205a = cpuStatus3;
    }

    public final void a(l30 l30Var) throws Exception {
        f92.d(l30Var, "$receiver");
        l30Var.H("mode", new String[]{"performance"});
        if (this.f3205a != null) {
            l30Var.G("fas", new tq0(this));
        }
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) throws Exception {
        a(l30Var);
        return m42.f6769a;
    }
}
