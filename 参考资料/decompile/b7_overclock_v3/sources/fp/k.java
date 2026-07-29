package fp;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BigInteger f28656d = BigInteger.valueOf(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f28658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f28659c;

    public np.q a() {
        BigInteger[] bigIntegerArrA = l.a(this.f28657a, this.f28658b, this.f28659c);
        BigInteger bigInteger = bigIntegerArrA[0];
        BigInteger bigInteger2 = bigIntegerArrA[1];
        return new np.q(bigInteger, l.b(bigInteger, bigInteger2, this.f28659c), bigInteger2, f28656d, (np.v) null);
    }

    public void b(int i10, int i11, SecureRandom secureRandom) {
        this.f28657a = i10;
        this.f28658b = i11;
        this.f28659c = secureRandom;
    }
}
