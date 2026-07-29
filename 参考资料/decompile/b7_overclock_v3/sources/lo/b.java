package lo;

import gm.d2;
import gm.j2;
import gm.u1;
import gm.z1;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import nn.p;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.ocsp.OCSPException;
import zn.c1;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f40060a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f40061b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f40062c;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f40063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public nn.c f40064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public gm.o f40065c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public gm.o f40066d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public z f40067e;

        public a(c cVar, d dVar, Date date, Date date2, z zVar) {
            nn.c cVar2;
            this.f40063a = cVar;
            if (dVar == null) {
                cVar2 = new nn.c();
            } else if (dVar instanceof o) {
                cVar2 = new nn.c(2, d2.f29657b);
            } else {
                m mVar = (m) dVar;
                cVar2 = mVar.c() ? new nn.c(new nn.m(new gm.o(mVar.b()), zn.m.z(mVar.a()))) : new nn.c(new nn.m(new gm.o(mVar.b()), null));
            }
            this.f40064b = cVar2;
            this.f40065c = new z1(date);
            this.f40066d = date2 != null ? new z1(date2) : null;
            this.f40067e = zVar;
        }

        public p a() throws Exception {
            return new p(this.f40063a.h(), this.f40064b, this.f40065c, this.f40066d, this.f40067e);
        }
    }

    public b(l lVar) {
        this.f40062c = lVar;
    }

    public b(c1 c1Var, cs.o oVar) throws OCSPException {
        this.f40062c = new l(c1Var, oVar);
    }

    public b a(c cVar, d dVar) {
        c(cVar, dVar, new Date(), null, null);
        return this;
    }

    public b b(c cVar, d dVar, Date date, Date date2) {
        c(cVar, dVar, date, date2, null);
        return this;
    }

    public b c(c cVar, d dVar, Date date, Date date2, z zVar) {
        this.f40060a.add(new a(cVar, dVar, date, date2, zVar));
        return this;
    }

    public b d(c cVar, d dVar, Date date, z zVar) {
        c(cVar, dVar, new Date(), date, zVar);
        return this;
    }

    public b e(c cVar, d dVar, z zVar) {
        c(cVar, dVar, new Date(), null, zVar);
        return this;
    }

    public lo.a f(cs.f fVar, X509CertificateHolder[] x509CertificateHolderArr, Date date) throws OCSPException {
        Iterator it2 = this.f40060a.iterator();
        gm.i iVar = new gm.i();
        while (it2.hasNext()) {
            try {
                iVar.a(((a) it2.next()).a());
            } catch (Exception e10) {
                throw new OCSPException("exception creating Request", e10);
            }
        }
        nn.l lVar = new nn.l(this.f40062c.a(), new gm.o(date), new j2(iVar), this.f40061b);
        try {
            OutputStream outputStreamB = fVar.b();
            outputStreamB.write(lVar.v(gm.j.f29713a));
            outputStreamB.close();
            u1 u1Var = new u1(fVar.getSignature());
            zn.b bVarA = fVar.a();
            j2 j2Var = null;
            if (x509CertificateHolderArr != null && x509CertificateHolderArr.length > 0) {
                gm.i iVar2 = new gm.i();
                for (int i10 = 0; i10 != x509CertificateHolderArr.length; i10++) {
                    iVar2.a(x509CertificateHolderArr[i10].y());
                }
                j2Var = new j2(iVar2);
            }
            return new lo.a(new nn.a(lVar, bVarA, u1Var, j2Var));
        } catch (Exception e11) {
            throw new OCSPException("exception processing TBSRequest: " + e11.getMessage(), e11);
        }
    }

    public b g(z zVar) {
        this.f40061b = zVar;
        return this;
    }
}
