package oo;

import gm.h;
import gm.u;
import java.io.IOException;
import org.bouncycastle.cert.CertException;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.path.CertPathValidationException;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.m;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class f implements no.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p000do.e f44382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xn.d f44383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c1 f44384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public zn.b f44385d;

    public f(p000do.e eVar) {
        this.f44382a = eVar;
    }

    public final boolean a(h hVar) {
        return hVar == null || (hVar instanceof u);
    }

    @Override // org.bouncycastle.util.m
    public m d() {
        f fVar = new f(this.f44382a);
        fVar.f44385d = this.f44385d;
        fVar.f44383b = this.f44383b;
        fVar.f44384c = this.f44384c;
        return fVar;
    }

    @Override // org.bouncycastle.util.m
    public void i(m mVar) {
        f fVar = (f) mVar;
        this.f44382a = fVar.f44382a;
        this.f44385d = fVar.f44385d;
        this.f44383b = fVar.f44383b;
        this.f44384c = fVar.f44384c;
    }

    @Override // no.c
    public void j(no.d dVar, X509CertificateHolder x509CertificateHolder) throws CertPathValidationException {
        xn.d dVar2 = this.f44383b;
        if (dVar2 != null && !dVar2.equals(x509CertificateHolder.f())) {
            throw new CertPathValidationException("Certificate issue does not match parent");
        }
        c1 c1Var = this.f44384c;
        if (c1Var != null) {
            try {
                if (!x509CertificateHolder.v(this.f44382a.b(c1Var.x().equals(this.f44385d) ? this.f44384c : new c1(this.f44385d, this.f44384c.D())))) {
                    throw new CertPathValidationException("Certificate signature not for public key in parent");
                }
            } catch (IOException e10) {
                throw new CertPathValidationException("Unable to build public key: " + e10.getMessage(), e10);
            } catch (CertException e11) {
                throw new CertPathValidationException("Unable to validate signature: " + e11.getMessage(), e11);
            } catch (OperatorCreationException e12) {
                throw new CertPathValidationException("Unable to create verifier: " + e12.getMessage(), e12);
            }
        }
        this.f44383b = x509CertificateHolder.o();
        c1 c1VarP = x509CertificateHolder.p();
        this.f44384c = c1VarP;
        zn.b bVar = this.f44385d;
        zn.b bVarX = c1VarP.x();
        if (bVar != null) {
            if (bVarX.x().C(this.f44385d.x()) && a(this.f44384c.x().A())) {
                return;
            } else {
                bVarX = this.f44384c.x();
            }
        }
        this.f44385d = bVarX;
    }
}
