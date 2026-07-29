package mr;

import ir.j;
import ir.s;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f41583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f41584b;

    public g(ir.e eVar, h hVar) {
        this.f41583a = hVar;
        this.f41584b = new s(eVar.n(hVar.a()));
    }

    @Override // mr.a
    public j a() {
        return this.f41584b;
    }

    @Override // mr.a
    public boolean b() {
        return true;
    }

    @Override // mr.d
    public BigInteger[] c(BigInteger bigInteger) {
        return c.b(this.f41583a.c(), bigInteger);
    }
}
