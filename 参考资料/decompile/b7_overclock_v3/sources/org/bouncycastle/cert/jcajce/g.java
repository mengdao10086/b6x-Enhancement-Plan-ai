package org.bouncycastle.cert.jcajce;

import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes5.dex */
public class g {
    public static byte[] a(X500Principal x500Principal) {
        return h(x500Principal).getEncoded();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static xn.d b(X509Certificate x509Certificate) {
        return x509Certificate instanceof kq.a ? i(((kq.a) x509Certificate).a()) : f(x509Certificate.getIssuerX500Principal());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static xn.d c(xn.f fVar, X509Certificate x509Certificate) {
        return x509Certificate instanceof kq.a ? xn.d.B(fVar, i(((kq.a) x509Certificate).a())) : g(fVar, x509Certificate.getIssuerX500Principal());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static xn.d d(X509Certificate x509Certificate) {
        return x509Certificate instanceof kq.a ? i(((kq.a) x509Certificate).b()) : f(x509Certificate.getSubjectX500Principal());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static xn.d e(xn.f fVar, X509Certificate x509Certificate) {
        return x509Certificate instanceof kq.a ? xn.d.B(fVar, i(((kq.a) x509Certificate).b())) : g(fVar, x509Certificate.getSubjectX500Principal());
    }

    public static xn.d f(X500Principal x500Principal) {
        return xn.d.A(a(x500Principal));
    }

    public static xn.d g(xn.f fVar, X500Principal x500Principal) {
        return xn.d.B(fVar, a(x500Principal));
    }

    public static X500Principal h(X500Principal x500Principal) {
        if (x500Principal != null) {
            return x500Principal;
        }
        throw new IllegalStateException();
    }

    public static xn.d i(xn.d dVar) {
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalStateException();
    }
}
