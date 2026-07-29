package qo;

import gm.z;
import java.io.IOException;
import java.security.cert.X509CertSelector;
import po.d;

/* JADX INFO: loaded from: classes5.dex */
public class a {
    public d a(X509CertSelector x509CertSelector) {
        try {
            return x509CertSelector.getSubjectKeyIdentifier() != null ? new d(xn.d.A(x509CertSelector.getIssuerAsBytes()), x509CertSelector.getSerialNumber(), z.I(x509CertSelector.getSubjectKeyIdentifier()).J()) : new d(xn.d.A(x509CertSelector.getIssuerAsBytes()), x509CertSelector.getSerialNumber());
        } catch (IOException e10) {
            throw new IllegalArgumentException("unable to convert issuer: " + e10.getMessage());
        }
    }
}
