package gs;

import es.l;
import java.security.PrivateKey;
import pn.u;

/* JADX INFO: loaded from: classes6.dex */
public class d extends l {
    public d(PrivateKey privateKey) {
        super(u.z(privateKey.getEncoded()));
    }
}
