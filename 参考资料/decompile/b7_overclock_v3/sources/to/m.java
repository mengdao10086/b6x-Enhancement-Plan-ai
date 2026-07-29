package to;

import ds.q;
import java.io.IOException;
import org.bouncycastle.cert.X509CertificateHolder;

/* JADX INFO: loaded from: classes5.dex */
public class m extends h {
    public m(X509CertificateHolder x509CertificateHolder) throws IOException {
        super(x509CertificateHolder, new q(x509CertificateHolder.p().x(), x509CertificateHolder.p()));
    }

    public m(byte[] bArr, zn.b bVar, np.c cVar) {
        super(bArr, new q(bVar, cVar));
    }
}
