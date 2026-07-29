package cp;

import java.math.BigInteger;
import java.util.Vector;
import np.w1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes5.dex */
public class k0 implements org.bouncycastle.crypto.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static BigInteger f25413e = BigInteger.valueOf(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static BigInteger f25414f = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f25415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public np.s1 f25416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Vector[] f25417c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f25418d = false;

    public static BigInteger f(Vector vector, Vector vector2) {
        BigInteger bigIntegerAdd = f25413e;
        BigInteger bigIntegerMultiply = f25414f;
        for (int i10 = 0; i10 < vector2.size(); i10++) {
            bigIntegerMultiply = bigIntegerMultiply.multiply((BigInteger) vector2.elementAt(i10));
        }
        for (int i11 = 0; i11 < vector2.size(); i11++) {
            BigInteger bigInteger = (BigInteger) vector2.elementAt(i11);
            BigInteger bigIntegerDivide = bigIntegerMultiply.divide(bigInteger);
            bigIntegerAdd = bigIntegerAdd.add(bigIntegerDivide.multiply(bigIntegerDivide.modInverse(bigInteger)).multiply((BigInteger) vector.elementAt(i11)));
        }
        return bigIntegerAdd.mod(bigIntegerMultiply);
    }

    @Override // org.bouncycastle.crypto.b
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f25415a = z10;
        if (kVar instanceof w1) {
            kVar = ((w1) kVar).a();
        }
        this.f25416b = (np.s1) kVar;
        if (this.f25415a) {
            return;
        }
        if (this.f25418d) {
            System.out.println("Constructing lookup Array");
        }
        np.t1 t1Var = (np.t1) this.f25416b;
        Vector vectorH = t1Var.h();
        this.f25417c = new Vector[vectorH.size()];
        for (int i10 = 0; i10 < vectorH.size(); i10++) {
            BigInteger bigInteger = (BigInteger) vectorH.elementAt(i10);
            int iIntValue = bigInteger.intValue();
            this.f25417c[i10] = new Vector();
            this.f25417c[i10].addElement(f25414f);
            if (this.f25418d) {
                System.out.println("Constructing lookup ArrayList for " + iIntValue);
            }
            BigInteger bigIntegerAdd = f25413e;
            for (int i11 = 1; i11 < iIntValue; i11++) {
                bigIntegerAdd = bigIntegerAdd.add(t1Var.g());
                this.f25417c[i10].addElement(t1Var.d().modPow(bigIntegerAdd.divide(bigInteger), t1Var.f()));
            }
        }
    }

    @Override // org.bouncycastle.crypto.b
    public int b() {
        return this.f25415a ? ((this.f25416b.e() + 7) / 8) - 1 : this.f25416b.f().toByteArray().length;
    }

    @Override // org.bouncycastle.crypto.b
    public byte[] c(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        if (this.f25416b == null) {
            throw new IllegalStateException("NaccacheStern engine not initialised");
        }
        if (i11 > b() + 1) {
            throw new DataLengthException("input too large for Naccache-Stern cipher.\n");
        }
        if (!this.f25415a && i11 < b()) {
            throw new InvalidCipherTextException("BlockLength does not match modulus for Naccache-Stern cipher.\n");
        }
        if (i10 != 0 || i11 != bArr.length) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            bArr = bArr2;
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (this.f25418d) {
            System.out.println("input as BigInteger: " + bigInteger);
        }
        if (this.f25415a) {
            return g(bigInteger);
        }
        Vector vector = new Vector();
        np.t1 t1Var = (np.t1) this.f25416b;
        Vector vectorH = t1Var.h();
        for (int i12 = 0; i12 < vectorH.size(); i12++) {
            BigInteger bigIntegerModPow = bigInteger.modPow(t1Var.g().divide((BigInteger) vectorH.elementAt(i12)), t1Var.f());
            Vector[] vectorArr = this.f25417c;
            Vector vector2 = vectorArr[i12];
            if (vectorArr[i12].size() != ((BigInteger) vectorH.elementAt(i12)).intValue()) {
                if (this.f25418d) {
                    System.out.println("Prime is " + vectorH.elementAt(i12) + ", lookup table has size " + vector2.size());
                }
                throw new InvalidCipherTextException("Error in lookup Array for " + ((BigInteger) vectorH.elementAt(i12)).intValue() + ": Size mismatch. Expected ArrayList with length " + ((BigInteger) vectorH.elementAt(i12)).intValue() + " but found ArrayList of length " + this.f25417c[i12].size());
            }
            int iIndexOf = vector2.indexOf(bigIntegerModPow);
            if (iIndexOf == -1) {
                if (this.f25418d) {
                    System.out.println("Actual prime is " + vectorH.elementAt(i12));
                    System.out.println("Decrypted value is " + bigIntegerModPow);
                    System.out.println("LookupList for " + vectorH.elementAt(i12) + " with size " + this.f25417c[i12].size() + " is: ");
                    for (int i13 = 0; i13 < this.f25417c[i12].size(); i13++) {
                        System.out.println(this.f25417c[i12].elementAt(i13));
                    }
                }
                throw new InvalidCipherTextException("Lookup failed");
            }
            vector.addElement(BigInteger.valueOf(iIndexOf));
        }
        return f(vector, vectorH).toByteArray();
    }

    @Override // org.bouncycastle.crypto.b
    public int d() {
        return this.f25415a ? this.f25416b.f().toByteArray().length : ((this.f25416b.e() + 7) / 8) - 1;
    }

    public byte[] e(byte[] bArr, byte[] bArr2) throws InvalidCipherTextException {
        if (this.f25415a) {
            if (bArr.length > d() || bArr2.length > d()) {
                throw new InvalidCipherTextException("BlockLength too large for simple addition.\n");
            }
        } else if (bArr.length > b() || bArr2.length > b()) {
            throw new InvalidCipherTextException("BlockLength too large for simple addition.\n");
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        BigInteger bigInteger2 = new BigInteger(1, bArr2);
        BigInteger bigIntegerMod = bigInteger.multiply(bigInteger2).mod(this.f25416b.f());
        if (this.f25418d) {
            System.out.println("c(m1) as BigInteger:....... " + bigInteger);
            System.out.println("c(m2) as BigInteger:....... " + bigInteger2);
            System.out.println("c(m1)*c(m2)%n = c(m1+m2)%n: " + bigIntegerMod);
        }
        byte[] byteArray = this.f25416b.f().toByteArray();
        org.bouncycastle.util.a.d0(byteArray, (byte) 0);
        System.arraycopy(bigIntegerMod.toByteArray(), 0, byteArray, byteArray.length - bigIntegerMod.toByteArray().length, bigIntegerMod.toByteArray().length);
        return byteArray;
    }

    public byte[] g(BigInteger bigInteger) {
        byte[] byteArray = this.f25416b.f().toByteArray();
        org.bouncycastle.util.a.d0(byteArray, (byte) 0);
        byte[] byteArray2 = this.f25416b.d().modPow(bigInteger, this.f25416b.f()).toByteArray();
        System.arraycopy(byteArray2, 0, byteArray, byteArray.length - byteArray2.length, byteArray2.length);
        if (this.f25418d) {
            System.out.println("Encrypted value is:  " + new BigInteger(byteArray));
        }
        return byteArray;
    }

    public byte[] h(byte[] bArr) throws InvalidCipherTextException {
        byte[] bArrC;
        if (this.f25418d) {
            System.out.println();
        }
        if (bArr.length <= b()) {
            if (this.f25418d) {
                System.out.println("data size is less then input block size, processing directly");
            }
            return c(bArr, 0, bArr.length);
        }
        int iB = b();
        int iD = d();
        if (this.f25418d) {
            System.out.println("Input blocksize is:  " + iB + " bytes");
            System.out.println("Output blocksize is: " + iD + " bytes");
            System.out.println("Data has length:.... " + bArr.length + " bytes");
        }
        byte[] bArr2 = new byte[((bArr.length / iB) + 1) * iD];
        int length = 0;
        int length2 = 0;
        while (length < bArr.length) {
            int i10 = length + iB;
            if (i10 < bArr.length) {
                bArrC = c(bArr, length, iB);
                length = i10;
            } else {
                bArrC = c(bArr, length, bArr.length - length);
                length += bArr.length - length;
            }
            if (this.f25418d) {
                System.out.println("new datapos is " + length);
            }
            if (bArrC == null) {
                if (this.f25418d) {
                    System.out.println("cipher returned null");
                }
                throw new InvalidCipherTextException("cipher returned null");
            }
            System.arraycopy(bArrC, 0, bArr2, length2, bArrC.length);
            length2 += bArrC.length;
        }
        byte[] bArr3 = new byte[length2];
        System.arraycopy(bArr2, 0, bArr3, 0, length2);
        if (this.f25418d) {
            System.out.println("returning " + length2 + " bytes");
        }
        return bArr3;
    }

    public void i(boolean z10) {
        this.f25418d = z10;
    }
}
