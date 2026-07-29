package qo;

import gm.f2;
import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.X509CertSelector;
import xn.d;

/* JADX INFO: loaded from: classes5.dex */
public class b {
    public X509CertSelector a(d dVar, BigInteger bigInteger, byte[] bArr) {
        X509CertSelector x509CertSelector = new X509CertSelector();
        if (dVar != null) {
            try {
                x509CertSelector.setIssuer(dVar.getEncoded());
            } catch (IOException e10) {
                throw new IllegalArgumentException("unable to convert issuer: " + e10.getMessage());
            }
        }
        if (bigInteger != null) {
            x509CertSelector.setSerialNumber(bigInteger);
        }
        if (bArr != null) {
            try {
                x509CertSelector.setSubjectKeyIdentifier(new f2(bArr).getEncoded());
            } catch (IOException e11) {
                throw new IllegalArgumentException("unable to convert issuer: " + e11.getMessage());
            }
        }
        return x509CertSelector;
    }

    public X509CertSelector b(po.d dVar) {
        return a(dVar.b(), dVar.c(), dVar.d());
    }
}
