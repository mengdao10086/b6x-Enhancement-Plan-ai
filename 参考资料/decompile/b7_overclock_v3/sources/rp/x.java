package rp;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class x implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BigInteger f49106c = BigInteger.valueOf(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f49107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f49108b;

    @Override // rp.c
    public BigInteger a() {
        int iBitLength = this.f49107a.bitLength();
        while (true) {
            BigInteger bigIntegerF = org.bouncycastle.util.b.f(iBitLength, this.f49108b);
            if (!bigIntegerF.equals(f49106c) && bigIntegerF.compareTo(this.f49107a) < 0) {
                return bigIntegerF;
            }
        }
    }

    @Override // rp.c
    public boolean b() {
        return false;
    }

    @Override // rp.c
    public void c(BigInteger bigInteger, SecureRandom secureRandom) {
        this.f49107a = bigInteger;
        this.f49108b = secureRandom;
    }

    @Override // rp.c
    public void d(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        throw new IllegalStateException("Operation not supported");
    }
}
