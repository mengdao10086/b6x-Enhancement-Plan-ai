package to;

import cs.h0;
import ds.u;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorException;
import so.y0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class e implements y0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h0 f51409c;

    public e(u uVar) {
        this.f51409c = uVar;
    }

    public org.bouncycastle.crypto.k g(zn.b bVar, zn.b bVar2, byte[] bArr) throws CMSException {
        try {
            return o.a(this.f51409c.b(bVar2, bArr));
        } catch (OperatorException e10) {
            throw new CMSException("exception unwrapping key: " + e10.getMessage(), e10);
        }
    }
}
