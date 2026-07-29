package org.bouncycastle.cert.jcajce;

import java.math.BigInteger;
import java.security.PublicKey;
import java.util.Date;
import javax.security.auth.x500.X500Principal;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class j extends p000do.g {
    public j(X500Principal x500Principal, BigInteger bigInteger, Date date, Date date2, X500Principal x500Principal2, PublicKey publicKey) {
        super(xn.d.A(x500Principal.getEncoded()), bigInteger, date, date2, xn.d.A(x500Principal2.getEncoded()), c1.A(publicKey.getEncoded()));
    }

    public j(xn.d dVar, BigInteger bigInteger, Date date, Date date2, xn.d dVar2, PublicKey publicKey) {
        super(dVar, bigInteger, date, date2, dVar2, c1.A(publicKey.getEncoded()));
    }
}
