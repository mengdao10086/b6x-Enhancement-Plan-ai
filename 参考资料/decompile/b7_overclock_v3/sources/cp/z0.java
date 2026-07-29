package cp;

import java.math.BigInteger;
import np.e2;
import np.f2;
import np.w1;
import org.bouncycastle.crypto.DataLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e2 f25773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25774b;

    public BigInteger a(byte[] bArr, int i10, int i11) {
        if (i11 > c() + 1) {
            throw new DataLengthException("input too large for RSA cipher.");
        }
        if (i11 == c() + 1 && !this.f25774b) {
            throw new DataLengthException("input too large for RSA cipher.");
        }
        if (i10 != 0 || i11 != bArr.length) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            bArr = bArr2;
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.compareTo(this.f25773a.e()) < 0) {
            return bigInteger;
        }
        throw new DataLengthException("input too large for RSA cipher.");
    }

    public byte[] b(BigInteger bigInteger) {
        byte[] bArr;
        byte[] byteArray = bigInteger.toByteArray();
        if (!this.f25774b) {
            if (byteArray[0] == 0) {
                int length = byteArray.length - 1;
                bArr = new byte[length];
                System.arraycopy(byteArray, 1, bArr, 0, length);
            } else {
                int length2 = byteArray.length;
                bArr = new byte[length2];
                System.arraycopy(byteArray, 0, bArr, 0, length2);
            }
            org.bouncycastle.util.a.d0(byteArray, (byte) 0);
            return bArr;
        }
        if (byteArray[0] == 0 && byteArray.length > d()) {
            int length3 = byteArray.length - 1;
            byte[] bArr2 = new byte[length3];
            System.arraycopy(byteArray, 1, bArr2, 0, length3);
            return bArr2;
        }
        if (byteArray.length >= d()) {
            return byteArray;
        }
        int iD = d();
        byte[] bArr3 = new byte[iD];
        System.arraycopy(byteArray, 0, bArr3, iD - byteArray.length, byteArray.length);
        return bArr3;
    }

    public int c() {
        int iBitLength = (this.f25773a.e().bitLength() + 7) / 8;
        return this.f25774b ? iBitLength - 1 : iBitLength;
    }

    public int d() {
        int iBitLength = (this.f25773a.e().bitLength() + 7) / 8;
        return this.f25774b ? iBitLength : iBitLength - 1;
    }

    public void e(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof w1) {
            kVar = ((w1) kVar).a();
        }
        this.f25773a = (e2) kVar;
        this.f25774b = z10;
    }

    public BigInteger f(BigInteger bigInteger) {
        e2 e2Var = this.f25773a;
        if (!(e2Var instanceof f2)) {
            return bigInteger.modPow(e2Var.d(), this.f25773a.e());
        }
        f2 f2Var = (f2) e2Var;
        BigInteger bigIntegerI = f2Var.i();
        BigInteger bigIntegerK = f2Var.k();
        BigInteger bigIntegerG = f2Var.g();
        BigInteger bigIntegerH = f2Var.h();
        BigInteger bigIntegerL = f2Var.l();
        BigInteger bigIntegerModPow = bigInteger.remainder(bigIntegerI).modPow(bigIntegerG, bigIntegerI);
        BigInteger bigIntegerModPow2 = bigInteger.remainder(bigIntegerK).modPow(bigIntegerH, bigIntegerK);
        return bigIntegerModPow.subtract(bigIntegerModPow2).multiply(bigIntegerL).mod(bigIntegerI).multiply(bigIntegerK).add(bigIntegerModPow2);
    }
}
