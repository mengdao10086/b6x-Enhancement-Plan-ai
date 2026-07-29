package sp;

import gm.f0;
import gm.z;
import mm.s0;
import org.bouncycastle.dvcs.DVCSConstructionException;
import so.l0;
import zn.b0;

/* JADX INFO: loaded from: classes5.dex */
public class f extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public rm.f f50367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f50368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f50369d;

    public f(mm.n nVar) throws DVCSConstructionException {
        h bVar;
        super(nVar);
        if (!rm.e.f48855e.C(nVar.y())) {
            throw new DVCSConstructionException("ContentInfo not a DVCS Request");
        }
        try {
            this.f50367b = nVar.x().b() instanceof f0 ? rm.f.z(nVar.x()) : rm.f.z(z.I(nVar.x()).J());
            i iVar = new i(this.f50367b.A());
            this.f50368c = iVar;
            int iH = iVar.h();
            if (iH == rm.m.f48903b.z().intValue()) {
                bVar = new d(this.f50367b.x());
            } else if (iH == rm.m.f48904c.z().intValue()) {
                bVar = new r(this.f50367b.x());
            } else if (iH == rm.m.f48905d.z().intValue()) {
                bVar = new p(this.f50367b.x());
            } else {
                if (iH != rm.m.f48906e.z().intValue()) {
                    throw new DVCSConstructionException("Unknown service type: " + iH);
                }
                bVar = new b(this.f50367b.x());
            }
            this.f50369d = bVar;
        } catch (Exception e10) {
            throw new DVCSConstructionException("Unable to parse content: " + e10.getMessage(), e10);
        }
    }

    public f(l0 l0Var) throws DVCSConstructionException {
        this(s0.D(l0Var.q().x()).C());
    }

    @Override // sp.e
    public gm.h a() {
        return this.f50367b;
    }

    public h c() {
        return this.f50369d;
    }

    public i d() {
        return this.f50368c;
    }

    public b0 e() {
        return this.f50367b.B();
    }
}
