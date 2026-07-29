package no;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.path.CertPathValidationException;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X509CertificateHolder[] f42307a;

    public a(X509CertificateHolder[] x509CertificateHolderArr) {
        this.f42307a = a(x509CertificateHolderArr);
    }

    public final X509CertificateHolder[] a(X509CertificateHolder[] x509CertificateHolderArr) {
        int length = x509CertificateHolderArr.length;
        X509CertificateHolder[] x509CertificateHolderArr2 = new X509CertificateHolder[length];
        System.arraycopy(x509CertificateHolderArr, 0, x509CertificateHolderArr2, 0, length);
        return x509CertificateHolderArr2;
    }

    public e b(c[] cVarArr) {
        d dVar = new d(b.a(this.f42307a));
        f fVar = new f(dVar);
        for (int i10 = 0; i10 != cVarArr.length; i10++) {
            int length = this.f42307a.length - 1;
            while (length >= 0) {
                try {
                    dVar.e(length == 0);
                    cVarArr[i10].j(dVar, this.f42307a[length]);
                } catch (CertPathValidationException e10) {
                    fVar.a(length, i10, e10);
                }
                length--;
            }
        }
        return fVar.b();
    }

    public X509CertificateHolder[] c() {
        return a(this.f42307a);
    }

    public int d() {
        return this.f42307a.length;
    }

    public e e(c[] cVarArr) {
        d dVar = new d(b.a(this.f42307a));
        for (int i10 = 0; i10 != cVarArr.length; i10++) {
            int length = this.f42307a.length - 1;
            while (length >= 0) {
                try {
                    dVar.e(length == 0);
                    cVarArr[i10].j(dVar, this.f42307a[length]);
                    length--;
                } catch (CertPathValidationException e10) {
                    return new e(dVar, length, i10, e10);
                }
            }
        }
        return new e(dVar);
    }
}
