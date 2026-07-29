package fp;

import java.math.BigInteger;
import np.l1;
import np.n1;
import org.bouncycastle.crypto.DataLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class c0 implements org.bouncycastle.crypto.b0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final BigInteger f28612j = BigInteger.valueOf(2147483647L);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final BigInteger f28613k = BigInteger.valueOf(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.crypto.a0 f28614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f28615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f28616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f28617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f28618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f28619f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f28620g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f28621h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f28622i;

    public c0(org.bouncycastle.crypto.a0 a0Var) {
        this.f28614a = a0Var;
        int iD = a0Var.d();
        this.f28615b = iD;
        this.f28622i = new byte[iD];
    }

    @Override // org.bouncycastle.crypto.q
    public void a(org.bouncycastle.crypto.r rVar) {
        if (!(rVar instanceof l1)) {
            throw new IllegalArgumentException("Wrong type of arguments given");
        }
        l1 l1Var = (l1) rVar;
        this.f28614a.a(new n1(l1Var.e()));
        this.f28616c = l1Var.c();
        int iF = l1Var.f();
        this.f28618e = new byte[iF / 8];
        int iIntValue = Integer.MAX_VALUE;
        if (l1Var.g()) {
            BigInteger bigIntegerMultiply = f28613k.pow(iF).multiply(BigInteger.valueOf(this.f28615b));
            if (bigIntegerMultiply.compareTo(f28612j) != 1) {
                iIntValue = bigIntegerMultiply.intValue();
            }
        }
        this.f28617d = iIntValue;
        this.f28619f = l1Var.d();
        this.f28620g = l1Var.g();
        this.f28621h = 0;
    }

    @Override // org.bouncycastle.crypto.q
    public int b(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
        int i12 = this.f28621h;
        int i13 = i12 + i11;
        if (i13 < 0 || i13 >= this.f28617d) {
            throw new DataLengthException("Current KDFCTR may only be used for " + this.f28617d + " bytes");
        }
        if (i12 % this.f28615b == 0) {
            e();
        }
        int i14 = this.f28621h;
        int i15 = this.f28615b;
        int i16 = i14 % i15;
        int iMin = Math.min(i15 - (i14 % i15), i11);
        System.arraycopy(this.f28622i, i16, bArr, i10, iMin);
        this.f28621h += iMin;
        int i17 = i11 - iMin;
        while (true) {
            i10 += iMin;
            if (i17 <= 0) {
                return i11;
            }
            e();
            iMin = Math.min(this.f28615b, i17);
            System.arraycopy(this.f28622i, 0, bArr, i10, iMin);
            this.f28621h += iMin;
            i17 -= iMin;
        }
    }

    @Override // org.bouncycastle.crypto.b0
    public org.bouncycastle.crypto.a0 d() {
        return this.f28614a;
    }

    public final void e() {
        if (this.f28621h == 0) {
            org.bouncycastle.crypto.a0 a0Var = this.f28614a;
            byte[] bArr = this.f28619f;
            a0Var.update(bArr, 0, bArr.length);
        } else {
            org.bouncycastle.crypto.a0 a0Var2 = this.f28614a;
            byte[] bArr2 = this.f28622i;
            a0Var2.update(bArr2, 0, bArr2.length);
        }
        if (this.f28620g) {
            int i10 = (this.f28621h / this.f28615b) + 1;
            byte[] bArr3 = this.f28618e;
            int length = bArr3.length;
            if (length != 1) {
                if (length != 2) {
                    if (length != 3) {
                        if (length != 4) {
                            throw new IllegalStateException("Unsupported size of counter i");
                        }
                        bArr3[0] = (byte) (i10 >>> 24);
                    }
                    bArr3[bArr3.length - 3] = (byte) (i10 >>> 16);
                }
                bArr3[bArr3.length - 2] = (byte) (i10 >>> 8);
            }
            bArr3[bArr3.length - 1] = (byte) i10;
            this.f28614a.update(bArr3, 0, bArr3.length);
        }
        org.bouncycastle.crypto.a0 a0Var3 = this.f28614a;
        byte[] bArr4 = this.f28616c;
        a0Var3.update(bArr4, 0, bArr4.length);
        this.f28614a.c(this.f28622i, 0);
    }
}
