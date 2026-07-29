package org.bouncycastle.cms.jcajce;

import java.math.BigInteger;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import so.a2;

/* JADX INFO: loaded from: classes5.dex */
public class f extends a2 {
    public f(X509Certificate x509Certificate) {
        super(d(x509Certificate.getIssuerX500Principal()), x509Certificate.getSerialNumber(), a.f(x509Certificate));
    }

    public f(X500Principal x500Principal, BigInteger bigInteger) {
        super(d(x500Principal), bigInteger);
    }

    public f(X500Principal x500Principal, BigInteger bigInteger, byte[] bArr) {
        super(d(x500Principal), bigInteger, bArr);
    }

    public static xn.d d(X500Principal x500Principal) {
        if (x500Principal == null) {
            return null;
        }
        return xn.d.A(x500Principal.getEncoded());
    }
}
