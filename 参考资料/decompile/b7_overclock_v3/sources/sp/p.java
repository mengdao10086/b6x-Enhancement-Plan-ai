package sp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bouncycastle.dvcs.DVCSConstructionException;

/* JADX INFO: loaded from: classes5.dex */
public class p extends h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f50381b;

    public p(rm.k kVar) throws DVCSConstructionException {
        super(kVar);
        rm.n[] nVarArrX = kVar.x();
        if (nVarArrX == null) {
            throw new DVCSConstructionException("DVCSRequest.data.certs should be specified for VPKC service");
        }
        this.f50381b = new ArrayList(nVarArrX.length);
        for (int i10 = 0; i10 != nVarArrX.length; i10++) {
            this.f50381b.add(new n(nVarArrX[i10]));
        }
    }

    public List b() {
        return Collections.unmodifiableList(this.f50381b);
    }
}
