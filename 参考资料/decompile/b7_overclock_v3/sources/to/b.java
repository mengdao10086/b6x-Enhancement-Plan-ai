package to;

import cs.g0;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.OperatorCreationException;
import so.f2;
import so.j0;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ds.n f51398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cs.p f51399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j0 f51400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g0 f51401d;

    public b(j0 j0Var, g0 g0Var, cs.n nVar, cs.p pVar) {
        this.f51400c = j0Var;
        this.f51401d = g0Var;
        this.f51398a = new ds.n(nVar);
        this.f51399b = pVar;
    }

    public f2 a(np.c cVar) throws OperatorCreationException {
        return new f2(this.f51400c, this.f51401d, this.f51398a.b(cVar), this.f51399b);
    }

    public f2 b(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException {
        return new f2(this.f51400c, this.f51401d, this.f51398a.c(x509CertificateHolder), this.f51399b);
    }
}
