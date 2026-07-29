package to;

import cs.g0;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.OperatorCreationException;
import so.f2;
import so.j0;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ds.o f51402a = new ds.o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cs.p f51403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j0 f51404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g0 f51405d;

    public c(j0 j0Var, g0 g0Var, cs.n nVar, cs.p pVar) {
        this.f51404c = j0Var;
        this.f51405d = g0Var;
        this.f51403b = pVar;
    }

    public f2 a(np.c cVar) throws OperatorCreationException {
        return new f2(this.f51404c, this.f51405d, this.f51402a.b(cVar), this.f51403b);
    }

    public f2 b(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException {
        return new f2(this.f51404c, this.f51405d, this.f51402a.c(x509CertificateHolder), this.f51403b);
    }
}
