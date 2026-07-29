package ho;

import cs.d0;
import cs.x;
import go.f;
import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import om.m;
import org.bouncycastle.cert.crmf.CRMFException;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;

/* JADX INFO: loaded from: classes5.dex */
public class b extends f {
    public b(x xVar, d0 d0Var) {
        super(xVar, d0Var);
    }

    public m f(X509Certificate x509Certificate) throws CRMFException, CertificateEncodingException {
        return a(new JcaX509CertificateHolder(x509Certificate));
    }

    public m g(np.c cVar) throws CRMFException, IOException {
        return b(org.bouncycastle.crypto.util.m.a(cVar));
    }
}
