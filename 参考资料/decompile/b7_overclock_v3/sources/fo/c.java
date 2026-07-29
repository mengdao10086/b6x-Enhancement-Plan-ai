package fo;

import cs.j;
import cs.n;
import cs.o;
import cs.p;
import gm.j2;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.cmp.CMPException;
import org.bouncycastle.operator.OperatorCreationException;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f28531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f28532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f28533c;

    public c() {
        this(new j());
    }

    public c(n nVar) {
        this.f28532b = new ArrayList();
        this.f28533c = new ArrayList();
        this.f28531a = nVar;
    }

    public c a(X509CertificateHolder x509CertificateHolder, BigInteger bigInteger) {
        this.f28532b.add(x509CertificateHolder);
        this.f28533c.add(bigInteger);
        return this;
    }

    public b b(p pVar) throws CMPException {
        gm.i iVar = new gm.i();
        for (int i10 = 0; i10 != this.f28532b.size(); i10++) {
            X509CertificateHolder x509CertificateHolder = (X509CertificateHolder) this.f28532b.get(i10);
            BigInteger bigInteger = (BigInteger) this.f28533c.get(i10);
            zn.b bVarC = this.f28531a.c(x509CertificateHolder.y().D());
            if (bVarC == null) {
                throw new CMPException("cannot find algorithm for digest from signature");
            }
            try {
                o oVarA = pVar.a(bVarC);
                a.a(x509CertificateHolder.y(), oVarA.b());
                iVar.a(new lm.i(oVarA.c(), bigInteger));
            } catch (OperatorCreationException e10) {
                throw new CMPException("unable to create digest: " + e10.getMessage(), e10);
            }
        }
        return new b(lm.e.x(new j2(iVar)), this.f28531a);
    }
}
