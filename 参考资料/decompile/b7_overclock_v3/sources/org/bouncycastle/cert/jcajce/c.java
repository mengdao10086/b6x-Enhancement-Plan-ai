package org.bouncycastle.cert.jcajce;

import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes5.dex */
public class c extends p000do.b {
    public c(X509Certificate x509Certificate) {
        this(x509Certificate.getIssuerX500Principal());
    }

    public c(X500Principal x500Principal) {
        super(xn.d.A(x500Principal.getEncoded()));
    }
}
