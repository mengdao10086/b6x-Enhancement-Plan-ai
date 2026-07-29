package zq;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import zq.i;

/* JADX INFO: loaded from: classes5.dex */
public final class j {

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
            super(new jp.c(new cp.t()), 64);
        }
    }

    public static class c extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public c() {
            super(new ip.c(new cp.t()));
        }
    }

    public static class d extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public d() {
            super(new ip.e(new cp.t()));
        }
    }

    public static class e extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public e() {
            super(new ip.c(new cp.t(), 64));
        }
    }

    public static class f extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public f() {
            super(new ip.c(new cp.t(), 64, new mp.c()));
        }
    }

    public static class g extends org.bouncycastle.jcajce.provider.symmetric.util.b {
        public g() {
            super(new ip.d(new cp.t()));
        }
    }

    public static class h extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public h() {
            super(new cp.t());
        }
    }

    public static class i extends ar.d {
        public i() {
            super("DESede", null);
        }

        @Override // ar.d, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            return keySpec instanceof DESedeKeySpec ? new SecretKeySpec(((DESedeKeySpec) keySpec).getKey(), "DESede") : super.engineGenerateSecret(keySpec);
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
            if (!DESedeKeySpec.class.isAssignableFrom(cls)) {
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
            byte[] encoded = secretKey.getEncoded();
            try {
                if (encoded.length != 16) {
                    return new DESedeKeySpec(encoded);
                }
                byte[] bArr = new byte[24];
                System.arraycopy(encoded, 0, bArr, 0, 16);
                System.arraycopy(encoded, 0, bArr, 16, 8);
                return new DESedeKeySpec(bArr);
            } catch (Exception e10) {
                throw new InvalidKeySpecException(e10.toString());
            }
        }
    }

    /* JADX INFO: renamed from: zq.j$j, reason: collision with other inner class name */
    public static class C0700j extends ar.c {
        public C0700j() {
            super("DESede3", 192, new fp.g());
        }
    }

    public static class k extends ar.c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f59593f;

        public k() {
            super("DESede", 192, new fp.g());
            this.f59593f = false;
        }

        @Override // ar.c, javax.crypto.KeyGeneratorSpi
        public SecretKey engineGenerateKey() {
            if (this.f8861e) {
                this.f8860d.b(new org.bouncycastle.crypto.y(org.bouncycastle.crypto.n.f(), this.f8859c));
                this.f8861e = false;
            }
            if (this.f59593f) {
                return new SecretKeySpec(this.f8860d.a(), this.f8857a);
            }
            byte[] bArrA = this.f8860d.a();
            System.arraycopy(bArrA, 0, bArrA, 16, 8);
            return new SecretKeySpec(bArrA, this.f8857a);
        }

        @Override // ar.c, javax.crypto.KeyGeneratorSpi
        public void engineInit(int i10, SecureRandom secureRandom) {
            super.engineInit(i10, secureRandom);
            this.f59593f = true;
        }
    }

    public static class l extends br.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f59594a = j.class.getName();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f59595b = "org.bouncycastle.jcajce.provider.symmetric";

        @Override // br.a
        public void a(uq.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            String str = f59594a;
            sb2.append(str);
            sb2.append("$ECB");
            aVar.h("Cipher.DESEDE", sb2.toString());
            gm.y yVar = pn.s.Z3;
            aVar.k("Cipher", yVar, str + "$CBC");
            aVar.h("Cipher.DESEDEWRAP", str + "$Wrap");
            aVar.k("Cipher", pn.s.f46835p6, str + "$Wrap");
            aVar.h("Cipher.DESEDERFC3211WRAP", str + "$RFC3211");
            aVar.h("Alg.Alias.Cipher.DESEDERFC3217WRAP", "DESEDEWRAP");
            aVar.h("Alg.Alias.Cipher.TDEA", "DESEDE");
            aVar.h("Alg.Alias.Cipher.TDEAWRAP", "DESEDEWRAP");
            aVar.h("Alg.Alias.KeyGenerator.TDEA", "DESEDE");
            aVar.h("Alg.Alias.AlgorithmParameters.TDEA", "DESEDE");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator.TDEA", "DESEDE");
            aVar.h("Alg.Alias.SecretKeyFactory.TDEA", "DESEDE");
            if (aVar.c("MessageDigest", et.e.f27137f)) {
                aVar.h("Cipher.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", str + "$PBEWithSHAAndDES3Key");
                aVar.h("Cipher.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", str + "$PBEWithSHAAndDES2Key");
                aVar.k("Alg.Alias.Cipher", pn.s.f46820k6, "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                aVar.k("Alg.Alias.Cipher", pn.s.f46823l6, "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
                aVar.h("Alg.Alias.Cipher.PBEWITHSHA1ANDDESEDE", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                aVar.h("Alg.Alias.Cipher.PBEWITHSHA1AND3-KEYTRIPLEDES-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                aVar.h("Alg.Alias.Cipher.PBEWITHSHA1AND2-KEYTRIPLEDES-CBC", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
                aVar.h("Alg.Alias.Cipher.PBEWITHSHAAND3-KEYDESEDE-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                aVar.h("Alg.Alias.Cipher.PBEWITHSHAAND2-KEYDESEDE-CBC", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
                aVar.h("Alg.Alias.Cipher.PBEWITHSHA1AND3-KEYDESEDE-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
                aVar.h("Alg.Alias.Cipher.PBEWITHSHA1AND2-KEYDESEDE-CBC", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
                aVar.h("Alg.Alias.Cipher.PBEWITHSHA1ANDDESEDE-CBC", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
            }
            aVar.h("KeyGenerator.DESEDE", str + "$KeyGenerator");
            aVar.h("KeyGenerator." + yVar, str + "$KeyGenerator3");
            aVar.h("KeyGenerator.DESEDEWRAP", str + "$KeyGenerator");
            aVar.h("SecretKeyFactory.DESEDE", str + "$KeyFactory");
            aVar.k("SecretKeyFactory", on.b.f44364h, str + "$KeyFactory");
            aVar.h("Mac.DESEDECMAC", str + "$CMAC");
            aVar.h("Mac.DESEDEMAC", str + "$CBCMAC");
            aVar.h("Alg.Alias.Mac.DESEDE", "DESEDEMAC");
            aVar.h("Mac.DESEDEMAC/CFB8", str + "$DESedeCFB8");
            aVar.h("Alg.Alias.Mac.DESEDE/CFB8", "DESEDEMAC/CFB8");
            aVar.h("Mac.DESEDEMAC64", str + "$DESede64");
            aVar.h("Alg.Alias.Mac.DESEDE64", "DESEDEMAC64");
            aVar.h("Mac.DESEDEMAC64WITHISO7816-4PADDING", str + "$DESede64with7816d4");
            aVar.h("Alg.Alias.Mac.DESEDE64WITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
            aVar.h("Alg.Alias.Mac.DESEDEISO9797ALG1MACWITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
            aVar.h("Alg.Alias.Mac.DESEDEISO9797ALG1WITHISO7816-4PADDING", "DESEDEMAC64WITHISO7816-4PADDING");
            aVar.h("AlgorithmParameters.DESEDE", "org.bouncycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters");
            aVar.h("Alg.Alias.AlgorithmParameters." + yVar, "DESEDE");
            aVar.h("AlgorithmParameterGenerator.DESEDE", str + "$AlgParamGen");
            aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar, "DESEDE");
            aVar.h("SecretKeyFactory.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", str + "$PBEWithSHAAndDES3KeyFactory");
            aVar.h("SecretKeyFactory.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", str + "$PBEWithSHAAndDES2KeyFactory");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWITHSHA1ANDDESEDE", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND3-KEYTRIPLEDES", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND2-KEYTRIPLEDES", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND3-KEYTRIPLEDES-CBC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAAND2-KEYTRIPLEDES-CBC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDDES3KEY-CBC", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.PBEWITHSHAANDDES2KEY-CBC", "PKCS12PBE");
            aVar.h("Alg.Alias.SecretKeyFactory.PBE", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
            aVar.h("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.3", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
            aVar.h("Alg.Alias.SecretKeyFactory.1.2.840.113549.1.12.1.4", "PBEWITHSHAAND2-KEYTRIPLEDES-CBC");
            aVar.h("Alg.Alias.SecretKeyFactory.PBEWithSHAAnd3KeyTripleDES", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
            aVar.h("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.3", "PKCS12PBE");
            aVar.h("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.12.1.4", "PKCS12PBE");
            aVar.h("Alg.Alias.Cipher.PBEWithSHAAnd3KeyTripleDES", "PBEWITHSHAAND3-KEYTRIPLEDES-CBC");
        }
    }

    public static class m extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public m() {
            super(new jp.c(new cp.t()), 2, 1, 128, 8);
        }
    }

    public static class n extends i.j {
        public n() {
            super("PBEwithSHAandDES2Key-CBC", pn.s.f46823l6, true, 2, 1, 128, 64);
        }
    }

    public static class o extends org.bouncycastle.jcajce.provider.symmetric.util.a {
        public o() {
            super(new jp.c(new cp.t()), 2, 1, 192, 8);
        }
    }

    public static class p extends i.j {
        public p() {
            super("PBEwithSHAandDES3Key-CBC", pn.s.f46820k6, true, 2, 1, 192, 64);
        }
    }

    public static class q extends BaseWrapCipher {
        public q() {
            super(new cp.u0(new cp.t()), 8);
        }
    }

    public static class r extends BaseWrapCipher {
        public r() {
            super(new cp.u());
        }
    }
}
