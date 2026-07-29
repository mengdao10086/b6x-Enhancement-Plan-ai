package xs;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcElieceCCA2PrivateKey;
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcElieceCCA2PublicKey;

/* JADX INFO: loaded from: classes6.dex */
public class c {
    public static np.c a(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof BCMcElieceCCA2PrivateKey) {
            return ((BCMcElieceCCA2PrivateKey) privateKey).f();
        }
        throw new InvalidKeyException("can't identify McElieceCCA2 private key.");
    }

    public static np.c b(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCMcElieceCCA2PublicKey) {
            return ((BCMcElieceCCA2PublicKey) publicKey).c();
        }
        throw new InvalidKeyException("can't identify McElieceCCA2 public key: " + publicKey.getClass().getName());
    }
}
