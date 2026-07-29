package mo;

import cs.o;
import java.math.BigInteger;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.cert.ocsp.OCSPException;

/* JADX INFO: loaded from: classes5.dex */
public class b extends lo.c {
    public b(o oVar, X509Certificate x509Certificate, BigInteger bigInteger) throws OCSPException, CertificateEncodingException {
        super(oVar, new JcaX509CertificateHolder(x509Certificate), bigInteger);
    }
}
