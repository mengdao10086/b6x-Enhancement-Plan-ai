package np;

/* JADX INFO: loaded from: classes5.dex */
public final class l1 implements org.bouncycastle.crypto.r {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f42472f = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f42473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f42474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f42475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f42476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f42477e;

    public l1(byte[] bArr, byte[] bArr2, byte[] bArr3, int i10, boolean z10) {
        if (bArr == null) {
            throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
        }
        this.f42473a = org.bouncycastle.util.a.p(bArr);
        if (bArr3 == null) {
            this.f42477e = new byte[0];
        } else {
            this.f42477e = org.bouncycastle.util.a.p(bArr3);
        }
        this.f42476d = i10;
        if (bArr2 == null) {
            this.f42474b = new byte[0];
        } else {
            this.f42474b = org.bouncycastle.util.a.p(bArr2);
        }
        this.f42475c = z10;
    }

    public static l1 a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i10) {
        if (i10 == 8 || i10 == 16 || i10 == 24 || i10 == 32) {
            return new l1(bArr, bArr2, bArr3, i10, true);
        }
        throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
    }

    public static l1 b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new l1(bArr, bArr2, bArr3, -1, false);
    }

    public byte[] c() {
        return org.bouncycastle.util.a.p(this.f42477e);
    }

    public byte[] d() {
        return this.f42474b;
    }

    public byte[] e() {
        return this.f42473a;
    }

    public int f() {
        return this.f42476d;
    }

    public boolean g() {
        return this.f42475c;
    }
}
