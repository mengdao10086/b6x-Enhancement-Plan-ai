package et;

import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes6.dex */
public class b implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d[] f27132a;

    public b(d[] dVarArr) {
        this.f27132a = (d[]) dVarArr.clone();
    }

    public d[] a() {
        return (d[]) this.f27132a.clone();
    }
}
