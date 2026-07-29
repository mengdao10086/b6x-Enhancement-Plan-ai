package zo;

/* JADX INFO: loaded from: classes5.dex */
public class v implements org.bouncycastle.crypto.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.v f59526a;

    public v(org.bouncycastle.crypto.v vVar) {
        if (vVar == null) {
            throw new IllegalArgumentException("baseDigest must not be null");
        }
        this.f59526a = vVar;
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return this.f59526a.b();
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        return this.f59526a.c(bArr, i10);
    }

    @Override // org.bouncycastle.crypto.v
    public int g() {
        return this.f59526a.g();
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return this.f59526a.h();
    }

    @Override // org.bouncycastle.crypto.s
    public void reset() {
        this.f59526a.reset();
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte b10) {
        this.f59526a.update(b10);
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte[] bArr, int i10, int i11) {
        this.f59526a.update(bArr, i10, i11);
    }
}
