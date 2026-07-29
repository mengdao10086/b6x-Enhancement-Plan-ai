package jp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class b0 extends org.bouncycastle.crypto.h {
    public b0(org.bouncycastle.crypto.f fVar) {
        this.f44684d = fVar;
        this.f44681a = new byte[fVar.c()];
        this.f44682b = 0;
    }

    @Override // org.bouncycastle.crypto.h
    public int a(byte[] bArr, int i10) throws InvalidCipherTextException, IllegalStateException, DataLengthException {
        int iD;
        int iD2;
        int iC = this.f44684d.c();
        if (this.f44683c) {
            if (this.f44682b != iC) {
                iD2 = 0;
            } else {
                if ((iC * 2) + i10 > bArr.length) {
                    throw new OutputLengthException("output buffer too short");
                }
                iD2 = this.f44684d.d(this.f44681a, 0, bArr, i10);
                this.f44682b = 0;
            }
            byte b10 = (byte) (iC - this.f44682b);
            while (true) {
                int i11 = this.f44682b;
                if (i11 >= iC) {
                    break;
                }
                this.f44681a[i11] = b10;
                this.f44682b = i11 + 1;
            }
            iD = iD2 + this.f44684d.d(this.f44681a, 0, bArr, i10 + iD2);
        } else {
            if (this.f44682b != iC) {
                throw new DataLengthException("last block incomplete in decryption");
            }
            org.bouncycastle.crypto.f fVar = this.f44684d;
            byte[] bArr2 = this.f44681a;
            int iD3 = fVar.d(bArr2, 0, bArr2, 0);
            this.f44682b = 0;
            byte[] bArr3 = this.f44681a;
            int i12 = bArr3[iC - 1] & 255;
            if (i12 > iC) {
                throw new InvalidCipherTextException("pad block corrupted");
            }
            iD = iD3 - i12;
            System.arraycopy(bArr3, 0, bArr, i10, iD);
        }
        i();
        return iD;
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
        return length == 0 ? i11 - bArr.length : i11 - length;
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
