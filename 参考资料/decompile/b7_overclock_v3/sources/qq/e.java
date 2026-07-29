package qq;

import co.r;
import gm.y;
import gr.k;
import gr.l;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHPrivateKeySpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.jcajce.provider.asymmetric.elgamal.BCElGamalPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.elgamal.BCElGamalPublicKey;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import pn.s;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class e extends org.bouncycastle.jcajce.provider.asymmetric.util.c {
    @Override // br.c
    public PublicKey a(c1 c1Var) throws IOException {
        y yVarX = c1Var.x().x();
        if (!yVarX.C(s.O3) && !yVarX.C(r.f11161d1) && !yVarX.C(on.b.f44368l)) {
            throw new IOException("algorithm identifier " + yVarX + " in key not recognised");
        }
        return new BCElGamalPublicKey(c1Var);
    }

    @Override // br.c
    public PrivateKey b(u uVar) throws IOException {
        y yVarX = uVar.B().x();
        if (!yVarX.C(s.O3) && !yVarX.C(r.f11161d1) && !yVarX.C(on.b.f44368l)) {
            throw new IOException("algorithm identifier " + yVarX + " in key not recognised");
        }
        return new BCElGamalPrivateKey(uVar);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        return keySpec instanceof k ? new BCElGamalPrivateKey((k) keySpec) : keySpec instanceof DHPrivateKeySpec ? new BCElGamalPrivateKey((DHPrivateKeySpec) keySpec) : super.engineGeneratePrivate(keySpec);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        return keySpec instanceof l ? new BCElGamalPublicKey((l) keySpec) : keySpec instanceof DHPublicKeySpec ? new BCElGamalPublicKey((DHPublicKeySpec) keySpec) : super.engineGeneratePublic(keySpec);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(DHPrivateKeySpec.class) && (key instanceof DHPrivateKey)) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            return new DHPrivateKeySpec(dHPrivateKey.getX(), dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG());
        }
        if (!cls.isAssignableFrom(DHPublicKeySpec.class) || !(key instanceof DHPublicKey)) {
            return super.engineGetKeySpec(key, cls);
        }
        DHPublicKey dHPublicKey = (DHPublicKey) key;
        return new DHPublicKeySpec(dHPublicKey.getY(), dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG());
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key instanceof DHPublicKey) {
            return new BCElGamalPublicKey((DHPublicKey) key);
        }
        if (key instanceof DHPrivateKey) {
            return new BCElGamalPrivateKey((DHPrivateKey) key);
        }
        if (key instanceof ElGamalPublicKey) {
            return new BCElGamalPublicKey((ElGamalPublicKey) key);
        }
        if (key instanceof ElGamalPrivateKey) {
            return new BCElGamalPrivateKey((ElGamalPrivateKey) key);
        }
        throw new InvalidKeyException("key type unknown");
    }
}
