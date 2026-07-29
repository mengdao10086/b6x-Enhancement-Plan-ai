package sp;

import org.bouncycastle.dvcs.DVCSConstructionException;

/* JADX INFO: loaded from: classes5.dex */
public class b extends h {
    public b(rm.k kVar) throws DVCSConstructionException {
        super(kVar);
        c();
    }

    public k b() {
        return new k(this.f50373a.B());
    }

    public final void c() throws DVCSConstructionException {
        if (this.f50373a.B() == null) {
            throw new DVCSConstructionException("DVCSRequest.data.messageImprint should be specified for CCPD service");
        }
    }
}
