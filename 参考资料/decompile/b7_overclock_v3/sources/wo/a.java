package wo;

import np.m1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.q;
import org.bouncycastle.crypto.r;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes5.dex */
public class a implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f54753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f54754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f54755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f54756d;

    public a(s sVar) {
        this.f54753a = sVar;
        this.f54756d = sVar.h();
    }

    @Override // org.bouncycastle.crypto.q
    public void a(r rVar) {
        if (!(rVar instanceof m1)) {
            throw new IllegalArgumentException("KDF parameters required for generator");
        }
        m1 m1Var = (m1) rVar;
        this.f54754b = m1Var.b();
        this.f54755c = m1Var.a();
    }

    @Override // org.bouncycastle.crypto.q
    public int b(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
        int i12;
        int i13;
        if (bArr.length - i11 < i10) {
            throw new OutputLengthException("output buffer too small");
        }
        byte[] bArr2 = new byte[this.f54756d];
        byte[] bArr3 = new byte[4];
        this.f54753a.reset();
        int i14 = 1;
        if (i11 > this.f54756d) {
            i12 = 0;
            while (true) {
                e(i14, bArr3);
                this.f54753a.update(bArr3, 0, 4);
                s sVar = this.f54753a;
                byte[] bArr4 = this.f54754b;
                sVar.update(bArr4, 0, bArr4.length);
                s sVar2 = this.f54753a;
                byte[] bArr5 = this.f54755c;
                sVar2.update(bArr5, 0, bArr5.length);
                this.f54753a.c(bArr2, 0);
                System.arraycopy(bArr2, 0, bArr, i10 + i12, this.f54756d);
                int i15 = this.f54756d;
                i12 += i15;
                i13 = i14 + 1;
                if (i14 >= i11 / i15) {
                    break;
                }
                i14 = i13;
            }
            i14 = i13;
        } else {
            i12 = 0;
        }
        if (i12 < i11) {
            e(i14, bArr3);
            this.f54753a.update(bArr3, 0, 4);
            s sVar3 = this.f54753a;
            byte[] bArr6 = this.f54754b;
            sVar3.update(bArr6, 0, bArr6.length);
            s sVar4 = this.f54753a;
            byte[] bArr7 = this.f54755c;
            sVar4.update(bArr7, 0, bArr7.length);
            this.f54753a.c(bArr2, 0);
            System.arraycopy(bArr2, 0, bArr, i10 + i12, i11 - i12);
        }
        return i11;
    }

    public s c() {
        return this.f54753a;
    }

    public final void e(int i10, byte[] bArr) {
        bArr[0] = (byte) (i10 >>> 24);
        bArr[1] = (byte) (i10 >>> 16);
        bArr[2] = (byte) (i10 >>> 8);
        bArr[3] = (byte) (i10 >>> 0);
    }
}
