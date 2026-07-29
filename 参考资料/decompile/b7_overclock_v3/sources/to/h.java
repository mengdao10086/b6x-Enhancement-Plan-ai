package to;

import mm.y;
import org.bouncycastle.cert.X509CertificateHolder;
import so.i1;

/* JADX INFO: loaded from: classes5.dex */
public abstract class h extends i1 {
    public h(X509CertificateHolder x509CertificateHolder, ds.e eVar) {
        super(new y(x509CertificateHolder.y()), eVar);
    }

    public h(byte[] bArr, ds.e eVar) {
        super(bArr, eVar);
    }
}
