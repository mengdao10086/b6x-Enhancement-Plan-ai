package rp;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.g0;
import np.j0;
import np.l0;
import np.m0;

/* JADX INFO: loaded from: classes5.dex */
public class f implements ir.d, org.bouncycastle.crypto.p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f48991g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j0 f48992h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SecureRandom f48993i;

    public f() {
        this.f48991g = new x();
    }

    public f(c cVar) {
        this.f48991g = cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    @Override // org.bouncycastle.crypto.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r2, org.bouncycastle.crypto.k r3) {
        /*
            r1 = this;
            if (r2 == 0) goto L18
            boolean r0 = r3 instanceof np.w1
            if (r0 == 0) goto L15
            np.w1 r3 = (np.w1) r3
            org.bouncycastle.crypto.k r0 = r3.a()
            np.l0 r0 = (np.l0) r0
            r1.f48992h = r0
            java.security.SecureRandom r3 = r3.b()
            goto L1d
        L15:
            np.l0 r3 = (np.l0) r3
            goto L1a
        L18:
            np.m0 r3 = (np.m0) r3
        L1a:
            r1.f48992h = r3
            r3 = 0
        L1d:
            if (r2 == 0) goto L29
            rp.c r2 = r1.f48991g
            boolean r2 = r2.b()
            if (r2 != 0) goto L29
            r2 = 1
            goto L2a
        L29:
            r2 = 0
        L2a:
            java.security.SecureRandom r2 = r1.g(r2, r3)
            r1.f48993i = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rp.f.a(boolean, org.bouncycastle.crypto.k):void");
    }

    @Override // org.bouncycastle.crypto.o
    public BigInteger[] b(byte[] bArr) {
        g0 g0VarD = this.f48992h.d();
        BigInteger bigIntegerE = g0VarD.e();
        BigInteger bigIntegerD = d(bigIntegerE, bArr);
        BigInteger bigIntegerE2 = ((l0) this.f48992h).e();
        if (this.f48991g.b()) {
            this.f48991g.d(bigIntegerE, bigIntegerE2, bArr);
        } else {
            this.f48991g.c(bigIntegerE, this.f48993i);
        }
        ir.h hVarE = e();
        while (true) {
            BigInteger bigIntegerA = this.f48991g.a();
            BigInteger bigIntegerMod = hVarE.a(g0VarD.b(), bigIntegerA).B().f().v().mod(bigIntegerE);
            BigInteger bigInteger = ir.d.f35646a;
            if (!bigIntegerMod.equals(bigInteger)) {
                BigInteger bigIntegerMod2 = org.bouncycastle.util.b.n(bigIntegerE, bigIntegerA).multiply(bigIntegerD.add(bigIntegerE2.multiply(bigIntegerMod))).mod(bigIntegerE);
                if (!bigIntegerMod2.equals(bigInteger)) {
                    return new BigInteger[]{bigIntegerMod, bigIntegerMod2};
                }
            }
        }
    }

    @Override // org.bouncycastle.crypto.o
    public boolean c(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigIntegerR;
        ir.f fVarF;
        g0 g0VarD = this.f48992h.d();
        BigInteger bigIntegerE = g0VarD.e();
        BigInteger bigIntegerD = d(bigIntegerE, bArr);
        BigInteger bigInteger3 = ir.d.f35647b;
        if (bigInteger.compareTo(bigInteger3) < 0 || bigInteger.compareTo(bigIntegerE) >= 0 || bigInteger2.compareTo(bigInteger3) < 0 || bigInteger2.compareTo(bigIntegerE) >= 0) {
            return false;
        }
        BigInteger bigIntegerO = org.bouncycastle.util.b.o(bigIntegerE, bigInteger2);
        ir.i iVarV = ir.c.v(g0VarD.b(), bigIntegerD.multiply(bigIntegerO).mod(bigIntegerE), ((m0) this.f48992h).e(), bigInteger.multiply(bigIntegerO).mod(bigIntegerE));
        if (iVarV.v()) {
            return false;
        }
        ir.e eVarI = iVarV.i();
        if (eVarI == null || (bigIntegerR = eVarI.r()) == null || bigIntegerR.compareTo(ir.d.f35651f) > 0 || (fVarF = f(eVarI.s(), iVarV)) == null || fVarF.j()) {
            return iVarV.B().f().v().mod(bigIntegerE).equals(bigInteger);
        }
        ir.f fVarQ = iVarV.q();
        while (eVarI.B(bigInteger)) {
            if (eVarI.n(bigInteger).k(fVarF).equals(fVarQ)) {
                return true;
            }
            bigInteger = bigInteger.add(bigIntegerE);
        }
        return false;
    }

    public BigInteger d(BigInteger bigInteger, byte[] bArr) {
        int iBitLength = bigInteger.bitLength();
        int length = bArr.length * 8;
        BigInteger bigInteger2 = new BigInteger(1, bArr);
        return iBitLength < length ? bigInteger2.shiftRight(length - iBitLength) : bigInteger2;
    }

    public ir.h e() {
        return new ir.k();
    }

    public ir.f f(int i10, ir.i iVar) {
        if (i10 != 1) {
            if (i10 == 2 || i10 == 3 || i10 == 4) {
                return iVar.s(0).p();
            }
            if (i10 != 6 && i10 != 7) {
                return null;
            }
        }
        return iVar.s(0);
    }

    public SecureRandom g(boolean z10, SecureRandom secureRandom) {
        if (z10) {
            return org.bouncycastle.crypto.n.g(secureRandom);
        }
        return null;
    }

    @Override // org.bouncycastle.crypto.p
    public BigInteger getOrder() {
        return this.f48992h.d().e();
    }
}
