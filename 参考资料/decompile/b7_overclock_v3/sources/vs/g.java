package vs;

import gm.y;

/* JADX INFO: loaded from: classes6.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f53367a = "org.bouncycastle.pqc.jcajce.provider.xmss.";

    public static class a extends br.b {
        @Override // br.a
        public void a(uq.a aVar) {
            aVar.h("KeyFactory.XMSS", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSKeyFactorySpi");
            aVar.h("KeyPairGenerator.XMSS", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSKeyPairGeneratorSpi");
            aVar.h("Signature.XMSS", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSSignatureSpi$generic");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Alg.Alias.Signature.");
            y yVar = bn.a.f9499a;
            sb2.append(yVar);
            aVar.h(sb2.toString(), "XMSS");
            aVar.h("Alg.Alias.Signature.OID." + yVar, "XMSS");
            b(aVar, "XMSS-SHA256", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSSignatureSpi$withSha256", im.a.B);
            b(aVar, "XMSS-SHAKE128", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSSignatureSpi$withShake128", im.a.D);
            b(aVar, "XMSS-SHA512", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSSignatureSpi$withSha512", im.a.C);
            b(aVar, "XMSS-SHAKE256", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSSignatureSpi$withShake256", im.a.E);
            d(aVar, "SHA256", "XMSS-SHA256", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSSignatureSpi$withSha256andPrehash", im.a.f32502x);
            d(aVar, "SHAKE128", "XMSS-SHAKE128", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSSignatureSpi$withShake128andPrehash", im.a.f32504z);
            d(aVar, "SHA512", "XMSS-SHA512", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSSignatureSpi$withSha512andPrehash", im.a.f32503y);
            d(aVar, "SHAKE256", "XMSS-SHAKE256", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSSignatureSpi$withShake256andPrehash", im.a.A);
            aVar.h("Alg.Alias.Signature.SHA256WITHXMSS", "SHA256WITHXMSS-SHA256");
            aVar.h("Alg.Alias.Signature.SHAKE128WITHXMSS", "SHAKE128WITHXMSS-SHAKE128");
            aVar.h("Alg.Alias.Signature.SHA512WITHXMSS", "SHA512WITHXMSS-SHA512");
            aVar.h("Alg.Alias.Signature.SHAKE256WITHXMSS", "SHAKE256WITHXMSS-SHAKE256");
            aVar.h("KeyFactory.XMSSMT", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSMTKeyFactorySpi");
            aVar.h("KeyPairGenerator.XMSSMT", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSMTKeyPairGeneratorSpi");
            aVar.h("Signature.XMSSMT", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSMTSignatureSpi$generic");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Alg.Alias.Signature.");
            y yVar2 = bn.a.f9500b;
            sb3.append(yVar2);
            aVar.h(sb3.toString(), "XMSSMT");
            aVar.h("Alg.Alias.Signature.OID." + yVar2, "XMSSMT");
            b(aVar, "XMSSMT-SHA256", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSMTSignatureSpi$withSha256", im.a.K);
            b(aVar, "XMSSMT-SHAKE128", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSMTSignatureSpi$withShake128", im.a.M);
            b(aVar, "XMSSMT-SHA512", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSMTSignatureSpi$withSha512", im.a.L);
            b(aVar, "XMSSMT-SHAKE256", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSMTSignatureSpi$withShake256", im.a.N);
            d(aVar, "SHA256", "XMSSMT-SHA256", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSMTSignatureSpi$withSha256andPrehash", im.a.G);
            d(aVar, "SHAKE128", "XMSSMT-SHAKE128", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSMTSignatureSpi$withShake128andPrehash", im.a.I);
            d(aVar, "SHA512", "XMSSMT-SHA512", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSMTSignatureSpi$withSha512andPrehash", im.a.H);
            d(aVar, "SHAKE256", "XMSSMT-SHAKE256", "org.bouncycastle.pqc.jcajce.provider.xmss.XMSSMTSignatureSpi$withShake256andPrehash", im.a.J);
            aVar.h("Alg.Alias.Signature.SHA256WITHXMSSMT", "SHA256WITHXMSSMT-SHA256");
            aVar.h("Alg.Alias.Signature.SHAKE128WITHXMSSMT", "SHAKE128WITHXMSSMT-SHAKE128");
            aVar.h("Alg.Alias.Signature.SHA512WITHXMSSMT", "SHA512WITHXMSSMT-SHA512");
            aVar.h("Alg.Alias.Signature.SHAKE256WITHXMSSMT", "SHAKE256WITHXMSSMT-SHAKE256");
            e(aVar, is.g.f35796w, "XMSS", new dt.b());
            e(aVar, yVar, "XMSS", new dt.b());
            e(aVar, is.g.F, "XMSSMT", new dt.d());
            e(aVar, yVar2, "XMSSMT", new dt.d());
        }
    }
}
