package xo;

import java.math.BigInteger;
import np.i2;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f55713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f55714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f55715c;

    public BigInteger a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return this.f55714b.modPow(d.f(this.f55715c, this.f55713a, bArr, bArr2, bArr3), this.f55713a);
    }

    public void b(BigInteger bigInteger, BigInteger bigInteger2, s sVar) {
        this.f55713a = bigInteger;
        this.f55714b = bigInteger2;
        this.f55715c = sVar;
    }

    public void c(i2 i2Var, s sVar) {
        this.f55713a = i2Var.b();
        this.f55714b = i2Var.a();
        this.f55715c = sVar;
    }
}
