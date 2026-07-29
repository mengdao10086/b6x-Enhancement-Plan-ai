package vs;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f53365a = "org.bouncycastle.pqc.jcajce.provider.rainbow.";

    public static class a extends br.b {
        @Override // br.a
        public void a(uq.a aVar) {
            aVar.h("KeyFactory.Rainbow", "org.bouncycastle.pqc.jcajce.provider.rainbow.RainbowKeyFactorySpi");
            aVar.h("KeyPairGenerator.Rainbow", "org.bouncycastle.pqc.jcajce.provider.rainbow.RainbowKeyPairGeneratorSpi");
            d(aVar, "SHA224", "Rainbow", "org.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi$withSha224", is.g.f35776c);
            d(aVar, "SHA256", "Rainbow", "org.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi$withSha256", is.g.f35777d);
            d(aVar, "SHA384", "Rainbow", "org.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi$withSha384", is.g.f35778e);
            d(aVar, "SHA512", "Rainbow", "org.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi$withSha512", is.g.f35779f);
            e(aVar, is.g.f35774a, "Rainbow", new at.a());
        }
    }
}
