package cr;

import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class h implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f25815b = "Ed25519";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f25816c = "Ed448";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25817a;

    public h(String str) {
        if (!str.equalsIgnoreCase(f25815b)) {
            if (!str.equalsIgnoreCase(f25816c)) {
                if (!str.equals(tm.a.f51340d.L())) {
                    if (!str.equals(tm.a.f51341e.L())) {
                        throw new IllegalArgumentException("unrecognized curve name: " + str);
                    }
                }
            }
            this.f25817a = f25816c;
            return;
        }
        this.f25817a = f25815b;
    }

    public String a() {
        return this.f25817a;
    }
}
