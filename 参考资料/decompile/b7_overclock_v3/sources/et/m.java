package et;

import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes6.dex */
public class m implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f27199c = "SHA256";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f27200d = "SHA512";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f27201e = "SHAKE128";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f27202f = "SHAKE256";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final m f27203g = new m(10, "SHA256");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final m f27204h = new m(16, "SHA256");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final m f27205i = new m(20, "SHA256");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final m f27206j = new m(10, "SHAKE128");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final m f27207k = new m(16, "SHAKE128");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final m f27208l = new m(20, "SHAKE128");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final m f27209m = new m(10, "SHA512");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final m f27210n = new m(16, "SHA512");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final m f27211o = new m(20, "SHA512");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final m f27212p = new m(10, "SHAKE256");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final m f27213q = new m(16, "SHAKE256");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final m f27214r = new m(20, "SHAKE256");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f27215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f27216b;

    public m(int i10, String str) {
        this.f27215a = i10;
        this.f27216b = str;
    }

    public int a() {
        return this.f27215a;
    }

    public String b() {
        return this.f27216b;
    }
}
