package et;

import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes6.dex */
public class a implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c[] f27131a;

    public a(c... cVarArr) {
        if (cVarArr.length == 0) {
            throw new IllegalArgumentException("at least one LMSKeyGenParameterSpec required");
        }
        this.f27131a = (c[]) cVarArr.clone();
    }

    public c[] a() {
        return (c[]) this.f27131a.clone();
    }
}
