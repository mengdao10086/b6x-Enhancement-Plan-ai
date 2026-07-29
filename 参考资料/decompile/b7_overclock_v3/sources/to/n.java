package to;

import cs.g0;
import ds.s;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.OperatorCreationException;
import so.f2;
import so.j0;

/* JADX INFO: loaded from: classes5.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f51419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cs.p f51420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j0 f51421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g0 f51422d;

    public n(j0 j0Var, g0 g0Var, cs.n nVar, cs.p pVar) {
        this.f51421c = j0Var;
        this.f51422d = g0Var;
        this.f51419a = new s(nVar);
        this.f51420b = pVar;
    }

    public f2 a(np.c cVar) throws OperatorCreationException {
        return new f2(this.f51421c, this.f51422d, this.f51419a.b(cVar), this.f51420b);
    }

    public f2 b(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException {
        return new f2(this.f51421c, this.f51422d, this.f51419a.c(x509CertificateHolder), this.f51420b);
    }
}
