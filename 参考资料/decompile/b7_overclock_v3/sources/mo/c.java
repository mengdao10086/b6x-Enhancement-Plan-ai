package mo;

import cs.o;
import java.security.PublicKey;
import javax.security.auth.x500.X500Principal;
import lo.l;
import org.bouncycastle.cert.ocsp.OCSPException;
import xn.d;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class c extends l {
    public c(PublicKey publicKey, o oVar) throws OCSPException {
        super(c1.A(publicKey.getEncoded()), oVar);
    }

    public c(X500Principal x500Principal) {
        super(d.A(x500Principal.getEncoded()));
    }
}
