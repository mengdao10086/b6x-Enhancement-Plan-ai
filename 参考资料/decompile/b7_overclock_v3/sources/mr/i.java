package mr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BigInteger f41588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BigInteger f41589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BigInteger f41590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BigInteger f41591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BigInteger f41592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BigInteger f41593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f41594g;

    public i(BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2, BigInteger bigInteger, BigInteger bigInteger2, int i10) {
        a(bigIntegerArr, "v1");
        a(bigIntegerArr2, "v2");
        this.f41588a = bigIntegerArr[0];
        this.f41589b = bigIntegerArr[1];
        this.f41590c = bigIntegerArr2[0];
        this.f41591d = bigIntegerArr2[1];
        this.f41592e = bigInteger;
        this.f41593f = bigInteger2;
        this.f41594g = i10;
    }

    public static void a(BigInteger[] bigIntegerArr, String str) {
        if (bigIntegerArr == null || bigIntegerArr.length != 2 || bigIntegerArr[0] == null || bigIntegerArr[1] == null) {
            throw new IllegalArgumentException("'" + str + "' must consist of exactly 2 (non-null) values");
        }
    }

    public int b() {
        return this.f41594g;
    }

    public BigInteger c() {
        return this.f41592e;
    }

    public BigInteger d() {
        return this.f41593f;
    }

    public BigInteger e() {
        return this.f41588a;
    }

    public BigInteger f() {
        return this.f41589b;
    }

    public BigInteger g() {
        return this.f41590c;
    }

    public BigInteger h() {
        return this.f41591d;
    }
}
