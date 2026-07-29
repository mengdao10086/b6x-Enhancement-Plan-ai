package hs;

import org.bouncycastle.cert.X509CertificateHolder;
import pn.u;
import so.h1;
import so.v1;
import zn.b1;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f31436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X509CertificateHolder[] f31437b;

    public a(u uVar, X509CertificateHolder x509CertificateHolder) {
        this(uVar, new X509CertificateHolder[]{x509CertificateHolder});
    }

    public a(u uVar, X509CertificateHolder[] x509CertificateHolderArr) {
        this.f31436a = uVar;
        X509CertificateHolder[] x509CertificateHolderArr2 = new X509CertificateHolder[x509CertificateHolderArr.length];
        this.f31437b = x509CertificateHolderArr2;
        System.arraycopy(x509CertificateHolderArr, 0, x509CertificateHolderArr2, 0, x509CertificateHolderArr.length);
    }

    public X509CertificateHolder a() {
        return this.f31437b[0];
    }

    public X509CertificateHolder[] b() {
        X509CertificateHolder[] x509CertificateHolderArr = this.f31437b;
        int length = x509CertificateHolderArr.length;
        X509CertificateHolder[] x509CertificateHolderArr2 = new X509CertificateHolder[length];
        System.arraycopy(x509CertificateHolderArr, 0, x509CertificateHolderArr2, 0, length);
        return x509CertificateHolderArr2;
    }

    public u c() {
        return this.f31436a;
    }

    public v1 d() {
        return new h1(this.f31437b[0].f(), this.f31437b[0].l(), e());
    }

    public final byte[] e() {
        b1 b1VarX = b1.x(this.f31437b[0].d());
        if (b1VarX == null) {
            return null;
        }
        return b1VarX.A();
    }
}
