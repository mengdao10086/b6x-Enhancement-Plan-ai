package fp;

import np.i1;
import np.m1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class c implements org.bouncycastle.crypto.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.bouncycastle.crypto.s f28609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f28610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f28611d;

    public c(int i10, org.bouncycastle.crypto.s sVar) {
        this.f28608a = i10;
        this.f28609b = sVar;
    }

    @Override // org.bouncycastle.crypto.q
    public void a(org.bouncycastle.crypto.r rVar) {
        if (rVar instanceof m1) {
            m1 m1Var = (m1) rVar;
            this.f28610c = m1Var.b();
            this.f28611d = m1Var.a();
        } else {
            if (!(rVar instanceof i1)) {
                throw new IllegalArgumentException("KDF parameters required for generator");
            }
            this.f28610c = ((i1) rVar).a();
            this.f28611d = null;
        }
    }

    @Override // org.bouncycastle.crypto.q
    public int b(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
        int i12 = i11;
        int i13 = i10;
        if (bArr.length - i12 < i13) {
            throw new OutputLengthException("output buffer too small");
        }
        long j10 = i12;
        int iH = this.f28609b.h();
        if (j10 > 8589934591L) {
            throw new IllegalArgumentException("Output length too large");
        }
        long j11 = iH;
        int i14 = (int) (((j10 + j11) - 1) / j11);
        byte[] bArr2 = new byte[this.f28609b.h()];
        byte[] bArr3 = new byte[4];
        org.bouncycastle.util.o.h(this.f28608a, bArr3, 0);
        int i15 = this.f28608a & (-256);
        for (int i16 = 0; i16 < i14; i16++) {
            org.bouncycastle.crypto.s sVar = this.f28609b;
            byte[] bArr4 = this.f28610c;
            sVar.update(bArr4, 0, bArr4.length);
            this.f28609b.update(bArr3, 0, 4);
            byte[] bArr5 = this.f28611d;
            if (bArr5 != null) {
                this.f28609b.update(bArr5, 0, bArr5.length);
            }
            this.f28609b.c(bArr2, 0);
            if (i12 > iH) {
                System.arraycopy(bArr2, 0, bArr, i13, iH);
                i13 += iH;
                i12 -= iH;
            } else {
                System.arraycopy(bArr2, 0, bArr, i13, i12);
            }
            byte b10 = (byte) (bArr3[3] + 1);
            bArr3[3] = b10;
            if (b10 == 0) {
                i15 += 256;
                org.bouncycastle.util.o.h(i15, bArr3, 0);
            }
        }
        this.f28609b.reset();
        return (int) j10;
    }

    @Override // org.bouncycastle.crypto.t
    public org.bouncycastle.crypto.s c() {
        return this.f28609b;
    }
}
