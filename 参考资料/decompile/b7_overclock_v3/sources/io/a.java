package io;

import co.r;
import gm.c0;
import gm.d2;
import gm.u;
import gm.y;
import gm.z;
import java.io.IOException;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import org.bouncycastle.cert.crmf.CRMFException;
import pn.s;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f32584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f32585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f32586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map f32587e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map f32588f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.jcajce.util.d f32589a;

    /* JADX INFO: renamed from: io.a$a, reason: collision with other inner class name */
    public class C0380a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f32590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Key f32591b;

        public C0380a(zn.b bVar, Key key) {
            this.f32590a = bVar;
            this.f32591b = key;
        }

        @Override // io.a.b
        public Object a() throws CRMFException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidParameterSpecException, InvalidKeyException, NoSuchProviderException, InvalidAlgorithmParameterException {
            Cipher cipherC = a.this.c(this.f32590a.x());
            c0 c0Var = (c0) this.f32590a.A();
            y yVarX = this.f32590a.x();
            if (c0Var != null && !(c0Var instanceof u)) {
                try {
                    AlgorithmParameters algorithmParametersB = a.this.b(this.f32590a.x());
                    try {
                        org.bouncycastle.jcajce.util.a.b(algorithmParametersB, c0Var);
                        cipherC.init(2, this.f32591b, algorithmParametersB);
                    } catch (IOException e10) {
                        throw new CRMFException("error decoding algorithm parameters.", e10);
                    }
                } catch (NoSuchAlgorithmException e11) {
                    if (!yVarX.C(so.c.f50085b) && !yVarX.C(so.c.f50089d) && !yVarX.C(so.c.f50093f) && !yVarX.C(so.c.f50095g) && !yVarX.C(so.c.f50097h)) {
                        throw e11;
                    }
                    cipherC.init(2, this.f32591b, new IvParameterSpec(z.I(c0Var).J()));
                }
            } else if (yVarX.C(so.c.f50085b) || yVarX.C(so.c.f50089d) || yVarX.C(so.c.f50091e)) {
                cipherC.init(2, this.f32591b, new IvParameterSpec(new byte[8]));
            } else {
                cipherC.init(2, this.f32591b);
            }
            return cipherC;
        }
    }

    public interface b {
        Object a() throws CRMFException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidParameterSpecException, InvalidKeyException, NoSuchProviderException, InvalidAlgorithmParameterException;
    }

    static {
        HashMap map = new HashMap();
        f32584b = map;
        HashMap map2 = new HashMap();
        f32585c = map2;
        HashMap map3 = new HashMap();
        f32586d = map3;
        HashMap map4 = new HashMap();
        f32587e = map4;
        HashMap map5 = new HashMap();
        f32588f = map5;
        map.put(s.Z3, "DESEDE");
        map.put(kn.d.f37625y, m5.b.f40641c);
        map.put(kn.d.G, m5.b.f40641c);
        map.put(kn.d.O, m5.b.f40641c);
        map2.put(so.c.f50085b, "DESEDE/CBC/PKCS5Padding");
        map2.put(so.c.f50093f, m5.b.f40640b);
        map2.put(so.c.f50095g, m5.b.f40640b);
        map2.put(so.c.f50097h, m5.b.f40640b);
        y yVar = s.f46854x3;
        map2.put(new y(yVar.L()), "RSA/ECB/PKCS1Padding");
        map3.put(on.b.f44365i, "SHA1");
        map3.put(kn.d.f37598f, "SHA224");
        map3.put(kn.d.f37592c, "SHA256");
        map3.put(kn.d.f37594d, "SHA384");
        map3.put(kn.d.f37596e, "SHA512");
        map5.put(zm.a.f58655o, "HMACSHA1");
        map5.put(s.f46806g4, "HMACSHA1");
        map5.put(s.f46809h4, "HMACSHA224");
        map5.put(s.f46812i4, "HMACSHA256");
        map5.put(s.f46815j4, "HMACSHA384");
        map5.put(s.f46818k4, "HMACSHA512");
        map4.put(yVar, "RSA");
        map4.put(r.W0, "DSA");
    }

    public a(org.bouncycastle.jcajce.util.d dVar) {
        this.f32589a = dVar;
    }

    public static Object i(b bVar) throws CRMFException {
        try {
            return bVar.a();
        } catch (InvalidAlgorithmParameterException e10) {
            throw new CRMFException("algorithm parameters invalid.", e10);
        } catch (InvalidKeyException e11) {
            throw new CRMFException("key invalid in message.", e11);
        } catch (NoSuchAlgorithmException e12) {
            throw new CRMFException("can't find algorithm.", e12);
        } catch (NoSuchProviderException e13) {
            throw new CRMFException("can't find provider.", e13);
        } catch (InvalidParameterSpecException e14) {
            throw new CRMFException("MAC algorithm parameter spec invalid.", e14);
        } catch (NoSuchPaddingException e15) {
            throw new CRMFException("required padding not supported.", e15);
        }
    }

    public AlgorithmParameterGenerator a(y yVar) throws GeneralSecurityException {
        String str = (String) f32584b.get(yVar);
        if (str != null) {
            try {
                return this.f32589a.q(str);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return this.f32589a.q(yVar.L());
    }

    public AlgorithmParameters b(y yVar) throws NoSuchAlgorithmException, NoSuchProviderException {
        String str = (String) f32584b.get(yVar);
        if (str != null) {
            try {
                return this.f32589a.t(str);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return this.f32589a.t(yVar.L());
    }

    public Cipher c(y yVar) throws CRMFException {
        try {
            String str = (String) f32585c.get(yVar);
            if (str != null) {
                try {
                    return this.f32589a.i(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f32589a.i(yVar.L());
        } catch (GeneralSecurityException e10) {
            throw new CRMFException("cannot create cipher: " + e10.getMessage(), e10);
        }
    }

    public Cipher d(Key key, zn.b bVar) throws CRMFException {
        return (Cipher) i(new C0380a(bVar, key));
    }

    public MessageDigest e(y yVar) throws CRMFException {
        try {
            String str = (String) f32586d.get(yVar);
            if (str != null) {
                try {
                    return this.f32589a.g(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f32589a.g(yVar.L());
        } catch (GeneralSecurityException e10) {
            throw new CRMFException("cannot create cipher: " + e10.getMessage(), e10);
        }
    }

    public KeyFactory f(y yVar) throws CRMFException {
        try {
            String str = (String) f32587e.get(yVar);
            if (str != null) {
                try {
                    return this.f32589a.b(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f32589a.b(yVar.L());
        } catch (GeneralSecurityException e10) {
            throw new CRMFException("cannot create cipher: " + e10.getMessage(), e10);
        }
    }

    public KeyGenerator g(y yVar) throws CRMFException {
        try {
            String str = (String) f32584b.get(yVar);
            if (str != null) {
                try {
                    return this.f32589a.h(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f32589a.h(yVar.L());
        } catch (GeneralSecurityException e10) {
            throw new CRMFException("cannot create key generator: " + e10.getMessage(), e10);
        }
    }

    public Mac h(y yVar) throws CRMFException {
        try {
            String str = (String) f32588f.get(yVar);
            if (str != null) {
                try {
                    return this.f32589a.n(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f32589a.n(yVar.L());
        } catch (GeneralSecurityException e10) {
            throw new CRMFException("cannot create mac: " + e10.getMessage(), e10);
        }
    }

    public AlgorithmParameters j(y yVar, SecretKey secretKey, SecureRandom secureRandom) throws CRMFException {
        try {
            AlgorithmParameterGenerator algorithmParameterGeneratorA = a(yVar);
            if (yVar.C(so.c.f50087c)) {
                byte[] bArr = new byte[8];
                secureRandom.nextBytes(bArr);
                try {
                    algorithmParameterGeneratorA.init(new RC2ParameterSpec(secretKey.getEncoded().length * 8, bArr), secureRandom);
                } catch (InvalidAlgorithmParameterException e10) {
                    throw new CRMFException("parameters generation error: " + e10, e10);
                }
            }
            return algorithmParameterGeneratorA.generateParameters();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        } catch (GeneralSecurityException e11) {
            throw new CRMFException("exception creating algorithm parameter generator: " + e11, e11);
        }
    }

    public zn.b k(y yVar, AlgorithmParameters algorithmParameters) throws CRMFException {
        gm.h hVarA;
        if (algorithmParameters != null) {
            try {
                hVarA = org.bouncycastle.jcajce.util.a.a(algorithmParameters);
            } catch (IOException e10) {
                throw new CRMFException("cannot encode parameters: " + e10.getMessage(), e10);
            }
        } else {
            hVarA = d2.f29657b;
        }
        return new zn.b(yVar, hVarA);
    }

    public PublicKey l(c1 c1Var) throws CRMFException {
        try {
            return f(c1Var.x().x()).generatePublic(new X509EncodedKeySpec(c1Var.getEncoded()));
        } catch (Exception e10) {
            throw new CRMFException("invalid key: " + e10.getMessage(), e10);
        }
    }
}
