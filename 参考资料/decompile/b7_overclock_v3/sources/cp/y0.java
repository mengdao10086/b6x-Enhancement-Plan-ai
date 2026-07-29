package cp;

import java.math.BigInteger;
import np.c2;
import np.e2;
import np.w1;

/* JADX INFO: loaded from: classes5.dex */
public class y0 implements org.bouncycastle.crypto.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z0 f25755a = new z0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e2 f25756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f25757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f25758d;

    @Override // org.bouncycastle.crypto.b
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof w1) {
            kVar = ((w1) kVar).a();
        }
        c2 c2Var = (c2) kVar;
        this.f25755a.e(z10, c2Var.b());
        this.f25758d = z10;
        this.f25756b = c2Var.b();
        this.f25757c = c2Var.a();
    }

    @Override // org.bouncycastle.crypto.b
    public int b() {
        return this.f25755a.c();
    }

    @Override // org.bouncycastle.crypto.b
    public byte[] c(byte[] bArr, int i10, int i11) {
        BigInteger bigIntegerA = this.f25755a.a(bArr, i10, i11);
        return this.f25755a.b(this.f25758d ? e(bigIntegerA) : f(bigIntegerA));
    }

    @Override // org.bouncycastle.crypto.b
    public int d() {
        return this.f25755a.d();
    }

    public final BigInteger e(BigInteger bigInteger) {
        return bigInteger.multiply(this.f25757c.modPow(this.f25756b.d(), this.f25756b.e())).mod(this.f25756b.e());
    }

    public final BigInteger f(BigInteger bigInteger) {
        BigInteger bigIntegerE = this.f25756b.e();
        return bigInteger.multiply(org.bouncycastle.util.b.n(bigIntegerE, this.f25757c)).mod(bigIntegerE);
    }
}
