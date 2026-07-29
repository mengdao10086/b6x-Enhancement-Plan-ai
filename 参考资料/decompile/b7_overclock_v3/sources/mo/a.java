package mo;

import cs.o;
import java.security.PublicKey;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.cert.ocsp.OCSPException;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class a extends lo.b {
    public a(PublicKey publicKey, o oVar) throws OCSPException {
        super(c1.A(publicKey.getEncoded()), oVar);
    }

    public a(X500Principal x500Principal) {
        super(new c(x500Principal));
    }
}
