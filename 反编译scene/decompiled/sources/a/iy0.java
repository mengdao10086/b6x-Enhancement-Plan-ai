package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class iy0 extends g92 implements g82<l30, m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jy0 f6453a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iy0(jy0 jy0Var) {
        super(1);
        this.f6453a = jy0Var;
    }

    public final void a(l30 l30Var) {
        f92.d(l30Var, "$receiver");
        ly0 ly0Var = this.f6453a.f6554a;
        l30Var.E("fpsMax", Float.valueOf(ly0Var.f1856a.O(ly0Var.f6747a)));
        ly0 ly0Var2 = this.f6453a.f6554a;
        l30Var.E("fpsMin", Float.valueOf(ly0Var2.f1856a.P(ly0Var2.f6747a)));
        ly0 ly0Var3 = this.f6453a.f6554a;
        l30Var.E("fpsAvg", Float.valueOf(ly0Var3.f1856a.L(ly0Var3.f6747a)));
        ly0 ly0Var4 = this.f6453a.f6554a;
        l30Var.E("fpsVariance", Double.valueOf(ly0Var4.f1856a.Q(ly0Var4.f6747a)));
        ly0 ly0Var5 = this.f6453a.f6554a;
        l30Var.E("bigJank", Integer.valueOf(ly0Var5.f1856a.u(ly0Var5.f6747a)));
        ly0 ly0Var6 = this.f6453a.f6554a;
        l30Var.E("jank", Integer.valueOf(ly0Var6.f1856a.T(ly0Var6.f6747a)));
        ly0 ly0Var7 = this.f6453a.f6554a;
        l30Var.E("powerAvg", Double.valueOf(ly0Var7.f1856a.V(ly0Var7.f6747a)));
        ly0 ly0Var8 = this.f6453a.f6554a;
        l30Var.E("powerMin", Double.valueOf(ly0Var8.f1856a.Y(ly0Var8.f6747a)));
        ly0 ly0Var9 = this.f6453a.f6554a;
        l30Var.E("powerMax", Double.valueOf(ly0Var9.f1856a.X(ly0Var9.f6747a)));
        ly0 ly0Var10 = this.f6453a.f6554a;
        l30Var.E("batTempMax", Float.valueOf(ly0Var10.f1856a.s(ly0Var10.f6747a)));
        ly0 ly0Var11 = this.f6453a.f6554a;
        l30Var.E("cpuTempMax", Float.valueOf(ly0Var11.f1856a.D(ly0Var11.f6747a)));
        ly0 ly0Var12 = this.f6453a.f6554a;
        l30Var.E("cpuTempMin", Float.valueOf(ly0Var12.f1856a.E(ly0Var12.f6747a)));
        ly0 ly0Var13 = this.f6453a.f6554a;
        l30Var.E("cpuTempAvg", Float.valueOf(ly0Var13.f1856a.B(ly0Var13.f6747a)));
        l30Var.E("duration", Integer.valueOf(this.f6453a.f6554a.f1854a.g() + 1));
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ m42 f(l30 l30Var) {
        a(l30Var);
        return m42.f6769a;
    }
}
