package zo;

/* JADX INFO: loaded from: classes5.dex */
public class l0 implements org.bouncycastle.crypto.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.v f59344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f59345b;

    public l0(org.bouncycastle.crypto.v vVar, int i10) {
        if (vVar == null) {
            throw new IllegalArgumentException("baseDigest must not be null");
        }
        if (i10 > vVar.h()) {
            throw new IllegalArgumentException("baseDigest output not large enough to support length");
        }
        this.f59344a = vVar;
        this.f59345b = i10;
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return this.f59344a.b() + ee.a.f26978c + (this.f59345b * 8) + ee.a.f26979d;
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        byte[] bArr2 = new byte[this.f59344a.h()];
        this.f59344a.c(bArr2, 0);
        System.arraycopy(bArr2, 0, bArr, i10, this.f59345b);
        return this.f59345b;
    }

    @Override // org.bouncycastle.crypto.v
    public int g() {
        return this.f59344a.g();
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return this.f59345b;
    }

    @Override // org.bouncycastle.crypto.s
    public void reset() {
        this.f59344a.reset();
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte b10) {
        this.f59344a.update(b10);
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte[] bArr, int i10, int i11) {
        this.f59344a.update(bArr, i10, i11);
    }
}
