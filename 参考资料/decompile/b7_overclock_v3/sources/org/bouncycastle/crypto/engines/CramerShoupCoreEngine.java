package org.bouncycastle.crypto.engines;

import cp.q;
import java.math.BigInteger;
import java.security.SecureRandom;
import np.g;
import np.i;
import np.j;
import np.w1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.k;
import org.bouncycastle.crypto.n;
import org.bouncycastle.crypto.s;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.b;

/* JADX INFO: loaded from: classes5.dex */
public class CramerShoupCoreEngine {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BigInteger f44665e = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f44666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f44667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f44668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f44669d = null;

    public static class CramerShoupCiphertextException extends Exception {
        private static final long serialVersionUID = -6360977166495345076L;

        public CramerShoupCiphertextException(String str) {
            super(str);
        }
    }

    public BigInteger a(byte[] bArr, int i10, int i11) {
        if (i11 > f() + 1) {
            throw new DataLengthException("input too large for Cramer Shoup cipher.");
        }
        if (i11 == f() + 1 && this.f44668c) {
            throw new DataLengthException("input too large for Cramer Shoup cipher.");
        }
        if (i10 != 0 || i11 != bArr.length) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            bArr = bArr2;
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.compareTo(this.f44666a.d().d()) < 0) {
            return bigInteger;
        }
        throw new DataLengthException("input too large for Cramer Shoup cipher.");
    }

    public byte[] b(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (this.f44668c) {
            if (byteArray[0] == 0) {
                int length = byteArray.length - 1;
                byte[] bArr = new byte[length];
                System.arraycopy(byteArray, 1, bArr, 0, length);
                return bArr;
            }
        } else {
            if (byteArray[0] == 0 && byteArray.length > g()) {
                int length2 = byteArray.length - 1;
                byte[] bArr2 = new byte[length2];
                System.arraycopy(byteArray, 1, bArr2, 0, length2);
                return bArr2;
            }
            if (byteArray.length < g()) {
                int iG = g();
                byte[] bArr3 = new byte[iG];
                System.arraycopy(byteArray, 0, bArr3, iG - byteArray.length, byteArray.length);
                return bArr3;
            }
        }
        return byteArray;
    }

    public BigInteger c(q qVar) throws CramerShoupCiphertextException {
        if (this.f44666a.c() && !this.f44668c) {
            g gVar = this.f44666a;
            if (gVar instanceof i) {
                i iVar = (i) gVar;
                BigInteger bigIntegerD = iVar.d().d();
                s sVarC = iVar.d().c();
                byte[] byteArray = qVar.b().toByteArray();
                sVarC.update(byteArray, 0, byteArray.length);
                byte[] byteArray2 = qVar.c().toByteArray();
                sVarC.update(byteArray2, 0, byteArray2.length);
                byte[] byteArray3 = qVar.a().toByteArray();
                sVarC.update(byteArray3, 0, byteArray3.length);
                byte[] bArr = this.f44669d;
                if (bArr != null) {
                    sVarC.update(bArr, 0, bArr.length);
                }
                byte[] bArr2 = new byte[sVarC.h()];
                sVarC.c(bArr2, 0);
                BigInteger bigInteger = new BigInteger(1, bArr2);
                if (qVar.f25608d.equals(qVar.f25605a.modPow(iVar.f().add(iVar.h().multiply(bigInteger)), bigIntegerD).multiply(qVar.f25606b.modPow(iVar.g().add(iVar.i().multiply(bigInteger)), bigIntegerD)).mod(bigIntegerD))) {
                    return qVar.f25607c.multiply(qVar.f25605a.modPow(iVar.j(), bigIntegerD).modInverse(bigIntegerD)).mod(bigIntegerD);
                }
                throw new CramerShoupCiphertextException("Sorry, that ciphertext is not correct");
            }
        }
        return null;
    }

    public q d(BigInteger bigInteger) {
        if (this.f44666a.c() || !this.f44668c) {
            return null;
        }
        g gVar = this.f44666a;
        if (!(gVar instanceof j)) {
            return null;
        }
        j jVar = (j) gVar;
        BigInteger bigIntegerD = jVar.d().d();
        BigInteger bigIntegerA = jVar.d().a();
        BigInteger bigIntegerB = jVar.d().b();
        BigInteger bigIntegerG = jVar.g();
        if (!k(bigInteger, bigIntegerD)) {
            return null;
        }
        BigInteger bigIntegerE = e(bigIntegerD, this.f44667b);
        BigInteger bigIntegerModPow = bigIntegerA.modPow(bigIntegerE, bigIntegerD);
        BigInteger bigIntegerModPow2 = bigIntegerB.modPow(bigIntegerE, bigIntegerD);
        BigInteger bigIntegerMod = bigIntegerG.modPow(bigIntegerE, bigIntegerD).multiply(bigInteger).mod(bigIntegerD);
        s sVarC = jVar.d().c();
        byte[] byteArray = bigIntegerModPow.toByteArray();
        sVarC.update(byteArray, 0, byteArray.length);
        byte[] byteArray2 = bigIntegerModPow2.toByteArray();
        sVarC.update(byteArray2, 0, byteArray2.length);
        byte[] byteArray3 = bigIntegerMod.toByteArray();
        sVarC.update(byteArray3, 0, byteArray3.length);
        byte[] bArr = this.f44669d;
        if (bArr != null) {
            sVarC.update(bArr, 0, bArr.length);
        }
        byte[] bArr2 = new byte[sVarC.h()];
        sVarC.c(bArr2, 0);
        return new q(bigIntegerModPow, bigIntegerModPow2, bigIntegerMod, jVar.e().modPow(bigIntegerE, bigIntegerD).multiply(jVar.f().modPow(bigIntegerE.multiply(new BigInteger(1, bArr2)), bigIntegerD)).mod(bigIntegerD));
    }

    public final BigInteger e(BigInteger bigInteger, SecureRandom secureRandom) {
        BigInteger bigInteger2 = f44665e;
        return b.g(bigInteger2, bigInteger.subtract(bigInteger2), secureRandom);
    }

    public int f() {
        int iBitLength = (this.f44666a.d().d().bitLength() + 7) / 8;
        return this.f44668c ? iBitLength - 1 : iBitLength;
    }

    public int g() {
        int iBitLength = (this.f44666a.d().d().bitLength() + 7) / 8;
        return this.f44668c ? iBitLength : iBitLength - 1;
    }

    public void h(boolean z10, k kVar) {
        SecureRandom secureRandomB;
        if (kVar instanceof w1) {
            w1 w1Var = (w1) kVar;
            this.f44666a = (g) w1Var.a();
            secureRandomB = w1Var.b();
        } else {
            this.f44666a = (g) kVar;
            secureRandomB = null;
        }
        this.f44667b = j(z10, secureRandomB);
        this.f44668c = z10;
    }

    public void i(boolean z10, k kVar, String str) {
        h(z10, kVar);
        this.f44669d = Strings.m(str);
    }

    public SecureRandom j(boolean z10, SecureRandom secureRandom) {
        if (z10) {
            return n.g(secureRandom);
        }
        return null;
    }

    public final boolean k(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.compareTo(bigInteger2) < 0;
    }
}
