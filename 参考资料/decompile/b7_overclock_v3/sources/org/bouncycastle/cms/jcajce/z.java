package org.bouncycastle.cms.jcajce;

import java.math.BigInteger;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import so.d1;

/* JADX INFO: loaded from: classes5.dex */
public class z extends d1 {
    public z(X509Certificate x509Certificate) {
        this(x509Certificate.getIssuerX500Principal(), x509Certificate.getSerialNumber());
    }

    public z(X500Principal x500Principal, BigInteger bigInteger) {
        super(xn.d.A(x500Principal.getEncoded()), bigInteger);
    }
}
