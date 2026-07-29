package org.bouncycastle.jce.provider;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;

/* JADX INFO: loaded from: classes5.dex */
public class i {
    public static np.c a(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof DHPrivateKey)) {
            throw new InvalidKeyException("can't identify DH private key.");
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey) privateKey;
        return new np.r(dHPrivateKey.getX(), new np.q(dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG(), null, dHPrivateKey.getParams().getL()));
    }

    public static np.c b(PublicKey publicKey) throws InvalidKeyException {
        if (!(publicKey instanceof DHPublicKey)) {
            throw new InvalidKeyException("can't identify DH public key.");
        }
        DHPublicKey dHPublicKey = (DHPublicKey) publicKey;
        return new np.s(dHPublicKey.getY(), new np.q(dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG(), null, dHPublicKey.getParams().getL()));
    }
}
