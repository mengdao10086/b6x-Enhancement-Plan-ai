package gs;

import java.security.PublicKey;
import javax.security.auth.x500.X500Principal;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class b extends es.c {
    public b(X500Principal x500Principal, PublicKey publicKey) {
        super(xn.d.A(x500Principal.getEncoded()), c1.A(publicKey.getEncoded()));
    }

    public b(xn.d dVar, PublicKey publicKey) {
        super(dVar, c1.A(publicKey.getEncoded()));
    }
}
