package io;

import go.j;
import java.security.PrivateKey;
import javax.security.auth.x500.X500Principal;
import pn.u;
import zn.b0;

/* JADX INFO: loaded from: classes5.dex */
public class e extends j {
    public e(PrivateKey privateKey, X500Principal x500Principal) {
        this(privateKey, xn.d.A(x500Principal.getEncoded()));
    }

    public e(PrivateKey privateKey, xn.d dVar) {
        this(privateKey, new b0(dVar));
    }

    public e(PrivateKey privateKey, b0 b0Var) {
        super(u.z(privateKey.getEncoded()), b0Var);
    }
}
