package mq;

import gm.y;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.KeyFactorySpi;

/* JADX INFO: loaded from: classes7.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41557a = "org.bouncycastle.jcajce.provider.asymmetric.dsa.";

    public static class a extends br.b {
        @Override // br.a
        public void a(uq.a aVar) {
            aVar.h("AlgorithmParameters.DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.AlgorithmParametersSpi");
            aVar.h("AlgorithmParameterGenerator.DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.AlgorithmParameterGeneratorSpi");
            aVar.h("KeyPairGenerator.DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.KeyPairGeneratorSpi");
            aVar.h("KeyFactory.DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.KeyFactorySpi");
            aVar.h("Signature.DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$stdDSA");
            aVar.h("Signature.NONEWITHDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$noneDSA");
            aVar.h("Alg.Alias.Signature.RAWDSA", "NONEWITHDSA");
            aVar.h("Signature.DETDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
            aVar.h("Signature.SHA1WITHDETDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
            aVar.h("Signature.SHA224WITHDETDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA224");
            aVar.h("Signature.SHA256WITHDETDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA256");
            aVar.h("Signature.SHA384WITHDETDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA384");
            aVar.h("Signature.SHA512WITHDETDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA512");
            aVar.h("Signature.DDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
            aVar.h("Signature.SHA1WITHDDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
            aVar.h("Signature.SHA224WITHDDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA224");
            aVar.h("Signature.SHA256WITHDDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA256");
            aVar.h("Signature.SHA384WITHDDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA384");
            aVar.h("Signature.SHA512WITHDDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA512");
            aVar.h("Signature.SHA3-224WITHDDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_224");
            aVar.h("Signature.SHA3-256WITHDDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_256");
            aVar.h("Signature.SHA3-384WITHDDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_384");
            aVar.h("Signature.SHA3-512WITHDDSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_512");
            d(aVar, "SHA224", "DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa224", kn.d.X);
            d(aVar, "SHA256", "DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa256", kn.d.Y);
            d(aVar, "SHA384", "DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa384", kn.d.Z);
            d(aVar, "SHA512", "DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa512", kn.d.f37589a0);
            d(aVar, "SHA3-224", "DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_224", kn.d.f37591b0);
            d(aVar, "SHA3-256", "DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_256", kn.d.f37593c0);
            d(aVar, "SHA3-384", "DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_384", kn.d.f37595d0);
            d(aVar, "SHA3-512", "DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_512", kn.d.f37597e0);
            aVar.h("Alg.Alias.Signature.SHA/DSA", "DSA");
            aVar.h("Alg.Alias.Signature.SHA1withDSA", "DSA");
            aVar.h("Alg.Alias.Signature.SHA1WITHDSA", "DSA");
            aVar.h("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.1", "DSA");
            aVar.h("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.3", "DSA");
            aVar.h("Alg.Alias.Signature.DSAwithSHA1", "DSA");
            aVar.h("Alg.Alias.Signature.DSAWITHSHA1", "DSA");
            aVar.h("Alg.Alias.Signature.SHA1WithDSA", "DSA");
            aVar.h("Alg.Alias.Signature.DSAWithSHA1", "DSA");
            c(aVar, "RIPEMD160", "DSA", "org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaRMD160");
            KeyFactorySpi keyFactorySpi = new KeyFactorySpi();
            int i10 = 0;
            while (true) {
                y[] yVarArr = org.bouncycastle.jcajce.provider.asymmetric.dsa.d.f44900a;
                if (i10 == yVarArr.length) {
                    return;
                }
                aVar.h("Alg.Alias.Signature." + yVarArr[i10], "DSA");
                e(aVar, yVarArr[i10], "DSA", keyFactorySpi);
                f(aVar, yVarArr[i10], "DSA");
                i10++;
            }
        }
    }
}
