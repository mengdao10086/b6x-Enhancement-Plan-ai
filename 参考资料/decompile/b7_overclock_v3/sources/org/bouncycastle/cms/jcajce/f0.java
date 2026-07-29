package org.bouncycastle.cms.jcajce;

import java.math.BigInteger;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import so.h1;

/* JADX INFO: loaded from: classes5.dex */
public class f0 extends h1 {
    public f0(X509Certificate x509Certificate) {
        super(e(x509Certificate.getIssuerX500Principal()), x509Certificate.getSerialNumber(), a.f(x509Certificate));
    }

    public f0(X500Principal x500Principal, BigInteger bigInteger) {
        super(e(x500Principal), bigInteger);
    }

    public f0(X500Principal x500Principal, BigInteger bigInteger, byte[] bArr) {
        super(e(x500Principal), bigInteger, bArr);
    }

    public static xn.d e(X500Principal x500Principal) {
        if (x500Principal == null) {
            return null;
        }
        return xn.d.A(x500Principal.getEncoded());
    }
}
