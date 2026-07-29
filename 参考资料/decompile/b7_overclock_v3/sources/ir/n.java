package ir;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class n extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f35720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mr.d f35721b;

    public n(e eVar, mr.d dVar) {
        if (eVar == null || eVar.y() == null) {
            throw new IllegalArgumentException("Need curve with known group order");
        }
        this.f35720a = eVar;
        this.f35721b = dVar;
    }

    @Override // ir.b
    public i c(i iVar, BigInteger bigInteger) {
        if (!this.f35720a.m(iVar.i())) {
            throw new IllegalStateException();
        }
        BigInteger[] bigIntegerArrC = this.f35721b.c(bigInteger.mod(iVar.i().y()));
        BigInteger bigInteger2 = bigIntegerArrC[0];
        BigInteger bigInteger3 = bigIntegerArrC[1];
        return this.f35721b.b() ? c.f(this.f35721b, iVar, bigInteger2, bigInteger3) : c.e(iVar, bigInteger2, mr.c.c(this.f35721b, iVar), bigInteger3);
    }
}
