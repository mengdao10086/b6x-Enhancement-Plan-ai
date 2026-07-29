package np;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class r1 extends org.bouncycastle.crypto.y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f42524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f42525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f42526e;

    public r1(SecureRandom secureRandom, int i10, int i11, int i12) {
        this(secureRandom, i10, i11, i12, false);
    }

    public r1(SecureRandom secureRandom, int i10, int i11, int i12, boolean z10) {
        super(secureRandom, i10);
        this.f42526e = false;
        this.f42524c = i11;
        if (i12 % 2 == 1) {
            throw new IllegalArgumentException("cntSmallPrimes must be a multiple of 2");
        }
        if (i12 < 30) {
            throw new IllegalArgumentException("cntSmallPrimes must be >= 30 for security reasons");
        }
        this.f42525d = i12;
        this.f42526e = z10;
    }

    public int c() {
        return this.f42524c;
    }

    public int d() {
        return this.f42525d;
    }

    public boolean e() {
        return this.f42526e;
    }
}
