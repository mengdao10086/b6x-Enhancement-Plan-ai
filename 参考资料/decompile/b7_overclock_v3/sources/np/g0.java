package np;

import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class g0 implements ir.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ir.e f42407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f42408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ir.i f42409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final BigInteger f42410j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final BigInteger f42411k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BigInteger f42412l;

    public g0(co.l lVar) {
        this(lVar.y(), lVar.B(), lVar.E(), lVar.C(), lVar.F());
    }

    public g0(ir.e eVar, ir.i iVar, BigInteger bigInteger) {
        this(eVar, iVar, bigInteger, ir.d.f35647b, null);
    }

    public g0(ir.e eVar, ir.i iVar, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eVar, iVar, bigInteger, bigInteger2, null);
    }

    public g0(ir.e eVar, ir.i iVar, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.f42412l = null;
        Objects.requireNonNull(eVar, "curve");
        Objects.requireNonNull(bigInteger, "n");
        this.f42407g = eVar;
        this.f42409i = h(eVar, iVar);
        this.f42410j = bigInteger;
        this.f42411k = bigInteger2;
        this.f42408h = org.bouncycastle.util.a.p(bArr);
    }

    public static ir.i h(ir.e eVar, ir.i iVar) {
        Objects.requireNonNull(iVar, "Point cannot be null");
        ir.i iVarB = ir.c.l(eVar, iVar).B();
        if (iVarB.v()) {
            throw new IllegalArgumentException("Point at infinity");
        }
        if (iVarB.x()) {
            return iVarB;
        }
        throw new IllegalArgumentException("Point not on curve");
    }

    public ir.e a() {
        return this.f42407g;
    }

    public ir.i b() {
        return this.f42409i;
    }

    public BigInteger c() {
        return this.f42411k;
    }

    public synchronized BigInteger d() {
        if (this.f42412l == null) {
            this.f42412l = org.bouncycastle.util.b.o(this.f42410j, this.f42411k);
        }
        return this.f42412l;
    }

    public BigInteger e() {
        return this.f42410j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.f42407g.m(g0Var.f42407g) && this.f42409i.e(g0Var.f42409i) && this.f42410j.equals(g0Var.f42410j);
    }

    public byte[] f() {
        return org.bouncycastle.util.a.p(this.f42408h);
    }

    public BigInteger g(BigInteger bigInteger) {
        Objects.requireNonNull(bigInteger, "Scalar cannot be null");
        if (bigInteger.compareTo(ir.d.f35647b) < 0 || bigInteger.compareTo(e()) >= 0) {
            throw new IllegalArgumentException("Scalar is not in the interval [1, n - 1]");
        }
        return bigInteger;
    }

    public int hashCode() {
        return ((((this.f42407g.hashCode() ^ 1028) * 257) ^ this.f42409i.hashCode()) * 257) ^ this.f42410j.hashCode();
    }

    public ir.i i(ir.i iVar) {
        return h(a(), iVar);
    }
}
