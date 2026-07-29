package sp;

import org.bouncycastle.dvcs.DVCSConstructionException;

/* JADX INFO: loaded from: classes5.dex */
public class d extends h {
    public d(rm.k kVar) throws DVCSConstructionException {
        super(kVar);
        c();
    }

    public byte[] b() {
        return this.f50373a.A().J();
    }

    public final void c() throws DVCSConstructionException {
        if (this.f50373a.A() == null) {
            throw new DVCSConstructionException("DVCSRequest.data.message should be specified for CPD service");
        }
    }
}
