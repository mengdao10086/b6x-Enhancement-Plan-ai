package ar;

import gm.y;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactorySpi;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public class d extends SecretKeyFactorySpi implements org.bouncycastle.jcajce.provider.symmetric.util.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f8863b;

    public d(String str, y yVar) {
        this.f8862a = str;
        this.f8863b = yVar;
    }

    @Override // javax.crypto.SecretKeyFactorySpi
    public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof SecretKeySpec) {
            return new SecretKeySpec(((SecretKeySpec) keySpec).getEncoded(), this.f8862a);
        }
        throw new InvalidKeySpecException("Invalid KeySpec");
    }

    @Override // javax.crypto.SecretKeyFactorySpi
    public KeySpec engineGetKeySpec(SecretKey secretKey, Class cls) throws InvalidKeySpecException {
        if (cls == null) {
            throw new InvalidKeySpecException("keySpec parameter is null");
        }
        if (secretKey == null) {
            throw new InvalidKeySpecException("key parameter is null");
        }
        if (SecretKeySpec.class.isAssignableFrom(cls)) {
            return new SecretKeySpec(secretKey.getEncoded(), this.f8862a);
        }
        try {
            return (KeySpec) cls.getConstructor(byte[].class).newInstance(secretKey.getEncoded());
        } catch (Exception e10) {
            throw new InvalidKeySpecException(e10.toString());
        }
    }

    @Override // javax.crypto.SecretKeyFactorySpi
    public SecretKey engineTranslateKey(SecretKey secretKey) throws InvalidKeyException {
        if (secretKey == null) {
            throw new InvalidKeyException("key parameter is null");
        }
        if (secretKey.getAlgorithm().equalsIgnoreCase(this.f8862a)) {
            return new SecretKeySpec(secretKey.getEncoded(), this.f8862a);
        }
        throw new InvalidKeyException("Key not of type " + this.f8862a + j3.b.f36044h);
    }
}
