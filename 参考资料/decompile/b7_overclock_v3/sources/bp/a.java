package bp;

import java.math.BigInteger;
import np.e2;
import np.w1;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.k;

/* JADX INFO: loaded from: classes5.dex */
public class a implements org.bouncycastle.crypto.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final BigInteger f9517f = BigInteger.valueOf(16);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f9518g = BigInteger.valueOf(6);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static byte[] f9519h = {14, 3, 5, 8, 9, 4, 2, 15, 0, 13, 11, 6, 7, 10, 12, 1};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static byte[] f9520i = {8, 15, 6, 1, 5, 2, 11, 12, 3, 4, 13, 10, 14, 9, 0, 7};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.b f9521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9524d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BigInteger f9525e;

    public a(org.bouncycastle.crypto.b bVar) {
        this.f9521a = bVar;
    }

    public static byte[] e(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] != 0) {
            return byteArray;
        }
        int length = byteArray.length - 1;
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 1, bArr, 0, length);
        return bArr;
    }

    @Override // org.bouncycastle.crypto.b
    public void a(boolean z10, k kVar) {
        e2 e2Var = kVar instanceof w1 ? (e2) ((w1) kVar).a() : (e2) kVar;
        this.f9521a.a(z10, kVar);
        BigInteger bigIntegerE = e2Var.e();
        this.f9525e = bigIntegerE;
        this.f9523c = bigIntegerE.bitLength();
        this.f9522b = z10;
    }

    @Override // org.bouncycastle.crypto.b
    public int b() {
        int iB = this.f9521a.b();
        return this.f9522b ? (iB + 1) / 2 : iB;
    }

    @Override // org.bouncycastle.crypto.b
    public byte[] c(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        return this.f9522b ? g(bArr, i10, i11) : f(bArr, i10, i11);
    }

    @Override // org.bouncycastle.crypto.b
    public int d() {
        int iD = this.f9521a.d();
        return this.f9522b ? iD : (iD + 1) / 2;
    }

    public final byte[] f(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        byte[] bArrC = this.f9521a.c(bArr, i10, i11);
        int i12 = (this.f9523c + 13) / 16;
        BigInteger bigInteger = new BigInteger(1, bArrC);
        BigInteger bigInteger2 = f9517f;
        BigInteger bigIntegerMod = bigInteger.mod(bigInteger2);
        BigInteger bigInteger3 = f9518g;
        if (!bigIntegerMod.equals(bigInteger3)) {
            if (!this.f9525e.subtract(bigInteger).mod(bigInteger2).equals(bigInteger3)) {
                throw new InvalidCipherTextException("resulting integer iS or (modulus - iS) is not congruent to 6 mod 16");
            }
            bigInteger = this.f9525e.subtract(bigInteger);
        }
        byte[] bArrE = e(bigInteger);
        if ((bArrE[bArrE.length - 1] & 15) != 6) {
            throw new InvalidCipherTextException("invalid forcing byte in block");
        }
        bArrE[bArrE.length - 1] = (byte) (((bArrE[bArrE.length - 1] & 255) >>> 4) | (f9520i[(bArrE[bArrE.length - 2] & 255) >> 4] << 4));
        byte[] bArr2 = f9519h;
        bArrE[0] = (byte) (bArr2[bArrE[1] & 15] | (bArr2[(bArrE[1] & 255) >>> 4] << 4));
        int i13 = 0;
        boolean z10 = false;
        int i14 = 1;
        for (int length = bArrE.length - 1; length >= bArrE.length - (i12 * 2); length -= 2) {
            byte[] bArr3 = f9519h;
            int i15 = bArr3[bArrE[length] & 15] | (bArr3[(bArrE[length] & 255) >>> 4] << 4);
            int i16 = length - 1;
            if (((bArrE[i16] ^ i15) & 255) != 0) {
                if (z10) {
                    throw new InvalidCipherTextException("invalid tsums in block");
                }
                i14 = (bArrE[i16] ^ i15) & 255;
                i13 = i16;
                z10 = true;
            }
        }
        bArrE[i13] = 0;
        int length2 = (bArrE.length - i13) / 2;
        byte[] bArr4 = new byte[length2];
        for (int i17 = 0; i17 < length2; i17++) {
            bArr4[i17] = bArrE[(i17 * 2) + i13 + 1];
        }
        this.f9524d = i14 - 1;
        return bArr4;
    }

    public final byte[] g(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        int i12 = this.f9523c;
        int i13 = (i12 + 7) / 8;
        byte[] bArr2 = new byte[i13];
        int i14 = 1;
        int i15 = this.f9524d + 1;
        int i16 = (i12 + 13) / 16;
        int i17 = 0;
        while (i17 < i16) {
            if (i17 > i16 - i11) {
                int i18 = i16 - i17;
                System.arraycopy(bArr, (i10 + i11) - i18, bArr2, i13 - i16, i18);
            } else {
                System.arraycopy(bArr, i10, bArr2, i13 - (i17 + i11), i11);
            }
            i17 += i11;
        }
        for (int i19 = i13 - (i16 * 2); i19 != i13; i19 += 2) {
            byte b10 = bArr2[(i13 - i16) + (i19 / 2)];
            byte[] bArr3 = f9519h;
            bArr2[i19] = (byte) (bArr3[b10 & 15] | (bArr3[(b10 & 255) >>> 4] << 4));
            bArr2[i19 + 1] = b10;
        }
        int i20 = i13 - (i11 * 2);
        bArr2[i20] = (byte) (bArr2[i20] ^ i15);
        int i21 = i13 - 1;
        bArr2[i21] = (byte) ((bArr2[i21] << 4) | 6);
        int i22 = 8 - ((this.f9523c - 1) % 8);
        if (i22 != 8) {
            bArr2[0] = (byte) (bArr2[0] & (255 >>> i22));
            bArr2[0] = (byte) ((128 >>> i22) | bArr2[0]);
            i14 = 0;
        } else {
            bArr2[0] = 0;
            bArr2[1] = (byte) (bArr2[1] | 128);
        }
        return this.f9521a.c(bArr2, i14, i13 - i14);
    }

    public int h() {
        return this.f9524d;
    }

    public org.bouncycastle.crypto.b i() {
        return this.f9521a;
    }

    public void j(int i10) {
        if (i10 > 7) {
            throw new IllegalArgumentException("padBits > 7");
        }
        this.f9524d = i10;
    }
}
