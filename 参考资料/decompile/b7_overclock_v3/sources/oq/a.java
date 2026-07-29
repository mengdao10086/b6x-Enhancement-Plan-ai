package oq;

import gm.y;
import gr.e;
import gr.f;
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
import org.bouncycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PublicKey;
import org.bouncycastle.jcajce.provider.asymmetric.util.h;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pn.u;
import vn.g;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class a extends org.bouncycastle.jcajce.provider.asymmetric.util.c {
    @Override // br.c
    public PublicKey a(c1 c1Var) throws IOException {
        y yVarX = c1Var.x().x();
        if (yVarX.C(g.f53268b) || yVarX.C(g.f53269c)) {
            return new BCDSTU4145PublicKey(c1Var);
        }
        throw new IOException("algorithm identifier " + yVarX + " in key not recognised");
    }

    @Override // br.c
    public PrivateKey b(u uVar) throws IOException {
        y yVarX = uVar.B().x();
        if (yVarX.C(g.f53268b) || yVarX.C(g.f53269c)) {
            return new BCDSTU4145PrivateKey(uVar);
        }
        throw new IOException("algorithm identifier " + yVarX + " in key not recognised");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        return keySpec instanceof f ? new BCDSTU4145PrivateKey((f) keySpec) : keySpec instanceof ECPrivateKeySpec ? new BCDSTU4145PrivateKey((ECPrivateKeySpec) keySpec) : super.engineGeneratePrivate(keySpec);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        return keySpec instanceof gr.g ? new BCDSTU4145PublicKey((gr.g) keySpec, BouncyCastleProvider.f45330c) : keySpec instanceof ECPublicKeySpec ? new BCDSTU4145PublicKey((ECPublicKeySpec) keySpec) : super.engineGeneratePublic(keySpec);
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
        if (cls.isAssignableFrom(gr.g.class) && (key instanceof ECPublicKey)) {
            ECPublicKey eCPublicKey2 = (ECPublicKey) key;
            if (eCPublicKey2.getParams() != null) {
                return new gr.g(h.e(eCPublicKey2.getParams(), eCPublicKey2.getW()), h.g(eCPublicKey2.getParams()));
            }
            return new gr.g(h.e(eCPublicKey2.getParams(), eCPublicKey2.getW()), BouncyCastleProvider.f45330c.b());
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
