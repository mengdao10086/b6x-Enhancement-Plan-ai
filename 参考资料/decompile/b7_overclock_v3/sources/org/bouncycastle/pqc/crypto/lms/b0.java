package org.bouncycastle.pqc.crypto.lms;

/* JADX INFO: loaded from: classes6.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f45731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f45732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final org.bouncycastle.crypto.s f45733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f45734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f45735e;

    public b0(byte[] bArr, byte[] bArr2, org.bouncycastle.crypto.s sVar) {
        this.f45731a = bArr;
        this.f45732b = bArr2;
        this.f45733c = sVar;
    }

    public void a(byte[] bArr, boolean z10) {
        b(bArr, z10, 0);
    }

    public void b(byte[] bArr, boolean z10, int i10) {
        c(bArr, i10);
        if (z10) {
            this.f45735e++;
        }
    }

    public byte[] c(byte[] bArr, int i10) {
        if (bArr.length < this.f45733c.h()) {
            throw new IllegalArgumentException("target length is less than digest size.");
        }
        org.bouncycastle.crypto.s sVar = this.f45733c;
        byte[] bArr2 = this.f45731a;
        sVar.update(bArr2, 0, bArr2.length);
        this.f45733c.update((byte) (this.f45734d >>> 24));
        this.f45733c.update((byte) (this.f45734d >>> 16));
        this.f45733c.update((byte) (this.f45734d >>> 8));
        this.f45733c.update((byte) this.f45734d);
        this.f45733c.update((byte) (this.f45735e >>> 8));
        this.f45733c.update((byte) this.f45735e);
        this.f45733c.update((byte) -1);
        org.bouncycastle.crypto.s sVar2 = this.f45733c;
        byte[] bArr3 = this.f45732b;
        sVar2.update(bArr3, 0, bArr3.length);
        this.f45733c.c(bArr, i10);
        return bArr;
    }

    public byte[] d() {
        return this.f45731a;
    }

    public int e() {
        return this.f45735e;
    }

    public byte[] f() {
        return this.f45732b;
    }

    public int g() {
        return this.f45734d;
    }

    public void h(int i10) {
        this.f45735e = i10;
    }

    public void i(int i10) {
        this.f45734d = i10;
    }
}
