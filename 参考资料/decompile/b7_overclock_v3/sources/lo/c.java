package lo;

import cs.p;
import gm.d2;
import gm.f2;
import gm.t;
import gm.y;
import java.io.OutputStream;
import java.math.BigInteger;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.ocsp.OCSPException;
import org.bouncycastle.operator.OperatorCreationException;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zn.b f40069b = new zn.b(on.b.f44365i, d2.f29657b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nn.b f40070a;

    public c(cs.o oVar, X509CertificateHolder x509CertificateHolder, BigInteger bigInteger) throws OCSPException {
        this.f40070a = a(oVar, x509CertificateHolder, new t(bigInteger));
    }

    public c(nn.b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("'id' cannot be null");
        }
        this.f40070a = bVar;
    }

    public static nn.b a(cs.o oVar, X509CertificateHolder x509CertificateHolder, t tVar) throws OCSPException {
        try {
            OutputStream outputStreamB = oVar.b();
            outputStreamB.write(x509CertificateHolder.y().F().v(gm.j.f29713a));
            outputStreamB.close();
            f2 f2Var = new f2(oVar.c());
            c1 c1VarP = x509CertificateHolder.p();
            OutputStream outputStreamB2 = oVar.b();
            outputStreamB2.write(c1VarP.C().H());
            outputStreamB2.close();
            return new nn.b(oVar.a(), f2Var, new f2(oVar.c()), tVar);
        } catch (Exception e10) {
            throw new OCSPException("problem creating ID: " + e10, e10);
        }
    }

    public static c b(c cVar, BigInteger bigInteger) {
        return new c(new nn.b(cVar.f40070a.x(), cVar.f40070a.B(), cVar.f40070a.A(), new t(bigInteger)));
    }

    public y c() {
        return this.f40070a.x().x();
    }

    public byte[] d() {
        return this.f40070a.A().J();
    }

    public byte[] e() {
        return this.f40070a.B().J();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f40070a.b().C(((c) obj).f40070a.b());
        }
        return false;
    }

    public BigInteger f() {
        return this.f40070a.C().K();
    }

    public boolean g(X509CertificateHolder x509CertificateHolder, p pVar) throws OCSPException {
        try {
            return a(pVar.a(this.f40070a.x()), x509CertificateHolder, this.f40070a.C()).equals(this.f40070a);
        } catch (OperatorCreationException e10) {
            throw new OCSPException("unable to create digest calculator: " + e10.getMessage(), e10);
        }
    }

    public nn.b h() {
        return this.f40070a;
    }

    public int hashCode() {
        return this.f40070a.b().hashCode();
    }
}
