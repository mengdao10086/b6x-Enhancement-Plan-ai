package cr;

import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class x implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f25873b = "X25519";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f25874c = "X448";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25875a;

    public x(String str) {
        if (!str.equalsIgnoreCase(f25873b)) {
            if (!str.equalsIgnoreCase(f25874c)) {
                if (!str.equals(tm.a.f51338b.L())) {
                    if (!str.equals(tm.a.f51339c.L())) {
                        throw new IllegalArgumentException("unrecognized curve name: " + str);
                    }
                }
            }
            this.f25875a = f25874c;
            return;
        }
        this.f25875a = f25873b;
    }

    public String a() {
        return this.f25875a;
    }
}
