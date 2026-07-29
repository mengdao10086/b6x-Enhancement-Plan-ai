package et;

import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes6.dex */
public class l implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f27173d = "SHA256";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f27174e = "SHA512";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f27175f = "SHAKE128";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f27176g = "SHAKE256";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f27196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f27197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f27198c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final l f27177h = new l(20, 2, "SHA256");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final l f27178i = new l(20, 4, "SHA256");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final l f27179j = new l(40, 2, "SHA256");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final l f27180k = new l(40, 4, "SHA256");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final l f27181l = new l(40, 8, "SHA256");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final l f27182m = new l(60, 3, "SHA256");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final l f27183n = new l(60, 6, "SHA256");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final l f27184o = new l(60, 12, "SHA256");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final l f27185p = new l(20, 2, "SHA512");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final l f27186q = new l(20, 4, "SHA512");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final l f27187r = new l(40, 2, "SHA512");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final l f27188s = new l(40, 4, "SHA512");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final l f27189t = new l(40, 8, "SHA512");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final l f27190u = new l(60, 3, "SHA512");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final l f27191v = new l(60, 6, "SHA512");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final l f27192w = new l(60, 12, "SHA512");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final l f27193x = new l(20, 2, "SHAKE128");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final l f27194y = new l(20, 4, "SHAKE128");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final l f27195z = new l(40, 2, "SHAKE128");
    public static final l A = new l(40, 4, "SHAKE128");
    public static final l B = new l(40, 8, "SHAKE128");
    public static final l C = new l(60, 3, "SHAKE128");
    public static final l D = new l(60, 6, "SHAKE128");
    public static final l E = new l(60, 12, "SHAKE128");
    public static final l F = new l(20, 2, "SHAKE256");
    public static final l G = new l(20, 4, "SHAKE256");
    public static final l H = new l(40, 2, "SHAKE256");
    public static final l I = new l(40, 4, "SHAKE256");
    public static final l J = new l(40, 8, "SHAKE256");
    public static final l K = new l(60, 3, "SHAKE256");
    public static final l L = new l(60, 6, "SHAKE256");
    public static final l M = new l(60, 12, "SHAKE256");

    public l(int i10, int i11, String str) {
        this.f27196a = i10;
        this.f27197b = i11;
        this.f27198c = str;
    }

    public int a() {
        return this.f27196a;
    }

    public int b() {
        return this.f27197b;
    }

    public String c() {
        return this.f27198c;
    }
}
