package np;

/* JADX INFO: loaded from: classes5.dex */
public class f1 implements org.bouncycastle.crypto.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f42396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f42397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f42398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f42399d;

    public f1(byte[] bArr, boolean z10, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            throw new IllegalArgumentException("IKM (input keying material) should not be null");
        }
        this.f42396a = org.bouncycastle.util.a.p(bArr);
        this.f42397b = z10;
        if (bArr2 == null || bArr2.length == 0) {
            this.f42398c = null;
        } else {
            this.f42398c = org.bouncycastle.util.a.p(bArr2);
        }
        if (bArr3 == null) {
            this.f42399d = new byte[0];
        } else {
            this.f42399d = org.bouncycastle.util.a.p(bArr3);
        }
    }

    public f1(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this(bArr, false, bArr2, bArr3);
    }

    public static f1 a(byte[] bArr) {
        return new f1(bArr, false, null, null);
    }

    public static f1 f(byte[] bArr, byte[] bArr2) {
        return new f1(bArr, true, null, bArr2);
    }

    public byte[] b() {
        return org.bouncycastle.util.a.p(this.f42396a);
    }

    public byte[] c() {
        return org.bouncycastle.util.a.p(this.f42399d);
    }

    public byte[] d() {
        return org.bouncycastle.util.a.p(this.f42398c);
    }

    public boolean e() {
        return this.f42397b;
    }
}
