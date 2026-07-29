package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f44681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f44682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f44683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f44684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f44685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f44686f;

    public h() {
    }

    public h(f fVar) {
        this.f44684d = fVar;
        this.f44681a = new byte[fVar.c()];
        boolean z10 = false;
        this.f44682b = 0;
        String strB = fVar.b();
        int iIndexOf = strB.indexOf(47) + 1;
        boolean z11 = iIndexOf > 0 && strB.startsWith("PGP", iIndexOf);
        this.f44686f = z11;
        if (z11 || (fVar instanceof k0)) {
            this.f44685e = true;
            return;
        }
        if (iIndexOf > 0 && strB.startsWith("OpenPGP", iIndexOf)) {
            z10 = true;
        }
        this.f44685e = z10;
    }

    public int a(byte[] bArr, int i10) throws InvalidCipherTextException, IllegalStateException, DataLengthException {
        try {
            int i11 = this.f44682b;
            if (i10 + i11 > bArr.length) {
                throw new OutputLengthException("output buffer too short for doFinal()");
            }
            int i12 = 0;
            if (i11 != 0) {
                if (!this.f44685e) {
                    throw new DataLengthException("data not block size aligned");
                }
                f fVar = this.f44684d;
                byte[] bArr2 = this.f44681a;
                fVar.d(bArr2, 0, bArr2, 0);
                int i13 = this.f44682b;
                this.f44682b = 0;
                System.arraycopy(this.f44681a, 0, bArr, i10, i13);
                i12 = i13;
            }
            return i12;
        } finally {
            i();
        }
    }

    public int b() {
        return this.f44684d.c();
    }

    public int c(int i10) {
        return i10 + this.f44682b;
    }

    public f d() {
        return this.f44684d;
    }

    public int e(int i10) {
        int length;
        int i11 = i10 + this.f44682b;
        if (this.f44686f && this.f44683c) {
            length = (i11 % this.f44681a.length) - (this.f44684d.c() + 2);
            return i11 - length;
        }
        int length2 = this.f44681a.length;
        length = i11 % length2;
        return i11 - length;
    }

    public void f(boolean z10, k kVar) throws IllegalArgumentException {
        this.f44683c = z10;
        i();
        this.f44684d.a(z10, kVar);
    }

    public int g(byte b10, byte[] bArr, int i10) throws IllegalStateException, DataLengthException {
        byte[] bArr2 = this.f44681a;
        int i11 = this.f44682b;
        int i12 = i11 + 1;
        this.f44682b = i12;
        bArr2[i11] = b10;
        if (i12 != bArr2.length) {
            return 0;
        }
        int iD = this.f44684d.d(bArr2, 0, bArr, i10);
        this.f44682b = 0;
        return iD;
    }

    public int h(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws IllegalStateException, DataLengthException {
        int iD;
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
        if (i11 > i14) {
            System.arraycopy(bArr, i10, bArr3, i13, i14);
            iD = this.f44684d.d(this.f44681a, 0, bArr2, i12) + 0;
            this.f44682b = 0;
            i11 -= i14;
            i10 += i14;
            while (i11 > this.f44681a.length) {
                iD += this.f44684d.d(bArr, i10, bArr2, i12 + iD);
                i11 -= iB;
                i10 += iB;
            }
        } else {
            iD = 0;
        }
        System.arraycopy(bArr, i10, this.f44681a, this.f44682b, i11);
        int i15 = this.f44682b + i11;
        this.f44682b = i15;
        byte[] bArr4 = this.f44681a;
        if (i15 != bArr4.length) {
            return iD;
        }
        int iD2 = iD + this.f44684d.d(bArr4, 0, bArr2, i12 + iD);
        this.f44682b = 0;
        return iD2;
    }

    public void i() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f44681a;
            if (i10 >= bArr.length) {
                this.f44682b = 0;
                this.f44684d.reset();
                return;
            } else {
                bArr[i10] = 0;
                i10++;
            }
        }
    }
}
