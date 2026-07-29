package xs;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import ms.q;
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcEliecePrivateKey;
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcEliecePublicKey;

/* JADX INFO: loaded from: classes6.dex */
public class h {
    public static np.c a(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof BCMcEliecePrivateKey)) {
            throw new InvalidKeyException("can't identify McEliece private key.");
        }
        BCMcEliecePrivateKey bCMcEliecePrivateKey = (BCMcEliecePrivateKey) privateKey;
        return new q(bCMcEliecePrivateKey.h(), bCMcEliecePrivateKey.d(), bCMcEliecePrivateKey.a(), bCMcEliecePrivateKey.b(), bCMcEliecePrivateKey.i(), bCMcEliecePrivateKey.k(), bCMcEliecePrivateKey.m());
    }

    public static np.c b(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCMcEliecePublicKey) {
            return ((BCMcEliecePublicKey) publicKey).c();
        }
        throw new InvalidKeyException("can't identify McEliece public key: " + publicKey.getClass().getName());
    }
}
