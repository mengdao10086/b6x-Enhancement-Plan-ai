package fp;

import np.n1;
import np.v1;

/* JADX INFO: loaded from: classes5.dex */
public class i0 extends org.bouncycastle.crypto.c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public org.bouncycastle.crypto.s f28652d;

    public i0(org.bouncycastle.crypto.s sVar) {
        this.f28652d = sVar;
    }

    @Override // org.bouncycastle.crypto.c0
    public org.bouncycastle.crypto.k d(int i10) {
        return e(i10);
    }

    @Override // org.bouncycastle.crypto.c0
    public org.bouncycastle.crypto.k e(int i10) {
        int i11 = i10 / 8;
        if (i11 <= this.f28652d.h()) {
            return new n1(k(), 0, i11);
        }
        throw new IllegalArgumentException("Can't generate a derived key " + i11 + " bytes long.");
    }

    @Override // org.bouncycastle.crypto.c0
    public org.bouncycastle.crypto.k f(int i10, int i11) {
        int i12 = i10 / 8;
        int i13 = i11 / 8;
        int i14 = i12 + i13;
        if (i14 <= this.f28652d.h()) {
            byte[] bArrK = k();
            return new v1(new n1(bArrK, 0, i12), bArrK, i12, i13);
        }
        throw new IllegalArgumentException("Can't generate a derived key " + i14 + " bytes long.");
    }

    public final byte[] k() {
        int iH = this.f28652d.h();
        byte[] bArr = new byte[iH];
        org.bouncycastle.crypto.s sVar = this.f28652d;
        byte[] bArr2 = this.f44662a;
        sVar.update(bArr2, 0, bArr2.length);
        org.bouncycastle.crypto.s sVar2 = this.f28652d;
        byte[] bArr3 = this.f44663b;
        sVar2.update(bArr3, 0, bArr3.length);
        this.f28652d.c(bArr, 0);
        for (int i10 = 1; i10 < this.f44664c; i10++) {
            this.f28652d.update(bArr, 0, iH);
            this.f28652d.c(bArr, 0);
        }
        return bArr;
    }
}
