package cp;

/* JADX INFO: loaded from: classes5.dex */
public class a1 implements org.bouncycastle.crypto.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z0 f25173a;

    @Override // org.bouncycastle.crypto.b
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (this.f25173a == null) {
            this.f25173a = new z0();
        }
        this.f25173a.e(z10, kVar);
    }

    @Override // org.bouncycastle.crypto.b
    public int b() {
        return this.f25173a.c();
    }

    @Override // org.bouncycastle.crypto.b
    public byte[] c(byte[] bArr, int i10, int i11) {
        z0 z0Var = this.f25173a;
        if (z0Var != null) {
            return z0Var.b(z0Var.f(z0Var.a(bArr, i10, i11)));
        }
        throw new IllegalStateException("RSA engine not initialised");
    }

    @Override // org.bouncycastle.crypto.b
    public int d() {
        return this.f25173a.d();
    }
}
