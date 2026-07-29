package lo;

import gm.j2;
import gm.u1;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nn.q;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.ocsp.OCSPException;
import zn.b0;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f40075a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b0 f40076b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z f40077c = null;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f40078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public z f40079b;

        public a(c cVar, z zVar) {
            this.f40078a = cVar;
            this.f40079b = zVar;
        }

        public nn.i a() throws Exception {
            return new nn.i(this.f40078a.h(), this.f40079b);
        }
    }

    public f a(c cVar) {
        this.f40075a.add(new a(cVar, null));
        return this;
    }

    public f b(c cVar, z zVar) {
        this.f40075a.add(new a(cVar, zVar));
        return this;
    }

    public e c() throws OCSPException {
        return e(null, null);
    }

    public e d(cs.f fVar, X509CertificateHolder[] x509CertificateHolderArr) throws OCSPException, IllegalArgumentException {
        if (fVar != null) {
            return e(fVar, x509CertificateHolderArr);
        }
        throw new IllegalArgumentException("no signer specified");
    }

    public final e e(cs.f fVar, X509CertificateHolder[] x509CertificateHolderArr) throws OCSPException {
        nn.o oVar;
        Iterator it2 = this.f40075a.iterator();
        gm.i iVar = new gm.i();
        while (it2.hasNext()) {
            try {
                iVar.a(((a) it2.next()).a());
            } catch (Exception e10) {
                throw new OCSPException("exception creating Request", e10);
            }
        }
        q qVar = new q(this.f40076b, new j2(iVar), this.f40077c);
        nn.o oVar2 = null;
        if (fVar != null) {
            if (this.f40076b == null) {
                throw new OCSPException("requestorName must be specified if request is signed.");
            }
            try {
                OutputStream outputStreamB = fVar.b();
                outputStreamB.write(qVar.v(gm.j.f29713a));
                outputStreamB.close();
                u1 u1Var = new u1(fVar.getSignature());
                zn.b bVarA = fVar.a();
                if (x509CertificateHolderArr == null || x509CertificateHolderArr.length <= 0) {
                    oVar = new nn.o(bVarA, u1Var);
                } else {
                    gm.i iVar2 = new gm.i();
                    for (int i10 = 0; i10 != x509CertificateHolderArr.length; i10++) {
                        iVar2.a(x509CertificateHolderArr[i10].y());
                    }
                    oVar = new nn.o(bVarA, u1Var, new j2(iVar2));
                }
                oVar2 = oVar;
            } catch (Exception e11) {
                throw new OCSPException("exception processing TBSRequest: " + e11, e11);
            }
        }
        return new e(new nn.f(qVar, oVar2));
    }

    public f f(z zVar) {
        this.f40077c = zVar;
        return this;
    }

    public f g(xn.d dVar) {
        this.f40076b = new b0(4, dVar);
        return this;
    }

    public f h(b0 b0Var) {
        this.f40076b = b0Var;
        return this;
    }
}
