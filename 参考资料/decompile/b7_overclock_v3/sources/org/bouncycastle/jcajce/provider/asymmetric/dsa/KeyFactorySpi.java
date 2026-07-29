package org.bouncycastle.jcajce.provider.asymmetric.dsa;

import cr.o;
import cr.p;
import gm.y;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import np.a0;
import np.b0;
import np.z;
import org.bouncycastle.crypto.util.g;
import org.bouncycastle.crypto.util.h;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class KeyFactorySpi extends org.bouncycastle.jcajce.provider.asymmetric.util.c {
    @Override // br.c
    public PublicKey a(c1 c1Var) throws IOException {
        y yVarX = c1Var.x().x();
        if (d.d(yVarX)) {
            return new BCDSAPublicKey(c1Var);
        }
        throw new IOException("algorithm identifier " + yVarX + " in key not recognised");
    }

    @Override // br.c
    public PrivateKey b(u uVar) throws IOException {
        y yVarX = uVar.B().x();
        if (d.d(yVarX)) {
            return new BCDSAPrivateKey(uVar);
        }
        throw new IOException("algorithm identifier " + yVarX + " in key not recognised");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof DSAPrivateKeySpec) {
            return new BCDSAPrivateKey((DSAPrivateKeySpec) keySpec);
        }
        if (!(keySpec instanceof o)) {
            return super.engineGeneratePrivate(keySpec);
        }
        np.c cVarC = g.c(((o) keySpec).getEncoded());
        if (!(cVarC instanceof a0)) {
            throw new IllegalArgumentException("openssh private key is not dsa privare key");
        }
        a0 a0Var = (a0) cVarC;
        return engineGeneratePrivate(new DSAPrivateKeySpec(a0Var.e(), a0Var.d().b(), a0Var.d().c(), a0Var.d().a()));
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof DSAPublicKeySpec) {
            try {
                return new BCDSAPublicKey((DSAPublicKeySpec) keySpec);
            } catch (Exception e10) {
                throw new InvalidKeySpecException("invalid KeySpec: " + e10.getMessage()) { // from class: org.bouncycastle.jcajce.provider.asymmetric.dsa.KeyFactorySpi.1
                    @Override // java.lang.Throwable
                    public Throwable getCause() {
                        return e10;
                    }
                };
            }
        }
        if (!(keySpec instanceof p)) {
            return super.engineGeneratePublic(keySpec);
        }
        np.c cVarC = h.c(((p) keySpec).getEncoded());
        if (!(cVarC instanceof b0)) {
            throw new IllegalArgumentException("openssh public key is not dsa public key");
        }
        b0 b0Var = (b0) cVarC;
        return engineGeneratePublic(new DSAPublicKeySpec(b0Var.e(), b0Var.d().b(), b0Var.d().c(), b0Var.d().a()));
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(DSAPublicKeySpec.class) && (key instanceof DSAPublicKey)) {
            DSAPublicKey dSAPublicKey = (DSAPublicKey) key;
            return new DSAPublicKeySpec(dSAPublicKey.getY(), dSAPublicKey.getParams().getP(), dSAPublicKey.getParams().getQ(), dSAPublicKey.getParams().getG());
        }
        if (cls.isAssignableFrom(DSAPrivateKeySpec.class) && (key instanceof DSAPrivateKey)) {
            DSAPrivateKey dSAPrivateKey = (DSAPrivateKey) key;
            return new DSAPrivateKeySpec(dSAPrivateKey.getX(), dSAPrivateKey.getParams().getP(), dSAPrivateKey.getParams().getQ(), dSAPrivateKey.getParams().getG());
        }
        if (cls.isAssignableFrom(p.class) && (key instanceof DSAPublicKey)) {
            DSAPublicKey dSAPublicKey2 = (DSAPublicKey) key;
            try {
                return new p(h.a(new b0(dSAPublicKey2.getY(), new z(dSAPublicKey2.getParams().getP(), dSAPublicKey2.getParams().getQ(), dSAPublicKey2.getParams().getG()))));
            } catch (IOException e10) {
                throw new IllegalArgumentException("unable to produce encoding: " + e10.getMessage());
            }
        }
        if (!cls.isAssignableFrom(o.class) || !(key instanceof DSAPrivateKey)) {
            return super.engineGetKeySpec(key, cls);
        }
        DSAPrivateKey dSAPrivateKey2 = (DSAPrivateKey) key;
        try {
            return new o(g.b(new a0(dSAPrivateKey2.getX(), new z(dSAPrivateKey2.getParams().getP(), dSAPrivateKey2.getParams().getQ(), dSAPrivateKey2.getParams().getG()))));
        } catch (IOException e11) {
            throw new IllegalArgumentException("unable to produce encoding: " + e11.getMessage());
        }
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key instanceof DSAPublicKey) {
            return new BCDSAPublicKey((DSAPublicKey) key);
        }
        if (key instanceof DSAPrivateKey) {
            return new BCDSAPrivateKey((DSAPrivateKey) key);
        }
        throw new InvalidKeyException("key type unknown");
    }
}
