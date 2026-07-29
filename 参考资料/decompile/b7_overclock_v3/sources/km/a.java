package km;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class a extends gm.w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f37422b = 4294967295L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f37423a;

    public a(long j10) {
        if (j10 < 0 || j10 > 4294967295L) {
            throw new IllegalArgumentException("id out of range");
        }
        this.f37423a = j10;
    }

    public a(gm.t tVar) {
        this(x(tVar.K()));
    }

    public static long x(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 32) {
            return bigInteger.longValue();
        }
        throw new IllegalArgumentException("id out of range");
    }

    public static a z(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(gm.t.I(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new gm.t(this.f37423a);
    }

    public long y() {
        return this.f37423a;
    }
}
