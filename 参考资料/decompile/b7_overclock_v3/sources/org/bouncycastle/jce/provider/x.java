package org.bouncycastle.jce.provider;

import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes5.dex */
public class x {
    public static xn.d a(TrustAnchor trustAnchor) {
        return g(i(trustAnchor).getCA());
    }

    public static byte[] b(X500Principal x500Principal) {
        return n(l(x500Principal).getEncoded());
    }

    public static xn.d c(Object obj) {
        return obj instanceof X509Certificate ? e((X509Certificate) obj) : g((X500Principal) ((org.bouncycastle.x509.l) obj).m().b()[0]);
    }

    public static xn.d d(X509CRL x509crl) {
        return g(j(x509crl).getIssuerX500Principal());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static xn.d e(X509Certificate x509Certificate) {
        return x509Certificate instanceof kq.a ? m(((kq.a) x509Certificate).a()) : g(k(x509Certificate).getIssuerX500Principal());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static xn.d f(X509Certificate x509Certificate) {
        return x509Certificate instanceof kq.a ? m(((kq.a) x509Certificate).b()) : g(k(x509Certificate).getSubjectX500Principal());
    }

    public static xn.d g(X500Principal x500Principal) {
        return m(xn.d.A(b(x500Principal)));
    }

    public static xn.d h(xn.f fVar, X500Principal x500Principal) {
        return m(xn.d.B(fVar, b(x500Principal)));
    }

    public static TrustAnchor i(TrustAnchor trustAnchor) {
        if (trustAnchor != null) {
            return trustAnchor;
        }
        throw new IllegalStateException();
    }

    public static X509CRL j(X509CRL x509crl) {
        if (x509crl != null) {
            return x509crl;
        }
        throw new IllegalStateException();
    }

    public static X509Certificate k(X509Certificate x509Certificate) {
        if (x509Certificate != null) {
            return x509Certificate;
        }
        throw new IllegalStateException();
    }

    public static X500Principal l(X500Principal x500Principal) {
        if (x500Principal != null) {
            return x500Principal;
        }
        throw new IllegalStateException();
    }

    public static xn.d m(xn.d dVar) {
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalStateException();
    }

    public static byte[] n(byte[] bArr) {
        if (bArr != null) {
            return bArr;
        }
        throw new IllegalStateException();
    }
}
