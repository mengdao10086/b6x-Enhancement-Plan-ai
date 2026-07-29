package wq;

import org.bouncycastle.util.p;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f54794a = "org.bouncycastle.jcajce.provider.keystore.bc.";

    /* JADX INFO: renamed from: wq.a$a, reason: collision with other inner class name */
    public static class C0641a extends br.b {
        @Override // br.a
        public void a(uq.a aVar) {
            aVar.h("KeyStore.BKS", "org.bouncycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi$Std");
            if (p.d("org.bouncycastle.bks.enable_v1")) {
                aVar.h("KeyStore.BKS-V1", "org.bouncycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi$Version1");
            }
            aVar.h("KeyStore.BouncyCastle", "org.bouncycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi$BouncyCastleStore");
            aVar.h("Alg.Alias.KeyStore.UBER", "BouncyCastle");
            aVar.h("Alg.Alias.KeyStore.BOUNCYCASTLE", "BouncyCastle");
            aVar.h("Alg.Alias.KeyStore.bouncycastle", "BouncyCastle");
        }
    }
}
