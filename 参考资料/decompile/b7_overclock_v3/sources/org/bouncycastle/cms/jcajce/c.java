package org.bouncycastle.cms.jcajce;

import gm.d2;
import gm.f2;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kg.c;
import org.bouncycastle.cms.CMSException;
import so.q1;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final cs.f0 f44516b = cs.k.f25889a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f44517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f44518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map f44519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map f44520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map f44521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final short[] f44522h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final short[] f44523i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f44524a;

    public class a implements InterfaceC0501c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f44525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Key f44526b;

        public a(zn.b bVar, Key key) {
            this.f44525a = bVar;
            this.f44526b = key;
        }

        @Override // org.bouncycastle.cms.jcajce.c.InterfaceC0501c
        public Object a() throws NoSuchPaddingException, CMSException, NoSuchAlgorithmException, InvalidParameterSpecException, InvalidKeyException, NoSuchProviderException, InvalidAlgorithmParameterException {
            Cipher cipherF = c.this.f(this.f44525a.x());
            gm.h hVarA = this.f44525a.A();
            String strL = this.f44525a.x().L();
            if (hVarA != null && !(hVarA instanceof gm.u)) {
                try {
                    AlgorithmParameters algorithmParametersC = c.this.c(this.f44525a.x());
                    org.bouncycastle.cms.jcajce.a.k(algorithmParametersC, hVarA);
                    cipherF.init(2, this.f44526b, algorithmParametersC);
                } catch (NoSuchAlgorithmException e10) {
                    if (!strL.equals(so.c.f50083a.L()) && !strL.equals(so.a0.f50035d) && !strL.equals(so.a0.f50037f) && !strL.equals(so.a0.f50039h) && !strL.equals(so.a0.f50040i) && !strL.equals(so.a0.f50041j)) {
                        throw e10;
                    }
                    cipherF.init(2, this.f44526b, new IvParameterSpec(gm.z.I(hVarA).J()));
                }
            } else if (strL.equals(so.c.f50083a.L()) || strL.equals(so.a0.f50035d) || strL.equals(so.a0.f50037f) || strL.equals(so.a0.f50038g)) {
                cipherF.init(2, this.f44526b, new IvParameterSpec(new byte[8]));
            } else {
                cipherF.init(2, this.f44526b);
            }
            return cipherF;
        }
    }

    public class b implements InterfaceC0501c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ zn.b f44528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Key f44529b;

        public b(zn.b bVar, Key key) {
            this.f44528a = bVar;
            this.f44529b = key;
        }

        @Override // org.bouncycastle.cms.jcajce.c.InterfaceC0501c
        public Object a() throws NoSuchPaddingException, CMSException, NoSuchAlgorithmException, InvalidParameterSpecException, InvalidKeyException, NoSuchProviderException, InvalidAlgorithmParameterException {
            Mac macM = c.this.m(this.f44528a.x());
            gm.h hVarA = this.f44528a.A();
            this.f44528a.x().L();
            if (hVarA == null || (hVarA instanceof gm.u)) {
                macM.init(this.f44529b);
            } else {
                try {
                    AlgorithmParameters algorithmParametersC = c.this.c(this.f44528a.x());
                    org.bouncycastle.cms.jcajce.a.k(algorithmParametersC, hVarA);
                    macM.init(this.f44529b, algorithmParametersC.getParameterSpec(AlgorithmParameterSpec.class));
                } catch (NoSuchAlgorithmException e10) {
                    throw e10;
                }
            }
            return macM;
        }
    }

    /* JADX INFO: renamed from: org.bouncycastle.cms.jcajce.c$c, reason: collision with other inner class name */
    public interface InterfaceC0501c {
        Object a() throws NoSuchPaddingException, CMSException, NoSuchAlgorithmException, InvalidParameterSpecException, InvalidKeyException, NoSuchProviderException, InvalidAlgorithmParameterException;
    }

    static {
        HashSet hashSet = new HashSet();
        f44517c = hashSet;
        HashMap map = new HashMap();
        f44518d = map;
        HashMap map2 = new HashMap();
        f44519e = map2;
        HashMap map3 = new HashMap();
        f44520f = map3;
        HashMap map4 = new HashMap();
        f44521g = map4;
        gm.y yVar = so.c.f50083a;
        map.put(yVar, "DES");
        gm.y yVar2 = so.c.f50085b;
        map.put(yVar2, "DESEDE");
        gm.y yVar3 = so.c.f50093f;
        map.put(yVar3, m5.b.f40641c);
        gm.y yVar4 = so.c.f50095g;
        map.put(yVar4, m5.b.f40641c);
        gm.y yVar5 = so.c.f50097h;
        map.put(yVar5, m5.b.f40641c);
        gm.y yVar6 = so.c.f50087c;
        map.put(yVar6, "RC2");
        gm.y yVar7 = so.c.f50091e;
        map.put(yVar7, "CAST5");
        gm.y yVar8 = so.c.f50108o;
        map.put(yVar8, "Camellia");
        gm.y yVar9 = so.c.f50109p;
        map.put(yVar9, "Camellia");
        gm.y yVar10 = so.c.f50110q;
        map.put(yVar10, "Camellia");
        gm.y yVar11 = so.c.f50112s;
        map.put(yVar11, "SEED");
        gm.y yVar12 = pn.s.f46791b4;
        map.put(yVar12, "RC4");
        map.put(qm.a.f47456f, "GOST28147");
        map2.put(yVar, "DES/CBC/PKCS5Padding");
        map2.put(yVar6, "RC2/CBC/PKCS5Padding");
        map2.put(yVar2, "DESEDE/CBC/PKCS5Padding");
        map2.put(yVar3, m5.b.f40640b);
        map2.put(yVar4, m5.b.f40640b);
        map2.put(yVar5, m5.b.f40640b);
        map2.put(pn.s.f46854x3, "RSA/ECB/PKCS1Padding");
        map2.put(yVar7, "CAST5/CBC/PKCS5Padding");
        map2.put(yVar8, "Camellia/CBC/PKCS5Padding");
        map2.put(yVar9, "Camellia/CBC/PKCS5Padding");
        map2.put(yVar10, "Camellia/CBC/PKCS5Padding");
        map2.put(yVar11, "SEED/CBC/PKCS5Padding");
        map2.put(yVar12, "RC4");
        map3.put(yVar2, "DESEDEMac");
        map3.put(yVar3, "AESMac");
        map3.put(yVar4, "AESMac");
        map3.put(yVar5, "AESMac");
        map3.put(yVar6, "RC2Mac");
        map4.put(q1.a.f50290c.a(), "PBKDF2WITHHMACSHA1");
        map4.put(q1.a.f50291d.a(), "PBKDF2WITHHMACSHA224");
        map4.put(q1.a.f50292e.a(), "PBKDF2WITHHMACSHA256");
        map4.put(q1.a.f50293f.a(), "PBKDF2WITHHMACSHA384");
        map4.put(q1.a.f50294g.a(), "PBKDF2WITHHMACSHA512");
        hashSet.add(kn.d.C);
        hashSet.add(kn.d.K);
        hashSet.add(kn.d.S);
        hashSet.add(kn.d.D);
        hashSet.add(kn.d.L);
        hashSet.add(kn.d.T);
        f44522h = new short[]{189, 86, 234, 242, 162, 241, 172, 42, 176, 147, 209, 156, 27, 51, 253, 208, 48, 4, 182, 220, 125, 223, 50, 75, 247, 203, 69, 155, 49, 187, 33, 90, 65, 159, 225, 217, 74, 77, 158, 218, 160, c.a.V4, 44, 195, 39, 95, c.a.Z4, 54, 62, 238, 251, 149, 26, 254, 206, 168, 52, 169, 19, 240, 166, 63, 216, 12, 120, 36, 175, 35, 82, 193, c.a.U4, 23, 245, c.a.T4, 144, 231, 232, 7, 184, 96, 72, 230, 30, 83, 243, 146, 164, 114, 140, 8, 21, 110, 134, 0, 132, 250, 244, 127, 138, 66, 25, 246, 219, 205, 20, 141, 80, 18, 186, 60, 6, 78, 236, 179, 53, 17, 161, 136, 142, 43, 148, 153, 183, 113, 116, 211, 228, 191, 58, 222, 150, 14, 188, 10, 237, 119, 252, 55, c.a.Y4, 3, 121, 137, 98, 198, 215, 192, 210, 124, c.a.X4, 139, 34, 163, 91, 5, 93, 2, 117, 213, 97, 227, 24, 143, 85, 81, 173, 31, 11, 94, 133, 229, 194, 87, 99, 202, 61, 108, 180, 197, 204, 112, 178, 145, 89, 13, 71, 32, 200, 79, 88, 224, 1, 226, 22, 56, 196, 111, 59, 15, c.a.S4, 70, 190, 126, 45, 123, 130, 249, 64, 181, 29, 115, 248, 235, 38, 199, 135, 151, 37, 84, 177, 40, 170, 152, 157, 165, 100, 109, 122, 212, 16, c.a.f37346a5, 68, 239, 73, 214, 174, 46, 221, 118, 92, 47, 167, 28, 201, 9, c.a.W4, 154, 131, 207, 41, 57, 185, 233, 76, 255, 67, 171};
        f44523i = new short[]{93, 190, 155, 139, 17, 153, 110, 77, 89, 243, 133, 166, 63, 183, 131, 197, 228, 115, c.a.Y4, 58, c.a.V4, 90, 192, 71, 160, 100, 52, 12, 241, 208, 82, 165, 185, 30, 150, 67, 65, 216, 212, 44, 219, 248, 7, 119, 42, 202, 235, 239, 16, 28, 22, 13, 56, 114, 47, 137, 193, 249, c.a.Z4, 196, 109, 174, 48, 61, 206, 32, 99, 254, 230, 26, 199, 184, 80, 232, 36, 23, 252, 37, 111, 187, c.a.X4, 163, 68, 83, 217, 162, 1, 171, 188, 182, 31, 152, 238, 154, 167, 45, 79, 158, 142, 172, 224, 198, 73, 70, 41, 244, 148, 138, 175, 225, 91, 195, 179, 123, 87, 209, 124, 156, 237, 135, 64, 140, 226, 203, 147, 20, 201, 97, 46, 229, 204, 246, 94, 168, 92, 214, 117, 141, 98, 149, 88, c.a.W4, 118, 161, 74, 181, 85, 9, 120, 51, 130, 215, 221, 121, 245, 27, 11, 222, 38, 33, 40, 116, 4, 151, 86, 223, 60, 240, 55, 57, 220, 255, 6, 164, 234, 66, 8, 218, 180, 113, 176, 207, 18, 122, 78, 250, 108, 29, 132, 0, 200, 127, 145, 69, 170, 43, 194, 177, 143, 213, 186, 242, 173, 25, 178, c.a.U4, 54, 247, 15, 10, 146, 125, 227, 157, 233, 144, 62, 35, 39, c.a.T4, 19, 236, c.a.f37346a5, 21, 189, 34, 191, 159, 126, 169, 81, 75, 76, 251, 2, 211, 112, 134, 49, 231, 59, 5, 3, 84, 96, 72, c.a.S4, 24, 210, 205, 95, 50, 136, 14, 53, 253};
    }

    public c(d dVar) {
        this.f44524a = dVar;
    }

    public static Object q(InterfaceC0501c interfaceC0501c) throws CMSException {
        try {
            return interfaceC0501c.a();
        } catch (InvalidAlgorithmParameterException e10) {
            throw new CMSException("algorithm parameters invalid.", e10);
        } catch (InvalidKeyException e11) {
            throw new CMSException("key invalid in message.", e11);
        } catch (NoSuchAlgorithmException e12) {
            throw new CMSException("can't find algorithm.", e12);
        } catch (NoSuchProviderException e13) {
            throw new CMSException("can't find provider.", e13);
        } catch (InvalidParameterSpecException e14) {
            throw new CMSException("MAC algorithm parameter spec invalid.", e14);
        } catch (NoSuchPaddingException e15) {
            throw new CMSException("required padding not supported.", e15);
        }
    }

    public byte[] a(int i10, char[] cArr, zn.b bVar, int i11) throws CMSException {
        d dVar;
        String str;
        pn.q qVarX = pn.q.x(bVar.A());
        try {
            if (i10 == 0) {
                dVar = this.f44524a;
                str = "PBKDF2with8BIT";
            } else {
                dVar = this.f44524a;
                str = (String) f44521g.get(qVarX.A());
            }
            return dVar.u(str).generateSecret(new PBEKeySpec(cArr, qVarX.B(), qVarX.y().intValue(), i11)).getEncoded();
        } catch (GeneralSecurityException e10) {
            throw new CMSException("Unable to calculate derived key from password: " + e10.getMessage(), e10);
        }
    }

    public AlgorithmParameterGenerator b(gm.y yVar) throws GeneralSecurityException {
        String str = (String) f44518d.get(yVar);
        if (str != null) {
            try {
                return this.f44524a.q(str);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return this.f44524a.q(yVar.L());
    }

    public AlgorithmParameters c(gm.y yVar) throws NoSuchAlgorithmException, NoSuchProviderException {
        String str = (String) f44518d.get(yVar);
        if (str != null) {
            try {
                return this.f44524a.t(str);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return this.f44524a.t(yVar.L());
    }

    public org.bouncycastle.operator.jcajce.e d(zn.b bVar, PrivateKey privateKey) {
        return this.f44524a.f(bVar, org.bouncycastle.cms.jcajce.a.a(privateKey));
    }

    public org.bouncycastle.operator.jcajce.i e(zn.b bVar, PrivateKey privateKey, byte[] bArr, byte[] bArr2) {
        return this.f44524a.m(bVar, org.bouncycastle.cms.jcajce.a.a(privateKey), bArr, bArr2);
    }

    public Cipher f(gm.y yVar) throws CMSException {
        try {
            String str = (String) f44519e.get(yVar);
            if (str != null) {
                try {
                    return this.f44524a.i(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f44524a.i(yVar.L());
        } catch (GeneralSecurityException e10) {
            throw new CMSException("cannot create cipher: " + e10.getMessage(), e10);
        }
    }

    public Cipher g(Key key, zn.b bVar) throws CMSException {
        return (Cipher) q(new a(bVar, key));
    }

    public Mac h(Key key, zn.b bVar) throws CMSException {
        return (Mac) q(new b(bVar, key));
    }

    public KeyAgreement i(gm.y yVar) throws CMSException {
        try {
            String str = (String) f44518d.get(yVar);
            if (str != null) {
                try {
                    return this.f44524a.k(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f44524a.k(yVar.L());
        } catch (GeneralSecurityException e10) {
            throw new CMSException("cannot create key agreement: " + e10.getMessage(), e10);
        }
    }

    public KeyFactory j(gm.y yVar) throws CMSException {
        try {
            String str = (String) f44518d.get(yVar);
            if (str != null) {
                try {
                    return this.f44524a.b(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f44524a.b(yVar.L());
        } catch (GeneralSecurityException e10) {
            throw new CMSException("cannot create key factory: " + e10.getMessage(), e10);
        }
    }

    public KeyGenerator k(gm.y yVar) throws CMSException {
        try {
            String str = (String) f44518d.get(yVar);
            if (str != null) {
                try {
                    return this.f44524a.h(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f44524a.h(yVar.L());
        } catch (GeneralSecurityException e10) {
            throw new CMSException("cannot create key generator: " + e10.getMessage(), e10);
        }
    }

    public KeyPairGenerator l(gm.y yVar) throws CMSException {
        try {
            String str = (String) f44518d.get(yVar);
            if (str != null) {
                try {
                    return this.f44524a.d(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f44524a.d(yVar.L());
        } catch (GeneralSecurityException e10) {
            throw new CMSException("cannot create key pair generator: " + e10.getMessage(), e10);
        }
    }

    public Mac m(gm.y yVar) throws CMSException {
        try {
            String str = (String) f44520f.get(yVar);
            if (str != null) {
                try {
                    return this.f44524a.n(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f44524a.n(yVar.L());
        } catch (GeneralSecurityException e10) {
            throw new CMSException("cannot create mac: " + e10.getMessage(), e10);
        }
    }

    public Cipher n(gm.y yVar) throws CMSException {
        String str = (String) f44518d.get(yVar);
        if (str == null) {
            throw new CMSException("no name for " + yVar);
        }
        try {
            return this.f44524a.i(str + "RFC3211Wrap");
        } catch (GeneralSecurityException e10) {
            throw new CMSException("cannot create cipher: " + e10.getMessage(), e10);
        }
    }

    public SecretKeyFactory o(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
        return this.f44524a.u(str);
    }

    public cs.h0 p(zn.b bVar, SecretKey secretKey) {
        return this.f44524a.o(bVar, secretKey);
    }

    public AlgorithmParameters r(gm.y yVar, SecretKey secretKey, SecureRandom secureRandom) throws CMSException {
        try {
            AlgorithmParameterGenerator algorithmParameterGeneratorB = b(yVar);
            if (yVar.C(so.c.f50087c)) {
                byte[] bArr = new byte[8];
                secureRandom.nextBytes(bArr);
                try {
                    algorithmParameterGeneratorB.init(new RC2ParameterSpec(secretKey.getEncoded().length * 8, bArr), secureRandom);
                } catch (InvalidAlgorithmParameterException e10) {
                    throw new CMSException("parameters generation error: " + e10, e10);
                }
            }
            return algorithmParameterGeneratorB.generateParameters();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        } catch (GeneralSecurityException e11) {
            throw new CMSException("exception creating algorithm parameter generator: " + e11, e11);
        }
    }

    public zn.b s(gm.y yVar, AlgorithmParameters algorithmParameters) throws CMSException {
        return new zn.b(yVar, algorithmParameters != null ? org.bouncycastle.cms.jcajce.a.d(algorithmParameters) : d2.f29657b);
    }

    public zn.b t(gm.y yVar, AlgorithmParameterSpec algorithmParameterSpec) {
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            return new zn.b(yVar, new f2(((IvParameterSpec) algorithmParameterSpec).getIV()));
        }
        if (!(algorithmParameterSpec instanceof RC2ParameterSpec)) {
            throw new IllegalStateException("unknown parameter spec: " + algorithmParameterSpec);
        }
        RC2ParameterSpec rC2ParameterSpec = (RC2ParameterSpec) algorithmParameterSpec;
        int effectiveKeyBits = rC2ParameterSpec.getEffectiveKeyBits();
        if (effectiveKeyBits == -1) {
            return new zn.b(yVar, new pn.v(rC2ParameterSpec.getIV()));
        }
        int i10 = effectiveKeyBits;
        if (effectiveKeyBits < 256) {
            i10 = f44522h[effectiveKeyBits];
        }
        return new zn.b(yVar, new pn.v(i10, rC2ParameterSpec.getIV()));
    }

    public String u(gm.y yVar) {
        String str = (String) f44518d.get(yVar);
        return str == null ? yVar.L() : str;
    }

    public Key v(cs.q qVar) {
        if (qVar.b() instanceof Key) {
            return (Key) qVar.b();
        }
        if (qVar.b() instanceof byte[]) {
            return new SecretKeySpec((byte[]) qVar.b(), "ENC");
        }
        throw new IllegalArgumentException("unknown generic key type");
    }

    public Key w(gm.y yVar, cs.q qVar) {
        if (qVar.b() instanceof Key) {
            return (Key) qVar.b();
        }
        if (qVar.b() instanceof byte[]) {
            return new SecretKeySpec((byte[]) qVar.b(), u(yVar));
        }
        throw new IllegalArgumentException("unknown generic key type");
    }

    public boolean x(gm.y yVar) {
        return f44517c.contains(yVar);
    }

    public void y(zn.b bVar, Key key) throws CMSException {
        int iA = f44516b.a(bVar);
        if (iA > 0) {
            byte[] encoded = null;
            try {
                encoded = key.getEncoded();
            } catch (Exception unused) {
            }
            if (encoded != null && encoded.length * 8 != iA) {
                throw new CMSException("Expected key size for algorithm OID not found in recipient.");
            }
        }
    }
}
