package et;

import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes6.dex */
public class k implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f27170b = "SHA512-256";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f27171c = "SHA3-256";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f27172a;

    public k() {
        this(f27170b);
    }

    public k(String str) {
        this.f27172a = str;
    }

    public String a() {
        return this.f27172a;
    }
}
