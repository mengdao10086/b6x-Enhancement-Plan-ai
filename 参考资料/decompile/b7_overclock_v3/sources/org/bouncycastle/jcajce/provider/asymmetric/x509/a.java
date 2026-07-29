package org.bouncycastle.jcajce.provider.asymmetric.x509;

import com.blankj.utilcode.util.i0;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class a extends KeyFactorySpi {
    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof PKCS8EncodedKeySpec)) {
            throw new InvalidKeySpecException("Unknown KeySpec type: " + keySpec.getClass().getName());
        }
        try {
            u uVarZ = u.z(((PKCS8EncodedKeySpec) keySpec).getEncoded());
            PrivateKey privateKeyO = BouncyCastleProvider.o(uVarZ);
            if (privateKeyO != null) {
                return privateKeyO;
            }
            throw new InvalidKeySpecException("no factory found for OID: " + uVarZ.B().x());
        } catch (Exception e10) {
            throw new InvalidKeySpecException(e10.toString());
        }
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof X509EncodedKeySpec)) {
            throw new InvalidKeySpecException("Unknown KeySpec type: " + keySpec.getClass().getName());
        }
        try {
            c1 c1VarA = c1.A(((X509EncodedKeySpec) keySpec).getEncoded());
            PublicKey publicKeyP = BouncyCastleProvider.p(c1VarA);
            if (publicKeyP != null) {
                return publicKeyP;
            }
            throw new InvalidKeySpecException("no factory found for OID: " + c1VarA.x().x());
        } catch (Exception e10) {
            throw new InvalidKeySpecException(e10.toString());
        }
    }

    @Override // java.security.KeyFactorySpi
    public KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (cls.isAssignableFrom(PKCS8EncodedKeySpec.class) && key.getFormat().equals("PKCS#8")) {
            return new PKCS8EncodedKeySpec(key.getEncoded());
        }
        if (cls.isAssignableFrom(X509EncodedKeySpec.class) && key.getFormat().equals("X.509")) {
            return new X509EncodedKeySpec(key.getEncoded());
        }
        throw new InvalidKeySpecException("not implemented yet " + key + i0.f11861z + cls);
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        throw new InvalidKeyException("not implemented yet " + key);
    }
}
