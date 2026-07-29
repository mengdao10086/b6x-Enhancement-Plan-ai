package oo;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.path.CertPathValidationException;
import org.bouncycastle.util.m;
import zn.k0;
import zn.y;

/* JADX INFO: loaded from: classes5.dex */
public class e implements no.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f44381a;

    public e() {
        this(true);
    }

    public e(boolean z10) {
        this.f44381a = z10;
    }

    @Override // org.bouncycastle.util.m
    public m d() {
        return new e(this.f44381a);
    }

    @Override // org.bouncycastle.util.m
    public void i(m mVar) {
        this.f44381a = ((e) mVar).f44381a;
    }

    @Override // no.c
    public void j(no.d dVar, X509CertificateHolder x509CertificateHolder) throws CertPathValidationException {
        dVar.a(y.f59059f);
        if (dVar.c()) {
            return;
        }
        k0 k0VarX = k0.x(x509CertificateHolder.d());
        if (k0VarX != null) {
            if (!k0VarX.A(4)) {
                throw new CertPathValidationException("Issuer certificate KeyUsage extension does not permit key signing");
            }
        } else if (this.f44381a) {
            throw new CertPathValidationException("KeyUsage extension not present in CA certificate");
        }
    }
}
