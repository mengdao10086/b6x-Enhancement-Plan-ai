package go;

import gm.u1;
import om.s;
import om.t;
import org.bouncycastle.cert.crmf.CRMFException;
import zn.b0;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public om.f f29889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c1 f29890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b0 f29891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public om.q f29892d;

    public o(om.f fVar) {
        this.f29889a = fVar;
    }

    public o(c1 c1Var) {
        this.f29890b = c1Var;
    }

    public s a(cs.f fVar) {
        t tVar;
        b0 b0Var = this.f29891c;
        if (b0Var != null && this.f29892d != null) {
            throw new IllegalStateException("name and publicKeyMAC cannot both be set.");
        }
        om.f fVar2 = this.f29889a;
        if (fVar2 != null) {
            tVar = null;
            b.b(fVar2, fVar.b());
        } else if (b0Var != null) {
            t tVar2 = new t(b0Var, this.f29890b);
            b.b(tVar2, fVar.b());
            tVar = tVar2;
        } else {
            tVar = new t(this.f29892d, this.f29890b);
            b.b(tVar, fVar.b());
        }
        return new s(tVar, fVar.a(), new u1(fVar.getSignature()));
    }

    public o b(l lVar, char[] cArr) throws CRMFException {
        this.f29892d = lVar.a(cArr, this.f29890b);
        return this;
    }

    public o c(b0 b0Var) {
        this.f29891c = b0Var;
        return this;
    }
}
