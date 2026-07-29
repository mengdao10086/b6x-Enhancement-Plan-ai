package vs;

import gm.y;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f53366a = "org.bouncycastle.pqc.jcajce.provider.sphincs.";

    public static class a extends br.b {
        @Override // br.a
        public void a(uq.a aVar) {
            aVar.h("KeyFactory.SPHINCS256", "org.bouncycastle.pqc.jcajce.provider.sphincs.Sphincs256KeyFactorySpi");
            aVar.h("KeyPairGenerator.SPHINCS256", "org.bouncycastle.pqc.jcajce.provider.sphincs.Sphincs256KeyPairGeneratorSpi");
            d(aVar, "SHA512", "SPHINCS256", "org.bouncycastle.pqc.jcajce.provider.sphincs.SignatureSpi$withSha512", is.g.f35793t);
            d(aVar, "SHA3-512", "SPHINCS256", "org.bouncycastle.pqc.jcajce.provider.sphincs.SignatureSpi$withSha3_512", is.g.f35794u);
            bt.b bVar = new bt.b();
            y yVar = is.g.f35791r;
            e(aVar, yVar, "SPHINCS256", bVar);
            g(aVar, yVar, "SPHINCS256");
        }
    }
}
