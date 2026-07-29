package fp;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.v0;

/* JADX INFO: loaded from: classes5.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f28691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f28692c;

    public v0 a() {
        BigInteger[] bigIntegerArrA = l.a(this.f28690a, this.f28691b, this.f28692c);
        BigInteger bigInteger = bigIntegerArrA[0];
        return new v0(bigInteger, l.b(bigInteger, bigIntegerArrA[1], this.f28692c));
    }

    public void b(int i10, int i11, SecureRandom secureRandom) {
        this.f28690a = i10;
        this.f28691b = i11;
        this.f28692c = secureRandom;
    }
}
