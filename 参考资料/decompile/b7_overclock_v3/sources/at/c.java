package at;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.pqc.jcajce.provider.rainbow.BCRainbowPrivateKey;
import org.bouncycastle.pqc.jcajce.provider.rainbow.BCRainbowPublicKey;
import ps.f;
import ps.g;

/* JADX INFO: loaded from: classes6.dex */
public class c {
    public static np.c a(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof BCRainbowPrivateKey)) {
            throw new InvalidKeyException("can't identify Rainbow private key.");
        }
        BCRainbowPrivateKey bCRainbowPrivateKey = (BCRainbowPrivateKey) privateKey;
        return new f(bCRainbowPrivateKey.c(), bCRainbowPrivateKey.a(), bCRainbowPrivateKey.d(), bCRainbowPrivateKey.b(), bCRainbowPrivateKey.h(), bCRainbowPrivateKey.f());
    }

    public static np.c b(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCRainbowPublicKey) {
            BCRainbowPublicKey bCRainbowPublicKey = (BCRainbowPublicKey) publicKey;
            return new g(bCRainbowPublicKey.d(), bCRainbowPublicKey.a(), bCRainbowPublicKey.c(), bCRainbowPublicKey.b());
        }
        throw new InvalidKeyException("can't identify Rainbow public key: " + publicKey.getClass().getName());
    }
}
