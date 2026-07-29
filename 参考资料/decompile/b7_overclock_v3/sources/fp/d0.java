package fp;

import np.o1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class d0 implements org.bouncycastle.crypto.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.s f28625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f28626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f28627c;

    public d0(org.bouncycastle.crypto.s sVar) {
        this.f28625a = sVar;
        this.f28627c = sVar.h();
    }

    @Override // org.bouncycastle.crypto.q
    public void a(org.bouncycastle.crypto.r rVar) {
        if (!(rVar instanceof o1)) {
            throw new IllegalArgumentException("MGF parameters required for MGF1Generator");
        }
        this.f28626b = ((o1) rVar).a();
    }

    @Override // org.bouncycastle.crypto.q
    public int b(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
        int i12;
        if (bArr.length - i11 < i10) {
            throw new OutputLengthException("output buffer too small");
        }
        byte[] bArr2 = new byte[this.f28627c];
        byte[] bArr3 = new byte[4];
        this.f28625a.reset();
        if (i11 > this.f28627c) {
            i12 = 0;
            do {
                e(i12, bArr3);
                org.bouncycastle.crypto.s sVar = this.f28625a;
                byte[] bArr4 = this.f28626b;
                sVar.update(bArr4, 0, bArr4.length);
                this.f28625a.update(bArr3, 0, 4);
                this.f28625a.c(bArr2, 0);
                int i13 = this.f28627c;
                System.arraycopy(bArr2, 0, bArr, (i12 * i13) + i10, i13);
                i12++;
            } while (i12 < i11 / this.f28627c);
        } else {
            i12 = 0;
        }
        if (this.f28627c * i12 < i11) {
            e(i12, bArr3);
            org.bouncycastle.crypto.s sVar2 = this.f28625a;
            byte[] bArr5 = this.f28626b;
            sVar2.update(bArr5, 0, bArr5.length);
            this.f28625a.update(bArr3, 0, 4);
            this.f28625a.c(bArr2, 0);
            int i14 = this.f28627c;
            System.arraycopy(bArr2, 0, bArr, i10 + (i12 * i14), i11 - (i12 * i14));
        }
        return i11;
    }

    public org.bouncycastle.crypto.s c() {
        return this.f28625a;
    }

    public final void e(int i10, byte[] bArr) {
        bArr[0] = (byte) (i10 >>> 24);
        bArr[1] = (byte) (i10 >>> 16);
        bArr[2] = (byte) (i10 >>> 8);
        bArr[3] = (byte) (i10 >>> 0);
    }
}
