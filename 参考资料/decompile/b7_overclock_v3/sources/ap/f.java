package ap;

import java.math.BigInteger;
import np.g0;
import np.m0;

/* JADX INFO: loaded from: classes5.dex */
public class f implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m0 f8819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f8820b;

    public f(BigInteger bigInteger) {
        this.f8820b = bigInteger;
    }

    @Override // ap.k
    public void a(org.bouncycastle.crypto.k kVar) {
        if (!(kVar instanceof m0)) {
            throw new IllegalArgumentException("ECPublicKeyParameters are required for fixed transform.");
        }
        this.f8819a = (m0) kVar;
    }

    @Override // ap.j
    public BigInteger b() {
        return this.f8820b;
    }

    @Override // ap.k
    public i c(i iVar) {
        m0 m0Var = this.f8819a;
        if (m0Var == null) {
            throw new IllegalStateException("ECFixedTransform not initialised");
        }
        g0 g0VarD = m0Var.d();
        BigInteger bigIntegerE = g0VarD.e();
        ir.h hVarD = d();
        BigInteger bigIntegerMod = this.f8820b.mod(bigIntegerE);
        ir.i[] iVarArr = {hVarD.a(g0VarD.b(), bigIntegerMod).a(ir.c.a(g0VarD.a(), iVar.b())), this.f8819a.e().z(bigIntegerMod).a(ir.c.a(g0VarD.a(), iVar.c()))};
        g0VarD.a().C(iVarArr);
        return new i(iVarArr[0], iVarArr[1]);
    }

    public ir.h d() {
        return new ir.k();
    }
}
