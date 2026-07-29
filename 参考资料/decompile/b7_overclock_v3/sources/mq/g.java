package mq;

import gm.y;
import java.util.HashMap;
import java.util.Map;
import pq.b;

/* JADX INFO: loaded from: classes7.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41564a = "org.bouncycastle.jcajce.provider.asymmetric.edec.";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f41565b;

    public static class a extends br.b {
        @Override // br.a
        public void a(uq.a aVar) {
            aVar.h("KeyFactory.XDH", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$XDH");
            aVar.h("KeyFactory.X448", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$X448");
            aVar.h("KeyFactory.X25519", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$X25519");
            aVar.h("KeyFactory.EDDSA", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$EdDSA");
            aVar.h("KeyFactory.ED448", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$Ed448");
            aVar.h("KeyFactory.ED25519", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyFactorySpi$Ed25519");
            aVar.h("Signature.EDDSA", "org.bouncycastle.jcajce.provider.asymmetric.edec.SignatureSpi$EdDSA");
            aVar.h("Signature.ED448", "org.bouncycastle.jcajce.provider.asymmetric.edec.SignatureSpi$Ed448");
            aVar.h("Signature.ED25519", "org.bouncycastle.jcajce.provider.asymmetric.edec.SignatureSpi$Ed25519");
            y yVar = tm.a.f51341e;
            aVar.k("Alg.Alias.Signature", yVar, "ED448");
            y yVar2 = tm.a.f51340d;
            aVar.k("Alg.Alias.Signature", yVar2, "ED25519");
            aVar.h("KeyPairGenerator.EDDSA", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$EdDSA");
            aVar.h("KeyPairGenerator.ED448", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$Ed448");
            aVar.h("KeyPairGenerator.ED25519", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$Ed25519");
            aVar.k("KeyPairGenerator", yVar, "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$Ed448");
            aVar.k("KeyPairGenerator", yVar2, "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$Ed25519");
            aVar.h("KeyAgreement.XDH", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$XDH");
            aVar.h("KeyAgreement.X448", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448");
            aVar.h("KeyAgreement.X25519", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519");
            y yVar3 = tm.a.f51339c;
            aVar.k("KeyAgreement", yVar3, "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448");
            y yVar4 = tm.a.f51338b;
            aVar.k("KeyAgreement", yVar4, "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519");
            aVar.h("KeyAgreement.X25519WITHSHA256CKDF", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519withSHA256CKDF");
            aVar.h("KeyAgreement.X25519WITHSHA384CKDF", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519withSHA384CKDF");
            aVar.h("KeyAgreement.X25519WITHSHA512CKDF", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519withSHA512CKDF");
            aVar.h("KeyAgreement.X448WITHSHA256CKDF", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448withSHA256CKDF");
            aVar.h("KeyAgreement.X448WITHSHA384CKDF", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448withSHA384CKDF");
            aVar.h("KeyAgreement.X448WITHSHA512CKDF", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448withSHA512CKDF");
            aVar.h("KeyAgreement.X25519WITHSHA256KDF", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519withSHA256KDF");
            aVar.h("KeyAgreement.X448WITHSHA512KDF", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448withSHA512KDF");
            aVar.h("KeyAgreement.X25519UWITHSHA256KDF", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519UwithSHA256KDF");
            aVar.h("KeyAgreement.X448UWITHSHA512KDF", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448UwithSHA512KDF");
            aVar.h("KeyPairGenerator.XDH", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$XDH");
            aVar.h("KeyPairGenerator.X448", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$X448");
            aVar.h("KeyPairGenerator.X25519", "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$X25519");
            aVar.k("KeyPairGenerator", yVar3, "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$X448");
            aVar.k("KeyPairGenerator", yVar4, "org.bouncycastle.jcajce.provider.asymmetric.edec.KeyPairGeneratorSpi$X25519");
            e(aVar, yVar3, "XDH", new b.e());
            e(aVar, yVar4, "XDH", new b.d());
            e(aVar, yVar, "EDDSA", new b.C0535b());
            e(aVar, yVar2, "EDDSA", new b.a());
        }
    }

    static {
        HashMap map = new HashMap();
        f41565b = map;
        map.put("SupportedKeyClasses", "java.security.interfaces.ECPublicKey|java.security.interfaces.ECPrivateKey");
        map.put("SupportedKeyFormats", "PKCS#8|X.509");
    }
}
