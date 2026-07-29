package rp;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.n1;

/* JADX INFO: loaded from: classes5.dex */
public class q implements c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BigInteger f49030e = BigInteger.valueOf(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ip.k f49031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f49032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f49033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BigInteger f49034d;

    public q(org.bouncycastle.crypto.s sVar) {
        ip.k kVar = new ip.k(sVar);
        this.f49031a = kVar;
        this.f49033c = new byte[kVar.d()];
        this.f49032b = new byte[kVar.d()];
    }

    @Override // rp.c
    public BigInteger a() {
        int iK = org.bouncycastle.util.b.k(this.f49034d);
        byte[] bArr = new byte[iK];
        while (true) {
            int i10 = 0;
            while (i10 < iK) {
                ip.k kVar = this.f49031a;
                byte[] bArr2 = this.f49033c;
                kVar.update(bArr2, 0, bArr2.length);
                this.f49031a.c(this.f49033c, 0);
                int iMin = Math.min(iK - i10, this.f49033c.length);
                System.arraycopy(this.f49033c, 0, bArr, i10, iMin);
                i10 += iMin;
            }
            BigInteger bigIntegerE = e(bArr);
            if (bigIntegerE.compareTo(f49030e) > 0 && bigIntegerE.compareTo(this.f49034d) < 0) {
                return bigIntegerE;
            }
            ip.k kVar2 = this.f49031a;
            byte[] bArr3 = this.f49033c;
            kVar2.update(bArr3, 0, bArr3.length);
            this.f49031a.update((byte) 0);
            this.f49031a.c(this.f49032b, 0);
            this.f49031a.a(new n1(this.f49032b));
            ip.k kVar3 = this.f49031a;
            byte[] bArr4 = this.f49033c;
            kVar3.update(bArr4, 0, bArr4.length);
            this.f49031a.c(this.f49033c, 0);
        }
    }

    @Override // rp.c
    public boolean b() {
        return true;
    }

    @Override // rp.c
    public void c(BigInteger bigInteger, SecureRandom secureRandom) {
        throw new IllegalStateException("Operation not supported");
    }

    @Override // rp.c
    public void d(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.f49034d = bigInteger;
        org.bouncycastle.util.a.d0(this.f49033c, (byte) 1);
        org.bouncycastle.util.a.d0(this.f49032b, (byte) 0);
        int iK = org.bouncycastle.util.b.k(bigInteger);
        byte[] bArr2 = new byte[iK];
        byte[] bArrC = org.bouncycastle.util.b.c(bigInteger2);
        System.arraycopy(bArrC, 0, bArr2, iK - bArrC.length, bArrC.length);
        byte[] bArr3 = new byte[iK];
        BigInteger bigIntegerE = e(bArr);
        if (bigIntegerE.compareTo(bigInteger) >= 0) {
            bigIntegerE = bigIntegerE.subtract(bigInteger);
        }
        byte[] bArrC2 = org.bouncycastle.util.b.c(bigIntegerE);
        System.arraycopy(bArrC2, 0, bArr3, iK - bArrC2.length, bArrC2.length);
        this.f49031a.a(new n1(this.f49032b));
        ip.k kVar = this.f49031a;
        byte[] bArr4 = this.f49033c;
        kVar.update(bArr4, 0, bArr4.length);
        this.f49031a.update((byte) 0);
        this.f49031a.update(bArr2, 0, iK);
        this.f49031a.update(bArr3, 0, iK);
        this.f49031a.c(this.f49032b, 0);
        this.f49031a.a(new n1(this.f49032b));
        ip.k kVar2 = this.f49031a;
        byte[] bArr5 = this.f49033c;
        kVar2.update(bArr5, 0, bArr5.length);
        this.f49031a.c(this.f49033c, 0);
        ip.k kVar3 = this.f49031a;
        byte[] bArr6 = this.f49033c;
        kVar3.update(bArr6, 0, bArr6.length);
        this.f49031a.update((byte) 1);
        this.f49031a.update(bArr2, 0, iK);
        this.f49031a.update(bArr3, 0, iK);
        this.f49031a.c(this.f49032b, 0);
        this.f49031a.a(new n1(this.f49032b));
        ip.k kVar4 = this.f49031a;
        byte[] bArr7 = this.f49033c;
        kVar4.update(bArr7, 0, bArr7.length);
        this.f49031a.c(this.f49033c, 0);
    }

    public final BigInteger e(byte[] bArr) {
        BigInteger bigInteger = new BigInteger(1, bArr);
        return bArr.length * 8 > this.f49034d.bitLength() ? bigInteger.shiftRight((bArr.length * 8) - this.f49034d.bitLength()) : bigInteger;
    }
}
