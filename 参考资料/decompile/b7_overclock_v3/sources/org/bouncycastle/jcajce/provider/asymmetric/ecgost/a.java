package org.bouncycastle.jcajce.provider.asymmetric.ecgost;

import gm.y;
import gr.e;
import gr.f;
import gr.g;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import org.bouncycastle.jcajce.provider.asymmetric.util.h;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class a extends org.bouncycastle.jcajce.provider.asymmetric.util.c {
    @Override // br.c
    public PublicKey a(c1 c1Var) throws IOException {
        y yVarX = c1Var.x().x();
        if (!yVarX.C(qm.a.f47463m) && !yVarX.C(qm.a.F) && !yVarX.C(qm.a.E)) {
            throw new IOException("algorithm identifier " + yVarX + " in key not recognised");
        }
        return new BCECGOST3410PublicKey(c1Var);
    }

    @Override // br.c
    public PrivateKey b(u uVar) throws IOException {
        y yVarX = uVar.B().x();
        if (!yVarX.C(qm.a.f47463m) && !yVarX.C(qm.a.F) && !yVarX.C(qm.a.E)) {
            throw new IOException("algorithm identifier " + yVarX + " in key not recognised");
        }
        return new BCECGOST3410PrivateKey(uVar);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        return keySpec instanceof f ? new BCECGOST3410PrivateKey((f) keySpec) : keySpec instanceof ECPrivateKeySpec ? new BCECGOST3410PrivateKey((ECPrivateKeySpec) keySpec) : super.engineGeneratePrivate(keySpec);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        return keySpec instanceof g ? new BCECGOST3410PublicKey((g) keySpec, BouncyCastleProvider.f45330c) : keySpec instanceof ECPublicKeySpec ? new BCECGOST3410PublicKey((ECPublicKeySpec) keySpec) : super.engineGeneratePublic(keySpec);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(ECPublicKeySpec.class) && (key instanceof ECPublicKey)) {
            ECPublicKey eCPublicKey = (ECPublicKey) key;
            if (eCPublicKey.getParams() != null) {
                return new ECPublicKeySpec(eCPublicKey.getW(), eCPublicKey.getParams());
            }
            e eVarB = BouncyCastleProvider.f45330c.b();
            return new ECPublicKeySpec(eCPublicKey.getW(), h.h(h.b(eVarB.a(), eVarB.e()), eVarB));
        }
        if (cls.isAssignableFrom(ECPrivateKeySpec.class) && (key instanceof ECPrivateKey)) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) key;
            if (eCPrivateKey.getParams() != null) {
                return new ECPrivateKeySpec(eCPrivateKey.getS(), eCPrivateKey.getParams());
            }
            e eVarB2 = BouncyCastleProvider.f45330c.b();
            return new ECPrivateKeySpec(eCPrivateKey.getS(), h.h(h.b(eVarB2.a(), eVarB2.e()), eVarB2));
        }
        if (cls.isAssignableFrom(g.class) && (key instanceof ECPublicKey)) {
            ECPublicKey eCPublicKey2 = (ECPublicKey) key;
            if (eCPublicKey2.getParams() != null) {
                return new g(h.e(eCPublicKey2.getParams(), eCPublicKey2.getW()), h.g(eCPublicKey2.getParams()));
            }
            return new g(h.e(eCPublicKey2.getParams(), eCPublicKey2.getW()), BouncyCastleProvider.f45330c.b());
        }
        if (!cls.isAssignableFrom(f.class) || !(key instanceof ECPrivateKey)) {
            return super.engineGetKeySpec(key, cls);
        }
        ECPrivateKey eCPrivateKey2 = (ECPrivateKey) key;
        if (eCPrivateKey2.getParams() != null) {
            return new f(eCPrivateKey2.getS(), h.g(eCPrivateKey2.getParams()));
        }
        return new f(eCPrivateKey2.getS(), BouncyCastleProvider.f45330c.b());
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        throw new InvalidKeyException("key type unknown");
    }
}
