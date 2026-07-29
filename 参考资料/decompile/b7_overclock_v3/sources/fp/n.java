package fp;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class n {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f28672i = BigInteger.valueOf(0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final BigInteger f28673j = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final BigInteger f28674k = BigInteger.valueOf(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.s f28675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f28676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f28677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f28678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f28679e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SecureRandom f28680f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f28681g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f28682h;

    public n() {
        this(org.bouncycastle.crypto.util.f.c());
    }

    public n(org.bouncycastle.crypto.s sVar) {
        this.f28675a = sVar;
    }

    public static BigInteger a(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger bigIntegerModPow;
        BigInteger bigIntegerDivide = bigInteger.subtract(f28673j).divide(bigInteger2);
        BigInteger bigIntegerSubtract = bigInteger.subtract(f28674k);
        do {
            bigIntegerModPow = org.bouncycastle.util.b.g(f28674k, bigIntegerSubtract, secureRandom).modPow(bigIntegerDivide, bigInteger);
        } while (bigIntegerModPow.bitLength() <= 1);
        return bigIntegerModPow;
    }

    public static BigInteger b(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        return a(bigInteger, bigInteger2, secureRandom);
    }

    public static BigInteger c(org.bouncycastle.crypto.s sVar, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr, int i10) {
        BigInteger bigIntegerDivide = bigInteger.subtract(f28673j).divide(bigInteger2);
        byte[] bArrD = jt.h.d("6767656E");
        int length = bArr.length + bArrD.length + 1 + 2;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(bArrD, 0, bArr2, bArr.length, bArrD.length);
        bArr2[length - 3] = (byte) i10;
        byte[] bArr3 = new byte[sVar.h()];
        for (int i11 = 1; i11 < 65536; i11++) {
            j(bArr2);
            i(sVar, bArr2, bArr3, 0);
            BigInteger bigIntegerModPow = new BigInteger(1, bArr3).modPow(bigIntegerDivide, bigInteger);
            if (bigIntegerModPow.compareTo(f28674k) >= 0) {
                return bigIntegerModPow;
            }
        }
        return null;
    }

    public static int g(int i10) {
        return i10 > 1024 ? 256 : 160;
    }

    public static int h(int i10) {
        if (i10 <= 1024) {
            return 40;
        }
        return (((i10 - 1) / 1024) * 8) + 48;
    }

    public static void i(org.bouncycastle.crypto.s sVar, byte[] bArr, byte[] bArr2, int i10) {
        sVar.update(bArr, 0, bArr.length);
        sVar.c(bArr2, i10);
    }

    public static void j(byte[] bArr) {
        for (int length = bArr.length - 1; length >= 0; length--) {
            byte b10 = (byte) ((bArr[length] + 1) & 255);
            bArr[length] = b10;
            if (b10 != 0) {
                return;
            }
        }
    }

    public np.z d() {
        return this.f28681g ? f() : e();
    }

    public final np.z e() {
        int i10 = 20;
        byte[] bArr = new byte[20];
        byte[] bArr2 = new byte[20];
        byte[] bArr3 = new byte[20];
        byte[] bArr4 = new byte[20];
        int i11 = this.f28676b;
        int i12 = (i11 - 1) / 160;
        int i13 = i11 / 8;
        byte[] bArr5 = new byte[i13];
        if (!(this.f28675a instanceof zo.c0)) {
            throw new IllegalStateException("can only use SHA-1 for generating FIPS 186-2 parameters");
        }
        while (true) {
            this.f28680f.nextBytes(bArr);
            i(this.f28675a, bArr, bArr2, 0);
            System.arraycopy(bArr, 0, bArr3, 0, i10);
            j(bArr3);
            i(this.f28675a, bArr3, bArr3, 0);
            for (int i14 = 0; i14 != i10; i14++) {
                bArr4[i14] = (byte) (bArr2[i14] ^ bArr3[i14]);
            }
            bArr4[0] = (byte) (bArr4[0] | (-128));
            bArr4[19] = (byte) (bArr4[19] | 1);
            BigInteger bigInteger = new BigInteger(1, bArr4);
            if (m(bigInteger)) {
                byte[] bArrP = org.bouncycastle.util.a.p(bArr);
                j(bArrP);
                int i15 = 0;
                while (i15 < 4096) {
                    for (int i16 = 1; i16 <= i12; i16++) {
                        j(bArrP);
                        i(this.f28675a, bArrP, bArr5, i13 - (i16 * 20));
                    }
                    int i17 = i13 - (i12 * 20);
                    j(bArrP);
                    i(this.f28675a, bArrP, bArr2, 0);
                    System.arraycopy(bArr2, 20 - i17, bArr5, 0, i17);
                    bArr5[0] = (byte) (bArr5[0] | (-128));
                    BigInteger bigInteger2 = new BigInteger(1, bArr5);
                    BigInteger bigIntegerSubtract = bigInteger2.subtract(bigInteger2.mod(bigInteger.shiftLeft(1)).subtract(f28673j));
                    if (bigIntegerSubtract.bitLength() == this.f28676b && m(bigIntegerSubtract)) {
                        return new np.z(bigIntegerSubtract, bigInteger, a(bigIntegerSubtract, bigInteger, this.f28680f), new np.c0(bArr, i15));
                    }
                    i15++;
                    i10 = 20;
                }
            }
        }
    }

    public final np.z f() {
        BigInteger bit;
        int i10;
        BigInteger bigIntegerSubtract;
        BigInteger bigIntegerC;
        org.bouncycastle.crypto.s sVar = this.f28675a;
        int iH = sVar.h() * 8;
        byte[] bArr = new byte[this.f28677c / 8];
        int i11 = this.f28676b;
        int i12 = (i11 - 1) / iH;
        int i13 = (i11 - 1) % iH;
        int i14 = i11 / 8;
        byte[] bArr2 = new byte[i14];
        int iH2 = sVar.h();
        byte[] bArr3 = new byte[iH2];
        loop0: while (true) {
            this.f28680f.nextBytes(bArr);
            int i15 = 0;
            i(sVar, bArr, bArr3, 0);
            bit = new BigInteger(1, bArr3).mod(f28673j.shiftLeft(this.f28677c - 1)).setBit(0).setBit(this.f28677c - 1);
            if (m(bit)) {
                byte[] bArrP = org.bouncycastle.util.a.p(bArr);
                int i16 = this.f28676b * 4;
                i10 = 0;
                while (i10 < i16) {
                    for (int i17 = 1; i17 <= i12; i17++) {
                        j(bArrP);
                        i(sVar, bArrP, bArr2, i14 - (i17 * iH2));
                    }
                    int i18 = i14 - (i12 * iH2);
                    j(bArrP);
                    i(sVar, bArrP, bArr3, i15);
                    System.arraycopy(bArr3, iH2 - i18, bArr2, i15, i18);
                    bArr2[i15] = (byte) (bArr2[i15] | (-128));
                    BigInteger bigInteger = new BigInteger(1, bArr2);
                    bigIntegerSubtract = bigInteger.subtract(bigInteger.mod(bit.shiftLeft(1)).subtract(f28673j));
                    if (bigIntegerSubtract.bitLength() == this.f28676b && m(bigIntegerSubtract)) {
                        break loop0;
                    }
                    i10++;
                    i15 = 0;
                }
            }
        }
        int i19 = this.f28682h;
        return (i19 < 0 || (bigIntegerC = c(sVar, bigIntegerSubtract, bit, bArr, i19)) == null) ? new np.z(bigIntegerSubtract, bit, b(bigIntegerSubtract, bit, this.f28680f), new np.c0(bArr, i10)) : new np.z(bigIntegerSubtract, bit, bigIntegerC, new np.c0(bArr, i10, this.f28682h));
    }

    public void k(int i10, int i11, SecureRandom secureRandom) {
        this.f28676b = i10;
        this.f28677c = g(i10);
        this.f28678d = i11;
        this.f28679e = Math.max(h(this.f28676b), (i11 + 1) / 2);
        this.f28680f = secureRandom;
        this.f28681g = false;
        this.f28682h = -1;
    }

    public void l(np.y yVar) {
        int iB = yVar.b();
        int iC = yVar.c();
        if (iB < 1024 || iB > 3072 || iB % 1024 != 0) {
            throw new IllegalArgumentException("L values must be between 1024 and 3072 and a multiple of 1024");
        }
        if (iB == 1024 && iC != 160) {
            throw new IllegalArgumentException("N must be 160 for L = 1024");
        }
        if (iB == 2048 && iC != 224 && iC != 256) {
            throw new IllegalArgumentException("N must be 224 or 256 for L = 2048");
        }
        if (iB == 3072 && iC != 256) {
            throw new IllegalArgumentException("N must be 256 for L = 3072");
        }
        if (this.f28675a.h() * 8 < iC) {
            throw new IllegalStateException("Digest output size too small for value of N");
        }
        this.f28676b = iB;
        this.f28677c = iC;
        this.f28678d = yVar.a();
        this.f28679e = Math.max(h(iB), (this.f28678d + 1) / 2);
        this.f28680f = yVar.d();
        this.f28681g = true;
        this.f28682h = yVar.e();
    }

    public final boolean m(BigInteger bigInteger) {
        return bigInteger.isProbablePrime(this.f28678d);
    }
}
