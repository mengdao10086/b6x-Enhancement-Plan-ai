package to;

import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorException;
import so.g1;

/* JADX INFO: loaded from: classes5.dex */
public abstract class g implements g1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public np.c f51410c;

    public g(np.c cVar) {
        this.f51410c = cVar;
    }

    public org.bouncycastle.crypto.k g(zn.b bVar, zn.b bVar2, byte[] bArr) throws CMSException {
        try {
            return o.a(new ds.p(bVar, this.f51410c).b(bVar2, bArr));
        } catch (OperatorException e10) {
            throw new CMSException("exception unwrapping key: " + e10.getMessage(), e10);
        }
    }
}
