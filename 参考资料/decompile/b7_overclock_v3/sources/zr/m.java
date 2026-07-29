package zr;

import gm.c0;
import gm.s;
import java.io.IOException;
import org.bouncycastle.cert.X509CertificateHolder;

/* JADX INFO: loaded from: classes6.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X509CertificateHolder f59714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f59715b;

    public m(X509CertificateHolder x509CertificateHolder, a aVar) {
        this.f59714a = x509CertificateHolder;
        this.f59715b = aVar;
    }

    public m(byte[] bArr) throws IOException {
        s sVar = new s(bArr);
        this.f59714a = new X509CertificateHolder(sVar.n().getEncoded());
        c0 c0VarN = sVar.n();
        if (c0VarN != null) {
            this.f59715b = new a(c0VarN.getEncoded());
        } else {
            this.f59715b = null;
        }
    }

    public X509CertificateHolder a() {
        return this.f59714a;
    }

    public byte[] b() throws IOException {
        return org.bouncycastle.util.a.B(this.f59714a.getEncoded(), this.f59715b.d().getEncoded());
    }

    public a c() {
        return this.f59715b;
    }
}
