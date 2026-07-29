package gt;

import cs.o;
import gm.c0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import mm.n;
import mm.y;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.tsp.TSPException;
import org.bouncycastle.tsp.TSPValidationException;
import pn.s;
import so.a2;
import so.d2;
import so.f2;
import so.l0;
import so.r0;
import zn.b0;
import zn.h0;

/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l0 f30053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d2 f30054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f30055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f30056d;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public vm.c f30057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public vm.d f30058b;

        public a(vm.c cVar) {
            this.f30057a = cVar;
            this.f30058b = null;
        }

        public a(vm.d dVar) {
            this.f30058b = dVar;
            this.f30057a = null;
        }

        public byte[] a() {
            vm.c cVar = this.f30057a;
            return cVar != null ? cVar.x() : this.f30058b.x();
        }

        public zn.b b() {
            return this.f30057a != null ? new zn.b(on.b.f44365i) : this.f30058b.y();
        }

        public h0 c() {
            vm.c cVar = this.f30057a;
            return cVar != null ? cVar.z() : this.f30058b.A();
        }
    }

    public h(n nVar) throws TSPException, IOException {
        this(h(nVar));
    }

    public h(l0 l0Var) throws TSPException, IOException {
        a aVar;
        this.f30053a = l0Var;
        if (!l0Var.i().equals(s.X4.L())) {
            throw new TSPValidationException("ContentInfo object not for a time stamp.");
        }
        Collection<d2> collectionB = this.f30053a.k().b();
        if (collectionB.size() != 1) {
            throw new IllegalArgumentException("Time-stamp token signed by " + collectionB.size() + " signers, but it must contain just the TSA signature.");
        }
        this.f30054b = collectionB.iterator().next();
        try {
            r0 r0VarH = this.f30053a.h();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            r0VarH.d(byteArrayOutputStream);
            this.f30055c = new j(un.j.A(c0.D(byteArrayOutputStream.toByteArray())));
            mm.a aVarD = this.f30054b.o().d(s.f46853w5);
            if (aVarD != null) {
                aVar = new a(vm.c.y(vm.g.y(aVarD.y().J(0)).x()[0]));
            } else {
                mm.a aVarD2 = this.f30054b.o().d(s.f46856x5);
                if (aVarD2 == null) {
                    throw new TSPValidationException("no signing certificate attribute found, time stamp invalid.");
                }
                aVar = new a(vm.d.z(vm.h.y(aVarD2.y().J(0)).x()[0]));
            }
            this.f30056d = aVar;
        } catch (CMSException e10) {
            throw new TSPException(e10.getMessage(), e10.a());
        }
    }

    public static l0 h(n nVar) throws TSPException {
        try {
            return new l0(nVar);
        } catch (CMSException e10) {
            throw new TSPException("TSP parsing error: " + e10.getMessage(), e10.getCause());
        }
    }

    public org.bouncycastle.util.s<X509AttributeCertificateHolder> a() {
        return this.f30053a.b();
    }

    public org.bouncycastle.util.s<X509CRLHolder> b() {
        return this.f30053a.c();
    }

    public org.bouncycastle.util.s<X509CertificateHolder> c() {
        return this.f30053a.d();
    }

    public byte[] d() throws IOException {
        return this.f30053a.f(gm.j.f29714b);
    }

    public byte[] e(String str) throws IOException {
        return this.f30053a.f(str);
    }

    public a2 f() {
        return this.f30054b.m();
    }

    public mm.b g() {
        return this.f30054b.o();
    }

    public j i() {
        return this.f30055c;
    }

    public mm.b j() {
        return this.f30054b.r();
    }

    public boolean k(f2 f2Var) throws TSPException {
        try {
            return this.f30054b.w(f2Var);
        } catch (CMSException e10) {
            if (e10.a() != null) {
                throw new TSPException(e10.getMessage(), e10.a());
            }
            throw new TSPException("CMS exception: " + e10, e10);
        }
    }

    public l0 l() {
        return this.f30053a;
    }

    public void m(f2 f2Var) throws TSPException {
        if (!f2Var.d()) {
            throw new IllegalArgumentException("verifier provider needs an associated certificate");
        }
        try {
            X509CertificateHolder x509CertificateHolderA = f2Var.a();
            o oVarC = f2Var.c(this.f30056d.b());
            OutputStream outputStreamB = oVarC.b();
            outputStreamB.write(x509CertificateHolderA.getEncoded());
            outputStreamB.close();
            if (!org.bouncycastle.util.a.I(this.f30056d.a(), oVarC.c())) {
                throw new TSPValidationException("certificate hash does not match certID hash.");
            }
            if (this.f30056d.c() != null) {
                y yVar = new y(x509CertificateHolderA.y());
                if (!this.f30056d.c().B().C(yVar.z())) {
                    throw new TSPValidationException("certificate serial number does not match certID for signature.");
                }
                b0[] b0VarArrB = this.f30056d.c().z().B();
                boolean z10 = false;
                int i10 = 0;
                while (true) {
                    if (i10 != b0VarArrB.length) {
                        if (b0VarArrB[i10].q() == 4 && xn.d.A(b0VarArrB[i10].A()).equals(xn.d.A(yVar.y()))) {
                            z10 = true;
                            break;
                        }
                        i10++;
                    } else {
                        break;
                    }
                }
                if (!z10) {
                    throw new TSPValidationException("certificate name does not match certID for signature. ");
                }
            }
            c.e(x509CertificateHolderA);
            if (!x509CertificateHolderA.w(this.f30055c.d())) {
                throw new TSPValidationException("certificate not valid when time stamp created.");
            }
            if (!this.f30054b.w(f2Var)) {
                throw new TSPValidationException("signature not created by certificate.");
            }
        } catch (IOException e10) {
            throw new TSPException("problem processing certificate: " + e10, e10);
        } catch (CMSException e11) {
            if (e11.a() != null) {
                throw new TSPException(e11.getMessage(), e11.a());
            }
            throw new TSPException("CMS exception: " + e11, e11);
        } catch (OperatorCreationException e12) {
            throw new TSPException("unable to create digest: " + e12.getMessage(), e12);
        }
    }
}
