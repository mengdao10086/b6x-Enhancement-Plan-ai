package bs;

import cs.d0;
import java.security.PrivateKey;
import org.bouncycastle.util.io.pem.PemGenerationException;
import pn.u;
import zr.k;

/* JADX INFO: loaded from: classes6.dex */
public class d extends k {
    public d(PrivateKey privateKey, d0 d0Var) throws PemGenerationException {
        super(u.z(privateKey.getEncoded()), d0Var);
    }
}
