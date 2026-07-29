package mq;

import gm.y;

/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41558a = "org.bouncycastle.jcajce.provider.asymmetric.dstu.";

    public static class a extends br.b {
        @Override // br.a
        public void a(uq.a aVar) {
            aVar.h("KeyFactory.DSTU4145", "org.bouncycastle.jcajce.provider.asymmetric.dstu.KeyFactorySpi");
            aVar.h("Alg.Alias.KeyFactory.DSTU-4145-2002", "DSTU4145");
            aVar.h("Alg.Alias.KeyFactory.DSTU4145-3410", "DSTU4145");
            y yVar = vn.g.f53268b;
            e(aVar, yVar, "DSTU4145", new oq.a());
            g(aVar, yVar, "DSTU4145");
            y yVar2 = vn.g.f53269c;
            e(aVar, yVar2, "DSTU4145", new oq.a());
            g(aVar, yVar2, "DSTU4145");
            aVar.h("KeyPairGenerator.DSTU4145", "org.bouncycastle.jcajce.provider.asymmetric.dstu.KeyPairGeneratorSpi");
            aVar.h("Alg.Alias.KeyPairGenerator.DSTU-4145", "DSTU4145");
            aVar.h("Alg.Alias.KeyPairGenerator.DSTU-4145-2002", "DSTU4145");
            aVar.h("Signature.DSTU4145", "org.bouncycastle.jcajce.provider.asymmetric.dstu.SignatureSpi");
            aVar.h("Alg.Alias.Signature.DSTU-4145", "DSTU4145");
            aVar.h("Alg.Alias.Signature.DSTU-4145-2002", "DSTU4145");
            d(aVar, "GOST3411", "DSTU4145LE", "org.bouncycastle.jcajce.provider.asymmetric.dstu.SignatureSpiLe", yVar);
            d(aVar, "GOST3411", "DSTU4145", "org.bouncycastle.jcajce.provider.asymmetric.dstu.SignatureSpi", yVar2);
        }
    }
}
