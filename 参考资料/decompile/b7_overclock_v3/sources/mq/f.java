package mq;

import gm.y;

/* JADX INFO: loaded from: classes7.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41561a = "org.bouncycastle.jcajce.provider.asymmetric.ec.";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f41562b = "org.bouncycastle.jcajce.provider.asymmetric.ecgost.";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f41563c = "org.bouncycastle.jcajce.provider.asymmetric.ecgost12.";

    public static class a extends br.b {
        @Override // br.a
        public void a(uq.a aVar) {
            aVar.h("KeyFactory.ECGOST3410", "org.bouncycastle.jcajce.provider.asymmetric.ecgost.KeyFactorySpi");
            aVar.h("Alg.Alias.KeyFactory.GOST-3410-2001", "ECGOST3410");
            aVar.h("Alg.Alias.KeyFactory.ECGOST-3410", "ECGOST3410");
            y yVar = qm.a.f47463m;
            e(aVar, yVar, "ECGOST3410", new org.bouncycastle.jcajce.provider.asymmetric.ecgost.a());
            e(aVar, qm.a.F, "ECGOST3410", new org.bouncycastle.jcajce.provider.asymmetric.ecgost.a());
            g(aVar, yVar, "ECGOST3410");
            aVar.h("KeyPairGenerator.ECGOST3410", "org.bouncycastle.jcajce.provider.asymmetric.ecgost.KeyPairGeneratorSpi");
            aVar.h("Alg.Alias.KeyPairGenerator.ECGOST-3410", "ECGOST3410");
            aVar.h("Alg.Alias.KeyPairGenerator.GOST-3410-2001", "ECGOST3410");
            aVar.h("Signature.ECGOST3410", "org.bouncycastle.jcajce.provider.asymmetric.ecgost.SignatureSpi");
            aVar.h("Alg.Alias.Signature.ECGOST-3410", "ECGOST3410");
            aVar.h("Alg.Alias.Signature.GOST-3410-2001", "ECGOST3410");
            aVar.h("KeyAgreement.ECGOST3410", "org.bouncycastle.jcajce.provider.asymmetric.ecgost.KeyAgreementSpi$ECVKO");
            aVar.h("Alg.Alias.KeyAgreement." + yVar, "ECGOST3410");
            aVar.h("Alg.Alias.KeyAgreement.GOST-3410-2001", "ECGOST3410");
            aVar.h("Alg.Alias.KeyAgreement." + qm.a.E, "ECGOST3410");
            aVar.h("AlgorithmParameters.ECGOST3410", "org.bouncycastle.jcajce.provider.asymmetric.ec.AlgorithmParametersSpi");
            aVar.h("AlgorithmParameters.ECGOST3410-2012", "org.bouncycastle.jcajce.provider.asymmetric.ec.AlgorithmParametersSpi");
            aVar.h("Alg.Alias.AlgorithmParameters.GOST-3410-2001", "ECGOST3410");
            d(aVar, "GOST3411", "ECGOST3410", "org.bouncycastle.jcajce.provider.asymmetric.ecgost.SignatureSpi", qm.a.f47465o);
            aVar.h("KeyFactory.ECGOST3410-2012", "org.bouncycastle.jcajce.provider.asymmetric.ecgost12.KeyFactorySpi");
            aVar.h("Alg.Alias.KeyFactory.GOST-3410-2012", "ECGOST3410-2012");
            aVar.h("Alg.Alias.KeyFactory.ECGOST-3410-2012", "ECGOST3410-2012");
            y yVar2 = qn.a.f47517g;
            e(aVar, yVar2, "ECGOST3410-2012", new org.bouncycastle.jcajce.provider.asymmetric.ecgost12.c());
            y yVar3 = qn.a.f47522l;
            e(aVar, yVar3, "ECGOST3410-2012", new org.bouncycastle.jcajce.provider.asymmetric.ecgost12.c());
            g(aVar, yVar2, "ECGOST3410-2012");
            y yVar4 = qn.a.f47518h;
            e(aVar, yVar4, "ECGOST3410-2012", new org.bouncycastle.jcajce.provider.asymmetric.ecgost12.c());
            y yVar5 = qn.a.f47523m;
            e(aVar, yVar5, "ECGOST3410-2012", new org.bouncycastle.jcajce.provider.asymmetric.ecgost12.c());
            g(aVar, yVar4, "ECGOST3410-2012");
            aVar.h("KeyPairGenerator.ECGOST3410-2012", "org.bouncycastle.jcajce.provider.asymmetric.ecgost12.KeyPairGeneratorSpi");
            aVar.h("Alg.Alias.KeyPairGenerator.ECGOST3410-2012", "ECGOST3410-2012");
            aVar.h("Alg.Alias.KeyPairGenerator.GOST-3410-2012", "ECGOST3410-2012");
            aVar.h("Signature.ECGOST3410-2012-256", "org.bouncycastle.jcajce.provider.asymmetric.ecgost12.ECGOST2012SignatureSpi256");
            aVar.h("Alg.Alias.Signature.ECGOST3410-2012-256", "ECGOST3410-2012-256");
            aVar.h("Alg.Alias.Signature.GOST-3410-2012-256", "ECGOST3410-2012-256");
            aVar.h("Alg.Alias.Signature.GOST3411WITHECGOST3410-2012-256", "ECGOST3410-2012-256");
            d(aVar, "GOST3411-2012-256", "ECGOST3410-2012-256", "org.bouncycastle.jcajce.provider.asymmetric.ecgost12.ECGOST2012SignatureSpi256", qn.a.f47519i);
            aVar.h("Signature.ECGOST3410-2012-512", "org.bouncycastle.jcajce.provider.asymmetric.ecgost12.ECGOST2012SignatureSpi512");
            aVar.h("Alg.Alias.Signature.ECGOST3410-2012-512", "ECGOST3410-2012-512");
            aVar.h("Alg.Alias.Signature.GOST-3410-2012-512", "ECGOST3410-2012-512");
            aVar.h("Alg.Alias.Signature.GOST3411WITHECGOST3410-2012-512", "ECGOST3410-2012-512");
            d(aVar, "GOST3411-2012-512", "ECGOST3410-2012-512", "org.bouncycastle.jcajce.provider.asymmetric.ecgost12.ECGOST2012SignatureSpi512", qn.a.f47520j);
            aVar.h("KeyAgreement.ECGOST3410-2012-256", "org.bouncycastle.jcajce.provider.asymmetric.ecgost12.KeyAgreementSpi$ECVKO256");
            aVar.h("KeyAgreement.ECGOST3410-2012-512", "org.bouncycastle.jcajce.provider.asymmetric.ecgost12.KeyAgreementSpi$ECVKO512");
            aVar.h("Alg.Alias.KeyAgreement." + yVar3, "ECGOST3410-2012-256");
            aVar.h("Alg.Alias.KeyAgreement." + yVar5, "ECGOST3410-2012-512");
            aVar.h("Alg.Alias.KeyAgreement." + yVar2, "ECGOST3410-2012-256");
            aVar.h("Alg.Alias.KeyAgreement." + yVar4, "ECGOST3410-2012-512");
        }
    }
}
