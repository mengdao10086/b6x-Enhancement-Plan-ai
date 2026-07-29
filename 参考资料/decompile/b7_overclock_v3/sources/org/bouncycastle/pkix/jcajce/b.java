package org.bouncycastle.pkix.jcajce;

import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import pn.u;

/* JADX INFO: loaded from: classes6.dex */
public class b extends hs.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PrivateKey f45658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final X509Certificate[] f45659d;

    public b(PrivateKey privateKey, X509Certificate x509Certificate) {
        this(privateKey, new X509Certificate[]{x509Certificate});
    }

    public b(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
        super(h(privateKey), f(x509CertificateArr));
        this.f45658c = privateKey;
        X509Certificate[] x509CertificateArr2 = new X509Certificate[x509CertificateArr.length];
        this.f45659d = x509CertificateArr2;
        System.arraycopy(x509CertificateArr, 0, x509CertificateArr2, 0, x509CertificateArr.length);
    }

    public static X509CertificateHolder[] f(X509Certificate[] x509CertificateArr) {
        int length = x509CertificateArr.length;
        X509CertificateHolder[] x509CertificateHolderArr = new X509CertificateHolder[length];
        for (int i10 = 0; i10 != length; i10++) {
            try {
                x509CertificateHolderArr[i10] = new JcaX509CertificateHolder(x509CertificateArr[i10]);
            } catch (CertificateEncodingException e10) {
                throw new IllegalArgumentException("Unable to process certificates: " + e10.getMessage());
            }
        }
        return x509CertificateHolderArr;
    }

    public static u h(PrivateKey privateKey) {
        try {
            return u.z(privateKey.getEncoded());
        } catch (Exception unused) {
            return null;
        }
    }

    public PrivateKey g() {
        return this.f45658c;
    }

    public X509Certificate i() {
        return this.f45659d[0];
    }

    public X509Certificate[] j() {
        X509Certificate[] x509CertificateArr = this.f45659d;
        int length = x509CertificateArr.length;
        X509Certificate[] x509CertificateArr2 = new X509Certificate[length];
        System.arraycopy(x509CertificateArr, 0, x509CertificateArr2, 0, length);
        return x509CertificateArr2;
    }
}
