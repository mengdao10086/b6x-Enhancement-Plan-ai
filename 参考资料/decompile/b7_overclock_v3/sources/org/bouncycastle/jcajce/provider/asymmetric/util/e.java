package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import np.q;
import np.r;
import np.s;
import org.bouncycastle.jcajce.provider.asymmetric.dh.BCDHPublicKey;

/* JADX INFO: loaded from: classes7.dex */
public class e {
    public static np.c a(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof DHPrivateKey)) {
            throw new InvalidKeyException("can't identify DH private key.");
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey) privateKey;
        return new r(dHPrivateKey.getX(), new q(dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG(), null, dHPrivateKey.getParams().getL()));
    }

    public static np.c b(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCDHPublicKey) {
            return ((BCDHPublicKey) publicKey).a();
        }
        if (!(publicKey instanceof DHPublicKey)) {
            throw new InvalidKeyException("can't identify DH public key.");
        }
        DHPublicKey dHPublicKey = (DHPublicKey) publicKey;
        return new s(dHPublicKey.getY(), new q(dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG(), null, dHPublicKey.getParams().getL()));
    }
}
