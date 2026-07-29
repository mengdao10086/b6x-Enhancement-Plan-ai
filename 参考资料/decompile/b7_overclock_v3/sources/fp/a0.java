package fp;

import java.math.BigInteger;
import np.j1;
import np.n1;
import org.bouncycastle.crypto.DataLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class a0 implements org.bouncycastle.crypto.b0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f28569i = BigInteger.valueOf(2147483647L);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final BigInteger f28570j = BigInteger.valueOf(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.crypto.a0 f28571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f28572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f28573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f28574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f28575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f28576f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f28577g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f28578h;

    public a0(org.bouncycastle.crypto.a0 a0Var) {
        this.f28571a = a0Var;
        int iD = a0Var.d();
        this.f28572b = iD;
        this.f28578h = new byte[iD];
    }

    @Override // org.bouncycastle.crypto.q
    public void a(org.bouncycastle.crypto.r rVar) {
        if (!(rVar instanceof j1)) {
            throw new IllegalArgumentException("Wrong type of arguments given");
        }
        j1 j1Var = (j1) rVar;
        this.f28571a.a(new n1(j1Var.d()));
        this.f28573c = j1Var.b();
        this.f28574d = j1Var.c();
        int iE = j1Var.e();
        this.f28576f = new byte[iE / 8];
        BigInteger bigIntegerMultiply = f28570j.pow(iE).multiply(BigInteger.valueOf(this.f28572b));
        this.f28575e = bigIntegerMultiply.compareTo(f28569i) == 1 ? Integer.MAX_VALUE : bigIntegerMultiply.intValue();
        this.f28577g = 0;
    }

    @Override // org.bouncycastle.crypto.q
    public int b(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
        int i12 = this.f28577g;
        int i13 = i12 + i11;
        if (i13 < 0 || i13 >= this.f28575e) {
            throw new DataLengthException("Current KDFCTR may only be used for " + this.f28575e + " bytes");
        }
        if (i12 % this.f28572b == 0) {
            e();
        }
        int i14 = this.f28577g;
        int i15 = this.f28572b;
        int i16 = i14 % i15;
        int iMin = Math.min(i15 - (i14 % i15), i11);
        System.arraycopy(this.f28578h, i16, bArr, i10, iMin);
        this.f28577g += iMin;
        int i17 = i11 - iMin;
        while (true) {
            i10 += iMin;
            if (i17 <= 0) {
                return i11;
            }
            e();
            iMin = Math.min(this.f28572b, i17);
            System.arraycopy(this.f28578h, 0, bArr, i10, iMin);
            this.f28577g += iMin;
            i17 -= iMin;
        }
    }

    @Override // org.bouncycastle.crypto.b0
    public org.bouncycastle.crypto.a0 d() {
        return this.f28571a;
    }

    public final void e() {
        int i10 = (this.f28577g / this.f28572b) + 1;
        byte[] bArr = this.f28576f;
        int length = bArr.length;
        if (length != 1) {
            if (length != 2) {
                if (length != 3) {
                    if (length != 4) {
                        throw new IllegalStateException("Unsupported size of counter i");
                    }
                    bArr[0] = (byte) (i10 >>> 24);
                }
                bArr[bArr.length - 3] = (byte) (i10 >>> 16);
            }
            bArr[bArr.length - 2] = (byte) (i10 >>> 8);
        }
        bArr[bArr.length - 1] = (byte) i10;
        org.bouncycastle.crypto.a0 a0Var = this.f28571a;
        byte[] bArr2 = this.f28573c;
        a0Var.update(bArr2, 0, bArr2.length);
        org.bouncycastle.crypto.a0 a0Var2 = this.f28571a;
        byte[] bArr3 = this.f28576f;
        a0Var2.update(bArr3, 0, bArr3.length);
        org.bouncycastle.crypto.a0 a0Var3 = this.f28571a;
        byte[] bArr4 = this.f28574d;
        a0Var3.update(bArr4, 0, bArr4.length);
        this.f28571a.c(this.f28578h, 0);
    }
}
