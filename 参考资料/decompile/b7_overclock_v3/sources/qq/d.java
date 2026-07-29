package qq;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import np.v0;
import np.w0;
import np.x0;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.jce.interfaces.ElGamalPublicKey;

/* JADX INFO: loaded from: classes7.dex */
public class d {
    public static np.c a(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof ElGamalPrivateKey) {
            ElGamalPrivateKey elGamalPrivateKey = (ElGamalPrivateKey) privateKey;
            return new w0(elGamalPrivateKey.getX(), new v0(elGamalPrivateKey.b().b(), elGamalPrivateKey.b().a()));
        }
        if (!(privateKey instanceof DHPrivateKey)) {
            throw new InvalidKeyException("can't identify private key for El Gamal.");
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey) privateKey;
        return new w0(dHPrivateKey.getX(), new v0(dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG()));
    }

    public static np.c b(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof ElGamalPublicKey) {
            ElGamalPublicKey elGamalPublicKey = (ElGamalPublicKey) publicKey;
            return new x0(elGamalPublicKey.getY(), new v0(elGamalPublicKey.b().b(), elGamalPublicKey.b().a()));
        }
        if (!(publicKey instanceof DHPublicKey)) {
            throw new InvalidKeyException("can't identify public key for El Gamal.");
        }
        DHPublicKey dHPublicKey = (DHPublicKey) publicKey;
        return new x0(dHPublicKey.getY(), new v0(dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG()));
    }
}
