package cr;

import java.security.spec.ECParameterSpec;
import np.g0;

/* JADX INFO: loaded from: classes5.dex */
public class g extends ECParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f25813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g0 f25814b;

    public g(g0 g0Var) {
        this(g0Var, org.bouncycastle.jcajce.provider.asymmetric.util.h.k(g0Var), vn.d.y());
    }

    public g(g0 g0Var, ECParameterSpec eCParameterSpec, byte[] bArr) {
        super(eCParameterSpec.getCurve(), eCParameterSpec.getGenerator(), eCParameterSpec.getOrder(), eCParameterSpec.getCofactor());
        this.f25814b = g0Var;
        this.f25813a = org.bouncycastle.util.a.p(bArr);
    }

    public byte[] a() {
        return org.bouncycastle.util.a.p(this.f25813a);
    }

    public boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f25814b.equals(((g) obj).f25814b);
        }
        return false;
    }

    public int hashCode() {
        return this.f25814b.hashCode();
    }
}
