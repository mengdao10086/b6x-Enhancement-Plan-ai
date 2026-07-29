package rq;

import gm.y;
import gr.o;
import gr.p;
import gr.q;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import org.bouncycastle.jcajce.provider.asymmetric.gost.BCGOST3410PrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.gost.BCGOST3410PublicKey;
import org.bouncycastle.jce.interfaces.GOST3410PrivateKey;
import org.bouncycastle.jce.interfaces.GOST3410PublicKey;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class d extends org.bouncycastle.jcajce.provider.asymmetric.util.c {
    @Override // br.c
    public PublicKey a(c1 c1Var) throws IOException {
        y yVarX = c1Var.x().x();
        if (yVarX.C(qm.a.f47462l)) {
            return new BCGOST3410PublicKey(c1Var);
        }
        throw new IOException("algorithm identifier " + yVarX + " in key not recognised");
    }

    @Override // br.c
    public PrivateKey b(u uVar) throws IOException {
        y yVarX = uVar.B().x();
        if (yVarX.C(qm.a.f47462l)) {
            return new BCGOST3410PrivateKey(uVar);
        }
        throw new IOException("algorithm identifier " + yVarX + " in key not recognised");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        return keySpec instanceof o ? new BCGOST3410PrivateKey((o) keySpec) : super.engineGeneratePrivate(keySpec);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        return keySpec instanceof q ? new BCGOST3410PublicKey((q) keySpec) : super.engineGeneratePublic(keySpec);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.c, java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(q.class) && (key instanceof GOST3410PublicKey)) {
            GOST3410PublicKey gOST3410PublicKey = (GOST3410PublicKey) key;
            p pVarA = gOST3410PublicKey.b().a();
            return new q(gOST3410PublicKey.getY(), pVarA.b(), pVarA.c(), pVarA.a());
        }
        if (!cls.isAssignableFrom(o.class) || !(key instanceof GOST3410PrivateKey)) {
            return super.engineGetKeySpec(key, cls);
        }
        GOST3410PrivateKey gOST3410PrivateKey = (GOST3410PrivateKey) key;
        p pVarA2 = gOST3410PrivateKey.b().a();
        return new o(gOST3410PrivateKey.getX(), pVarA2.b(), pVarA2.c(), pVarA2.a());
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (key instanceof GOST3410PublicKey) {
            return new BCGOST3410PublicKey((GOST3410PublicKey) key);
        }
        if (key instanceof GOST3410PrivateKey) {
            return new BCGOST3410PrivateKey((GOST3410PrivateKey) key);
        }
        throw new InvalidKeyException("key type unknown");
    }
}
