package org.bouncycastle.jcajce.provider.asymmetric.util;

import gr.p;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import np.b1;
import np.c1;
import np.d1;
import org.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import org.bouncycastle.jce.interfaces.GOST3410PublicKey;

/* JADX INFO: loaded from: classes7.dex */
public class j {
    public static np.c a(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof GOST3410PrivateKey)) {
            throw new InvalidKeyException("can't identify GOST3410 private key.");
        }
        GOST3410PrivateKey gOST3410PrivateKey = (GOST3410PrivateKey) privateKey;
        p pVarA = gOST3410PrivateKey.b().a();
        return new c1(gOST3410PrivateKey.getX(), new b1(pVarA.b(), pVarA.c(), pVarA.a()));
    }

    public static np.c b(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof GOST3410PublicKey) {
            GOST3410PublicKey gOST3410PublicKey = (GOST3410PublicKey) publicKey;
            p pVarA = gOST3410PublicKey.b().a();
            return new d1(gOST3410PublicKey.getY(), new b1(pVarA.b(), pVarA.c(), pVarA.a()));
        }
        throw new InvalidKeyException("can't identify GOST3410 public key: " + publicKey.getClass().getName());
    }
}
