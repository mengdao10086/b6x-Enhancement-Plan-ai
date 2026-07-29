package jp;

import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class v extends org.bouncycastle.crypto.h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f36772i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f36773j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f36774k = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f36775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f36776h;

    public v(int i10, org.bouncycastle.crypto.f fVar) {
        this.f36775g = i10;
        this.f44684d = new c(fVar);
        int iC = fVar.c();
        this.f36776h = iC;
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
                throw new DataLengthException("need at least one block of input for NISTCTS");
            }
            if (i11 > iC) {
                byte[] bArr3 = new byte[iC];
                int i13 = this.f36775g;
                if (i13 == 2 || i13 == 3) {
                    this.f44684d.d(this.f44681a, 0, bArr2, 0);
                    System.arraycopy(this.f44681a, iC, bArr3, 0, i12);
                    this.f44684d.d(bArr3, 0, bArr3, 0);
                    if (this.f36775g == 2 && i12 == iC) {
                        System.arraycopy(bArr2, 0, bArr, i10, iC);
                        System.arraycopy(bArr3, 0, bArr, i10 + iC, i12);
                    } else {
                        System.arraycopy(bArr3, 0, bArr, i10, iC);
                        System.arraycopy(bArr2, 0, bArr, i10 + iC, i12);
                    }
                } else {
                    System.arraycopy(this.f44681a, 0, bArr2, 0, iC);
                    this.f44684d.d(bArr2, 0, bArr2, 0);
                    System.arraycopy(bArr2, 0, bArr, i10, i12);
                    System.arraycopy(this.f44681a, this.f44682b - i12, bArr3, 0, i12);
                    this.f44684d.d(bArr3, 0, bArr3, 0);
                    System.arraycopy(bArr3, 0, bArr, i10 + i12, iC);
                }
            } else {
                this.f44684d.d(this.f44681a, 0, bArr2, 0);
                System.arraycopy(bArr2, 0, bArr, i10, iC);
            }
        } else {
            if (i11 < iC) {
                throw new DataLengthException("need at least one block of input for CTS");
            }
            byte[] bArr4 = new byte[iC];
            if (i11 > iC) {
                int i14 = this.f36775g;
                if (i14 == 3 || (i14 == 2 && (this.f44681a.length - i11) % iC != 0)) {
                    org.bouncycastle.crypto.f fVar = this.f44684d;
                    if (fVar instanceof c) {
                        ((c) fVar).g().d(this.f44681a, 0, bArr2, 0);
                    } else {
                        fVar.d(this.f44681a, 0, bArr2, 0);
                    }
                    for (int i15 = iC; i15 != this.f44682b; i15++) {
                        int i16 = i15 - iC;
                        bArr4[i16] = (byte) (bArr2[i16] ^ this.f44681a[i15]);
                    }
                    System.arraycopy(this.f44681a, iC, bArr2, 0, i12);
                    this.f44684d.d(bArr2, 0, bArr, i10);
                } else {
                    ((c) this.f44684d).g().d(this.f44681a, this.f44682b - iC, bArr4, 0);
                    System.arraycopy(this.f44681a, 0, bArr2, 0, iC);
                    if (i12 != iC) {
                        System.arraycopy(bArr4, i12, bArr2, i12, iC - i12);
                    }
                    this.f44684d.d(bArr2, 0, bArr2, 0);
                    System.arraycopy(bArr2, 0, bArr, i10, iC);
                    for (int i17 = 0; i17 != i12; i17++) {
                        bArr4[i17] = (byte) (bArr4[i17] ^ this.f44681a[i17]);
                    }
                }
                System.arraycopy(bArr4, 0, bArr, i10 + iC, i12);
            } else {
                this.f44684d.d(this.f44681a, 0, bArr2, 0);
                System.arraycopy(bArr2, 0, bArr, i10, iC);
            }
        }
        int i18 = this.f44682b;
        i();
        return i18;
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
            int i13 = this.f36776h;
            System.arraycopy(bArr3, i13, bArr3, 0, i13);
            this.f44682b = this.f36776h;
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
