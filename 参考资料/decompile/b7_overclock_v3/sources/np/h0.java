package np;

/* JADX INFO: loaded from: classes5.dex */
public class h0 extends k0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final gm.y f42425n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final gm.y f42426o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final gm.y f42427p;

    public h0(g0 g0Var, gm.y yVar, gm.y yVar2) {
        this(g0Var, yVar, yVar2, null);
    }

    public h0(g0 g0Var, gm.y yVar, gm.y yVar2, gm.y yVar3) {
        super(yVar, g0Var);
        if ((g0Var instanceof k0) && !yVar.C(((k0) g0Var).j())) {
            throw new IllegalArgumentException("named parameters do not match publicKeyParamSet value");
        }
        this.f42425n = yVar;
        this.f42426o = yVar2;
        this.f42427p = yVar3;
    }

    public gm.y k() {
        return this.f42426o;
    }

    public gm.y l() {
        return this.f42427p;
    }

    public gm.y m() {
        return this.f42425n;
    }
}
