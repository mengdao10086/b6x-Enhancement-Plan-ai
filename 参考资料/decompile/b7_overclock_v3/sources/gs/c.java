package gs;

import cs.d0;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.pkcs.PKCSIOException;
import pn.u;
import zn.o;

/* JADX INFO: loaded from: classes6.dex */
public class c extends es.i {
    public c(PrivateKey privateKey) {
        super(u.z(privateKey.getEncoded()));
    }

    public c(PrivateKey privateKey, d0 d0Var) {
        super(u.z(privateKey.getEncoded()), d0Var);
    }

    public c(X509Certificate x509Certificate) throws IOException {
        super(c(x509Certificate));
    }

    public static o c(X509Certificate x509Certificate) throws IOException {
        try {
            return o.z(x509Certificate.getEncoded());
        } catch (CertificateEncodingException e10) {
            throw new PKCSIOException("cannot encode certificate: " + e10.getMessage(), e10);
        }
    }
}
