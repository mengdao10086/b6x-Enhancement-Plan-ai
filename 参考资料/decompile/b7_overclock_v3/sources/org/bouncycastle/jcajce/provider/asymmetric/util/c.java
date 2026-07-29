package org.bouncycastle.jcajce.provider.asymmetric.util;

import com.blankj.utilcode.util.i0;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public abstract class c extends KeyFactorySpi implements br.c {
    @Override // java.security.KeyFactorySpi
    public PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof PKCS8EncodedKeySpec)) {
            throw new InvalidKeySpecException("key spec not recognized");
        }
        try {
            return b(u.z(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
        } catch (Exception e10) {
            throw new InvalidKeySpecException("encoded key spec not recognized: " + e10.getMessage());
        }
    }

    @Override // java.security.KeyFactorySpi
    public PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof X509EncodedKeySpec)) {
            throw new InvalidKeySpecException("key spec not recognized");
        }
        try {
            return a(c1.A(((X509EncodedKeySpec) keySpec).getEncoded()));
        } catch (Exception e10) {
            throw new InvalidKeySpecException("encoded key spec not recognized: " + e10.getMessage());
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
}
