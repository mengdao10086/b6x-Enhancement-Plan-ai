package zq;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import np.n1;
import np.v1;
import org.bouncycastle.crypto.PasswordConverter;
import org.bouncycastle.jcajce.PBKDF1Key;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.bouncycastle.jcajce.provider.symmetric.util.d;

/* JADX INFO: loaded from: classes5.dex */
public final class i {

    public static class a extends ar.a {
        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[8];
            if (this.f8855b == null) {
                this.f8855b = org.bouncycastle.crypto.n.f();
            }
            this.f8855b.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersA = a("DES");
                algorithmParametersA.init(new IvParameterSpec(bArr));
                return algorithmParametersA;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DES parameter generation.");
        }
    }

    public static class b extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public b() {
            super(new jp.c(new cp.s()), 64);
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public c() {
            super(new ip.c(new cp.s()));
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public d() {
            super(new ip.e(new cp.s()));
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public e() {
            super(new ip.c(new cp.s(), 64));
        }
    }

    public static class f extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public f() {
            super(new ip.c(new cp.s(), 64, new mp.c()));
        }
    }

    public static class g extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public g() {
            super(new ip.l(new cp.s()));
        }
    }

    public static class h extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public h() {
            super(new ip.l(new cp.s(), new mp.c()));
        }
    }

    /* JADX INFO: renamed from: zq.i$i, reason: collision with other inner class name */
    public static class C0699i extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public C0699i() {
            super(new ip.d(new cp.s()));
        }
    }

    public static class j extends ar.d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f59585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f59586d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f59587e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f59588f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f59589g;

        public j(String str, gm.y yVar, boolean z10, int i10, int i11, int i12, int i13) {
            super(str, yVar);
            this.f59585c = z10;
            this.f59586d = i10;
            this.f59587e = i11;
            this.f59588f = i12;
            this.f59589g = i13;
        }

        @Override // ar.d, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (!(keySpec instanceof PBEKeySpec)) {
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
            PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
            if (pBEKeySpec.getSalt() != null) {
                org.bouncycastle.crypto.k kVarF = this.f59585c ? d.a.f(pBEKeySpec, this.f59586d, this.f59587e, this.f59588f, this.f59589g) : d.a.d(pBEKeySpec, this.f59586d, this.f59587e, this.f59588f);
                np.k.c((kVarF instanceof v1 ? (n1) ((v1) kVarF).b() : (n1) kVarF).a());
                return new BCPBEKey(this.f8862a, this.f8863b, this.f59586d, this.f59587e, this.f59588f, this.f59589g, pBEKeySpec, kVarF);
            }
            int i10 = this.f59586d;
            if (i10 == 0 || i10 == 4) {
                return new PBKDF1Key(pBEKeySpec.getPassword(), this.f59586d == 0 ? PasswordConverter.ASCII : PasswordConverter.UTF8);
            }
            return new BCPBEKey(this.f8862a, this.f8863b, i10, this.f59587e, this.f59588f, this.f59589g, pBEKeySpec, null);
        }
    }

    public static class k extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public k() {
            super(new cp.s());
        }
    }

    public static class l extends ar.d {
        public l() {
            super("DES", null);
        }

        @Override // ar.d, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            return keySpec instanceof DESKeySpec ? new SecretKeySpec(((DESKeySpec) keySpec).getKey(), "DES") : super.engineGenerateSecret(keySpec);
        }

        @Override // ar.d, javax.crypto.SecretKeyFactorySpi
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
            if (!DESKeySpec.class.isAssignableFrom(cls)) {
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
            try {
                return new DESKeySpec(secretKey.getEncoded());
            } catch (Exception e10) {
                throw new InvalidKeySpecException(e10.toString());
            }
        }
    }

    public static class m extends ar.c {
        public m() {
            super("DES", 64, new fp.f());
        }

        @Override // ar.c, javax.crypto.KeyGeneratorSpi
        public SecretKey engineGenerateKey() {
            if (this.f8861e) {
                this.f8860d.b(new org.bouncycastle.crypto.y(org.bouncycastle.crypto.n.f(), this.f8859c));
                this.f8861e = false;
            }
            return new SecretKeySpec(this.f8860d.a(), this.f8857a);
        }

        @Override // ar.c, javax.crypto.KeyGeneratorSpi
        public void engineInit(int i10, SecureRandom secureRandom) {
            super.engineInit(i10, secureRandom);
        }
    }

    public static class n extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59590a = i.class.getName();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f59591b = "org.bouncycastle.jcajce.provider.symmetric";

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59590a;
            sb2.append(str);
            sb2.append("$ECB");
            aVar.h("Cipher.DES", sb2.toString());
            gm.y yVar = on.b.f44361e;
            aVar.k("Cipher", yVar, str + "$CBC");
            b(aVar, yVar, "DES");
            aVar.h("Cipher.DESRFC3211WRAP", str + "$RFC3211");
            aVar.h("KeyGenerator.DES", str + "$KeyGenerator");
            aVar.h("SecretKeyFactory.DES", str + "$KeyFactory");
            aVar.h("Mac.DESCMAC", str + "$CMAC");
            aVar.h("Mac.DESMAC", str + "$CBCMAC");
            aVar.h("Alg.Alias.Mac.DES", "DESMAC");
            aVar.h("Mac.DESMAC/CFB8", str + "$DESCFB8");
            aVar.h("Alg.Alias.Mac.DES/CFB8", "DESMAC/CFB8");
            aVar.h("Mac.DESMAC64", str + "$DES64");
            aVar.h("Alg.Alias.Mac.DES64", "DESMAC64");
            aVar.h("Mac.DESMAC64WITHISO7816-4PADDING", str + "$DES64with7816d4");
            aVar.h("Alg.Alias.Mac.DES64WITHISO7816-4PADDING", "DESMAC64WITHISO7816-4PADDING");
            aVar.h("Alg.Alias.Mac.DESISO9797ALG1MACWITHISO7816-4PADDING", "DESMAC64WITHISO7816-4PADDING");
            aVar.h("Alg.Alias.Mac.DESISO9797ALG1WITHISO7816-4PADDING", "DESMAC64WITHISO7816-4PADDING");
            aVar.h("Mac.DESWITHISO9797", str + "$DES9797Alg3");
            aVar.h("Alg.Alias.Mac.DESISO9797MAC", "DESWITHISO9797");
            aVar.h("Mac.ISO9797ALG3MAC", str + "$DES9797Alg3");
            aVar.h("Alg.Alias.Mac.ISO9797ALG3", "ISO9797ALG3MAC");
            aVar.h("Mac.ISO9797ALG3WITHISO7816-4PADDING", str + "$DES9797Alg3with7816d4");
            aVar.h("Alg.Alias.Mac.ISO9797ALG3MACWITHISO7816-4PADDING", "ISO9797ALG3WITHISO7816-4PADDING");
            aVar.h("AlgorithmParameters.DES", "org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters");
            aVar.k("Alg.Alias.AlgorithmParameters", yVar, "DES");
            aVar.h("AlgorithmParameterGenerator.DES", str + "$AlgParamGen");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar, "DES");
            aVar.h("Cipher.PBEWITHMD2ANDDES", str + "$PBEWithMD2");
            aVar.h("Cipher.PBEWITHMD5ANDDES", str + "$PBEWithMD5");
            aVar.h("Cipher.PBEWITHSHA1ANDDES", str + "$PBEWithSHA1");
            gm.y yVar2 = pn.s.Q3;
            aVar.k("Alg.Alias.Cipher", yVar2, "PBEWITHMD2ANDDES");
            gm.y yVar3 = pn.s.S3;
            aVar.k("Alg.Alias.Cipher", yVar3, "PBEWITHMD5ANDDES");
            gm.y yVar4 = pn.s.U3;
            aVar.k("Alg.Alias.Cipher", yVar4, "PBEWITHSHA1ANDDES");
            aVar.h("Alg.Alias.Cipher.PBEWITHMD2ANDDES-CBC", "PBEWITHMD2ANDDES");
            aVar.h("Alg.Alias.Cipher.PBEWITHMD5ANDDES-CBC", "PBEWITHMD5ANDDES");
            aVar.h("Alg.Alias.Cipher.PBEWITHSHA1ANDDES-CBC", "PBEWITHSHA1ANDDES");
            aVar.h("SecretKeyFactory.PBEWITHMD2ANDDES", str + "$PBEWithMD2KeyFactory");
            aVar.h("SecretKeyFactory.PBEWITHMD5ANDDES", str + "$PBEWithMD5KeyFactory");
            aVar.h("SecretKeyFactory.PBEWITHSHA1ANDDES", str + "$PBEWithSHA1KeyFactory");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHMD2ANDDES-CBC", "PBEWITHMD2ANDDES");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHMD5ANDDES-CBC", "PBEWITHMD5ANDDES");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHSHA1ANDDES-CBC", "PBEWITHSHA1ANDDES");
            aVar.h("Alg.Alias.SecretKeyFactory." + yVar2, "PBEWITHMD2ANDDES");
            aVar.h("Alg.Alias.SecretKeyFactory." + yVar3, "PBEWITHMD5ANDDES");
            aVar.h("Alg.Alias.SecretKeyFactory." + yVar4, "PBEWITHSHA1ANDDES");
        }

        public final void b(uq.a aVar, gm.y yVar, String str) {
            aVar.h("Alg.Alias.KeyGenerator." + yVar.L(), str);
            aVar.h("Alg.Alias.KeyFactory." + yVar.L(), str);
        }
    }

    public static class o extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public o() {
            super(new jp.c(new cp.s()), 0, 5, 64, 8);
        }
    }

    public static class p extends j {
        public p() {
            super("PBEwithMD2andDES", pn.s.Q3, true, 0, 5, 64, 64);
        }
    }

    public static class q extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public q() {
            super(new jp.c(new cp.s()), 0, 0, 64, 8);
        }
    }

    public static class r extends j {
        public r() {
            super("PBEwithMD5andDES", pn.s.S3, true, 0, 0, 64, 64);
        }
    }

    public static class s extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public s() {
            super(new jp.c(new cp.s()), 0, 1, 64, 8);
        }
    }

    public static class t extends j {
        public t() {
            super("PBEwithSHA1andDES", pn.s.U3, true, 0, 1, 64, 64);
        }
    }

    public static class u extends BaseWrapCipher {
        public u() {
            super(new cp.u0(new cp.s()), 8);
        }
    }
}
