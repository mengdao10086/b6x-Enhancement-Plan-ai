package fp;

import java.math.BigInteger;
import np.k1;
import np.n1;
import org.bouncycastle.crypto.DataLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class b0 implements org.bouncycastle.crypto.b0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final BigInteger f28597j = BigInteger.valueOf(2147483647L);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final BigInteger f28598k = BigInteger.valueOf(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.crypto.a0 f28599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f28600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f28601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f28602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f28603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f28604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f28605g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f28606h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f28607i;

    public b0(org.bouncycastle.crypto.a0 a0Var) {
        this.f28599a = a0Var;
        int iD = a0Var.d();
        this.f28600b = iD;
        this.f28606h = new byte[iD];
        this.f28607i = new byte[iD];
    }

    @Override // org.bouncycastle.crypto.q
    public void a(org.bouncycastle.crypto.r rVar) {
        if (!(rVar instanceof k1)) {
            throw new IllegalArgumentException("Wrong type of arguments given");
        }
        k1 k1Var = (k1) rVar;
        this.f28599a.a(new n1(k1Var.d()));
        this.f28601c = k1Var.c();
        int iE = k1Var.e();
        this.f28603e = new byte[iE / 8];
        int iIntValue = Integer.MAX_VALUE;
        if (k1Var.f()) {
            BigInteger bigIntegerMultiply = f28598k.pow(iE).multiply(BigInteger.valueOf(this.f28600b));
            if (bigIntegerMultiply.compareTo(f28597j) != 1) {
                iIntValue = bigIntegerMultiply.intValue();
            }
        }
        this.f28602d = iIntValue;
        this.f28604f = k1Var.f();
        this.f28605g = 0;
    }

    @Override // org.bouncycastle.crypto.q
    public int b(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
        int i12 = this.f28605g;
        int i13 = i12 + i11;
        if (i13 < 0 || i13 >= this.f28602d) {
            throw new DataLengthException("Current KDFCTR may only be used for " + this.f28602d + " bytes");
        }
        if (i12 % this.f28600b == 0) {
            e();
        }
        int i14 = this.f28605g;
        int i15 = this.f28600b;
        int i16 = i14 % i15;
        int iMin = Math.min(i15 - (i14 % i15), i11);
        System.arraycopy(this.f28607i, i16, bArr, i10, iMin);
        this.f28605g += iMin;
        int i17 = i11 - iMin;
        while (true) {
            i10 += iMin;
            if (i17 <= 0) {
                return i11;
            }
            e();
            iMin = Math.min(this.f28600b, i17);
            System.arraycopy(this.f28607i, 0, bArr, i10, iMin);
            this.f28605g += iMin;
            i17 -= iMin;
        }
    }

    @Override // org.bouncycastle.crypto.b0
    public org.bouncycastle.crypto.a0 d() {
        return this.f28599a;
    }

    public final void e() {
        if (this.f28605g == 0) {
            org.bouncycastle.crypto.a0 a0Var = this.f28599a;
            byte[] bArr = this.f28601c;
            a0Var.update(bArr, 0, bArr.length);
            this.f28599a.c(this.f28606h, 0);
        } else {
            org.bouncycastle.crypto.a0 a0Var2 = this.f28599a;
            byte[] bArr2 = this.f28606h;
            a0Var2.update(bArr2, 0, bArr2.length);
            this.f28599a.c(this.f28606h, 0);
        }
        org.bouncycastle.crypto.a0 a0Var3 = this.f28599a;
        byte[] bArr3 = this.f28606h;
        a0Var3.update(bArr3, 0, bArr3.length);
        if (this.f28604f) {
            int i10 = (this.f28605g / this.f28600b) + 1;
            byte[] bArr4 = this.f28603e;
            int length = bArr4.length;
            if (length != 1) {
                if (length != 2) {
                    if (length != 3) {
                        if (length != 4) {
                            throw new IllegalStateException("Unsupported size of counter i");
                        }
                        bArr4[0] = (byte) (i10 >>> 24);
                    }
                    bArr4[bArr4.length - 3] = (byte) (i10 >>> 16);
                }
                bArr4[bArr4.length - 2] = (byte) (i10 >>> 8);
            }
            bArr4[bArr4.length - 1] = (byte) i10;
            this.f28599a.update(bArr4, 0, bArr4.length);
        }
        org.bouncycastle.crypto.a0 a0Var4 = this.f28599a;
        byte[] bArr5 = this.f28601c;
        a0Var4.update(bArr5, 0, bArr5.length);
        this.f28599a.c(this.f28607i, 0);
    }
}
