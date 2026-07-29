package to;

import cs.q;
import np.n1;

/* JADX INFO: loaded from: classes5.dex */
public class o {
    public static org.bouncycastle.crypto.k a(q qVar) {
        if (qVar.b() instanceof org.bouncycastle.crypto.k) {
            return (org.bouncycastle.crypto.k) qVar.b();
        }
        if (qVar.b() instanceof byte[]) {
            return new n1((byte[]) qVar.b());
        }
        throw new IllegalArgumentException("unknown generic key type");
    }
}
