package fp;

import np.n1;
import np.v1;

/* JADX INFO: loaded from: classes5.dex */
public class g0 extends org.bouncycastle.crypto.c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final org.bouncycastle.crypto.s f28641d;

    public g0() {
        this(org.bouncycastle.crypto.util.f.b());
    }

    public g0(org.bouncycastle.crypto.s sVar) {
        this.f28641d = sVar;
    }

    @Override // org.bouncycastle.crypto.c0
    public org.bouncycastle.crypto.k d(int i10) {
        return e(i10);
    }

    @Override // org.bouncycastle.crypto.c0
    public org.bouncycastle.crypto.k e(int i10) {
        int i11 = i10 / 8;
        return new n1(k(i11), 0, i11);
    }

    @Override // org.bouncycastle.crypto.c0
    public org.bouncycastle.crypto.k f(int i10, int i11) {
        int i12 = i10 / 8;
        int i13 = i11 / 8;
        byte[] bArrK = k(i12 + i13);
        return new v1(new n1(bArrK, 0, i12), bArrK, i12, i13);
    }

    public final byte[] k(int i10) {
        int iH = this.f28641d.h();
        byte[] bArr = new byte[iH];
        byte[] bArr2 = new byte[i10];
        int i11 = 0;
        while (true) {
            org.bouncycastle.crypto.s sVar = this.f28641d;
            byte[] bArr3 = this.f44662a;
            sVar.update(bArr3, 0, bArr3.length);
            org.bouncycastle.crypto.s sVar2 = this.f28641d;
            byte[] bArr4 = this.f44663b;
            sVar2.update(bArr4, 0, bArr4.length);
            this.f28641d.c(bArr, 0);
            int i12 = i10 > iH ? iH : i10;
            System.arraycopy(bArr, 0, bArr2, i11, i12);
            i11 += i12;
            i10 -= i12;
            if (i10 == 0) {
                return bArr2;
            }
            this.f28641d.reset();
            this.f28641d.update(bArr, 0, iH);
        }
    }

    public void l(byte[] bArr, byte[] bArr2) {
        super.j(bArr, bArr2, 1);
    }
}
