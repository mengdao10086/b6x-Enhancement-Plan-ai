package et;

import ft.z;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes6.dex */
public class e implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f27137f = "SHA-1";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f27138g = "SHA-224";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f27139h = "SHA-256";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f27140i = "SHA-384";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f27141j = "SHA-512";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f27142k = 11;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f27143l = 50;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f27144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f27145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f27146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f27147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f27148e;

    public e() {
        this(11, 50, "SHA-256");
    }

    public e(int i10) {
        this(i10, "SHA-256");
    }

    public e(int i10, int i11) {
        this(i10, i11, "SHA-256");
    }

    public e(int i10, int i11, int i12) {
        this(i10, i11, i12, "SHA-256");
    }

    public e(int i10, int i11, int i12, String str) {
        this.f27144a = i10;
        if (i10 < 1) {
            throw new IllegalArgumentException("m must be positive");
        }
        if (i10 > 32) {
            throw new IllegalArgumentException(" m is too large");
        }
        int i13 = 1 << i10;
        this.f27146c = i13;
        this.f27145b = i11;
        if (i11 < 0) {
            throw new IllegalArgumentException("t must be positive");
        }
        if (i11 > i13) {
            throw new IllegalArgumentException("t must be less than n = 2^m");
        }
        if (z.b(i12) != i10 || !z.f(i12)) {
            throw new IllegalArgumentException("polynomial is not a field polynomial for GF(2^m)");
        }
        this.f27147d = i12;
        this.f27148e = str;
    }

    public e(int i10, int i11, String str) {
        if (i10 < 1) {
            throw new IllegalArgumentException("m must be positive");
        }
        if (i10 > 32) {
            throw new IllegalArgumentException("m is too large");
        }
        this.f27144a = i10;
        int i12 = 1 << i10;
        this.f27146c = i12;
        if (i11 < 0) {
            throw new IllegalArgumentException("t must be positive");
        }
        if (i11 > i12) {
            throw new IllegalArgumentException("t must be less than n = 2^m");
        }
        this.f27145b = i11;
        this.f27147d = z.e(i10);
        this.f27148e = str;
    }

    public e(int i10, String str) {
        int i11 = 1;
        if (i10 < 1) {
            throw new IllegalArgumentException("key size must be positive");
        }
        int i12 = 0;
        while (i11 < i10) {
            i11 <<= 1;
            i12++;
        }
        this.f27145b = (i11 >>> 1) / i12;
        this.f27144a = i12;
        this.f27146c = i11;
        this.f27147d = z.e(i12);
        this.f27148e = str;
    }

    public String a() {
        return this.f27148e;
    }

    public int b() {
        return this.f27147d;
    }

    public int c() {
        return this.f27144a;
    }

    public int d() {
        return this.f27146c;
    }

    public int e() {
        return this.f27145b;
    }
}
