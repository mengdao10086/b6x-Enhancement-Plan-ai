package xs;

import gm.c0;
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
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcElieceCCA2PrivateKey;
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcElieceCCA2PublicKey;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class a extends KeyFactorySpi implements br.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f56113a = "1.3.6.1.4.1.8301.3.1.3.4.2";

    @Override // br.c
    public PublicKey a(c1 c1Var) throws IOException {
        is.d dVarZ = is.d.z(c1Var.D());
        return new BCMcElieceCCA2PublicKey(new ms.h(dVarZ.A(), dVarZ.B(), dVarZ.y(), l.b(dVarZ.x()).b()));
    }

    @Override // br.c
    public PrivateKey b(u uVar) throws IOException {
        is.c cVarA = is.c.A(uVar.G().b());
        return new BCMcElieceCCA2PrivateKey(new ms.g(cVarA.C(), cVarA.B(), cVarA.y(), cVarA.z(), cVarA.D(), null));
    }

    public KeySpec c(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof BCMcElieceCCA2PrivateKey) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
        } else {
            if (!(key instanceof BCMcElieceCCA2PublicKey)) {
                throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + j3.b.f36044h);
            }
            if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new X509EncodedKeySpec(key.getEncoded());
            }
        }
        throw new InvalidKeySpecException("Unknown key specification: " + cls + j3.b.f36044h);
    }

    public Key d(Key key) throws InvalidKeyException {
        if ((key instanceof BCMcElieceCCA2PrivateKey) || (key instanceof BCMcElieceCCA2PublicKey)) {
            return key;
        }
        throw new InvalidKeyException("Unsupported key type.");
    }

    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof PKCS8EncodedKeySpec)) {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + j3.b.f36044h);
        }
        try {
            u uVarZ = u.z(c0.D(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
            try {
                if (!is.g.f35787n.C(uVarZ.B().x())) {
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");
                }
                is.c cVarA = is.c.A(uVarZ.G());
                return new BCMcElieceCCA2PrivateKey(new ms.g(cVarA.C(), cVarA.B(), cVarA.y(), cVarA.z(), cVarA.D(), l.b(cVarA.x()).b()));
            } catch (IOException unused) {
                throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec.");
            }
        } catch (IOException e10) {
            throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec: " + e10);
        }
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof X509EncodedKeySpec)) {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + j3.b.f36044h);
        }
        try {
            c1 c1VarA = c1.A(c0.D(((X509EncodedKeySpec) keySpec).getEncoded()));
            try {
                if (!is.g.f35787n.C(c1VarA.x().x())) {
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");
                }
                is.d dVarZ = is.d.z(c1VarA.D());
                return new BCMcElieceCCA2PublicKey(new ms.h(dVarZ.A(), dVarZ.B(), dVarZ.y(), l.b(dVarZ.x()).b()));
            } catch (IOException e10) {
                throw new InvalidKeySpecException("Unable to decode X509EncodedKeySpec: " + e10.getMessage());
            }
        } catch (IOException e11) {
            throw new InvalidKeySpecException(e11.toString());
        }
    }

    @Override // java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        return null;
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        return null;
    }
}
