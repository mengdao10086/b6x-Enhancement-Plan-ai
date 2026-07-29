package vs;

import gm.y;
import pn.s;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f53361a = "org.bouncycastle.pqc.jcajce.provider.lms.";

    /* JADX INFO: renamed from: vs.a$a, reason: collision with other inner class name */
    public static class C0628a extends br.b {
        @Override // br.a
        public void a(uq.a aVar) {
            aVar.h("KeyFactory.LMS", "org.bouncycastle.pqc.jcajce.provider.lms.LMSKeyFactorySpi");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Alg.Alias.KeyFactory.");
            y yVar = s.f46801e5;
            sb2.append(yVar);
            aVar.h(sb2.toString(), "LMS");
            aVar.h("KeyPairGenerator.LMS", "org.bouncycastle.pqc.jcajce.provider.lms.LMSKeyPairGeneratorSpi");
            aVar.h("Alg.Alias.KeyPairGenerator." + yVar, "LMS");
            aVar.h("Signature.LMS", "org.bouncycastle.pqc.jcajce.provider.lms.LMSSignatureSpi$generic");
            aVar.h("Alg.Alias.Signature." + yVar, "LMS");
        }
    }
}
