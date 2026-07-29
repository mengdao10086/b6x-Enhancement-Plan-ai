package np;

/* JADX INFO: loaded from: classes5.dex */
public final class j1 implements org.bouncycastle.crypto.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f42445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f42446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f42447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f42448d;

    public j1(byte[] bArr, byte[] bArr2, int i10) {
        this(bArr, null, bArr2, i10);
    }

    public j1(byte[] bArr, byte[] bArr2, byte[] bArr3, int i10) {
        if (bArr == null) {
            throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
        }
        this.f42445a = org.bouncycastle.util.a.p(bArr);
        if (bArr2 == null) {
            this.f42446b = new byte[0];
        } else {
            this.f42446b = org.bouncycastle.util.a.p(bArr2);
        }
        if (bArr3 == null) {
            this.f42447c = new byte[0];
        } else {
            this.f42447c = org.bouncycastle.util.a.p(bArr3);
        }
        if (i10 != 8 && i10 != 16 && i10 != 24 && i10 != 32) {
            throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
        }
        this.f42448d = i10;
    }

    public byte[] a() {
        return org.bouncycastle.util.a.p(this.f42447c);
    }

    public byte[] b() {
        return org.bouncycastle.util.a.p(this.f42446b);
    }

    public byte[] c() {
        return org.bouncycastle.util.a.p(this.f42447c);
    }

    public byte[] d() {
        return this.f42445a;
    }

    public int e() {
        return this.f42448d;
    }
}
