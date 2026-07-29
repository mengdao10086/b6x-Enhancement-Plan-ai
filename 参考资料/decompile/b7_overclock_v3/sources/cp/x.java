package cp;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.w1;
import org.bouncycastle.crypto.DataLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class x implements org.bouncycastle.crypto.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BigInteger f25726e = BigInteger.valueOf(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final BigInteger f25727f = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f25728g = BigInteger.valueOf(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public np.u0 f25729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f25730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25732d;

    @Override // org.bouncycastle.crypto.b
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        SecureRandom secureRandomF;
        if (kVar instanceof w1) {
            w1 w1Var = (w1) kVar;
            this.f25729a = (np.u0) w1Var.a();
            secureRandomF = w1Var.b();
        } else {
            this.f25729a = (np.u0) kVar;
            secureRandomF = org.bouncycastle.crypto.n.f();
        }
        this.f25730b = secureRandomF;
        this.f25731c = z10;
        this.f25732d = this.f25729a.d().c().bitLength();
        if (z10) {
            if (!(this.f25729a instanceof np.x0)) {
                throw new IllegalArgumentException("ElGamalPublicKeyParameters are required for encryption.");
            }
        } else if (!(this.f25729a instanceof np.w0)) {
            throw new IllegalArgumentException("ElGamalPrivateKeyParameters are required for decryption.");
        }
    }

    @Override // org.bouncycastle.crypto.b
    public int b() {
        return this.f25731c ? (this.f25732d - 1) / 8 : ((this.f25732d + 7) / 8) * 2;
    }

    @Override // org.bouncycastle.crypto.b
    public byte[] c(byte[] bArr, int i10, int i11) {
        BigInteger bigIntegerF;
        if (this.f25729a == null) {
            throw new IllegalStateException("ElGamal engine not initialised");
        }
        if (i11 > (this.f25731c ? ((this.f25732d - 1) + 7) / 8 : b())) {
            throw new DataLengthException("input too large for ElGamal cipher.\n");
        }
        BigInteger bigIntegerC = this.f25729a.d().c();
        if (this.f25729a instanceof np.w0) {
            int i12 = i11 / 2;
            byte[] bArr2 = new byte[i12];
            byte[] bArr3 = new byte[i12];
            System.arraycopy(bArr, i10, bArr2, 0, i12);
            System.arraycopy(bArr, i10 + i12, bArr3, 0, i12);
            return org.bouncycastle.util.b.c(new BigInteger(1, bArr2).modPow(bigIntegerC.subtract(f25727f).subtract(((np.w0) this.f25729a).e()), bigIntegerC).multiply(new BigInteger(1, bArr3)).mod(bigIntegerC));
        }
        if (i10 != 0 || i11 != bArr.length) {
            byte[] bArr4 = new byte[i11];
            System.arraycopy(bArr, i10, bArr4, 0, i11);
            bArr = bArr4;
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.compareTo(bigIntegerC) >= 0) {
            throw new DataLengthException("input too large for ElGamal cipher.\n");
        }
        np.x0 x0Var = (np.x0) this.f25729a;
        int iBitLength = bigIntegerC.bitLength();
        while (true) {
            bigIntegerF = org.bouncycastle.util.b.f(iBitLength, this.f25730b);
            if (!bigIntegerF.equals(f25726e) && bigIntegerF.compareTo(bigIntegerC.subtract(f25728g)) <= 0) {
                break;
            }
        }
        BigInteger bigIntegerModPow = this.f25729a.d().a().modPow(bigIntegerF, bigIntegerC);
        BigInteger bigIntegerMod = bigInteger.multiply(x0Var.e().modPow(bigIntegerF, bigIntegerC)).mod(bigIntegerC);
        byte[] byteArray = bigIntegerModPow.toByteArray();
        byte[] byteArray2 = bigIntegerMod.toByteArray();
        int iD = d();
        byte[] bArr5 = new byte[iD];
        int i13 = iD / 2;
        if (byteArray.length > i13) {
            System.arraycopy(byteArray, 1, bArr5, i13 - (byteArray.length - 1), byteArray.length - 1);
        } else {
            System.arraycopy(byteArray, 0, bArr5, i13 - byteArray.length, byteArray.length);
        }
        if (byteArray2.length > i13) {
            System.arraycopy(byteArray2, 1, bArr5, iD - (byteArray2.length - 1), byteArray2.length - 1);
        } else {
            System.arraycopy(byteArray2, 0, bArr5, iD - byteArray2.length, byteArray2.length);
        }
        return bArr5;
    }

    @Override // org.bouncycastle.crypto.b
    public int d() {
        return this.f25731c ? ((this.f25732d + 7) / 8) * 2 : (this.f25732d - 1) / 8;
    }
}
