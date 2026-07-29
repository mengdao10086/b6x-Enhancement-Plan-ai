package cr;

import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class c extends DHParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BigInteger f25803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BigInteger f25804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f25805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public np.v f25806d;

    public c(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, null, 0);
    }

    public c(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i10) {
        this(bigInteger, bigInteger2, bigInteger3, null, i10);
    }

    public c(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i10) {
        this(bigInteger, bigInteger2, bigInteger3, bigInteger4, 0, i10);
    }

    public c(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i10, int i11) {
        super(bigInteger, bigInteger3, i11);
        this.f25803a = bigInteger2;
        this.f25804b = bigInteger4;
        this.f25805c = i10;
    }

    public c(np.q qVar) {
        this(qVar.f(), qVar.g(), qVar.b(), qVar.c(), qVar.e(), qVar.d());
        this.f25806d = qVar.h();
    }

    public np.q a() {
        return new np.q(getP(), getG(), this.f25803a, this.f25805c, getL(), this.f25804b, this.f25806d);
    }

    public BigInteger b() {
        return this.f25804b;
    }

    public int c() {
        return this.f25805c;
    }

    public BigInteger d() {
        return this.f25803a;
    }
}
