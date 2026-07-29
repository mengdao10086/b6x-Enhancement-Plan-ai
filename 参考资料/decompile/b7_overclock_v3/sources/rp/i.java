package rp;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.i0;
import np.j0;
import np.l0;
import np.m0;
import np.w1;
import org.bouncycastle.crypto.DataLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class i implements org.bouncycastle.crypto.p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f48998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j0 f48999h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SecureRandom f49000i;

    @Override // org.bouncycastle.crypto.o
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        j0 j0Var;
        this.f48998g = z10;
        if (!z10) {
            j0Var = (m0) kVar;
        } else {
            if (kVar instanceof w1) {
                w1 w1Var = (w1) kVar;
                this.f49000i = w1Var.b();
                this.f48999h = (l0) w1Var.a();
                return;
            }
            this.f49000i = org.bouncycastle.crypto.n.f();
            j0Var = (l0) kVar;
        }
        this.f48999h = j0Var;
    }

    @Override // org.bouncycastle.crypto.o
    public BigInteger[] b(byte[] bArr) {
        org.bouncycastle.crypto.c cVarB;
        BigInteger bigIntegerMod;
        if (!this.f48998g) {
            throw new IllegalStateException("not initialised for signing");
        }
        BigInteger order = getOrder();
        BigInteger bigInteger = new BigInteger(1, bArr);
        l0 l0Var = (l0) this.f48999h;
        if (bigInteger.compareTo(order) >= 0) {
            throw new DataLengthException("input too large for ECNR key");
        }
        do {
            fp.p pVar = new fp.p();
            pVar.a(new i0(l0Var.d(), this.f49000i));
            cVarB = pVar.b();
            bigIntegerMod = ((m0) cVarB.b()).e().f().v().add(bigInteger).mod(order);
        } while (bigIntegerMod.equals(ir.d.f35646a));
        return new BigInteger[]{bigIntegerMod, ((l0) cVarB.a()).e().subtract(bigIntegerMod.multiply(l0Var.e())).mod(order)};
    }

    @Override // org.bouncycastle.crypto.o
    public boolean c(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        if (this.f48998g) {
            throw new IllegalStateException("not initialised for verifying");
        }
        m0 m0Var = (m0) this.f48999h;
        BigInteger bigIntegerE = m0Var.d().e();
        int iBitLength = bigIntegerE.bitLength();
        BigInteger bigInteger3 = new BigInteger(1, bArr);
        if (bigInteger3.bitLength() > iBitLength) {
            throw new DataLengthException("input too large for ECNR key.");
        }
        BigInteger bigIntegerD = d(m0Var, bigInteger, bigInteger2);
        return bigIntegerD != null && bigIntegerD.equals(bigInteger3.mod(bigIntegerE));
    }

    public final BigInteger d(m0 m0Var, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigIntegerE = m0Var.d().e();
        if (bigInteger.compareTo(ir.d.f35647b) < 0 || bigInteger.compareTo(bigIntegerE) >= 0 || bigInteger2.compareTo(ir.d.f35646a) < 0 || bigInteger2.compareTo(bigIntegerE) >= 0) {
            return null;
        }
        ir.i iVarB = ir.c.v(m0Var.d().b(), bigInteger2, m0Var.e(), bigInteger).B();
        if (iVarB.v()) {
            return null;
        }
        return bigInteger.subtract(iVarB.f().v()).mod(bigIntegerE);
    }

    public byte[] e(BigInteger bigInteger, BigInteger bigInteger2) {
        if (this.f48998g) {
            throw new IllegalStateException("not initialised for verifying/recovery");
        }
        BigInteger bigIntegerD = d((m0) this.f48999h, bigInteger, bigInteger2);
        if (bigIntegerD != null) {
            return org.bouncycastle.util.b.c(bigIntegerD);
        }
        return null;
    }

    @Override // org.bouncycastle.crypto.p
    public BigInteger getOrder() {
        return this.f48999h.d().e();
    }
}
