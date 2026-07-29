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
import ms.q;
import ms.r;
import org.bouncycastle.crypto.s;
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcEliecePrivateKey;
import org.bouncycastle.pqc.jcajce.provider.mceliece.BCMcEliecePublicKey;
import pn.u;
import zn.c1;
import zo.e0;

/* JADX INFO: loaded from: classes6.dex */
public class f extends KeyFactorySpi implements br.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f56118a = "1.3.6.1.4.1.8301.3.1.3.4.1";

    public static s c(zn.b bVar) {
        return new e0();
    }

    @Override // br.c
    public PublicKey a(c1 c1Var) throws IOException {
        is.f fVarY = is.f.y(c1Var.D());
        return new BCMcEliecePublicKey(new r(fVarY.z(), fVarY.A(), fVarY.x()));
    }

    @Override // br.c
    public PrivateKey b(u uVar) throws IOException {
        is.e eVarZ = is.e.z(uVar.G().b());
        return new BCMcEliecePrivateKey(new q(eVarZ.B(), eVarZ.A(), eVarZ.x(), eVarZ.y(), eVarZ.C(), eVarZ.D(), eVarZ.E()));
    }

    public KeySpec d(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof BCMcEliecePrivateKey) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
        } else {
            if (!(key instanceof BCMcEliecePublicKey)) {
                throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + j3.b.f36044h);
            }
            if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new X509EncodedKeySpec(key.getEncoded());
            }
        }
        throw new InvalidKeySpecException("Unknown key specification: " + cls + j3.b.f36044h);
    }

    public Key e(Key key) throws InvalidKeyException {
        if ((key instanceof BCMcEliecePrivateKey) || (key instanceof BCMcEliecePublicKey)) {
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
                if (!is.g.f35786m.C(uVarZ.B().x())) {
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");
                }
                is.e eVarZ = is.e.z(uVarZ.G());
                return new BCMcEliecePrivateKey(new q(eVarZ.B(), eVarZ.A(), eVarZ.x(), eVarZ.y(), eVarZ.C(), eVarZ.D(), eVarZ.E()));
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
                if (!is.g.f35786m.C(c1VarA.x().x())) {
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");
                }
                is.f fVarY = is.f.y(c1VarA.D());
                return new BCMcEliecePublicKey(new r(fVarY.z(), fVarY.A(), fVarY.x()));
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
