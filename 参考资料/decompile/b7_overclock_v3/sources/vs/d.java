package vs;

import gm.y;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f53364a = "org.bouncycastle.pqc.jcajce.provider.qtesla.";

    public static class a extends br.b {
        @Override // br.a
        public void a(uq.a aVar) {
            aVar.h("KeyFactory.QTESLA", "org.bouncycastle.pqc.jcajce.provider.qtesla.QTESLAKeyFactorySpi");
            aVar.h("KeyPairGenerator.QTESLA", "org.bouncycastle.pqc.jcajce.provider.qtesla.KeyPairGeneratorSpi");
            aVar.h("Signature.QTESLA", "org.bouncycastle.pqc.jcajce.provider.qtesla.SignatureSpi$qTESLA");
            y yVar = is.g.X;
            b(aVar, "QTESLA-P-I", "org.bouncycastle.pqc.jcajce.provider.qtesla.SignatureSpi$PI", yVar);
            y yVar2 = is.g.Y;
            b(aVar, "QTESLA-P-III", "org.bouncycastle.pqc.jcajce.provider.qtesla.SignatureSpi$PIII", yVar2);
            zs.c cVar = new zs.c();
            e(aVar, yVar, "QTESLA-P-I", cVar);
            e(aVar, yVar2, "QTESLA-P-III", cVar);
        }
    }
}
