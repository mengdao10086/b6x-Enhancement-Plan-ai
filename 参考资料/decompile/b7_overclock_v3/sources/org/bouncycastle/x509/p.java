package org.bouncycastle.x509;

import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.jce.provider.X509CertificateObject;

/* JADX INFO: loaded from: classes6.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f46137a = new org.bouncycastle.jcajce.util.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public X509Certificate f46138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public X509Certificate f46139c;

    public p(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        this.f46138b = x509Certificate;
        this.f46139c = x509Certificate2;
    }

    public p(zn.q qVar) throws CertificateParsingException {
        if (qVar.x() != null) {
            this.f46138b = new X509CertificateObject(qVar.x());
        }
        if (qVar.z() != null) {
            this.f46139c = new X509CertificateObject(qVar.z());
        }
    }

    public byte[] a() throws CertificateEncodingException {
        zn.o oVarZ;
        try {
            zn.o oVarZ2 = null;
            if (this.f46138b != null) {
                oVarZ = zn.o.z(new gm.s(this.f46138b.getEncoded()).n());
                if (oVarZ == null) {
                    throw new CertificateEncodingException("unable to get encoding for forward");
                }
            } else {
                oVarZ = null;
            }
            if (this.f46139c != null && (oVarZ2 = zn.o.z(new gm.s(this.f46139c.getEncoded()).n())) == null) {
                throw new CertificateEncodingException("unable to get encoding for reverse");
            }
            return new zn.q(oVarZ, oVarZ2).v(gm.j.f29713a);
        } catch (IOException e10) {
            throw new ExtCertificateEncodingException(e10.toString(), e10);
        } catch (IllegalArgumentException e11) {
            throw new ExtCertificateEncodingException(e11.toString(), e11);
        }
    }

    public X509Certificate b() {
        return this.f46138b;
    }

    public X509Certificate c() {
        return this.f46139c;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        X509Certificate x509Certificate = this.f46138b;
        boolean zEquals = x509Certificate != null ? x509Certificate.equals(pVar.f46138b) : pVar.f46138b == null;
        X509Certificate x509Certificate2 = this.f46139c;
        X509Certificate x509Certificate3 = pVar.f46139c;
        return zEquals && (x509Certificate2 != null ? x509Certificate2.equals(x509Certificate3) : x509Certificate3 == null);
    }

    public int hashCode() {
        X509Certificate x509Certificate = this.f46138b;
        int iHashCode = x509Certificate != null ? (-1) ^ x509Certificate.hashCode() : -1;
        X509Certificate x509Certificate2 = this.f46139c;
        return x509Certificate2 != null ? (iHashCode * 17) ^ x509Certificate2.hashCode() : iHashCode;
    }
}
