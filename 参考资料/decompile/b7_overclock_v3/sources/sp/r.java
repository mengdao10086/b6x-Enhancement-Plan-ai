package sp;

import org.bouncycastle.cms.CMSException;
import org.bouncycastle.dvcs.DVCSConstructionException;
import so.l0;

/* JADX INFO: loaded from: classes5.dex */
public class r extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l0 f50382b;

    public r(rm.k kVar) throws DVCSConstructionException {
        super(kVar);
        d();
    }

    public byte[] b() {
        return this.f50373a.A().J();
    }

    public l0 c() {
        return this.f50382b;
    }

    public final void d() throws DVCSConstructionException {
        if (this.f50382b == null) {
            if (this.f50373a.A() == null) {
                throw new DVCSConstructionException("DVCSRequest.data.message should be specified for VSD service");
            }
            try {
                this.f50382b = new l0(this.f50373a.A().J());
            } catch (CMSException e10) {
                throw new DVCSConstructionException("Can't read CMS SignedData from input", e10);
            }
        }
    }
}
