package mq;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41567a = "org.bouncycastle.jcajce.provider.asymmetric.ec.";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f41568b;

    public static class a extends br.b {
        @Override // br.a
        public void a(uq.a aVar) {
            aVar.h("Signature.SHA256WITHSM2", "org.bouncycastle.jcajce.provider.asymmetric.ec.GMSignatureSpi$sha256WithSM2");
            aVar.h("Alg.Alias.Signature." + xm.b.f55624f0, "SHA256WITHSM2");
            aVar.h("Signature.SM3WITHSM2", "org.bouncycastle.jcajce.provider.asymmetric.ec.GMSignatureSpi$sm3WithSM2");
            aVar.h("Alg.Alias.Signature." + xm.b.f55620d0, "SM3WITHSM2");
            aVar.h("Cipher.SM2", "org.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2");
            aVar.h("Alg.Alias.Cipher.SM2WITHSM3", "SM2");
            aVar.h("Alg.Alias.Cipher." + xm.b.M, "SM2");
            aVar.h("Cipher.SM2WITHBLAKE2B", "org.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withBlake2b");
            aVar.h("Alg.Alias.Cipher." + xm.b.U, "SM2WITHBLAKE2B");
            aVar.h("Cipher.SM2WITHBLAKE2S", "org.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withBlake2s");
            aVar.h("Alg.Alias.Cipher." + xm.b.V, "SM2WITHBLAKE2S");
            aVar.h("Cipher.SM2WITHWHIRLPOOL", "org.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withWhirlpool");
            aVar.h("Alg.Alias.Cipher." + xm.b.T, "SM2WITHWHIRLPOOL");
            aVar.h("Cipher.SM2WITHMD5", "org.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withMD5");
            aVar.h("Alg.Alias.Cipher." + xm.b.W, "SM2WITHMD5");
            aVar.h("Cipher.SM2WITHRIPEMD160", "org.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withRMD");
            aVar.h("Alg.Alias.Cipher." + xm.b.S, "SM2WITHRIPEMD160");
            aVar.h("Cipher.SM2WITHSHA1", "org.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withSha1");
            aVar.h("Alg.Alias.Cipher." + xm.b.N, "SM2WITHSHA1");
            aVar.h("Cipher.SM2WITHSHA224", "org.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withSha224");
            aVar.h("Alg.Alias.Cipher." + xm.b.O, "SM2WITHSHA224");
            aVar.h("Cipher.SM2WITHSHA256", "org.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withSha256");
            aVar.h("Alg.Alias.Cipher." + xm.b.P, "SM2WITHSHA256");
            aVar.h("Cipher.SM2WITHSHA384", "org.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withSha384");
            aVar.h("Alg.Alias.Cipher." + xm.b.Q, "SM2WITHSHA384");
            aVar.h("Cipher.SM2WITHSHA512", "org.bouncycastle.jcajce.provider.asymmetric.ec.GMCipherSpi$SM2withSha512");
            aVar.h("Alg.Alias.Cipher." + xm.b.R, "SM2WITHSHA512");
        }
    }

    static {
        HashMap map = new HashMap();
        f41568b = map;
        map.put("SupportedKeyClasses", "java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey");
        map.put("SupportedKeyFormats", "PKCS#8|X.509");
    }
}
