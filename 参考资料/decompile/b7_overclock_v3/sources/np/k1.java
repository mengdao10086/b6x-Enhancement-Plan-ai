package np;

/* JADX INFO: loaded from: classes5.dex */
public final class k1 implements org.bouncycastle.crypto.r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f42463e = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f42464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f42465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f42466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f42467d;

    public k1(byte[] bArr, byte[] bArr2, int i10, boolean z10) {
        if (bArr == null) {
            throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
        }
        this.f42464a = org.bouncycastle.util.a.p(bArr);
        if (bArr2 == null) {
            this.f42467d = new byte[0];
        } else {
            this.f42467d = org.bouncycastle.util.a.p(bArr2);
        }
        if (i10 != 8 && i10 != 16 && i10 != 24 && i10 != 32) {
            throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
        }
        this.f42466c = i10;
        this.f42465b = z10;
    }

    public static k1 a(byte[] bArr, byte[] bArr2, int i10) {
        return new k1(bArr, bArr2, i10, true);
    }

    public static k1 b(byte[] bArr, byte[] bArr2) {
        return new k1(bArr, bArr2, 32, false);
    }

    public byte[] c() {
        return org.bouncycastle.util.a.p(this.f42467d);
    }

    public byte[] d() {
        return this.f42464a;
    }

    public int e() {
        return this.f42466c;
    }

    public boolean f() {
        return this.f42465b;
    }
}
