package rp;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.b0;

/* JADX INFO: loaded from: classes5.dex */
public class d implements org.bouncycastle.crypto.p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f48985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public np.x f48986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SecureRandom f48987i;

    public d() {
        this.f48985g = new x();
    }

    public d(c cVar) {
        this.f48985g = cVar;
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
            np.a0 r0 = (np.a0) r0
            r1.f48986h = r0
            java.security.SecureRandom r3 = r3.b()
            goto L1d
        L15:
            np.a0 r3 = (np.a0) r3
            goto L1a
        L18:
            np.b0 r3 = (np.b0) r3
        L1a:
            r1.f48986h = r3
            r3 = 0
        L1d:
            if (r2 == 0) goto L29
            rp.c r2 = r1.f48985g
            boolean r2 = r2.b()
            if (r2 != 0) goto L29
            r2 = 1
            goto L2a
        L29:
            r2 = 0
        L2a:
            java.security.SecureRandom r2 = r1.f(r2, r3)
            r1.f48987i = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rp.d.a(boolean, org.bouncycastle.crypto.k):void");
    }

    @Override // org.bouncycastle.crypto.o
    public BigInteger[] b(byte[] bArr) {
        np.z zVarD = this.f48986h.d();
        BigInteger bigIntegerC = zVarD.c();
        BigInteger bigIntegerD = d(bigIntegerC, bArr);
        BigInteger bigIntegerE = ((np.a0) this.f48986h).e();
        if (this.f48985g.b()) {
            this.f48985g.d(bigIntegerC, bigIntegerE, bArr);
        } else {
            this.f48985g.c(bigIntegerC, this.f48987i);
        }
        BigInteger bigIntegerA = this.f48985g.a();
        BigInteger bigIntegerMod = zVarD.a().modPow(bigIntegerA.add(e(bigIntegerC, this.f48987i)), zVarD.b()).mod(bigIntegerC);
        return new BigInteger[]{bigIntegerMod, org.bouncycastle.util.b.n(bigIntegerC, bigIntegerA).multiply(bigIntegerD.add(bigIntegerE.multiply(bigIntegerMod))).mod(bigIntegerC)};
    }

    @Override // org.bouncycastle.crypto.o
    public boolean c(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        np.z zVarD = this.f48986h.d();
        BigInteger bigIntegerC = zVarD.c();
        BigInteger bigIntegerD = d(bigIntegerC, bArr);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        if (bigIntegerValueOf.compareTo(bigInteger) >= 0 || bigIntegerC.compareTo(bigInteger) <= 0 || bigIntegerValueOf.compareTo(bigInteger2) >= 0 || bigIntegerC.compareTo(bigInteger2) <= 0) {
            return false;
        }
        BigInteger bigIntegerO = org.bouncycastle.util.b.o(bigIntegerC, bigInteger2);
        BigInteger bigIntegerMod = bigIntegerD.multiply(bigIntegerO).mod(bigIntegerC);
        BigInteger bigIntegerMod2 = bigInteger.multiply(bigIntegerO).mod(bigIntegerC);
        BigInteger bigIntegerB = zVarD.b();
        return zVarD.a().modPow(bigIntegerMod, bigIntegerB).multiply(((b0) this.f48986h).e().modPow(bigIntegerMod2, bigIntegerB)).mod(bigIntegerB).mod(bigIntegerC).equals(bigInteger);
    }

    public final BigInteger d(BigInteger bigInteger, byte[] bArr) {
        if (bigInteger.bitLength() >= bArr.length * 8) {
            return new BigInteger(1, bArr);
        }
        int iBitLength = bigInteger.bitLength() / 8;
        byte[] bArr2 = new byte[iBitLength];
        System.arraycopy(bArr, 0, bArr2, 0, iBitLength);
        return new BigInteger(1, bArr2);
    }

    public final BigInteger e(BigInteger bigInteger, SecureRandom secureRandom) {
        return org.bouncycastle.util.b.f(7, org.bouncycastle.crypto.n.g(secureRandom)).add(BigInteger.valueOf(128L)).multiply(bigInteger);
    }

    public SecureRandom f(boolean z10, SecureRandom secureRandom) {
        if (z10) {
            return org.bouncycastle.crypto.n.g(secureRandom);
        }
        return null;
    }

    @Override // org.bouncycastle.crypto.p
    public BigInteger getOrder() {
        return this.f48986h.d().c();
    }
}
