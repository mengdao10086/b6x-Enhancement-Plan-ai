package sp;

import gm.f0;
import gm.z;
import mm.s0;
import org.bouncycastle.dvcs.DVCSConstructionException;
import so.l0;

/* JADX INFO: loaded from: classes5.dex */
public class j extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public rm.i f50375b;

    public j(mm.n nVar) throws DVCSConstructionException {
        super(nVar);
        if (!rm.e.f48856f.C(nVar.y())) {
            throw new DVCSConstructionException("ContentInfo not a DVCS Response");
        }
        try {
            this.f50375b = nVar.x().b() instanceof f0 ? rm.i.A(nVar.x()) : rm.i.A(z.I(nVar.x()).J());
        } catch (Exception e10) {
            throw new DVCSConstructionException("Unable to parse content: " + e10.getMessage(), e10);
        }
    }

    public j(l0 l0Var) throws DVCSConstructionException {
        this(s0.D(l0Var.q().x()).C());
    }

    @Override // sp.e
    public gm.h a() {
        return this.f50375b;
    }
}
