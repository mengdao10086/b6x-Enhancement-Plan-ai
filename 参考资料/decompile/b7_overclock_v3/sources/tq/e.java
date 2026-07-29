package tq;

import cr.o;
import cr.p;
import gm.y;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import np.e2;
import np.f2;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateCrtKey;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPublicKey;
import org.bouncycastle.jcajce.provider.asymmetric.util.ExtendedInvalidKeySpecException;
import pn.u;
import pn.x;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class e extends org.bouncycastle.jcajce.provider.asymmetric.util.c {
    @Override // br.c
    public PublicKey a(c1 c1Var) throws IOException {
        y yVarX = c1Var.x().x();
        if (h.e(yVarX)) {
            return new BCRSAPublicKey(c1Var);
        }
        throw new IOException("algorithm identifier " + yVarX + " in key not recognised");
    }

    @Override // br.c
    public PrivateKey b(u uVar) throws IOException {
        y yVarX = uVar.B().x();
        if (h.e(yVarX)) {
            x xVarB = x.B(uVar.G());
            return xVarB.x().intValue() == 0 ? new BCRSAPrivateKey(uVar.B(), xVarB) : new BCRSAPrivateCrtKey(uVar);
        }
        throw new IOException("algorithm identifier " + yVarX + " in key not recognised");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return b(u.z(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
            } catch (Exception e10) {
                try {
                    return new BCRSAPrivateCrtKey(x.B(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
                } catch (Exception unused) {
                    throw new ExtendedInvalidKeySpecException("unable to process key spec: " + e10.toString(), e10);
                }
            }
        }
        if (keySpec instanceof RSAPrivateCrtKeySpec) {
            return new BCRSAPrivateCrtKey((RSAPrivateCrtKeySpec) keySpec);
        }
        if (keySpec instanceof RSAPrivateKeySpec) {
            return new BCRSAPrivateKey((RSAPrivateKeySpec) keySpec);
        }
        if (keySpec instanceof o) {
            np.c cVarC = org.bouncycastle.crypto.util.g.c(((o) keySpec).getEncoded());
            if (cVarC instanceof f2) {
                return new BCRSAPrivateCrtKey((f2) cVarC);
            }
            throw new InvalidKeySpecException("open SSH public key is not RSA private key");
        }
        throw new InvalidKeySpecException("unknown KeySpec type: " + keySpec.getClass().getName());
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof RSAPublicKeySpec) {
            return new BCRSAPublicKey((RSAPublicKeySpec) keySpec);
        }
        if (!(keySpec instanceof p)) {
            return super.engineGeneratePublic(keySpec);
        }
        np.c cVarC = org.bouncycastle.crypto.util.h.c(((p) keySpec).getEncoded());
        if (cVarC instanceof e2) {
            return new BCRSAPublicKey((e2) cVarC);
        }
        throw new InvalidKeySpecException("Open SSH public key is not RSA public key");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if ((cls.isAssignableFrom(KeySpec.class) || cls.isAssignableFrom(RSAPublicKeySpec.class)) && (key instanceof RSAPublicKey)) {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) key;
            return new RSAPublicKeySpec(rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
        }
        if ((cls.isAssignableFrom(KeySpec.class) || cls.isAssignableFrom(RSAPrivateCrtKeySpec.class)) && (key instanceof RSAPrivateCrtKey)) {
            RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) key;
            return new RSAPrivateCrtKeySpec(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent(), rSAPrivateCrtKey.getPrivateExponent(), rSAPrivateCrtKey.getPrimeP(), rSAPrivateCrtKey.getPrimeQ(), rSAPrivateCrtKey.getPrimeExponentP(), rSAPrivateCrtKey.getPrimeExponentQ(), rSAPrivateCrtKey.getCrtCoefficient());
        }
        if ((cls.isAssignableFrom(KeySpec.class) || cls.isAssignableFrom(RSAPrivateKeySpec.class)) && (key instanceof RSAPrivateKey)) {
            RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) key;
            return new RSAPrivateKeySpec(rSAPrivateKey.getModulus(), rSAPrivateKey.getPrivateExponent());
        }
        if (cls.isAssignableFrom(p.class) && (key instanceof RSAPublicKey)) {
            try {
                return new p(org.bouncycastle.crypto.util.h.a(new e2(false, ((RSAPublicKey) key).getModulus(), ((RSAPublicKey) key).getPublicExponent())));
            } catch (IOException e10) {
                throw new IllegalArgumentException("unable to produce encoding: " + e10.getMessage());
            }
        }
        if (!cls.isAssignableFrom(o.class) || !(key instanceof RSAPrivateCrtKey)) {
            return super.engineGetKeySpec(key, cls);
        }
        try {
            return new o(org.bouncycastle.crypto.util.g.b(new f2(((RSAPrivateCrtKey) key).getModulus(), ((RSAPrivateCrtKey) key).getPublicExponent(), ((RSAPrivateCrtKey) key).getPrivateExponent(), ((RSAPrivateCrtKey) key).getPrimeP(), ((RSAPrivateCrtKey) key).getPrimeQ(), ((RSAPrivateCrtKey) key).getPrimeExponentP(), ((RSAPrivateCrtKey) key).getPrimeExponentQ(), ((RSAPrivateCrtKey) key).getCrtCoefficient())));
        } catch (IOException e11) {
            throw new IllegalArgumentException("unable to produce encoding: " + e11.getMessage());
        }
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key instanceof RSAPublicKey) {
            return new BCRSAPublicKey((RSAPublicKey) key);
        }
        if (key instanceof RSAPrivateCrtKey) {
            return new BCRSAPrivateCrtKey((RSAPrivateCrtKey) key);
        }
        if (key instanceof RSAPrivateKey) {
            return new BCRSAPrivateKey((RSAPrivateKey) key);
        }
        throw new InvalidKeyException("key type unknown");
    }
}
