package fo;

import cs.n;
import cs.o;
import cs.p;
import java.math.BigInteger;
import lm.b0;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.cmp.CMPException;
import org.bouncycastle.operator.OperatorCreationException;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f28534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public lm.i f28535b;

    public d(n nVar, lm.i iVar) {
        this.f28534a = nVar;
        this.f28535b = iVar;
    }

    public BigInteger a() {
        return this.f28535b.y().K();
    }

    public b0 b() {
        return this.f28535b.A();
    }

    public boolean c(X509CertificateHolder x509CertificateHolder, p pVar) throws CMPException {
        zn.b bVarC = this.f28534a.c(x509CertificateHolder.y().D());
        if (bVarC == null) {
            throw new CMPException("cannot find algorithm for digest from signature");
        }
        try {
            o oVarA = pVar.a(bVarC);
            a.a(x509CertificateHolder.y(), oVarA.b());
            return org.bouncycastle.util.a.g(this.f28535b.x().J(), oVarA.c());
        } catch (OperatorCreationException e10) {
            throw new CMPException("unable to create digester: " + e10.getMessage(), e10);
        }
    }
}
