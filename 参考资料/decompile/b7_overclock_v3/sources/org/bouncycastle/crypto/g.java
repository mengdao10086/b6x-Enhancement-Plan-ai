package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f44678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f44679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f44680c;

    public g(b bVar) {
        this.f44680c = bVar;
    }

    public byte[] a() throws InvalidCipherTextException {
        byte[] bArrC = this.f44680c.c(this.f44678a, 0, this.f44679b);
        i();
        return bArrC;
    }

    public int b() {
        return this.f44679b;
    }

    public int c() {
        return this.f44680c.b();
    }

    public int d() {
        return this.f44680c.d();
    }

    public b e() {
        return this.f44680c;
    }

    public void f(boolean z10, k kVar) {
        i();
        this.f44680c.a(z10, kVar);
        this.f44678a = new byte[this.f44680c.b() + (z10 ? 1 : 0)];
        this.f44679b = 0;
    }

    public void g(byte b10) {
        int i10 = this.f44679b;
        byte[] bArr = this.f44678a;
        if (i10 >= bArr.length) {
            throw new DataLengthException("attempt to process message too long for cipher");
        }
        this.f44679b = i10 + 1;
        bArr[i10] = b10;
    }

    public void h(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return;
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int i12 = this.f44679b;
        int i13 = i12 + i11;
        byte[] bArr2 = this.f44678a;
        if (i13 > bArr2.length) {
            throw new DataLengthException("attempt to process message too long for cipher");
        }
        System.arraycopy(bArr, i10, bArr2, i12, i11);
        this.f44679b += i11;
    }

    public void i() {
        if (this.f44678a != null) {
            int i10 = 0;
            while (true) {
                byte[] bArr = this.f44678a;
                if (i10 >= bArr.length) {
                    break;
                }
                bArr[i10] = 0;
                i10++;
            }
        }
        this.f44679b = 0;
    }
}
