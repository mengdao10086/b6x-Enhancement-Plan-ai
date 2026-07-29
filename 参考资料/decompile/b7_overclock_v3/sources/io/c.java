package io;

import java.math.BigInteger;
import java.security.PublicKey;
import javax.security.auth.x500.X500Principal;
import zn.b0;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class c extends go.d {
    public c(BigInteger bigInteger) {
        super(bigInteger);
    }

    public c s(X500Principal x500Principal) {
        if (x500Principal != null) {
            h(new b0(xn.d.A(x500Principal.getEncoded())));
        }
        return this;
    }

    public c t(X500Principal x500Principal) {
        if (x500Principal != null) {
            i(xn.d.A(x500Principal.getEncoded()));
        }
        return this;
    }

    public c u(PublicKey publicKey) {
        o(c1.A(publicKey.getEncoded()));
        return this;
    }

    public c v(X500Principal x500Principal) {
        if (x500Principal != null) {
            q(xn.d.A(x500Principal.getEncoded()));
        }
        return this;
    }
}
