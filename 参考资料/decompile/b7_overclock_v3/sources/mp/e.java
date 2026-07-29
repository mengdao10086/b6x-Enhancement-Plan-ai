package mp;

import np.w1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.k;

/* JADX INFO: loaded from: classes5.dex */
public class e extends org.bouncycastle.crypto.h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f41549g;

    public e(org.bouncycastle.crypto.f fVar) {
        this(fVar, new d());
    }

    public e(org.bouncycastle.crypto.f fVar, a aVar) {
        this.f44684d = fVar;
        this.f41549g = aVar;
        this.f44681a = new byte[fVar.c()];
        this.f44682b = 0;
    }

    @Override // org.bouncycastle.crypto.h
    public int a(byte[] bArr, int i10) throws InvalidCipherTextException, IllegalStateException, DataLengthException {
        int iC;
        int iD;
        int iC2 = this.f44684d.c();
        if (this.f44683c) {
            if (this.f44682b != iC2) {
                iD = 0;
            } else {
                if ((iC2 * 2) + i10 > bArr.length) {
                    i();
                    throw new OutputLengthException("output buffer too short");
                }
                iD = this.f44684d.d(this.f44681a, 0, bArr, i10);
                this.f44682b = 0;
            }
            this.f41549g.b(this.f44681a, this.f44682b);
            iC = iD + this.f44684d.d(this.f44681a, 0, bArr, i10 + iD);
        } else {
            if (this.f44682b != iC2) {
                i();
                throw new DataLengthException("last block incomplete in decryption");
            }
            org.bouncycastle.crypto.f fVar = this.f44684d;
            byte[] bArr2 = this.f44681a;
            int iD2 = fVar.d(bArr2, 0, bArr2, 0);
            this.f44682b = 0;
            try {
                iC = iD2 - this.f41549g.c(this.f44681a);
                System.arraycopy(this.f44681a, 0, bArr, i10, iC);
            } finally {
                i();
            }
        }
        return iC;
    }

    @Override // org.bouncycastle.crypto.h
    public int c(int i10) {
        int i11 = i10 + this.f44682b;
        byte[] bArr = this.f44681a;
        int length = i11 % bArr.length;
        if (length != 0) {
            i11 -= length;
        } else if (!this.f44683c) {
            return i11;
        }
        return i11 + bArr.length;
    }

    @Override // org.bouncycastle.crypto.h
    public int e(int i10) {
        int i11 = i10 + this.f44682b;
        byte[] bArr = this.f44681a;
        int length = i11 % bArr.length;
        return length == 0 ? Math.max(0, i11 - bArr.length) : i11 - length;
    }

    @Override // org.bouncycastle.crypto.h
    public void f(boolean z10, k kVar) throws IllegalArgumentException {
        org.bouncycastle.crypto.f fVar;
        this.f44683c = z10;
        i();
        if (kVar instanceof w1) {
            w1 w1Var = (w1) kVar;
            this.f41549g.d(w1Var.b());
            fVar = this.f44684d;
            kVar = w1Var.a();
        } else {
            this.f41549g.d(null);
            fVar = this.f44684d;
        }
        fVar.a(z10, kVar);
    }

    @Override // org.bouncycastle.crypto.h
    public int g(byte b10, byte[] bArr, int i10) throws IllegalStateException, DataLengthException {
        int i11 = this.f44682b;
        byte[] bArr2 = this.f44681a;
        int i12 = 0;
        if (i11 == bArr2.length) {
            int iD = this.f44684d.d(bArr2, 0, bArr, i10);
            this.f44682b = 0;
            i12 = iD;
        }
        byte[] bArr3 = this.f44681a;
        int i13 = this.f44682b;
        this.f44682b = i13 + 1;
        bArr3[i13] = b10;
        return i12;
    }

    @Override // org.bouncycastle.crypto.h
    public int h(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws IllegalStateException, DataLengthException {
        if (i11 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int iB = b();
        int iE = e(i11);
        if (iE > 0 && iE + i12 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        byte[] bArr3 = this.f44681a;
        int length = bArr3.length;
        int i13 = this.f44682b;
        int i14 = length - i13;
        int iD = 0;
        if (i11 > i14) {
            System.arraycopy(bArr, i10, bArr3, i13, i14);
            int iD2 = this.f44684d.d(this.f44681a, 0, bArr2, i12) + 0;
            this.f44682b = 0;
            i11 -= i14;
            i10 += i14;
            iD = iD2;
            while (i11 > this.f44681a.length) {
                iD += this.f44684d.d(bArr, i10, bArr2, i12 + iD);
                i11 -= iB;
                i10 += iB;
            }
        }
        System.arraycopy(bArr, i10, this.f44681a, this.f44682b, i11);
        this.f44682b += i11;
        return iD;
    }
}
