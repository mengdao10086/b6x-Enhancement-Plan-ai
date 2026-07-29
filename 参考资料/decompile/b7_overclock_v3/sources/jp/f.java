package jp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.j0;

/* JADX INFO: loaded from: classes5.dex */
public class f extends org.bouncycastle.crypto.h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f36581g;

    public f(org.bouncycastle.crypto.f fVar) {
        if (fVar instanceof j0) {
            throw new IllegalArgumentException("CTSBlockCipher can only accept ECB, or CBC ciphers");
        }
        this.f44684d = fVar;
        int iC = fVar.c();
        this.f36581g = iC;
        this.f44681a = new byte[iC * 2];
        this.f44682b = 0;
    }

    @Override // org.bouncycastle.crypto.h
    public int a(byte[] bArr, int i10) throws InvalidCipherTextException, IllegalStateException, DataLengthException {
        if (this.f44682b + i10 > bArr.length) {
            throw new OutputLengthException("output buffer to small in doFinal");
        }
        int iC = this.f44684d.c();
        int i11 = this.f44682b;
        int i12 = i11 - iC;
        byte[] bArr2 = new byte[iC];
        if (this.f44683c) {
            if (i11 < iC) {
                throw new DataLengthException("need at least one block of input for CTS");
            }
            this.f44684d.d(this.f44681a, 0, bArr2, 0);
            int i13 = this.f44682b;
            if (i13 > iC) {
                while (true) {
                    byte[] bArr3 = this.f44681a;
                    if (i13 == bArr3.length) {
                        break;
                    }
                    bArr3[i13] = bArr2[i13 - iC];
                    i13++;
                }
                for (int i14 = iC; i14 != this.f44682b; i14++) {
                    byte[] bArr4 = this.f44681a;
                    bArr4[i14] = (byte) (bArr4[i14] ^ bArr2[i14 - iC]);
                }
                org.bouncycastle.crypto.f fVar = this.f44684d;
                if (fVar instanceof c) {
                    ((c) fVar).g().d(this.f44681a, iC, bArr, i10);
                } else {
                    fVar.d(this.f44681a, iC, bArr, i10);
                }
                System.arraycopy(bArr2, 0, bArr, i10 + iC, i12);
            } else {
                System.arraycopy(bArr2, 0, bArr, i10, iC);
            }
        } else {
            if (i11 < iC) {
                throw new DataLengthException("need at least one block of input for CTS");
            }
            byte[] bArr5 = new byte[iC];
            if (i11 > iC) {
                org.bouncycastle.crypto.f fVar2 = this.f44684d;
                if (fVar2 instanceof c) {
                    ((c) fVar2).g().d(this.f44681a, 0, bArr2, 0);
                } else {
                    fVar2.d(this.f44681a, 0, bArr2, 0);
                }
                for (int i15 = iC; i15 != this.f44682b; i15++) {
                    int i16 = i15 - iC;
                    bArr5[i16] = (byte) (bArr2[i16] ^ this.f44681a[i15]);
                }
                System.arraycopy(this.f44681a, iC, bArr2, 0, i12);
                this.f44684d.d(bArr2, 0, bArr, i10);
                System.arraycopy(bArr5, 0, bArr, i10 + iC, i12);
            } else {
                this.f44684d.d(this.f44681a, 0, bArr2, 0);
                System.arraycopy(bArr2, 0, bArr, i10, iC);
            }
        }
        int i17 = this.f44682b;
        i();
        return i17;
    }

    @Override // org.bouncycastle.crypto.h
    public int c(int i10) {
        return i10 + this.f44682b;
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
            byte[] bArr3 = this.f44681a;
            int i13 = this.f36581g;
            System.arraycopy(bArr3, i13, bArr3, 0, i13);
            this.f44682b = this.f36581g;
            i12 = iD;
        }
        byte[] bArr4 = this.f44681a;
        int i14 = this.f44682b;
        this.f44682b = i14 + 1;
        bArr4[i14] = b10;
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
        int i15 = 0;
        if (i11 > i14) {
            System.arraycopy(bArr, i10, bArr3, i13, i14);
            int iD = this.f44684d.d(this.f44681a, 0, bArr2, i12) + 0;
            byte[] bArr4 = this.f44681a;
            System.arraycopy(bArr4, iB, bArr4, 0, iB);
            this.f44682b = iB;
            i11 -= i14;
            i10 += i14;
            while (i11 > iB) {
                System.arraycopy(bArr, i10, this.f44681a, this.f44682b, iB);
                iD += this.f44684d.d(this.f44681a, 0, bArr2, i12 + iD);
                byte[] bArr5 = this.f44681a;
                System.arraycopy(bArr5, iB, bArr5, 0, iB);
                i11 -= iB;
                i10 += iB;
            }
            i15 = iD;
        }
        System.arraycopy(bArr, i10, this.f44681a, this.f44682b, i11);
        this.f44682b += i11;
        return i15;
    }
}
