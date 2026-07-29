package jo;

import cs.o;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.dane.DANEException;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f36534a;

    public c(o oVar) {
        this.f36534a = new g(oVar);
    }

    public b a(String str, int i10, X509CertificateHolder x509CertificateHolder) throws DANEException {
        if (i10 >= 0 && i10 <= 3) {
            return new b(this.f36534a.a(str).a(), new byte[]{(byte) i10, 0, 0}, x509CertificateHolder);
        }
        throw new DANEException("unknown certificate usage: " + i10);
    }

    public b b(String str, X509CertificateHolder x509CertificateHolder) throws DANEException {
        return a(str, 3, x509CertificateHolder);
    }
}
