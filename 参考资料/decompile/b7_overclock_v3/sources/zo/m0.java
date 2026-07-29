package zo;

import np.j2;

/* JADX INFO: loaded from: classes5.dex */
public class m0 implements org.bouncycastle.crypto.v, org.bouncycastle.util.m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f59349b = 256;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f59350c = 512;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f59351d = 1024;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n0 f59352a;

    public m0(int i10, int i11) {
        this.f59352a = new n0(i10, i11);
        a(null);
    }

    public m0(m0 m0Var) {
        this.f59352a = new n0(m0Var.f59352a);
    }

    public void a(j2 j2Var) {
        this.f59352a.k(j2Var);
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return "Skein-" + (this.f59352a.g() * 8) + "-" + (this.f59352a.h() * 8);
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        return this.f59352a.f(bArr, i10);
    }

    @Override // org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new m0(this);
    }

    @Override // org.bouncycastle.crypto.v
    public int g() {
        return this.f59352a.g();
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return this.f59352a.h();
    }

    @Override // org.bouncycastle.util.m
    public void i(org.bouncycastle.util.m mVar) {
        this.f59352a.i(((m0) mVar).f59352a);
    }

    @Override // org.bouncycastle.crypto.s
    public void reset() {
        this.f59352a.o();
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte b10) {
        this.f59352a.t(b10);
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte[] bArr, int i10, int i11) {
        this.f59352a.u(bArr, i10, i11);
    }
}
