package at;

import gm.c0;
import is.i;
import is.j;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.pqc.jcajce.provider.rainbow.BCRainbowPrivateKey;
import org.bouncycastle.pqc.jcajce.provider.rainbow.BCRainbowPublicKey;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class a extends KeyFactorySpi implements br.c {
    @Override // br.c
    public PublicKey a(c1 c1Var) throws IOException {
        j jVarB = j.B(c1Var.D());
        return new BCRainbowPublicKey(jVarB.A(), jVarB.x(), jVarB.z(), jVarB.y());
    }

    @Override // br.c
    public PrivateKey b(u uVar) throws IOException {
        i iVarZ = i.z(uVar.G());
        return new BCRainbowPrivateKey(iVarZ.A(), iVarZ.x(), iVarZ.B(), iVarZ.y(), iVarZ.E(), iVarZ.C());
    }

    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof et.i) {
            return new BCRainbowPrivateKey((et.i) keySpec);
        }
        if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return b(u.z(c0.D(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
            } catch (Exception e10) {
                throw new InvalidKeySpecException(e10.toString());
            }
        }
        throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + j3.b.f36044h);
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof et.j) {
            return new BCRainbowPublicKey((et.j) keySpec);
        }
        if (keySpec instanceof X509EncodedKeySpec) {
            try {
                return a(c1.A(((X509EncodedKeySpec) keySpec).getEncoded()));
            } catch (Exception e10) {
                throw new InvalidKeySpecException(e10.toString());
            }
        }
        throw new InvalidKeySpecException("Unknown key specification: " + keySpec + j3.b.f36044h);
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof BCRainbowPrivateKey) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
            if (et.i.class.isAssignableFrom(cls)) {
                BCRainbowPrivateKey bCRainbowPrivateKey = (BCRainbowPrivateKey) key;
                return new et.i(bCRainbowPrivateKey.c(), bCRainbowPrivateKey.a(), bCRainbowPrivateKey.d(), bCRainbowPrivateKey.b(), bCRainbowPrivateKey.h(), bCRainbowPrivateKey.f());
            }
        } else {
            if (!(key instanceof BCRainbowPublicKey)) {
                throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + j3.b.f36044h);
            }
            if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new X509EncodedKeySpec(key.getEncoded());
            }
            if (et.j.class.isAssignableFrom(cls)) {
                BCRainbowPublicKey bCRainbowPublicKey = (BCRainbowPublicKey) key;
                return new et.j(bCRainbowPublicKey.d(), bCRainbowPublicKey.a(), bCRainbowPublicKey.c(), bCRainbowPublicKey.b());
            }
        }
        throw new InvalidKeySpecException("Unknown key specification: " + cls + j3.b.f36044h);
    }

    @Override // java.security.KeyFactorySpi
    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        if ((key instanceof BCRainbowPrivateKey) || (key instanceof BCRainbowPublicKey)) {
            return key;
        }
        throw new InvalidKeyException("Unsupported key type");
    }
}
