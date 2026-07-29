package fp;

import np.n1;
import np.v1;

/* JADX INFO: loaded from: classes5.dex */
public class j0 extends org.bouncycastle.crypto.c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public org.bouncycastle.crypto.a0 f28654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f28655e;

    public j0() {
        this(org.bouncycastle.crypto.util.f.c());
    }

    public j0(org.bouncycastle.crypto.s sVar) {
        ip.k kVar = new ip.k(sVar);
        this.f28654d = kVar;
        this.f28655e = new byte[kVar.d()];
    }

    @Override // org.bouncycastle.crypto.c0
    public org.bouncycastle.crypto.k d(int i10) {
        return e(i10);
    }

    @Override // org.bouncycastle.crypto.c0
    public org.bouncycastle.crypto.k e(int i10) {
        int i11 = i10 / 8;
        return new n1(l(i11), 0, i11);
    }

    @Override // org.bouncycastle.crypto.c0
    public org.bouncycastle.crypto.k f(int i10, int i11) {
        int i12 = i10 / 8;
        int i13 = i11 / 8;
        byte[] bArrL = l(i12 + i13);
        return new v1(new n1(bArrL, 0, i12), bArrL, i12, i13);
    }

    public final void k(byte[] bArr, int i10, byte[] bArr2, byte[] bArr3, int i11) {
        if (i10 == 0) {
            throw new IllegalArgumentException("iteration count must be at least 1.");
        }
        if (bArr != null) {
            this.f28654d.update(bArr, 0, bArr.length);
        }
        this.f28654d.update(bArr2, 0, bArr2.length);
        this.f28654d.c(this.f28655e, 0);
        byte[] bArr4 = this.f28655e;
        System.arraycopy(bArr4, 0, bArr3, i11, bArr4.length);
        for (int i12 = 1; i12 < i10; i12++) {
            org.bouncycastle.crypto.a0 a0Var = this.f28654d;
            byte[] bArr5 = this.f28655e;
            a0Var.update(bArr5, 0, bArr5.length);
            this.f28654d.c(this.f28655e, 0);
            int i13 = 0;
            while (true) {
                byte[] bArr6 = this.f28655e;
                if (i13 != bArr6.length) {
                    int i14 = i11 + i13;
                    bArr3[i14] = (byte) (bArr6[i13] ^ bArr3[i14]);
                    i13++;
                }
            }
        }
    }

    public final byte[] l(int i10) {
        int i11;
        int iD = this.f28654d.d();
        int i12 = ((i10 + iD) - 1) / iD;
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[i12 * iD];
        this.f28654d.a(new n1(this.f44662a));
        int i13 = 0;
        for (int i14 = 1; i14 <= i12; i14++) {
            while (true) {
                byte b10 = (byte) (bArr[i11] + 1);
                bArr[i11] = b10;
                i11 = b10 == 0 ? i11 - 1 : 3;
            }
            k(this.f44663b, this.f44664c, bArr, bArr2, i13);
            i13 += iD;
        }
        return bArr2;
    }
}
